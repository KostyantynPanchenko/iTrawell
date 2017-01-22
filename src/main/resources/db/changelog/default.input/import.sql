--liquibase formatted sql
--changeset Kostyantyn.Panchenko:2017-01-22-01

INSERT INTO visitors(id, name, password, email, created) VALUES(1, 'superuser', 'Super:P4ssw0rd', 'yougetit@ukr.net', '1983-04-26 05:55:00');
INSERT INTO visitors(id, name, password, email, created) VALUES(2, 'admin', 'admin', 'youget@ukr.net', '1983-04-26 05:55:00');
INSERT INTO visitors(id, name, password, email, created) VALUES(3, 'Jim Beam', 'jimbeam', 'jimbeam@ukr.net', '1983-04-26 05:55:00');
INSERT INTO visitors(id, name, password, email, created) VALUES(4, 'Jose Cuervo', 'josecuervo', 'josecuervo@ukr.net', '1983-04-26 05:55:00');
INSERT INTO visitors(id, name, password, email, created) VALUES(5, 'Sovignon Blank', 'sovignonblanc', 'sovignonblanc@ukr.net', '1983-04-26 05:55:00');

INSERT INTO posts(id, title, content, country, region, city, created, image_id) VALUES(1, 'When the sun is on your side', 'Mauris neque quam, fermentum ut nisl vitae, convallis maximus nisl. Sed mattis nunc id lorem euismod placerat. Vivamus porttitor magna enim, ac accumsan tortor cursus at. Phasellus sed ultricies mi non congue ullam corper. Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.', 'Sweden', 'Stockholm County', 'Stockholm', '2016-08-20 12:00:00', 1);
INSERT INTO posts(id, title, content, country, region, city, created, image_id) VALUES(2, 'Кожному своє', 'Mauris neque quam, fermentum ut nisl vitae, convallis maximus nisl. Sed mattis nunc id lorem euismod placerat. Vivamus porttitor magna enim, ac accumsan tortor cursus at. Phasellus sed ultricies mi non congue ullam corper. Praesent tincidunt sed tellus ut rutrum. Sed vitae justo condimentum, porta lectus vitae, ultricies congue gravida diam non fringilla.', 'Poland', 'Lesser Poland Voivodeship', 'Krakow', '2016-06-27 12:00:00', 2);

INSERT INTO images(id, data) VALUES(1, LOAD_FILE('D:/workspace/iTrawell/src/main/resources/static/img/img_stockholm.jpg'));
INSERT INTO images(id, data) VALUES(2, LOAD_FILE('D:/workspace/iTrawell/src/main/resources/static/img/img_krakov.jpg'));

INSERT INTO comments(id, content, author_id, post_id, created) VALUES(1, 'Fantastic story!', 3, 1, '2017-01-22 14:04:56');
INSERT INTO comments(id, content, author_id, post_id, created) VALUES(2, 'You should visit Mexico :)', 4, 1, '2017-01-22 14:08:23');
