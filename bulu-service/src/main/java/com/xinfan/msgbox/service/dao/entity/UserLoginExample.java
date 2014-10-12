package com.xinfan.msgbox.service.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserLoginExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserLoginExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andLoginTimeIsNull() {
            addCriterion("LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("LOGIN_TIME =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("LOGIN_TIME <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("LOGIN_TIME >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LOGIN_TIME >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("LOGIN_TIME <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("LOGIN_TIME <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("LOGIN_TIME in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("LOGIN_TIME not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("LOGIN_TIME between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("LOGIN_TIME not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andGpsxIsNull() {
            addCriterion("GPSX is null");
            return (Criteria) this;
        }

        public Criteria andGpsxIsNotNull() {
            addCriterion("GPSX is not null");
            return (Criteria) this;
        }

        public Criteria andGpsxEqualTo(String value) {
            addCriterion("GPSX =", value, "gpsx");
            return (Criteria) this;
        }

        public Criteria andGpsxNotEqualTo(String value) {
            addCriterion("GPSX <>", value, "gpsx");
            return (Criteria) this;
        }

        public Criteria andGpsxGreaterThan(String value) {
            addCriterion("GPSX >", value, "gpsx");
            return (Criteria) this;
        }

        public Criteria andGpsxGreaterThanOrEqualTo(String value) {
            addCriterion("GPSX >=", value, "gpsx");
            return (Criteria) this;
        }

        public Criteria andGpsxLessThan(String value) {
            addCriterion("GPSX <", value, "gpsx");
            return (Criteria) this;
        }

        public Criteria andGpsxLessThanOrEqualTo(String value) {
            addCriterion("GPSX <=", value, "gpsx");
            return (Criteria) this;
        }

        public Criteria andGpsxLike(String value) {
            addCriterion("GPSX like", value, "gpsx");
            return (Criteria) this;
        }

        public Criteria andGpsxNotLike(String value) {
            addCriterion("GPSX not like", value, "gpsx");
            return (Criteria) this;
        }

        public Criteria andGpsxIn(List<String> values) {
            addCriterion("GPSX in", values, "gpsx");
            return (Criteria) this;
        }

        public Criteria andGpsxNotIn(List<String> values) {
            addCriterion("GPSX not in", values, "gpsx");
            return (Criteria) this;
        }

        public Criteria andGpsxBetween(String value1, String value2) {
            addCriterion("GPSX between", value1, value2, "gpsx");
            return (Criteria) this;
        }

        public Criteria andGpsxNotBetween(String value1, String value2) {
            addCriterion("GPSX not between", value1, value2, "gpsx");
            return (Criteria) this;
        }

        public Criteria andGpsyIsNull() {
            addCriterion("GPSY is null");
            return (Criteria) this;
        }

        public Criteria andGpsyIsNotNull() {
            addCriterion("GPSY is not null");
            return (Criteria) this;
        }

        public Criteria andGpsyEqualTo(String value) {
            addCriterion("GPSY =", value, "gpsy");
            return (Criteria) this;
        }

        public Criteria andGpsyNotEqualTo(String value) {
            addCriterion("GPSY <>", value, "gpsy");
            return (Criteria) this;
        }

        public Criteria andGpsyGreaterThan(String value) {
            addCriterion("GPSY >", value, "gpsy");
            return (Criteria) this;
        }

        public Criteria andGpsyGreaterThanOrEqualTo(String value) {
            addCriterion("GPSY >=", value, "gpsy");
            return (Criteria) this;
        }

        public Criteria andGpsyLessThan(String value) {
            addCriterion("GPSY <", value, "gpsy");
            return (Criteria) this;
        }

        public Criteria andGpsyLessThanOrEqualTo(String value) {
            addCriterion("GPSY <=", value, "gpsy");
            return (Criteria) this;
        }

        public Criteria andGpsyLike(String value) {
            addCriterion("GPSY like", value, "gpsy");
            return (Criteria) this;
        }

        public Criteria andGpsyNotLike(String value) {
            addCriterion("GPSY not like", value, "gpsy");
            return (Criteria) this;
        }

        public Criteria andGpsyIn(List<String> values) {
            addCriterion("GPSY in", values, "gpsy");
            return (Criteria) this;
        }

        public Criteria andGpsyNotIn(List<String> values) {
            addCriterion("GPSY not in", values, "gpsy");
            return (Criteria) this;
        }

        public Criteria andGpsyBetween(String value1, String value2) {
            addCriterion("GPSY between", value1, value2, "gpsy");
            return (Criteria) this;
        }

        public Criteria andGpsyNotBetween(String value1, String value2) {
            addCriterion("GPSY not between", value1, value2, "gpsy");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNull() {
            addCriterion("LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNotNull() {
            addCriterion("LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIpEqualTo(String value) {
            addCriterion("LOGIN_IP =", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotEqualTo(String value) {
            addCriterion("LOGIN_IP <>", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThan(String value) {
            addCriterion("LOGIN_IP >", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP >=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThan(String value) {
            addCriterion("LOGIN_IP <", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_IP <=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLike(String value) {
            addCriterion("LOGIN_IP like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotLike(String value) {
            addCriterion("LOGIN_IP not like", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpIn(List<String> values) {
            addCriterion("LOGIN_IP in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotIn(List<String> values) {
            addCriterion("LOGIN_IP not in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpBetween(String value1, String value2) {
            addCriterion("LOGIN_IP between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotBetween(String value1, String value2) {
            addCriterion("LOGIN_IP not between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andClientVersionIsNull() {
            addCriterion("CLIENT_VERSION is null");
            return (Criteria) this;
        }

        public Criteria andClientVersionIsNotNull() {
            addCriterion("CLIENT_VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andClientVersionEqualTo(String value) {
            addCriterion("CLIENT_VERSION =", value, "clientVersion");
            return (Criteria) this;
        }

        public Criteria andClientVersionNotEqualTo(String value) {
            addCriterion("CLIENT_VERSION <>", value, "clientVersion");
            return (Criteria) this;
        }

        public Criteria andClientVersionGreaterThan(String value) {
            addCriterion("CLIENT_VERSION >", value, "clientVersion");
            return (Criteria) this;
        }

        public Criteria andClientVersionGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_VERSION >=", value, "clientVersion");
            return (Criteria) this;
        }

        public Criteria andClientVersionLessThan(String value) {
            addCriterion("CLIENT_VERSION <", value, "clientVersion");
            return (Criteria) this;
        }

        public Criteria andClientVersionLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_VERSION <=", value, "clientVersion");
            return (Criteria) this;
        }

        public Criteria andClientVersionLike(String value) {
            addCriterion("CLIENT_VERSION like", value, "clientVersion");
            return (Criteria) this;
        }

        public Criteria andClientVersionNotLike(String value) {
            addCriterion("CLIENT_VERSION not like", value, "clientVersion");
            return (Criteria) this;
        }

        public Criteria andClientVersionIn(List<String> values) {
            addCriterion("CLIENT_VERSION in", values, "clientVersion");
            return (Criteria) this;
        }

        public Criteria andClientVersionNotIn(List<String> values) {
            addCriterion("CLIENT_VERSION not in", values, "clientVersion");
            return (Criteria) this;
        }

        public Criteria andClientVersionBetween(String value1, String value2) {
            addCriterion("CLIENT_VERSION between", value1, value2, "clientVersion");
            return (Criteria) this;
        }

        public Criteria andClientVersionNotBetween(String value1, String value2) {
            addCriterion("CLIENT_VERSION not between", value1, value2, "clientVersion");
            return (Criteria) this;
        }

        public Criteria andClientTypeIsNull() {
            addCriterion("CLIENT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andClientTypeIsNotNull() {
            addCriterion("CLIENT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andClientTypeEqualTo(String value) {
            addCriterion("CLIENT_TYPE =", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotEqualTo(String value) {
            addCriterion("CLIENT_TYPE <>", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeGreaterThan(String value) {
            addCriterion("CLIENT_TYPE >", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_TYPE >=", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLessThan(String value) {
            addCriterion("CLIENT_TYPE <", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_TYPE <=", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeLike(String value) {
            addCriterion("CLIENT_TYPE like", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotLike(String value) {
            addCriterion("CLIENT_TYPE not like", value, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeIn(List<String> values) {
            addCriterion("CLIENT_TYPE in", values, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotIn(List<String> values) {
            addCriterion("CLIENT_TYPE not in", values, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeBetween(String value1, String value2) {
            addCriterion("CLIENT_TYPE between", value1, value2, "clientType");
            return (Criteria) this;
        }

        public Criteria andClientTypeNotBetween(String value1, String value2) {
            addCriterion("CLIENT_TYPE not between", value1, value2, "clientType");
            return (Criteria) this;
        }

        public Criteria andLoginAreaIsNull() {
            addCriterion("LOGIN_AREA is null");
            return (Criteria) this;
        }

        public Criteria andLoginAreaIsNotNull() {
            addCriterion("LOGIN_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andLoginAreaEqualTo(String value) {
            addCriterion("LOGIN_AREA =", value, "loginArea");
            return (Criteria) this;
        }

        public Criteria andLoginAreaNotEqualTo(String value) {
            addCriterion("LOGIN_AREA <>", value, "loginArea");
            return (Criteria) this;
        }

        public Criteria andLoginAreaGreaterThan(String value) {
            addCriterion("LOGIN_AREA >", value, "loginArea");
            return (Criteria) this;
        }

        public Criteria andLoginAreaGreaterThanOrEqualTo(String value) {
            addCriterion("LOGIN_AREA >=", value, "loginArea");
            return (Criteria) this;
        }

        public Criteria andLoginAreaLessThan(String value) {
            addCriterion("LOGIN_AREA <", value, "loginArea");
            return (Criteria) this;
        }

        public Criteria andLoginAreaLessThanOrEqualTo(String value) {
            addCriterion("LOGIN_AREA <=", value, "loginArea");
            return (Criteria) this;
        }

        public Criteria andLoginAreaLike(String value) {
            addCriterion("LOGIN_AREA like", value, "loginArea");
            return (Criteria) this;
        }

        public Criteria andLoginAreaNotLike(String value) {
            addCriterion("LOGIN_AREA not like", value, "loginArea");
            return (Criteria) this;
        }

        public Criteria andLoginAreaIn(List<String> values) {
            addCriterion("LOGIN_AREA in", values, "loginArea");
            return (Criteria) this;
        }

        public Criteria andLoginAreaNotIn(List<String> values) {
            addCriterion("LOGIN_AREA not in", values, "loginArea");
            return (Criteria) this;
        }

        public Criteria andLoginAreaBetween(String value1, String value2) {
            addCriterion("LOGIN_AREA between", value1, value2, "loginArea");
            return (Criteria) this;
        }

        public Criteria andLoginAreaNotBetween(String value1, String value2) {
            addCriterion("LOGIN_AREA not between", value1, value2, "loginArea");
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