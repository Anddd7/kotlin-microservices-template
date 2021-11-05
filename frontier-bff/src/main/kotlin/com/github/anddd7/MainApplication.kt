package com.github.anddd7

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
internal class MainApplication

fun main() {
    runApplication<MainApplication>()
}
