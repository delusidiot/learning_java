# INSERT INTO authorities(authority) VALUES('ROLE_USER');
# INSERT INTO authorities(authority) VALUES('ROLE_ADMIN');
# INSERT INTO authorities(authority) VALUES('ROLE_DEVELOPER');
#
# INSERT INTO users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, first_name, last_name, email_address, birthdate) VALUES ('Developer', '$2y$07$jXb6ImhHU8alhu.GIqCRtu3zDwnVDDzHrcBkCyTYkeNzkPpFUmuPO', true, true, true, true, 'Willy', 'De Keyser', 'wdkeyser@gmail.com', DATE('1990-01-01'));
# INSERT INTO users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, first_name, last_name, email_address, birthdate) VALUES ('Admin', '$2y$07$h8ulIJo1Omk1i/oBz0DgGehVzH0sD9VajW9Aj6pzB3Bv0BS7U7Nse', true, true, true, true, 'Walter', 'De Keyser', 'wdkeyser@gmail.com', DATE('1990-01-01'));
# INSERT INTO users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, first_name, last_name, email_address, birthdate) VALUES ('User', '$2y$07$vtl8LHxQeQtilJUL3xfd3ez8O1WhPpgrUUR2Tj03gtIA6oTSyf46i', true, true, true, true, 'Ken', 'De Keyser', 'wdkeyser@gmail.com', DATE('1990-01-01'));
#
# INSERT INTO users_authorities(users_id, authorities_id) VALUES (1, 1);
# INSERT INTO users_authorities(users_id, authorities_id) VALUES (1, 2);
# INSERT INTO users_authorities(users_id, authorities_id) VALUES (1, 3);
# INSERT INTO users_authorities(users_id, authorities_id) VALUES (2, 1);
# INSERT INTO users_authorities(users_id, authorities_id) VALUES (2, 2);
# INSERT INTO users_authorities(users_id, authorities_id) VALUES (3, 1);