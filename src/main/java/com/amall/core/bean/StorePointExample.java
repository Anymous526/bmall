package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class StorePointExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StorePointExample() {
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

        public Criteria andAddtimeIsNull() {
            addCriterion("addTime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addTime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addTime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addTime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addTime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addTime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addTime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addTime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addTime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addTime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addTime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addTime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andDeletestatusIsNull() {
            addCriterion("deleteStatus is null");
            return (Criteria) this;
        }

        public Criteria andDeletestatusIsNotNull() {
            addCriterion("deleteStatus is not null");
            return (Criteria) this;
        }

        public Criteria andDeletestatusEqualTo(Boolean value) {
            addCriterion("deleteStatus =", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusNotEqualTo(Boolean value) {
            addCriterion("deleteStatus <>", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusGreaterThan(Boolean value) {
            addCriterion("deleteStatus >", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleteStatus >=", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusLessThan(Boolean value) {
            addCriterion("deleteStatus <", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusLessThanOrEqualTo(Boolean value) {
            addCriterion("deleteStatus <=", value, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusIn(List<Boolean> values) {
            addCriterion("deleteStatus in", values, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusNotIn(List<Boolean> values) {
            addCriterion("deleteStatus not in", values, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusBetween(Boolean value1, Boolean value2) {
            addCriterion("deleteStatus between", value1, value2, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDeletestatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleteStatus not between", value1, value2, "deletestatus");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateIsNull() {
            addCriterion("description_evaluate is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateIsNotNull() {
            addCriterion("description_evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateEqualTo(BigDecimal value) {
            addCriterion("description_evaluate =", value, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateNotEqualTo(BigDecimal value) {
            addCriterion("description_evaluate <>", value, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateGreaterThan(BigDecimal value) {
            addCriterion("description_evaluate >", value, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("description_evaluate >=", value, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateLessThan(BigDecimal value) {
            addCriterion("description_evaluate <", value, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("description_evaluate <=", value, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateIn(List<BigDecimal> values) {
            addCriterion("description_evaluate in", values, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateNotIn(List<BigDecimal> values) {
            addCriterion("description_evaluate not in", values, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("description_evaluate between", value1, value2, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("description_evaluate not between", value1, value2, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearIsNull() {
            addCriterion("description_evaluate_halfyear is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearIsNotNull() {
            addCriterion("description_evaluate_halfyear is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearEqualTo(BigDecimal value) {
            addCriterion("description_evaluate_halfyear =", value, "descriptionEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearNotEqualTo(BigDecimal value) {
            addCriterion("description_evaluate_halfyear <>", value, "descriptionEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearGreaterThan(BigDecimal value) {
            addCriterion("description_evaluate_halfyear >", value, "descriptionEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("description_evaluate_halfyear >=", value, "descriptionEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearLessThan(BigDecimal value) {
            addCriterion("description_evaluate_halfyear <", value, "descriptionEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearLessThanOrEqualTo(BigDecimal value) {
            addCriterion("description_evaluate_halfyear <=", value, "descriptionEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearIn(List<BigDecimal> values) {
            addCriterion("description_evaluate_halfyear in", values, "descriptionEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearNotIn(List<BigDecimal> values) {
            addCriterion("description_evaluate_halfyear not in", values, "descriptionEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("description_evaluate_halfyear between", value1, value2, "descriptionEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("description_evaluate_halfyear not between", value1, value2, "descriptionEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount1IsNull() {
            addCriterion("description_evaluate_halfyear_count1 is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount1IsNotNull() {
            addCriterion("description_evaluate_halfyear_count1 is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount1EqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count1 =", value, "descriptionEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount1NotEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count1 <>", value, "descriptionEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount1GreaterThan(Integer value) {
            addCriterion("description_evaluate_halfyear_count1 >", value, "descriptionEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount1GreaterThanOrEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count1 >=", value, "descriptionEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount1LessThan(Integer value) {
            addCriterion("description_evaluate_halfyear_count1 <", value, "descriptionEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount1LessThanOrEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count1 <=", value, "descriptionEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount1In(List<Integer> values) {
            addCriterion("description_evaluate_halfyear_count1 in", values, "descriptionEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount1NotIn(List<Integer> values) {
            addCriterion("description_evaluate_halfyear_count1 not in", values, "descriptionEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount1Between(Integer value1, Integer value2) {
            addCriterion("description_evaluate_halfyear_count1 between", value1, value2, "descriptionEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount1NotBetween(Integer value1, Integer value2) {
            addCriterion("description_evaluate_halfyear_count1 not between", value1, value2, "descriptionEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount2IsNull() {
            addCriterion("description_evaluate_halfyear_count2 is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount2IsNotNull() {
            addCriterion("description_evaluate_halfyear_count2 is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount2EqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count2 =", value, "descriptionEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount2NotEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count2 <>", value, "descriptionEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount2GreaterThan(Integer value) {
            addCriterion("description_evaluate_halfyear_count2 >", value, "descriptionEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount2GreaterThanOrEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count2 >=", value, "descriptionEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount2LessThan(Integer value) {
            addCriterion("description_evaluate_halfyear_count2 <", value, "descriptionEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount2LessThanOrEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count2 <=", value, "descriptionEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount2In(List<Integer> values) {
            addCriterion("description_evaluate_halfyear_count2 in", values, "descriptionEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount2NotIn(List<Integer> values) {
            addCriterion("description_evaluate_halfyear_count2 not in", values, "descriptionEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount2Between(Integer value1, Integer value2) {
            addCriterion("description_evaluate_halfyear_count2 between", value1, value2, "descriptionEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount2NotBetween(Integer value1, Integer value2) {
            addCriterion("description_evaluate_halfyear_count2 not between", value1, value2, "descriptionEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount3IsNull() {
            addCriterion("description_evaluate_halfyear_count3 is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount3IsNotNull() {
            addCriterion("description_evaluate_halfyear_count3 is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount3EqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count3 =", value, "descriptionEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount3NotEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count3 <>", value, "descriptionEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount3GreaterThan(Integer value) {
            addCriterion("description_evaluate_halfyear_count3 >", value, "descriptionEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount3GreaterThanOrEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count3 >=", value, "descriptionEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount3LessThan(Integer value) {
            addCriterion("description_evaluate_halfyear_count3 <", value, "descriptionEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount3LessThanOrEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count3 <=", value, "descriptionEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount3In(List<Integer> values) {
            addCriterion("description_evaluate_halfyear_count3 in", values, "descriptionEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount3NotIn(List<Integer> values) {
            addCriterion("description_evaluate_halfyear_count3 not in", values, "descriptionEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount3Between(Integer value1, Integer value2) {
            addCriterion("description_evaluate_halfyear_count3 between", value1, value2, "descriptionEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount3NotBetween(Integer value1, Integer value2) {
            addCriterion("description_evaluate_halfyear_count3 not between", value1, value2, "descriptionEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount4IsNull() {
            addCriterion("description_evaluate_halfyear_count4 is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount4IsNotNull() {
            addCriterion("description_evaluate_halfyear_count4 is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount4EqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count4 =", value, "descriptionEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount4NotEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count4 <>", value, "descriptionEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount4GreaterThan(Integer value) {
            addCriterion("description_evaluate_halfyear_count4 >", value, "descriptionEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount4GreaterThanOrEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count4 >=", value, "descriptionEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount4LessThan(Integer value) {
            addCriterion("description_evaluate_halfyear_count4 <", value, "descriptionEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount4LessThanOrEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count4 <=", value, "descriptionEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount4In(List<Integer> values) {
            addCriterion("description_evaluate_halfyear_count4 in", values, "descriptionEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount4NotIn(List<Integer> values) {
            addCriterion("description_evaluate_halfyear_count4 not in", values, "descriptionEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount4Between(Integer value1, Integer value2) {
            addCriterion("description_evaluate_halfyear_count4 between", value1, value2, "descriptionEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount4NotBetween(Integer value1, Integer value2) {
            addCriterion("description_evaluate_halfyear_count4 not between", value1, value2, "descriptionEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount5IsNull() {
            addCriterion("description_evaluate_halfyear_count5 is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount5IsNotNull() {
            addCriterion("description_evaluate_halfyear_count5 is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount5EqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count5 =", value, "descriptionEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount5NotEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count5 <>", value, "descriptionEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount5GreaterThan(Integer value) {
            addCriterion("description_evaluate_halfyear_count5 >", value, "descriptionEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount5GreaterThanOrEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count5 >=", value, "descriptionEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount5LessThan(Integer value) {
            addCriterion("description_evaluate_halfyear_count5 <", value, "descriptionEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount5LessThanOrEqualTo(Integer value) {
            addCriterion("description_evaluate_halfyear_count5 <=", value, "descriptionEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount5In(List<Integer> values) {
            addCriterion("description_evaluate_halfyear_count5 in", values, "descriptionEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount5NotIn(List<Integer> values) {
            addCriterion("description_evaluate_halfyear_count5 not in", values, "descriptionEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount5Between(Integer value1, Integer value2) {
            addCriterion("description_evaluate_halfyear_count5 between", value1, value2, "descriptionEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateHalfyearCount5NotBetween(Integer value1, Integer value2) {
            addCriterion("description_evaluate_halfyear_count5 not between", value1, value2, "descriptionEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateIsNull() {
            addCriterion("service_evaluate is null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateIsNotNull() {
            addCriterion("service_evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateEqualTo(BigDecimal value) {
            addCriterion("service_evaluate =", value, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateNotEqualTo(BigDecimal value) {
            addCriterion("service_evaluate <>", value, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateGreaterThan(BigDecimal value) {
            addCriterion("service_evaluate >", value, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_evaluate >=", value, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateLessThan(BigDecimal value) {
            addCriterion("service_evaluate <", value, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_evaluate <=", value, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateIn(List<BigDecimal> values) {
            addCriterion("service_evaluate in", values, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateNotIn(List<BigDecimal> values) {
            addCriterion("service_evaluate not in", values, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_evaluate between", value1, value2, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_evaluate not between", value1, value2, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearIsNull() {
            addCriterion("service_evaluate_halfyear is null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearIsNotNull() {
            addCriterion("service_evaluate_halfyear is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearEqualTo(BigDecimal value) {
            addCriterion("service_evaluate_halfyear =", value, "serviceEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearNotEqualTo(BigDecimal value) {
            addCriterion("service_evaluate_halfyear <>", value, "serviceEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearGreaterThan(BigDecimal value) {
            addCriterion("service_evaluate_halfyear >", value, "serviceEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_evaluate_halfyear >=", value, "serviceEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearLessThan(BigDecimal value) {
            addCriterion("service_evaluate_halfyear <", value, "serviceEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_evaluate_halfyear <=", value, "serviceEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearIn(List<BigDecimal> values) {
            addCriterion("service_evaluate_halfyear in", values, "serviceEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearNotIn(List<BigDecimal> values) {
            addCriterion("service_evaluate_halfyear not in", values, "serviceEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_evaluate_halfyear between", value1, value2, "serviceEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_evaluate_halfyear not between", value1, value2, "serviceEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount1IsNull() {
            addCriterion("service_evaluate_halfyear_count1 is null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount1IsNotNull() {
            addCriterion("service_evaluate_halfyear_count1 is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount1EqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count1 =", value, "serviceEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount1NotEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count1 <>", value, "serviceEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount1GreaterThan(Integer value) {
            addCriterion("service_evaluate_halfyear_count1 >", value, "serviceEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount1GreaterThanOrEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count1 >=", value, "serviceEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount1LessThan(Integer value) {
            addCriterion("service_evaluate_halfyear_count1 <", value, "serviceEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount1LessThanOrEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count1 <=", value, "serviceEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount1In(List<Integer> values) {
            addCriterion("service_evaluate_halfyear_count1 in", values, "serviceEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount1NotIn(List<Integer> values) {
            addCriterion("service_evaluate_halfyear_count1 not in", values, "serviceEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount1Between(Integer value1, Integer value2) {
            addCriterion("service_evaluate_halfyear_count1 between", value1, value2, "serviceEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount1NotBetween(Integer value1, Integer value2) {
            addCriterion("service_evaluate_halfyear_count1 not between", value1, value2, "serviceEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount2IsNull() {
            addCriterion("service_evaluate_halfyear_count2 is null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount2IsNotNull() {
            addCriterion("service_evaluate_halfyear_count2 is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount2EqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count2 =", value, "serviceEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount2NotEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count2 <>", value, "serviceEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount2GreaterThan(Integer value) {
            addCriterion("service_evaluate_halfyear_count2 >", value, "serviceEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount2GreaterThanOrEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count2 >=", value, "serviceEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount2LessThan(Integer value) {
            addCriterion("service_evaluate_halfyear_count2 <", value, "serviceEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount2LessThanOrEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count2 <=", value, "serviceEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount2In(List<Integer> values) {
            addCriterion("service_evaluate_halfyear_count2 in", values, "serviceEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount2NotIn(List<Integer> values) {
            addCriterion("service_evaluate_halfyear_count2 not in", values, "serviceEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount2Between(Integer value1, Integer value2) {
            addCriterion("service_evaluate_halfyear_count2 between", value1, value2, "serviceEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount2NotBetween(Integer value1, Integer value2) {
            addCriterion("service_evaluate_halfyear_count2 not between", value1, value2, "serviceEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount3IsNull() {
            addCriterion("service_evaluate_halfyear_count3 is null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount3IsNotNull() {
            addCriterion("service_evaluate_halfyear_count3 is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount3EqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count3 =", value, "serviceEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount3NotEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count3 <>", value, "serviceEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount3GreaterThan(Integer value) {
            addCriterion("service_evaluate_halfyear_count3 >", value, "serviceEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount3GreaterThanOrEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count3 >=", value, "serviceEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount3LessThan(Integer value) {
            addCriterion("service_evaluate_halfyear_count3 <", value, "serviceEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount3LessThanOrEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count3 <=", value, "serviceEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount3In(List<Integer> values) {
            addCriterion("service_evaluate_halfyear_count3 in", values, "serviceEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount3NotIn(List<Integer> values) {
            addCriterion("service_evaluate_halfyear_count3 not in", values, "serviceEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount3Between(Integer value1, Integer value2) {
            addCriterion("service_evaluate_halfyear_count3 between", value1, value2, "serviceEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount3NotBetween(Integer value1, Integer value2) {
            addCriterion("service_evaluate_halfyear_count3 not between", value1, value2, "serviceEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount4IsNull() {
            addCriterion("service_evaluate_halfyear_count4 is null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount4IsNotNull() {
            addCriterion("service_evaluate_halfyear_count4 is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount4EqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count4 =", value, "serviceEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount4NotEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count4 <>", value, "serviceEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount4GreaterThan(Integer value) {
            addCriterion("service_evaluate_halfyear_count4 >", value, "serviceEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount4GreaterThanOrEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count4 >=", value, "serviceEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount4LessThan(Integer value) {
            addCriterion("service_evaluate_halfyear_count4 <", value, "serviceEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount4LessThanOrEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count4 <=", value, "serviceEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount4In(List<Integer> values) {
            addCriterion("service_evaluate_halfyear_count4 in", values, "serviceEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount4NotIn(List<Integer> values) {
            addCriterion("service_evaluate_halfyear_count4 not in", values, "serviceEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount4Between(Integer value1, Integer value2) {
            addCriterion("service_evaluate_halfyear_count4 between", value1, value2, "serviceEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount4NotBetween(Integer value1, Integer value2) {
            addCriterion("service_evaluate_halfyear_count4 not between", value1, value2, "serviceEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount5IsNull() {
            addCriterion("service_evaluate_halfyear_count5 is null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount5IsNotNull() {
            addCriterion("service_evaluate_halfyear_count5 is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount5EqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count5 =", value, "serviceEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount5NotEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count5 <>", value, "serviceEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount5GreaterThan(Integer value) {
            addCriterion("service_evaluate_halfyear_count5 >", value, "serviceEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount5GreaterThanOrEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count5 >=", value, "serviceEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount5LessThan(Integer value) {
            addCriterion("service_evaluate_halfyear_count5 <", value, "serviceEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount5LessThanOrEqualTo(Integer value) {
            addCriterion("service_evaluate_halfyear_count5 <=", value, "serviceEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount5In(List<Integer> values) {
            addCriterion("service_evaluate_halfyear_count5 in", values, "serviceEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount5NotIn(List<Integer> values) {
            addCriterion("service_evaluate_halfyear_count5 not in", values, "serviceEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount5Between(Integer value1, Integer value2) {
            addCriterion("service_evaluate_halfyear_count5 between", value1, value2, "serviceEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateHalfyearCount5NotBetween(Integer value1, Integer value2) {
            addCriterion("service_evaluate_halfyear_count5 not between", value1, value2, "serviceEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateIsNull() {
            addCriterion("ship_evaluate is null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateIsNotNull() {
            addCriterion("ship_evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateEqualTo(BigDecimal value) {
            addCriterion("ship_evaluate =", value, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateNotEqualTo(BigDecimal value) {
            addCriterion("ship_evaluate <>", value, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateGreaterThan(BigDecimal value) {
            addCriterion("ship_evaluate >", value, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_evaluate >=", value, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateLessThan(BigDecimal value) {
            addCriterion("ship_evaluate <", value, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_evaluate <=", value, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateIn(List<BigDecimal> values) {
            addCriterion("ship_evaluate in", values, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateNotIn(List<BigDecimal> values) {
            addCriterion("ship_evaluate not in", values, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_evaluate between", value1, value2, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_evaluate not between", value1, value2, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearIsNull() {
            addCriterion("ship_evaluate_halfyear is null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearIsNotNull() {
            addCriterion("ship_evaluate_halfyear is not null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearEqualTo(BigDecimal value) {
            addCriterion("ship_evaluate_halfyear =", value, "shipEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearNotEqualTo(BigDecimal value) {
            addCriterion("ship_evaluate_halfyear <>", value, "shipEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearGreaterThan(BigDecimal value) {
            addCriterion("ship_evaluate_halfyear >", value, "shipEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_evaluate_halfyear >=", value, "shipEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearLessThan(BigDecimal value) {
            addCriterion("ship_evaluate_halfyear <", value, "shipEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_evaluate_halfyear <=", value, "shipEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearIn(List<BigDecimal> values) {
            addCriterion("ship_evaluate_halfyear in", values, "shipEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearNotIn(List<BigDecimal> values) {
            addCriterion("ship_evaluate_halfyear not in", values, "shipEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_evaluate_halfyear between", value1, value2, "shipEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_evaluate_halfyear not between", value1, value2, "shipEvaluateHalfyear");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount1IsNull() {
            addCriterion("ship_evaluate_halfyear_count1 is null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount1IsNotNull() {
            addCriterion("ship_evaluate_halfyear_count1 is not null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount1EqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count1 =", value, "shipEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount1NotEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count1 <>", value, "shipEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount1GreaterThan(Integer value) {
            addCriterion("ship_evaluate_halfyear_count1 >", value, "shipEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount1GreaterThanOrEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count1 >=", value, "shipEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount1LessThan(Integer value) {
            addCriterion("ship_evaluate_halfyear_count1 <", value, "shipEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount1LessThanOrEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count1 <=", value, "shipEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount1In(List<Integer> values) {
            addCriterion("ship_evaluate_halfyear_count1 in", values, "shipEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount1NotIn(List<Integer> values) {
            addCriterion("ship_evaluate_halfyear_count1 not in", values, "shipEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount1Between(Integer value1, Integer value2) {
            addCriterion("ship_evaluate_halfyear_count1 between", value1, value2, "shipEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount1NotBetween(Integer value1, Integer value2) {
            addCriterion("ship_evaluate_halfyear_count1 not between", value1, value2, "shipEvaluateHalfyearCount1");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount2IsNull() {
            addCriterion("ship_evaluate_halfyear_count2 is null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount2IsNotNull() {
            addCriterion("ship_evaluate_halfyear_count2 is not null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount2EqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count2 =", value, "shipEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount2NotEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count2 <>", value, "shipEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount2GreaterThan(Integer value) {
            addCriterion("ship_evaluate_halfyear_count2 >", value, "shipEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount2GreaterThanOrEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count2 >=", value, "shipEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount2LessThan(Integer value) {
            addCriterion("ship_evaluate_halfyear_count2 <", value, "shipEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount2LessThanOrEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count2 <=", value, "shipEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount2In(List<Integer> values) {
            addCriterion("ship_evaluate_halfyear_count2 in", values, "shipEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount2NotIn(List<Integer> values) {
            addCriterion("ship_evaluate_halfyear_count2 not in", values, "shipEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount2Between(Integer value1, Integer value2) {
            addCriterion("ship_evaluate_halfyear_count2 between", value1, value2, "shipEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount2NotBetween(Integer value1, Integer value2) {
            addCriterion("ship_evaluate_halfyear_count2 not between", value1, value2, "shipEvaluateHalfyearCount2");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount3IsNull() {
            addCriterion("ship_evaluate_halfyear_count3 is null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount3IsNotNull() {
            addCriterion("ship_evaluate_halfyear_count3 is not null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount3EqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count3 =", value, "shipEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount3NotEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count3 <>", value, "shipEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount3GreaterThan(Integer value) {
            addCriterion("ship_evaluate_halfyear_count3 >", value, "shipEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount3GreaterThanOrEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count3 >=", value, "shipEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount3LessThan(Integer value) {
            addCriterion("ship_evaluate_halfyear_count3 <", value, "shipEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount3LessThanOrEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count3 <=", value, "shipEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount3In(List<Integer> values) {
            addCriterion("ship_evaluate_halfyear_count3 in", values, "shipEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount3NotIn(List<Integer> values) {
            addCriterion("ship_evaluate_halfyear_count3 not in", values, "shipEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount3Between(Integer value1, Integer value2) {
            addCriterion("ship_evaluate_halfyear_count3 between", value1, value2, "shipEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount3NotBetween(Integer value1, Integer value2) {
            addCriterion("ship_evaluate_halfyear_count3 not between", value1, value2, "shipEvaluateHalfyearCount3");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount4IsNull() {
            addCriterion("ship_evaluate_halfyear_count4 is null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount4IsNotNull() {
            addCriterion("ship_evaluate_halfyear_count4 is not null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount4EqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count4 =", value, "shipEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount4NotEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count4 <>", value, "shipEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount4GreaterThan(Integer value) {
            addCriterion("ship_evaluate_halfyear_count4 >", value, "shipEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount4GreaterThanOrEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count4 >=", value, "shipEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount4LessThan(Integer value) {
            addCriterion("ship_evaluate_halfyear_count4 <", value, "shipEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount4LessThanOrEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count4 <=", value, "shipEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount4In(List<Integer> values) {
            addCriterion("ship_evaluate_halfyear_count4 in", values, "shipEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount4NotIn(List<Integer> values) {
            addCriterion("ship_evaluate_halfyear_count4 not in", values, "shipEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount4Between(Integer value1, Integer value2) {
            addCriterion("ship_evaluate_halfyear_count4 between", value1, value2, "shipEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount4NotBetween(Integer value1, Integer value2) {
            addCriterion("ship_evaluate_halfyear_count4 not between", value1, value2, "shipEvaluateHalfyearCount4");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount5IsNull() {
            addCriterion("ship_evaluate_halfyear_count5 is null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount5IsNotNull() {
            addCriterion("ship_evaluate_halfyear_count5 is not null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount5EqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count5 =", value, "shipEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount5NotEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count5 <>", value, "shipEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount5GreaterThan(Integer value) {
            addCriterion("ship_evaluate_halfyear_count5 >", value, "shipEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount5GreaterThanOrEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count5 >=", value, "shipEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount5LessThan(Integer value) {
            addCriterion("ship_evaluate_halfyear_count5 <", value, "shipEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount5LessThanOrEqualTo(Integer value) {
            addCriterion("ship_evaluate_halfyear_count5 <=", value, "shipEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount5In(List<Integer> values) {
            addCriterion("ship_evaluate_halfyear_count5 in", values, "shipEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount5NotIn(List<Integer> values) {
            addCriterion("ship_evaluate_halfyear_count5 not in", values, "shipEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount5Between(Integer value1, Integer value2) {
            addCriterion("ship_evaluate_halfyear_count5 between", value1, value2, "shipEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateHalfyearCount5NotBetween(Integer value1, Integer value2) {
            addCriterion("ship_evaluate_halfyear_count5 not between", value1, value2, "shipEvaluateHalfyearCount5");
            return (Criteria) this;
        }

        public Criteria andStoreEvaluate1IsNull() {
            addCriterion("store_evaluate1 is null");
            return (Criteria) this;
        }

        public Criteria andStoreEvaluate1IsNotNull() {
            addCriterion("store_evaluate1 is not null");
            return (Criteria) this;
        }

        public Criteria andStoreEvaluate1EqualTo(BigDecimal value) {
            addCriterion("store_evaluate1 =", value, "storeEvaluate1");
            return (Criteria) this;
        }

        public Criteria andStoreEvaluate1NotEqualTo(BigDecimal value) {
            addCriterion("store_evaluate1 <>", value, "storeEvaluate1");
            return (Criteria) this;
        }

        public Criteria andStoreEvaluate1GreaterThan(BigDecimal value) {
            addCriterion("store_evaluate1 >", value, "storeEvaluate1");
            return (Criteria) this;
        }

        public Criteria andStoreEvaluate1GreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("store_evaluate1 >=", value, "storeEvaluate1");
            return (Criteria) this;
        }

        public Criteria andStoreEvaluate1LessThan(BigDecimal value) {
            addCriterion("store_evaluate1 <", value, "storeEvaluate1");
            return (Criteria) this;
        }

        public Criteria andStoreEvaluate1LessThanOrEqualTo(BigDecimal value) {
            addCriterion("store_evaluate1 <=", value, "storeEvaluate1");
            return (Criteria) this;
        }

        public Criteria andStoreEvaluate1In(List<BigDecimal> values) {
            addCriterion("store_evaluate1 in", values, "storeEvaluate1");
            return (Criteria) this;
        }

        public Criteria andStoreEvaluate1NotIn(List<BigDecimal> values) {
            addCriterion("store_evaluate1 not in", values, "storeEvaluate1");
            return (Criteria) this;
        }

        public Criteria andStoreEvaluate1Between(BigDecimal value1, BigDecimal value2) {
            addCriterion("store_evaluate1 between", value1, value2, "storeEvaluate1");
            return (Criteria) this;
        }

        public Criteria andStoreEvaluate1NotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("store_evaluate1 not between", value1, value2, "storeEvaluate1");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Long value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Long value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Long value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Long value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Long value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Long> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Long> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Long value1, Long value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Long value1, Long value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStattimeIsNull() {
            addCriterion("statTime is null");
            return (Criteria) this;
        }

        public Criteria andStattimeIsNotNull() {
            addCriterion("statTime is not null");
            return (Criteria) this;
        }

        public Criteria andStattimeEqualTo(Date value) {
            addCriterion("statTime =", value, "stattime");
            return (Criteria) this;
        }

        public Criteria andStattimeNotEqualTo(Date value) {
            addCriterion("statTime <>", value, "stattime");
            return (Criteria) this;
        }

        public Criteria andStattimeGreaterThan(Date value) {
            addCriterion("statTime >", value, "stattime");
            return (Criteria) this;
        }

        public Criteria andStattimeGreaterThanOrEqualTo(Date value) {
            addCriterion("statTime >=", value, "stattime");
            return (Criteria) this;
        }

        public Criteria andStattimeLessThan(Date value) {
            addCriterion("statTime <", value, "stattime");
            return (Criteria) this;
        }

        public Criteria andStattimeLessThanOrEqualTo(Date value) {
            addCriterion("statTime <=", value, "stattime");
            return (Criteria) this;
        }

        public Criteria andStattimeIn(List<Date> values) {
            addCriterion("statTime in", values, "stattime");
            return (Criteria) this;
        }

        public Criteria andStattimeNotIn(List<Date> values) {
            addCriterion("statTime not in", values, "stattime");
            return (Criteria) this;
        }

        public Criteria andStattimeBetween(Date value1, Date value2) {
            addCriterion("statTime between", value1, value2, "stattime");
            return (Criteria) this;
        }

        public Criteria andStattimeNotBetween(Date value1, Date value2) {
            addCriterion("statTime not between", value1, value2, "stattime");
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