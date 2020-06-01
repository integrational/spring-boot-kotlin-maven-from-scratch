package org.integrational.spring.boot.kotlin.fromscratch

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication.run
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class App(
    @Value("\${app.name}") private val app: String,
    @Value("\${app.version}") private val version: String,
    @Value("\${app.env}") private val env: String
) {
    private val log = LoggerFactory.getLogger(App::class.java)

    init {
        log.info("Started $app $version in $env")
    }
}

fun main(args: Array<String>) {
    run(App::class.java, *args)
}
