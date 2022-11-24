package ru.netology

import Comment
import Post
import WallService
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class WallServiceTest {
    @Before
    fun clearPost() {
        WallService.clear()
    }
    @After
    fun print() {
        WallService.printAll()
    }

    @Test
    fun addPost() {
        val post = Post(
            1,
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
            10,
            attachment = null
        )

        assertEquals(post.id, WallService.add(post).id)
    }

    @Test
    fun updateFalse() {
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
            10,
            attachment = null
        )

        val added = WallService.add(post).id


        val update = Post(
            added + 1,
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
            10,
            attachment = null
        )

        val result = WallService.update(update)
        assertFalse(result)
    }

    @Test
    fun updateTrue() {
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
            10,
            attachment = null
        )

        val added = WallService.add(post).id


        val update = Post(
            added,
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
            10,
            attachment = null
        )

        val result = WallService.update(update)
        assertTrue(result)
    }

    @Test
    fun addComment() {
        val added = WallService.add(
            Post(
                1,
                1,
                1,
                1,
                2022,
                "комментарий",
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
                1,
                attachment = null
            )
        )
        val commentTest = Comment(1, 23, 12121, "комментарий", null, 55, 6, null, null, null)
        val result = WallService.createComment(1, commentTest)
        assertEquals(added.text, result.text)
    }

    @Test(expected = WallService.PostNotFoundException::class)
    fun shouldThrow() {
        val postThrow = WallService.add(
            Post(
                1,
                1,
                1,
                1,
                2022,
                "комментарий",
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
                1,
                attachment = null
            )
        )
        val commentTest2 = Comment(1, 23, 12121, "комментарий", null, 55, 6, null, null, null)
        WallService.createComment(123, commentTest2)
    }
}
