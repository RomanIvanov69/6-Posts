object WallService {
    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var uniqueId: Int = 0


    fun add(post: Post): Post {
        posts += post.copy(id = ++uniqueId)
        return posts.last()
    }

    fun clear() {
        posts = emptyArray()
        uniqueId = 0
    }

    fun update(post: Post): Boolean {
        for ((index, item) in posts.withIndex()) {
            if (item.id == post.id) {
                posts[index] = post.copy(ownerId = item.ownerId, date = item.id)
                return true
            }
        }
        return false
    }
    class PostNotFoundException(message: String): RuntimeException(message)
    fun createComment(postId: Int, comment: Comment): Comment {
        for (post in posts) {
            if (postId == post.id) {
                comments += comment
                return comments.last()
            }
        }
        throw PostNotFoundException("Post with ID $postId not found!")
    }
    fun printAll() {
        for (post in posts) {
            println(post)
        }
    }
}
