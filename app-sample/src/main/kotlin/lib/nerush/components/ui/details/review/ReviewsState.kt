package lib.nerush.components.ui.details.review

import androidx.compose.runtime.Immutable
import lib.nerush.components.data.Review

@Immutable
data class ReviewsState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val reviews: List<Review>? = null,
)