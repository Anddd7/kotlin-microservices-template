package com.github.anddd7.business.merchant.repository

import org.springframework.stereotype.Repository
import java.time.Instant

@Repository
interface MerchantAccountProposalRepository {
    fun save(proposal: MerchantAccountProposal): MerchantAccountProposal
    fun get(id: String): MerchantAccountProposal
}

data class MerchantAccountProposal(
    val userId: String,
    val declarationVersion: String,
    val createdAt: Instant,
    val expiredAt: Instant,
    val id: String = "",
)
