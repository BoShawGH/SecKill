-- ---------------------------------------------------------------------
-- 修改时间                |修改人                 |修改原因                
-- ---------------------------------------------------------------------
-- 2021-02-22             |肖勇博                 |创建表
-- 2021-03-16             肖勇博                   删除原主键，设置字段productid为主键
-- ---------------------------------------------------------------------

create table t_seckill_details
(
 productid               char(10) not null default 0                   comment '产品id',
 merchantid              char(6) not null default 0                    comment '商家id',
 productplace            varchar(50) not null default ''               comment '产地',
 productname             varchar(50) not null default ''               comment '商品名称',
 brandname               varchar(20) not null default ''               comment '品牌',
 productweight           float not null default 0.0                    comment '商品毛重',
 specification           varchar(200) not null default ''              comment '规格与包装',
 productdetailpicture    varchar(100) not null default ''              comment '商品详情图片',
 primary key(productid)
)
engine=InnoDB default charset=utf8mb4 comment "秒杀商品详情";