drop table if exists op CASCADE;
create table op
(
id integer auto_increment,
colour varchar (255),
engine_size double,
manufacturer varchar (255),
mileage integer not null,
model varchar (255),
year_manufactured integer not null,
primary key (id)
);