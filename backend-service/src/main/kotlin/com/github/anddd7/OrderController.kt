package com.github.anddd7

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.UUID

@RestController
@RequestMapping("/orders")
class OrderController {
    @GetMapping("/{id}")
    fun one(@PathVariable id: String): Order = Order(id, Instant.now())

    @GetMapping
    fun all(): List<Order> = listOf(
        Order(UUID.randomUUID().toString(), Instant.now()),
        Order(UUID.randomUUID().toString(), Instant.now()),
        Order(UUID.randomUUID().toString(), Instant.now()),
    )

    @PostMapping
    fun create(@RequestBody command: CreateOrderCommand) = command.id

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody order: Order) {
        println(order)
    }

    @PostMapping("/{path1}/{path2}")
    fun test(
        @PathVariable path1: String,
        @PathVariable path2: String,
        query1: String?,
        query2: String,
        @RequestBody order: Order
    ) {
        println(path1)
        println(path2)
        println(query1)
        println(query2)
        println(order)
    }
}

data class Order(
    val id: String,
    val createdAt: Instant,
)

data class CreateOrderCommand(
    val id: String,
)
