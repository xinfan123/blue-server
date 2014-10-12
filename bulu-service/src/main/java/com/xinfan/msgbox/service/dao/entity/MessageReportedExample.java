package com.xinfan.msgbox.service.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageReportedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageReportedExample() {
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

        public Criteria andReportedIdIsNull() {
            addCriterion("REPORTED_ID is null");
            return (Criteria) this;
        }

        public Criteria andReportedIdIsNotNull() {
            addCriterion("REPORTED_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReportedIdEqualTo(Long value) {
            addCriterion("REPORTED_ID =", value, "reportedId");
            return (Criteria) this;
        }

        public Criteria andReportedIdNotEqualTo(Long value) {
            addCriterion("REPORTED_ID <>", value, "reportedId");
            return (Criteria) this;
        }

        public Criteria andReportedIdGreaterThan(Long value) {
            addCriterion("REPORTED_ID >", value, "reportedId");
            return (Criteria) this;
        }

        public Criteria andReportedIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REPORTED_ID >=", value, "reportedId");
            return (Criteria) this;
        }

        public Criteria andReportedIdLessThan(Long value) {
            addCriterion("REPORTED_ID <", value, "reportedId");
            return (Criteria) this;
        }

        public Criteria andReportedIdLessThanOrEqualTo(Long value) {
            addCriterion("REPORTED_ID <=", value, "reportedId");
            return (Criteria) this;
        }

        public Criteria andReportedIdIn(List<Long> values) {
            addCriterion("REPORTED_ID in", values, "reportedId");
            return (Criteria) this;
        }

        public Criteria andReportedIdNotIn(List<Long> values) {
            addCriterion("REPORTED_ID not in", values, "reportedId");
            return (Criteria) this;
        }

        public Criteria andReportedIdBetween(Long value1, Long value2) {
            addCriterion("REPORTED_ID between", value1, value2, "reportedId");
            return (Criteria) this;
        }

        public Criteria andReportedIdNotBetween(Long value1, Long value2) {
            addCriterion("REPORTED_ID not between", value1, value2, "reportedId");
            return (Criteria) this;
        }

        public Criteria andBeReportedUserIdIsNull() {
            addCriterion("BE_REPORTED_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andBeReportedUserIdIsNotNull() {
            addCriterion("BE_REPORTED_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBeReportedUserIdEqualTo(Long value) {
            addCriterion("BE_REPORTED_USER_ID =", value, "beReportedUserId");
            return (Criteria) this;
        }

        public Criteria andBeReportedUserIdNotEqualTo(Long value) {
            addCriterion("BE_REPORTED_USER_ID <>", value, "beReportedUserId");
            return (Criteria) this;
        }

        public Criteria andBeReportedUserIdGreaterThan(Long value) {
            addCriterion("BE_REPORTED_USER_ID >", value, "beReportedUserId");
            return (Criteria) this;
        }

        public Criteria andBeReportedUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BE_REPORTED_USER_ID >=", value, "beReportedUserId");
            return (Criteria) this;
        }

        public Criteria andBeReportedUserIdLessThan(Long value) {
            addCriterion("BE_REPORTED_USER_ID <", value, "beReportedUserId");
            return (Criteria) this;
        }

        public Criteria andBeReportedUserIdLessThanOrEqualTo(Long value) {
            addCriterion("BE_REPORTED_USER_ID <=", value, "beReportedUserId");
            return (Criteria) this;
        }

        public Criteria andBeReportedUserIdIn(List<Long> values) {
            addCriterion("BE_REPORTED_USER_ID in", values, "beReportedUserId");
            return (Criteria) this;
        }

        public Criteria andBeReportedUserIdNotIn(List<Long> values) {
            addCriterion("BE_REPORTED_USER_ID not in", values, "beReportedUserId");
            return (Criteria) this;
        }

        public Criteria andBeReportedUserIdBetween(Long value1, Long value2) {
            addCriterion("BE_REPORTED_USER_ID between", value1, value2, "beReportedUserId");
            return (Criteria) this;
        }

        public Criteria andBeReportedUserIdNotBetween(Long value1, Long value2) {
            addCriterion("BE_REPORTED_USER_ID not between", value1, value2, "beReportedUserId");
            return (Criteria) this;
        }

        public Criteria andBeReportedMsgIdIsNull() {
            addCriterion("BE_REPORTED_MSG_ID is null");
            return (Criteria) this;
        }

        public Criteria andBeReportedMsgIdIsNotNull() {
            addCriterion("BE_REPORTED_MSG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBeReportedMsgIdEqualTo(Long value) {
            addCriterion("BE_REPORTED_MSG_ID =", value, "beReportedMsgId");
            return (Criteria) this;
        }

        public Criteria andBeReportedMsgIdNotEqualTo(Long value) {
            addCriterion("BE_REPORTED_MSG_ID <>", value, "beReportedMsgId");
            return (Criteria) this;
        }

        public Criteria andBeReportedMsgIdGreaterThan(Long value) {
            addCriterion("BE_REPORTED_MSG_ID >", value, "beReportedMsgId");
            return (Criteria) this;
        }

        public Criteria andBeReportedMsgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("BE_REPORTED_MSG_ID >=", value, "beReportedMsgId");
            return (Criteria) this;
        }

        public Criteria andBeReportedMsgIdLessThan(Long value) {
            addCriterion("BE_REPORTED_MSG_ID <", value, "beReportedMsgId");
            return (Criteria) this;
        }

        public Criteria andBeReportedMsgIdLessThanOrEqualTo(Long value) {
            addCriterion("BE_REPORTED_MSG_ID <=", value, "beReportedMsgId");
            return (Criteria) this;
        }

        public Criteria andBeReportedMsgIdIn(List<Long> values) {
            addCriterion("BE_REPORTED_MSG_ID in", values, "beReportedMsgId");
            return (Criteria) this;
        }

        public Criteria andBeReportedMsgIdNotIn(List<Long> values) {
            addCriterion("BE_REPORTED_MSG_ID not in", values, "beReportedMsgId");
            return (Criteria) this;
        }

        public Criteria andBeReportedMsgIdBetween(Long value1, Long value2) {
            addCriterion("BE_REPORTED_MSG_ID between", value1, value2, "beReportedMsgId");
            return (Criteria) this;
        }

        public Criteria andBeReportedMsgIdNotBetween(Long value1, Long value2) {
            addCriterion("BE_REPORTED_MSG_ID not between", value1, value2, "beReportedMsgId");
            return (Criteria) this;
        }

        public Criteria andContextIsNull() {
            addCriterion("CONTEXT is null");
            return (Criteria) this;
        }

        public Criteria andContextIsNotNull() {
            addCriterion("CONTEXT is not null");
            return (Criteria) this;
        }

        public Criteria andContextEqualTo(String value) {
            addCriterion("CONTEXT =", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotEqualTo(String value) {
            addCriterion("CONTEXT <>", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThan(String value) {
            addCriterion("CONTEXT >", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            addCriterion("CONTEXT >=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThan(String value) {
            addCriterion("CONTEXT <", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            addCriterion("CONTEXT <=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLike(String value) {
            addCriterion("CONTEXT like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotLike(String value) {
            addCriterion("CONTEXT not like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextIn(List<String> values) {
            addCriterion("CONTEXT in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotIn(List<String> values) {
            addCriterion("CONTEXT not in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextBetween(String value1, String value2) {
            addCriterion("CONTEXT between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotBetween(String value1, String value2) {
            addCriterion("CONTEXT not between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andReportTypeIsNull() {
            addCriterion("REPORT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andReportTypeIsNotNull() {
            addCriterion("REPORT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andReportTypeEqualTo(Integer value) {
            addCriterion("REPORT_TYPE =", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeNotEqualTo(Integer value) {
            addCriterion("REPORT_TYPE <>", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeGreaterThan(Integer value) {
            addCriterion("REPORT_TYPE >", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("REPORT_TYPE >=", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeLessThan(Integer value) {
            addCriterion("REPORT_TYPE <", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeLessThanOrEqualTo(Integer value) {
            addCriterion("REPORT_TYPE <=", value, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeIn(List<Integer> values) {
            addCriterion("REPORT_TYPE in", values, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeNotIn(List<Integer> values) {
            addCriterion("REPORT_TYPE not in", values, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeBetween(Integer value1, Integer value2) {
            addCriterion("REPORT_TYPE between", value1, value2, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("REPORT_TYPE not between", value1, value2, "reportType");
            return (Criteria) this;
        }

        public Criteria andReportUserIdIsNull() {
            addCriterion("REPORT_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andReportUserIdIsNotNull() {
            addCriterion("REPORT_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReportUserIdEqualTo(Long value) {
            addCriterion("REPORT_USER_ID =", value, "reportUserId");
            return (Criteria) this;
        }

        public Criteria andReportUserIdNotEqualTo(Long value) {
            addCriterion("REPORT_USER_ID <>", value, "reportUserId");
            return (Criteria) this;
        }

        public Criteria andReportUserIdGreaterThan(Long value) {
            addCriterion("REPORT_USER_ID >", value, "reportUserId");
            return (Criteria) this;
        }

        public Criteria andReportUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("REPORT_USER_ID >=", value, "reportUserId");
            return (Criteria) this;
        }

        public Criteria andReportUserIdLessThan(Long value) {
            addCriterion("REPORT_USER_ID <", value, "reportUserId");
            return (Criteria) this;
        }

        public Criteria andReportUserIdLessThanOrEqualTo(Long value) {
            addCriterion("REPORT_USER_ID <=", value, "reportUserId");
            return (Criteria) this;
        }

        public Criteria andReportUserIdIn(List<Long> values) {
            addCriterion("REPORT_USER_ID in", values, "reportUserId");
            return (Criteria) this;
        }

        public Criteria andReportUserIdNotIn(List<Long> values) {
            addCriterion("REPORT_USER_ID not in", values, "reportUserId");
            return (Criteria) this;
        }

        public Criteria andReportUserIdBetween(Long value1, Long value2) {
            addCriterion("REPORT_USER_ID between", value1, value2, "reportUserId");
            return (Criteria) this;
        }

        public Criteria andReportUserIdNotBetween(Long value1, Long value2) {
            addCriterion("REPORT_USER_ID not between", value1, value2, "reportUserId");
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

        public Criteria andDealStatusIsNull() {
            addCriterion("DEAL_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andDealStatusIsNotNull() {
            addCriterion("DEAL_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andDealStatusEqualTo(Integer value) {
            addCriterion("DEAL_STATUS =", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotEqualTo(Integer value) {
            addCriterion("DEAL_STATUS <>", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThan(Integer value) {
            addCriterion("DEAL_STATUS >", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEAL_STATUS >=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThan(Integer value) {
            addCriterion("DEAL_STATUS <", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusLessThanOrEqualTo(Integer value) {
            addCriterion("DEAL_STATUS <=", value, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusIn(List<Integer> values) {
            addCriterion("DEAL_STATUS in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotIn(List<Integer> values) {
            addCriterion("DEAL_STATUS not in", values, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusBetween(Integer value1, Integer value2) {
            addCriterion("DEAL_STATUS between", value1, value2, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("DEAL_STATUS not between", value1, value2, "dealStatus");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNull() {
            addCriterion("DEAL_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andDealResultIsNotNull() {
            addCriterion("DEAL_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andDealResultEqualTo(String value) {
            addCriterion("DEAL_RESULT =", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotEqualTo(String value) {
            addCriterion("DEAL_RESULT <>", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThan(String value) {
            addCriterion("DEAL_RESULT >", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultGreaterThanOrEqualTo(String value) {
            addCriterion("DEAL_RESULT >=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThan(String value) {
            addCriterion("DEAL_RESULT <", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLessThanOrEqualTo(String value) {
            addCriterion("DEAL_RESULT <=", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultLike(String value) {
            addCriterion("DEAL_RESULT like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotLike(String value) {
            addCriterion("DEAL_RESULT not like", value, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultIn(List<String> values) {
            addCriterion("DEAL_RESULT in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotIn(List<String> values) {
            addCriterion("DEAL_RESULT not in", values, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultBetween(String value1, String value2) {
            addCriterion("DEAL_RESULT between", value1, value2, "dealResult");
            return (Criteria) this;
        }

        public Criteria andDealResultNotBetween(String value1, String value2) {
            addCriterion("DEAL_RESULT not between", value1, value2, "dealResult");
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