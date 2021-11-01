package com.github.anddd7

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

// use ContextConfiguration to lock the application entry if found multiple @SpringBootApplication
@ContextConfiguration(classes = [KotlinSpringMultipleModulesApplication::class])
@WebMvcTest(value = [HelloController::class])
internal class HelloControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should print hello`() {
        mockMvc.get("/hello")
            .andExpect {
                status { isOk() }
                content { string("Hello, this is the root project") }
            }
    }
}
