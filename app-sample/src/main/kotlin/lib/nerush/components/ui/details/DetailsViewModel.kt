package lib.nerush.components.ui.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import lib.nerush.components.base.BaseViewModel
import lib.nerush.components.data.Book
import lib.nerush.components.data.BookRepository
import lib.nerush.components.ui.details.author.AuthorComponent
import lib.nerush.components.ui.details.author.AuthorComponentFactory
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val bookRepository: BookRepository,
    private val authorComponentFactory: AuthorComponentFactory,
) : BaseViewModel() {

    private val _state = MutableStateFlow(DetailsState(savedStateHandle["id"]!!))
    val state = _state.asStateFlow()

    init {
        loadBook()
    }

    private fun loadBook() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            bookRepository.getBook(state.value.bookId).fold(
                onSuccess = { book ->
                    val authorComponent = createAuthorComponent(book)
                    _state.update {
                        it.copy(
                            isLoading = false,
                            book = book,
                            authorComponent = authorComponent
                        )
                    }
                },
                onFailure = { _state.update { it.copy(isError = true) } }
            )
        }
    }

    private fun createAuthorComponent(book: Book): AuthorComponent {
        return authorComponentFactory.create(storeOwner = this, book = book)
    }
}