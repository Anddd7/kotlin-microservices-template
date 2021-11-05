package com.github.anddd7.client.dto

        import com.fasterxml.jackson.annotation.JsonProperty

/**
 * 
 *
 * @param id 
 */

data class CreateOrderCommand (

    @field:JsonProperty("id")
    val id: kotlin.String

)

