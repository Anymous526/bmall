package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class GroupGoodsExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GroupGoodsExample() {
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

        public Criteria andGgAuditTimeIsNull() {
            addCriterion("gg_audit_time is null");
            return (Criteria) this;
        }

        public Criteria andGgAuditTimeIsNotNull() {
            addCriterion("gg_audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andGgAuditTimeEqualTo(Date value) {
            addCriterion("gg_audit_time =", value, "ggAuditTime");
            return (Criteria) this;
        }

        public Criteria andGgAuditTimeNotEqualTo(Date value) {
            addCriterion("gg_audit_time <>", value, "ggAuditTime");
            return (Criteria) this;
        }

        public Criteria andGgAuditTimeGreaterThan(Date value) {
            addCriterion("gg_audit_time >", value, "ggAuditTime");
            return (Criteria) this;
        }

        public Criteria andGgAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gg_audit_time >=", value, "ggAuditTime");
            return (Criteria) this;
        }

        public Criteria andGgAuditTimeLessThan(Date value) {
            addCriterion("gg_audit_time <", value, "ggAuditTime");
            return (Criteria) this;
        }

        public Criteria andGgAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("gg_audit_time <=", value, "ggAuditTime");
            return (Criteria) this;
        }

        public Criteria andGgAuditTimeIn(List<Date> values) {
            addCriterion("gg_audit_time in", values, "ggAuditTime");
            return (Criteria) this;
        }

        public Criteria andGgAuditTimeNotIn(List<Date> values) {
            addCriterion("gg_audit_time not in", values, "ggAuditTime");
            return (Criteria) this;
        }

        public Criteria andGgAuditTimeBetween(Date value1, Date value2) {
            addCriterion("gg_audit_time between", value1, value2, "ggAuditTime");
            return (Criteria) this;
        }

        public Criteria andGgAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("gg_audit_time not between", value1, value2, "ggAuditTime");
            return (Criteria) this;
        }

        public Criteria andGgCountIsNull() {
            addCriterion("gg_count is null");
            return (Criteria) this;
        }

        public Criteria andGgCountIsNotNull() {
            addCriterion("gg_count is not null");
            return (Criteria) this;
        }

        public Criteria andGgCountEqualTo(Integer value) {
            addCriterion("gg_count =", value, "ggCount");
            return (Criteria) this;
        }

        public Criteria andGgCountNotEqualTo(Integer value) {
            addCriterion("gg_count <>", value, "ggCount");
            return (Criteria) this;
        }

        public Criteria andGgCountGreaterThan(Integer value) {
            addCriterion("gg_count >", value, "ggCount");
            return (Criteria) this;
        }

        public Criteria andGgCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("gg_count >=", value, "ggCount");
            return (Criteria) this;
        }

        public Criteria andGgCountLessThan(Integer value) {
            addCriterion("gg_count <", value, "ggCount");
            return (Criteria) this;
        }

        public Criteria andGgCountLessThanOrEqualTo(Integer value) {
            addCriterion("gg_count <=", value, "ggCount");
            return (Criteria) this;
        }

        public Criteria andGgCountIn(List<Integer> values) {
            addCriterion("gg_count in", values, "ggCount");
            return (Criteria) this;
        }

        public Criteria andGgCountNotIn(List<Integer> values) {
            addCriterion("gg_count not in", values, "ggCount");
            return (Criteria) this;
        }

        public Criteria andGgCountBetween(Integer value1, Integer value2) {
            addCriterion("gg_count between", value1, value2, "ggCount");
            return (Criteria) this;
        }

        public Criteria andGgCountNotBetween(Integer value1, Integer value2) {
            addCriterion("gg_count not between", value1, value2, "ggCount");
            return (Criteria) this;
        }

        public Criteria andGgDefCountIsNull() {
            addCriterion("gg_def_count is null");
            return (Criteria) this;
        }

        public Criteria andGgDefCountIsNotNull() {
            addCriterion("gg_def_count is not null");
            return (Criteria) this;
        }

        public Criteria andGgDefCountEqualTo(Integer value) {
            addCriterion("gg_def_count =", value, "ggDefCount");
            return (Criteria) this;
        }

        public Criteria andGgDefCountNotEqualTo(Integer value) {
            addCriterion("gg_def_count <>", value, "ggDefCount");
            return (Criteria) this;
        }

        public Criteria andGgDefCountGreaterThan(Integer value) {
            addCriterion("gg_def_count >", value, "ggDefCount");
            return (Criteria) this;
        }

        public Criteria andGgDefCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("gg_def_count >=", value, "ggDefCount");
            return (Criteria) this;
        }

        public Criteria andGgDefCountLessThan(Integer value) {
            addCriterion("gg_def_count <", value, "ggDefCount");
            return (Criteria) this;
        }

        public Criteria andGgDefCountLessThanOrEqualTo(Integer value) {
            addCriterion("gg_def_count <=", value, "ggDefCount");
            return (Criteria) this;
        }

        public Criteria andGgDefCountIn(List<Integer> values) {
            addCriterion("gg_def_count in", values, "ggDefCount");
            return (Criteria) this;
        }

        public Criteria andGgDefCountNotIn(List<Integer> values) {
            addCriterion("gg_def_count not in", values, "ggDefCount");
            return (Criteria) this;
        }

        public Criteria andGgDefCountBetween(Integer value1, Integer value2) {
            addCriterion("gg_def_count between", value1, value2, "ggDefCount");
            return (Criteria) this;
        }

        public Criteria andGgDefCountNotBetween(Integer value1, Integer value2) {
            addCriterion("gg_def_count not between", value1, value2, "ggDefCount");
            return (Criteria) this;
        }

        public Criteria andGgGroupCountIsNull() {
            addCriterion("gg_group_count is null");
            return (Criteria) this;
        }

        public Criteria andGgGroupCountIsNotNull() {
            addCriterion("gg_group_count is not null");
            return (Criteria) this;
        }

        public Criteria andGgGroupCountEqualTo(Integer value) {
            addCriterion("gg_group_count =", value, "ggGroupCount");
            return (Criteria) this;
        }

        public Criteria andGgGroupCountNotEqualTo(Integer value) {
            addCriterion("gg_group_count <>", value, "ggGroupCount");
            return (Criteria) this;
        }

        public Criteria andGgGroupCountGreaterThan(Integer value) {
            addCriterion("gg_group_count >", value, "ggGroupCount");
            return (Criteria) this;
        }

        public Criteria andGgGroupCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("gg_group_count >=", value, "ggGroupCount");
            return (Criteria) this;
        }

        public Criteria andGgGroupCountLessThan(Integer value) {
            addCriterion("gg_group_count <", value, "ggGroupCount");
            return (Criteria) this;
        }

        public Criteria andGgGroupCountLessThanOrEqualTo(Integer value) {
            addCriterion("gg_group_count <=", value, "ggGroupCount");
            return (Criteria) this;
        }

        public Criteria andGgGroupCountIn(List<Integer> values) {
            addCriterion("gg_group_count in", values, "ggGroupCount");
            return (Criteria) this;
        }

        public Criteria andGgGroupCountNotIn(List<Integer> values) {
            addCriterion("gg_group_count not in", values, "ggGroupCount");
            return (Criteria) this;
        }

        public Criteria andGgGroupCountBetween(Integer value1, Integer value2) {
            addCriterion("gg_group_count between", value1, value2, "ggGroupCount");
            return (Criteria) this;
        }

        public Criteria andGgGroupCountNotBetween(Integer value1, Integer value2) {
            addCriterion("gg_group_count not between", value1, value2, "ggGroupCount");
            return (Criteria) this;
        }

        public Criteria andGgMaxCountIsNull() {
            addCriterion("gg_max_count is null");
            return (Criteria) this;
        }

        public Criteria andGgMaxCountIsNotNull() {
            addCriterion("gg_max_count is not null");
            return (Criteria) this;
        }

        public Criteria andGgMaxCountEqualTo(Integer value) {
            addCriterion("gg_max_count =", value, "ggMaxCount");
            return (Criteria) this;
        }

        public Criteria andGgMaxCountNotEqualTo(Integer value) {
            addCriterion("gg_max_count <>", value, "ggMaxCount");
            return (Criteria) this;
        }

        public Criteria andGgMaxCountGreaterThan(Integer value) {
            addCriterion("gg_max_count >", value, "ggMaxCount");
            return (Criteria) this;
        }

        public Criteria andGgMaxCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("gg_max_count >=", value, "ggMaxCount");
            return (Criteria) this;
        }

        public Criteria andGgMaxCountLessThan(Integer value) {
            addCriterion("gg_max_count <", value, "ggMaxCount");
            return (Criteria) this;
        }

        public Criteria andGgMaxCountLessThanOrEqualTo(Integer value) {
            addCriterion("gg_max_count <=", value, "ggMaxCount");
            return (Criteria) this;
        }

        public Criteria andGgMaxCountIn(List<Integer> values) {
            addCriterion("gg_max_count in", values, "ggMaxCount");
            return (Criteria) this;
        }

        public Criteria andGgMaxCountNotIn(List<Integer> values) {
            addCriterion("gg_max_count not in", values, "ggMaxCount");
            return (Criteria) this;
        }

        public Criteria andGgMaxCountBetween(Integer value1, Integer value2) {
            addCriterion("gg_max_count between", value1, value2, "ggMaxCount");
            return (Criteria) this;
        }

        public Criteria andGgMaxCountNotBetween(Integer value1, Integer value2) {
            addCriterion("gg_max_count not between", value1, value2, "ggMaxCount");
            return (Criteria) this;
        }

        public Criteria andGgMinCountIsNull() {
            addCriterion("gg_min_count is null");
            return (Criteria) this;
        }

        public Criteria andGgMinCountIsNotNull() {
            addCriterion("gg_min_count is not null");
            return (Criteria) this;
        }

        public Criteria andGgMinCountEqualTo(Integer value) {
            addCriterion("gg_min_count =", value, "ggMinCount");
            return (Criteria) this;
        }

        public Criteria andGgMinCountNotEqualTo(Integer value) {
            addCriterion("gg_min_count <>", value, "ggMinCount");
            return (Criteria) this;
        }

        public Criteria andGgMinCountGreaterThan(Integer value) {
            addCriterion("gg_min_count >", value, "ggMinCount");
            return (Criteria) this;
        }

        public Criteria andGgMinCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("gg_min_count >=", value, "ggMinCount");
            return (Criteria) this;
        }

        public Criteria andGgMinCountLessThan(Integer value) {
            addCriterion("gg_min_count <", value, "ggMinCount");
            return (Criteria) this;
        }

        public Criteria andGgMinCountLessThanOrEqualTo(Integer value) {
            addCriterion("gg_min_count <=", value, "ggMinCount");
            return (Criteria) this;
        }

        public Criteria andGgMinCountIn(List<Integer> values) {
            addCriterion("gg_min_count in", values, "ggMinCount");
            return (Criteria) this;
        }

        public Criteria andGgMinCountNotIn(List<Integer> values) {
            addCriterion("gg_min_count not in", values, "ggMinCount");
            return (Criteria) this;
        }

        public Criteria andGgMinCountBetween(Integer value1, Integer value2) {
            addCriterion("gg_min_count between", value1, value2, "ggMinCount");
            return (Criteria) this;
        }

        public Criteria andGgMinCountNotBetween(Integer value1, Integer value2) {
            addCriterion("gg_min_count not between", value1, value2, "ggMinCount");
            return (Criteria) this;
        }

        public Criteria andGgNameIsNull() {
            addCriterion("gg_name is null");
            return (Criteria) this;
        }

        public Criteria andGgNameIsNotNull() {
            addCriterion("gg_name is not null");
            return (Criteria) this;
        }

        public Criteria andGgNameEqualTo(String value) {
            addCriterion("gg_name =", value, "ggName");
            return (Criteria) this;
        }

        public Criteria andGgNameNotEqualTo(String value) {
            addCriterion("gg_name <>", value, "ggName");
            return (Criteria) this;
        }

        public Criteria andGgNameGreaterThan(String value) {
            addCriterion("gg_name >", value, "ggName");
            return (Criteria) this;
        }

        public Criteria andGgNameGreaterThanOrEqualTo(String value) {
            addCriterion("gg_name >=", value, "ggName");
            return (Criteria) this;
        }

        public Criteria andGgNameLessThan(String value) {
            addCriterion("gg_name <", value, "ggName");
            return (Criteria) this;
        }

        public Criteria andGgNameLessThanOrEqualTo(String value) {
            addCriterion("gg_name <=", value, "ggName");
            return (Criteria) this;
        }

        public Criteria andGgNameLike(String value) {
            addCriterion("gg_name like", value, "ggName");
            return (Criteria) this;
        }

        public Criteria andGgNameNotLike(String value) {
            addCriterion("gg_name not like", value, "ggName");
            return (Criteria) this;
        }

        public Criteria andGgNameIn(List<String> values) {
            addCriterion("gg_name in", values, "ggName");
            return (Criteria) this;
        }

        public Criteria andGgNameNotIn(List<String> values) {
            addCriterion("gg_name not in", values, "ggName");
            return (Criteria) this;
        }

        public Criteria andGgNameBetween(String value1, String value2) {
            addCriterion("gg_name between", value1, value2, "ggName");
            return (Criteria) this;
        }

        public Criteria andGgNameNotBetween(String value1, String value2) {
            addCriterion("gg_name not between", value1, value2, "ggName");
            return (Criteria) this;
        }

        public Criteria andGgPriceIsNull() {
            addCriterion("gg_price is null");
            return (Criteria) this;
        }

        public Criteria andGgPriceIsNotNull() {
            addCriterion("gg_price is not null");
            return (Criteria) this;
        }

        public Criteria andGgPriceEqualTo(BigDecimal value) {
            addCriterion("gg_price =", value, "ggPrice");
            return (Criteria) this;
        }

        public Criteria andGgPriceNotEqualTo(BigDecimal value) {
            addCriterion("gg_price <>", value, "ggPrice");
            return (Criteria) this;
        }

        public Criteria andGgPriceGreaterThan(BigDecimal value) {
            addCriterion("gg_price >", value, "ggPrice");
            return (Criteria) this;
        }

        public Criteria andGgPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gg_price >=", value, "ggPrice");
            return (Criteria) this;
        }

        public Criteria andGgPriceLessThan(BigDecimal value) {
            addCriterion("gg_price <", value, "ggPrice");
            return (Criteria) this;
        }

        public Criteria andGgPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gg_price <=", value, "ggPrice");
            return (Criteria) this;
        }

        public Criteria andGgPriceIn(List<BigDecimal> values) {
            addCriterion("gg_price in", values, "ggPrice");
            return (Criteria) this;
        }

        public Criteria andGgPriceNotIn(List<BigDecimal> values) {
            addCriterion("gg_price not in", values, "ggPrice");
            return (Criteria) this;
        }

        public Criteria andGgPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gg_price between", value1, value2, "ggPrice");
            return (Criteria) this;
        }

        public Criteria andGgPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gg_price not between", value1, value2, "ggPrice");
            return (Criteria) this;
        }

        public Criteria andGgRebateIsNull() {
            addCriterion("gg_rebate is null");
            return (Criteria) this;
        }

        public Criteria andGgRebateIsNotNull() {
            addCriterion("gg_rebate is not null");
            return (Criteria) this;
        }

        public Criteria andGgRebateEqualTo(BigDecimal value) {
            addCriterion("gg_rebate =", value, "ggRebate");
            return (Criteria) this;
        }

        public Criteria andGgRebateNotEqualTo(BigDecimal value) {
            addCriterion("gg_rebate <>", value, "ggRebate");
            return (Criteria) this;
        }

        public Criteria andGgRebateGreaterThan(BigDecimal value) {
            addCriterion("gg_rebate >", value, "ggRebate");
            return (Criteria) this;
        }

        public Criteria andGgRebateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gg_rebate >=", value, "ggRebate");
            return (Criteria) this;
        }

        public Criteria andGgRebateLessThan(BigDecimal value) {
            addCriterion("gg_rebate <", value, "ggRebate");
            return (Criteria) this;
        }

        public Criteria andGgRebateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gg_rebate <=", value, "ggRebate");
            return (Criteria) this;
        }

        public Criteria andGgRebateIn(List<BigDecimal> values) {
            addCriterion("gg_rebate in", values, "ggRebate");
            return (Criteria) this;
        }

        public Criteria andGgRebateNotIn(List<BigDecimal> values) {
            addCriterion("gg_rebate not in", values, "ggRebate");
            return (Criteria) this;
        }

        public Criteria andGgRebateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gg_rebate between", value1, value2, "ggRebate");
            return (Criteria) this;
        }

        public Criteria andGgRebateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gg_rebate not between", value1, value2, "ggRebate");
            return (Criteria) this;
        }

        public Criteria andGgRecommendIsNull() {
            addCriterion("gg_recommend is null");
            return (Criteria) this;
        }

        public Criteria andGgRecommendIsNotNull() {
            addCriterion("gg_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andGgRecommendEqualTo(Integer value) {
            addCriterion("gg_recommend =", value, "ggRecommend");
            return (Criteria) this;
        }

        public Criteria andGgRecommendNotEqualTo(Integer value) {
            addCriterion("gg_recommend <>", value, "ggRecommend");
            return (Criteria) this;
        }

        public Criteria andGgRecommendGreaterThan(Integer value) {
            addCriterion("gg_recommend >", value, "ggRecommend");
            return (Criteria) this;
        }

        public Criteria andGgRecommendGreaterThanOrEqualTo(Integer value) {
            addCriterion("gg_recommend >=", value, "ggRecommend");
            return (Criteria) this;
        }

        public Criteria andGgRecommendLessThan(Integer value) {
            addCriterion("gg_recommend <", value, "ggRecommend");
            return (Criteria) this;
        }

        public Criteria andGgRecommendLessThanOrEqualTo(Integer value) {
            addCriterion("gg_recommend <=", value, "ggRecommend");
            return (Criteria) this;
        }

        public Criteria andGgRecommendIn(List<Integer> values) {
            addCriterion("gg_recommend in", values, "ggRecommend");
            return (Criteria) this;
        }

        public Criteria andGgRecommendNotIn(List<Integer> values) {
            addCriterion("gg_recommend not in", values, "ggRecommend");
            return (Criteria) this;
        }

        public Criteria andGgRecommendBetween(Integer value1, Integer value2) {
            addCriterion("gg_recommend between", value1, value2, "ggRecommend");
            return (Criteria) this;
        }

        public Criteria andGgRecommendNotBetween(Integer value1, Integer value2) {
            addCriterion("gg_recommend not between", value1, value2, "ggRecommend");
            return (Criteria) this;
        }

        public Criteria andGgRecommendTimeIsNull() {
            addCriterion("gg_recommend_time is null");
            return (Criteria) this;
        }

        public Criteria andGgRecommendTimeIsNotNull() {
            addCriterion("gg_recommend_time is not null");
            return (Criteria) this;
        }

        public Criteria andGgRecommendTimeEqualTo(Date value) {
            addCriterion("gg_recommend_time =", value, "ggRecommendTime");
            return (Criteria) this;
        }

        public Criteria andGgRecommendTimeNotEqualTo(Date value) {
            addCriterion("gg_recommend_time <>", value, "ggRecommendTime");
            return (Criteria) this;
        }

        public Criteria andGgRecommendTimeGreaterThan(Date value) {
            addCriterion("gg_recommend_time >", value, "ggRecommendTime");
            return (Criteria) this;
        }

        public Criteria andGgRecommendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("gg_recommend_time >=", value, "ggRecommendTime");
            return (Criteria) this;
        }

        public Criteria andGgRecommendTimeLessThan(Date value) {
            addCriterion("gg_recommend_time <", value, "ggRecommendTime");
            return (Criteria) this;
        }

        public Criteria andGgRecommendTimeLessThanOrEqualTo(Date value) {
            addCriterion("gg_recommend_time <=", value, "ggRecommendTime");
            return (Criteria) this;
        }

        public Criteria andGgRecommendTimeIn(List<Date> values) {
            addCriterion("gg_recommend_time in", values, "ggRecommendTime");
            return (Criteria) this;
        }

        public Criteria andGgRecommendTimeNotIn(List<Date> values) {
            addCriterion("gg_recommend_time not in", values, "ggRecommendTime");
            return (Criteria) this;
        }

        public Criteria andGgRecommendTimeBetween(Date value1, Date value2) {
            addCriterion("gg_recommend_time between", value1, value2, "ggRecommendTime");
            return (Criteria) this;
        }

        public Criteria andGgRecommendTimeNotBetween(Date value1, Date value2) {
            addCriterion("gg_recommend_time not between", value1, value2, "ggRecommendTime");
            return (Criteria) this;
        }

        public Criteria andGgStatusIsNull() {
            addCriterion("gg_status is null");
            return (Criteria) this;
        }

        public Criteria andGgStatusIsNotNull() {
            addCriterion("gg_status is not null");
            return (Criteria) this;
        }

        public Criteria andGgStatusEqualTo(Integer value) {
            addCriterion("gg_status =", value, "ggStatus");
            return (Criteria) this;
        }

        public Criteria andGgStatusNotEqualTo(Integer value) {
            addCriterion("gg_status <>", value, "ggStatus");
            return (Criteria) this;
        }

        public Criteria andGgStatusGreaterThan(Integer value) {
            addCriterion("gg_status >", value, "ggStatus");
            return (Criteria) this;
        }

        public Criteria andGgStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("gg_status >=", value, "ggStatus");
            return (Criteria) this;
        }

        public Criteria andGgStatusLessThan(Integer value) {
            addCriterion("gg_status <", value, "ggStatus");
            return (Criteria) this;
        }

        public Criteria andGgStatusLessThanOrEqualTo(Integer value) {
            addCriterion("gg_status <=", value, "ggStatus");
            return (Criteria) this;
        }

        public Criteria andGgStatusIn(List<Integer> values) {
            addCriterion("gg_status in", values, "ggStatus");
            return (Criteria) this;
        }

        public Criteria andGgStatusNotIn(List<Integer> values) {
            addCriterion("gg_status not in", values, "ggStatus");
            return (Criteria) this;
        }

        public Criteria andGgStatusBetween(Integer value1, Integer value2) {
            addCriterion("gg_status between", value1, value2, "ggStatus");
            return (Criteria) this;
        }

        public Criteria andGgStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("gg_status not between", value1, value2, "ggStatus");
            return (Criteria) this;
        }

        public Criteria andGgVirCountIsNull() {
            addCriterion("gg_vir_count is null");
            return (Criteria) this;
        }

        public Criteria andGgVirCountIsNotNull() {
            addCriterion("gg_vir_count is not null");
            return (Criteria) this;
        }

        public Criteria andGgVirCountEqualTo(Integer value) {
            addCriterion("gg_vir_count =", value, "ggVirCount");
            return (Criteria) this;
        }

        public Criteria andGgVirCountNotEqualTo(Integer value) {
            addCriterion("gg_vir_count <>", value, "ggVirCount");
            return (Criteria) this;
        }

        public Criteria andGgVirCountGreaterThan(Integer value) {
            addCriterion("gg_vir_count >", value, "ggVirCount");
            return (Criteria) this;
        }

        public Criteria andGgVirCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("gg_vir_count >=", value, "ggVirCount");
            return (Criteria) this;
        }

        public Criteria andGgVirCountLessThan(Integer value) {
            addCriterion("gg_vir_count <", value, "ggVirCount");
            return (Criteria) this;
        }

        public Criteria andGgVirCountLessThanOrEqualTo(Integer value) {
            addCriterion("gg_vir_count <=", value, "ggVirCount");
            return (Criteria) this;
        }

        public Criteria andGgVirCountIn(List<Integer> values) {
            addCriterion("gg_vir_count in", values, "ggVirCount");
            return (Criteria) this;
        }

        public Criteria andGgVirCountNotIn(List<Integer> values) {
            addCriterion("gg_vir_count not in", values, "ggVirCount");
            return (Criteria) this;
        }

        public Criteria andGgVirCountBetween(Integer value1, Integer value2) {
            addCriterion("gg_vir_count between", value1, value2, "ggVirCount");
            return (Criteria) this;
        }

        public Criteria andGgVirCountNotBetween(Integer value1, Integer value2) {
            addCriterion("gg_vir_count not between", value1, value2, "ggVirCount");
            return (Criteria) this;
        }

        public Criteria andGgGaIdIsNull() {
            addCriterion("gg_ga_id is null");
            return (Criteria) this;
        }

        public Criteria andGgGaIdIsNotNull() {
            addCriterion("gg_ga_id is not null");
            return (Criteria) this;
        }

        public Criteria andGgGaIdEqualTo(Long value) {
            addCriterion("gg_ga_id =", value, "ggGaId");
            return (Criteria) this;
        }

        public Criteria andGgGaIdNotEqualTo(Long value) {
            addCriterion("gg_ga_id <>", value, "ggGaId");
            return (Criteria) this;
        }

        public Criteria andGgGaIdGreaterThan(Long value) {
            addCriterion("gg_ga_id >", value, "ggGaId");
            return (Criteria) this;
        }

        public Criteria andGgGaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("gg_ga_id >=", value, "ggGaId");
            return (Criteria) this;
        }

        public Criteria andGgGaIdLessThan(Long value) {
            addCriterion("gg_ga_id <", value, "ggGaId");
            return (Criteria) this;
        }

        public Criteria andGgGaIdLessThanOrEqualTo(Long value) {
            addCriterion("gg_ga_id <=", value, "ggGaId");
            return (Criteria) this;
        }

        public Criteria andGgGaIdIn(List<Long> values) {
            addCriterion("gg_ga_id in", values, "ggGaId");
            return (Criteria) this;
        }

        public Criteria andGgGaIdNotIn(List<Long> values) {
            addCriterion("gg_ga_id not in", values, "ggGaId");
            return (Criteria) this;
        }

        public Criteria andGgGaIdBetween(Long value1, Long value2) {
            addCriterion("gg_ga_id between", value1, value2, "ggGaId");
            return (Criteria) this;
        }

        public Criteria andGgGaIdNotBetween(Long value1, Long value2) {
            addCriterion("gg_ga_id not between", value1, value2, "ggGaId");
            return (Criteria) this;
        }

        public Criteria andGgGcIdIsNull() {
            addCriterion("gg_gc_id is null");
            return (Criteria) this;
        }

        public Criteria andGgGcIdIsNotNull() {
            addCriterion("gg_gc_id is not null");
            return (Criteria) this;
        }

        public Criteria andGgGcIdEqualTo(Long value) {
            addCriterion("gg_gc_id =", value, "ggGcId");
            return (Criteria) this;
        }

        public Criteria andGgGcIdNotEqualTo(Long value) {
            addCriterion("gg_gc_id <>", value, "ggGcId");
            return (Criteria) this;
        }

        public Criteria andGgGcIdGreaterThan(Long value) {
            addCriterion("gg_gc_id >", value, "ggGcId");
            return (Criteria) this;
        }

        public Criteria andGgGcIdGreaterThanOrEqualTo(Long value) {
            addCriterion("gg_gc_id >=", value, "ggGcId");
            return (Criteria) this;
        }

        public Criteria andGgGcIdLessThan(Long value) {
            addCriterion("gg_gc_id <", value, "ggGcId");
            return (Criteria) this;
        }

        public Criteria andGgGcIdLessThanOrEqualTo(Long value) {
            addCriterion("gg_gc_id <=", value, "ggGcId");
            return (Criteria) this;
        }

        public Criteria andGgGcIdIn(List<Long> values) {
            addCriterion("gg_gc_id in", values, "ggGcId");
            return (Criteria) this;
        }

        public Criteria andGgGcIdNotIn(List<Long> values) {
            addCriterion("gg_gc_id not in", values, "ggGcId");
            return (Criteria) this;
        }

        public Criteria andGgGcIdBetween(Long value1, Long value2) {
            addCriterion("gg_gc_id between", value1, value2, "ggGcId");
            return (Criteria) this;
        }

        public Criteria andGgGcIdNotBetween(Long value1, Long value2) {
            addCriterion("gg_gc_id not between", value1, value2, "ggGcId");
            return (Criteria) this;
        }

        public Criteria andGgGoodsIdIsNull() {
            addCriterion("gg_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGgGoodsIdIsNotNull() {
            addCriterion("gg_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGgGoodsIdEqualTo(Long value) {
            addCriterion("gg_goods_id =", value, "ggGoodsId");
            return (Criteria) this;
        }

        public Criteria andGgGoodsIdNotEqualTo(Long value) {
            addCriterion("gg_goods_id <>", value, "ggGoodsId");
            return (Criteria) this;
        }

        public Criteria andGgGoodsIdGreaterThan(Long value) {
            addCriterion("gg_goods_id >", value, "ggGoodsId");
            return (Criteria) this;
        }

        public Criteria andGgGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("gg_goods_id >=", value, "ggGoodsId");
            return (Criteria) this;
        }

        public Criteria andGgGoodsIdLessThan(Long value) {
            addCriterion("gg_goods_id <", value, "ggGoodsId");
            return (Criteria) this;
        }

        public Criteria andGgGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("gg_goods_id <=", value, "ggGoodsId");
            return (Criteria) this;
        }

        public Criteria andGgGoodsIdIn(List<Long> values) {
            addCriterion("gg_goods_id in", values, "ggGoodsId");
            return (Criteria) this;
        }

        public Criteria andGgGoodsIdNotIn(List<Long> values) {
            addCriterion("gg_goods_id not in", values, "ggGoodsId");
            return (Criteria) this;
        }

        public Criteria andGgGoodsIdBetween(Long value1, Long value2) {
            addCriterion("gg_goods_id between", value1, value2, "ggGoodsId");
            return (Criteria) this;
        }

        public Criteria andGgGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("gg_goods_id not between", value1, value2, "ggGoodsId");
            return (Criteria) this;
        }

        public Criteria andGgImgIdIsNull() {
            addCriterion("gg_img_id is null");
            return (Criteria) this;
        }

        public Criteria andGgImgIdIsNotNull() {
            addCriterion("gg_img_id is not null");
            return (Criteria) this;
        }

        public Criteria andGgImgIdEqualTo(Long value) {
            addCriterion("gg_img_id =", value, "ggImgId");
            return (Criteria) this;
        }

        public Criteria andGgImgIdNotEqualTo(Long value) {
            addCriterion("gg_img_id <>", value, "ggImgId");
            return (Criteria) this;
        }

        public Criteria andGgImgIdGreaterThan(Long value) {
            addCriterion("gg_img_id >", value, "ggImgId");
            return (Criteria) this;
        }

        public Criteria andGgImgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("gg_img_id >=", value, "ggImgId");
            return (Criteria) this;
        }

        public Criteria andGgImgIdLessThan(Long value) {
            addCriterion("gg_img_id <", value, "ggImgId");
            return (Criteria) this;
        }

        public Criteria andGgImgIdLessThanOrEqualTo(Long value) {
            addCriterion("gg_img_id <=", value, "ggImgId");
            return (Criteria) this;
        }

        public Criteria andGgImgIdIn(List<Long> values) {
            addCriterion("gg_img_id in", values, "ggImgId");
            return (Criteria) this;
        }

        public Criteria andGgImgIdNotIn(List<Long> values) {
            addCriterion("gg_img_id not in", values, "ggImgId");
            return (Criteria) this;
        }

        public Criteria andGgImgIdBetween(Long value1, Long value2) {
            addCriterion("gg_img_id between", value1, value2, "ggImgId");
            return (Criteria) this;
        }

        public Criteria andGgImgIdNotBetween(Long value1, Long value2) {
            addCriterion("gg_img_id not between", value1, value2, "ggImgId");
            return (Criteria) this;
        }
        
        public Criteria andGgImgId2IsNull() {
            addCriterion("gg_img_id2 is null");
            return (Criteria) this;
        }

        public Criteria andGgImgId2IsNotNull() {
            addCriterion("gg_img_id2 is not null");
            return (Criteria) this;
        }

        public Criteria andGgImgId2EqualTo(Long value) {
            addCriterion("gg_img_id2 =", value, "ggImgId2");
            return (Criteria) this;
        }

        public Criteria andGgImgId2NotEqualTo(Long value) {
            addCriterion("gg_img_id2 <>", value, "ggImgId2");
            return (Criteria) this;
        }

        public Criteria andGgImgId2GreaterThan(Long value) {
            addCriterion("gg_img_id2 >", value, "ggImgId2");
            return (Criteria) this;
        }

        public Criteria andGgImgId2GreaterThanOrEqualTo(Long value) {
            addCriterion("gg_img_id2 >=", value, "ggImgId2");
            return (Criteria) this;
        }

        public Criteria andGgImgId2LessThan(Long value) {
            addCriterion("gg_img_id2 <", value, "ggImgId2");
            return (Criteria) this;
        }

        public Criteria andGgImgId2LessThanOrEqualTo(Long value) {
            addCriterion("gg_img_id2 <=", value, "ggImgId2");
            return (Criteria) this;
        }

        public Criteria andGgImgId2In(List<Long> values) {
            addCriterion("gg_img_id2 in", values, "ggImgId2");
            return (Criteria) this;
        }

        public Criteria andGgImgId2NotIn(List<Long> values) {
            addCriterion("gg_img_id2 not in", values, "ggImgId2");
            return (Criteria) this;
        }

        public Criteria andGgImgId2Between(Long value1, Long value2) {
            addCriterion("gg_img_id2 between", value1, value2, "ggImgId2");
            return (Criteria) this;
        }

        public Criteria andGgImgId2NotBetween(Long value1, Long value2) {
            addCriterion("gg_img_id2 not between", value1, value2, "ggImgId2");
            return (Criteria) this;
        }
        
        public Criteria andGgImgId3IsNull() {
            addCriterion("gg_img_id3 is null");
            return (Criteria) this;
        }

        public Criteria andGgImgId3IsNotNull() {
            addCriterion("gg_img_id3 is not null");
            return (Criteria) this;
        }

        public Criteria andGgImgId3EqualTo(Long value) {
            addCriterion("gg_img_id3 =", value, "ggImgId3");
            return (Criteria) this;
        }

        public Criteria andGgImgId3NotEqualTo(Long value) {
            addCriterion("gg_img_id3 <>", value, "ggImgId3");
            return (Criteria) this;
        }

        public Criteria andGgImgId3GreaterThan(Long value) {
            addCriterion("gg_img_id3 >", value, "ggImgId3");
            return (Criteria) this;
        }

        public Criteria andGgImgId3GreaterThanOrEqualTo(Long value) {
            addCriterion("gg_img_id3 >=", value, "ggImgId3");
            return (Criteria) this;
        }

        public Criteria andGgImgId3LessThan(Long value) {
            addCriterion("gg_img_id3 <", value, "ggImgId3");
            return (Criteria) this;
        }

        public Criteria andGgImgId3LessThanOrEqualTo(Long value) {
            addCriterion("gg_img_id3 <=", value, "ggImgId3");
            return (Criteria) this;
        }

        public Criteria andGgImgId3In(List<Long> values) {
            addCriterion("gg_img_id3 in", values, "ggImgId3");
            return (Criteria) this;
        }

        public Criteria andGgImgId3NotIn(List<Long> values) {
            addCriterion("gg_img_id3 not in", values, "ggImgId3");
            return (Criteria) this;
        }

        public Criteria andGgImgId3Between(Long value1, Long value2) {
            addCriterion("gg_img_id3 between", value1, value2, "ggImgId3");
            return (Criteria) this;
        }

        public Criteria andGgImgId3NotBetween(Long value1, Long value2) {
            addCriterion("gg_img_id3 not between", value1, value2, "ggImgId3");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Long value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Long value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Long value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Long value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Long> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Long> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Long value1, Long value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendIsNull() {
            addCriterion("weixin_shop_recommend is null");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendIsNotNull() {
            addCriterion("weixin_shop_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendEqualTo(Boolean value) {
            addCriterion("weixin_shop_recommend =", value, "weixinShopRecommend");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendNotEqualTo(Boolean value) {
            addCriterion("weixin_shop_recommend <>", value, "weixinShopRecommend");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendGreaterThan(Boolean value) {
            addCriterion("weixin_shop_recommend >", value, "weixinShopRecommend");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("weixin_shop_recommend >=", value, "weixinShopRecommend");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendLessThan(Boolean value) {
            addCriterion("weixin_shop_recommend <", value, "weixinShopRecommend");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendLessThanOrEqualTo(Boolean value) {
            addCriterion("weixin_shop_recommend <=", value, "weixinShopRecommend");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendIn(List<Boolean> values) {
            addCriterion("weixin_shop_recommend in", values, "weixinShopRecommend");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendNotIn(List<Boolean> values) {
            addCriterion("weixin_shop_recommend not in", values, "weixinShopRecommend");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendBetween(Boolean value1, Boolean value2) {
            addCriterion("weixin_shop_recommend between", value1, value2, "weixinShopRecommend");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("weixin_shop_recommend not between", value1, value2, "weixinShopRecommend");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendtimeIsNull() {
            addCriterion("weixin_shop_recommendTime is null");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendtimeIsNotNull() {
            addCriterion("weixin_shop_recommendTime is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendtimeEqualTo(Date value) {
            addCriterionForJDBCDate("weixin_shop_recommendTime =", value, "weixinShopRecommendtime");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendtimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("weixin_shop_recommendTime <>", value, "weixinShopRecommendtime");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendtimeGreaterThan(Date value) {
            addCriterionForJDBCDate("weixin_shop_recommendTime >", value, "weixinShopRecommendtime");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendtimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("weixin_shop_recommendTime >=", value, "weixinShopRecommendtime");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendtimeLessThan(Date value) {
            addCriterionForJDBCDate("weixin_shop_recommendTime <", value, "weixinShopRecommendtime");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendtimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("weixin_shop_recommendTime <=", value, "weixinShopRecommendtime");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendtimeIn(List<Date> values) {
            addCriterionForJDBCDate("weixin_shop_recommendTime in", values, "weixinShopRecommendtime");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendtimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("weixin_shop_recommendTime not in", values, "weixinShopRecommendtime");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendtimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("weixin_shop_recommendTime between", value1, value2, "weixinShopRecommendtime");
            return (Criteria) this;
        }

        public Criteria andWeixinShopRecommendtimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("weixin_shop_recommendTime not between", value1, value2, "weixinShopRecommendtime");
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