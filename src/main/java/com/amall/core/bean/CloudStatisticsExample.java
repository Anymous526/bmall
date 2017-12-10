package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class CloudStatisticsExample extends BaseQuery{
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CloudStatisticsExample() {
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

        public Criteria andGoodsCountIsNull() {
            addCriterion("goods_count is null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIsNotNull() {
            addCriterion("goods_count is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsCountEqualTo(Long value) {
            addCriterion("goods_count =", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotEqualTo(Long value) {
            addCriterion("goods_count <>", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThan(Long value) {
            addCriterion("goods_count >", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_count >=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThan(Long value) {
            addCriterion("goods_count <", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThanOrEqualTo(Long value) {
            addCriterion("goods_count <=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIn(List<Long> values) {
            addCriterion("goods_count in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotIn(List<Long> values) {
            addCriterion("goods_count not in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountBetween(Long value1, Long value2) {
            addCriterion("goods_count between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotBetween(Long value1, Long value2) {
            addCriterion("goods_count not between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andUserCountIsNull() {
            addCriterion("user_count is null");
            return (Criteria) this;
        }

        public Criteria andUserCountIsNotNull() {
            addCriterion("user_count is not null");
            return (Criteria) this;
        }

        public Criteria andUserCountEqualTo(Long value) {
            addCriterion("user_count =", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountNotEqualTo(Long value) {
            addCriterion("user_count <>", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountGreaterThan(Long value) {
            addCriterion("user_count >", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountGreaterThanOrEqualTo(Long value) {
            addCriterion("user_count >=", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountLessThan(Long value) {
            addCriterion("user_count <", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountLessThanOrEqualTo(Long value) {
            addCriterion("user_count <=", value, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountIn(List<Long> values) {
            addCriterion("user_count in", values, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountNotIn(List<Long> values) {
            addCriterion("user_count not in", values, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountBetween(Long value1, Long value2) {
            addCriterion("user_count between", value1, value2, "userCount");
            return (Criteria) this;
        }

        public Criteria andUserCountNotBetween(Long value1, Long value2) {
            addCriterion("user_count not between", value1, value2, "userCount");
            return (Criteria) this;
        }

        public Criteria andAngelCoinCountIsNull() {
            addCriterion("angel_coin_count is null");
            return (Criteria) this;
        }

        public Criteria andAngelCoinCountIsNotNull() {
            addCriterion("angel_coin_count is not null");
            return (Criteria) this;
        }

        public Criteria andAngelCoinCountEqualTo(Long value) {
            addCriterion("angel_coin_count =", value, "angelCoinCount");
            return (Criteria) this;
        }

        public Criteria andAngelCoinCountNotEqualTo(Long value) {
            addCriterion("angel_coin_count <>", value, "angelCoinCount");
            return (Criteria) this;
        }

        public Criteria andAngelCoinCountGreaterThan(Long value) {
            addCriterion("angel_coin_count >", value, "angelCoinCount");
            return (Criteria) this;
        }

        public Criteria andAngelCoinCountGreaterThanOrEqualTo(Long value) {
            addCriterion("angel_coin_count >=", value, "angelCoinCount");
            return (Criteria) this;
        }

        public Criteria andAngelCoinCountLessThan(Long value) {
            addCriterion("angel_coin_count <", value, "angelCoinCount");
            return (Criteria) this;
        }

        public Criteria andAngelCoinCountLessThanOrEqualTo(Long value) {
            addCriterion("angel_coin_count <=", value, "angelCoinCount");
            return (Criteria) this;
        }

        public Criteria andAngelCoinCountIn(List<Long> values) {
            addCriterion("angel_coin_count in", values, "angelCoinCount");
            return (Criteria) this;
        }

        public Criteria andAngelCoinCountNotIn(List<Long> values) {
            addCriterion("angel_coin_count not in", values, "angelCoinCount");
            return (Criteria) this;
        }

        public Criteria andAngelCoinCountBetween(Long value1, Long value2) {
            addCriterion("angel_coin_count between", value1, value2, "angelCoinCount");
            return (Criteria) this;
        }

        public Criteria andAngelCoinCountNotBetween(Long value1, Long value2) {
            addCriterion("angel_coin_count not between", value1, value2, "angelCoinCount");
            return (Criteria) this;
        }

        public Criteria andGoodsPassCountIsNull() {
            addCriterion("goods_pass_count is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPassCountIsNotNull() {
            addCriterion("goods_pass_count is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPassCountEqualTo(Long value) {
            addCriterion("goods_pass_count =", value, "goodsPassCount");
            return (Criteria) this;
        }

        public Criteria andGoodsPassCountNotEqualTo(Long value) {
            addCriterion("goods_pass_count <>", value, "goodsPassCount");
            return (Criteria) this;
        }

        public Criteria andGoodsPassCountGreaterThan(Long value) {
            addCriterion("goods_pass_count >", value, "goodsPassCount");
            return (Criteria) this;
        }

        public Criteria andGoodsPassCountGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_pass_count >=", value, "goodsPassCount");
            return (Criteria) this;
        }

        public Criteria andGoodsPassCountLessThan(Long value) {
            addCriterion("goods_pass_count <", value, "goodsPassCount");
            return (Criteria) this;
        }

        public Criteria andGoodsPassCountLessThanOrEqualTo(Long value) {
            addCriterion("goods_pass_count <=", value, "goodsPassCount");
            return (Criteria) this;
        }

        public Criteria andGoodsPassCountIn(List<Long> values) {
            addCriterion("goods_pass_count in", values, "goodsPassCount");
            return (Criteria) this;
        }

        public Criteria andGoodsPassCountNotIn(List<Long> values) {
            addCriterion("goods_pass_count not in", values, "goodsPassCount");
            return (Criteria) this;
        }

        public Criteria andGoodsPassCountBetween(Long value1, Long value2) {
            addCriterion("goods_pass_count between", value1, value2, "goodsPassCount");
            return (Criteria) this;
        }

        public Criteria andGoodsPassCountNotBetween(Long value1, Long value2) {
            addCriterion("goods_pass_count not between", value1, value2, "goodsPassCount");
            return (Criteria) this;
        }

        public Criteria andGoodsWinnerCountIsNull() {
            addCriterion("goods_winner_count is null");
            return (Criteria) this;
        }

        public Criteria andGoodsWinnerCountIsNotNull() {
            addCriterion("goods_winner_count is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsWinnerCountEqualTo(Long value) {
            addCriterion("goods_winner_count =", value, "goodsWinnerCount");
            return (Criteria) this;
        }

        public Criteria andGoodsWinnerCountNotEqualTo(Long value) {
            addCriterion("goods_winner_count <>", value, "goodsWinnerCount");
            return (Criteria) this;
        }

        public Criteria andGoodsWinnerCountGreaterThan(Long value) {
            addCriterion("goods_winner_count >", value, "goodsWinnerCount");
            return (Criteria) this;
        }

        public Criteria andGoodsWinnerCountGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_winner_count >=", value, "goodsWinnerCount");
            return (Criteria) this;
        }

        public Criteria andGoodsWinnerCountLessThan(Long value) {
            addCriterion("goods_winner_count <", value, "goodsWinnerCount");
            return (Criteria) this;
        }

        public Criteria andGoodsWinnerCountLessThanOrEqualTo(Long value) {
            addCriterion("goods_winner_count <=", value, "goodsWinnerCount");
            return (Criteria) this;
        }

        public Criteria andGoodsWinnerCountIn(List<Long> values) {
            addCriterion("goods_winner_count in", values, "goodsWinnerCount");
            return (Criteria) this;
        }

        public Criteria andGoodsWinnerCountNotIn(List<Long> values) {
            addCriterion("goods_winner_count not in", values, "goodsWinnerCount");
            return (Criteria) this;
        }

        public Criteria andGoodsWinnerCountBetween(Long value1, Long value2) {
            addCriterion("goods_winner_count between", value1, value2, "goodsWinnerCount");
            return (Criteria) this;
        }

        public Criteria andGoodsWinnerCountNotBetween(Long value1, Long value2) {
            addCriterion("goods_winner_count not between", value1, value2, "goodsWinnerCount");
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