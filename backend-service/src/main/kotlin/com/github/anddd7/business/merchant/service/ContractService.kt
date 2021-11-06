package com.github.anddd7.business.merchant.service

import com.github.anddd7.business.common.Confirmation
import com.github.anddd7.business.common.Request
import com.github.anddd7.business.merchant.repository.MerchantAccountContract
import com.github.anddd7.business.merchant.repository.MerchantAccountContractRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class ContractService(
    private val proposalService: ProposalService,
    private val contractService: MerchantAccountContractRepository,
) {
    fun requestAndConfirm(request: ContractRequest): ContractConfirmationResponse {
        val proposalId = request
            .run { ProposalRequest(userId, declarationVersion) }
            .let { proposalService.requestAndConfirm(it) }
            .proposalId
        return request
            // confirmation
            .run { ContractConfirmation(userId, fullName, identityNumber, declarationVersion, createdAt) }
            // entity
            .run { MerchantAccountContract(userId, fullName, identityNumber, proposalId, createdAt, expiredAt) }
            // save the entity
            .let { contractService.save(it) }
            // return response
            .run { ContractConfirmationResponse(contractId) }
    }
}

data class ContractRequest(
    val userId: String,
    val fullName: String,
    val identityNumber: String,
    val declarationVersion: String,
    override val createdAt: Instant = Instant.now(),
) : Request

data class ContractConfirmation(
    val userId: String,
    val fullName: String,
    val identityNumber: String,
    val declarationVersion: String,
    override val createdAt: Instant,
    override val expiredAt: Instant = Instant.MAX,
) : Confirmation

data class ContractConfirmationResponse(
    val contractId: String,
)
