package com.github.anddd7.business.merchant.repository

import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
interface MerchantAccountContractRepository {
    fun save(contract: MerchantAccountContract): MerchantAccountContract
}

data class MerchantAccountContract(
    val userId: String,
    val fullName: String,
    val identityNumber: String,
    val proposalId: String,
    val createdAt: Instant,
    val expiredAt: Instant,
    val contractId: String = "",
)
