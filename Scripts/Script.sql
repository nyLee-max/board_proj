select user(),database();
create database login_web;
drop database login_web;

use login_web;

grant all 
on login_web.*
to 'user_login_web'@'localhost'
identified by 'rootroot';

create table login_web.users(
	uid int not null auto_increment,
	id varchar(12) not null unique comment '아이디', -- 아이디
	passwd char(41) not null comment '비밀번호', -- 비밀번호
	email varchar(60) comment '이메일', -- 이메일
	primary key (uid)
)
comment '사용자';

select * from users;