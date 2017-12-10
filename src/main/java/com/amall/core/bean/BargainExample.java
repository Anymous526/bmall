package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class BargainExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BargainExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andBargainTimeIsNull() {
            addCriterion("bargain_time is null");
            return (Criteria) this;
        }

        public Criteria andBargainTimeIsNotNull() {
            addCriterion("bargain_time is not null");
            return (Criteria) this;
        }

        public Criteria andBargainTimeEqualTo(Date value) {
            addCriterionForJDBCDate("bargain_time =", value, "bargainTime");
            return (Criteria) this;
        }

        public Criteria andBargainTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("bargain_time <>", value, "bargainTime");
            return (Criteria) this;
        }

        public Criteria andBargainTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("bargain_time >", value, "bargainTime");
            return (Criteria) this;
        }

        public Criteria andBargainTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bargain_time >=", value, "bargainTime");
            return (Criteria) this;
        }

        public Criteria andBargainTimeLessThan(Date value) {
            addCriterionForJDBCDate("bargain_time <", value, "bargainTime");
            return (Criteria) this;
        }

        public Criteria andBargainTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bargain_time <=", value, "bargainTime");
            return (Criteria) this;
        }

        public Criteria andBargainTimeIn(List<Date> values) {
            addCriterionForJDBCDate("bargain_time in", values, "bargainTime");
            return (Criteria) this;
        }

        public Criteria andBargainTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("bargain_time not in", values, "bargainTime");
            return (Criteria) this;
        }

        public Criteria andBargainTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bargain_time between", value1, value2, "bargainTime");
            return (Criteria) this;
        }

        public Criteria andBargainTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bargain_time not between", value1, value2, "bargainTime");
            return (Criteria) this;
        }

        public Criteria andBargainTitleIsNull() {
            addCriterion("bargain_title is null");
            return (Criteria) this;
        }

        public Criteria andBargainTitleIsNotNull() {
            addCriterion("bargain_title is not null");
            return (Criteria) this;
        }

        public Criteria andBargainTitleEqualTo(String value) {
            addCriterion("bargain_title =", value, "bargaintitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleNotEqualTo(String value) {
            addCriterion("bargain_title <>", value, "bargaintitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleGreaterThan(String value) {
            addCriterion("bargain_title >", value, "bargaintitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleGreaterThanOrEqualTo(String value) {
            addCriterion("bargain_title >=", value, "bargaintitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleLessThan(String value) {
            addCriterion("bargain_title <", value, "bargaintitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleLessThanOrEqualTo(String value) {
            addCriterion("bargain_title <=", value, "bargaintitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleIn(List<String> values) {
            addCriterion("bargain_title in", values, "bargaintitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleNotIn(List<String> values) {
            addCriterion("bargain_title not in", values, "bargaintitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleBetween(String value1, String value2) {
            addCriterion("bargain_title between", value1, value2, "bargaintitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleNotBetween(String value1, String value2) {
            addCriterion("bargain_title not between", value1, value2, "bargaintitle");
            return (Criteria) this;
        }
        
        public Criteria andBargainStatusIsNull() {
            addCriterion("bargain_status is null");
            return (Criteria) this;
        }

        public Criteria andBargainStatusIsNotNull() {
            addCriterion("bargain_status is not null");
            return (Criteria) this;
        }

        public Criteria andBargainStatusEqualTo(String value) {
            addCriterion("bargain_status =", value, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusNotEqualTo(String value) {
            addCriterion("bargain_status <>", value, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusGreaterThan(String value) {
            addCriterion("bargain_status >", value, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusGreaterThanOrEqualTo(String value) {
            addCriterion("bargain_status >=", value, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusLessThan(String value) {
            addCriterion("bargain_status <", value, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusLessThanOrEqualTo(String value) {
            addCriterion("bargain_status <=", value, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusIn(List<String> values) {
            addCriterion("bargain_status in", values, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusNotIn(List<String> values) {
            addCriterion("bargain_status not in", values, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusBetween(String value1, String value2) {
            addCriterion("bargain_status between", value1, value2, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusNotBetween(String value1, String value2) {
            addCriterion("bargain_status not between", value1, value2, "bargainStatus");
            return (Criteria) this;
        }
        
        public Criteria andCloseTimeIsNull() {
            addCriterion("close_time is null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIsNotNull() {
            addCriterion("close_time is not null");
            return (Criteria) this;
        }

        public Criteria andCloseTimeEqualTo(Date value) {
            addCriterion("close_time =", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotEqualTo(Date value) {
            addCriterion("close_time <>", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThan(Date value) {
            addCriterion("close_time >", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("close_time >=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThan(Date value) {
            addCriterion("close_time <", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeLessThanOrEqualTo(Date value) {
            addCriterion("close_time <=", value, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeIn(List<Date> values) {
            addCriterion("close_time in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotIn(List<Date> values) {
            addCriterion("close_time not in", values, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeBetween(Date value1, Date value2) {
            addCriterion("close_time between", value1, value2, "closeTime");
            return (Criteria) this;
        }

        public Criteria andCloseTimeNotBetween(Date value1, Date value2) {
            addCriterion("close_time not between", value1, value2, "closeTime");
            return (Criteria) this;
        }
        
        public Criteria andMaximumIsNull() {
            addCriterion("maximum is null");
            return (Criteria) this;
        }

        public Criteria andMaximumIsNotNull() {
            addCriterion("maximum is not null");
            return (Criteria) this;
        }

        public Criteria andMaximumEqualTo(Integer value) {
            addCriterion("maximum =", value, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumNotEqualTo(Integer value) {
            addCriterion("maximum <>", value, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumGreaterThan(Integer value) {
            addCriterion("maximum >", value, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumGreaterThanOrEqualTo(Integer value) {
            addCriterion("maximum >=", value, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumLessThan(Integer value) {
            addCriterion("maximum <", value, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumLessThanOrEqualTo(Integer value) {
            addCriterion("maximum <=", value, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumIn(List<Integer> values) {
            addCriterion("maximum in", values, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumNotIn(List<Integer> values) {
            addCriterion("maximum not in", values, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumBetween(Integer value1, Integer value2) {
            addCriterion("maximum between", value1, value2, "maximum");
            return (Criteria) this;
        }

        public Criteria andMaximumNotBetween(Integer value1, Integer value2) {
            addCriterion("maximum not between", value1, value2, "maximum");
            return (Criteria) this;
        }

        public Criteria andRebateIsNull() {
            addCriterion("rebate is null");
            return (Criteria) this;
        }

        public Criteria andRebateIsNotNull() {
            addCriterion("rebate is not null");
            return (Criteria) this;
        }

        public Criteria andRebateEqualTo(BigDecimal value) {
            addCriterion("rebate =", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateNotEqualTo(BigDecimal value) {
            addCriterion("rebate <>", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateGreaterThan(BigDecimal value) {
            addCriterion("rebate >", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rebate >=", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateLessThan(BigDecimal value) {
            addCriterion("rebate <", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rebate <=", value, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateIn(List<BigDecimal> values) {
            addCriterion("rebate in", values, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateNotIn(List<BigDecimal> values) {
            addCriterion("rebate not in", values, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rebate between", value1, value2, "rebate");
            return (Criteria) this;
        }

        public Criteria andRebateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rebate not between", value1, value2, "rebate");
            return (Criteria) this;
        }
        
        public Criteria andBargainEndTimeIsNull() {
            addCriterion("bargain_endtime is null");
            return (Criteria) this;
        }

        public Criteria andBargainEndTimeIsNotNull() {
            addCriterion("bargain_endtime is not null");
            return (Criteria) this;
        }

        public Criteria andBargainEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("bargain_endtime =", value, "bargainEndTime");
            return (Criteria) this;
        }

        public Criteria andBargainEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("bargain_endtime <>", value, "bargainEndTime");
            return (Criteria) this;
        }

        public Criteria andBargainEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("bargain_endtime >", value, "bargainEndTime");
            return (Criteria) this;
        }

        public Criteria andBargainEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bargain_endtime >=", value, "bargainEndTime");
            return (Criteria) this;
        }

        public Criteria andBargainEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("bargain_endtime <", value, "bargainEndTime");
            return (Criteria) this;
        }

        public Criteria andBargainEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("bargain_endtime <=", value, "bargainEndTime");
            return (Criteria) this;
        }

        public Criteria andBargainEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("bargain_endtime in", values, "bargainEndTime");
            return (Criteria) this;
        }

        public Criteria andBargainEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("bargain_endtime not in", values, "bargainEndTime");
            return (Criteria) this;
        }

        public Criteria andBargainEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bargain_endtime between", value1, value2, "bargainEndTime");
            return (Criteria) this;
        }

        public Criteria andBargainEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("bargain_endtime not between", value1, value2, "bargainEndTime");
            return (Criteria) this;
        }
        
        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(Integer value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(Integer value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(Integer value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(Integer value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(Integer value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(Integer value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<Integer> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<Integer> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(Integer value1, Integer value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(Integer value1, Integer value2) {
            addCriterion("mark not between", value1, value2, "mark");
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