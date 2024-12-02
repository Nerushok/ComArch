package lib.nerush.components.ui.main

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import lib.nerush.components.base.BaseViewModel
import lib.nerush.components.data.BookRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val bookRepository: BookRepository) :
    BaseViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state: StateFlow<MainState> = _state.asStateFlow()

    init {
        loadBooks()
    }

    private fun loadBooks() {
        _state.update { it.copy(isLoading = true) }
        viewModelScope.launch {
            bookRepository.getBooks().fold(
                onSuccess = { books ->
                    _state.update { it.copy(isLoading = false, books = books) }
                },
                onFailure = {
                    _state.update { it.copy(isLoading = false, isError = true) }
                },
            )
        }
    }
}