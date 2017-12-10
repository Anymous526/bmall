package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class MutualBenefitExample extends BaseQuery{
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MutualBenefitExample() {
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

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andMutualFeeIsNull() {
            addCriterion("mutual_fee is null");
            return (Criteria) this;
        }

        public Criteria andMutualFeeIsNotNull() {
            addCriterion("mutual_fee is not null");
            return (Criteria) this;
        }

        public Criteria andMutualFeeEqualTo(BigDecimal value) {
            addCriterion("mutual_fee =", value, "mutualFee");
            return (Criteria) this;
        }

        public Criteria andMutualFeeNotEqualTo(BigDecimal value) {
            addCriterion("mutual_fee <>", value, "mutualFee");
            return (Criteria) this;
        }

        public Criteria andMutualFeeGreaterThan(BigDecimal value) {
            addCriterion("mutual_fee >", value, "mutualFee");
            return (Criteria) this;
        }

        public Criteria andMutualFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mutual_fee >=", value, "mutualFee");
            return (Criteria) this;
        }

        public Criteria andMutualFeeLessThan(BigDecimal value) {
            addCriterion("mutual_fee <", value, "mutualFee");
            return (Criteria) this;
        }

        public Criteria andMutualFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mutual_fee <=", value, "mutualFee");
            return (Criteria) this;
        }

        public Criteria andMutualFeeIn(List<BigDecimal> values) {
            addCriterion("mutual_fee in", values, "mutualFee");
            return (Criteria) this;
        }

        public Criteria andMutualFeeNotIn(List<BigDecimal> values) {
            addCriterion("mutual_fee not in", values, "mutualFee");
            return (Criteria) this;
        }

        public Criteria andMutualFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mutual_fee between", value1, value2, "mutualFee");
            return (Criteria) this;
        }

        public Criteria andMutualFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mutual_fee not between", value1, value2, "mutualFee");
            return (Criteria) this;
        }

        public Criteria andGetUserIdIsNull() {
            addCriterion("get_user_id is null");
            return (Criteria) this;
        }

        public Criteria andGetUserIdIsNotNull() {
            addCriterion("get_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andGetUserIdEqualTo(Long value) {
            addCriterion("get_user_id =", value, "getUserId");
            return (Criteria) this;
        }

        public Criteria andGetUserIdNotEqualTo(Long value) {
            addCriterion("get_user_id <>", value, "getUserId");
            return (Criteria) this;
        }

        public Criteria andGetUserIdGreaterThan(Long value) {
            addCriterion("get_user_id >", value, "getUserId");
            return (Criteria) this;
        }

        public Criteria andGetUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("get_user_id >=", value, "getUserId");
            return (Criteria) this;
        }

        public Criteria andGetUserIdLessThan(Long value) {
            addCriterion("get_user_id <", value, "getUserId");
            return (Criteria) this;
        }

        public Criteria andGetUserIdLessThanOrEqualTo(Long value) {
            addCriterion("get_user_id <=", value, "getUserId");
            return (Criteria) this;
        }

        public Criteria andGetUserIdIn(List<Long> values) {
            addCriterion("get_user_id in", values, "getUserId");
            return (Criteria) this;
        }

        public Criteria andGetUserIdNotIn(List<Long> values) {
            addCriterion("get_user_id not in", values, "getUserId");
            return (Criteria) this;
        }

        public Criteria andGetUserIdBetween(Long value1, Long value2) {
            addCriterion("get_user_id between", value1, value2, "getUserId");
            return (Criteria) this;
        }

        public Criteria andGetUserIdNotBetween(Long value1, Long value2) {
            addCriterion("get_user_id not between", value1, value2, "getUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdIsNull() {
            addCriterion("give_user_id is null");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdIsNotNull() {
            addCriterion("give_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdEqualTo(Long value) {
            addCriterion("give_user_id =", value, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdNotEqualTo(Long value) {
            addCriterion("give_user_id <>", value, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdGreaterThan(Long value) {
            addCriterion("give_user_id >", value, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("give_user_id >=", value, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdLessThan(Long value) {
            addCriterion("give_user_id <", value, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdLessThanOrEqualTo(Long value) {
            addCriterion("give_user_id <=", value, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdIn(List<Long> values) {
            addCriterion("give_user_id in", values, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdNotIn(List<Long> values) {
            addCriterion("give_user_id not in", values, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdBetween(Long value1, Long value2) {
            addCriterion("give_user_id between", value1, value2, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdNotBetween(Long value1, Long value2) {
            addCriterion("give_user_id not between", value1, value2, "giveUserId");
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