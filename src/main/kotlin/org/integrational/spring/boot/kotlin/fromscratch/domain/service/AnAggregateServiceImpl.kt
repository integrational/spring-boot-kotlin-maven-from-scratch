package org.integrational.spring.boot.kotlin.fromscratch.domain.service

import org.integrational.spring.boot.kotlin.fromscratch.domain.AnAggregateRoot
import org.integrational.spring.boot.kotlin.fromscratch.domain.AnAggregateRootId
import org.integrational.spring.boot.kotlin.fromscratch.domain.AnEntity
import org.integrational.spring.boot.kotlin.fromscratch.domain.AnEntityId
import org.integrational.spring.boot.kotlin.fromscratch.domain.repository.AnAggregateRepository
import javax.inject.Named

@Named
class TheAggregateDomainServiceImpl(private val repo: AnAggregateRepository) : AnAggregateService {
    override fun createAggregate(root: AnAggregateRoot): AnAggregateRoot {
        TODO("Not yet implemented")
    }

    override fun getAggregate(rootId: AnAggregateRootId): AnAggregateRoot {
        TODO("Not yet implemented")
    }

    override fun addChild(rootId: AnAggregateRootId, child: AnEntity): Boolean {
        TODO("Not yet implemented")
    }

    override fun removeChild(rootId: AnAggregateRootId, childId: AnEntityId): Boolean {
        TODO("Not yet implemented")
    }
}