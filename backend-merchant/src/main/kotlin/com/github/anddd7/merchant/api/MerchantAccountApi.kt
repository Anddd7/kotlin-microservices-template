package com.github.anddd7.merchant.api

import com.github.anddd7.merchant.service.MerchantAccountService
import com.github.anddd7.merchant.domain.user.RegisteredUserService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/merchant-account")
class MerchantAccountApi(
    private val registeredUserService: RegisteredUserService,
    private val merchantAccountService: MerchantAccountService,
) {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create() {


    }
}
