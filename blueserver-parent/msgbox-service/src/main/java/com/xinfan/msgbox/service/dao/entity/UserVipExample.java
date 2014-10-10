package com.xinfan.msgbox.service.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserVipExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserVipExample() {
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

        public Criteria andVipTatusIsNull() {
            addCriterion("VIP_TATUS is null");
            return (Criteria) this;
        }

        public Criteria andVipTatusIsNotNull() {
            addCriterion("VIP_TATUS is not null");
            return (Criteria) this;
        }

        public Criteria andVipTatusEqualTo(Integer value) {
            addCriterion("VIP_TATUS =", value, "vipTatus");
            return (Criteria) this;
        }

        public Criteria andVipTatusNotEqualTo(Integer value) {
            addCriterion("VIP_TATUS <>", value, "vipTatus");
            return (Criteria) this;
        }

        public Criteria andVipTatusGreaterThan(Integer value) {
            addCriterion("VIP_TATUS >", value, "vipTatus");
            return (Criteria) this;
        }

        public Criteria andVipTatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("VIP_TATUS >=", value, "vipTatus");
            return (Criteria) this;
        }

        public Criteria andVipTatusLessThan(Integer value) {
            addCriterion("VIP_TATUS <", value, "vipTatus");
            return (Criteria) this;
        }

        public Criteria andVipTatusLessThanOrEqualTo(Integer value) {
            addCriterion("VIP_TATUS <=", value, "vipTatus");
            return (Criteria) this;
        }

        public Criteria andVipTatusIn(List<Integer> values) {
            addCriterion("VIP_TATUS in", values, "vipTatus");
            return (Criteria) this;
        }

        public Criteria andVipTatusNotIn(List<Integer> values) {
            addCriterion("VIP_TATUS not in", values, "vipTatus");
            return (Criteria) this;
        }

        public Criteria andVipTatusBetween(Integer value1, Integer value2) {
            addCriterion("VIP_TATUS between", value1, value2, "vipTatus");
            return (Criteria) this;
        }

        public Criteria andVipTatusNotBetween(Integer value1, Integer value2) {
            addCriterion("VIP_TATUS not between", value1, value2, "vipTatus");
            return (Criteria) this;
        }

        public Criteria andVipRegTimeIsNull() {
            addCriterion("VIP_REG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andVipRegTimeIsNotNull() {
            addCriterion("VIP_REG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andVipRegTimeEqualTo(Date value) {
            addCriterion("VIP_REG_TIME =", value, "vipRegTime");
            return (Criteria) this;
        }

        public Criteria andVipRegTimeNotEqualTo(Date value) {
            addCriterion("VIP_REG_TIME <>", value, "vipRegTime");
            return (Criteria) this;
        }

        public Criteria andVipRegTimeGreaterThan(Date value) {
            addCriterion("VIP_REG_TIME >", value, "vipRegTime");
            return (Criteria) this;
        }

        public Criteria andVipRegTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("VIP_REG_TIME >=", value, "vipRegTime");
            return (Criteria) this;
        }

        public Criteria andVipRegTimeLessThan(Date value) {
            addCriterion("VIP_REG_TIME <", value, "vipRegTime");
            return (Criteria) this;
        }

        public Criteria andVipRegTimeLessThanOrEqualTo(Date value) {
            addCriterion("VIP_REG_TIME <=", value, "vipRegTime");
            return (Criteria) this;
        }

        public Criteria andVipRegTimeIn(List<Date> values) {
            addCriterion("VIP_REG_TIME in", values, "vipRegTime");
            return (Criteria) this;
        }

        public Criteria andVipRegTimeNotIn(List<Date> values) {
            addCriterion("VIP_REG_TIME not in", values, "vipRegTime");
            return (Criteria) this;
        }

        public Criteria andVipRegTimeBetween(Date value1, Date value2) {
            addCriterion("VIP_REG_TIME between", value1, value2, "vipRegTime");
            return (Criteria) this;
        }

        public Criteria andVipRegTimeNotBetween(Date value1, Date value2) {
            addCriterion("VIP_REG_TIME not between", value1, value2, "vipRegTime");
            return (Criteria) this;
        }

        public Criteria andVipEndTimeIsNull() {
            addCriterion("VIP_END_TIME is null");
            return (Criteria) this;
        }

        public Criteria andVipEndTimeIsNotNull() {
            addCriterion("VIP_END_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andVipEndTimeEqualTo(Date value) {
            addCriterion("VIP_END_TIME =", value, "vipEndTime");
            return (Criteria) this;
        }

        public Criteria andVipEndTimeNotEqualTo(Date value) {
            addCriterion("VIP_END_TIME <>", value, "vipEndTime");
            return (Criteria) this;
        }

        public Criteria andVipEndTimeGreaterThan(Date value) {
            addCriterion("VIP_END_TIME >", value, "vipEndTime");
            return (Criteria) this;
        }

        public Criteria andVipEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("VIP_END_TIME >=", value, "vipEndTime");
            return (Criteria) this;
        }

        public Criteria andVipEndTimeLessThan(Date value) {
            addCriterion("VIP_END_TIME <", value, "vipEndTime");
            return (Criteria) this;
        }

        public Criteria andVipEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("VIP_END_TIME <=", value, "vipEndTime");
            return (Criteria) this;
        }

        public Criteria andVipEndTimeIn(List<Date> values) {
            addCriterion("VIP_END_TIME in", values, "vipEndTime");
            return (Criteria) this;
        }

        public Criteria andVipEndTimeNotIn(List<Date> values) {
            addCriterion("VIP_END_TIME not in", values, "vipEndTime");
            return (Criteria) this;
        }

        public Criteria andVipEndTimeBetween(Date value1, Date value2) {
            addCriterion("VIP_END_TIME between", value1, value2, "vipEndTime");
            return (Criteria) this;
        }

        public Criteria andVipEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("VIP_END_TIME not between", value1, value2, "vipEndTime");
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