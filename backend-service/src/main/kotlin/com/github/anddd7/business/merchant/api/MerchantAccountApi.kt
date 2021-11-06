package com.github.anddd7.business.merchant.api

import com.github.anddd7.business.merchant.service.ContractConfirmation
import com.github.anddd7.business.merchant.service.ContractRequest
import com.github.anddd7.business.merchant.service.ContractService
import com.github.anddd7.business.merchant.service.ProposalQuery
import com.github.anddd7.business.merchant.service.ProposalService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/merchant-account")
class MerchantAccountApi(
    private val proposalService: ProposalService,
    private val contractService: ContractService,
) {
    @GetMapping("/proposal")
    fun viewProposal() =
        proposalService.query(ProposalQuery())

    @PostMapping("/contract")
    fun issueContract(request: ContractRequest) =
        contractService.request(request)

    @PostMapping("/contract/{contractId}")
    fun ackContract(@PathVariable contractId: String, confirmation: ContractConfirmation) =
        contractService.confirm(contractId, confirmation)
}


