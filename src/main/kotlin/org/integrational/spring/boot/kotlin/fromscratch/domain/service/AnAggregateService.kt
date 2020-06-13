package org.integrational.spring.boot.kotlin.fromscratch.domain.service

import org.integrational.spring.boot.kotlin.fromscratch.domain.AnAggregateRoot

interface AnAggregateDomainService {
    fun createAggregate(): AnAggregateRoot
}