-- ---------------------------------------------------------------------
-- 修改时间                |修改人                 |修改原因                
-- ---------------------------------------------------------------------
-- 2021-02-22             |肖勇博                 |创建表
-- ---------------------------------------------------------------------

create table t_seckill_merchant
(
 id                      int not null AUTO_INCREMENT                      comment '主键',
 merchantname            varchar(20) not null default ''                  comment '商家姓名',
 merchantshopname        varchar(40) not null default ''                  comment '商家店铺名',
 merchantaccount         varchar(50) not null default ''                  comment '商家账号',
 merchantpassword        varchar(60) not null default ''                  comment '商家密码',
 merchantscope           varchar(600) not null default ''                 comment '商家经营范围',
 primary key(id)
)
engine=InnoDB default charset=utf8mb4 comment "商家信息表";