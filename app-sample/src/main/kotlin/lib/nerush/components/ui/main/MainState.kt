package lib.nerush.components.ui.main

import androidx.compose.runtime.Immutable
import lib.nerush.components.data.Book

@Immutable
data class MainState(
    val isError: Boolean = false,
    val isLoading: Boolean = false,
    val books: List<Book>? = null,
)