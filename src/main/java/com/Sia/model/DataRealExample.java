package com.Sia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.Sia.model.GatewayExample.Criteria;

public class DataRealExample {
	protected String orderByClause;

	protected boolean distinct;

	protected List<Criteria> oredCriteria;

	protected int start;

	protected int limit;

	public DataRealExample() {
		oredCriteria = new ArrayList<Criteria>();
	}

	public DataRealExample(int start, int limit) {
		this.start = start;
		this.limit = limit;
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

		public Criteria andAdapterIdIsNull() {
			addCriterion("adapter_id is null");
			return (Criteria) this;
		}

		public Criteria andAdapterIdIsNotNull() {
			addCriterion("adapter_id is not null");
			return (Criteria) this;
		}

		public Criteria andAdapterIdEqualTo(Integer value) {
			addCriterion("adapter_id =", value, "adapterId");
			return (Criteria) this;
		}

		public Criteria andAdapterIdNotEqualTo(Integer value) {
			addCriterion("adapter_id <>", value, "adapterId");
			return (Criteria) this;
		}

		public Criteria andAdapterIdGreaterThan(Integer value) {
			addCriterion("adapter_id >", value, "adapterId");
			return (Criteria) this;
		}

		public Criteria andAdapterIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("adapter_id >=", value, "adapterId");
			return (Criteria) this;
		}

		public Criteria andAdapterIdLessThan(Integer value) {
			addCriterion("adapter_id <", value, "adapterId");
			return (Criteria) this;
		}

		public Criteria andAdapterIdLessThanOrEqualTo(Integer value) {
			addCriterion("adapter_id <=", value, "adapterId");
			return (Criteria) this;
		}

		public Criteria andAdapterIdIn(List<Integer> values) {
			addCriterion("adapter_id in", values, "adapterId");
			return (Criteria) this;
		}

		public Criteria andAdapterIdNotIn(List<Integer> values) {
			addCriterion("adapter_id not in", values, "adapterId");
			return (Criteria) this;
		}

		public Criteria andAdapterIdBetween(Integer value1, Integer value2) {
			addCriterion("adapter_id between", value1, value2, "adapterId");
			return (Criteria) this;
		}

