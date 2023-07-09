insert into users(username, password, enabled)
values ( 'member', '{noop}member', true );
insert into users(username, password, enabled)
values ( 'admin', '{noop}admin', true );

insert into authorities(username, authority)
values ( 'member', 'ROLE_USER' );
insert into authorities(username, authority)
values ( 'admin', 'ROLE_USER' );
insert into authorities(username, authority)
values ( 'admin', 'ROLE_ADMIN' )
