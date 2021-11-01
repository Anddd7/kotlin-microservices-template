package com.github.anddd7

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@Deprecated("用根项目启动时，runApplication不会传递此class信息，因此也会忽略掉该启动配置文件")
@SpringBootApplication
class CraftedGradleModuleApplication

fun main(args: Array<String>) {
    runApplication<CraftedGradleModuleApplication>(*args)
}
