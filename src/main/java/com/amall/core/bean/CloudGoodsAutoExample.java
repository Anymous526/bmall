package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class CloudGoodsAutoExample extends BaseQuery{
	private static final long serialVersionUID = 1L;
	
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CloudGoodsAutoExample() {
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

        public Criteria andCloudGoodsIdIsNull() {
            addCriterion("cloud_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdIsNotNull() {
            addCriterion("cloud_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdEqualTo(Long value) {
            addCriterion("cloud_goods_id =", value, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdNotEqualTo(Long value) {
            addCriterion("cloud_goods_id <>", value, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdGreaterThan(Long value) {
            addCriterion("cloud_goods_id >", value, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cloud_goods_id >=", value, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdLessThan(Long value) {
            addCriterion("cloud_goods_id <", value, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("cloud_goods_id <=", value, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdIn(List<Long> values) {
            addCriterion("cloud_goods_id in", values, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdNotIn(List<Long> values) {
            addCriterion("cloud_goods_id not in", values, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdBetween(Long value1, Long value2) {
            addCriterion("cloud_goods_id between", value1, value2, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andCloudGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("cloud_goods_id not between", value1, value2, "cloudGoodsId");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalIsNull() {
            addCriterion("time_interval is null");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalIsNotNull() {
            addCriterion("time_interval is not null");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalEqualTo(Integer value) {
            addCriterion("time_interval =", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalNotEqualTo(Integer value) {
            addCriterion("time_interval <>", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalGreaterThan(Integer value) {
            addCriterion("time_interval >", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_interval >=", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalLessThan(Integer value) {
            addCriterion("time_interval <", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("time_interval <=", value, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalIn(List<Integer> values) {
            addCriterion("time_interval in", values, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalNotIn(List<Integer> values) {
            addCriterion("time_interval not in", values, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalBetween(Integer value1, Integer value2) {
            addCriterion("time_interval between", value1, value2, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andTimeIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("time_interval not between", value1, value2, "timeInterval");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNull() {
            addCriterion("is_enable is null");
            return (Criteria) this;
        }

        public Criteria andIsEnableIsNotNull() {
            addCriterion("is_enable is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnableEqualTo(Boolean value) {
            addCriterion("is_enable =", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotEqualTo(Boolean value) {
            addCriterion("is_enable <>", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThan(Boolean value) {
            addCriterion("is_enable >", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_enable >=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThan(Boolean value) {
            addCriterion("is_enable <", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableLessThanOrEqualTo(Boolean value) {
            addCriterion("is_enable <=", value, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableIn(List<Boolean> values) {
            addCriterion("is_enable in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotIn(List<Boolean> values) {
            addCriterion("is_enable not in", values, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enable between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andIsEnableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enable not between", value1, value2, "isEnable");
            return (Criteria) this;
        }

        public Criteria andOpenGoodsNumberIsNull() {
            addCriterion("open_goods_number is null");
            return (Criteria) this;
        }

        public Criteria andOpenGoodsNumberIsNotNull() {
            addCriterion("open_goods_number is not null");
            return (Criteria) this;
        }

        public Criteria andOpenGoodsNumberEqualTo(Integer value) {
            addCriterion("open_goods_number =", value, "openGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOpenGoodsNumberNotEqualTo(Integer value) {
            addCriterion("open_goods_number <>", value, "openGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOpenGoodsNumberGreaterThan(Integer value) {
            addCriterion("open_goods_number >", value, "openGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOpenGoodsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("open_goods_number >=", value, "openGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOpenGoodsNumberLessThan(Integer value) {
            addCriterion("open_goods_number <", value, "openGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOpenGoodsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("open_goods_number <=", value, "openGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOpenGoodsNumberIn(List<Integer> values) {
            addCriterion("open_goods_number in", values, "openGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOpenGoodsNumberNotIn(List<Integer> values) {
            addCriterion("open_goods_number not in", values, "openGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOpenGoodsNumberBetween(Integer value1, Integer value2) {
            addCriterion("open_goods_number between", value1, value2, "openGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andOpenGoodsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("open_goods_number not between", value1, value2, "openGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andRemainGoodsNumberIsNull() {
            addCriterion("remain_goods_number is null");
            return (Criteria) this;
        }

        public Criteria andRemainGoodsNumberIsNotNull() {
            addCriterion("remain_goods_number is not null");
            return (Criteria) this;
        }

        public Criteria andRemainGoodsNumberEqualTo(Integer value) {
            addCriterion("remain_goods_number =", value, "remainGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andRemainGoodsNumberNotEqualTo(Integer value) {
            addCriterion("remain_goods_number <>", value, "remainGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andRemainGoodsNumberGreaterThan(Integer value) {
            addCriterion("remain_goods_number >", value, "remainGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andRemainGoodsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("remain_goods_number >=", value, "remainGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andRemainGoodsNumberLessThan(Integer value) {
            addCriterion("remain_goods_number <", value, "remainGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andRemainGoodsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("remain_goods_number <=", value, "remainGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andRemainGoodsNumberIn(List<Integer> values) {
            addCriterion("remain_goods_number in", values, "remainGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andRemainGoodsNumberNotIn(List<Integer> values) {
            addCriterion("remain_goods_number not in", values, "remainGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andRemainGoodsNumberBetween(Integer value1, Integer value2) {
            addCriterion("remain_goods_number between", value1, value2, "remainGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andRemainGoodsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("remain_goods_number not between", value1, value2, "remainGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andPassGoodsNumberIsNull() {
            addCriterion("pass_goods_number is null");
            return (Criteria) this;
        }

        public Criteria andPassGoodsNumberIsNotNull() {
            addCriterion("pass_goods_number is not null");
            return (Criteria) this;
        }

        public Criteria andPassGoodsNumberEqualTo(Integer value) {
            addCriterion("pass_goods_number =", value, "passGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andPassGoodsNumberNotEqualTo(Integer value) {
            addCriterion("pass_goods_number <>", value, "passGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andPassGoodsNumberGreaterThan(Integer value) {
            addCriterion("pass_goods_number >", value, "passGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andPassGoodsNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("pass_goods_number >=", value, "passGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andPassGoodsNumberLessThan(Integer value) {
            addCriterion("pass_goods_number <", value, "passGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andPassGoodsNumberLessThanOrEqualTo(Integer value) {
            addCriterion("pass_goods_number <=", value, "passGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andPassGoodsNumberIn(List<Integer> values) {
            addCriterion("pass_goods_number in", values, "passGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andPassGoodsNumberNotIn(List<Integer> values) {
            addCriterion("pass_goods_number not in", values, "passGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andPassGoodsNumberBetween(Integer value1, Integer value2) {
            addCriterion("pass_goods_number between", value1, value2, "passGoodsNumber");
            return (Criteria) this;
        }

        public Criteria andPassGoodsNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("pass_goods_number not between", value1, value2, "passGoodsNumber");
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