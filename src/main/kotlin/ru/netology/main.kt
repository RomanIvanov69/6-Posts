package ru.netology

import Likes
import Post

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
            3,
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
    print(post1)
    println()
    print(post2)
}
