package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class ComplaintExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ComplaintExample() {
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

        public Criteria andAppealTimeIsNull() {
            addCriterion("appeal_time is null");
            return (Criteria) this;
        }

        public Criteria andAppealTimeIsNotNull() {
            addCriterion("appeal_time is not null");
            return (Criteria) this;
        }

        public Criteria andAppealTimeEqualTo(Date value) {
            addCriterion("appeal_time =", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeNotEqualTo(Date value) {
            addCriterion("appeal_time <>", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeGreaterThan(Date value) {
            addCriterion("appeal_time >", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("appeal_time >=", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeLessThan(Date value) {
            addCriterion("appeal_time <", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeLessThanOrEqualTo(Date value) {
            addCriterion("appeal_time <=", value, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeIn(List<Date> values) {
            addCriterion("appeal_time in", values, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeNotIn(List<Date> values) {
            addCriterion("appeal_time not in", values, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeBetween(Date value1, Date value2) {
            addCriterion("appeal_time between", value1, value2, "appealTime");
            return (Criteria) this;
        }

        public Criteria andAppealTimeNotBetween(Date value1, Date value2) {
            addCriterion("appeal_time not between", value1, value2, "appealTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNull() {
            addCriterion("handle_time is null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIsNotNull() {
            addCriterion("handle_time is not null");
            return (Criteria) this;
        }

        public Criteria andHandleTimeEqualTo(Date value) {
            addCriterion("handle_time =", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotEqualTo(Date value) {
            addCriterion("handle_time <>", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThan(Date value) {
            addCriterion("handle_time >", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("handle_time >=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThan(Date value) {
            addCriterion("handle_time <", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeLessThanOrEqualTo(Date value) {
            addCriterion("handle_time <=", value, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeIn(List<Date> values) {
            addCriterion("handle_time in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotIn(List<Date> values) {
            addCriterion("handle_time not in", values, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeBetween(Date value1, Date value2) {
            addCriterion("handle_time between", value1, value2, "handleTime");
            return (Criteria) this;
        }

        public Criteria andHandleTimeNotBetween(Date value1, Date value2) {
            addCriterion("handle_time not between", value1, value2, "handleTime");
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

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andCsIdIsNull() {
            addCriterion("cs_id is null");
            return (Criteria) this;
        }

        public Criteria andCsIdIsNotNull() {
            addCriterion("cs_id is not null");
            return (Criteria) this;
        }

        public Criteria andCsIdEqualTo(Long value) {
            addCriterion("cs_id =", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotEqualTo(Long value) {
            addCriterion("cs_id <>", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdGreaterThan(Long value) {
            addCriterion("cs_id >", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cs_id >=", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdLessThan(Long value) {
            addCriterion("cs_id <", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdLessThanOrEqualTo(Long value) {
            addCriterion("cs_id <=", value, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdIn(List<Long> values) {
            addCriterion("cs_id in", values, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotIn(List<Long> values) {
            addCriterion("cs_id not in", values, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdBetween(Long value1, Long value2) {
            addCriterion("cs_id between", value1, value2, "csId");
            return (Criteria) this;
        }

        public Criteria andCsIdNotBetween(Long value1, Long value2) {
            addCriterion("cs_id not between", value1, value2, "csId");
            return (Criteria) this;
        }

        public Criteria andFromAcc1IdIsNull() {
            addCriterion("from_acc1_id is null");
            return (Criteria) this;
        }

        public Criteria andFromAcc1IdIsNotNull() {
            addCriterion("from_acc1_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromAcc1IdEqualTo(Long value) {
            addCriterion("from_acc1_id =", value, "fromAcc1Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc1IdNotEqualTo(Long value) {
            addCriterion("from_acc1_id <>", value, "fromAcc1Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc1IdGreaterThan(Long value) {
            addCriterion("from_acc1_id >", value, "fromAcc1Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc1IdGreaterThanOrEqualTo(Long value) {
            addCriterion("from_acc1_id >=", value, "fromAcc1Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc1IdLessThan(Long value) {
            addCriterion("from_acc1_id <", value, "fromAcc1Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc1IdLessThanOrEqualTo(Long value) {
            addCriterion("from_acc1_id <=", value, "fromAcc1Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc1IdIn(List<Long> values) {
            addCriterion("from_acc1_id in", values, "fromAcc1Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc1IdNotIn(List<Long> values) {
            addCriterion("from_acc1_id not in", values, "fromAcc1Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc1IdBetween(Long value1, Long value2) {
            addCriterion("from_acc1_id between", value1, value2, "fromAcc1Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc1IdNotBetween(Long value1, Long value2) {
            addCriterion("from_acc1_id not between", value1, value2, "fromAcc1Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc2IdIsNull() {
            addCriterion("from_acc2_id is null");
            return (Criteria) this;
        }

        public Criteria andFromAcc2IdIsNotNull() {
            addCriterion("from_acc2_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromAcc2IdEqualTo(Long value) {
            addCriterion("from_acc2_id =", value, "fromAcc2Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc2IdNotEqualTo(Long value) {
            addCriterion("from_acc2_id <>", value, "fromAcc2Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc2IdGreaterThan(Long value) {
            addCriterion("from_acc2_id >", value, "fromAcc2Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc2IdGreaterThanOrEqualTo(Long value) {
            addCriterion("from_acc2_id >=", value, "fromAcc2Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc2IdLessThan(Long value) {
            addCriterion("from_acc2_id <", value, "fromAcc2Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc2IdLessThanOrEqualTo(Long value) {
            addCriterion("from_acc2_id <=", value, "fromAcc2Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc2IdIn(List<Long> values) {
            addCriterion("from_acc2_id in", values, "fromAcc2Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc2IdNotIn(List<Long> values) {
            addCriterion("from_acc2_id not in", values, "fromAcc2Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc2IdBetween(Long value1, Long value2) {
            addCriterion("from_acc2_id between", value1, value2, "fromAcc2Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc2IdNotBetween(Long value1, Long value2) {
            addCriterion("from_acc2_id not between", value1, value2, "fromAcc2Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc3IdIsNull() {
            addCriterion("from_acc3_id is null");
            return (Criteria) this;
        }

        public Criteria andFromAcc3IdIsNotNull() {
            addCriterion("from_acc3_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromAcc3IdEqualTo(Long value) {
            addCriterion("from_acc3_id =", value, "fromAcc3Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc3IdNotEqualTo(Long value) {
            addCriterion("from_acc3_id <>", value, "fromAcc3Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc3IdGreaterThan(Long value) {
            addCriterion("from_acc3_id >", value, "fromAcc3Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc3IdGreaterThanOrEqualTo(Long value) {
            addCriterion("from_acc3_id >=", value, "fromAcc3Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc3IdLessThan(Long value) {
            addCriterion("from_acc3_id <", value, "fromAcc3Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc3IdLessThanOrEqualTo(Long value) {
            addCriterion("from_acc3_id <=", value, "fromAcc3Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc3IdIn(List<Long> values) {
            addCriterion("from_acc3_id in", values, "fromAcc3Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc3IdNotIn(List<Long> values) {
            addCriterion("from_acc3_id not in", values, "fromAcc3Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc3IdBetween(Long value1, Long value2) {
            addCriterion("from_acc3_id between", value1, value2, "fromAcc3Id");
            return (Criteria) this;
        }

        public Criteria andFromAcc3IdNotBetween(Long value1, Long value2) {
            addCriterion("from_acc3_id not between", value1, value2, "fromAcc3Id");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIsNull() {
            addCriterion("from_user_id is null");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIsNotNull() {
            addCriterion("from_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andFromUserIdEqualTo(Long value) {
            addCriterion("from_user_id =", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotEqualTo(Long value) {
            addCriterion("from_user_id <>", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdGreaterThan(Long value) {
            addCriterion("from_user_id >", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("from_user_id >=", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLessThan(Long value) {
            addCriterion("from_user_id <", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdLessThanOrEqualTo(Long value) {
            addCriterion("from_user_id <=", value, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdIn(List<Long> values) {
            addCriterion("from_user_id in", values, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotIn(List<Long> values) {
            addCriterion("from_user_id not in", values, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdBetween(Long value1, Long value2) {
            addCriterion("from_user_id between", value1, value2, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andFromUserIdNotBetween(Long value1, Long value2) {
            addCriterion("from_user_id not between", value1, value2, "fromUserId");
            return (Criteria) this;
        }

        public Criteria andHandleUserIdIsNull() {
            addCriterion("handle_user_id is null");
            return (Criteria) this;
        }

        public Criteria andHandleUserIdIsNotNull() {
            addCriterion("handle_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andHandleUserIdEqualTo(Long value) {
            addCriterion("handle_user_id =", value, "handleUserId");
            return (Criteria) this;
        }

        public Criteria andHandleUserIdNotEqualTo(Long value) {
            addCriterion("handle_user_id <>", value, "handleUserId");
            return (Criteria) this;
        }

        public Criteria andHandleUserIdGreaterThan(Long value) {
            addCriterion("handle_user_id >", value, "handleUserId");
            return (Criteria) this;
        }

        public Criteria andHandleUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("handle_user_id >=", value, "handleUserId");
            return (Criteria) this;
        }

        public Criteria andHandleUserIdLessThan(Long value) {
            addCriterion("handle_user_id <", value, "handleUserId");
            return (Criteria) this;
        }

        public Criteria andHandleUserIdLessThanOrEqualTo(Long value) {
            addCriterion("handle_user_id <=", value, "handleUserId");
            return (Criteria) this;
        }

        public Criteria andHandleUserIdIn(List<Long> values) {
            addCriterion("handle_user_id in", values, "handleUserId");
            return (Criteria) this;
        }

        public Criteria andHandleUserIdNotIn(List<Long> values) {
            addCriterion("handle_user_id not in", values, "handleUserId");
            return (Criteria) this;
        }

        public Criteria andHandleUserIdBetween(Long value1, Long value2) {
            addCriterion("handle_user_id between", value1, value2, "handleUserId");
            return (Criteria) this;
        }

        public Criteria andHandleUserIdNotBetween(Long value1, Long value2) {
            addCriterion("handle_user_id not between", value1, value2, "handleUserId");
            return (Criteria) this;
        }

        public Criteria andOfIdIsNull() {
            addCriterion("of_id is null");
            return (Criteria) this;
        }

        public Criteria andOfIdIsNotNull() {
            addCriterion("of_id is not null");
            return (Criteria) this;
        }

        public Criteria andOfIdEqualTo(Long value) {
            addCriterion("of_id =", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdNotEqualTo(Long value) {
            addCriterion("of_id <>", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdGreaterThan(Long value) {
            addCriterion("of_id >", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdGreaterThanOrEqualTo(Long value) {
            addCriterion("of_id >=", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdLessThan(Long value) {
            addCriterion("of_id <", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdLessThanOrEqualTo(Long value) {
            addCriterion("of_id <=", value, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdIn(List<Long> values) {
            addCriterion("of_id in", values, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdNotIn(List<Long> values) {
            addCriterion("of_id not in", values, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdBetween(Long value1, Long value2) {
            addCriterion("of_id between", value1, value2, "ofId");
            return (Criteria) this;
        }

        public Criteria andOfIdNotBetween(Long value1, Long value2) {
            addCriterion("of_id not between", value1, value2, "ofId");
            return (Criteria) this;
        }

        public Criteria andToAcc1IdIsNull() {
            addCriterion("to_acc1_id is null");
            return (Criteria) this;
        }

        public Criteria andToAcc1IdIsNotNull() {
            addCriterion("to_acc1_id is not null");
            return (Criteria) this;
        }

        public Criteria andToAcc1IdEqualTo(Long value) {
            addCriterion("to_acc1_id =", value, "toAcc1Id");
            return (Criteria) this;
        }

        public Criteria andToAcc1IdNotEqualTo(Long value) {
            addCriterion("to_acc1_id <>", value, "toAcc1Id");
            return (Criteria) this;
        }

        public Criteria andToAcc1IdGreaterThan(Long value) {
            addCriterion("to_acc1_id >", value, "toAcc1Id");
            return (Criteria) this;
        }

        public Criteria andToAcc1IdGreaterThanOrEqualTo(Long value) {
            addCriterion("to_acc1_id >=", value, "toAcc1Id");
            return (Criteria) this;
        }

        public Criteria andToAcc1IdLessThan(Long value) {
            addCriterion("to_acc1_id <", value, "toAcc1Id");
            return (Criteria) this;
        }

        public Criteria andToAcc1IdLessThanOrEqualTo(Long value) {
            addCriterion("to_acc1_id <=", value, "toAcc1Id");
            return (Criteria) this;
        }

        public Criteria andToAcc1IdIn(List<Long> values) {
            addCriterion("to_acc1_id in", values, "toAcc1Id");
            return (Criteria) this;
        }

        public Criteria andToAcc1IdNotIn(List<Long> values) {
            addCriterion("to_acc1_id not in", values, "toAcc1Id");
            return (Criteria) this;
        }

        public Criteria andToAcc1IdBetween(Long value1, Long value2) {
            addCriterion("to_acc1_id between", value1, value2, "toAcc1Id");
            return (Criteria) this;
        }

        public Criteria andToAcc1IdNotBetween(Long value1, Long value2) {
            addCriterion("to_acc1_id not between", value1, value2, "toAcc1Id");
            return (Criteria) this;
        }

        public Criteria andToAcc2IdIsNull() {
            addCriterion("to_acc2_id is null");
            return (Criteria) this;
        }

        public Criteria andToAcc2IdIsNotNull() {
            addCriterion("to_acc2_id is not null");
            return (Criteria) this;
        }

        public Criteria andToAcc2IdEqualTo(Long value) {
            addCriterion("to_acc2_id =", value, "toAcc2Id");
            return (Criteria) this;
        }

        public Criteria andToAcc2IdNotEqualTo(Long value) {
            addCriterion("to_acc2_id <>", value, "toAcc2Id");
            return (Criteria) this;
        }

        public Criteria andToAcc2IdGreaterThan(Long value) {
            addCriterion("to_acc2_id >", value, "toAcc2Id");
            return (Criteria) this;
        }

        public Criteria andToAcc2IdGreaterThanOrEqualTo(Long value) {
            addCriterion("to_acc2_id >=", value, "toAcc2Id");
            return (Criteria) this;
        }

        public Criteria andToAcc2IdLessThan(Long value) {
            addCriterion("to_acc2_id <", value, "toAcc2Id");
            return (Criteria) this;
        }

        public Criteria andToAcc2IdLessThanOrEqualTo(Long value) {
            addCriterion("to_acc2_id <=", value, "toAcc2Id");
            return (Criteria) this;
        }

        public Criteria andToAcc2IdIn(List<Long> values) {
            addCriterion("to_acc2_id in", values, "toAcc2Id");
            return (Criteria) this;
        }

        public Criteria andToAcc2IdNotIn(List<Long> values) {
            addCriterion("to_acc2_id not in", values, "toAcc2Id");
            return (Criteria) this;
        }

        public Criteria andToAcc2IdBetween(Long value1, Long value2) {
            addCriterion("to_acc2_id between", value1, value2, "toAcc2Id");
            return (Criteria) this;
        }

        public Criteria andToAcc2IdNotBetween(Long value1, Long value2) {
            addCriterion("to_acc2_id not between", value1, value2, "toAcc2Id");
            return (Criteria) this;
        }

        public Criteria andToAcc3IdIsNull() {
            addCriterion("to_acc3_id is null");
            return (Criteria) this;
        }

        public Criteria andToAcc3IdIsNotNull() {
            addCriterion("to_acc3_id is not null");
            return (Criteria) this;
        }

        public Criteria andToAcc3IdEqualTo(Long value) {
            addCriterion("to_acc3_id =", value, "toAcc3Id");
            return (Criteria) this;
        }

        public Criteria andToAcc3IdNotEqualTo(Long value) {
            addCriterion("to_acc3_id <>", value, "toAcc3Id");
            return (Criteria) this;
        }

        public Criteria andToAcc3IdGreaterThan(Long value) {
            addCriterion("to_acc3_id >", value, "toAcc3Id");
            return (Criteria) this;
        }

        public Criteria andToAcc3IdGreaterThanOrEqualTo(Long value) {
            addCriterion("to_acc3_id >=", value, "toAcc3Id");
            return (Criteria) this;
        }

        public Criteria andToAcc3IdLessThan(Long value) {
            addCriterion("to_acc3_id <", value, "toAcc3Id");
            return (Criteria) this;
        }

        public Criteria andToAcc3IdLessThanOrEqualTo(Long value) {
            addCriterion("to_acc3_id <=", value, "toAcc3Id");
            return (Criteria) this;
        }

        public Criteria andToAcc3IdIn(List<Long> values) {
            addCriterion("to_acc3_id in", values, "toAcc3Id");
            return (Criteria) this;
        }

        public Criteria andToAcc3IdNotIn(List<Long> values) {
            addCriterion("to_acc3_id not in", values, "toAcc3Id");
            return (Criteria) this;
        }

        public Criteria andToAcc3IdBetween(Long value1, Long value2) {
            addCriterion("to_acc3_id between", value1, value2, "toAcc3Id");
            return (Criteria) this;
        }

        public Criteria andToAcc3IdNotBetween(Long value1, Long value2) {
            addCriterion("to_acc3_id not between", value1, value2, "toAcc3Id");
            return (Criteria) this;
        }

        public Criteria andToUserIdIsNull() {
            addCriterion("to_user_id is null");
            return (Criteria) this;
        }

        public Criteria andToUserIdIsNotNull() {
            addCriterion("to_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andToUserIdEqualTo(Long value) {
            addCriterion("to_user_id =", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotEqualTo(Long value) {
            addCriterion("to_user_id <>", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdGreaterThan(Long value) {
            addCriterion("to_user_id >", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("to_user_id >=", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdLessThan(Long value) {
            addCriterion("to_user_id <", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdLessThanOrEqualTo(Long value) {
            addCriterion("to_user_id <=", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdIn(List<Long> values) {
            addCriterion("to_user_id in", values, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotIn(List<Long> values) {
            addCriterion("to_user_id not in", values, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdBetween(Long value1, Long value2) {
            addCriterion("to_user_id between", value1, value2, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotBetween(Long value1, Long value2) {
            addCriterion("to_user_id not between", value1, value2, "toUserId");
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