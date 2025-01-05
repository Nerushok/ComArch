package lib.nerush.components.ui.details.review

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import lib.nerush.components.base.StateComponent
import lib.nerush.components.base.StateDelegate
import lib.nerush.components.data.Book
import lib.nerush.components.data.ReviewRepository
import lib.nerush.components.library.Component

interface IReviewsComponent : Component, StateDelegate<ReviewsState>

@AssistedFactory
interface ReviewsComponentFactory {
    fun create(book: Book): ReviewsComponent
}

class ReviewsComponent @AssistedInject constructor(
    @Assisted book: Book,
    private val reviewRepository: ReviewRepository,
) : IReviewsComponent, StateComponent<ReviewsState>(ReviewsState()) {

    init {
        updateState { copy(isLoading = true) }
        coroutineScope.launch {
            reviewRepository.getReviews(book.id).fold(
                onSuccess = { updateState { copy(isLoading = false, reviews = it.take(10)) } },
                onFailure = { updateState { copy(isLoading = false, isError = true) } },
            )
        }
    }
}