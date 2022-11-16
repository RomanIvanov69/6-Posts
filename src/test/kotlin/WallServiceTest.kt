package ru.netology

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {
    @Test
    fun addPost() {
        val post = Post(
            1,
            1,
            1,
            1,
            1,
            "Текст",
            "copy",
            true,
            true,
            false,
            Likes(count = 1, userLikes = true, canLike = false, canPublish = true)
        )
        val result = WallService.add(post).ownerId

        assertEquals(1, result)
    }
//    @Before
//    fun clearBeforeTest() {
//        WallService.clear()
//    }
    @Test
    fun updateFalse() {
        val service = WallService
        service.add(Post(
            1,
            1,
            1,
            1,
            1,
            "Текст",
            "copy",
            true,
            true,
            false,
            Likes(count = 1, userLikes = true, canLike = false, canPublish = true)
        ))
        service.add(Post(
            1,
            1,
            1,
            1,
            1,
            "Текст",
            "copy",
            true,
            true,
            false,
            Likes(count = 1, userLikes = true, canLike = false, canPublish = true)
        ))

        val update = Post(
            1,
            1,
            1,
            1,
            1,
            "Текст",
            "copy",
            true,
            true,
            false,
            Likes(count = 1, userLikes = true, canLike = false, canPublish = true)
        )
        val result = service.update(update)
        assertFalse(result)
    }
    @Test
    fun updateTrue() {
        val service = WallService
        service.add(Post(
            1,
            1,
            1,
            1,
            1,
            "Текст",
            "copy",
            true,
            true,
            false,
            Likes(count = 1, userLikes = true, canLike = false, canPublish = true)
        ))
        service.add(Post(
            1,
            1,
            1,
            1,
            1,
            "Текст",
            "copy",
            true,
            true,
            false,
            Likes(count = 1, userLikes = true, canLike = false, canPublish = true)
        ))
        val update = Post(
            1,
            1,
            1,
            1,
            1,
            "Текст",
            "copy",
            true,
            true,
            false,
            Likes(count = 1, userLikes = true, canLike = false, canPublish = true)
        )
        val result = service.update(update)
        assertTrue(result)
    }
}