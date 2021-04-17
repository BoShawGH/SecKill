-- ---------------------------------------------------------------------
-- 修改时间                |修改人                 |修改原因                
-- ---------------------------------------------------------------------
-- 2021-02-22             |肖勇博                 |创建表
-- 2021-03-16             肖勇博                   删除原主键，修改productid为主键
-- ---------------------------------------------------------------------
CREATE TABLE t_seckill_product
(
  productid                char(10) NOT NULL DEFAULT '0'                       COMMENT '商品id',
  merchantid               char(6) NOT NULL DEFAULT '0'                        COMMENT '商家id',
  producttitle             varchar(50) NOT NULL DEFAULT ''                     COMMENT '商品名',
  productpicture           varchar(50) NOT NULL DEFAULT ''                     COMMENT '商品图片',
  originprice              decimal(10,2) NOT NULL DEFAULT '0.00'               COMMENT '原价格',
  applydate                char(19) NOT NULL DEFAULT '1900-01-01 00:00:00'     COMMENT '申请日期',
  auditdate                char(19) NOT NULL DEFAULT '1900-01-01 00:00:00'     COMMENT '审核日期',
  auditstate               char(1) NOT NULL DEFAULT 0                          COMMENT '审核状态',
  starttime                char(19) NOT NULL DEFAULT '1900-01-01 00:00:00'     COMMENT '开始时间',
  endtime                  char(19) NOT NULL DEFAULT '1900-01-01 00:00:00'     COMMENT '结束时间',
  secprice                 decimal(10,2) NOT NULL DEFAULT '0.00'               COMMENT '秒杀价格',
  productcount             int NOT NULL DEFAULT '0'                            COMMENT '商品数量',
  stockcount               int NOT NULL DEFAULT '0'                            COMMENT '库存',
  description              varchar(255) NOT NULL DEFAULT ''                    COMMENT '简介',
  PRIMARY KEY (`productid`)
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment "秒杀商品表";