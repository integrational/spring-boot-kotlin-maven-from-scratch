package org.integrational.spring.boot.kotlin.fromscratch

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Integration test running against this app started to listen on a random free port.
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
class AppIT {

    @BeforeTest
    fun beforeTest() {
        println("Integration Test: before test")
    }

    @AfterTest
    fun afterTest() {
        println("Integration Test: after test")
    }

    @Test
    fun aTest() {
        assertEquals("hello IT", "hello IT")
    }
}
