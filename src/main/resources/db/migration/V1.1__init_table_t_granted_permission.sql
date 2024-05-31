create table if not exists t_granted_permission (
    granted_permission_id serial primary key,
    role_id varchar(50) not null,
    permission_id varchar(50) not null
);



