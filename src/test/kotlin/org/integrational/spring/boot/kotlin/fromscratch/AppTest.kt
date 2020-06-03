package org.integrational.spring.boot.kotlin.fromscratch

import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit test
 */
@SpringBootTest
class AppTest {

    @BeforeTest
    fun beforeTest() {
        println("Unit Test: before test")
    }

    @AfterTest
    fun afterTest() {
        println("Unit Test: after test")
    }

    @Test
    fun aTest() {
        assertEquals("hello UT", "hello UT")
    }
}
