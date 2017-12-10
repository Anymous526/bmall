package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class SpareGoodsFloorExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SpareGoodsFloorExample() {
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

        public Criteria andAdverIdIsNull() {
            addCriterion("adver_id is null");
            return (Criteria) this;
        }

        public Criteria andAdverIdIsNotNull() {
            addCriterion("adver_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdverIdEqualTo(String value) {
            addCriterion("adver_id =", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdNotEqualTo(String value) {
            addCriterion("adver_id <>", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdGreaterThan(String value) {
            addCriterion("adver_id >", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdGreaterThanOrEqualTo(String value) {
            addCriterion("adver_id >=", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdLessThan(String value) {
            addCriterion("adver_id <", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdLessThanOrEqualTo(String value) {
            addCriterion("adver_id <=", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdLike(String value) {
            addCriterion("adver_id like", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdNotLike(String value) {
            addCriterion("adver_id not like", value, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdIn(List<String> values) {
            addCriterion("adver_id in", values, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdNotIn(List<String> values) {
            addCriterion("adver_id not in", values, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdBetween(String value1, String value2) {
            addCriterion("adver_id between", value1, value2, "adverId");
            return (Criteria) this;
        }

        public Criteria andAdverIdNotBetween(String value1, String value2) {
            addCriterion("adver_id not between", value1, value2, "adverId");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNull() {
            addCriterion("sequence is null");
            return (Criteria) this;
        }

        public Criteria andSequenceIsNotNull() {
            addCriterion("sequence is not null");
            return (Criteria) this;
        }

        public Criteria andSequenceEqualTo(Integer value) {
            addCriterion("sequence =", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotEqualTo(Integer value) {
            addCriterion("sequence <>", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThan(Integer value) {
            addCriterion("sequence >", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("sequence >=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThan(Integer value) {
            addCriterion("sequence <", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("sequence <=", value, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceIn(List<Integer> values) {
            addCriterion("sequence in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotIn(List<Integer> values) {
            addCriterion("sequence not in", values, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceBetween(Integer value1, Integer value2) {
            addCriterion("sequence between", value1, value2, "sequence");
            return (Criteria) this;
        }

        public Criteria andSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("sequence not between", value1, value2, "sequence");
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

        public Criteria andVisableIsNull() {
            addCriterion("visable is null");
            return (Criteria) this;
        }

        public Criteria andVisableIsNotNull() {
            addCriterion("visable is not null");
            return (Criteria) this;
        }

        public Criteria andVisableEqualTo(Integer value) {
            addCriterion("visable =", value, "visable");
            return (Criteria) this;
        }

        public Criteria andVisableNotEqualTo(Integer value) {
            addCriterion("visable <>", value, "visable");
            return (Criteria) this;
        }

        public Criteria andVisableGreaterThan(Integer value) {
            addCriterion("visable >", value, "visable");
            return (Criteria) this;
        }

        public Criteria andVisableGreaterThanOrEqualTo(Integer value) {
            addCriterion("visable >=", value, "visable");
            return (Criteria) this;
        }

        public Criteria andVisableLessThan(Integer value) {
            addCriterion("visable <", value, "visable");
            return (Criteria) this;
        }

        public Criteria andVisableLessThanOrEqualTo(Integer value) {
            addCriterion("visable <=", value, "visable");
            return (Criteria) this;
        }

        public Criteria andVisableIn(List<Integer> values) {
            addCriterion("visable in", values, "visable");
            return (Criteria) this;
        }

        public Criteria andVisableNotIn(List<Integer> values) {
            addCriterion("visable not in", values, "visable");
            return (Criteria) this;
        }

        public Criteria andVisableBetween(Integer value1, Integer value2) {
            addCriterion("visable between", value1, value2, "visable");
            return (Criteria) this;
        }

        public Criteria andVisableNotBetween(Integer value1, Integer value2) {
            addCriterion("visable not between", value1, value2, "visable");
            return (Criteria) this;
        }

        public Criteria andSgcIdIsNull() {
            addCriterion("sgc_id is null");
            return (Criteria) this;
        }

        public Criteria andSgcIdIsNotNull() {
            addCriterion("sgc_id is not null");
            return (Criteria) this;
        }

        public Criteria andSgcIdEqualTo(Long value) {
            addCriterion("sgc_id =", value, "sgcId");
            return (Criteria) this;
        }

        public Criteria andSgcIdNotEqualTo(Long value) {
            addCriterion("sgc_id <>", value, "sgcId");
            return (Criteria) this;
        }

        public Criteria andSgcIdGreaterThan(Long value) {
            addCriterion("sgc_id >", value, "sgcId");
            return (Criteria) this;
        }

        public Criteria andSgcIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sgc_id >=", value, "sgcId");
            return (Criteria) this;
        }

        public Criteria andSgcIdLessThan(Long value) {
            addCriterion("sgc_id <", value, "sgcId");
            return (Criteria) this;
        }

        public Criteria andSgcIdLessThanOrEqualTo(Long value) {
            addCriterion("sgc_id <=", value, "sgcId");
            return (Criteria) this;
        }

        public Criteria andSgcIdIn(List<Long> values) {
            addCriterion("sgc_id in", values, "sgcId");
            return (Criteria) this;
        }

        public Criteria andSgcIdNotIn(List<Long> values) {
            addCriterion("sgc_id not in", values, "sgcId");
            return (Criteria) this;
        }

        public Criteria andSgcIdBetween(Long value1, Long value2) {
            addCriterion("sgc_id between", value1, value2, "sgcId");
            return (Criteria) this;
        }

        public Criteria andSgcIdNotBetween(Long value1, Long value2) {
            addCriterion("sgc_id not between", value1, value2, "sgcId");
            return (Criteria) this;
        }

        public Criteria andAdverTypeIsNull() {
            addCriterion("adver_type is null");
            return (Criteria) this;
        }

        public Criteria andAdverTypeIsNotNull() {
            addCriterion("adver_type is not null");
            return (Criteria) this;
        }

        public Criteria andAdverTypeEqualTo(Integer value) {
            addCriterion("adver_type =", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeNotEqualTo(Integer value) {
            addCriterion("adver_type <>", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeGreaterThan(Integer value) {
            addCriterion("adver_type >", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("adver_type >=", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeLessThan(Integer value) {
            addCriterion("adver_type <", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeLessThanOrEqualTo(Integer value) {
            addCriterion("adver_type <=", value, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeIn(List<Integer> values) {
            addCriterion("adver_type in", values, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeNotIn(List<Integer> values) {
            addCriterion("adver_type not in", values, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeBetween(Integer value1, Integer value2) {
            addCriterion("adver_type between", value1, value2, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdverTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("adver_type not between", value1, value2, "adverType");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlIsNull() {
            addCriterion("advert_url is null");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlIsNotNull() {
            addCriterion("advert_url is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlEqualTo(String value) {
            addCriterion("advert_url =", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlNotEqualTo(String value) {
            addCriterion("advert_url <>", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlGreaterThan(String value) {
            addCriterion("advert_url >", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlGreaterThanOrEqualTo(String value) {
            addCriterion("advert_url >=", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlLessThan(String value) {
            addCriterion("advert_url <", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlLessThanOrEqualTo(String value) {
            addCriterion("advert_url <=", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlLike(String value) {
            addCriterion("advert_url like", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlNotLike(String value) {
            addCriterion("advert_url not like", value, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlIn(List<String> values) {
            addCriterion("advert_url in", values, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlNotIn(List<String> values) {
            addCriterion("advert_url not in", values, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlBetween(String value1, String value2) {
            addCriterion("advert_url between", value1, value2, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertUrlNotBetween(String value1, String value2) {
            addCriterion("advert_url not between", value1, value2, "advertUrl");
            return (Criteria) this;
        }

        public Criteria andAdvertIdIsNull() {
            addCriterion("advert_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvertIdIsNotNull() {
            addCriterion("advert_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertIdEqualTo(Long value) {
            addCriterion("advert_id =", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdNotEqualTo(Long value) {
            addCriterion("advert_id <>", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdGreaterThan(Long value) {
            addCriterion("advert_id >", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdGreaterThanOrEqualTo(Long value) {
            addCriterion("advert_id >=", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdLessThan(Long value) {
            addCriterion("advert_id <", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdLessThanOrEqualTo(Long value) {
            addCriterion("advert_id <=", value, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdIn(List<Long> values) {
            addCriterion("advert_id in", values, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdNotIn(List<Long> values) {
            addCriterion("advert_id not in", values, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdBetween(Long value1, Long value2) {
            addCriterion("advert_id between", value1, value2, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertIdNotBetween(Long value1, Long value2) {
            addCriterion("advert_id not between", value1, value2, "advertId");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIdIsNull() {
            addCriterion("advert_img_id is null");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIdIsNotNull() {
            addCriterion("advert_img_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIdEqualTo(Long value) {
            addCriterion("advert_img_id =", value, "advertImgId");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIdNotEqualTo(Long value) {
            addCriterion("advert_img_id <>", value, "advertImgId");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIdGreaterThan(Long value) {
            addCriterion("advert_img_id >", value, "advertImgId");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("advert_img_id >=", value, "advertImgId");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIdLessThan(Long value) {
            addCriterion("advert_img_id <", value, "advertImgId");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIdLessThanOrEqualTo(Long value) {
            addCriterion("advert_img_id <=", value, "advertImgId");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIdIn(List<Long> values) {
            addCriterion("advert_img_id in", values, "advertImgId");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIdNotIn(List<Long> values) {
            addCriterion("advert_img_id not in", values, "advertImgId");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIdBetween(Long value1, Long value2) {
            addCriterion("advert_img_id between", value1, value2, "advertImgId");
            return (Criteria) this;
        }

        public Criteria andAdvertImgIdNotBetween(Long value1, Long value2) {
            addCriterion("advert_img_id not between", value1, value2, "advertImgId");
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

        public Criteria andAdpIdIsNull() {
            addCriterion("adp_id is null");
            return (Criteria) this;
        }

        public Criteria andAdpIdIsNotNull() {
            addCriterion("adp_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdpIdEqualTo(Long value) {
            addCriterion("adp_id =", value, "adpId");
            return (Criteria) this;
        }

        public Criteria andAdpIdNotEqualTo(Long value) {
            addCriterion("adp_id <>", value, "adpId");
            return (Criteria) this;
        }

        public Criteria andAdpIdGreaterThan(Long value) {
            addCriterion("adp_id >", value, "adpId");
            return (Criteria) this;
        }

        public Criteria andAdpIdGreaterThanOrEqualTo(Long value) {
            addCriterion("adp_id >=", value, "adpId");
            return (Criteria) this;
        }

        public Criteria andAdpIdLessThan(Long value) {
            addCriterion("adp_id <", value, "adpId");
            return (Criteria) this;
        }

        public Criteria andAdpIdLessThanOrEqualTo(Long value) {
            addCriterion("adp_id <=", value, "adpId");
            return (Criteria) this;
        }

        public Criteria andAdpIdIn(List<Long> values) {
            addCriterion("adp_id in", values, "adpId");
            return (Criteria) this;
        }

        public Criteria andAdpIdNotIn(List<Long> values) {
            addCriterion("adp_id not in", values, "adpId");
            return (Criteria) this;
        }

        public Criteria andAdpIdBetween(Long value1, Long value2) {
            addCriterion("adp_id between", value1, value2, "adpId");
            return (Criteria) this;
        }

        public Criteria andAdpIdNotBetween(Long value1, Long value2) {
            addCriterion("adp_id not between", value1, value2, "adpId");
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