insert into authorities(authority)
values ( 'ROLE_USER' );
insert into authorities(authority)
values ( 'ROLE_ADMIN' );
insert into authorities(authority)
values ( 'ROLE_DEVELOPER' );

INSERT INTO users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, first_name, last_name, email_address, birthdate)
VALUES ('Developer', '$2a$12$2yOChyhSuJm/naTBUjGZb.6d6mu1NsXS8XWRFousQfRTwzy0ZQtWW'
       , true, true, true, true, 'Willy', 'De Keyser', 'wdkeyser@gmail.com', DATE('1990-01-01'));
INSERT INTO users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, first_name, last_name, email_address, birthdate)
VALUES ('Admin', '$2a$12$2yOChyhSuJm/naTBUjGZb.6d6mu1NsXS8XWRFousQfRTwzy0ZQtWW'
       , true, true, true, true, 'Walter', 'De Keyser', 'wdkeyser@gmail.com', DATE('1990-01-01'));
INSERT INTO users(username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled, first_name, last_name, email_address, birthdate)
VALUES ('User', '$2a$12$2yOChyhSuJm/naTBUjGZb.6d6mu1NsXS8XWRFousQfRTwzy0ZQtWW',
        true, true, true, true, 'Ken', 'De Keyser', 'wdkeyser@gmail.com', DATE('1990-01-01'));

INSERT INTO  users_authorities(users_id, authorities_id) VALUES ( 1, 1 );
INSERT INTO  users_authorities(users_id, authorities_id) VALUES ( 1, 2 );
INSERT INTO  users_authorities(users_id, authorities_id) VALUES ( 1, 3 );
INSERT INTO  users_authorities(users_id, authorities_id) VALUES ( 2, 1 );
INSERT INTO  users_authorities(users_id, authorities_id) VALUES ( 2, 2 );
INSERT INTO  users_authorities(users_id, authorities_id) VALUES ( 3, 1 );