package com.github.anddd7.merchant.api

import com.github.anddd7.merchant.service.MerchantAccountService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/merchant-account")
class MerchantAccountApi(
    private val merchantAccountService: MerchantAccountService,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create() {
        merchantAccountService.create()
    }
}

