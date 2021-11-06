package com.github.anddd7.business.merchant.repository

import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
interface MerchantAcceptedDeclarationRepository {
    fun save(entity: MerchantAcceptedDeclaration): MerchantAcceptedDeclaration
    fun get(id: String): MerchantAcceptedDeclaration
}

data class MerchantAcceptedDeclaration(
    val userId: String,
    val declarationVersion: String,
    val createdAt: Instant,
    val expiredAt: Instant,
    private val id: String = "",
) {
    val proposalId: String = id
}
