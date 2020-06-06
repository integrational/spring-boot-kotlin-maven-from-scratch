package org.integrational.spring.boot.kotlin.fromscratch

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Integration test running against this app listening on a random free port.
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
class AppIT {
    private val self = this.javaClass.simpleName

    private val testType = "Integration Test"
    private val testEnv = "it"

    @Value("\${app.env}")
    lateinit var env: String

    @BeforeTest
    fun beforeTest() = println("$testType $self: before test")

    @AfterTest
    fun afterTest() = println("$testType $self: after test")

    @Test
    fun `env correct for this test type`() = assertEquals(testEnv, env)
}
