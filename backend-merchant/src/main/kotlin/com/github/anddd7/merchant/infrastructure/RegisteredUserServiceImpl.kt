package com.github.anddd7.merchant.infrastructure

import com.github.anddd7.merchant.domain.user.RegisteredUser
import com.github.anddd7.merchant.domain.user.RegisteredUserService
import org.springframework.stereotype.Service

/**
 * It's the implement of the domain system('s interfaces), modify the implementation without effecting business system
 */
@Service
class RegisteredUserServiceImpl : RegisteredUserService {
    // from the header, jwt, or external api
    override fun getCurrentUser() = RegisteredUserImpl(
        "test-user",
        "password",
        "liaoad_space@sina.com",
        "Anddd7",
    )
}

data class RegisteredUserImpl(
    override val username: String,
    val password: String,
    val email: String,
    override val name: String,
) : RegisteredUser
