package lib.nerush.components.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import lib.nerush.components.data.Author
import lib.nerush.components.data.Book
import lib.nerush.components.data.Review
import lib.nerush.components.ui.details.author.AuthorState
import lib.nerush.components.ui.details.author.AuthorUiComponent
import lib.nerush.components.ui.details.author.IAuthorComponent
import lib.nerush.components.ui.details.review.IReviewsComponent
import lib.nerush.components.ui.details.review.ReviewsState
import lib.nerush.components.ui.details.review.ReviewsUiComponent

@Composable
fun DetailsScreen(navigateUp: () -> Unit) {
    val viewModel: DetailsViewModel = hiltViewModel()
    DetailsScreen(viewModel = viewModel, navigateUp)
}

@Composable
private fun DetailsScreen(viewModel: DetailsViewModel, navigateUp: () -> Unit) {
    val state = viewModel.state.collectAsState()
    DetailsScreen(state = state.value, navigateUp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DetailsScreen(state: DetailsState, navigateUp: () -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { },
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = null,
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            when {
                state.isError -> {
                    Text(text = "Error", modifier = Modifier.align(Alignment.Center))
                }

                state.isLoading -> {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }

                else -> DetailsScreenContent(state)
            }
        }
    }
}

@Composable
private fun DetailsScreenContent(state: DetailsState) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 16.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        state.book?.let {
            BookPreview(it)
        }

        state.authorComponent?.let {
            Spacer(modifier = Modifier.size(32.dp))

            Text(text = "Author", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.size(16.dp))

            AuthorUiComponent(component = it)
        }

        state.reviewsComponent?.let {
            Spacer(modifier = Modifier.size(32.dp))

            Text(text = "Reviews", style = MaterialTheme.typography.titleLarge)

            Spacer(modifier = Modifier.size(16.dp))

            ReviewsUiComponent(component = it)
        }
    }
}

@Composable
private fun BookPreview(book: Book) {
    Column {
        Row {
            AsyncImage(
                model = book.coverUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .background(MaterialTheme.colorScheme.outlineVariant)
                    .size(width = 75.dp, height = 100.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
            ) {
                Text(text = book.title, style = MaterialTheme.typography.headlineSmall)

                Text(text = book.rating.toString(), style = MaterialTheme.typography.labelLarge)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = book.description,
            style = MaterialTheme.typography.bodySmall,
        )
    }
}

@Preview
@Composable
private fun PreviewDetailsScreen() {
    val book = Book(
        id = "1",
        title = "The Great Gatsby",
        coverUrl = "https://images-na.ssl-images-amazon.com/images/I/51ZQj5j7ZfL._SX331_BO1,204,203,200_.jpg",
        rating = 4.5f,
        description = "The Great Gatsby is a 1925 novel by American writer F. Scott Fitzgerald. Set in the Jazz Age on Long Island, near New York City, the novel depicts first-person narrator Nick Carraway's interactions with mysterious millionaire Jay Gatsby and Gatsby's obsession to reunite with his former lover, Daisy Buchanan.",
        authorId = "1",
    )
    val author = Author(
        id = "1",
        name = "F. Scott Fitzgerald",
        avatarUrl = "null",
        bio = "Francis Scott Key Fitzgerald (September 24, 1896 – December 21, 1940) was an American novelist, essayist, screenwriter, and short-story writer. He was best known for his novels depicting the flamboyance and excess of the Jazz Age—a term he popularized. During his lifetime, he published four novels, four collections of short stories, and 164 short stories. Although he temporarily achieved popular success and fortune in the 1920s, Fitzgerald only received wide critical and popular acclaim after his death."
    )
    val reviews = listOf(
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
    )
    val state = DetailsState(
        bookId = "1",
        book = book,
        authorComponent = object : IAuthorComponent {
            override val stateFlow: StateFlow<AuthorState> =
                MutableStateFlow(AuthorState(author = author))

            override fun updateState(reducer: AuthorState.() -> AuthorState) {}
        },
        reviewsComponent = object : IReviewsComponent {
            override val stateFlow: StateFlow<ReviewsState> =
                MutableStateFlow(ReviewsState(reviews = reviews))

            override fun updateState(reducer: ReviewsState.() -> ReviewsState) {}
        },
    )
    MaterialTheme {
        DetailsScreen(state = state, {})
    }
}