-- 数据库canteen创建语句
drop database if exists cblog;
create database cblog
    default character set utf8mb4 collate utf8mb4_general_ci;

use cblog;

-- 创建相对应的数据库表
drop table if exists tb_user;
create table if not exists tb_user
(
    userId         int not null comment '用户id'
    primary key auto_increment,
    uname  varchar(20) null comment '用户名称',
    upwd   varchar(20) null comment '用户密码',
    nick   varchar(20) null comment '用户昵称',
    head   varchar(50) null comment '用户头像',
    mood   varchar(20) null comment '用户心情',
    create_time         datetime    null comment '创建时间'
    )
    comment '用户';
-- INSERT INTO canteen.canteen_customer ()
-- VALUES ();

drop table if exists tb_type;
create table if not exists tb_type
(
    typeId      int  not null comment '类型编号'
    primary key auto_increment,
    typeName    varchar(20)  null comment '类型名称',
    userId  	int  null comment '用户ID'
    )
    comment '类型';

drop table if exists tb_note;
create table if not exists tb_note
(
    noteId     int not null comment '云记Id'
    primary key auto_increment,
    title   varchar(20) null comment '标题',
    content  text null comment '内容',
    typeId   int null comment '类型ID',
    pubTime  datetime null comment '发布时间',
    lon     float null comment '经度',
    lat		float null comment '纬度'
    );
