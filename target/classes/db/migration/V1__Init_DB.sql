CREATE TABLE message
(
    id           bigint AUTO_INCREMENT not null,
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
    id                   bigint AUTO_INCREMENT not null,
    activation_code      varchar(255),
    active               boolean not null,
    email                varchar(255),
    password             varchar(255) not null,
    username             varchar(255) not null,
    primary key (id)
)

engine=InnoDB;

alter table message
  add constraint message_user_fk
  foreign key (user_id) references usr (id);

alter table user_role
  add constraint user_role_user_fk
  foreign key (user_id) references usr (id);