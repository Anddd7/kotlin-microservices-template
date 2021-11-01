package com.github.anddd7

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Deprecated("会被根项目下同名类所覆盖")
@RestController
@RequestMapping
class HelloController {

    @GetMapping("/hello")
    fun hello() = "Hello, this is the crafted gradle module project"
}
