package ru.netology

import Images
import Photo
import PhotoAttachment
import Post
import Sticker
import StickerAttachment
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
            10,
            attachment = PhotoAttachment(Photo(1,1,1,1,"текст",2022, null,10,10))
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
            5,
            attachment = StickerAttachment(Sticker(1,1,"url",true, Images("url", 1, 1)))
            )
    println(WallService.add(post1))
    println(WallService.add(post2))
}
