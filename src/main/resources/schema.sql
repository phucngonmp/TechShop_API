CREATE TABLE IF NOT EXISTS "USERS" (
                                        ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        USERNAME VARCHAR(255) NOT NULL,
                                        PASSWORD VARCHAR(255) NOT NULL,
                                        EMAIL VARCHAR(255) NOT NULL,
                                        ENABLED BOOLEAN NOT NULL,
                                        VERIFICATION_TOKEN VARCHAR(255),
                                        ROLE INT NOT NULL
);

CREATE TABLE IF NOT EXISTS CATEGORY (
                                       ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       NAME VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS PRODUCT (
                                       ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       NAME VARCHAR(255) NOT NULL,
                                       PRICE FLOAT NOT NULL,
                                       QUANTITY INT NOT NULL,
                                       DESCRIPTION VARCHAR(1000),
                                       CATEGORY_ID BIGINT,
                                       CONSTRAINT fk_category FOREIGN KEY (CATEGORY_ID) REFERENCES CATEGORY(ID)
);

