-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-1');
-- insert into myentity (id, field) values(nextval('hibernate_sequence'), 'field-2');

insert into passagem (id, nome, origem, destinoFinal) values (nextval('hibernate_sequence'), 'Paulo', 'Palmas-TO', 'Brasília-DF');
insert into passagem (id, nome, origem, destinoFinal) values (nextval('hibernate_sequence'), 'Jânio', 'Palmas-TO', 'Brasília-DF');
insert into passagem (id, nome, origem, destinoFinal) values (nextval('hibernate_sequence'), 'Bruno', 'Palmas-TO', 'São Paulo-SP');
