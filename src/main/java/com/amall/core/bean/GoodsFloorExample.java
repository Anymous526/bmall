package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class GoodsFloorExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsFloorExample() {
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

        public Criteria andGfCssIsNull() {
            addCriterion("gf_css is null");
            return (Criteria) this;
        }

        public Criteria andGfCssIsNotNull() {
            addCriterion("gf_css is not null");
            return (Criteria) this;
        }

        public Criteria andGfCssEqualTo(String value) {
            addCriterion("gf_css =", value, "gfCss");
            return (Criteria) this;
        }

        public Criteria andGfCssNotEqualTo(String value) {
            addCriterion("gf_css <>", value, "gfCss");
            return (Criteria) this;
        }

        public Criteria andGfCssGreaterThan(String value) {
            addCriterion("gf_css >", value, "gfCss");
            return (Criteria) this;
        }

        public Criteria andGfCssGreaterThanOrEqualTo(String value) {
            addCriterion("gf_css >=", value, "gfCss");
            return (Criteria) this;
        }

        public Criteria andGfCssLessThan(String value) {
            addCriterion("gf_css <", value, "gfCss");
            return (Criteria) this;
        }

        public Criteria andGfCssLessThanOrEqualTo(String value) {
            addCriterion("gf_css <=", value, "gfCss");
            return (Criteria) this;
        }

        public Criteria andGfCssLike(String value) {
            addCriterion("gf_css like", value, "gfCss");
            return (Criteria) this;
        }

        public Criteria andGfCssNotLike(String value) {
            addCriterion("gf_css not like", value, "gfCss");
            return (Criteria) this;
        }

        public Criteria andGfCssIn(List<String> values) {
            addCriterion("gf_css in", values, "gfCss");
            return (Criteria) this;
        }

        public Criteria andGfCssNotIn(List<String> values) {
            addCriterion("gf_css not in", values, "gfCss");
            return (Criteria) this;
        }

        public Criteria andGfCssBetween(String value1, String value2) {
            addCriterion("gf_css between", value1, value2, "gfCss");
            return (Criteria) this;
        }

        public Criteria andGfCssNotBetween(String value1, String value2) {
            addCriterion("gf_css not between", value1, value2, "gfCss");
            return (Criteria) this;
        }

        public Criteria andGfDisplayIsNull() {
            addCriterion("gf_display is null");
            return (Criteria) this;
        }

        public Criteria andGfDisplayIsNotNull() {
            addCriterion("gf_display is not null");
            return (Criteria) this;
        }

        public Criteria andGfDisplayEqualTo(Boolean value) {
            addCriterion("gf_display =", value, "gfDisplay");
            return (Criteria) this;
        }

        public Criteria andGfDisplayNotEqualTo(Boolean value) {
            addCriterion("gf_display <>", value, "gfDisplay");
            return (Criteria) this;
        }

        public Criteria andGfDisplayGreaterThan(Boolean value) {
            addCriterion("gf_display >", value, "gfDisplay");
            return (Criteria) this;
        }

        public Criteria andGfDisplayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("gf_display >=", value, "gfDisplay");
            return (Criteria) this;
        }

        public Criteria andGfDisplayLessThan(Boolean value) {
            addCriterion("gf_display <", value, "gfDisplay");
            return (Criteria) this;
        }

        public Criteria andGfDisplayLessThanOrEqualTo(Boolean value) {
            addCriterion("gf_display <=", value, "gfDisplay");
            return (Criteria) this;
        }

        public Criteria andGfDisplayIn(List<Boolean> values) {
            addCriterion("gf_display in", values, "gfDisplay");
            return (Criteria) this;
        }

        public Criteria andGfDisplayNotIn(List<Boolean> values) {
            addCriterion("gf_display not in", values, "gfDisplay");
            return (Criteria) this;
        }

        public Criteria andGfDisplayBetween(Boolean value1, Boolean value2) {
            addCriterion("gf_display between", value1, value2, "gfDisplay");
            return (Criteria) this;
        }

        public Criteria andGfDisplayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("gf_display not between", value1, value2, "gfDisplay");
            return (Criteria) this;
        }

        public Criteria andGfGoodsCountIsNull() {
            addCriterion("gf_goods_count is null");
            return (Criteria) this;
        }

        public Criteria andGfGoodsCountIsNotNull() {
            addCriterion("gf_goods_count is not null");
            return (Criteria) this;
        }

        public Criteria andGfGoodsCountEqualTo(Integer value) {
            addCriterion("gf_goods_count =", value, "gfGoodsCount");
            return (Criteria) this;
        }

        public Criteria andGfGoodsCountNotEqualTo(Integer value) {
            addCriterion("gf_goods_count <>", value, "gfGoodsCount");
            return (Criteria) this;
        }

        public Criteria andGfGoodsCountGreaterThan(Integer value) {
            addCriterion("gf_goods_count >", value, "gfGoodsCount");
            return (Criteria) this;
        }

        public Criteria andGfGoodsCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("gf_goods_count >=", value, "gfGoodsCount");
            return (Criteria) this;
        }

        public Criteria andGfGoodsCountLessThan(Integer value) {
            addCriterion("gf_goods_count <", value, "gfGoodsCount");
            return (Criteria) this;
        }

        public Criteria andGfGoodsCountLessThanOrEqualTo(Integer value) {
            addCriterion("gf_goods_count <=", value, "gfGoodsCount");
            return (Criteria) this;
        }

        public Criteria andGfGoodsCountIn(List<Integer> values) {
            addCriterion("gf_goods_count in", values, "gfGoodsCount");
            return (Criteria) this;
        }

        public Criteria andGfGoodsCountNotIn(List<Integer> values) {
            addCriterion("gf_goods_count not in", values, "gfGoodsCount");
            return (Criteria) this;
        }

        public Criteria andGfGoodsCountBetween(Integer value1, Integer value2) {
            addCriterion("gf_goods_count between", value1, value2, "gfGoodsCount");
            return (Criteria) this;
        }

        public Criteria andGfGoodsCountNotBetween(Integer value1, Integer value2) {
            addCriterion("gf_goods_count not between", value1, value2, "gfGoodsCount");
            return (Criteria) this;
        }

        public Criteria andGfLevelIsNull() {
            addCriterion("gf_level is null");
            return (Criteria) this;
        }

        public Criteria andGfLevelIsNotNull() {
            addCriterion("gf_level is not null");
            return (Criteria) this;
        }

        public Criteria andGfLevelEqualTo(Integer value) {
            addCriterion("gf_level =", value, "gfLevel");
            return (Criteria) this;
        }

        public Criteria andGfLevelNotEqualTo(Integer value) {
            addCriterion("gf_level <>", value, "gfLevel");
            return (Criteria) this;
        }

        public Criteria andGfLevelGreaterThan(Integer value) {
            addCriterion("gf_level >", value, "gfLevel");
            return (Criteria) this;
        }

        public Criteria andGfLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("gf_level >=", value, "gfLevel");
            return (Criteria) this;
        }

        public Criteria andGfLevelLessThan(Integer value) {
            addCriterion("gf_level <", value, "gfLevel");
            return (Criteria) this;
        }

        public Criteria andGfLevelLessThanOrEqualTo(Integer value) {
            addCriterion("gf_level <=", value, "gfLevel");
            return (Criteria) this;
        }

        public Criteria andGfLevelIn(List<Integer> values) {
            addCriterion("gf_level in", values, "gfLevel");
            return (Criteria) this;
        }

        public Criteria andGfLevelNotIn(List<Integer> values) {
            addCriterion("gf_level not in", values, "gfLevel");
            return (Criteria) this;
        }

        public Criteria andGfLevelBetween(Integer value1, Integer value2) {
            addCriterion("gf_level between", value1, value2, "gfLevel");
            return (Criteria) this;
        }

        public Criteria andGfLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("gf_level not between", value1, value2, "gfLevel");
            return (Criteria) this;
        }

        public Criteria andGfNameIsNull() {
            addCriterion("gf_name is null");
            return (Criteria) this;
        }

        public Criteria andGfNameIsNotNull() {
            addCriterion("gf_name is not null");
            return (Criteria) this;
        }

        public Criteria andGfNameEqualTo(String value) {
            addCriterion("gf_name =", value, "gfName");
            return (Criteria) this;
        }

        public Criteria andGfNameNotEqualTo(String value) {
            addCriterion("gf_name <>", value, "gfName");
            return (Criteria) this;
        }

        public Criteria andGfNameGreaterThan(String value) {
            addCriterion("gf_name >", value, "gfName");
            return (Criteria) this;
        }

        public Criteria andGfNameGreaterThanOrEqualTo(String value) {
            addCriterion("gf_name >=", value, "gfName");
            return (Criteria) this;
        }

        public Criteria andGfNameLessThan(String value) {
            addCriterion("gf_name <", value, "gfName");
            return (Criteria) this;
        }

        public Criteria andGfNameLessThanOrEqualTo(String value) {
            addCriterion("gf_name <=", value, "gfName");
            return (Criteria) this;
        }

        public Criteria andGfNameLike(String value) {
            addCriterion("gf_name like", value, "gfName");
            return (Criteria) this;
        }

        public Criteria andGfNameNotLike(String value) {
            addCriterion("gf_name not like", value, "gfName");
            return (Criteria) this;
        }

        public Criteria andGfNameIn(List<String> values) {
            addCriterion("gf_name in", values, "gfName");
            return (Criteria) this;
        }

        public Criteria andGfNameNotIn(List<String> values) {
            addCriterion("gf_name not in", values, "gfName");
            return (Criteria) this;
        }

        public Criteria andGfNameBetween(String value1, String value2) {
            addCriterion("gf_name between", value1, value2, "gfName");
            return (Criteria) this;
        }

        public Criteria andGfNameNotBetween(String value1, String value2) {
            addCriterion("gf_name not between", value1, value2, "gfName");
            return (Criteria) this;
        }

        public Criteria andGfSequenceIsNull() {
            addCriterion("gf_sequence is null");
            return (Criteria) this;
        }

        public Criteria andGfSequenceIsNotNull() {
            addCriterion("gf_sequence is not null");
            return (Criteria) this;
        }

        public Criteria andGfSequenceEqualTo(Integer value) {
            addCriterion("gf_sequence =", value, "gfSequence");
            return (Criteria) this;
        }

        public Criteria andGfSequenceNotEqualTo(Integer value) {
            addCriterion("gf_sequence <>", value, "gfSequence");
            return (Criteria) this;
        }

        public Criteria andGfSequenceGreaterThan(Integer value) {
            addCriterion("gf_sequence >", value, "gfSequence");
            return (Criteria) this;
        }

        public Criteria andGfSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("gf_sequence >=", value, "gfSequence");
            return (Criteria) this;
        }

        public Criteria andGfSequenceLessThan(Integer value) {
            addCriterion("gf_sequence <", value, "gfSequence");
            return (Criteria) this;
        }

        public Criteria andGfSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("gf_sequence <=", value, "gfSequence");
            return (Criteria) this;
        }

        public Criteria andGfSequenceIn(List<Integer> values) {
            addCriterion("gf_sequence in", values, "gfSequence");
            return (Criteria) this;
        }

        public Criteria andGfSequenceNotIn(List<Integer> values) {
            addCriterion("gf_sequence not in", values, "gfSequence");
            return (Criteria) this;
        }

        public Criteria andGfSequenceBetween(Integer value1, Integer value2) {
            addCriterion("gf_sequence between", value1, value2, "gfSequence");
            return (Criteria) this;
        }

        public Criteria andGfSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("gf_sequence not between", value1, value2, "gfSequence");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }
        
        public Criteria andGfMarkEqualTo(String value) {
            addCriterion("gf_mark =", value, "gfMark");
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