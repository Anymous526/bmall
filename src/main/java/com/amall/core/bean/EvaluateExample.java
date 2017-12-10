package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class EvaluateExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluateExample() {
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

        public Criteria andEvaluateBuyerValIsNull() {
            addCriterion("evaluate_buyer_val is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateBuyerValIsNotNull() {
            addCriterion("evaluate_buyer_val is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateBuyerValEqualTo(Integer value) {
            addCriterion("evaluate_buyer_val =", value, "evaluateBuyerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateBuyerValNotEqualTo(Integer value) {
            addCriterion("evaluate_buyer_val <>", value, "evaluateBuyerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateBuyerValGreaterThan(Integer value) {
            addCriterion("evaluate_buyer_val >", value, "evaluateBuyerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateBuyerValGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_buyer_val >=", value, "evaluateBuyerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateBuyerValLessThan(Integer value) {
            addCriterion("evaluate_buyer_val <", value, "evaluateBuyerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateBuyerValLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_buyer_val <=", value, "evaluateBuyerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateBuyerValIn(List<Integer> values) {
            addCriterion("evaluate_buyer_val in", values, "evaluateBuyerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateBuyerValNotIn(List<Integer> values) {
            addCriterion("evaluate_buyer_val not in", values, "evaluateBuyerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateBuyerValBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_buyer_val between", value1, value2, "evaluateBuyerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateBuyerValNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_buyer_val not between", value1, value2, "evaluateBuyerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerTimeIsNull() {
            addCriterion("evaluate_seller_time is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerTimeIsNotNull() {
            addCriterion("evaluate_seller_time is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerTimeEqualTo(Date value) {
            addCriterion("evaluate_seller_time =", value, "evaluateSellerTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerTimeNotEqualTo(Date value) {
            addCriterion("evaluate_seller_time <>", value, "evaluateSellerTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerTimeGreaterThan(Date value) {
            addCriterion("evaluate_seller_time >", value, "evaluateSellerTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("evaluate_seller_time >=", value, "evaluateSellerTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerTimeLessThan(Date value) {
            addCriterion("evaluate_seller_time <", value, "evaluateSellerTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerTimeLessThanOrEqualTo(Date value) {
            addCriterion("evaluate_seller_time <=", value, "evaluateSellerTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerTimeIn(List<Date> values) {
            addCriterion("evaluate_seller_time in", values, "evaluateSellerTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerTimeNotIn(List<Date> values) {
            addCriterion("evaluate_seller_time not in", values, "evaluateSellerTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerTimeBetween(Date value1, Date value2) {
            addCriterion("evaluate_seller_time between", value1, value2, "evaluateSellerTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerTimeNotBetween(Date value1, Date value2) {
            addCriterion("evaluate_seller_time not between", value1, value2, "evaluateSellerTime");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerValIsNull() {
            addCriterion("evaluate_seller_val is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerValIsNotNull() {
            addCriterion("evaluate_seller_val is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerValEqualTo(Integer value) {
            addCriterion("evaluate_seller_val =", value, "evaluateSellerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerValNotEqualTo(Integer value) {
            addCriterion("evaluate_seller_val <>", value, "evaluateSellerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerValGreaterThan(Integer value) {
            addCriterion("evaluate_seller_val >", value, "evaluateSellerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerValGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_seller_val >=", value, "evaluateSellerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerValLessThan(Integer value) {
            addCriterion("evaluate_seller_val <", value, "evaluateSellerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerValLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_seller_val <=", value, "evaluateSellerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerValIn(List<Integer> values) {
            addCriterion("evaluate_seller_val in", values, "evaluateSellerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerValNotIn(List<Integer> values) {
            addCriterion("evaluate_seller_val not in", values, "evaluateSellerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerValBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_seller_val between", value1, value2, "evaluateSellerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerValNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_seller_val not between", value1, value2, "evaluateSellerVal");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusIsNull() {
            addCriterion("evaluate_status is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusIsNotNull() {
            addCriterion("evaluate_status is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusEqualTo(Integer value) {
            addCriterion("evaluate_status =", value, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusNotEqualTo(Integer value) {
            addCriterion("evaluate_status <>", value, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusGreaterThan(Integer value) {
            addCriterion("evaluate_status >", value, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaluate_status >=", value, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusLessThan(Integer value) {
            addCriterion("evaluate_status <", value, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusLessThanOrEqualTo(Integer value) {
            addCriterion("evaluate_status <=", value, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusIn(List<Integer> values) {
            addCriterion("evaluate_status in", values, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusNotIn(List<Integer> values) {
            addCriterion("evaluate_status not in", values, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_status between", value1, value2, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("evaluate_status not between", value1, value2, "evaluateStatus");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeIsNull() {
            addCriterion("evaluate_type is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeIsNotNull() {
            addCriterion("evaluate_type is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeEqualTo(String value) {
            addCriterion("evaluate_type =", value, "evaluateType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeNotEqualTo(String value) {
            addCriterion("evaluate_type <>", value, "evaluateType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeGreaterThan(String value) {
            addCriterion("evaluate_type >", value, "evaluateType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("evaluate_type >=", value, "evaluateType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeLessThan(String value) {
            addCriterion("evaluate_type <", value, "evaluateType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeLessThanOrEqualTo(String value) {
            addCriterion("evaluate_type <=", value, "evaluateType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeLike(String value) {
            addCriterion("evaluate_type like", value, "evaluateType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeNotLike(String value) {
            addCriterion("evaluate_type not like", value, "evaluateType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeIn(List<String> values) {
            addCriterion("evaluate_type in", values, "evaluateType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeNotIn(List<String> values) {
            addCriterion("evaluate_type not in", values, "evaluateType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeBetween(String value1, String value2) {
            addCriterion("evaluate_type between", value1, value2, "evaluateType");
            return (Criteria) this;
        }

        public Criteria andEvaluateTypeNotBetween(String value1, String value2) {
            addCriterion("evaluate_type not between", value1, value2, "evaluateType");
            return (Criteria) this;
        }

        public Criteria andEvaluateGoodsIdIsNull() {
            addCriterion("evaluate_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateGoodsIdIsNotNull() {
            addCriterion("evaluate_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateGoodsIdEqualTo(Long value) {
            addCriterion("evaluate_goods_id =", value, "evaluateGoodsId");
            return (Criteria) this;
        }

        public Criteria andEvaluateGoodsIdNotEqualTo(Long value) {
            addCriterion("evaluate_goods_id <>", value, "evaluateGoodsId");
            return (Criteria) this;
        }

        public Criteria andEvaluateGoodsIdGreaterThan(Long value) {
            addCriterion("evaluate_goods_id >", value, "evaluateGoodsId");
            return (Criteria) this;
        }

        public Criteria andEvaluateGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("evaluate_goods_id >=", value, "evaluateGoodsId");
            return (Criteria) this;
        }

        public Criteria andEvaluateGoodsIdLessThan(Long value) {
            addCriterion("evaluate_goods_id <", value, "evaluateGoodsId");
            return (Criteria) this;
        }

        public Criteria andEvaluateGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("evaluate_goods_id <=", value, "evaluateGoodsId");
            return (Criteria) this;
        }

        public Criteria andEvaluateGoodsIdIn(List<Long> values) {
            addCriterion("evaluate_goods_id in", values, "evaluateGoodsId");
            return (Criteria) this;
        }

        public Criteria andEvaluateGoodsIdNotIn(List<Long> values) {
            addCriterion("evaluate_goods_id not in", values, "evaluateGoodsId");
            return (Criteria) this;
        }

        public Criteria andEvaluateGoodsIdBetween(Long value1, Long value2) {
            addCriterion("evaluate_goods_id between", value1, value2, "evaluateGoodsId");
            return (Criteria) this;
        }

        public Criteria andEvaluateGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("evaluate_goods_id not between", value1, value2, "evaluateGoodsId");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerUserIdIsNull() {
            addCriterion("evaluate_seller_user_id is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerUserIdIsNotNull() {
            addCriterion("evaluate_seller_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerUserIdEqualTo(Long value) {
            addCriterion("evaluate_seller_user_id =", value, "evaluateSellerUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerUserIdNotEqualTo(Long value) {
            addCriterion("evaluate_seller_user_id <>", value, "evaluateSellerUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerUserIdGreaterThan(Long value) {
            addCriterion("evaluate_seller_user_id >", value, "evaluateSellerUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("evaluate_seller_user_id >=", value, "evaluateSellerUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerUserIdLessThan(Long value) {
            addCriterion("evaluate_seller_user_id <", value, "evaluateSellerUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerUserIdLessThanOrEqualTo(Long value) {
            addCriterion("evaluate_seller_user_id <=", value, "evaluateSellerUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerUserIdIn(List<Long> values) {
            addCriterion("evaluate_seller_user_id in", values, "evaluateSellerUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerUserIdNotIn(List<Long> values) {
            addCriterion("evaluate_seller_user_id not in", values, "evaluateSellerUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerUserIdBetween(Long value1, Long value2) {
            addCriterion("evaluate_seller_user_id between", value1, value2, "evaluateSellerUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateSellerUserIdNotBetween(Long value1, Long value2) {
            addCriterion("evaluate_seller_user_id not between", value1, value2, "evaluateSellerUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdIsNull() {
            addCriterion("evaluate_user_id is null");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdIsNotNull() {
            addCriterion("evaluate_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdEqualTo(Long value) {
            addCriterion("evaluate_user_id =", value, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdNotEqualTo(Long value) {
            addCriterion("evaluate_user_id <>", value, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdGreaterThan(Long value) {
            addCriterion("evaluate_user_id >", value, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("evaluate_user_id >=", value, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdLessThan(Long value) {
            addCriterion("evaluate_user_id <", value, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdLessThanOrEqualTo(Long value) {
            addCriterion("evaluate_user_id <=", value, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdIn(List<Long> values) {
            addCriterion("evaluate_user_id in", values, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdNotIn(List<Long> values) {
            addCriterion("evaluate_user_id not in", values, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdBetween(Long value1, Long value2) {
            addCriterion("evaluate_user_id between", value1, value2, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andEvaluateUserIdNotBetween(Long value1, Long value2) {
            addCriterion("evaluate_user_id not between", value1, value2, "evaluateUserId");
            return (Criteria) this;
        }

        public Criteria andOfIdIsNull() {
            addCriterion("of_id is null");
            return (Criteria) this;
        }

        public Criteria andOfIdIsNotNull() {
            addCriterion("of_id is not null");
            return (Criteria) this;
        }

        public Criteria andOfIdEqualTo(Long value) {
            addCriterion("of_id =", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdNotEqualTo(Long value) {
            addCriterion("of_id <>", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdGreaterThan(Long value) {
            addCriterion("of_id >", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdGreaterThanOrEqualTo(Long value) {
            addCriterion("of_id >=", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdLessThan(Long value) {
            addCriterion("of_id <", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdLessThanOrEqualTo(Long value) {
            addCriterion("of_id <=", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdIn(List<Long> values) {
            addCriterion("of_id in", values, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdNotIn(List<Long> values) {
            addCriterion("of_id not in", values, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdBetween(Long value1, Long value2) {
            addCriterion("of_id between", value1, value2, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdNotBetween(Long value1, Long value2) {
            addCriterion("of_id not between", value1, value2, "ofId");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateIsNull() {
            addCriterion("description_evaluate is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateIsNotNull() {
            addCriterion("description_evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateEqualTo(BigDecimal value) {
            addCriterion("description_evaluate =", value, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateNotEqualTo(BigDecimal value) {
            addCriterion("description_evaluate <>", value, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateGreaterThan(BigDecimal value) {
            addCriterion("description_evaluate >", value, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("description_evaluate >=", value, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateLessThan(BigDecimal value) {
            addCriterion("description_evaluate <", value, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("description_evaluate <=", value, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateIn(List<BigDecimal> values) {
            addCriterion("description_evaluate in", values, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateNotIn(List<BigDecimal> values) {
            addCriterion("description_evaluate not in", values, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("description_evaluate between", value1, value2, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andDescriptionEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("description_evaluate not between", value1, value2, "descriptionEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateIsNull() {
            addCriterion("service_evaluate is null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateIsNotNull() {
            addCriterion("service_evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateEqualTo(BigDecimal value) {
            addCriterion("service_evaluate =", value, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateNotEqualTo(BigDecimal value) {
            addCriterion("service_evaluate <>", value, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateGreaterThan(BigDecimal value) {
            addCriterion("service_evaluate >", value, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("service_evaluate >=", value, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateLessThan(BigDecimal value) {
            addCriterion("service_evaluate <", value, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("service_evaluate <=", value, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateIn(List<BigDecimal> values) {
            addCriterion("service_evaluate in", values, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateNotIn(List<BigDecimal> values) {
            addCriterion("service_evaluate not in", values, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_evaluate between", value1, value2, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andServiceEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("service_evaluate not between", value1, value2, "serviceEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateIsNull() {
            addCriterion("ship_evaluate is null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateIsNotNull() {
            addCriterion("ship_evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateEqualTo(BigDecimal value) {
            addCriterion("ship_evaluate =", value, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateNotEqualTo(BigDecimal value) {
            addCriterion("ship_evaluate <>", value, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateGreaterThan(BigDecimal value) {
            addCriterion("ship_evaluate >", value, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_evaluate >=", value, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateLessThan(BigDecimal value) {
            addCriterion("ship_evaluate <", value, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ship_evaluate <=", value, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateIn(List<BigDecimal> values) {
            addCriterion("ship_evaluate in", values, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateNotIn(List<BigDecimal> values) {
            addCriterion("ship_evaluate not in", values, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_evaluate between", value1, value2, "shipEvaluate");
            return (Criteria) this;
        }

        public Criteria andShipEvaluateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ship_evaluate not between", value1, value2, "shipEvaluate");
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