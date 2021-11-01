package com.github.anddd7

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class HelloController {

    @GetMapping("/hello")
    fun hello() = "Hello, this is the root project"
}
