package com.github.plugins

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * 通过spring.factories直接注册这个controller
 * 通过spring.factories + AutoConfiguration选择性加载Talker这个Bean，实现底层服务的动态替换
 */
@RestController
@RequestMapping
class StarterController(
    private val talker: Talker,
) {

    @GetMapping("/starter")
    fun goodbye() = "Hello, this is the starter project: ${talker.say()}"
}

interface Talker {
    fun say(): String
}
