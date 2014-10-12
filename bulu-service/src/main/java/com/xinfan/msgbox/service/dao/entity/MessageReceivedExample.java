package com.xinfan.msgbox.service.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageReceivedExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageReceivedExample() {
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

        public Criteria andPublishIdIsNull() {
            addCriterion("PUBLISH_ID is null");
            return (Criteria) this;
        }

        public Criteria andPublishIdIsNotNull() {
            addCriterion("PUBLISH_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPublishIdEqualTo(Long value) {
            addCriterion("PUBLISH_ID =", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotEqualTo(Long value) {
            addCriterion("PUBLISH_ID <>", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdGreaterThan(Long value) {
            addCriterion("PUBLISH_ID >", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdGreaterThanOrEqualTo(Long value) {
            addCriterion("PUBLISH_ID >=", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLessThan(Long value) {
            addCriterion("PUBLISH_ID <", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdLessThanOrEqualTo(Long value) {
            addCriterion("PUBLISH_ID <=", value, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdIn(List<Long> values) {
            addCriterion("PUBLISH_ID in", values, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotIn(List<Long> values) {
            addCriterion("PUBLISH_ID not in", values, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdBetween(Long value1, Long value2) {
            addCriterion("PUBLISH_ID between", value1, value2, "publishId");
            return (Criteria) this;
        }

        public Criteria andPublishIdNotBetween(Long value1, Long value2) {
            addCriterion("PUBLISH_ID not between", value1, value2, "publishId");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNull() {
            addCriterion("MSG_ID is null");
            return (Criteria) this;
        }

        public Criteria andMsgIdIsNotNull() {
            addCriterion("MSG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andMsgIdEqualTo(Long value) {
            addCriterion("MSG_ID =", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotEqualTo(Long value) {
            addCriterion("MSG_ID <>", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThan(Long value) {
            addCriterion("MSG_ID >", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("MSG_ID >=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThan(Long value) {
            addCriterion("MSG_ID <", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdLessThanOrEqualTo(Long value) {
            addCriterion("MSG_ID <=", value, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdIn(List<Long> values) {
            addCriterion("MSG_ID in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotIn(List<Long> values) {
            addCriterion("MSG_ID not in", values, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdBetween(Long value1, Long value2) {
            addCriterion("MSG_ID between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andMsgIdNotBetween(Long value1, Long value2) {
            addCriterion("MSG_ID not between", value1, value2, "msgId");
            return (Criteria) this;
        }

        public Criteria andReceivedUseridIsNull() {
            addCriterion("RECEIVED_USERID is null");
            return (Criteria) this;
        }

        public Criteria andReceivedUseridIsNotNull() {
            addCriterion("RECEIVED_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedUseridEqualTo(Long value) {
            addCriterion("RECEIVED_USERID =", value, "receivedUserid");
            return (Criteria) this;
        }

        public Criteria andReceivedUseridNotEqualTo(Long value) {
            addCriterion("RECEIVED_USERID <>", value, "receivedUserid");
            return (Criteria) this;
        }

        public Criteria andReceivedUseridGreaterThan(Long value) {
            addCriterion("RECEIVED_USERID >", value, "receivedUserid");
            return (Criteria) this;
        }

        public Criteria andReceivedUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("RECEIVED_USERID >=", value, "receivedUserid");
            return (Criteria) this;
        }

        public Criteria andReceivedUseridLessThan(Long value) {
            addCriterion("RECEIVED_USERID <", value, "receivedUserid");
            return (Criteria) this;
        }

        public Criteria andReceivedUseridLessThanOrEqualTo(Long value) {
            addCriterion("RECEIVED_USERID <=", value, "receivedUserid");
            return (Criteria) this;
        }

        public Criteria andReceivedUseridIn(List<Long> values) {
            addCriterion("RECEIVED_USERID in", values, "receivedUserid");
            return (Criteria) this;
        }

        public Criteria andReceivedUseridNotIn(List<Long> values) {
            addCriterion("RECEIVED_USERID not in", values, "receivedUserid");
            return (Criteria) this;
        }

        public Criteria andReceivedUseridBetween(Long value1, Long value2) {
            addCriterion("RECEIVED_USERID between", value1, value2, "receivedUserid");
            return (Criteria) this;
        }

        public Criteria andReceivedUseridNotBetween(Long value1, Long value2) {
            addCriterion("RECEIVED_USERID not between", value1, value2, "receivedUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridIsNull() {
            addCriterion("SEND_USERID is null");
            return (Criteria) this;
        }

        public Criteria andSendUseridIsNotNull() {
            addCriterion("SEND_USERID is not null");
            return (Criteria) this;
        }

        public Criteria andSendUseridEqualTo(Long value) {
            addCriterion("SEND_USERID =", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridNotEqualTo(Long value) {
            addCriterion("SEND_USERID <>", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridGreaterThan(Long value) {
            addCriterion("SEND_USERID >", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridGreaterThanOrEqualTo(Long value) {
            addCriterion("SEND_USERID >=", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridLessThan(Long value) {
            addCriterion("SEND_USERID <", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridLessThanOrEqualTo(Long value) {
            addCriterion("SEND_USERID <=", value, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridIn(List<Long> values) {
            addCriterion("SEND_USERID in", values, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridNotIn(List<Long> values) {
            addCriterion("SEND_USERID not in", values, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridBetween(Long value1, Long value2) {
            addCriterion("SEND_USERID between", value1, value2, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendUseridNotBetween(Long value1, Long value2) {
            addCriterion("SEND_USERID not between", value1, value2, "sendUserid");
            return (Criteria) this;
        }

        public Criteria andSendNewReplyIsNull() {
            addCriterion("SEND_NEW_REPLY is null");
            return (Criteria) this;
        }

        public Criteria andSendNewReplyIsNotNull() {
            addCriterion("SEND_NEW_REPLY is not null");
            return (Criteria) this;
        }

        public Criteria andSendNewReplyEqualTo(Integer value) {
            addCriterion("SEND_NEW_REPLY =", value, "sendNewReply");
            return (Criteria) this;
        }

        public Criteria andSendNewReplyNotEqualTo(Integer value) {
            addCriterion("SEND_NEW_REPLY <>", value, "sendNewReply");
            return (Criteria) this;
        }

        public Criteria andSendNewReplyGreaterThan(Integer value) {
            addCriterion("SEND_NEW_REPLY >", value, "sendNewReply");
            return (Criteria) this;
        }

        public Criteria andSendNewReplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEND_NEW_REPLY >=", value, "sendNewReply");
            return (Criteria) this;
        }

        public Criteria andSendNewReplyLessThan(Integer value) {
            addCriterion("SEND_NEW_REPLY <", value, "sendNewReply");
            return (Criteria) this;
        }

        public Criteria andSendNewReplyLessThanOrEqualTo(Integer value) {
            addCriterion("SEND_NEW_REPLY <=", value, "sendNewReply");
            return (Criteria) this;
        }

        public Criteria andSendNewReplyIn(List<Integer> values) {
            addCriterion("SEND_NEW_REPLY in", values, "sendNewReply");
            return (Criteria) this;
        }

        public Criteria andSendNewReplyNotIn(List<Integer> values) {
            addCriterion("SEND_NEW_REPLY not in", values, "sendNewReply");
            return (Criteria) this;
        }

        public Criteria andSendNewReplyBetween(Integer value1, Integer value2) {
            addCriterion("SEND_NEW_REPLY between", value1, value2, "sendNewReply");
            return (Criteria) this;
        }

        public Criteria andSendNewReplyNotBetween(Integer value1, Integer value2) {
            addCriterion("SEND_NEW_REPLY not between", value1, value2, "sendNewReply");
            return (Criteria) this;
        }

        public Criteria andReceivedNewReplyIsNull() {
            addCriterion("RECEIVED_NEW_REPLY is null");
            return (Criteria) this;
        }

        public Criteria andReceivedNewReplyIsNotNull() {
            addCriterion("RECEIVED_NEW_REPLY is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedNewReplyEqualTo(Integer value) {
            addCriterion("RECEIVED_NEW_REPLY =", value, "receivedNewReply");
            return (Criteria) this;
        }

        public Criteria andReceivedNewReplyNotEqualTo(Integer value) {
            addCriterion("RECEIVED_NEW_REPLY <>", value, "receivedNewReply");
            return (Criteria) this;
        }

        public Criteria andReceivedNewReplyGreaterThan(Integer value) {
            addCriterion("RECEIVED_NEW_REPLY >", value, "receivedNewReply");
            return (Criteria) this;
        }

        public Criteria andReceivedNewReplyGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECEIVED_NEW_REPLY >=", value, "receivedNewReply");
            return (Criteria) this;
        }

        public Criteria andReceivedNewReplyLessThan(Integer value) {
            addCriterion("RECEIVED_NEW_REPLY <", value, "receivedNewReply");
            return (Criteria) this;
        }

        public Criteria andReceivedNewReplyLessThanOrEqualTo(Integer value) {
            addCriterion("RECEIVED_NEW_REPLY <=", value, "receivedNewReply");
            return (Criteria) this;
        }

        public Criteria andReceivedNewReplyIn(List<Integer> values) {
            addCriterion("RECEIVED_NEW_REPLY in", values, "receivedNewReply");
            return (Criteria) this;
        }

        public Criteria andReceivedNewReplyNotIn(List<Integer> values) {
            addCriterion("RECEIVED_NEW_REPLY not in", values, "receivedNewReply");
            return (Criteria) this;
        }

        public Criteria andReceivedNewReplyBetween(Integer value1, Integer value2) {
            addCriterion("RECEIVED_NEW_REPLY between", value1, value2, "receivedNewReply");
            return (Criteria) this;
        }

        public Criteria andReceivedNewReplyNotBetween(Integer value1, Integer value2) {
            addCriterion("RECEIVED_NEW_REPLY not between", value1, value2, "receivedNewReply");
            return (Criteria) this;
        }

        public Criteria andReceivedStausIsNull() {
            addCriterion("RECEIVED_STAUS is null");
            return (Criteria) this;
        }

        public Criteria andReceivedStausIsNotNull() {
            addCriterion("RECEIVED_STAUS is not null");
            return (Criteria) this;
        }

        public Criteria andReceivedStausEqualTo(Integer value) {
            addCriterion("RECEIVED_STAUS =", value, "receivedStaus");
            return (Criteria) this;
        }

        public Criteria andReceivedStausNotEqualTo(Integer value) {
            addCriterion("RECEIVED_STAUS <>", value, "receivedStaus");
            return (Criteria) this;
        }

        public Criteria andReceivedStausGreaterThan(Integer value) {
            addCriterion("RECEIVED_STAUS >", value, "receivedStaus");
            return (Criteria) this;
        }

        public Criteria andReceivedStausGreaterThanOrEqualTo(Integer value) {
            addCriterion("RECEIVED_STAUS >=", value, "receivedStaus");
            return (Criteria) this;
        }

        public Criteria andReceivedStausLessThan(Integer value) {
            addCriterion("RECEIVED_STAUS <", value, "receivedStaus");
            return (Criteria) this;
        }

        public Criteria andReceivedStausLessThanOrEqualTo(Integer value) {
            addCriterion("RECEIVED_STAUS <=", value, "receivedStaus");
            return (Criteria) this;
        }

        public Criteria andReceivedStausIn(List<Integer> values) {
            addCriterion("RECEIVED_STAUS in", values, "receivedStaus");
            return (Criteria) this;
        }

        public Criteria andReceivedStausNotIn(List<Integer> values) {
            addCriterion("RECEIVED_STAUS not in", values, "receivedStaus");
            return (Criteria) this;
        }

        public Criteria andReceivedStausBetween(Integer value1, Integer value2) {
            addCriterion("RECEIVED_STAUS between", value1, value2, "receivedStaus");
            return (Criteria) this;
        }

        public Criteria andReceivedStausNotBetween(Integer value1, Integer value2) {
            addCriterion("RECEIVED_STAUS not between", value1, value2, "receivedStaus");
            return (Criteria) this;
        }

        public Criteria andReadTimeIsNull() {
            addCriterion("READ_TIME is null");
            return (Criteria) this;
        }

        public Criteria andReadTimeIsNotNull() {
            addCriterion("READ_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andReadTimeEqualTo(Date value) {
            addCriterion("READ_TIME =", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotEqualTo(Date value) {
            addCriterion("READ_TIME <>", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeGreaterThan(Date value) {
            addCriterion("READ_TIME >", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("READ_TIME >=", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeLessThan(Date value) {
            addCriterion("READ_TIME <", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeLessThanOrEqualTo(Date value) {
            addCriterion("READ_TIME <=", value, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeIn(List<Date> values) {
            addCriterion("READ_TIME in", values, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotIn(List<Date> values) {
            addCriterion("READ_TIME not in", values, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeBetween(Date value1, Date value2) {
            addCriterion("READ_TIME between", value1, value2, "readTime");
            return (Criteria) this;
        }

        public Criteria andReadTimeNotBetween(Date value1, Date value2) {
            addCriterion("READ_TIME not between", value1, value2, "readTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNull() {
            addCriterion("DELETE_TIME is null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIsNotNull() {
            addCriterion("DELETE_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeEqualTo(Date value) {
            addCriterion("DELETE_TIME =", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotEqualTo(Date value) {
            addCriterion("DELETE_TIME <>", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThan(Date value) {
            addCriterion("DELETE_TIME >", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("DELETE_TIME >=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThan(Date value) {
            addCriterion("DELETE_TIME <", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeLessThanOrEqualTo(Date value) {
            addCriterion("DELETE_TIME <=", value, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeIn(List<Date> values) {
            addCriterion("DELETE_TIME in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotIn(List<Date> values) {
            addCriterion("DELETE_TIME not in", values, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeBetween(Date value1, Date value2) {
            addCriterion("DELETE_TIME between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andDeleteTimeNotBetween(Date value1, Date value2) {
            addCriterion("DELETE_TIME not between", value1, value2, "deleteTime");
            return (Criteria) this;
        }

        public Criteria andPubishTimeIsNull() {
            addCriterion("PUBISH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPubishTimeIsNotNull() {
            addCriterion("PUBISH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPubishTimeEqualTo(Date value) {
            addCriterion("PUBISH_TIME =", value, "pubishTime");
            return (Criteria) this;
        }

        public Criteria andPubishTimeNotEqualTo(Date value) {
            addCriterion("PUBISH_TIME <>", value, "pubishTime");
            return (Criteria) this;
        }

        public Criteria andPubishTimeGreaterThan(Date value) {
            addCriterion("PUBISH_TIME >", value, "pubishTime");
            return (Criteria) this;
        }

        public Criteria andPubishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PUBISH_TIME >=", value, "pubishTime");
            return (Criteria) this;
        }

        public Criteria andPubishTimeLessThan(Date value) {
            addCriterion("PUBISH_TIME <", value, "pubishTime");
            return (Criteria) this;
        }

        public Criteria andPubishTimeLessThanOrEqualTo(Date value) {
            addCriterion("PUBISH_TIME <=", value, "pubishTime");
            return (Criteria) this;
        }

        public Criteria andPubishTimeIn(List<Date> values) {
            addCriterion("PUBISH_TIME in", values, "pubishTime");
            return (Criteria) this;
        }

        public Criteria andPubishTimeNotIn(List<Date> values) {
            addCriterion("PUBISH_TIME not in", values, "pubishTime");
            return (Criteria) this;
        }

        public Criteria andPubishTimeBetween(Date value1, Date value2) {
            addCriterion("PUBISH_TIME between", value1, value2, "pubishTime");
            return (Criteria) this;
        }

        public Criteria andPubishTimeNotBetween(Date value1, Date value2) {
            addCriterion("PUBISH_TIME not between", value1, value2, "pubishTime");
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