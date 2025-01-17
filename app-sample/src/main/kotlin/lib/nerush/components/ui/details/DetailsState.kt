package lib.nerush.components.ui.details

import androidx.compose.runtime.Immutable
import lib.nerush.components.data.Book
import lib.nerush.components.ui.details.author.IAuthorComponent
import lib.nerush.components.ui.details.review.IReviewsComponent

@Immutable
data class DetailsState(
    val bookId: String,
    val isError: Boolean = false,
    val isLoading: Boolean = false,
    val book: Book? = null,
    val authorComponent: IAuthorComponent? = null,
    val reviewsComponent: IReviewsComponent? = null,
)