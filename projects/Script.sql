create table if not exists users (
	user_id serial primary key,
	username VARCHAR(20) unique not null,
	password VARCHAR(30) not null,
	isAdmin boolean
);

select * from users where username = 'adam';

create table if not exists items (
	item_id serial primary key,
	itemname VARCHAR(20) unique not null,
	price int not null,
	payment int,
	offer int
);

select * from items;

alter table users add isManager int;

create table offers (
	user_id int references users (user_id),
	item_id int references items (item_id),
	offer int,
	offer_id serial primary key
);
alter table offers add status int;

update offers set status = 1 where offer_id = 3;

alter table items drop column offer;

create table payments (
	user_id int references users (user_id),
	item_id int references items (item_id),
	payment_id serial primary key,
	payment int,
	offer int
);
drop table users_items;
alter table items add payment int;

create table paymenthistory (
	history_id serial primary key,
	payment_id int references payments (payment_id),
	user_id int references users (user_id),
	paymentAmount int
);
alter table paymenthistory add currdate TIMESTAMP default CURRENT_TIMESTAMP;
select SUM(paymentamount) as w_sum_payment from paymenthistory where current_timestamp - interval '7 day' <= currdate;
alter table payments drop ownStatus;

create table ownedItems(
	user_id int,
	item_id int
);
alter table items drop column payment;


select itemname
from items i inner join 
owneditems o on i.item_id = o.item_id where user_id = 8;