package org.integrational.spring.boot.kotlin.fromscratch.rest

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus.OK
import javax.inject.Inject
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Integration test for endpoint exposed by [PingRestResource].
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
class PingRestResourceIT {

    @Inject
    lateinit var http: TestRestTemplate

    @Test
    fun `HTTP GET to ping`() = http.getForEntity("/ping", String::class.java).run {
        assertEquals(OK, statusCode, "HTTP status is OK")
        assertTrue(hasBody(), "HTTP response has body")
        assertEquals("pong", body, "body is 'pong'")
    }
}