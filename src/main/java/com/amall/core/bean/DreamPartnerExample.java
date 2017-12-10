package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class DreamPartnerExample extends BaseQuery{
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DreamPartnerExample() {
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

        public Criteria andApproveTimeIsNull() {
            addCriterion("approve_time is null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIsNotNull() {
            addCriterion("approve_time is not null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeEqualTo(Date value) {
            addCriterion("approve_time =", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotEqualTo(Date value) {
            addCriterion("approve_time <>", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThan(Date value) {
            addCriterion("approve_time >", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approve_time >=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThan(Date value) {
            addCriterion("approve_time <", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThanOrEqualTo(Date value) {
            addCriterion("approve_time <=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIn(List<Date> values) {
            addCriterion("approve_time in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotIn(List<Date> values) {
            addCriterion("approve_time not in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeBetween(Date value1, Date value2) {
            addCriterion("approve_time between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotBetween(Date value1, Date value2) {
            addCriterion("approve_time not between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdIsNull() {
            addCriterion("referrer_user_id is null");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdIsNotNull() {
            addCriterion("referrer_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdEqualTo(Long value) {
            addCriterion("referrer_user_id =", value, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdNotEqualTo(Long value) {
            addCriterion("referrer_user_id <>", value, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdGreaterThan(Long value) {
            addCriterion("referrer_user_id >", value, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("referrer_user_id >=", value, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdLessThan(Long value) {
            addCriterion("referrer_user_id <", value, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdLessThanOrEqualTo(Long value) {
            addCriterion("referrer_user_id <=", value, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdIn(List<Long> values) {
            addCriterion("referrer_user_id in", values, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdNotIn(List<Long> values) {
            addCriterion("referrer_user_id not in", values, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdBetween(Long value1, Long value2) {
            addCriterion("referrer_user_id between", value1, value2, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andReferrerUserIdNotBetween(Long value1, Long value2) {
            addCriterion("referrer_user_id not between", value1, value2, "referrerUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdIsNull() {
            addCriterion("apply_user_id is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdIsNotNull() {
            addCriterion("apply_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdEqualTo(Long value) {
            addCriterion("apply_user_id =", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdNotEqualTo(Long value) {
            addCriterion("apply_user_id <>", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdGreaterThan(Long value) {
            addCriterion("apply_user_id >", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("apply_user_id >=", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdLessThan(Long value) {
            addCriterion("apply_user_id <", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdLessThanOrEqualTo(Long value) {
            addCriterion("apply_user_id <=", value, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdIn(List<Long> values) {
            addCriterion("apply_user_id in", values, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdNotIn(List<Long> values) {
            addCriterion("apply_user_id not in", values, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdBetween(Long value1, Long value2) {
            addCriterion("apply_user_id between", value1, value2, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApplyUserIdNotBetween(Long value1, Long value2) {
            addCriterion("apply_user_id not between", value1, value2, "applyUserId");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNull() {
            addCriterion("approve_status is null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIsNotNull() {
            addCriterion("approve_status is not null");
            return (Criteria) this;
        }

        public Criteria andApproveStatusEqualTo(Boolean value) {
            addCriterion("approve_status =", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotEqualTo(Boolean value) {
            addCriterion("approve_status <>", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThan(Boolean value) {
            addCriterion("approve_status >", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("approve_status >=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThan(Boolean value) {
            addCriterion("approve_status <", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("approve_status <=", value, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusIn(List<Boolean> values) {
            addCriterion("approve_status in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotIn(List<Boolean> values) {
            addCriterion("approve_status not in", values, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("approve_status between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andApproveStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("approve_status not between", value1, value2, "approveStatus");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNull() {
            addCriterion("total_fee is null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIsNotNull() {
            addCriterion("total_fee is not null");
            return (Criteria) this;
        }

        public Criteria andTotalFeeEqualTo(BigDecimal value) {
            addCriterion("total_fee =", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotEqualTo(BigDecimal value) {
            addCriterion("total_fee <>", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThan(BigDecimal value) {
            addCriterion("total_fee >", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("total_fee >=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThan(BigDecimal value) {
            addCriterion("total_fee <", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("total_fee <=", value, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeIn(List<BigDecimal> values) {
            addCriterion("total_fee in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotIn(List<BigDecimal> values) {
            addCriterion("total_fee not in", values, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_fee between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andTotalFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("total_fee not between", value1, value2, "totalFee");
            return (Criteria) this;
        }

        public Criteria andUserFeeIsNull() {
            addCriterion("user_fee is null");
            return (Criteria) this;
        }

        public Criteria andUserFeeIsNotNull() {
            addCriterion("user_fee is not null");
            return (Criteria) this;
        }

        public Criteria andUserFeeEqualTo(BigDecimal value) {
            addCriterion("user_fee =", value, "userFee");
            return (Criteria) this;
        }

        public Criteria andUserFeeNotEqualTo(BigDecimal value) {
            addCriterion("user_fee <>", value, "userFee");
            return (Criteria) this;
        }

        public Criteria andUserFeeGreaterThan(BigDecimal value) {
            addCriterion("user_fee >", value, "userFee");
            return (Criteria) this;
        }

        public Criteria andUserFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("user_fee >=", value, "userFee");
            return (Criteria) this;
        }

        public Criteria andUserFeeLessThan(BigDecimal value) {
            addCriterion("user_fee <", value, "userFee");
            return (Criteria) this;
        }

        public Criteria andUserFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("user_fee <=", value, "userFee");
            return (Criteria) this;
        }

        public Criteria andUserFeeIn(List<BigDecimal> values) {
            addCriterion("user_fee in", values, "userFee");
            return (Criteria) this;
        }

        public Criteria andUserFeeNotIn(List<BigDecimal> values) {
            addCriterion("user_fee not in", values, "userFee");
            return (Criteria) this;
        }

        public Criteria andUserFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_fee between", value1, value2, "userFee");
            return (Criteria) this;
        }

        public Criteria andUserFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("user_fee not between", value1, value2, "userFee");
            return (Criteria) this;
        }

        public Criteria andLastUserFeeTimeIsNull() {
            addCriterion("last_user_fee_time is null");
            return (Criteria) this;
        }

        public Criteria andLastUserFeeTimeIsNotNull() {
            addCriterion("last_user_fee_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastUserFeeTimeEqualTo(Date value) {
            addCriterion("last_user_fee_time =", value, "lastUserFeeTime");
            return (Criteria) this;
        }

        public Criteria andLastUserFeeTimeNotEqualTo(Date value) {
            addCriterion("last_user_fee_time <>", value, "lastUserFeeTime");
            return (Criteria) this;
        }

        public Criteria andLastUserFeeTimeGreaterThan(Date value) {
            addCriterion("last_user_fee_time >", value, "lastUserFeeTime");
            return (Criteria) this;
        }

        public Criteria andLastUserFeeTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_user_fee_time >=", value, "lastUserFeeTime");
            return (Criteria) this;
        }

        public Criteria andLastUserFeeTimeLessThan(Date value) {
            addCriterion("last_user_fee_time <", value, "lastUserFeeTime");
            return (Criteria) this;
        }

        public Criteria andLastUserFeeTimeLessThanOrEqualTo(Date value) {
            addCriterion("last_user_fee_time <=", value, "lastUserFeeTime");
            return (Criteria) this;
        }

        public Criteria andLastUserFeeTimeIn(List<Date> values) {
            addCriterion("last_user_fee_time in", values, "lastUserFeeTime");
            return (Criteria) this;
        }

        public Criteria andLastUserFeeTimeNotIn(List<Date> values) {
            addCriterion("last_user_fee_time not in", values, "lastUserFeeTime");
            return (Criteria) this;
        }

        public Criteria andLastUserFeeTimeBetween(Date value1, Date value2) {
            addCriterion("last_user_fee_time between", value1, value2, "lastUserFeeTime");
            return (Criteria) this;
        }

        public Criteria andLastUserFeeTimeNotBetween(Date value1, Date value2) {
            addCriterion("last_user_fee_time not between", value1, value2, "lastUserFeeTime");
            return (Criteria) this;
        }

        public Criteria andCardFrontIdIsNull() {
            addCriterion("card_front_id is null");
            return (Criteria) this;
        }

        public Criteria andCardFrontIdIsNotNull() {
            addCriterion("card_front_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardFrontIdEqualTo(Long value) {
            addCriterion("card_front_id =", value, "cardFrontId");
            return (Criteria) this;
        }

        public Criteria andCardFrontIdNotEqualTo(Long value) {
            addCriterion("card_front_id <>", value, "cardFrontId");
            return (Criteria) this;
        }

        public Criteria andCardFrontIdGreaterThan(Long value) {
            addCriterion("card_front_id >", value, "cardFrontId");
            return (Criteria) this;
        }

        public Criteria andCardFrontIdGreaterThanOrEqualTo(Long value) {
            addCriterion("card_front_id >=", value, "cardFrontId");
            return (Criteria) this;
        }

        public Criteria andCardFrontIdLessThan(Long value) {
            addCriterion("card_front_id <", value, "cardFrontId");
            return (Criteria) this;
        }

        public Criteria andCardFrontIdLessThanOrEqualTo(Long value) {
            addCriterion("card_front_id <=", value, "cardFrontId");
            return (Criteria) this;
        }

        public Criteria andCardFrontIdIn(List<Long> values) {
            addCriterion("card_front_id in", values, "cardFrontId");
            return (Criteria) this;
        }

        public Criteria andCardFrontIdNotIn(List<Long> values) {
            addCriterion("card_front_id not in", values, "cardFrontId");
            return (Criteria) this;
        }

        public Criteria andCardFrontIdBetween(Long value1, Long value2) {
            addCriterion("card_front_id between", value1, value2, "cardFrontId");
            return (Criteria) this;
        }

        public Criteria andCardFrontIdNotBetween(Long value1, Long value2) {
            addCriterion("card_front_id not between", value1, value2, "cardFrontId");
            return (Criteria) this;
        }

        public Criteria andCardBackIdIsNull() {
            addCriterion("card_back_id is null");
            return (Criteria) this;
        }

        public Criteria andCardBackIdIsNotNull() {
            addCriterion("card_back_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardBackIdEqualTo(Long value) {
            addCriterion("card_back_id =", value, "cardBackId");
            return (Criteria) this;
        }

        public Criteria andCardBackIdNotEqualTo(Long value) {
            addCriterion("card_back_id <>", value, "cardBackId");
            return (Criteria) this;
        }

        public Criteria andCardBackIdGreaterThan(Long value) {
            addCriterion("card_back_id >", value, "cardBackId");
            return (Criteria) this;
        }

        public Criteria andCardBackIdGreaterThanOrEqualTo(Long value) {
            addCriterion("card_back_id >=", value, "cardBackId");
            return (Criteria) this;
        }

        public Criteria andCardBackIdLessThan(Long value) {
            addCriterion("card_back_id <", value, "cardBackId");
            return (Criteria) this;
        }

        public Criteria andCardBackIdLessThanOrEqualTo(Long value) {
            addCriterion("card_back_id <=", value, "cardBackId");
            return (Criteria) this;
        }

        public Criteria andCardBackIdIn(List<Long> values) {
            addCriterion("card_back_id in", values, "cardBackId");
            return (Criteria) this;
        }

        public Criteria andCardBackIdNotIn(List<Long> values) {
            addCriterion("card_back_id not in", values, "cardBackId");
            return (Criteria) this;
        }

        public Criteria andCardBackIdBetween(Long value1, Long value2) {
            addCriterion("card_back_id between", value1, value2, "cardBackId");
            return (Criteria) this;
        }

        public Criteria andCardBackIdNotBetween(Long value1, Long value2) {
            addCriterion("card_back_id not between", value1, value2, "cardBackId");
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