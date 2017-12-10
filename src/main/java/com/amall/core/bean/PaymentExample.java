package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class PaymentExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PaymentExample() {
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

        public Criteria andChinabankAccountIsNull() {
            addCriterion("chinabank_account is null");
            return (Criteria) this;
        }

        public Criteria andChinabankAccountIsNotNull() {
            addCriterion("chinabank_account is not null");
            return (Criteria) this;
        }

        public Criteria andChinabankAccountEqualTo(String value) {
            addCriterion("chinabank_account =", value, "chinabankAccount");
            return (Criteria) this;
        }

        public Criteria andChinabankAccountNotEqualTo(String value) {
            addCriterion("chinabank_account <>", value, "chinabankAccount");
            return (Criteria) this;
        }

        public Criteria andChinabankAccountGreaterThan(String value) {
            addCriterion("chinabank_account >", value, "chinabankAccount");
            return (Criteria) this;
        }

        public Criteria andChinabankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("chinabank_account >=", value, "chinabankAccount");
            return (Criteria) this;
        }

        public Criteria andChinabankAccountLessThan(String value) {
            addCriterion("chinabank_account <", value, "chinabankAccount");
            return (Criteria) this;
        }

        public Criteria andChinabankAccountLessThanOrEqualTo(String value) {
            addCriterion("chinabank_account <=", value, "chinabankAccount");
            return (Criteria) this;
        }

        public Criteria andChinabankAccountLike(String value) {
            addCriterion("chinabank_account like", value, "chinabankAccount");
            return (Criteria) this;
        }

        public Criteria andChinabankAccountNotLike(String value) {
            addCriterion("chinabank_account not like", value, "chinabankAccount");
            return (Criteria) this;
        }

        public Criteria andChinabankAccountIn(List<String> values) {
            addCriterion("chinabank_account in", values, "chinabankAccount");
            return (Criteria) this;
        }

        public Criteria andChinabankAccountNotIn(List<String> values) {
            addCriterion("chinabank_account not in", values, "chinabankAccount");
            return (Criteria) this;
        }

        public Criteria andChinabankAccountBetween(String value1, String value2) {
            addCriterion("chinabank_account between", value1, value2, "chinabankAccount");
            return (Criteria) this;
        }

        public Criteria andChinabankAccountNotBetween(String value1, String value2) {
            addCriterion("chinabank_account not between", value1, value2, "chinabankAccount");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyIsNull() {
            addCriterion("chinabank_key is null");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyIsNotNull() {
            addCriterion("chinabank_key is not null");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyEqualTo(String value) {
            addCriterion("chinabank_key =", value, "chinabankKey");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyNotEqualTo(String value) {
            addCriterion("chinabank_key <>", value, "chinabankKey");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyGreaterThan(String value) {
            addCriterion("chinabank_key >", value, "chinabankKey");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyGreaterThanOrEqualTo(String value) {
            addCriterion("chinabank_key >=", value, "chinabankKey");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyLessThan(String value) {
            addCriterion("chinabank_key <", value, "chinabankKey");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyLessThanOrEqualTo(String value) {
            addCriterion("chinabank_key <=", value, "chinabankKey");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyLike(String value) {
            addCriterion("chinabank_key like", value, "chinabankKey");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyNotLike(String value) {
            addCriterion("chinabank_key not like", value, "chinabankKey");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyIn(List<String> values) {
            addCriterion("chinabank_key in", values, "chinabankKey");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyNotIn(List<String> values) {
            addCriterion("chinabank_key not in", values, "chinabankKey");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyBetween(String value1, String value2) {
            addCriterion("chinabank_key between", value1, value2, "chinabankKey");
            return (Criteria) this;
        }

        public Criteria andChinabankKeyNotBetween(String value1, String value2) {
            addCriterion("chinabank_key not between", value1, value2, "chinabankKey");
            return (Criteria) this;
        }

        public Criteria andInstallIsNull() {
            addCriterion("install is null");
            return (Criteria) this;
        }

        public Criteria andInstallIsNotNull() {
            addCriterion("install is not null");
            return (Criteria) this;
        }

        public Criteria andInstallEqualTo(Boolean value) {
            addCriterion("install =", value, "install");
            return (Criteria) this;
        }

        public Criteria andInstallNotEqualTo(Boolean value) {
            addCriterion("install <>", value, "install");
            return (Criteria) this;
        }

        public Criteria andInstallGreaterThan(Boolean value) {
            addCriterion("install >", value, "install");
            return (Criteria) this;
        }

        public Criteria andInstallGreaterThanOrEqualTo(Boolean value) {
            addCriterion("install >=", value, "install");
            return (Criteria) this;
        }

        public Criteria andInstallLessThan(Boolean value) {
            addCriterion("install <", value, "install");
            return (Criteria) this;
        }

        public Criteria andInstallLessThanOrEqualTo(Boolean value) {
            addCriterion("install <=", value, "install");
            return (Criteria) this;
        }

        public Criteria andInstallIn(List<Boolean> values) {
            addCriterion("install in", values, "install");
            return (Criteria) this;
        }

        public Criteria andInstallNotIn(List<Boolean> values) {
            addCriterion("install not in", values, "install");
            return (Criteria) this;
        }

        public Criteria andInstallBetween(Boolean value1, Boolean value2) {
            addCriterion("install between", value1, value2, "install");
            return (Criteria) this;
        }

        public Criteria andInstallNotBetween(Boolean value1, Boolean value2) {
            addCriterion("install not between", value1, value2, "install");
            return (Criteria) this;
        }

        public Criteria andInterfacetypeIsNull() {
            addCriterion("interfaceType is null");
            return (Criteria) this;
        }

        public Criteria andInterfacetypeIsNotNull() {
            addCriterion("interfaceType is not null");
            return (Criteria) this;
        }

        public Criteria andInterfacetypeEqualTo(Integer value) {
            addCriterion("interfaceType =", value, "interfacetype");
            return (Criteria) this;
        }

        public Criteria andInterfacetypeNotEqualTo(Integer value) {
            addCriterion("interfaceType <>", value, "interfacetype");
            return (Criteria) this;
        }

        public Criteria andInterfacetypeGreaterThan(Integer value) {
            addCriterion("interfaceType >", value, "interfacetype");
            return (Criteria) this;
        }

        public Criteria andInterfacetypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("interfaceType >=", value, "interfacetype");
            return (Criteria) this;
        }

        public Criteria andInterfacetypeLessThan(Integer value) {
            addCriterion("interfaceType <", value, "interfacetype");
            return (Criteria) this;
        }

        public Criteria andInterfacetypeLessThanOrEqualTo(Integer value) {
            addCriterion("interfaceType <=", value, "interfacetype");
            return (Criteria) this;
        }

        public Criteria andInterfacetypeIn(List<Integer> values) {
            addCriterion("interfaceType in", values, "interfacetype");
            return (Criteria) this;
        }

        public Criteria andInterfacetypeNotIn(List<Integer> values) {
            addCriterion("interfaceType not in", values, "interfacetype");
            return (Criteria) this;
        }

        public Criteria andInterfacetypeBetween(Integer value1, Integer value2) {
            addCriterion("interfaceType between", value1, value2, "interfacetype");
            return (Criteria) this;
        }

        public Criteria andInterfacetypeNotBetween(Integer value1, Integer value2) {
            addCriterion("interfaceType not between", value1, value2, "interfacetype");
            return (Criteria) this;
        }

        public Criteria andMarkIsNull() {
            addCriterion("mark is null");
            return (Criteria) this;
        }

        public Criteria andMarkIsNotNull() {
            addCriterion("mark is not null");
            return (Criteria) this;
        }

        public Criteria andMarkEqualTo(String value) {
            addCriterion("mark =", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotEqualTo(String value) {
            addCriterion("mark <>", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThan(String value) {
            addCriterion("mark >", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkGreaterThanOrEqualTo(String value) {
            addCriterion("mark >=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThan(String value) {
            addCriterion("mark <", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLessThanOrEqualTo(String value) {
            addCriterion("mark <=", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkLike(String value) {
            addCriterion("mark like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotLike(String value) {
            addCriterion("mark not like", value, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkIn(List<String> values) {
            addCriterion("mark in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotIn(List<String> values) {
            addCriterion("mark not in", values, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkBetween(String value1, String value2) {
            addCriterion("mark between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMarkNotBetween(String value1, String value2) {
            addCriterion("mark not between", value1, value2, "mark");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidIsNull() {
            addCriterion("merchantAcctId is null");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidIsNotNull() {
            addCriterion("merchantAcctId is not null");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidEqualTo(String value) {
            addCriterion("merchantAcctId =", value, "merchantacctid");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidNotEqualTo(String value) {
            addCriterion("merchantAcctId <>", value, "merchantacctid");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidGreaterThan(String value) {
            addCriterion("merchantAcctId >", value, "merchantacctid");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidGreaterThanOrEqualTo(String value) {
            addCriterion("merchantAcctId >=", value, "merchantacctid");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidLessThan(String value) {
            addCriterion("merchantAcctId <", value, "merchantacctid");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidLessThanOrEqualTo(String value) {
            addCriterion("merchantAcctId <=", value, "merchantacctid");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidLike(String value) {
            addCriterion("merchantAcctId like", value, "merchantacctid");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidNotLike(String value) {
            addCriterion("merchantAcctId not like", value, "merchantacctid");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidIn(List<String> values) {
            addCriterion("merchantAcctId in", values, "merchantacctid");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidNotIn(List<String> values) {
            addCriterion("merchantAcctId not in", values, "merchantacctid");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidBetween(String value1, String value2) {
            addCriterion("merchantAcctId between", value1, value2, "merchantacctid");
            return (Criteria) this;
        }

        public Criteria andMerchantacctidNotBetween(String value1, String value2) {
            addCriterion("merchantAcctId not between", value1, value2, "merchantacctid");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPartnerIsNull() {
            addCriterion("partner is null");
            return (Criteria) this;
        }

        public Criteria andPartnerIsNotNull() {
            addCriterion("partner is not null");
            return (Criteria) this;
        }

        public Criteria andPartnerEqualTo(String value) {
            addCriterion("partner =", value, "partner");
            return (Criteria) this;
        }

        public Criteria andPartnerNotEqualTo(String value) {
            addCriterion("partner <>", value, "partner");
            return (Criteria) this;
        }

        public Criteria andPartnerGreaterThan(String value) {
            addCriterion("partner >", value, "partner");
            return (Criteria) this;
        }

        public Criteria andPartnerGreaterThanOrEqualTo(String value) {
            addCriterion("partner >=", value, "partner");
            return (Criteria) this;
        }

        public Criteria andPartnerLessThan(String value) {
            addCriterion("partner <", value, "partner");
            return (Criteria) this;
        }

        public Criteria andPartnerLessThanOrEqualTo(String value) {
            addCriterion("partner <=", value, "partner");
            return (Criteria) this;
        }

        public Criteria andPartnerLike(String value) {
            addCriterion("partner like", value, "partner");
            return (Criteria) this;
        }

        public Criteria andPartnerNotLike(String value) {
            addCriterion("partner not like", value, "partner");
            return (Criteria) this;
        }

        public Criteria andPartnerIn(List<String> values) {
            addCriterion("partner in", values, "partner");
            return (Criteria) this;
        }

        public Criteria andPartnerNotIn(List<String> values) {
            addCriterion("partner not in", values, "partner");
            return (Criteria) this;
        }

        public Criteria andPartnerBetween(String value1, String value2) {
            addCriterion("partner between", value1, value2, "partner");
            return (Criteria) this;
        }

        public Criteria andPartnerNotBetween(String value1, String value2) {
            addCriterion("partner not between", value1, value2, "partner");
            return (Criteria) this;
        }

        public Criteria andPidIsNull() {
            addCriterion("pid is null");
            return (Criteria) this;
        }

        public Criteria andPidIsNotNull() {
            addCriterion("pid is not null");
            return (Criteria) this;
        }

        public Criteria andPidEqualTo(String value) {
            addCriterion("pid =", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotEqualTo(String value) {
            addCriterion("pid <>", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThan(String value) {
            addCriterion("pid >", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidGreaterThanOrEqualTo(String value) {
            addCriterion("pid >=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThan(String value) {
            addCriterion("pid <", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLessThanOrEqualTo(String value) {
            addCriterion("pid <=", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidLike(String value) {
            addCriterion("pid like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotLike(String value) {
            addCriterion("pid not like", value, "pid");
            return (Criteria) this;
        }

        public Criteria andPidIn(List<String> values) {
            addCriterion("pid in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotIn(List<String> values) {
            addCriterion("pid not in", values, "pid");
            return (Criteria) this;
        }

        public Criteria andPidBetween(String value1, String value2) {
            addCriterion("pid between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andPidNotBetween(String value1, String value2) {
            addCriterion("pid not between", value1, value2, "pid");
            return (Criteria) this;
        }

        public Criteria andRmbkeyIsNull() {
            addCriterion("rmbKey is null");
            return (Criteria) this;
        }

        public Criteria andRmbkeyIsNotNull() {
            addCriterion("rmbKey is not null");
            return (Criteria) this;
        }

        public Criteria andRmbkeyEqualTo(String value) {
            addCriterion("rmbKey =", value, "rmbkey");
            return (Criteria) this;
        }

        public Criteria andRmbkeyNotEqualTo(String value) {
            addCriterion("rmbKey <>", value, "rmbkey");
            return (Criteria) this;
        }

        public Criteria andRmbkeyGreaterThan(String value) {
            addCriterion("rmbKey >", value, "rmbkey");
            return (Criteria) this;
        }

        public Criteria andRmbkeyGreaterThanOrEqualTo(String value) {
            addCriterion("rmbKey >=", value, "rmbkey");
            return (Criteria) this;
        }

        public Criteria andRmbkeyLessThan(String value) {
            addCriterion("rmbKey <", value, "rmbkey");
            return (Criteria) this;
        }

        public Criteria andRmbkeyLessThanOrEqualTo(String value) {
            addCriterion("rmbKey <=", value, "rmbkey");
            return (Criteria) this;
        }

        public Criteria andRmbkeyLike(String value) {
            addCriterion("rmbKey like", value, "rmbkey");
            return (Criteria) this;
        }

        public Criteria andRmbkeyNotLike(String value) {
            addCriterion("rmbKey not like", value, "rmbkey");
            return (Criteria) this;
        }

        public Criteria andRmbkeyIn(List<String> values) {
            addCriterion("rmbKey in", values, "rmbkey");
            return (Criteria) this;
        }

        public Criteria andRmbkeyNotIn(List<String> values) {
            addCriterion("rmbKey not in", values, "rmbkey");
            return (Criteria) this;
        }

        public Criteria andRmbkeyBetween(String value1, String value2) {
            addCriterion("rmbKey between", value1, value2, "rmbkey");
            return (Criteria) this;
        }

        public Criteria andRmbkeyNotBetween(String value1, String value2) {
            addCriterion("rmbKey not between", value1, value2, "rmbkey");
            return (Criteria) this;
        }

        public Criteria andSafekeyIsNull() {
            addCriterion("safeKey is null");
            return (Criteria) this;
        }

        public Criteria andSafekeyIsNotNull() {
            addCriterion("safeKey is not null");
            return (Criteria) this;
        }

        public Criteria andSafekeyEqualTo(String value) {
            addCriterion("safeKey =", value, "safekey");
            return (Criteria) this;
        }

        public Criteria andSafekeyNotEqualTo(String value) {
            addCriterion("safeKey <>", value, "safekey");
            return (Criteria) this;
        }

        public Criteria andSafekeyGreaterThan(String value) {
            addCriterion("safeKey >", value, "safekey");
            return (Criteria) this;
        }

        public Criteria andSafekeyGreaterThanOrEqualTo(String value) {
            addCriterion("safeKey >=", value, "safekey");
            return (Criteria) this;
        }

        public Criteria andSafekeyLessThan(String value) {
            addCriterion("safeKey <", value, "safekey");
            return (Criteria) this;
        }

        public Criteria andSafekeyLessThanOrEqualTo(String value) {
            addCriterion("safeKey <=", value, "safekey");
            return (Criteria) this;
        }

        public Criteria andSafekeyLike(String value) {
            addCriterion("safeKey like", value, "safekey");
            return (Criteria) this;
        }

        public Criteria andSafekeyNotLike(String value) {
            addCriterion("safeKey not like", value, "safekey");
            return (Criteria) this;
        }

        public Criteria andSafekeyIn(List<String> values) {
            addCriterion("safeKey in", values, "safekey");
            return (Criteria) this;
        }

        public Criteria andSafekeyNotIn(List<String> values) {
            addCriterion("safeKey not in", values, "safekey");
            return (Criteria) this;
        }

        public Criteria andSafekeyBetween(String value1, String value2) {
            addCriterion("safeKey between", value1, value2, "safekey");
            return (Criteria) this;
        }

        public Criteria andSafekeyNotBetween(String value1, String value2) {
            addCriterion("safeKey not between", value1, value2, "safekey");
            return (Criteria) this;
        }

        public Criteria andSellerEmailIsNull() {
            addCriterion("seller_email is null");
            return (Criteria) this;
        }

        public Criteria andSellerEmailIsNotNull() {
            addCriterion("seller_email is not null");
            return (Criteria) this;
        }

        public Criteria andSellerEmailEqualTo(String value) {
            addCriterion("seller_email =", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailNotEqualTo(String value) {
            addCriterion("seller_email <>", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailGreaterThan(String value) {
            addCriterion("seller_email >", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailGreaterThanOrEqualTo(String value) {
            addCriterion("seller_email >=", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailLessThan(String value) {
            addCriterion("seller_email <", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailLessThanOrEqualTo(String value) {
            addCriterion("seller_email <=", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailLike(String value) {
            addCriterion("seller_email like", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailNotLike(String value) {
            addCriterion("seller_email not like", value, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailIn(List<String> values) {
            addCriterion("seller_email in", values, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailNotIn(List<String> values) {
            addCriterion("seller_email not in", values, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailBetween(String value1, String value2) {
            addCriterion("seller_email between", value1, value2, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSellerEmailNotBetween(String value1, String value2) {
            addCriterion("seller_email not between", value1, value2, "sellerEmail");
            return (Criteria) this;
        }

        public Criteria andSpnameIsNull() {
            addCriterion("spname is null");
            return (Criteria) this;
        }

        public Criteria andSpnameIsNotNull() {
            addCriterion("spname is not null");
            return (Criteria) this;
        }

        public Criteria andSpnameEqualTo(String value) {
            addCriterion("spname =", value, "spname");
            return (Criteria) this;
        }

        public Criteria andSpnameNotEqualTo(String value) {
            addCriterion("spname <>", value, "spname");
            return (Criteria) this;
        }

        public Criteria andSpnameGreaterThan(String value) {
            addCriterion("spname >", value, "spname");
            return (Criteria) this;
        }

        public Criteria andSpnameGreaterThanOrEqualTo(String value) {
            addCriterion("spname >=", value, "spname");
            return (Criteria) this;
        }

        public Criteria andSpnameLessThan(String value) {
            addCriterion("spname <", value, "spname");
            return (Criteria) this;
        }

        public Criteria andSpnameLessThanOrEqualTo(String value) {
            addCriterion("spname <=", value, "spname");
            return (Criteria) this;
        }

        public Criteria andSpnameLike(String value) {
            addCriterion("spname like", value, "spname");
            return (Criteria) this;
        }

        public Criteria andSpnameNotLike(String value) {
            addCriterion("spname not like", value, "spname");
            return (Criteria) this;
        }

        public Criteria andSpnameIn(List<String> values) {
            addCriterion("spname in", values, "spname");
            return (Criteria) this;
        }

        public Criteria andSpnameNotIn(List<String> values) {
            addCriterion("spname not in", values, "spname");
            return (Criteria) this;
        }

        public Criteria andSpnameBetween(String value1, String value2) {
            addCriterion("spname between", value1, value2, "spname");
            return (Criteria) this;
        }

        public Criteria andSpnameNotBetween(String value1, String value2) {
            addCriterion("spname not between", value1, value2, "spname");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyIsNull() {
            addCriterion("tenpay_key is null");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyIsNotNull() {
            addCriterion("tenpay_key is not null");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyEqualTo(String value) {
            addCriterion("tenpay_key =", value, "tenpayKey");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyNotEqualTo(String value) {
            addCriterion("tenpay_key <>", value, "tenpayKey");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyGreaterThan(String value) {
            addCriterion("tenpay_key >", value, "tenpayKey");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyGreaterThanOrEqualTo(String value) {
            addCriterion("tenpay_key >=", value, "tenpayKey");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyLessThan(String value) {
            addCriterion("tenpay_key <", value, "tenpayKey");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyLessThanOrEqualTo(String value) {
            addCriterion("tenpay_key <=", value, "tenpayKey");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyLike(String value) {
            addCriterion("tenpay_key like", value, "tenpayKey");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyNotLike(String value) {
            addCriterion("tenpay_key not like", value, "tenpayKey");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyIn(List<String> values) {
            addCriterion("tenpay_key in", values, "tenpayKey");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyNotIn(List<String> values) {
            addCriterion("tenpay_key not in", values, "tenpayKey");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyBetween(String value1, String value2) {
            addCriterion("tenpay_key between", value1, value2, "tenpayKey");
            return (Criteria) this;
        }

        public Criteria andTenpayKeyNotBetween(String value1, String value2) {
            addCriterion("tenpay_key not between", value1, value2, "tenpayKey");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerIsNull() {
            addCriterion("tenpay_partner is null");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerIsNotNull() {
            addCriterion("tenpay_partner is not null");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerEqualTo(String value) {
            addCriterion("tenpay_partner =", value, "tenpayPartner");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerNotEqualTo(String value) {
            addCriterion("tenpay_partner <>", value, "tenpayPartner");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerGreaterThan(String value) {
            addCriterion("tenpay_partner >", value, "tenpayPartner");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerGreaterThanOrEqualTo(String value) {
            addCriterion("tenpay_partner >=", value, "tenpayPartner");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerLessThan(String value) {
            addCriterion("tenpay_partner <", value, "tenpayPartner");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerLessThanOrEqualTo(String value) {
            addCriterion("tenpay_partner <=", value, "tenpayPartner");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerLike(String value) {
            addCriterion("tenpay_partner like", value, "tenpayPartner");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerNotLike(String value) {
            addCriterion("tenpay_partner not like", value, "tenpayPartner");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerIn(List<String> values) {
            addCriterion("tenpay_partner in", values, "tenpayPartner");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerNotIn(List<String> values) {
            addCriterion("tenpay_partner not in", values, "tenpayPartner");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerBetween(String value1, String value2) {
            addCriterion("tenpay_partner between", value1, value2, "tenpayPartner");
            return (Criteria) this;
        }

        public Criteria andTenpayPartnerNotBetween(String value1, String value2) {
            addCriterion("tenpay_partner not between", value1, value2, "tenpayPartner");
            return (Criteria) this;
        }

        public Criteria andTradeModeIsNull() {
            addCriterion("trade_mode is null");
            return (Criteria) this;
        }

        public Criteria andTradeModeIsNotNull() {
            addCriterion("trade_mode is not null");
            return (Criteria) this;
        }

        public Criteria andTradeModeEqualTo(Integer value) {
            addCriterion("trade_mode =", value, "tradeMode");
            return (Criteria) this;
        }

        public Criteria andTradeModeNotEqualTo(Integer value) {
            addCriterion("trade_mode <>", value, "tradeMode");
            return (Criteria) this;
        }

        public Criteria andTradeModeGreaterThan(Integer value) {
            addCriterion("trade_mode >", value, "tradeMode");
            return (Criteria) this;
        }

        public Criteria andTradeModeGreaterThanOrEqualTo(Integer value) {
            addCriterion("trade_mode >=", value, "tradeMode");
            return (Criteria) this;
        }

        public Criteria andTradeModeLessThan(Integer value) {
            addCriterion("trade_mode <", value, "tradeMode");
            return (Criteria) this;
        }

        public Criteria andTradeModeLessThanOrEqualTo(Integer value) {
            addCriterion("trade_mode <=", value, "tradeMode");
            return (Criteria) this;
        }

        public Criteria andTradeModeIn(List<Integer> values) {
            addCriterion("trade_mode in", values, "tradeMode");
            return (Criteria) this;
        }

        public Criteria andTradeModeNotIn(List<Integer> values) {
            addCriterion("trade_mode not in", values, "tradeMode");
            return (Criteria) this;
        }

        public Criteria andTradeModeBetween(Integer value1, Integer value2) {
            addCriterion("trade_mode between", value1, value2, "tradeMode");
            return (Criteria) this;
        }

        public Criteria andTradeModeNotBetween(Integer value1, Integer value2) {
            addCriterion("trade_mode not between", value1, value2, "tradeMode");
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

        public Criteria andStoreIdIsNull() {
            addCriterion("store_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreIdIsNotNull() {
            addCriterion("store_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreIdEqualTo(Long value) {
            addCriterion("store_id =", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotEqualTo(Long value) {
            addCriterion("store_id <>", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThan(Long value) {
            addCriterion("store_id >", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdGreaterThanOrEqualTo(Long value) {
            addCriterion("store_id >=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThan(Long value) {
            addCriterion("store_id <", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdLessThanOrEqualTo(Long value) {
            addCriterion("store_id <=", value, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdIn(List<Long> values) {
            addCriterion("store_id in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotIn(List<Long> values) {
            addCriterion("store_id not in", values, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdBetween(Long value1, Long value2) {
            addCriterion("store_id between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andStoreIdNotBetween(Long value1, Long value2) {
            addCriterion("store_id not between", value1, value2, "storeId");
            return (Criteria) this;
        }

        public Criteria andAlipayDivideRateIsNull() {
            addCriterion("alipay_divide_rate is null");
            return (Criteria) this;
        }

        public Criteria andAlipayDivideRateIsNotNull() {
            addCriterion("alipay_divide_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayDivideRateEqualTo(BigDecimal value) {
            addCriterion("alipay_divide_rate =", value, "alipayDivideRate");
            return (Criteria) this;
        }

        public Criteria andAlipayDivideRateNotEqualTo(BigDecimal value) {
            addCriterion("alipay_divide_rate <>", value, "alipayDivideRate");
            return (Criteria) this;
        }

        public Criteria andAlipayDivideRateGreaterThan(BigDecimal value) {
            addCriterion("alipay_divide_rate >", value, "alipayDivideRate");
            return (Criteria) this;
        }

        public Criteria andAlipayDivideRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("alipay_divide_rate >=", value, "alipayDivideRate");
            return (Criteria) this;
        }

        public Criteria andAlipayDivideRateLessThan(BigDecimal value) {
            addCriterion("alipay_divide_rate <", value, "alipayDivideRate");
            return (Criteria) this;
        }

        public Criteria andAlipayDivideRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("alipay_divide_rate <=", value, "alipayDivideRate");
            return (Criteria) this;
        }

        public Criteria andAlipayDivideRateIn(List<BigDecimal> values) {
            addCriterion("alipay_divide_rate in", values, "alipayDivideRate");
            return (Criteria) this;
        }

        public Criteria andAlipayDivideRateNotIn(List<BigDecimal> values) {
            addCriterion("alipay_divide_rate not in", values, "alipayDivideRate");
            return (Criteria) this;
        }

        public Criteria andAlipayDivideRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("alipay_divide_rate between", value1, value2, "alipayDivideRate");
            return (Criteria) this;
        }

        public Criteria andAlipayDivideRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("alipay_divide_rate not between", value1, value2, "alipayDivideRate");
            return (Criteria) this;
        }

        public Criteria andAlipayRateIsNull() {
            addCriterion("alipay_rate is null");
            return (Criteria) this;
        }

        public Criteria andAlipayRateIsNotNull() {
            addCriterion("alipay_rate is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayRateEqualTo(BigDecimal value) {
            addCriterion("alipay_rate =", value, "alipayRate");
            return (Criteria) this;
        }

        public Criteria andAlipayRateNotEqualTo(BigDecimal value) {
            addCriterion("alipay_rate <>", value, "alipayRate");
            return (Criteria) this;
        }

        public Criteria andAlipayRateGreaterThan(BigDecimal value) {
            addCriterion("alipay_rate >", value, "alipayRate");
            return (Criteria) this;
        }

        public Criteria andAlipayRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("alipay_rate >=", value, "alipayRate");
            return (Criteria) this;
        }

        public Criteria andAlipayRateLessThan(BigDecimal value) {
            addCriterion("alipay_rate <", value, "alipayRate");
            return (Criteria) this;
        }

        public Criteria andAlipayRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("alipay_rate <=", value, "alipayRate");
            return (Criteria) this;
        }

        public Criteria andAlipayRateIn(List<BigDecimal> values) {
            addCriterion("alipay_rate in", values, "alipayRate");
            return (Criteria) this;
        }

        public Criteria andAlipayRateNotIn(List<BigDecimal> values) {
            addCriterion("alipay_rate not in", values, "alipayRate");
            return (Criteria) this;
        }

        public Criteria andAlipayRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("alipay_rate between", value1, value2, "alipayRate");
            return (Criteria) this;
        }

        public Criteria andAlipayRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("alipay_rate not between", value1, value2, "alipayRate");
            return (Criteria) this;
        }

        public Criteria andBalanceDivideRateIsNull() {
            addCriterion("balance_divide_rate is null");
            return (Criteria) this;
        }

        public Criteria andBalanceDivideRateIsNotNull() {
            addCriterion("balance_divide_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceDivideRateEqualTo(BigDecimal value) {
            addCriterion("balance_divide_rate =", value, "balanceDivideRate");
            return (Criteria) this;
        }

        public Criteria andBalanceDivideRateNotEqualTo(BigDecimal value) {
            addCriterion("balance_divide_rate <>", value, "balanceDivideRate");
            return (Criteria) this;
        }

        public Criteria andBalanceDivideRateGreaterThan(BigDecimal value) {
            addCriterion("balance_divide_rate >", value, "balanceDivideRate");
            return (Criteria) this;
        }

        public Criteria andBalanceDivideRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_divide_rate >=", value, "balanceDivideRate");
            return (Criteria) this;
        }

        public Criteria andBalanceDivideRateLessThan(BigDecimal value) {
            addCriterion("balance_divide_rate <", value, "balanceDivideRate");
            return (Criteria) this;
        }

        public Criteria andBalanceDivideRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("balance_divide_rate <=", value, "balanceDivideRate");
            return (Criteria) this;
        }

        public Criteria andBalanceDivideRateIn(List<BigDecimal> values) {
            addCriterion("balance_divide_rate in", values, "balanceDivideRate");
            return (Criteria) this;
        }

        public Criteria andBalanceDivideRateNotIn(List<BigDecimal> values) {
            addCriterion("balance_divide_rate not in", values, "balanceDivideRate");
            return (Criteria) this;
        }

        public Criteria andBalanceDivideRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_divide_rate between", value1, value2, "balanceDivideRate");
            return (Criteria) this;
        }

        public Criteria andBalanceDivideRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("balance_divide_rate not between", value1, value2, "balanceDivideRate");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIsNull() {
            addCriterion("currency_code is null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIsNotNull() {
            addCriterion("currency_code is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeEqualTo(String value) {
            addCriterion("currency_code =", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotEqualTo(String value) {
            addCriterion("currency_code <>", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThan(String value) {
            addCriterion("currency_code >", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeGreaterThanOrEqualTo(String value) {
            addCriterion("currency_code >=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThan(String value) {
            addCriterion("currency_code <", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLessThanOrEqualTo(String value) {
            addCriterion("currency_code <=", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeLike(String value) {
            addCriterion("currency_code like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotLike(String value) {
            addCriterion("currency_code not like", value, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeIn(List<String> values) {
            addCriterion("currency_code in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotIn(List<String> values) {
            addCriterion("currency_code not in", values, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeBetween(String value1, String value2) {
            addCriterion("currency_code between", value1, value2, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andCurrencyCodeNotBetween(String value1, String value2) {
            addCriterion("currency_code not between", value1, value2, "currencyCode");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridIsNull() {
            addCriterion("paypal_userId is null");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridIsNotNull() {
            addCriterion("paypal_userId is not null");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridEqualTo(String value) {
            addCriterion("paypal_userId =", value, "paypalUserid");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridNotEqualTo(String value) {
            addCriterion("paypal_userId <>", value, "paypalUserid");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridGreaterThan(String value) {
            addCriterion("paypal_userId >", value, "paypalUserid");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridGreaterThanOrEqualTo(String value) {
            addCriterion("paypal_userId >=", value, "paypalUserid");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridLessThan(String value) {
            addCriterion("paypal_userId <", value, "paypalUserid");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridLessThanOrEqualTo(String value) {
            addCriterion("paypal_userId <=", value, "paypalUserid");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridLike(String value) {
            addCriterion("paypal_userId like", value, "paypalUserid");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridNotLike(String value) {
            addCriterion("paypal_userId not like", value, "paypalUserid");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridIn(List<String> values) {
            addCriterion("paypal_userId in", values, "paypalUserid");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridNotIn(List<String> values) {
            addCriterion("paypal_userId not in", values, "paypalUserid");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridBetween(String value1, String value2) {
            addCriterion("paypal_userId between", value1, value2, "paypalUserid");
            return (Criteria) this;
        }

        public Criteria andPaypalUseridNotBetween(String value1, String value2) {
            addCriterion("paypal_userId not between", value1, value2, "paypalUserid");
            return (Criteria) this;
        }

        public Criteria andPoundageIsNull() {
            addCriterion("poundage is null");
            return (Criteria) this;
        }

        public Criteria andPoundageIsNotNull() {
            addCriterion("poundage is not null");
            return (Criteria) this;
        }

        public Criteria andPoundageEqualTo(BigDecimal value) {
            addCriterion("poundage =", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageNotEqualTo(BigDecimal value) {
            addCriterion("poundage <>", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageGreaterThan(BigDecimal value) {
            addCriterion("poundage >", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("poundage >=", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageLessThan(BigDecimal value) {
            addCriterion("poundage <", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("poundage <=", value, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageIn(List<BigDecimal> values) {
            addCriterion("poundage in", values, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageNotIn(List<BigDecimal> values) {
            addCriterion("poundage not in", values, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("poundage between", value1, value2, "poundage");
            return (Criteria) this;
        }

        public Criteria andPoundageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("poundage not between", value1, value2, "poundage");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyIsNull() {
            addCriterion("lzbank_key is null");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyIsNotNull() {
            addCriterion("lzbank_key is not null");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyEqualTo(String value) {
            addCriterion("lzbank_key =", value, "lzbankKey");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyNotEqualTo(String value) {
            addCriterion("lzbank_key <>", value, "lzbankKey");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyGreaterThan(String value) {
            addCriterion("lzbank_key >", value, "lzbankKey");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyGreaterThanOrEqualTo(String value) {
            addCriterion("lzbank_key >=", value, "lzbankKey");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyLessThan(String value) {
            addCriterion("lzbank_key <", value, "lzbankKey");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyLessThanOrEqualTo(String value) {
            addCriterion("lzbank_key <=", value, "lzbankKey");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyLike(String value) {
            addCriterion("lzbank_key like", value, "lzbankKey");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyNotLike(String value) {
            addCriterion("lzbank_key not like", value, "lzbankKey");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyIn(List<String> values) {
            addCriterion("lzbank_key in", values, "lzbankKey");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyNotIn(List<String> values) {
            addCriterion("lzbank_key not in", values, "lzbankKey");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyBetween(String value1, String value2) {
            addCriterion("lzbank_key between", value1, value2, "lzbankKey");
            return (Criteria) this;
        }

        public Criteria andLzbankKeyNotBetween(String value1, String value2) {
            addCriterion("lzbank_key not between", value1, value2, "lzbankKey");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerIsNull() {
            addCriterion("lzbank_partner is null");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerIsNotNull() {
            addCriterion("lzbank_partner is not null");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerEqualTo(String value) {
            addCriterion("lzbank_partner =", value, "lzbankPartner");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerNotEqualTo(String value) {
            addCriterion("lzbank_partner <>", value, "lzbankPartner");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerGreaterThan(String value) {
            addCriterion("lzbank_partner >", value, "lzbankPartner");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerGreaterThanOrEqualTo(String value) {
            addCriterion("lzbank_partner >=", value, "lzbankPartner");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerLessThan(String value) {
            addCriterion("lzbank_partner <", value, "lzbankPartner");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerLessThanOrEqualTo(String value) {
            addCriterion("lzbank_partner <=", value, "lzbankPartner");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerLike(String value) {
            addCriterion("lzbank_partner like", value, "lzbankPartner");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerNotLike(String value) {
            addCriterion("lzbank_partner not like", value, "lzbankPartner");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerIn(List<String> values) {
            addCriterion("lzbank_partner in", values, "lzbankPartner");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerNotIn(List<String> values) {
            addCriterion("lzbank_partner not in", values, "lzbankPartner");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerBetween(String value1, String value2) {
            addCriterion("lzbank_partner between", value1, value2, "lzbankPartner");
            return (Criteria) this;
        }

        public Criteria andLzbankPartnerNotBetween(String value1, String value2) {
            addCriterion("lzbank_partner not between", value1, value2, "lzbankPartner");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeIsNull() {
            addCriterion("lzbank_trade_mode is null");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeIsNotNull() {
            addCriterion("lzbank_trade_mode is not null");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeEqualTo(String value) {
            addCriterion("lzbank_trade_mode =", value, "lzbankTradeMode");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeNotEqualTo(String value) {
            addCriterion("lzbank_trade_mode <>", value, "lzbankTradeMode");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeGreaterThan(String value) {
            addCriterion("lzbank_trade_mode >", value, "lzbankTradeMode");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeGreaterThanOrEqualTo(String value) {
            addCriterion("lzbank_trade_mode >=", value, "lzbankTradeMode");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeLessThan(String value) {
            addCriterion("lzbank_trade_mode <", value, "lzbankTradeMode");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeLessThanOrEqualTo(String value) {
            addCriterion("lzbank_trade_mode <=", value, "lzbankTradeMode");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeLike(String value) {
            addCriterion("lzbank_trade_mode like", value, "lzbankTradeMode");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeNotLike(String value) {
            addCriterion("lzbank_trade_mode not like", value, "lzbankTradeMode");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeIn(List<String> values) {
            addCriterion("lzbank_trade_mode in", values, "lzbankTradeMode");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeNotIn(List<String> values) {
            addCriterion("lzbank_trade_mode not in", values, "lzbankTradeMode");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeBetween(String value1, String value2) {
            addCriterion("lzbank_trade_mode between", value1, value2, "lzbankTradeMode");
            return (Criteria) this;
        }

        public Criteria andLzbankTradeModeNotBetween(String value1, String value2) {
            addCriterion("lzbank_trade_mode not between", value1, value2, "lzbankTradeMode");
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