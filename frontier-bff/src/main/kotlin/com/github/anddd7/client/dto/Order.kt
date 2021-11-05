package com.github.anddd7.client.dto

        import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 *
 * @param id 
 * @param createdAt 
 */

data class Order (

    @field:JsonProperty("id")
    val id: kotlin.String,

    @field:JsonProperty("createdAt")
    val createdAt: java.time.OffsetDateTime

)

