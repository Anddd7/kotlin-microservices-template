package com.github.anddd7.business.merchant.api

import com.github.anddd7.business.merchant.service.ProposalService
import com.github.anddd7.business.merchant.service.request.ProposalRequest
import com.github.anddd7.business.merchant.service.request.ProposalRequestResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/merchant-account")
class MerchantAccountApi(
    private val proposalEventHandler: ProposalService
) {
    @GetMapping("proposal")
    fun proposal(): ProposalRequestResponse = proposalEventHandler.request(ProposalRequest())
}




