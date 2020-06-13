package org.integrational.spring.boot.kotlin.fromscratch.domain.repository

import org.integrational.spring.boot.kotlin.fromscratch.domain.AnAggregateRoot

interface AnAggregateRootRepository {
    fun save(entity: AnAggregateRoot)

    fun findById(id: String): AnAggregateRoot?
}