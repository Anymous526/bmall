package com.amall.core.bean;

import java.util.ArrayList;
import java.util.List;

public class SmsVerificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsVerificationExample() {
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

        public Criteria andSmsPhoneIsNull() {
            addCriterion("sms_phone is null");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneIsNotNull() {
            addCriterion("sms_phone is not null");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneEqualTo(String value) {
            addCriterion("sms_phone =", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneNotEqualTo(String value) {
            addCriterion("sms_phone <>", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneGreaterThan(String value) {
            addCriterion("sms_phone >", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("sms_phone >=", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneLessThan(String value) {
            addCriterion("sms_phone <", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneLessThanOrEqualTo(String value) {
            addCriterion("sms_phone <=", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneLike(String value) {
            addCriterion("sms_phone like", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneNotLike(String value) {
            addCriterion("sms_phone not like", value, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneIn(List<String> values) {
            addCriterion("sms_phone in", values, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneNotIn(List<String> values) {
            addCriterion("sms_phone not in", values, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneBetween(String value1, String value2) {
            addCriterion("sms_phone between", value1, value2, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsPhoneNotBetween(String value1, String value2) {
            addCriterion("sms_phone not between", value1, value2, "smsPhone");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateIsNull() {
            addCriterion("sms_create_date is null");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateIsNotNull() {
            addCriterion("sms_create_date is not null");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateEqualTo(String value) {
            addCriterion("sms_create_date =", value, "smsCreateDate");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateNotEqualTo(String value) {
            addCriterion("sms_create_date <>", value, "smsCreateDate");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateGreaterThan(String value) {
            addCriterion("sms_create_date >", value, "smsCreateDate");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateGreaterThanOrEqualTo(String value) {
            addCriterion("sms_create_date >=", value, "smsCreateDate");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateLessThan(String value) {
            addCriterion("sms_create_date <", value, "smsCreateDate");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateLessThanOrEqualTo(String value) {
            addCriterion("sms_create_date <=", value, "smsCreateDate");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateLike(String value) {
            addCriterion("sms_create_date like", value, "smsCreateDate");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateNotLike(String value) {
            addCriterion("sms_create_date not like", value, "smsCreateDate");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateIn(List<String> values) {
            addCriterion("sms_create_date in", values, "smsCreateDate");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateNotIn(List<String> values) {
            addCriterion("sms_create_date not in", values, "smsCreateDate");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateBetween(String value1, String value2) {
            addCriterion("sms_create_date between", value1, value2, "smsCreateDate");
            return (Criteria) this;
        }

        public Criteria andSmsCreateDateNotBetween(String value1, String value2) {
            addCriterion("sms_create_date not between", value1, value2, "smsCreateDate");
            return (Criteria) this;
        }

        public Criteria andSmsCountIsNull() {
            addCriterion("sms_count is null");
            return (Criteria) this;
        }

        public Criteria andSmsCountIsNotNull() {
            addCriterion("sms_count is not null");
            return (Criteria) this;
        }

        public Criteria andSmsCountEqualTo(Integer value) {
            addCriterion("sms_count =", value, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountNotEqualTo(Integer value) {
            addCriterion("sms_count <>", value, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountGreaterThan(Integer value) {
            addCriterion("sms_count >", value, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("sms_count >=", value, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountLessThan(Integer value) {
            addCriterion("sms_count <", value, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountLessThanOrEqualTo(Integer value) {
            addCriterion("sms_count <=", value, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountIn(List<Integer> values) {
            addCriterion("sms_count in", values, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountNotIn(List<Integer> values) {
            addCriterion("sms_count not in", values, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountBetween(Integer value1, Integer value2) {
            addCriterion("sms_count between", value1, value2, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("sms_count not between", value1, value2, "smsCount");
            return (Criteria) this;
        }

        public Criteria andSmsCodeIsNull() {
            addCriterion("sms_code is null");
            return (Criteria) this;
        }

        public Criteria andSmsCodeIsNotNull() {
            addCriterion("sms_code is not null");
            return (Criteria) this;
        }

        public Criteria andSmsCodeEqualTo(String value) {
            addCriterion("sms_code =", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeNotEqualTo(String value) {
            addCriterion("sms_code <>", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeGreaterThan(String value) {
            addCriterion("sms_code >", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeGreaterThanOrEqualTo(String value) {
            addCriterion("sms_code >=", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeLessThan(String value) {
            addCriterion("sms_code <", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeLessThanOrEqualTo(String value) {
            addCriterion("sms_code <=", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeLike(String value) {
            addCriterion("sms_code like", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeNotLike(String value) {
            addCriterion("sms_code not like", value, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeIn(List<String> values) {
            addCriterion("sms_code in", values, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeNotIn(List<String> values) {
            addCriterion("sms_code not in", values, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeBetween(String value1, String value2) {
            addCriterion("sms_code between", value1, value2, "smsCode");
            return (Criteria) this;
        }

        public Criteria andSmsCodeNotBetween(String value1, String value2) {
            addCriterion("sms_code not between", value1, value2, "smsCode");
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