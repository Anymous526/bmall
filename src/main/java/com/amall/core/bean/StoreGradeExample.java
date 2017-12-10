package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class StoreGradeExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreGradeExample() {
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

        public Criteria andAddFuncitonIsNull() {
            addCriterion("add_funciton is null");
            return (Criteria) this;
        }

        public Criteria andAddFuncitonIsNotNull() {
            addCriterion("add_funciton is not null");
            return (Criteria) this;
        }

        public Criteria andAddFuncitonEqualTo(String value) {
            addCriterion("add_funciton =", value, "addFunciton");
            return (Criteria) this;
        }

        public Criteria andAddFuncitonNotEqualTo(String value) {
            addCriterion("add_funciton <>", value, "addFunciton");
            return (Criteria) this;
        }

        public Criteria andAddFuncitonGreaterThan(String value) {
            addCriterion("add_funciton >", value, "addFunciton");
            return (Criteria) this;
        }

        public Criteria andAddFuncitonGreaterThanOrEqualTo(String value) {
            addCriterion("add_funciton >=", value, "addFunciton");
            return (Criteria) this;
        }

        public Criteria andAddFuncitonLessThan(String value) {
            addCriterion("add_funciton <", value, "addFunciton");
            return (Criteria) this;
        }

        public Criteria andAddFuncitonLessThanOrEqualTo(String value) {
            addCriterion("add_funciton <=", value, "addFunciton");
            return (Criteria) this;
        }

        public Criteria andAddFuncitonLike(String value) {
            addCriterion("add_funciton like", value, "addFunciton");
            return (Criteria) this;
        }

        public Criteria andAddFuncitonNotLike(String value) {
            addCriterion("add_funciton not like", value, "addFunciton");
            return (Criteria) this;
        }

        public Criteria andAddFuncitonIn(List<String> values) {
            addCriterion("add_funciton in", values, "addFunciton");
            return (Criteria) this;
        }

        public Criteria andAddFuncitonNotIn(List<String> values) {
            addCriterion("add_funciton not in", values, "addFunciton");
            return (Criteria) this;
        }

        public Criteria andAddFuncitonBetween(String value1, String value2) {
            addCriterion("add_funciton between", value1, value2, "addFunciton");
            return (Criteria) this;
        }

        public Criteria andAddFuncitonNotBetween(String value1, String value2) {
            addCriterion("add_funciton not between", value1, value2, "addFunciton");
            return (Criteria) this;
        }

        public Criteria andAuditIsNull() {
            addCriterion("audit is null");
            return (Criteria) this;
        }

        public Criteria andAuditIsNotNull() {
            addCriterion("audit is not null");
            return (Criteria) this;
        }

        public Criteria andAuditEqualTo(Boolean value) {
            addCriterion("audit =", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotEqualTo(Boolean value) {
            addCriterion("audit <>", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThan(Boolean value) {
            addCriterion("audit >", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditGreaterThanOrEqualTo(Boolean value) {
            addCriterion("audit >=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThan(Boolean value) {
            addCriterion("audit <", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditLessThanOrEqualTo(Boolean value) {
            addCriterion("audit <=", value, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditIn(List<Boolean> values) {
            addCriterion("audit in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotIn(List<Boolean> values) {
            addCriterion("audit not in", values, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditBetween(Boolean value1, Boolean value2) {
            addCriterion("audit between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andAuditNotBetween(Boolean value1, Boolean value2) {
            addCriterion("audit not between", value1, value2, "audit");
            return (Criteria) this;
        }

        public Criteria andGoodscountIsNull() {
            addCriterion("goodsCount is null");
            return (Criteria) this;
        }

        public Criteria andGoodscountIsNotNull() {
            addCriterion("goodsCount is not null");
            return (Criteria) this;
        }

        public Criteria andGoodscountEqualTo(Integer value) {
            addCriterion("goodsCount =", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountNotEqualTo(Integer value) {
            addCriterion("goodsCount <>", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountGreaterThan(Integer value) {
            addCriterion("goodsCount >", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountGreaterThanOrEqualTo(Integer value) {
            addCriterion("goodsCount >=", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountLessThan(Integer value) {
            addCriterion("goodsCount <", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountLessThanOrEqualTo(Integer value) {
            addCriterion("goodsCount <=", value, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountIn(List<Integer> values) {
            addCriterion("goodsCount in", values, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountNotIn(List<Integer> values) {
            addCriterion("goodsCount not in", values, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountBetween(Integer value1, Integer value2) {
            addCriterion("goodsCount between", value1, value2, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGoodscountNotBetween(Integer value1, Integer value2) {
            addCriterion("goodsCount not between", value1, value2, "goodscount");
            return (Criteria) this;
        }

        public Criteria andGradelevelIsNull() {
            addCriterion("gradeLevel is null");
            return (Criteria) this;
        }

        public Criteria andGradelevelIsNotNull() {
            addCriterion("gradeLevel is not null");
            return (Criteria) this;
        }

        public Criteria andGradelevelEqualTo(Integer value) {
            addCriterion("gradeLevel =", value, "gradelevel");
            return (Criteria) this;
        }

        public Criteria andGradelevelNotEqualTo(Integer value) {
            addCriterion("gradeLevel <>", value, "gradelevel");
            return (Criteria) this;
        }

        public Criteria andGradelevelGreaterThan(Integer value) {
            addCriterion("gradeLevel >", value, "gradelevel");
            return (Criteria) this;
        }

        public Criteria andGradelevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("gradeLevel >=", value, "gradelevel");
            return (Criteria) this;
        }

        public Criteria andGradelevelLessThan(Integer value) {
            addCriterion("gradeLevel <", value, "gradelevel");
            return (Criteria) this;
        }

        public Criteria andGradelevelLessThanOrEqualTo(Integer value) {
            addCriterion("gradeLevel <=", value, "gradelevel");
            return (Criteria) this;
        }

        public Criteria andGradelevelIn(List<Integer> values) {
            addCriterion("gradeLevel in", values, "gradelevel");
            return (Criteria) this;
        }

        public Criteria andGradelevelNotIn(List<Integer> values) {
            addCriterion("gradeLevel not in", values, "gradelevel");
            return (Criteria) this;
        }

        public Criteria andGradelevelBetween(Integer value1, Integer value2) {
            addCriterion("gradeLevel between", value1, value2, "gradelevel");
            return (Criteria) this;
        }

        public Criteria andGradelevelNotBetween(Integer value1, Integer value2) {
            addCriterion("gradeLevel not between", value1, value2, "gradelevel");
            return (Criteria) this;
        }

        public Criteria andGradenameIsNull() {
            addCriterion("gradeName is null");
            return (Criteria) this;
        }

        public Criteria andGradenameIsNotNull() {
            addCriterion("gradeName is not null");
            return (Criteria) this;
        }

        public Criteria andGradenameEqualTo(String value) {
            addCriterion("gradeName =", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameNotEqualTo(String value) {
            addCriterion("gradeName <>", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameGreaterThan(String value) {
            addCriterion("gradeName >", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameGreaterThanOrEqualTo(String value) {
            addCriterion("gradeName >=", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameLessThan(String value) {
            addCriterion("gradeName <", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameLessThanOrEqualTo(String value) {
            addCriterion("gradeName <=", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameLike(String value) {
            addCriterion("gradeName like", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameNotLike(String value) {
            addCriterion("gradeName not like", value, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameIn(List<String> values) {
            addCriterion("gradeName in", values, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameNotIn(List<String> values) {
            addCriterion("gradeName not in", values, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameBetween(String value1, String value2) {
            addCriterion("gradeName between", value1, value2, "gradename");
            return (Criteria) this;
        }

        public Criteria andGradenameNotBetween(String value1, String value2) {
            addCriterion("gradeName not between", value1, value2, "gradename");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(String value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(String value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(String value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(String value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(String value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(String value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLike(String value) {
            addCriterion("price like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotLike(String value) {
            addCriterion("price not like", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<String> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<String> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(String value1, String value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(String value1, String value2) {
            addCriterion("price not between", value1, value2, "price");
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

        public Criteria andSpacesizeIsNull() {
            addCriterion("spaceSize is null");
            return (Criteria) this;
        }

        public Criteria andSpacesizeIsNotNull() {
            addCriterion("spaceSize is not null");
            return (Criteria) this;
        }

        public Criteria andSpacesizeEqualTo(Float value) {
            addCriterion("spaceSize =", value, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeNotEqualTo(Float value) {
            addCriterion("spaceSize <>", value, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeGreaterThan(Float value) {
            addCriterion("spaceSize >", value, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeGreaterThanOrEqualTo(Float value) {
            addCriterion("spaceSize >=", value, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeLessThan(Float value) {
            addCriterion("spaceSize <", value, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeLessThanOrEqualTo(Float value) {
            addCriterion("spaceSize <=", value, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeIn(List<Float> values) {
            addCriterion("spaceSize in", values, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeNotIn(List<Float> values) {
            addCriterion("spaceSize not in", values, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeBetween(Float value1, Float value2) {
            addCriterion("spaceSize between", value1, value2, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSpacesizeNotBetween(Float value1, Float value2) {
            addCriterion("spaceSize not between", value1, value2, "spacesize");
            return (Criteria) this;
        }

        public Criteria andSysgradeIsNull() {
            addCriterion("sysGrade is null");
            return (Criteria) this;
        }

        public Criteria andSysgradeIsNotNull() {
            addCriterion("sysGrade is not null");
            return (Criteria) this;
        }

        public Criteria andSysgradeEqualTo(Boolean value) {
            addCriterion("sysGrade =", value, "sysgrade");
            return (Criteria) this;
        }

        public Criteria andSysgradeNotEqualTo(Boolean value) {
            addCriterion("sysGrade <>", value, "sysgrade");
            return (Criteria) this;
        }

        public Criteria andSysgradeGreaterThan(Boolean value) {
            addCriterion("sysGrade >", value, "sysgrade");
            return (Criteria) this;
        }

        public Criteria andSysgradeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sysGrade >=", value, "sysgrade");
            return (Criteria) this;
        }

        public Criteria andSysgradeLessThan(Boolean value) {
            addCriterion("sysGrade <", value, "sysgrade");
            return (Criteria) this;
        }

        public Criteria andSysgradeLessThanOrEqualTo(Boolean value) {
            addCriterion("sysGrade <=", value, "sysgrade");
            return (Criteria) this;
        }

        public Criteria andSysgradeIn(List<Boolean> values) {
            addCriterion("sysGrade in", values, "sysgrade");
            return (Criteria) this;
        }

        public Criteria andSysgradeNotIn(List<Boolean> values) {
            addCriterion("sysGrade not in", values, "sysgrade");
            return (Criteria) this;
        }

        public Criteria andSysgradeBetween(Boolean value1, Boolean value2) {
            addCriterion("sysGrade between", value1, value2, "sysgrade");
            return (Criteria) this;
        }

        public Criteria andSysgradeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sysGrade not between", value1, value2, "sysgrade");
            return (Criteria) this;
        }

        public Criteria andTemplatesIsNull() {
            addCriterion("templates is null");
            return (Criteria) this;
        }

        public Criteria andTemplatesIsNotNull() {
            addCriterion("templates is not null");
            return (Criteria) this;
        }

        public Criteria andTemplatesEqualTo(String value) {
            addCriterion("templates =", value, "templates");
            return (Criteria) this;
        }

        public Criteria andTemplatesNotEqualTo(String value) {
            addCriterion("templates <>", value, "templates");
            return (Criteria) this;
        }

        public Criteria andTemplatesGreaterThan(String value) {
            addCriterion("templates >", value, "templates");
            return (Criteria) this;
        }

        public Criteria andTemplatesGreaterThanOrEqualTo(String value) {
            addCriterion("templates >=", value, "templates");
            return (Criteria) this;
        }

        public Criteria andTemplatesLessThan(String value) {
            addCriterion("templates <", value, "templates");
            return (Criteria) this;
        }

        public Criteria andTemplatesLessThanOrEqualTo(String value) {
            addCriterion("templates <=", value, "templates");
            return (Criteria) this;
        }

        public Criteria andTemplatesLike(String value) {
            addCriterion("templates like", value, "templates");
            return (Criteria) this;
        }

        public Criteria andTemplatesNotLike(String value) {
            addCriterion("templates not like", value, "templates");
            return (Criteria) this;
        }

        public Criteria andTemplatesIn(List<String> values) {
            addCriterion("templates in", values, "templates");
            return (Criteria) this;
        }

        public Criteria andTemplatesNotIn(List<String> values) {
            addCriterion("templates not in", values, "templates");
            return (Criteria) this;
        }

        public Criteria andTemplatesBetween(String value1, String value2) {
            addCriterion("templates between", value1, value2, "templates");
            return (Criteria) this;
        }

        public Criteria andTemplatesNotBetween(String value1, String value2) {
            addCriterion("templates not between", value1, value2, "templates");
            return (Criteria) this;
        }

        public Criteria andAcountNumIsNull() {
            addCriterion("acount_num is null");
            return (Criteria) this;
        }

        public Criteria andAcountNumIsNotNull() {
            addCriterion("acount_num is not null");
            return (Criteria) this;
        }

        public Criteria andAcountNumEqualTo(Integer value) {
            addCriterion("acount_num =", value, "acountNum");
            return (Criteria) this;
        }

        public Criteria andAcountNumNotEqualTo(Integer value) {
            addCriterion("acount_num <>", value, "acountNum");
            return (Criteria) this;
        }

        public Criteria andAcountNumGreaterThan(Integer value) {
            addCriterion("acount_num >", value, "acountNum");
            return (Criteria) this;
        }

        public Criteria andAcountNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("acount_num >=", value, "acountNum");
            return (Criteria) this;
        }

        public Criteria andAcountNumLessThan(Integer value) {
            addCriterion("acount_num <", value, "acountNum");
            return (Criteria) this;
        }

        public Criteria andAcountNumLessThanOrEqualTo(Integer value) {
            addCriterion("acount_num <=", value, "acountNum");
            return (Criteria) this;
        }

        public Criteria andAcountNumIn(List<Integer> values) {
            addCriterion("acount_num in", values, "acountNum");
            return (Criteria) this;
        }

        public Criteria andAcountNumNotIn(List<Integer> values) {
            addCriterion("acount_num not in", values, "acountNum");
            return (Criteria) this;
        }

        public Criteria andAcountNumBetween(Integer value1, Integer value2) {
            addCriterion("acount_num between", value1, value2, "acountNum");
            return (Criteria) this;
        }

        public Criteria andAcountNumNotBetween(Integer value1, Integer value2) {
            addCriterion("acount_num not between", value1, value2, "acountNum");
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