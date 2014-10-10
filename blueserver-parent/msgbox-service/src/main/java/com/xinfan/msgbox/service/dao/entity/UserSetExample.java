package com.xinfan.msgbox.service.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserSetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserSetExample() {
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

        public Criteria andNewMsgNotifyIsNull() {
            addCriterion("NEW_MSG_NOTIFY is null");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotifyIsNotNull() {
            addCriterion("NEW_MSG_NOTIFY is not null");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotifyEqualTo(Integer value) {
            addCriterion("NEW_MSG_NOTIFY =", value, "newMsgNotify");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotifyNotEqualTo(Integer value) {
            addCriterion("NEW_MSG_NOTIFY <>", value, "newMsgNotify");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotifyGreaterThan(Integer value) {
            addCriterion("NEW_MSG_NOTIFY >", value, "newMsgNotify");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("NEW_MSG_NOTIFY >=", value, "newMsgNotify");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotifyLessThan(Integer value) {
            addCriterion("NEW_MSG_NOTIFY <", value, "newMsgNotify");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotifyLessThanOrEqualTo(Integer value) {
            addCriterion("NEW_MSG_NOTIFY <=", value, "newMsgNotify");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotifyIn(List<Integer> values) {
            addCriterion("NEW_MSG_NOTIFY in", values, "newMsgNotify");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotifyNotIn(List<Integer> values) {
            addCriterion("NEW_MSG_NOTIFY not in", values, "newMsgNotify");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotifyBetween(Integer value1, Integer value2) {
            addCriterion("NEW_MSG_NOTIFY between", value1, value2, "newMsgNotify");
            return (Criteria) this;
        }

        public Criteria andNewMsgNotifyNotBetween(Integer value1, Integer value2) {
            addCriterion("NEW_MSG_NOTIFY not between", value1, value2, "newMsgNotify");
            return (Criteria) this;
        }

        public Criteria andVoiceIsNull() {
            addCriterion("VOICE is null");
            return (Criteria) this;
        }

        public Criteria andVoiceIsNotNull() {
            addCriterion("VOICE is not null");
            return (Criteria) this;
        }

        public Criteria andVoiceEqualTo(Integer value) {
            addCriterion("VOICE =", value, "voice");
            return (Criteria) this;
        }

        public Criteria andVoiceNotEqualTo(Integer value) {
            addCriterion("VOICE <>", value, "voice");
            return (Criteria) this;
        }

        public Criteria andVoiceGreaterThan(Integer value) {
            addCriterion("VOICE >", value, "voice");
            return (Criteria) this;
        }

        public Criteria andVoiceGreaterThanOrEqualTo(Integer value) {
            addCriterion("VOICE >=", value, "voice");
            return (Criteria) this;
        }

        public Criteria andVoiceLessThan(Integer value) {
            addCriterion("VOICE <", value, "voice");
            return (Criteria) this;
        }

        public Criteria andVoiceLessThanOrEqualTo(Integer value) {
            addCriterion("VOICE <=", value, "voice");
            return (Criteria) this;
        }

        public Criteria andVoiceIn(List<Integer> values) {
            addCriterion("VOICE in", values, "voice");
            return (Criteria) this;
        }

        public Criteria andVoiceNotIn(List<Integer> values) {
            addCriterion("VOICE not in", values, "voice");
            return (Criteria) this;
        }

        public Criteria andVoiceBetween(Integer value1, Integer value2) {
            addCriterion("VOICE between", value1, value2, "voice");
            return (Criteria) this;
        }

        public Criteria andVoiceNotBetween(Integer value1, Integer value2) {
            addCriterion("VOICE not between", value1, value2, "voice");
            return (Criteria) this;
        }

        public Criteria andVibrateIsNull() {
            addCriterion("VIBRATE is null");
            return (Criteria) this;
        }

        public Criteria andVibrateIsNotNull() {
            addCriterion("VIBRATE is not null");
            return (Criteria) this;
        }

        public Criteria andVibrateEqualTo(Integer value) {
            addCriterion("VIBRATE =", value, "vibrate");
            return (Criteria) this;
        }

        public Criteria andVibrateNotEqualTo(Integer value) {
            addCriterion("VIBRATE <>", value, "vibrate");
            return (Criteria) this;
        }

        public Criteria andVibrateGreaterThan(Integer value) {
            addCriterion("VIBRATE >", value, "vibrate");
            return (Criteria) this;
        }

        public Criteria andVibrateGreaterThanOrEqualTo(Integer value) {
            addCriterion("VIBRATE >=", value, "vibrate");
            return (Criteria) this;
        }

        public Criteria andVibrateLessThan(Integer value) {
            addCriterion("VIBRATE <", value, "vibrate");
            return (Criteria) this;
        }

        public Criteria andVibrateLessThanOrEqualTo(Integer value) {
            addCriterion("VIBRATE <=", value, "vibrate");
            return (Criteria) this;
        }

        public Criteria andVibrateIn(List<Integer> values) {
            addCriterion("VIBRATE in", values, "vibrate");
            return (Criteria) this;
        }

        public Criteria andVibrateNotIn(List<Integer> values) {
            addCriterion("VIBRATE not in", values, "vibrate");
            return (Criteria) this;
        }

        public Criteria andVibrateBetween(Integer value1, Integer value2) {
            addCriterion("VIBRATE between", value1, value2, "vibrate");
            return (Criteria) this;
        }

        public Criteria andVibrateNotBetween(Integer value1, Integer value2) {
            addCriterion("VIBRATE not between", value1, value2, "vibrate");
            return (Criteria) this;
        }

        public Criteria andMaxCountIsNull() {
            addCriterion("MAX_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andMaxCountIsNotNull() {
            addCriterion("MAX_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andMaxCountEqualTo(Integer value) {
            addCriterion("MAX_COUNT =", value, "maxCount");
            return (Criteria) this;
        }

        public Criteria andMaxCountNotEqualTo(Integer value) {
            addCriterion("MAX_COUNT <>", value, "maxCount");
            return (Criteria) this;
        }

        public Criteria andMaxCountGreaterThan(Integer value) {
            addCriterion("MAX_COUNT >", value, "maxCount");
            return (Criteria) this;
        }

        public Criteria andMaxCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("MAX_COUNT >=", value, "maxCount");
            return (Criteria) this;
        }

        public Criteria andMaxCountLessThan(Integer value) {
            addCriterion("MAX_COUNT <", value, "maxCount");
            return (Criteria) this;
        }

        public Criteria andMaxCountLessThanOrEqualTo(Integer value) {
            addCriterion("MAX_COUNT <=", value, "maxCount");
            return (Criteria) this;
        }

        public Criteria andMaxCountIn(List<Integer> values) {
            addCriterion("MAX_COUNT in", values, "maxCount");
            return (Criteria) this;
        }

        public Criteria andMaxCountNotIn(List<Integer> values) {
            addCriterion("MAX_COUNT not in", values, "maxCount");
            return (Criteria) this;
        }

        public Criteria andMaxCountBetween(Integer value1, Integer value2) {
            addCriterion("MAX_COUNT between", value1, value2, "maxCount");
            return (Criteria) this;
        }

        public Criteria andMaxCountNotBetween(Integer value1, Integer value2) {
            addCriterion("MAX_COUNT not between", value1, value2, "maxCount");
            return (Criteria) this;
        }

        public Criteria andSimilarLevelIsNull() {
            addCriterion("SIMILAR_LEVEL is null");
            return (Criteria) this;
        }

        public Criteria andSimilarLevelIsNotNull() {
            addCriterion("SIMILAR_LEVEL is not null");
            return (Criteria) this;
        }

        public Criteria andSimilarLevelEqualTo(Integer value) {
            addCriterion("SIMILAR_LEVEL =", value, "similarLevel");
            return (Criteria) this;
        }

        public Criteria andSimilarLevelNotEqualTo(Integer value) {
            addCriterion("SIMILAR_LEVEL <>", value, "similarLevel");
            return (Criteria) this;
        }

        public Criteria andSimilarLevelGreaterThan(Integer value) {
            addCriterion("SIMILAR_LEVEL >", value, "similarLevel");
            return (Criteria) this;
        }

        public Criteria andSimilarLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("SIMILAR_LEVEL >=", value, "similarLevel");
            return (Criteria) this;
        }

        public Criteria andSimilarLevelLessThan(Integer value) {
            addCriterion("SIMILAR_LEVEL <", value, "similarLevel");
            return (Criteria) this;
        }

        public Criteria andSimilarLevelLessThanOrEqualTo(Integer value) {
            addCriterion("SIMILAR_LEVEL <=", value, "similarLevel");
            return (Criteria) this;
        }

        public Criteria andSimilarLevelIn(List<Integer> values) {
            addCriterion("SIMILAR_LEVEL in", values, "similarLevel");
            return (Criteria) this;
        }

        public Criteria andSimilarLevelNotIn(List<Integer> values) {
            addCriterion("SIMILAR_LEVEL not in", values, "similarLevel");
            return (Criteria) this;
        }

        public Criteria andSimilarLevelBetween(Integer value1, Integer value2) {
            addCriterion("SIMILAR_LEVEL between", value1, value2, "similarLevel");
            return (Criteria) this;
        }

        public Criteria andSimilarLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("SIMILAR_LEVEL not between", value1, value2, "similarLevel");
            return (Criteria) this;
        }

        public Criteria andMinAmmountIsNull() {
            addCriterion("MIN_AMMOUNT is null");
            return (Criteria) this;
        }

        public Criteria andMinAmmountIsNotNull() {
            addCriterion("MIN_AMMOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andMinAmmountEqualTo(Integer value) {
            addCriterion("MIN_AMMOUNT =", value, "minAmmount");
            return (Criteria) this;
        }

        public Criteria andMinAmmountNotEqualTo(Integer value) {
            addCriterion("MIN_AMMOUNT <>", value, "minAmmount");
            return (Criteria) this;
        }

        public Criteria andMinAmmountGreaterThan(Integer value) {
            addCriterion("MIN_AMMOUNT >", value, "minAmmount");
            return (Criteria) this;
        }

        public Criteria andMinAmmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("MIN_AMMOUNT >=", value, "minAmmount");
            return (Criteria) this;
        }

        public Criteria andMinAmmountLessThan(Integer value) {
            addCriterion("MIN_AMMOUNT <", value, "minAmmount");
            return (Criteria) this;
        }

        public Criteria andMinAmmountLessThanOrEqualTo(Integer value) {
            addCriterion("MIN_AMMOUNT <=", value, "minAmmount");
            return (Criteria) this;
        }

        public Criteria andMinAmmountIn(List<Integer> values) {
            addCriterion("MIN_AMMOUNT in", values, "minAmmount");
            return (Criteria) this;
        }

        public Criteria andMinAmmountNotIn(List<Integer> values) {
            addCriterion("MIN_AMMOUNT not in", values, "minAmmount");
            return (Criteria) this;
        }

        public Criteria andMinAmmountBetween(Integer value1, Integer value2) {
            addCriterion("MIN_AMMOUNT between", value1, value2, "minAmmount");
            return (Criteria) this;
        }

        public Criteria andMinAmmountNotBetween(Integer value1, Integer value2) {
            addCriterion("MIN_AMMOUNT not between", value1, value2, "minAmmount");
            return (Criteria) this;
        }

        public Criteria andMinCreditIsNull() {
            addCriterion("MIN_CREDIT is null");
            return (Criteria) this;
        }

        public Criteria andMinCreditIsNotNull() {
            addCriterion("MIN_CREDIT is not null");
            return (Criteria) this;
        }

        public Criteria andMinCreditEqualTo(Integer value) {
            addCriterion("MIN_CREDIT =", value, "minCredit");
            return (Criteria) this;
        }

        public Criteria andMinCreditNotEqualTo(Integer value) {
            addCriterion("MIN_CREDIT <>", value, "minCredit");
            return (Criteria) this;
        }

        public Criteria andMinCreditGreaterThan(Integer value) {
            addCriterion("MIN_CREDIT >", value, "minCredit");
            return (Criteria) this;
        }

        public Criteria andMinCreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("MIN_CREDIT >=", value, "minCredit");
            return (Criteria) this;
        }

        public Criteria andMinCreditLessThan(Integer value) {
            addCriterion("MIN_CREDIT <", value, "minCredit");
            return (Criteria) this;
        }

        public Criteria andMinCreditLessThanOrEqualTo(Integer value) {
            addCriterion("MIN_CREDIT <=", value, "minCredit");
            return (Criteria) this;
        }

        public Criteria andMinCreditIn(List<Integer> values) {
            addCriterion("MIN_CREDIT in", values, "minCredit");
            return (Criteria) this;
        }

        public Criteria andMinCreditNotIn(List<Integer> values) {
            addCriterion("MIN_CREDIT not in", values, "minCredit");
            return (Criteria) this;
        }

        public Criteria andMinCreditBetween(Integer value1, Integer value2) {
            addCriterion("MIN_CREDIT between", value1, value2, "minCredit");
            return (Criteria) this;
        }

        public Criteria andMinCreditNotBetween(Integer value1, Integer value2) {
            addCriterion("MIN_CREDIT not between", value1, value2, "minCredit");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME not between", value1, value2, "updatetime");
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