		public Criteria andAdapterIdNotBetween(Integer value1, Integer value2) {
			addCriterion("adapter_id not between", value1, value2, "adapterId");
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

		public Criteria andValueTypeIsNull() {
			addCriterion("value_type is null");
			return (Criteria) this;
		}

		public Criteria andValueTypeIsNotNull() {
			addCriterion("value_type is not null");
			return (Criteria) this;
		}

		public Criteria andValueTypeEqualTo(String value) {
			addCriterion("value_type =", value, "valueType");
			return (Criteria) this;
		}

		public Criteria andValueTypeNotEqualTo(String value) {
			addCriterion("value_type <>", value, "valueType");
			return (Criteria) this;
		}

		public Criteria andValueTypeGreaterThan(String value) {
			addCriterion("value_type >", value, "valueType");
			return (Criteria) this;
		}

		public Criteria andValueTypeGreaterThanOrEqualTo(String value) {
			addCriterion("value_type >=", value, "valueType");
			return (Criteria) this;
		}

		public Criteria andValueTypeLessThan(String value) {
			addCriterion("value_type <", value, "valueType");
			return (Criteria) this;
		}

		public Criteria andValueTypeLessThanOrEqualTo(String value) {
			addCriterion("value_type <=", value, "valueType");
			return (Criteria) this;
		}

		public Criteria andValueTypeLike(String value) {
			addCriterion("value_type like", value, "valueType");
			return (Criteria) this;
		}

		public Criteria andValueTypeNotLike(String value) {
			addCriterion("value_type not like", value, "valueType");
			return (Criteria) this;
		}

		public Criteria andValueTypeIn(List<String> values) {
			addCriterion("value_type in", values, "valueType");
			return (Criteria) this;
		}

		public Criteria andValueTypeNotIn(List<String> values) {
			addCriterion("value_type not in", values, "valueType");
			return (Criteria) this;
		}

		public Criteria andValueTypeBetween(String value1, String value2) {
			addCriterion("value_type between", value1, value2, "valueType");
			return (Criteria) this;
		}

		public Criteria andValueTypeNotBetween(String value1, String value2) {
			addCriterion("value_type not between", value1, value2, "valueType");
			return (Criteria) this;
		}

		public Criteria andWriteAbleIsNull() {
			addCriterion("write_able is null");
			return (Criteria) this;
		}

		public Criteria andWriteAbleIsNotNull() {
			addCriterion("write_able is not null");
			return (Criteria) this;
		}

		public Criteria andWriteAbleEqualTo(String value) {
			addCriterion("write_able =", value, "writeAble");
			return (Criteria) this;
		}

		public Criteria andWriteAbleNotEqualTo(String value) {
			addCriterion("write_able <>", value, "writeAble");
			return (Criteria) this;
		}

		public Criteria andWriteAbleGreaterThan(String value) {
			addCriterion("write_able >", value, "writeAble");
			return (Criteria) this;
		}

		public Criteria andWriteAbleGreaterThanOrEqualTo(String value) {
			addCriterion("write_able >=", value, "writeAble");
			return (Criteria) this;
		}

		public Criteria andWriteAbleLessThan(String value) {
			addCriterion("write_able <", value, "writeAble");
			return (Criteria) this;
		}

		public Criteria andWriteAbleLessThanOrEqualTo(String value) {
			addCriterion("write_able <=", value, "writeAble");
			return (Criteria) this;
		}

		public Criteria andWriteAbleLike(String value) {
			addCriterion("write_able like", value, "writeAble");
			return (Criteria) this;
		}

		public Criteria andWriteAbleNotLike(String value) {
			addCriterion("write_able not like", value, "writeAble");
			return (Criteria) this;
		}

		public Criteria andWriteAbleIn(List<String> values) {
			addCriterion("write_able in", values, "writeAble");
			return (Criteria) this;
		}

		public Criteria andWriteAbleNotIn(List<String> values) {
			addCriterion("write_able not in", values, "writeAble");
			return (Criteria) this;
		}

		public Criteria andWriteAbleBetween(String value1, String value2) {
			addCriterion("write_able between", value1, value2, "writeAble");
			return (Criteria) this;
		}

		public Criteria andWriteAbleNotBetween(String value1, String value2) {
			addCriterion("write_able not between", value1, value2, "writeAble");
			return (Criteria) this;
		}

		public Criteria andTagIsNull() {
			addCriterion("tag is null");
			return (Criteria) this;
		}

		public Criteria andTagIsNotNull() {
			addCriterion("tag is not null");
			return (Criteria) this;
		}

		public Criteria andTagEqualTo(Byte value) {
			addCriterion("tag =", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagNotEqualTo(Byte value) {
			addCriterion("tag <>", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagGreaterThan(Byte value) {
			addCriterion("tag >", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagGreaterThanOrEqualTo(Byte value) {
			addCriterion("tag >=", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagLessThan(Byte value) {
			addCriterion("tag <", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagLessThanOrEqualTo(Byte value) {
			addCriterion("tag <=", value, "tag");
			return (Criteria) this;
		}

		public Criteria andTagIn(List<Byte> values) {
			addCriterion("tag in", values, "tag");
			return (Criteria) this;
		}

		public Criteria andTagNotIn(List<Byte> values) {
			addCriterion("tag not in", values, "tag");
			return (Criteria) this;
		}

		public Criteria andTagBetween(Byte value1, Byte value2) {
			addCriterion("tag between", value1, value2, "tag");
			return (Criteria) this;
		}

		public Criteria andTagNotBetween(Byte value1, Byte value2) {
			addCriterion("tag not between", value1, value2, "tag");
			return (Criteria) this;
		}

		public Criteria andValueIsNull() {
			addCriterion("value is null");
			return (Criteria) this;
		}

		public Criteria andValueIsNotNull() {
			addCriterion("value is not null");
			return (Criteria) this;
		}

		public Criteria andValueEqualTo(String value) {
			addCriterion("value =", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotEqualTo(String value) {
			addCriterion("value <>", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThan(String value) {
			addCriterion("value >", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueGreaterThanOrEqualTo(String value) {
			addCriterion("value >=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThan(String value) {
			addCriterion("value <", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLessThanOrEqualTo(String value) {
			addCriterion("value <=", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueLike(String value) {
			addCriterion("value like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotLike(String value) {
			addCriterion("value not like", value, "value");
			return (Criteria) this;
		}

		public Criteria andValueIn(List<String> values) {
			addCriterion("value in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotIn(List<String> values) {
			addCriterion("value not in", values, "value");
			return (Criteria) this;
		}

		public Criteria andValueBetween(String value1, String value2) {
			addCriterion("value between", value1, value2, "value");
			return (Criteria) this;
		}

		public Criteria andValueNotBetween(String value1, String value2) {
			addCriterion("value not between", value1, value2, "value");
			return (Criteria) this;
		}

		public Criteria andProtocolIdIsNull() {
			addCriterion("protocol_id is null");
			return (Criteria) this;
		}

		public Criteria andProtocolIdIsNotNull() {
			addCriterion("protocol_id is not null");
			return (Criteria) this;
		}

		public Criteria andProtocolIdEqualTo(Integer value) {
			addCriterion("protocol_id =", value, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdNotEqualTo(Integer value) {
			addCriterion("protocol_id <>", value, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdGreaterThan(Integer value) {
			addCriterion("protocol_id >", value, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdGreaterThanOrEqualTo(Integer value) {
			addCriterion("protocol_id >=", value, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdLessThan(Integer value) {
			addCriterion("protocol_id <", value, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdLessThanOrEqualTo(Integer value) {
			addCriterion("protocol_id <=", value, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdIn(List<Integer> values) {
			addCriterion("protocol_id in", values, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdNotIn(List<Integer> values) {
			addCriterion("protocol_id not in", values, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdBetween(Integer value1, Integer value2) {
			addCriterion("protocol_id between", value1, value2, "protocolId");
			return (Criteria) this;
		}

		public Criteria andProtocolIdNotBetween(Integer value1, Integer value2) {
			addCriterion("protocol_id not between", value1, value2, "protocolId");
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

		public Criteria andValueTypeLikeInsensitive(String value) {
			addCriterion("upper(value_type) like", value.toUpperCase(), "valueType");
			return (Criteria) this;
		}

		public Criteria andWriteAbleLikeInsensitive(String value) {
			addCriterion("upper(write_able) like", value.toUpperCase(), "writeAble");
			return (Criteria) this;
		}

		public Criteria andValueLikeInsensitive(String value) {
			addCriterion("upper(value) like", value.toUpperCase(), "value");
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