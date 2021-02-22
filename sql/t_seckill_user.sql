-- ---------------------------------------------------------------------
-- 修改时间                |修改人                 |修改原因                
-- ---------------------------------------------------------------------
-- 2021-02-22             |肖勇博                 |创建表
-- ---------------------------------------------------------------------

create table t_seckill_user
(
 id                      int not null AUTO_INCREMENT                      comment '主键',
 username                varchar(20) not null default ''                  comment '用户名',
 useraccount             varchar(20) not null default ''                  comment '用户账号',
 userpassword            varchar(50) not null default ''                  comment '用户密码',
 usergender              char not null default '0'                        comment '用户性别',
 userage                 int not null default 0                           comment '用户年龄',
 useraddress             varchar(200) not null default ''                 comment '用户地址',
 useremail               varchar(40) not null default ''                  comment '用户邮箱',
 primary key(id)
)
engine=InnoDB default charset=utf8mb4 comment "秒杀用户表";