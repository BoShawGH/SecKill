-- ---------------------------------------------------------------------
-- 修改时间                |修改人                 |修改原因                
-- ---------------------------------------------------------------------
-- 2021-02-22            |肖勇博                  |创建表
-- 2021-03-15            |肖勇博                  |添加字段transquantity
-- 2021-03-16             肖勇博                   删除原主键，设置(productid,merchantid, transserial)为主键
-- ---------------------------------------------------------------------

CREATE TABLE t_seckill_order
(
  productid                char(10) NOT NULL DEFAULT '0'                       COMMENT '商品id',
  merchantid               char(6) NOT NULL DEFAULT ''                         COMMENT '商家id',
  transserial              varchar(20) NOT NULL DEFAULT ''                     COMMENT '交易流水号',
  userid                   char(10) NOT NULL DEFAULT ''                        COMMENT '用户id',
  payamount                DECIMAL(10,2) NOT NULL DEFAULT 0                    COMMENT '支付金额',
  transquantity            int unsigned NOT NULL DEFAULT 0                     COMMENT '购买数量',
  createtime               datetime NOT NULL DEFAULT '1900-01-01 00:00:00'     COMMENT '创建日期',
  paytime                  datetime NOT NULL DEFAULT '1900-01-01 00:00:00'     COMMENT '支付日期',
  paystate                 char(1) NOT NULL default 0                          COMMENT '支付状态',
  receivingaddress         varchar(50) NOT NULL DEFAULT ''                     COMMENT '收货地址',
  receivingphone           char(11) NOT NULL DEFAULT '00000000000'             COMMENT '收货人电话',
  receivingname            varchar(50) NOT NULL DEFAULT ''                     COMMENT '收货人名称',
  PRIMARY KEY (`productid`, `merchantid`, `transserial`)
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment "秒杀订单表";