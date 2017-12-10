package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PromoteDreamSetExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PromoteDreamSetExample() {
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

        public Criteria andLimitNumberIsNull() {
            addCriterion("limit_number is null");
            return (Criteria) this;
        }

        public Criteria andLimitNumberIsNotNull() {
            addCriterion("limit_number is not null");
            return (Criteria) this;
        }

        public Criteria andLimitNumberEqualTo(Integer value) {
            addCriterion("limit_number =", value, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberNotEqualTo(Integer value) {
            addCriterion("limit_number <>", value, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberGreaterThan(Integer value) {
            addCriterion("limit_number >", value, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("limit_number >=", value, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberLessThan(Integer value) {
            addCriterion("limit_number <", value, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberLessThanOrEqualTo(Integer value) {
            addCriterion("limit_number <=", value, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberIn(List<Integer> values) {
            addCriterion("limit_number in", values, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberNotIn(List<Integer> values) {
            addCriterion("limit_number not in", values, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberBetween(Integer value1, Integer value2) {
            addCriterion("limit_number between", value1, value2, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andLimitNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("limit_number not between", value1, value2, "limitNumber");
            return (Criteria) this;
        }

        public Criteria andRemainNumberIsNull() {
            addCriterion("remain_number is null");
            return (Criteria) this;
        }

        public Criteria andRemainNumberIsNotNull() {
            addCriterion("remain_number is not null");
            return (Criteria) this;
        }

        public Criteria andRemainNumberEqualTo(Integer value) {
            addCriterion("remain_number =", value, "remainNumber");
            return (Criteria) this;
        }

        public Criteria andRemainNumberNotEqualTo(Integer value) {
            addCriterion("remain_number <>", value, "remainNumber");
            return (Criteria) this;
        }

        public Criteria andRemainNumberGreaterThan(Integer value) {
            addCriterion("remain_number >", value, "remainNumber");
            return (Criteria) this;
        }

        public Criteria andRemainNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("remain_number >=", value, "remainNumber");
            return (Criteria) this;
        }

        public Criteria andRemainNumberLessThan(Integer value) {
            addCriterion("remain_number <", value, "remainNumber");
            return (Criteria) this;
        }

        public Criteria andRemainNumberLessThanOrEqualTo(Integer value) {
            addCriterion("remain_number <=", value, "remainNumber");
            return (Criteria) this;
        }

        public Criteria andRemainNumberIn(List<Integer> values) {
            addCriterion("remain_number in", values, "remainNumber");
            return (Criteria) this;
        }

        public Criteria andRemainNumberNotIn(List<Integer> values) {
            addCriterion("remain_number not in", values, "remainNumber");
            return (Criteria) this;
        }

        public Criteria andRemainNumberBetween(Integer value1, Integer value2) {
            addCriterion("remain_number between", value1, value2, "remainNumber");
            return (Criteria) this;
        }

        public Criteria andRemainNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("remain_number not between", value1, value2, "remainNumber");
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

        public Criteria andRateEqualTo(BigDecimal value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(BigDecimal value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(BigDecimal value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(BigDecimal value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<BigDecimal> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<BigDecimal> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andPromoteNumberIsNull() {
            addCriterion("promote_number is null");
            return (Criteria) this;
        }

        public Criteria andPromoteNumberIsNotNull() {
            addCriterion("promote_number is not null");
            return (Criteria) this;
        }

        public Criteria andPromoteNumberEqualTo(Integer value) {
            addCriterion("promote_number =", value, "promoteNumber");
            return (Criteria) this;
        }

        public Criteria andPromoteNumberNotEqualTo(Integer value) {
            addCriterion("promote_number <>", value, "promoteNumber");
            return (Criteria) this;
        }

        public Criteria andPromoteNumberGreaterThan(Integer value) {
            addCriterion("promote_number >", value, "promoteNumber");
            return (Criteria) this;
        }

        public Criteria andPromoteNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("promote_number >=", value, "promoteNumber");
            return (Criteria) this;
        }

        public Criteria andPromoteNumberLessThan(Integer value) {
            addCriterion("promote_number <", value, "promoteNumber");
            return (Criteria) this;
        }

        public Criteria andPromoteNumberLessThanOrEqualTo(Integer value) {
            addCriterion("promote_number <=", value, "promoteNumber");
            return (Criteria) this;
        }

        public Criteria andPromoteNumberIn(List<Integer> values) {
            addCriterion("promote_number in", values, "promoteNumber");
            return (Criteria) this;
        }

        public Criteria andPromoteNumberNotIn(List<Integer> values) {
            addCriterion("promote_number not in", values, "promoteNumber");
            return (Criteria) this;
        }

        public Criteria andPromoteNumberBetween(Integer value1, Integer value2) {
            addCriterion("promote_number between", value1, value2, "promoteNumber");
            return (Criteria) this;
        }

        public Criteria andPromoteNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("promote_number not between", value1, value2, "promoteNumber");
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