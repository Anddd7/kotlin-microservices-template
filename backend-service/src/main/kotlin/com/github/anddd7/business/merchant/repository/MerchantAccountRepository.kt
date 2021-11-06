package com.github.anddd7.business.merchant.repository

import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
interface MerchantAccountRepository {
    fun save(entity: MerchantAccount): MerchantAccount
    fun get(id: String): MerchantAccount
}

data class MerchantAccount(
    val userId: String,
    val fullName: String,
    val identityNumber: String,
    val proposalId: String,
    val createdAt: Instant,
    val expiredAt: Instant,
    private val id: String = "",
) {
    val contractId: String = id
}
