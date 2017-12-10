package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class StoreGradeLogExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreGradeLogExample() {
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

        public Criteria andLogEditIsNull() {
            addCriterion("log_edit is null");
            return (Criteria) this;
        }

        public Criteria andLogEditIsNotNull() {
            addCriterion("log_edit is not null");
            return (Criteria) this;
        }

        public Criteria andLogEditEqualTo(Boolean value) {
            addCriterion("log_edit =", value, "logEdit");
            return (Criteria) this;
        }

        public Criteria andLogEditNotEqualTo(Boolean value) {
            addCriterion("log_edit <>", value, "logEdit");
            return (Criteria) this;
        }

        public Criteria andLogEditGreaterThan(Boolean value) {
            addCriterion("log_edit >", value, "logEdit");
            return (Criteria) this;
        }

        public Criteria andLogEditGreaterThanOrEqualTo(Boolean value) {
            addCriterion("log_edit >=", value, "logEdit");
            return (Criteria) this;
        }

        public Criteria andLogEditLessThan(Boolean value) {
            addCriterion("log_edit <", value, "logEdit");
            return (Criteria) this;
        }

        public Criteria andLogEditLessThanOrEqualTo(Boolean value) {
            addCriterion("log_edit <=", value, "logEdit");
            return (Criteria) this;
        }

        public Criteria andLogEditIn(List<Boolean> values) {
            addCriterion("log_edit in", values, "logEdit");
            return (Criteria) this;
        }

        public Criteria andLogEditNotIn(List<Boolean> values) {
            addCriterion("log_edit not in", values, "logEdit");
            return (Criteria) this;
        }

        public Criteria andLogEditBetween(Boolean value1, Boolean value2) {
            addCriterion("log_edit between", value1, value2, "logEdit");
            return (Criteria) this;
        }

        public Criteria andLogEditNotBetween(Boolean value1, Boolean value2) {
            addCriterion("log_edit not between", value1, value2, "logEdit");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoIsNull() {
            addCriterion("store_grade_info is null");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoIsNotNull() {
            addCriterion("store_grade_info is not null");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoEqualTo(String value) {
            addCriterion("store_grade_info =", value, "storeGradeInfo");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoNotEqualTo(String value) {
            addCriterion("store_grade_info <>", value, "storeGradeInfo");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoGreaterThan(String value) {
            addCriterion("store_grade_info >", value, "storeGradeInfo");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoGreaterThanOrEqualTo(String value) {
            addCriterion("store_grade_info >=", value, "storeGradeInfo");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoLessThan(String value) {
            addCriterion("store_grade_info <", value, "storeGradeInfo");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoLessThanOrEqualTo(String value) {
            addCriterion("store_grade_info <=", value, "storeGradeInfo");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoLike(String value) {
            addCriterion("store_grade_info like", value, "storeGradeInfo");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoNotLike(String value) {
            addCriterion("store_grade_info not like", value, "storeGradeInfo");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoIn(List<String> values) {
            addCriterion("store_grade_info in", values, "storeGradeInfo");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoNotIn(List<String> values) {
            addCriterion("store_grade_info not in", values, "storeGradeInfo");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoBetween(String value1, String value2) {
            addCriterion("store_grade_info between", value1, value2, "storeGradeInfo");
            return (Criteria) this;
        }

        public Criteria andStoreGradeInfoNotBetween(String value1, String value2) {
            addCriterion("store_grade_info not between", value1, value2, "storeGradeInfo");
            return (Criteria) this;
        }

        public Criteria andStoreGradeStatusIsNull() {
            addCriterion("store_grade_status is null");
            return (Criteria) this;
        }

        public Criteria andStoreGradeStatusIsNotNull() {
            addCriterion("store_grade_status is not null");
            return (Criteria) this;
        }

        public Criteria andStoreGradeStatusEqualTo(Integer value) {
            addCriterion("store_grade_status =", value, "storeGradeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreGradeStatusNotEqualTo(Integer value) {
            addCriterion("store_grade_status <>", value, "storeGradeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreGradeStatusGreaterThan(Integer value) {
            addCriterion("store_grade_status >", value, "storeGradeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreGradeStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_grade_status >=", value, "storeGradeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreGradeStatusLessThan(Integer value) {
            addCriterion("store_grade_status <", value, "storeGradeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreGradeStatusLessThanOrEqualTo(Integer value) {
            addCriterion("store_grade_status <=", value, "storeGradeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreGradeStatusIn(List<Integer> values) {
            addCriterion("store_grade_status in", values, "storeGradeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreGradeStatusNotIn(List<Integer> values) {
            addCriterion("store_grade_status not in", values, "storeGradeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreGradeStatusBetween(Integer value1, Integer value2) {
            addCriterion("store_grade_status between", value1, value2, "storeGradeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreGradeStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("store_grade_status not between", value1, value2, "storeGradeStatus");
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