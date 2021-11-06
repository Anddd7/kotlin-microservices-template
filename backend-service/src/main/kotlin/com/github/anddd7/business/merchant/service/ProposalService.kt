package com.github.anddd7.business.merchant.service

import com.github.anddd7.business.common.Confirmation
import com.github.anddd7.business.common.Query
import com.github.anddd7.business.common.Request
import com.github.anddd7.business.common.RequestAndConfirmService
import com.github.anddd7.business.common.ToConfirmation
import com.github.anddd7.business.merchant.repository.Declaration
import com.github.anddd7.business.merchant.repository.DeclarationRepository
import com.github.anddd7.business.merchant.repository.MerchantAccountProposal
import com.github.anddd7.business.merchant.repository.MerchantAccountProposalRepository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class ProposalService(
    private val declarationRepository: DeclarationRepository,
    private val proposalRepository: MerchantAccountProposalRepository
) : RequestAndConfirmService<
    ProposalRequest,
    ProposalRequest,
    ProposalConfirmation,
    ProposalConfirmationResponse
    > {
    fun query(request: ProposalQuery) =
        ProposalQueryResult(declarationRepository.latest())

    override fun request(request: ProposalRequest) = request
    override fun confirm(confirmation: ProposalConfirmation): ProposalConfirmationResponse {
        return confirmation.run { MerchantAccountProposal(userId, declarationVersion, createdAt, expiredAt) }
            .let { proposalRepository.save(it) }
            .run { ProposalConfirmationResponse(id) }
    }

    // retrieve request/confirmation
    private fun getRequest(proposalId: String) =
        proposalRepository.get(proposalId)
            .run { ProposalRequest(userId, declarationVersion, createdAt) }

    private fun getConfirmation(proposalId: String) =
        proposalRepository.get(proposalId)
            .run { ProposalConfirmation(userId, declarationVersion, createdAt, expiredAt) }
}

class ProposalQuery : Query

data class ProposalQueryResult(
    val declaration: Declaration,
)

data class ProposalRequest(
    val userId: String,
    val declarationVersion: String,
    override val createdAt: Instant = Instant.now()
) : Request, ToConfirmation<ProposalConfirmation> {
    override fun toConfirmation() = ProposalConfirmation(userId, declarationVersion, createdAt)
}

data class ProposalConfirmation(
    val userId: String,
    val declarationVersion: String,
    override val createdAt: Instant,
    override val expiredAt: Instant = Instant.MAX
) : Confirmation

data class ProposalConfirmationResponse(
    val proposalId: String,
)
