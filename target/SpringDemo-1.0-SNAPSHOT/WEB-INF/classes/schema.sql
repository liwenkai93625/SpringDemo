create table Spittle(
    id identity,
    message VARCHAR(140) not null,
    created_at TIMESTAMP not null,
    latitude DOUBLE ,
    longtitude double,
    PRIMARY KEY (id)
);

create table Spitter (
    id identity,
    username VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(20) not NULL,
    first_name VARCHAR(30) not null,
    last_name VARCHAR(30) NOT NULL,
    email VARCHAR(30) not NULL,
    PRIMARY KEY (id)
);