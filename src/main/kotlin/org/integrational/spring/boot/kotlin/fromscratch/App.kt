package org.integrational.spring.boot.kotlin.fromscratch

import org.slf4j.LoggerFactory
import org.springframework.boot.SpringApplication.run
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class App {
    private val log = LoggerFactory.getLogger(App::class.java)

    init {
        log.info("Started")
    }
}

fun main(args: Array<String>) {
    run(App::class.java, *args)
}
