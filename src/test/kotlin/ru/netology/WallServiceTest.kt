package ru.netology

import Post
import WallService
import org.junit.Assert.*
import org.junit.Test

class WallServiceTest {

    @Test
    fun addPost() {
        val service = WallService
        val post = Post(
            5,
            1,
        )

        val result = service.add(post).id

        assertEquals(1, result)
    }

    @Test
    fun updateFalse() {
        val service = WallService
        service.add(
            Post(
                2,
                1,
            )
        )
        service.add(
            Post(
                1,
                1,
            )
        )
        val update = Post(
            100,
            1,
        )
        val result = service.update(update)
        assertFalse(result)
    }

    @Test
    fun updateTrue() {
        val service = WallService
        service.add(
            Post(
                1000,
                10,
            )
        )
        service.add(
            Post(
                2,
                3,
            )
        )
        val update = Post(
            2,
            2,
        )
        val result = service.update(update)
        assertTrue(result)
    }
}