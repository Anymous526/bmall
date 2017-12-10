package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class SpareGoodsExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpareGoodsExample() {
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

        public Criteria andContactIsNull() {
            addCriterion("contact is null");
            return (Criteria) this;
        }

        public Criteria andContactIsNotNull() {
            addCriterion("contact is not null");
            return (Criteria) this;
        }

        public Criteria andContactEqualTo(String value) {
            addCriterion("contact =", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotEqualTo(String value) {
            addCriterion("contact <>", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThan(String value) {
            addCriterion("contact >", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactGreaterThanOrEqualTo(String value) {
            addCriterion("contact >=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThan(String value) {
            addCriterion("contact <", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLessThanOrEqualTo(String value) {
            addCriterion("contact <=", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactLike(String value) {
            addCriterion("contact like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotLike(String value) {
            addCriterion("contact not like", value, "contact");
            return (Criteria) this;
        }

        public Criteria andContactIn(List<String> values) {
            addCriterion("contact in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotIn(List<String> values) {
            addCriterion("contact not in", values, "contact");
            return (Criteria) this;
        }

        public Criteria andContactBetween(String value1, String value2) {
            addCriterion("contact between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andContactNotBetween(String value1, String value2) {
            addCriterion("contact not between", value1, value2, "contact");
            return (Criteria) this;
        }

        public Criteria andErrormessageIsNull() {
            addCriterion("errorMessage is null");
            return (Criteria) this;
        }

        public Criteria andErrormessageIsNotNull() {
            addCriterion("errorMessage is not null");
            return (Criteria) this;
        }

        public Criteria andErrormessageEqualTo(String value) {
            addCriterion("errorMessage =", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageNotEqualTo(String value) {
            addCriterion("errorMessage <>", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageGreaterThan(String value) {
            addCriterion("errorMessage >", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageGreaterThanOrEqualTo(String value) {
            addCriterion("errorMessage >=", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageLessThan(String value) {
            addCriterion("errorMessage <", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageLessThanOrEqualTo(String value) {
            addCriterion("errorMessage <=", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageLike(String value) {
            addCriterion("errorMessage like", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageNotLike(String value) {
            addCriterion("errorMessage not like", value, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageIn(List<String> values) {
            addCriterion("errorMessage in", values, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageNotIn(List<String> values) {
            addCriterion("errorMessage not in", values, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageBetween(String value1, String value2) {
            addCriterion("errorMessage between", value1, value2, "errormessage");
            return (Criteria) this;
        }

        public Criteria andErrormessageNotBetween(String value1, String value2) {
            addCriterion("errorMessage not between", value1, value2, "errormessage");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceIsNull() {
            addCriterion("goods_old_price is null");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceIsNotNull() {
            addCriterion("goods_old_price is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceEqualTo(Integer value) {
            addCriterion("goods_old_price =", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceNotEqualTo(Integer value) {
            addCriterion("goods_old_price <>", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceGreaterThan(Integer value) {
            addCriterion("goods_old_price >", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_old_price >=", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceLessThan(Integer value) {
            addCriterion("goods_old_price <", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceLessThanOrEqualTo(Integer value) {
            addCriterion("goods_old_price <=", value, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceIn(List<Integer> values) {
            addCriterion("goods_old_price in", values, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceNotIn(List<Integer> values) {
            addCriterion("goods_old_price not in", values, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceBetween(Integer value1, Integer value2) {
            addCriterion("goods_old_price between", value1, value2, "goodsOldPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsOldPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_old_price not between", value1, value2, "goodsOldPrice");
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

        public Criteria andGoodsPriceEqualTo(Integer value) {
            addCriterion("goods_price =", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotEqualTo(Integer value) {
            addCriterion("goods_price <>", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThan(Integer value) {
            addCriterion("goods_price >", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("goods_price >=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThan(Integer value) {
            addCriterion("goods_price <", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceLessThanOrEqualTo(Integer value) {
            addCriterion("goods_price <=", value, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceIn(List<Integer> values) {
            addCriterion("goods_price in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotIn(List<Integer> values) {
            addCriterion("goods_price not in", values, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceBetween(Integer value1, Integer value2) {
            addCriterion("goods_price between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andGoodsPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("goods_price not between", value1, value2, "goodsPrice");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andOldandnewIsNull() {
            addCriterion("oldAndnew is null");
            return (Criteria) this;
        }

        public Criteria andOldandnewIsNotNull() {
            addCriterion("oldAndnew is not null");
            return (Criteria) this;
        }

        public Criteria andOldandnewEqualTo(Integer value) {
            addCriterion("oldAndnew =", value, "oldandnew");
            return (Criteria) this;
        }

        public Criteria andOldandnewNotEqualTo(Integer value) {
            addCriterion("oldAndnew <>", value, "oldandnew");
            return (Criteria) this;
        }

        public Criteria andOldandnewGreaterThan(Integer value) {
            addCriterion("oldAndnew >", value, "oldandnew");
            return (Criteria) this;
        }

        public Criteria andOldandnewGreaterThanOrEqualTo(Integer value) {
            addCriterion("oldAndnew >=", value, "oldandnew");
            return (Criteria) this;
        }

        public Criteria andOldandnewLessThan(Integer value) {
            addCriterion("oldAndnew <", value, "oldandnew");
            return (Criteria) this;
        }

        public Criteria andOldandnewLessThanOrEqualTo(Integer value) {
            addCriterion("oldAndnew <=", value, "oldandnew");
            return (Criteria) this;
        }

        public Criteria andOldandnewIn(List<Integer> values) {
            addCriterion("oldAndnew in", values, "oldandnew");
            return (Criteria) this;
        }

        public Criteria andOldandnewNotIn(List<Integer> values) {
            addCriterion("oldAndnew not in", values, "oldandnew");
            return (Criteria) this;
        }

        public Criteria andOldandnewBetween(Integer value1, Integer value2) {
            addCriterion("oldAndnew between", value1, value2, "oldandnew");
            return (Criteria) this;
        }

        public Criteria andOldandnewNotBetween(Integer value1, Integer value2) {
            addCriterion("oldAndnew not between", value1, value2, "oldandnew");
            return (Criteria) this;
        }

        public Criteria andSellmethodIsNull() {
            addCriterion("sellMethod is null");
            return (Criteria) this;
        }

        public Criteria andSellmethodIsNotNull() {
            addCriterion("sellMethod is not null");
            return (Criteria) this;
        }

        public Criteria andSellmethodEqualTo(Integer value) {
            addCriterion("sellMethod =", value, "sellmethod");
            return (Criteria) this;
        }

        public Criteria andSellmethodNotEqualTo(Integer value) {
            addCriterion("sellMethod <>", value, "sellmethod");
            return (Criteria) this;
        }

        public Criteria andSellmethodGreaterThan(Integer value) {
            addCriterion("sellMethod >", value, "sellmethod");
            return (Criteria) this;
        }

        public Criteria andSellmethodGreaterThanOrEqualTo(Integer value) {
            addCriterion("sellMethod >=", value, "sellmethod");
            return (Criteria) this;
        }

        public Criteria andSellmethodLessThan(Integer value) {
            addCriterion("sellMethod <", value, "sellmethod");
            return (Criteria) this;
        }

        public Criteria andSellmethodLessThanOrEqualTo(Integer value) {
            addCriterion("sellMethod <=", value, "sellmethod");
            return (Criteria) this;
        }

        public Criteria andSellmethodIn(List<Integer> values) {
            addCriterion("sellMethod in", values, "sellmethod");
            return (Criteria) this;
        }

        public Criteria andSellmethodNotIn(List<Integer> values) {
            addCriterion("sellMethod not in", values, "sellmethod");
            return (Criteria) this;
        }

        public Criteria andSellmethodBetween(Integer value1, Integer value2) {
            addCriterion("sellMethod between", value1, value2, "sellmethod");
            return (Criteria) this;
        }

        public Criteria andSellmethodNotBetween(Integer value1, Integer value2) {
            addCriterion("sellMethod not between", value1, value2, "sellmethod");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Long value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Long value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Long value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Long value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Long value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Long> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Long> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Long value1, Long value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Long value1, Long value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andImgIdIsNull() {
            addCriterion("img_id is null");
            return (Criteria) this;
        }

        public Criteria andImgIdIsNotNull() {
            addCriterion("img_id is not null");
            return (Criteria) this;
        }

        public Criteria andImgIdEqualTo(Long value) {
            addCriterion("img_id =", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotEqualTo(Long value) {
            addCriterion("img_id <>", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThan(Long value) {
            addCriterion("img_id >", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("img_id >=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThan(Long value) {
            addCriterion("img_id <", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdLessThanOrEqualTo(Long value) {
            addCriterion("img_id <=", value, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdIn(List<Long> values) {
            addCriterion("img_id in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotIn(List<Long> values) {
            addCriterion("img_id not in", values, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdBetween(Long value1, Long value2) {
            addCriterion("img_id between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andImgIdNotBetween(Long value1, Long value2) {
            addCriterion("img_id not between", value1, value2, "imgId");
            return (Criteria) this;
        }

        public Criteria andSparegoodsclassIdIsNull() {
            addCriterion("spareGoodsClass_id is null");
            return (Criteria) this;
        }

        public Criteria andSparegoodsclassIdIsNotNull() {
            addCriterion("spareGoodsClass_id is not null");
            return (Criteria) this;
        }

        public Criteria andSparegoodsclassIdEqualTo(Long value) {
            addCriterion("spareGoodsClass_id =", value, "sparegoodsclassId");
            return (Criteria) this;
        }

        public Criteria andSparegoodsclassIdNotEqualTo(Long value) {
            addCriterion("spareGoodsClass_id <>", value, "sparegoodsclassId");
            return (Criteria) this;
        }

        public Criteria andSparegoodsclassIdGreaterThan(Long value) {
            addCriterion("spareGoodsClass_id >", value, "sparegoodsclassId");
            return (Criteria) this;
        }

        public Criteria andSparegoodsclassIdGreaterThanOrEqualTo(Long value) {
            addCriterion("spareGoodsClass_id >=", value, "sparegoodsclassId");
            return (Criteria) this;
        }

        public Criteria andSparegoodsclassIdLessThan(Long value) {
            addCriterion("spareGoodsClass_id <", value, "sparegoodsclassId");
            return (Criteria) this;
        }

        public Criteria andSparegoodsclassIdLessThanOrEqualTo(Long value) {
            addCriterion("spareGoodsClass_id <=", value, "sparegoodsclassId");
            return (Criteria) this;
        }

        public Criteria andSparegoodsclassIdIn(List<Long> values) {
            addCriterion("spareGoodsClass_id in", values, "sparegoodsclassId");
            return (Criteria) this;
        }

        public Criteria andSparegoodsclassIdNotIn(List<Long> values) {
            addCriterion("spareGoodsClass_id not in", values, "sparegoodsclassId");
            return (Criteria) this;
        }

        public Criteria andSparegoodsclassIdBetween(Long value1, Long value2) {
            addCriterion("spareGoodsClass_id between", value1, value2, "sparegoodsclassId");
            return (Criteria) this;
        }

        public Criteria andSparegoodsclassIdNotBetween(Long value1, Long value2) {
            addCriterion("spareGoodsClass_id not between", value1, value2, "sparegoodsclassId");
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

        public Criteria andPhoneIsNull() {
            addCriterion("phone is null");
            return (Criteria) this;
        }

        public Criteria andPhoneIsNotNull() {
            addCriterion("phone is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneEqualTo(String value) {
            addCriterion("phone =", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotEqualTo(String value) {
            addCriterion("phone <>", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThan(String value) {
            addCriterion("phone >", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("phone >=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThan(String value) {
            addCriterion("phone <", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLessThanOrEqualTo(String value) {
            addCriterion("phone <=", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneLike(String value) {
            addCriterion("phone like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotLike(String value) {
            addCriterion("phone not like", value, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneIn(List<String> values) {
            addCriterion("phone in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotIn(List<String> values) {
            addCriterion("phone not in", values, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneBetween(String value1, String value2) {
            addCriterion("phone between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andPhoneNotBetween(String value1, String value2) {
            addCriterion("phone not between", value1, value2, "phone");
            return (Criteria) this;
        }

        public Criteria andImg1IdIsNull() {
            addCriterion("img1_id is null");
            return (Criteria) this;
        }

        public Criteria andImg1IdIsNotNull() {
            addCriterion("img1_id is not null");
            return (Criteria) this;
        }

        public Criteria andImg1IdEqualTo(Long value) {
            addCriterion("img1_id =", value, "img1Id");
            return (Criteria) this;
        }

        public Criteria andImg1IdNotEqualTo(Long value) {
            addCriterion("img1_id <>", value, "img1Id");
            return (Criteria) this;
        }

        public Criteria andImg1IdGreaterThan(Long value) {
            addCriterion("img1_id >", value, "img1Id");
            return (Criteria) this;
        }

        public Criteria andImg1IdGreaterThanOrEqualTo(Long value) {
            addCriterion("img1_id >=", value, "img1Id");
            return (Criteria) this;
        }

        public Criteria andImg1IdLessThan(Long value) {
            addCriterion("img1_id <", value, "img1Id");
            return (Criteria) this;
        }

        public Criteria andImg1IdLessThanOrEqualTo(Long value) {
            addCriterion("img1_id <=", value, "img1Id");
            return (Criteria) this;
        }

        public Criteria andImg1IdIn(List<Long> values) {
            addCriterion("img1_id in", values, "img1Id");
            return (Criteria) this;
        }

        public Criteria andImg1IdNotIn(List<Long> values) {
            addCriterion("img1_id not in", values, "img1Id");
            return (Criteria) this;
        }

        public Criteria andImg1IdBetween(Long value1, Long value2) {
            addCriterion("img1_id between", value1, value2, "img1Id");
            return (Criteria) this;
        }

        public Criteria andImg1IdNotBetween(Long value1, Long value2) {
            addCriterion("img1_id not between", value1, value2, "img1Id");
            return (Criteria) this;
        }

        public Criteria andImg2IdIsNull() {
            addCriterion("img2_id is null");
            return (Criteria) this;
        }

        public Criteria andImg2IdIsNotNull() {
            addCriterion("img2_id is not null");
            return (Criteria) this;
        }

        public Criteria andImg2IdEqualTo(Long value) {
            addCriterion("img2_id =", value, "img2Id");
            return (Criteria) this;
        }

        public Criteria andImg2IdNotEqualTo(Long value) {
            addCriterion("img2_id <>", value, "img2Id");
            return (Criteria) this;
        }

        public Criteria andImg2IdGreaterThan(Long value) {
            addCriterion("img2_id >", value, "img2Id");
            return (Criteria) this;
        }

        public Criteria andImg2IdGreaterThanOrEqualTo(Long value) {
            addCriterion("img2_id >=", value, "img2Id");
            return (Criteria) this;
        }

        public Criteria andImg2IdLessThan(Long value) {
            addCriterion("img2_id <", value, "img2Id");
            return (Criteria) this;
        }

        public Criteria andImg2IdLessThanOrEqualTo(Long value) {
            addCriterion("img2_id <=", value, "img2Id");
            return (Criteria) this;
        }

        public Criteria andImg2IdIn(List<Long> values) {
            addCriterion("img2_id in", values, "img2Id");
            return (Criteria) this;
        }

        public Criteria andImg2IdNotIn(List<Long> values) {
            addCriterion("img2_id not in", values, "img2Id");
            return (Criteria) this;
        }

        public Criteria andImg2IdBetween(Long value1, Long value2) {
            addCriterion("img2_id between", value1, value2, "img2Id");
            return (Criteria) this;
        }

        public Criteria andImg2IdNotBetween(Long value1, Long value2) {
            addCriterion("img2_id not between", value1, value2, "img2Id");
            return (Criteria) this;
        }

        public Criteria andImg3IdIsNull() {
            addCriterion("img3_id is null");
            return (Criteria) this;
        }

        public Criteria andImg3IdIsNotNull() {
            addCriterion("img3_id is not null");
            return (Criteria) this;
        }

        public Criteria andImg3IdEqualTo(Long value) {
            addCriterion("img3_id =", value, "img3Id");
            return (Criteria) this;
        }

        public Criteria andImg3IdNotEqualTo(Long value) {
            addCriterion("img3_id <>", value, "img3Id");
            return (Criteria) this;
        }

        public Criteria andImg3IdGreaterThan(Long value) {
            addCriterion("img3_id >", value, "img3Id");
            return (Criteria) this;
        }

        public Criteria andImg3IdGreaterThanOrEqualTo(Long value) {
            addCriterion("img3_id >=", value, "img3Id");
            return (Criteria) this;
        }

        public Criteria andImg3IdLessThan(Long value) {
            addCriterion("img3_id <", value, "img3Id");
            return (Criteria) this;
        }

        public Criteria andImg3IdLessThanOrEqualTo(Long value) {
            addCriterion("img3_id <=", value, "img3Id");
            return (Criteria) this;
        }

        public Criteria andImg3IdIn(List<Long> values) {
            addCriterion("img3_id in", values, "img3Id");
            return (Criteria) this;
        }

        public Criteria andImg3IdNotIn(List<Long> values) {
            addCriterion("img3_id not in", values, "img3Id");
            return (Criteria) this;
        }

        public Criteria andImg3IdBetween(Long value1, Long value2) {
            addCriterion("img3_id between", value1, value2, "img3Id");
            return (Criteria) this;
        }

        public Criteria andImg3IdNotBetween(Long value1, Long value2) {
            addCriterion("img3_id not between", value1, value2, "img3Id");
            return (Criteria) this;
        }

        public Criteria andImg4IdIsNull() {
            addCriterion("img4_id is null");
            return (Criteria) this;
        }

        public Criteria andImg4IdIsNotNull() {
            addCriterion("img4_id is not null");
            return (Criteria) this;
        }

        public Criteria andImg4IdEqualTo(Long value) {
            addCriterion("img4_id =", value, "img4Id");
            return (Criteria) this;
        }

        public Criteria andImg4IdNotEqualTo(Long value) {
            addCriterion("img4_id <>", value, "img4Id");
            return (Criteria) this;
        }

        public Criteria andImg4IdGreaterThan(Long value) {
            addCriterion("img4_id >", value, "img4Id");
            return (Criteria) this;
        }

        public Criteria andImg4IdGreaterThanOrEqualTo(Long value) {
            addCriterion("img4_id >=", value, "img4Id");
            return (Criteria) this;
        }

        public Criteria andImg4IdLessThan(Long value) {
            addCriterion("img4_id <", value, "img4Id");
            return (Criteria) this;
        }

        public Criteria andImg4IdLessThanOrEqualTo(Long value) {
            addCriterion("img4_id <=", value, "img4Id");
            return (Criteria) this;
        }

        public Criteria andImg4IdIn(List<Long> values) {
            addCriterion("img4_id in", values, "img4Id");
            return (Criteria) this;
        }

        public Criteria andImg4IdNotIn(List<Long> values) {
            addCriterion("img4_id not in", values, "img4Id");
            return (Criteria) this;
        }

        public Criteria andImg4IdBetween(Long value1, Long value2) {
            addCriterion("img4_id between", value1, value2, "img4Id");
            return (Criteria) this;
        }

        public Criteria andImg4IdNotBetween(Long value1, Long value2) {
            addCriterion("img4_id not between", value1, value2, "img4Id");
            return (Criteria) this;
        }

        public Criteria andMainImgIdIsNull() {
            addCriterion("main_img_id is null");
            return (Criteria) this;
        }

        public Criteria andMainImgIdIsNotNull() {
            addCriterion("main_img_id is not null");
            return (Criteria) this;
        }

        public Criteria andMainImgIdEqualTo(Long value) {
            addCriterion("main_img_id =", value, "mainImgId");
            return (Criteria) this;
        }

        public Criteria andMainImgIdNotEqualTo(Long value) {
            addCriterion("main_img_id <>", value, "mainImgId");
            return (Criteria) this;
        }

        public Criteria andMainImgIdGreaterThan(Long value) {
            addCriterion("main_img_id >", value, "mainImgId");
            return (Criteria) this;
        }

        public Criteria andMainImgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("main_img_id >=", value, "mainImgId");
            return (Criteria) this;
        }

        public Criteria andMainImgIdLessThan(Long value) {
            addCriterion("main_img_id <", value, "mainImgId");
            return (Criteria) this;
        }

        public Criteria andMainImgIdLessThanOrEqualTo(Long value) {
            addCriterion("main_img_id <=", value, "mainImgId");
            return (Criteria) this;
        }

        public Criteria andMainImgIdIn(List<Long> values) {
            addCriterion("main_img_id in", values, "mainImgId");
            return (Criteria) this;
        }

        public Criteria andMainImgIdNotIn(List<Long> values) {
            addCriterion("main_img_id not in", values, "mainImgId");
            return (Criteria) this;
        }

        public Criteria andMainImgIdBetween(Long value1, Long value2) {
            addCriterion("main_img_id between", value1, value2, "mainImgId");
            return (Criteria) this;
        }

        public Criteria andMainImgIdNotBetween(Long value1, Long value2) {
            addCriterion("main_img_id not between", value1, value2, "mainImgId");
            return (Criteria) this;
        }

        public Criteria andImg5IdIsNull() {
            addCriterion("img5_id is null");
            return (Criteria) this;
        }

        public Criteria andImg5IdIsNotNull() {
            addCriterion("img5_id is not null");
            return (Criteria) this;
        }

        public Criteria andImg5IdEqualTo(Long value) {
            addCriterion("img5_id =", value, "img5Id");
            return (Criteria) this;
        }

        public Criteria andImg5IdNotEqualTo(Long value) {
            addCriterion("img5_id <>", value, "img5Id");
            return (Criteria) this;
        }

        public Criteria andImg5IdGreaterThan(Long value) {
            addCriterion("img5_id >", value, "img5Id");
            return (Criteria) this;
        }

        public Criteria andImg5IdGreaterThanOrEqualTo(Long value) {
            addCriterion("img5_id >=", value, "img5Id");
            return (Criteria) this;
        }

        public Criteria andImg5IdLessThan(Long value) {
            addCriterion("img5_id <", value, "img5Id");
            return (Criteria) this;
        }

        public Criteria andImg5IdLessThanOrEqualTo(Long value) {
            addCriterion("img5_id <=", value, "img5Id");
            return (Criteria) this;
        }

        public Criteria andImg5IdIn(List<Long> values) {
            addCriterion("img5_id in", values, "img5Id");
            return (Criteria) this;
        }

        public Criteria andImg5IdNotIn(List<Long> values) {
            addCriterion("img5_id not in", values, "img5Id");
            return (Criteria) this;
        }

        public Criteria andImg5IdBetween(Long value1, Long value2) {
            addCriterion("img5_id between", value1, value2, "img5Id");
            return (Criteria) this;
        }

        public Criteria andImg5IdNotBetween(Long value1, Long value2) {
            addCriterion("img5_id not between", value1, value2, "img5Id");
            return (Criteria) this;
        }

        public Criteria andViewinfloorIsNull() {
            addCriterion("viewInFloor is null");
            return (Criteria) this;
        }

        public Criteria andViewinfloorIsNotNull() {
            addCriterion("viewInFloor is not null");
            return (Criteria) this;
        }

        public Criteria andViewinfloorEqualTo(Boolean value) {
            addCriterion("viewInFloor =", value, "viewinfloor");
            return (Criteria) this;
        }

        public Criteria andViewinfloorNotEqualTo(Boolean value) {
            addCriterion("viewInFloor <>", value, "viewinfloor");
            return (Criteria) this;
        }

        public Criteria andViewinfloorGreaterThan(Boolean value) {
            addCriterion("viewInFloor >", value, "viewinfloor");
            return (Criteria) this;
        }

        public Criteria andViewinfloorGreaterThanOrEqualTo(Boolean value) {
            addCriterion("viewInFloor >=", value, "viewinfloor");
            return (Criteria) this;
        }

        public Criteria andViewinfloorLessThan(Boolean value) {
            addCriterion("viewInFloor <", value, "viewinfloor");
            return (Criteria) this;
        }

        public Criteria andViewinfloorLessThanOrEqualTo(Boolean value) {
            addCriterion("viewInFloor <=", value, "viewinfloor");
            return (Criteria) this;
        }

        public Criteria andViewinfloorIn(List<Boolean> values) {
            addCriterion("viewInFloor in", values, "viewinfloor");
            return (Criteria) this;
        }

        public Criteria andViewinfloorNotIn(List<Boolean> values) {
            addCriterion("viewInFloor not in", values, "viewinfloor");
            return (Criteria) this;
        }

        public Criteria andViewinfloorBetween(Boolean value1, Boolean value2) {
            addCriterion("viewInFloor between", value1, value2, "viewinfloor");
            return (Criteria) this;
        }

        public Criteria andViewinfloorNotBetween(Boolean value1, Boolean value2) {
            addCriterion("viewInFloor not between", value1, value2, "viewinfloor");
            return (Criteria) this;
        }

        public Criteria andSgfIdIsNull() {
            addCriterion("sgf_id is null");
            return (Criteria) this;
        }

        public Criteria andSgfIdIsNotNull() {
            addCriterion("sgf_id is not null");
            return (Criteria) this;
        }

        public Criteria andSgfIdEqualTo(Long value) {
            addCriterion("sgf_id =", value, "sgfId");
            return (Criteria) this;
        }

        public Criteria andSgfIdNotEqualTo(Long value) {
            addCriterion("sgf_id <>", value, "sgfId");
            return (Criteria) this;
        }

        public Criteria andSgfIdGreaterThan(Long value) {
            addCriterion("sgf_id >", value, "sgfId");
            return (Criteria) this;
        }

        public Criteria andSgfIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sgf_id >=", value, "sgfId");
            return (Criteria) this;
        }

        public Criteria andSgfIdLessThan(Long value) {
            addCriterion("sgf_id <", value, "sgfId");
            return (Criteria) this;
        }

        public Criteria andSgfIdLessThanOrEqualTo(Long value) {
            addCriterion("sgf_id <=", value, "sgfId");
            return (Criteria) this;
        }

        public Criteria andSgfIdIn(List<Long> values) {
            addCriterion("sgf_id in", values, "sgfId");
            return (Criteria) this;
        }

        public Criteria andSgfIdNotIn(List<Long> values) {
            addCriterion("sgf_id not in", values, "sgfId");
            return (Criteria) this;
        }

        public Criteria andSgfIdBetween(Long value1, Long value2) {
            addCriterion("sgf_id between", value1, value2, "sgfId");
            return (Criteria) this;
        }

        public Criteria andSgfIdNotBetween(Long value1, Long value2) {
            addCriterion("sgf_id not between", value1, value2, "sgfId");
            return (Criteria) this;
        }

        public Criteria andQqIsNull() {
            addCriterion("QQ is null");
            return (Criteria) this;
        }

        public Criteria andQqIsNotNull() {
            addCriterion("QQ is not null");
            return (Criteria) this;
        }

        public Criteria andQqEqualTo(String value) {
            addCriterion("QQ =", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotEqualTo(String value) {
            addCriterion("QQ <>", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThan(String value) {
            addCriterion("QQ >", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqGreaterThanOrEqualTo(String value) {
            addCriterion("QQ >=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThan(String value) {
            addCriterion("QQ <", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLessThanOrEqualTo(String value) {
            addCriterion("QQ <=", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqLike(String value) {
            addCriterion("QQ like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotLike(String value) {
            addCriterion("QQ not like", value, "qq");
            return (Criteria) this;
        }

        public Criteria andQqIn(List<String> values) {
            addCriterion("QQ in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotIn(List<String> values) {
            addCriterion("QQ not in", values, "qq");
            return (Criteria) this;
        }

        public Criteria andQqBetween(String value1, String value2) {
            addCriterion("QQ between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andQqNotBetween(String value1, String value2) {
            addCriterion("QQ not between", value1, value2, "qq");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNull() {
            addCriterion("recommend is null");
            return (Criteria) this;
        }

        public Criteria andRecommendIsNotNull() {
            addCriterion("recommend is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendEqualTo(Boolean value) {
            addCriterion("recommend =", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotEqualTo(Boolean value) {
            addCriterion("recommend <>", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThan(Boolean value) {
            addCriterion("recommend >", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("recommend >=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThan(Boolean value) {
            addCriterion("recommend <", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendLessThanOrEqualTo(Boolean value) {
            addCriterion("recommend <=", value, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendIn(List<Boolean> values) {
            addCriterion("recommend in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotIn(List<Boolean> values) {
            addCriterion("recommend not in", values, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendBetween(Boolean value1, Boolean value2) {
            addCriterion("recommend between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andRecommendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("recommend not between", value1, value2, "recommend");
            return (Criteria) this;
        }

        public Criteria andDownIsNull() {
            addCriterion("down is null");
            return (Criteria) this;
        }

        public Criteria andDownIsNotNull() {
            addCriterion("down is not null");
            return (Criteria) this;
        }

        public Criteria andDownEqualTo(Integer value) {
            addCriterion("down =", value, "down");
            return (Criteria) this;
        }

        public Criteria andDownNotEqualTo(Integer value) {
            addCriterion("down <>", value, "down");
            return (Criteria) this;
        }

        public Criteria andDownGreaterThan(Integer value) {
            addCriterion("down >", value, "down");
            return (Criteria) this;
        }

        public Criteria andDownGreaterThanOrEqualTo(Integer value) {
            addCriterion("down >=", value, "down");
            return (Criteria) this;
        }

        public Criteria andDownLessThan(Integer value) {
            addCriterion("down <", value, "down");
            return (Criteria) this;
        }

        public Criteria andDownLessThanOrEqualTo(Integer value) {
            addCriterion("down <=", value, "down");
            return (Criteria) this;
        }

        public Criteria andDownIn(List<Integer> values) {
            addCriterion("down in", values, "down");
            return (Criteria) this;
        }

        public Criteria andDownNotIn(List<Integer> values) {
            addCriterion("down not in", values, "down");
            return (Criteria) this;
        }

        public Criteria andDownBetween(Integer value1, Integer value2) {
            addCriterion("down between", value1, value2, "down");
            return (Criteria) this;
        }

        public Criteria andDownNotBetween(Integer value1, Integer value2) {
            addCriterion("down not between", value1, value2, "down");
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