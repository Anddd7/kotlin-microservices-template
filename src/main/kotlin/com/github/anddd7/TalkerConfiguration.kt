package com.github.anddd7

import com.github.plugins.Talker
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TalkerConfiguration {
    @Bean
    fun talker() = object : Talker {
        override fun say(): String = "来自老板的问候"
    }
}
