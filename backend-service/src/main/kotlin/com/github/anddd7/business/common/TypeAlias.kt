package com.github.anddd7.business.common

import java.time.Instant

internal interface Query
internal interface Command

internal interface Request : Command {
    val createdAt: Instant
}

internal interface Confirmation : Command {
    val createdAt: Instant
    val expiredAt: Instant
}

internal interface ToConfirmation<C> {
    fun toConfirmation(): C
}

internal interface RequestAndConfirmService<R, RR : ToConfirmation<C>, C, CR> :
    RequestService<R, RR>, ConfirmationService<C, CR> {

    fun requestAndConfirm(request: R): CR = confirm(request(request).toConfirmation())
}

internal interface RequestService<R, RR> {
    fun request(request: R): RR = TODO()
}

internal interface ConfirmationService<C, CR> {
    fun confirm(confirmation: C): CR = TODO()
}

