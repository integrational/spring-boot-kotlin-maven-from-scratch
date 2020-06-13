package org.integrational.spring.boot.kotlin.fromscratch.rest

import org.glassfish.jersey.server.ResourceConfig
import javax.inject.Named

/**
 * Registers all well-known REST resources with the JAX-RS runtime.
 */
@Named
class RestResourceRegistrator(anAggregateResource: AnAggregateResource) : ResourceConfig() {
    init {
        registerInstances(anAggregateResource)
    }
}