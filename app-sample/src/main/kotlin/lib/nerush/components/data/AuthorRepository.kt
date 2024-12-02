package lib.nerush.components.data

import kotlinx.coroutines.delay
import javax.inject.Inject

class AuthorRepository @Inject constructor() {

    suspend fun getAuthor(id: String): Result<Author?> {
        delay(2000)
        return Result.success(authors.find { it.id == id })
    }

    private val authors = listOf(
        Author(
            id = "1",
            name = "F. Scott Fitzgerald",
            avatarUrl = "https://upload.wikimedia.org/wikipedia/commons/0/0c/Scott_Fitzgerald_1921.jpg",
            bio = "Francis Scott Key Fitzgerald (September 24, 1896 – December 21, 1940) was an American novelist, essayist, screenwriter, and short-story writer. He was best known for his novels depicting the flamboyance and excess of the Jazz Age—a term he popularized. During his lifetime, he published four novels, four collections of short stories, and 164 short stories. Although he temporarily achieved popular success and fortune in the 1920s, Fitzgerald only received wide critical and popular acclaim after his death.",
        ),
        Author(
            id = "2",
            name = "Harper Lee",
            avatarUrl = "https://upload.wikimedia.org/wikipedia/commons/4/4f/Harper_Lee_1961.jpg",
            bio = "Nelle Harper Lee (April 28, 1926 – February 19, 2016) was an American novelist best known for her 1960 novel To Kill a Mockingbird. It won the 1961 Pulitzer Prize and has become a classic of modern American literature. Lee published only two books, yet she was awarded the Presidential Medal of Freedom in 2007 for her contribution to literature. She also received numerous honorary degrees, though she declined to speak on those occasions. She assisted her close friend Truman Capote in his research for the book In Cold Blood (1966).",
        ),
        Author(
            id = "3",
            name = "George Orwell",
            avatarUrl = "https://upload.wikimedia.org/wikipedia/commons/1/10/George-Orwell.jpg",
            bio = "Eric Arthur Blair (25 June 1903 – 21 January 1950), known by his pen name George Orwell, was an English novelist, essayist, journalist and critic. His work is characterised by lucid prose, biting social criticism, opposition to totalitarianism, and outspoken support of democratic socialism. As a writer, Orwell produced literary criticism, fiction, and poetry, and was best known for the allegorical novella Animal Farm (1945) and the dystopian novel Nineteen Eighty-Four (1949). His non-fiction works, including The Road to Wigan Pier (1937), documenting his experience of working-class life in the north of England, and Homage to Catalonia (1938), an account of his experiences soldiering for the Republican faction of the Spanish Civil War (1936–1939), are as critically respected as his essays on politics and literature.",
        ),
        Author(
            id = "4",
            name = "J. K. Rowling",
            avatarUrl = "https://upload.wikimedia.org/wikipedia/commons/5/5d/J._K._Rowling_2010.jpg",
            bio = "Joanne Rowling CH, OBE, HonFRSE, FRCPE, FRSL (/ˈroʊlɪŋ/ ROH-ling; born 31 July 1965), better known by her pen name J. K. Rowling, is a British author, philanthropist, film producer, television producer, and screenwriter. She is best known for writing the Harry Potter fantasy series, which has won multiple awards and sold more than 500 million copies, becoming the best-selling book series in history. The books are the basis of a popular film series, over which Rowling had overall approval on the scripts and was a producer on the final films. She also writes crime novels under the pen name Robert Galbraith.",
        ),
        Author(
            id = "5",
            name = "J. D. Salinger",
            avatarUrl = "https://upload.wikimedia.org/wikipedia/commons/0/0f/J._D._Salinger.jpg",
            bio = "Jerome David Salinger (/ˈsælɪndʒər/; January 1, 1919 – January 27, 2010) was an American writer best known for his 1951 novel The Catcher in the Rye. Before its publication, Salinger published several short stories in Story magazine and served in World War II. In 1948, his critically acclaimed story \"A Perfect Day for Bananafish\" appeared in The New Yorker, which published much of his later work. The Catcher in the Rye was an immediate popular success. Salinger's depiction of adolescent alienation and loss of innocence in the protagonist Holden Caulfield was influential, especially among adolescent readers. The novel was widely read and controversial, and its success led to public attention and scrutiny. Salinger became reclusive, publishing new work less frequently. He followed Catcher with Nine Stories (1953), Franny and Zooey (1961), and Raise High the Roof Beam, Carpenters and Seymour: An Introduction (1963). His last published work, the novella Hapworth 16, 1924, appeared in The New Yorker on June 19, 1965.",
        ),
    )
}