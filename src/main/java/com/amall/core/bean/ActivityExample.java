package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class ActivityExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityExample() {
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

        public Criteria andAcBeginTimeIsNull() {
            addCriterion("ac_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andAcBeginTimeIsNotNull() {
            addCriterion("ac_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andAcBeginTimeEqualTo(Date value) {
            addCriterionForJDBCDate("ac_begin_time =", value, "acBeginTime");
            return (Criteria) this;
        }

        public Criteria andAcBeginTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ac_begin_time <>", value, "acBeginTime");
            return (Criteria) this;
        }

        public Criteria andAcBeginTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ac_begin_time >", value, "acBeginTime");
            return (Criteria) this;
        }

        public Criteria andAcBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ac_begin_time >=", value, "acBeginTime");
            return (Criteria) this;
        }

        public Criteria andAcBeginTimeLessThan(Date value) {
            addCriterionForJDBCDate("ac_begin_time <", value, "acBeginTime");
            return (Criteria) this;
        }

        public Criteria andAcBeginTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ac_begin_time <=", value, "acBeginTime");
            return (Criteria) this;
        }

        public Criteria andAcBeginTimeIn(List<Date> values) {
            addCriterionForJDBCDate("ac_begin_time in", values, "acBeginTime");
            return (Criteria) this;
        }

        public Criteria andAcBeginTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ac_begin_time not in", values, "acBeginTime");
            return (Criteria) this;
        }

        public Criteria andAcBeginTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ac_begin_time between", value1, value2, "acBeginTime");
            return (Criteria) this;
        }

        public Criteria andAcBeginTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ac_begin_time not between", value1, value2, "acBeginTime");
            return (Criteria) this;
        }

        public Criteria andAcEndTimeIsNull() {
            addCriterion("ac_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAcEndTimeIsNotNull() {
            addCriterion("ac_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAcEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("ac_end_time =", value, "acEndTime");
            return (Criteria) this;
        }

        public Criteria andAcEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("ac_end_time <>", value, "acEndTime");
            return (Criteria) this;
        }

        public Criteria andAcEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("ac_end_time >", value, "acEndTime");
            return (Criteria) this;
        }

        public Criteria andAcEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ac_end_time >=", value, "acEndTime");
            return (Criteria) this;
        }

        public Criteria andAcEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("ac_end_time <", value, "acEndTime");
            return (Criteria) this;
        }

        public Criteria andAcEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("ac_end_time <=", value, "acEndTime");
            return (Criteria) this;
        }

        public Criteria andAcEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("ac_end_time in", values, "acEndTime");
            return (Criteria) this;
        }

        public Criteria andAcEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("ac_end_time not in", values, "acEndTime");
            return (Criteria) this;
        }

        public Criteria andAcEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ac_end_time between", value1, value2, "acEndTime");
            return (Criteria) this;
        }

        public Criteria andAcEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("ac_end_time not between", value1, value2, "acEndTime");
            return (Criteria) this;
        }

        public Criteria andAcSequenceIsNull() {
            addCriterion("ac_sequence is null");
            return (Criteria) this;
        }

        public Criteria andAcSequenceIsNotNull() {
            addCriterion("ac_sequence is not null");
            return (Criteria) this;
        }

        public Criteria andAcSequenceEqualTo(Integer value) {
            addCriterion("ac_sequence =", value, "acSequence");
            return (Criteria) this;
        }

        public Criteria andAcSequenceNotEqualTo(Integer value) {
            addCriterion("ac_sequence <>", value, "acSequence");
            return (Criteria) this;
        }

        public Criteria andAcSequenceGreaterThan(Integer value) {
            addCriterion("ac_sequence >", value, "acSequence");
            return (Criteria) this;
        }

        public Criteria andAcSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("ac_sequence >=", value, "acSequence");
            return (Criteria) this;
        }

        public Criteria andAcSequenceLessThan(Integer value) {
            addCriterion("ac_sequence <", value, "acSequence");
            return (Criteria) this;
        }

        public Criteria andAcSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("ac_sequence <=", value, "acSequence");
            return (Criteria) this;
        }

        public Criteria andAcSequenceIn(List<Integer> values) {
            addCriterion("ac_sequence in", values, "acSequence");
            return (Criteria) this;
        }

        public Criteria andAcSequenceNotIn(List<Integer> values) {
            addCriterion("ac_sequence not in", values, "acSequence");
            return (Criteria) this;
        }

        public Criteria andAcSequenceBetween(Integer value1, Integer value2) {
            addCriterion("ac_sequence between", value1, value2, "acSequence");
            return (Criteria) this;
        }

        public Criteria andAcSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("ac_sequence not between", value1, value2, "acSequence");
            return (Criteria) this;
        }

        public Criteria andAcStatusIsNull() {
            addCriterion("ac_status is null");
            return (Criteria) this;
        }

        public Criteria andAcStatusIsNotNull() {
            addCriterion("ac_status is not null");
            return (Criteria) this;
        }

        public Criteria andAcStatusEqualTo(Integer value) {
            addCriterion("ac_status =", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusNotEqualTo(Integer value) {
            addCriterion("ac_status <>", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusGreaterThan(Integer value) {
            addCriterion("ac_status >", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ac_status >=", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusLessThan(Integer value) {
            addCriterion("ac_status <", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ac_status <=", value, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusIn(List<Integer> values) {
            addCriterion("ac_status in", values, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusNotIn(List<Integer> values) {
            addCriterion("ac_status not in", values, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusBetween(Integer value1, Integer value2) {
            addCriterion("ac_status between", value1, value2, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ac_status not between", value1, value2, "acStatus");
            return (Criteria) this;
        }

        public Criteria andAcTitleIsNull() {
            addCriterion("ac_title is null");
            return (Criteria) this;
        }

        public Criteria andAcTitleIsNotNull() {
            addCriterion("ac_title is not null");
            return (Criteria) this;
        }

        public Criteria andAcTitleEqualTo(String value) {
            addCriterion("ac_title =", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleNotEqualTo(String value) {
            addCriterion("ac_title <>", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleGreaterThan(String value) {
            addCriterion("ac_title >", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ac_title >=", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleLessThan(String value) {
            addCriterion("ac_title <", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleLessThanOrEqualTo(String value) {
            addCriterion("ac_title <=", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleLike(String value) {
            addCriterion("ac_title like", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleNotLike(String value) {
            addCriterion("ac_title not like", value, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleIn(List<String> values) {
            addCriterion("ac_title in", values, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleNotIn(List<String> values) {
            addCriterion("ac_title not in", values, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleBetween(String value1, String value2) {
            addCriterion("ac_title between", value1, value2, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcTitleNotBetween(String value1, String value2) {
            addCriterion("ac_title not between", value1, value2, "acTitle");
            return (Criteria) this;
        }

        public Criteria andAcAccIdIsNull() {
            addCriterion("ac_acc_id is null");
            return (Criteria) this;
        }

        public Criteria andAcAccIdIsNotNull() {
            addCriterion("ac_acc_id is not null");
            return (Criteria) this;
        }

        public Criteria andAcAccIdEqualTo(Long value) {
            addCriterion("ac_acc_id =", value, "acAccId");
            return (Criteria) this;
        }

        public Criteria andAcAccIdNotEqualTo(Long value) {
            addCriterion("ac_acc_id <>", value, "acAccId");
            return (Criteria) this;
        }

        public Criteria andAcAccIdGreaterThan(Long value) {
            addCriterion("ac_acc_id >", value, "acAccId");
            return (Criteria) this;
        }

        public Criteria andAcAccIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ac_acc_id >=", value, "acAccId");
            return (Criteria) this;
        }

        public Criteria andAcAccIdLessThan(Long value) {
            addCriterion("ac_acc_id <", value, "acAccId");
            return (Criteria) this;
        }

        public Criteria andAcAccIdLessThanOrEqualTo(Long value) {
            addCriterion("ac_acc_id <=", value, "acAccId");
            return (Criteria) this;
        }

        public Criteria andAcAccIdIn(List<Long> values) {
            addCriterion("ac_acc_id in", values, "acAccId");
            return (Criteria) this;
        }

        public Criteria andAcAccIdNotIn(List<Long> values) {
            addCriterion("ac_acc_id not in", values, "acAccId");
            return (Criteria) this;
        }

        public Criteria andAcAccIdBetween(Long value1, Long value2) {
            addCriterion("ac_acc_id between", value1, value2, "acAccId");
            return (Criteria) this;
        }

        public Criteria andAcAccIdNotBetween(Long value1, Long value2) {
            addCriterion("ac_acc_id not between", value1, value2, "acAccId");
            return (Criteria) this;
        }

        public Criteria andAcRebateIsNull() {
            addCriterion("ac_rebate is null");
            return (Criteria) this;
        }

        public Criteria andAcRebateIsNotNull() {
            addCriterion("ac_rebate is not null");
            return (Criteria) this;
        }

        public Criteria andAcRebateEqualTo(BigDecimal value) {
            addCriterion("ac_rebate =", value, "acRebate");
            return (Criteria) this;
        }

        public Criteria andAcRebateNotEqualTo(BigDecimal value) {
            addCriterion("ac_rebate <>", value, "acRebate");
            return (Criteria) this;
        }

        public Criteria andAcRebateGreaterThan(BigDecimal value) {
            addCriterion("ac_rebate >", value, "acRebate");
            return (Criteria) this;
        }

        public Criteria andAcRebateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ac_rebate >=", value, "acRebate");
            return (Criteria) this;
        }

        public Criteria andAcRebateLessThan(BigDecimal value) {
            addCriterion("ac_rebate <", value, "acRebate");
            return (Criteria) this;
        }

        public Criteria andAcRebateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ac_rebate <=", value, "acRebate");
            return (Criteria) this;
        }

        public Criteria andAcRebateIn(List<BigDecimal> values) {
            addCriterion("ac_rebate in", values, "acRebate");
            return (Criteria) this;
        }

        public Criteria andAcRebateNotIn(List<BigDecimal> values) {
            addCriterion("ac_rebate not in", values, "acRebate");
            return (Criteria) this;
        }

        public Criteria andAcRebateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ac_rebate between", value1, value2, "acRebate");
            return (Criteria) this;
        }

        public Criteria andAcRebateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ac_rebate not between", value1, value2, "acRebate");
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