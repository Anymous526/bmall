package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class StoreExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StoreExample() {
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

        public Criteria andPartnerIdIsNull() {
            addCriterion("partner_id is null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIsNotNull() {
            addCriterion("partner_id is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerIdEqualTo(Long value) {
            addCriterion("partner_id =", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotEqualTo(Long value) {
            addCriterion("partner_id <>", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThan(Long value) {
            addCriterion("partner_id >", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("partner_id >=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThan(Long value) {
            addCriterion("partner_id <", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdLessThanOrEqualTo(Long value) {
            addCriterion("partner_id <=", value, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdIn(List<Long> values) {
            addCriterion("partner_id in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotIn(List<Long> values) {
            addCriterion("partner_id not in", values, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdBetween(Long value1, Long value2) {
            addCriterion("partner_id between", value1, value2, "partnerId");
            return (Criteria) this;
        }

        public Criteria andPartnerIdNotBetween(Long value1, Long value2) {
            addCriterion("partner_id not between", value1, value2, "partnerId");
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

        public Criteria andCardApproveIsNull() {
            addCriterion("card_approve is null");
            return (Criteria) this;
        }

        public Criteria andCardApproveIsNotNull() {
            addCriterion("card_approve is not null");
            return (Criteria) this;
        }

        public Criteria andCardApproveEqualTo(Boolean value) {
            addCriterion("card_approve =", value, "cardApprove");
            return (Criteria) this;
        }

        public Criteria andCardApproveNotEqualTo(Boolean value) {
            addCriterion("card_approve <>", value, "cardApprove");
            return (Criteria) this;
        }

        public Criteria andCardApproveGreaterThan(Boolean value) {
            addCriterion("card_approve >", value, "cardApprove");
            return (Criteria) this;
        }

        public Criteria andCardApproveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("card_approve >=", value, "cardApprove");
            return (Criteria) this;
        }

        public Criteria andCardApproveLessThan(Boolean value) {
            addCriterion("card_approve <", value, "cardApprove");
            return (Criteria) this;
        }

        public Criteria andCardApproveLessThanOrEqualTo(Boolean value) {
            addCriterion("card_approve <=", value, "cardApprove");
            return (Criteria) this;
        }

        public Criteria andCardApproveIn(List<Boolean> values) {
            addCriterion("card_approve in", values, "cardApprove");
            return (Criteria) this;
        }

        public Criteria andCardApproveNotIn(List<Boolean> values) {
            addCriterion("card_approve not in", values, "cardApprove");
            return (Criteria) this;
        }

        public Criteria andCardApproveBetween(Boolean value1, Boolean value2) {
            addCriterion("card_approve between", value1, value2, "cardApprove");
            return (Criteria) this;
        }

        public Criteria andCardApproveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("card_approve not between", value1, value2, "cardApprove");
            return (Criteria) this;
        }

        public Criteria andRealstoreApproveIsNull() {
            addCriterion("realstore_approve is null");
            return (Criteria) this;
        }

        public Criteria andRealstoreApproveIsNotNull() {
            addCriterion("realstore_approve is not null");
            return (Criteria) this;
        }

        public Criteria andRealstoreApproveEqualTo(Boolean value) {
            addCriterion("realstore_approve =", value, "realstoreApprove");
            return (Criteria) this;
        }

        public Criteria andRealstoreApproveNotEqualTo(Boolean value) {
            addCriterion("realstore_approve <>", value, "realstoreApprove");
            return (Criteria) this;
        }

        public Criteria andRealstoreApproveGreaterThan(Boolean value) {
            addCriterion("realstore_approve >", value, "realstoreApprove");
            return (Criteria) this;
        }

        public Criteria andRealstoreApproveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("realstore_approve >=", value, "realstoreApprove");
            return (Criteria) this;
        }

        public Criteria andRealstoreApproveLessThan(Boolean value) {
            addCriterion("realstore_approve <", value, "realstoreApprove");
            return (Criteria) this;
        }

        public Criteria andRealstoreApproveLessThanOrEqualTo(Boolean value) {
            addCriterion("realstore_approve <=", value, "realstoreApprove");
            return (Criteria) this;
        }

        public Criteria andRealstoreApproveIn(List<Boolean> values) {
            addCriterion("realstore_approve in", values, "realstoreApprove");
            return (Criteria) this;
        }

        public Criteria andRealstoreApproveNotIn(List<Boolean> values) {
            addCriterion("realstore_approve not in", values, "realstoreApprove");
            return (Criteria) this;
        }

        public Criteria andRealstoreApproveBetween(Boolean value1, Boolean value2) {
            addCriterion("realstore_approve between", value1, value2, "realstoreApprove");
            return (Criteria) this;
        }

        public Criteria andRealstoreApproveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("realstore_approve not between", value1, value2, "realstoreApprove");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNull() {
            addCriterion("store_address is null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIsNotNull() {
            addCriterion("store_address is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAddressEqualTo(String value) {
            addCriterion("store_address =", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotEqualTo(String value) {
            addCriterion("store_address <>", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThan(String value) {
            addCriterion("store_address >", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressGreaterThanOrEqualTo(String value) {
            addCriterion("store_address >=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThan(String value) {
            addCriterion("store_address <", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLessThanOrEqualTo(String value) {
            addCriterion("store_address <=", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressLike(String value) {
            addCriterion("store_address like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotLike(String value) {
            addCriterion("store_address not like", value, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressIn(List<String> values) {
            addCriterion("store_address in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotIn(List<String> values) {
            addCriterion("store_address not in", values, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressBetween(String value1, String value2) {
            addCriterion("store_address between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreAddressNotBetween(String value1, String value2) {
            addCriterion("store_address not between", value1, value2, "storeAddress");
            return (Criteria) this;
        }

        public Criteria andStoreCreditIsNull() {
            addCriterion("store_credit is null");
            return (Criteria) this;
        }

        public Criteria andStoreCreditIsNotNull() {
            addCriterion("store_credit is not null");
            return (Criteria) this;
        }

        public Criteria andStoreCreditEqualTo(Integer value) {
            addCriterion("store_credit =", value, "storeCredit");
            return (Criteria) this;
        }

        public Criteria andStoreCreditNotEqualTo(Integer value) {
            addCriterion("store_credit <>", value, "storeCredit");
            return (Criteria) this;
        }

        public Criteria andStoreCreditGreaterThan(Integer value) {
            addCriterion("store_credit >", value, "storeCredit");
            return (Criteria) this;
        }

        public Criteria andStoreCreditGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_credit >=", value, "storeCredit");
            return (Criteria) this;
        }

        public Criteria andStoreCreditLessThan(Integer value) {
            addCriterion("store_credit <", value, "storeCredit");
            return (Criteria) this;
        }

        public Criteria andStoreCreditLessThanOrEqualTo(Integer value) {
            addCriterion("store_credit <=", value, "storeCredit");
            return (Criteria) this;
        }

        public Criteria andStoreCreditIn(List<Integer> values) {
            addCriterion("store_credit in", values, "storeCredit");
            return (Criteria) this;
        }

        public Criteria andStoreCreditNotIn(List<Integer> values) {
            addCriterion("store_credit not in", values, "storeCredit");
            return (Criteria) this;
        }

        public Criteria andStoreCreditBetween(Integer value1, Integer value2) {
            addCriterion("store_credit between", value1, value2, "storeCredit");
            return (Criteria) this;
        }

        public Criteria andStoreCreditNotBetween(Integer value1, Integer value2) {
            addCriterion("store_credit not between", value1, value2, "storeCredit");
            return (Criteria) this;
        }

        public Criteria andStoreMsnIsNull() {
            addCriterion("store_msn is null");
            return (Criteria) this;
        }

        public Criteria andStoreMsnIsNotNull() {
            addCriterion("store_msn is not null");
            return (Criteria) this;
        }

        public Criteria andStoreMsnEqualTo(String value) {
            addCriterion("store_msn =", value, "storeMsn");
            return (Criteria) this;
        }

        public Criteria andStoreMsnNotEqualTo(String value) {
            addCriterion("store_msn <>", value, "storeMsn");
            return (Criteria) this;
        }

        public Criteria andStoreMsnGreaterThan(String value) {
            addCriterion("store_msn >", value, "storeMsn");
            return (Criteria) this;
        }

        public Criteria andStoreMsnGreaterThanOrEqualTo(String value) {
            addCriterion("store_msn >=", value, "storeMsn");
            return (Criteria) this;
        }

        public Criteria andStoreMsnLessThan(String value) {
            addCriterion("store_msn <", value, "storeMsn");
            return (Criteria) this;
        }

        public Criteria andStoreMsnLessThanOrEqualTo(String value) {
            addCriterion("store_msn <=", value, "storeMsn");
            return (Criteria) this;
        }

        public Criteria andStoreMsnLike(String value) {
            addCriterion("store_msn like", value, "storeMsn");
            return (Criteria) this;
        }

        public Criteria andStoreMsnNotLike(String value) {
            addCriterion("store_msn not like", value, "storeMsn");
            return (Criteria) this;
        }

        public Criteria andStoreMsnIn(List<String> values) {
            addCriterion("store_msn in", values, "storeMsn");
            return (Criteria) this;
        }

        public Criteria andStoreMsnNotIn(List<String> values) {
            addCriterion("store_msn not in", values, "storeMsn");
            return (Criteria) this;
        }

        public Criteria andStoreMsnBetween(String value1, String value2) {
            addCriterion("store_msn between", value1, value2, "storeMsn");
            return (Criteria) this;
        }

        public Criteria andStoreMsnNotBetween(String value1, String value2) {
            addCriterion("store_msn not between", value1, value2, "storeMsn");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNull() {
            addCriterion("store_name is null");
            return (Criteria) this;
        }

        public Criteria andStoreNameIsNotNull() {
            addCriterion("store_name is not null");
            return (Criteria) this;
        }

        public Criteria andStoreNameEqualTo(String value) {
            addCriterion("store_name =", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotEqualTo(String value) {
            addCriterion("store_name <>", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThan(String value) {
            addCriterion("store_name >", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("store_name >=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThan(String value) {
            addCriterion("store_name <", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLessThanOrEqualTo(String value) {
            addCriterion("store_name <=", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameLike(String value) {
            addCriterion("store_name like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotLike(String value) {
            addCriterion("store_name not like", value, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameIn(List<String> values) {
            addCriterion("store_name in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotIn(List<String> values) {
            addCriterion("store_name not in", values, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameBetween(String value1, String value2) {
            addCriterion("store_name between", value1, value2, "storeName");
            return (Criteria) this;
        }

        public Criteria andStoreNameNotBetween(String value1, String value2) {
            addCriterion("store_name not between", value1, value2, "storeName");
            return (Criteria) this;
        }
        
        
        
        
        
        
        
        
        public Criteria andCompanyNameIsNull() {
        	addCriterion("companyName is null");
        	return (Criteria) this;
        }
        
        public Criteria andCompanyNameIsNotNull() {
        	addCriterion("companyName is not null");
        	return (Criteria) this;
        }
        
        public Criteria andCompanyNameEqualTo(String value) {
        	addCriterion("companyName =", value, "companyName");
        	return (Criteria) this;
        }
        
        public Criteria andCompanyNameNotEqualTo(String value) {
        	addCriterion("companyName <>", value, "companyName");
        	return (Criteria) this;
        }
        
        public Criteria andCompanyNameGreaterThan(String value) {
        	addCriterion("companyName >", value, "companyName");
        	return (Criteria) this;
        }
        
        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
        	addCriterion("companyName >=", value, "companyName");
        	return (Criteria) this;
        }
        
        public Criteria andCompanyNameLessThan(String value) {
        	addCriterion("companyName <", value, "companyName");
        	return (Criteria) this;
        }
        
        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
        	addCriterion("companyName <=", value, "companyName");
        	return (Criteria) this;
        }
        
        public Criteria andCompanyNameLike(String value) {
        	addCriterion("companyName like", value, "companyName");
        	return (Criteria) this;
        }
        
        public Criteria andCompanyNameNotLike(String value) {
        	addCriterion("companyName not like", value, "companyName");
        	return (Criteria) this;
        }
        
        public Criteria andCompanyNameIn(List<String> values) {
        	addCriterion("companyName in", values, "companyName");
        	return (Criteria) this;
        }
        
        public Criteria andCompanyNameNotIn(List<String> values) {
        	addCriterion("companyName not in", values, "companyName");
        	return (Criteria) this;
        }
        
        public Criteria andCompanyNameBetween(String value1, String value2) {
        	addCriterion("companyName between", value1, value2, "companyName");
        	return (Criteria) this;
        }
        
        public Criteria andCompanyNameNotBetween(String value1, String value2) {
        	addCriterion("companyName not between", value1, value2, "companyName");
        	return (Criteria) this;
        }

        
        
        
        
        
        public Criteria andStoreOwerIsNull() {
            addCriterion("store_ower is null");
            return (Criteria) this;
        }

        public Criteria andStoreOwerIsNotNull() {
            addCriterion("store_ower is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOwerEqualTo(String value) {
            addCriterion("store_ower =", value, "storeOwer");
            return (Criteria) this;
        }

        public Criteria andStoreOwerNotEqualTo(String value) {
            addCriterion("store_ower <>", value, "storeOwer");
            return (Criteria) this;
        }

        public Criteria andStoreOwerGreaterThan(String value) {
            addCriterion("store_ower >", value, "storeOwer");
            return (Criteria) this;
        }

        public Criteria andStoreOwerGreaterThanOrEqualTo(String value) {
            addCriterion("store_ower >=", value, "storeOwer");
            return (Criteria) this;
        }

        public Criteria andStoreOwerLessThan(String value) {
            addCriterion("store_ower <", value, "storeOwer");
            return (Criteria) this;
        }

        public Criteria andStoreOwerLessThanOrEqualTo(String value) {
            addCriterion("store_ower <=", value, "storeOwer");
            return (Criteria) this;
        }

        public Criteria andStoreOwerLike(String value) {
            addCriterion("store_ower like", value, "storeOwer");
            return (Criteria) this;
        }

        public Criteria andStoreOwerNotLike(String value) {
            addCriterion("store_ower not like", value, "storeOwer");
            return (Criteria) this;
        }

        public Criteria andStoreOwerIn(List<String> values) {
            addCriterion("store_ower in", values, "storeOwer");
            return (Criteria) this;
        }

        public Criteria andStoreOwerNotIn(List<String> values) {
            addCriterion("store_ower not in", values, "storeOwer");
            return (Criteria) this;
        }

        public Criteria andStoreOwerBetween(String value1, String value2) {
            addCriterion("store_ower between", value1, value2, "storeOwer");
            return (Criteria) this;
        }

        public Criteria andStoreOwerNotBetween(String value1, String value2) {
            addCriterion("store_ower not between", value1, value2, "storeOwer");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardIsNull() {
            addCriterion("store_ower_card is null");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardIsNotNull() {
            addCriterion("store_ower_card is not null");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardEqualTo(String value) {
            addCriterion("store_ower_card =", value, "storeOwerCard");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardNotEqualTo(String value) {
            addCriterion("store_ower_card <>", value, "storeOwerCard");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardGreaterThan(String value) {
            addCriterion("store_ower_card >", value, "storeOwerCard");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardGreaterThanOrEqualTo(String value) {
            addCriterion("store_ower_card >=", value, "storeOwerCard");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardLessThan(String value) {
            addCriterion("store_ower_card <", value, "storeOwerCard");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardLessThanOrEqualTo(String value) {
            addCriterion("store_ower_card <=", value, "storeOwerCard");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardLike(String value) {
            addCriterion("store_ower_card like", value, "storeOwerCard");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardNotLike(String value) {
            addCriterion("store_ower_card not like", value, "storeOwerCard");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardIn(List<String> values) {
            addCriterion("store_ower_card in", values, "storeOwerCard");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardNotIn(List<String> values) {
            addCriterion("store_ower_card not in", values, "storeOwerCard");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardBetween(String value1, String value2) {
            addCriterion("store_ower_card between", value1, value2, "storeOwerCard");
            return (Criteria) this;
        }

        public Criteria andStoreOwerCardNotBetween(String value1, String value2) {
            addCriterion("store_ower_card not between", value1, value2, "storeOwerCard");
            return (Criteria) this;
        }

        public Criteria andStoreQqIsNull() {
            addCriterion("store_qq is null");
            return (Criteria) this;
        }

        public Criteria andStoreQqIsNotNull() {
            addCriterion("store_qq is not null");
            return (Criteria) this;
        }

        public Criteria andStoreQqEqualTo(String value) {
            addCriterion("store_qq =", value, "storeQq");
            return (Criteria) this;
        }

        public Criteria andStoreQqNotEqualTo(String value) {
            addCriterion("store_qq <>", value, "storeQq");
            return (Criteria) this;
        }

        public Criteria andStoreQqGreaterThan(String value) {
            addCriterion("store_qq >", value, "storeQq");
            return (Criteria) this;
        }

        public Criteria andStoreQqGreaterThanOrEqualTo(String value) {
            addCriterion("store_qq >=", value, "storeQq");
            return (Criteria) this;
        }

        public Criteria andStoreQqLessThan(String value) {
            addCriterion("store_qq <", value, "storeQq");
            return (Criteria) this;
        }

        public Criteria andStoreQqLessThanOrEqualTo(String value) {
            addCriterion("store_qq <=", value, "storeQq");
            return (Criteria) this;
        }

        public Criteria andStoreQqLike(String value) {
            addCriterion("store_qq like", value, "storeQq");
            return (Criteria) this;
        }

        public Criteria andStoreQqNotLike(String value) {
            addCriterion("store_qq not like", value, "storeQq");
            return (Criteria) this;
        }

        public Criteria andStoreQqIn(List<String> values) {
            addCriterion("store_qq in", values, "storeQq");
            return (Criteria) this;
        }

        public Criteria andStoreQqNotIn(List<String> values) {
            addCriterion("store_qq not in", values, "storeQq");
            return (Criteria) this;
        }

        public Criteria andStoreQqBetween(String value1, String value2) {
            addCriterion("store_qq between", value1, value2, "storeQq");
            return (Criteria) this;
        }

        public Criteria andStoreQqNotBetween(String value1, String value2) {
            addCriterion("store_qq not between", value1, value2, "storeQq");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendIsNull() {
            addCriterion("store_recommend is null");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendIsNotNull() {
            addCriterion("store_recommend is not null");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendEqualTo(Boolean value) {
            addCriterion("store_recommend =", value, "storeRecommend");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendNotEqualTo(Boolean value) {
            addCriterion("store_recommend <>", value, "storeRecommend");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendGreaterThan(Boolean value) {
            addCriterion("store_recommend >", value, "storeRecommend");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendGreaterThanOrEqualTo(Boolean value) {
            addCriterion("store_recommend >=", value, "storeRecommend");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendLessThan(Boolean value) {
            addCriterion("store_recommend <", value, "storeRecommend");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendLessThanOrEqualTo(Boolean value) {
            addCriterion("store_recommend <=", value, "storeRecommend");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendIn(List<Boolean> values) {
            addCriterion("store_recommend in", values, "storeRecommend");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendNotIn(List<Boolean> values) {
            addCriterion("store_recommend not in", values, "storeRecommend");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendBetween(Boolean value1, Boolean value2) {
            addCriterion("store_recommend between", value1, value2, "storeRecommend");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendNotBetween(Boolean value1, Boolean value2) {
            addCriterion("store_recommend not between", value1, value2, "storeRecommend");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendTimeIsNull() {
            addCriterion("store_recommend_time is null");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendTimeIsNotNull() {
            addCriterion("store_recommend_time is not null");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendTimeEqualTo(Date value) {
            addCriterion("store_recommend_time =", value, "storeRecommendTime");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendTimeNotEqualTo(Date value) {
            addCriterion("store_recommend_time <>", value, "storeRecommendTime");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendTimeGreaterThan(Date value) {
            addCriterion("store_recommend_time >", value, "storeRecommendTime");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("store_recommend_time >=", value, "storeRecommendTime");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendTimeLessThan(Date value) {
            addCriterion("store_recommend_time <", value, "storeRecommendTime");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendTimeLessThanOrEqualTo(Date value) {
            addCriterion("store_recommend_time <=", value, "storeRecommendTime");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendTimeIn(List<Date> values) {
            addCriterion("store_recommend_time in", values, "storeRecommendTime");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendTimeNotIn(List<Date> values) {
            addCriterion("store_recommend_time not in", values, "storeRecommendTime");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendTimeBetween(Date value1, Date value2) {
            addCriterion("store_recommend_time between", value1, value2, "storeRecommendTime");
            return (Criteria) this;
        }

        public Criteria andStoreRecommendTimeNotBetween(Date value1, Date value2) {
            addCriterion("store_recommend_time not between", value1, value2, "storeRecommendTime");
            return (Criteria) this;
        }

        public Criteria andStoreStatusIsNull() {
            addCriterion("store_status is null");
            return (Criteria) this;
        }

        public Criteria andStoreStatusIsNotNull() {
            addCriterion("store_status is not null");
            return (Criteria) this;
        }

        public Criteria andStoreStatusEqualTo(Integer value) {
            addCriterion("store_status =", value, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusNotEqualTo(Integer value) {
            addCriterion("store_status <>", value, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusGreaterThan(Integer value) {
            addCriterion("store_status >", value, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("store_status >=", value, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusLessThan(Integer value) {
            addCriterion("store_status <", value, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusLessThanOrEqualTo(Integer value) {
            addCriterion("store_status <=", value, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusIn(List<Integer> values) {
            addCriterion("store_status in", values, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusNotIn(List<Integer> values) {
            addCriterion("store_status not in", values, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusBetween(Integer value1, Integer value2) {
            addCriterion("store_status between", value1, value2, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("store_status not between", value1, value2, "storeStatus");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneIsNull() {
            addCriterion("store_telephone is null");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneIsNotNull() {
            addCriterion("store_telephone is not null");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneEqualTo(String value) {
            addCriterion("store_telephone =", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneNotEqualTo(String value) {
            addCriterion("store_telephone <>", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneGreaterThan(String value) {
            addCriterion("store_telephone >", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("store_telephone >=", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneLessThan(String value) {
            addCriterion("store_telephone <", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneLessThanOrEqualTo(String value) {
            addCriterion("store_telephone <=", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneLike(String value) {
            addCriterion("store_telephone like", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneNotLike(String value) {
            addCriterion("store_telephone not like", value, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneIn(List<String> values) {
            addCriterion("store_telephone in", values, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneNotIn(List<String> values) {
            addCriterion("store_telephone not in", values, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneBetween(String value1, String value2) {
            addCriterion("store_telephone between", value1, value2, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreTelephoneNotBetween(String value1, String value2) {
            addCriterion("store_telephone not between", value1, value2, "storeTelephone");
            return (Criteria) this;
        }

        public Criteria andStoreZipIsNull() {
            addCriterion("store_zip is null");
            return (Criteria) this;
        }

        public Criteria andStoreZipIsNotNull() {
            addCriterion("store_zip is not null");
            return (Criteria) this;
        }

        public Criteria andStoreZipEqualTo(String value) {
            addCriterion("store_zip =", value, "storeZip");
            return (Criteria) this;
        }

        public Criteria andStoreZipNotEqualTo(String value) {
            addCriterion("store_zip <>", value, "storeZip");
            return (Criteria) this;
        }

        public Criteria andStoreZipGreaterThan(String value) {
            addCriterion("store_zip >", value, "storeZip");
            return (Criteria) this;
        }

        public Criteria andStoreZipGreaterThanOrEqualTo(String value) {
            addCriterion("store_zip >=", value, "storeZip");
            return (Criteria) this;
        }

        public Criteria andStoreZipLessThan(String value) {
            addCriterion("store_zip <", value, "storeZip");
            return (Criteria) this;
        }

        public Criteria andStoreZipLessThanOrEqualTo(String value) {
            addCriterion("store_zip <=", value, "storeZip");
            return (Criteria) this;
        }

        public Criteria andStoreZipLike(String value) {
            addCriterion("store_zip like", value, "storeZip");
            return (Criteria) this;
        }

        public Criteria andStoreZipNotLike(String value) {
            addCriterion("store_zip not like", value, "storeZip");
            return (Criteria) this;
        }

        public Criteria andStoreZipIn(List<String> values) {
            addCriterion("store_zip in", values, "storeZip");
            return (Criteria) this;
        }

        public Criteria andStoreZipNotIn(List<String> values) {
            addCriterion("store_zip not in", values, "storeZip");
            return (Criteria) this;
        }

        public Criteria andStoreZipBetween(String value1, String value2) {
            addCriterion("store_zip between", value1, value2, "storeZip");
            return (Criteria) this;
        }

        public Criteria andStoreZipNotBetween(String value1, String value2) {
            addCriterion("store_zip not between", value1, value2, "storeZip");
            return (Criteria) this;
        }

        public Criteria andTemplateIsNull() {
            addCriterion("template is null");
            return (Criteria) this;
        }

        public Criteria andTemplateIsNotNull() {
            addCriterion("template is not null");
            return (Criteria) this;
        }

        public Criteria andTemplateEqualTo(String value) {
            addCriterion("template =", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateNotEqualTo(String value) {
            addCriterion("template <>", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateGreaterThan(String value) {
            addCriterion("template >", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateGreaterThanOrEqualTo(String value) {
            addCriterion("template >=", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateLessThan(String value) {
            addCriterion("template <", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateLessThanOrEqualTo(String value) {
            addCriterion("template <=", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateLike(String value) {
            addCriterion("template like", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateNotLike(String value) {
            addCriterion("template not like", value, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateIn(List<String> values) {
            addCriterion("template in", values, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateNotIn(List<String> values) {
            addCriterion("template not in", values, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateBetween(String value1, String value2) {
            addCriterion("template between", value1, value2, "template");
            return (Criteria) this;
        }

        public Criteria andTemplateNotBetween(String value1, String value2) {
            addCriterion("template not between", value1, value2, "template");
            return (Criteria) this;
        }

        public Criteria andValidityIsNull() {
            addCriterion("validity is null");
            return (Criteria) this;
        }

        public Criteria andValidityIsNotNull() {
            addCriterion("validity is not null");
            return (Criteria) this;
        }

        public Criteria andValidityEqualTo(Date value) {
            addCriterion("validity =", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityNotEqualTo(Date value) {
            addCriterion("validity <>", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityGreaterThan(Date value) {
            addCriterion("validity >", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityGreaterThanOrEqualTo(Date value) {
            addCriterion("validity >=", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityLessThan(Date value) {
            addCriterion("validity <", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityLessThanOrEqualTo(Date value) {
            addCriterion("validity <=", value, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityIn(List<Date> values) {
            addCriterion("validity in", values, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityNotIn(List<Date> values) {
            addCriterion("validity not in", values, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityBetween(Date value1, Date value2) {
            addCriterion("validity between", value1, value2, "validity");
            return (Criteria) this;
        }

        public Criteria andValidityNotBetween(Date value1, Date value2) {
            addCriterion("validity not between", value1, value2, "validity");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Long value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Long value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Long value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Long value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Long value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Long> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Long> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Long value1, Long value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Long value1, Long value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNull() {
            addCriterion("card_id is null");
            return (Criteria) this;
        }

        public Criteria andCardIdIsNotNull() {
            addCriterion("card_id is not null");
            return (Criteria) this;
        }

        public Criteria andCardIdEqualTo(Long value) {
            addCriterion("card_id =", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotEqualTo(Long value) {
            addCriterion("card_id <>", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThan(Long value) {
            addCriterion("card_id >", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdGreaterThanOrEqualTo(Long value) {
            addCriterion("card_id >=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThan(Long value) {
            addCriterion("card_id <", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdLessThanOrEqualTo(Long value) {
            addCriterion("card_id <=", value, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdIn(List<Long> values) {
            addCriterion("card_id in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotIn(List<Long> values) {
            addCriterion("card_id not in", values, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdBetween(Long value1, Long value2) {
            addCriterion("card_id between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andCardIdNotBetween(Long value1, Long value2) {
            addCriterion("card_id not between", value1, value2, "cardId");
            return (Criteria) this;
        }

        public Criteria andGradeIdIsNull() {
            addCriterion("grade_id is null");
            return (Criteria) this;
        }

        public Criteria andGradeIdIsNotNull() {
            addCriterion("grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andGradeIdEqualTo(Long value) {
            addCriterion("grade_id =", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotEqualTo(Long value) {
            addCriterion("grade_id <>", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThan(Long value) {
            addCriterion("grade_id >", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("grade_id >=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThan(Long value) {
            addCriterion("grade_id <", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdLessThanOrEqualTo(Long value) {
            addCriterion("grade_id <=", value, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdIn(List<Long> values) {
            addCriterion("grade_id in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotIn(List<Long> values) {
            addCriterion("grade_id not in", values, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdBetween(Long value1, Long value2) {
            addCriterion("grade_id between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andGradeIdNotBetween(Long value1, Long value2) {
            addCriterion("grade_id not between", value1, value2, "gradeId");
            return (Criteria) this;
        }

        public Criteria andScIdIsNull() {
            addCriterion("sc_id is null");
            return (Criteria) this;
        }

        public Criteria andScIdIsNotNull() {
            addCriterion("sc_id is not null");
            return (Criteria) this;
        }

        public Criteria andScIdEqualTo(Long value) {
            addCriterion("sc_id =", value, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdNotEqualTo(Long value) {
            addCriterion("sc_id <>", value, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdGreaterThan(Long value) {
            addCriterion("sc_id >", value, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdGreaterThanOrEqualTo(Long value) {
            addCriterion("sc_id >=", value, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdLessThan(Long value) {
            addCriterion("sc_id <", value, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdLessThanOrEqualTo(Long value) {
            addCriterion("sc_id <=", value, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdIn(List<Long> values) {
            addCriterion("sc_id in", values, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdNotIn(List<Long> values) {
            addCriterion("sc_id not in", values, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdBetween(Long value1, Long value2) {
            addCriterion("sc_id between", value1, value2, "scId");
            return (Criteria) this;
        }

        public Criteria andScIdNotBetween(Long value1, Long value2) {
            addCriterion("sc_id not between", value1, value2, "scId");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIdIsNull() {
            addCriterion("store_banner_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIdIsNotNull() {
            addCriterion("store_banner_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIdEqualTo(Long value) {
            addCriterion("store_banner_id =", value, "storeBannerId");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIdNotEqualTo(Long value) {
            addCriterion("store_banner_id <>", value, "storeBannerId");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIdGreaterThan(Long value) {
            addCriterion("store_banner_id >", value, "storeBannerId");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("store_banner_id >=", value, "storeBannerId");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIdLessThan(Long value) {
            addCriterion("store_banner_id <", value, "storeBannerId");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIdLessThanOrEqualTo(Long value) {
            addCriterion("store_banner_id <=", value, "storeBannerId");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIdIn(List<Long> values) {
            addCriterion("store_banner_id in", values, "storeBannerId");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIdNotIn(List<Long> values) {
            addCriterion("store_banner_id not in", values, "storeBannerId");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIdBetween(Long value1, Long value2) {
            addCriterion("store_banner_id between", value1, value2, "storeBannerId");
            return (Criteria) this;
        }

        public Criteria andStoreBannerIdNotBetween(Long value1, Long value2) {
            addCriterion("store_banner_id not between", value1, value2, "storeBannerId");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIdIsNull() {
            addCriterion("store_license_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIdIsNotNull() {
            addCriterion("store_license_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIdEqualTo(Long value) {
            addCriterion("store_license_id =", value, "storeLicenseId");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIdNotEqualTo(Long value) {
            addCriterion("store_license_id <>", value, "storeLicenseId");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIdGreaterThan(Long value) {
            addCriterion("store_license_id >", value, "storeLicenseId");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIdGreaterThanOrEqualTo(Long value) {
            addCriterion("store_license_id >=", value, "storeLicenseId");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIdLessThan(Long value) {
            addCriterion("store_license_id <", value, "storeLicenseId");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIdLessThanOrEqualTo(Long value) {
            addCriterion("store_license_id <=", value, "storeLicenseId");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIdIn(List<Long> values) {
            addCriterion("store_license_id in", values, "storeLicenseId");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIdNotIn(List<Long> values) {
            addCriterion("store_license_id not in", values, "storeLicenseId");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIdBetween(Long value1, Long value2) {
            addCriterion("store_license_id between", value1, value2, "storeLicenseId");
            return (Criteria) this;
        }

        public Criteria andStoreLicenseIdNotBetween(Long value1, Long value2) {
            addCriterion("store_license_id not between", value1, value2, "storeLicenseId");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIdIsNull() {
            addCriterion("store_logo_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIdIsNotNull() {
            addCriterion("store_logo_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIdEqualTo(Long value) {
            addCriterion("store_logo_id =", value, "storeLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIdNotEqualTo(Long value) {
            addCriterion("store_logo_id <>", value, "storeLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIdGreaterThan(Long value) {
            addCriterion("store_logo_id >", value, "storeLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("store_logo_id >=", value, "storeLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIdLessThan(Long value) {
            addCriterion("store_logo_id <", value, "storeLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIdLessThanOrEqualTo(Long value) {
            addCriterion("store_logo_id <=", value, "storeLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIdIn(List<Long> values) {
            addCriterion("store_logo_id in", values, "storeLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIdNotIn(List<Long> values) {
            addCriterion("store_logo_id not in", values, "storeLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIdBetween(Long value1, Long value2) {
            addCriterion("store_logo_id between", value1, value2, "storeLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreLogoIdNotBetween(Long value1, Long value2) {
            addCriterion("store_logo_id not between", value1, value2, "storeLogoId");
            return (Criteria) this;
        }

        public Criteria andUpdateGradeIdIsNull() {
            addCriterion("update_grade_id is null");
            return (Criteria) this;
        }

        public Criteria andUpdateGradeIdIsNotNull() {
            addCriterion("update_grade_id is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateGradeIdEqualTo(Long value) {
            addCriterion("update_grade_id =", value, "updateGradeId");
            return (Criteria) this;
        }

        public Criteria andUpdateGradeIdNotEqualTo(Long value) {
            addCriterion("update_grade_id <>", value, "updateGradeId");
            return (Criteria) this;
        }

        public Criteria andUpdateGradeIdGreaterThan(Long value) {
            addCriterion("update_grade_id >", value, "updateGradeId");
            return (Criteria) this;
        }

        public Criteria andUpdateGradeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("update_grade_id >=", value, "updateGradeId");
            return (Criteria) this;
        }

        public Criteria andUpdateGradeIdLessThan(Long value) {
            addCriterion("update_grade_id <", value, "updateGradeId");
            return (Criteria) this;
        }

        public Criteria andUpdateGradeIdLessThanOrEqualTo(Long value) {
            addCriterion("update_grade_id <=", value, "updateGradeId");
            return (Criteria) this;
        }

        public Criteria andUpdateGradeIdIn(List<Long> values) {
            addCriterion("update_grade_id in", values, "updateGradeId");
            return (Criteria) this;
        }

        public Criteria andUpdateGradeIdNotIn(List<Long> values) {
            addCriterion("update_grade_id not in", values, "updateGradeId");
            return (Criteria) this;
        }

        public Criteria andUpdateGradeIdBetween(Long value1, Long value2) {
            addCriterion("update_grade_id between", value1, value2, "updateGradeId");
            return (Criteria) this;
        }

        public Criteria andUpdateGradeIdNotBetween(Long value1, Long value2) {
            addCriterion("update_grade_id not between", value1, value2, "updateGradeId");
            return (Criteria) this;
        }

        public Criteria andDomainModifyCountIsNull() {
            addCriterion("domain_modify_count is null");
            return (Criteria) this;
        }

        public Criteria andDomainModifyCountIsNotNull() {
            addCriterion("domain_modify_count is not null");
            return (Criteria) this;
        }

        public Criteria andDomainModifyCountEqualTo(Integer value) {
            addCriterion("domain_modify_count =", value, "domainModifyCount");
            return (Criteria) this;
        }

        public Criteria andDomainModifyCountNotEqualTo(Integer value) {
            addCriterion("domain_modify_count <>", value, "domainModifyCount");
            return (Criteria) this;
        }

        public Criteria andDomainModifyCountGreaterThan(Integer value) {
            addCriterion("domain_modify_count >", value, "domainModifyCount");
            return (Criteria) this;
        }

        public Criteria andDomainModifyCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("domain_modify_count >=", value, "domainModifyCount");
            return (Criteria) this;
        }

        public Criteria andDomainModifyCountLessThan(Integer value) {
            addCriterion("domain_modify_count <", value, "domainModifyCount");
            return (Criteria) this;
        }

        public Criteria andDomainModifyCountLessThanOrEqualTo(Integer value) {
            addCriterion("domain_modify_count <=", value, "domainModifyCount");
            return (Criteria) this;
        }

        public Criteria andDomainModifyCountIn(List<Integer> values) {
            addCriterion("domain_modify_count in", values, "domainModifyCount");
            return (Criteria) this;
        }

        public Criteria andDomainModifyCountNotIn(List<Integer> values) {
            addCriterion("domain_modify_count not in", values, "domainModifyCount");
            return (Criteria) this;
        }

        public Criteria andDomainModifyCountBetween(Integer value1, Integer value2) {
            addCriterion("domain_modify_count between", value1, value2, "domainModifyCount");
            return (Criteria) this;
        }

        public Criteria andDomainModifyCountNotBetween(Integer value1, Integer value2) {
            addCriterion("domain_modify_count not between", value1, value2, "domainModifyCount");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainIsNull() {
            addCriterion("store_second_domain is null");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainIsNotNull() {
            addCriterion("store_second_domain is not null");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainEqualTo(String value) {
            addCriterion("store_second_domain =", value, "storeSecondDomain");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainNotEqualTo(String value) {
            addCriterion("store_second_domain <>", value, "storeSecondDomain");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainGreaterThan(String value) {
            addCriterion("store_second_domain >", value, "storeSecondDomain");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainGreaterThanOrEqualTo(String value) {
            addCriterion("store_second_domain >=", value, "storeSecondDomain");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainLessThan(String value) {
            addCriterion("store_second_domain <", value, "storeSecondDomain");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainLessThanOrEqualTo(String value) {
            addCriterion("store_second_domain <=", value, "storeSecondDomain");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainLike(String value) {
            addCriterion("store_second_domain like", value, "storeSecondDomain");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainNotLike(String value) {
            addCriterion("store_second_domain not like", value, "storeSecondDomain");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainIn(List<String> values) {
            addCriterion("store_second_domain in", values, "storeSecondDomain");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainNotIn(List<String> values) {
            addCriterion("store_second_domain not in", values, "storeSecondDomain");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainBetween(String value1, String value2) {
            addCriterion("store_second_domain between", value1, value2, "storeSecondDomain");
            return (Criteria) this;
        }

        public Criteria andStoreSecondDomainNotBetween(String value1, String value2) {
            addCriterion("store_second_domain not between", value1, value2, "storeSecondDomain");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNull() {
            addCriterion("payment_id is null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIsNotNull() {
            addCriterion("payment_id is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentIdEqualTo(Long value) {
            addCriterion("payment_id =", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotEqualTo(Long value) {
            addCriterion("payment_id <>", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThan(Long value) {
            addCriterion("payment_id >", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("payment_id >=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThan(Long value) {
            addCriterion("payment_id <", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdLessThanOrEqualTo(Long value) {
            addCriterion("payment_id <=", value, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdIn(List<Long> values) {
            addCriterion("payment_id in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotIn(List<Long> values) {
            addCriterion("payment_id not in", values, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdBetween(Long value1, Long value2) {
            addCriterion("payment_id between", value1, value2, "paymentId");
            return (Criteria) this;
        }

        public Criteria andPaymentIdNotBetween(Long value1, Long value2) {
            addCriterion("payment_id not between", value1, value2, "paymentId");
            return (Criteria) this;
        }
        
        public Criteria andFavoriteCountIsNull() {
            addCriterion("favorite_count is null");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountIsNotNull() {
            addCriterion("favorite_count is not null");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountEqualTo(Integer value) {
            addCriterion("favorite_count =", value, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountNotEqualTo(Integer value) {
            addCriterion("favorite_count <>", value, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountGreaterThan(Integer value) {
            addCriterion("favorite_count >", value, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("favorite_count >=", value, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountLessThan(Integer value) {
            addCriterion("favorite_count <", value, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountLessThanOrEqualTo(Integer value) {
            addCriterion("favorite_count <=", value, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountIn(List<Integer> values) {
            addCriterion("favorite_count in", values, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountNotIn(List<Integer> values) {
            addCriterion("favorite_count not in", values, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountBetween(Integer value1, Integer value2) {
            addCriterion("favorite_count between", value1, value2, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andFavoriteCountNotBetween(Integer value1, Integer value2) {
            addCriterion("favorite_count not between", value1, value2, "favoriteCount");
            return (Criteria) this;
        }

        public Criteria andStoreLatIsNull() {
            addCriterion("store_lat is null");
            return (Criteria) this;
        }

        public Criteria andStoreLatIsNotNull() {
            addCriterion("store_lat is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLatEqualTo(BigDecimal value) {
            addCriterion("store_lat =", value, "storeLat");
            return (Criteria) this;
        }

        public Criteria andStoreLatNotEqualTo(BigDecimal value) {
            addCriterion("store_lat <>", value, "storeLat");
            return (Criteria) this;
        }

        public Criteria andStoreLatGreaterThan(BigDecimal value) {
            addCriterion("store_lat >", value, "storeLat");
            return (Criteria) this;
        }

        public Criteria andStoreLatGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("store_lat >=", value, "storeLat");
            return (Criteria) this;
        }

        public Criteria andStoreLatLessThan(BigDecimal value) {
            addCriterion("store_lat <", value, "storeLat");
            return (Criteria) this;
        }

        public Criteria andStoreLatLessThanOrEqualTo(BigDecimal value) {
            addCriterion("store_lat <=", value, "storeLat");
            return (Criteria) this;
        }

        public Criteria andStoreLatIn(List<BigDecimal> values) {
            addCriterion("store_lat in", values, "storeLat");
            return (Criteria) this;
        }

        public Criteria andStoreLatNotIn(List<BigDecimal> values) {
            addCriterion("store_lat not in", values, "storeLat");
            return (Criteria) this;
        }

        public Criteria andStoreLatBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("store_lat between", value1, value2, "storeLat");
            return (Criteria) this;
        }

        public Criteria andStoreLatNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("store_lat not between", value1, value2, "storeLat");
            return (Criteria) this;
        }

        public Criteria andStoreLngIsNull() {
            addCriterion("store_lng is null");
            return (Criteria) this;
        }

        public Criteria andStoreLngIsNotNull() {
            addCriterion("store_lng is not null");
            return (Criteria) this;
        }

        public Criteria andStoreLngEqualTo(BigDecimal value) {
            addCriterion("store_lng =", value, "storeLng");
            return (Criteria) this;
        }

        public Criteria andStoreLngNotEqualTo(BigDecimal value) {
            addCriterion("store_lng <>", value, "storeLng");
            return (Criteria) this;
        }

        public Criteria andStoreLngGreaterThan(BigDecimal value) {
            addCriterion("store_lng >", value, "storeLng");
            return (Criteria) this;
        }

        public Criteria andStoreLngGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("store_lng >=", value, "storeLng");
            return (Criteria) this;
        }

        public Criteria andStoreLngLessThan(BigDecimal value) {
            addCriterion("store_lng <", value, "storeLng");
            return (Criteria) this;
        }

        public Criteria andStoreLngLessThanOrEqualTo(BigDecimal value) {
            addCriterion("store_lng <=", value, "storeLng");
            return (Criteria) this;
        }

        public Criteria andStoreLngIn(List<BigDecimal> values) {
            addCriterion("store_lng in", values, "storeLng");
            return (Criteria) this;
        }

        public Criteria andStoreLngNotIn(List<BigDecimal> values) {
            addCriterion("store_lng not in", values, "storeLng");
            return (Criteria) this;
        }

        public Criteria andStoreLngBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("store_lng between", value1, value2, "storeLng");
            return (Criteria) this;
        }

        public Criteria andStoreLngNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("store_lng not between", value1, value2, "storeLng");
            return (Criteria) this;
        }

        public Criteria andStoreWwIsNull() {
            addCriterion("store_ww is null");
            return (Criteria) this;
        }

        public Criteria andStoreWwIsNotNull() {
            addCriterion("store_ww is not null");
            return (Criteria) this;
        }

        public Criteria andStoreWwEqualTo(String value) {
            addCriterion("store_ww =", value, "storeWw");
            return (Criteria) this;
        }

        public Criteria andStoreWwNotEqualTo(String value) {
            addCriterion("store_ww <>", value, "storeWw");
            return (Criteria) this;
        }

        public Criteria andStoreWwGreaterThan(String value) {
            addCriterion("store_ww >", value, "storeWw");
            return (Criteria) this;
        }

        public Criteria andStoreWwGreaterThanOrEqualTo(String value) {
            addCriterion("store_ww >=", value, "storeWw");
            return (Criteria) this;
        }

        public Criteria andStoreWwLessThan(String value) {
            addCriterion("store_ww <", value, "storeWw");
            return (Criteria) this;
        }

        public Criteria andStoreWwLessThanOrEqualTo(String value) {
            addCriterion("store_ww <=", value, "storeWw");
            return (Criteria) this;
        }

        public Criteria andStoreWwLike(String value) {
            addCriterion("store_ww like", value, "storeWw");
            return (Criteria) this;
        }

        public Criteria andStoreWwNotLike(String value) {
            addCriterion("store_ww not like", value, "storeWw");
            return (Criteria) this;
        }

        public Criteria andStoreWwIn(List<String> values) {
            addCriterion("store_ww in", values, "storeWw");
            return (Criteria) this;
        }

        public Criteria andStoreWwNotIn(List<String> values) {
            addCriterion("store_ww not in", values, "storeWw");
            return (Criteria) this;
        }

        public Criteria andStoreWwBetween(String value1, String value2) {
            addCriterion("store_ww between", value1, value2, "storeWw");
            return (Criteria) this;
        }

        public Criteria andStoreWwNotBetween(String value1, String value2) {
            addCriterion("store_ww not between", value1, value2, "storeWw");
            return (Criteria) this;
        }

        public Criteria andMapTypeIsNull() {
            addCriterion("map_type is null");
            return (Criteria) this;
        }

        public Criteria andMapTypeIsNotNull() {
            addCriterion("map_type is not null");
            return (Criteria) this;
        }

        public Criteria andMapTypeEqualTo(String value) {
            addCriterion("map_type =", value, "mapType");
            return (Criteria) this;
        }

        public Criteria andMapTypeNotEqualTo(String value) {
            addCriterion("map_type <>", value, "mapType");
            return (Criteria) this;
        }

        public Criteria andMapTypeGreaterThan(String value) {
            addCriterion("map_type >", value, "mapType");
            return (Criteria) this;
        }

        public Criteria andMapTypeGreaterThanOrEqualTo(String value) {
            addCriterion("map_type >=", value, "mapType");
            return (Criteria) this;
        }

        public Criteria andMapTypeLessThan(String value) {
            addCriterion("map_type <", value, "mapType");
            return (Criteria) this;
        }

        public Criteria andMapTypeLessThanOrEqualTo(String value) {
            addCriterion("map_type <=", value, "mapType");
            return (Criteria) this;
        }

        public Criteria andMapTypeLike(String value) {
            addCriterion("map_type like", value, "mapType");
            return (Criteria) this;
        }

        public Criteria andMapTypeNotLike(String value) {
            addCriterion("map_type not like", value, "mapType");
            return (Criteria) this;
        }

        public Criteria andMapTypeIn(List<String> values) {
            addCriterion("map_type in", values, "mapType");
            return (Criteria) this;
        }

        public Criteria andMapTypeNotIn(List<String> values) {
            addCriterion("map_type not in", values, "mapType");
            return (Criteria) this;
        }

        public Criteria andMapTypeBetween(String value1, String value2) {
            addCriterion("map_type between", value1, value2, "mapType");
            return (Criteria) this;
        }

        public Criteria andMapTypeNotBetween(String value1, String value2) {
            addCriterion("map_type not between", value1, value2, "mapType");
            return (Criteria) this;
        }

        public Criteria andDeliveryBeginTimeIsNull() {
            addCriterion("delivery_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryBeginTimeIsNotNull() {
            addCriterion("delivery_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryBeginTimeEqualTo(Date value) {
            addCriterion("delivery_begin_time =", value, "deliveryBeginTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryBeginTimeNotEqualTo(Date value) {
            addCriterion("delivery_begin_time <>", value, "deliveryBeginTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryBeginTimeGreaterThan(Date value) {
            addCriterion("delivery_begin_time >", value, "deliveryBeginTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_begin_time >=", value, "deliveryBeginTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryBeginTimeLessThan(Date value) {
            addCriterion("delivery_begin_time <", value, "deliveryBeginTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("delivery_begin_time <=", value, "deliveryBeginTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryBeginTimeIn(List<Date> values) {
            addCriterion("delivery_begin_time in", values, "deliveryBeginTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryBeginTimeNotIn(List<Date> values) {
            addCriterion("delivery_begin_time not in", values, "deliveryBeginTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryBeginTimeBetween(Date value1, Date value2) {
            addCriterion("delivery_begin_time between", value1, value2, "deliveryBeginTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("delivery_begin_time not between", value1, value2, "deliveryBeginTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeIsNull() {
            addCriterion("delivery_end_time is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeIsNotNull() {
            addCriterion("delivery_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeEqualTo(Date value) {
            addCriterion("delivery_end_time =", value, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeNotEqualTo(Date value) {
            addCriterion("delivery_end_time <>", value, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeGreaterThan(Date value) {
            addCriterion("delivery_end_time >", value, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_end_time >=", value, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeLessThan(Date value) {
            addCriterion("delivery_end_time <", value, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("delivery_end_time <=", value, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeIn(List<Date> values) {
            addCriterion("delivery_end_time in", values, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeNotIn(List<Date> values) {
            addCriterion("delivery_end_time not in", values, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeBetween(Date value1, Date value2) {
            addCriterion("delivery_end_time between", value1, value2, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andDeliveryEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("delivery_end_time not between", value1, value2, "deliveryEndTime");
            return (Criteria) this;
        }

        public Criteria andCombinBeginTimeIsNull() {
            addCriterion("combin_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andCombinBeginTimeIsNotNull() {
            addCriterion("combin_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andCombinBeginTimeEqualTo(Date value) {
            addCriterion("combin_begin_time =", value, "combinBeginTime");
            return (Criteria) this;
        }

        public Criteria andCombinBeginTimeNotEqualTo(Date value) {
            addCriterion("combin_begin_time <>", value, "combinBeginTime");
            return (Criteria) this;
        }

        public Criteria andCombinBeginTimeGreaterThan(Date value) {
            addCriterion("combin_begin_time >", value, "combinBeginTime");
            return (Criteria) this;
        }

        public Criteria andCombinBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("combin_begin_time >=", value, "combinBeginTime");
            return (Criteria) this;
        }

        public Criteria andCombinBeginTimeLessThan(Date value) {
            addCriterion("combin_begin_time <", value, "combinBeginTime");
            return (Criteria) this;
        }

        public Criteria andCombinBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("combin_begin_time <=", value, "combinBeginTime");
            return (Criteria) this;
        }

        public Criteria andCombinBeginTimeIn(List<Date> values) {
            addCriterion("combin_begin_time in", values, "combinBeginTime");
            return (Criteria) this;
        }

        public Criteria andCombinBeginTimeNotIn(List<Date> values) {
            addCriterion("combin_begin_time not in", values, "combinBeginTime");
            return (Criteria) this;
        }

        public Criteria andCombinBeginTimeBetween(Date value1, Date value2) {
            addCriterion("combin_begin_time between", value1, value2, "combinBeginTime");
            return (Criteria) this;
        }

        public Criteria andCombinBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("combin_begin_time not between", value1, value2, "combinBeginTime");
            return (Criteria) this;
        }

        public Criteria andCombinEndTimeIsNull() {
            addCriterion("combin_end_time is null");
            return (Criteria) this;
        }

        public Criteria andCombinEndTimeIsNotNull() {
            addCriterion("combin_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andCombinEndTimeEqualTo(Date value) {
            addCriterion("combin_end_time =", value, "combinEndTime");
            return (Criteria) this;
        }

        public Criteria andCombinEndTimeNotEqualTo(Date value) {
            addCriterion("combin_end_time <>", value, "combinEndTime");
            return (Criteria) this;
        }

        public Criteria andCombinEndTimeGreaterThan(Date value) {
            addCriterion("combin_end_time >", value, "combinEndTime");
            return (Criteria) this;
        }

        public Criteria andCombinEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("combin_end_time >=", value, "combinEndTime");
            return (Criteria) this;
        }

        public Criteria andCombinEndTimeLessThan(Date value) {
            addCriterion("combin_end_time <", value, "combinEndTime");
            return (Criteria) this;
        }

        public Criteria andCombinEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("combin_end_time <=", value, "combinEndTime");
            return (Criteria) this;
        }

        public Criteria andCombinEndTimeIn(List<Date> values) {
            addCriterion("combin_end_time in", values, "combinEndTime");
            return (Criteria) this;
        }

        public Criteria andCombinEndTimeNotIn(List<Date> values) {
            addCriterion("combin_end_time not in", values, "combinEndTime");
            return (Criteria) this;
        }

        public Criteria andCombinEndTimeBetween(Date value1, Date value2) {
            addCriterion("combin_end_time between", value1, value2, "combinEndTime");
            return (Criteria) this;
        }

        public Criteria andCombinEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("combin_end_time not between", value1, value2, "combinEndTime");
            return (Criteria) this;
        }

        public Criteria andWeixinBeginTimeIsNull() {
            addCriterion("weixin_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andWeixinBeginTimeIsNotNull() {
            addCriterion("weixin_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinBeginTimeEqualTo(Date value) {
            addCriterionForJDBCDate("weixin_begin_time =", value, "weixinBeginTime");
            return (Criteria) this;
        }

        public Criteria andWeixinBeginTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("weixin_begin_time <>", value, "weixinBeginTime");
            return (Criteria) this;
        }

        public Criteria andWeixinBeginTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("weixin_begin_time >", value, "weixinBeginTime");
            return (Criteria) this;
        }

        public Criteria andWeixinBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("weixin_begin_time >=", value, "weixinBeginTime");
            return (Criteria) this;
        }

        public Criteria andWeixinBeginTimeLessThan(Date value) {
            addCriterionForJDBCDate("weixin_begin_time <", value, "weixinBeginTime");
            return (Criteria) this;
        }

        public Criteria andWeixinBeginTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("weixin_begin_time <=", value, "weixinBeginTime");
            return (Criteria) this;
        }

        public Criteria andWeixinBeginTimeIn(List<Date> values) {
            addCriterionForJDBCDate("weixin_begin_time in", values, "weixinBeginTime");
            return (Criteria) this;
        }

        public Criteria andWeixinBeginTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("weixin_begin_time not in", values, "weixinBeginTime");
            return (Criteria) this;
        }

        public Criteria andWeixinBeginTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("weixin_begin_time between", value1, value2, "weixinBeginTime");
            return (Criteria) this;
        }

        public Criteria andWeixinBeginTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("weixin_begin_time not between", value1, value2, "weixinBeginTime");
            return (Criteria) this;
        }

        public Criteria andWeixinEndTimeIsNull() {
            addCriterion("weixin_end_time is null");
            return (Criteria) this;
        }

        public Criteria andWeixinEndTimeIsNotNull() {
            addCriterion("weixin_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinEndTimeEqualTo(Date value) {
            addCriterionForJDBCDate("weixin_end_time =", value, "weixinEndTime");
            return (Criteria) this;
        }

        public Criteria andWeixinEndTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("weixin_end_time <>", value, "weixinEndTime");
            return (Criteria) this;
        }

        public Criteria andWeixinEndTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("weixin_end_time >", value, "weixinEndTime");
            return (Criteria) this;
        }

        public Criteria andWeixinEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("weixin_end_time >=", value, "weixinEndTime");
            return (Criteria) this;
        }

        public Criteria andWeixinEndTimeLessThan(Date value) {
            addCriterionForJDBCDate("weixin_end_time <", value, "weixinEndTime");
            return (Criteria) this;
        }

        public Criteria andWeixinEndTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("weixin_end_time <=", value, "weixinEndTime");
            return (Criteria) this;
        }

        public Criteria andWeixinEndTimeIn(List<Date> values) {
            addCriterionForJDBCDate("weixin_end_time in", values, "weixinEndTime");
            return (Criteria) this;
        }

        public Criteria andWeixinEndTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("weixin_end_time not in", values, "weixinEndTime");
            return (Criteria) this;
        }

        public Criteria andWeixinEndTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("weixin_end_time between", value1, value2, "weixinEndTime");
            return (Criteria) this;
        }

        public Criteria andWeixinEndTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("weixin_end_time not between", value1, value2, "weixinEndTime");
            return (Criteria) this;
        }

        public Criteria andWeixinStatusIsNull() {
            addCriterion("weixin_status is null");
            return (Criteria) this;
        }

        public Criteria andWeixinStatusIsNotNull() {
            addCriterion("weixin_status is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinStatusEqualTo(Integer value) {
            addCriterion("weixin_status =", value, "weixinStatus");
            return (Criteria) this;
        }

        public Criteria andWeixinStatusNotEqualTo(Integer value) {
            addCriterion("weixin_status <>", value, "weixinStatus");
            return (Criteria) this;
        }

        public Criteria andWeixinStatusGreaterThan(Integer value) {
            addCriterion("weixin_status >", value, "weixinStatus");
            return (Criteria) this;
        }

        public Criteria andWeixinStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("weixin_status >=", value, "weixinStatus");
            return (Criteria) this;
        }

        public Criteria andWeixinStatusLessThan(Integer value) {
            addCriterion("weixin_status <", value, "weixinStatus");
            return (Criteria) this;
        }

        public Criteria andWeixinStatusLessThanOrEqualTo(Integer value) {
            addCriterion("weixin_status <=", value, "weixinStatus");
            return (Criteria) this;
        }

        public Criteria andWeixinStatusIn(List<Integer> values) {
            addCriterion("weixin_status in", values, "weixinStatus");
            return (Criteria) this;
        }

        public Criteria andWeixinStatusNotIn(List<Integer> values) {
            addCriterion("weixin_status not in", values, "weixinStatus");
            return (Criteria) this;
        }

        public Criteria andWeixinStatusBetween(Integer value1, Integer value2) {
            addCriterion("weixin_status between", value1, value2, "weixinStatus");
            return (Criteria) this;
        }

        public Criteria andWeixinStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("weixin_status not between", value1, value2, "weixinStatus");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidIsNull() {
            addCriterion("weixin_appId is null");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidIsNotNull() {
            addCriterion("weixin_appId is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidEqualTo(String value) {
            addCriterion("weixin_appId =", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidNotEqualTo(String value) {
            addCriterion("weixin_appId <>", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidGreaterThan(String value) {
            addCriterion("weixin_appId >", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_appId >=", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidLessThan(String value) {
            addCriterion("weixin_appId <", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidLessThanOrEqualTo(String value) {
            addCriterion("weixin_appId <=", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidLike(String value) {
            addCriterion("weixin_appId like", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidNotLike(String value) {
            addCriterion("weixin_appId not like", value, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidIn(List<String> values) {
            addCriterion("weixin_appId in", values, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidNotIn(List<String> values) {
            addCriterion("weixin_appId not in", values, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidBetween(String value1, String value2) {
            addCriterion("weixin_appId between", value1, value2, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppidNotBetween(String value1, String value2) {
            addCriterion("weixin_appId not between", value1, value2, "weixinAppid");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretIsNull() {
            addCriterion("weixin_appSecret is null");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretIsNotNull() {
            addCriterion("weixin_appSecret is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretEqualTo(String value) {
            addCriterion("weixin_appSecret =", value, "weixinAppsecret");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretNotEqualTo(String value) {
            addCriterion("weixin_appSecret <>", value, "weixinAppsecret");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretGreaterThan(String value) {
            addCriterion("weixin_appSecret >", value, "weixinAppsecret");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_appSecret >=", value, "weixinAppsecret");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretLessThan(String value) {
            addCriterion("weixin_appSecret <", value, "weixinAppsecret");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretLessThanOrEqualTo(String value) {
            addCriterion("weixin_appSecret <=", value, "weixinAppsecret");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretLike(String value) {
            addCriterion("weixin_appSecret like", value, "weixinAppsecret");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretNotLike(String value) {
            addCriterion("weixin_appSecret not like", value, "weixinAppsecret");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretIn(List<String> values) {
            addCriterion("weixin_appSecret in", values, "weixinAppsecret");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretNotIn(List<String> values) {
            addCriterion("weixin_appSecret not in", values, "weixinAppsecret");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretBetween(String value1, String value2) {
            addCriterion("weixin_appSecret between", value1, value2, "weixinAppsecret");
            return (Criteria) this;
        }

        public Criteria andWeixinAppsecretNotBetween(String value1, String value2) {
            addCriterion("weixin_appSecret not between", value1, value2, "weixinAppsecret");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenIsNull() {
            addCriterion("weixin_token is null");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenIsNotNull() {
            addCriterion("weixin_token is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenEqualTo(String value) {
            addCriterion("weixin_token =", value, "weixinToken");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenNotEqualTo(String value) {
            addCriterion("weixin_token <>", value, "weixinToken");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenGreaterThan(String value) {
            addCriterion("weixin_token >", value, "weixinToken");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_token >=", value, "weixinToken");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenLessThan(String value) {
            addCriterion("weixin_token <", value, "weixinToken");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenLessThanOrEqualTo(String value) {
            addCriterion("weixin_token <=", value, "weixinToken");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenLike(String value) {
            addCriterion("weixin_token like", value, "weixinToken");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenNotLike(String value) {
            addCriterion("weixin_token not like", value, "weixinToken");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenIn(List<String> values) {
            addCriterion("weixin_token in", values, "weixinToken");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenNotIn(List<String> values) {
            addCriterion("weixin_token not in", values, "weixinToken");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenBetween(String value1, String value2) {
            addCriterion("weixin_token between", value1, value2, "weixinToken");
            return (Criteria) this;
        }

        public Criteria andWeixinTokenNotBetween(String value1, String value2) {
            addCriterion("weixin_token not between", value1, value2, "weixinToken");
            return (Criteria) this;
        }

        public Criteria andWeixinQrImgIdIsNull() {
            addCriterion("weixin_qr_img_id is null");
            return (Criteria) this;
        }

        public Criteria andWeixinQrImgIdIsNotNull() {
            addCriterion("weixin_qr_img_id is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinQrImgIdEqualTo(Long value) {
            addCriterion("weixin_qr_img_id =", value, "weixinQrImgId");
            return (Criteria) this;
        }

        public Criteria andWeixinQrImgIdNotEqualTo(Long value) {
            addCriterion("weixin_qr_img_id <>", value, "weixinQrImgId");
            return (Criteria) this;
        }

        public Criteria andWeixinQrImgIdGreaterThan(Long value) {
            addCriterion("weixin_qr_img_id >", value, "weixinQrImgId");
            return (Criteria) this;
        }

        public Criteria andWeixinQrImgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("weixin_qr_img_id >=", value, "weixinQrImgId");
            return (Criteria) this;
        }

        public Criteria andWeixinQrImgIdLessThan(Long value) {
            addCriterion("weixin_qr_img_id <", value, "weixinQrImgId");
            return (Criteria) this;
        }

        public Criteria andWeixinQrImgIdLessThanOrEqualTo(Long value) {
            addCriterion("weixin_qr_img_id <=", value, "weixinQrImgId");
            return (Criteria) this;
        }

        public Criteria andWeixinQrImgIdIn(List<Long> values) {
            addCriterion("weixin_qr_img_id in", values, "weixinQrImgId");
            return (Criteria) this;
        }

        public Criteria andWeixinQrImgIdNotIn(List<Long> values) {
            addCriterion("weixin_qr_img_id not in", values, "weixinQrImgId");
            return (Criteria) this;
        }

        public Criteria andWeixinQrImgIdBetween(Long value1, Long value2) {
            addCriterion("weixin_qr_img_id between", value1, value2, "weixinQrImgId");
            return (Criteria) this;
        }

        public Criteria andWeixinQrImgIdNotBetween(Long value1, Long value2) {
            addCriterion("weixin_qr_img_id not between", value1, value2, "weixinQrImgId");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountIsNull() {
            addCriterion("weixin_account is null");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountIsNotNull() {
            addCriterion("weixin_account is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountEqualTo(String value) {
            addCriterion("weixin_account =", value, "weixinAccount");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountNotEqualTo(String value) {
            addCriterion("weixin_account <>", value, "weixinAccount");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountGreaterThan(String value) {
            addCriterion("weixin_account >", value, "weixinAccount");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_account >=", value, "weixinAccount");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountLessThan(String value) {
            addCriterion("weixin_account <", value, "weixinAccount");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountLessThanOrEqualTo(String value) {
            addCriterion("weixin_account <=", value, "weixinAccount");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountLike(String value) {
            addCriterion("weixin_account like", value, "weixinAccount");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountNotLike(String value) {
            addCriterion("weixin_account not like", value, "weixinAccount");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountIn(List<String> values) {
            addCriterion("weixin_account in", values, "weixinAccount");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountNotIn(List<String> values) {
            addCriterion("weixin_account not in", values, "weixinAccount");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountBetween(String value1, String value2) {
            addCriterion("weixin_account between", value1, value2, "weixinAccount");
            return (Criteria) this;
        }

        public Criteria andWeixinAccountNotBetween(String value1, String value2) {
            addCriterion("weixin_account not between", value1, value2, "weixinAccount");
            return (Criteria) this;
        }

        public Criteria andStoreWeixinLogoIdIsNull() {
            addCriterion("store_weixin_logo_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreWeixinLogoIdIsNotNull() {
            addCriterion("store_weixin_logo_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreWeixinLogoIdEqualTo(Long value) {
            addCriterion("store_weixin_logo_id =", value, "storeWeixinLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreWeixinLogoIdNotEqualTo(Long value) {
            addCriterion("store_weixin_logo_id <>", value, "storeWeixinLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreWeixinLogoIdGreaterThan(Long value) {
            addCriterion("store_weixin_logo_id >", value, "storeWeixinLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreWeixinLogoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("store_weixin_logo_id >=", value, "storeWeixinLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreWeixinLogoIdLessThan(Long value) {
            addCriterion("store_weixin_logo_id <", value, "storeWeixinLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreWeixinLogoIdLessThanOrEqualTo(Long value) {
            addCriterion("store_weixin_logo_id <=", value, "storeWeixinLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreWeixinLogoIdIn(List<Long> values) {
            addCriterion("store_weixin_logo_id in", values, "storeWeixinLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreWeixinLogoIdNotIn(List<Long> values) {
            addCriterion("store_weixin_logo_id not in", values, "storeWeixinLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreWeixinLogoIdBetween(Long value1, Long value2) {
            addCriterion("store_weixin_logo_id between", value1, value2, "storeWeixinLogoId");
            return (Criteria) this;
        }

        public Criteria andStoreWeixinLogoIdNotBetween(Long value1, Long value2) {
            addCriterion("store_weixin_logo_id not between", value1, value2, "storeWeixinLogoId");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameIsNull() {
            addCriterion("weixin_store_name is null");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameIsNotNull() {
            addCriterion("weixin_store_name is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameEqualTo(String value) {
            addCriterion("weixin_store_name =", value, "weixinStoreName");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameNotEqualTo(String value) {
            addCriterion("weixin_store_name <>", value, "weixinStoreName");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameGreaterThan(String value) {
            addCriterion("weixin_store_name >", value, "weixinStoreName");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameGreaterThanOrEqualTo(String value) {
            addCriterion("weixin_store_name >=", value, "weixinStoreName");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameLessThan(String value) {
            addCriterion("weixin_store_name <", value, "weixinStoreName");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameLessThanOrEqualTo(String value) {
            addCriterion("weixin_store_name <=", value, "weixinStoreName");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameLike(String value) {
            addCriterion("weixin_store_name like", value, "weixinStoreName");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameNotLike(String value) {
            addCriterion("weixin_store_name not like", value, "weixinStoreName");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameIn(List<String> values) {
            addCriterion("weixin_store_name in", values, "weixinStoreName");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameNotIn(List<String> values) {
            addCriterion("weixin_store_name not in", values, "weixinStoreName");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameBetween(String value1, String value2) {
            addCriterion("weixin_store_name between", value1, value2, "weixinStoreName");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNameNotBetween(String value1, String value2) {
            addCriterion("weixin_store_name not between", value1, value2, "weixinStoreName");
            return (Criteria) this;
        }
        
        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPointIdIsNull() {
            addCriterion("point_id is null");
            return (Criteria) this;
        }

        public Criteria andPointIdIsNotNull() {
            addCriterion("point_id is not null");
            return (Criteria) this;
        }

        public Criteria andPointIdEqualTo(Long value) {
            addCriterion("point_id =", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotEqualTo(Long value) {
            addCriterion("point_id <>", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdGreaterThan(Long value) {
            addCriterion("point_id >", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdGreaterThanOrEqualTo(Long value) {
            addCriterion("point_id >=", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLessThan(Long value) {
            addCriterion("point_id <", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdLessThanOrEqualTo(Long value) {
            addCriterion("point_id <=", value, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdIn(List<Long> values) {
            addCriterion("point_id in", values, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotIn(List<Long> values) {
            addCriterion("point_id not in", values, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdBetween(Long value1, Long value2) {
            addCriterion("point_id between", value1, value2, "pointId");
            return (Criteria) this;
        }

        public Criteria andPointIdNotBetween(Long value1, Long value2) {
            addCriterion("point_id not between", value1, value2, "pointId");
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