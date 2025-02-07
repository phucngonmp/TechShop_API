package org.example.learningjwt;

import org.example.learningjwt.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LearningJwtApplicationTests {

    @Autowired
    public UserController userController;

    @Test
    void contextLoads() {

    }

}
