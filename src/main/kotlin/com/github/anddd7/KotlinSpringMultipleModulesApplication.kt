package com.github.anddd7

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinSpringMultipleModulesApplication

fun main(args: Array<String>) {
    runApplication<KotlinSpringMultipleModulesApplication>(*args)
}

