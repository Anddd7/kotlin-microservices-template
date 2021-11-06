package com.github.anddd7.business.common

import java.time.Instant

internal interface Query
internal interface Request : Command {
    val createdAt: Instant
}

internal interface Confirmation : Command {
    val createdAt: Instant
    val expiredAt: Instant
}

internal interface Command

internal interface ContractService<R, RR, C, CR> {
    fun request(request: R): RR
    fun confirmation(confirmation: C): CR
}
