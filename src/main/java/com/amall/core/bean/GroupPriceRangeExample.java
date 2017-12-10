package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class GroupPriceRangeExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupPriceRangeExample() {
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

        public Criteria andGprBeginIsNull() {
            addCriterion("gpr_begin is null");
            return (Criteria) this;
        }

        public Criteria andGprBeginIsNotNull() {
            addCriterion("gpr_begin is not null");
            return (Criteria) this;
        }

        public Criteria andGprBeginEqualTo(Integer value) {
            addCriterion("gpr_begin =", value, "gprBegin");
            return (Criteria) this;
        }

        public Criteria andGprBeginNotEqualTo(Integer value) {
            addCriterion("gpr_begin <>", value, "gprBegin");
            return (Criteria) this;
        }

        public Criteria andGprBeginGreaterThan(Integer value) {
            addCriterion("gpr_begin >", value, "gprBegin");
            return (Criteria) this;
        }

        public Criteria andGprBeginGreaterThanOrEqualTo(Integer value) {
            addCriterion("gpr_begin >=", value, "gprBegin");
            return (Criteria) this;
        }

        public Criteria andGprBeginLessThan(Integer value) {
            addCriterion("gpr_begin <", value, "gprBegin");
            return (Criteria) this;
        }

        public Criteria andGprBeginLessThanOrEqualTo(Integer value) {
            addCriterion("gpr_begin <=", value, "gprBegin");
            return (Criteria) this;
        }

        public Criteria andGprBeginIn(List<Integer> values) {
            addCriterion("gpr_begin in", values, "gprBegin");
            return (Criteria) this;
        }

        public Criteria andGprBeginNotIn(List<Integer> values) {
            addCriterion("gpr_begin not in", values, "gprBegin");
            return (Criteria) this;
        }

        public Criteria andGprBeginBetween(Integer value1, Integer value2) {
            addCriterion("gpr_begin between", value1, value2, "gprBegin");
            return (Criteria) this;
        }

        public Criteria andGprBeginNotBetween(Integer value1, Integer value2) {
            addCriterion("gpr_begin not between", value1, value2, "gprBegin");
            return (Criteria) this;
        }

        public Criteria andGprEndIsNull() {
            addCriterion("gpr_end is null");
            return (Criteria) this;
        }

        public Criteria andGprEndIsNotNull() {
            addCriterion("gpr_end is not null");
            return (Criteria) this;
        }

        public Criteria andGprEndEqualTo(Integer value) {
            addCriterion("gpr_end =", value, "gprEnd");
            return (Criteria) this;
        }

        public Criteria andGprEndNotEqualTo(Integer value) {
            addCriterion("gpr_end <>", value, "gprEnd");
            return (Criteria) this;
        }

        public Criteria andGprEndGreaterThan(Integer value) {
            addCriterion("gpr_end >", value, "gprEnd");
            return (Criteria) this;
        }

        public Criteria andGprEndGreaterThanOrEqualTo(Integer value) {
            addCriterion("gpr_end >=", value, "gprEnd");
            return (Criteria) this;
        }

        public Criteria andGprEndLessThan(Integer value) {
            addCriterion("gpr_end <", value, "gprEnd");
            return (Criteria) this;
        }

        public Criteria andGprEndLessThanOrEqualTo(Integer value) {
            addCriterion("gpr_end <=", value, "gprEnd");
            return (Criteria) this;
        }

        public Criteria andGprEndIn(List<Integer> values) {
            addCriterion("gpr_end in", values, "gprEnd");
            return (Criteria) this;
        }

        public Criteria andGprEndNotIn(List<Integer> values) {
            addCriterion("gpr_end not in", values, "gprEnd");
            return (Criteria) this;
        }

        public Criteria andGprEndBetween(Integer value1, Integer value2) {
            addCriterion("gpr_end between", value1, value2, "gprEnd");
            return (Criteria) this;
        }

        public Criteria andGprEndNotBetween(Integer value1, Integer value2) {
            addCriterion("gpr_end not between", value1, value2, "gprEnd");
            return (Criteria) this;
        }

        public Criteria andGprNameIsNull() {
            addCriterion("gpr_name is null");
            return (Criteria) this;
        }

        public Criteria andGprNameIsNotNull() {
            addCriterion("gpr_name is not null");
            return (Criteria) this;
        }

        public Criteria andGprNameEqualTo(String value) {
            addCriterion("gpr_name =", value, "gprName");
            return (Criteria) this;
        }

        public Criteria andGprNameNotEqualTo(String value) {
            addCriterion("gpr_name <>", value, "gprName");
            return (Criteria) this;
        }

        public Criteria andGprNameGreaterThan(String value) {
            addCriterion("gpr_name >", value, "gprName");
            return (Criteria) this;
        }

        public Criteria andGprNameGreaterThanOrEqualTo(String value) {
            addCriterion("gpr_name >=", value, "gprName");
            return (Criteria) this;
        }

        public Criteria andGprNameLessThan(String value) {
            addCriterion("gpr_name <", value, "gprName");
            return (Criteria) this;
        }

        public Criteria andGprNameLessThanOrEqualTo(String value) {
            addCriterion("gpr_name <=", value, "gprName");
            return (Criteria) this;
        }

        public Criteria andGprNameLike(String value) {
            addCriterion("gpr_name like", value, "gprName");
            return (Criteria) this;
        }

        public Criteria andGprNameNotLike(String value) {
            addCriterion("gpr_name not like", value, "gprName");
            return (Criteria) this;
        }

        public Criteria andGprNameIn(List<String> values) {
            addCriterion("gpr_name in", values, "gprName");
            return (Criteria) this;
        }

        public Criteria andGprNameNotIn(List<String> values) {
            addCriterion("gpr_name not in", values, "gprName");
            return (Criteria) this;
        }

        public Criteria andGprNameBetween(String value1, String value2) {
            addCriterion("gpr_name between", value1, value2, "gprName");
            return (Criteria) this;
        }

        public Criteria andGprNameNotBetween(String value1, String value2) {
            addCriterion("gpr_name not between", value1, value2, "gprName");
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