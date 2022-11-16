package ru.netology

object WallService {
    private var posts = emptyArray<Post>()
    private var uniqueId: Int = 1


    fun add(post: Post): Post {
        posts += post.copy(id = uniqueId)
        uniqueId++
        return posts.last()
    }

//    fun update(post: Post): Boolean {
//        for ((index, item) in posts.withIndex()) {
//            if (item.id == post.id) {
//                posts[index] = post.copy(id = item.id, date = item.id)
//                return true
//            }
//        }
//        return false
//    }

    fun update(post: Post): Boolean {
        val indexPost = posts.indexOf(post)
        return if (indexPost != -1) {
            posts[indexPost] = post.copy(ownerId = posts[indexPost].ownerId, date = posts[indexPost].date)
            true
        } else {
            false
        }
    }

    fun print() {
        for (post in posts) println(post)
    }
}
