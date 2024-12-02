package lib.nerush.components.ui.details.author

import androidx.compose.runtime.Immutable
import lib.nerush.components.data.Author

@Immutable
data class AuthorState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val author: Author? = null,
)