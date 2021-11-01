package com.github.plugins

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class TalkerAutoconfiguration {

    @Bean
    @ConditionalOnMissingBean(Talker::class)
    fun talker(): Talker = object : Talker {
        override fun say(): String = "我只是一个临时工"
    }
}
