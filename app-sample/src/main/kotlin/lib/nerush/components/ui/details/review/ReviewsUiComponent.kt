package lib.nerush.components.ui.details.review

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import lib.nerush.components.data.Review

@Composable
fun ReviewsUiComponent(component: IReviewsComponent) {
    val state by component.stateFlow.collectAsState()
    ReviewsUiComponent(state)
}

@Composable
private fun ReviewsUiComponent(state: ReviewsState) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 50.dp)
    ) {
        when {
            state.isError -> {
                Text(text = "Error", modifier = Modifier.align(Alignment.Center))
            }

            state.isLoading -> {
                CircularProgressIndicator(Modifier.align(Alignment.Center))
            }

            state.reviews != null -> {
                if (state.reviews.isEmpty()) {
                    Text(text = "There is no reviews", modifier = Modifier.align(Alignment.Center))
                } else {
                    ReviewsContent(state.reviews)
                }
            }
        }
    }
}

@Composable
private fun ReviewsContent(reviews: List<Review>) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        reviews.forEach { review ->
            Card(
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(Modifier.padding(12.dp)) {
                    Text(
                        text = review.ownerNickname,
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )

                    Spacer(modifier = Modifier.size(4.dp))

                    Text(
                        text = review.text,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun PreviewPreviewsUiComponent() {
    val state = ReviewsState(
        reviews = listOf(
            Review(
                bookId = "1",
                ownerNickname = "John Doe",
                ownerAvatarUrl = "null",
                text = "Great book!",
            ),
            Review(
                bookId = "2",
                ownerNickname = "Obi Nobi",
                ownerAvatarUrl = "null",
                text = "I love it!",
            ),
        ),
    )
    MaterialTheme {
        Surface {
            ReviewsUiComponent(state)
        }
    }
}