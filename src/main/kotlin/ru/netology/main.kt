package ru.netology

import Post
import WallService

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
            "копия",
            10,
            10,
            false,
            true,
            true,
            false,
            10
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
            "копия",
            15,
            15,
            true,
            false,
            true,
            false,
            5
            )
    println(WallService.add(post1))
    println(WallService.add(post2))
}
