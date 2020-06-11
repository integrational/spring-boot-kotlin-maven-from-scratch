package org.integrational.spring.boot.kotlin.profile

import org.springframework.context.annotation.Profile
import kotlin.annotation.AnnotationRetention.RUNTIME
import kotlin.annotation.AnnotationTarget.CLASS

/**
 * To restrict the registration of a Spring component to the Production environment.
 */
@Target(CLASS)
@Retention(RUNTIME)
@Profile("default")
annotation class Production

/**
 * To restrict the registration of a Spring component to all environments but Production.
 */
@Target(CLASS)
@Retention(RUNTIME)
@Profile("!default")
annotation class NonProduction

/**
 * To restrict the registration of a Spring component to the Development environment.
 */
@Target(CLASS)
@Retention(RUNTIME)
@Profile("dev")
annotation class Development

/**
 * To restrict the registration of a Spring component to the Unit Test environment.
 */
@Target(CLASS)
@Retention(RUNTIME)
@Profile("ut")
annotation class UnitTest

/**
 * To restrict the registration of a Spring component to the Integration Test environment.
 */
@Target(CLASS)
@Retention(RUNTIME)
@Profile("it")
annotation class IntegrationTest

/**
 * To restrict the registration of a Spring component to any Test environment.
 */
@Target(CLASS)
@Retention(RUNTIME)
@Profile("ut | it")
annotation class Test
