package org.integrational.spring.boot.kotlin.fromscratch.rest

import org.integrational.spring.boot.kotlin.fromscratch.domain.AValueObject
import org.integrational.spring.boot.kotlin.fromscratch.domain.AnAggregateRoot
import org.integrational.spring.boot.kotlin.fromscratch.domain.service.AnAggregateService
import javax.inject.Named

@Named
class AnAggregateResourceImpl(val svc: AnAggregateService) : AnAggregateResource {
    override fun createAggregate(representation: AnAggregateToCreate): AnAggregate {
        val root = domain(representation)
        val createdRoot = svc.createAggregate(root)
        TODO("Not yet implemented")
    }

    override fun getAggregate(id: String): AnAggregate {
        TODO("Not yet implemented")
    }

    override fun addChild(parentId: String, representation: AnEntityToAdd): AnEntity {
        TODO("Not yet implemented")
    }

    override fun removeChild(parentId: String, childId: String) {
        TODO("Not yet implemented")
    }

    companion object {
        private fun domain(rest: AnAggregateToCreate) =
            AnAggregateRoot(null, rest.children.map { domain(it) }, domain(rest.value))

        private fun domain(rest: AnEntityToAdd) =
            org.integrational.spring.boot.kotlin.fromscratch.domain.AnEntity(null, null, domain(rest.property))

        private fun domain(property: String) = AValueObject(property)
    }
}