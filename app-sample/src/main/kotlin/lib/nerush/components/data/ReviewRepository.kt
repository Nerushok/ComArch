package lib.nerush.components.data

import kotlinx.coroutines.delay
import javax.inject.Inject

class ReviewRepository @Inject constructor() {

    suspend fun getReviews(bookId: String): Result<List<Review>> {
        delay(1000)
        return Result.success(reviews[bookId] ?: emptyList())
    }

    private val reviews = mapOf(
        "1" to listOf(
            Review(
                bookId = "1",
                ownerNickname = "John Doe",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "This is a great book! I recommend it to everyone!",
            ),
            Review(
                bookId = "2",
                ownerNickname = "Jack Jackson",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "Amazing book! I loved it!",
            ),
            Review(
                bookId = "3",
                ownerNickname = "Bill",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "The best book I've ever read!",
            ),
        ),
        "2" to listOf(
            Review(
                bookId = "2",
                ownerNickname = "Jane Doe",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "This is a great book! I recommend it to everyone!",
            ),
            Review(
                bookId = "2",
                ownerNickname = "Jack Jackson",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "Amazing book! I loved it!",
            ),
            Review(
                bookId = "3",
                ownerNickname = "Bill",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "The best book I've ever read!",
            ),
        ),
        "3" to listOf(
            Review(
                bookId = "3",
                ownerNickname = "John Doe",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "This is a great book! I recommend it to everyone!",
            ),
            Review(
                bookId = "2",
                ownerNickname = "Jack Jackson",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "Amazing book! I loved it!",
            ),
            Review(
                bookId = "3",
                ownerNickname = "Bill",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "The best book I've ever read!",
            ),
        ),
        "4" to listOf(
            Review(
                bookId = "4",
                ownerNickname = "Jane Doe",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "This is a great book! I recommend it to everyone!",
            ),
            Review(
                bookId = "2",
                ownerNickname = "Jack Jackson",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "Amazing book! I loved it!",
            ),
        ),
        "5" to listOf(
            Review(
                bookId = "5",
                ownerNickname = "John Doe",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "This is a great book! I recommend it to everyone!",
            ),
            Review(
                bookId = "2",
                ownerNickname = "Jack Jackson",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "Amazing book! I loved it!",
            ),
            Review(
                bookId = "3",
                ownerNickname = "Bill",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "The best book I've ever read!",
            ),
        ),
    )
}