
INSERT INTO USERS (USERNAME, PASSWORD, email, role, enabled, verification_token) VALUES ('superadmin', '$2a$10$uy08U4tsYx4jX2R3bPsN3eeLYPocLsI.gypZGkTEePIouUjW0eWT.', 'foo@gmail.com', 0, 1, null);
INSERT INTO USERS (username, password, email, role, enabled, verification_token) VALUES ('superuser', '$2a$10$uy08U4tsYx4jX2R3bPsN3eeLYPocLsI.gypZGkTEePIouUjW0eWT.', 'foo2@gmail.com', 1, 1, null);

INSERT INTO PRODUCT (name, price, quantity, description) values ( 'foo1', 150.0, 10, 'a foo toy1' );
INSERT INTO PRODUCT (name, price, quantity, description) values ( 'foo2', 150.5, 10, 'a foo toy2' );
INSERT INTO PRODUCT (name, price, quantity, description) values ( 'foo3', 100.3, 10, 'a foo toy3' );