package com.github.anddd7

import com.github.anddd7.client.orders.OrderControllerApi
import com.github.anddd7.client.orders.dto.CreateOrderCommand
import com.github.anddd7.client.orders.dto.Order
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/orders")
@RestController
class OrderEndpoint(
    private val orderControllerApi: OrderControllerApi
) {
    @GetMapping("/{id}")
    fun one(@PathVariable id: String) = orderControllerApi.one(id)

    @GetMapping
    fun all(): List<Order> = orderControllerApi.all()

    @PostMapping
    fun create(@RequestBody command: CreateOrderCommand) = orderControllerApi.create(command)

    @PostMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody order: Order) = orderControllerApi.update(id, order)

    @PostMapping("/{path1}/{path2}")
    fun test(
        @PathVariable path1: String,
        @PathVariable path2: String,
        query1: String?,
        query2: String,
        @RequestBody order: Order
    ) = orderControllerApi.test(path1, path2, query1, query2, order)
}
