package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class CloudShowOrderExample extends BaseQuery{
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CloudShowOrderExample() {
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

        public Criteria andPhotoOneIsNull() {
            addCriterion("photo_one is null");
            return (Criteria) this;
        }

        public Criteria andPhotoOneIsNotNull() {
            addCriterion("photo_one is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoOneEqualTo(Long value) {
            addCriterion("photo_one =", value, "photoOne");
            return (Criteria) this;
        }

        public Criteria andPhotoOneNotEqualTo(Long value) {
            addCriterion("photo_one <>", value, "photoOne");
            return (Criteria) this;
        }

        public Criteria andPhotoOneGreaterThan(Long value) {
            addCriterion("photo_one >", value, "photoOne");
            return (Criteria) this;
        }

        public Criteria andPhotoOneGreaterThanOrEqualTo(Long value) {
            addCriterion("photo_one >=", value, "photoOne");
            return (Criteria) this;
        }

        public Criteria andPhotoOneLessThan(Long value) {
            addCriterion("photo_one <", value, "photoOne");
            return (Criteria) this;
        }

        public Criteria andPhotoOneLessThanOrEqualTo(Long value) {
            addCriterion("photo_one <=", value, "photoOne");
            return (Criteria) this;
        }

        public Criteria andPhotoOneIn(List<Long> values) {
            addCriterion("photo_one in", values, "photoOne");
            return (Criteria) this;
        }

        public Criteria andPhotoOneNotIn(List<Long> values) {
            addCriterion("photo_one not in", values, "photoOne");
            return (Criteria) this;
        }

        public Criteria andPhotoOneBetween(Long value1, Long value2) {
            addCriterion("photo_one between", value1, value2, "photoOne");
            return (Criteria) this;
        }

        public Criteria andPhotoOneNotBetween(Long value1, Long value2) {
            addCriterion("photo_one not between", value1, value2, "photoOne");
            return (Criteria) this;
        }

        public Criteria andPhotoTwoIsNull() {
            addCriterion("photo_two is null");
            return (Criteria) this;
        }

        public Criteria andPhotoTwoIsNotNull() {
            addCriterion("photo_two is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoTwoEqualTo(Long value) {
            addCriterion("photo_two =", value, "photoTwo");
            return (Criteria) this;
        }

        public Criteria andPhotoTwoNotEqualTo(Long value) {
            addCriterion("photo_two <>", value, "photoTwo");
            return (Criteria) this;
        }

        public Criteria andPhotoTwoGreaterThan(Long value) {
            addCriterion("photo_two >", value, "photoTwo");
            return (Criteria) this;
        }

        public Criteria andPhotoTwoGreaterThanOrEqualTo(Long value) {
            addCriterion("photo_two >=", value, "photoTwo");
            return (Criteria) this;
        }

        public Criteria andPhotoTwoLessThan(Long value) {
            addCriterion("photo_two <", value, "photoTwo");
            return (Criteria) this;
        }

        public Criteria andPhotoTwoLessThanOrEqualTo(Long value) {
            addCriterion("photo_two <=", value, "photoTwo");
            return (Criteria) this;
        }

        public Criteria andPhotoTwoIn(List<Long> values) {
            addCriterion("photo_two in", values, "photoTwo");
            return (Criteria) this;
        }

        public Criteria andPhotoTwoNotIn(List<Long> values) {
            addCriterion("photo_two not in", values, "photoTwo");
            return (Criteria) this;
        }

        public Criteria andPhotoTwoBetween(Long value1, Long value2) {
            addCriterion("photo_two between", value1, value2, "photoTwo");
            return (Criteria) this;
        }

        public Criteria andPhotoTwoNotBetween(Long value1, Long value2) {
            addCriterion("photo_two not between", value1, value2, "photoTwo");
            return (Criteria) this;
        }

        public Criteria andPhotoThreeIsNull() {
            addCriterion("photo_three is null");
            return (Criteria) this;
        }

        public Criteria andPhotoThreeIsNotNull() {
            addCriterion("photo_three is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoThreeEqualTo(Long value) {
            addCriterion("photo_three =", value, "photoThree");
            return (Criteria) this;
        }

        public Criteria andPhotoThreeNotEqualTo(Long value) {
            addCriterion("photo_three <>", value, "photoThree");
            return (Criteria) this;
        }

        public Criteria andPhotoThreeGreaterThan(Long value) {
            addCriterion("photo_three >", value, "photoThree");
            return (Criteria) this;
        }

        public Criteria andPhotoThreeGreaterThanOrEqualTo(Long value) {
            addCriterion("photo_three >=", value, "photoThree");
            return (Criteria) this;
        }

        public Criteria andPhotoThreeLessThan(Long value) {
            addCriterion("photo_three <", value, "photoThree");
            return (Criteria) this;
        }

        public Criteria andPhotoThreeLessThanOrEqualTo(Long value) {
            addCriterion("photo_three <=", value, "photoThree");
            return (Criteria) this;
        }

        public Criteria andPhotoThreeIn(List<Long> values) {
            addCriterion("photo_three in", values, "photoThree");
            return (Criteria) this;
        }

        public Criteria andPhotoThreeNotIn(List<Long> values) {
            addCriterion("photo_three not in", values, "photoThree");
            return (Criteria) this;
        }

        public Criteria andPhotoThreeBetween(Long value1, Long value2) {
            addCriterion("photo_three between", value1, value2, "photoThree");
            return (Criteria) this;
        }

        public Criteria andPhotoThreeNotBetween(Long value1, Long value2) {
            addCriterion("photo_three not between", value1, value2, "photoThree");
            return (Criteria) this;
        }

        public Criteria andContextIsNull() {
            addCriterion("context is null");
            return (Criteria) this;
        }

        public Criteria andContextIsNotNull() {
            addCriterion("context is not null");
            return (Criteria) this;
        }

        public Criteria andContextEqualTo(String value) {
            addCriterion("context =", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotEqualTo(String value) {
            addCriterion("context <>", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThan(String value) {
            addCriterion("context >", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextGreaterThanOrEqualTo(String value) {
            addCriterion("context >=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThan(String value) {
            addCriterion("context <", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLessThanOrEqualTo(String value) {
            addCriterion("context <=", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextLike(String value) {
            addCriterion("context like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotLike(String value) {
            addCriterion("context not like", value, "context");
            return (Criteria) this;
        }

        public Criteria andContextIn(List<String> values) {
            addCriterion("context in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotIn(List<String> values) {
            addCriterion("context not in", values, "context");
            return (Criteria) this;
        }

        public Criteria andContextBetween(String value1, String value2) {
            addCriterion("context between", value1, value2, "context");
            return (Criteria) this;
        }

        public Criteria andContextNotBetween(String value1, String value2) {
            addCriterion("context not between", value1, value2, "context");
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