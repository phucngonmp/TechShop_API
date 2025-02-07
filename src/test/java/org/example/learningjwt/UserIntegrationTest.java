package org.example.learningjwt;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testValidatePassword_Valid() throws Exception {
        String requestBody = """
            {
                "username": "phucngune",
                "password": "Password!1",
                "email": "phuc@gmail.com"
            }
            """;
        mockMvc.perform(post("/user/register")
                        .content(requestBody)
                        .contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().string("create successfully"));
    }
}
