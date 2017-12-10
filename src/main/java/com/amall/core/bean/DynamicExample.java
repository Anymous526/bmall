package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class DynamicExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DynamicExample() {
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

        public Criteria andDiscussnumIsNull() {
            addCriterion("discussNum is null");
            return (Criteria) this;
        }

        public Criteria andDiscussnumIsNotNull() {
            addCriterion("discussNum is not null");
            return (Criteria) this;
        }

        public Criteria andDiscussnumEqualTo(Integer value) {
            addCriterion("discussNum =", value, "discussnum");
            return (Criteria) this;
        }

        public Criteria andDiscussnumNotEqualTo(Integer value) {
            addCriterion("discussNum <>", value, "discussnum");
            return (Criteria) this;
        }

        public Criteria andDiscussnumGreaterThan(Integer value) {
            addCriterion("discussNum >", value, "discussnum");
            return (Criteria) this;
        }

        public Criteria andDiscussnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("discussNum >=", value, "discussnum");
            return (Criteria) this;
        }

        public Criteria andDiscussnumLessThan(Integer value) {
            addCriterion("discussNum <", value, "discussnum");
            return (Criteria) this;
        }

        public Criteria andDiscussnumLessThanOrEqualTo(Integer value) {
            addCriterion("discussNum <=", value, "discussnum");
            return (Criteria) this;
        }

        public Criteria andDiscussnumIn(List<Integer> values) {
            addCriterion("discussNum in", values, "discussnum");
            return (Criteria) this;
        }

        public Criteria andDiscussnumNotIn(List<Integer> values) {
            addCriterion("discussNum not in", values, "discussnum");
            return (Criteria) this;
        }

        public Criteria andDiscussnumBetween(Integer value1, Integer value2) {
            addCriterion("discussNum between", value1, value2, "discussnum");
            return (Criteria) this;
        }

        public Criteria andDiscussnumNotBetween(Integer value1, Integer value2) {
            addCriterion("discussNum not between", value1, value2, "discussnum");
            return (Criteria) this;
        }

        public Criteria andPraisenumIsNull() {
            addCriterion("praiseNum is null");
            return (Criteria) this;
        }

        public Criteria andPraisenumIsNotNull() {
            addCriterion("praiseNum is not null");
            return (Criteria) this;
        }

        public Criteria andPraisenumEqualTo(Integer value) {
            addCriterion("praiseNum =", value, "praisenum");
            return (Criteria) this;
        }

        public Criteria andPraisenumNotEqualTo(Integer value) {
            addCriterion("praiseNum <>", value, "praisenum");
            return (Criteria) this;
        }

        public Criteria andPraisenumGreaterThan(Integer value) {
            addCriterion("praiseNum >", value, "praisenum");
            return (Criteria) this;
        }

        public Criteria andPraisenumGreaterThanOrEqualTo(Integer value) {
            addCriterion("praiseNum >=", value, "praisenum");
            return (Criteria) this;
        }

        public Criteria andPraisenumLessThan(Integer value) {
            addCriterion("praiseNum <", value, "praisenum");
            return (Criteria) this;
        }

        public Criteria andPraisenumLessThanOrEqualTo(Integer value) {
            addCriterion("praiseNum <=", value, "praisenum");
            return (Criteria) this;
        }

        public Criteria andPraisenumIn(List<Integer> values) {
            addCriterion("praiseNum in", values, "praisenum");
            return (Criteria) this;
        }

        public Criteria andPraisenumNotIn(List<Integer> values) {
            addCriterion("praiseNum not in", values, "praisenum");
            return (Criteria) this;
        }

        public Criteria andPraisenumBetween(Integer value1, Integer value2) {
            addCriterion("praiseNum between", value1, value2, "praisenum");
            return (Criteria) this;
        }

        public Criteria andPraisenumNotBetween(Integer value1, Integer value2) {
            addCriterion("praiseNum not between", value1, value2, "praisenum");
            return (Criteria) this;
        }

        public Criteria andTurnnumIsNull() {
            addCriterion("turnNum is null");
            return (Criteria) this;
        }

        public Criteria andTurnnumIsNotNull() {
            addCriterion("turnNum is not null");
            return (Criteria) this;
        }

        public Criteria andTurnnumEqualTo(Integer value) {
            addCriterion("turnNum =", value, "turnnum");
            return (Criteria) this;
        }

        public Criteria andTurnnumNotEqualTo(Integer value) {
            addCriterion("turnNum <>", value, "turnnum");
            return (Criteria) this;
        }

        public Criteria andTurnnumGreaterThan(Integer value) {
            addCriterion("turnNum >", value, "turnnum");
            return (Criteria) this;
        }

        public Criteria andTurnnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("turnNum >=", value, "turnnum");
            return (Criteria) this;
        }

        public Criteria andTurnnumLessThan(Integer value) {
            addCriterion("turnNum <", value, "turnnum");
            return (Criteria) this;
        }

        public Criteria andTurnnumLessThanOrEqualTo(Integer value) {
            addCriterion("turnNum <=", value, "turnnum");
            return (Criteria) this;
        }

        public Criteria andTurnnumIn(List<Integer> values) {
            addCriterion("turnNum in", values, "turnnum");
            return (Criteria) this;
        }

        public Criteria andTurnnumNotIn(List<Integer> values) {
            addCriterion("turnNum not in", values, "turnnum");
            return (Criteria) this;
        }

        public Criteria andTurnnumBetween(Integer value1, Integer value2) {
            addCriterion("turnNum between", value1, value2, "turnnum");
            return (Criteria) this;
        }

        public Criteria andTurnnumNotBetween(Integer value1, Integer value2) {
            addCriterion("turnNum not between", value1, value2, "turnnum");
            return (Criteria) this;
        }

        public Criteria andDissparentIdIsNull() {
            addCriterion("dissParent_id is null");
            return (Criteria) this;
        }

        public Criteria andDissparentIdIsNotNull() {
            addCriterion("dissParent_id is not null");
            return (Criteria) this;
        }

        public Criteria andDissparentIdEqualTo(Long value) {
            addCriterion("dissParent_id =", value, "dissparentId");
            return (Criteria) this;
        }

        public Criteria andDissparentIdNotEqualTo(Long value) {
            addCriterion("dissParent_id <>", value, "dissparentId");
            return (Criteria) this;
        }

        public Criteria andDissparentIdGreaterThan(Long value) {
            addCriterion("dissParent_id >", value, "dissparentId");
            return (Criteria) this;
        }

        public Criteria andDissparentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("dissParent_id >=", value, "dissparentId");
            return (Criteria) this;
        }

        public Criteria andDissparentIdLessThan(Long value) {
            addCriterion("dissParent_id <", value, "dissparentId");
            return (Criteria) this;
        }

        public Criteria andDissparentIdLessThanOrEqualTo(Long value) {
            addCriterion("dissParent_id <=", value, "dissparentId");
            return (Criteria) this;
        }

        public Criteria andDissparentIdIn(List<Long> values) {
            addCriterion("dissParent_id in", values, "dissparentId");
            return (Criteria) this;
        }

        public Criteria andDissparentIdNotIn(List<Long> values) {
            addCriterion("dissParent_id not in", values, "dissparentId");
            return (Criteria) this;
        }

        public Criteria andDissparentIdBetween(Long value1, Long value2) {
            addCriterion("dissParent_id between", value1, value2, "dissparentId");
            return (Criteria) this;
        }

        public Criteria andDissparentIdNotBetween(Long value1, Long value2) {
            addCriterion("dissParent_id not between", value1, value2, "dissparentId");
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

        public Criteria andTurnparentIdIsNull() {
            addCriterion("turnParent_id is null");
            return (Criteria) this;
        }

        public Criteria andTurnparentIdIsNotNull() {
            addCriterion("turnParent_id is not null");
            return (Criteria) this;
        }

        public Criteria andTurnparentIdEqualTo(Long value) {
            addCriterion("turnParent_id =", value, "turnparentId");
            return (Criteria) this;
        }

        public Criteria andTurnparentIdNotEqualTo(Long value) {
            addCriterion("turnParent_id <>", value, "turnparentId");
            return (Criteria) this;
        }

        public Criteria andTurnparentIdGreaterThan(Long value) {
            addCriterion("turnParent_id >", value, "turnparentId");
            return (Criteria) this;
        }

        public Criteria andTurnparentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("turnParent_id >=", value, "turnparentId");
            return (Criteria) this;
        }

        public Criteria andTurnparentIdLessThan(Long value) {
            addCriterion("turnParent_id <", value, "turnparentId");
            return (Criteria) this;
        }

        public Criteria andTurnparentIdLessThanOrEqualTo(Long value) {
            addCriterion("turnParent_id <=", value, "turnparentId");
            return (Criteria) this;
        }

        public Criteria andTurnparentIdIn(List<Long> values) {
            addCriterion("turnParent_id in", values, "turnparentId");
            return (Criteria) this;
        }

        public Criteria andTurnparentIdNotIn(List<Long> values) {
            addCriterion("turnParent_id not in", values, "turnparentId");
            return (Criteria) this;
        }

        public Criteria andTurnparentIdBetween(Long value1, Long value2) {
            addCriterion("turnParent_id between", value1, value2, "turnparentId");
            return (Criteria) this;
        }

        public Criteria andTurnparentIdNotBetween(Long value1, Long value2) {
            addCriterion("turnParent_id not between", value1, value2, "turnparentId");
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

        public Criteria andLockedIsNull() {
            addCriterion("locked is null");
            return (Criteria) this;
        }

        public Criteria andLockedIsNotNull() {
            addCriterion("locked is not null");
            return (Criteria) this;
        }

        public Criteria andLockedEqualTo(Boolean value) {
            addCriterion("locked =", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotEqualTo(Boolean value) {
            addCriterion("locked <>", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedGreaterThan(Boolean value) {
            addCriterion("locked >", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("locked >=", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedLessThan(Boolean value) {
            addCriterion("locked <", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedLessThanOrEqualTo(Boolean value) {
            addCriterion("locked <=", value, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedIn(List<Boolean> values) {
            addCriterion("locked in", values, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotIn(List<Boolean> values) {
            addCriterion("locked not in", values, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedBetween(Boolean value1, Boolean value2) {
            addCriterion("locked between", value1, value2, "locked");
            return (Criteria) this;
        }

        public Criteria andLockedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("locked not between", value1, value2, "locked");
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

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Long value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Long value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Long value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Long value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Long value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Long> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Long> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Long value1, Long value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Long value1, Long value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andDisplayIsNull() {
            addCriterion("display is null");
            return (Criteria) this;
        }

        public Criteria andDisplayIsNotNull() {
            addCriterion("display is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayEqualTo(Boolean value) {
            addCriterion("display =", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotEqualTo(Boolean value) {
            addCriterion("display <>", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayGreaterThan(Boolean value) {
            addCriterion("display >", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("display >=", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLessThan(Boolean value) {
            addCriterion("display <", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayLessThanOrEqualTo(Boolean value) {
            addCriterion("display <=", value, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayIn(List<Boolean> values) {
            addCriterion("display in", values, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotIn(List<Boolean> values) {
            addCriterion("display not in", values, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayBetween(Boolean value1, Boolean value2) {
            addCriterion("display between", value1, value2, "display");
            return (Criteria) this;
        }

        public Criteria andDisplayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("display not between", value1, value2, "display");
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