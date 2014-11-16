package com.xinfan.msgbox.service.dao.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserSentExample {
    protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	public UserSentExample() {
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
			addCriterion("id is null");
			return (Criteria) this;
		}

		public Criteria andIdIsNotNull() {
			addCriterion("id is not null");
			return (Criteria) this;
		}

		public Criteria andIdEqualTo(Long value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Long value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Long value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Long value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Long value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Long value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Long> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Long> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Long value1, Long value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Long value1, Long value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNull() {
			addCriterion("user_id is null");
			return (Criteria) this;
		}

		public Criteria andUserIdIsNotNull() {
			addCriterion("user_id is not null");
			return (Criteria) this;
		}

		public Criteria andUserIdEqualTo(Long value) {
			addCriterion("user_id =", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotEqualTo(Long value) {
			addCriterion("user_id <>", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThan(Long value) {
			addCriterion("user_id >", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
			addCriterion("user_id >=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThan(Long value) {
			addCriterion("user_id <", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdLessThanOrEqualTo(Long value) {
			addCriterion("user_id <=", value, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdIn(List<Long> values) {
			addCriterion("user_id in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotIn(List<Long> values) {
			addCriterion("user_id not in", values, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdBetween(Long value1, Long value2) {
			addCriterion("user_id between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserIdNotBetween(Long value1, Long value2) {
			addCriterion("user_id not between", value1, value2, "userId");
			return (Criteria) this;
		}

		public Criteria andUserSentIsNull() {
			addCriterion("user_sent is null");
			return (Criteria) this;
		}

		public Criteria andUserSentIsNotNull() {
			addCriterion("user_sent is not null");
			return (Criteria) this;
		}

		public Criteria andUserSentEqualTo(String value) {
			addCriterion("user_sent =", value, "userSent");
			return (Criteria) this;
		}

		public Criteria andUserSentNotEqualTo(String value) {
			addCriterion("user_sent <>", value, "userSent");
			return (Criteria) this;
		}

		public Criteria andUserSentGreaterThan(String value) {
			addCriterion("user_sent >", value, "userSent");
			return (Criteria) this;
		}

		public Criteria andUserSentGreaterThanOrEqualTo(String value) {
			addCriterion("user_sent >=", value, "userSent");
			return (Criteria) this;
		}

		public Criteria andUserSentLessThan(String value) {
			addCriterion("user_sent <", value, "userSent");
			return (Criteria) this;
		}

		public Criteria andUserSentLessThanOrEqualTo(String value) {
			addCriterion("user_sent <=", value, "userSent");
			return (Criteria) this;
		}

		public Criteria andUserSentLike(String value) {
			addCriterion("user_sent like", value, "userSent");
			return (Criteria) this;
		}

		public Criteria andUserSentNotLike(String value) {
			addCriterion("user_sent not like", value, "userSent");
			return (Criteria) this;
		}

		public Criteria andUserSentIn(List<String> values) {
			addCriterion("user_sent in", values, "userSent");
			return (Criteria) this;
		}

		public Criteria andUserSentNotIn(List<String> values) {
			addCriterion("user_sent not in", values, "userSent");
			return (Criteria) this;
		}

		public Criteria andUserSentBetween(String value1, String value2) {
			addCriterion("user_sent between", value1, value2, "userSent");
			return (Criteria) this;
		}

		public Criteria andUserSentNotBetween(String value1, String value2) {
			addCriterion("user_sent not between", value1, value2, "userSent");
			return (Criteria) this;
		}

		public Criteria andGpsyIsNull() {
			addCriterion("gpsy is null");
			return (Criteria) this;
		}

		public Criteria andGpsyIsNotNull() {
			addCriterion("gpsy is not null");
			return (Criteria) this;
		}

		public Criteria andGpsyEqualTo(String value) {
			addCriterion("gpsy =", value, "gpsy");
			return (Criteria) this;
		}

		public Criteria andGpsyNotEqualTo(String value) {
			addCriterion("gpsy <>", value, "gpsy");
			return (Criteria) this;
		}

		public Criteria andGpsyGreaterThan(String value) {
			addCriterion("gpsy >", value, "gpsy");
			return (Criteria) this;
		}

		public Criteria andGpsyGreaterThanOrEqualTo(String value) {
			addCriterion("gpsy >=", value, "gpsy");
			return (Criteria) this;
		}

		public Criteria andGpsyLessThan(String value) {
			addCriterion("gpsy <", value, "gpsy");
			return (Criteria) this;
		}

		public Criteria andGpsyLessThanOrEqualTo(String value) {
			addCriterion("gpsy <=", value, "gpsy");
			return (Criteria) this;
		}

		public Criteria andGpsyLike(String value) {
			addCriterion("gpsy like", value, "gpsy");
			return (Criteria) this;
		}

		public Criteria andGpsyNotLike(String value) {
			addCriterion("gpsy not like", value, "gpsy");
			return (Criteria) this;
		}

		public Criteria andGpsyIn(List<String> values) {
			addCriterion("gpsy in", values, "gpsy");
			return (Criteria) this;
		}

		public Criteria andGpsyNotIn(List<String> values) {
			addCriterion("gpsy not in", values, "gpsy");
			return (Criteria) this;
		}

		public Criteria andGpsyBetween(String value1, String value2) {
			addCriterion("gpsy between", value1, value2, "gpsy");
			return (Criteria) this;
		}

		public Criteria andGpsyNotBetween(String value1, String value2) {
			addCriterion("gpsy not between", value1, value2, "gpsy");
			return (Criteria) this;
		}

		public Criteria andGpsxIsNull() {
			addCriterion("gpsx is null");
			return (Criteria) this;
		}

		public Criteria andGpsxIsNotNull() {
			addCriterion("gpsx is not null");
			return (Criteria) this;
		}

		public Criteria andGpsxEqualTo(String value) {
			addCriterion("gpsx =", value, "gpsx");
			return (Criteria) this;
		}

		public Criteria andGpsxNotEqualTo(String value) {
			addCriterion("gpsx <>", value, "gpsx");
			return (Criteria) this;
		}

		public Criteria andGpsxGreaterThan(String value) {
			addCriterion("gpsx >", value, "gpsx");
			return (Criteria) this;
		}

		public Criteria andGpsxGreaterThanOrEqualTo(String value) {
			addCriterion("gpsx >=", value, "gpsx");
			return (Criteria) this;
		}

		public Criteria andGpsxLessThan(String value) {
			addCriterion("gpsx <", value, "gpsx");
			return (Criteria) this;
		}

		public Criteria andGpsxLessThanOrEqualTo(String value) {
			addCriterion("gpsx <=", value, "gpsx");
			return (Criteria) this;
		}

		public Criteria andGpsxLike(String value) {
			addCriterion("gpsx like", value, "gpsx");
			return (Criteria) this;
		}

		public Criteria andGpsxNotLike(String value) {
			addCriterion("gpsx not like", value, "gpsx");
			return (Criteria) this;
		}

		public Criteria andGpsxIn(List<String> values) {
			addCriterion("gpsx in", values, "gpsx");
			return (Criteria) this;
		}

		public Criteria andGpsxNotIn(List<String> values) {
			addCriterion("gpsx not in", values, "gpsx");
			return (Criteria) this;
		}

		public Criteria andGpsxBetween(String value1, String value2) {
			addCriterion("gpsx between", value1, value2, "gpsx");
			return (Criteria) this;
		}

		public Criteria andGpsxNotBetween(String value1, String value2) {
			addCriterion("gpsx not between", value1, value2, "gpsx");
			return (Criteria) this;
		}

		public Criteria andReginCodeIsNull() {
			addCriterion("regin_code is null");
			return (Criteria) this;
		}

		public Criteria andReginCodeIsNotNull() {
			addCriterion("regin_code is not null");
			return (Criteria) this;
		}

		public Criteria andReginCodeEqualTo(String value) {
			addCriterion("regin_code =", value, "reginCode");
			return (Criteria) this;
		}

		public Criteria andReginCodeNotEqualTo(String value) {
			addCriterion("regin_code <>", value, "reginCode");
			return (Criteria) this;
		}

		public Criteria andReginCodeGreaterThan(String value) {
			addCriterion("regin_code >", value, "reginCode");
			return (Criteria) this;
		}

		public Criteria andReginCodeGreaterThanOrEqualTo(String value) {
			addCriterion("regin_code >=", value, "reginCode");
			return (Criteria) this;
		}

		public Criteria andReginCodeLessThan(String value) {
			addCriterion("regin_code <", value, "reginCode");
			return (Criteria) this;
		}

		public Criteria andReginCodeLessThanOrEqualTo(String value) {
			addCriterion("regin_code <=", value, "reginCode");
			return (Criteria) this;
		}

		public Criteria andReginCodeLike(String value) {
			addCriterion("regin_code like", value, "reginCode");
			return (Criteria) this;
		}

		public Criteria andReginCodeNotLike(String value) {
			addCriterion("regin_code not like", value, "reginCode");
			return (Criteria) this;
		}

		public Criteria andReginCodeIn(List<String> values) {
			addCriterion("regin_code in", values, "reginCode");
			return (Criteria) this;
		}

		public Criteria andReginCodeNotIn(List<String> values) {
			addCriterion("regin_code not in", values, "reginCode");
			return (Criteria) this;
		}

		public Criteria andReginCodeBetween(String value1, String value2) {
			addCriterion("regin_code between", value1, value2, "reginCode");
			return (Criteria) this;
		}

		public Criteria andReginCodeNotBetween(String value1, String value2) {
			addCriterion("regin_code not between", value1, value2, "reginCode");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNull() {
			addCriterion("create_time is null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIsNotNull() {
			addCriterion("create_time is not null");
			return (Criteria) this;
		}

		public Criteria andCreateTimeEqualTo(Date value) {
			addCriterion("create_time =", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotEqualTo(Date value) {
			addCriterion("create_time <>", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThan(Date value) {
			addCriterion("create_time >", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("create_time >=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThan(Date value) {
			addCriterion("create_time <", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
			addCriterion("create_time <=", value, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeIn(List<Date> values) {
			addCriterion("create_time in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotIn(List<Date> values) {
			addCriterion("create_time not in", values, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeBetween(Date value1, Date value2) {
			addCriterion("create_time between", value1, value2, "createTime");
			return (Criteria) this;
		}

		public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
			addCriterion("create_time not between", value1, value2, "createTime");
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