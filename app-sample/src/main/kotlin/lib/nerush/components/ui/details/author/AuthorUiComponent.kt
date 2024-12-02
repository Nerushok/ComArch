package lib.nerush.components.ui.details.author

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import lib.nerush.components.data.Author

@Composable
internal fun AuthorUiComponent(component: IAuthorComponent, modifier: Modifier = Modifier) {
    val state by component.stateFlow.collectAsState()
    AuthorUiComponent(state = state, modifier = modifier)
}

@Composable
private fun AuthorUiComponent(state: AuthorState, modifier: Modifier = Modifier) {
    Card(modifier.animateContentSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 100.dp)
                .padding(16.dp)
        ) {
            when {
                state.isError -> {
                    Text(text = "Error", modifier = Modifier.align(Alignment.Center))
                }

                state.isLoading -> {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }

                state.author != null -> AuthorContent(state.author)
            }
        }
    }
}

@Composable
private fun AuthorContent(author: Author, modifier: Modifier = Modifier) {
    Row(modifier) {
        AsyncImage(
            model = author.avatarUrl,
            contentDescription = null,
            modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.outlineVariant)
                .size(60.dp)
        )

        Spacer(modifier = Modifier.size(16.dp))

        Column {
            Text(
                text = author.name,
                style = MaterialTheme.typography.titleSmall,
            )

            Spacer(modifier = Modifier.size(8.dp))

            Text(
                text = author.bio,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 4,
                color = MaterialTheme.colorScheme.outline,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
private fun PreviewAuthorUiComponentLoading() {
    val state = AuthorState(isLoading = true)
    MaterialTheme {
        AuthorUiComponent(state)
    }
}

@Preview
@Composable
private fun PreviewAuthorUiComponent() {
    val state = AuthorState(
        author = Author(
            id = "1",
            name = "F. Scott Fitzgerald",
            avatarUrl = "null",
            bio = "Francis Scott Key Fitzgerald (September 24, 1896 – December 21, 1940) was an American novelist, essayist, screenwriter, and short-story writer. He was best known for his novels depicting the flamboyance and excess of the Jazz Age—a term he popularized. During his lifetime, he published four novels, four collections of short stories, and 164 short stories. Although he temporarily achieved popular success and fortune in the 1920s, Fitzgerald only received wide critical and popular acclaim after his death."
        )
    )
    MaterialTheme {
        AuthorUiComponent(state)
    }
}