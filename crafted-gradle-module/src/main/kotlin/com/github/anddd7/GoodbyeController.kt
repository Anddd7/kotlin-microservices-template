package com.github.anddd7

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping
class GoodbyeController {

    @GetMapping("/goodbye")
    fun goodbye() = "Goodbye, this is the crafted gradle module project"
}
