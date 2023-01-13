drop table if exists orders;
drop table if exists product;
drop table if exists category;
create table category(id serial primary key, type varchar(25));
create table product(id serial primary key, name varchar(25), price float, category_id int references category(id));
create table orders(id serial primary key, product_id int references product(id), order_date date);
