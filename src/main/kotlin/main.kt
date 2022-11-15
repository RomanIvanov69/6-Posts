package ru.netology

fun main() {
    val post1 =
        Post(
            12,
            22,
            223,
            5,
            15112022,
            "Текст поста",
            "post",
            true,
            false,
            false,
            Likes(count = 10, userLikes = true, canLike = true, canPublish = true)
        )

    val post2 =
        Post(
            100,
            200,
            111,
            89,
            15112022,
            "Текст поста",
            "copy",
            true,
            true,
            false,
            Likes(count = 95, userLikes = true, canLike = false, canPublish = true)
        )
    WallService.add(post1)
    WallService.add(post2)
    print(post1)
    println()
    print(post2)
}

object WallService {
    private var posts = emptyArray<Post>()
    private var uniqueId: Int = 1
    fun add(post: Post): Post {
        posts += post.copy(id = uniqueId)
        uniqueId++
        return posts.last()
    }

    fun update(post: Post): Boolean {
        for ((index, value) in posts.withIndex()) {
            if (value.id == post.id) {
                posts[index] = post.copy(ownerId = value.ownerId, date = value.date)
                return true
            }
        }
        return false
    }

    fun print() {
        for (post in posts) println(post)
    }

    fun clear() {
        posts = emptyArray()
    }
}