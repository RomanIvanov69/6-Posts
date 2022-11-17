object WallService {
    private var posts = emptyArray<Post>()
    private var uniqueId: Int = 0


    fun add(post: Post): Post {
        posts += post.copy(id = ++uniqueId)
        return posts.last()
    }

    fun clear() {
        posts = emptyArray()
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
}
