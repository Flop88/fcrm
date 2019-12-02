create table hibernate_sequence (next_val bigint) engine=InnoDB;

CREATE TABLE message
(
    id           int8 not null,
    client_name  varchar(255),
    client_phone varchar(255),
    first_date   varchar(255),
    order_active varchar(255),
    order_brand  varchar(255),
    order_device varchar(255),
    order_model  varchar(255),
    user_id bigint not null,
    primary key (id)
)
engine=InnoDB;

create table user_role (
    user_id  bigint not null,
    roles    varchar(255)
)
engine=InnoDB;

create table usr (
    id                   int8 not null,
    activation_code      varchar(255),
    active               boolean not null,
    email                varchar(255),
    password             varchar(255) not null,
    username             varchar(255) not null,
    primary key (id)
)

engine=InnoDB;

ALTER TABLE message add constraint message_user_fk
    FOREIGN KEY (user_id)
    REFERENCES usr (id);

ALTER TABLE user_role add constraint user_role_user_fk
    FOREIGN KEY (user_id)
    REFERENCES usr (id);
