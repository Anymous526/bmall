package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class IntegralGoodsExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntegralGoodsExample() {
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

    public boolean getDistinct() {
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

        public Criteria andIgBeginTimeIsNull() {
            addCriterion("ig_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andIgBeginTimeIsNotNull() {
            addCriterion("ig_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andIgBeginTimeEqualTo(Date value) {
            addCriterion("ig_begin_time =", value, "igBeginTime");
            return (Criteria) this;
        }
        
        /**
         * 
         * @author wsw
         * @date 2015年7月10日 上午11:06:37
         * @return Criteria
         * @param value
         * @return
         */
        public Criteria andIgGcIdEqualTo(Long value) {
            addCriterion("ig_gc_id =", value, "igGcId");
            return (Criteria) this;
        }
        

        public Criteria andIgBeginTimeNotEqualTo(Date value) {
            addCriterion("ig_begin_time <>", value, "igBeginTime");
            return (Criteria) this;
        }

        public Criteria andIgBeginTimeGreaterThan(Date value) {
            addCriterion("ig_begin_time >", value, "igBeginTime");
            return (Criteria) this;
        }

        public Criteria andIgBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ig_begin_time >=", value, "igBeginTime");
            return (Criteria) this;
        }

        public Criteria andIgBeginTimeLessThan(Date value) {
            addCriterion("ig_begin_time <", value, "igBeginTime");
            return (Criteria) this;
        }

        public Criteria andIgBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("ig_begin_time <=", value, "igBeginTime");
            return (Criteria) this;
        }

        public Criteria andIgBeginTimeIn(List<Date> values) {
            addCriterion("ig_begin_time in", values, "igBeginTime");
            return (Criteria) this;
        }

        public Criteria andIgBeginTimeNotIn(List<Date> values) {
            addCriterion("ig_begin_time not in", values, "igBeginTime");
            return (Criteria) this;
        }

        public Criteria andIgBeginTimeBetween(Date value1, Date value2) {
            addCriterion("ig_begin_time between", value1, value2, "igBeginTime");
            return (Criteria) this;
        }

        public Criteria andIgBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("ig_begin_time not between", value1, value2, "igBeginTime");
            return (Criteria) this;
        }

        public Criteria andIgClickCountIsNull() {
            addCriterion("ig_click_count is null");
            return (Criteria) this;
        }

        public Criteria andIgClickCountIsNotNull() {
            addCriterion("ig_click_count is not null");
            return (Criteria) this;
        }

        public Criteria andIgClickCountEqualTo(Integer value) {
            addCriterion("ig_click_count =", value, "igClickCount");
            return (Criteria) this;
        }

        public Criteria andIgClickCountNotEqualTo(Integer value) {
            addCriterion("ig_click_count <>", value, "igClickCount");
            return (Criteria) this;
        }

        public Criteria andIgClickCountGreaterThan(Integer value) {
            addCriterion("ig_click_count >", value, "igClickCount");
            return (Criteria) this;
        }

        public Criteria andIgClickCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ig_click_count >=", value, "igClickCount");
            return (Criteria) this;
        }

        public Criteria andIgClickCountLessThan(Integer value) {
            addCriterion("ig_click_count <", value, "igClickCount");
            return (Criteria) this;
        }

        public Criteria andIgClickCountLessThanOrEqualTo(Integer value) {
            addCriterion("ig_click_count <=", value, "igClickCount");
            return (Criteria) this;
        }

        public Criteria andIgClickCountIn(List<Integer> values) {
            addCriterion("ig_click_count in", values, "igClickCount");
            return (Criteria) this;
        }

        public Criteria andIgClickCountNotIn(List<Integer> values) {
            addCriterion("ig_click_count not in", values, "igClickCount");
            return (Criteria) this;
        }

        public Criteria andIgClickCountBetween(Integer value1, Integer value2) {
            addCriterion("ig_click_count between", value1, value2, "igClickCount");
            return (Criteria) this;
        }

        public Criteria andIgClickCountNotBetween(Integer value1, Integer value2) {
            addCriterion("ig_click_count not between", value1, value2, "igClickCount");
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

        public Criteria andIgEndTimeIsNull() {
            addCriterion("ig_end_time is null");
            return (Criteria) this;
        }

        public Criteria andIgEndTimeIsNotNull() {
            addCriterion("ig_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andIgEndTimeEqualTo(Date value) {
            addCriterion("ig_end_time =", value, "igEndTime");
            return (Criteria) this;
        }

        public Criteria andIgEndTimeNotEqualTo(Date value) {
            addCriterion("ig_end_time <>", value, "igEndTime");
            return (Criteria) this;
        }

        public Criteria andIgEndTimeGreaterThan(Date value) {
            addCriterion("ig_end_time >", value, "igEndTime");
            return (Criteria) this;
        }

        public Criteria andIgEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ig_end_time >=", value, "igEndTime");
            return (Criteria) this;
        }

        public Criteria andIgEndTimeLessThan(Date value) {
            addCriterion("ig_end_time <", value, "igEndTime");
            return (Criteria) this;
        }

        public Criteria andIgEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("ig_end_time <=", value, "igEndTime");
            return (Criteria) this;
        }

        public Criteria andIgEndTimeIn(List<Date> values) {
            addCriterion("ig_end_time in", values, "igEndTime");
            return (Criteria) this;
        }

        public Criteria andIgEndTimeNotIn(List<Date> values) {
            addCriterion("ig_end_time not in", values, "igEndTime");
            return (Criteria) this;
        }

        public Criteria andIgEndTimeBetween(Date value1, Date value2) {
            addCriterion("ig_end_time between", value1, value2, "igEndTime");
            return (Criteria) this;
        }

        public Criteria andIgEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("ig_end_time not between", value1, value2, "igEndTime");
            return (Criteria) this;
        }

        public Criteria andIgExchangeCountIsNull() {
            addCriterion("ig_exchange_count is null");
            return (Criteria) this;
        }

        public Criteria andIgExchangeCountIsNotNull() {
            addCriterion("ig_exchange_count is not null");
            return (Criteria) this;
        }

        public Criteria andIgExchangeCountEqualTo(Integer value) {
            addCriterion("ig_exchange_count =", value, "igExchangeCount");
            return (Criteria) this;
        }

        public Criteria andIgExchangeCountNotEqualTo(Integer value) {
            addCriterion("ig_exchange_count <>", value, "igExchangeCount");
            return (Criteria) this;
        }

        public Criteria andIgExchangeCountGreaterThan(Integer value) {
            addCriterion("ig_exchange_count >", value, "igExchangeCount");
            return (Criteria) this;
        }

        public Criteria andIgExchangeCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ig_exchange_count >=", value, "igExchangeCount");
            return (Criteria) this;
        }

        public Criteria andIgExchangeCountLessThan(Integer value) {
            addCriterion("ig_exchange_count <", value, "igExchangeCount");
            return (Criteria) this;
        }

        public Criteria andIgExchangeCountLessThanOrEqualTo(Integer value) {
            addCriterion("ig_exchange_count <=", value, "igExchangeCount");
            return (Criteria) this;
        }

        public Criteria andIgExchangeCountIn(List<Integer> values) {
            addCriterion("ig_exchange_count in", values, "igExchangeCount");
            return (Criteria) this;
        }

        public Criteria andIgExchangeCountNotIn(List<Integer> values) {
            addCriterion("ig_exchange_count not in", values, "igExchangeCount");
            return (Criteria) this;
        }

        public Criteria andIgExchangeCountBetween(Integer value1, Integer value2) {
            addCriterion("ig_exchange_count between", value1, value2, "igExchangeCount");
            return (Criteria) this;
        }

        public Criteria andIgExchangeCountNotBetween(Integer value1, Integer value2) {
            addCriterion("ig_exchange_count not between", value1, value2, "igExchangeCount");
            return (Criteria) this;
        }

        public Criteria andIgGoodsCountIsNull() {
            addCriterion("ig_goods_count is null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsCountIsNotNull() {
            addCriterion("ig_goods_count is not null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsCountEqualTo(Integer value) {
            addCriterion("ig_goods_count =", value, "igGoodsCount");
            return (Criteria) this;
        }

        public Criteria andIgGoodsCountNotEqualTo(Integer value) {
            addCriterion("ig_goods_count <>", value, "igGoodsCount");
            return (Criteria) this;
        }

        public Criteria andIgGoodsCountGreaterThan(Integer value) {
            addCriterion("ig_goods_count >", value, "igGoodsCount");
            return (Criteria) this;
        }

        public Criteria andIgGoodsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ig_goods_count >=", value, "igGoodsCount");
            return (Criteria) this;
        }

        public Criteria andIgGoodsCountLessThan(Integer value) {
            addCriterion("ig_goods_count <", value, "igGoodsCount");
            return (Criteria) this;
        }

        public Criteria andIgGoodsCountLessThanOrEqualTo(Integer value) {
            addCriterion("ig_goods_count <=", value, "igGoodsCount");
            return (Criteria) this;
        }

        public Criteria andIgGoodsCountIn(List<Integer> values) {
            addCriterion("ig_goods_count in", values, "igGoodsCount");
            return (Criteria) this;
        }

        public Criteria andIgGoodsCountNotIn(List<Integer> values) {
            addCriterion("ig_goods_count not in", values, "igGoodsCount");
            return (Criteria) this;
        }

        public Criteria andIgGoodsCountBetween(Integer value1, Integer value2) {
            addCriterion("ig_goods_count between", value1, value2, "igGoodsCount");
            return (Criteria) this;
        }

        public Criteria andIgGoodsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("ig_goods_count not between", value1, value2, "igGoodsCount");
            return (Criteria) this;
        }

        public Criteria andIgGoodsIntegralIsNull() {
            addCriterion("ig_goods_integral is null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsIntegralIsNotNull() {
            addCriterion("ig_goods_integral is not null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsIntegralEqualTo(Integer value) {
            addCriterion("ig_goods_integral =", value, "igGoodsIntegral");
            return (Criteria) this;
        }

        public Criteria andIgGoodsIntegralNotEqualTo(Integer value) {
            addCriterion("ig_goods_integral <>", value, "igGoodsIntegral");
            return (Criteria) this;
        }

        public Criteria andIgGoodsIntegralGreaterThan(Integer value) {
            addCriterion("ig_goods_integral >", value, "igGoodsIntegral");
            return (Criteria) this;
        }

        public Criteria andIgGoodsIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("ig_goods_integral >=", value, "igGoodsIntegral");
            return (Criteria) this;
        }

        public Criteria andIgGoodsIntegralLessThan(Integer value) {
            addCriterion("ig_goods_integral <", value, "igGoodsIntegral");
            return (Criteria) this;
        }

        public Criteria andIgGoodsIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("ig_goods_integral <=", value, "igGoodsIntegral");
            return (Criteria) this;
        }

        public Criteria andIgGoodsIntegralIn(List<Integer> values) {
            addCriterion("ig_goods_integral in", values, "igGoodsIntegral");
            return (Criteria) this;
        }

        public Criteria andIgGoodsIntegralNotIn(List<Integer> values) {
            addCriterion("ig_goods_integral not in", values, "igGoodsIntegral");
            return (Criteria) this;
        }

        public Criteria andIgGoodsIntegralBetween(Integer value1, Integer value2) {
            addCriterion("ig_goods_integral between", value1, value2, "igGoodsIntegral");
            return (Criteria) this;
        }

        public Criteria andIgGoodsIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("ig_goods_integral not between", value1, value2, "igGoodsIntegral");
            return (Criteria) this;
        }
        
        
        
        
        
        
        
        public Criteria andIgGoodsGoldNumIsNull() {
        	addCriterion("igGoodsGoldNum is null");
        	return (Criteria) this;
        }
        
        public Criteria andIgGoodsGoldNumIsNotNull() {
        	addCriterion("igGoodsGoldNum is not null");
        	return (Criteria) this;
        }
        
        public Criteria andIgGoodsGoldNumEqualTo(Integer value) {
        	addCriterion("igGoodsGoldNum =", value, "igGoodsGoldNum");
        	return (Criteria) this;
        }
        
        public Criteria andIgGoodsGoldNumNotEqualTo(Integer value) {
        	addCriterion("igGoodsGoldNum <>", value, "igGoodsGoldNum");
        	return (Criteria) this;
        }
        
        public Criteria andIgGoodsGoldNumGreaterThan(Integer value) {
        	addCriterion("igGoodsGoldNum >", value, "igGoodsGoldNum");
        	return (Criteria) this;
        }
        
        public Criteria andIgGoodsGoldNumGreaterThanOrEqualTo(Integer value) {
        	addCriterion("igGoodsGoldNum >=", value, "igGoodsGoldNum");
        	return (Criteria) this;
        }
        
        public Criteria andIgGoodsGoldNumLessThan(Integer value) {
        	addCriterion("igGoodsGoldNum <", value, "igGoodsGoldNum");
        	return (Criteria) this;
        }
        
        public Criteria andIgGoodsGoldNumLessThanOrEqualTo(Integer value) {
        	addCriterion("igGoodsGoldNum <=", value, "igGoodsGoldNum");
        	return (Criteria) this;
        }
        
        public Criteria andIgGoodsGoldNumIn(List<Integer> values) {
        	addCriterion("igGoodsGoldNum in", values, "igGoodsGoldNum");
        	return (Criteria) this;
        }
        
        public Criteria andIgGoodsGoldNumNotIn(List<Integer> values) {
        	addCriterion("igGoodsGoldNum not in", values, "igGoodsGoldNum");
        	return (Criteria) this;
        }
        
        public Criteria andIgGoodsGoldNumBetween(Integer value1, Integer value2) {
        	addCriterion("igGoodsGoldNum between", value1, value2, "igGoodsGoldNum");
        	return (Criteria) this;
        }
        
        public Criteria andIgGoodsGoldNumNotBetween(Integer value1, Integer value2) {
        	addCriterion("igGoodsGoldNum not between", value1, value2, "igGoodsGoldNum");
        	return (Criteria) this;
        }

        public Criteria andIgGoodsNameIsNull() {
            addCriterion("ig_goods_name is null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsNameIsNotNull() {
            addCriterion("ig_goods_name is not null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsNameEqualTo(String value) {
            addCriterion("ig_goods_name =", value, "igGoodsName");
            return (Criteria) this;
        }

        public Criteria andIgGoodsNameNotEqualTo(String value) {
            addCriterion("ig_goods_name <>", value, "igGoodsName");
            return (Criteria) this;
        }

        public Criteria andIgGoodsNameGreaterThan(String value) {
            addCriterion("ig_goods_name >", value, "igGoodsName");
            return (Criteria) this;
        }

        public Criteria andIgGoodsNameGreaterThanOrEqualTo(String value) {
            addCriterion("ig_goods_name >=", value, "igGoodsName");
            return (Criteria) this;
        }

        public Criteria andIgGoodsNameLessThan(String value) {
            addCriterion("ig_goods_name <", value, "igGoodsName");
            return (Criteria) this;
        }

        public Criteria andIgGoodsNameLessThanOrEqualTo(String value) {
            addCriterion("ig_goods_name <=", value, "igGoodsName");
            return (Criteria) this;
        }

        public Criteria andIgGoodsNameLike(String value) {
            addCriterion("ig_goods_name like", value, "igGoodsName");
            return (Criteria) this;
        }

        public Criteria andIgGoodsNameNotLike(String value) {
            addCriterion("ig_goods_name not like", value, "igGoodsName");
            return (Criteria) this;
        }

        public Criteria andIgGoodsNameIn(List<String> values) {
            addCriterion("ig_goods_name in", values, "igGoodsName");
            return (Criteria) this;
        }

        public Criteria andIgGoodsNameNotIn(List<String> values) {
            addCriterion("ig_goods_name not in", values, "igGoodsName");
            return (Criteria) this;
        }

        public Criteria andIgGoodsNameBetween(String value1, String value2) {
            addCriterion("ig_goods_name between", value1, value2, "igGoodsName");
            return (Criteria) this;
        }

        public Criteria andIgGoodsNameNotBetween(String value1, String value2) {
            addCriterion("ig_goods_name not between", value1, value2, "igGoodsName");
            return (Criteria) this;
        }

        public Criteria andIgGoodsPriceIsNull() {
            addCriterion("ig_goods_price is null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsPriceIsNotNull() {
            addCriterion("ig_goods_price is not null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsPriceEqualTo(BigDecimal value) {
            addCriterion("ig_goods_price =", value, "igGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andIgGoodsPriceNotEqualTo(BigDecimal value) {
            addCriterion("ig_goods_price <>", value, "igGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andIgGoodsPriceGreaterThan(BigDecimal value) {
            addCriterion("ig_goods_price >", value, "igGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andIgGoodsPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ig_goods_price >=", value, "igGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andIgGoodsPriceLessThan(BigDecimal value) {
            addCriterion("ig_goods_price <", value, "igGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andIgGoodsPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ig_goods_price <=", value, "igGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andIgGoodsPriceIn(List<BigDecimal> values) {
            addCriterion("ig_goods_price in", values, "igGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andIgGoodsPriceNotIn(List<BigDecimal> values) {
            addCriterion("ig_goods_price not in", values, "igGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andIgGoodsPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ig_goods_price between", value1, value2, "igGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andIgGoodsPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ig_goods_price not between", value1, value2, "igGoodsPrice");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnIsNull() {
            addCriterion("ig_goods_sn is null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnIsNotNull() {
            addCriterion("ig_goods_sn is not null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnEqualTo(String value) {
            addCriterion("ig_goods_sn =", value, "igGoodsSn");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnNotEqualTo(String value) {
            addCriterion("ig_goods_sn <>", value, "igGoodsSn");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnGreaterThan(String value) {
            addCriterion("ig_goods_sn >", value, "igGoodsSn");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnGreaterThanOrEqualTo(String value) {
            addCriterion("ig_goods_sn >=", value, "igGoodsSn");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnLessThan(String value) {
            addCriterion("ig_goods_sn <", value, "igGoodsSn");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnLessThanOrEqualTo(String value) {
            addCriterion("ig_goods_sn <=", value, "igGoodsSn");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnLike(String value) {
            addCriterion("ig_goods_sn like", value, "igGoodsSn");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnNotLike(String value) {
            addCriterion("ig_goods_sn not like", value, "igGoodsSn");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnIn(List<String> values) {
            addCriterion("ig_goods_sn in", values, "igGoodsSn");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnNotIn(List<String> values) {
            addCriterion("ig_goods_sn not in", values, "igGoodsSn");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnBetween(String value1, String value2) {
            addCriterion("ig_goods_sn between", value1, value2, "igGoodsSn");
            return (Criteria) this;
        }

        public Criteria andIgGoodsSnNotBetween(String value1, String value2) {
            addCriterion("ig_goods_sn not between", value1, value2, "igGoodsSn");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagIsNull() {
            addCriterion("ig_goods_tag is null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagIsNotNull() {
            addCriterion("ig_goods_tag is not null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagEqualTo(String value) {
            addCriterion("ig_goods_tag =", value, "igGoodsTag");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagNotEqualTo(String value) {
            addCriterion("ig_goods_tag <>", value, "igGoodsTag");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagGreaterThan(String value) {
            addCriterion("ig_goods_tag >", value, "igGoodsTag");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagGreaterThanOrEqualTo(String value) {
            addCriterion("ig_goods_tag >=", value, "igGoodsTag");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagLessThan(String value) {
            addCriterion("ig_goods_tag <", value, "igGoodsTag");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagLessThanOrEqualTo(String value) {
            addCriterion("ig_goods_tag <=", value, "igGoodsTag");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagLike(String value) {
            addCriterion("ig_goods_tag like", value, "igGoodsTag");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagNotLike(String value) {
            addCriterion("ig_goods_tag not like", value, "igGoodsTag");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagIn(List<String> values) {
            addCriterion("ig_goods_tag in", values, "igGoodsTag");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagNotIn(List<String> values) {
            addCriterion("ig_goods_tag not in", values, "igGoodsTag");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagBetween(String value1, String value2) {
            addCriterion("ig_goods_tag between", value1, value2, "igGoodsTag");
            return (Criteria) this;
        }

        public Criteria andIgGoodsTagNotBetween(String value1, String value2) {
            addCriterion("ig_goods_tag not between", value1, value2, "igGoodsTag");
            return (Criteria) this;
        }

        public Criteria andIgLimitCountIsNull() {
            addCriterion("ig_limit_count is null");
            return (Criteria) this;
        }

        public Criteria andIgLimitCountIsNotNull() {
            addCriterion("ig_limit_count is not null");
            return (Criteria) this;
        }

        public Criteria andIgLimitCountEqualTo(Integer value) {
            addCriterion("ig_limit_count =", value, "igLimitCount");
            return (Criteria) this;
        }

        public Criteria andIgLimitCountNotEqualTo(Integer value) {
            addCriterion("ig_limit_count <>", value, "igLimitCount");
            return (Criteria) this;
        }

        public Criteria andIgLimitCountGreaterThan(Integer value) {
            addCriterion("ig_limit_count >", value, "igLimitCount");
            return (Criteria) this;
        }

        public Criteria andIgLimitCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ig_limit_count >=", value, "igLimitCount");
            return (Criteria) this;
        }

        public Criteria andIgLimitCountLessThan(Integer value) {
            addCriterion("ig_limit_count <", value, "igLimitCount");
            return (Criteria) this;
        }

        public Criteria andIgLimitCountLessThanOrEqualTo(Integer value) {
            addCriterion("ig_limit_count <=", value, "igLimitCount");
            return (Criteria) this;
        }

        public Criteria andIgLimitCountIn(List<Integer> values) {
            addCriterion("ig_limit_count in", values, "igLimitCount");
            return (Criteria) this;
        }

        public Criteria andIgLimitCountNotIn(List<Integer> values) {
            addCriterion("ig_limit_count not in", values, "igLimitCount");
            return (Criteria) this;
        }

        public Criteria andIgLimitCountBetween(Integer value1, Integer value2) {
            addCriterion("ig_limit_count between", value1, value2, "igLimitCount");
            return (Criteria) this;
        }

        public Criteria andIgLimitCountNotBetween(Integer value1, Integer value2) {
            addCriterion("ig_limit_count not between", value1, value2, "igLimitCount");
            return (Criteria) this;
        }

        public Criteria andIgLimitTypeIsNull() {
            addCriterion("ig_limit_type is null");
            return (Criteria) this;
        }

        public Criteria andIgLimitTypeIsNotNull() {
            addCriterion("ig_limit_type is not null");
            return (Criteria) this;
        }

        public Criteria andIgLimitTypeEqualTo(Boolean value) {
            addCriterion("ig_limit_type =", value, "igLimitType");
            return (Criteria) this;
        }

        public Criteria andIgLimitTypeNotEqualTo(Boolean value) {
            addCriterion("ig_limit_type <>", value, "igLimitType");
            return (Criteria) this;
        }

        public Criteria andIgLimitTypeGreaterThan(Boolean value) {
            addCriterion("ig_limit_type >", value, "igLimitType");
            return (Criteria) this;
        }

        public Criteria andIgLimitTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ig_limit_type >=", value, "igLimitType");
            return (Criteria) this;
        }

        public Criteria andIgLimitTypeLessThan(Boolean value) {
            addCriterion("ig_limit_type <", value, "igLimitType");
            return (Criteria) this;
        }

        public Criteria andIgLimitTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("ig_limit_type <=", value, "igLimitType");
            return (Criteria) this;
        }

        public Criteria andIgLimitTypeIn(List<Boolean> values) {
            addCriterion("ig_limit_type in", values, "igLimitType");
            return (Criteria) this;
        }

        public Criteria andIgLimitTypeNotIn(List<Boolean> values) {
            addCriterion("ig_limit_type not in", values, "igLimitType");
            return (Criteria) this;
        }

        public Criteria andIgLimitTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("ig_limit_type between", value1, value2, "igLimitType");
            return (Criteria) this;
        }

        public Criteria andIgLimitTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ig_limit_type not between", value1, value2, "igLimitType");
            return (Criteria) this;
        }

        public Criteria andIgRecommendIsNull() {
            addCriterion("ig_recommend is null");
            return (Criteria) this;
        }

        public Criteria andIgRecommendIsNotNull() {
            addCriterion("ig_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andIgRecommendEqualTo(Boolean value) {
            addCriterion("ig_recommend =", value, "igRecommend");
            return (Criteria) this;
        }

        public Criteria andIgRecommendNotEqualTo(Boolean value) {
            addCriterion("ig_recommend <>", value, "igRecommend");
            return (Criteria) this;
        }

        public Criteria andIgRecommendGreaterThan(Boolean value) {
            addCriterion("ig_recommend >", value, "igRecommend");
            return (Criteria) this;
        }

        public Criteria andIgRecommendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ig_recommend >=", value, "igRecommend");
            return (Criteria) this;
        }

        public Criteria andIgRecommendLessThan(Boolean value) {
            addCriterion("ig_recommend <", value, "igRecommend");
            return (Criteria) this;
        }

        public Criteria andIgRecommendLessThanOrEqualTo(Boolean value) {
            addCriterion("ig_recommend <=", value, "igRecommend");
            return (Criteria) this;
        }

        public Criteria andIgRecommendIn(List<Boolean> values) {
            addCriterion("ig_recommend in", values, "igRecommend");
            return (Criteria) this;
        }

        public Criteria andIgRecommendNotIn(List<Boolean> values) {
            addCriterion("ig_recommend not in", values, "igRecommend");
            return (Criteria) this;
        }

        public Criteria andIgRecommendBetween(Boolean value1, Boolean value2) {
            addCriterion("ig_recommend between", value1, value2, "igRecommend");
            return (Criteria) this;
        }

        public Criteria andIgRecommendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ig_recommend not between", value1, value2, "igRecommend");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionIsNull() {
            addCriterion("ig_seo_description is null");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionIsNotNull() {
            addCriterion("ig_seo_description is not null");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionEqualTo(String value) {
            addCriterion("ig_seo_description =", value, "igSeoDescription");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionNotEqualTo(String value) {
            addCriterion("ig_seo_description <>", value, "igSeoDescription");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionGreaterThan(String value) {
            addCriterion("ig_seo_description >", value, "igSeoDescription");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("ig_seo_description >=", value, "igSeoDescription");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionLessThan(String value) {
            addCriterion("ig_seo_description <", value, "igSeoDescription");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionLessThanOrEqualTo(String value) {
            addCriterion("ig_seo_description <=", value, "igSeoDescription");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionLike(String value) {
            addCriterion("ig_seo_description like", value, "igSeoDescription");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionNotLike(String value) {
            addCriterion("ig_seo_description not like", value, "igSeoDescription");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionIn(List<String> values) {
            addCriterion("ig_seo_description in", values, "igSeoDescription");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionNotIn(List<String> values) {
            addCriterion("ig_seo_description not in", values, "igSeoDescription");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionBetween(String value1, String value2) {
            addCriterion("ig_seo_description between", value1, value2, "igSeoDescription");
            return (Criteria) this;
        }

        public Criteria andIgSeoDescriptionNotBetween(String value1, String value2) {
            addCriterion("ig_seo_description not between", value1, value2, "igSeoDescription");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsIsNull() {
            addCriterion("ig_seo_keywords is null");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsIsNotNull() {
            addCriterion("ig_seo_keywords is not null");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsEqualTo(String value) {
            addCriterion("ig_seo_keywords =", value, "igSeoKeywords");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsNotEqualTo(String value) {
            addCriterion("ig_seo_keywords <>", value, "igSeoKeywords");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsGreaterThan(String value) {
            addCriterion("ig_seo_keywords >", value, "igSeoKeywords");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("ig_seo_keywords >=", value, "igSeoKeywords");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsLessThan(String value) {
            addCriterion("ig_seo_keywords <", value, "igSeoKeywords");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsLessThanOrEqualTo(String value) {
            addCriterion("ig_seo_keywords <=", value, "igSeoKeywords");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsLike(String value) {
            addCriterion("ig_seo_keywords like", value, "igSeoKeywords");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsNotLike(String value) {
            addCriterion("ig_seo_keywords not like", value, "igSeoKeywords");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsIn(List<String> values) {
            addCriterion("ig_seo_keywords in", values, "igSeoKeywords");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsNotIn(List<String> values) {
            addCriterion("ig_seo_keywords not in", values, "igSeoKeywords");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsBetween(String value1, String value2) {
            addCriterion("ig_seo_keywords between", value1, value2, "igSeoKeywords");
            return (Criteria) this;
        }

        public Criteria andIgSeoKeywordsNotBetween(String value1, String value2) {
            addCriterion("ig_seo_keywords not between", value1, value2, "igSeoKeywords");
            return (Criteria) this;
        }

        public Criteria andIgSequenceIsNull() {
            addCriterion("ig_sequence is null");
            return (Criteria) this;
        }

        public Criteria andIgSequenceIsNotNull() {
            addCriterion("ig_sequence is not null");
            return (Criteria) this;
        }

        public Criteria andIgSequenceEqualTo(Integer value) {
            addCriterion("ig_sequence =", value, "igSequence");
            return (Criteria) this;
        }

        public Criteria andIgSequenceNotEqualTo(Integer value) {
            addCriterion("ig_sequence <>", value, "igSequence");
            return (Criteria) this;
        }

        public Criteria andIgSequenceGreaterThan(Integer value) {
            addCriterion("ig_sequence >", value, "igSequence");
            return (Criteria) this;
        }

        public Criteria andIgSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("ig_sequence >=", value, "igSequence");
            return (Criteria) this;
        }

        public Criteria andIgSequenceLessThan(Integer value) {
            addCriterion("ig_sequence <", value, "igSequence");
            return (Criteria) this;
        }

        public Criteria andIgSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("ig_sequence <=", value, "igSequence");
            return (Criteria) this;
        }

        public Criteria andIgSequenceIn(List<Integer> values) {
            addCriterion("ig_sequence in", values, "igSequence");
            return (Criteria) this;
        }

        public Criteria andIgSequenceNotIn(List<Integer> values) {
            addCriterion("ig_sequence not in", values, "igSequence");
            return (Criteria) this;
        }

        public Criteria andIgSequenceBetween(Integer value1, Integer value2) {
            addCriterion("ig_sequence between", value1, value2, "igSequence");
            return (Criteria) this;
        }

        public Criteria andIgSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("ig_sequence not between", value1, value2, "igSequence");
            return (Criteria) this;
        }

        public Criteria andIgShowIsNull() {
            addCriterion("ig_show is null");
            return (Criteria) this;
        }

        public Criteria andIgShowIsNotNull() {
            addCriterion("ig_show is not null");
            return (Criteria) this;
        }

        public Criteria andIgShowEqualTo(Boolean value) {
            addCriterion("ig_show =", value, "igShow");
            return (Criteria) this;
        }

        public Criteria andIgShowNotEqualTo(Boolean value) {
            addCriterion("ig_show <>", value, "igShow");
            return (Criteria) this;
        }

        public Criteria andIgShowGreaterThan(Boolean value) {
            addCriterion("ig_show >", value, "igShow");
            return (Criteria) this;
        }

        public Criteria andIgShowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ig_show >=", value, "igShow");
            return (Criteria) this;
        }

        public Criteria andIgShowLessThan(Boolean value) {
            addCriterion("ig_show <", value, "igShow");
            return (Criteria) this;
        }

        public Criteria andIgShowLessThanOrEqualTo(Boolean value) {
            addCriterion("ig_show <=", value, "igShow");
            return (Criteria) this;
        }

        public Criteria andIgShowIn(List<Boolean> values) {
            addCriterion("ig_show in", values, "igShow");
            return (Criteria) this;
        }

        public Criteria andIgShowNotIn(List<Boolean> values) {
            addCriterion("ig_show not in", values, "igShow");
            return (Criteria) this;
        }

        public Criteria andIgShowBetween(Boolean value1, Boolean value2) {
            addCriterion("ig_show between", value1, value2, "igShow");
            return (Criteria) this;
        }

        public Criteria andIgShowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ig_show not between", value1, value2, "igShow");
            return (Criteria) this;
        }

        public Criteria andIgTimeTypeIsNull() {
            addCriterion("ig_time_type is null");
            return (Criteria) this;
        }

        public Criteria andIgTimeTypeIsNotNull() {
            addCriterion("ig_time_type is not null");
            return (Criteria) this;
        }

        public Criteria andIgTimeTypeEqualTo(Boolean value) {
            addCriterion("ig_time_type =", value, "igTimeType");
            return (Criteria) this;
        }

        public Criteria andIgTimeTypeNotEqualTo(Boolean value) {
            addCriterion("ig_time_type <>", value, "igTimeType");
            return (Criteria) this;
        }

        public Criteria andIgTimeTypeGreaterThan(Boolean value) {
            addCriterion("ig_time_type >", value, "igTimeType");
            return (Criteria) this;
        }

        public Criteria andIgTimeTypeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ig_time_type >=", value, "igTimeType");
            return (Criteria) this;
        }

        public Criteria andIgTimeTypeLessThan(Boolean value) {
            addCriterion("ig_time_type <", value, "igTimeType");
            return (Criteria) this;
        }

        public Criteria andIgTimeTypeLessThanOrEqualTo(Boolean value) {
            addCriterion("ig_time_type <=", value, "igTimeType");
            return (Criteria) this;
        }

        public Criteria andIgTimeTypeIn(List<Boolean> values) {
            addCriterion("ig_time_type in", values, "igTimeType");
            return (Criteria) this;
        }

        public Criteria andIgTimeTypeNotIn(List<Boolean> values) {
            addCriterion("ig_time_type not in", values, "igTimeType");
            return (Criteria) this;
        }

        public Criteria andIgTimeTypeBetween(Boolean value1, Boolean value2) {
            addCriterion("ig_time_type between", value1, value2, "igTimeType");
            return (Criteria) this;
        }

        public Criteria andIgTimeTypeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ig_time_type not between", value1, value2, "igTimeType");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeIsNull() {
            addCriterion("ig_transfee is null");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeIsNotNull() {
            addCriterion("ig_transfee is not null");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeEqualTo(BigDecimal value) {
            addCriterion("ig_transfee =", value, "igTransfee");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeNotEqualTo(BigDecimal value) {
            addCriterion("ig_transfee <>", value, "igTransfee");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeGreaterThan(BigDecimal value) {
            addCriterion("ig_transfee >", value, "igTransfee");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ig_transfee >=", value, "igTransfee");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeLessThan(BigDecimal value) {
            addCriterion("ig_transfee <", value, "igTransfee");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ig_transfee <=", value, "igTransfee");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeIn(List<BigDecimal> values) {
            addCriterion("ig_transfee in", values, "igTransfee");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeNotIn(List<BigDecimal> values) {
            addCriterion("ig_transfee not in", values, "igTransfee");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ig_transfee between", value1, value2, "igTransfee");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ig_transfee not between", value1, value2, "igTransfee");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeTypeIsNull() {
            addCriterion("ig_transfee_type is null");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeTypeIsNotNull() {
            addCriterion("ig_transfee_type is not null");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeTypeEqualTo(Integer value) {
            addCriterion("ig_transfee_type =", value, "igTransfeeType");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeTypeNotEqualTo(Integer value) {
            addCriterion("ig_transfee_type <>", value, "igTransfeeType");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeTypeGreaterThan(Integer value) {
            addCriterion("ig_transfee_type >", value, "igTransfeeType");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ig_transfee_type >=", value, "igTransfeeType");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeTypeLessThan(Integer value) {
            addCriterion("ig_transfee_type <", value, "igTransfeeType");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ig_transfee_type <=", value, "igTransfeeType");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeTypeIn(List<Integer> values) {
            addCriterion("ig_transfee_type in", values, "igTransfeeType");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeTypeNotIn(List<Integer> values) {
            addCriterion("ig_transfee_type not in", values, "igTransfeeType");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeTypeBetween(Integer value1, Integer value2) {
            addCriterion("ig_transfee_type between", value1, value2, "igTransfeeType");
            return (Criteria) this;
        }

        public Criteria andIgTransfeeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ig_transfee_type not between", value1, value2, "igTransfeeType");
            return (Criteria) this;
        }

        public Criteria andIgGoodsImgIdIsNull() {
            addCriterion("ig_goods_img_id is null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsImgIdIsNotNull() {
            addCriterion("ig_goods_img_id is not null");
            return (Criteria) this;
        }

        public Criteria andIgGoodsImgIdEqualTo(Long value) {
            addCriterion("ig_goods_img_id =", value, "igGoodsImgId");
            return (Criteria) this;
        }

        public Criteria andIgGoodsImgIdNotEqualTo(Long value) {
            addCriterion("ig_goods_img_id <>", value, "igGoodsImgId");
            return (Criteria) this;
        }

        public Criteria andIgGoodsImgIdGreaterThan(Long value) {
            addCriterion("ig_goods_img_id >", value, "igGoodsImgId");
            return (Criteria) this;
        }

        public Criteria andIgGoodsImgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ig_goods_img_id >=", value, "igGoodsImgId");
            return (Criteria) this;
        }

        public Criteria andIgGoodsImgIdLessThan(Long value) {
            addCriterion("ig_goods_img_id <", value, "igGoodsImgId");
            return (Criteria) this;
        }

        public Criteria andIgGoodsImgIdLessThanOrEqualTo(Long value) {
            addCriterion("ig_goods_img_id <=", value, "igGoodsImgId");
            return (Criteria) this;
        }

        public Criteria andIgGoodsImgIdIn(List<Long> values) {
            addCriterion("ig_goods_img_id in", values, "igGoodsImgId");
            return (Criteria) this;
        }

        public Criteria andIgGoodsImgIdNotIn(List<Long> values) {
            addCriterion("ig_goods_img_id not in", values, "igGoodsImgId");
            return (Criteria) this;
        }

        public Criteria andIgGoodsImgIdBetween(Long value1, Long value2) {
            addCriterion("ig_goods_img_id between", value1, value2, "igGoodsImgId");
            return (Criteria) this;
        }

        public Criteria andIgGoodsImgIdNotBetween(Long value1, Long value2) {
            addCriterion("ig_goods_img_id not between", value1, value2, "igGoodsImgId");
            return (Criteria) this;
        }
        
        
        public Criteria andNavigationIdIsNull() {
            addCriterion("navigation_id is null");
            return (Criteria) this;
        }

        public Criteria andNavigationIdIsNotNull() {
            addCriterion("navigation_id is not null");
            return (Criteria) this;
        }

        public Criteria andNavigationIdEqualTo(Long value) {
            addCriterion("navigation_id =", value, "navigationId");
            return (Criteria) this;
        }

        public Criteria andNavigationIdNotEqualTo(Long value) {
            addCriterion("navigation_id <>", value, "navigationId");
            return (Criteria) this;
        }

        public Criteria andNavigationIdGreaterThan(Long value) {
            addCriterion("navigation_id >", value, "navigationId");
            return (Criteria) this;
        }

        public Criteria andNavigationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("navigation_id >=", value, "navigationId");
            return (Criteria) this;
        }

        public Criteria andNavigationIdLessThan(Long value) {
            addCriterion("navigation_id <", value, "navigationId");
            return (Criteria) this;
        }

        public Criteria andNavigationIdLessThanOrEqualTo(Long value) {
            addCriterion("navigation_id <=", value, "navigationId");
            return (Criteria) this;
        }

        public Criteria andNavigationIdIn(List<Long> values) {
            addCriterion("navigation_id in", values, "navigationId");
            return (Criteria) this;
        }

        public Criteria andNavigationIdNotIn(List<Long> values) {
            addCriterion("navigation_id not in", values, "navigationId");
            return (Criteria) this;
        }

        public Criteria andNavigationIdBetween(Long value1, Long value2) {
            addCriterion("navigation_id between", value1, value2, "navigationId");
            return (Criteria) this;
        }

        public Criteria andNavigationIdNotBetween(Long value1, Long value2) {
            addCriterion("navigation_id not between", value1, value2, "navigationId");
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