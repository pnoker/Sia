package com.Sia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataBaseExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected int start;

	protected int limit;

	public DataBaseExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public DataBaseExample(int start, int limit) {
		this.start = start;
		this.limit = limit;
		oredCriteria = new ArrayList<Criteria>();
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
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

		public Criteria andIdEqualTo(Integer value) {
			addCriterion("id =", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotEqualTo(Integer value) {
			addCriterion("id <>", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThan(Integer value) {
			addCriterion("id >", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("id >=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThan(Integer value) {
			addCriterion("id <", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdLessThanOrEqualTo(Integer value) {
			addCriterion("id <=", value, "id");
			return (Criteria) this;
		}

		public Criteria andIdIn(List<Integer> values) {
			addCriterion("id in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotIn(List<Integer> values) {
			addCriterion("id not in", values, "id");
			return (Criteria) this;
		}

		public Criteria andIdBetween(Integer value1, Integer value2) {
			addCriterion("id between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andIdNotBetween(Integer value1, Integer value2) {
			addCriterion("id not between", value1, value2, "id");
			return (Criteria) this;
		}

		public Criteria andNameIsNull() {
			addCriterion("name is null");
			return (Criteria) this;
		}

		public Criteria andNameIsNotNull() {
			addCriterion("name is not null");
			return (Criteria) this;
		}

		public Criteria andNameEqualTo(String value) {
			addCriterion("name =", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotEqualTo(String value) {
			addCriterion("name <>", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThan(String value) {
			addCriterion("name >", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameGreaterThanOrEqualTo(String value) {
			addCriterion("name >=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThan(String value) {
			addCriterion("name <", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLessThanOrEqualTo(String value) {
			addCriterion("name <=", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameLike(String value) {
			addCriterion("name like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotLike(String value) {
			addCriterion("name not like", value, "name");
			return (Criteria) this;
		}

		public Criteria andNameIn(List<String> values) {
			addCriterion("name in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotIn(List<String> values) {
			addCriterion("name not in", values, "name");
			return (Criteria) this;
		}

		public Criteria andNameBetween(String value1, String value2) {
			addCriterion("name between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andNameNotBetween(String value1, String value2) {
			addCriterion("name not between", value1, value2, "name");
			return (Criteria) this;
		}

		public Criteria andTypeIsNull() {
			addCriterion("type is null");
			return (Criteria) this;
		}

		public Criteria andTypeIsNotNull() {
			addCriterion("type is not null");
			return (Criteria) this;
		}

		public Criteria andTypeEqualTo(Byte value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(Byte value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(Byte value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(Byte value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(Byte value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(Byte value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<Byte> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<Byte> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(Byte value1, Byte value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(Byte value1, Byte value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andIpIsNull() {
			addCriterion("ip is null");
			return (Criteria) this;
		}

		public Criteria andIpIsNotNull() {
			addCriterion("ip is not null");
			return (Criteria) this;
		}

		public Criteria andIpEqualTo(String value) {
			addCriterion("ip =", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotEqualTo(String value) {
			addCriterion("ip <>", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThan(String value) {
			addCriterion("ip >", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpGreaterThanOrEqualTo(String value) {
			addCriterion("ip >=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThan(String value) {
			addCriterion("ip <", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLessThanOrEqualTo(String value) {
			addCriterion("ip <=", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpLike(String value) {
			addCriterion("ip like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotLike(String value) {
			addCriterion("ip not like", value, "ip");
			return (Criteria) this;
		}

		public Criteria andIpIn(List<String> values) {
			addCriterion("ip in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotIn(List<String> values) {
			addCriterion("ip not in", values, "ip");
			return (Criteria) this;
		}

		public Criteria andIpBetween(String value1, String value2) {
			addCriterion("ip between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andIpNotBetween(String value1, String value2) {
			addCriterion("ip not between", value1, value2, "ip");
			return (Criteria) this;
		}

		public Criteria andPortIsNull() {
			addCriterion("port is null");
			return (Criteria) this;
		}

		public Criteria andPortIsNotNull() {
			addCriterion("port is not null");
			return (Criteria) this;
		}

		public Criteria andPortEqualTo(Integer value) {
			addCriterion("port =", value, "port");
			return (Criteria) this;
		}

		public Criteria andPortNotEqualTo(Integer value) {
			addCriterion("port <>", value, "port");
			return (Criteria) this;
		}

		public Criteria andPortGreaterThan(Integer value) {
			addCriterion("port >", value, "port");
			return (Criteria) this;
		}

		public Criteria andPortGreaterThanOrEqualTo(Integer value) {
			addCriterion("port >=", value, "port");
			return (Criteria) this;
		}

		public Criteria andPortLessThan(Integer value) {
			addCriterion("port <", value, "port");
			return (Criteria) this;
		}

		public Criteria andPortLessThanOrEqualTo(Integer value) {
			addCriterion("port <=", value, "port");
			return (Criteria) this;
		}

		public Criteria andPortIn(List<Integer> values) {
			addCriterion("port in", values, "port");
			return (Criteria) this;
		}

		public Criteria andPortNotIn(List<Integer> values) {
			addCriterion("port not in", values, "port");
			return (Criteria) this;
		}

		public Criteria andPortBetween(Integer value1, Integer value2) {
			addCriterion("port between", value1, value2, "port");
			return (Criteria) this;
		}

		public Criteria andPortNotBetween(Integer value1, Integer value2) {
			addCriterion("port not between", value1, value2, "port");
			return (Criteria) this;
		}

		public Criteria andLoginIsNull() {
			addCriterion("login is null");
			return (Criteria) this;
		}

		public Criteria andLoginIsNotNull() {
			addCriterion("login is not null");
			return (Criteria) this;
		}

		public Criteria andLoginEqualTo(String value) {
			addCriterion("login =", value, "login");
			return (Criteria) this;
		}

		public Criteria andLoginNotEqualTo(String value) {
			addCriterion("login <>", value, "login");
			return (Criteria) this;
		}

		public Criteria andLoginGreaterThan(String value) {
			addCriterion("login >", value, "login");
			return (Criteria) this;
		}

		public Criteria andLoginGreaterThanOrEqualTo(String value) {
			addCriterion("login >=", value, "login");
			return (Criteria) this;
		}

		public Criteria andLoginLessThan(String value) {
			addCriterion("login <", value, "login");
			return (Criteria) this;
		}

		public Criteria andLoginLessThanOrEqualTo(String value) {
			addCriterion("login <=", value, "login");
			return (Criteria) this;
		}

		public Criteria andLoginLike(String value) {
			addCriterion("login like", value, "login");
			return (Criteria) this;
		}

		public Criteria andLoginNotLike(String value) {
			addCriterion("login not like", value, "login");
			return (Criteria) this;
		}

		public Criteria andLoginIn(List<String> values) {
			addCriterion("login in", values, "login");
			return (Criteria) this;
		}

		public Criteria andLoginNotIn(List<String> values) {
			addCriterion("login not in", values, "login");
			return (Criteria) this;
		}

		public Criteria andLoginBetween(String value1, String value2) {
			addCriterion("login between", value1, value2, "login");
			return (Criteria) this;
		}

		public Criteria andLoginNotBetween(String value1, String value2) {
			addCriterion("login not between", value1, value2, "login");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNull() {
			addCriterion("password is null");
			return (Criteria) this;
		}

		public Criteria andPasswordIsNotNull() {
			addCriterion("password is not null");
			return (Criteria) this;
		}

		public Criteria andPasswordEqualTo(String value) {
			addCriterion("password =", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotEqualTo(String value) {
			addCriterion("password <>", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThan(String value) {
			addCriterion("password >", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordGreaterThanOrEqualTo(String value) {
			addCriterion("password >=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThan(String value) {
			addCriterion("password <", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLessThanOrEqualTo(String value) {
			addCriterion("password <=", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordLike(String value) {
			addCriterion("password like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotLike(String value) {
			addCriterion("password not like", value, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordIn(List<String> values) {
			addCriterion("password in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotIn(List<String> values) {
			addCriterion("password not in", values, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordBetween(String value1, String value2) {
			addCriterion("password between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andPasswordNotBetween(String value1, String value2) {
			addCriterion("password not between", value1, value2, "password");
			return (Criteria) this;
		}

		public Criteria andUserIsNull() {
			addCriterion("user is null");
			return (Criteria) this;
		}

		public Criteria andUserIsNotNull() {
			addCriterion("user is not null");
			return (Criteria) this;
		}

		public Criteria andUserEqualTo(String value) {
			addCriterion("user =", value, "user");
			return (Criteria) this;
		}

		public Criteria andUserNotEqualTo(String value) {
			addCriterion("user <>", value, "user");
			return (Criteria) this;
		}

		public Criteria andUserGreaterThan(String value) {
			addCriterion("user >", value, "user");
			return (Criteria) this;
		}

		public Criteria andUserGreaterThanOrEqualTo(String value) {
			addCriterion("user >=", value, "user");
			return (Criteria) this;
		}

		public Criteria andUserLessThan(String value) {
			addCriterion("user <", value, "user");
			return (Criteria) this;
		}

		public Criteria andUserLessThanOrEqualTo(String value) {
			addCriterion("user <=", value, "user");
			return (Criteria) this;
		}

		public Criteria andUserLike(String value) {
			addCriterion("user like", value, "user");
			return (Criteria) this;
		}

		public Criteria andUserNotLike(String value) {
			addCriterion("user not like", value, "user");
			return (Criteria) this;
		}

		public Criteria andUserIn(List<String> values) {
			addCriterion("user in", values, "user");
			return (Criteria) this;
		}

		public Criteria andUserNotIn(List<String> values) {
			addCriterion("user not in", values, "user");
			return (Criteria) this;
		}

		public Criteria andUserBetween(String value1, String value2) {
			addCriterion("user between", value1, value2, "user");
			return (Criteria) this;
		}

		public Criteria andUserNotBetween(String value1, String value2) {
			addCriterion("user not between", value1, value2, "user");
			return (Criteria) this;
		}

		public Criteria andIsEnableIsNull() {
			addCriterion("is_enable is null");
			return (Criteria) this;
		}

		public Criteria andIsEnableIsNotNull() {
			addCriterion("is_enable is not null");
			return (Criteria) this;
		}

		public Criteria andIsEnableEqualTo(Byte value) {
			addCriterion("is_enable =", value, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableNotEqualTo(Byte value) {
			addCriterion("is_enable <>", value, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableGreaterThan(Byte value) {
			addCriterion("is_enable >", value, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableGreaterThanOrEqualTo(Byte value) {
			addCriterion("is_enable >=", value, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableLessThan(Byte value) {
			addCriterion("is_enable <", value, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableLessThanOrEqualTo(Byte value) {
			addCriterion("is_enable <=", value, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableIn(List<Byte> values) {
			addCriterion("is_enable in", values, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableNotIn(List<Byte> values) {
			addCriterion("is_enable not in", values, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableBetween(Byte value1, Byte value2) {
			addCriterion("is_enable between", value1, value2, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableNotBetween(Byte value1, Byte value2) {
			addCriterion("is_enable not between", value1, value2, "isEnable");
			return (Criteria) this;
		}

		public Criteria andStateIsNull() {
			addCriterion("state is null");
			return (Criteria) this;
		}

		public Criteria andStateIsNotNull() {
			addCriterion("state is not null");
			return (Criteria) this;
		}

		public Criteria andStateEqualTo(Byte value) {
			addCriterion("state =", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotEqualTo(Byte value) {
			addCriterion("state <>", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThan(Byte value) {
			addCriterion("state >", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateGreaterThanOrEqualTo(Byte value) {
			addCriterion("state >=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThan(Byte value) {
			addCriterion("state <", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateLessThanOrEqualTo(Byte value) {
			addCriterion("state <=", value, "state");
			return (Criteria) this;
		}

		public Criteria andStateIn(List<Byte> values) {
			addCriterion("state in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotIn(List<Byte> values) {
			addCriterion("state not in", values, "state");
			return (Criteria) this;
		}

		public Criteria andStateBetween(Byte value1, Byte value2) {
			addCriterion("state between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andStateNotBetween(Byte value1, Byte value2) {
			addCriterion("state not between", value1, value2, "state");
			return (Criteria) this;
		}

		public Criteria andAtTimeIsNull() {
			addCriterion("at_time is null");
			return (Criteria) this;
		}

		public Criteria andAtTimeIsNotNull() {
			addCriterion("at_time is not null");
			return (Criteria) this;
		}

		public Criteria andAtTimeEqualTo(Date value) {
			addCriterion("at_time =", value, "atTime");
			return (Criteria) this;
		}

		public Criteria andAtTimeNotEqualTo(Date value) {
			addCriterion("at_time <>", value, "atTime");
			return (Criteria) this;
		}

		public Criteria andAtTimeGreaterThan(Date value) {
			addCriterion("at_time >", value, "atTime");
			return (Criteria) this;
		}

		public Criteria andAtTimeGreaterThanOrEqualTo(Date value) {
			addCriterion("at_time >=", value, "atTime");
			return (Criteria) this;
		}

		public Criteria andAtTimeLessThan(Date value) {
			addCriterion("at_time <", value, "atTime");
			return (Criteria) this;
		}

		public Criteria andAtTimeLessThanOrEqualTo(Date value) {
			addCriterion("at_time <=", value, "atTime");
			return (Criteria) this;
		}

		public Criteria andAtTimeIn(List<Date> values) {
			addCriterion("at_time in", values, "atTime");
			return (Criteria) this;
		}

		public Criteria andAtTimeNotIn(List<Date> values) {
			addCriterion("at_time not in", values, "atTime");
			return (Criteria) this;
		}

		public Criteria andAtTimeBetween(Date value1, Date value2) {
			addCriterion("at_time between", value1, value2, "atTime");
			return (Criteria) this;
		}

		public Criteria andAtTimeNotBetween(Date value1, Date value2) {
			addCriterion("at_time not between", value1, value2, "atTime");
			return (Criteria) this;
		}

		public Criteria andNameLikeInsensitive(String value) {
			addCriterion("upper(name) like", value.toUpperCase(), "name");
			return (Criteria) this;
		}

		public Criteria andIpLikeInsensitive(String value) {
			addCriterion("upper(ip) like", value.toUpperCase(), "ip");
			return (Criteria) this;
		}

		public Criteria andLoginLikeInsensitive(String value) {
			addCriterion("upper(login) like", value.toUpperCase(), "login");
			return (Criteria) this;
		}

		public Criteria andPasswordLikeInsensitive(String value) {
			addCriterion("upper(password) like", value.toUpperCase(), "password");
			return (Criteria) this;
		}

		public Criteria andUserLikeInsensitive(String value) {
			addCriterion("upper(user) like", value.toUpperCase(), "user");
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