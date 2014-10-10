package com.xinfan.msgbox.service.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MessageExample() {
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

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
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

        public Criteria andValidTimeIsNull() {
            addCriterion("VALID_TIME is null");
            return (Criteria) this;
        }

        public Criteria andValidTimeIsNotNull() {
            addCriterion("VALID_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andValidTimeEqualTo(Date value) {
            addCriterion("VALID_TIME =", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotEqualTo(Date value) {
            addCriterion("VALID_TIME <>", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThan(Date value) {
            addCriterion("VALID_TIME >", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("VALID_TIME >=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThan(Date value) {
            addCriterion("VALID_TIME <", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeLessThanOrEqualTo(Date value) {
            addCriterion("VALID_TIME <=", value, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeIn(List<Date> values) {
            addCriterion("VALID_TIME in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotIn(List<Date> values) {
            addCriterion("VALID_TIME not in", values, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeBetween(Date value1, Date value2) {
            addCriterion("VALID_TIME between", value1, value2, "validTime");
            return (Criteria) this;
        }

        public Criteria andValidTimeNotBetween(Date value1, Date value2) {
            addCriterion("VALID_TIME not between", value1, value2, "validTime");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNull() {
            addCriterion("SEND_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andSendTypeIsNotNull() {
            addCriterion("SEND_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andSendTypeEqualTo(Integer value) {
            addCriterion("SEND_TYPE =", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotEqualTo(Integer value) {
            addCriterion("SEND_TYPE <>", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThan(Integer value) {
            addCriterion("SEND_TYPE >", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEND_TYPE >=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThan(Integer value) {
            addCriterion("SEND_TYPE <", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeLessThanOrEqualTo(Integer value) {
            addCriterion("SEND_TYPE <=", value, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeIn(List<Integer> values) {
            addCriterion("SEND_TYPE in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotIn(List<Integer> values) {
            addCriterion("SEND_TYPE not in", values, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeBetween(Integer value1, Integer value2) {
            addCriterion("SEND_TYPE between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("SEND_TYPE not between", value1, value2, "sendType");
            return (Criteria) this;
        }

        public Criteria andSendAreaIsNull() {
            addCriterion("SEND_AREA is null");
            return (Criteria) this;
        }

        public Criteria andSendAreaIsNotNull() {
            addCriterion("SEND_AREA is not null");
            return (Criteria) this;
        }

        public Criteria andSendAreaEqualTo(String value) {
            addCriterion("SEND_AREA =", value, "sendArea");
            return (Criteria) this;
        }

        public Criteria andSendAreaNotEqualTo(String value) {
            addCriterion("SEND_AREA <>", value, "sendArea");
            return (Criteria) this;
        }

        public Criteria andSendAreaGreaterThan(String value) {
            addCriterion("SEND_AREA >", value, "sendArea");
            return (Criteria) this;
        }

        public Criteria andSendAreaGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_AREA >=", value, "sendArea");
            return (Criteria) this;
        }

        public Criteria andSendAreaLessThan(String value) {
            addCriterion("SEND_AREA <", value, "sendArea");
            return (Criteria) this;
        }

        public Criteria andSendAreaLessThanOrEqualTo(String value) {
            addCriterion("SEND_AREA <=", value, "sendArea");
            return (Criteria) this;
        }

        public Criteria andSendAreaLike(String value) {
            addCriterion("SEND_AREA like", value, "sendArea");
            return (Criteria) this;
        }

        public Criteria andSendAreaNotLike(String value) {
            addCriterion("SEND_AREA not like", value, "sendArea");
            return (Criteria) this;
        }

        public Criteria andSendAreaIn(List<String> values) {
            addCriterion("SEND_AREA in", values, "sendArea");
            return (Criteria) this;
        }

        public Criteria andSendAreaNotIn(List<String> values) {
            addCriterion("SEND_AREA not in", values, "sendArea");
            return (Criteria) this;
        }

        public Criteria andSendAreaBetween(String value1, String value2) {
            addCriterion("SEND_AREA between", value1, value2, "sendArea");
            return (Criteria) this;
        }

        public Criteria andSendAreaNotBetween(String value1, String value2) {
            addCriterion("SEND_AREA not between", value1, value2, "sendArea");
            return (Criteria) this;
        }

        public Criteria andSendDistanceIsNull() {
            addCriterion("SEND_DISTANCE is null");
            return (Criteria) this;
        }

        public Criteria andSendDistanceIsNotNull() {
            addCriterion("SEND_DISTANCE is not null");
            return (Criteria) this;
        }

        public Criteria andSendDistanceEqualTo(String value) {
            addCriterion("SEND_DISTANCE =", value, "sendDistance");
            return (Criteria) this;
        }

        public Criteria andSendDistanceNotEqualTo(String value) {
            addCriterion("SEND_DISTANCE <>", value, "sendDistance");
            return (Criteria) this;
        }

        public Criteria andSendDistanceGreaterThan(String value) {
            addCriterion("SEND_DISTANCE >", value, "sendDistance");
            return (Criteria) this;
        }

        public Criteria andSendDistanceGreaterThanOrEqualTo(String value) {
            addCriterion("SEND_DISTANCE >=", value, "sendDistance");
            return (Criteria) this;
        }

        public Criteria andSendDistanceLessThan(String value) {
            addCriterion("SEND_DISTANCE <", value, "sendDistance");
            return (Criteria) this;
        }

        public Criteria andSendDistanceLessThanOrEqualTo(String value) {
            addCriterion("SEND_DISTANCE <=", value, "sendDistance");
            return (Criteria) this;
        }

        public Criteria andSendDistanceLike(String value) {
            addCriterion("SEND_DISTANCE like", value, "sendDistance");
            return (Criteria) this;
        }

        public Criteria andSendDistanceNotLike(String value) {
            addCriterion("SEND_DISTANCE not like", value, "sendDistance");
            return (Criteria) this;
        }

        public Criteria andSendDistanceIn(List<String> values) {
            addCriterion("SEND_DISTANCE in", values, "sendDistance");
            return (Criteria) this;
        }

        public Criteria andSendDistanceNotIn(List<String> values) {
            addCriterion("SEND_DISTANCE not in", values, "sendDistance");
            return (Criteria) this;
        }

        public Criteria andSendDistanceBetween(String value1, String value2) {
            addCriterion("SEND_DISTANCE between", value1, value2, "sendDistance");
            return (Criteria) this;
        }

        public Criteria andSendDistanceNotBetween(String value1, String value2) {
            addCriterion("SEND_DISTANCE not between", value1, value2, "sendDistance");
            return (Criteria) this;
        }

        public Criteria andAmountStatusIsNull() {
            addCriterion("AMOUNT_STATUS is null");
            return (Criteria) this;
        }

        public Criteria andAmountStatusIsNotNull() {
            addCriterion("AMOUNT_STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andAmountStatusEqualTo(Integer value) {
            addCriterion("AMOUNT_STATUS =", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusNotEqualTo(Integer value) {
            addCriterion("AMOUNT_STATUS <>", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusGreaterThan(Integer value) {
            addCriterion("AMOUNT_STATUS >", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("AMOUNT_STATUS >=", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusLessThan(Integer value) {
            addCriterion("AMOUNT_STATUS <", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusLessThanOrEqualTo(Integer value) {
            addCriterion("AMOUNT_STATUS <=", value, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusIn(List<Integer> values) {
            addCriterion("AMOUNT_STATUS in", values, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusNotIn(List<Integer> values) {
            addCriterion("AMOUNT_STATUS not in", values, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusBetween(Integer value1, Integer value2) {
            addCriterion("AMOUNT_STATUS between", value1, value2, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("AMOUNT_STATUS not between", value1, value2, "amountStatus");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("AMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("AMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Long value) {
            addCriterion("AMOUNT =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Long value) {
            addCriterion("AMOUNT <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Long value) {
            addCriterion("AMOUNT >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Long value) {
            addCriterion("AMOUNT >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Long value) {
            addCriterion("AMOUNT <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Long value) {
            addCriterion("AMOUNT <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Long> values) {
            addCriterion("AMOUNT in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Long> values) {
            addCriterion("AMOUNT not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Long value1, Long value2) {
            addCriterion("AMOUNT between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Long value1, Long value2) {
            addCriterion("AMOUNT not between", value1, value2, "amount");
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

        public Criteria andCreateUserIdIsNull() {
            addCriterion("CREATE_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIsNotNull() {
            addCriterion("CREATE_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdEqualTo(Long value) {
            addCriterion("CREATE_USER_ID =", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotEqualTo(Long value) {
            addCriterion("CREATE_USER_ID <>", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThan(Long value) {
            addCriterion("CREATE_USER_ID >", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("CREATE_USER_ID >=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThan(Long value) {
            addCriterion("CREATE_USER_ID <", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("CREATE_USER_ID <=", value, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdIn(List<Long> values) {
            addCriterion("CREATE_USER_ID in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotIn(List<Long> values) {
            addCriterion("CREATE_USER_ID not in", values, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdBetween(Long value1, Long value2) {
            addCriterion("CREATE_USER_ID between", value1, value2, "createUserId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("CREATE_USER_ID not between", value1, value2, "createUserId");
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

        public Criteria andReginCodeIsNull() {
            addCriterion("REGIN_CODE is null");
            return (Criteria) this;
        }

        public Criteria andReginCodeIsNotNull() {
            addCriterion("REGIN_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andReginCodeEqualTo(String value) {
            addCriterion("REGIN_CODE =", value, "reginCode");
            return (Criteria) this;
        }

        public Criteria andReginCodeNotEqualTo(String value) {
            addCriterion("REGIN_CODE <>", value, "reginCode");
            return (Criteria) this;
        }

        public Criteria andReginCodeGreaterThan(String value) {
            addCriterion("REGIN_CODE >", value, "reginCode");
            return (Criteria) this;
        }

        public Criteria andReginCodeGreaterThanOrEqualTo(String value) {
            addCriterion("REGIN_CODE >=", value, "reginCode");
            return (Criteria) this;
        }

        public Criteria andReginCodeLessThan(String value) {
            addCriterion("REGIN_CODE <", value, "reginCode");
            return (Criteria) this;
        }

        public Criteria andReginCodeLessThanOrEqualTo(String value) {
            addCriterion("REGIN_CODE <=", value, "reginCode");
            return (Criteria) this;
        }

        public Criteria andReginCodeLike(String value) {
            addCriterion("REGIN_CODE like", value, "reginCode");
            return (Criteria) this;
        }

        public Criteria andReginCodeNotLike(String value) {
            addCriterion("REGIN_CODE not like", value, "reginCode");
            return (Criteria) this;
        }

        public Criteria andReginCodeIn(List<String> values) {
            addCriterion("REGIN_CODE in", values, "reginCode");
            return (Criteria) this;
        }

        public Criteria andReginCodeNotIn(List<String> values) {
            addCriterion("REGIN_CODE not in", values, "reginCode");
            return (Criteria) this;
        }

        public Criteria andReginCodeBetween(String value1, String value2) {
            addCriterion("REGIN_CODE between", value1, value2, "reginCode");
            return (Criteria) this;
        }

        public Criteria andReginCodeNotBetween(String value1, String value2) {
            addCriterion("REGIN_CODE not between", value1, value2, "reginCode");
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