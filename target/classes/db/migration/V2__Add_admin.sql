insert into usr (id, username, password, active)
    values (1, 'user', '$2a$08$Ct/qQjZqp8xp.PEjFBhJMuDkamClGgut8l91TGVi89Sa/ahapBAQO', true);

insert into user_role (user_id, roles)
    values (1, 'USER'), (1, 'ADMIN');