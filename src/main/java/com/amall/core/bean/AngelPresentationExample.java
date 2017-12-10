package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class AngelPresentationExample extends BaseQuery{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AngelPresentationExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andGiveContentIsNull() {
            addCriterion("give_content is null");
            return (Criteria) this;
        }

        public Criteria andGiveContentIsNotNull() {
            addCriterion("give_content is not null");
            return (Criteria) this;
        }

        public Criteria andGiveContentEqualTo(String value) {
            addCriterion("give_content =", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentNotEqualTo(String value) {
            addCriterion("give_content <>", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentGreaterThan(String value) {
            addCriterion("give_content >", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentGreaterThanOrEqualTo(String value) {
            addCriterion("give_content >=", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentLessThan(String value) {
            addCriterion("give_content <", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentLessThanOrEqualTo(String value) {
            addCriterion("give_content <=", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentLike(String value) {
            addCriterion("give_content like", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentNotLike(String value) {
            addCriterion("give_content not like", value, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentIn(List<String> values) {
            addCriterion("give_content in", values, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentNotIn(List<String> values) {
            addCriterion("give_content not in", values, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentBetween(String value1, String value2) {
            addCriterion("give_content between", value1, value2, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGiveContentNotBetween(String value1, String value2) {
            addCriterion("give_content not between", value1, value2, "giveContent");
            return (Criteria) this;
        }

        public Criteria andGetContentIsNull() {
            addCriterion("get_content is null");
            return (Criteria) this;
        }

        public Criteria andGetContentIsNotNull() {
            addCriterion("get_content is not null");
            return (Criteria) this;
        }

        public Criteria andGetContentEqualTo(String value) {
            addCriterion("get_content =", value, "getContent");
            return (Criteria) this;
        }

        public Criteria andGetContentNotEqualTo(String value) {
            addCriterion("get_content <>", value, "getContent");
            return (Criteria) this;
        }

        public Criteria andGetContentGreaterThan(String value) {
            addCriterion("get_content >", value, "getContent");
            return (Criteria) this;
        }

        public Criteria andGetContentGreaterThanOrEqualTo(String value) {
            addCriterion("get_content >=", value, "getContent");
            return (Criteria) this;
        }

        public Criteria andGetContentLessThan(String value) {
            addCriterion("get_content <", value, "getContent");
            return (Criteria) this;
        }

        public Criteria andGetContentLessThanOrEqualTo(String value) {
            addCriterion("get_content <=", value, "getContent");
            return (Criteria) this;
        }

        public Criteria andGetContentLike(String value) {
            addCriterion("get_content like", value, "getContent");
            return (Criteria) this;
        }

        public Criteria andGetContentNotLike(String value) {
            addCriterion("get_content not like", value, "getContent");
            return (Criteria) this;
        }

        public Criteria andGetContentIn(List<String> values) {
            addCriterion("get_content in", values, "getContent");
            return (Criteria) this;
        }

        public Criteria andGetContentNotIn(List<String> values) {
            addCriterion("get_content not in", values, "getContent");
            return (Criteria) this;
        }

        public Criteria andGetContentBetween(String value1, String value2) {
            addCriterion("get_content between", value1, value2, "getContent");
            return (Criteria) this;
        }

        public Criteria andGetContentNotBetween(String value1, String value2) {
            addCriterion("get_content not between", value1, value2, "getContent");
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

        public Criteria andGiveUserIdIsNull() {
            addCriterion("give_user_id is null");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdIsNotNull() {
            addCriterion("give_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdEqualTo(Long value) {
            addCriterion("give_user_id =", value, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdNotEqualTo(Long value) {
            addCriterion("give_user_id <>", value, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdGreaterThan(Long value) {
            addCriterion("give_user_id >", value, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("give_user_id >=", value, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdLessThan(Long value) {
            addCriterion("give_user_id <", value, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdLessThanOrEqualTo(Long value) {
            addCriterion("give_user_id <=", value, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdIn(List<Long> values) {
            addCriterion("give_user_id in", values, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdNotIn(List<Long> values) {
            addCriterion("give_user_id not in", values, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdBetween(Long value1, Long value2) {
            addCriterion("give_user_id between", value1, value2, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andGiveUserIdNotBetween(Long value1, Long value2) {
            addCriterion("give_user_id not between", value1, value2, "giveUserId");
            return (Criteria) this;
        }

        public Criteria andTxTimeIsNull() {
            addCriterion("tx_time is null");
            return (Criteria) this;
        }

        public Criteria andTxTimeIsNotNull() {
            addCriterion("tx_time is not null");
            return (Criteria) this;
        }

        public Criteria andTxTimeEqualTo(Date value) {
            addCriterionForJDBCDate("tx_time =", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("tx_time <>", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("tx_time >", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tx_time >=", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeLessThan(Date value) {
            addCriterionForJDBCDate("tx_time <", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("tx_time <=", value, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeIn(List<Date> values) {
            addCriterionForJDBCDate("tx_time in", values, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("tx_time not in", values, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tx_time between", value1, value2, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("tx_time not between", value1, value2, "txTime");
            return (Criteria) this;
        }

        public Criteria andTxStatusIsNull() {
            addCriterion("tx_status is null");
            return (Criteria) this;
        }

        public Criteria andTxStatusIsNotNull() {
            addCriterion("tx_status is not null");
            return (Criteria) this;
        }

        public Criteria andTxStatusEqualTo(Integer value) {
            addCriterion("tx_status =", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusNotEqualTo(Integer value) {
            addCriterion("tx_status <>", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusGreaterThan(Integer value) {
            addCriterion("tx_status >", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("tx_status >=", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusLessThan(Integer value) {
            addCriterion("tx_status <", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusLessThanOrEqualTo(Integer value) {
            addCriterion("tx_status <=", value, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusIn(List<Integer> values) {
            addCriterion("tx_status in", values, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusNotIn(List<Integer> values) {
            addCriterion("tx_status not in", values, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusBetween(Integer value1, Integer value2) {
            addCriterion("tx_status between", value1, value2, "txStatus");
            return (Criteria) this;
        }

        public Criteria andTxStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("tx_status not between", value1, value2, "txStatus");
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