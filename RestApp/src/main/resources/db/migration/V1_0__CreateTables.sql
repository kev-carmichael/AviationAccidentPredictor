DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS simulation;

CREATE TABLE user
(
    user_id integer primary key auto_increment,
    email varchar(50) not null
);

CREATE TABLE simulation
(
    simulation_id integer primary key auto_increment,
    last_input varchar(50) not null,
    #user integer not null,
    age_aircraft integer not null,
    no_of_passengers integer not null,
    pic_licence varchar(50) not null,
    pic_age integer not null,
    total_hrs integer not null,
    type_hrs integer not null,
    ninety_day_hrs integer not null,
    twenty_eight_day_hrs integer not null,
    day_of_week varchar(10),
    accident_severity varchar(50),
    injury_severity varchar(50)
);

INSERT INTO user (email)
VALUES ('adam@gmail.com'),
       ('bob@gmail.com'),
       ('colin@gmail.com');

INSERT INTO simulation (last_input, age_aircraft, no_of_passengers, pic_licence, pic_age, total_hrs, type_hrs, ninety_day_hrs, twenty_eight_day_hrs, day_of_week, accident_severity, injury_severity)
VALUES ('2023-01-01 01:11:11', 15, 0, 'student', 21, 35, 35, 24, 8, null, 'non-severe', null),
       ('2023-02-02 02:22:22', 25, 1, 'airline transport pilot licence', 52, 10000, 2, 180, 60, null, 'severe', null),
       ('2023-03-03 03:33:33', 35, 1, 'private pilot licence', 67, 3000, 2100, 24, 8, null, 'non-severe', null);