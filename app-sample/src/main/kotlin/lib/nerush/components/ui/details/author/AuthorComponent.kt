package lib.nerush.components.ui.details.author

import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.launch
import lib.nerush.components.base.StateComponent
import lib.nerush.components.base.StateDelegate
import lib.nerush.components.data.AuthorRepository
import lib.nerush.components.data.Book
import lib.nerush.components.library.Component

interface IAuthorComponent : Component, StateDelegate<AuthorState>

@AssistedFactory
interface AuthorComponentFactory {
    fun create(book: Book): AuthorComponent
}

class AuthorComponent @AssistedInject constructor(
    @Assisted private val book: Book,
    private val authorRepository: AuthorRepository,
) : IAuthorComponent, StateComponent<AuthorState>(AuthorState()) {

    init {
        updateState { copy(isLoading = true) }
        coroutineScope.launch {
            authorRepository.getAuthor(book.id).fold(
                onSuccess = { updateState { copy(isLoading = false, author = it) } },
                onFailure = { updateState { copy(isLoading = false, isError = true) } },
            )
        }
    }
}