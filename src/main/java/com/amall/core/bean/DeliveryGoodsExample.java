package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class DeliveryGoodsExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeliveryGoodsExample() {
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

        public Criteria andDStatusIsNull() {
            addCriterion("d_status is null");
            return (Criteria) this;
        }

        public Criteria andDStatusIsNotNull() {
            addCriterion("d_status is not null");
            return (Criteria) this;
        }

        public Criteria andDStatusEqualTo(Integer value) {
            addCriterion("d_status =", value, "dStatus");
            return (Criteria) this;
        }

        public Criteria andDStatusNotEqualTo(Integer value) {
            addCriterion("d_status <>", value, "dStatus");
            return (Criteria) this;
        }

        public Criteria andDStatusGreaterThan(Integer value) {
            addCriterion("d_status >", value, "dStatus");
            return (Criteria) this;
        }

        public Criteria andDStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("d_status >=", value, "dStatus");
            return (Criteria) this;
        }

        public Criteria andDStatusLessThan(Integer value) {
            addCriterion("d_status <", value, "dStatus");
            return (Criteria) this;
        }

        public Criteria andDStatusLessThanOrEqualTo(Integer value) {
            addCriterion("d_status <=", value, "dStatus");
            return (Criteria) this;
        }

        public Criteria andDStatusIn(List<Integer> values) {
            addCriterion("d_status in", values, "dStatus");
            return (Criteria) this;
        }

        public Criteria andDStatusNotIn(List<Integer> values) {
            addCriterion("d_status not in", values, "dStatus");
            return (Criteria) this;
        }

        public Criteria andDStatusBetween(Integer value1, Integer value2) {
            addCriterion("d_status between", value1, value2, "dStatus");
            return (Criteria) this;
        }

        public Criteria andDStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("d_status not between", value1, value2, "dStatus");
            return (Criteria) this;
        }

        public Criteria andDAdminUserIdIsNull() {
            addCriterion("d_admin_user_id is null");
            return (Criteria) this;
        }

        public Criteria andDAdminUserIdIsNotNull() {
            addCriterion("d_admin_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andDAdminUserIdEqualTo(Long value) {
            addCriterion("d_admin_user_id =", value, "dAdminUserId");
            return (Criteria) this;
        }

        public Criteria andDAdminUserIdNotEqualTo(Long value) {
            addCriterion("d_admin_user_id <>", value, "dAdminUserId");
            return (Criteria) this;
        }

        public Criteria andDAdminUserIdGreaterThan(Long value) {
            addCriterion("d_admin_user_id >", value, "dAdminUserId");
            return (Criteria) this;
        }

        public Criteria andDAdminUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("d_admin_user_id >=", value, "dAdminUserId");
            return (Criteria) this;
        }

        public Criteria andDAdminUserIdLessThan(Long value) {
            addCriterion("d_admin_user_id <", value, "dAdminUserId");
            return (Criteria) this;
        }

        public Criteria andDAdminUserIdLessThanOrEqualTo(Long value) {
            addCriterion("d_admin_user_id <=", value, "dAdminUserId");
            return (Criteria) this;
        }

        public Criteria andDAdminUserIdIn(List<Long> values) {
            addCriterion("d_admin_user_id in", values, "dAdminUserId");
            return (Criteria) this;
        }

        public Criteria andDAdminUserIdNotIn(List<Long> values) {
            addCriterion("d_admin_user_id not in", values, "dAdminUserId");
            return (Criteria) this;
        }

        public Criteria andDAdminUserIdBetween(Long value1, Long value2) {
            addCriterion("d_admin_user_id between", value1, value2, "dAdminUserId");
            return (Criteria) this;
        }

        public Criteria andDAdminUserIdNotBetween(Long value1, Long value2) {
            addCriterion("d_admin_user_id not between", value1, value2, "dAdminUserId");
            return (Criteria) this;
        }

        public Criteria andDDeliveryGoodsIdIsNull() {
            addCriterion("d_delivery_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andDDeliveryGoodsIdIsNotNull() {
            addCriterion("d_delivery_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andDDeliveryGoodsIdEqualTo(Long value) {
            addCriterion("d_delivery_goods_id =", value, "dDeliveryGoodsId");
            return (Criteria) this;
        }

        public Criteria andDDeliveryGoodsIdNotEqualTo(Long value) {
            addCriterion("d_delivery_goods_id <>", value, "dDeliveryGoodsId");
            return (Criteria) this;
        }

        public Criteria andDDeliveryGoodsIdGreaterThan(Long value) {
            addCriterion("d_delivery_goods_id >", value, "dDeliveryGoodsId");
            return (Criteria) this;
        }

        public Criteria andDDeliveryGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("d_delivery_goods_id >=", value, "dDeliveryGoodsId");
            return (Criteria) this;
        }

        public Criteria andDDeliveryGoodsIdLessThan(Long value) {
            addCriterion("d_delivery_goods_id <", value, "dDeliveryGoodsId");
            return (Criteria) this;
        }

        public Criteria andDDeliveryGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("d_delivery_goods_id <=", value, "dDeliveryGoodsId");
            return (Criteria) this;
        }

        public Criteria andDDeliveryGoodsIdIn(List<Long> values) {
            addCriterion("d_delivery_goods_id in", values, "dDeliveryGoodsId");
            return (Criteria) this;
        }

        public Criteria andDDeliveryGoodsIdNotIn(List<Long> values) {
            addCriterion("d_delivery_goods_id not in", values, "dDeliveryGoodsId");
            return (Criteria) this;
        }

        public Criteria andDDeliveryGoodsIdBetween(Long value1, Long value2) {
            addCriterion("d_delivery_goods_id between", value1, value2, "dDeliveryGoodsId");
            return (Criteria) this;
        }

        public Criteria andDDeliveryGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("d_delivery_goods_id not between", value1, value2, "dDeliveryGoodsId");
            return (Criteria) this;
        }

        public Criteria andDGoodsIdIsNull() {
            addCriterion("d_goods_id is null");
            return (Criteria) this;
        }

        public Criteria andDGoodsIdIsNotNull() {
            addCriterion("d_goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andDGoodsIdEqualTo(Long value) {
            addCriterion("d_goods_id =", value, "dGoodsId");
            return (Criteria) this;
        }

        public Criteria andDGoodsIdNotEqualTo(Long value) {
            addCriterion("d_goods_id <>", value, "dGoodsId");
            return (Criteria) this;
        }

        public Criteria andDGoodsIdGreaterThan(Long value) {
            addCriterion("d_goods_id >", value, "dGoodsId");
            return (Criteria) this;
        }

        public Criteria andDGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("d_goods_id >=", value, "dGoodsId");
            return (Criteria) this;
        }

        public Criteria andDGoodsIdLessThan(Long value) {
            addCriterion("d_goods_id <", value, "dGoodsId");
            return (Criteria) this;
        }

        public Criteria andDGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("d_goods_id <=", value, "dGoodsId");
            return (Criteria) this;
        }

        public Criteria andDGoodsIdIn(List<Long> values) {
            addCriterion("d_goods_id in", values, "dGoodsId");
            return (Criteria) this;
        }

        public Criteria andDGoodsIdNotIn(List<Long> values) {
            addCriterion("d_goods_id not in", values, "dGoodsId");
            return (Criteria) this;
        }

        public Criteria andDGoodsIdBetween(Long value1, Long value2) {
            addCriterion("d_goods_id between", value1, value2, "dGoodsId");
            return (Criteria) this;
        }

        public Criteria andDGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("d_goods_id not between", value1, value2, "dGoodsId");
            return (Criteria) this;
        }

        public Criteria andDBeginTimeIsNull() {
            addCriterion("d_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andDBeginTimeIsNotNull() {
            addCriterion("d_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andDBeginTimeEqualTo(Date value) {
            addCriterionForJDBCDate("d_begin_time =", value, "dBeginTime");
            return (Criteria) this;
        }

        public Criteria andDBeginTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("d_begin_time <>", value, "dBeginTime");
            return (Criteria) this;
        }

        public Criteria andDBeginTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("d_begin_time >", value, "dBeginTime");
            return (Criteria) this;
        }

        public Criteria andDBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("d_begin_time >=", value, "dBeginTime");
            return (Criteria) this;
        }

        public Criteria andDBeginTimeLessThan(Date value) {
            addCriterionForJDBCDate("d_begin_time <", value, "dBeginTime");
            return (Criteria) this;
        }

        public Criteria andDBeginTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("d_begin_time <=", value, "dBeginTime");
            return (Criteria) this;
        }

        public Criteria andDBeginTimeIn(List<Date> values) {
            addCriterionForJDBCDate("d_begin_time in", values, "dBeginTime");
            return (Criteria) this;
        }

        public Criteria andDBeginTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("d_begin_time not in", values, "dBeginTime");
            return (Criteria) this;
        }

        public Criteria andDBeginTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("d_begin_time between", value1, value2, "dBeginTime");
            return (Criteria) this;
        }

        public Criteria andDBeginTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("d_begin_time not between", value1, value2, "dBeginTime");
            return (Criteria) this;
        }

        public Criteria andDEndTimeIsNull() {
            addCriterion("d_end_time is null");
            return (Criteria) this;
        }

        public Criteria andDEndTimeIsNotNull() {
            addCriterion("d_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andDEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("d_end_time =", value, "dEndTime");
            return (Criteria) this;
        }

        public Criteria andDEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("d_end_time <>", value, "dEndTime");
            return (Criteria) this;
        }

        public Criteria andDEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("d_end_time >", value, "dEndTime");
            return (Criteria) this;
        }

        public Criteria andDEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("d_end_time >=", value, "dEndTime");
            return (Criteria) this;
        }

        public Criteria andDEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("d_end_time <", value, "dEndTime");
            return (Criteria) this;
        }

        public Criteria andDEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("d_end_time <=", value, "dEndTime");
            return (Criteria) this;
        }

        public Criteria andDEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("d_end_time in", values, "dEndTime");
            return (Criteria) this;
        }

        public Criteria andDEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("d_end_time not in", values, "dEndTime");
            return (Criteria) this;
        }

        public Criteria andDEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("d_end_time between", value1, value2, "dEndTime");
            return (Criteria) this;
        }

        public Criteria andDEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("d_end_time not between", value1, value2, "dEndTime");
            return (Criteria) this;
        }

        public Criteria andDAuditTimeIsNull() {
            addCriterion("d_audit_time is null");
            return (Criteria) this;
        }

        public Criteria andDAuditTimeIsNotNull() {
            addCriterion("d_audit_time is not null");
            return (Criteria) this;
        }

        public Criteria andDAuditTimeEqualTo(Date value) {
            addCriterion("d_audit_time =", value, "dAuditTime");
            return (Criteria) this;
        }

        public Criteria andDAuditTimeNotEqualTo(Date value) {
            addCriterion("d_audit_time <>", value, "dAuditTime");
            return (Criteria) this;
        }

        public Criteria andDAuditTimeGreaterThan(Date value) {
            addCriterion("d_audit_time >", value, "dAuditTime");
            return (Criteria) this;
        }

        public Criteria andDAuditTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("d_audit_time >=", value, "dAuditTime");
            return (Criteria) this;
        }

        public Criteria andDAuditTimeLessThan(Date value) {
            addCriterion("d_audit_time <", value, "dAuditTime");
            return (Criteria) this;
        }

        public Criteria andDAuditTimeLessThanOrEqualTo(Date value) {
            addCriterion("d_audit_time <=", value, "dAuditTime");
            return (Criteria) this;
        }

        public Criteria andDAuditTimeIn(List<Date> values) {
            addCriterion("d_audit_time in", values, "dAuditTime");
            return (Criteria) this;
        }

        public Criteria andDAuditTimeNotIn(List<Date> values) {
            addCriterion("d_audit_time not in", values, "dAuditTime");
            return (Criteria) this;
        }

        public Criteria andDAuditTimeBetween(Date value1, Date value2) {
            addCriterion("d_audit_time between", value1, value2, "dAuditTime");
            return (Criteria) this;
        }

        public Criteria andDAuditTimeNotBetween(Date value1, Date value2) {
            addCriterion("d_audit_time not between", value1, value2, "dAuditTime");
            return (Criteria) this;
        }

        public Criteria andDRefuseTimeIsNull() {
            addCriterion("d_refuse_time is null");
            return (Criteria) this;
        }

        public Criteria andDRefuseTimeIsNotNull() {
            addCriterion("d_refuse_time is not null");
            return (Criteria) this;
        }

        public Criteria andDRefuseTimeEqualTo(Date value) {
            addCriterion("d_refuse_time =", value, "dRefuseTime");
            return (Criteria) this;
        }

        public Criteria andDRefuseTimeNotEqualTo(Date value) {
            addCriterion("d_refuse_time <>", value, "dRefuseTime");
            return (Criteria) this;
        }

        public Criteria andDRefuseTimeGreaterThan(Date value) {
            addCriterion("d_refuse_time >", value, "dRefuseTime");
            return (Criteria) this;
        }

        public Criteria andDRefuseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("d_refuse_time >=", value, "dRefuseTime");
            return (Criteria) this;
        }

        public Criteria andDRefuseTimeLessThan(Date value) {
            addCriterion("d_refuse_time <", value, "dRefuseTime");
            return (Criteria) this;
        }

        public Criteria andDRefuseTimeLessThanOrEqualTo(Date value) {
            addCriterion("d_refuse_time <=", value, "dRefuseTime");
            return (Criteria) this;
        }

        public Criteria andDRefuseTimeIn(List<Date> values) {
            addCriterion("d_refuse_time in", values, "dRefuseTime");
            return (Criteria) this;
        }

        public Criteria andDRefuseTimeNotIn(List<Date> values) {
            addCriterion("d_refuse_time not in", values, "dRefuseTime");
            return (Criteria) this;
        }

        public Criteria andDRefuseTimeBetween(Date value1, Date value2) {
            addCriterion("d_refuse_time between", value1, value2, "dRefuseTime");
            return (Criteria) this;
        }

        public Criteria andDRefuseTimeNotBetween(Date value1, Date value2) {
            addCriterion("d_refuse_time not between", value1, value2, "dRefuseTime");
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