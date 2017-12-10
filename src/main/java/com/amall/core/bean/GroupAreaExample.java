package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class GroupAreaExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupAreaExample() {
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

        public Criteria andGaLevelIsNull() {
            addCriterion("ga_level is null");
            return (Criteria) this;
        }

        public Criteria andGaLevelIsNotNull() {
            addCriterion("ga_level is not null");
            return (Criteria) this;
        }

        public Criteria andGaLevelEqualTo(Integer value) {
            addCriterion("ga_level =", value, "gaLevel");
            return (Criteria) this;
        }

        public Criteria andGaLevelNotEqualTo(Integer value) {
            addCriterion("ga_level <>", value, "gaLevel");
            return (Criteria) this;
        }

        public Criteria andGaLevelGreaterThan(Integer value) {
            addCriterion("ga_level >", value, "gaLevel");
            return (Criteria) this;
        }

        public Criteria andGaLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("ga_level >=", value, "gaLevel");
            return (Criteria) this;
        }

        public Criteria andGaLevelLessThan(Integer value) {
            addCriterion("ga_level <", value, "gaLevel");
            return (Criteria) this;
        }

        public Criteria andGaLevelLessThanOrEqualTo(Integer value) {
            addCriterion("ga_level <=", value, "gaLevel");
            return (Criteria) this;
        }

        public Criteria andGaLevelIn(List<Integer> values) {
            addCriterion("ga_level in", values, "gaLevel");
            return (Criteria) this;
        }

        public Criteria andGaLevelNotIn(List<Integer> values) {
            addCriterion("ga_level not in", values, "gaLevel");
            return (Criteria) this;
        }

        public Criteria andGaLevelBetween(Integer value1, Integer value2) {
            addCriterion("ga_level between", value1, value2, "gaLevel");
            return (Criteria) this;
        }

        public Criteria andGaLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("ga_level not between", value1, value2, "gaLevel");
            return (Criteria) this;
        }

        public Criteria andGaNameIsNull() {
            addCriterion("ga_name is null");
            return (Criteria) this;
        }

        public Criteria andGaNameIsNotNull() {
            addCriterion("ga_name is not null");
            return (Criteria) this;
        }

        public Criteria andGaNameEqualTo(String value) {
            addCriterion("ga_name =", value, "gaName");
            return (Criteria) this;
        }

        public Criteria andGaNameNotEqualTo(String value) {
            addCriterion("ga_name <>", value, "gaName");
            return (Criteria) this;
        }

        public Criteria andGaNameGreaterThan(String value) {
            addCriterion("ga_name >", value, "gaName");
            return (Criteria) this;
        }

        public Criteria andGaNameGreaterThanOrEqualTo(String value) {
            addCriterion("ga_name >=", value, "gaName");
            return (Criteria) this;
        }

        public Criteria andGaNameLessThan(String value) {
            addCriterion("ga_name <", value, "gaName");
            return (Criteria) this;
        }

        public Criteria andGaNameLessThanOrEqualTo(String value) {
            addCriterion("ga_name <=", value, "gaName");
            return (Criteria) this;
        }

        public Criteria andGaNameLike(String value) {
            addCriterion("ga_name like", value, "gaName");
            return (Criteria) this;
        }

        public Criteria andGaNameNotLike(String value) {
            addCriterion("ga_name not like", value, "gaName");
            return (Criteria) this;
        }

        public Criteria andGaNameIn(List<String> values) {
            addCriterion("ga_name in", values, "gaName");
            return (Criteria) this;
        }

        public Criteria andGaNameNotIn(List<String> values) {
            addCriterion("ga_name not in", values, "gaName");
            return (Criteria) this;
        }

        public Criteria andGaNameBetween(String value1, String value2) {
            addCriterion("ga_name between", value1, value2, "gaName");
            return (Criteria) this;
        }

        public Criteria andGaNameNotBetween(String value1, String value2) {
            addCriterion("ga_name not between", value1, value2, "gaName");
            return (Criteria) this;
        }

        public Criteria andGaSequenceIsNull() {
            addCriterion("ga_sequence is null");
            return (Criteria) this;
        }

        public Criteria andGaSequenceIsNotNull() {
            addCriterion("ga_sequence is not null");
            return (Criteria) this;
        }

        public Criteria andGaSequenceEqualTo(Integer value) {
            addCriterion("ga_sequence =", value, "gaSequence");
            return (Criteria) this;
        }

        public Criteria andGaSequenceNotEqualTo(Integer value) {
            addCriterion("ga_sequence <>", value, "gaSequence");
            return (Criteria) this;
        }

        public Criteria andGaSequenceGreaterThan(Integer value) {
            addCriterion("ga_sequence >", value, "gaSequence");
            return (Criteria) this;
        }

        public Criteria andGaSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("ga_sequence >=", value, "gaSequence");
            return (Criteria) this;
        }

        public Criteria andGaSequenceLessThan(Integer value) {
            addCriterion("ga_sequence <", value, "gaSequence");
            return (Criteria) this;
        }

        public Criteria andGaSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("ga_sequence <=", value, "gaSequence");
            return (Criteria) this;
        }

        public Criteria andGaSequenceIn(List<Integer> values) {
            addCriterion("ga_sequence in", values, "gaSequence");
            return (Criteria) this;
        }

        public Criteria andGaSequenceNotIn(List<Integer> values) {
            addCriterion("ga_sequence not in", values, "gaSequence");
            return (Criteria) this;
        }

        public Criteria andGaSequenceBetween(Integer value1, Integer value2) {
            addCriterion("ga_sequence between", value1, value2, "gaSequence");
            return (Criteria) this;
        }

        public Criteria andGaSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("ga_sequence not between", value1, value2, "gaSequence");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
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