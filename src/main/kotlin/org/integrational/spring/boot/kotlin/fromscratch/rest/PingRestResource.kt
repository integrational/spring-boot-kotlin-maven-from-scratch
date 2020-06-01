package org.integrational.spring.boot.kotlin.fromscratch.rest

import javax.inject.Named
import javax.ws.rs.GET
import javax.ws.rs.Path

/**
 * REST resource for a simple "ping".
 */
@Named
@Path("/")
class PingRestResource {
    @GET
    @Path("ping")
    fun ping() = "pong"
}