package com.github.anddd7.core

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class HelloController {
    @GetMapping
    fun hello() = "hello"
}
