package ru.netology

import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WallServiceTest {

    @Test
    fun addPost() {
        val post = Post(
            1,
            2,
            3,
            4,
            5,
            "Текст",
            "copy",
            true,
            true,
            false,
            Likes(count = 1, userLikes = true, canLike = false, canPublish = true)
        )
        val result = WallService.add(post).id

        assertEquals(1, result)
    }

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateTrue() {
        val service = WallService
        val post1 = Post(
            1,
            2,
            3,
            4,
            5,
            "Текст",
            "copy",
            true,
            true,
            false,
            Likes(count = 1, userLikes = true, canLike = false, canPublish = true)
        )
        service.add(post1)
        val post2 = Post(
            2,
            2,
            3,
            4,
            5,
            "Текст",
            "copy",
            true,
            true,
            false,
            Likes(count = 1, userLikes = true, canLike = false, canPublish = true)
        )
        service.add(post2)
        val update = Post(
            1,
            2,
            3,
            4,
            5,
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

    @Test
    fun updateFalse() {
        val service = WallService
        val post1 = Post(
            1,
            2,
            3,
            4,
            5,
            "Текст",
            "copy",
            true,
            true,
            false,
            Likes(count = 1, userLikes = true, canLike = false, canPublish = true)
        )
        service.add(post1)
        val post2 = Post(
            2,
            2,
            3,
            4,
            5,
            "Текст",
            "copy",
            true,
            true,
            false,
            Likes(count = 1, userLikes = true, canLike = false, canPublish = true)
        )
        service.add(post2)
        val update = Post(
            3,
            2,
            3,
            4,
            5,
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
}