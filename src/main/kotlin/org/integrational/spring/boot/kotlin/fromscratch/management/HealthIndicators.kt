package org.integrational.spring.boot.kotlin.fromscratch.management

import org.springframework.boot.actuate.availability.LivenessStateHealthIndicator
import org.springframework.boot.actuate.availability.ReadinessStateHealthIndicator
import org.springframework.boot.availability.ApplicationAvailability
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Always expose liveness and readiness health indicators.
 */
@Configuration
class HealthIndicators constructor(private val avail: ApplicationAvailability) {

    @Bean
    fun liveness() = LivenessStateHealthIndicator(avail)

    @Bean
    fun readiness() = ReadinessStateHealthIndicator(avail)
}