package com.Sia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected int start;

	protected int limit;

	public AdapterExample(int start, int limit) {
		this.start = start;
		this.limit = limit;
		oredCriteria = new ArrayList<Criteria>();
	}

	public AdapterExample() {
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

		public Criteria andNodeIdIsNull() {
			addCriterion("node_id is null");
			return (Criteria) this;
		}

		public Criteria andNodeIdIsNotNull() {
			addCriterion("node_id is not null");
			return (Criteria) this;
		}

		public Criteria andNodeIdEqualTo(Integer value) {
			addCriterion("node_id =", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdNotEqualTo(Integer value) {
			addCriterion("node_id <>", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdGreaterThan(Integer value) {
			addCriterion("node_id >", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("node_id >=", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdLessThan(Integer value) {
			addCriterion("node_id <", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdLessThanOrEqualTo(Integer value) {
			addCriterion("node_id <=", value, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdIn(List<Integer> values) {
			addCriterion("node_id in", values, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdNotIn(List<Integer> values) {
			addCriterion("node_id not in", values, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdBetween(Integer value1, Integer value2) {
			addCriterion("node_id between", value1, value2, "nodeId");
			return (Criteria) this;
		}

		public Criteria andNodeIdNotBetween(Integer value1, Integer value2) {
			addCriterion("node_id not between", value1, value2, "nodeId");
			return (Criteria) this;
		}

		public Criteria andGatewayIdIsNull() {
			addCriterion("gateway_id is null");
			return (Criteria) this;
		}

		public Criteria andGatewayIdIsNotNull() {
			addCriterion("gateway_id is not null");
			return (Criteria) this;
		}

		public Criteria andGatewayIdEqualTo(Integer value) {
			addCriterion("gateway_id =", value, "gatewayId");
			return (Criteria) this;
		}

		public Criteria andGatewayIdNotEqualTo(Integer value) {
			addCriterion("gateway_id <>", value, "gatewayId");
			return (Criteria) this;
		}

		public Criteria andGatewayIdGreaterThan(Integer value) {
			addCriterion("gateway_id >", value, "gatewayId");
			return (Criteria) this;
		}

		public Criteria andGatewayIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("gateway_id >=", value, "gatewayId");
			return (Criteria) this;
		}

		public Criteria andGatewayIdLessThan(Integer value) {
			addCriterion("gateway_id <", value, "gatewayId");
			return (Criteria) this;
		}

		public Criteria andGatewayIdLessThanOrEqualTo(Integer value) {
			addCriterion("gateway_id <=", value, "gatewayId");
			return (Criteria) this;
		}

		public Criteria andGatewayIdIn(List<Integer> values) {
			addCriterion("gateway_id in", values, "gatewayId");
			return (Criteria) this;
		}

		public Criteria andGatewayIdNotIn(List<Integer> values) {
			addCriterion("gateway_id not in", values, "gatewayId");
			return (Criteria) this;
		}

		public Criteria andGatewayIdBetween(Integer value1, Integer value2) {
			addCriterion("gateway_id between", value1, value2, "gatewayId");
			return (Criteria) this;
		}

		public Criteria andGatewayIdNotBetween(Integer value1, Integer value2) {
			addCriterion("gateway_id not between", value1, value2, "gatewayId");
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

		public Criteria andSerialIsNull() {
			addCriterion("serial is null");
			return (Criteria) this;
		}

		public Criteria andSerialIsNotNull() {
			addCriterion("serial is not null");
			return (Criteria) this;
		}

		public Criteria andSerialEqualTo(String value) {
			addCriterion("serial =", value, "serial");
			return (Criteria) this;
		}

		public Criteria andSerialNotEqualTo(String value) {
			addCriterion("serial <>", value, "serial");
			return (Criteria) this;
		}

		public Criteria andSerialGreaterThan(String value) {
			addCriterion("serial >", value, "serial");
			return (Criteria) this;
		}

		public Criteria andSerialGreaterThanOrEqualTo(String value) {
			addCriterion("serial >=", value, "serial");
			return (Criteria) this;
		}

		public Criteria andSerialLessThan(String value) {
			addCriterion("serial <", value, "serial");
			return (Criteria) this;
		}

		public Criteria andSerialLessThanOrEqualTo(String value) {
			addCriterion("serial <=", value, "serial");
			return (Criteria) this;
		}

		public Criteria andSerialLike(String value) {
			addCriterion("serial like", value, "serial");
			return (Criteria) this;
		}

		public Criteria andSerialNotLike(String value) {
			addCriterion("serial not like", value, "serial");
			return (Criteria) this;
		}

		public Criteria andSerialIn(List<String> values) {
			addCriterion("serial in", values, "serial");
			return (Criteria) this;
		}

		public Criteria andSerialNotIn(List<String> values) {
			addCriterion("serial not in", values, "serial");
			return (Criteria) this;
		}

		public Criteria andSerialBetween(String value1, String value2) {
			addCriterion("serial between", value1, value2, "serial");
			return (Criteria) this;
		}

		public Criteria andSerialNotBetween(String value1, String value2) {
			addCriterion("serial not between", value1, value2, "serial");
			return (Criteria) this;
		}

		public Criteria andTypeserialIsNull() {
			addCriterion("typeserial is null");
			return (Criteria) this;
		}

		public Criteria andTypeserialIsNotNull() {
			addCriterion("typeserial is not null");
			return (Criteria) this;
		}

		public Criteria andTypeserialEqualTo(String value) {
			addCriterion("typeserial =", value, "typeserial");
			return (Criteria) this;
		}

		public Criteria andTypeserialNotEqualTo(String value) {
			addCriterion("typeserial <>", value, "typeserial");
			return (Criteria) this;
		}

		public Criteria andTypeserialGreaterThan(String value) {
			addCriterion("typeserial >", value, "typeserial");
			return (Criteria) this;
		}

		public Criteria andTypeserialGreaterThanOrEqualTo(String value) {
			addCriterion("typeserial >=", value, "typeserial");
			return (Criteria) this;
		}

		public Criteria andTypeserialLessThan(String value) {
			addCriterion("typeserial <", value, "typeserial");
			return (Criteria) this;
		}

		public Criteria andTypeserialLessThanOrEqualTo(String value) {
			addCriterion("typeserial <=", value, "typeserial");
			return (Criteria) this;
		}

		public Criteria andTypeserialLike(String value) {
			addCriterion("typeserial like", value, "typeserial");
			return (Criteria) this;
		}

		public Criteria andTypeserialNotLike(String value) {
			addCriterion("typeserial not like", value, "typeserial");
			return (Criteria) this;
		}

		public Criteria andTypeserialIn(List<String> values) {
			addCriterion("typeserial in", values, "typeserial");
			return (Criteria) this;
		}

		public Criteria andTypeserialNotIn(List<String> values) {
			addCriterion("typeserial not in", values, "typeserial");
			return (Criteria) this;
		}

		public Criteria andTypeserialBetween(String value1, String value2) {
			addCriterion("typeserial between", value1, value2, "typeserial");
			return (Criteria) this;
		}

		public Criteria andTypeserialNotBetween(String value1, String value2) {
			addCriterion("typeserial not between", value1, value2, "typeserial");
			return (Criteria) this;
		}

		public Criteria andLongAddressIsNull() {
			addCriterion("long_address is null");
			return (Criteria) this;
		}

		public Criteria andLongAddressIsNotNull() {
			addCriterion("long_address is not null");
			return (Criteria) this;
		}

		public Criteria andLongAddressEqualTo(String value) {
			addCriterion("long_address =", value, "longAddress");
			return (Criteria) this;
		}

		public Criteria andLongAddressNotEqualTo(String value) {
			addCriterion("long_address <>", value, "longAddress");
			return (Criteria) this;
		}

		public Criteria andLongAddressGreaterThan(String value) {
			addCriterion("long_address >", value, "longAddress");
			return (Criteria) this;
		}

		public Criteria andLongAddressGreaterThanOrEqualTo(String value) {
			addCriterion("long_address >=", value, "longAddress");
			return (Criteria) this;
		}

		public Criteria andLongAddressLessThan(String value) {
			addCriterion("long_address <", value, "longAddress");
			return (Criteria) this;
		}

		public Criteria andLongAddressLessThanOrEqualTo(String value) {
			addCriterion("long_address <=", value, "longAddress");
			return (Criteria) this;
		}

		public Criteria andLongAddressLike(String value) {
			addCriterion("long_address like", value, "longAddress");
			return (Criteria) this;
		}

		public Criteria andLongAddressNotLike(String value) {
			addCriterion("long_address not like", value, "longAddress");
			return (Criteria) this;
		}

		public Criteria andLongAddressIn(List<String> values) {
			addCriterion("long_address in", values, "longAddress");
			return (Criteria) this;
		}

		public Criteria andLongAddressNotIn(List<String> values) {
			addCriterion("long_address not in", values, "longAddress");
			return (Criteria) this;
		}

		public Criteria andLongAddressBetween(String value1, String value2) {
			addCriterion("long_address between", value1, value2, "longAddress");
			return (Criteria) this;
		}

		public Criteria andLongAddressNotBetween(String value1, String value2) {
			addCriterion("long_address not between", value1, value2, "longAddress");
			return (Criteria) this;
		}

		public Criteria andSubAddressIsNull() {
			addCriterion("sub_address is null");
			return (Criteria) this;
		}

		public Criteria andSubAddressIsNotNull() {
			addCriterion("sub_address is not null");
			return (Criteria) this;
		}

		public Criteria andSubAddressEqualTo(String value) {
			addCriterion("sub_address =", value, "subAddress");
			return (Criteria) this;
		}

		public Criteria andSubAddressNotEqualTo(String value) {
			addCriterion("sub_address <>", value, "subAddress");
			return (Criteria) this;
		}

		public Criteria andSubAddressGreaterThan(String value) {
			addCriterion("sub_address >", value, "subAddress");
			return (Criteria) this;
		}

		public Criteria andSubAddressGreaterThanOrEqualTo(String value) {
			addCriterion("sub_address >=", value, "subAddress");
			return (Criteria) this;
		}

		public Criteria andSubAddressLessThan(String value) {
			addCriterion("sub_address <", value, "subAddress");
			return (Criteria) this;
		}

		public Criteria andSubAddressLessThanOrEqualTo(String value) {
			addCriterion("sub_address <=", value, "subAddress");
			return (Criteria) this;
		}

		public Criteria andSubAddressLike(String value) {
			addCriterion("sub_address like", value, "subAddress");
			return (Criteria) this;
		}

		public Criteria andSubAddressNotLike(String value) {
			addCriterion("sub_address not like", value, "subAddress");
			return (Criteria) this;
		}

		public Criteria andSubAddressIn(List<String> values) {
			addCriterion("sub_address in", values, "subAddress");
			return (Criteria) this;
		}

		public Criteria andSubAddressNotIn(List<String> values) {
			addCriterion("sub_address not in", values, "subAddress");
			return (Criteria) this;
		}

		public Criteria andSubAddressBetween(String value1, String value2) {
			addCriterion("sub_address between", value1, value2, "subAddress");
			return (Criteria) this;
		}

		public Criteria andSubAddressNotBetween(String value1, String value2) {
			addCriterion("sub_address not between", value1, value2, "subAddress");
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

		public Criteria andTypeEqualTo(String value) {
			addCriterion("type =", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotEqualTo(String value) {
			addCriterion("type <>", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThan(String value) {
			addCriterion("type >", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeGreaterThanOrEqualTo(String value) {
			addCriterion("type >=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThan(String value) {
			addCriterion("type <", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLessThanOrEqualTo(String value) {
			addCriterion("type <=", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeLike(String value) {
			addCriterion("type like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotLike(String value) {
			addCriterion("type not like", value, "type");
			return (Criteria) this;
		}

		public Criteria andTypeIn(List<String> values) {
			addCriterion("type in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotIn(List<String> values) {
			addCriterion("type not in", values, "type");
			return (Criteria) this;
		}

		public Criteria andTypeBetween(String value1, String value2) {
			addCriterion("type between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andTypeNotBetween(String value1, String value2) {
			addCriterion("type not between", value1, value2, "type");
			return (Criteria) this;
		}

		public Criteria andFactoryIsNull() {
			addCriterion("factory is null");
			return (Criteria) this;
		}

		public Criteria andFactoryIsNotNull() {
			addCriterion("factory is not null");
			return (Criteria) this;
		}

		public Criteria andFactoryEqualTo(String value) {
			addCriterion("factory =", value, "factory");
			return (Criteria) this;
		}

		public Criteria andFactoryNotEqualTo(String value) {
			addCriterion("factory <>", value, "factory");
			return (Criteria) this;
		}

		public Criteria andFactoryGreaterThan(String value) {
			addCriterion("factory >", value, "factory");
			return (Criteria) this;
		}

		public Criteria andFactoryGreaterThanOrEqualTo(String value) {
			addCriterion("factory >=", value, "factory");
			return (Criteria) this;
		}

		public Criteria andFactoryLessThan(String value) {
			addCriterion("factory <", value, "factory");
			return (Criteria) this;
		}

		public Criteria andFactoryLessThanOrEqualTo(String value) {
			addCriterion("factory <=", value, "factory");
			return (Criteria) this;
		}

		public Criteria andFactoryLike(String value) {
			addCriterion("factory like", value, "factory");
			return (Criteria) this;
		}

		public Criteria andFactoryNotLike(String value) {
			addCriterion("factory not like", value, "factory");
			return (Criteria) this;
		}

		public Criteria andFactoryIn(List<String> values) {
			addCriterion("factory in", values, "factory");
			return (Criteria) this;
		}

		public Criteria andFactoryNotIn(List<String> values) {
			addCriterion("factory not in", values, "factory");
			return (Criteria) this;
		}

		public Criteria andFactoryBetween(String value1, String value2) {
			addCriterion("factory between", value1, value2, "factory");
			return (Criteria) this;
		}

		public Criteria andFactoryNotBetween(String value1, String value2) {
			addCriterion("factory not between", value1, value2, "factory");
			return (Criteria) this;
		}

		public Criteria andProtoclIdIsNull() {
			addCriterion("protocl_id is null");
			return (Criteria) this;
		}

		public Criteria andProtoclIdIsNotNull() {
			addCriterion("protocl_id is not null");
			return (Criteria) this;
		}

		public Criteria andProtoclIdEqualTo(Integer value) {
			addCriterion("protocl_id =", value, "protoclId");
			return (Criteria) this;
		}

		public Criteria andProtoclIdNotEqualTo(Integer value) {
			addCriterion("protocl_id <>", value, "protoclId");
			return (Criteria) this;
		}

		public Criteria andProtoclIdGreaterThan(Integer value) {
			addCriterion("protocl_id >", value, "protoclId");
			return (Criteria) this;
		}

		public Criteria andProtoclIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("protocl_id >=", value, "protoclId");
			return (Criteria) this;
		}

		public Criteria andProtoclIdLessThan(Integer value) {
			addCriterion("protocl_id <", value, "protoclId");
			return (Criteria) this;
		}

		public Criteria andProtoclIdLessThanOrEqualTo(Integer value) {
			addCriterion("protocl_id <=", value, "protoclId");
			return (Criteria) this;
		}

		public Criteria andProtoclIdIn(List<Integer> values) {
			addCriterion("protocl_id in", values, "protoclId");
			return (Criteria) this;
		}

		public Criteria andProtoclIdNotIn(List<Integer> values) {
			addCriterion("protocl_id not in", values, "protoclId");
			return (Criteria) this;
		}

		public Criteria andProtoclIdBetween(Integer value1, Integer value2) {
			addCriterion("protocl_id between", value1, value2, "protoclId");
			return (Criteria) this;
		}

		public Criteria andProtoclIdNotBetween(Integer value1, Integer value2) {
			addCriterion("protocl_id not between", value1, value2, "protoclId");
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

		public Criteria andIsEnableEqualTo(Integer value) {
			addCriterion("is_enable =", value, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableNotEqualTo(Integer value) {
			addCriterion("is_enable <>", value, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableGreaterThan(Integer value) {
			addCriterion("is_enable >", value, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableGreaterThanOrEqualTo(Integer value) {
			addCriterion("is_enable >=", value, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableLessThan(Integer value) {
			addCriterion("is_enable <", value, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableLessThanOrEqualTo(Integer value) {
			addCriterion("is_enable <=", value, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableIn(List<Integer> values) {
			addCriterion("is_enable in", values, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableNotIn(List<Integer> values) {
			addCriterion("is_enable not in", values, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableBetween(Integer value1, Integer value2) {
			addCriterion("is_enable between", value1, value2, "isEnable");
			return (Criteria) this;
		}

		public Criteria andIsEnableNotBetween(Integer value1, Integer value2) {
			addCriterion("is_enable not between", value1, value2, "isEnable");
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

		public Criteria andSerialLikeInsensitive(String value) {
			addCriterion("upper(serial) like", value.toUpperCase(), "serial");
			return (Criteria) this;
		}

		public Criteria andTypeserialLikeInsensitive(String value) {
			addCriterion("upper(typeserial) like", value.toUpperCase(), "typeserial");
			return (Criteria) this;
		}

		public Criteria andLongAddressLikeInsensitive(String value) {
			addCriterion("upper(long_address) like", value.toUpperCase(), "longAddress");
			return (Criteria) this;
		}

		public Criteria andSubAddressLikeInsensitive(String value) {
			addCriterion("upper(sub_address) like", value.toUpperCase(), "subAddress");
			return (Criteria) this;
		}

		public Criteria andTypeLikeInsensitive(String value) {
			addCriterion("upper(type) like", value.toUpperCase(), "type");
			return (Criteria) this;
		}

		public Criteria andFactoryLikeInsensitive(String value) {
			addCriterion("upper(factory) like", value.toUpperCase(), "factory");
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