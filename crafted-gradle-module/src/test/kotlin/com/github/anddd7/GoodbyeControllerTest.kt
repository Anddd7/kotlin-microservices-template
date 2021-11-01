package com.github.anddd7

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(value = [GoodbyeController::class])
internal class GoodbyeControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should print goodbye`() {
        mockMvc.get("/goodbye")
            .andExpect {
                status { isOk() }
                content { string("Goodbye, this is the crafted gradle module project") }
            }
    }
}
