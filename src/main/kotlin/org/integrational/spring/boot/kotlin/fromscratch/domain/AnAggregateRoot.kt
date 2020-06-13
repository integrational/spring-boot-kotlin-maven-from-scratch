package org.integrational.spring.boot.kotlin.fromscratch.core.domain

class AnAggregateRoot(var id: String?, var entitites: List<AnEntity>, var value: AValueObject)