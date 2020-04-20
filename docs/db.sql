
drop table if exists platform_user;
create table `platform_user` (
    `id` int(11) not null auto_increment comment '主键id',
    `tenant_id` varchar(20) not null comment '租户id',
    `company_id` varchar(20) not null comment '公司id',
    `username` varchar(20) not null default '' comment '用户名',
    `password` varchar(64) not null comment '用户密码',
    `zh_name` varchar(20) not null default '' comment '用户中文姓名',
    `eng_name` varchar(20) not null default '' comment '用户英文姓名',
    `nick_name` varchar(20) not null default '' comment '用户昵称',
    `phone` varchar(11) not null default '' comment '手机号码',
    `email` varchar(30) not null default '' comment '邮箱',
    `gender` tinyint(2) default -1 comment '性别：1-男；0-女',
    `is_active` bit(1) not null default 1 comment '是否启用：1-启用；0-禁用',
    `creator_id` varchar(20) default '' comment '创建人id',
    `creation_time` datetime  not null default current_timestamp comment '创建时间',
    `modifier_id` varchar(20) default '' comment '修改人id',
    `modification_time` datetime  not null default current_timestamp comment '修改时间',
    `version` int(11) not null default 0 comment '版本号',
    -- 主键
    primary key (`id`),
    -- 索引
    index idx_query (`tenant_id`, `company_id`, `phone`, `email`)
) engine=innodb default charset=utf8mb4 comment='平台用户表';

truncate table platform_user;

insert into platform_user (tenant_id, company_id, username, phone, email, password, zh_name, eng_name, nick_name, gender) values
('tenant_000001', 'company_000001', 'user_000001', '15003770001', 'email1@163.com', '123456', '王 1', 'wang 1', '昵称 1', 1),
('tenant_000002', 'company_000002', 'user_000002', '15003770002', 'email2@163.com', '123456', '王 2', 'wang 2', '昵称 2', 0),
('tenant_000003', 'company_000003', 'user_000003', '15003770003', 'email3@163.com', '123456', '王 3', 'wang 3', '昵称 3', 1);
