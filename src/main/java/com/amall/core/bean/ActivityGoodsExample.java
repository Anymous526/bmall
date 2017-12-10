package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class ActivityGoodsExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityGoodsExample() {
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

        public Criteria andAgStatusIsNull() {
            addCriterion("ag_status is null");
            return (Criteria) this;
        }

        public Criteria andAgStatusIsNotNull() {
            addCriterion("ag_status is not null");
            return (Criteria) this;
        }

        public Criteria andAgStatusEqualTo(Integer value) {
            addCriterion("ag_status =", value, "agStatus");
            return (Criteria) this;
        }

        public Criteria andAgStatusNotEqualTo(Integer value) {
            addCriterion("ag_status <>", value, "agStatus");
            return (Criteria) this;
        }

        public Criteria andAgStatusGreaterThan(Integer value) {
            addCriterion("ag_status >", value, "agStatus");
            return (Criteria) this;
        }

        public Criteria andAgStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ag_status >=", value, "agStatus");
            return (Criteria) this;
        }

        public Criteria andAgStatusLessThan(Integer value) {
            addCriterion("ag_status <", value, "agStatus");
            return (Criteria) this;
        }

        public Criteria andAgStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ag_status <=", value, "agStatus");
            return (Criteria) this;
        }

        public Criteria andAgStatusIn(List<Integer> values) {
            addCriterion("ag_status in", values, "agStatus");
            return (Criteria) this;
        }

        public Criteria andAgStatusNotIn(List<Integer> values) {
            addCriterion("ag_status not in", values, "agStatus");
            return (Criteria) this;
        }

        public Criteria andAgStatusBetween(Integer value1, Integer value2) {
            addCriterion("ag_status between", value1, value2, "agStatus");
            return (Criteria) this;
        }

        public Criteria andAgStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ag_status not between", value1, value2, "agStatus");
            return (Criteria) this;
        }

        public Criteria andActIdIsNull() {
            addCriterion("act_id is null");
            return (Criteria) this;
        }

        public Criteria andActIdIsNotNull() {
            addCriterion("act_id is not null");
            return (Criteria) this;
        }

        public Criteria andActIdEqualTo(Long value) {
            addCriterion("act_id =", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotEqualTo(Long value) {
            addCriterion("act_id <>", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdGreaterThan(Long value) {
            addCriterion("act_id >", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdGreaterThanOrEqualTo(Long value) {
            addCriterion("act_id >=", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdLessThan(Long value) {
            addCriterion("act_id <", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdLessThanOrEqualTo(Long value) {
            addCriterion("act_id <=", value, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdIn(List<Long> values) {
            addCriterion("act_id in", values, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotIn(List<Long> values) {
            addCriterion("act_id not in", values, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdBetween(Long value1, Long value2) {
            addCriterion("act_id between", value1, value2, "actId");
            return (Criteria) this;
        }

        public Criteria andActIdNotBetween(Long value1, Long value2) {
            addCriterion("act_id not between", value1, value2, "actId");
            return (Criteria) this;
        }

        public Criteria andAgAdminIdIsNull() {
            addCriterion("ag_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAgAdminIdIsNotNull() {
            addCriterion("ag_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgAdminIdEqualTo(Long value) {
            addCriterion("ag_admin_id =", value, "agAdminId");
            return (Criteria) this;
        }

        public Criteria andAgAdminIdNotEqualTo(Long value) {
            addCriterion("ag_admin_id <>", value, "agAdminId");
            return (Criteria) this;
        }

        public Criteria andAgAdminIdGreaterThan(Long value) {
            addCriterion("ag_admin_id >", value, "agAdminId");
            return (Criteria) this;
        }

        public Criteria andAgAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ag_admin_id >=", value, "agAdminId");
            return (Criteria) this;
        }

        public Criteria andAgAdminIdLessThan(Long value) {
            addCriterion("ag_admin_id <", value, "agAdminId");
            return (Criteria) this;
        }

        public Criteria andAgAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("ag_admin_id <=", value, "agAdminId");
            return (Criteria) this;
        }

        public Criteria andAgAdminIdIn(List<Long> values) {
            addCriterion("ag_admin_id in", values, "agAdminId");
            return (Criteria) this;
        }

        public Criteria andAgAdminIdNotIn(List<Long> values) {
            addCriterion("ag_admin_id not in", values, "agAdminId");
            return (Criteria) this;
        }

        public Criteria andAgAdminIdBetween(Long value1, Long value2) {
            addCriterion("ag_admin_id between", value1, value2, "agAdminId");
            return (Criteria) this;
        }

        public Criteria andAgAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("ag_admin_id not between", value1, value2, "agAdminId");
            return (Criteria) this;
        }

        public Criteria andAgGoodsIdIsNull() {
            addCriterion("ag_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andAgGoodsIdIsNotNull() {
            addCriterion("ag_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andAgGoodsIdEqualTo(Long value) {
            addCriterion("ag_goods_id =", value, "agGoodsId");
            return (Criteria) this;
        }

        public Criteria andAgGoodsIdNotEqualTo(Long value) {
            addCriterion("ag_goods_id <>", value, "agGoodsId");
            return (Criteria) this;
        }

        public Criteria andAgGoodsIdGreaterThan(Long value) {
            addCriterion("ag_goods_id >", value, "agGoodsId");
            return (Criteria) this;
        }

        public Criteria andAgGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ag_goods_id >=", value, "agGoodsId");
            return (Criteria) this;
        }

        public Criteria andAgGoodsIdLessThan(Long value) {
            addCriterion("ag_goods_id <", value, "agGoodsId");
            return (Criteria) this;
        }

        public Criteria andAgGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("ag_goods_id <=", value, "agGoodsId");
            return (Criteria) this;
        }

        public Criteria andAgGoodsIdIn(List<Long> values) {
            addCriterion("ag_goods_id in", values, "agGoodsId");
            return (Criteria) this;
        }

        public Criteria andAgGoodsIdNotIn(List<Long> values) {
            addCriterion("ag_goods_id not in", values, "agGoodsId");
            return (Criteria) this;
        }

        public Criteria andAgGoodsIdBetween(Long value1, Long value2) {
            addCriterion("ag_goods_id between", value1, value2, "agGoodsId");
            return (Criteria) this;
        }

        public Criteria andAgGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("ag_goods_id not between", value1, value2, "agGoodsId");
            return (Criteria) this;
        }

        public Criteria andAgPriceIsNull() {
            addCriterion("ag_price is null");
            return (Criteria) this;
        }

        public Criteria andAgPriceIsNotNull() {
            addCriterion("ag_price is not null");
            return (Criteria) this;
        }

        public Criteria andAgPriceEqualTo(BigDecimal value) {
            addCriterion("ag_price =", value, "agPrice");
            return (Criteria) this;
        }

        public Criteria andAgPriceNotEqualTo(BigDecimal value) {
            addCriterion("ag_price <>", value, "agPrice");
            return (Criteria) this;
        }

        public Criteria andAgPriceGreaterThan(BigDecimal value) {
            addCriterion("ag_price >", value, "agPrice");
            return (Criteria) this;
        }

        public Criteria andAgPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ag_price >=", value, "agPrice");
            return (Criteria) this;
        }

        public Criteria andAgPriceLessThan(BigDecimal value) {
            addCriterion("ag_price <", value, "agPrice");
            return (Criteria) this;
        }

        public Criteria andAgPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ag_price <=", value, "agPrice");
            return (Criteria) this;
        }

        public Criteria andAgPriceIn(List<BigDecimal> values) {
            addCriterion("ag_price in", values, "agPrice");
            return (Criteria) this;
        }

        public Criteria andAgPriceNotIn(List<BigDecimal> values) {
            addCriterion("ag_price not in", values, "agPrice");
            return (Criteria) this;
        }

        public Criteria andAgPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ag_price between", value1, value2, "agPrice");
            return (Criteria) this;
        }

        public Criteria andAgPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ag_price not between", value1, value2, "agPrice");
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