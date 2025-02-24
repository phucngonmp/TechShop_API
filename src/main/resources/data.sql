
INSERT INTO USERS (USERNAME, PASSWORD, email, role, enabled, verification_token) VALUES ('superadmin', '$2a$10$uy08U4tsYx4jX2R3bPsN3eeLYPocLsI.gypZGkTEePIouUjW0eWT.', 'foo@gmail.com', 0, 1, null);
INSERT INTO USERS (username, password, email, role, enabled, verification_token) VALUES ('superuser', '$2a$10$uy08U4tsYx4jX2R3bPsN3eeLYPocLsI.gypZGkTEePIouUjW0eWT.', 'foo2@gmail.com', 1, 1, null);
INSERT INTO USERS (username, password, email, role, enabled, verification_token) VALUES ('superuser2', '$2a$10$uy08U4tsYx4jX2R3bPsN3eeLYPocLsI.gypZGkTEePIouUjW0eWT.', 'foo3@gmail.com', 1, 1, null);

INSERT INTO CATEGORY (id, name) values ( 1, 'laptop');
INSERT INTO CATEGORY (id, name) values ( 2, 'phone');
INSERT INTO CATEGORY (id, name) values ( 3, 'watch');

INSERT INTO PRODUCT (name, price, quantity, description, category_id) values ( 'foo1', 150.0, 10, 'a foo toy1', 1 );
INSERT INTO PRODUCT (name, price, quantity, description, category_id) values ( 'foo2', 150.5, 10, 'a foo toy2', 2 );
INSERT INTO PRODUCT (name, price, quantity, description, category_id) values ( 'foo3', 100.3, 10, 'a foo toy3', 3 );


INSERT INTO CART (total_price, user_id) values ( 300, 2);
INSERT INTO CART (total_price, user_id) values ( 400.8, 3);

INSERT INTO CART_ITEM (product_id, quantity, cart_id) values ( 1, 2, 1);
INSERT INTO CART_ITEM (product_id, quantity, cart_id) values ( 1, 1, 2);
INSERT INTO CART_ITEM (product_id, quantity, cart_id) values ( 2, 1, 2);
INSERT INTO CART_ITEM (product_id, quantity, cart_id) values ( 3, 1, 2);