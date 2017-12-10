package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class IntegralGoodsOrderExample extends BaseQuery{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IntegralGoodsOrderExample() {
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

        public Criteria andIgoOrderSnIsNull() {
            addCriterion("igo_order_sn is null");
            return (Criteria) this;
        }

        public Criteria andIgoOrderSnIsNotNull() {
            addCriterion("igo_order_sn is not null");
            return (Criteria) this;
        }

        public Criteria andIgoOrderSnEqualTo(String value) {
            addCriterion("igo_order_sn =", value, "igoOrderSn");
            return (Criteria) this;
        }

        public Criteria andIgoOrderSnNotEqualTo(String value) {
            addCriterion("igo_order_sn <>", value, "igoOrderSn");
            return (Criteria) this;
        }

        public Criteria andIgoOrderSnGreaterThan(String value) {
            addCriterion("igo_order_sn >", value, "igoOrderSn");
            return (Criteria) this;
        }

        public Criteria andIgoOrderSnGreaterThanOrEqualTo(String value) {
            addCriterion("igo_order_sn >=", value, "igoOrderSn");
            return (Criteria) this;
        }

        public Criteria andIgoOrderSnLessThan(String value) {
            addCriterion("igo_order_sn <", value, "igoOrderSn");
            return (Criteria) this;
        }

        public Criteria andIgoOrderSnLessThanOrEqualTo(String value) {
            addCriterion("igo_order_sn <=", value, "igoOrderSn");
            return (Criteria) this;
        }

        public Criteria andIgoOrderSnLike(String value) {
            addCriterion("igo_order_sn like", value, "igoOrderSn");
            return (Criteria) this;
        }

        public Criteria andIgoOrderSnNotLike(String value) {
            addCriterion("igo_order_sn not like", value, "igoOrderSn");
            return (Criteria) this;
        }

        public Criteria andIgoOrderSnIn(List<String> values) {
            addCriterion("igo_order_sn in", values, "igoOrderSn");
            return (Criteria) this;
        }

        public Criteria andIgoOrderSnNotIn(List<String> values) {
            addCriterion("igo_order_sn not in", values, "igoOrderSn");
            return (Criteria) this;
        }

        public Criteria andIgoOrderSnBetween(String value1, String value2) {
            addCriterion("igo_order_sn between", value1, value2, "igoOrderSn");
            return (Criteria) this;
        }

        public Criteria andIgoOrderSnNotBetween(String value1, String value2) {
            addCriterion("igo_order_sn not between", value1, value2, "igoOrderSn");
            return (Criteria) this;
        }

        public Criteria andIgoPayTimeIsNull() {
            addCriterion("igo_pay_time is null");
            return (Criteria) this;
        }

        public Criteria andIgoPayTimeIsNotNull() {
            addCriterion("igo_pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andIgoPayTimeEqualTo(Date value) {
            addCriterion("igo_pay_time =", value, "igoPayTime");
            return (Criteria) this;
        }

        public Criteria andIgoPayTimeNotEqualTo(Date value) {
            addCriterion("igo_pay_time <>", value, "igoPayTime");
            return (Criteria) this;
        }

        public Criteria andIgoPayTimeGreaterThan(Date value) {
            addCriterion("igo_pay_time >", value, "igoPayTime");
            return (Criteria) this;
        }

        public Criteria andIgoPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("igo_pay_time >=", value, "igoPayTime");
            return (Criteria) this;
        }

        public Criteria andIgoPayTimeLessThan(Date value) {
            addCriterion("igo_pay_time <", value, "igoPayTime");
            return (Criteria) this;
        }

        public Criteria andIgoPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("igo_pay_time <=", value, "igoPayTime");
            return (Criteria) this;
        }

        public Criteria andIgoPayTimeIn(List<Date> values) {
            addCriterion("igo_pay_time in", values, "igoPayTime");
            return (Criteria) this;
        }

        public Criteria andIgoPayTimeNotIn(List<Date> values) {
            addCriterion("igo_pay_time not in", values, "igoPayTime");
            return (Criteria) this;
        }

        public Criteria andIgoPayTimeBetween(Date value1, Date value2) {
            addCriterion("igo_pay_time between", value1, value2, "igoPayTime");
            return (Criteria) this;
        }

        public Criteria andIgoPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("igo_pay_time not between", value1, value2, "igoPayTime");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentIsNull() {
            addCriterion("igo_payment is null");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentIsNotNull() {
            addCriterion("igo_payment is not null");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentEqualTo(String value) {
            addCriterion("igo_payment =", value, "igoPayment");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentNotEqualTo(String value) {
            addCriterion("igo_payment <>", value, "igoPayment");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentGreaterThan(String value) {
            addCriterion("igo_payment >", value, "igoPayment");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("igo_payment >=", value, "igoPayment");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentLessThan(String value) {
            addCriterion("igo_payment <", value, "igoPayment");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentLessThanOrEqualTo(String value) {
            addCriterion("igo_payment <=", value, "igoPayment");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentLike(String value) {
            addCriterion("igo_payment like", value, "igoPayment");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentNotLike(String value) {
            addCriterion("igo_payment not like", value, "igoPayment");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentIn(List<String> values) {
            addCriterion("igo_payment in", values, "igoPayment");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentNotIn(List<String> values) {
            addCriterion("igo_payment not in", values, "igoPayment");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentBetween(String value1, String value2) {
            addCriterion("igo_payment between", value1, value2, "igoPayment");
            return (Criteria) this;
        }

        public Criteria andIgoPaymentNotBetween(String value1, String value2) {
            addCriterion("igo_payment not between", value1, value2, "igoPayment");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeIsNull() {
            addCriterion("igo_ship_code is null");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeIsNotNull() {
            addCriterion("igo_ship_code is not null");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeEqualTo(String value) {
            addCriterion("igo_ship_code =", value, "igoShipCode");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeNotEqualTo(String value) {
            addCriterion("igo_ship_code <>", value, "igoShipCode");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeGreaterThan(String value) {
            addCriterion("igo_ship_code >", value, "igoShipCode");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeGreaterThanOrEqualTo(String value) {
            addCriterion("igo_ship_code >=", value, "igoShipCode");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeLessThan(String value) {
            addCriterion("igo_ship_code <", value, "igoShipCode");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeLessThanOrEqualTo(String value) {
            addCriterion("igo_ship_code <=", value, "igoShipCode");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeLike(String value) {
            addCriterion("igo_ship_code like", value, "igoShipCode");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeNotLike(String value) {
            addCriterion("igo_ship_code not like", value, "igoShipCode");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeIn(List<String> values) {
            addCriterion("igo_ship_code in", values, "igoShipCode");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeNotIn(List<String> values) {
            addCriterion("igo_ship_code not in", values, "igoShipCode");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeBetween(String value1, String value2) {
            addCriterion("igo_ship_code between", value1, value2, "igoShipCode");
            return (Criteria) this;
        }

        public Criteria andIgoShipCodeNotBetween(String value1, String value2) {
            addCriterion("igo_ship_code not between", value1, value2, "igoShipCode");
            return (Criteria) this;
        }

        public Criteria andIgoShipTimeIsNull() {
            addCriterion("igo_ship_time is null");
            return (Criteria) this;
        }

        public Criteria andIgoShipTimeIsNotNull() {
            addCriterion("igo_ship_time is not null");
            return (Criteria) this;
        }

        public Criteria andIgoShipTimeEqualTo(Date value) {
            addCriterionForJDBCDate("igo_ship_time =", value, "igoShipTime");
            return (Criteria) this;
        }

        public Criteria andIgoShipTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("igo_ship_time <>", value, "igoShipTime");
            return (Criteria) this;
        }

        public Criteria andIgoShipTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("igo_ship_time >", value, "igoShipTime");
            return (Criteria) this;
        }

        public Criteria andIgoShipTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("igo_ship_time >=", value, "igoShipTime");
            return (Criteria) this;
        }

        public Criteria andIgoShipTimeLessThan(Date value) {
            addCriterionForJDBCDate("igo_ship_time <", value, "igoShipTime");
            return (Criteria) this;
        }

        public Criteria andIgoShipTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("igo_ship_time <=", value, "igoShipTime");
            return (Criteria) this;
        }

        public Criteria andIgoShipTimeIn(List<Date> values) {
            addCriterionForJDBCDate("igo_ship_time in", values, "igoShipTime");
            return (Criteria) this;
        }

        public Criteria andIgoShipTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("igo_ship_time not in", values, "igoShipTime");
            return (Criteria) this;
        }

        public Criteria andIgoShipTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("igo_ship_time between", value1, value2, "igoShipTime");
            return (Criteria) this;
        }

        public Criteria andIgoShipTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("igo_ship_time not between", value1, value2, "igoShipTime");
            return (Criteria) this;
        }

        public Criteria andIgoStatusIsNull() {
            addCriterion("igo_status is null");
            return (Criteria) this;
        }

        public Criteria andIgoStatusIsNotNull() {
            addCriterion("igo_status is not null");
            return (Criteria) this;
        }

        public Criteria andIgoStatusEqualTo(Integer value) {
            addCriterion("igo_status =", value, "igoStatus");
            return (Criteria) this;
        }

        public Criteria andIgoStatusNotEqualTo(Integer value) {
            addCriterion("igo_status <>", value, "igoStatus");
            return (Criteria) this;
        }

        public Criteria andIgoStatusGreaterThan(Integer value) {
            addCriterion("igo_status >", value, "igoStatus");
            return (Criteria) this;
        }

        public Criteria andIgoStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("igo_status >=", value, "igoStatus");
            return (Criteria) this;
        }

        public Criteria andIgoStatusLessThan(Integer value) {
            addCriterion("igo_status <", value, "igoStatus");
            return (Criteria) this;
        }

        public Criteria andIgoStatusLessThanOrEqualTo(Integer value) {
            addCriterion("igo_status <=", value, "igoStatus");
            return (Criteria) this;
        }

        public Criteria andIgoStatusIn(List<Integer> values) {
            addCriterion("igo_status in", values, "igoStatus");
            return (Criteria) this;
        }

        public Criteria andIgoStatusNotIn(List<Integer> values) {
            addCriterion("igo_status not in", values, "igoStatus");
            return (Criteria) this;
        }

        public Criteria andIgoStatusBetween(Integer value1, Integer value2) {
            addCriterion("igo_status between", value1, value2, "igoStatus");
            return (Criteria) this;
        }

        public Criteria andIgoStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("igo_status not between", value1, value2, "igoStatus");
            return (Criteria) this;
        }

        public Criteria andIgoTotalIntegralIsNull() {
            addCriterion("igo_total_integral is null");
            return (Criteria) this;
        }

        public Criteria andIgoTotalgoldIsNotNull() {
            addCriterion("igo_total_integral is not null");
            return (Criteria) this;
        }

        public Criteria andIgoTotalIntegralEqualTo(Integer value) {
            addCriterion("igo_total_integral =", value, "igoTotalIntegral");
            return (Criteria) this;
        }

        public Criteria andIgoTotalIntegralNotEqualTo(Integer value) {
            addCriterion("igo_total_integral <>", value, "igoTotalIntegral");
            return (Criteria) this;
        }

        public Criteria andIgoTotalIntegralGreaterThan(Integer value) {
            addCriterion("igo_total_integral >", value, "igoTotalIntegral");
            return (Criteria) this;
        }

        public Criteria andIgoTotalIntegralGreaterThanOrEqualTo(Integer value) {
            addCriterion("igo_total_integral >=", value, "igoTotalIntegral");
            return (Criteria) this;
        }

        public Criteria andIgoTotalIntegralLessThan(Integer value) {
            addCriterion("igo_total_integral <", value, "igoTotalIntegral");
            return (Criteria) this;
        }

        public Criteria andIgoTotalIntegralLessThanOrEqualTo(Integer value) {
            addCriterion("igo_total_integral <=", value, "igoTotalIntegral");
            return (Criteria) this;
        }

        public Criteria andIgoTotalIntegralIn(List<Integer> values) {
            addCriterion("igo_total_integral in", values, "igoTotalIntegral");
            return (Criteria) this;
        }

        public Criteria andIgoTotalIntegralNotIn(List<Integer> values) {
            addCriterion("igo_total_integral not in", values, "igoTotalIntegral");
            return (Criteria) this;
        }

        public Criteria andIgoTotalIntegralBetween(Integer value1, Integer value2) {
            addCriterion("igo_total_integral between", value1, value2, "igoTotalIntegral");
            return (Criteria) this;
        }

        public Criteria andIgoTotalIntegralNotBetween(Integer value1, Integer value2) {
            addCriterion("igo_total_integral not between", value1, value2, "igoTotalIntegral");
            return (Criteria) this;
        }
        
        
        public Criteria andIgoTotalGoldIsNull() {
        	addCriterion("igo_total_integral is null");
        	return (Criteria) this;
        }
        
        public Criteria andIgoTotalGoldIsNotNull() {
        	addCriterion("igo_total_gold is not null");
        	return (Criteria) this;
        }
        
        public Criteria andIgoTotalGoldEqualTo(Integer value) {
        	addCriterion("igo_total_gold =", value, "igoTotalGold");
        	return (Criteria) this;
        }
        
        public Criteria andIgoTotalGoldNotEqualTo(Integer value) {
        	addCriterion("igo_total_gold <>", value, "igoTotalGold");
        	return (Criteria) this;
        }
        
        public Criteria andIgoTotalGoldGreaterThan(Integer value) {
        	addCriterion("igo_total_gold >", value, "igoTotalGold");
        	return (Criteria) this;
        }
        
        public Criteria andIgoTotalGoldGreaterThanOrEqualTo(Integer value) {
        	addCriterion("igo_total_gold >=", value, "igoTotalGold");
        	return (Criteria) this;
        }
        
        public Criteria andIgoTotalGoldLessThan(Integer value) {
        	addCriterion("igo_total_gold <", value, "igoTotalGold");
        	return (Criteria) this;
        }
        
        public Criteria andIgoTotalGoldLessThanOrEqualTo(Integer value) {
        	addCriterion("igo_total_gold <=", value, "igoTotalGold");
        	return (Criteria) this;
        }
        
        public Criteria andIgoTotalGoldIn(List<Integer> values) {
        	addCriterion("igo_total_gold in", values, "igoTotalGold");
        	return (Criteria) this;
        }
        
        public Criteria andIgoTotalGoldNotIn(List<Integer> values) {
        	addCriterion("igo_total_gold not in", values, "igoTotalGold");
        	return (Criteria) this;
        }
        
        public Criteria andIgoTotalGoldBetween(Integer value1, Integer value2) {
        	addCriterion("igo_total_gold between", value1, value2, "igoTotalGold");
        	return (Criteria) this;
        }
        
        public Criteria andIgoTotalGoldNotBetween(Integer value1, Integer value2) {
        	addCriterion("igo_total_gold not between", value1, value2, "igoTotalGold");
        	return (Criteria) this;
        }
        

        public Criteria andIgoTransFeeIsNull() {
            addCriterion("igo_trans_fee is null");
            return (Criteria) this;
        }

        public Criteria andIgoTransFeeIsNotNull() {
            addCriterion("igo_trans_fee is not null");
            return (Criteria) this;
        }

        public Criteria andIgoTransFeeEqualTo(BigDecimal value) {
            addCriterion("igo_trans_fee =", value, "igoTransFee");
            return (Criteria) this;
        }

        public Criteria andIgoTransFeeNotEqualTo(BigDecimal value) {
            addCriterion("igo_trans_fee <>", value, "igoTransFee");
            return (Criteria) this;
        }

        public Criteria andIgoTransFeeGreaterThan(BigDecimal value) {
            addCriterion("igo_trans_fee >", value, "igoTransFee");
            return (Criteria) this;
        }

        public Criteria andIgoTransFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("igo_trans_fee >=", value, "igoTransFee");
            return (Criteria) this;
        }

        public Criteria andIgoTransFeeLessThan(BigDecimal value) {
            addCriterion("igo_trans_fee <", value, "igoTransFee");
            return (Criteria) this;
        }

        public Criteria andIgoTransFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("igo_trans_fee <=", value, "igoTransFee");
            return (Criteria) this;
        }

        public Criteria andIgoTransFeeIn(List<BigDecimal> values) {
            addCriterion("igo_trans_fee in", values, "igoTransFee");
            return (Criteria) this;
        }

        public Criteria andIgoTransFeeNotIn(List<BigDecimal> values) {
            addCriterion("igo_trans_fee not in", values, "igoTransFee");
            return (Criteria) this;
        }

        public Criteria andIgoTransFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("igo_trans_fee between", value1, value2, "igoTransFee");
            return (Criteria) this;
        }

        public Criteria andIgoTransFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("igo_trans_fee not between", value1, value2, "igoTransFee");
            return (Criteria) this;
        }

        public Criteria andIgoAddrIdIsNull() {
            addCriterion("igo_addr_id is null");
            return (Criteria) this;
        }

        public Criteria andIgoAddrIdIsNotNull() {
            addCriterion("igo_addr_id is not null");
            return (Criteria) this;
        }

        public Criteria andIgoAddrIdEqualTo(Long value) {
            addCriterion("igo_addr_id =", value, "igoAddrId");
            return (Criteria) this;
        }

        public Criteria andIgoAddrIdNotEqualTo(Long value) {
            addCriterion("igo_addr_id <>", value, "igoAddrId");
            return (Criteria) this;
        }

        public Criteria andIgoAddrIdGreaterThan(Long value) {
            addCriterion("igo_addr_id >", value, "igoAddrId");
            return (Criteria) this;
        }

        public Criteria andIgoAddrIdGreaterThanOrEqualTo(Long value) {
            addCriterion("igo_addr_id >=", value, "igoAddrId");
            return (Criteria) this;
        }

        public Criteria andIgoAddrIdLessThan(Long value) {
            addCriterion("igo_addr_id <", value, "igoAddrId");
            return (Criteria) this;
        }

        public Criteria andIgoAddrIdLessThanOrEqualTo(Long value) {
            addCriterion("igo_addr_id <=", value, "igoAddrId");
            return (Criteria) this;
        }

        public Criteria andIgoAddrIdIn(List<Long> values) {
            addCriterion("igo_addr_id in", values, "igoAddrId");
            return (Criteria) this;
        }

        public Criteria andIgoAddrIdNotIn(List<Long> values) {
            addCriterion("igo_addr_id not in", values, "igoAddrId");
            return (Criteria) this;
        }

        public Criteria andIgoAddrIdBetween(Long value1, Long value2) {
            addCriterion("igo_addr_id between", value1, value2, "igoAddrId");
            return (Criteria) this;
        }

        public Criteria andIgoAddrIdNotBetween(Long value1, Long value2) {
            addCriterion("igo_addr_id not between", value1, value2, "igoAddrId");
            return (Criteria) this;
        }

        public Criteria andIgoUserIdIsNull() {
            addCriterion("igo_user_id is null");
            return (Criteria) this;
        }

        public Criteria andIgoUserIdIsNotNull() {
            addCriterion("igo_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andIgoUserIdEqualTo(Long value) {
            addCriterion("igo_user_id =", value, "igoUserId");
            return (Criteria) this;
        }

        public Criteria andIgoUserIdNotEqualTo(Long value) {
            addCriterion("igo_user_id <>", value, "igoUserId");
            return (Criteria) this;
        }

        public Criteria andIgoUserIdGreaterThan(Long value) {
            addCriterion("igo_user_id >", value, "igoUserId");
            return (Criteria) this;
        }

        public Criteria andIgoUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("igo_user_id >=", value, "igoUserId");
            return (Criteria) this;
        }

        public Criteria andIgoUserIdLessThan(Long value) {
            addCriterion("igo_user_id <", value, "igoUserId");
            return (Criteria) this;
        }

        public Criteria andIgoUserIdLessThanOrEqualTo(Long value) {
            addCriterion("igo_user_id <=", value, "igoUserId");
            return (Criteria) this;
        }

        public Criteria andIgoUserIdIn(List<Long> values) {
            addCriterion("igo_user_id in", values, "igoUserId");
            return (Criteria) this;
        }

        public Criteria andIgoUserIdNotIn(List<Long> values) {
            addCriterion("igo_user_id not in", values, "igoUserId");
            return (Criteria) this;
        }

        public Criteria andIgoUserIdBetween(Long value1, Long value2) {
            addCriterion("igo_user_id between", value1, value2, "igoUserId");
            return (Criteria) this;
        }

        public Criteria andIgoUserIdNotBetween(Long value1, Long value2) {
            addCriterion("igo_user_id not between", value1, value2, "igoUserId");
            return (Criteria) this;
        }
        
        public Criteria andIgIdIsNull() {
            addCriterion("igId is null");
            return (Criteria) this;
        }

        public Criteria andIgIdIsNotNull() {
            addCriterion("igId is not null");
            return (Criteria) this;
        }

        public Criteria andIgIdEqualTo(Long value) {
            addCriterion("igId =", value, "igId");
            return (Criteria) this;
        }

        public Criteria andIgIdNotEqualTo(Long value) {
            addCriterion("igId <>", value, "igId");
            return (Criteria) this;
        }

        public Criteria andIgIdGreaterThan(Long value) {
            addCriterion("igId >", value, "igId");
            return (Criteria) this;
        }

        public Criteria andIgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("igId >=", value, "igId");
            return (Criteria) this;
        }

        public Criteria andIgIdLessThan(Long value) {
            addCriterion("igId <", value, "igId");
            return (Criteria) this;
        }

        public Criteria andIgIdLessThanOrEqualTo(Long value) {
            addCriterion("igId <=", value, "igId");
            return (Criteria) this;
        }

        public Criteria andIgIdIn(List<Long> values) {
            addCriterion("igId in", values, "igId");
            return (Criteria) this;
        }

        public Criteria andIgIdNotIn(List<Long> values) {
            addCriterion("igId not in", values, "igId");
            return (Criteria) this;
        }

        public Criteria andIgIdBetween(Long value1, Long value2) {
            addCriterion("igId between", value1, value2, "igId");
            return (Criteria) this;
        }

        public Criteria andIgIdNotBetween(Long value1, Long value2) {
            addCriterion("igId not between", value1, value2, "igId");
            return (Criteria) this;
        }
        
        
        
        
        
        public Criteria andEcIdIsNull() {
            addCriterion("ecId is null");
            return (Criteria) this;
        }

        public Criteria andEcIdIsNotNull() {
            addCriterion("ecId is not null");
            return (Criteria) this;
        }

        public Criteria andEcIdEqualTo(Long value) {
            addCriterion("ecId =", value, "ecId");
            return (Criteria) this;
        }

        public Criteria andEcIdNotEqualTo(Long value) {
            addCriterion("ecId <>", value, "ecId");
            return (Criteria) this;
        }

        public Criteria andEcIdGreaterThan(Long value) {
            addCriterion("ecId >", value, "ecId");
            return (Criteria) this;
        }

        public Criteria andEcIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ecId >=", value, "ecId");
            return (Criteria) this;
        }

        public Criteria andEcIdLessThan(Long value) {
            addCriterion("ecId <", value, "ecId");
            return (Criteria) this;
        }

        public Criteria andEcIdLessThanOrEqualTo(Long value) {
            addCriterion("ecId <=", value, "ecId");
            return (Criteria) this;
        }

        public Criteria andEcIdIn(List<Long> values) {
            addCriterion("ecId in", values, "ecId");
            return (Criteria) this;
        }

        public Criteria andEcIdNotIn(List<Long> values) {
            addCriterion("ecId not in", values, "ecId");
            return (Criteria) this;
        }

        public Criteria andEcIdBetween(Long value1, Long value2) {
            addCriterion("ecId between", value1, value2, "ecId");
            return (Criteria) this;
        }

        public Criteria andEcIdNotBetween(Long value1, Long value2) {
            addCriterion("ecId not between", value1, value2, "ecId");
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