insert into role(id, name) values (1, 'USER')

insert into user(id, username, password, role_id) values (2, 'user', 123, 1)
insert into user(id, username, password) values (1, 'fake_user', 123)
