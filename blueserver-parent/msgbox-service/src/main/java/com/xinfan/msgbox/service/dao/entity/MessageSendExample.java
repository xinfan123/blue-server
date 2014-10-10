package com.xinfan.msgbox.service.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageSendExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageSendExample() {
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

        public Criteria andSendUserIdIsNull() {
            addCriterion("SEND_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andSendUserIdIsNotNull() {
            addCriterion("SEND_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andSendUserIdEqualTo(Long value) {
            addCriterion("SEND_USER_ID =", value, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdNotEqualTo(Long value) {
            addCriterion("SEND_USER_ID <>", value, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdGreaterThan(Long value) {
            addCriterion("SEND_USER_ID >", value, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("SEND_USER_ID >=", value, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdLessThan(Long value) {
            addCriterion("SEND_USER_ID <", value, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdLessThanOrEqualTo(Long value) {
            addCriterion("SEND_USER_ID <=", value, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdIn(List<Long> values) {
            addCriterion("SEND_USER_ID in", values, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdNotIn(List<Long> values) {
            addCriterion("SEND_USER_ID not in", values, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdBetween(Long value1, Long value2) {
            addCriterion("SEND_USER_ID between", value1, value2, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andSendUserIdNotBetween(Long value1, Long value2) {
            addCriterion("SEND_USER_ID not between", value1, value2, "sendUserId");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIsNull() {
            addCriterion("PUBLISH_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIsNotNull() {
            addCriterion("PUBLISH_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andPublishStatusEqualTo(Integer value) {
            addCriterion("PUBLISH_STATUS =", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotEqualTo(Integer value) {
            addCriterion("PUBLISH_STATUS <>", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusGreaterThan(Integer value) {
            addCriterion("PUBLISH_STATUS >", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("PUBLISH_STATUS >=", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusLessThan(Integer value) {
            addCriterion("PUBLISH_STATUS <", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusLessThanOrEqualTo(Integer value) {
            addCriterion("PUBLISH_STATUS <=", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIn(List<Integer> values) {
            addCriterion("PUBLISH_STATUS in", values, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotIn(List<Integer> values) {
            addCriterion("PUBLISH_STATUS not in", values, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusBetween(Integer value1, Integer value2) {
            addCriterion("PUBLISH_STATUS between", value1, value2, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("PUBLISH_STATUS not between", value1, value2, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNull() {
            addCriterion("PUBLISH_TIME is null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIsNotNull() {
            addCriterion("PUBLISH_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTimeEqualTo(Date value) {
            addCriterion("PUBLISH_TIME =", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotEqualTo(Date value) {
            addCriterion("PUBLISH_TIME <>", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThan(Date value) {
            addCriterion("PUBLISH_TIME >", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("PUBLISH_TIME >=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThan(Date value) {
            addCriterion("PUBLISH_TIME <", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeLessThanOrEqualTo(Date value) {
            addCriterion("PUBLISH_TIME <=", value, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeIn(List<Date> values) {
            addCriterion("PUBLISH_TIME in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotIn(List<Date> values) {
            addCriterion("PUBLISH_TIME not in", values, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeBetween(Date value1, Date value2) {
            addCriterion("PUBLISH_TIME between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishTimeNotBetween(Date value1, Date value2) {
            addCriterion("PUBLISH_TIME not between", value1, value2, "publishTime");
            return (Criteria) this;
        }

        public Criteria andPublishCountIsNull() {
            addCriterion("PUBLISH_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andPublishCountIsNotNull() {
            addCriterion("PUBLISH_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andPublishCountEqualTo(Integer value) {
            addCriterion("PUBLISH_COUNT =", value, "publishCount");
            return (Criteria) this;
        }

        public Criteria andPublishCountNotEqualTo(Integer value) {
            addCriterion("PUBLISH_COUNT <>", value, "publishCount");
            return (Criteria) this;
        }

        public Criteria andPublishCountGreaterThan(Integer value) {
            addCriterion("PUBLISH_COUNT >", value, "publishCount");
            return (Criteria) this;
        }

        public Criteria andPublishCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("PUBLISH_COUNT >=", value, "publishCount");
            return (Criteria) this;
        }

        public Criteria andPublishCountLessThan(Integer value) {
            addCriterion("PUBLISH_COUNT <", value, "publishCount");
            return (Criteria) this;
        }

        public Criteria andPublishCountLessThanOrEqualTo(Integer value) {
            addCriterion("PUBLISH_COUNT <=", value, "publishCount");
            return (Criteria) this;
        }

        public Criteria andPublishCountIn(List<Integer> values) {
            addCriterion("PUBLISH_COUNT in", values, "publishCount");
            return (Criteria) this;
        }

        public Criteria andPublishCountNotIn(List<Integer> values) {
            addCriterion("PUBLISH_COUNT not in", values, "publishCount");
            return (Criteria) this;
        }

        public Criteria andPublishCountBetween(Integer value1, Integer value2) {
            addCriterion("PUBLISH_COUNT between", value1, value2, "publishCount");
            return (Criteria) this;
        }

        public Criteria andPublishCountNotBetween(Integer value1, Integer value2) {
            addCriterion("PUBLISH_COUNT not between", value1, value2, "publishCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNull() {
            addCriterion("READ_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNotNull() {
            addCriterion("READ_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andReadCountEqualTo(Integer value) {
            addCriterion("READ_COUNT =", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotEqualTo(Integer value) {
            addCriterion("READ_COUNT <>", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThan(Integer value) {
            addCriterion("READ_COUNT >", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("READ_COUNT >=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThan(Integer value) {
            addCriterion("READ_COUNT <", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountLessThanOrEqualTo(Integer value) {
            addCriterion("READ_COUNT <=", value, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountIn(List<Integer> values) {
            addCriterion("READ_COUNT in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotIn(List<Integer> values) {
            addCriterion("READ_COUNT not in", values, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountBetween(Integer value1, Integer value2) {
            addCriterion("READ_COUNT between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andReadCountNotBetween(Integer value1, Integer value2) {
            addCriterion("READ_COUNT not between", value1, value2, "readCount");
            return (Criteria) this;
        }

        public Criteria andPublishTypeIsNull() {
            addCriterion("PUBLISH_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPublishTypeIsNotNull() {
            addCriterion("PUBLISH_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPublishTypeEqualTo(Integer value) {
            addCriterion("PUBLISH_TYPE =", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeNotEqualTo(Integer value) {
            addCriterion("PUBLISH_TYPE <>", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeGreaterThan(Integer value) {
            addCriterion("PUBLISH_TYPE >", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("PUBLISH_TYPE >=", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeLessThan(Integer value) {
            addCriterion("PUBLISH_TYPE <", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeLessThanOrEqualTo(Integer value) {
            addCriterion("PUBLISH_TYPE <=", value, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeIn(List<Integer> values) {
            addCriterion("PUBLISH_TYPE in", values, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeNotIn(List<Integer> values) {
            addCriterion("PUBLISH_TYPE not in", values, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeBetween(Integer value1, Integer value2) {
            addCriterion("PUBLISH_TYPE between", value1, value2, "publishType");
            return (Criteria) this;
        }

        public Criteria andPublishTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("PUBLISH_TYPE not between", value1, value2, "publishType");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNull() {
            addCriterion("SEND_TIME is null");
            return (Criteria) this;
        }

        public Criteria andSendTimeIsNotNull() {
            addCriterion("SEND_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andSendTimeEqualTo(Date value) {
            addCriterion("SEND_TIME =", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotEqualTo(Date value) {
            addCriterion("SEND_TIME <>", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThan(Date value) {
            addCriterion("SEND_TIME >", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("SEND_TIME >=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThan(Date value) {
            addCriterion("SEND_TIME <", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeLessThanOrEqualTo(Date value) {
            addCriterion("SEND_TIME <=", value, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeIn(List<Date> values) {
            addCriterion("SEND_TIME in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotIn(List<Date> values) {
            addCriterion("SEND_TIME not in", values, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeBetween(Date value1, Date value2) {
            addCriterion("SEND_TIME between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendTimeNotBetween(Date value1, Date value2) {
            addCriterion("SEND_TIME not between", value1, value2, "sendTime");
            return (Criteria) this;
        }

        public Criteria andSendCurrentCreditIsNull() {
            addCriterion("SEND_CURRENT_CREDIT is null");
            return (Criteria) this;
        }

        public Criteria andSendCurrentCreditIsNotNull() {
            addCriterion("SEND_CURRENT_CREDIT is not null");
            return (Criteria) this;
        }

        public Criteria andSendCurrentCreditEqualTo(Integer value) {
            addCriterion("SEND_CURRENT_CREDIT =", value, "sendCurrentCredit");
            return (Criteria) this;
        }

        public Criteria andSendCurrentCreditNotEqualTo(Integer value) {
            addCriterion("SEND_CURRENT_CREDIT <>", value, "sendCurrentCredit");
            return (Criteria) this;
        }

        public Criteria andSendCurrentCreditGreaterThan(Integer value) {
            addCriterion("SEND_CURRENT_CREDIT >", value, "sendCurrentCredit");
            return (Criteria) this;
        }

        public Criteria andSendCurrentCreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEND_CURRENT_CREDIT >=", value, "sendCurrentCredit");
            return (Criteria) this;
        }

        public Criteria andSendCurrentCreditLessThan(Integer value) {
            addCriterion("SEND_CURRENT_CREDIT <", value, "sendCurrentCredit");
            return (Criteria) this;
        }

        public Criteria andSendCurrentCreditLessThanOrEqualTo(Integer value) {
            addCriterion("SEND_CURRENT_CREDIT <=", value, "sendCurrentCredit");
            return (Criteria) this;
        }

        public Criteria andSendCurrentCreditIn(List<Integer> values) {
            addCriterion("SEND_CURRENT_CREDIT in", values, "sendCurrentCredit");
            return (Criteria) this;
        }

        public Criteria andSendCurrentCreditNotIn(List<Integer> values) {
            addCriterion("SEND_CURRENT_CREDIT not in", values, "sendCurrentCredit");
            return (Criteria) this;
        }

        public Criteria andSendCurrentCreditBetween(Integer value1, Integer value2) {
            addCriterion("SEND_CURRENT_CREDIT between", value1, value2, "sendCurrentCredit");
            return (Criteria) this;
        }

        public Criteria andSendCurrentCreditNotBetween(Integer value1, Integer value2) {
            addCriterion("SEND_CURRENT_CREDIT not between", value1, value2, "sendCurrentCredit");
            return (Criteria) this;
        }

        public Criteria andNewReplyForSendIsNull() {
            addCriterion("NEW_REPLY_FOR_SEND is null");
            return (Criteria) this;
        }

        public Criteria andNewReplyForSendIsNotNull() {
            addCriterion("NEW_REPLY_FOR_SEND is not null");
            return (Criteria) this;
        }

        public Criteria andNewReplyForSendEqualTo(Integer value) {
            addCriterion("NEW_REPLY_FOR_SEND =", value, "newReplyForSend");
            return (Criteria) this;
        }

        public Criteria andNewReplyForSendNotEqualTo(Integer value) {
            addCriterion("NEW_REPLY_FOR_SEND <>", value, "newReplyForSend");
            return (Criteria) this;
        }

        public Criteria andNewReplyForSendGreaterThan(Integer value) {
            addCriterion("NEW_REPLY_FOR_SEND >", value, "newReplyForSend");
            return (Criteria) this;
        }

        public Criteria andNewReplyForSendGreaterThanOrEqualTo(Integer value) {
            addCriterion("NEW_REPLY_FOR_SEND >=", value, "newReplyForSend");
            return (Criteria) this;
        }

        public Criteria andNewReplyForSendLessThan(Integer value) {
            addCriterion("NEW_REPLY_FOR_SEND <", value, "newReplyForSend");
            return (Criteria) this;
        }

        public Criteria andNewReplyForSendLessThanOrEqualTo(Integer value) {
            addCriterion("NEW_REPLY_FOR_SEND <=", value, "newReplyForSend");
            return (Criteria) this;
        }

        public Criteria andNewReplyForSendIn(List<Integer> values) {
            addCriterion("NEW_REPLY_FOR_SEND in", values, "newReplyForSend");
            return (Criteria) this;
        }

        public Criteria andNewReplyForSendNotIn(List<Integer> values) {
            addCriterion("NEW_REPLY_FOR_SEND not in", values, "newReplyForSend");
            return (Criteria) this;
        }

        public Criteria andNewReplyForSendBetween(Integer value1, Integer value2) {
            addCriterion("NEW_REPLY_FOR_SEND between", value1, value2, "newReplyForSend");
            return (Criteria) this;
        }

        public Criteria andNewReplyForSendNotBetween(Integer value1, Integer value2) {
            addCriterion("NEW_REPLY_FOR_SEND not between", value1, value2, "newReplyForSend");
            return (Criteria) this;
        }

        public Criteria andMsgStatusIsNull() {
            addCriterion("MSG_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andMsgStatusIsNotNull() {
            addCriterion("MSG_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andMsgStatusEqualTo(Integer value) {
            addCriterion("MSG_STATUS =", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusNotEqualTo(Integer value) {
            addCriterion("MSG_STATUS <>", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusGreaterThan(Integer value) {
            addCriterion("MSG_STATUS >", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("MSG_STATUS >=", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusLessThan(Integer value) {
            addCriterion("MSG_STATUS <", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusLessThanOrEqualTo(Integer value) {
            addCriterion("MSG_STATUS <=", value, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusIn(List<Integer> values) {
            addCriterion("MSG_STATUS in", values, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusNotIn(List<Integer> values) {
            addCriterion("MSG_STATUS not in", values, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusBetween(Integer value1, Integer value2) {
            addCriterion("MSG_STATUS between", value1, value2, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andMsgStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("MSG_STATUS not between", value1, value2, "msgStatus");
            return (Criteria) this;
        }

        public Criteria andPublishToIsNull() {
            addCriterion("PUBLISH_TO is null");
            return (Criteria) this;
        }

        public Criteria andPublishToIsNotNull() {
            addCriterion("PUBLISH_TO is not null");
            return (Criteria) this;
        }

        public Criteria andPublishToEqualTo(String value) {
            addCriterion("PUBLISH_TO =", value, "publishTo");
            return (Criteria) this;
        }

        public Criteria andPublishToNotEqualTo(String value) {
            addCriterion("PUBLISH_TO <>", value, "publishTo");
            return (Criteria) this;
        }

        public Criteria andPublishToGreaterThan(String value) {
            addCriterion("PUBLISH_TO >", value, "publishTo");
            return (Criteria) this;
        }

        public Criteria andPublishToGreaterThanOrEqualTo(String value) {
            addCriterion("PUBLISH_TO >=", value, "publishTo");
            return (Criteria) this;
        }

        public Criteria andPublishToLessThan(String value) {
            addCriterion("PUBLISH_TO <", value, "publishTo");
            return (Criteria) this;
        }

        public Criteria andPublishToLessThanOrEqualTo(String value) {
            addCriterion("PUBLISH_TO <=", value, "publishTo");
            return (Criteria) this;
        }

        public Criteria andPublishToLike(String value) {
            addCriterion("PUBLISH_TO like", value, "publishTo");
            return (Criteria) this;
        }

        public Criteria andPublishToNotLike(String value) {
            addCriterion("PUBLISH_TO not like", value, "publishTo");
            return (Criteria) this;
        }

        public Criteria andPublishToIn(List<String> values) {
            addCriterion("PUBLISH_TO in", values, "publishTo");
            return (Criteria) this;
        }

        public Criteria andPublishToNotIn(List<String> values) {
            addCriterion("PUBLISH_TO not in", values, "publishTo");
            return (Criteria) this;
        }

        public Criteria andPublishToBetween(String value1, String value2) {
            addCriterion("PUBLISH_TO between", value1, value2, "publishTo");
            return (Criteria) this;
        }

        public Criteria andPublishToNotBetween(String value1, String value2) {
            addCriterion("PUBLISH_TO not between", value1, value2, "publishTo");
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