package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class PromoteVipItemExample extends BaseQuery{
    private static final long serialVersionUID = 1L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PromoteVipItemExample() {
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

        public Criteria andUpgradeLevelIsNull() {
            addCriterion("upgrade_level is null");
            return (Criteria) this;
        }

        public Criteria andUpgradeLevelIsNotNull() {
            addCriterion("upgrade_level is not null");
            return (Criteria) this;
        }

        public Criteria andUpgradeLevelEqualTo(Integer value) {
            addCriterion("upgrade_level =", value, "upgradeLevel");
            return (Criteria) this;
        }

        public Criteria andUpgradeLevelNotEqualTo(Integer value) {
            addCriterion("upgrade_level <>", value, "upgradeLevel");
            return (Criteria) this;
        }

        public Criteria andUpgradeLevelGreaterThan(Integer value) {
            addCriterion("upgrade_level >", value, "upgradeLevel");
            return (Criteria) this;
        }

        public Criteria andUpgradeLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("upgrade_level >=", value, "upgradeLevel");
            return (Criteria) this;
        }

        public Criteria andUpgradeLevelLessThan(Integer value) {
            addCriterion("upgrade_level <", value, "upgradeLevel");
            return (Criteria) this;
        }

        public Criteria andUpgradeLevelLessThanOrEqualTo(Integer value) {
            addCriterion("upgrade_level <=", value, "upgradeLevel");
            return (Criteria) this;
        }

        public Criteria andUpgradeLevelIn(List<Integer> values) {
            addCriterion("upgrade_level in", values, "upgradeLevel");
            return (Criteria) this;
        }

        public Criteria andUpgradeLevelNotIn(List<Integer> values) {
            addCriterion("upgrade_level not in", values, "upgradeLevel");
            return (Criteria) this;
        }

        public Criteria andUpgradeLevelBetween(Integer value1, Integer value2) {
            addCriterion("upgrade_level between", value1, value2, "upgradeLevel");
            return (Criteria) this;
        }

        public Criteria andUpgradeLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("upgrade_level not between", value1, value2, "upgradeLevel");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserIdIsNull() {
            addCriterion("upgrade_user_id is null");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserIdIsNotNull() {
            addCriterion("upgrade_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserIdEqualTo(Long value) {
            addCriterion("upgrade_user_id =", value, "upgradeUserId");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserIdNotEqualTo(Long value) {
            addCriterion("upgrade_user_id <>", value, "upgradeUserId");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserIdGreaterThan(Long value) {
            addCriterion("upgrade_user_id >", value, "upgradeUserId");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("upgrade_user_id >=", value, "upgradeUserId");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserIdLessThan(Long value) {
            addCriterion("upgrade_user_id <", value, "upgradeUserId");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserIdLessThanOrEqualTo(Long value) {
            addCriterion("upgrade_user_id <=", value, "upgradeUserId");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserIdIn(List<Long> values) {
            addCriterion("upgrade_user_id in", values, "upgradeUserId");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserIdNotIn(List<Long> values) {
            addCriterion("upgrade_user_id not in", values, "upgradeUserId");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserIdBetween(Long value1, Long value2) {
            addCriterion("upgrade_user_id between", value1, value2, "upgradeUserId");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserIdNotBetween(Long value1, Long value2) {
            addCriterion("upgrade_user_id not between", value1, value2, "upgradeUserId");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameIsNull() {
            addCriterion("upgrade_user_name is null");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameIsNotNull() {
            addCriterion("upgrade_user_name is not null");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameEqualTo(String value) {
            addCriterion("upgrade_user_name =", value, "upgradeUserName");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameNotEqualTo(String value) {
            addCriterion("upgrade_user_name <>", value, "upgradeUserName");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameGreaterThan(String value) {
            addCriterion("upgrade_user_name >", value, "upgradeUserName");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("upgrade_user_name >=", value, "upgradeUserName");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameLessThan(String value) {
            addCriterion("upgrade_user_name <", value, "upgradeUserName");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameLessThanOrEqualTo(String value) {
            addCriterion("upgrade_user_name <=", value, "upgradeUserName");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameLike(String value) {
            addCriterion("upgrade_user_name like", value, "upgradeUserName");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameNotLike(String value) {
            addCriterion("upgrade_user_name not like", value, "upgradeUserName");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameIn(List<String> values) {
            addCriterion("upgrade_user_name in", values, "upgradeUserName");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameNotIn(List<String> values) {
            addCriterion("upgrade_user_name not in", values, "upgradeUserName");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameBetween(String value1, String value2) {
            addCriterion("upgrade_user_name between", value1, value2, "upgradeUserName");
            return (Criteria) this;
        }

        public Criteria andUpgradeUserNameNotBetween(String value1, String value2) {
            addCriterion("upgrade_user_name not between", value1, value2, "upgradeUserName");
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

        public Criteria andPromoteUserIdIsNull() {
            addCriterion("promote_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPromoteUserIdIsNotNull() {
            addCriterion("promote_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPromoteUserIdEqualTo(Long value) {
            addCriterion("promote_user_id =", value, "promoteUserId");
            return (Criteria) this;
        }

        public Criteria andPromoteUserIdNotEqualTo(Long value) {
            addCriterion("promote_user_id <>", value, "promoteUserId");
            return (Criteria) this;
        }

        public Criteria andPromoteUserIdGreaterThan(Long value) {
            addCriterion("promote_user_id >", value, "promoteUserId");
            return (Criteria) this;
        }

        public Criteria andPromoteUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("promote_user_id >=", value, "promoteUserId");
            return (Criteria) this;
        }

        public Criteria andPromoteUserIdLessThan(Long value) {
            addCriterion("promote_user_id <", value, "promoteUserId");
            return (Criteria) this;
        }

        public Criteria andPromoteUserIdLessThanOrEqualTo(Long value) {
            addCriterion("promote_user_id <=", value, "promoteUserId");
            return (Criteria) this;
        }

        public Criteria andPromoteUserIdIn(List<Long> values) {
            addCriterion("promote_user_id in", values, "promoteUserId");
            return (Criteria) this;
        }

        public Criteria andPromoteUserIdNotIn(List<Long> values) {
            addCriterion("promote_user_id not in", values, "promoteUserId");
            return (Criteria) this;
        }

        public Criteria andPromoteUserIdBetween(Long value1, Long value2) {
            addCriterion("promote_user_id between", value1, value2, "promoteUserId");
            return (Criteria) this;
        }

        public Criteria andPromoteUserIdNotBetween(Long value1, Long value2) {
            addCriterion("promote_user_id not between", value1, value2, "promoteUserId");
            return (Criteria) this;
        }

        public Criteria andYearIsNull() {
            addCriterion("year is null");
            return (Criteria) this;
        }

        public Criteria andYearIsNotNull() {
            addCriterion("year is not null");
            return (Criteria) this;
        }

        public Criteria andYearEqualTo(Integer value) {
            addCriterion("year =", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotEqualTo(Integer value) {
            addCriterion("year <>", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThan(Integer value) {
            addCriterion("year >", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("year >=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThan(Integer value) {
            addCriterion("year <", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearLessThanOrEqualTo(Integer value) {
            addCriterion("year <=", value, "year");
            return (Criteria) this;
        }

        public Criteria andYearIn(List<Integer> values) {
            addCriterion("year in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotIn(List<Integer> values) {
            addCriterion("year not in", values, "year");
            return (Criteria) this;
        }

        public Criteria andYearBetween(Integer value1, Integer value2) {
            addCriterion("year between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andYearNotBetween(Integer value1, Integer value2) {
            addCriterion("year not between", value1, value2, "year");
            return (Criteria) this;
        }

        public Criteria andMonthIsNull() {
            addCriterion("month is null");
            return (Criteria) this;
        }

        public Criteria andMonthIsNotNull() {
            addCriterion("month is not null");
            return (Criteria) this;
        }

        public Criteria andMonthEqualTo(Integer value) {
            addCriterion("month =", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotEqualTo(Integer value) {
            addCriterion("month <>", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThan(Integer value) {
            addCriterion("month >", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("month >=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThan(Integer value) {
            addCriterion("month <", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthLessThanOrEqualTo(Integer value) {
            addCriterion("month <=", value, "month");
            return (Criteria) this;
        }

        public Criteria andMonthIn(List<Integer> values) {
            addCriterion("month in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotIn(List<Integer> values) {
            addCriterion("month not in", values, "month");
            return (Criteria) this;
        }

        public Criteria andMonthBetween(Integer value1, Integer value2) {
            addCriterion("month between", value1, value2, "month");
            return (Criteria) this;
        }

        public Criteria andMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("month not between", value1, value2, "month");
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