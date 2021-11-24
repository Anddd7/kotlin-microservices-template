package com.github.anddd7.merchant.service

import com.github.anddd7.merchant.domain.user.RegisteredUser
import com.github.anddd7.merchant.domain.user.RegisteredUserService
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import java.time.Instant

@Service
class MerchantAccountService(
    private val registeredUserService: RegisteredUserService,
    private val handler: MerchantAccountHandler,
) {
    fun create() {
        val currentUser = registeredUserService.getCurrentUser()
        val createAt = Instant.now()
        val command = CreateMerchantAccount(currentUser, createAt, createAt)
        handler.create(command)
    }
}

@Component
class MerchantAccountHandler(
    private val storage: MerchantAccountStorage
) {
    fun create(command: CreateMerchantAccount) {
        val entity = command.run {
            MerchantAccount(createdBy = user.name, createdAt = createAt, expiredAt = expiredAt)
        }
        storage.save(entity)
    }
}

interface MerchantAccountStorage {
    fun save(entity: MerchantAccount)
}

@Component
class MerchantAccountRepository: MerchantAccountStorage {
    override fun save(entity: MerchantAccount){
        // TODO save to db or memory
    }
}

interface Command
interface Entity

data class CreateMerchantAccount(
    val user: RegisteredUser,
    val createAt: Instant,
    val expiredAt: Instant,
) : Command

data class MerchantAccount(
    val id: Long = 0,
    val createdBy: String,
    val createdAt: Instant,
    val expiredAt: Instant,
) : Entity
