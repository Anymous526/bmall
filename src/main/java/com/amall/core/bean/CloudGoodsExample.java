package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class CloudGoodsExample extends BaseQuery{
	
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CloudGoodsExample() {
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

        public Criteria andBeginTimeIsNull() {
            addCriterion("begin_time is null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIsNotNull() {
            addCriterion("begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andBeginTimeEqualTo(Date value) {
            addCriterion("begin_time =", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotEqualTo(Date value) {
            addCriterion("begin_time <>", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThan(Date value) {
            addCriterion("begin_time >", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("begin_time >=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThan(Date value) {
            addCriterion("begin_time <", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("begin_time <=", value, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeIn(List<Date> values) {
            addCriterion("begin_time in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotIn(List<Date> values) {
            addCriterion("begin_time not in", values, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeBetween(Date value1, Date value2) {
            addCriterion("begin_time between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("begin_time not between", value1, value2, "beginTime");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNull() {
            addCriterion("click_count is null");
            return (Criteria) this;
        }

        public Criteria andClickCountIsNotNull() {
            addCriterion("click_count is not null");
            return (Criteria) this;
        }

        public Criteria andClickCountEqualTo(Integer value) {
            addCriterion("click_count =", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotEqualTo(Integer value) {
            addCriterion("click_count <>", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThan(Integer value) {
            addCriterion("click_count >", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("click_count >=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThan(Integer value) {
            addCriterion("click_count <", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountLessThanOrEqualTo(Integer value) {
            addCriterion("click_count <=", value, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountIn(List<Integer> values) {
            addCriterion("click_count in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotIn(List<Integer> values) {
            addCriterion("click_count not in", values, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountBetween(Integer value1, Integer value2) {
            addCriterion("click_count between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andClickCountNotBetween(Integer value1, Integer value2) {
            addCriterion("click_count not between", value1, value2, "clickCount");
            return (Criteria) this;
        }

        public Criteria andIgContentIsNull() {
            addCriterion("ig_content is null");
            return (Criteria) this;
        }

        public Criteria andIgContentIsNotNull() {
            addCriterion("ig_content is not null");
            return (Criteria) this;
        }

        public Criteria andIgContentEqualTo(String value) {
            addCriterion("ig_content =", value, "igContent");
            return (Criteria) this;
        }

        public Criteria andIgContentNotEqualTo(String value) {
            addCriterion("ig_content <>", value, "igContent");
            return (Criteria) this;
        }

        public Criteria andIgContentGreaterThan(String value) {
            addCriterion("ig_content >", value, "igContent");
            return (Criteria) this;
        }

        public Criteria andIgContentGreaterThanOrEqualTo(String value) {
            addCriterion("ig_content >=", value, "igContent");
            return (Criteria) this;
        }

        public Criteria andIgContentLessThan(String value) {
            addCriterion("ig_content <", value, "igContent");
            return (Criteria) this;
        }

        public Criteria andIgContentLessThanOrEqualTo(String value) {
            addCriterion("ig_content <=", value, "igContent");
            return (Criteria) this;
        }

        public Criteria andIgContentLike(String value) {
            addCriterion("ig_content like", value, "igContent");
            return (Criteria) this;
        }

        public Criteria andIgContentNotLike(String value) {
            addCriterion("ig_content not like", value, "igContent");
            return (Criteria) this;
        }

        public Criteria andIgContentIn(List<String> values) {
            addCriterion("ig_content in", values, "igContent");
            return (Criteria) this;
        }

        public Criteria andIgContentNotIn(List<String> values) {
            addCriterion("ig_content not in", values, "igContent");
            return (Criteria) this;
        }

        public Criteria andIgContentBetween(String value1, String value2) {
            addCriterion("ig_content between", value1, value2, "igContent");
            return (Criteria) this;
        }

        public Criteria andIgContentNotBetween(String value1, String value2) {
            addCriterion("ig_content not between", value1, value2, "igContent");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNull() {
            addCriterion("end_time is null");
            return (Criteria) this;
        }

        public Criteria andEndTimeIsNotNull() {
            addCriterion("end_time is not null");
            return (Criteria) this;
        }

        public Criteria andEndTimeEqualTo(Date value) {
            addCriterion("end_time =", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotEqualTo(Date value) {
            addCriterion("end_time <>", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThan(Date value) {
            addCriterion("end_time >", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("end_time >=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThan(Date value) {
            addCriterion("end_time <", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("end_time <=", value, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeIn(List<Date> values) {
            addCriterion("end_time in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotIn(List<Date> values) {
            addCriterion("end_time not in", values, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeBetween(Date value1, Date value2) {
            addCriterion("end_time between", value1, value2, "endTime");
            return (Criteria) this;
        }

        public Criteria andEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("end_time not between", value1, value2, "endTime");
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

        public Criteria andGoodsCountEqualTo(Integer value) {
            addCriterion("goods_count =", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotEqualTo(Integer value) {
            addCriterion("goods_count <>", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThan(Integer value) {
            addCriterion("goods_count >", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_count >=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThan(Integer value) {
            addCriterion("goods_count <", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountLessThanOrEqualTo(Integer value) {
            addCriterion("goods_count <=", value, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountIn(List<Integer> values) {
            addCriterion("goods_count in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotIn(List<Integer> values) {
            addCriterion("goods_count not in", values, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountBetween(Integer value1, Integer value2) {
            addCriterion("goods_count between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_count not between", value1, value2, "goodsCount");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNull() {
            addCriterion("goods_number is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIsNotNull() {
            addCriterion("goods_number is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberEqualTo(Integer value) {
            addCriterion("goods_number =", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotEqualTo(Integer value) {
            addCriterion("goods_number <>", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThan(Integer value) {
            addCriterion("goods_number >", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_number >=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThan(Integer value) {
            addCriterion("goods_number <", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("goods_number <=", value, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberIn(List<Integer> values) {
            addCriterion("goods_number in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotIn(List<Integer> values) {
            addCriterion("goods_number not in", values, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberBetween(Integer value1, Integer value2) {
            addCriterion("goods_number between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_number not between", value1, value2, "goodsNumber");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNull() {
            addCriterion("goods_name is null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIsNotNull() {
            addCriterion("goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsNameEqualTo(String value) {
            addCriterion("goods_name =", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotEqualTo(String value) {
            addCriterion("goods_name <>", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThan(String value) {
            addCriterion("goods_name >", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("goods_name >=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThan(String value) {
            addCriterion("goods_name <", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("goods_name <=", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameLike(String value) {
            addCriterion("goods_name like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotLike(String value) {
            addCriterion("goods_name not like", value, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameIn(List<String> values) {
            addCriterion("goods_name in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotIn(List<String> values) {
            addCriterion("goods_name not in", values, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameBetween(String value1, String value2) {
            addCriterion("goods_name between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsNameNotBetween(String value1, String value2) {
            addCriterion("goods_name not between", value1, value2, "goodsName");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNull() {
            addCriterion("goods_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIsNotNull() {
            addCriterion("goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceEqualTo(BigDecimal value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(BigDecimal value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(BigDecimal value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(BigDecimal value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<BigDecimal> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<BigDecimal> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsSnIsNull() {
            addCriterion("goods_sn is null");
            return (Criteria) this;
        }

        public Criteria andGoodsSnIsNotNull() {
            addCriterion("goods_sn is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsSnEqualTo(String value) {
            addCriterion("goods_sn =", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnNotEqualTo(String value) {
            addCriterion("goods_sn <>", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnGreaterThan(String value) {
            addCriterion("goods_sn >", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnGreaterThanOrEqualTo(String value) {
            addCriterion("goods_sn >=", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnLessThan(String value) {
            addCriterion("goods_sn <", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnLessThanOrEqualTo(String value) {
            addCriterion("goods_sn <=", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnLike(String value) {
            addCriterion("goods_sn like", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnNotLike(String value) {
            addCriterion("goods_sn not like", value, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnIn(List<String> values) {
            addCriterion("goods_sn in", values, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnNotIn(List<String> values) {
            addCriterion("goods_sn not in", values, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnBetween(String value1, String value2) {
            addCriterion("goods_sn between", value1, value2, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsSnNotBetween(String value1, String value2) {
            addCriterion("goods_sn not between", value1, value2, "goodsSn");
            return (Criteria) this;
        }

        public Criteria andGoodsTagIsNull() {
            addCriterion("goods_tag is null");
            return (Criteria) this;
        }

        public Criteria andGoodsTagIsNotNull() {
            addCriterion("goods_tag is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsTagEqualTo(String value) {
            addCriterion("goods_tag =", value, "goodsTag");
            return (Criteria) this;
        }

        public Criteria andGoodsTagNotEqualTo(String value) {
            addCriterion("goods_tag <>", value, "goodsTag");
            return (Criteria) this;
        }

        public Criteria andGoodsTagGreaterThan(String value) {
            addCriterion("goods_tag >", value, "goodsTag");
            return (Criteria) this;
        }

        public Criteria andGoodsTagGreaterThanOrEqualTo(String value) {
            addCriterion("goods_tag >=", value, "goodsTag");
            return (Criteria) this;
        }

        public Criteria andGoodsTagLessThan(String value) {
            addCriterion("goods_tag <", value, "goodsTag");
            return (Criteria) this;
        }

        public Criteria andGoodsTagLessThanOrEqualTo(String value) {
            addCriterion("goods_tag <=", value, "goodsTag");
            return (Criteria) this;
        }

        public Criteria andGoodsTagLike(String value) {
            addCriterion("goods_tag like", value, "goodsTag");
            return (Criteria) this;
        }

        public Criteria andGoodsTagNotLike(String value) {
            addCriterion("goods_tag not like", value, "goodsTag");
            return (Criteria) this;
        }

        public Criteria andGoodsTagIn(List<String> values) {
            addCriterion("goods_tag in", values, "goodsTag");
            return (Criteria) this;
        }

        public Criteria andGoodsTagNotIn(List<String> values) {
            addCriterion("goods_tag not in", values, "goodsTag");
            return (Criteria) this;
        }

        public Criteria andGoodsTagBetween(String value1, String value2) {
            addCriterion("goods_tag between", value1, value2, "goodsTag");
            return (Criteria) this;
        }

        public Criteria andGoodsTagNotBetween(String value1, String value2) {
            addCriterion("goods_tag not between", value1, value2, "goodsTag");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Boolean value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Boolean value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Boolean value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Boolean value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Boolean value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Boolean> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Boolean> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Boolean value1, Boolean value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIdIsNull() {
            addCriterion("goods_img_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIdIsNotNull() {
            addCriterion("goods_img_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIdEqualTo(Long value) {
            addCriterion("goods_img_id =", value, "goodsImgId");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIdNotEqualTo(Long value) {
            addCriterion("goods_img_id <>", value, "goodsImgId");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIdGreaterThan(Long value) {
            addCriterion("goods_img_id >", value, "goodsImgId");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_img_id >=", value, "goodsImgId");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIdLessThan(Long value) {
            addCriterion("goods_img_id <", value, "goodsImgId");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_img_id <=", value, "goodsImgId");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIdIn(List<Long> values) {
            addCriterion("goods_img_id in", values, "goodsImgId");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIdNotIn(List<Long> values) {
            addCriterion("goods_img_id not in", values, "goodsImgId");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIdBetween(Long value1, Long value2) {
            addCriterion("goods_img_id between", value1, value2, "goodsImgId");
            return (Criteria) this;
        }

        public Criteria andGoodsImgIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_img_id not between", value1, value2, "goodsImgId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdIsNull() {
            addCriterion("goods_class_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdIsNotNull() {
            addCriterion("goods_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdEqualTo(Long value) {
            addCriterion("goods_class_id =", value, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdNotEqualTo(Long value) {
            addCriterion("goods_class_id <>", value, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdGreaterThan(Long value) {
            addCriterion("goods_class_id >", value, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_class_id >=", value, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdLessThan(Long value) {
            addCriterion("goods_class_id <", value, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_class_id <=", value, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdIn(List<Long> values) {
            addCriterion("goods_class_id in", values, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdNotIn(List<Long> values) {
            addCriterion("goods_class_id not in", values, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdBetween(Long value1, Long value2) {
            addCriterion("goods_class_id between", value1, value2, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsClassIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_class_id not between", value1, value2, "goodsClassId");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListIsNull() {
            addCriterion("goods_pack_list is null");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListIsNotNull() {
            addCriterion("goods_pack_list is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListEqualTo(String value) {
            addCriterion("goods_pack_list =", value, "goodsPackList");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListNotEqualTo(String value) {
            addCriterion("goods_pack_list <>", value, "goodsPackList");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListGreaterThan(String value) {
            addCriterion("goods_pack_list >", value, "goodsPackList");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListGreaterThanOrEqualTo(String value) {
            addCriterion("goods_pack_list >=", value, "goodsPackList");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListLessThan(String value) {
            addCriterion("goods_pack_list <", value, "goodsPackList");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListLessThanOrEqualTo(String value) {
            addCriterion("goods_pack_list <=", value, "goodsPackList");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListLike(String value) {
            addCriterion("goods_pack_list like", value, "goodsPackList");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListNotLike(String value) {
            addCriterion("goods_pack_list not like", value, "goodsPackList");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListIn(List<String> values) {
            addCriterion("goods_pack_list in", values, "goodsPackList");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListNotIn(List<String> values) {
            addCriterion("goods_pack_list not in", values, "goodsPackList");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListBetween(String value1, String value2) {
            addCriterion("goods_pack_list between", value1, value2, "goodsPackList");
            return (Criteria) this;
        }

        public Criteria andGoodsPackListNotBetween(String value1, String value2) {
            addCriterion("goods_pack_list not between", value1, value2, "goodsPackList");
            return (Criteria) this;
        }

        public Criteria andIsPassedIsNull() {
            addCriterion("is_passed is null");
            return (Criteria) this;
        }

        public Criteria andIsPassedIsNotNull() {
            addCriterion("is_passed is not null");
            return (Criteria) this;
        }

        public Criteria andIsPassedEqualTo(Boolean value) {
            addCriterion("is_passed =", value, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedNotEqualTo(Boolean value) {
            addCriterion("is_passed <>", value, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedGreaterThan(Boolean value) {
            addCriterion("is_passed >", value, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_passed >=", value, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedLessThan(Boolean value) {
            addCriterion("is_passed <", value, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_passed <=", value, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedIn(List<Boolean> values) {
            addCriterion("is_passed in", values, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedNotIn(List<Boolean> values) {
            addCriterion("is_passed not in", values, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_passed between", value1, value2, "isPassed");
            return (Criteria) this;
        }

        public Criteria andIsPassedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_passed not between", value1, value2, "isPassed");
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

        public Criteria andOpenWinnerTimeIsNull() {
            addCriterion("open_winner_time is null");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerTimeIsNotNull() {
            addCriterion("open_winner_time is not null");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerTimeEqualTo(Date value) {
            addCriterion("open_winner_time =", value, "openWinnerTime");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerTimeNotEqualTo(Date value) {
            addCriterion("open_winner_time <>", value, "openWinnerTime");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerTimeGreaterThan(Date value) {
            addCriterion("open_winner_time >", value, "openWinnerTime");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("open_winner_time >=", value, "openWinnerTime");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerTimeLessThan(Date value) {
            addCriterion("open_winner_time <", value, "openWinnerTime");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerTimeLessThanOrEqualTo(Date value) {
            addCriterion("open_winner_time <=", value, "openWinnerTime");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerTimeIn(List<Date> values) {
            addCriterion("open_winner_time in", values, "openWinnerTime");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerTimeNotIn(List<Date> values) {
            addCriterion("open_winner_time not in", values, "openWinnerTime");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerTimeBetween(Date value1, Date value2) {
            addCriterion("open_winner_time between", value1, value2, "openWinnerTime");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerTimeNotBetween(Date value1, Date value2) {
            addCriterion("open_winner_time not between", value1, value2, "openWinnerTime");
            return (Criteria) this;
        }
        public Criteria andExchangeLimitIsNull() {
            addCriterion("exchange_limit is null");
            return (Criteria) this;
        }

        public Criteria andExchangeLimitIsNotNull() {
            addCriterion("exchange_limit is not null");
            return (Criteria) this;
        }

        public Criteria andExchangeLimitEqualTo(Integer value) {
            addCriterion("exchange_limit =", value, "exchangeLimit");
            return (Criteria) this;
        }

        public Criteria andExchangeLimitNotEqualTo(Integer value) {
            addCriterion("exchange_limit <>", value, "exchangeLimit");
            return (Criteria) this;
        }

        public Criteria andExchangeLimitGreaterThan(Integer value) {
            addCriterion("exchange_limit >", value, "exchangeLimit");
            return (Criteria) this;
        }

        public Criteria andExchangeLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("exchange_limit >=", value, "exchangeLimit");
            return (Criteria) this;
        }

        public Criteria andExchangeLimitLessThan(Integer value) {
            addCriterion("exchange_limit <", value, "exchangeLimit");
            return (Criteria) this;
        }

        public Criteria andExchangeLimitLessThanOrEqualTo(Integer value) {
            addCriterion("exchange_limit <=", value, "exchangeLimit");
            return (Criteria) this;
        }

        public Criteria andExchangeLimitIn(List<Integer> values) {
            addCriterion("exchange_limit in", values, "exchangeLimit");
            return (Criteria) this;
        }

        public Criteria andExchangeLimitNotIn(List<Integer> values) {
            addCriterion("exchange_limit not in", values, "exchangeLimit");
            return (Criteria) this;
        }

        public Criteria andExchangeLimitBetween(Integer value1, Integer value2) {
            addCriterion("exchange_limit between", value1, value2, "exchangeLimit");
            return (Criteria) this;
        }

        public Criteria andExchangeLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("exchange_limit not between", value1, value2, "exchangeLimit");
            return (Criteria) this;
        }

        public Criteria andBuyerCodeCountIsNull() {
            addCriterion("buyer_code_count is null");
            return (Criteria) this;
        }

        public Criteria andBuyerCodeCountIsNotNull() {
            addCriterion("buyer_code_count is not null");
            return (Criteria) this;
        }

        public Criteria andBuyerCodeCountEqualTo(Integer value) {
            addCriterion("buyer_code_count =", value, "buyerCodeCount");
            return (Criteria) this;
        }

        public Criteria andBuyerCodeCountNotEqualTo(Integer value) {
            addCriterion("buyer_code_count <>", value, "buyerCodeCount");
            return (Criteria) this;
        }

        public Criteria andBuyerCodeCountGreaterThan(Integer value) {
            addCriterion("buyer_code_count >", value, "buyerCodeCount");
            return (Criteria) this;
        }

        public Criteria andBuyerCodeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("buyer_code_count >=", value, "buyerCodeCount");
            return (Criteria) this;
        }

        public Criteria andBuyerCodeCountLessThan(Integer value) {
            addCriterion("buyer_code_count <", value, "buyerCodeCount");
            return (Criteria) this;
        }

        public Criteria andBuyerCodeCountLessThanOrEqualTo(Integer value) {
            addCriterion("buyer_code_count <=", value, "buyerCodeCount");
            return (Criteria) this;
        }

        public Criteria andBuyerCodeCountIn(List<Integer> values) {
            addCriterion("buyer_code_count in", values, "buyerCodeCount");
            return (Criteria) this;
        }

        public Criteria andBuyerCodeCountNotIn(List<Integer> values) {
            addCriterion("buyer_code_count not in", values, "buyerCodeCount");
            return (Criteria) this;
        }

        public Criteria andBuyerCodeCountBetween(Integer value1, Integer value2) {
            addCriterion("buyer_code_count between", value1, value2, "buyerCodeCount");
            return (Criteria) this;
        }

        public Criteria andBuyerCodeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("buyer_code_count not between", value1, value2, "buyerCodeCount");
            return (Criteria) this;
        }
        public Criteria andOpenWinnerCodeIsNull() {
            addCriterion("open_winner_code is null");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerCodeIsNotNull() {
            addCriterion("open_winner_code is not null");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerCodeEqualTo(Integer value) {
            addCriterion("open_winner_code =", value, "openWinnerCode");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerCodeNotEqualTo(Integer value) {
            addCriterion("open_winner_code <>", value, "openWinnerCode");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerCodeGreaterThan(Integer value) {
            addCriterion("open_winner_code >", value, "openWinnerCode");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerCodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_winner_code >=", value, "openWinnerCode");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerCodeLessThan(Integer value) {
            addCriterion("open_winner_code <", value, "openWinnerCode");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerCodeLessThanOrEqualTo(Integer value) {
            addCriterion("open_winner_code <=", value, "openWinnerCode");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerCodeIn(List<Integer> values) {
            addCriterion("open_winner_code in", values, "openWinnerCode");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerCodeNotIn(List<Integer> values) {
            addCriterion("open_winner_code not in", values, "openWinnerCode");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerCodeBetween(Integer value1, Integer value2) {
            addCriterion("open_winner_code between", value1, value2, "openWinnerCode");
            return (Criteria) this;
        }

        public Criteria andOpenWinnerCodeNotBetween(Integer value1, Integer value2) {
            addCriterion("open_winner_code not between", value1, value2, "openWinnerCode");
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