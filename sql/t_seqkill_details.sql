create table t_seckill_details
(
 id                      int not null AUTO_INCREMENT                   comment '主键',
 productid               int not null default 0                        comment '产品id',
 merchantid              int not null default 0                        comment '商家id',
 productplace            varchar(50) not null default ''               comment '产地',
 productname             varchar(50) not null default ''               comment '商品名称',
 brandname               varchar(20) not null default ''               comment '品牌',
 productweight           float not null default 0.0                    comment '商品毛重',
 specification           varchar(200) not null default ''              comment '规格与包装',
 productdetailpicture    varchar(100) not null default ''              comment '商品详情图片',
 primary key(id)
)
engine=InnoDB default charset=utf8mb4 comment "秒杀商品详情";