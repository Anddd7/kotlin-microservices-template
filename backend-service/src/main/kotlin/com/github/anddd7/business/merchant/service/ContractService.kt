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
    fun request(request: ContractRequest): ContractRequestResponse {
        val proposalId = request
            .run { ProposalRequest(userId, declarationVersion) }
            .let { proposalService.requestAndConfirm(it) }
            .proposalId

        return request
            .run { MerchantAccountContract(userId, fullName, identityNumber, proposalId, createdAt, Instant.MAX) }
            .let { contractService.save(it) }
            .run { ContractRequestResponse(contractId) }
    }

    fun confirm(contractId: String, confirmation: ContractConfirmation): ContractConfirmationResponse {
        if (confirmation.approval) {
            // TODO create merchant account
            return ContractConfirmationResponse(contractId, "merchant account id")
        }

        return ContractConfirmationResponse(contractId, null)
    }
}

data class ContractRequest(
    val userId: String,
    val fullName: String,
    val identityNumber: String,
    val declarationVersion: String,
    override val createdAt: Instant = Instant.now(),
) : Request

data class ContractRequestResponse(
    val contractId: String,
)

data class ContractConfirmation(
    val approval: Boolean,
    val remark: String,
    override val createdAt: Instant,
    override val expiredAt: Instant = Instant.MAX,
) : Confirmation

data class ContractConfirmationResponse(
    val contractId: String,
    val merchantAccountId: String?,
)
