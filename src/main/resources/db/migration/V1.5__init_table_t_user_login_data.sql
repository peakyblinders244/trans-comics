create table if not exists t_user_login_data (
    user_id varchar(50) primary key,
    login_name varchar(255) not null,
    password_salt int not null,
    password_hash varchar(255) not null,
    hash_algorithm_id varchar(20) not null,
    email_address varchar(255) not null,
    confirmation_token varchar(255) ,
    token_generation_time date,
    email_validation_status_id varchar(5),
    password_recovery_token varchar(255),
    recover_token_time date
);



