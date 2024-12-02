package lib.nerush.components.data

data class Book(
    val id: String,
    val title: String,
    val coverUrl: String,
    val rating: Float,
    val description: String,
    val authorId: String,
)

data class Author(
    val id: String,
    val name: String,
    val avatarUrl: String,
    val bio: String,
)

data class Review(
    val bookId: String,
    val ownerNickname: String,
    val ownerAvatarUrl: String,
    val text: String,
)