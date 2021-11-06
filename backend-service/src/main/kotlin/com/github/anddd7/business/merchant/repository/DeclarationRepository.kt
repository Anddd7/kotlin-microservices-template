package com.github.anddd7.business.merchant.repository

import org.springframework.stereotype.Repository

@Repository
interface DeclarationRepository {
    fun latest(): Declaration
}

data class Declaration(
    val version: String,
    val content: String,
)
