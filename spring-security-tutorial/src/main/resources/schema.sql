create table authorities (
    id bigint not null auto_increment,
    authority varchar(255),
    primary key (id)
) engine=InnoDB;

create table users (
    account_non_expired bit,
    account_non_locked bit,
    credentials_non_expired bit,
    enabled bit,
    id bigint not null auto_increment,
    password varchar(255),
    username varchar(255),
    primary key (id)
) engine=InnoDB;

create table users_authorities (
    authorities_id bigint not null,
    users_id bigint not null,
    primary key (authorities_id, users_id)
) engine=InnoDB;

alter table authorities
add constraint uniqueAuthority unique (authority);

alter table users
add constraint uniqueUsername unique (username);

alter table users_authorities
add constraint FK_authorities_id
foreign key (authorities_id)
references authorities (id);

alter table users_authorities
add constraint FK_user_id
foreign key (users_id)
references users (id);