package lib.nerush.components.data

import javax.inject.Inject

class ReviewRepository @Inject constructor() {

    fun getReviews(bookId: String): List<Review>? {
        return reviews[bookId]
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
        ),
        "2" to listOf(
            Review(
                bookId = "2",
                ownerNickname = "Jane Doe",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "This is a great book! I recommend it to everyone!",
            ),
        ),
        "3" to listOf(
            Review(
                bookId = "3",
                ownerNickname = "John Doe",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "This is a great book! I recommend it to everyone!",
            ),
        ),
        "4" to listOf(
            Review(
                bookId = "4",
                ownerNickname = "Jane Doe",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "This is a great book! I recommend it to everyone!",
            ),
        ),
        "5" to listOf(
            Review(
                bookId = "5",
                ownerNickname = "John Doe",
                ownerAvatarUrl = "https://www.gravatar.com/avatar/",
                text = "This is a great book! I recommend it to everyone!",
            ),
        ),
    )
}