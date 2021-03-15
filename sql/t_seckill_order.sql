-- ---------------------------------------------------------------------
-- 修改时间                |修改人                 |修改原因                
-- ---------------------------------------------------------------------
-- 2021-02-22            |肖勇博                  |创建表
-- 2021-03-15            |肖勇博                  |添加字段transquantity
-- ---------------------------------------------------------------------

CREATE TABLE t_seckill_order
(
  id                       int NOT NULL AUTO_INCREMENT                         COMMENT '主键',
  productid                int NOT NULL DEFAULT '0'                            COMMENT '商品id',
  payamount                DECIMAL(10,2) NOT NULL DEFAULT 0                    COMMENT '支付金额',
  userid                   int NOT NULL DEFAULT 0                              COMMENT '用户id',
  merchantid               int NOT NULL DEFAULT 0                              COMMENT '商家id',
  transquantity            int unsigned NOT NULL DEFAULT 0                     COMMENT '购买数量',
  createtime               datetime NOT NULL DEFAULT '1900-01-01 00:00:00'     COMMENT '创建日期',
  paytime                  datetime NOT NULL DEFAULT '1900-01-01 00:00:00'     COMMENT '支付日期',
  paystate                 int NOT NULL default 0                              COMMENT '支付状态',
  receivingaddress         varchar(50) NOT NULL DEFAULT ''                     COMMENT '收货地址',
  receivingphone           char(11) NOT NULL DEFAULT '00000000000'             COMMENT '收货人电话',
  receivingname            varchar(50) NOT NULL DEFAULT ''                     COMMENT '收货人名称',
  transserial              varchar(20) NOT NULL DEFAULT ''                     COMMENT '交易流水号',
  PRIMARY KEY (`id`)
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment "秒杀订单表";