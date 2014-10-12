package com.xinfan.msgbox.service.dao.entity;

import java.util.ArrayList;
import java.util.List;

public class ClientVersionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClientVersionExample() {
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

        public Criteria andClientCodeIsNull() {
            addCriterion("CLIENT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andClientCodeIsNotNull() {
            addCriterion("CLIENT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andClientCodeEqualTo(String value) {
            addCriterion("CLIENT_CODE =", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeNotEqualTo(String value) {
            addCriterion("CLIENT_CODE <>", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeGreaterThan(String value) {
            addCriterion("CLIENT_CODE >", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeGreaterThanOrEqualTo(String value) {
            addCriterion("CLIENT_CODE >=", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeLessThan(String value) {
            addCriterion("CLIENT_CODE <", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeLessThanOrEqualTo(String value) {
            addCriterion("CLIENT_CODE <=", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeLike(String value) {
            addCriterion("CLIENT_CODE like", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeNotLike(String value) {
            addCriterion("CLIENT_CODE not like", value, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeIn(List<String> values) {
            addCriterion("CLIENT_CODE in", values, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeNotIn(List<String> values) {
            addCriterion("CLIENT_CODE not in", values, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeBetween(String value1, String value2) {
            addCriterion("CLIENT_CODE between", value1, value2, "clientCode");
            return (Criteria) this;
        }

        public Criteria andClientCodeNotBetween(String value1, String value2) {
            addCriterion("CLIENT_CODE not between", value1, value2, "clientCode");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("VERSION like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("VERSION not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andIsNewestIsNull() {
            addCriterion("IS_NEWEST is null");
            return (Criteria) this;
        }

        public Criteria andIsNewestIsNotNull() {
            addCriterion("IS_NEWEST is not null");
            return (Criteria) this;
        }

        public Criteria andIsNewestEqualTo(String value) {
            addCriterion("IS_NEWEST =", value, "isNewest");
            return (Criteria) this;
        }

        public Criteria andIsNewestNotEqualTo(String value) {
            addCriterion("IS_NEWEST <>", value, "isNewest");
            return (Criteria) this;
        }

        public Criteria andIsNewestGreaterThan(String value) {
            addCriterion("IS_NEWEST >", value, "isNewest");
            return (Criteria) this;
        }

        public Criteria andIsNewestGreaterThanOrEqualTo(String value) {
            addCriterion("IS_NEWEST >=", value, "isNewest");
            return (Criteria) this;
        }

        public Criteria andIsNewestLessThan(String value) {
            addCriterion("IS_NEWEST <", value, "isNewest");
            return (Criteria) this;
        }

        public Criteria andIsNewestLessThanOrEqualTo(String value) {
            addCriterion("IS_NEWEST <=", value, "isNewest");
            return (Criteria) this;
        }

        public Criteria andIsNewestLike(String value) {
            addCriterion("IS_NEWEST like", value, "isNewest");
            return (Criteria) this;
        }

        public Criteria andIsNewestNotLike(String value) {
            addCriterion("IS_NEWEST not like", value, "isNewest");
            return (Criteria) this;
        }

        public Criteria andIsNewestIn(List<String> values) {
            addCriterion("IS_NEWEST in", values, "isNewest");
            return (Criteria) this;
        }

        public Criteria andIsNewestNotIn(List<String> values) {
            addCriterion("IS_NEWEST not in", values, "isNewest");
            return (Criteria) this;
        }

        public Criteria andIsNewestBetween(String value1, String value2) {
            addCriterion("IS_NEWEST between", value1, value2, "isNewest");
            return (Criteria) this;
        }

        public Criteria andIsNewestNotBetween(String value1, String value2) {
            addCriterion("IS_NEWEST not between", value1, value2, "isNewest");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlIsNull() {
            addCriterion("INCR_DOWNLOAD_URL is null");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlIsNotNull() {
            addCriterion("INCR_DOWNLOAD_URL is not null");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlEqualTo(String value) {
            addCriterion("INCR_DOWNLOAD_URL =", value, "incrDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlNotEqualTo(String value) {
            addCriterion("INCR_DOWNLOAD_URL <>", value, "incrDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlGreaterThan(String value) {
            addCriterion("INCR_DOWNLOAD_URL >", value, "incrDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("INCR_DOWNLOAD_URL >=", value, "incrDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlLessThan(String value) {
            addCriterion("INCR_DOWNLOAD_URL <", value, "incrDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlLessThanOrEqualTo(String value) {
            addCriterion("INCR_DOWNLOAD_URL <=", value, "incrDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlLike(String value) {
            addCriterion("INCR_DOWNLOAD_URL like", value, "incrDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlNotLike(String value) {
            addCriterion("INCR_DOWNLOAD_URL not like", value, "incrDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlIn(List<String> values) {
            addCriterion("INCR_DOWNLOAD_URL in", values, "incrDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlNotIn(List<String> values) {
            addCriterion("INCR_DOWNLOAD_URL not in", values, "incrDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlBetween(String value1, String value2) {
            addCriterion("INCR_DOWNLOAD_URL between", value1, value2, "incrDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIncrDownloadUrlNotBetween(String value1, String value2) {
            addCriterion("INCR_DOWNLOAD_URL not between", value1, value2, "incrDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlIsNull() {
            addCriterion("FULL_DOWNLOAD_URL is null");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlIsNotNull() {
            addCriterion("FULL_DOWNLOAD_URL is not null");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlEqualTo(String value) {
            addCriterion("FULL_DOWNLOAD_URL =", value, "fullDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlNotEqualTo(String value) {
            addCriterion("FULL_DOWNLOAD_URL <>", value, "fullDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlGreaterThan(String value) {
            addCriterion("FULL_DOWNLOAD_URL >", value, "fullDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlGreaterThanOrEqualTo(String value) {
            addCriterion("FULL_DOWNLOAD_URL >=", value, "fullDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlLessThan(String value) {
            addCriterion("FULL_DOWNLOAD_URL <", value, "fullDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlLessThanOrEqualTo(String value) {
            addCriterion("FULL_DOWNLOAD_URL <=", value, "fullDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlLike(String value) {
            addCriterion("FULL_DOWNLOAD_URL like", value, "fullDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlNotLike(String value) {
            addCriterion("FULL_DOWNLOAD_URL not like", value, "fullDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlIn(List<String> values) {
            addCriterion("FULL_DOWNLOAD_URL in", values, "fullDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlNotIn(List<String> values) {
            addCriterion("FULL_DOWNLOAD_URL not in", values, "fullDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlBetween(String value1, String value2) {
            addCriterion("FULL_DOWNLOAD_URL between", value1, value2, "fullDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andFullDownloadUrlNotBetween(String value1, String value2) {
            addCriterion("FULL_DOWNLOAD_URL not between", value1, value2, "fullDownloadUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlIsNull() {
            addCriterion("INTRODUCE_URL is null");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlIsNotNull() {
            addCriterion("INTRODUCE_URL is not null");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlEqualTo(String value) {
            addCriterion("INTRODUCE_URL =", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlNotEqualTo(String value) {
            addCriterion("INTRODUCE_URL <>", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlGreaterThan(String value) {
            addCriterion("INTRODUCE_URL >", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlGreaterThanOrEqualTo(String value) {
            addCriterion("INTRODUCE_URL >=", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlLessThan(String value) {
            addCriterion("INTRODUCE_URL <", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlLessThanOrEqualTo(String value) {
            addCriterion("INTRODUCE_URL <=", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlLike(String value) {
            addCriterion("INTRODUCE_URL like", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlNotLike(String value) {
            addCriterion("INTRODUCE_URL not like", value, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlIn(List<String> values) {
            addCriterion("INTRODUCE_URL in", values, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlNotIn(List<String> values) {
            addCriterion("INTRODUCE_URL not in", values, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlBetween(String value1, String value2) {
            addCriterion("INTRODUCE_URL between", value1, value2, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andIntroduceUrlNotBetween(String value1, String value2) {
            addCriterion("INTRODUCE_URL not between", value1, value2, "introduceUrl");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
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