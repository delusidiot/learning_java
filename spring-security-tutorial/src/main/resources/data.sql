insert into authorities(authority)
values ( 'ROLE_USER' );
insert into authorities(authority)
values ( 'ROLE_ADMIN' );
insert into authorities(authority)
values ( 'ROLE_DEVELOPER' );

insert into users(username, password, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED)
values ( 'Developer', '$2y$07$ionwU9D46zj0UoZK2d9ki.EjFzzYAtd3CuFnxxM88m1CmpQ..qyw2', true, true, true, true );
insert into users(username, password, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED)
values ( 'Admin', '$2y$07$ionwU9D46zj0UoZK2d9ki.EjFzzYAtd3CuFnxxM88m1CmpQ..qyw2', true, true, true, true );
insert into users(username, password, ACCOUNT_NON_EXPIRED, ACCOUNT_NON_LOCKED, CREDENTIALS_NON_EXPIRED, ENABLED)
values ( 'User', '$2y$07$ionwU9D46zj0UoZK2d9ki.EjFzzYAtd3CuFnxxM88m1CmpQ..qyw2', true, true, true, true );

INSERT INTO  users_authorities(users_id, authorities_id) VALUES ( 1, 1 );
INSERT INTO  users_authorities(users_id, authorities_id) VALUES ( 1, 2 );
INSERT INTO  users_authorities(users_id, authorities_id) VALUES ( 1, 3 );
INSERT INTO  users_authorities(users_id, authorities_id) VALUES ( 2, 1 );
INSERT INTO  users_authorities(users_id, authorities_id) VALUES ( 2, 2 );
INSERT INTO  users_authorities(users_id, authorities_id) VALUES ( 3, 1 );