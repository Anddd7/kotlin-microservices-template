package com.github.anddd7.merchant.domain.user

/**
 * It's a interface of User Management System, provide needed data to business service
 */
interface RegisteredUserService {
    fun getCurrentUser(): RegisteredUser
}

interface RegisteredUser {
    val username: String
    val name: String
}
