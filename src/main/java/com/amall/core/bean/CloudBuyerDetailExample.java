package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class CloudBuyerDetailExample extends BaseQuery{
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CloudBuyerDetailExample() {
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
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Date value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Date value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Date value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Date value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Date> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Date> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Date value1, Date value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdIsNull() {
            addCriterion("cloud_Goods_id is null");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdIsNotNull() {
            addCriterion("cloud_Goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdEqualTo(Long value) {
            addCriterion("cloud_Goods_id =", value, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdNotEqualTo(Long value) {
            addCriterion("cloud_Goods_id <>", value, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdGreaterThan(Long value) {
            addCriterion("cloud_Goods_id >", value, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cloud_Goods_id >=", value, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdLessThan(Long value) {
            addCriterion("cloud_Goods_id <", value, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("cloud_Goods_id <=", value, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdIn(List<Long> values) {
            addCriterion("cloud_Goods_id in", values, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdNotIn(List<Long> values) {
            addCriterion("cloud_Goods_id not in", values, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdBetween(Long value1, Long value2) {
            addCriterion("cloud_Goods_id between", value1, value2, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("cloud_Goods_id not between", value1, value2, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserSelectNumberIsNull() {
            addCriterion("user_select_number is null");
            return (Criteria) this;
        }

        public Criteria andUserSelectNumberIsNotNull() {
            addCriterion("user_select_number is not null");
            return (Criteria) this;
        }

        public Criteria andUserSelectNumberEqualTo(Integer value) {
            addCriterion("user_select_number =", value, "userSelectNumber");
            return (Criteria) this;
        }

        public Criteria andUserSelectNumberNotEqualTo(Integer value) {
            addCriterion("user_select_number <>", value, "userSelectNumber");
            return (Criteria) this;
        }

        public Criteria andUserSelectNumberGreaterThan(Integer value) {
            addCriterion("user_select_number >", value, "userSelectNumber");
            return (Criteria) this;
        }

        public Criteria andUserSelectNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_select_number >=", value, "userSelectNumber");
            return (Criteria) this;
        }

        public Criteria andUserSelectNumberLessThan(Integer value) {
            addCriterion("user_select_number <", value, "userSelectNumber");
            return (Criteria) this;
        }

        public Criteria andUserSelectNumberLessThanOrEqualTo(Integer value) {
            addCriterion("user_select_number <=", value, "userSelectNumber");
            return (Criteria) this;
        }

        public Criteria andUserSelectNumberIn(List<Integer> values) {
            addCriterion("user_select_number in", values, "userSelectNumber");
            return (Criteria) this;
        }

        public Criteria andUserSelectNumberNotIn(List<Integer> values) {
            addCriterion("user_select_number not in", values, "userSelectNumber");
            return (Criteria) this;
        }

        public Criteria andUserSelectNumberBetween(Integer value1, Integer value2) {
            addCriterion("user_select_number between", value1, value2, "userSelectNumber");
            return (Criteria) this;
        }

        public Criteria andUserSelectNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("user_select_number not between", value1, value2, "userSelectNumber");
            return (Criteria) this;
        }
        public Criteria andBuyCountsIsNull() {
            addCriterion("buy_counts is null");
            return (Criteria) this;
        }

        public Criteria andBuyCountsIsNotNull() {
            addCriterion("buy_counts is not null");
            return (Criteria) this;
        }

        public Criteria andBuyCountsEqualTo(Integer value) {
            addCriterion("buy_counts =", value, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsNotEqualTo(Integer value) {
            addCriterion("buy_counts <>", value, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsGreaterThan(Integer value) {
            addCriterion("buy_counts >", value, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsGreaterThanOrEqualTo(Integer value) {
            addCriterion("buy_counts >=", value, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsLessThan(Integer value) {
            addCriterion("buy_counts <", value, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsLessThanOrEqualTo(Integer value) {
            addCriterion("buy_counts <=", value, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsIn(List<Integer> values) {
            addCriterion("buy_counts in", values, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsNotIn(List<Integer> values) {
            addCriterion("buy_counts not in", values, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsBetween(Integer value1, Integer value2) {
            addCriterion("buy_counts between", value1, value2, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andBuyCountsNotBetween(Integer value1, Integer value2) {
            addCriterion("buy_counts not between", value1, value2, "buyCounts");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNull() {
            addCriterion("is_open is null");
            return (Criteria) this;
        }

        public Criteria andIsOpenIsNotNull() {
            addCriterion("is_open is not null");
            return (Criteria) this;
        }

        public Criteria andIsOpenEqualTo(Boolean value) {
            addCriterion("is_open =", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotEqualTo(Boolean value) {
            addCriterion("is_open <>", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThan(Boolean value) {
            addCriterion("is_open >", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_open >=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThan(Boolean value) {
            addCriterion("is_open <", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenLessThanOrEqualTo(Boolean value) {
            addCriterion("is_open <=", value, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenIn(List<Boolean> values) {
            addCriterion("is_open in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotIn(List<Boolean> values) {
            addCriterion("is_open not in", values, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenBetween(Boolean value1, Boolean value2) {
            addCriterion("is_open between", value1, value2, "isOpen");
            return (Criteria) this;
        }

        public Criteria andIsOpenNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_open not between", value1, value2, "isOpen");
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