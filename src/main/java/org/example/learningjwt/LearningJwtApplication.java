package org.example.learningjwt;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.example")
public class LearningJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningJwtApplication.class, args);
    }

}
