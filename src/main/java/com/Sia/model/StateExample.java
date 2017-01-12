package com.Sia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StateExample() {
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

        public Criteria andNetworkUpIsNull() {
            addCriterion("network_up is null");
            return (Criteria) this;
        }

        public Criteria andNetworkUpIsNotNull() {
            addCriterion("network_up is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkUpEqualTo(Date value) {
            addCriterion("network_up =", value, "networkUp");
            return (Criteria) this;
        }

        public Criteria andNetworkUpNotEqualTo(Date value) {
            addCriterion("network_up <>", value, "networkUp");
            return (Criteria) this;
        }

        public Criteria andNetworkUpGreaterThan(Date value) {
            addCriterion("network_up >", value, "networkUp");
            return (Criteria) this;
        }

        public Criteria andNetworkUpGreaterThanOrEqualTo(Date value) {
            addCriterion("network_up >=", value, "networkUp");
            return (Criteria) this;
        }

        public Criteria andNetworkUpLessThan(Date value) {
            addCriterion("network_up <", value, "networkUp");
            return (Criteria) this;
        }

        public Criteria andNetworkUpLessThanOrEqualTo(Date value) {
            addCriterion("network_up <=", value, "networkUp");
            return (Criteria) this;
        }

        public Criteria andNetworkUpIn(List<Date> values) {
            addCriterion("network_up in", values, "networkUp");
            return (Criteria) this;
        }

        public Criteria andNetworkUpNotIn(List<Date> values) {
            addCriterion("network_up not in", values, "networkUp");
            return (Criteria) this;
        }

        public Criteria andNetworkUpBetween(Date value1, Date value2) {
            addCriterion("network_up between", value1, value2, "networkUp");
            return (Criteria) this;
        }

        public Criteria andNetworkUpNotBetween(Date value1, Date value2) {
            addCriterion("network_up not between", value1, value2, "networkUp");
            return (Criteria) this;
        }

        public Criteria andHealthUpIsNull() {
            addCriterion("health_up is null");
            return (Criteria) this;
        }

        public Criteria andHealthUpIsNotNull() {
            addCriterion("health_up is not null");
            return (Criteria) this;
        }

        public Criteria andHealthUpEqualTo(Date value) {
            addCriterion("health_up =", value, "healthUp");
            return (Criteria) this;
        }

        public Criteria andHealthUpNotEqualTo(Date value) {
            addCriterion("health_up <>", value, "healthUp");
            return (Criteria) this;
        }

        public Criteria andHealthUpGreaterThan(Date value) {
            addCriterion("health_up >", value, "healthUp");
            return (Criteria) this;
        }

        public Criteria andHealthUpGreaterThanOrEqualTo(Date value) {
            addCriterion("health_up >=", value, "healthUp");
            return (Criteria) this;
        }

        public Criteria andHealthUpLessThan(Date value) {
            addCriterion("health_up <", value, "healthUp");
            return (Criteria) this;
        }

        public Criteria andHealthUpLessThanOrEqualTo(Date value) {
            addCriterion("health_up <=", value, "healthUp");
            return (Criteria) this;
        }

        public Criteria andHealthUpIn(List<Date> values) {
            addCriterion("health_up in", values, "healthUp");
            return (Criteria) this;
        }

        public Criteria andHealthUpNotIn(List<Date> values) {
            addCriterion("health_up not in", values, "healthUp");
            return (Criteria) this;
        }

        public Criteria andHealthUpBetween(Date value1, Date value2) {
            addCriterion("health_up between", value1, value2, "healthUp");
            return (Criteria) this;
        }

        public Criteria andHealthUpNotBetween(Date value1, Date value2) {
            addCriterion("health_up not between", value1, value2, "healthUp");
            return (Criteria) this;
        }

        public Criteria andDataUpIsNull() {
            addCriterion("data_up is null");
            return (Criteria) this;
        }

        public Criteria andDataUpIsNotNull() {
            addCriterion("data_up is not null");
            return (Criteria) this;
        }

        public Criteria andDataUpEqualTo(Date value) {
            addCriterion("data_up =", value, "dataUp");
            return (Criteria) this;
        }

        public Criteria andDataUpNotEqualTo(Date value) {
            addCriterion("data_up <>", value, "dataUp");
            return (Criteria) this;
        }

        public Criteria andDataUpGreaterThan(Date value) {
            addCriterion("data_up >", value, "dataUp");
            return (Criteria) this;
        }

        public Criteria andDataUpGreaterThanOrEqualTo(Date value) {
            addCriterion("data_up >=", value, "dataUp");
            return (Criteria) this;
        }

        public Criteria andDataUpLessThan(Date value) {
            addCriterion("data_up <", value, "dataUp");
            return (Criteria) this;
        }

        public Criteria andDataUpLessThanOrEqualTo(Date value) {
            addCriterion("data_up <=", value, "dataUp");
            return (Criteria) this;
        }

        public Criteria andDataUpIn(List<Date> values) {
            addCriterion("data_up in", values, "dataUp");
            return (Criteria) this;
        }

        public Criteria andDataUpNotIn(List<Date> values) {
            addCriterion("data_up not in", values, "dataUp");
            return (Criteria) this;
        }

        public Criteria andDataUpBetween(Date value1, Date value2) {
            addCriterion("data_up between", value1, value2, "dataUp");
            return (Criteria) this;
        }

        public Criteria andDataUpNotBetween(Date value1, Date value2) {
            addCriterion("data_up not between", value1, value2, "dataUp");
            return (Criteria) this;
        }

        public Criteria andSigMagIsNull() {
            addCriterion("sig_mag is null");
            return (Criteria) this;
        }

        public Criteria andSigMagIsNotNull() {
            addCriterion("sig_mag is not null");
            return (Criteria) this;
        }

        public Criteria andSigMagEqualTo(Byte value) {
            addCriterion("sig_mag =", value, "sigMag");
            return (Criteria) this;
        }

        public Criteria andSigMagNotEqualTo(Byte value) {
            addCriterion("sig_mag <>", value, "sigMag");
            return (Criteria) this;
        }

        public Criteria andSigMagGreaterThan(Byte value) {
            addCriterion("sig_mag >", value, "sigMag");
            return (Criteria) this;
        }

        public Criteria andSigMagGreaterThanOrEqualTo(Byte value) {
            addCriterion("sig_mag >=", value, "sigMag");
            return (Criteria) this;
        }

        public Criteria andSigMagLessThan(Byte value) {
            addCriterion("sig_mag <", value, "sigMag");
            return (Criteria) this;
        }

        public Criteria andSigMagLessThanOrEqualTo(Byte value) {
            addCriterion("sig_mag <=", value, "sigMag");
            return (Criteria) this;
        }

        public Criteria andSigMagIn(List<Byte> values) {
            addCriterion("sig_mag in", values, "sigMag");
            return (Criteria) this;
        }

        public Criteria andSigMagNotIn(List<Byte> values) {
            addCriterion("sig_mag not in", values, "sigMag");
            return (Criteria) this;
        }

        public Criteria andSigMagBetween(Byte value1, Byte value2) {
            addCriterion("sig_mag between", value1, value2, "sigMag");
            return (Criteria) this;
        }

        public Criteria andSigMagNotBetween(Byte value1, Byte value2) {
            addCriterion("sig_mag not between", value1, value2, "sigMag");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(Byte value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(Byte value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(Byte value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(Byte value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(Byte value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(Byte value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<Byte> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<Byte> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(Byte value1, Byte value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(Byte value1, Byte value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andLostNumIsNull() {
            addCriterion("lost_num is null");
            return (Criteria) this;
        }

        public Criteria andLostNumIsNotNull() {
            addCriterion("lost_num is not null");
            return (Criteria) this;
        }

        public Criteria andLostNumEqualTo(Byte value) {
            addCriterion("lost_num =", value, "lostNum");
            return (Criteria) this;
        }

        public Criteria andLostNumNotEqualTo(Byte value) {
            addCriterion("lost_num <>", value, "lostNum");
            return (Criteria) this;
        }

        public Criteria andLostNumGreaterThan(Byte value) {
            addCriterion("lost_num >", value, "lostNum");
            return (Criteria) this;
        }

        public Criteria andLostNumGreaterThanOrEqualTo(Byte value) {
            addCriterion("lost_num >=", value, "lostNum");
            return (Criteria) this;
        }

        public Criteria andLostNumLessThan(Byte value) {
            addCriterion("lost_num <", value, "lostNum");
            return (Criteria) this;
        }

        public Criteria andLostNumLessThanOrEqualTo(Byte value) {
            addCriterion("lost_num <=", value, "lostNum");
            return (Criteria) this;
        }

        public Criteria andLostNumIn(List<Byte> values) {
            addCriterion("lost_num in", values, "lostNum");
            return (Criteria) this;
        }

        public Criteria andLostNumNotIn(List<Byte> values) {
            addCriterion("lost_num not in", values, "lostNum");
            return (Criteria) this;
        }

        public Criteria andLostNumBetween(Byte value1, Byte value2) {
            addCriterion("lost_num between", value1, value2, "lostNum");
            return (Criteria) this;
        }

        public Criteria andLostNumNotBetween(Byte value1, Byte value2) {
            addCriterion("lost_num not between", value1, value2, "lostNum");
            return (Criteria) this;
        }

        public Criteria andLostTimeIsNull() {
            addCriterion("lost_time is null");
            return (Criteria) this;
        }

        public Criteria andLostTimeIsNotNull() {
            addCriterion("lost_time is not null");
            return (Criteria) this;
        }

        public Criteria andLostTimeEqualTo(Integer value) {
            addCriterion("lost_time =", value, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeNotEqualTo(Integer value) {
            addCriterion("lost_time <>", value, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeGreaterThan(Integer value) {
            addCriterion("lost_time >", value, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("lost_time >=", value, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeLessThan(Integer value) {
            addCriterion("lost_time <", value, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeLessThanOrEqualTo(Integer value) {
            addCriterion("lost_time <=", value, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeIn(List<Integer> values) {
            addCriterion("lost_time in", values, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeNotIn(List<Integer> values) {
            addCriterion("lost_time not in", values, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeBetween(Integer value1, Integer value2) {
            addCriterion("lost_time between", value1, value2, "lostTime");
            return (Criteria) this;
        }

        public Criteria andLostTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("lost_time not between", value1, value2, "lostTime");
            return (Criteria) this;
        }

        public Criteria andDiaResultIsNull() {
            addCriterion("dia_result is null");
            return (Criteria) this;
        }

        public Criteria andDiaResultIsNotNull() {
            addCriterion("dia_result is not null");
            return (Criteria) this;
        }

        public Criteria andDiaResultEqualTo(Byte value) {
            addCriterion("dia_result =", value, "diaResult");
            return (Criteria) this;
        }

        public Criteria andDiaResultNotEqualTo(Byte value) {
            addCriterion("dia_result <>", value, "diaResult");
            return (Criteria) this;
        }

        public Criteria andDiaResultGreaterThan(Byte value) {
            addCriterion("dia_result >", value, "diaResult");
            return (Criteria) this;
        }

        public Criteria andDiaResultGreaterThanOrEqualTo(Byte value) {
            addCriterion("dia_result >=", value, "diaResult");
            return (Criteria) this;
        }

        public Criteria andDiaResultLessThan(Byte value) {
            addCriterion("dia_result <", value, "diaResult");
            return (Criteria) this;
        }

        public Criteria andDiaResultLessThanOrEqualTo(Byte value) {
            addCriterion("dia_result <=", value, "diaResult");
            return (Criteria) this;
        }

        public Criteria andDiaResultIn(List<Byte> values) {
            addCriterion("dia_result in", values, "diaResult");
            return (Criteria) this;
        }

        public Criteria andDiaResultNotIn(List<Byte> values) {
            addCriterion("dia_result not in", values, "diaResult");
            return (Criteria) this;
        }

        public Criteria andDiaResultBetween(Byte value1, Byte value2) {
            addCriterion("dia_result between", value1, value2, "diaResult");
            return (Criteria) this;
        }

        public Criteria andDiaResultNotBetween(Byte value1, Byte value2) {
            addCriterion("dia_result not between", value1, value2, "diaResult");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andSuggeatIsNull() {
            addCriterion("suggeat is null");
            return (Criteria) this;
        }

        public Criteria andSuggeatIsNotNull() {
            addCriterion("suggeat is not null");
            return (Criteria) this;
        }

        public Criteria andSuggeatEqualTo(String value) {
            addCriterion("suggeat =", value, "suggeat");
            return (Criteria) this;
        }

        public Criteria andSuggeatNotEqualTo(String value) {
            addCriterion("suggeat <>", value, "suggeat");
            return (Criteria) this;
        }

        public Criteria andSuggeatGreaterThan(String value) {
            addCriterion("suggeat >", value, "suggeat");
            return (Criteria) this;
        }

        public Criteria andSuggeatGreaterThanOrEqualTo(String value) {
            addCriterion("suggeat >=", value, "suggeat");
            return (Criteria) this;
        }

        public Criteria andSuggeatLessThan(String value) {
            addCriterion("suggeat <", value, "suggeat");
            return (Criteria) this;
        }

        public Criteria andSuggeatLessThanOrEqualTo(String value) {
            addCriterion("suggeat <=", value, "suggeat");
            return (Criteria) this;
        }

        public Criteria andSuggeatLike(String value) {
            addCriterion("suggeat like", value, "suggeat");
            return (Criteria) this;
        }

        public Criteria andSuggeatNotLike(String value) {
            addCriterion("suggeat not like", value, "suggeat");
            return (Criteria) this;
        }

        public Criteria andSuggeatIn(List<String> values) {
            addCriterion("suggeat in", values, "suggeat");
            return (Criteria) this;
        }

        public Criteria andSuggeatNotIn(List<String> values) {
            addCriterion("suggeat not in", values, "suggeat");
            return (Criteria) this;
        }

        public Criteria andSuggeatBetween(String value1, String value2) {
            addCriterion("suggeat between", value1, value2, "suggeat");
            return (Criteria) this;
        }

        public Criteria andSuggeatNotBetween(String value1, String value2) {
            addCriterion("suggeat not between", value1, value2, "suggeat");
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

        public Criteria andDescriptionLikeInsensitive(String value) {
            addCriterion("upper(description) like", value.toUpperCase(), "description");
            return (Criteria) this;
        }

        public Criteria andSuggeatLikeInsensitive(String value) {
            addCriterion("upper(suggeat) like", value.toUpperCase(), "suggeat");
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