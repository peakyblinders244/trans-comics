create table if not exists t_user_account (
    user_id varchar(50) primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    gender varchar(10) not null,
    date_of_birth date not null,
    role_id varchar(50)
);



