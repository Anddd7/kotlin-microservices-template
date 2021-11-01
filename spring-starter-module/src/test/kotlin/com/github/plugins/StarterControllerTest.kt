package com.github.plugins

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@Import(TalkerAutoconfiguration::class)
@WebMvcTest(value = [StarterController::class])
internal class StarterControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `should print starter`() {
        mockMvc.get("/starter")
            .andExpect {
                status { isOk() }
                content { string("Hello, this is the starter project: 我只是一个临时工") }
            }
    }
}
