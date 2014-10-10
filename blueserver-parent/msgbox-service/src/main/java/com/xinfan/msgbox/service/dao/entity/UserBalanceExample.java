package com.xinfan.msgbox.service.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class UserBalanceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserBalanceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserCreditIsNull() {
            addCriterion("USER_CREDIT is null");
            return (Criteria) this;
        }

        public Criteria andUserCreditIsNotNull() {
            addCriterion("USER_CREDIT is not null");
            return (Criteria) this;
        }

        public Criteria andUserCreditEqualTo(Integer value) {
            addCriterion("USER_CREDIT =", value, "userCredit");
            return (Criteria) this;
        }

        public Criteria andUserCreditNotEqualTo(Integer value) {
            addCriterion("USER_CREDIT <>", value, "userCredit");
            return (Criteria) this;
        }

        public Criteria andUserCreditGreaterThan(Integer value) {
            addCriterion("USER_CREDIT >", value, "userCredit");
            return (Criteria) this;
        }

        public Criteria andUserCreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_CREDIT >=", value, "userCredit");
            return (Criteria) this;
        }

        public Criteria andUserCreditLessThan(Integer value) {
            addCriterion("USER_CREDIT <", value, "userCredit");
            return (Criteria) this;
        }

        public Criteria andUserCreditLessThanOrEqualTo(Integer value) {
            addCriterion("USER_CREDIT <=", value, "userCredit");
            return (Criteria) this;
        }

        public Criteria andUserCreditIn(List<Integer> values) {
            addCriterion("USER_CREDIT in", values, "userCredit");
            return (Criteria) this;
        }

        public Criteria andUserCreditNotIn(List<Integer> values) {
            addCriterion("USER_CREDIT not in", values, "userCredit");
            return (Criteria) this;
        }

        public Criteria andUserCreditBetween(Integer value1, Integer value2) {
            addCriterion("USER_CREDIT between", value1, value2, "userCredit");
            return (Criteria) this;
        }

        public Criteria andUserCreditNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_CREDIT not between", value1, value2, "userCredit");
            return (Criteria) this;
        }

        public Criteria andUserBalanceIsNull() {
            addCriterion("USER_BALANCE is null");
            return (Criteria) this;
        }

        public Criteria andUserBalanceIsNotNull() {
            addCriterion("USER_BALANCE is not null");
            return (Criteria) this;
        }

        public Criteria andUserBalanceEqualTo(Integer value) {
            addCriterion("USER_BALANCE =", value, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceNotEqualTo(Integer value) {
            addCriterion("USER_BALANCE <>", value, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceGreaterThan(Integer value) {
            addCriterion("USER_BALANCE >", value, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_BALANCE >=", value, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceLessThan(Integer value) {
            addCriterion("USER_BALANCE <", value, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceLessThanOrEqualTo(Integer value) {
            addCriterion("USER_BALANCE <=", value, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceIn(List<Integer> values) {
            addCriterion("USER_BALANCE in", values, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceNotIn(List<Integer> values) {
            addCriterion("USER_BALANCE not in", values, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceBetween(Integer value1, Integer value2) {
            addCriterion("USER_BALANCE between", value1, value2, "userBalance");
            return (Criteria) this;
        }

        public Criteria andUserBalanceNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_BALANCE not between", value1, value2, "userBalance");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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