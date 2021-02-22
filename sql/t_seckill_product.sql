-- ---------------------------------------------------------------------
-- 修改时间                |修改人                 |修改原因                
-- ---------------------------------------------------------------------
-- 2021-02-22             |肖勇博                 |创建表
-- ---------------------------------------------------------------------
CREATE TABLE t_seckill_product
(
  id                       int NOT NULL AUTO_INCREMENT                         COMMENT '����',
  productid                int NOT NULL DEFAULT '0'                            COMMENT '��Ʒid',
  producttitle             varchar(50) NOT NULL DEFAULT ''                     COMMENT '��Ʒ����',
  productpicture           varchar(50) NOT NULL DEFAULT ''                     COMMENT '��ƷͼƬ',
  originprice              decimal(10,2) NOT NULL DEFAULT '0.00'               COMMENT 'ԭ�۸�',
  merchantid               int NOT NULL DEFAULT '0'                            COMMENT '�̼�id',
  applydate                char(19) NOT NULL DEFAULT '1900-01-01 00:00:00'     COMMENT '��������',
  auditdate                char(19) NOT NULL DEFAULT '1900-01-01 00:00:00'     COMMENT '�޸�����',
  auditstate               int NOT NULL DEFAULT 0                              COMMENT '���״̬',
  starttime                char(19) NOT NULL DEFAULT '1900-01-01 00:00:00'     COMMENT '��ʼʱ��',
  endtime                  char(19) NOT NULL DEFAULT '1900-01-01 00:00:00'     COMMENT '����ʱ��',
  secprice                 decimal(10,2) NOT NULL DEFAULT '0.00'               COMMENT '��ɱ�۸�',
  productcount             int NOT NULL DEFAULT '0'                            COMMENT '��ɱ��Ʒ��',
  stockcount               int NOT NULL DEFAULT '0'                            COMMENT 'ʣ������',
  description              varchar(255) NOT NULL DEFAULT ''                    COMMENT '����',
  PRIMARY KEY (`id`)
) 
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 comment "秒杀商品表";