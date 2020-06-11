package org.integrational.spring.boot.kotlin.fromscratch.rest

import org.glassfish.jersey.server.ResourceConfig
import javax.inject.Inject
import javax.inject.Named

/**
 * Registers all well-known REST resources with the JAX-RS runtime.
 */
@Named
class RestResourceRegistrator @Inject constructor(ping: PingRestResource) : ResourceConfig() {
    init {
        registerInstances(ping)
    }
}