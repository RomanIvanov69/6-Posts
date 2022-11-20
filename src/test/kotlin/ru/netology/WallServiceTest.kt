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
            10,
            10,
            2022,
            "текст",
            "тип",
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

        val result = service.add(post).id

        assertEquals(1, result)
    }

    @Test
    fun updateFalse() {
        val service = WallService
        service.add(
            Post(
                5,
                1,
                10,
                10,
                2022,
                "текст",
                "тип",
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
        )
        service.add(
            Post(
                5,
                1,
                1,
                1,
                2021,
                "текст",
                "тип",
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
        )
        val update = Post(
            5,
            11,
            11,
            111,
            2021,
            "текст",
            "тип",
            true,
            false,
            true,
            "копия",
            10,
            10,
            false,
            true,
            true,
            false,
            10
        )
        val result = service.update(update)
        assertFalse(result)
    }

    @Test
    fun updateTrue() {
        val service = WallService
        service.add(
            Post(1,
                1,
                1,
                1,
                2022,
                "текст",
                "тип",
                true,
                false,
                true,
                "копия",
                10,
                10,
                false,
                true,
                true,
                false,
                1
            )
        )
        service.add(
            Post(
                1,
                2,
                3,
                4,
                2022,
                "текст",
                "тип",
                true,
                false,
                true,
                "копия",
                10,
                10,
                false,
                true,
                true,
                false,
                1
            )
        )
        val update = Post(
            1,
            1,
            1,
            1,
            2022,
            "текст",
            "тип",
            true,
            false,
            true,
            "копия",
            10,
            10,
            false,
            true,
            true,
            false,
            1
        )
        val result = service.update(update)
        assertTrue(result)
    }
}