package lib.nerush.components.data

import javax.inject.Inject

class BookRepository @Inject constructor() {

    fun getBooks(): List<Book> {
        return books
    }

    private val books = listOf(
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
            title = "To Kill a Mockingbird",
            coverUrl = "https://images-na.ssl-images-amazon.com/images/I/51ZQj5j7ZfL._SX331_BO1,204,203,200_.jpg",
            rating = 4.5f,
            description = "To Kill a Mockingbird is a novel by the American author Harper Lee. It was published in 1960 and was instantly successful. In the United States, it is widely read in high schools and middle schools. To Kill a Mockingbird has become a classic of modern American literature, winning the Pulitzer Prize. The plot and characters are loosely based on Lee's observations of her family, her neighbors and an event that occurred near her hometown of Monroeville, Alabama, in 1936, when she was",
            authorId = "2",
        ),
        Book(
            id = "3",
            title = "1984",
            coverUrl = "https://images-na.ssl-images-amazon",
            rating = 4.5f,
            description = "1984 is a dystopian social science fiction novel by English novelist George Orwell. It was published on 8 June 1949 by Secker & Warburg as Orwell's ninth and final book completed in his lifetime. Thematically, Nineteen Eighty-Four centres on the consequences of totalitarianism, mass surveillance, and repressive regimentation of persons and behaviours within society.",
            authorId = "3",
        ),
        Book(
            id = "4",
            title = "Harry Potter and the Philosopher's Stone",
            coverUrl = "https://images-na.ssl-images-amazon.com/images/I/51ZQj5j7ZfL._SX331_BO1,204,203,200_.jpg",
            rating = 4.5f,
            description = "Harry Potter and the Philosopher's Stone is a fantasy novel written by British author J. K. Rowling. The first novel in the Harry Potter series and Rowling's debut novel, it follows Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday when he receives a letter of acceptance to Hogwarts School of Witchcraft and Wizardry. Harry makes close friends and a few enemies during his first year at the school, and with the help of his friends, Harry faces an attempted comeback by the dark wizard Lord Voldemort, who killed Harry's parents, but failed to kill Harry when he was just 15 months old.",
            authorId = "4",
        ),
        Book(
            id = "5",
            title = "The Catcher in the Rye",
            coverUrl = "https://images-na.ssl-images-amazon",
            rating = 4.5f,
            description = "The Catcher in the Rye is a novel by J. D. Salinger, partially published in serial form in 1945–1946 and as a novel in 1951. It was originally intended for adults, but is often read by adolescents for its themes of angst, alienation, and as a critique on superficiality in society. It has been translated widely. Around one million copies are sold each year, with total sales of more than 65 million books. The novel's protagonist Holden Caulfield has become an icon for teenage rebellion. The novel also deals with complex issues of innocence, identity, belonging, loss, and connection.",
            authorId = "5",
        ),
    )
}