package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.amall.core.web.BaseQuery;

public class FengHongExample extends BaseQuery{

    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FengHongExample() {
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

        public Criteria andFenhongFeeIsNull() {
            addCriterion("fenhong_fee is null");
            return (Criteria) this;
        }

        public Criteria andFenhongFeeIsNotNull() {
            addCriterion("fenhong_fee is not null");
            return (Criteria) this;
        }

        public Criteria andFenhongFeeEqualTo(BigDecimal value) {
            addCriterion("fenhong_fee =", value, "fenhongFee");
            return (Criteria) this;
        }

        public Criteria andFenhongFeeNotEqualTo(BigDecimal value) {
            addCriterion("fenhong_fee <>", value, "fenhongFee");
            return (Criteria) this;
        }

        public Criteria andFenhongFeeGreaterThan(BigDecimal value) {
            addCriterion("fenhong_fee >", value, "fenhongFee");
            return (Criteria) this;
        }

        public Criteria andFenhongFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fenhong_fee >=", value, "fenhongFee");
            return (Criteria) this;
        }

        public Criteria andFenhongFeeLessThan(BigDecimal value) {
            addCriterion("fenhong_fee <", value, "fenhongFee");
            return (Criteria) this;
        }

        public Criteria andFenhongFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fenhong_fee <=", value, "fenhongFee");
            return (Criteria) this;
        }

        public Criteria andFenhongFeeIn(List<BigDecimal> values) {
            addCriterion("fenhong_fee in", values, "fenhongFee");
            return (Criteria) this;
        }

        public Criteria andFenhongFeeNotIn(List<BigDecimal> values) {
            addCriterion("fenhong_fee not in", values, "fenhongFee");
            return (Criteria) this;
        }

        public Criteria andFenhongFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fenhong_fee between", value1, value2, "fenhongFee");
            return (Criteria) this;
        }

        public Criteria andFenhongFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fenhong_fee not between", value1, value2, "fenhongFee");
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

        public Criteria andGiveShopIdIsNull() {
            addCriterion("give_shop_id is null");
            return (Criteria) this;
        }

        public Criteria andGiveShopIdIsNotNull() {
            addCriterion("give_shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andGiveShopIdEqualTo(Long value) {
            addCriterion("give_shop_id =", value, "giveShopId");
            return (Criteria) this;
        }

        public Criteria andGiveShopIdNotEqualTo(Long value) {
            addCriterion("give_shop_id <>", value, "giveShopId");
            return (Criteria) this;
        }

        public Criteria andGiveShopIdGreaterThan(Long value) {
            addCriterion("give_shop_id >", value, "giveShopId");
            return (Criteria) this;
        }

        public Criteria andGiveShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("give_shop_id >=", value, "giveShopId");
            return (Criteria) this;
        }

        public Criteria andGiveShopIdLessThan(Long value) {
            addCriterion("give_shop_id <", value, "giveShopId");
            return (Criteria) this;
        }

        public Criteria andGiveShopIdLessThanOrEqualTo(Long value) {
            addCriterion("give_shop_id <=", value, "giveShopId");
            return (Criteria) this;
        }

        public Criteria andGiveShopIdIn(List<Long> values) {
            addCriterion("give_shop_id in", values, "giveShopId");
            return (Criteria) this;
        }

        public Criteria andGiveShopIdNotIn(List<Long> values) {
            addCriterion("give_shop_id not in", values, "giveShopId");
            return (Criteria) this;
        }

        public Criteria andGiveShopIdBetween(Long value1, Long value2) {
            addCriterion("give_shop_id between", value1, value2, "giveShopId");
            return (Criteria) this;
        }

        public Criteria andGiveShopIdNotBetween(Long value1, Long value2) {
            addCriterion("give_shop_id not between", value1, value2, "giveShopId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Long value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Long value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Long value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Long value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Long> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Long> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Long value1, Long value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andGetUserNameIsNull() {
            addCriterion("get_user_name is null");
            return (Criteria) this;
        }

        public Criteria andGetUserNameIsNotNull() {
            addCriterion("get_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andGetUserNameEqualTo(String value) {
            addCriterion("get_user_name =", value, "getUserName");
            return (Criteria) this;
        }

        public Criteria andGetUserNameNotEqualTo(String value) {
            addCriterion("get_user_name <>", value, "getUserName");
            return (Criteria) this;
        }

        public Criteria andGetUserNameGreaterThan(String value) {
            addCriterion("get_user_name >", value, "getUserName");
            return (Criteria) this;
        }

        public Criteria andGetUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("get_user_name >=", value, "getUserName");
            return (Criteria) this;
        }

        public Criteria andGetUserNameLessThan(String value) {
            addCriterion("get_user_name <", value, "getUserName");
            return (Criteria) this;
        }

        public Criteria andGetUserNameLessThanOrEqualTo(String value) {
            addCriterion("get_user_name <=", value, "getUserName");
            return (Criteria) this;
        }

        public Criteria andGetUserNameLike(String value) {
            addCriterion("get_user_name like", value, "getUserName");
            return (Criteria) this;
        }

        public Criteria andGetUserNameNotLike(String value) {
            addCriterion("get_user_name not like", value, "getUserName");
            return (Criteria) this;
        }

        public Criteria andGetUserNameIn(List<String> values) {
            addCriterion("get_user_name in", values, "getUserName");
            return (Criteria) this;
        }

        public Criteria andGetUserNameNotIn(List<String> values) {
            addCriterion("get_user_name not in", values, "getUserName");
            return (Criteria) this;
        }

        public Criteria andGetUserNameBetween(String value1, String value2) {
            addCriterion("get_user_name between", value1, value2, "getUserName");
            return (Criteria) this;
        }

        public Criteria andGetUserNameNotBetween(String value1, String value2) {
            addCriterion("get_user_name not between", value1, value2, "getUserName");
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