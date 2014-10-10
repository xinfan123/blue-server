package com.xinfan.msgbox.service.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNull() {
            addCriterion("USER_STATE is null");
            return (Criteria) this;
        }

        public Criteria andUserStateIsNotNull() {
            addCriterion("USER_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andUserStateEqualTo(Integer value) {
            addCriterion("USER_STATE =", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotEqualTo(Integer value) {
            addCriterion("USER_STATE <>", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThan(Integer value) {
            addCriterion("USER_STATE >", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_STATE >=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThan(Integer value) {
            addCriterion("USER_STATE <", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateLessThanOrEqualTo(Integer value) {
            addCriterion("USER_STATE <=", value, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateIn(List<Integer> values) {
            addCriterion("USER_STATE in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotIn(List<Integer> values) {
            addCriterion("USER_STATE not in", values, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateBetween(Integer value1, Integer value2) {
            addCriterion("USER_STATE between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andUserStateNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_STATE not between", value1, value2, "userState");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNull() {
            addCriterion("PASSWD is null");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNotNull() {
            addCriterion("PASSWD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswdEqualTo(String value) {
            addCriterion("PASSWD =", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotEqualTo(String value) {
            addCriterion("PASSWD <>", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThan(String value) {
            addCriterion("PASSWD >", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWD >=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThan(String value) {
            addCriterion("PASSWD <", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThanOrEqualTo(String value) {
            addCriterion("PASSWD <=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLike(String value) {
            addCriterion("PASSWD like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotLike(String value) {
            addCriterion("PASSWD not like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdIn(List<String> values) {
            addCriterion("PASSWD in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotIn(List<String> values) {
            addCriterion("PASSWD not in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdBetween(String value1, String value2) {
            addCriterion("PASSWD between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotBetween(String value1, String value2) {
            addCriterion("PASSWD not between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andRegGpsyIsNull() {
            addCriterion("REG_GPSY is null");
            return (Criteria) this;
        }

        public Criteria andRegGpsyIsNotNull() {
            addCriterion("REG_GPSY is not null");
            return (Criteria) this;
        }

        public Criteria andRegGpsyEqualTo(String value) {
            addCriterion("REG_GPSY =", value, "regGpsy");
            return (Criteria) this;
        }

        public Criteria andRegGpsyNotEqualTo(String value) {
            addCriterion("REG_GPSY <>", value, "regGpsy");
            return (Criteria) this;
        }

        public Criteria andRegGpsyGreaterThan(String value) {
            addCriterion("REG_GPSY >", value, "regGpsy");
            return (Criteria) this;
        }

        public Criteria andRegGpsyGreaterThanOrEqualTo(String value) {
            addCriterion("REG_GPSY >=", value, "regGpsy");
            return (Criteria) this;
        }

        public Criteria andRegGpsyLessThan(String value) {
            addCriterion("REG_GPSY <", value, "regGpsy");
            return (Criteria) this;
        }

        public Criteria andRegGpsyLessThanOrEqualTo(String value) {
            addCriterion("REG_GPSY <=", value, "regGpsy");
            return (Criteria) this;
        }

        public Criteria andRegGpsyLike(String value) {
            addCriterion("REG_GPSY like", value, "regGpsy");
            return (Criteria) this;
        }

        public Criteria andRegGpsyNotLike(String value) {
            addCriterion("REG_GPSY not like", value, "regGpsy");
            return (Criteria) this;
        }

        public Criteria andRegGpsyIn(List<String> values) {
            addCriterion("REG_GPSY in", values, "regGpsy");
            return (Criteria) this;
        }

        public Criteria andRegGpsyNotIn(List<String> values) {
            addCriterion("REG_GPSY not in", values, "regGpsy");
            return (Criteria) this;
        }

        public Criteria andRegGpsyBetween(String value1, String value2) {
            addCriterion("REG_GPSY between", value1, value2, "regGpsy");
            return (Criteria) this;
        }

        public Criteria andRegGpsyNotBetween(String value1, String value2) {
            addCriterion("REG_GPSY not between", value1, value2, "regGpsy");
            return (Criteria) this;
        }

        public Criteria andRegGpsxIsNull() {
            addCriterion("REG_GPSX is null");
            return (Criteria) this;
        }

        public Criteria andRegGpsxIsNotNull() {
            addCriterion("REG_GPSX is not null");
            return (Criteria) this;
        }

        public Criteria andRegGpsxEqualTo(String value) {
            addCriterion("REG_GPSX =", value, "regGpsx");
            return (Criteria) this;
        }

        public Criteria andRegGpsxNotEqualTo(String value) {
            addCriterion("REG_GPSX <>", value, "regGpsx");
            return (Criteria) this;
        }

        public Criteria andRegGpsxGreaterThan(String value) {
            addCriterion("REG_GPSX >", value, "regGpsx");
            return (Criteria) this;
        }

        public Criteria andRegGpsxGreaterThanOrEqualTo(String value) {
            addCriterion("REG_GPSX >=", value, "regGpsx");
            return (Criteria) this;
        }

        public Criteria andRegGpsxLessThan(String value) {
            addCriterion("REG_GPSX <", value, "regGpsx");
            return (Criteria) this;
        }

        public Criteria andRegGpsxLessThanOrEqualTo(String value) {
            addCriterion("REG_GPSX <=", value, "regGpsx");
            return (Criteria) this;
        }

        public Criteria andRegGpsxLike(String value) {
            addCriterion("REG_GPSX like", value, "regGpsx");
            return (Criteria) this;
        }

        public Criteria andRegGpsxNotLike(String value) {
            addCriterion("REG_GPSX not like", value, "regGpsx");
            return (Criteria) this;
        }

        public Criteria andRegGpsxIn(List<String> values) {
            addCriterion("REG_GPSX in", values, "regGpsx");
            return (Criteria) this;
        }

        public Criteria andRegGpsxNotIn(List<String> values) {
            addCriterion("REG_GPSX not in", values, "regGpsx");
            return (Criteria) this;
        }

        public Criteria andRegGpsxBetween(String value1, String value2) {
            addCriterion("REG_GPSX between", value1, value2, "regGpsx");
            return (Criteria) this;
        }

        public Criteria andRegGpsxNotBetween(String value1, String value2) {
            addCriterion("REG_GPSX not between", value1, value2, "regGpsx");
            return (Criteria) this;
        }

        public Criteria andRegEareaIsNull() {
            addCriterion("REG_EAREA is null");
            return (Criteria) this;
        }

        public Criteria andRegEareaIsNotNull() {
            addCriterion("REG_EAREA is not null");
            return (Criteria) this;
        }

        public Criteria andRegEareaEqualTo(String value) {
            addCriterion("REG_EAREA =", value, "regEarea");
            return (Criteria) this;
        }

        public Criteria andRegEareaNotEqualTo(String value) {
            addCriterion("REG_EAREA <>", value, "regEarea");
            return (Criteria) this;
        }

        public Criteria andRegEareaGreaterThan(String value) {
            addCriterion("REG_EAREA >", value, "regEarea");
            return (Criteria) this;
        }

        public Criteria andRegEareaGreaterThanOrEqualTo(String value) {
            addCriterion("REG_EAREA >=", value, "regEarea");
            return (Criteria) this;
        }

        public Criteria andRegEareaLessThan(String value) {
            addCriterion("REG_EAREA <", value, "regEarea");
            return (Criteria) this;
        }

        public Criteria andRegEareaLessThanOrEqualTo(String value) {
            addCriterion("REG_EAREA <=", value, "regEarea");
            return (Criteria) this;
        }

        public Criteria andRegEareaLike(String value) {
            addCriterion("REG_EAREA like", value, "regEarea");
            return (Criteria) this;
        }

        public Criteria andRegEareaNotLike(String value) {
            addCriterion("REG_EAREA not like", value, "regEarea");
            return (Criteria) this;
        }

        public Criteria andRegEareaIn(List<String> values) {
            addCriterion("REG_EAREA in", values, "regEarea");
            return (Criteria) this;
        }

        public Criteria andRegEareaNotIn(List<String> values) {
            addCriterion("REG_EAREA not in", values, "regEarea");
            return (Criteria) this;
        }

        public Criteria andRegEareaBetween(String value1, String value2) {
            addCriterion("REG_EAREA between", value1, value2, "regEarea");
            return (Criteria) this;
        }

        public Criteria andRegEareaNotBetween(String value1, String value2) {
            addCriterion("REG_EAREA not between", value1, value2, "regEarea");
            return (Criteria) this;
        }

        public Criteria andVipIsNull() {
            addCriterion("VIP is null");
            return (Criteria) this;
        }

        public Criteria andVipIsNotNull() {
            addCriterion("VIP is not null");
            return (Criteria) this;
        }

        public Criteria andVipEqualTo(Integer value) {
            addCriterion("VIP =", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipNotEqualTo(Integer value) {
            addCriterion("VIP <>", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipGreaterThan(Integer value) {
            addCriterion("VIP >", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipGreaterThanOrEqualTo(Integer value) {
            addCriterion("VIP >=", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipLessThan(Integer value) {
            addCriterion("VIP <", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipLessThanOrEqualTo(Integer value) {
            addCriterion("VIP <=", value, "vip");
            return (Criteria) this;
        }

        public Criteria andVipIn(List<Integer> values) {
            addCriterion("VIP in", values, "vip");
            return (Criteria) this;
        }

        public Criteria andVipNotIn(List<Integer> values) {
            addCriterion("VIP not in", values, "vip");
            return (Criteria) this;
        }

        public Criteria andVipBetween(Integer value1, Integer value2) {
            addCriterion("VIP between", value1, value2, "vip");
            return (Criteria) this;
        }

        public Criteria andVipNotBetween(Integer value1, Integer value2) {
            addCriterion("VIP not between", value1, value2, "vip");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNull() {
            addCriterion("REG_TIME is null");
            return (Criteria) this;
        }

        public Criteria andRegTimeIsNotNull() {
            addCriterion("REG_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andRegTimeEqualTo(Date value) {
            addCriterion("REG_TIME =", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotEqualTo(Date value) {
            addCriterion("REG_TIME <>", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThan(Date value) {
            addCriterion("REG_TIME >", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("REG_TIME >=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThan(Date value) {
            addCriterion("REG_TIME <", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeLessThanOrEqualTo(Date value) {
            addCriterion("REG_TIME <=", value, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeIn(List<Date> values) {
            addCriterion("REG_TIME in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotIn(List<Date> values) {
            addCriterion("REG_TIME not in", values, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeBetween(Date value1, Date value2) {
            addCriterion("REG_TIME between", value1, value2, "regTime");
            return (Criteria) this;
        }

        public Criteria andRegTimeNotBetween(Date value1, Date value2) {
            addCriterion("REG_TIME not between", value1, value2, "regTime");
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