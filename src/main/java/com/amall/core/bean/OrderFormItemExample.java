package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class OrderFormItemExample  extends BaseQuery{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	  protected String orderByClause;

	    protected boolean distinct;

	    protected List<Criteria> oredCriteria;

	    public OrderFormItemExample() {
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

	        public Criteria andGoodsIdIsNull() {
	            addCriterion("goods_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsIdIsNotNull() {
	            addCriterion("goods_id is not null");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsIdEqualTo(Long value) {
	            addCriterion("goods_id =", value, "goodsId");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsIdNotEqualTo(Long value) {
	            addCriterion("goods_id <>", value, "goodsId");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsIdGreaterThan(Long value) {
	            addCriterion("goods_id >", value, "goodsId");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
	            addCriterion("goods_id >=", value, "goodsId");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsIdLessThan(Long value) {
	            addCriterion("goods_id <", value, "goodsId");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
	            addCriterion("goods_id <=", value, "goodsId");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsIdIn(List<Long> values) {
	            addCriterion("goods_id in", values, "goodsId");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsIdNotIn(List<Long> values) {
	            addCriterion("goods_id not in", values, "goodsId");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsIdBetween(Long value1, Long value2) {
	            addCriterion("goods_id between", value1, value2, "goodsId");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
	            addCriterion("goods_id not between", value1, value2, "goodsId");
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

	        public Criteria andDirectBuyIsNull() {
	            addCriterion("direct_buy is null");
	            return (Criteria) this;
	        }

	        public Criteria andDirectBuyIsNotNull() {
	            addCriterion("direct_buy is not null");
	            return (Criteria) this;
	        }

	        public Criteria andDirectBuyEqualTo(Boolean value) {
	            addCriterion("direct_buy =", value, "directBuy");
	            return (Criteria) this;
	        }

	        public Criteria andDirectBuyNotEqualTo(Boolean value) {
	            addCriterion("direct_buy <>", value, "directBuy");
	            return (Criteria) this;
	        }

	        public Criteria andDirectBuyGreaterThan(Boolean value) {
	            addCriterion("direct_buy >", value, "directBuy");
	            return (Criteria) this;
	        }

	        public Criteria andDirectBuyGreaterThanOrEqualTo(Boolean value) {
	            addCriterion("direct_buy >=", value, "directBuy");
	            return (Criteria) this;
	        }

	        public Criteria andDirectBuyLessThan(Boolean value) {
	            addCriterion("direct_buy <", value, "directBuy");
	            return (Criteria) this;
	        }

	        public Criteria andDirectBuyLessThanOrEqualTo(Boolean value) {
	            addCriterion("direct_buy <=", value, "directBuy");
	            return (Criteria) this;
	        }

	        public Criteria andDirectBuyIn(List<Boolean> values) {
	            addCriterion("direct_buy in", values, "directBuy");
	            return (Criteria) this;
	        }

	        public Criteria andDirectBuyNotIn(List<Boolean> values) {
	            addCriterion("direct_buy not in", values, "directBuy");
	            return (Criteria) this;
	        }

	        public Criteria andDirectBuyBetween(Boolean value1, Boolean value2) {
	            addCriterion("direct_buy between", value1, value2, "directBuy");
	            return (Criteria) this;
	        }

	        public Criteria andDirectBuyNotBetween(Boolean value1, Boolean value2) {
	            addCriterion("direct_buy not between", value1, value2, "directBuy");
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

	        public Criteria andRefundIsNull() {
	            addCriterion("refund is null");
	            return (Criteria) this;
	        }

	        public Criteria andRefundIsNotNull() {
	            addCriterion("refund is not null");
	            return (Criteria) this;
	        }

	        public Criteria andRefundEqualTo(Integer value) {
	            addCriterion("refund =", value, "refund");
	            return (Criteria) this;
	        }

	        public Criteria andRefundNotEqualTo(Integer value) {
	            addCriterion("refund <>", value, "refund");
	            return (Criteria) this;
	        }

	        public Criteria andRefundGreaterThan(Integer value) {
	            addCriterion("refund >", value, "refund");
	            return (Criteria) this;
	        }

	        public Criteria andRefundGreaterThanOrEqualTo(Integer value) {
	            addCriterion("refund >=", value, "refund");
	            return (Criteria) this;
	        }

	        public Criteria andRefundLessThan(Integer value) {
	            addCriterion("refund <", value, "refund");
	            return (Criteria) this;
	        }

	        public Criteria andRefundLessThanOrEqualTo(Integer value) {
	            addCriterion("refund <=", value, "refund");
	            return (Criteria) this;
	        }

	        public Criteria andRefundIn(List<Integer> values) {
	            addCriterion("refund in", values, "refund");
	            return (Criteria) this;
	        }

	        public Criteria andRefundNotIn(List<Integer> values) {
	            addCriterion("refund not in", values, "refund");
	            return (Criteria) this;
	        }

	        public Criteria andRefundBetween(Integer value1, Integer value2) {
	            addCriterion("refund between", value1, value2, "refund");
	            return (Criteria) this;
	        }

	        public Criteria andRefundNotBetween(Integer value1, Integer value2) {
	            addCriterion("refund not between", value1, value2, "refund");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsPhotoIsNull() {
	            addCriterion("goods_photo is null");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsPhotoIsNotNull() {
	            addCriterion("goods_photo is not null");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsPhotoEqualTo(Long value) {
	            addCriterion("goods_photo =", value, "goodsPhoto");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsPhotoNotEqualTo(Long value) {
	            addCriterion("goods_photo <>", value, "goodsPhoto");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsPhotoGreaterThan(Long value) {
	            addCriterion("goods_photo >", value, "goodsPhoto");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsPhotoGreaterThanOrEqualTo(Long value) {
	            addCriterion("goods_photo >=", value, "goodsPhoto");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsPhotoLessThan(Long value) {
	            addCriterion("goods_photo <", value, "goodsPhoto");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsPhotoLessThanOrEqualTo(Long value) {
	            addCriterion("goods_photo <=", value, "goodsPhoto");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsPhotoIn(List<Long> values) {
	            addCriterion("goods_photo in", values, "goodsPhoto");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsPhotoNotIn(List<Long> values) {
	            addCriterion("goods_photo not in", values, "goodsPhoto");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsPhotoBetween(Long value1, Long value2) {
	            addCriterion("goods_photo between", value1, value2, "goodsPhoto");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsPhotoNotBetween(Long value1, Long value2) {
	            addCriterion("goods_photo not between", value1, value2, "goodsPhoto");
	            return (Criteria) this;
	        }

	        public Criteria andOrderIdIsNull() {
	            addCriterion("order_id is null");
	            return (Criteria) this;
	        }

	        public Criteria andOrderIdIsNotNull() {
	            addCriterion("order_id is not null");
	            return (Criteria) this;
	        }

	        public Criteria andOrderIdEqualTo(Long value) {
	            addCriterion("order_id =", value, "orderId");
	            return (Criteria) this;
	        }

	        public Criteria andOrderIdNotEqualTo(Long value) {
	            addCriterion("order_id <>", value, "orderId");
	            return (Criteria) this;
	        }

	        public Criteria andOrderIdGreaterThan(Long value) {
	            addCriterion("order_id >", value, "orderId");
	            return (Criteria) this;
	        }

	        public Criteria andOrderIdGreaterThanOrEqualTo(Long value) {
	            addCriterion("order_id >=", value, "orderId");
	            return (Criteria) this;
	        }

	        public Criteria andOrderIdLessThan(Long value) {
	            addCriterion("order_id <", value, "orderId");
	            return (Criteria) this;
	        }

	        public Criteria andOrderIdLessThanOrEqualTo(Long value) {
	            addCriterion("order_id <=", value, "orderId");
	            return (Criteria) this;
	        }

	        public Criteria andOrderIdIn(List<Long> values) {
	            addCriterion("order_id in", values, "orderId");
	            return (Criteria) this;
	        }

	        public Criteria andOrderIdNotIn(List<Long> values) {
	            addCriterion("order_id not in", values, "orderId");
	            return (Criteria) this;
	        }

	        public Criteria andOrderIdBetween(Long value1, Long value2) {
	            addCriterion("order_id between", value1, value2, "orderId");
	            return (Criteria) this;
	        }

	        public Criteria andOrderIdNotBetween(Long value1, Long value2) {
	            addCriterion("order_id not between", value1, value2, "orderId");
	            return (Criteria) this;
	        }

	        public Criteria andLeeStatusIsNull() {
	            addCriterion("lee_status is null");
	            return (Criteria) this;
	        }

	        public Criteria andLeeStatusIsNotNull() {
	            addCriterion("lee_status is not null");
	            return (Criteria) this;
	        }

	        public Criteria andLeeStatusEqualTo(Boolean value) {
	            addCriterion("lee_status =", value, "leeStatus");
	            return (Criteria) this;
	        }

	        public Criteria andLeeStatusNotEqualTo(Boolean value) {
	            addCriterion("lee_status <>", value, "leeStatus");
	            return (Criteria) this;
	        }

	        public Criteria andLeeStatusGreaterThan(Boolean value) {
	            addCriterion("lee_status >", value, "leeStatus");
	            return (Criteria) this;
	        }

	        public Criteria andLeeStatusGreaterThanOrEqualTo(Boolean value) {
	            addCriterion("lee_status >=", value, "leeStatus");
	            return (Criteria) this;
	        }

	        public Criteria andLeeStatusLessThan(Boolean value) {
	            addCriterion("lee_status <", value, "leeStatus");
	            return (Criteria) this;
	        }

	        public Criteria andLeeStatusLessThanOrEqualTo(Boolean value) {
	            addCriterion("lee_status <=", value, "leeStatus");
	            return (Criteria) this;
	        }

	        public Criteria andLeeStatusIn(List<Boolean> values) {
	            addCriterion("lee_status in", values, "leeStatus");
	            return (Criteria) this;
	        }

	        public Criteria andLeeStatusNotIn(List<Boolean> values) {
	            addCriterion("lee_status not in", values, "leeStatus");
	            return (Criteria) this;
	        }

	        public Criteria andLeeStatusBetween(Boolean value1, Boolean value2) {
	            addCriterion("lee_status between", value1, value2, "leeStatus");
	            return (Criteria) this;
	        }

	        public Criteria andLeeStatusNotBetween(Boolean value1, Boolean value2) {
	            addCriterion("lee_status not between", value1, value2, "leeStatus");
	            return (Criteria) this;
	        }

	        public Criteria andItemStatusIsNull() {
	            addCriterion("item_status is null");
	            return (Criteria) this;
	        }

	        public Criteria andItemStatusIsNotNull() {
	            addCriterion("item_status is not null");
	            return (Criteria) this;
	        }

	        public Criteria andItemStatusEqualTo(Boolean value) {
	            addCriterion("item_status =", value, "itemStatus");
	            return (Criteria) this;
	        }

	        public Criteria andItemStatusNotEqualTo(Boolean value) {
	            addCriterion("item_status <>", value, "itemStatus");
	            return (Criteria) this;
	        }

	        public Criteria andItemStatusGreaterThan(Boolean value) {
	            addCriterion("item_status >", value, "itemStatus");
	            return (Criteria) this;
	        }

	        public Criteria andItemStatusGreaterThanOrEqualTo(Boolean value) {
	            addCriterion("item_status >=", value, "itemStatus");
	            return (Criteria) this;
	        }

	        public Criteria andItemStatusLessThan(Boolean value) {
	            addCriterion("item_status <", value, "itemStatus");
	            return (Criteria) this;
	        }

	        public Criteria andItemStatusLessThanOrEqualTo(Boolean value) {
	            addCriterion("item_status <=", value, "itemStatus");
	            return (Criteria) this;
	        }

	        public Criteria andItemStatusIn(List<Boolean> values) {
	            addCriterion("item_status in", values, "itemStatus");
	            return (Criteria) this;
	        }

	        public Criteria andItemStatusNotIn(List<Boolean> values) {
	            addCriterion("item_status not in", values, "itemStatus");
	            return (Criteria) this;
	        }

	        public Criteria andItemStatusBetween(Boolean value1, Boolean value2) {
	            addCriterion("item_status between", value1, value2, "itemStatus");
	            return (Criteria) this;
	        }

	        public Criteria andItemStatusNotBetween(Boolean value1, Boolean value2) {
	            addCriterion("item_status not between", value1, value2, "itemStatus");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsRateIsNull() {
	            addCriterion("goods_rate is null");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsRateIsNotNull() {
	            addCriterion("goods_rate is not null");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsRateEqualTo(BigDecimal value) {
	            addCriterion("goods_rate =", value, "goodsRate");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsRateNotEqualTo(BigDecimal value) {
	            addCriterion("goods_rate <>", value, "goodsRate");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsRateGreaterThan(BigDecimal value) {
	            addCriterion("goods_rate >", value, "goodsRate");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsRateGreaterThanOrEqualTo(BigDecimal value) {
	            addCriterion("goods_rate >=", value, "goodsRate");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsRateLessThan(BigDecimal value) {
	            addCriterion("goods_rate <", value, "goodsRate");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsRateLessThanOrEqualTo(BigDecimal value) {
	            addCriterion("goods_rate <=", value, "goodsRate");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsRateIn(List<BigDecimal> values) {
	            addCriterion("goods_rate in", values, "goodsRate");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsRateNotIn(List<BigDecimal> values) {
	            addCriterion("goods_rate not in", values, "goodsRate");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsRateBetween(BigDecimal value1, BigDecimal value2) {
	            addCriterion("goods_rate between", value1, value2, "goodsRate");
	            return (Criteria) this;
	        }

	        public Criteria andGoodsRateNotBetween(BigDecimal value1, BigDecimal value2) {
	            addCriterion("goods_rate not between", value1, value2, "goodsRate");
	            return (Criteria) this;
	        }

	        public Criteria andUpdateorderIsNull() {
	            addCriterion("updateOrder is null");
	            return (Criteria) this;
	        }

	        public Criteria andUpdateorderIsNotNull() {
	            addCriterion("updateOrder is not null");
	            return (Criteria) this;
	        }

	        public Criteria andUpdateorderEqualTo(Boolean value) {
	            addCriterion("updateOrder =", value, "updateorder");
	            return (Criteria) this;
	        }

	        public Criteria andUpdateorderNotEqualTo(Boolean value) {
	            addCriterion("updateOrder <>", value, "updateorder");
	            return (Criteria) this;
	        }

	        public Criteria andUpdateorderGreaterThan(Boolean value) {
	            addCriterion("updateOrder >", value, "updateorder");
	            return (Criteria) this;
	        }

	        public Criteria andUpdateorderGreaterThanOrEqualTo(Boolean value) {
	            addCriterion("updateOrder >=", value, "updateorder");
	            return (Criteria) this;
	        }

	        public Criteria andUpdateorderLessThan(Boolean value) {
	            addCriterion("updateOrder <", value, "updateorder");
	            return (Criteria) this;
	        }

	        public Criteria andUpdateorderLessThanOrEqualTo(Boolean value) {
	            addCriterion("updateOrder <=", value, "updateorder");
	            return (Criteria) this;
	        }

	        public Criteria andUpdateorderIn(List<Boolean> values) {
	            addCriterion("updateOrder in", values, "updateorder");
	            return (Criteria) this;
	        }

	        public Criteria andUpdateorderNotIn(List<Boolean> values) {
	            addCriterion("updateOrder not in", values, "updateorder");
	            return (Criteria) this;
	        }

	        public Criteria andUpdateorderBetween(Boolean value1, Boolean value2) {
	            addCriterion("updateOrder between", value1, value2, "updateorder");
	            return (Criteria) this;
	        }

	        public Criteria andUpdateorderNotBetween(Boolean value1, Boolean value2) {
	            addCriterion("updateOrder not between", value1, value2, "updateorder");
	            return (Criteria) this;
	        }

	        public Criteria andRefundServerIsNull() {
	            addCriterion("refund_server is null");
	            return (Criteria) this;
	        }

	        public Criteria andRefundServerIsNotNull() {
	            addCriterion("refund_server is not null");
	            return (Criteria) this;
	        }

	        public Criteria andRefundServerEqualTo(Integer value) {
	            addCriterion("refund_server =", value, "refundServer");
	            return (Criteria) this;
	        }

	        public Criteria andRefundServerNotEqualTo(Integer value) {
	            addCriterion("refund_server <>", value, "refundServer");
	            return (Criteria) this;
	        }

	        public Criteria andRefundServerGreaterThan(Integer value) {
	            addCriterion("refund_server >", value, "refundServer");
	            return (Criteria) this;
	        }

	        public Criteria andRefundServerGreaterThanOrEqualTo(Integer value) {
	            addCriterion("refund_server >=", value, "refundServer");
	            return (Criteria) this;
	        }

	        public Criteria andRefundServerLessThan(Integer value) {
	            addCriterion("refund_server <", value, "refundServer");
	            return (Criteria) this;
	        }

	        public Criteria andRefundServerLessThanOrEqualTo(Integer value) {
	            addCriterion("refund_server <=", value, "refundServer");
	            return (Criteria) this;
	        }

	        public Criteria andRefundServerIn(List<Integer> values) {
	            addCriterion("refund_server in", values, "refundServer");
	            return (Criteria) this;
	        }

	        public Criteria andRefundServerNotIn(List<Integer> values) {
	            addCriterion("refund_server not in", values, "refundServer");
	            return (Criteria) this;
	        }

	        public Criteria andRefundServerBetween(Integer value1, Integer value2) {
	            addCriterion("refund_server between", value1, value2, "refundServer");
	            return (Criteria) this;
	        }

	        public Criteria andRefundServerNotBetween(Integer value1, Integer value2) {
	            addCriterion("refund_server not between", value1, value2, "refundServer");
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