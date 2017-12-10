package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class PredepositExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PredepositExample() {
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

        public Criteria andPdAmountIsNull() {
            addCriterion("pd_amount is null");
            return (Criteria) this;
        }

        public Criteria andPdAmountIsNotNull() {
            addCriterion("pd_amount is not null");
            return (Criteria) this;
        }

        public Criteria andPdAmountEqualTo(BigDecimal value) {
            addCriterion("pd_amount =", value, "pdAmount");
            return (Criteria) this;
        }

        public Criteria andPdAmountNotEqualTo(BigDecimal value) {
            addCriterion("pd_amount <>", value, "pdAmount");
            return (Criteria) this;
        }

        public Criteria andPdAmountGreaterThan(BigDecimal value) {
            addCriterion("pd_amount >", value, "pdAmount");
            return (Criteria) this;
        }

        public Criteria andPdAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("pd_amount >=", value, "pdAmount");
            return (Criteria) this;
        }

        public Criteria andPdAmountLessThan(BigDecimal value) {
            addCriterion("pd_amount <", value, "pdAmount");
            return (Criteria) this;
        }

        public Criteria andPdAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("pd_amount <=", value, "pdAmount");
            return (Criteria) this;
        }

        public Criteria andPdAmountIn(List<BigDecimal> values) {
            addCriterion("pd_amount in", values, "pdAmount");
            return (Criteria) this;
        }

        public Criteria andPdAmountNotIn(List<BigDecimal> values) {
            addCriterion("pd_amount not in", values, "pdAmount");
            return (Criteria) this;
        }

        public Criteria andPdAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pd_amount between", value1, value2, "pdAmount");
            return (Criteria) this;
        }

        public Criteria andPdAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("pd_amount not between", value1, value2, "pdAmount");
            return (Criteria) this;
        }

        public Criteria andPdPayStatusIsNull() {
            addCriterion("pd_pay_status is null");
            return (Criteria) this;
        }

        public Criteria andPdPayStatusIsNotNull() {
            addCriterion("pd_pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andPdPayStatusEqualTo(Integer value) {
            addCriterion("pd_pay_status =", value, "pdPayStatus");
            return (Criteria) this;
        }

        public Criteria andPdPayStatusNotEqualTo(Integer value) {
            addCriterion("pd_pay_status <>", value, "pdPayStatus");
            return (Criteria) this;
        }

        public Criteria andPdPayStatusGreaterThan(Integer value) {
            addCriterion("pd_pay_status >", value, "pdPayStatus");
            return (Criteria) this;
        }

        public Criteria andPdPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pd_pay_status >=", value, "pdPayStatus");
            return (Criteria) this;
        }

        public Criteria andPdPayStatusLessThan(Integer value) {
            addCriterion("pd_pay_status <", value, "pdPayStatus");
            return (Criteria) this;
        }

        public Criteria andPdPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pd_pay_status <=", value, "pdPayStatus");
            return (Criteria) this;
        }

        public Criteria andPdPayStatusIn(List<Integer> values) {
            addCriterion("pd_pay_status in", values, "pdPayStatus");
            return (Criteria) this;
        }

        public Criteria andPdPayStatusNotIn(List<Integer> values) {
            addCriterion("pd_pay_status not in", values, "pdPayStatus");
            return (Criteria) this;
        }

        public Criteria andPdPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("pd_pay_status between", value1, value2, "pdPayStatus");
            return (Criteria) this;
        }

        public Criteria andPdPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pd_pay_status not between", value1, value2, "pdPayStatus");
            return (Criteria) this;
        }

        public Criteria andPdPaymentIsNull() {
            addCriterion("pd_payment is null");
            return (Criteria) this;
        }

        public Criteria andPdPaymentIsNotNull() {
            addCriterion("pd_payment is not null");
            return (Criteria) this;
        }

        public Criteria andPdPaymentEqualTo(String value) {
            addCriterion("pd_payment =", value, "pdPayment");
            return (Criteria) this;
        }

        public Criteria andPdPaymentNotEqualTo(String value) {
            addCriterion("pd_payment <>", value, "pdPayment");
            return (Criteria) this;
        }

        public Criteria andPdPaymentGreaterThan(String value) {
            addCriterion("pd_payment >", value, "pdPayment");
            return (Criteria) this;
        }

        public Criteria andPdPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("pd_payment >=", value, "pdPayment");
            return (Criteria) this;
        }

        public Criteria andPdPaymentLessThan(String value) {
            addCriterion("pd_payment <", value, "pdPayment");
            return (Criteria) this;
        }

        public Criteria andPdPaymentLessThanOrEqualTo(String value) {
            addCriterion("pd_payment <=", value, "pdPayment");
            return (Criteria) this;
        }

        public Criteria andPdPaymentLike(String value) {
            addCriterion("pd_payment like", value, "pdPayment");
            return (Criteria) this;
        }

        public Criteria andPdPaymentNotLike(String value) {
            addCriterion("pd_payment not like", value, "pdPayment");
            return (Criteria) this;
        }

        public Criteria andPdPaymentIn(List<String> values) {
            addCriterion("pd_payment in", values, "pdPayment");
            return (Criteria) this;
        }

        public Criteria andPdPaymentNotIn(List<String> values) {
            addCriterion("pd_payment not in", values, "pdPayment");
            return (Criteria) this;
        }

        public Criteria andPdPaymentBetween(String value1, String value2) {
            addCriterion("pd_payment between", value1, value2, "pdPayment");
            return (Criteria) this;
        }

        public Criteria andPdPaymentNotBetween(String value1, String value2) {
            addCriterion("pd_payment not between", value1, value2, "pdPayment");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankIsNull() {
            addCriterion("pd_remittance_bank is null");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankIsNotNull() {
            addCriterion("pd_remittance_bank is not null");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankEqualTo(String value) {
            addCriterion("pd_remittance_bank =", value, "pdRemittanceBank");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankNotEqualTo(String value) {
            addCriterion("pd_remittance_bank <>", value, "pdRemittanceBank");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankGreaterThan(String value) {
            addCriterion("pd_remittance_bank >", value, "pdRemittanceBank");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankGreaterThanOrEqualTo(String value) {
            addCriterion("pd_remittance_bank >=", value, "pdRemittanceBank");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankLessThan(String value) {
            addCriterion("pd_remittance_bank <", value, "pdRemittanceBank");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankLessThanOrEqualTo(String value) {
            addCriterion("pd_remittance_bank <=", value, "pdRemittanceBank");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankLike(String value) {
            addCriterion("pd_remittance_bank like", value, "pdRemittanceBank");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankNotLike(String value) {
            addCriterion("pd_remittance_bank not like", value, "pdRemittanceBank");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankIn(List<String> values) {
            addCriterion("pd_remittance_bank in", values, "pdRemittanceBank");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankNotIn(List<String> values) {
            addCriterion("pd_remittance_bank not in", values, "pdRemittanceBank");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankBetween(String value1, String value2) {
            addCriterion("pd_remittance_bank between", value1, value2, "pdRemittanceBank");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceBankNotBetween(String value1, String value2) {
            addCriterion("pd_remittance_bank not between", value1, value2, "pdRemittanceBank");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceTimeIsNull() {
            addCriterion("pd_remittance_time is null");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceTimeIsNotNull() {
            addCriterion("pd_remittance_time is not null");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceTimeEqualTo(Date value) {
            addCriterionForJDBCDate("pd_remittance_time =", value, "pdRemittanceTime");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("pd_remittance_time <>", value, "pdRemittanceTime");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("pd_remittance_time >", value, "pdRemittanceTime");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pd_remittance_time >=", value, "pdRemittanceTime");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceTimeLessThan(Date value) {
            addCriterionForJDBCDate("pd_remittance_time <", value, "pdRemittanceTime");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("pd_remittance_time <=", value, "pdRemittanceTime");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceTimeIn(List<Date> values) {
            addCriterionForJDBCDate("pd_remittance_time in", values, "pdRemittanceTime");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("pd_remittance_time not in", values, "pdRemittanceTime");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pd_remittance_time between", value1, value2, "pdRemittanceTime");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("pd_remittance_time not between", value1, value2, "pdRemittanceTime");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserIsNull() {
            addCriterion("pd_remittance_user is null");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserIsNotNull() {
            addCriterion("pd_remittance_user is not null");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserEqualTo(String value) {
            addCriterion("pd_remittance_user =", value, "pdRemittanceUser");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserNotEqualTo(String value) {
            addCriterion("pd_remittance_user <>", value, "pdRemittanceUser");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserGreaterThan(String value) {
            addCriterion("pd_remittance_user >", value, "pdRemittanceUser");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserGreaterThanOrEqualTo(String value) {
            addCriterion("pd_remittance_user >=", value, "pdRemittanceUser");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserLessThan(String value) {
            addCriterion("pd_remittance_user <", value, "pdRemittanceUser");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserLessThanOrEqualTo(String value) {
            addCriterion("pd_remittance_user <=", value, "pdRemittanceUser");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserLike(String value) {
            addCriterion("pd_remittance_user like", value, "pdRemittanceUser");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserNotLike(String value) {
            addCriterion("pd_remittance_user not like", value, "pdRemittanceUser");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserIn(List<String> values) {
            addCriterion("pd_remittance_user in", values, "pdRemittanceUser");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserNotIn(List<String> values) {
            addCriterion("pd_remittance_user not in", values, "pdRemittanceUser");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserBetween(String value1, String value2) {
            addCriterion("pd_remittance_user between", value1, value2, "pdRemittanceUser");
            return (Criteria) this;
        }

        public Criteria andPdRemittanceUserNotBetween(String value1, String value2) {
            addCriterion("pd_remittance_user not between", value1, value2, "pdRemittanceUser");
            return (Criteria) this;
        }

        public Criteria andPdSnIsNull() {
            addCriterion("pd_sn is null");
            return (Criteria) this;
        }

        public Criteria andPdSnIsNotNull() {
            addCriterion("pd_sn is not null");
            return (Criteria) this;
        }

        public Criteria andPdSnEqualTo(String value) {
            addCriterion("pd_sn =", value, "pdSn");
            return (Criteria) this;
        }

        public Criteria andPdSnNotEqualTo(String value) {
            addCriterion("pd_sn <>", value, "pdSn");
            return (Criteria) this;
        }

        public Criteria andPdSnGreaterThan(String value) {
            addCriterion("pd_sn >", value, "pdSn");
            return (Criteria) this;
        }

        public Criteria andPdSnGreaterThanOrEqualTo(String value) {
            addCriterion("pd_sn >=", value, "pdSn");
            return (Criteria) this;
        }

        public Criteria andPdSnLessThan(String value) {
            addCriterion("pd_sn <", value, "pdSn");
            return (Criteria) this;
        }

        public Criteria andPdSnLessThanOrEqualTo(String value) {
            addCriterion("pd_sn <=", value, "pdSn");
            return (Criteria) this;
        }

        public Criteria andPdSnLike(String value) {
            addCriterion("pd_sn like", value, "pdSn");
            return (Criteria) this;
        }

        public Criteria andPdSnNotLike(String value) {
            addCriterion("pd_sn not like", value, "pdSn");
            return (Criteria) this;
        }

        public Criteria andPdSnIn(List<String> values) {
            addCriterion("pd_sn in", values, "pdSn");
            return (Criteria) this;
        }

        public Criteria andPdSnNotIn(List<String> values) {
            addCriterion("pd_sn not in", values, "pdSn");
            return (Criteria) this;
        }

        public Criteria andPdSnBetween(String value1, String value2) {
            addCriterion("pd_sn between", value1, value2, "pdSn");
            return (Criteria) this;
        }

        public Criteria andPdSnNotBetween(String value1, String value2) {
            addCriterion("pd_sn not between", value1, value2, "pdSn");
            return (Criteria) this;
        }

        public Criteria andPdStatusIsNull() {
            addCriterion("pd_status is null");
            return (Criteria) this;
        }

        public Criteria andPdStatusIsNotNull() {
            addCriterion("pd_status is not null");
            return (Criteria) this;
        }

        public Criteria andPdStatusEqualTo(Integer value) {
            addCriterion("pd_status =", value, "pdStatus");
            return (Criteria) this;
        }

        public Criteria andPdStatusNotEqualTo(Integer value) {
            addCriterion("pd_status <>", value, "pdStatus");
            return (Criteria) this;
        }

        public Criteria andPdStatusGreaterThan(Integer value) {
            addCriterion("pd_status >", value, "pdStatus");
            return (Criteria) this;
        }

        public Criteria andPdStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("pd_status >=", value, "pdStatus");
            return (Criteria) this;
        }

        public Criteria andPdStatusLessThan(Integer value) {
            addCriterion("pd_status <", value, "pdStatus");
            return (Criteria) this;
        }

        public Criteria andPdStatusLessThanOrEqualTo(Integer value) {
            addCriterion("pd_status <=", value, "pdStatus");
            return (Criteria) this;
        }

        public Criteria andPdStatusIn(List<Integer> values) {
            addCriterion("pd_status in", values, "pdStatus");
            return (Criteria) this;
        }

        public Criteria andPdStatusNotIn(List<Integer> values) {
            addCriterion("pd_status not in", values, "pdStatus");
            return (Criteria) this;
        }

        public Criteria andPdStatusBetween(Integer value1, Integer value2) {
            addCriterion("pd_status between", value1, value2, "pdStatus");
            return (Criteria) this;
        }

        public Criteria andPdStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("pd_status not between", value1, value2, "pdStatus");
            return (Criteria) this;
        }

        public Criteria andPdAdminIdIsNull() {
            addCriterion("pd_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andPdAdminIdIsNotNull() {
            addCriterion("pd_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andPdAdminIdEqualTo(Long value) {
            addCriterion("pd_admin_id =", value, "pdAdminId");
            return (Criteria) this;
        }

        public Criteria andPdAdminIdNotEqualTo(Long value) {
            addCriterion("pd_admin_id <>", value, "pdAdminId");
            return (Criteria) this;
        }

        public Criteria andPdAdminIdGreaterThan(Long value) {
            addCriterion("pd_admin_id >", value, "pdAdminId");
            return (Criteria) this;
        }

        public Criteria andPdAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pd_admin_id >=", value, "pdAdminId");
            return (Criteria) this;
        }

        public Criteria andPdAdminIdLessThan(Long value) {
            addCriterion("pd_admin_id <", value, "pdAdminId");
            return (Criteria) this;
        }

        public Criteria andPdAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("pd_admin_id <=", value, "pdAdminId");
            return (Criteria) this;
        }

        public Criteria andPdAdminIdIn(List<Long> values) {
            addCriterion("pd_admin_id in", values, "pdAdminId");
            return (Criteria) this;
        }

        public Criteria andPdAdminIdNotIn(List<Long> values) {
            addCriterion("pd_admin_id not in", values, "pdAdminId");
            return (Criteria) this;
        }

        public Criteria andPdAdminIdBetween(Long value1, Long value2) {
            addCriterion("pd_admin_id between", value1, value2, "pdAdminId");
            return (Criteria) this;
        }

        public Criteria andPdAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("pd_admin_id not between", value1, value2, "pdAdminId");
            return (Criteria) this;
        }

        public Criteria andPdUserIdIsNull() {
            addCriterion("pd_user_id is null");
            return (Criteria) this;
        }

        public Criteria andPdUserIdIsNotNull() {
            addCriterion("pd_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andPdUserIdEqualTo(Long value) {
            addCriterion("pd_user_id =", value, "pdUserId");
            return (Criteria) this;
        }

        public Criteria andPdUserIdNotEqualTo(Long value) {
            addCriterion("pd_user_id <>", value, "pdUserId");
            return (Criteria) this;
        }

        public Criteria andPdUserIdGreaterThan(Long value) {
            addCriterion("pd_user_id >", value, "pdUserId");
            return (Criteria) this;
        }

        public Criteria andPdUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pd_user_id >=", value, "pdUserId");
            return (Criteria) this;
        }

        public Criteria andPdUserIdLessThan(Long value) {
            addCriterion("pd_user_id <", value, "pdUserId");
            return (Criteria) this;
        }

        public Criteria andPdUserIdLessThanOrEqualTo(Long value) {
            addCriterion("pd_user_id <=", value, "pdUserId");
            return (Criteria) this;
        }

        public Criteria andPdUserIdIn(List<Long> values) {
            addCriterion("pd_user_id in", values, "pdUserId");
            return (Criteria) this;
        }

        public Criteria andPdUserIdNotIn(List<Long> values) {
            addCriterion("pd_user_id not in", values, "pdUserId");
            return (Criteria) this;
        }

        public Criteria andPdUserIdBetween(Long value1, Long value2) {
            addCriterion("pd_user_id between", value1, value2, "pdUserId");
            return (Criteria) this;
        }

        public Criteria andPdUserIdNotBetween(Long value1, Long value2) {
            addCriterion("pd_user_id not between", value1, value2, "pdUserId");
            return (Criteria) this;
        }
        
        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Long value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Long value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Long value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Long value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Long value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Long value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Long> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Long> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Long value1, Long value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Long value1, Long value2) {
            addCriterion("log_id not between", value1, value2, "logId");
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