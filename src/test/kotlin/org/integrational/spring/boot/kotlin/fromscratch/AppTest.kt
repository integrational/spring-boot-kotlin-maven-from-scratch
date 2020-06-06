package org.integrational.spring.boot.kotlin.fromscratch

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Unit test, without web stack.
 */
@SpringBootTest(webEnvironment = NONE)
class AppTest {
    private val self = this.javaClass.simpleName

    private val testType = "Unit Test"
    private val testEnv = "ut"

    @Value("\${app.env}")
    lateinit var env: String

    @BeforeTest
    fun beforeTest() = println("$testType $self: before test")

    @AfterTest
    fun afterTest() = println("$testType $self: after test")

    @Test
    fun `env correct for this test type`() = assertEquals(testEnv, env)
}
