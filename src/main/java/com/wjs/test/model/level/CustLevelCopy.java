package com.wjs.test.model.level;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

public class CustLevelCopy implements Serializable {
    /**
     * 标准ID -- cust_level_copy.id
     * 
     */
    private Long id;

    /**
     * 客户ID(网金所) -- cust_level_copy.customer_id
     * 
     */
    private String customerId;

    /**
     * 会员等级id -- cust_level_copy.level_id
     * 
     */
    private Long levelId;

    /**
     * 会员等级名称 -- cust_level_copy.level_name
     * 
     */
    private String levelName;

    /**
     * 持有金额 -- cust_level_copy.hold_amount
     * 
     */
    private BigDecimal holdAmount;

    /**
     * 备注 -- cust_level_copy.remark
     * 
     */
    private String remark;

    /**
     * 历史最高持有本金 -- cust_level_copy.max_hold_principle
     * 
     */
    private BigDecimal maxHoldPrinciple;

    /**
     * 修改时间戳 -- cust_level_copy.modify_datetime
     * 
     */
    private Date modifyDatetime;

    /**
     * cust_level_copy表的操作属性:serialVersionUID
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 数据字段 cust_level_copy.id的get方法 
     * 
     */
    public Long getId() {
        return id;
    }

    /**
     * 数据字段 cust_level_copy.id的set方法
     * 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 数据字段 cust_level_copy.customer_id的get方法 
     * 
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 数据字段 cust_level_copy.customer_id的set方法
     * 
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    /**
     * 数据字段 cust_level_copy.level_id的get方法 
     * 
     */
    public Long getLevelId() {
        return levelId;
    }

    /**
     * 数据字段 cust_level_copy.level_id的set方法
     * 
     */
    public void setLevelId(Long levelId) {
        this.levelId = levelId;
    }

    /**
     * 数据字段 cust_level_copy.level_name的get方法 
     * 
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * 数据字段 cust_level_copy.level_name的set方法
     * 
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName == null ? null : levelName.trim();
    }

    /**
     * 数据字段 cust_level_copy.hold_amount的get方法 
     * 
     */
    public BigDecimal getHoldAmount() {
        return holdAmount;
    }

    /**
     * 数据字段 cust_level_copy.hold_amount的set方法
     * 
     */
    public void setHoldAmount(BigDecimal holdAmount) {
        this.holdAmount = holdAmount;
    }

    /**
     * 数据字段 cust_level_copy.remark的get方法 
     * 
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 数据字段 cust_level_copy.remark的set方法
     * 
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 数据字段 cust_level_copy.max_hold_principle的get方法 
     * 
     */
    public BigDecimal getMaxHoldPrinciple() {
        return maxHoldPrinciple;
    }

    /**
     * 数据字段 cust_level_copy.max_hold_principle的set方法
     * 
     */
    public void setMaxHoldPrinciple(BigDecimal maxHoldPrinciple) {
        this.maxHoldPrinciple = maxHoldPrinciple;
    }

    /**
     * 数据字段 cust_level_copy.modify_datetime的get方法 
     * 
     */
    public Date getModifyDatetime() {
        return modifyDatetime;
    }

    /**
     * 数据字段 cust_level_copy.modify_datetime的set方法
     * 
     */
    public void setModifyDatetime(Date modifyDatetime) {
        this.modifyDatetime = modifyDatetime;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}