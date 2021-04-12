-- ---------------------------------------------------------------------
-- 修改时间                 修改人                   修改原因                
-- ---------------------------------------------------------------------
-- 2021-02-22             肖勇博                   创建表
-- 2021-03-16             肖勇博                   删除原主键，添加字段merchantid并设为主键
-- ---------------------------------------------------------------------

create table t_seckill_merchant
(
 merchantid              char(6) not null default ''                      comment '商家id',
 merchantname            varchar(20) not null default ''                  comment '商家姓名',
 merchantshopname        varchar(40) not null default ''                  comment '商家店铺名',
 merchantaccount         varchar(50) not null default ''                  comment '商家账号',
 merchantpassword        varchar(60) not null default ''                  comment '商家密码',
 merchantscope           varchar(600) not null default ''                 comment '商家经营范围',
 primary key(merchantid)
)
engine=InnoDB default charset=utf8mb4 comment "商家信息表";