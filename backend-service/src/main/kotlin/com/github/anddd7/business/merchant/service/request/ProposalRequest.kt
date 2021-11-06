package com.github.anddd7.business.merchant.service.request

import com.github.anddd7.business.merchant.repository.Declaration

class ProposalRequest

data class ProposalRequestResponse(
    val declaration: Declaration,
)
