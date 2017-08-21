package com.wjs.member.model.level;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustLevelCriteria {
    /**
     * cust_level表的操作属性:orderByClause
     * 创建时间 : 2017-04-13 15:30:44
     */
    protected String orderByClause;

    /**
     * cust_level表的操作属性:start
     * 创建时间 : 2017-04-13 15:30:44
     */
    protected int start;

    /**
     * cust_level表的操作属性:limit
     * 创建时间 : 2017-04-13 15:30:44
     */
    protected int limit;

    /**
     * cust_level表的操作属性:distinct
     * 创建时间 : 2017-04-13 15:30:44
     */
    protected boolean distinct;

    /**
     * cust_level表的操作属性:oredCriteria
     * 创建时间 : 2017-04-13 15:30:44
     */
    protected List<Criteria> oredCriteria;

    /**
     * cust_level数据表的操作方法: CustLevelCriteria  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public CustLevelCriteria() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * cust_level数据表的操作方法: setOrderByClause  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * cust_level数据表的操作方法: getOrderByClause  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * cust_level数据表的操作方法: setStart  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * cust_level数据表的操作方法: getStart  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public int getStart() {
        return start;
    }

    /**
     * cust_level数据表的操作方法: setLimit  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public void setLimit(int limit) {
        this.limit = limit;
    }

    /**
     * cust_level数据表的操作方法: getLimit  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public int getLimit() {
        return limit;
    }

    /**
     * cust_level数据表的操作方法: setDistinct  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * cust_level数据表的操作方法: isDistinct  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * cust_level数据表的操作方法: getOredCriteria  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * cust_level数据表的操作方法: or  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * cust_level数据表的操作方法: or  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * cust_level数据表的操作方法: createCriteria  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * cust_level数据表的操作方法: createCriteriaInternal  
     * 创建时间 : 2017-04-13 15:30:44
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * cust_level数据表的操作方法: clear  
     * 创建时间 : 2017-04-13 15:30:44
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * cust_level表的操作类
     * 创建时间 : 2017-04-13 15:30:44
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNull() {
            addCriterion("customer_id is null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIsNotNull() {
            addCriterion("customer_id is not null");
            return (Criteria) this;
        }

        public Criteria andCustomerIdEqualTo(String value) {
            addCriterion("customer_id =", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotEqualTo(String value) {
            addCriterion("customer_id <>", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThan(String value) {
            addCriterion("customer_id >", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdGreaterThanOrEqualTo(String value) {
            addCriterion("customer_id >=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThan(String value) {
            addCriterion("customer_id <", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLessThanOrEqualTo(String value) {
            addCriterion("customer_id <=", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdLike(String value) {
            addCriterion("customer_id like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotLike(String value) {
            addCriterion("customer_id not like", value, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdIn(List<String> values) {
            addCriterion("customer_id in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotIn(List<String> values) {
            addCriterion("customer_id not in", values, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdBetween(String value1, String value2) {
            addCriterion("customer_id between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andCustomerIdNotBetween(String value1, String value2) {
            addCriterion("customer_id not between", value1, value2, "customerId");
            return (Criteria) this;
        }

        public Criteria andLevelIdIsNull() {
            addCriterion("level_id is null");
            return (Criteria) this;
        }

        public Criteria andLevelIdIsNotNull() {
            addCriterion("level_id is not null");
            return (Criteria) this;
        }

        public Criteria andLevelIdEqualTo(Long value) {
            addCriterion("level_id =", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotEqualTo(Long value) {
            addCriterion("level_id <>", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdGreaterThan(Long value) {
            addCriterion("level_id >", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("level_id >=", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdLessThan(Long value) {
            addCriterion("level_id <", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdLessThanOrEqualTo(Long value) {
            addCriterion("level_id <=", value, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdIn(List<Long> values) {
            addCriterion("level_id in", values, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotIn(List<Long> values) {
            addCriterion("level_id not in", values, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdBetween(Long value1, Long value2) {
            addCriterion("level_id between", value1, value2, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelIdNotBetween(Long value1, Long value2) {
            addCriterion("level_id not between", value1, value2, "levelId");
            return (Criteria) this;
        }

        public Criteria andLevelNameIsNull() {
            addCriterion("level_name is null");
            return (Criteria) this;
        }

        public Criteria andLevelNameIsNotNull() {
            addCriterion("level_name is not null");
            return (Criteria) this;
        }

        public Criteria andLevelNameEqualTo(String value) {
            addCriterion("level_name =", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameNotEqualTo(String value) {
            addCriterion("level_name <>", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameGreaterThan(String value) {
            addCriterion("level_name >", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameGreaterThanOrEqualTo(String value) {
            addCriterion("level_name >=", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameLessThan(String value) {
            addCriterion("level_name <", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameLessThanOrEqualTo(String value) {
            addCriterion("level_name <=", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameLike(String value) {
            addCriterion("level_name like", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameNotLike(String value) {
            addCriterion("level_name not like", value, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameIn(List<String> values) {
            addCriterion("level_name in", values, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameNotIn(List<String> values) {
            addCriterion("level_name not in", values, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameBetween(String value1, String value2) {
            addCriterion("level_name between", value1, value2, "levelName");
            return (Criteria) this;
        }

        public Criteria andLevelNameNotBetween(String value1, String value2) {
            addCriterion("level_name not between", value1, value2, "levelName");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeIsNull() {
            addCriterion("modify_datetime is null");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeIsNotNull() {
            addCriterion("modify_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeEqualTo(Long value) {
            addCriterion("modify_datetime =", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeNotEqualTo(Long value) {
            addCriterion("modify_datetime <>", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeGreaterThan(Long value) {
            addCriterion("modify_datetime >", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeGreaterThanOrEqualTo(Long value) {
            addCriterion("modify_datetime >=", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeLessThan(Long value) {
            addCriterion("modify_datetime <", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeLessThanOrEqualTo(Long value) {
            addCriterion("modify_datetime <=", value, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeIn(List<Long> values) {
            addCriterion("modify_datetime in", values, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeNotIn(List<Long> values) {
            addCriterion("modify_datetime not in", values, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeBetween(Long value1, Long value2) {
            addCriterion("modify_datetime between", value1, value2, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andModifyDatetimeNotBetween(Long value1, Long value2) {
            addCriterion("modify_datetime not between", value1, value2, "modifyDatetime");
            return (Criteria) this;
        }

        public Criteria andHoldAmountIsNull() {
            addCriterion("hold_amount is null");
            return (Criteria) this;
        }

        public Criteria andHoldAmountIsNotNull() {
            addCriterion("hold_amount is not null");
            return (Criteria) this;
        }

        public Criteria andHoldAmountEqualTo(BigDecimal value) {
            addCriterion("hold_amount =", value, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountNotEqualTo(BigDecimal value) {
            addCriterion("hold_amount <>", value, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountGreaterThan(BigDecimal value) {
            addCriterion("hold_amount >", value, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hold_amount >=", value, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountLessThan(BigDecimal value) {
            addCriterion("hold_amount <", value, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hold_amount <=", value, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountIn(List<BigDecimal> values) {
            addCriterion("hold_amount in", values, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountNotIn(List<BigDecimal> values) {
            addCriterion("hold_amount not in", values, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hold_amount between", value1, value2, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andHoldAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hold_amount not between", value1, value2, "holdAmount");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andMaxHoldPrincipleIsNull() {
            addCriterion("max_hold_principle is null");
            return (Criteria) this;
        }

        public Criteria andMaxHoldPrincipleIsNotNull() {
            addCriterion("max_hold_principle is not null");
            return (Criteria) this;
        }

        public Criteria andMaxHoldPrincipleEqualTo(BigDecimal value) {
            addCriterion("max_hold_principle =", value, "maxHoldPrinciple");
            return (Criteria) this;
        }

        public Criteria andMaxHoldPrincipleNotEqualTo(BigDecimal value) {
            addCriterion("max_hold_principle <>", value, "maxHoldPrinciple");
            return (Criteria) this;
        }

        public Criteria andMaxHoldPrincipleGreaterThan(BigDecimal value) {
            addCriterion("max_hold_principle >", value, "maxHoldPrinciple");
            return (Criteria) this;
        }

        public Criteria andMaxHoldPrincipleGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_hold_principle >=", value, "maxHoldPrinciple");
            return (Criteria) this;
        }

        public Criteria andMaxHoldPrincipleLessThan(BigDecimal value) {
            addCriterion("max_hold_principle <", value, "maxHoldPrinciple");
            return (Criteria) this;
        }

        public Criteria andMaxHoldPrincipleLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_hold_principle <=", value, "maxHoldPrinciple");
            return (Criteria) this;
        }

        public Criteria andMaxHoldPrincipleIn(List<BigDecimal> values) {
            addCriterion("max_hold_principle in", values, "maxHoldPrinciple");
            return (Criteria) this;
        }

        public Criteria andMaxHoldPrincipleNotIn(List<BigDecimal> values) {
            addCriterion("max_hold_principle not in", values, "maxHoldPrinciple");
            return (Criteria) this;
        }

        public Criteria andMaxHoldPrincipleBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_hold_principle between", value1, value2, "maxHoldPrinciple");
            return (Criteria) this;
        }

        public Criteria andMaxHoldPrincipleNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_hold_principle not between", value1, value2, "maxHoldPrinciple");
            return (Criteria) this;
        }

        public Criteria andTxDateIsNull() {
            addCriterion("tx_date is null");
            return (Criteria) this;
        }

        public Criteria andTxDateIsNotNull() {
            addCriterion("tx_date is not null");
            return (Criteria) this;
        }

        public Criteria andTxDateEqualTo(Integer value) {
            addCriterion("tx_date =", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateNotEqualTo(Integer value) {
            addCriterion("tx_date <>", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateGreaterThan(Integer value) {
            addCriterion("tx_date >", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("tx_date >=", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateLessThan(Integer value) {
            addCriterion("tx_date <", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateLessThanOrEqualTo(Integer value) {
            addCriterion("tx_date <=", value, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateIn(List<Integer> values) {
            addCriterion("tx_date in", values, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateNotIn(List<Integer> values) {
            addCriterion("tx_date not in", values, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateBetween(Integer value1, Integer value2) {
            addCriterion("tx_date between", value1, value2, "txDate");
            return (Criteria) this;
        }

        public Criteria andTxDateNotBetween(Integer value1, Integer value2) {
            addCriterion("tx_date not between", value1, value2, "txDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempIdIsNull() {
            addCriterion("level_temp_id is null");
            return (Criteria) this;
        }

        public Criteria andLevelTempIdIsNotNull() {
            addCriterion("level_temp_id is not null");
            return (Criteria) this;
        }

        public Criteria andLevelTempIdEqualTo(Long value) {
            addCriterion("level_temp_id =", value, "levelTempId");
            return (Criteria) this;
        }

        public Criteria andLevelTempIdNotEqualTo(Long value) {
            addCriterion("level_temp_id <>", value, "levelTempId");
            return (Criteria) this;
        }

        public Criteria andLevelTempIdGreaterThan(Long value) {
            addCriterion("level_temp_id >", value, "levelTempId");
            return (Criteria) this;
        }

        public Criteria andLevelTempIdGreaterThanOrEqualTo(Long value) {
            addCriterion("level_temp_id >=", value, "levelTempId");
            return (Criteria) this;
        }

        public Criteria andLevelTempIdLessThan(Long value) {
            addCriterion("level_temp_id <", value, "levelTempId");
            return (Criteria) this;
        }

        public Criteria andLevelTempIdLessThanOrEqualTo(Long value) {
            addCriterion("level_temp_id <=", value, "levelTempId");
            return (Criteria) this;
        }

        public Criteria andLevelTempIdIn(List<Long> values) {
            addCriterion("level_temp_id in", values, "levelTempId");
            return (Criteria) this;
        }

        public Criteria andLevelTempIdNotIn(List<Long> values) {
            addCriterion("level_temp_id not in", values, "levelTempId");
            return (Criteria) this;
        }

        public Criteria andLevelTempIdBetween(Long value1, Long value2) {
            addCriterion("level_temp_id between", value1, value2, "levelTempId");
            return (Criteria) this;
        }

        public Criteria andLevelTempIdNotBetween(Long value1, Long value2) {
            addCriterion("level_temp_id not between", value1, value2, "levelTempId");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameIsNull() {
            addCriterion("level_temp_name is null");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameIsNotNull() {
            addCriterion("level_temp_name is not null");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameEqualTo(String value) {
            addCriterion("level_temp_name =", value, "levelTempName");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameNotEqualTo(String value) {
            addCriterion("level_temp_name <>", value, "levelTempName");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameGreaterThan(String value) {
            addCriterion("level_temp_name >", value, "levelTempName");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameGreaterThanOrEqualTo(String value) {
            addCriterion("level_temp_name >=", value, "levelTempName");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameLessThan(String value) {
            addCriterion("level_temp_name <", value, "levelTempName");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameLessThanOrEqualTo(String value) {
            addCriterion("level_temp_name <=", value, "levelTempName");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameLike(String value) {
            addCriterion("level_temp_name like", value, "levelTempName");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameNotLike(String value) {
            addCriterion("level_temp_name not like", value, "levelTempName");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameIn(List<String> values) {
            addCriterion("level_temp_name in", values, "levelTempName");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameNotIn(List<String> values) {
            addCriterion("level_temp_name not in", values, "levelTempName");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameBetween(String value1, String value2) {
            addCriterion("level_temp_name between", value1, value2, "levelTempName");
            return (Criteria) this;
        }

        public Criteria andLevelTempNameNotBetween(String value1, String value2) {
            addCriterion("level_temp_name not between", value1, value2, "levelTempName");
            return (Criteria) this;
        }

        public Criteria andLevelTempStartDateIsNull() {
            addCriterion("level_temp_start_date is null");
            return (Criteria) this;
        }

        public Criteria andLevelTempStartDateIsNotNull() {
            addCriterion("level_temp_start_date is not null");
            return (Criteria) this;
        }

        public Criteria andLevelTempStartDateEqualTo(Integer value) {
            addCriterion("level_temp_start_date =", value, "levelTempStartDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempStartDateNotEqualTo(Integer value) {
            addCriterion("level_temp_start_date <>", value, "levelTempStartDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempStartDateGreaterThan(Integer value) {
            addCriterion("level_temp_start_date >", value, "levelTempStartDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempStartDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("level_temp_start_date >=", value, "levelTempStartDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempStartDateLessThan(Integer value) {
            addCriterion("level_temp_start_date <", value, "levelTempStartDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempStartDateLessThanOrEqualTo(Integer value) {
            addCriterion("level_temp_start_date <=", value, "levelTempStartDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempStartDateIn(List<Integer> values) {
            addCriterion("level_temp_start_date in", values, "levelTempStartDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempStartDateNotIn(List<Integer> values) {
            addCriterion("level_temp_start_date not in", values, "levelTempStartDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempStartDateBetween(Integer value1, Integer value2) {
            addCriterion("level_temp_start_date between", value1, value2, "levelTempStartDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempStartDateNotBetween(Integer value1, Integer value2) {
            addCriterion("level_temp_start_date not between", value1, value2, "levelTempStartDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempEndDateIsNull() {
            addCriterion("level_temp_end_date is null");
            return (Criteria) this;
        }

        public Criteria andLevelTempEndDateIsNotNull() {
            addCriterion("level_temp_end_date is not null");
            return (Criteria) this;
        }

        public Criteria andLevelTempEndDateEqualTo(Integer value) {
            addCriterion("level_temp_end_date =", value, "levelTempEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempEndDateNotEqualTo(Integer value) {
            addCriterion("level_temp_end_date <>", value, "levelTempEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempEndDateGreaterThan(Integer value) {
            addCriterion("level_temp_end_date >", value, "levelTempEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempEndDateGreaterThanOrEqualTo(Integer value) {
            addCriterion("level_temp_end_date >=", value, "levelTempEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempEndDateLessThan(Integer value) {
            addCriterion("level_temp_end_date <", value, "levelTempEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempEndDateLessThanOrEqualTo(Integer value) {
            addCriterion("level_temp_end_date <=", value, "levelTempEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempEndDateIn(List<Integer> values) {
            addCriterion("level_temp_end_date in", values, "levelTempEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempEndDateNotIn(List<Integer> values) {
            addCriterion("level_temp_end_date not in", values, "levelTempEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempEndDateBetween(Integer value1, Integer value2) {
            addCriterion("level_temp_end_date between", value1, value2, "levelTempEndDate");
            return (Criteria) this;
        }

        public Criteria andLevelTempEndDateNotBetween(Integer value1, Integer value2) {
            addCriterion("level_temp_end_date not between", value1, value2, "levelTempEndDate");
            return (Criteria) this;
        }
    }

    /**
     * cust_level表的操作类
     * 创建时间 : 2017-04-13 15:30:44
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * cust_level表的操作类
     * 创建时间 : 2017-04-13 15:30:44
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}