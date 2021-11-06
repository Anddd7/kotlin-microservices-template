package com.github.anddd7.business.merchant.service

import com.github.anddd7.business.merchant.repository.DeclarationRepository
import com.github.anddd7.business.merchant.service.request.ProposalRequest
import com.github.anddd7.business.merchant.service.request.ProposalRequestResponse
import org.springframework.stereotype.Service

@Service
class ProposalService(
    private val declarationRepository: DeclarationRepository,
) {
    fun request(request: ProposalRequest): ProposalRequestResponse = ProposalRequestResponse(
        declarationRepository.latest()
    )
}
