package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreCountExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreCountExample() {
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

        public Criteria andLastWeekSaleIsNull() {
            addCriterion("last_week_sale is null");
            return (Criteria) this;
        }

        public Criteria andLastWeekSaleIsNotNull() {
            addCriterion("last_week_sale is not null");
            return (Criteria) this;
        }

        public Criteria andLastWeekSaleEqualTo(Integer value) {
            addCriterion("last_week_sale =", value, "lastWeekSale");
            return (Criteria) this;
        }

        public Criteria andLastWeekSaleNotEqualTo(Integer value) {
            addCriterion("last_week_sale <>", value, "lastWeekSale");
            return (Criteria) this;
        }

        public Criteria andLastWeekSaleGreaterThan(Integer value) {
            addCriterion("last_week_sale >", value, "lastWeekSale");
            return (Criteria) this;
        }

        public Criteria andLastWeekSaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_week_sale >=", value, "lastWeekSale");
            return (Criteria) this;
        }

        public Criteria andLastWeekSaleLessThan(Integer value) {
            addCriterion("last_week_sale <", value, "lastWeekSale");
            return (Criteria) this;
        }

        public Criteria andLastWeekSaleLessThanOrEqualTo(Integer value) {
            addCriterion("last_week_sale <=", value, "lastWeekSale");
            return (Criteria) this;
        }

        public Criteria andLastWeekSaleIn(List<Integer> values) {
            addCriterion("last_week_sale in", values, "lastWeekSale");
            return (Criteria) this;
        }

        public Criteria andLastWeekSaleNotIn(List<Integer> values) {
            addCriterion("last_week_sale not in", values, "lastWeekSale");
            return (Criteria) this;
        }

        public Criteria andLastWeekSaleBetween(Integer value1, Integer value2) {
            addCriterion("last_week_sale between", value1, value2, "lastWeekSale");
            return (Criteria) this;
        }

        public Criteria andLastWeekSaleNotBetween(Integer value1, Integer value2) {
            addCriterion("last_week_sale not between", value1, value2, "lastWeekSale");
            return (Criteria) this;
        }

        public Criteria andThisWeekSaleIsNull() {
            addCriterion("this_week_sale is null");
            return (Criteria) this;
        }

        public Criteria andThisWeekSaleIsNotNull() {
            addCriterion("this_week_sale is not null");
            return (Criteria) this;
        }

        public Criteria andThisWeekSaleEqualTo(Integer value) {
            addCriterion("this_week_sale =", value, "thisWeekSale");
            return (Criteria) this;
        }

        public Criteria andThisWeekSaleNotEqualTo(Integer value) {
            addCriterion("this_week_sale <>", value, "thisWeekSale");
            return (Criteria) this;
        }

        public Criteria andThisWeekSaleGreaterThan(Integer value) {
            addCriterion("this_week_sale >", value, "thisWeekSale");
            return (Criteria) this;
        }

        public Criteria andThisWeekSaleGreaterThanOrEqualTo(Integer value) {
            addCriterion("this_week_sale >=", value, "thisWeekSale");
            return (Criteria) this;
        }

        public Criteria andThisWeekSaleLessThan(Integer value) {
            addCriterion("this_week_sale <", value, "thisWeekSale");
            return (Criteria) this;
        }

        public Criteria andThisWeekSaleLessThanOrEqualTo(Integer value) {
            addCriterion("this_week_sale <=", value, "thisWeekSale");
            return (Criteria) this;
        }

        public Criteria andThisWeekSaleIn(List<Integer> values) {
            addCriterion("this_week_sale in", values, "thisWeekSale");
            return (Criteria) this;
        }

        public Criteria andThisWeekSaleNotIn(List<Integer> values) {
            addCriterion("this_week_sale not in", values, "thisWeekSale");
            return (Criteria) this;
        }

        public Criteria andThisWeekSaleBetween(Integer value1, Integer value2) {
            addCriterion("this_week_sale between", value1, value2, "thisWeekSale");
            return (Criteria) this;
        }

        public Criteria andThisWeekSaleNotBetween(Integer value1, Integer value2) {
            addCriterion("this_week_sale not between", value1, value2, "thisWeekSale");
            return (Criteria) this;
        }

        public Criteria andLastWeekVisitIsNull() {
            addCriterion("last_week_visit is null");
            return (Criteria) this;
        }

        public Criteria andLastWeekVisitIsNotNull() {
            addCriterion("last_week_visit is not null");
            return (Criteria) this;
        }

        public Criteria andLastWeekVisitEqualTo(Integer value) {
            addCriterion("last_week_visit =", value, "lastWeekVisit");
            return (Criteria) this;
        }

        public Criteria andLastWeekVisitNotEqualTo(Integer value) {
            addCriterion("last_week_visit <>", value, "lastWeekVisit");
            return (Criteria) this;
        }

        public Criteria andLastWeekVisitGreaterThan(Integer value) {
            addCriterion("last_week_visit >", value, "lastWeekVisit");
            return (Criteria) this;
        }

        public Criteria andLastWeekVisitGreaterThanOrEqualTo(Integer value) {
            addCriterion("last_week_visit >=", value, "lastWeekVisit");
            return (Criteria) this;
        }

        public Criteria andLastWeekVisitLessThan(Integer value) {
            addCriterion("last_week_visit <", value, "lastWeekVisit");
            return (Criteria) this;
        }

        public Criteria andLastWeekVisitLessThanOrEqualTo(Integer value) {
            addCriterion("last_week_visit <=", value, "lastWeekVisit");
            return (Criteria) this;
        }

        public Criteria andLastWeekVisitIn(List<Integer> values) {
            addCriterion("last_week_visit in", values, "lastWeekVisit");
            return (Criteria) this;
        }

        public Criteria andLastWeekVisitNotIn(List<Integer> values) {
            addCriterion("last_week_visit not in", values, "lastWeekVisit");
            return (Criteria) this;
        }

        public Criteria andLastWeekVisitBetween(Integer value1, Integer value2) {
            addCriterion("last_week_visit between", value1, value2, "lastWeekVisit");
            return (Criteria) this;
        }

        public Criteria andLastWeekVisitNotBetween(Integer value1, Integer value2) {
            addCriterion("last_week_visit not between", value1, value2, "lastWeekVisit");
            return (Criteria) this;
        }

        public Criteria andThisWeekVisitIsNull() {
            addCriterion("this_week_visit is null");
            return (Criteria) this;
        }

        public Criteria andThisWeekVisitIsNotNull() {
            addCriterion("this_week_visit is not null");
            return (Criteria) this;
        }

        public Criteria andThisWeekVisitEqualTo(Integer value) {
            addCriterion("this_week_visit =", value, "thisWeekVisit");
            return (Criteria) this;
        }

        public Criteria andThisWeekVisitNotEqualTo(Integer value) {
            addCriterion("this_week_visit <>", value, "thisWeekVisit");
            return (Criteria) this;
        }

        public Criteria andThisWeekVisitGreaterThan(Integer value) {
            addCriterion("this_week_visit >", value, "thisWeekVisit");
            return (Criteria) this;
        }

        public Criteria andThisWeekVisitGreaterThanOrEqualTo(Integer value) {
            addCriterion("this_week_visit >=", value, "thisWeekVisit");
            return (Criteria) this;
        }

        public Criteria andThisWeekVisitLessThan(Integer value) {
            addCriterion("this_week_visit <", value, "thisWeekVisit");
            return (Criteria) this;
        }

        public Criteria andThisWeekVisitLessThanOrEqualTo(Integer value) {
            addCriterion("this_week_visit <=", value, "thisWeekVisit");
            return (Criteria) this;
        }

        public Criteria andThisWeekVisitIn(List<Integer> values) {
            addCriterion("this_week_visit in", values, "thisWeekVisit");
            return (Criteria) this;
        }

        public Criteria andThisWeekVisitNotIn(List<Integer> values) {
            addCriterion("this_week_visit not in", values, "thisWeekVisit");
            return (Criteria) this;
        }

        public Criteria andThisWeekVisitBetween(Integer value1, Integer value2) {
            addCriterion("this_week_visit between", value1, value2, "thisWeekVisit");
            return (Criteria) this;
        }

        public Criteria andThisWeekVisitNotBetween(Integer value1, Integer value2) {
            addCriterion("this_week_visit not between", value1, value2, "thisWeekVisit");
            return (Criteria) this;
        }

        public Criteria andStoreTimeIsNull() {
            addCriterion("store_time is null");
            return (Criteria) this;
        }

        public Criteria andStoreTimeIsNotNull() {
            addCriterion("store_time is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTimeEqualTo(Date value) {
            addCriterion("store_time =", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeNotEqualTo(Date value) {
            addCriterion("store_time <>", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeGreaterThan(Date value) {
            addCriterion("store_time >", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("store_time >=", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeLessThan(Date value) {
            addCriterion("store_time <", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeLessThanOrEqualTo(Date value) {
            addCriterion("store_time <=", value, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeIn(List<Date> values) {
            addCriterion("store_time in", values, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeNotIn(List<Date> values) {
            addCriterion("store_time not in", values, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeBetween(Date value1, Date value2) {
            addCriterion("store_time between", value1, value2, "storeTime");
            return (Criteria) this;
        }

        public Criteria andStoreTimeNotBetween(Date value1, Date value2) {
            addCriterion("store_time not between", value1, value2, "storeTime");
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