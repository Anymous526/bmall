package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class PredepositCashExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PredepositCashExample() {
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

        public Criteria andCashAccountIsNull() {
            addCriterion("cash_account is null");
            return (Criteria) this;
        }

        public Criteria andCashAccountIsNotNull() {
            addCriterion("cash_account is not null");
            return (Criteria) this;
        }

        public Criteria andCashAccountEqualTo(String value) {
            addCriterion("cash_account =", value, "cashAccount");
            return (Criteria) this;
        }

        public Criteria andCashAccountNotEqualTo(String value) {
            addCriterion("cash_account <>", value, "cashAccount");
            return (Criteria) this;
        }

        public Criteria andCashAccountGreaterThan(String value) {
            addCriterion("cash_account >", value, "cashAccount");
            return (Criteria) this;
        }

        public Criteria andCashAccountGreaterThanOrEqualTo(String value) {
            addCriterion("cash_account >=", value, "cashAccount");
            return (Criteria) this;
        }

        public Criteria andCashAccountLessThan(String value) {
            addCriterion("cash_account <", value, "cashAccount");
            return (Criteria) this;
        }

        public Criteria andCashAccountLessThanOrEqualTo(String value) {
            addCriterion("cash_account <=", value, "cashAccount");
            return (Criteria) this;
        }

        public Criteria andCashAccountLike(String value) {
            addCriterion("cash_account like", value, "cashAccount");
            return (Criteria) this;
        }

        public Criteria andCashAccountNotLike(String value) {
            addCriterion("cash_account not like", value, "cashAccount");
            return (Criteria) this;
        }

        public Criteria andCashAccountIn(List<String> values) {
            addCriterion("cash_account in", values, "cashAccount");
            return (Criteria) this;
        }

        public Criteria andCashAccountNotIn(List<String> values) {
            addCriterion("cash_account not in", values, "cashAccount");
            return (Criteria) this;
        }

        public Criteria andCashAccountBetween(String value1, String value2) {
            addCriterion("cash_account between", value1, value2, "cashAccount");
            return (Criteria) this;
        }

        public Criteria andCashAccountNotBetween(String value1, String value2) {
            addCriterion("cash_account not between", value1, value2, "cashAccount");
            return (Criteria) this;
        }

        public Criteria andCashAmountIsNull() {
            addCriterion("cash_amount is null");
            return (Criteria) this;
        }

        public Criteria andCashAmountIsNotNull() {
            addCriterion("cash_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCashAmountEqualTo(BigDecimal value) {
            addCriterion("cash_amount =", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountNotEqualTo(BigDecimal value) {
            addCriterion("cash_amount <>", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountGreaterThan(BigDecimal value) {
            addCriterion("cash_amount >", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_amount >=", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountLessThan(BigDecimal value) {
            addCriterion("cash_amount <", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("cash_amount <=", value, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountIn(List<BigDecimal> values) {
            addCriterion("cash_amount in", values, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountNotIn(List<BigDecimal> values) {
            addCriterion("cash_amount not in", values, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_amount between", value1, value2, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("cash_amount not between", value1, value2, "cashAmount");
            return (Criteria) this;
        }

        public Criteria andCashBankIsNull() {
            addCriterion("cash_bank is null");
            return (Criteria) this;
        }

        public Criteria andCashBankIsNotNull() {
            addCriterion("cash_bank is not null");
            return (Criteria) this;
        }

        public Criteria andCashBankEqualTo(String value) {
            addCriterion("cash_bank =", value, "cashBank");
            return (Criteria) this;
        }

        public Criteria andCashBankNotEqualTo(String value) {
            addCriterion("cash_bank <>", value, "cashBank");
            return (Criteria) this;
        }

        public Criteria andCashBankGreaterThan(String value) {
            addCriterion("cash_bank >", value, "cashBank");
            return (Criteria) this;
        }

        public Criteria andCashBankGreaterThanOrEqualTo(String value) {
            addCriterion("cash_bank >=", value, "cashBank");
            return (Criteria) this;
        }

        public Criteria andCashBankLessThan(String value) {
            addCriterion("cash_bank <", value, "cashBank");
            return (Criteria) this;
        }

        public Criteria andCashBankLessThanOrEqualTo(String value) {
            addCriterion("cash_bank <=", value, "cashBank");
            return (Criteria) this;
        }

        public Criteria andCashBankLike(String value) {
            addCriterion("cash_bank like", value, "cashBank");
            return (Criteria) this;
        }

        public Criteria andCashBankNotLike(String value) {
            addCriterion("cash_bank not like", value, "cashBank");
            return (Criteria) this;
        }

        public Criteria andCashBankIn(List<String> values) {
            addCriterion("cash_bank in", values, "cashBank");
            return (Criteria) this;
        }

        public Criteria andCashBankNotIn(List<String> values) {
            addCriterion("cash_bank not in", values, "cashBank");
            return (Criteria) this;
        }

        public Criteria andCashBankBetween(String value1, String value2) {
            addCriterion("cash_bank between", value1, value2, "cashBank");
            return (Criteria) this;
        }

        public Criteria andCashBankNotBetween(String value1, String value2) {
            addCriterion("cash_bank not between", value1, value2, "cashBank");
            return (Criteria) this;
        }

        public Criteria andCashPayStatusIsNull() {
            addCriterion("cash_pay_status is null");
            return (Criteria) this;
        }

        public Criteria andCashPayStatusIsNotNull() {
            addCriterion("cash_pay_status is not null");
            return (Criteria) this;
        }

        public Criteria andCashPayStatusEqualTo(Integer value) {
            addCriterion("cash_pay_status =", value, "cashPayStatus");
            return (Criteria) this;
        }

        public Criteria andCashPayStatusNotEqualTo(Integer value) {
            addCriterion("cash_pay_status <>", value, "cashPayStatus");
            return (Criteria) this;
        }

        public Criteria andCashPayStatusGreaterThan(Integer value) {
            addCriterion("cash_pay_status >", value, "cashPayStatus");
            return (Criteria) this;
        }

        public Criteria andCashPayStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("cash_pay_status >=", value, "cashPayStatus");
            return (Criteria) this;
        }

        public Criteria andCashPayStatusLessThan(Integer value) {
            addCriterion("cash_pay_status <", value, "cashPayStatus");
            return (Criteria) this;
        }

        public Criteria andCashPayStatusLessThanOrEqualTo(Integer value) {
            addCriterion("cash_pay_status <=", value, "cashPayStatus");
            return (Criteria) this;
        }

        public Criteria andCashPayStatusIn(List<Integer> values) {
            addCriterion("cash_pay_status in", values, "cashPayStatus");
            return (Criteria) this;
        }

        public Criteria andCashPayStatusNotIn(List<Integer> values) {
            addCriterion("cash_pay_status not in", values, "cashPayStatus");
            return (Criteria) this;
        }

        public Criteria andCashPayStatusBetween(Integer value1, Integer value2) {
            addCriterion("cash_pay_status between", value1, value2, "cashPayStatus");
            return (Criteria) this;
        }

        public Criteria andCashPayStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("cash_pay_status not between", value1, value2, "cashPayStatus");
            return (Criteria) this;
        }

        public Criteria andCashPaymentIsNull() {
            addCriterion("cash_payment is null");
            return (Criteria) this;
        }

        public Criteria andCashPaymentIsNotNull() {
            addCriterion("cash_payment is not null");
            return (Criteria) this;
        }

        public Criteria andCashPaymentEqualTo(String value) {
            addCriterion("cash_payment =", value, "cashPayment");
            return (Criteria) this;
        }

        public Criteria andCashPaymentNotEqualTo(String value) {
            addCriterion("cash_payment <>", value, "cashPayment");
            return (Criteria) this;
        }

        public Criteria andCashPaymentGreaterThan(String value) {
            addCriterion("cash_payment >", value, "cashPayment");
            return (Criteria) this;
        }

        public Criteria andCashPaymentGreaterThanOrEqualTo(String value) {
            addCriterion("cash_payment >=", value, "cashPayment");
            return (Criteria) this;
        }

        public Criteria andCashPaymentLessThan(String value) {
            addCriterion("cash_payment <", value, "cashPayment");
            return (Criteria) this;
        }

        public Criteria andCashPaymentLessThanOrEqualTo(String value) {
            addCriterion("cash_payment <=", value, "cashPayment");
            return (Criteria) this;
        }

        public Criteria andCashPaymentLike(String value) {
            addCriterion("cash_payment like", value, "cashPayment");
            return (Criteria) this;
        }

        public Criteria andCashPaymentNotLike(String value) {
            addCriterion("cash_payment not like", value, "cashPayment");
            return (Criteria) this;
        }

        public Criteria andCashPaymentIn(List<String> values) {
            addCriterion("cash_payment in", values, "cashPayment");
            return (Criteria) this;
        }

        public Criteria andCashPaymentNotIn(List<String> values) {
            addCriterion("cash_payment not in", values, "cashPayment");
            return (Criteria) this;
        }

        public Criteria andCashPaymentBetween(String value1, String value2) {
            addCriterion("cash_payment between", value1, value2, "cashPayment");
            return (Criteria) this;
        }

        public Criteria andCashPaymentNotBetween(String value1, String value2) {
            addCriterion("cash_payment not between", value1, value2, "cashPayment");
            return (Criteria) this;
        }

        public Criteria andCashSnIsNull() {
            addCriterion("cash_sn is null");
            return (Criteria) this;
        }

        public Criteria andCashSnIsNotNull() {
            addCriterion("cash_sn is not null");
            return (Criteria) this;
        }

        public Criteria andCashSnEqualTo(String value) {
            addCriterion("cash_sn =", value, "cashSn");
            return (Criteria) this;
        }

        public Criteria andCashSnNotEqualTo(String value) {
            addCriterion("cash_sn <>", value, "cashSn");
            return (Criteria) this;
        }

        public Criteria andCashSnGreaterThan(String value) {
            addCriterion("cash_sn >", value, "cashSn");
            return (Criteria) this;
        }

        public Criteria andCashSnGreaterThanOrEqualTo(String value) {
            addCriterion("cash_sn >=", value, "cashSn");
            return (Criteria) this;
        }

        public Criteria andCashSnLessThan(String value) {
            addCriterion("cash_sn <", value, "cashSn");
            return (Criteria) this;
        }

        public Criteria andCashSnLessThanOrEqualTo(String value) {
            addCriterion("cash_sn <=", value, "cashSn");
            return (Criteria) this;
        }

        public Criteria andCashSnLike(String value) {
            addCriterion("cash_sn like", value, "cashSn");
            return (Criteria) this;
        }

        public Criteria andCashSnNotLike(String value) {
            addCriterion("cash_sn not like", value, "cashSn");
            return (Criteria) this;
        }

        public Criteria andCashSnIn(List<String> values) {
            addCriterion("cash_sn in", values, "cashSn");
            return (Criteria) this;
        }

        public Criteria andCashSnNotIn(List<String> values) {
            addCriterion("cash_sn not in", values, "cashSn");
            return (Criteria) this;
        }

        public Criteria andCashSnBetween(String value1, String value2) {
            addCriterion("cash_sn between", value1, value2, "cashSn");
            return (Criteria) this;
        }

        public Criteria andCashSnNotBetween(String value1, String value2) {
            addCriterion("cash_sn not between", value1, value2, "cashSn");
            return (Criteria) this;
        }

        public Criteria andCashStatusIsNull() {
            addCriterion("cash_status is null");
            return (Criteria) this;
        }

        public Criteria andCashStatusIsNotNull() {
            addCriterion("cash_status is not null");
            return (Criteria) this;
        }

        public Criteria andCashStatusEqualTo(Integer value) {
            addCriterion("cash_status =", value, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusNotEqualTo(Integer value) {
            addCriterion("cash_status <>", value, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusGreaterThan(Integer value) {
            addCriterion("cash_status >", value, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("cash_status >=", value, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusLessThan(Integer value) {
            addCriterion("cash_status <", value, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusLessThanOrEqualTo(Integer value) {
            addCriterion("cash_status <=", value, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusIn(List<Integer> values) {
            addCriterion("cash_status in", values, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusNotIn(List<Integer> values) {
            addCriterion("cash_status not in", values, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusBetween(Integer value1, Integer value2) {
            addCriterion("cash_status between", value1, value2, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("cash_status not between", value1, value2, "cashStatus");
            return (Criteria) this;
        }

        public Criteria andCashUsernameIsNull() {
            addCriterion("cash_userName is null");
            return (Criteria) this;
        }

        public Criteria andCashUsernameIsNotNull() {
            addCriterion("cash_userName is not null");
            return (Criteria) this;
        }

        public Criteria andCashUsernameEqualTo(String value) {
            addCriterion("cash_userName =", value, "cashUsername");
            return (Criteria) this;
        }

        public Criteria andCashUsernameNotEqualTo(String value) {
            addCriterion("cash_userName <>", value, "cashUsername");
            return (Criteria) this;
        }

        public Criteria andCashUsernameGreaterThan(String value) {
            addCriterion("cash_userName >", value, "cashUsername");
            return (Criteria) this;
        }

        public Criteria andCashUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("cash_userName >=", value, "cashUsername");
            return (Criteria) this;
        }

        public Criteria andCashUsernameLessThan(String value) {
            addCriterion("cash_userName <", value, "cashUsername");
            return (Criteria) this;
        }

        public Criteria andCashUsernameLessThanOrEqualTo(String value) {
            addCriterion("cash_userName <=", value, "cashUsername");
            return (Criteria) this;
        }

        public Criteria andCashUsernameLike(String value) {
            addCriterion("cash_userName like", value, "cashUsername");
            return (Criteria) this;
        }

        public Criteria andCashUsernameNotLike(String value) {
            addCriterion("cash_userName not like", value, "cashUsername");
            return (Criteria) this;
        }

        public Criteria andCashUsernameIn(List<String> values) {
            addCriterion("cash_userName in", values, "cashUsername");
            return (Criteria) this;
        }

        public Criteria andCashUsernameNotIn(List<String> values) {
            addCriterion("cash_userName not in", values, "cashUsername");
            return (Criteria) this;
        }

        public Criteria andCashUsernameBetween(String value1, String value2) {
            addCriterion("cash_userName between", value1, value2, "cashUsername");
            return (Criteria) this;
        }

        public Criteria andCashUsernameNotBetween(String value1, String value2) {
            addCriterion("cash_userName not between", value1, value2, "cashUsername");
            return (Criteria) this;
        }

        public Criteria andCashAdminIdIsNull() {
            addCriterion("cash_admin_id is null");
            return (Criteria) this;
        }

        public Criteria andCashAdminIdIsNotNull() {
            addCriterion("cash_admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andCashAdminIdEqualTo(Long value) {
            addCriterion("cash_admin_id =", value, "cashAdminId");
            return (Criteria) this;
        }

        public Criteria andCashAdminIdNotEqualTo(Long value) {
            addCriterion("cash_admin_id <>", value, "cashAdminId");
            return (Criteria) this;
        }

        public Criteria andCashAdminIdGreaterThan(Long value) {
            addCriterion("cash_admin_id >", value, "cashAdminId");
            return (Criteria) this;
        }

        public Criteria andCashAdminIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cash_admin_id >=", value, "cashAdminId");
            return (Criteria) this;
        }

        public Criteria andCashAdminIdLessThan(Long value) {
            addCriterion("cash_admin_id <", value, "cashAdminId");
            return (Criteria) this;
        }

        public Criteria andCashAdminIdLessThanOrEqualTo(Long value) {
            addCriterion("cash_admin_id <=", value, "cashAdminId");
            return (Criteria) this;
        }

        public Criteria andCashAdminIdIn(List<Long> values) {
            addCriterion("cash_admin_id in", values, "cashAdminId");
            return (Criteria) this;
        }

        public Criteria andCashAdminIdNotIn(List<Long> values) {
            addCriterion("cash_admin_id not in", values, "cashAdminId");
            return (Criteria) this;
        }

        public Criteria andCashAdminIdBetween(Long value1, Long value2) {
            addCriterion("cash_admin_id between", value1, value2, "cashAdminId");
            return (Criteria) this;
        }

        public Criteria andCashAdminIdNotBetween(Long value1, Long value2) {
            addCriterion("cash_admin_id not between", value1, value2, "cashAdminId");
            return (Criteria) this;
        }

        public Criteria andCashUserIdIsNull() {
            addCriterion("cash_user_id is null");
            return (Criteria) this;
        }

        public Criteria andCashUserIdIsNotNull() {
            addCriterion("cash_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andCashUserIdEqualTo(Long value) {
            addCriterion("cash_user_id =", value, "cashUserId");
            return (Criteria) this;
        }

        public Criteria andCashUserIdNotEqualTo(Long value) {
            addCriterion("cash_user_id <>", value, "cashUserId");
            return (Criteria) this;
        }

        public Criteria andCashUserIdGreaterThan(Long value) {
            addCriterion("cash_user_id >", value, "cashUserId");
            return (Criteria) this;
        }

        public Criteria andCashUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("cash_user_id >=", value, "cashUserId");
            return (Criteria) this;
        }

        public Criteria andCashUserIdLessThan(Long value) {
            addCriterion("cash_user_id <", value, "cashUserId");
            return (Criteria) this;
        }

        public Criteria andCashUserIdLessThanOrEqualTo(Long value) {
            addCriterion("cash_user_id <=", value, "cashUserId");
            return (Criteria) this;
        }

        public Criteria andCashUserIdIn(List<Long> values) {
            addCriterion("cash_user_id in", values, "cashUserId");
            return (Criteria) this;
        }

        public Criteria andCashUserIdNotIn(List<Long> values) {
            addCriterion("cash_user_id not in", values, "cashUserId");
            return (Criteria) this;
        }

        public Criteria andCashUserIdBetween(Long value1, Long value2) {
            addCriterion("cash_user_id between", value1, value2, "cashUserId");
            return (Criteria) this;
        }

        public Criteria andCashUserIdNotBetween(Long value1, Long value2) {
            addCriterion("cash_user_id not between", value1, value2, "cashUserId");
            return (Criteria) this;
        }
        
        public Criteria andCashBankCityIsNull() {
            addCriterion("cash_bank_city is null");
            return (Criteria) this;
        }

        public Criteria andCashBankCityIsNotNull() {
            addCriterion("cash_bank_city is not null");
            return (Criteria) this;
        }

        public Criteria andCashBankCityEqualTo(String value) {
            addCriterion("cash_bank_city =", value, "cashBankCity");
            return (Criteria) this;
        }

        public Criteria andCashBankCityNotEqualTo(String value) {
            addCriterion("cash_bank_city <>", value, "cashBankCity");
            return (Criteria) this;
        }

        public Criteria andCashBankCityGreaterThan(String value) {
            addCriterion("cash_bank_city >", value, "cashBankCity");
            return (Criteria) this;
        }

        public Criteria andCashBankCityGreaterThanOrEqualTo(String value) {
            addCriterion("cash_bank_city >=", value, "cashBankCity");
            return (Criteria) this;
        }

        public Criteria andCashBankCityLessThan(String value) {
            addCriterion("cash_bank_city <", value, "cashBankCity");
            return (Criteria) this;
        }

        public Criteria andCashBankCityLessThanOrEqualTo(String value) {
            addCriterion("cash_bank_city <=", value, "cashBankCity");
            return (Criteria) this;
        }

        public Criteria andCashBankCityLike(String value) {
            addCriterion("cash_bank_city like", value, "cashBankCity");
            return (Criteria) this;
        }

        public Criteria andCashBankCityNotLike(String value) {
            addCriterion("cash_bank_city not like", value, "cashBankCity");
            return (Criteria) this;
        }

        public Criteria andCashBankCityIn(List<String> values) {
            addCriterion("cash_bank_city in", values, "cashBankCity");
            return (Criteria) this;
        }

        public Criteria andCashBankCityNotIn(List<String> values) {
            addCriterion("cash_bank_city not in", values, "cashBankCity");
            return (Criteria) this;
        }

        public Criteria andCashBankCityBetween(String value1, String value2) {
            addCriterion("cash_bank_city between", value1, value2, "cashBankCity");
            return (Criteria) this;
        }

        public Criteria andCashBankCityNotBetween(String value1, String value2) {
            addCriterion("cash_bank_city not between", value1, value2, "cashBankCity");
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