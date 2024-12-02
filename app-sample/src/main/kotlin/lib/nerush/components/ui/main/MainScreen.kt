package lib.nerush.components.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import lib.nerush.components.data.Book

@Composable
fun MainScreen(openBook: (String) -> Unit) {
    val viewModel: MainViewModel = hiltViewModel()
    MainScreen(viewModel = viewModel, openBook)
}

@Composable
private fun MainScreen(viewModel: MainViewModel, openBook: (String) -> Unit) {
    val state = viewModel.state.collectAsState()
    MainScreen(state = state.value, onBookClicked = openBook)
}

@Composable
private fun MainScreen(state: MainState, onBookClicked: (String) -> Unit) {
    Scaffold { paddingValues ->
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

                state.books != null -> {
                    MainScreenContent(state.books, onBookClicked)
                }
            }
        }
    }
}

@Composable
private fun MainScreenContent(books: List<Book>, onBookClicked: (String) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp),
    ) {
        items(books) { book ->
            BookItem(book = book, onBookClicked = onBookClicked)
        }
    }
}

private val BookItemHeight = 160.dp

@Composable
private fun BookItem(book: Book, onBookClicked: (String) -> Unit) {
    Row(
        modifier = Modifier
            .height(BookItemHeight)
            .clickable(onClick = { onBookClicked(book.id) })
    ) {
        AsyncImage(
            model = book.coverUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .background(MaterialTheme.colorScheme.outlineVariant)
                .size(width = 120.dp, height = BookItemHeight)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier
        ) {
            Text(text = book.title, style = MaterialTheme.typography.titleLarge)

            Text(text = book.rating.toString(), style = MaterialTheme.typography.labelLarge)

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = book.description,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.outline,
                maxLines = 5,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
private fun PreviewMainScreen() {
    val state = MainState(
        books = listOf(
            Book(
                id = "1",
                title = "The Great Gatsby",
                coverUrl = "https://images-na.ssl-images-amazon.com/images/I/51ZQj5j7ZfL._SX331_BO1,204,203,200_.jpg",
                rating = 4.5f,
                description = "The Great Gatsby is a 1925 novel by American writer F. Scott Fitzgerald. Set in the Jazz Age on Long Island, near New York City, the novel depicts first-person narrator Nick Carraway's interactions with mysterious millionaire Jay Gatsby and Gatsby's obsession to reunite with his former lover, Daisy Buchanan.",
                authorId = "1",
            ),
            Book(
                id = "2",
                title = "To Kill a Mockingbird and something",
                coverUrl = "https://images-na.ssl-images-amazon.com/images/I/51ZQj5j7ZfL._SX331_BO1,204,203,200_.jpg",
                rating = 4.5f,
                description = "To Kill a Mockingbird is a novel by the American author Harper Lee. It was published in 1960 and was instantly successful. In the United States, it is widely read in high schools and middle schools. To Kill a Mockingbird has become a classic of modern American literature, winning the Pulitzer Prize. The plot and characters are loosely based on Lee's observations of her family, her neighbors and an event that occurred near her hometown of Monroeville, Alabama, in 1936, when she was",
                authorId = "2",
            ),
        )
    )
    MaterialTheme {
        MainScreen(state = state, onBookClicked = {})
    }
}