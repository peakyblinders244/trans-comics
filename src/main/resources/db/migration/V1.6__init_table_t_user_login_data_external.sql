create table if not exists t_user_login_data_external (
    id serial primary key,
    user_id varchar(50),
    external_provider_id varchar(50),
    external_provider_token varchar(255)
);



