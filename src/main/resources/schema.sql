CREATE TABLE IF NOT EXISTS "USERS" (
                                        ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        USERNAME VARCHAR(255) NOT NULL,
                                        PASSWORD VARCHAR(255) NOT NULL,
                                        EMAIL VARCHAR(255) NOT NULL,
                                        ENABLED BOOLEAN NOT NULL,
                                        VERIFICATION_TOKEN VARCHAR(255),
                                        ROLE INT NOT NULL
);

