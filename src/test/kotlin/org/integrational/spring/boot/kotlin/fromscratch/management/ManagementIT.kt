package org.integrational.spring.boot.kotlin.fromscratch.management

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus.OK
import javax.inject.Inject
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Integration test of management and monitoring endpoints exposed by Actuator.
 */
@SpringBootTest(webEnvironment = RANDOM_PORT)
class ManagementIT {

    @Inject
    lateinit var http: TestRestTemplate

    private val base = "/management"

    /**
     * HTTP GET to base URL plus optional path, asserting HTTP status code is OK and returning response body as [Map].
     */
    private fun getMap(path: String? = null) = http.getForEntity(base + (path ?: ""), Map::class.java).run {
        assertEquals(OK, statusCode, "HTTP status is OK")
        assertTrue(hasBody(), "HTTP response has body")
        body!!
    }

    @Test
    fun `HTTP GET to management base URL`() = getMap().run {
        assertTrue(contains("_links"), "body contains _links")
    }

    @Test
    fun `configprops endpoint`() = getMap("/configprops").run {
        assertTrue(contains("contexts"), "body contains contexts")
    }

    @Test
    fun `env endpoint`() = getMap("/env").run {
        assertTrue(contains("activeProfiles"), "body contains activeProfiles")
        assertTrue(contains("propertySources"), "body contains propertySources")
    }

    @Test
    fun `health endpoint`() = getMap("/health").run {
        assertTrue(contains("status"), "body contains status")
        assertEquals("UP", get("status"), "status is UP")
        assertTrue(contains("components"), "body contains components")
    }

    @Test
    fun `info endpoint`() = getMap("/info").run {
        assertTrue(contains("build"), "body contains build")
    }

    @Test
    fun `metrics endpoint`() = getMap("/metrics").run {
        assertTrue(contains("names"), "body contains names")
    }
}
