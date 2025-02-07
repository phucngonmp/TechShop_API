CREATE TABLE IF NOT EXISTS "USERS" (
                                       ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       USERNAME VARCHAR(255) NOT NULL,
                                       PASSWORD VARCHAR(255) NOT NULL,
                                        EMAIL VARCHAR(255) NOT NULL,
                                        ROLE INT NOT NULL
);

