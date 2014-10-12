package com.xinfan.msgbox.service.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserLinkmanExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserLinkmanExample() {
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

        public Criteria andLinkUserIdIsNull() {
            addCriterion("LINK_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdIsNotNull() {
            addCriterion("LINK_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdEqualTo(Long value) {
            addCriterion("LINK_USER_ID =", value, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdNotEqualTo(Long value) {
            addCriterion("LINK_USER_ID <>", value, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdGreaterThan(Long value) {
            addCriterion("LINK_USER_ID >", value, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("LINK_USER_ID >=", value, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdLessThan(Long value) {
            addCriterion("LINK_USER_ID <", value, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdLessThanOrEqualTo(Long value) {
            addCriterion("LINK_USER_ID <=", value, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdIn(List<Long> values) {
            addCriterion("LINK_USER_ID in", values, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdNotIn(List<Long> values) {
            addCriterion("LINK_USER_ID not in", values, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdBetween(Long value1, Long value2) {
            addCriterion("LINK_USER_ID between", value1, value2, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkUserIdNotBetween(Long value1, Long value2) {
            addCriterion("LINK_USER_ID not between", value1, value2, "linkUserId");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkIsNull() {
            addCriterion("LINK_REMARK is null");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkIsNotNull() {
            addCriterion("LINK_REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkEqualTo(String value) {
            addCriterion("LINK_REMARK =", value, "linkRemark");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkNotEqualTo(String value) {
            addCriterion("LINK_REMARK <>", value, "linkRemark");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkGreaterThan(String value) {
            addCriterion("LINK_REMARK >", value, "linkRemark");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("LINK_REMARK >=", value, "linkRemark");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkLessThan(String value) {
            addCriterion("LINK_REMARK <", value, "linkRemark");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkLessThanOrEqualTo(String value) {
            addCriterion("LINK_REMARK <=", value, "linkRemark");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkLike(String value) {
            addCriterion("LINK_REMARK like", value, "linkRemark");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkNotLike(String value) {
            addCriterion("LINK_REMARK not like", value, "linkRemark");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkIn(List<String> values) {
            addCriterion("LINK_REMARK in", values, "linkRemark");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkNotIn(List<String> values) {
            addCriterion("LINK_REMARK not in", values, "linkRemark");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkBetween(String value1, String value2) {
            addCriterion("LINK_REMARK between", value1, value2, "linkRemark");
            return (Criteria) this;
        }

        public Criteria andLinkRemarkNotBetween(String value1, String value2) {
            addCriterion("LINK_REMARK not between", value1, value2, "linkRemark");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("CREATE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("CREATE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("CREATE_TIME =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("CREATE_TIME <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("CREATE_TIME >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("CREATE_TIME <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_TIME <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("CREATE_TIME in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("CREATE_TIME not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_TIME not between", value1, value2, "createTime");
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