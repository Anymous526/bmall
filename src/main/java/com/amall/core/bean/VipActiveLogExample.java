package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class VipActiveLogExample extends BaseQuery {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VipActiveLogExample() {
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

        public Criteria andAngelGoldIsNull() {
            addCriterion("angel_gold is null");
            return (Criteria) this;
        }

        public Criteria andAngelGoldIsNotNull() {
            addCriterion("angel_gold is not null");
            return (Criteria) this;
        }

        public Criteria andAngelGoldEqualTo(Integer value) {
            addCriterion("angel_gold =", value, "angelGold");
            return (Criteria) this;
        }

        public Criteria andAngelGoldNotEqualTo(Integer value) {
            addCriterion("angel_gold <>", value, "angelGold");
            return (Criteria) this;
        }

        public Criteria andAngelGoldGreaterThan(Integer value) {
            addCriterion("angel_gold >", value, "angelGold");
            return (Criteria) this;
        }

        public Criteria andAngelGoldGreaterThanOrEqualTo(Integer value) {
            addCriterion("angel_gold >=", value, "angelGold");
            return (Criteria) this;
        }

        public Criteria andAngelGoldLessThan(Integer value) {
            addCriterion("angel_gold <", value, "angelGold");
            return (Criteria) this;
        }

        public Criteria andAngelGoldLessThanOrEqualTo(Integer value) {
            addCriterion("angel_gold <=", value, "angelGold");
            return (Criteria) this;
        }

        public Criteria andAngelGoldIn(List<Integer> values) {
            addCriterion("angel_gold in", values, "angelGold");
            return (Criteria) this;
        }

        public Criteria andAngelGoldNotIn(List<Integer> values) {
            addCriterion("angel_gold not in", values, "angelGold");
            return (Criteria) this;
        }

        public Criteria andAngelGoldBetween(Integer value1, Integer value2) {
            addCriterion("angel_gold between", value1, value2, "angelGold");
            return (Criteria) this;
        }

        public Criteria andAngelGoldNotBetween(Integer value1, Integer value2) {
            addCriterion("angel_gold not between", value1, value2, "angelGold");
            return (Criteria) this;
        }

        public Criteria andUpgradeFeeIsNull() {
            addCriterion("upgrade_fee is null");
            return (Criteria) this;
        }

        public Criteria andUpgradeFeeIsNotNull() {
            addCriterion("upgrade_fee is not null");
            return (Criteria) this;
        }

        public Criteria andUpgradeFeeEqualTo(BigDecimal value) {
            addCriterion("upgrade_fee =", value, "upgradeFee");
            return (Criteria) this;
        }

        public Criteria andUpgradeFeeNotEqualTo(BigDecimal value) {
            addCriterion("upgrade_fee <>", value, "upgradeFee");
            return (Criteria) this;
        }

        public Criteria andUpgradeFeeGreaterThan(BigDecimal value) {
            addCriterion("upgrade_fee >", value, "upgradeFee");
            return (Criteria) this;
        }

        public Criteria andUpgradeFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("upgrade_fee >=", value, "upgradeFee");
            return (Criteria) this;
        }

        public Criteria andUpgradeFeeLessThan(BigDecimal value) {
            addCriterion("upgrade_fee <", value, "upgradeFee");
            return (Criteria) this;
        }

        public Criteria andUpgradeFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("upgrade_fee <=", value, "upgradeFee");
            return (Criteria) this;
        }

        public Criteria andUpgradeFeeIn(List<BigDecimal> values) {
            addCriterion("upgrade_fee in", values, "upgradeFee");
            return (Criteria) this;
        }

        public Criteria andUpgradeFeeNotIn(List<BigDecimal> values) {
            addCriterion("upgrade_fee not in", values, "upgradeFee");
            return (Criteria) this;
        }

        public Criteria andUpgradeFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("upgrade_fee between", value1, value2, "upgradeFee");
            return (Criteria) this;
        }

        public Criteria andUpgradeFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("upgrade_fee not between", value1, value2, "upgradeFee");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNull() {
            addCriterion("pay_id is null");
            return (Criteria) this;
        }

        public Criteria andPayIdIsNotNull() {
            addCriterion("pay_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayIdEqualTo(Long value) {
            addCriterion("pay_id =", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotEqualTo(Long value) {
            addCriterion("pay_id <>", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThan(Long value) {
            addCriterion("pay_id >", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_id >=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThan(Long value) {
            addCriterion("pay_id <", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdLessThanOrEqualTo(Long value) {
            addCriterion("pay_id <=", value, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdIn(List<Long> values) {
            addCriterion("pay_id in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotIn(List<Long> values) {
            addCriterion("pay_id not in", values, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdBetween(Long value1, Long value2) {
            addCriterion("pay_id between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayIdNotBetween(Long value1, Long value2) {
            addCriterion("pay_id not between", value1, value2, "payId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdIsNull() {
            addCriterion("pay_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPayUserIdIsNotNull() {
            addCriterion("pay_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayUserIdEqualTo(Long value) {
            addCriterion("pay_user_id =", value, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdNotEqualTo(Long value) {
            addCriterion("pay_user_id <>", value, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdGreaterThan(Long value) {
            addCriterion("pay_user_id >", value, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_user_id >=", value, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdLessThan(Long value) {
            addCriterion("pay_user_id <", value, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdLessThanOrEqualTo(Long value) {
            addCriterion("pay_user_id <=", value, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdIn(List<Long> values) {
            addCriterion("pay_user_id in", values, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdNotIn(List<Long> values) {
            addCriterion("pay_user_id not in", values, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdBetween(Long value1, Long value2) {
            addCriterion("pay_user_id between", value1, value2, "payUserId");
            return (Criteria) this;
        }

        public Criteria andPayUserIdNotBetween(Long value1, Long value2) {
            addCriterion("pay_user_id not between", value1, value2, "payUserId");
            return (Criteria) this;
        }

        public Criteria andFinancialGoldIsNull() {
            addCriterion("Financial_gold is null");
            return (Criteria) this;
        }

        public Criteria andFinancialGoldIsNotNull() {
            addCriterion("Financial_gold is not null");
            return (Criteria) this;
        }

        public Criteria andFinancialGoldEqualTo(Integer value) {
            addCriterion("Financial_gold =", value, "financialGold");
            return (Criteria) this;
        }

        public Criteria andFinancialGoldNotEqualTo(Integer value) {
            addCriterion("Financial_gold <>", value, "financialGold");
            return (Criteria) this;
        }

        public Criteria andFinancialGoldGreaterThan(Integer value) {
            addCriterion("Financial_gold >", value, "financialGold");
            return (Criteria) this;
        }

        public Criteria andFinancialGoldGreaterThanOrEqualTo(Integer value) {
            addCriterion("Financial_gold >=", value, "financialGold");
            return (Criteria) this;
        }

        public Criteria andFinancialGoldLessThan(Integer value) {
            addCriterion("Financial_gold <", value, "financialGold");
            return (Criteria) this;
        }

        public Criteria andFinancialGoldLessThanOrEqualTo(Integer value) {
            addCriterion("Financial_gold <=", value, "financialGold");
            return (Criteria) this;
        }

        public Criteria andFinancialGoldIn(List<Integer> values) {
            addCriterion("Financial_gold in", values, "financialGold");
            return (Criteria) this;
        }

        public Criteria andFinancialGoldNotIn(List<Integer> values) {
            addCriterion("Financial_gold not in", values, "financialGold");
            return (Criteria) this;
        }

        public Criteria andFinancialGoldBetween(Integer value1, Integer value2) {
            addCriterion("Financial_gold between", value1, value2, "financialGold");
            return (Criteria) this;
        }

        public Criteria andFinancialGoldNotBetween(Integer value1, Integer value2) {
            addCriterion("Financial_gold not between", value1, value2, "financialGold");
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