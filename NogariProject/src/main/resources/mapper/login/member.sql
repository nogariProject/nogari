create table members (
  id bigint not null auto_increment,
  user_id varchar(255) unique,
  name varchar(255),
  password varchar(255),
  primary key(id)   
);