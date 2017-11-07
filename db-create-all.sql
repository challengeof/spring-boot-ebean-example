create table user (
  id                            bigint auto_increment not null,
  username                      varchar(255),
  real_name                     varchar(255) not null,
  password                      varchar(255),
  salt                          varchar(255),
  registered                    datetime(6) comment 'The date the adminUser first registered',
  constraint uq_user_username unique (username),
  constraint pk_user primary key (id)
);

create index ix_user_username on user (username);
