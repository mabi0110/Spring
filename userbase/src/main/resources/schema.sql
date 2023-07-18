create table users (
    id bigint auto_increment primary key,
    first_name varchar(100),
    last_name varchar(100),
    age int
);

create table address (
    id bigint auto_increment primary key,
    city varchar(200),
    street varchar(200),
    home_no varchar(5),
    flat_no varchar(5)
);