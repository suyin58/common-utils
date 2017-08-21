CREATE TABLE `cust_level` (
`id`  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标准ID' ,
`customer_id`  varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '客户ID' ,
`level_id`  bigint(20) NULL DEFAULT 0 COMMENT '会员等级id' ,
`level_name`  varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '会员等级名称' ,
`modify_datetime`  decimal(13,0) NOT NULL DEFAULT 0 COMMENT '修改时间戳' ,
`hold_amount`  decimal(19,2) NOT NULL DEFAULT 0.00 COMMENT '持有金额' ,
`remark`  varchar(2000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '备注' ,
`max_hold_principle`  decimal(19,2) NOT NULL DEFAULT 0.00 COMMENT '历史最高持有本金' ,
`tx_date`  int(11) NOT NULL DEFAULT 0 COMMENT '统计日期' ,
`level_temp_id`  bigint(20) NULL DEFAULT NULL ,
`level_temp_name`  varchar(32) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL ,
`level_temp_start_date`  int(11) NULL DEFAULT NULL ,
`level_temp_end_date`  int(11) NULL DEFAULT NULL ,
PRIMARY KEY (`id`),
INDEX `idx_cust_level_custid` (`customer_id`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_bin
COMMENT='表备注'
AUTO_INCREMENT=418
ROW_FORMAT=COMPACT
;

