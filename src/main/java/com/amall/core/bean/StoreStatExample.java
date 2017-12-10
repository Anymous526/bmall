package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class StoreStatExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreStatExample() {
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

        public Criteria andAllGoodsIsNull() {
            addCriterion("all_goods is null");
            return (Criteria) this;
        }

        public Criteria andAllGoodsIsNotNull() {
            addCriterion("all_goods is not null");
            return (Criteria) this;
        }

        public Criteria andAllGoodsEqualTo(Integer value) {
            addCriterion("all_goods =", value, "allGoods");
            return (Criteria) this;
        }

        public Criteria andAllGoodsNotEqualTo(Integer value) {
            addCriterion("all_goods <>", value, "allGoods");
            return (Criteria) this;
        }

        public Criteria andAllGoodsGreaterThan(Integer value) {
            addCriterion("all_goods >", value, "allGoods");
            return (Criteria) this;
        }

        public Criteria andAllGoodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_goods >=", value, "allGoods");
            return (Criteria) this;
        }

        public Criteria andAllGoodsLessThan(Integer value) {
            addCriterion("all_goods <", value, "allGoods");
            return (Criteria) this;
        }

        public Criteria andAllGoodsLessThanOrEqualTo(Integer value) {
            addCriterion("all_goods <=", value, "allGoods");
            return (Criteria) this;
        }

        public Criteria andAllGoodsIn(List<Integer> values) {
            addCriterion("all_goods in", values, "allGoods");
            return (Criteria) this;
        }

        public Criteria andAllGoodsNotIn(List<Integer> values) {
            addCriterion("all_goods not in", values, "allGoods");
            return (Criteria) this;
        }

        public Criteria andAllGoodsBetween(Integer value1, Integer value2) {
            addCriterion("all_goods between", value1, value2, "allGoods");
            return (Criteria) this;
        }

        public Criteria andAllGoodsNotBetween(Integer value1, Integer value2) {
            addCriterion("all_goods not between", value1, value2, "allGoods");
            return (Criteria) this;
        }

        public Criteria andAllStoreIsNull() {
            addCriterion("all_store is null");
            return (Criteria) this;
        }

        public Criteria andAllStoreIsNotNull() {
            addCriterion("all_store is not null");
            return (Criteria) this;
        }

        public Criteria andAllStoreEqualTo(Integer value) {
            addCriterion("all_store =", value, "allStore");
            return (Criteria) this;
        }

        public Criteria andAllStoreNotEqualTo(Integer value) {
            addCriterion("all_store <>", value, "allStore");
            return (Criteria) this;
        }

        public Criteria andAllStoreGreaterThan(Integer value) {
            addCriterion("all_store >", value, "allStore");
            return (Criteria) this;
        }

        public Criteria andAllStoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_store >=", value, "allStore");
            return (Criteria) this;
        }

        public Criteria andAllStoreLessThan(Integer value) {
            addCriterion("all_store <", value, "allStore");
            return (Criteria) this;
        }

        public Criteria andAllStoreLessThanOrEqualTo(Integer value) {
            addCriterion("all_store <=", value, "allStore");
            return (Criteria) this;
        }

        public Criteria andAllStoreIn(List<Integer> values) {
            addCriterion("all_store in", values, "allStore");
            return (Criteria) this;
        }

        public Criteria andAllStoreNotIn(List<Integer> values) {
            addCriterion("all_store not in", values, "allStore");
            return (Criteria) this;
        }

        public Criteria andAllStoreBetween(Integer value1, Integer value2) {
            addCriterion("all_store between", value1, value2, "allStore");
            return (Criteria) this;
        }

        public Criteria andAllStoreNotBetween(Integer value1, Integer value2) {
            addCriterion("all_store not between", value1, value2, "allStore");
            return (Criteria) this;
        }

        public Criteria andAllUserIsNull() {
            addCriterion("all_user is null");
            return (Criteria) this;
        }

        public Criteria andAllUserIsNotNull() {
            addCriterion("all_user is not null");
            return (Criteria) this;
        }

        public Criteria andAllUserEqualTo(Integer value) {
            addCriterion("all_user =", value, "allUser");
            return (Criteria) this;
        }

        public Criteria andAllUserNotEqualTo(Integer value) {
            addCriterion("all_user <>", value, "allUser");
            return (Criteria) this;
        }

        public Criteria andAllUserGreaterThan(Integer value) {
            addCriterion("all_user >", value, "allUser");
            return (Criteria) this;
        }

        public Criteria andAllUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_user >=", value, "allUser");
            return (Criteria) this;
        }

        public Criteria andAllUserLessThan(Integer value) {
            addCriterion("all_user <", value, "allUser");
            return (Criteria) this;
        }

        public Criteria andAllUserLessThanOrEqualTo(Integer value) {
            addCriterion("all_user <=", value, "allUser");
            return (Criteria) this;
        }

        public Criteria andAllUserIn(List<Integer> values) {
            addCriterion("all_user in", values, "allUser");
            return (Criteria) this;
        }

        public Criteria andAllUserNotIn(List<Integer> values) {
            addCriterion("all_user not in", values, "allUser");
            return (Criteria) this;
        }

        public Criteria andAllUserBetween(Integer value1, Integer value2) {
            addCriterion("all_user between", value1, value2, "allUser");
            return (Criteria) this;
        }

        public Criteria andAllUserNotBetween(Integer value1, Integer value2) {
            addCriterion("all_user not between", value1, value2, "allUser");
            return (Criteria) this;
        }

        public Criteria andNextTimeIsNull() {
            addCriterion("next_time is null");
            return (Criteria) this;
        }

        public Criteria andNextTimeIsNotNull() {
            addCriterion("next_time is not null");
            return (Criteria) this;
        }

        public Criteria andNextTimeEqualTo(Date value) {
            addCriterion("next_time =", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeNotEqualTo(Date value) {
            addCriterion("next_time <>", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeGreaterThan(Date value) {
            addCriterion("next_time >", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("next_time >=", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeLessThan(Date value) {
            addCriterion("next_time <", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeLessThanOrEqualTo(Date value) {
            addCriterion("next_time <=", value, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeIn(List<Date> values) {
            addCriterion("next_time in", values, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeNotIn(List<Date> values) {
            addCriterion("next_time not in", values, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeBetween(Date value1, Date value2) {
            addCriterion("next_time between", value1, value2, "nextTime");
            return (Criteria) this;
        }

        public Criteria andNextTimeNotBetween(Date value1, Date value2) {
            addCriterion("next_time not between", value1, value2, "nextTime");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<BigDecimal> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andStoreUpdateIsNull() {
            addCriterion("store_update is null");
            return (Criteria) this;
        }

        public Criteria andStoreUpdateIsNotNull() {
            addCriterion("store_update is not null");
            return (Criteria) this;
        }

        public Criteria andStoreUpdateEqualTo(Integer value) {
            addCriterion("store_update =", value, "storeUpdate");
            return (Criteria) this;
        }

        public Criteria andStoreUpdateNotEqualTo(Integer value) {
            addCriterion("store_update <>", value, "storeUpdate");
            return (Criteria) this;
        }

        public Criteria andStoreUpdateGreaterThan(Integer value) {
            addCriterion("store_update >", value, "storeUpdate");
            return (Criteria) this;
        }

        public Criteria andStoreUpdateGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_update >=", value, "storeUpdate");
            return (Criteria) this;
        }

        public Criteria andStoreUpdateLessThan(Integer value) {
            addCriterion("store_update <", value, "storeUpdate");
            return (Criteria) this;
        }

        public Criteria andStoreUpdateLessThanOrEqualTo(Integer value) {
            addCriterion("store_update <=", value, "storeUpdate");
            return (Criteria) this;
        }

        public Criteria andStoreUpdateIn(List<Integer> values) {
            addCriterion("store_update in", values, "storeUpdate");
            return (Criteria) this;
        }

        public Criteria andStoreUpdateNotIn(List<Integer> values) {
            addCriterion("store_update not in", values, "storeUpdate");
            return (Criteria) this;
        }

        public Criteria andStoreUpdateBetween(Integer value1, Integer value2) {
            addCriterion("store_update between", value1, value2, "storeUpdate");
            return (Criteria) this;
        }

        public Criteria andStoreUpdateNotBetween(Integer value1, Integer value2) {
            addCriterion("store_update not between", value1, value2, "storeUpdate");
            return (Criteria) this;
        }

        public Criteria andWeekComplaintIsNull() {
            addCriterion("week_complaint is null");
            return (Criteria) this;
        }

        public Criteria andWeekComplaintIsNotNull() {
            addCriterion("week_complaint is not null");
            return (Criteria) this;
        }

        public Criteria andWeekComplaintEqualTo(Integer value) {
            addCriterion("week_complaint =", value, "weekComplaint");
            return (Criteria) this;
        }

        public Criteria andWeekComplaintNotEqualTo(Integer value) {
            addCriterion("week_complaint <>", value, "weekComplaint");
            return (Criteria) this;
        }

        public Criteria andWeekComplaintGreaterThan(Integer value) {
            addCriterion("week_complaint >", value, "weekComplaint");
            return (Criteria) this;
        }

        public Criteria andWeekComplaintGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_complaint >=", value, "weekComplaint");
            return (Criteria) this;
        }

        public Criteria andWeekComplaintLessThan(Integer value) {
            addCriterion("week_complaint <", value, "weekComplaint");
            return (Criteria) this;
        }

        public Criteria andWeekComplaintLessThanOrEqualTo(Integer value) {
            addCriterion("week_complaint <=", value, "weekComplaint");
            return (Criteria) this;
        }

        public Criteria andWeekComplaintIn(List<Integer> values) {
            addCriterion("week_complaint in", values, "weekComplaint");
            return (Criteria) this;
        }

        public Criteria andWeekComplaintNotIn(List<Integer> values) {
            addCriterion("week_complaint not in", values, "weekComplaint");
            return (Criteria) this;
        }

        public Criteria andWeekComplaintBetween(Integer value1, Integer value2) {
            addCriterion("week_complaint between", value1, value2, "weekComplaint");
            return (Criteria) this;
        }

        public Criteria andWeekComplaintNotBetween(Integer value1, Integer value2) {
            addCriterion("week_complaint not between", value1, value2, "weekComplaint");
            return (Criteria) this;
        }

        public Criteria andWeekGoodsIsNull() {
            addCriterion("week_goods is null");
            return (Criteria) this;
        }

        public Criteria andWeekGoodsIsNotNull() {
            addCriterion("week_goods is not null");
            return (Criteria) this;
        }

        public Criteria andWeekGoodsEqualTo(Integer value) {
            addCriterion("week_goods =", value, "weekGoods");
            return (Criteria) this;
        }

        public Criteria andWeekGoodsNotEqualTo(Integer value) {
            addCriterion("week_goods <>", value, "weekGoods");
            return (Criteria) this;
        }

        public Criteria andWeekGoodsGreaterThan(Integer value) {
            addCriterion("week_goods >", value, "weekGoods");
            return (Criteria) this;
        }

        public Criteria andWeekGoodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_goods >=", value, "weekGoods");
            return (Criteria) this;
        }

        public Criteria andWeekGoodsLessThan(Integer value) {
            addCriterion("week_goods <", value, "weekGoods");
            return (Criteria) this;
        }

        public Criteria andWeekGoodsLessThanOrEqualTo(Integer value) {
            addCriterion("week_goods <=", value, "weekGoods");
            return (Criteria) this;
        }

        public Criteria andWeekGoodsIn(List<Integer> values) {
            addCriterion("week_goods in", values, "weekGoods");
            return (Criteria) this;
        }

        public Criteria andWeekGoodsNotIn(List<Integer> values) {
            addCriterion("week_goods not in", values, "weekGoods");
            return (Criteria) this;
        }

        public Criteria andWeekGoodsBetween(Integer value1, Integer value2) {
            addCriterion("week_goods between", value1, value2, "weekGoods");
            return (Criteria) this;
        }

        public Criteria andWeekGoodsNotBetween(Integer value1, Integer value2) {
            addCriterion("week_goods not between", value1, value2, "weekGoods");
            return (Criteria) this;
        }

        public Criteria andWeekOrderIsNull() {
            addCriterion("week_order is null");
            return (Criteria) this;
        }

        public Criteria andWeekOrderIsNotNull() {
            addCriterion("week_order is not null");
            return (Criteria) this;
        }

        public Criteria andWeekOrderEqualTo(Integer value) {
            addCriterion("week_order =", value, "weekOrder");
            return (Criteria) this;
        }

        public Criteria andWeekOrderNotEqualTo(Integer value) {
            addCriterion("week_order <>", value, "weekOrder");
            return (Criteria) this;
        }

        public Criteria andWeekOrderGreaterThan(Integer value) {
            addCriterion("week_order >", value, "weekOrder");
            return (Criteria) this;
        }

        public Criteria andWeekOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_order >=", value, "weekOrder");
            return (Criteria) this;
        }

        public Criteria andWeekOrderLessThan(Integer value) {
            addCriterion("week_order <", value, "weekOrder");
            return (Criteria) this;
        }

        public Criteria andWeekOrderLessThanOrEqualTo(Integer value) {
            addCriterion("week_order <=", value, "weekOrder");
            return (Criteria) this;
        }

        public Criteria andWeekOrderIn(List<Integer> values) {
            addCriterion("week_order in", values, "weekOrder");
            return (Criteria) this;
        }

        public Criteria andWeekOrderNotIn(List<Integer> values) {
            addCriterion("week_order not in", values, "weekOrder");
            return (Criteria) this;
        }

        public Criteria andWeekOrderBetween(Integer value1, Integer value2) {
            addCriterion("week_order between", value1, value2, "weekOrder");
            return (Criteria) this;
        }

        public Criteria andWeekOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("week_order not between", value1, value2, "weekOrder");
            return (Criteria) this;
        }

        public Criteria andWeekReportIsNull() {
            addCriterion("week_report is null");
            return (Criteria) this;
        }

        public Criteria andWeekReportIsNotNull() {
            addCriterion("week_report is not null");
            return (Criteria) this;
        }

        public Criteria andWeekReportEqualTo(Integer value) {
            addCriterion("week_report =", value, "weekReport");
            return (Criteria) this;
        }

        public Criteria andWeekReportNotEqualTo(Integer value) {
            addCriterion("week_report <>", value, "weekReport");
            return (Criteria) this;
        }

        public Criteria andWeekReportGreaterThan(Integer value) {
            addCriterion("week_report >", value, "weekReport");
            return (Criteria) this;
        }

        public Criteria andWeekReportGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_report >=", value, "weekReport");
            return (Criteria) this;
        }

        public Criteria andWeekReportLessThan(Integer value) {
            addCriterion("week_report <", value, "weekReport");
            return (Criteria) this;
        }

        public Criteria andWeekReportLessThanOrEqualTo(Integer value) {
            addCriterion("week_report <=", value, "weekReport");
            return (Criteria) this;
        }

        public Criteria andWeekReportIn(List<Integer> values) {
            addCriterion("week_report in", values, "weekReport");
            return (Criteria) this;
        }

        public Criteria andWeekReportNotIn(List<Integer> values) {
            addCriterion("week_report not in", values, "weekReport");
            return (Criteria) this;
        }

        public Criteria andWeekReportBetween(Integer value1, Integer value2) {
            addCriterion("week_report between", value1, value2, "weekReport");
            return (Criteria) this;
        }

        public Criteria andWeekReportNotBetween(Integer value1, Integer value2) {
            addCriterion("week_report not between", value1, value2, "weekReport");
            return (Criteria) this;
        }

        public Criteria andWeekStoreIsNull() {
            addCriterion("week_store is null");
            return (Criteria) this;
        }

        public Criteria andWeekStoreIsNotNull() {
            addCriterion("week_store is not null");
            return (Criteria) this;
        }

        public Criteria andWeekStoreEqualTo(Integer value) {
            addCriterion("week_store =", value, "weekStore");
            return (Criteria) this;
        }

        public Criteria andWeekStoreNotEqualTo(Integer value) {
            addCriterion("week_store <>", value, "weekStore");
            return (Criteria) this;
        }

        public Criteria andWeekStoreGreaterThan(Integer value) {
            addCriterion("week_store >", value, "weekStore");
            return (Criteria) this;
        }

        public Criteria andWeekStoreGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_store >=", value, "weekStore");
            return (Criteria) this;
        }

        public Criteria andWeekStoreLessThan(Integer value) {
            addCriterion("week_store <", value, "weekStore");
            return (Criteria) this;
        }

        public Criteria andWeekStoreLessThanOrEqualTo(Integer value) {
            addCriterion("week_store <=", value, "weekStore");
            return (Criteria) this;
        }

        public Criteria andWeekStoreIn(List<Integer> values) {
            addCriterion("week_store in", values, "weekStore");
            return (Criteria) this;
        }

        public Criteria andWeekStoreNotIn(List<Integer> values) {
            addCriterion("week_store not in", values, "weekStore");
            return (Criteria) this;
        }

        public Criteria andWeekStoreBetween(Integer value1, Integer value2) {
            addCriterion("week_store between", value1, value2, "weekStore");
            return (Criteria) this;
        }

        public Criteria andWeekStoreNotBetween(Integer value1, Integer value2) {
            addCriterion("week_store not between", value1, value2, "weekStore");
            return (Criteria) this;
        }

        public Criteria andWeekUserIsNull() {
            addCriterion("week_user is null");
            return (Criteria) this;
        }

        public Criteria andWeekUserIsNotNull() {
            addCriterion("week_user is not null");
            return (Criteria) this;
        }

        public Criteria andWeekUserEqualTo(Integer value) {
            addCriterion("week_user =", value, "weekUser");
            return (Criteria) this;
        }

        public Criteria andWeekUserNotEqualTo(Integer value) {
            addCriterion("week_user <>", value, "weekUser");
            return (Criteria) this;
        }

        public Criteria andWeekUserGreaterThan(Integer value) {
            addCriterion("week_user >", value, "weekUser");
            return (Criteria) this;
        }

        public Criteria andWeekUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("week_user >=", value, "weekUser");
            return (Criteria) this;
        }

        public Criteria andWeekUserLessThan(Integer value) {
            addCriterion("week_user <", value, "weekUser");
            return (Criteria) this;
        }

        public Criteria andWeekUserLessThanOrEqualTo(Integer value) {
            addCriterion("week_user <=", value, "weekUser");
            return (Criteria) this;
        }

        public Criteria andWeekUserIn(List<Integer> values) {
            addCriterion("week_user in", values, "weekUser");
            return (Criteria) this;
        }

        public Criteria andWeekUserNotIn(List<Integer> values) {
            addCriterion("week_user not in", values, "weekUser");
            return (Criteria) this;
        }

        public Criteria andWeekUserBetween(Integer value1, Integer value2) {
            addCriterion("week_user between", value1, value2, "weekUser");
            return (Criteria) this;
        }

        public Criteria andWeekUserNotBetween(Integer value1, Integer value2) {
            addCriterion("week_user not between", value1, value2, "weekUser");
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