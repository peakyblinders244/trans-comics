create table if not exists t_token (
    id varchar(255) primary key,
    token varchar(255),
    user_id varchar(255),
    token_type varchar(255),
    revoked boolean,
    expired boolean
);



