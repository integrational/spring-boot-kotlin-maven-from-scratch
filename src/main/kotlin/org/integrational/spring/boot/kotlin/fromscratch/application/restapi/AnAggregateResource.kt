package org.integrational.spring.boot.kotlin.fromscratch.rest

import javax.ws.rs.*
import javax.ws.rs.core.MediaType.APPLICATION_JSON
import javax.ws.rs.core.MediaType.APPLICATION_XML

@Path("/api/aggregates")
@Produces(value = [APPLICATION_JSON, APPLICATION_XML])
@Consumes(value = [APPLICATION_JSON, APPLICATION_XML])
interface AnAggregateResource {
    @POST
    fun createAggregate(representation: AnAggregateToCreate): AnAggregate

    @GET
    @Path("/{id}")
    fun getAggregate(@PathParam("id") id: String): AnAggregate

    @POST
    @Path("/{id}/children")
    fun addChild(@PathParam("id") parentId: String, representation: AnEntityToAdd): AnEntity

    @DELETE
    @Path("/{id}/children/{childId}")
    fun removeChild(@PathParam("id") parentId: String, @PathParam("childId") childId: String)
}

data class AnAggregateToCreate(
    val children: List<AnEntityToAdd>,
    val value: String
)

data class AnAggregate(
    val id: String,
    val children: List<AnEntity>,
    val value: String
)

data class AnEntityToAdd(
    val property: String
)

data class AnEntity(
    val id: String,
    val property: String
)