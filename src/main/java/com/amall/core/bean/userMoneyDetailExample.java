package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class userMoneyDetailExample extends BaseQuery{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public userMoneyDetailExample() {
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

        public Criteria andCanCarryIsNull() {
            addCriterion("can_carry is null");
            return (Criteria) this;
        }

        public Criteria andCanCarryIsNotNull() {
            addCriterion("can_carry is not null");
            return (Criteria) this;
        }

        public Criteria andCanCarryEqualTo(BigDecimal value) {
            addCriterion("can_carry =", value, "canCarry");
            return (Criteria) this;
        }

        public Criteria andCanCarryNotEqualTo(BigDecimal value) {
            addCriterion("can_carry <>", value, "canCarry");
            return (Criteria) this;
        }

        public Criteria andCanCarryGreaterThan(BigDecimal value) {
            addCriterion("can_carry >", value, "canCarry");
            return (Criteria) this;
        }

        public Criteria andCanCarryGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("can_carry >=", value, "canCarry");
            return (Criteria) this;
        }

        public Criteria andCanCarryLessThan(BigDecimal value) {
            addCriterion("can_carry <", value, "canCarry");
            return (Criteria) this;
        }

        public Criteria andCanCarryLessThanOrEqualTo(BigDecimal value) {
            addCriterion("can_carry <=", value, "canCarry");
            return (Criteria) this;
        }

        public Criteria andCanCarryIn(List<BigDecimal> values) {
            addCriterion("can_carry in", values, "canCarry");
            return (Criteria) this;
        }

        public Criteria andCanCarryNotIn(List<BigDecimal> values) {
            addCriterion("can_carry not in", values, "canCarry");
            return (Criteria) this;
        }

        public Criteria andCanCarryBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("can_carry between", value1, value2, "canCarry");
            return (Criteria) this;
        }

        public Criteria andCanCarryNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("can_carry not between", value1, value2, "canCarry");
            return (Criteria) this;
        }

        public Criteria andManageMoneyIsNull() {
            addCriterion("manage_money is null");
            return (Criteria) this;
        }

        public Criteria andManageMoneyIsNotNull() {
            addCriterion("manage_money is not null");
            return (Criteria) this;
        }

        public Criteria andManageMoneyEqualTo(BigDecimal value) {
            addCriterion("manage_money =", value, "manageMoney");
            return (Criteria) this;
        }

        public Criteria andManageMoneyNotEqualTo(BigDecimal value) {
            addCriterion("manage_money <>", value, "manageMoney");
            return (Criteria) this;
        }

        public Criteria andManageMoneyGreaterThan(BigDecimal value) {
            addCriterion("manage_money >", value, "manageMoney");
            return (Criteria) this;
        }

        public Criteria andManageMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_money >=", value, "manageMoney");
            return (Criteria) this;
        }

        public Criteria andManageMoneyLessThan(BigDecimal value) {
            addCriterion("manage_money <", value, "manageMoney");
            return (Criteria) this;
        }

        public Criteria andManageMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("manage_money <=", value, "manageMoney");
            return (Criteria) this;
        }

        public Criteria andManageMoneyIn(List<BigDecimal> values) {
            addCriterion("manage_money in", values, "manageMoney");
            return (Criteria) this;
        }

        public Criteria andManageMoneyNotIn(List<BigDecimal> values) {
            addCriterion("manage_money not in", values, "manageMoney");
            return (Criteria) this;
        }

        public Criteria andManageMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_money between", value1, value2, "manageMoney");
            return (Criteria) this;
        }

        public Criteria andManageMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("manage_money not between", value1, value2, "manageMoney");
            return (Criteria) this;
        }

        public Criteria andDetailFeeIsNull() {
            addCriterion("detail_fee is null");
            return (Criteria) this;
        }

        public Criteria andDetailFeeIsNotNull() {
            addCriterion("detail_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDetailFeeEqualTo(BigDecimal value) {
            addCriterion("detail_fee =", value, "detailFee");
            return (Criteria) this;
        }

        public Criteria andDetailFeeNotEqualTo(BigDecimal value) {
            addCriterion("detail_fee <>", value, "detailFee");
            return (Criteria) this;
        }

        public Criteria andDetailFeeGreaterThan(BigDecimal value) {
            addCriterion("detail_fee >", value, "detailFee");
            return (Criteria) this;
        }

        public Criteria andDetailFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("detail_fee >=", value, "detailFee");
            return (Criteria) this;
        }

        public Criteria andDetailFeeLessThan(BigDecimal value) {
            addCriterion("detail_fee <", value, "detailFee");
            return (Criteria) this;
        }

        public Criteria andDetailFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("detail_fee <=", value, "detailFee");
            return (Criteria) this;
        }

        public Criteria andDetailFeeIn(List<BigDecimal> values) {
            addCriterion("detail_fee in", values, "detailFee");
            return (Criteria) this;
        }

        public Criteria andDetailFeeNotIn(List<BigDecimal> values) {
            addCriterion("detail_fee not in", values, "detailFee");
            return (Criteria) this;
        }

        public Criteria andDetailFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("detail_fee between", value1, value2, "detailFee");
            return (Criteria) this;
        }

        public Criteria andDetailFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("detail_fee not between", value1, value2, "detailFee");
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

        public Criteria andDetailIdIsNull() {
            addCriterion("detail_id is null");
            return (Criteria) this;
        }

        public Criteria andDetailIdIsNotNull() {
            addCriterion("detail_id is not null");
            return (Criteria) this;
        }

        public Criteria andDetailIdEqualTo(Long value) {
            addCriterion("detail_id =", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotEqualTo(Long value) {
            addCriterion("detail_id <>", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThan(Long value) {
            addCriterion("detail_id >", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdGreaterThanOrEqualTo(Long value) {
            addCriterion("detail_id >=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThan(Long value) {
            addCriterion("detail_id <", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdLessThanOrEqualTo(Long value) {
            addCriterion("detail_id <=", value, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdIn(List<Long> values) {
            addCriterion("detail_id in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotIn(List<Long> values) {
            addCriterion("detail_id not in", values, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdBetween(Long value1, Long value2) {
            addCriterion("detail_id between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailIdNotBetween(Long value1, Long value2) {
            addCriterion("detail_id not between", value1, value2, "detailId");
            return (Criteria) this;
        }

        public Criteria andDetailTxIsNull() {
            addCriterion("detail_tx is null");
            return (Criteria) this;
        }

        public Criteria andDetailTxIsNotNull() {
            addCriterion("detail_tx is not null");
            return (Criteria) this;
        }

        public Criteria andDetailTxEqualTo(Integer value) {
            addCriterion("detail_tx =", value, "detailTx");
            return (Criteria) this;
        }

        public Criteria andDetailTxNotEqualTo(Integer value) {
            addCriterion("detail_tx <>", value, "detailTx");
            return (Criteria) this;
        }

        public Criteria andDetailTxGreaterThan(Integer value) {
            addCriterion("detail_tx >", value, "detailTx");
            return (Criteria) this;
        }

        public Criteria andDetailTxGreaterThanOrEqualTo(Integer value) {
            addCriterion("detail_tx >=", value, "detailTx");
            return (Criteria) this;
        }

        public Criteria andDetailTxLessThan(Integer value) {
            addCriterion("detail_tx <", value, "detailTx");
            return (Criteria) this;
        }

        public Criteria andDetailTxLessThanOrEqualTo(Integer value) {
            addCriterion("detail_tx <=", value, "detailTx");
            return (Criteria) this;
        }

        public Criteria andDetailTxIn(List<Integer> values) {
            addCriterion("detail_tx in", values, "detailTx");
            return (Criteria) this;
        }

        public Criteria andDetailTxNotIn(List<Integer> values) {
            addCriterion("detail_tx not in", values, "detailTx");
            return (Criteria) this;
        }

        public Criteria andDetailTxBetween(Integer value1, Integer value2) {
            addCriterion("detail_tx between", value1, value2, "detailTx");
            return (Criteria) this;
        }

        public Criteria andDetailTxNotBetween(Integer value1, Integer value2) {
            addCriterion("detail_tx not between", value1, value2, "detailTx");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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