package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class SysConfigExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysConfigExample() {
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

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andBigheightIsNull() {
            addCriterion("bigHeight is null");
            return (Criteria) this;
        }

        public Criteria andBigheightIsNotNull() {
            addCriterion("bigHeight is not null");
            return (Criteria) this;
        }

        public Criteria andBigheightEqualTo(Integer value) {
            addCriterion("bigHeight =", value, "bigheight");
            return (Criteria) this;
        }

        public Criteria andBigheightNotEqualTo(Integer value) {
            addCriterion("bigHeight <>", value, "bigheight");
            return (Criteria) this;
        }

        public Criteria andBigheightGreaterThan(Integer value) {
            addCriterion("bigHeight >", value, "bigheight");
            return (Criteria) this;
        }

        public Criteria andBigheightGreaterThanOrEqualTo(Integer value) {
            addCriterion("bigHeight >=", value, "bigheight");
            return (Criteria) this;
        }

        public Criteria andBigheightLessThan(Integer value) {
            addCriterion("bigHeight <", value, "bigheight");
            return (Criteria) this;
        }

        public Criteria andBigheightLessThanOrEqualTo(Integer value) {
            addCriterion("bigHeight <=", value, "bigheight");
            return (Criteria) this;
        }

        public Criteria andBigheightIn(List<Integer> values) {
            addCriterion("bigHeight in", values, "bigheight");
            return (Criteria) this;
        }

        public Criteria andBigheightNotIn(List<Integer> values) {
            addCriterion("bigHeight not in", values, "bigheight");
            return (Criteria) this;
        }

        public Criteria andBigheightBetween(Integer value1, Integer value2) {
            addCriterion("bigHeight between", value1, value2, "bigheight");
            return (Criteria) this;
        }

        public Criteria andBigheightNotBetween(Integer value1, Integer value2) {
            addCriterion("bigHeight not between", value1, value2, "bigheight");
            return (Criteria) this;
        }

        public Criteria andBigwidthIsNull() {
            addCriterion("bigWidth is null");
            return (Criteria) this;
        }

        public Criteria andBigwidthIsNotNull() {
            addCriterion("bigWidth is not null");
            return (Criteria) this;
        }

        public Criteria andBigwidthEqualTo(Integer value) {
            addCriterion("bigWidth =", value, "bigwidth");
            return (Criteria) this;
        }

        public Criteria andBigwidthNotEqualTo(Integer value) {
            addCriterion("bigWidth <>", value, "bigwidth");
            return (Criteria) this;
        }

        public Criteria andBigwidthGreaterThan(Integer value) {
            addCriterion("bigWidth >", value, "bigwidth");
            return (Criteria) this;
        }

        public Criteria andBigwidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("bigWidth >=", value, "bigwidth");
            return (Criteria) this;
        }

        public Criteria andBigwidthLessThan(Integer value) {
            addCriterion("bigWidth <", value, "bigwidth");
            return (Criteria) this;
        }

        public Criteria andBigwidthLessThanOrEqualTo(Integer value) {
            addCriterion("bigWidth <=", value, "bigwidth");
            return (Criteria) this;
        }

        public Criteria andBigwidthIn(List<Integer> values) {
            addCriterion("bigWidth in", values, "bigwidth");
            return (Criteria) this;
        }

        public Criteria andBigwidthNotIn(List<Integer> values) {
            addCriterion("bigWidth not in", values, "bigwidth");
            return (Criteria) this;
        }

        public Criteria andBigwidthBetween(Integer value1, Integer value2) {
            addCriterion("bigWidth between", value1, value2, "bigwidth");
            return (Criteria) this;
        }

        public Criteria andBigwidthNotBetween(Integer value1, Integer value2) {
            addCriterion("bigWidth not between", value1, value2, "bigwidth");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeIsNull() {
            addCriterion("complaint_time is null");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeIsNotNull() {
            addCriterion("complaint_time is not null");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeEqualTo(Integer value) {
            addCriterion("complaint_time =", value, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeNotEqualTo(Integer value) {
            addCriterion("complaint_time <>", value, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeGreaterThan(Integer value) {
            addCriterion("complaint_time >", value, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("complaint_time >=", value, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeLessThan(Integer value) {
            addCriterion("complaint_time <", value, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeLessThanOrEqualTo(Integer value) {
            addCriterion("complaint_time <=", value, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeIn(List<Integer> values) {
            addCriterion("complaint_time in", values, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeNotIn(List<Integer> values) {
            addCriterion("complaint_time not in", values, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeBetween(Integer value1, Integer value2) {
            addCriterion("complaint_time between", value1, value2, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andComplaintTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("complaint_time not between", value1, value2, "complaintTime");
            return (Criteria) this;
        }

        public Criteria andConsumptionratioIsNull() {
            addCriterion("consumptionRatio is null");
            return (Criteria) this;
        }

        public Criteria andConsumptionratioIsNotNull() {
            addCriterion("consumptionRatio is not null");
            return (Criteria) this;
        }

        public Criteria andConsumptionratioEqualTo(Integer value) {
            addCriterion("consumptionRatio =", value, "consumptionratio");
            return (Criteria) this;
        }

        public Criteria andConsumptionratioNotEqualTo(Integer value) {
            addCriterion("consumptionRatio <>", value, "consumptionratio");
            return (Criteria) this;
        }

        public Criteria andConsumptionratioGreaterThan(Integer value) {
            addCriterion("consumptionRatio >", value, "consumptionratio");
            return (Criteria) this;
        }

        public Criteria andConsumptionratioGreaterThanOrEqualTo(Integer value) {
            addCriterion("consumptionRatio >=", value, "consumptionratio");
            return (Criteria) this;
        }

        public Criteria andConsumptionratioLessThan(Integer value) {
            addCriterion("consumptionRatio <", value, "consumptionratio");
            return (Criteria) this;
        }

        public Criteria andConsumptionratioLessThanOrEqualTo(Integer value) {
            addCriterion("consumptionRatio <=", value, "consumptionratio");
            return (Criteria) this;
        }

        public Criteria andConsumptionratioIn(List<Integer> values) {
            addCriterion("consumptionRatio in", values, "consumptionratio");
            return (Criteria) this;
        }

        public Criteria andConsumptionratioNotIn(List<Integer> values) {
            addCriterion("consumptionRatio not in", values, "consumptionratio");
            return (Criteria) this;
        }

        public Criteria andConsumptionratioBetween(Integer value1, Integer value2) {
            addCriterion("consumptionRatio between", value1, value2, "consumptionratio");
            return (Criteria) this;
        }

        public Criteria andConsumptionratioNotBetween(Integer value1, Integer value2) {
            addCriterion("consumptionRatio not between", value1, value2, "consumptionratio");
            return (Criteria) this;
        }

        public Criteria andSmsSendIntervalIsNull() {
            addCriterion("sms_send_interval is null");
            return (Criteria) this;
        }

        public Criteria andSmsSendIntervalIsNotNull() {
            addCriterion("sms_send_interval is not null");
            return (Criteria) this;
        }

        public Criteria andSmsSendIntervalEqualTo(Integer value) {
            addCriterion("sms_send_interval =", value, "smsSendInterval");
            return (Criteria) this;
        }

        public Criteria andSmsSendIntervalNotEqualTo(Integer value) {
            addCriterion("sms_send_interval <>", value, "smsSendInterval");
            return (Criteria) this;
        }

        public Criteria andSmsSendIntervalGreaterThan(Integer value) {
            addCriterion("sms_send_interval >", value, "smsSendInterval");
            return (Criteria) this;
        }

        public Criteria andSmsSendIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("sms_send_interval >=", value, "smsSendInterval");
            return (Criteria) this;
        }

        public Criteria andSmsSendIntervalLessThan(Integer value) {
            addCriterion("sms_send_interval <", value, "smsSendInterval");
            return (Criteria) this;
        }

        public Criteria andSmsSendIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("sms_send_interval <=", value, "smsSendInterval");
            return (Criteria) this;
        }

        public Criteria andSmsSendIntervalIn(List<Integer> values) {
            addCriterion("sms_send_interval in", values, "smsSendInterval");
            return (Criteria) this;
        }

        public Criteria andSmsSendIntervalNotIn(List<Integer> values) {
            addCriterion("sms_send_interval not in", values, "smsSendInterval");
            return (Criteria) this;
        }

        public Criteria andSmsSendIntervalBetween(Integer value1, Integer value2) {
            addCriterion("sms_send_interval between", value1, value2, "smsSendInterval");
            return (Criteria) this;
        }

        public Criteria andSmsSendIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("sms_send_interval not between", value1, value2, "smsSendInterval");
            return (Criteria) this;
        }
        
        public Criteria andCopyrightIsNull() {
            addCriterion("copyRight is null");
            return (Criteria) this;
        }

        public Criteria andCopyrightIsNotNull() {
            addCriterion("copyRight is not null");
            return (Criteria) this;
        }

        public Criteria andCopyrightEqualTo(String value) {
            addCriterion("copyRight =", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightNotEqualTo(String value) {
            addCriterion("copyRight <>", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightGreaterThan(String value) {
            addCriterion("copyRight >", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightGreaterThanOrEqualTo(String value) {
            addCriterion("copyRight >=", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightLessThan(String value) {
            addCriterion("copyRight <", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightLessThanOrEqualTo(String value) {
            addCriterion("copyRight <=", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightLike(String value) {
            addCriterion("copyRight like", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightNotLike(String value) {
            addCriterion("copyRight not like", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightIn(List<String> values) {
            addCriterion("copyRight in", values, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightNotIn(List<String> values) {
            addCriterion("copyRight not in", values, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightBetween(String value1, String value2) {
            addCriterion("copyRight between", value1, value2, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightNotBetween(String value1, String value2) {
            addCriterion("copyRight not between", value1, value2, "copyright");
            return (Criteria) this;
        }

        public Criteria andDepositIsNull() {
            addCriterion("deposit is null");
            return (Criteria) this;
        }

        public Criteria andDepositIsNotNull() {
            addCriterion("deposit is not null");
            return (Criteria) this;
        }

        public Criteria andDepositEqualTo(Boolean value) {
            addCriterion("deposit =", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotEqualTo(Boolean value) {
            addCriterion("deposit <>", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThan(Boolean value) {
            addCriterion("deposit >", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deposit >=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThan(Boolean value) {
            addCriterion("deposit <", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositLessThanOrEqualTo(Boolean value) {
            addCriterion("deposit <=", value, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositIn(List<Boolean> values) {
            addCriterion("deposit in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotIn(List<Boolean> values) {
            addCriterion("deposit not in", values, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositBetween(Boolean value1, Boolean value2) {
            addCriterion("deposit between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDepositNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deposit not between", value1, value2, "deposit");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andEmailenableIsNull() {
            addCriterion("emailEnable is null");
            return (Criteria) this;
        }

        public Criteria andEmailenableIsNotNull() {
            addCriterion("emailEnable is not null");
            return (Criteria) this;
        }

        public Criteria andEmailenableEqualTo(Boolean value) {
            addCriterion("emailEnable =", value, "emailenable");
            return (Criteria) this;
        }

        public Criteria andEmailenableNotEqualTo(Boolean value) {
            addCriterion("emailEnable <>", value, "emailenable");
            return (Criteria) this;
        }

        public Criteria andEmailenableGreaterThan(Boolean value) {
            addCriterion("emailEnable >", value, "emailenable");
            return (Criteria) this;
        }

        public Criteria andEmailenableGreaterThanOrEqualTo(Boolean value) {
            addCriterion("emailEnable >=", value, "emailenable");
            return (Criteria) this;
        }

        public Criteria andEmailenableLessThan(Boolean value) {
            addCriterion("emailEnable <", value, "emailenable");
            return (Criteria) this;
        }

        public Criteria andEmailenableLessThanOrEqualTo(Boolean value) {
            addCriterion("emailEnable <=", value, "emailenable");
            return (Criteria) this;
        }

        public Criteria andEmailenableIn(List<Boolean> values) {
            addCriterion("emailEnable in", values, "emailenable");
            return (Criteria) this;
        }

        public Criteria andEmailenableNotIn(List<Boolean> values) {
            addCriterion("emailEnable not in", values, "emailenable");
            return (Criteria) this;
        }

        public Criteria andEmailenableBetween(Boolean value1, Boolean value2) {
            addCriterion("emailEnable between", value1, value2, "emailenable");
            return (Criteria) this;
        }

        public Criteria andEmailenableNotBetween(Boolean value1, Boolean value2) {
            addCriterion("emailEnable not between", value1, value2, "emailenable");
            return (Criteria) this;
        }

        public Criteria andEmailhostIsNull() {
            addCriterion("emailHost is null");
            return (Criteria) this;
        }

        public Criteria andEmailhostIsNotNull() {
            addCriterion("emailHost is not null");
            return (Criteria) this;
        }

        public Criteria andEmailhostEqualTo(String value) {
            addCriterion("emailHost =", value, "emailhost");
            return (Criteria) this;
        }

        public Criteria andEmailhostNotEqualTo(String value) {
            addCriterion("emailHost <>", value, "emailhost");
            return (Criteria) this;
        }

        public Criteria andEmailhostGreaterThan(String value) {
            addCriterion("emailHost >", value, "emailhost");
            return (Criteria) this;
        }

        public Criteria andEmailhostGreaterThanOrEqualTo(String value) {
            addCriterion("emailHost >=", value, "emailhost");
            return (Criteria) this;
        }

        public Criteria andEmailhostLessThan(String value) {
            addCriterion("emailHost <", value, "emailhost");
            return (Criteria) this;
        }

        public Criteria andEmailhostLessThanOrEqualTo(String value) {
            addCriterion("emailHost <=", value, "emailhost");
            return (Criteria) this;
        }

        public Criteria andEmailhostLike(String value) {
            addCriterion("emailHost like", value, "emailhost");
            return (Criteria) this;
        }

        public Criteria andEmailhostNotLike(String value) {
            addCriterion("emailHost not like", value, "emailhost");
            return (Criteria) this;
        }

        public Criteria andEmailhostIn(List<String> values) {
            addCriterion("emailHost in", values, "emailhost");
            return (Criteria) this;
        }

        public Criteria andEmailhostNotIn(List<String> values) {
            addCriterion("emailHost not in", values, "emailhost");
            return (Criteria) this;
        }

        public Criteria andEmailhostBetween(String value1, String value2) {
            addCriterion("emailHost between", value1, value2, "emailhost");
            return (Criteria) this;
        }

        public Criteria andEmailhostNotBetween(String value1, String value2) {
            addCriterion("emailHost not between", value1, value2, "emailhost");
            return (Criteria) this;
        }

        public Criteria andEmailportIsNull() {
            addCriterion("emailPort is null");
            return (Criteria) this;
        }

        public Criteria andEmailportIsNotNull() {
            addCriterion("emailPort is not null");
            return (Criteria) this;
        }

        public Criteria andEmailportEqualTo(Integer value) {
            addCriterion("emailPort =", value, "emailport");
            return (Criteria) this;
        }

        public Criteria andEmailportNotEqualTo(Integer value) {
            addCriterion("emailPort <>", value, "emailport");
            return (Criteria) this;
        }

        public Criteria andEmailportGreaterThan(Integer value) {
            addCriterion("emailPort >", value, "emailport");
            return (Criteria) this;
        }

        public Criteria andEmailportGreaterThanOrEqualTo(Integer value) {
            addCriterion("emailPort >=", value, "emailport");
            return (Criteria) this;
        }

        public Criteria andEmailportLessThan(Integer value) {
            addCriterion("emailPort <", value, "emailport");
            return (Criteria) this;
        }

        public Criteria andEmailportLessThanOrEqualTo(Integer value) {
            addCriterion("emailPort <=", value, "emailport");
            return (Criteria) this;
        }

        public Criteria andEmailportIn(List<Integer> values) {
            addCriterion("emailPort in", values, "emailport");
            return (Criteria) this;
        }

        public Criteria andEmailportNotIn(List<Integer> values) {
            addCriterion("emailPort not in", values, "emailport");
            return (Criteria) this;
        }

        public Criteria andEmailportBetween(Integer value1, Integer value2) {
            addCriterion("emailPort between", value1, value2, "emailport");
            return (Criteria) this;
        }

        public Criteria andEmailportNotBetween(Integer value1, Integer value2) {
            addCriterion("emailPort not between", value1, value2, "emailport");
            return (Criteria) this;
        }

        public Criteria andEmailpwsIsNull() {
            addCriterion("emailPws is null");
            return (Criteria) this;
        }

        public Criteria andEmailpwsIsNotNull() {
            addCriterion("emailPws is not null");
            return (Criteria) this;
        }

        public Criteria andEmailpwsEqualTo(String value) {
            addCriterion("emailPws =", value, "emailpws");
            return (Criteria) this;
        }

        public Criteria andEmailpwsNotEqualTo(String value) {
            addCriterion("emailPws <>", value, "emailpws");
            return (Criteria) this;
        }

        public Criteria andEmailpwsGreaterThan(String value) {
            addCriterion("emailPws >", value, "emailpws");
            return (Criteria) this;
        }

        public Criteria andEmailpwsGreaterThanOrEqualTo(String value) {
            addCriterion("emailPws >=", value, "emailpws");
            return (Criteria) this;
        }

        public Criteria andEmailpwsLessThan(String value) {
            addCriterion("emailPws <", value, "emailpws");
            return (Criteria) this;
        }

        public Criteria andEmailpwsLessThanOrEqualTo(String value) {
            addCriterion("emailPws <=", value, "emailpws");
            return (Criteria) this;
        }

        public Criteria andEmailpwsLike(String value) {
            addCriterion("emailPws like", value, "emailpws");
            return (Criteria) this;
        }

        public Criteria andEmailpwsNotLike(String value) {
            addCriterion("emailPws not like", value, "emailpws");
            return (Criteria) this;
        }

        public Criteria andEmailpwsIn(List<String> values) {
            addCriterion("emailPws in", values, "emailpws");
            return (Criteria) this;
        }

        public Criteria andEmailpwsNotIn(List<String> values) {
            addCriterion("emailPws not in", values, "emailpws");
            return (Criteria) this;
        }

        public Criteria andEmailpwsBetween(String value1, String value2) {
            addCriterion("emailPws between", value1, value2, "emailpws");
            return (Criteria) this;
        }

        public Criteria andEmailpwsNotBetween(String value1, String value2) {
            addCriterion("emailPws not between", value1, value2, "emailpws");
            return (Criteria) this;
        }

        public Criteria andEmailtestIsNull() {
            addCriterion("emailTest is null");
            return (Criteria) this;
        }

        public Criteria andEmailtestIsNotNull() {
            addCriterion("emailTest is not null");
            return (Criteria) this;
        }

        public Criteria andEmailtestEqualTo(String value) {
            addCriterion("emailTest =", value, "emailtest");
            return (Criteria) this;
        }

        public Criteria andEmailtestNotEqualTo(String value) {
            addCriterion("emailTest <>", value, "emailtest");
            return (Criteria) this;
        }

        public Criteria andEmailtestGreaterThan(String value) {
            addCriterion("emailTest >", value, "emailtest");
            return (Criteria) this;
        }

        public Criteria andEmailtestGreaterThanOrEqualTo(String value) {
            addCriterion("emailTest >=", value, "emailtest");
            return (Criteria) this;
        }

        public Criteria andEmailtestLessThan(String value) {
            addCriterion("emailTest <", value, "emailtest");
            return (Criteria) this;
        }

        public Criteria andEmailtestLessThanOrEqualTo(String value) {
            addCriterion("emailTest <=", value, "emailtest");
            return (Criteria) this;
        }

        public Criteria andEmailtestLike(String value) {
            addCriterion("emailTest like", value, "emailtest");
            return (Criteria) this;
        }

        public Criteria andEmailtestNotLike(String value) {
            addCriterion("emailTest not like", value, "emailtest");
            return (Criteria) this;
        }

        public Criteria andEmailtestIn(List<String> values) {
            addCriterion("emailTest in", values, "emailtest");
            return (Criteria) this;
        }

        public Criteria andEmailtestNotIn(List<String> values) {
            addCriterion("emailTest not in", values, "emailtest");
            return (Criteria) this;
        }

        public Criteria andEmailtestBetween(String value1, String value2) {
            addCriterion("emailTest between", value1, value2, "emailtest");
            return (Criteria) this;
        }

        public Criteria andEmailtestNotBetween(String value1, String value2) {
            addCriterion("emailTest not between", value1, value2, "emailtest");
            return (Criteria) this;
        }

        public Criteria andEmailuserIsNull() {
            addCriterion("emailUser is null");
            return (Criteria) this;
        }

        public Criteria andEmailuserIsNotNull() {
            addCriterion("emailUser is not null");
            return (Criteria) this;
        }

        public Criteria andEmailuserEqualTo(String value) {
            addCriterion("emailUser =", value, "emailuser");
            return (Criteria) this;
        }

        public Criteria andEmailuserNotEqualTo(String value) {
            addCriterion("emailUser <>", value, "emailuser");
            return (Criteria) this;
        }

        public Criteria andEmailuserGreaterThan(String value) {
            addCriterion("emailUser >", value, "emailuser");
            return (Criteria) this;
        }

        public Criteria andEmailuserGreaterThanOrEqualTo(String value) {
            addCriterion("emailUser >=", value, "emailuser");
            return (Criteria) this;
        }

        public Criteria andEmailuserLessThan(String value) {
            addCriterion("emailUser <", value, "emailuser");
            return (Criteria) this;
        }

        public Criteria andEmailuserLessThanOrEqualTo(String value) {
            addCriterion("emailUser <=", value, "emailuser");
            return (Criteria) this;
        }

        public Criteria andEmailuserLike(String value) {
            addCriterion("emailUser like", value, "emailuser");
            return (Criteria) this;
        }

        public Criteria andEmailuserNotLike(String value) {
            addCriterion("emailUser not like", value, "emailuser");
            return (Criteria) this;
        }

        public Criteria andEmailuserIn(List<String> values) {
            addCriterion("emailUser in", values, "emailuser");
            return (Criteria) this;
        }

        public Criteria andEmailuserNotIn(List<String> values) {
            addCriterion("emailUser not in", values, "emailuser");
            return (Criteria) this;
        }

        public Criteria andEmailuserBetween(String value1, String value2) {
            addCriterion("emailUser between", value1, value2, "emailuser");
            return (Criteria) this;
        }

        public Criteria andEmailuserNotBetween(String value1, String value2) {
            addCriterion("emailUser not between", value1, value2, "emailuser");
            return (Criteria) this;
        }

        public Criteria andEmailusernameIsNull() {
            addCriterion("emailUserName is null");
            return (Criteria) this;
        }

        public Criteria andEmailusernameIsNotNull() {
            addCriterion("emailUserName is not null");
            return (Criteria) this;
        }

        public Criteria andEmailusernameEqualTo(String value) {
            addCriterion("emailUserName =", value, "emailusername");
            return (Criteria) this;
        }

        public Criteria andEmailusernameNotEqualTo(String value) {
            addCriterion("emailUserName <>", value, "emailusername");
            return (Criteria) this;
        }

        public Criteria andEmailusernameGreaterThan(String value) {
            addCriterion("emailUserName >", value, "emailusername");
            return (Criteria) this;
        }

        public Criteria andEmailusernameGreaterThanOrEqualTo(String value) {
            addCriterion("emailUserName >=", value, "emailusername");
            return (Criteria) this;
        }

        public Criteria andEmailusernameLessThan(String value) {
            addCriterion("emailUserName <", value, "emailusername");
            return (Criteria) this;
        }

        public Criteria andEmailusernameLessThanOrEqualTo(String value) {
            addCriterion("emailUserName <=", value, "emailusername");
            return (Criteria) this;
        }

        public Criteria andEmailusernameLike(String value) {
            addCriterion("emailUserName like", value, "emailusername");
            return (Criteria) this;
        }

        public Criteria andEmailusernameNotLike(String value) {
            addCriterion("emailUserName not like", value, "emailusername");
            return (Criteria) this;
        }

        public Criteria andEmailusernameIn(List<String> values) {
            addCriterion("emailUserName in", values, "emailusername");
            return (Criteria) this;
        }

        public Criteria andEmailusernameNotIn(List<String> values) {
            addCriterion("emailUserName not in", values, "emailusername");
            return (Criteria) this;
        }

        public Criteria andEmailusernameBetween(String value1, String value2) {
            addCriterion("emailUserName between", value1, value2, "emailusername");
            return (Criteria) this;
        }

        public Criteria andEmailusernameNotBetween(String value1, String value2) {
            addCriterion("emailUserName not between", value1, value2, "emailusername");
            return (Criteria) this;
        }

        public Criteria andEveryindentlimitIsNull() {
            addCriterion("everyIndentLimit is null");
            return (Criteria) this;
        }

        public Criteria andEveryindentlimitIsNotNull() {
            addCriterion("everyIndentLimit is not null");
            return (Criteria) this;
        }

        public Criteria andEveryindentlimitEqualTo(Integer value) {
            addCriterion("everyIndentLimit =", value, "everyindentlimit");
            return (Criteria) this;
        }

        public Criteria andEveryindentlimitNotEqualTo(Integer value) {
            addCriterion("everyIndentLimit <>", value, "everyindentlimit");
            return (Criteria) this;
        }

        public Criteria andEveryindentlimitGreaterThan(Integer value) {
            addCriterion("everyIndentLimit >", value, "everyindentlimit");
            return (Criteria) this;
        }

        public Criteria andEveryindentlimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("everyIndentLimit >=", value, "everyindentlimit");
            return (Criteria) this;
        }

        public Criteria andEveryindentlimitLessThan(Integer value) {
            addCriterion("everyIndentLimit <", value, "everyindentlimit");
            return (Criteria) this;
        }

        public Criteria andEveryindentlimitLessThanOrEqualTo(Integer value) {
            addCriterion("everyIndentLimit <=", value, "everyindentlimit");
            return (Criteria) this;
        }

        public Criteria andEveryindentlimitIn(List<Integer> values) {
            addCriterion("everyIndentLimit in", values, "everyindentlimit");
            return (Criteria) this;
        }

        public Criteria andEveryindentlimitNotIn(List<Integer> values) {
            addCriterion("everyIndentLimit not in", values, "everyindentlimit");
            return (Criteria) this;
        }

        public Criteria andEveryindentlimitBetween(Integer value1, Integer value2) {
            addCriterion("everyIndentLimit between", value1, value2, "everyindentlimit");
            return (Criteria) this;
        }

        public Criteria andEveryindentlimitNotBetween(Integer value1, Integer value2) {
            addCriterion("everyIndentLimit not between", value1, value2, "everyindentlimit");
            return (Criteria) this;
        }

        public Criteria andGoldIsNull() {
            addCriterion("gold is null");
            return (Criteria) this;
        }

        public Criteria andGoldIsNotNull() {
            addCriterion("gold is not null");
            return (Criteria) this;
        }

        public Criteria andGoldEqualTo(Boolean value) {
            addCriterion("gold =", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotEqualTo(Boolean value) {
            addCriterion("gold <>", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldGreaterThan(Boolean value) {
            addCriterion("gold >", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldGreaterThanOrEqualTo(Boolean value) {
            addCriterion("gold >=", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldLessThan(Boolean value) {
            addCriterion("gold <", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldLessThanOrEqualTo(Boolean value) {
            addCriterion("gold <=", value, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldIn(List<Boolean> values) {
            addCriterion("gold in", values, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotIn(List<Boolean> values) {
            addCriterion("gold not in", values, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldBetween(Boolean value1, Boolean value2) {
            addCriterion("gold between", value1, value2, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldNotBetween(Boolean value1, Boolean value2) {
            addCriterion("gold not between", value1, value2, "gold");
            return (Criteria) this;
        }

        public Criteria andGoldmarketvalueIsNull() {
            addCriterion("goldMarketValue is null");
            return (Criteria) this;
        }

        public Criteria andGoldmarketvalueIsNotNull() {
            addCriterion("goldMarketValue is not null");
            return (Criteria) this;
        }

        public Criteria andGoldmarketvalueEqualTo(Integer value) {
            addCriterion("goldMarketValue =", value, "goldmarketvalue");
            return (Criteria) this;
        }

        public Criteria andGoldmarketvalueNotEqualTo(Integer value) {
            addCriterion("goldMarketValue <>", value, "goldmarketvalue");
            return (Criteria) this;
        }

        public Criteria andGoldmarketvalueGreaterThan(Integer value) {
            addCriterion("goldMarketValue >", value, "goldmarketvalue");
            return (Criteria) this;
        }

        public Criteria andGoldmarketvalueGreaterThanOrEqualTo(Integer value) {
            addCriterion("goldMarketValue >=", value, "goldmarketvalue");
            return (Criteria) this;
        }

        public Criteria andGoldmarketvalueLessThan(Integer value) {
            addCriterion("goldMarketValue <", value, "goldmarketvalue");
            return (Criteria) this;
        }

        public Criteria andGoldmarketvalueLessThanOrEqualTo(Integer value) {
            addCriterion("goldMarketValue <=", value, "goldmarketvalue");
            return (Criteria) this;
        }

        public Criteria andGoldmarketvalueIn(List<Integer> values) {
            addCriterion("goldMarketValue in", values, "goldmarketvalue");
            return (Criteria) this;
        }

        public Criteria andGoldmarketvalueNotIn(List<Integer> values) {
            addCriterion("goldMarketValue not in", values, "goldmarketvalue");
            return (Criteria) this;
        }

        public Criteria andGoldmarketvalueBetween(Integer value1, Integer value2) {
            addCriterion("goldMarketValue between", value1, value2, "goldmarketvalue");
            return (Criteria) this;
        }

        public Criteria andGoldmarketvalueNotBetween(Integer value1, Integer value2) {
            addCriterion("goldMarketValue not between", value1, value2, "goldmarketvalue");
            return (Criteria) this;
        }

        public Criteria andGroupbuyIsNull() {
            addCriterion("groupBuy is null");
            return (Criteria) this;
        }

        public Criteria andGroupbuyIsNotNull() {
            addCriterion("groupBuy is not null");
            return (Criteria) this;
        }

        public Criteria andGroupbuyEqualTo(Boolean value) {
            addCriterion("groupBuy =", value, "groupbuy");
            return (Criteria) this;
        }

        public Criteria andGroupbuyNotEqualTo(Boolean value) {
            addCriterion("groupBuy <>", value, "groupbuy");
            return (Criteria) this;
        }

        public Criteria andGroupbuyGreaterThan(Boolean value) {
            addCriterion("groupBuy >", value, "groupbuy");
            return (Criteria) this;
        }

        public Criteria andGroupbuyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("groupBuy >=", value, "groupbuy");
            return (Criteria) this;
        }

        public Criteria andGroupbuyLessThan(Boolean value) {
            addCriterion("groupBuy <", value, "groupbuy");
            return (Criteria) this;
        }

        public Criteria andGroupbuyLessThanOrEqualTo(Boolean value) {
            addCriterion("groupBuy <=", value, "groupbuy");
            return (Criteria) this;
        }

        public Criteria andGroupbuyIn(List<Boolean> values) {
            addCriterion("groupBuy in", values, "groupbuy");
            return (Criteria) this;
        }

        public Criteria andGroupbuyNotIn(List<Boolean> values) {
            addCriterion("groupBuy not in", values, "groupbuy");
            return (Criteria) this;
        }

        public Criteria andGroupbuyBetween(Boolean value1, Boolean value2) {
            addCriterion("groupBuy between", value1, value2, "groupbuy");
            return (Criteria) this;
        }

        public Criteria andGroupbuyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("groupBuy not between", value1, value2, "groupbuy");
            return (Criteria) this;
        }

        public Criteria andHotsearchIsNull() {
            addCriterion("hotSearch is null");
            return (Criteria) this;
        }

        public Criteria andHotsearchIsNotNull() {
            addCriterion("hotSearch is not null");
            return (Criteria) this;
        }

        public Criteria andHotsearchEqualTo(String value) {
            addCriterion("hotSearch =", value, "hotsearch");
            return (Criteria) this;
        }

        public Criteria andHotsearchNotEqualTo(String value) {
            addCriterion("hotSearch <>", value, "hotsearch");
            return (Criteria) this;
        }

        public Criteria andHotsearchGreaterThan(String value) {
            addCriterion("hotSearch >", value, "hotsearch");
            return (Criteria) this;
        }

        public Criteria andHotsearchGreaterThanOrEqualTo(String value) {
            addCriterion("hotSearch >=", value, "hotsearch");
            return (Criteria) this;
        }

        public Criteria andHotsearchLessThan(String value) {
            addCriterion("hotSearch <", value, "hotsearch");
            return (Criteria) this;
        }

        public Criteria andHotsearchLessThanOrEqualTo(String value) {
            addCriterion("hotSearch <=", value, "hotsearch");
            return (Criteria) this;
        }

        public Criteria andHotsearchLike(String value) {
            addCriterion("hotSearch like", value, "hotsearch");
            return (Criteria) this;
        }

        public Criteria andHotsearchNotLike(String value) {
            addCriterion("hotSearch not like", value, "hotsearch");
            return (Criteria) this;
        }

        public Criteria andHotsearchIn(List<String> values) {
            addCriterion("hotSearch in", values, "hotsearch");
            return (Criteria) this;
        }

        public Criteria andHotsearchNotIn(List<String> values) {
            addCriterion("hotSearch not in", values, "hotsearch");
            return (Criteria) this;
        }

        public Criteria andHotsearchBetween(String value1, String value2) {
            addCriterion("hotSearch between", value1, value2, "hotsearch");
            return (Criteria) this;
        }

        public Criteria andHotsearchNotBetween(String value1, String value2) {
            addCriterion("hotSearch not between", value1, value2, "hotsearch");
            return (Criteria) this;
        }

        public Criteria andImagefilesizeIsNull() {
            addCriterion("imageFilesize is null");
            return (Criteria) this;
        }

        public Criteria andImagefilesizeIsNotNull() {
            addCriterion("imageFilesize is not null");
            return (Criteria) this;
        }

        public Criteria andImagefilesizeEqualTo(Integer value) {
            addCriterion("imageFilesize =", value, "imagefilesize");
            return (Criteria) this;
        }

        public Criteria andImagefilesizeNotEqualTo(Integer value) {
            addCriterion("imageFilesize <>", value, "imagefilesize");
            return (Criteria) this;
        }

        public Criteria andImagefilesizeGreaterThan(Integer value) {
            addCriterion("imageFilesize >", value, "imagefilesize");
            return (Criteria) this;
        }

        public Criteria andImagefilesizeGreaterThanOrEqualTo(Integer value) {
            addCriterion("imageFilesize >=", value, "imagefilesize");
            return (Criteria) this;
        }

        public Criteria andImagefilesizeLessThan(Integer value) {
            addCriterion("imageFilesize <", value, "imagefilesize");
            return (Criteria) this;
        }

        public Criteria andImagefilesizeLessThanOrEqualTo(Integer value) {
            addCriterion("imageFilesize <=", value, "imagefilesize");
            return (Criteria) this;
        }

        public Criteria andImagefilesizeIn(List<Integer> values) {
            addCriterion("imageFilesize in", values, "imagefilesize");
            return (Criteria) this;
        }

        public Criteria andImagefilesizeNotIn(List<Integer> values) {
            addCriterion("imageFilesize not in", values, "imagefilesize");
            return (Criteria) this;
        }

        public Criteria andImagefilesizeBetween(Integer value1, Integer value2) {
            addCriterion("imageFilesize between", value1, value2, "imagefilesize");
            return (Criteria) this;
        }

        public Criteria andImagefilesizeNotBetween(Integer value1, Integer value2) {
            addCriterion("imageFilesize not between", value1, value2, "imagefilesize");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeIsNull() {
            addCriterion("imageSaveType is null");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeIsNotNull() {
            addCriterion("imageSaveType is not null");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeEqualTo(String value) {
            addCriterion("imageSaveType =", value, "imagesavetype");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeNotEqualTo(String value) {
            addCriterion("imageSaveType <>", value, "imagesavetype");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeGreaterThan(String value) {
            addCriterion("imageSaveType >", value, "imagesavetype");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeGreaterThanOrEqualTo(String value) {
            addCriterion("imageSaveType >=", value, "imagesavetype");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeLessThan(String value) {
            addCriterion("imageSaveType <", value, "imagesavetype");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeLessThanOrEqualTo(String value) {
            addCriterion("imageSaveType <=", value, "imagesavetype");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeLike(String value) {
            addCriterion("imageSaveType like", value, "imagesavetype");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeNotLike(String value) {
            addCriterion("imageSaveType not like", value, "imagesavetype");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeIn(List<String> values) {
            addCriterion("imageSaveType in", values, "imagesavetype");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeNotIn(List<String> values) {
            addCriterion("imageSaveType not in", values, "imagesavetype");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeBetween(String value1, String value2) {
            addCriterion("imageSaveType between", value1, value2, "imagesavetype");
            return (Criteria) this;
        }

        public Criteria andImagesavetypeNotBetween(String value1, String value2) {
            addCriterion("imageSaveType not between", value1, value2, "imagesavetype");
            return (Criteria) this;
        }

        public Criteria andImagesuffixIsNull() {
            addCriterion("imageSuffix is null");
            return (Criteria) this;
        }

        public Criteria andImagesuffixIsNotNull() {
            addCriterion("imageSuffix is not null");
            return (Criteria) this;
        }

        public Criteria andImagesuffixEqualTo(String value) {
            addCriterion("imageSuffix =", value, "imagesuffix");
            return (Criteria) this;
        }

        public Criteria andImagesuffixNotEqualTo(String value) {
            addCriterion("imageSuffix <>", value, "imagesuffix");
            return (Criteria) this;
        }

        public Criteria andImagesuffixGreaterThan(String value) {
            addCriterion("imageSuffix >", value, "imagesuffix");
            return (Criteria) this;
        }

        public Criteria andImagesuffixGreaterThanOrEqualTo(String value) {
            addCriterion("imageSuffix >=", value, "imagesuffix");
            return (Criteria) this;
        }

        public Criteria andImagesuffixLessThan(String value) {
            addCriterion("imageSuffix <", value, "imagesuffix");
            return (Criteria) this;
        }

        public Criteria andImagesuffixLessThanOrEqualTo(String value) {
            addCriterion("imageSuffix <=", value, "imagesuffix");
            return (Criteria) this;
        }

        public Criteria andImagesuffixLike(String value) {
            addCriterion("imageSuffix like", value, "imagesuffix");
            return (Criteria) this;
        }

        public Criteria andImagesuffixNotLike(String value) {
            addCriterion("imageSuffix not like", value, "imagesuffix");
            return (Criteria) this;
        }

        public Criteria andImagesuffixIn(List<String> values) {
            addCriterion("imageSuffix in", values, "imagesuffix");
            return (Criteria) this;
        }

        public Criteria andImagesuffixNotIn(List<String> values) {
            addCriterion("imageSuffix not in", values, "imagesuffix");
            return (Criteria) this;
        }

        public Criteria andImagesuffixBetween(String value1, String value2) {
            addCriterion("imageSuffix between", value1, value2, "imagesuffix");
            return (Criteria) this;
        }

        public Criteria andImagesuffixNotBetween(String value1, String value2) {
            addCriterion("imageSuffix not between", value1, value2, "imagesuffix");
            return (Criteria) this;
        }

        public Criteria andIndentcommentIsNull() {
            addCriterion("indentComment is null");
            return (Criteria) this;
        }

        public Criteria andIndentcommentIsNotNull() {
            addCriterion("indentComment is not null");
            return (Criteria) this;
        }

        public Criteria andIndentcommentEqualTo(Integer value) {
            addCriterion("indentComment =", value, "indentcomment");
            return (Criteria) this;
        }

        public Criteria andIndentcommentNotEqualTo(Integer value) {
            addCriterion("indentComment <>", value, "indentcomment");
            return (Criteria) this;
        }

        public Criteria andIndentcommentGreaterThan(Integer value) {
            addCriterion("indentComment >", value, "indentcomment");
            return (Criteria) this;
        }

        public Criteria andIndentcommentGreaterThanOrEqualTo(Integer value) {
            addCriterion("indentComment >=", value, "indentcomment");
            return (Criteria) this;
        }

        public Criteria andIndentcommentLessThan(Integer value) {
            addCriterion("indentComment <", value, "indentcomment");
            return (Criteria) this;
        }

        public Criteria andIndentcommentLessThanOrEqualTo(Integer value) {
            addCriterion("indentComment <=", value, "indentcomment");
            return (Criteria) this;
        }

        public Criteria andIndentcommentIn(List<Integer> values) {
            addCriterion("indentComment in", values, "indentcomment");
            return (Criteria) this;
        }

        public Criteria andIndentcommentNotIn(List<Integer> values) {
            addCriterion("indentComment not in", values, "indentcomment");
            return (Criteria) this;
        }

        public Criteria andIndentcommentBetween(Integer value1, Integer value2) {
            addCriterion("indentComment between", value1, value2, "indentcomment");
            return (Criteria) this;
        }

        public Criteria andIndentcommentNotBetween(Integer value1, Integer value2) {
            addCriterion("indentComment not between", value1, value2, "indentcomment");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNull() {
            addCriterion("integral is null");
            return (Criteria) this;
        }

        public Criteria andIntegralIsNotNull() {
            addCriterion("integral is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralEqualTo(Boolean value) {
            addCriterion("integral =", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotEqualTo(Boolean value) {
            addCriterion("integral <>", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThan(Boolean value) {
            addCriterion("integral >", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralGreaterThanOrEqualTo(Boolean value) {
            addCriterion("integral >=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThan(Boolean value) {
            addCriterion("integral <", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralLessThanOrEqualTo(Boolean value) {
            addCriterion("integral <=", value, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralIn(List<Boolean> values) {
            addCriterion("integral in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotIn(List<Boolean> values) {
            addCriterion("integral not in", values, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralBetween(Boolean value1, Boolean value2) {
            addCriterion("integral between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralNotBetween(Boolean value1, Boolean value2) {
            addCriterion("integral not between", value1, value2, "integral");
            return (Criteria) this;
        }

        public Criteria andIntegralrateIsNull() {
            addCriterion("integralRate is null");
            return (Criteria) this;
        }

        public Criteria andIntegralrateIsNotNull() {
            addCriterion("integralRate is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralrateEqualTo(Integer value) {
            addCriterion("integralRate =", value, "integralrate");
            return (Criteria) this;
        }

        public Criteria andIntegralrateNotEqualTo(Integer value) {
            addCriterion("integralRate <>", value, "integralrate");
            return (Criteria) this;
        }

        public Criteria andIntegralrateGreaterThan(Integer value) {
            addCriterion("integralRate >", value, "integralrate");
            return (Criteria) this;
        }

        public Criteria andIntegralrateGreaterThanOrEqualTo(Integer value) {
            addCriterion("integralRate >=", value, "integralrate");
            return (Criteria) this;
        }

        public Criteria andIntegralrateLessThan(Integer value) {
            addCriterion("integralRate <", value, "integralrate");
            return (Criteria) this;
        }

        public Criteria andIntegralrateLessThanOrEqualTo(Integer value) {
            addCriterion("integralRate <=", value, "integralrate");
            return (Criteria) this;
        }

        public Criteria andIntegralrateIn(List<Integer> values) {
            addCriterion("integralRate in", values, "integralrate");
            return (Criteria) this;
        }

        public Criteria andIntegralrateNotIn(List<Integer> values) {
            addCriterion("integralRate not in", values, "integralrate");
            return (Criteria) this;
        }

        public Criteria andIntegralrateBetween(Integer value1, Integer value2) {
            addCriterion("integralRate between", value1, value2, "integralrate");
            return (Criteria) this;
        }

        public Criteria andIntegralrateNotBetween(Integer value1, Integer value2) {
            addCriterion("integralRate not between", value1, value2, "integralrate");
            return (Criteria) this;
        }

        public Criteria andIntegralstoreIsNull() {
            addCriterion("integralStore is null");
            return (Criteria) this;
        }

        public Criteria andIntegralstoreIsNotNull() {
            addCriterion("integralStore is not null");
            return (Criteria) this;
        }

        public Criteria andIntegralstoreEqualTo(Boolean value) {
            addCriterion("integralStore =", value, "integralstore");
            return (Criteria) this;
        }

        public Criteria andIntegralstoreNotEqualTo(Boolean value) {
            addCriterion("integralStore <>", value, "integralstore");
            return (Criteria) this;
        }

        public Criteria andIntegralstoreGreaterThan(Boolean value) {
            addCriterion("integralStore >", value, "integralstore");
            return (Criteria) this;
        }

        public Criteria andIntegralstoreGreaterThanOrEqualTo(Boolean value) {
            addCriterion("integralStore >=", value, "integralstore");
            return (Criteria) this;
        }

        public Criteria andIntegralstoreLessThan(Boolean value) {
            addCriterion("integralStore <", value, "integralstore");
            return (Criteria) this;
        }

        public Criteria andIntegralstoreLessThanOrEqualTo(Boolean value) {
            addCriterion("integralStore <=", value, "integralstore");
            return (Criteria) this;
        }

        public Criteria andIntegralstoreIn(List<Boolean> values) {
            addCriterion("integralStore in", values, "integralstore");
            return (Criteria) this;
        }

        public Criteria andIntegralstoreNotIn(List<Boolean> values) {
            addCriterion("integralStore not in", values, "integralstore");
            return (Criteria) this;
        }

        public Criteria andIntegralstoreBetween(Boolean value1, Boolean value2) {
            addCriterion("integralStore between", value1, value2, "integralstore");
            return (Criteria) this;
        }

        public Criteria andIntegralstoreNotBetween(Boolean value1, Boolean value2) {
            addCriterion("integralStore not between", value1, value2, "integralstore");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andMemberdayloginIsNull() {
            addCriterion("memberDayLogin is null");
            return (Criteria) this;
        }

        public Criteria andMemberdayloginIsNotNull() {
            addCriterion("memberDayLogin is not null");
            return (Criteria) this;
        }

        public Criteria andMemberdayloginEqualTo(Integer value) {
            addCriterion("memberDayLogin =", value, "memberdaylogin");
            return (Criteria) this;
        }

        public Criteria andMemberdayloginNotEqualTo(Integer value) {
            addCriterion("memberDayLogin <>", value, "memberdaylogin");
            return (Criteria) this;
        }

        public Criteria andMemberdayloginGreaterThan(Integer value) {
            addCriterion("memberDayLogin >", value, "memberdaylogin");
            return (Criteria) this;
        }

        public Criteria andMemberdayloginGreaterThanOrEqualTo(Integer value) {
            addCriterion("memberDayLogin >=", value, "memberdaylogin");
            return (Criteria) this;
        }

        public Criteria andMemberdayloginLessThan(Integer value) {
            addCriterion("memberDayLogin <", value, "memberdaylogin");
            return (Criteria) this;
        }

        public Criteria andMemberdayloginLessThanOrEqualTo(Integer value) {
            addCriterion("memberDayLogin <=", value, "memberdaylogin");
            return (Criteria) this;
        }

        public Criteria andMemberdayloginIn(List<Integer> values) {
            addCriterion("memberDayLogin in", values, "memberdaylogin");
            return (Criteria) this;
        }

        public Criteria andMemberdayloginNotIn(List<Integer> values) {
            addCriterion("memberDayLogin not in", values, "memberdaylogin");
            return (Criteria) this;
        }

        public Criteria andMemberdayloginBetween(Integer value1, Integer value2) {
            addCriterion("memberDayLogin between", value1, value2, "memberdaylogin");
            return (Criteria) this;
        }

        public Criteria andMemberdayloginNotBetween(Integer value1, Integer value2) {
            addCriterion("memberDayLogin not between", value1, value2, "memberdaylogin");
            return (Criteria) this;
        }

        public Criteria andMemberregisterIsNull() {
            addCriterion("memberRegister is null");
            return (Criteria) this;
        }

        public Criteria andMemberregisterIsNotNull() {
            addCriterion("memberRegister is not null");
            return (Criteria) this;
        }

        public Criteria andMemberregisterEqualTo(Integer value) {
            addCriterion("memberRegister =", value, "memberregister");
            return (Criteria) this;
        }

        public Criteria andMemberregisterNotEqualTo(Integer value) {
            addCriterion("memberRegister <>", value, "memberregister");
            return (Criteria) this;
        }

        public Criteria andMemberregisterGreaterThan(Integer value) {
            addCriterion("memberRegister >", value, "memberregister");
            return (Criteria) this;
        }

        public Criteria andMemberregisterGreaterThanOrEqualTo(Integer value) {
            addCriterion("memberRegister >=", value, "memberregister");
            return (Criteria) this;
        }

        public Criteria andMemberregisterLessThan(Integer value) {
            addCriterion("memberRegister <", value, "memberregister");
            return (Criteria) this;
        }

        public Criteria andMemberregisterLessThanOrEqualTo(Integer value) {
            addCriterion("memberRegister <=", value, "memberregister");
            return (Criteria) this;
        }

        public Criteria andMemberregisterIn(List<Integer> values) {
            addCriterion("memberRegister in", values, "memberregister");
            return (Criteria) this;
        }

        public Criteria andMemberregisterNotIn(List<Integer> values) {
            addCriterion("memberRegister not in", values, "memberregister");
            return (Criteria) this;
        }

        public Criteria andMemberregisterBetween(Integer value1, Integer value2) {
            addCriterion("memberRegister between", value1, value2, "memberregister");
            return (Criteria) this;
        }

        public Criteria andMemberregisterNotBetween(Integer value1, Integer value2) {
            addCriterion("memberRegister not between", value1, value2, "memberregister");
            return (Criteria) this;
        }

        public Criteria andMiddleheightIsNull() {
            addCriterion("middleHeight is null");
            return (Criteria) this;
        }

        public Criteria andMiddleheightIsNotNull() {
            addCriterion("middleHeight is not null");
            return (Criteria) this;
        }

        public Criteria andMiddleheightEqualTo(Integer value) {
            addCriterion("middleHeight =", value, "middleheight");
            return (Criteria) this;
        }

        public Criteria andMiddleheightNotEqualTo(Integer value) {
            addCriterion("middleHeight <>", value, "middleheight");
            return (Criteria) this;
        }

        public Criteria andMiddleheightGreaterThan(Integer value) {
            addCriterion("middleHeight >", value, "middleheight");
            return (Criteria) this;
        }

        public Criteria andMiddleheightGreaterThanOrEqualTo(Integer value) {
            addCriterion("middleHeight >=", value, "middleheight");
            return (Criteria) this;
        }

        public Criteria andMiddleheightLessThan(Integer value) {
            addCriterion("middleHeight <", value, "middleheight");
            return (Criteria) this;
        }

        public Criteria andMiddleheightLessThanOrEqualTo(Integer value) {
            addCriterion("middleHeight <=", value, "middleheight");
            return (Criteria) this;
        }

        public Criteria andMiddleheightIn(List<Integer> values) {
            addCriterion("middleHeight in", values, "middleheight");
            return (Criteria) this;
        }

        public Criteria andMiddleheightNotIn(List<Integer> values) {
            addCriterion("middleHeight not in", values, "middleheight");
            return (Criteria) this;
        }

        public Criteria andMiddleheightBetween(Integer value1, Integer value2) {
            addCriterion("middleHeight between", value1, value2, "middleheight");
            return (Criteria) this;
        }

        public Criteria andMiddleheightNotBetween(Integer value1, Integer value2) {
            addCriterion("middleHeight not between", value1, value2, "middleheight");
            return (Criteria) this;
        }

        public Criteria andMiddlewidthIsNull() {
            addCriterion("middleWidth is null");
            return (Criteria) this;
        }

        public Criteria andMiddlewidthIsNotNull() {
            addCriterion("middleWidth is not null");
            return (Criteria) this;
        }

        public Criteria andMiddlewidthEqualTo(Integer value) {
            addCriterion("middleWidth =", value, "middlewidth");
            return (Criteria) this;
        }

        public Criteria andMiddlewidthNotEqualTo(Integer value) {
            addCriterion("middleWidth <>", value, "middlewidth");
            return (Criteria) this;
        }

        public Criteria andMiddlewidthGreaterThan(Integer value) {
            addCriterion("middleWidth >", value, "middlewidth");
            return (Criteria) this;
        }

        public Criteria andMiddlewidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("middleWidth >=", value, "middlewidth");
            return (Criteria) this;
        }

        public Criteria andMiddlewidthLessThan(Integer value) {
            addCriterion("middleWidth <", value, "middlewidth");
            return (Criteria) this;
        }

        public Criteria andMiddlewidthLessThanOrEqualTo(Integer value) {
            addCriterion("middleWidth <=", value, "middlewidth");
            return (Criteria) this;
        }

        public Criteria andMiddlewidthIn(List<Integer> values) {
            addCriterion("middleWidth in", values, "middlewidth");
            return (Criteria) this;
        }

        public Criteria andMiddlewidthNotIn(List<Integer> values) {
            addCriterion("middleWidth not in", values, "middlewidth");
            return (Criteria) this;
        }

        public Criteria andMiddlewidthBetween(Integer value1, Integer value2) {
            addCriterion("middleWidth between", value1, value2, "middlewidth");
            return (Criteria) this;
        }

        public Criteria andMiddlewidthNotBetween(Integer value1, Integer value2) {
            addCriterion("middleWidth not between", value1, value2, "middlewidth");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeconsultIsNull() {
            addCriterion("securityCodeConsult is null");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeconsultIsNotNull() {
            addCriterion("securityCodeConsult is not null");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeconsultEqualTo(Boolean value) {
            addCriterion("securityCodeConsult =", value, "securitycodeconsult");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeconsultNotEqualTo(Boolean value) {
            addCriterion("securityCodeConsult <>", value, "securitycodeconsult");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeconsultGreaterThan(Boolean value) {
            addCriterion("securityCodeConsult >", value, "securitycodeconsult");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeconsultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("securityCodeConsult >=", value, "securitycodeconsult");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeconsultLessThan(Boolean value) {
            addCriterion("securityCodeConsult <", value, "securitycodeconsult");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeconsultLessThanOrEqualTo(Boolean value) {
            addCriterion("securityCodeConsult <=", value, "securitycodeconsult");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeconsultIn(List<Boolean> values) {
            addCriterion("securityCodeConsult in", values, "securitycodeconsult");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeconsultNotIn(List<Boolean> values) {
            addCriterion("securityCodeConsult not in", values, "securitycodeconsult");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeconsultBetween(Boolean value1, Boolean value2) {
            addCriterion("securityCodeConsult between", value1, value2, "securitycodeconsult");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeconsultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("securityCodeConsult not between", value1, value2, "securitycodeconsult");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeloginIsNull() {
            addCriterion("securityCodeLogin is null");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeloginIsNotNull() {
            addCriterion("securityCodeLogin is not null");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeloginEqualTo(Boolean value) {
            addCriterion("securityCodeLogin =", value, "securitycodelogin");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeloginNotEqualTo(Boolean value) {
            addCriterion("securityCodeLogin <>", value, "securitycodelogin");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeloginGreaterThan(Boolean value) {
            addCriterion("securityCodeLogin >", value, "securitycodelogin");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeloginGreaterThanOrEqualTo(Boolean value) {
            addCriterion("securityCodeLogin >=", value, "securitycodelogin");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeloginLessThan(Boolean value) {
            addCriterion("securityCodeLogin <", value, "securitycodelogin");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeloginLessThanOrEqualTo(Boolean value) {
            addCriterion("securityCodeLogin <=", value, "securitycodelogin");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeloginIn(List<Boolean> values) {
            addCriterion("securityCodeLogin in", values, "securitycodelogin");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeloginNotIn(List<Boolean> values) {
            addCriterion("securityCodeLogin not in", values, "securitycodelogin");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeloginBetween(Boolean value1, Boolean value2) {
            addCriterion("securityCodeLogin between", value1, value2, "securitycodelogin");
            return (Criteria) this;
        }

        public Criteria andSecuritycodeloginNotBetween(Boolean value1, Boolean value2) {
            addCriterion("securityCodeLogin not between", value1, value2, "securitycodelogin");
            return (Criteria) this;
        }

        public Criteria andSecuritycoderegisterIsNull() {
            addCriterion("securityCodeRegister is null");
            return (Criteria) this;
        }

        public Criteria andSecuritycoderegisterIsNotNull() {
            addCriterion("securityCodeRegister is not null");
            return (Criteria) this;
        }

        public Criteria andSecuritycoderegisterEqualTo(Boolean value) {
            addCriterion("securityCodeRegister =", value, "securitycoderegister");
            return (Criteria) this;
        }

        public Criteria andSecuritycoderegisterNotEqualTo(Boolean value) {
            addCriterion("securityCodeRegister <>", value, "securitycoderegister");
            return (Criteria) this;
        }

        public Criteria andSecuritycoderegisterGreaterThan(Boolean value) {
            addCriterion("securityCodeRegister >", value, "securitycoderegister");
            return (Criteria) this;
        }

        public Criteria andSecuritycoderegisterGreaterThanOrEqualTo(Boolean value) {
            addCriterion("securityCodeRegister >=", value, "securitycoderegister");
            return (Criteria) this;
        }

        public Criteria andSecuritycoderegisterLessThan(Boolean value) {
            addCriterion("securityCodeRegister <", value, "securitycoderegister");
            return (Criteria) this;
        }

        public Criteria andSecuritycoderegisterLessThanOrEqualTo(Boolean value) {
            addCriterion("securityCodeRegister <=", value, "securitycoderegister");
            return (Criteria) this;
        }

        public Criteria andSecuritycoderegisterIn(List<Boolean> values) {
            addCriterion("securityCodeRegister in", values, "securitycoderegister");
            return (Criteria) this;
        }

        public Criteria andSecuritycoderegisterNotIn(List<Boolean> values) {
            addCriterion("securityCodeRegister not in", values, "securitycoderegister");
            return (Criteria) this;
        }

        public Criteria andSecuritycoderegisterBetween(Boolean value1, Boolean value2) {
            addCriterion("securityCodeRegister between", value1, value2, "securitycoderegister");
            return (Criteria) this;
        }

        public Criteria andSecuritycoderegisterNotBetween(Boolean value1, Boolean value2) {
            addCriterion("securityCodeRegister not between", value1, value2, "securitycoderegister");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeIsNull() {
            addCriterion("securityCodeType is null");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeIsNotNull() {
            addCriterion("securityCodeType is not null");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeEqualTo(String value) {
            addCriterion("securityCodeType =", value, "securitycodetype");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeNotEqualTo(String value) {
            addCriterion("securityCodeType <>", value, "securitycodetype");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeGreaterThan(String value) {
            addCriterion("securityCodeType >", value, "securitycodetype");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeGreaterThanOrEqualTo(String value) {
            addCriterion("securityCodeType >=", value, "securitycodetype");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeLessThan(String value) {
            addCriterion("securityCodeType <", value, "securitycodetype");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeLessThanOrEqualTo(String value) {
            addCriterion("securityCodeType <=", value, "securitycodetype");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeLike(String value) {
            addCriterion("securityCodeType like", value, "securitycodetype");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeNotLike(String value) {
            addCriterion("securityCodeType not like", value, "securitycodetype");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeIn(List<String> values) {
            addCriterion("securityCodeType in", values, "securitycodetype");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeNotIn(List<String> values) {
            addCriterion("securityCodeType not in", values, "securitycodetype");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeBetween(String value1, String value2) {
            addCriterion("securityCodeType between", value1, value2, "securitycodetype");
            return (Criteria) this;
        }

        public Criteria andSecuritycodetypeNotBetween(String value1, String value2) {
            addCriterion("securityCodeType not between", value1, value2, "securitycodetype");
            return (Criteria) this;
        }

        public Criteria andSmallheightIsNull() {
            addCriterion("smallHeight is null");
            return (Criteria) this;
        }

        public Criteria andSmallheightIsNotNull() {
            addCriterion("smallHeight is not null");
            return (Criteria) this;
        }

        public Criteria andSmallheightEqualTo(Integer value) {
            addCriterion("smallHeight =", value, "smallheight");
            return (Criteria) this;
        }

        public Criteria andSmallheightNotEqualTo(Integer value) {
            addCriterion("smallHeight <>", value, "smallheight");
            return (Criteria) this;
        }

        public Criteria andSmallheightGreaterThan(Integer value) {
            addCriterion("smallHeight >", value, "smallheight");
            return (Criteria) this;
        }

        public Criteria andSmallheightGreaterThanOrEqualTo(Integer value) {
            addCriterion("smallHeight >=", value, "smallheight");
            return (Criteria) this;
        }

        public Criteria andSmallheightLessThan(Integer value) {
            addCriterion("smallHeight <", value, "smallheight");
            return (Criteria) this;
        }

        public Criteria andSmallheightLessThanOrEqualTo(Integer value) {
            addCriterion("smallHeight <=", value, "smallheight");
            return (Criteria) this;
        }

        public Criteria andSmallheightIn(List<Integer> values) {
            addCriterion("smallHeight in", values, "smallheight");
            return (Criteria) this;
        }

        public Criteria andSmallheightNotIn(List<Integer> values) {
            addCriterion("smallHeight not in", values, "smallheight");
            return (Criteria) this;
        }

        public Criteria andSmallheightBetween(Integer value1, Integer value2) {
            addCriterion("smallHeight between", value1, value2, "smallheight");
            return (Criteria) this;
        }

        public Criteria andSmallheightNotBetween(Integer value1, Integer value2) {
            addCriterion("smallHeight not between", value1, value2, "smallheight");
            return (Criteria) this;
        }

        public Criteria andSmallwidthIsNull() {
            addCriterion("smallWidth is null");
            return (Criteria) this;
        }

        public Criteria andSmallwidthIsNotNull() {
            addCriterion("smallWidth is not null");
            return (Criteria) this;
        }

        public Criteria andSmallwidthEqualTo(Integer value) {
            addCriterion("smallWidth =", value, "smallwidth");
            return (Criteria) this;
        }

        public Criteria andSmallwidthNotEqualTo(Integer value) {
            addCriterion("smallWidth <>", value, "smallwidth");
            return (Criteria) this;
        }

        public Criteria andSmallwidthGreaterThan(Integer value) {
            addCriterion("smallWidth >", value, "smallwidth");
            return (Criteria) this;
        }

        public Criteria andSmallwidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("smallWidth >=", value, "smallwidth");
            return (Criteria) this;
        }

        public Criteria andSmallwidthLessThan(Integer value) {
            addCriterion("smallWidth <", value, "smallwidth");
            return (Criteria) this;
        }

        public Criteria andSmallwidthLessThanOrEqualTo(Integer value) {
            addCriterion("smallWidth <=", value, "smallwidth");
            return (Criteria) this;
        }

        public Criteria andSmallwidthIn(List<Integer> values) {
            addCriterion("smallWidth in", values, "smallwidth");
            return (Criteria) this;
        }

        public Criteria andSmallwidthNotIn(List<Integer> values) {
            addCriterion("smallWidth not in", values, "smallwidth");
            return (Criteria) this;
        }

        public Criteria andSmallwidthBetween(Integer value1, Integer value2) {
            addCriterion("smallWidth between", value1, value2, "smallwidth");
            return (Criteria) this;
        }

        public Criteria andSmallwidthNotBetween(Integer value1, Integer value2) {
            addCriterion("smallWidth not between", value1, value2, "smallwidth");
            return (Criteria) this;
        }

        public Criteria andSmsenbaleIsNull() {
            addCriterion("smsEnbale is null");
            return (Criteria) this;
        }

        public Criteria andSmsenbaleIsNotNull() {
            addCriterion("smsEnbale is not null");
            return (Criteria) this;
        }

        public Criteria andSmsenbaleEqualTo(Boolean value) {
            addCriterion("smsEnbale =", value, "smsenbale");
            return (Criteria) this;
        }

        public Criteria andSmsenbaleNotEqualTo(Boolean value) {
            addCriterion("smsEnbale <>", value, "smsenbale");
            return (Criteria) this;
        }

        public Criteria andSmsenbaleGreaterThan(Boolean value) {
            addCriterion("smsEnbale >", value, "smsenbale");
            return (Criteria) this;
        }

        public Criteria andSmsenbaleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("smsEnbale >=", value, "smsenbale");
            return (Criteria) this;
        }

        public Criteria andSmsenbaleLessThan(Boolean value) {
            addCriterion("smsEnbale <", value, "smsenbale");
            return (Criteria) this;
        }

        public Criteria andSmsenbaleLessThanOrEqualTo(Boolean value) {
            addCriterion("smsEnbale <=", value, "smsenbale");
            return (Criteria) this;
        }

        public Criteria andSmsenbaleIn(List<Boolean> values) {
            addCriterion("smsEnbale in", values, "smsenbale");
            return (Criteria) this;
        }

        public Criteria andSmsenbaleNotIn(List<Boolean> values) {
            addCriterion("smsEnbale not in", values, "smsenbale");
            return (Criteria) this;
        }

        public Criteria andSmsenbaleBetween(Boolean value1, Boolean value2) {
            addCriterion("smsEnbale between", value1, value2, "smsenbale");
            return (Criteria) this;
        }

        public Criteria andSmsenbaleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("smsEnbale not between", value1, value2, "smsenbale");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNumberIsNull() {
            addCriterion("sms_max_number is null");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNumberIsNotNull() {
            addCriterion("sms_max_number is not null");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNumberEqualTo(Integer value) {
            addCriterion("sms_max_number =", value, "smsMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNumberNotEqualTo(Integer value) {
            addCriterion("sms_max_number <>", value, "smsMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNumberGreaterThan(Integer value) {
            addCriterion("sms_max_number >", value, "smsMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("sms_max_number >=", value, "smsMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNumberLessThan(Integer value) {
            addCriterion("sms_max_number <", value, "smsMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNumberLessThanOrEqualTo(Integer value) {
            addCriterion("sms_max_number <=", value, "smsMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNumberIn(List<Integer> values) {
            addCriterion("sms_max_number in", values, "smsMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNumberNotIn(List<Integer> values) {
            addCriterion("sms_max_number not in", values, "smsMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNumberBetween(Integer value1, Integer value2) {
            addCriterion("sms_max_number between", value1, value2, "smsMaxNumber");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("sms_max_number not between", value1, value2, "smsMaxNumber");
            return (Criteria) this;
        }
        
        public Criteria andSmsAuthTokenIsNull() {
            addCriterion("sms_auth_token is null");
            return (Criteria) this;
        }

        public Criteria andSmsAuthTokenIsNotNull() {
            addCriterion("sms_auth_token is not null");
            return (Criteria) this;
        }

        public Criteria andSmsAuthTokenEqualTo(String value) {
            addCriterion("sms_auth_token =", value, "smsAuthToken");
            return (Criteria) this;
        }

        public Criteria andSmsAuthTokenNotEqualTo(String value) {
            addCriterion("sms_auth_token <>", value, "smsAuthToken");
            return (Criteria) this;
        }

        public Criteria andSmsAuthTokenGreaterThan(String value) {
            addCriterion("sms_auth_token >", value, "smsAuthToken");
            return (Criteria) this;
        }

        public Criteria andSmsAuthTokenGreaterThanOrEqualTo(String value) {
            addCriterion("sms_auth_token >=", value, "smsAuthToken");
            return (Criteria) this;
        }

        public Criteria andSmsAuthTokenLessThan(String value) {
            addCriterion("sms_auth_token <", value, "smsAuthToken");
            return (Criteria) this;
        }

        public Criteria andSmsAuthTokenLessThanOrEqualTo(String value) {
            addCriterion("sms_auth_token <=", value, "smsAuthToken");
            return (Criteria) this;
        }

        public Criteria andSmsAuthTokenLike(String value) {
            addCriterion("sms_auth_token like", value, "smsAuthToken");
            return (Criteria) this;
        }

        public Criteria andSmsAuthTokenNotLike(String value) {
            addCriterion("sms_auth_token not like", value, "smsAuthToken");
            return (Criteria) this;
        }

        public Criteria andSmsAuthTokenIn(List<String> values) {
            addCriterion("sms_auth_token in", values, "smsAuthToken");
            return (Criteria) this;
        }

        public Criteria andSmsAuthTokenNotIn(List<String> values) {
            addCriterion("sms_auth_token not in", values, "smsAuthToken");
            return (Criteria) this;
        }

        public Criteria andSmsAuthTokenBetween(String value1, String value2) {
            addCriterion("sms_auth_token between", value1, value2, "smsAuthToken");
            return (Criteria) this;
        }

        public Criteria andSmsAuthTokenNotBetween(String value1, String value2) {
            addCriterion("sms_auth_token not between", value1, value2, "smsAuthToken");
            return (Criteria) this;
        }

        public Criteria andSmsPortIsNull() {
            addCriterion("sms_port is null");
            return (Criteria) this;
        }

        public Criteria andSmsPortIsNotNull() {
            addCriterion("sms_port is not null");
            return (Criteria) this;
        }

        public Criteria andSmsPortEqualTo(String value) {
            addCriterion("sms_port =", value, "smsPort");
            return (Criteria) this;
        }

        public Criteria andSmsPortNotEqualTo(String value) {
            addCriterion("sms_port <>", value, "smsPort");
            return (Criteria) this;
        }

        public Criteria andSmsPortGreaterThan(String value) {
            addCriterion("sms_port >", value, "smsPort");
            return (Criteria) this;
        }

        public Criteria andSmsPortGreaterThanOrEqualTo(String value) {
            addCriterion("sms_port >=", value, "smsPort");
            return (Criteria) this;
        }

        public Criteria andSmsPortLessThan(String value) {
            addCriterion("sms_port <", value, "smsPort");
            return (Criteria) this;
        }

        public Criteria andSmsPortLessThanOrEqualTo(String value) {
            addCriterion("sms_port <=", value, "smsPort");
            return (Criteria) this;
        }

        public Criteria andSmsPortLike(String value) {
            addCriterion("sms_port like", value, "smsPort");
            return (Criteria) this;
        }

        public Criteria andSmsPortNotLike(String value) {
            addCriterion("sms_port not like", value, "smsPort");
            return (Criteria) this;
        }

        public Criteria andSmsPortIn(List<String> values) {
            addCriterion("sms_port in", values, "smsPort");
            return (Criteria) this;
        }

        public Criteria andSmsPortNotIn(List<String> values) {
            addCriterion("sms_port not in", values, "smsPort");
            return (Criteria) this;
        }

        public Criteria andSmsPortBetween(String value1, String value2) {
            addCriterion("sms_port between", value1, value2, "smsPort");
            return (Criteria) this;
        }

        public Criteria andSmsPortNotBetween(String value1, String value2) {
            addCriterion("sms_port not between", value1, value2, "smsPort");
            return (Criteria) this;
        }

        public Criteria andSmsUrlIsNull() {
            addCriterion("sms_url is null");
            return (Criteria) this;
        }

        public Criteria andSmsUrlIsNotNull() {
            addCriterion("sms_url is not null");
            return (Criteria) this;
        }

        public Criteria andSmsUrlEqualTo(String value) {
            addCriterion("sms_url =", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlNotEqualTo(String value) {
            addCriterion("sms_url <>", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlGreaterThan(String value) {
            addCriterion("sms_url >", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("sms_url >=", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlLessThan(String value) {
            addCriterion("sms_url <", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlLessThanOrEqualTo(String value) {
            addCriterion("sms_url <=", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlLike(String value) {
            addCriterion("sms_url like", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlNotLike(String value) {
            addCriterion("sms_url not like", value, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlIn(List<String> values) {
            addCriterion("sms_url in", values, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlNotIn(List<String> values) {
            addCriterion("sms_url not in", values, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlBetween(String value1, String value2) {
            addCriterion("sms_url between", value1, value2, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsUrlNotBetween(String value1, String value2) {
            addCriterion("sms_url not between", value1, value2, "smsUrl");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidIsNull() {
            addCriterion("sms_account_sid is null");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidIsNotNull() {
            addCriterion("sms_account_sid is not null");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidEqualTo(String value) {
            addCriterion("sms_account_sid =", value, "smsAccountSid");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidNotEqualTo(String value) {
            addCriterion("sms_account_sid <>", value, "smsAccountSid");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidGreaterThan(String value) {
            addCriterion("sms_account_sid >", value, "smsAccountSid");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidGreaterThanOrEqualTo(String value) {
            addCriterion("sms_account_sid >=", value, "smsAccountSid");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidLessThan(String value) {
            addCriterion("sms_account_sid <", value, "smsAccountSid");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidLessThanOrEqualTo(String value) {
            addCriterion("sms_account_sid <=", value, "smsAccountSid");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidLike(String value) {
            addCriterion("sms_account_sid like", value, "smsAccountSid");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidNotLike(String value) {
            addCriterion("sms_account_sid not like", value, "smsAccountSid");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidIn(List<String> values) {
            addCriterion("sms_account_sid in", values, "smsAccountSid");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidNotIn(List<String> values) {
            addCriterion("sms_account_sid not in", values, "smsAccountSid");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidBetween(String value1, String value2) {
            addCriterion("sms_account_sid between", value1, value2, "smsAccountSid");
            return (Criteria) this;
        }

        public Criteria andSmsAccountSidNotBetween(String value1, String value2) {
            addCriterion("sms_account_sid not between", value1, value2, "smsAccountSid");
            return (Criteria) this;
        }

        public Criteria andCartCountMaxIsNull() {
            addCriterion("cart_count_max is null");
            return (Criteria) this;
        }

        public Criteria andCartCountMaxIsNotNull() {
            addCriterion("cart_count_max is not null");
            return (Criteria) this;
        }

        public Criteria andCartCountMaxEqualTo(Integer value) {
            addCriterion("cart_count_max =", value, "cartCountMax");
            return (Criteria) this;
        }

        public Criteria andCartCountMaxNotEqualTo(Integer value) {
            addCriterion("cart_count_max <>", value, "cartCountMax");
            return (Criteria) this;
        }

        public Criteria andCartCountMaxGreaterThan(Integer value) {
            addCriterion("cart_count_max >", value, "cartCountMax");
            return (Criteria) this;
        }

        public Criteria andCartCountMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("cart_count_max >=", value, "cartCountMax");
            return (Criteria) this;
        }

        public Criteria andCartCountMaxLessThan(Integer value) {
            addCriterion("cart_count_max <", value, "cartCountMax");
            return (Criteria) this;
        }

        public Criteria andCartCountMaxLessThanOrEqualTo(Integer value) {
            addCriterion("cart_count_max <=", value, "cartCountMax");
            return (Criteria) this;
        }

        public Criteria andCartCountMaxIn(List<Integer> values) {
            addCriterion("cart_count_max in", values, "cartCountMax");
            return (Criteria) this;
        }

        public Criteria andCartCountMaxNotIn(List<Integer> values) {
            addCriterion("cart_count_max not in", values, "cartCountMax");
            return (Criteria) this;
        }

        public Criteria andCartCountMaxBetween(Integer value1, Integer value2) {
            addCriterion("cart_count_max between", value1, value2, "cartCountMax");
            return (Criteria) this;
        }

        public Criteria andCartCountMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("cart_count_max not between", value1, value2, "cartCountMax");
            return (Criteria) this;
        }
        
        public Criteria andStoreAllowIsNull() {
            addCriterion("store_allow is null");
            return (Criteria) this;
        }

        public Criteria andStoreAllowIsNotNull() {
            addCriterion("store_allow is not null");
            return (Criteria) this;
        }

        public Criteria andStoreAllowEqualTo(Boolean value) {
            addCriterion("store_allow =", value, "storeAllow");
            return (Criteria) this;
        }

        public Criteria andStoreAllowNotEqualTo(Boolean value) {
            addCriterion("store_allow <>", value, "storeAllow");
            return (Criteria) this;
        }

        public Criteria andStoreAllowGreaterThan(Boolean value) {
            addCriterion("store_allow >", value, "storeAllow");
            return (Criteria) this;
        }

        public Criteria andStoreAllowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("store_allow >=", value, "storeAllow");
            return (Criteria) this;
        }

        public Criteria andStoreAllowLessThan(Boolean value) {
            addCriterion("store_allow <", value, "storeAllow");
            return (Criteria) this;
        }

        public Criteria andStoreAllowLessThanOrEqualTo(Boolean value) {
            addCriterion("store_allow <=", value, "storeAllow");
            return (Criteria) this;
        }

        public Criteria andStoreAllowIn(List<Boolean> values) {
            addCriterion("store_allow in", values, "storeAllow");
            return (Criteria) this;
        }

        public Criteria andStoreAllowNotIn(List<Boolean> values) {
            addCriterion("store_allow not in", values, "storeAllow");
            return (Criteria) this;
        }

        public Criteria andStoreAllowBetween(Boolean value1, Boolean value2) {
            addCriterion("store_allow between", value1, value2, "storeAllow");
            return (Criteria) this;
        }

        public Criteria andStoreAllowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("store_allow not between", value1, value2, "storeAllow");
            return (Criteria) this;
        }

        public Criteria andSyslanguageIsNull() {
            addCriterion("sysLanguage is null");
            return (Criteria) this;
        }

        public Criteria andSyslanguageIsNotNull() {
            addCriterion("sysLanguage is not null");
            return (Criteria) this;
        }

        public Criteria andSyslanguageEqualTo(String value) {
            addCriterion("sysLanguage =", value, "syslanguage");
            return (Criteria) this;
        }

        public Criteria andSyslanguageNotEqualTo(String value) {
            addCriterion("sysLanguage <>", value, "syslanguage");
            return (Criteria) this;
        }

        public Criteria andSyslanguageGreaterThan(String value) {
            addCriterion("sysLanguage >", value, "syslanguage");
            return (Criteria) this;
        }

        public Criteria andSyslanguageGreaterThanOrEqualTo(String value) {
            addCriterion("sysLanguage >=", value, "syslanguage");
            return (Criteria) this;
        }

        public Criteria andSyslanguageLessThan(String value) {
            addCriterion("sysLanguage <", value, "syslanguage");
            return (Criteria) this;
        }

        public Criteria andSyslanguageLessThanOrEqualTo(String value) {
            addCriterion("sysLanguage <=", value, "syslanguage");
            return (Criteria) this;
        }

        public Criteria andSyslanguageLike(String value) {
            addCriterion("sysLanguage like", value, "syslanguage");
            return (Criteria) this;
        }

        public Criteria andSyslanguageNotLike(String value) {
            addCriterion("sysLanguage not like", value, "syslanguage");
            return (Criteria) this;
        }

        public Criteria andSyslanguageIn(List<String> values) {
            addCriterion("sysLanguage in", values, "syslanguage");
            return (Criteria) this;
        }

        public Criteria andSyslanguageNotIn(List<String> values) {
            addCriterion("sysLanguage not in", values, "syslanguage");
            return (Criteria) this;
        }

        public Criteria andSyslanguageBetween(String value1, String value2) {
            addCriterion("sysLanguage between", value1, value2, "syslanguage");
            return (Criteria) this;
        }

        public Criteria andSyslanguageNotBetween(String value1, String value2) {
            addCriterion("sysLanguage not between", value1, value2, "syslanguage");
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathIsNull() {
            addCriterion("uploadFilePath is null");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathIsNotNull() {
            addCriterion("uploadFilePath is not null");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathEqualTo(String value) {
            addCriterion("uploadFilePath =", value, "uploadfilepath");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathNotEqualTo(String value) {
            addCriterion("uploadFilePath <>", value, "uploadfilepath");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathGreaterThan(String value) {
            addCriterion("uploadFilePath >", value, "uploadfilepath");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathGreaterThanOrEqualTo(String value) {
            addCriterion("uploadFilePath >=", value, "uploadfilepath");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathLessThan(String value) {
            addCriterion("uploadFilePath <", value, "uploadfilepath");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathLessThanOrEqualTo(String value) {
            addCriterion("uploadFilePath <=", value, "uploadfilepath");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathLike(String value) {
            addCriterion("uploadFilePath like", value, "uploadfilepath");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathNotLike(String value) {
            addCriterion("uploadFilePath not like", value, "uploadfilepath");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathIn(List<String> values) {
            addCriterion("uploadFilePath in", values, "uploadfilepath");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathNotIn(List<String> values) {
            addCriterion("uploadFilePath not in", values, "uploadfilepath");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathBetween(String value1, String value2) {
            addCriterion("uploadFilePath between", value1, value2, "uploadfilepath");
            return (Criteria) this;
        }

        public Criteria andUploadfilepathNotBetween(String value1, String value2) {
            addCriterion("uploadFilePath not between", value1, value2, "uploadfilepath");
            return (Criteria) this;
        }

        public Criteria andVisitorconsultIsNull() {
            addCriterion("visitorConsult is null");
            return (Criteria) this;
        }

        public Criteria andVisitorconsultIsNotNull() {
            addCriterion("visitorConsult is not null");
            return (Criteria) this;
        }

        public Criteria andVisitorconsultEqualTo(Boolean value) {
            addCriterion("visitorConsult =", value, "visitorconsult");
            return (Criteria) this;
        }

        public Criteria andVisitorconsultNotEqualTo(Boolean value) {
            addCriterion("visitorConsult <>", value, "visitorconsult");
            return (Criteria) this;
        }

        public Criteria andVisitorconsultGreaterThan(Boolean value) {
            addCriterion("visitorConsult >", value, "visitorconsult");
            return (Criteria) this;
        }

        public Criteria andVisitorconsultGreaterThanOrEqualTo(Boolean value) {
            addCriterion("visitorConsult >=", value, "visitorconsult");
            return (Criteria) this;
        }

        public Criteria andVisitorconsultLessThan(Boolean value) {
            addCriterion("visitorConsult <", value, "visitorconsult");
            return (Criteria) this;
        }

        public Criteria andVisitorconsultLessThanOrEqualTo(Boolean value) {
            addCriterion("visitorConsult <=", value, "visitorconsult");
            return (Criteria) this;
        }

        public Criteria andVisitorconsultIn(List<Boolean> values) {
            addCriterion("visitorConsult in", values, "visitorconsult");
            return (Criteria) this;
        }

        public Criteria andVisitorconsultNotIn(List<Boolean> values) {
            addCriterion("visitorConsult not in", values, "visitorconsult");
            return (Criteria) this;
        }

        public Criteria andVisitorconsultBetween(Boolean value1, Boolean value2) {
            addCriterion("visitorConsult between", value1, value2, "visitorconsult");
            return (Criteria) this;
        }

        public Criteria andVisitorconsultNotBetween(Boolean value1, Boolean value2) {
            addCriterion("visitorConsult not between", value1, value2, "visitorconsult");
            return (Criteria) this;
        }

        public Criteria andVoucherIsNull() {
            addCriterion("voucher is null");
            return (Criteria) this;
        }

        public Criteria andVoucherIsNotNull() {
            addCriterion("voucher is not null");
            return (Criteria) this;
        }

        public Criteria andVoucherEqualTo(Boolean value) {
            addCriterion("voucher =", value, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherNotEqualTo(Boolean value) {
            addCriterion("voucher <>", value, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherGreaterThan(Boolean value) {
            addCriterion("voucher >", value, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherGreaterThanOrEqualTo(Boolean value) {
            addCriterion("voucher >=", value, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherLessThan(Boolean value) {
            addCriterion("voucher <", value, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherLessThanOrEqualTo(Boolean value) {
            addCriterion("voucher <=", value, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherIn(List<Boolean> values) {
            addCriterion("voucher in", values, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherNotIn(List<Boolean> values) {
            addCriterion("voucher not in", values, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherBetween(Boolean value1, Boolean value2) {
            addCriterion("voucher between", value1, value2, "voucher");
            return (Criteria) this;
        }

        public Criteria andVoucherNotBetween(Boolean value1, Boolean value2) {
            addCriterion("voucher not between", value1, value2, "voucher");
            return (Criteria) this;
        }

        public Criteria andWebsitenameIsNull() {
            addCriterion("websiteName is null");
            return (Criteria) this;
        }

        public Criteria andWebsitenameIsNotNull() {
            addCriterion("websiteName is not null");
            return (Criteria) this;
        }

        public Criteria andWebsitenameEqualTo(String value) {
            addCriterion("websiteName =", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameNotEqualTo(String value) {
            addCriterion("websiteName <>", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameGreaterThan(String value) {
            addCriterion("websiteName >", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameGreaterThanOrEqualTo(String value) {
            addCriterion("websiteName >=", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameLessThan(String value) {
            addCriterion("websiteName <", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameLessThanOrEqualTo(String value) {
            addCriterion("websiteName <=", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameLike(String value) {
            addCriterion("websiteName like", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameNotLike(String value) {
            addCriterion("websiteName not like", value, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameIn(List<String> values) {
            addCriterion("websiteName in", values, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameNotIn(List<String> values) {
            addCriterion("websiteName not in", values, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameBetween(String value1, String value2) {
            addCriterion("websiteName between", value1, value2, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitenameNotBetween(String value1, String value2) {
            addCriterion("websiteName not between", value1, value2, "websitename");
            return (Criteria) this;
        }

        public Criteria andWebsitestateIsNull() {
            addCriterion("websiteState is null");
            return (Criteria) this;
        }

        public Criteria andWebsitestateIsNotNull() {
            addCriterion("websiteState is not null");
            return (Criteria) this;
        }

        public Criteria andWebsitestateEqualTo(Boolean value) {
            addCriterion("websiteState =", value, "websitestate");
            return (Criteria) this;
        }

        public Criteria andWebsitestateNotEqualTo(Boolean value) {
            addCriterion("websiteState <>", value, "websitestate");
            return (Criteria) this;
        }

        public Criteria andWebsitestateGreaterThan(Boolean value) {
            addCriterion("websiteState >", value, "websitestate");
            return (Criteria) this;
        }

        public Criteria andWebsitestateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("websiteState >=", value, "websitestate");
            return (Criteria) this;
        }

        public Criteria andWebsitestateLessThan(Boolean value) {
            addCriterion("websiteState <", value, "websitestate");
            return (Criteria) this;
        }

        public Criteria andWebsitestateLessThanOrEqualTo(Boolean value) {
            addCriterion("websiteState <=", value, "websitestate");
            return (Criteria) this;
        }

        public Criteria andWebsitestateIn(List<Boolean> values) {
            addCriterion("websiteState in", values, "websitestate");
            return (Criteria) this;
        }

        public Criteria andWebsitestateNotIn(List<Boolean> values) {
            addCriterion("websiteState not in", values, "websitestate");
            return (Criteria) this;
        }

        public Criteria andWebsitestateBetween(Boolean value1, Boolean value2) {
            addCriterion("websiteState between", value1, value2, "websitestate");
            return (Criteria) this;
        }

        public Criteria andWebsitestateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("websiteState not between", value1, value2, "websitestate");
            return (Criteria) this;
        }

        public Criteria andZtcPriceIsNull() {
            addCriterion("ztc_price is null");
            return (Criteria) this;
        }

        public Criteria andZtcPriceIsNotNull() {
            addCriterion("ztc_price is not null");
            return (Criteria) this;
        }

        public Criteria andZtcPriceEqualTo(Integer value) {
            addCriterion("ztc_price =", value, "ztcPrice");
            return (Criteria) this;
        }

        public Criteria andZtcPriceNotEqualTo(Integer value) {
            addCriterion("ztc_price <>", value, "ztcPrice");
            return (Criteria) this;
        }

        public Criteria andZtcPriceGreaterThan(Integer value) {
            addCriterion("ztc_price >", value, "ztcPrice");
            return (Criteria) this;
        }

        public Criteria andZtcPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("ztc_price >=", value, "ztcPrice");
            return (Criteria) this;
        }

        public Criteria andZtcPriceLessThan(Integer value) {
            addCriterion("ztc_price <", value, "ztcPrice");
            return (Criteria) this;
        }

        public Criteria andZtcPriceLessThanOrEqualTo(Integer value) {
            addCriterion("ztc_price <=", value, "ztcPrice");
            return (Criteria) this;
        }

        public Criteria andZtcPriceIn(List<Integer> values) {
            addCriterion("ztc_price in", values, "ztcPrice");
            return (Criteria) this;
        }

        public Criteria andZtcPriceNotIn(List<Integer> values) {
            addCriterion("ztc_price not in", values, "ztcPrice");
            return (Criteria) this;
        }

        public Criteria andZtcPriceBetween(Integer value1, Integer value2) {
            addCriterion("ztc_price between", value1, value2, "ztcPrice");
            return (Criteria) this;
        }

        public Criteria andZtcPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("ztc_price not between", value1, value2, "ztcPrice");
            return (Criteria) this;
        }

        public Criteria andZtcStatusIsNull() {
            addCriterion("ztc_status is null");
            return (Criteria) this;
        }

        public Criteria andZtcStatusIsNotNull() {
            addCriterion("ztc_status is not null");
            return (Criteria) this;
        }

        public Criteria andZtcStatusEqualTo(Boolean value) {
            addCriterion("ztc_status =", value, "ztcStatus");
            return (Criteria) this;
        }

        public Criteria andZtcStatusNotEqualTo(Boolean value) {
            addCriterion("ztc_status <>", value, "ztcStatus");
            return (Criteria) this;
        }

        public Criteria andZtcStatusGreaterThan(Boolean value) {
            addCriterion("ztc_status >", value, "ztcStatus");
            return (Criteria) this;
        }

        public Criteria andZtcStatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("ztc_status >=", value, "ztcStatus");
            return (Criteria) this;
        }

        public Criteria andZtcStatusLessThan(Boolean value) {
            addCriterion("ztc_status <", value, "ztcStatus");
            return (Criteria) this;
        }

        public Criteria andZtcStatusLessThanOrEqualTo(Boolean value) {
            addCriterion("ztc_status <=", value, "ztcStatus");
            return (Criteria) this;
        }

        public Criteria andZtcStatusIn(List<Boolean> values) {
            addCriterion("ztc_status in", values, "ztcStatus");
            return (Criteria) this;
        }

        public Criteria andZtcStatusNotIn(List<Boolean> values) {
            addCriterion("ztc_status not in", values, "ztcStatus");
            return (Criteria) this;
        }

        public Criteria andZtcStatusBetween(Boolean value1, Boolean value2) {
            addCriterion("ztc_status between", value1, value2, "ztcStatus");
            return (Criteria) this;
        }

        public Criteria andZtcStatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("ztc_status not between", value1, value2, "ztcStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIdIsNull() {
            addCriterion("goodsImage_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIdIsNotNull() {
            addCriterion("goodsImage_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIdEqualTo(Long value) {
            addCriterion("goodsImage_id =", value, "goodsimageId");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIdNotEqualTo(Long value) {
            addCriterion("goodsImage_id <>", value, "goodsimageId");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIdGreaterThan(Long value) {
            addCriterion("goodsImage_id >", value, "goodsimageId");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goodsImage_id >=", value, "goodsimageId");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIdLessThan(Long value) {
            addCriterion("goodsImage_id <", value, "goodsimageId");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIdLessThanOrEqualTo(Long value) {
            addCriterion("goodsImage_id <=", value, "goodsimageId");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIdIn(List<Long> values) {
            addCriterion("goodsImage_id in", values, "goodsimageId");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIdNotIn(List<Long> values) {
            addCriterion("goodsImage_id not in", values, "goodsimageId");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIdBetween(Long value1, Long value2) {
            addCriterion("goodsImage_id between", value1, value2, "goodsimageId");
            return (Criteria) this;
        }

        public Criteria andGoodsimageIdNotBetween(Long value1, Long value2) {
            addCriterion("goodsImage_id not between", value1, value2, "goodsimageId");
            return (Criteria) this;
        }

        public Criteria andMembericonIdIsNull() {
            addCriterion("memberIcon_id is null");
            return (Criteria) this;
        }

        public Criteria andMembericonIdIsNotNull() {
            addCriterion("memberIcon_id is not null");
            return (Criteria) this;
        }

        public Criteria andMembericonIdEqualTo(Long value) {
            addCriterion("memberIcon_id =", value, "membericonId");
            return (Criteria) this;
        }

        public Criteria andMembericonIdNotEqualTo(Long value) {
            addCriterion("memberIcon_id <>", value, "membericonId");
            return (Criteria) this;
        }

        public Criteria andMembericonIdGreaterThan(Long value) {
            addCriterion("memberIcon_id >", value, "membericonId");
            return (Criteria) this;
        }

        public Criteria andMembericonIdGreaterThanOrEqualTo(Long value) {
            addCriterion("memberIcon_id >=", value, "membericonId");
            return (Criteria) this;
        }

        public Criteria andMembericonIdLessThan(Long value) {
            addCriterion("memberIcon_id <", value, "membericonId");
            return (Criteria) this;
        }

        public Criteria andMembericonIdLessThanOrEqualTo(Long value) {
            addCriterion("memberIcon_id <=", value, "membericonId");
            return (Criteria) this;
        }

        public Criteria andMembericonIdIn(List<Long> values) {
            addCriterion("memberIcon_id in", values, "membericonId");
            return (Criteria) this;
        }

        public Criteria andMembericonIdNotIn(List<Long> values) {
            addCriterion("memberIcon_id not in", values, "membericonId");
            return (Criteria) this;
        }

        public Criteria andMembericonIdBetween(Long value1, Long value2) {
            addCriterion("memberIcon_id between", value1, value2, "membericonId");
            return (Criteria) this;
        }

        public Criteria andMembericonIdNotBetween(Long value1, Long value2) {
            addCriterion("memberIcon_id not between", value1, value2, "membericonId");
            return (Criteria) this;
        }

        public Criteria andStoreimageIdIsNull() {
            addCriterion("storeImage_id is null");
            return (Criteria) this;
        }

        public Criteria andStoreimageIdIsNotNull() {
            addCriterion("storeImage_id is not null");
            return (Criteria) this;
        }

        public Criteria andStoreimageIdEqualTo(Long value) {
            addCriterion("storeImage_id =", value, "storeimageId");
            return (Criteria) this;
        }

        public Criteria andStoreimageIdNotEqualTo(Long value) {
            addCriterion("storeImage_id <>", value, "storeimageId");
            return (Criteria) this;
        }

        public Criteria andStoreimageIdGreaterThan(Long value) {
            addCriterion("storeImage_id >", value, "storeimageId");
            return (Criteria) this;
        }

        public Criteria andStoreimageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("storeImage_id >=", value, "storeimageId");
            return (Criteria) this;
        }

        public Criteria andStoreimageIdLessThan(Long value) {
            addCriterion("storeImage_id <", value, "storeimageId");
            return (Criteria) this;
        }

        public Criteria andStoreimageIdLessThanOrEqualTo(Long value) {
            addCriterion("storeImage_id <=", value, "storeimageId");
            return (Criteria) this;
        }

        public Criteria andStoreimageIdIn(List<Long> values) {
            addCriterion("storeImage_id in", values, "storeimageId");
            return (Criteria) this;
        }

        public Criteria andStoreimageIdNotIn(List<Long> values) {
            addCriterion("storeImage_id not in", values, "storeimageId");
            return (Criteria) this;
        }

        public Criteria andStoreimageIdBetween(Long value1, Long value2) {
            addCriterion("storeImage_id between", value1, value2, "storeimageId");
            return (Criteria) this;
        }

        public Criteria andStoreimageIdNotBetween(Long value1, Long value2) {
            addCriterion("storeImage_id not between", value1, value2, "storeimageId");
            return (Criteria) this;
        }

        public Criteria andWebsitelogoIdIsNull() {
            addCriterion("websiteLogo_id is null");
            return (Criteria) this;
        }

        public Criteria andWebsitelogoIdIsNotNull() {
            addCriterion("websiteLogo_id is not null");
            return (Criteria) this;
        }

        public Criteria andWebsitelogoIdEqualTo(Long value) {
            addCriterion("websiteLogo_id =", value, "websitelogoId");
            return (Criteria) this;
        }

        public Criteria andWebsitelogoIdNotEqualTo(Long value) {
            addCriterion("websiteLogo_id <>", value, "websitelogoId");
            return (Criteria) this;
        }

        public Criteria andWebsitelogoIdGreaterThan(Long value) {
            addCriterion("websiteLogo_id >", value, "websitelogoId");
            return (Criteria) this;
        }

        public Criteria andWebsitelogoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("websiteLogo_id >=", value, "websitelogoId");
            return (Criteria) this;
        }

        public Criteria andWebsitelogoIdLessThan(Long value) {
            addCriterion("websiteLogo_id <", value, "websitelogoId");
            return (Criteria) this;
        }

        public Criteria andWebsitelogoIdLessThanOrEqualTo(Long value) {
            addCriterion("websiteLogo_id <=", value, "websitelogoId");
            return (Criteria) this;
        }

        public Criteria andWebsitelogoIdIn(List<Long> values) {
            addCriterion("websiteLogo_id in", values, "websitelogoId");
            return (Criteria) this;
        }

        public Criteria andWebsitelogoIdNotIn(List<Long> values) {
            addCriterion("websiteLogo_id not in", values, "websitelogoId");
            return (Criteria) this;
        }

        public Criteria andWebsitelogoIdBetween(Long value1, Long value2) {
            addCriterion("websiteLogo_id between", value1, value2, "websitelogoId");
            return (Criteria) this;
        }

        public Criteria andWebsitelogoIdNotBetween(Long value1, Long value2) {
            addCriterion("websiteLogo_id not between", value1, value2, "websitelogoId");
            return (Criteria) this;
        }

        public Criteria andDomainAllowCountIsNull() {
            addCriterion("domain_allow_count is null");
            return (Criteria) this;
        }

        public Criteria andDomainAllowCountIsNotNull() {
            addCriterion("domain_allow_count is not null");
            return (Criteria) this;
        }

        public Criteria andDomainAllowCountEqualTo(Integer value) {
            addCriterion("domain_allow_count =", value, "domainAllowCount");
            return (Criteria) this;
        }

        public Criteria andDomainAllowCountNotEqualTo(Integer value) {
            addCriterion("domain_allow_count <>", value, "domainAllowCount");
            return (Criteria) this;
        }

        public Criteria andDomainAllowCountGreaterThan(Integer value) {
            addCriterion("domain_allow_count >", value, "domainAllowCount");
            return (Criteria) this;
        }

        public Criteria andDomainAllowCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("domain_allow_count >=", value, "domainAllowCount");
            return (Criteria) this;
        }

        public Criteria andDomainAllowCountLessThan(Integer value) {
            addCriterion("domain_allow_count <", value, "domainAllowCount");
            return (Criteria) this;
        }

        public Criteria andDomainAllowCountLessThanOrEqualTo(Integer value) {
            addCriterion("domain_allow_count <=", value, "domainAllowCount");
            return (Criteria) this;
        }

        public Criteria andDomainAllowCountIn(List<Integer> values) {
            addCriterion("domain_allow_count in", values, "domainAllowCount");
            return (Criteria) this;
        }

        public Criteria andDomainAllowCountNotIn(List<Integer> values) {
            addCriterion("domain_allow_count not in", values, "domainAllowCount");
            return (Criteria) this;
        }

        public Criteria andDomainAllowCountBetween(Integer value1, Integer value2) {
            addCriterion("domain_allow_count between", value1, value2, "domainAllowCount");
            return (Criteria) this;
        }

        public Criteria andDomainAllowCountNotBetween(Integer value1, Integer value2) {
            addCriterion("domain_allow_count not between", value1, value2, "domainAllowCount");
            return (Criteria) this;
        }

        public Criteria andSecondDomainOpenIsNull() {
            addCriterion("second_domain_open is null");
            return (Criteria) this;
        }

        public Criteria andSecondDomainOpenIsNotNull() {
            addCriterion("second_domain_open is not null");
            return (Criteria) this;
        }

        public Criteria andSecondDomainOpenEqualTo(Boolean value) {
            addCriterion("second_domain_open =", value, "secondDomainOpen");
            return (Criteria) this;
        }

        public Criteria andSecondDomainOpenNotEqualTo(Boolean value) {
            addCriterion("second_domain_open <>", value, "secondDomainOpen");
            return (Criteria) this;
        }

        public Criteria andSecondDomainOpenGreaterThan(Boolean value) {
            addCriterion("second_domain_open >", value, "secondDomainOpen");
            return (Criteria) this;
        }

        public Criteria andSecondDomainOpenGreaterThanOrEqualTo(Boolean value) {
            addCriterion("second_domain_open >=", value, "secondDomainOpen");
            return (Criteria) this;
        }

        public Criteria andSecondDomainOpenLessThan(Boolean value) {
            addCriterion("second_domain_open <", value, "secondDomainOpen");
            return (Criteria) this;
        }

        public Criteria andSecondDomainOpenLessThanOrEqualTo(Boolean value) {
            addCriterion("second_domain_open <=", value, "secondDomainOpen");
            return (Criteria) this;
        }

        public Criteria andSecondDomainOpenIn(List<Boolean> values) {
            addCriterion("second_domain_open in", values, "secondDomainOpen");
            return (Criteria) this;
        }

        public Criteria andSecondDomainOpenNotIn(List<Boolean> values) {
            addCriterion("second_domain_open not in", values, "secondDomainOpen");
            return (Criteria) this;
        }

        public Criteria andSecondDomainOpenBetween(Boolean value1, Boolean value2) {
            addCriterion("second_domain_open between", value1, value2, "secondDomainOpen");
            return (Criteria) this;
        }

        public Criteria andSecondDomainOpenNotBetween(Boolean value1, Boolean value2) {
            addCriterion("second_domain_open not between", value1, value2, "secondDomainOpen");
            return (Criteria) this;
        }

        public Criteria andQqLoginIsNull() {
            addCriterion("qq_login is null");
            return (Criteria) this;
        }

        public Criteria andQqLoginIsNotNull() {
            addCriterion("qq_login is not null");
            return (Criteria) this;
        }

        public Criteria andQqLoginEqualTo(Boolean value) {
            addCriterion("qq_login =", value, "qqLogin");
            return (Criteria) this;
        }

        public Criteria andQqLoginNotEqualTo(Boolean value) {
            addCriterion("qq_login <>", value, "qqLogin");
            return (Criteria) this;
        }

        public Criteria andQqLoginGreaterThan(Boolean value) {
            addCriterion("qq_login >", value, "qqLogin");
            return (Criteria) this;
        }

        public Criteria andQqLoginGreaterThanOrEqualTo(Boolean value) {
            addCriterion("qq_login >=", value, "qqLogin");
            return (Criteria) this;
        }

        public Criteria andQqLoginLessThan(Boolean value) {
            addCriterion("qq_login <", value, "qqLogin");
            return (Criteria) this;
        }

        public Criteria andQqLoginLessThanOrEqualTo(Boolean value) {
            addCriterion("qq_login <=", value, "qqLogin");
            return (Criteria) this;
        }

        public Criteria andQqLoginIn(List<Boolean> values) {
            addCriterion("qq_login in", values, "qqLogin");
            return (Criteria) this;
        }

        public Criteria andQqLoginNotIn(List<Boolean> values) {
            addCriterion("qq_login not in", values, "qqLogin");
            return (Criteria) this;
        }

        public Criteria andQqLoginBetween(Boolean value1, Boolean value2) {
            addCriterion("qq_login between", value1, value2, "qqLogin");
            return (Criteria) this;
        }

        public Criteria andQqLoginNotBetween(Boolean value1, Boolean value2) {
            addCriterion("qq_login not between", value1, value2, "qqLogin");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdIsNull() {
            addCriterion("qq_login_id is null");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdIsNotNull() {
            addCriterion("qq_login_id is not null");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdEqualTo(String value) {
            addCriterion("qq_login_id =", value, "qqLoginId");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdNotEqualTo(String value) {
            addCriterion("qq_login_id <>", value, "qqLoginId");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdGreaterThan(String value) {
            addCriterion("qq_login_id >", value, "qqLoginId");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdGreaterThanOrEqualTo(String value) {
            addCriterion("qq_login_id >=", value, "qqLoginId");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdLessThan(String value) {
            addCriterion("qq_login_id <", value, "qqLoginId");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdLessThanOrEqualTo(String value) {
            addCriterion("qq_login_id <=", value, "qqLoginId");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdLike(String value) {
            addCriterion("qq_login_id like", value, "qqLoginId");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdNotLike(String value) {
            addCriterion("qq_login_id not like", value, "qqLoginId");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdIn(List<String> values) {
            addCriterion("qq_login_id in", values, "qqLoginId");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdNotIn(List<String> values) {
            addCriterion("qq_login_id not in", values, "qqLoginId");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdBetween(String value1, String value2) {
            addCriterion("qq_login_id between", value1, value2, "qqLoginId");
            return (Criteria) this;
        }

        public Criteria andQqLoginIdNotBetween(String value1, String value2) {
            addCriterion("qq_login_id not between", value1, value2, "qqLoginId");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyIsNull() {
            addCriterion("qq_login_key is null");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyIsNotNull() {
            addCriterion("qq_login_key is not null");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyEqualTo(String value) {
            addCriterion("qq_login_key =", value, "qqLoginKey");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyNotEqualTo(String value) {
            addCriterion("qq_login_key <>", value, "qqLoginKey");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyGreaterThan(String value) {
            addCriterion("qq_login_key >", value, "qqLoginKey");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyGreaterThanOrEqualTo(String value) {
            addCriterion("qq_login_key >=", value, "qqLoginKey");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyLessThan(String value) {
            addCriterion("qq_login_key <", value, "qqLoginKey");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyLessThanOrEqualTo(String value) {
            addCriterion("qq_login_key <=", value, "qqLoginKey");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyLike(String value) {
            addCriterion("qq_login_key like", value, "qqLoginKey");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyNotLike(String value) {
            addCriterion("qq_login_key not like", value, "qqLoginKey");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyIn(List<String> values) {
            addCriterion("qq_login_key in", values, "qqLoginKey");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyNotIn(List<String> values) {
            addCriterion("qq_login_key not in", values, "qqLoginKey");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyBetween(String value1, String value2) {
            addCriterion("qq_login_key between", value1, value2, "qqLoginKey");
            return (Criteria) this;
        }

        public Criteria andQqLoginKeyNotBetween(String value1, String value2) {
            addCriterion("qq_login_key not between", value1, value2, "qqLoginKey");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIsNull() {
            addCriterion("sina_login is null");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIsNotNull() {
            addCriterion("sina_login is not null");
            return (Criteria) this;
        }

        public Criteria andSinaLoginEqualTo(Boolean value) {
            addCriterion("sina_login =", value, "sinaLogin");
            return (Criteria) this;
        }

        public Criteria andSinaLoginNotEqualTo(Boolean value) {
            addCriterion("sina_login <>", value, "sinaLogin");
            return (Criteria) this;
        }

        public Criteria andSinaLoginGreaterThan(Boolean value) {
            addCriterion("sina_login >", value, "sinaLogin");
            return (Criteria) this;
        }

        public Criteria andSinaLoginGreaterThanOrEqualTo(Boolean value) {
            addCriterion("sina_login >=", value, "sinaLogin");
            return (Criteria) this;
        }

        public Criteria andSinaLoginLessThan(Boolean value) {
            addCriterion("sina_login <", value, "sinaLogin");
            return (Criteria) this;
        }

        public Criteria andSinaLoginLessThanOrEqualTo(Boolean value) {
            addCriterion("sina_login <=", value, "sinaLogin");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIn(List<Boolean> values) {
            addCriterion("sina_login in", values, "sinaLogin");
            return (Criteria) this;
        }

        public Criteria andSinaLoginNotIn(List<Boolean> values) {
            addCriterion("sina_login not in", values, "sinaLogin");
            return (Criteria) this;
        }

        public Criteria andSinaLoginBetween(Boolean value1, Boolean value2) {
            addCriterion("sina_login between", value1, value2, "sinaLogin");
            return (Criteria) this;
        }

        public Criteria andSinaLoginNotBetween(Boolean value1, Boolean value2) {
            addCriterion("sina_login not between", value1, value2, "sinaLogin");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdIsNull() {
            addCriterion("sina_login_id is null");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdIsNotNull() {
            addCriterion("sina_login_id is not null");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdEqualTo(String value) {
            addCriterion("sina_login_id =", value, "sinaLoginId");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdNotEqualTo(String value) {
            addCriterion("sina_login_id <>", value, "sinaLoginId");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdGreaterThan(String value) {
            addCriterion("sina_login_id >", value, "sinaLoginId");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdGreaterThanOrEqualTo(String value) {
            addCriterion("sina_login_id >=", value, "sinaLoginId");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdLessThan(String value) {
            addCriterion("sina_login_id <", value, "sinaLoginId");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdLessThanOrEqualTo(String value) {
            addCriterion("sina_login_id <=", value, "sinaLoginId");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdLike(String value) {
            addCriterion("sina_login_id like", value, "sinaLoginId");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdNotLike(String value) {
            addCriterion("sina_login_id not like", value, "sinaLoginId");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdIn(List<String> values) {
            addCriterion("sina_login_id in", values, "sinaLoginId");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdNotIn(List<String> values) {
            addCriterion("sina_login_id not in", values, "sinaLoginId");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdBetween(String value1, String value2) {
            addCriterion("sina_login_id between", value1, value2, "sinaLoginId");
            return (Criteria) this;
        }

        public Criteria andSinaLoginIdNotBetween(String value1, String value2) {
            addCriterion("sina_login_id not between", value1, value2, "sinaLoginId");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyIsNull() {
            addCriterion("sina_login_key is null");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyIsNotNull() {
            addCriterion("sina_login_key is not null");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyEqualTo(String value) {
            addCriterion("sina_login_key =", value, "sinaLoginKey");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyNotEqualTo(String value) {
            addCriterion("sina_login_key <>", value, "sinaLoginKey");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyGreaterThan(String value) {
            addCriterion("sina_login_key >", value, "sinaLoginKey");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyGreaterThanOrEqualTo(String value) {
            addCriterion("sina_login_key >=", value, "sinaLoginKey");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyLessThan(String value) {
            addCriterion("sina_login_key <", value, "sinaLoginKey");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyLessThanOrEqualTo(String value) {
            addCriterion("sina_login_key <=", value, "sinaLoginKey");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyLike(String value) {
            addCriterion("sina_login_key like", value, "sinaLoginKey");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyNotLike(String value) {
            addCriterion("sina_login_key not like", value, "sinaLoginKey");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyIn(List<String> values) {
            addCriterion("sina_login_key in", values, "sinaLoginKey");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyNotIn(List<String> values) {
            addCriterion("sina_login_key not in", values, "sinaLoginKey");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyBetween(String value1, String value2) {
            addCriterion("sina_login_key between", value1, value2, "sinaLoginKey");
            return (Criteria) this;
        }

        public Criteria andSinaLoginKeyNotBetween(String value1, String value2) {
            addCriterion("sina_login_key not between", value1, value2, "sinaLoginKey");
            return (Criteria) this;
        }

        public Criteria andImagewebserverIsNull() {
            addCriterion("imageWebServer is null");
            return (Criteria) this;
        }

        public Criteria andImagewebserverIsNotNull() {
            addCriterion("imageWebServer is not null");
            return (Criteria) this;
        }

        public Criteria andImagewebserverEqualTo(String value) {
            addCriterion("imageWebServer =", value, "imagewebserver");
            return (Criteria) this;
        }

        public Criteria andImagewebserverNotEqualTo(String value) {
            addCriterion("imageWebServer <>", value, "imagewebserver");
            return (Criteria) this;
        }

        public Criteria andImagewebserverGreaterThan(String value) {
            addCriterion("imageWebServer >", value, "imagewebserver");
            return (Criteria) this;
        }

        public Criteria andImagewebserverGreaterThanOrEqualTo(String value) {
            addCriterion("imageWebServer >=", value, "imagewebserver");
            return (Criteria) this;
        }

        public Criteria andImagewebserverLessThan(String value) {
            addCriterion("imageWebServer <", value, "imagewebserver");
            return (Criteria) this;
        }

        public Criteria andImagewebserverLessThanOrEqualTo(String value) {
            addCriterion("imageWebServer <=", value, "imagewebserver");
            return (Criteria) this;
        }

        public Criteria andImagewebserverLike(String value) {
            addCriterion("imageWebServer like", value, "imagewebserver");
            return (Criteria) this;
        }

        public Criteria andImagewebserverNotLike(String value) {
            addCriterion("imageWebServer not like", value, "imagewebserver");
            return (Criteria) this;
        }

        public Criteria andImagewebserverIn(List<String> values) {
            addCriterion("imageWebServer in", values, "imagewebserver");
            return (Criteria) this;
        }

        public Criteria andImagewebserverNotIn(List<String> values) {
            addCriterion("imageWebServer not in", values, "imagewebserver");
            return (Criteria) this;
        }

        public Criteria andImagewebserverBetween(String value1, String value2) {
            addCriterion("imageWebServer between", value1, value2, "imagewebserver");
            return (Criteria) this;
        }

        public Criteria andImagewebserverNotBetween(String value1, String value2) {
            addCriterion("imageWebServer not between", value1, value2, "imagewebserver");
            return (Criteria) this;
        }

        public Criteria andLuceneUpdateIsNull() {
            addCriterion("lucene_update is null");
            return (Criteria) this;
        }

        public Criteria andLuceneUpdateIsNotNull() {
            addCriterion("lucene_update is not null");
            return (Criteria) this;
        }

        public Criteria andLuceneUpdateEqualTo(Date value) {
            addCriterion("lucene_update =", value, "luceneUpdate");
            return (Criteria) this;
        }

        public Criteria andLuceneUpdateNotEqualTo(Date value) {
            addCriterion("lucene_update <>", value, "luceneUpdate");
            return (Criteria) this;
        }

        public Criteria andLuceneUpdateGreaterThan(Date value) {
            addCriterion("lucene_update >", value, "luceneUpdate");
            return (Criteria) this;
        }

        public Criteria andLuceneUpdateGreaterThanOrEqualTo(Date value) {
            addCriterion("lucene_update >=", value, "luceneUpdate");
            return (Criteria) this;
        }

        public Criteria andLuceneUpdateLessThan(Date value) {
            addCriterion("lucene_update <", value, "luceneUpdate");
            return (Criteria) this;
        }

        public Criteria andLuceneUpdateLessThanOrEqualTo(Date value) {
            addCriterion("lucene_update <=", value, "luceneUpdate");
            return (Criteria) this;
        }

        public Criteria andLuceneUpdateIn(List<Date> values) {
            addCriterion("lucene_update in", values, "luceneUpdate");
            return (Criteria) this;
        }

        public Criteria andLuceneUpdateNotIn(List<Date> values) {
            addCriterion("lucene_update not in", values, "luceneUpdate");
            return (Criteria) this;
        }

        public Criteria andLuceneUpdateBetween(Date value1, Date value2) {
            addCriterion("lucene_update between", value1, value2, "luceneUpdate");
            return (Criteria) this;
        }

        public Criteria andLuceneUpdateNotBetween(Date value1, Date value2) {
            addCriterion("lucene_update not between", value1, value2, "luceneUpdate");
            return (Criteria) this;
        }

        public Criteria andAlipayFenrunIsNull() {
            addCriterion("alipay_fenrun is null");
            return (Criteria) this;
        }

        public Criteria andAlipayFenrunIsNotNull() {
            addCriterion("alipay_fenrun is not null");
            return (Criteria) this;
        }

        public Criteria andAlipayFenrunEqualTo(Integer value) {
            addCriterion("alipay_fenrun =", value, "alipayFenrun");
            return (Criteria) this;
        }

        public Criteria andAlipayFenrunNotEqualTo(Integer value) {
            addCriterion("alipay_fenrun <>", value, "alipayFenrun");
            return (Criteria) this;
        }

        public Criteria andAlipayFenrunGreaterThan(Integer value) {
            addCriterion("alipay_fenrun >", value, "alipayFenrun");
            return (Criteria) this;
        }

        public Criteria andAlipayFenrunGreaterThanOrEqualTo(Integer value) {
            addCriterion("alipay_fenrun >=", value, "alipayFenrun");
            return (Criteria) this;
        }

        public Criteria andAlipayFenrunLessThan(Integer value) {
            addCriterion("alipay_fenrun <", value, "alipayFenrun");
            return (Criteria) this;
        }

        public Criteria andAlipayFenrunLessThanOrEqualTo(Integer value) {
            addCriterion("alipay_fenrun <=", value, "alipayFenrun");
            return (Criteria) this;
        }

        public Criteria andAlipayFenrunIn(List<Integer> values) {
            addCriterion("alipay_fenrun in", values, "alipayFenrun");
            return (Criteria) this;
        }

        public Criteria andAlipayFenrunNotIn(List<Integer> values) {
            addCriterion("alipay_fenrun not in", values, "alipayFenrun");
            return (Criteria) this;
        }

        public Criteria andAlipayFenrunBetween(Integer value1, Integer value2) {
            addCriterion("alipay_fenrun between", value1, value2, "alipayFenrun");
            return (Criteria) this;
        }

        public Criteria andAlipayFenrunNotBetween(Integer value1, Integer value2) {
            addCriterion("alipay_fenrun not between", value1, value2, "alipayFenrun");
            return (Criteria) this;
        }

        public Criteria andBalanceFenrunIsNull() {
            addCriterion("balance_fenrun is null");
            return (Criteria) this;
        }

        public Criteria andBalanceFenrunIsNotNull() {
            addCriterion("balance_fenrun is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceFenrunEqualTo(Integer value) {
            addCriterion("balance_fenrun =", value, "balanceFenrun");
            return (Criteria) this;
        }

        public Criteria andBalanceFenrunNotEqualTo(Integer value) {
            addCriterion("balance_fenrun <>", value, "balanceFenrun");
            return (Criteria) this;
        }

        public Criteria andBalanceFenrunGreaterThan(Integer value) {
            addCriterion("balance_fenrun >", value, "balanceFenrun");
            return (Criteria) this;
        }

        public Criteria andBalanceFenrunGreaterThanOrEqualTo(Integer value) {
            addCriterion("balance_fenrun >=", value, "balanceFenrun");
            return (Criteria) this;
        }

        public Criteria andBalanceFenrunLessThan(Integer value) {
            addCriterion("balance_fenrun <", value, "balanceFenrun");
            return (Criteria) this;
        }

        public Criteria andBalanceFenrunLessThanOrEqualTo(Integer value) {
            addCriterion("balance_fenrun <=", value, "balanceFenrun");
            return (Criteria) this;
        }

        public Criteria andBalanceFenrunIn(List<Integer> values) {
            addCriterion("balance_fenrun in", values, "balanceFenrun");
            return (Criteria) this;
        }

        public Criteria andBalanceFenrunNotIn(List<Integer> values) {
            addCriterion("balance_fenrun not in", values, "balanceFenrun");
            return (Criteria) this;
        }

        public Criteria andBalanceFenrunBetween(Integer value1, Integer value2) {
            addCriterion("balance_fenrun between", value1, value2, "balanceFenrun");
            return (Criteria) this;
        }

        public Criteria andBalanceFenrunNotBetween(Integer value1, Integer value2) {
            addCriterion("balance_fenrun not between", value1, value2, "balanceFenrun");
            return (Criteria) this;
        }

        public Criteria andAutoOrderConfirmIsNull() {
            addCriterion("auto_order_confirm is null");
            return (Criteria) this;
        }

        public Criteria andAutoOrderConfirmIsNotNull() {
            addCriterion("auto_order_confirm is not null");
            return (Criteria) this;
        }

        public Criteria andAutoOrderConfirmEqualTo(Integer value) {
            addCriterion("auto_order_confirm =", value, "autoOrderConfirm");
            return (Criteria) this;
        }

        public Criteria andAutoOrderConfirmNotEqualTo(Integer value) {
            addCriterion("auto_order_confirm <>", value, "autoOrderConfirm");
            return (Criteria) this;
        }

        public Criteria andAutoOrderConfirmGreaterThan(Integer value) {
            addCriterion("auto_order_confirm >", value, "autoOrderConfirm");
            return (Criteria) this;
        }

        public Criteria andAutoOrderConfirmGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_order_confirm >=", value, "autoOrderConfirm");
            return (Criteria) this;
        }

        public Criteria andAutoOrderConfirmLessThan(Integer value) {
            addCriterion("auto_order_confirm <", value, "autoOrderConfirm");
            return (Criteria) this;
        }

        public Criteria andAutoOrderConfirmLessThanOrEqualTo(Integer value) {
            addCriterion("auto_order_confirm <=", value, "autoOrderConfirm");
            return (Criteria) this;
        }

        public Criteria andAutoOrderConfirmIn(List<Integer> values) {
            addCriterion("auto_order_confirm in", values, "autoOrderConfirm");
            return (Criteria) this;
        }

        public Criteria andAutoOrderConfirmNotIn(List<Integer> values) {
            addCriterion("auto_order_confirm not in", values, "autoOrderConfirm");
            return (Criteria) this;
        }

        public Criteria andAutoOrderConfirmBetween(Integer value1, Integer value2) {
            addCriterion("auto_order_confirm between", value1, value2, "autoOrderConfirm");
            return (Criteria) this;
        }

        public Criteria andAutoOrderConfirmNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_order_confirm not between", value1, value2, "autoOrderConfirm");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNoticeIsNull() {
            addCriterion("auto_order_notice is null");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNoticeIsNotNull() {
            addCriterion("auto_order_notice is not null");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNoticeEqualTo(Integer value) {
            addCriterion("auto_order_notice =", value, "autoOrderNotice");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNoticeNotEqualTo(Integer value) {
            addCriterion("auto_order_notice <>", value, "autoOrderNotice");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNoticeGreaterThan(Integer value) {
            addCriterion("auto_order_notice >", value, "autoOrderNotice");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNoticeGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_order_notice >=", value, "autoOrderNotice");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNoticeLessThan(Integer value) {
            addCriterion("auto_order_notice <", value, "autoOrderNotice");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNoticeLessThanOrEqualTo(Integer value) {
            addCriterion("auto_order_notice <=", value, "autoOrderNotice");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNoticeIn(List<Integer> values) {
            addCriterion("auto_order_notice in", values, "autoOrderNotice");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNoticeNotIn(List<Integer> values) {
            addCriterion("auto_order_notice not in", values, "autoOrderNotice");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNoticeBetween(Integer value1, Integer value2) {
            addCriterion("auto_order_notice between", value1, value2, "autoOrderNotice");
            return (Criteria) this;
        }

        public Criteria andAutoOrderNoticeNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_order_notice not between", value1, value2, "autoOrderNotice");
            return (Criteria) this;
        }

        public Criteria andBargainMaximumIsNull() {
            addCriterion("bargain_maximum is null");
            return (Criteria) this;
        }

        public Criteria andBargainMaximumIsNotNull() {
            addCriterion("bargain_maximum is not null");
            return (Criteria) this;
        }

        public Criteria andBargainMaximumEqualTo(Integer value) {
            addCriterion("bargain_maximum =", value, "bargainMaximum");
            return (Criteria) this;
        }

        public Criteria andBargainMaximumNotEqualTo(Integer value) {
            addCriterion("bargain_maximum <>", value, "bargainMaximum");
            return (Criteria) this;
        }

        public Criteria andBargainMaximumGreaterThan(Integer value) {
            addCriterion("bargain_maximum >", value, "bargainMaximum");
            return (Criteria) this;
        }

        public Criteria andBargainMaximumGreaterThanOrEqualTo(Integer value) {
            addCriterion("bargain_maximum >=", value, "bargainMaximum");
            return (Criteria) this;
        }

        public Criteria andBargainMaximumLessThan(Integer value) {
            addCriterion("bargain_maximum <", value, "bargainMaximum");
            return (Criteria) this;
        }

        public Criteria andBargainMaximumLessThanOrEqualTo(Integer value) {
            addCriterion("bargain_maximum <=", value, "bargainMaximum");
            return (Criteria) this;
        }

        public Criteria andBargainMaximumIn(List<Integer> values) {
            addCriterion("bargain_maximum in", values, "bargainMaximum");
            return (Criteria) this;
        }

        public Criteria andBargainMaximumNotIn(List<Integer> values) {
            addCriterion("bargain_maximum not in", values, "bargainMaximum");
            return (Criteria) this;
        }

        public Criteria andBargainMaximumBetween(Integer value1, Integer value2) {
            addCriterion("bargain_maximum between", value1, value2, "bargainMaximum");
            return (Criteria) this;
        }

        public Criteria andBargainMaximumNotBetween(Integer value1, Integer value2) {
            addCriterion("bargain_maximum not between", value1, value2, "bargainMaximum");
            return (Criteria) this;
        }

        public Criteria andBargainRebateIsNull() {
            addCriterion("bargain_rebate is null");
            return (Criteria) this;
        }

        public Criteria andBargainRebateIsNotNull() {
            addCriterion("bargain_rebate is not null");
            return (Criteria) this;
        }

        public Criteria andBargainRebateEqualTo(BigDecimal value) {
            addCriterion("bargain_rebate =", value, "bargainRebate");
            return (Criteria) this;
        }

        public Criteria andBargainRebateNotEqualTo(BigDecimal value) {
            addCriterion("bargain_rebate <>", value, "bargainRebate");
            return (Criteria) this;
        }

        public Criteria andBargainRebateGreaterThan(BigDecimal value) {
            addCriterion("bargain_rebate >", value, "bargainRebate");
            return (Criteria) this;
        }

        public Criteria andBargainRebateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bargain_rebate >=", value, "bargainRebate");
            return (Criteria) this;
        }

        public Criteria andBargainRebateLessThan(BigDecimal value) {
            addCriterion("bargain_rebate <", value, "bargainRebate");
            return (Criteria) this;
        }

        public Criteria andBargainRebateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bargain_rebate <=", value, "bargainRebate");
            return (Criteria) this;
        }

        public Criteria andBargainRebateIn(List<BigDecimal> values) {
            addCriterion("bargain_rebate in", values, "bargainRebate");
            return (Criteria) this;
        }

        public Criteria andBargainRebateNotIn(List<BigDecimal> values) {
            addCriterion("bargain_rebate not in", values, "bargainRebate");
            return (Criteria) this;
        }

        public Criteria andBargainRebateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bargain_rebate between", value1, value2, "bargainRebate");
            return (Criteria) this;
        }

        public Criteria andBargainRebateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bargain_rebate not between", value1, value2, "bargainRebate");
            return (Criteria) this;
        }

        public Criteria andBargainStatusIsNull() {
            addCriterion("bargain_status is null");
            return (Criteria) this;
        }

        public Criteria andBargainStatusIsNotNull() {
            addCriterion("bargain_status is not null");
            return (Criteria) this;
        }

        public Criteria andBargainStatusEqualTo(Integer value) {
            addCriterion("bargain_status =", value, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusNotEqualTo(Integer value) {
            addCriterion("bargain_status <>", value, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusGreaterThan(Integer value) {
            addCriterion("bargain_status >", value, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("bargain_status >=", value, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusLessThan(Integer value) {
            addCriterion("bargain_status <", value, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusLessThanOrEqualTo(Integer value) {
            addCriterion("bargain_status <=", value, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusIn(List<Integer> values) {
            addCriterion("bargain_status in", values, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusNotIn(List<Integer> values) {
            addCriterion("bargain_status not in", values, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusBetween(Integer value1, Integer value2) {
            addCriterion("bargain_status between", value1, value2, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("bargain_status not between", value1, value2, "bargainStatus");
            return (Criteria) this;
        }

        public Criteria andBargainTitleIsNull() {
            addCriterion("bargain_title is null");
            return (Criteria) this;
        }

        public Criteria andBargainTitleIsNotNull() {
            addCriterion("bargain_title is not null");
            return (Criteria) this;
        }

        public Criteria andBargainTitleEqualTo(String value) {
            addCriterion("bargain_title =", value, "bargainTitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleNotEqualTo(String value) {
            addCriterion("bargain_title <>", value, "bargainTitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleGreaterThan(String value) {
            addCriterion("bargain_title >", value, "bargainTitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleGreaterThanOrEqualTo(String value) {
            addCriterion("bargain_title >=", value, "bargainTitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleLessThan(String value) {
            addCriterion("bargain_title <", value, "bargainTitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleLessThanOrEqualTo(String value) {
            addCriterion("bargain_title <=", value, "bargainTitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleLike(String value) {
            addCriterion("bargain_title like", value, "bargainTitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleNotLike(String value) {
            addCriterion("bargain_title not like", value, "bargainTitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleIn(List<String> values) {
            addCriterion("bargain_title in", values, "bargainTitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleNotIn(List<String> values) {
            addCriterion("bargain_title not in", values, "bargainTitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleBetween(String value1, String value2) {
            addCriterion("bargain_title between", value1, value2, "bargainTitle");
            return (Criteria) this;
        }

        public Criteria andBargainTitleNotBetween(String value1, String value2) {
            addCriterion("bargain_title not between", value1, value2, "bargainTitle");
            return (Criteria) this;
        }

        public Criteria andSysDeliveryMaximumIsNull() {
            addCriterion("sys_delivery_maximum is null");
            return (Criteria) this;
        }

        public Criteria andSysDeliveryMaximumIsNotNull() {
            addCriterion("sys_delivery_maximum is not null");
            return (Criteria) this;
        }

        public Criteria andSysDeliveryMaximumEqualTo(Integer value) {
            addCriterion("sys_delivery_maximum =", value, "sysDeliveryMaximum");
            return (Criteria) this;
        }

        public Criteria andSysDeliveryMaximumNotEqualTo(Integer value) {
            addCriterion("sys_delivery_maximum <>", value, "sysDeliveryMaximum");
            return (Criteria) this;
        }

        public Criteria andSysDeliveryMaximumGreaterThan(Integer value) {
            addCriterion("sys_delivery_maximum >", value, "sysDeliveryMaximum");
            return (Criteria) this;
        }

        public Criteria andSysDeliveryMaximumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sys_delivery_maximum >=", value, "sysDeliveryMaximum");
            return (Criteria) this;
        }

        public Criteria andSysDeliveryMaximumLessThan(Integer value) {
            addCriterion("sys_delivery_maximum <", value, "sysDeliveryMaximum");
            return (Criteria) this;
        }

        public Criteria andSysDeliveryMaximumLessThanOrEqualTo(Integer value) {
            addCriterion("sys_delivery_maximum <=", value, "sysDeliveryMaximum");
            return (Criteria) this;
        }

        public Criteria andSysDeliveryMaximumIn(List<Integer> values) {
            addCriterion("sys_delivery_maximum in", values, "sysDeliveryMaximum");
            return (Criteria) this;
        }

        public Criteria andSysDeliveryMaximumNotIn(List<Integer> values) {
            addCriterion("sys_delivery_maximum not in", values, "sysDeliveryMaximum");
            return (Criteria) this;
        }

        public Criteria andSysDeliveryMaximumBetween(Integer value1, Integer value2) {
            addCriterion("sys_delivery_maximum between", value1, value2, "sysDeliveryMaximum");
            return (Criteria) this;
        }

        public Criteria andSysDeliveryMaximumNotBetween(Integer value1, Integer value2) {
            addCriterion("sys_delivery_maximum not between", value1, value2, "sysDeliveryMaximum");
            return (Criteria) this;
        }

        public Criteria andUcBbsIsNull() {
            addCriterion("uc_bbs is null");
            return (Criteria) this;
        }

        public Criteria andUcBbsIsNotNull() {
            addCriterion("uc_bbs is not null");
            return (Criteria) this;
        }

        public Criteria andUcBbsEqualTo(Boolean value) {
            addCriterion("uc_bbs =", value, "ucBbs");
            return (Criteria) this;
        }

        public Criteria andUcBbsNotEqualTo(Boolean value) {
            addCriterion("uc_bbs <>", value, "ucBbs");
            return (Criteria) this;
        }

        public Criteria andUcBbsGreaterThan(Boolean value) {
            addCriterion("uc_bbs >", value, "ucBbs");
            return (Criteria) this;
        }

        public Criteria andUcBbsGreaterThanOrEqualTo(Boolean value) {
            addCriterion("uc_bbs >=", value, "ucBbs");
            return (Criteria) this;
        }

        public Criteria andUcBbsLessThan(Boolean value) {
            addCriterion("uc_bbs <", value, "ucBbs");
            return (Criteria) this;
        }

        public Criteria andUcBbsLessThanOrEqualTo(Boolean value) {
            addCriterion("uc_bbs <=", value, "ucBbs");
            return (Criteria) this;
        }

        public Criteria andUcBbsIn(List<Boolean> values) {
            addCriterion("uc_bbs in", values, "ucBbs");
            return (Criteria) this;
        }

        public Criteria andUcBbsNotIn(List<Boolean> values) {
            addCriterion("uc_bbs not in", values, "ucBbs");
            return (Criteria) this;
        }

        public Criteria andUcBbsBetween(Boolean value1, Boolean value2) {
            addCriterion("uc_bbs between", value1, value2, "ucBbs");
            return (Criteria) this;
        }

        public Criteria andUcBbsNotBetween(Boolean value1, Boolean value2) {
            addCriterion("uc_bbs not between", value1, value2, "ucBbs");
            return (Criteria) this;
        }

        public Criteria andUcApiIsNull() {
            addCriterion("uc_api is null");
            return (Criteria) this;
        }

        public Criteria andUcApiIsNotNull() {
            addCriterion("uc_api is not null");
            return (Criteria) this;
        }

        public Criteria andUcApiEqualTo(String value) {
            addCriterion("uc_api =", value, "ucApi");
            return (Criteria) this;
        }

        public Criteria andUcApiNotEqualTo(String value) {
            addCriterion("uc_api <>", value, "ucApi");
            return (Criteria) this;
        }

        public Criteria andUcApiGreaterThan(String value) {
            addCriterion("uc_api >", value, "ucApi");
            return (Criteria) this;
        }

        public Criteria andUcApiGreaterThanOrEqualTo(String value) {
            addCriterion("uc_api >=", value, "ucApi");
            return (Criteria) this;
        }

        public Criteria andUcApiLessThan(String value) {
            addCriterion("uc_api <", value, "ucApi");
            return (Criteria) this;
        }

        public Criteria andUcApiLessThanOrEqualTo(String value) {
            addCriterion("uc_api <=", value, "ucApi");
            return (Criteria) this;
        }

        public Criteria andUcApiLike(String value) {
            addCriterion("uc_api like", value, "ucApi");
            return (Criteria) this;
        }

        public Criteria andUcApiNotLike(String value) {
            addCriterion("uc_api not like", value, "ucApi");
            return (Criteria) this;
        }

        public Criteria andUcApiIn(List<String> values) {
            addCriterion("uc_api in", values, "ucApi");
            return (Criteria) this;
        }

        public Criteria andUcApiNotIn(List<String> values) {
            addCriterion("uc_api not in", values, "ucApi");
            return (Criteria) this;
        }

        public Criteria andUcApiBetween(String value1, String value2) {
            addCriterion("uc_api between", value1, value2, "ucApi");
            return (Criteria) this;
        }

        public Criteria andUcApiNotBetween(String value1, String value2) {
            addCriterion("uc_api not between", value1, value2, "ucApi");
            return (Criteria) this;
        }

        public Criteria andUcAppidIsNull() {
            addCriterion("uc_appid is null");
            return (Criteria) this;
        }

        public Criteria andUcAppidIsNotNull() {
            addCriterion("uc_appid is not null");
            return (Criteria) this;
        }

        public Criteria andUcAppidEqualTo(String value) {
            addCriterion("uc_appid =", value, "ucAppid");
            return (Criteria) this;
        }

        public Criteria andUcAppidNotEqualTo(String value) {
            addCriterion("uc_appid <>", value, "ucAppid");
            return (Criteria) this;
        }

        public Criteria andUcAppidGreaterThan(String value) {
            addCriterion("uc_appid >", value, "ucAppid");
            return (Criteria) this;
        }

        public Criteria andUcAppidGreaterThanOrEqualTo(String value) {
            addCriterion("uc_appid >=", value, "ucAppid");
            return (Criteria) this;
        }

        public Criteria andUcAppidLessThan(String value) {
            addCriterion("uc_appid <", value, "ucAppid");
            return (Criteria) this;
        }

        public Criteria andUcAppidLessThanOrEqualTo(String value) {
            addCriterion("uc_appid <=", value, "ucAppid");
            return (Criteria) this;
        }

        public Criteria andUcAppidLike(String value) {
            addCriterion("uc_appid like", value, "ucAppid");
            return (Criteria) this;
        }

        public Criteria andUcAppidNotLike(String value) {
            addCriterion("uc_appid not like", value, "ucAppid");
            return (Criteria) this;
        }

        public Criteria andUcAppidIn(List<String> values) {
            addCriterion("uc_appid in", values, "ucAppid");
            return (Criteria) this;
        }

        public Criteria andUcAppidNotIn(List<String> values) {
            addCriterion("uc_appid not in", values, "ucAppid");
            return (Criteria) this;
        }

        public Criteria andUcAppidBetween(String value1, String value2) {
            addCriterion("uc_appid between", value1, value2, "ucAppid");
            return (Criteria) this;
        }

        public Criteria andUcAppidNotBetween(String value1, String value2) {
            addCriterion("uc_appid not between", value1, value2, "ucAppid");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseIsNull() {
            addCriterion("uc_database is null");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseIsNotNull() {
            addCriterion("uc_database is not null");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseEqualTo(String value) {
            addCriterion("uc_database =", value, "ucDatabase");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseNotEqualTo(String value) {
            addCriterion("uc_database <>", value, "ucDatabase");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseGreaterThan(String value) {
            addCriterion("uc_database >", value, "ucDatabase");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseGreaterThanOrEqualTo(String value) {
            addCriterion("uc_database >=", value, "ucDatabase");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseLessThan(String value) {
            addCriterion("uc_database <", value, "ucDatabase");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseLessThanOrEqualTo(String value) {
            addCriterion("uc_database <=", value, "ucDatabase");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseLike(String value) {
            addCriterion("uc_database like", value, "ucDatabase");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseNotLike(String value) {
            addCriterion("uc_database not like", value, "ucDatabase");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseIn(List<String> values) {
            addCriterion("uc_database in", values, "ucDatabase");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseNotIn(List<String> values) {
            addCriterion("uc_database not in", values, "ucDatabase");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseBetween(String value1, String value2) {
            addCriterion("uc_database between", value1, value2, "ucDatabase");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseNotBetween(String value1, String value2) {
            addCriterion("uc_database not between", value1, value2, "ucDatabase");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortIsNull() {
            addCriterion("uc_database_port is null");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortIsNotNull() {
            addCriterion("uc_database_port is not null");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortEqualTo(String value) {
            addCriterion("uc_database_port =", value, "ucDatabasePort");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortNotEqualTo(String value) {
            addCriterion("uc_database_port <>", value, "ucDatabasePort");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortGreaterThan(String value) {
            addCriterion("uc_database_port >", value, "ucDatabasePort");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortGreaterThanOrEqualTo(String value) {
            addCriterion("uc_database_port >=", value, "ucDatabasePort");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortLessThan(String value) {
            addCriterion("uc_database_port <", value, "ucDatabasePort");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortLessThanOrEqualTo(String value) {
            addCriterion("uc_database_port <=", value, "ucDatabasePort");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortLike(String value) {
            addCriterion("uc_database_port like", value, "ucDatabasePort");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortNotLike(String value) {
            addCriterion("uc_database_port not like", value, "ucDatabasePort");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortIn(List<String> values) {
            addCriterion("uc_database_port in", values, "ucDatabasePort");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortNotIn(List<String> values) {
            addCriterion("uc_database_port not in", values, "ucDatabasePort");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortBetween(String value1, String value2) {
            addCriterion("uc_database_port between", value1, value2, "ucDatabasePort");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePortNotBetween(String value1, String value2) {
            addCriterion("uc_database_port not between", value1, value2, "ucDatabasePort");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsIsNull() {
            addCriterion("uc_database_pws is null");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsIsNotNull() {
            addCriterion("uc_database_pws is not null");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsEqualTo(String value) {
            addCriterion("uc_database_pws =", value, "ucDatabasePws");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsNotEqualTo(String value) {
            addCriterion("uc_database_pws <>", value, "ucDatabasePws");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsGreaterThan(String value) {
            addCriterion("uc_database_pws >", value, "ucDatabasePws");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsGreaterThanOrEqualTo(String value) {
            addCriterion("uc_database_pws >=", value, "ucDatabasePws");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsLessThan(String value) {
            addCriterion("uc_database_pws <", value, "ucDatabasePws");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsLessThanOrEqualTo(String value) {
            addCriterion("uc_database_pws <=", value, "ucDatabasePws");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsLike(String value) {
            addCriterion("uc_database_pws like", value, "ucDatabasePws");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsNotLike(String value) {
            addCriterion("uc_database_pws not like", value, "ucDatabasePws");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsIn(List<String> values) {
            addCriterion("uc_database_pws in", values, "ucDatabasePws");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsNotIn(List<String> values) {
            addCriterion("uc_database_pws not in", values, "ucDatabasePws");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsBetween(String value1, String value2) {
            addCriterion("uc_database_pws between", value1, value2, "ucDatabasePws");
            return (Criteria) this;
        }

        public Criteria andUcDatabasePwsNotBetween(String value1, String value2) {
            addCriterion("uc_database_pws not between", value1, value2, "ucDatabasePws");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlIsNull() {
            addCriterion("uc_database_url is null");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlIsNotNull() {
            addCriterion("uc_database_url is not null");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlEqualTo(String value) {
            addCriterion("uc_database_url =", value, "ucDatabaseUrl");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlNotEqualTo(String value) {
            addCriterion("uc_database_url <>", value, "ucDatabaseUrl");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlGreaterThan(String value) {
            addCriterion("uc_database_url >", value, "ucDatabaseUrl");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlGreaterThanOrEqualTo(String value) {
            addCriterion("uc_database_url >=", value, "ucDatabaseUrl");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlLessThan(String value) {
            addCriterion("uc_database_url <", value, "ucDatabaseUrl");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlLessThanOrEqualTo(String value) {
            addCriterion("uc_database_url <=", value, "ucDatabaseUrl");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlLike(String value) {
            addCriterion("uc_database_url like", value, "ucDatabaseUrl");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlNotLike(String value) {
            addCriterion("uc_database_url not like", value, "ucDatabaseUrl");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlIn(List<String> values) {
            addCriterion("uc_database_url in", values, "ucDatabaseUrl");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlNotIn(List<String> values) {
            addCriterion("uc_database_url not in", values, "ucDatabaseUrl");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlBetween(String value1, String value2) {
            addCriterion("uc_database_url between", value1, value2, "ucDatabaseUrl");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUrlNotBetween(String value1, String value2) {
            addCriterion("uc_database_url not between", value1, value2, "ucDatabaseUrl");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameIsNull() {
            addCriterion("uc_database_username is null");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameIsNotNull() {
            addCriterion("uc_database_username is not null");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameEqualTo(String value) {
            addCriterion("uc_database_username =", value, "ucDatabaseUsername");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameNotEqualTo(String value) {
            addCriterion("uc_database_username <>", value, "ucDatabaseUsername");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameGreaterThan(String value) {
            addCriterion("uc_database_username >", value, "ucDatabaseUsername");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("uc_database_username >=", value, "ucDatabaseUsername");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameLessThan(String value) {
            addCriterion("uc_database_username <", value, "ucDatabaseUsername");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameLessThanOrEqualTo(String value) {
            addCriterion("uc_database_username <=", value, "ucDatabaseUsername");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameLike(String value) {
            addCriterion("uc_database_username like", value, "ucDatabaseUsername");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameNotLike(String value) {
            addCriterion("uc_database_username not like", value, "ucDatabaseUsername");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameIn(List<String> values) {
            addCriterion("uc_database_username in", values, "ucDatabaseUsername");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameNotIn(List<String> values) {
            addCriterion("uc_database_username not in", values, "ucDatabaseUsername");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameBetween(String value1, String value2) {
            addCriterion("uc_database_username between", value1, value2, "ucDatabaseUsername");
            return (Criteria) this;
        }

        public Criteria andUcDatabaseUsernameNotBetween(String value1, String value2) {
            addCriterion("uc_database_username not between", value1, value2, "ucDatabaseUsername");
            return (Criteria) this;
        }

        public Criteria andUcIpIsNull() {
            addCriterion("uc_ip is null");
            return (Criteria) this;
        }

        public Criteria andUcIpIsNotNull() {
            addCriterion("uc_ip is not null");
            return (Criteria) this;
        }

        public Criteria andUcIpEqualTo(String value) {
            addCriterion("uc_ip =", value, "ucIp");
            return (Criteria) this;
        }

        public Criteria andUcIpNotEqualTo(String value) {
            addCriterion("uc_ip <>", value, "ucIp");
            return (Criteria) this;
        }

        public Criteria andUcIpGreaterThan(String value) {
            addCriterion("uc_ip >", value, "ucIp");
            return (Criteria) this;
        }

        public Criteria andUcIpGreaterThanOrEqualTo(String value) {
            addCriterion("uc_ip >=", value, "ucIp");
            return (Criteria) this;
        }

        public Criteria andUcIpLessThan(String value) {
            addCriterion("uc_ip <", value, "ucIp");
            return (Criteria) this;
        }

        public Criteria andUcIpLessThanOrEqualTo(String value) {
            addCriterion("uc_ip <=", value, "ucIp");
            return (Criteria) this;
        }

        public Criteria andUcIpLike(String value) {
            addCriterion("uc_ip like", value, "ucIp");
            return (Criteria) this;
        }

        public Criteria andUcIpNotLike(String value) {
            addCriterion("uc_ip not like", value, "ucIp");
            return (Criteria) this;
        }

        public Criteria andUcIpIn(List<String> values) {
            addCriterion("uc_ip in", values, "ucIp");
            return (Criteria) this;
        }

        public Criteria andUcIpNotIn(List<String> values) {
            addCriterion("uc_ip not in", values, "ucIp");
            return (Criteria) this;
        }

        public Criteria andUcIpBetween(String value1, String value2) {
            addCriterion("uc_ip between", value1, value2, "ucIp");
            return (Criteria) this;
        }

        public Criteria andUcIpNotBetween(String value1, String value2) {
            addCriterion("uc_ip not between", value1, value2, "ucIp");
            return (Criteria) this;
        }

        public Criteria andUcKeyIsNull() {
            addCriterion("uc_key is null");
            return (Criteria) this;
        }

        public Criteria andUcKeyIsNotNull() {
            addCriterion("uc_key is not null");
            return (Criteria) this;
        }

        public Criteria andUcKeyEqualTo(String value) {
            addCriterion("uc_key =", value, "ucKey");
            return (Criteria) this;
        }

        public Criteria andUcKeyNotEqualTo(String value) {
            addCriterion("uc_key <>", value, "ucKey");
            return (Criteria) this;
        }

        public Criteria andUcKeyGreaterThan(String value) {
            addCriterion("uc_key >", value, "ucKey");
            return (Criteria) this;
        }

        public Criteria andUcKeyGreaterThanOrEqualTo(String value) {
            addCriterion("uc_key >=", value, "ucKey");
            return (Criteria) this;
        }

        public Criteria andUcKeyLessThan(String value) {
            addCriterion("uc_key <", value, "ucKey");
            return (Criteria) this;
        }

        public Criteria andUcKeyLessThanOrEqualTo(String value) {
            addCriterion("uc_key <=", value, "ucKey");
            return (Criteria) this;
        }

        public Criteria andUcKeyLike(String value) {
            addCriterion("uc_key like", value, "ucKey");
            return (Criteria) this;
        }

        public Criteria andUcKeyNotLike(String value) {
            addCriterion("uc_key not like", value, "ucKey");
            return (Criteria) this;
        }

        public Criteria andUcKeyIn(List<String> values) {
            addCriterion("uc_key in", values, "ucKey");
            return (Criteria) this;
        }

        public Criteria andUcKeyNotIn(List<String> values) {
            addCriterion("uc_key not in", values, "ucKey");
            return (Criteria) this;
        }

        public Criteria andUcKeyBetween(String value1, String value2) {
            addCriterion("uc_key between", value1, value2, "ucKey");
            return (Criteria) this;
        }

        public Criteria andUcKeyNotBetween(String value1, String value2) {
            addCriterion("uc_key not between", value1, value2, "ucKey");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixIsNull() {
            addCriterion("uc_table_preffix is null");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixIsNotNull() {
            addCriterion("uc_table_preffix is not null");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixEqualTo(String value) {
            addCriterion("uc_table_preffix =", value, "ucTablePreffix");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixNotEqualTo(String value) {
            addCriterion("uc_table_preffix <>", value, "ucTablePreffix");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixGreaterThan(String value) {
            addCriterion("uc_table_preffix >", value, "ucTablePreffix");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixGreaterThanOrEqualTo(String value) {
            addCriterion("uc_table_preffix >=", value, "ucTablePreffix");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixLessThan(String value) {
            addCriterion("uc_table_preffix <", value, "ucTablePreffix");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixLessThanOrEqualTo(String value) {
            addCriterion("uc_table_preffix <=", value, "ucTablePreffix");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixLike(String value) {
            addCriterion("uc_table_preffix like", value, "ucTablePreffix");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixNotLike(String value) {
            addCriterion("uc_table_preffix not like", value, "ucTablePreffix");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixIn(List<String> values) {
            addCriterion("uc_table_preffix in", values, "ucTablePreffix");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixNotIn(List<String> values) {
            addCriterion("uc_table_preffix not in", values, "ucTablePreffix");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixBetween(String value1, String value2) {
            addCriterion("uc_table_preffix between", value1, value2, "ucTablePreffix");
            return (Criteria) this;
        }

        public Criteria andUcTablePreffixNotBetween(String value1, String value2) {
            addCriterion("uc_table_preffix not between", value1, value2, "ucTablePreffix");
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

        public Criteria andBargainValidityIsNull() {
            addCriterion("bargain_validity is null");
            return (Criteria) this;
        }

        public Criteria andBargainValidityIsNotNull() {
            addCriterion("bargain_validity is not null");
            return (Criteria) this;
        }

        public Criteria andBargainValidityEqualTo(Integer value) {
            addCriterion("bargain_validity =", value, "bargainValidity");
            return (Criteria) this;
        }

        public Criteria andBargainValidityNotEqualTo(Integer value) {
            addCriterion("bargain_validity <>", value, "bargainValidity");
            return (Criteria) this;
        }

        public Criteria andBargainValidityGreaterThan(Integer value) {
            addCriterion("bargain_validity >", value, "bargainValidity");
            return (Criteria) this;
        }

        public Criteria andBargainValidityGreaterThanOrEqualTo(Integer value) {
            addCriterion("bargain_validity >=", value, "bargainValidity");
            return (Criteria) this;
        }

        public Criteria andBargainValidityLessThan(Integer value) {
            addCriterion("bargain_validity <", value, "bargainValidity");
            return (Criteria) this;
        }

        public Criteria andBargainValidityLessThanOrEqualTo(Integer value) {
            addCriterion("bargain_validity <=", value, "bargainValidity");
            return (Criteria) this;
        }

        public Criteria andBargainValidityIn(List<Integer> values) {
            addCriterion("bargain_validity in", values, "bargainValidity");
            return (Criteria) this;
        }

        public Criteria andBargainValidityNotIn(List<Integer> values) {
            addCriterion("bargain_validity not in", values, "bargainValidity");
            return (Criteria) this;
        }

        public Criteria andBargainValidityBetween(Integer value1, Integer value2) {
            addCriterion("bargain_validity between", value1, value2, "bargainValidity");
            return (Criteria) this;
        }

        public Criteria andBargainValidityNotBetween(Integer value1, Integer value2) {
            addCriterion("bargain_validity not between", value1, value2, "bargainValidity");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountIsNull() {
            addCriterion("delivery_amount is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountIsNotNull() {
            addCriterion("delivery_amount is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountEqualTo(Integer value) {
            addCriterion("delivery_amount =", value, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountNotEqualTo(Integer value) {
            addCriterion("delivery_amount <>", value, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountGreaterThan(Integer value) {
            addCriterion("delivery_amount >", value, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_amount >=", value, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountLessThan(Integer value) {
            addCriterion("delivery_amount <", value, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_amount <=", value, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountIn(List<Integer> values) {
            addCriterion("delivery_amount in", values, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountNotIn(List<Integer> values) {
            addCriterion("delivery_amount not in", values, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountBetween(Integer value1, Integer value2) {
            addCriterion("delivery_amount between", value1, value2, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_amount not between", value1, value2, "deliveryAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusIsNull() {
            addCriterion("delivery_status is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusIsNotNull() {
            addCriterion("delivery_status is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusEqualTo(Integer value) {
            addCriterion("delivery_status =", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusNotEqualTo(Integer value) {
            addCriterion("delivery_status <>", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusGreaterThan(Integer value) {
            addCriterion("delivery_status >", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("delivery_status >=", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusLessThan(Integer value) {
            addCriterion("delivery_status <", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusLessThanOrEqualTo(Integer value) {
            addCriterion("delivery_status <=", value, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusIn(List<Integer> values) {
            addCriterion("delivery_status in", values, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusNotIn(List<Integer> values) {
            addCriterion("delivery_status not in", values, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusBetween(Integer value1, Integer value2) {
            addCriterion("delivery_status between", value1, value2, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("delivery_status not between", value1, value2, "deliveryStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleIsNull() {
            addCriterion("delivery_title is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleIsNotNull() {
            addCriterion("delivery_title is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleEqualTo(String value) {
            addCriterion("delivery_title =", value, "deliveryTitle");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleNotEqualTo(String value) {
            addCriterion("delivery_title <>", value, "deliveryTitle");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleGreaterThan(String value) {
            addCriterion("delivery_title >", value, "deliveryTitle");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_title >=", value, "deliveryTitle");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleLessThan(String value) {
            addCriterion("delivery_title <", value, "deliveryTitle");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleLessThanOrEqualTo(String value) {
            addCriterion("delivery_title <=", value, "deliveryTitle");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleLike(String value) {
            addCriterion("delivery_title like", value, "deliveryTitle");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleNotLike(String value) {
            addCriterion("delivery_title not like", value, "deliveryTitle");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleIn(List<String> values) {
            addCriterion("delivery_title in", values, "deliveryTitle");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleNotIn(List<String> values) {
            addCriterion("delivery_title not in", values, "deliveryTitle");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleBetween(String value1, String value2) {
            addCriterion("delivery_title between", value1, value2, "deliveryTitle");
            return (Criteria) this;
        }

        public Criteria andDeliveryTitleNotBetween(String value1, String value2) {
            addCriterion("delivery_title not between", value1, value2, "deliveryTitle");
            return (Criteria) this;
        }

        public Criteria andWebsitecssIsNull() {
            addCriterion("websiteCss is null");
            return (Criteria) this;
        }

        public Criteria andWebsitecssIsNotNull() {
            addCriterion("websiteCss is not null");
            return (Criteria) this;
        }

        public Criteria andWebsitecssEqualTo(String value) {
            addCriterion("websiteCss =", value, "websitecss");
            return (Criteria) this;
        }

        public Criteria andWebsitecssNotEqualTo(String value) {
            addCriterion("websiteCss <>", value, "websitecss");
            return (Criteria) this;
        }

        public Criteria andWebsitecssGreaterThan(String value) {
            addCriterion("websiteCss >", value, "websitecss");
            return (Criteria) this;
        }

        public Criteria andWebsitecssGreaterThanOrEqualTo(String value) {
            addCriterion("websiteCss >=", value, "websitecss");
            return (Criteria) this;
        }

        public Criteria andWebsitecssLessThan(String value) {
            addCriterion("websiteCss <", value, "websitecss");
            return (Criteria) this;
        }

        public Criteria andWebsitecssLessThanOrEqualTo(String value) {
            addCriterion("websiteCss <=", value, "websitecss");
            return (Criteria) this;
        }

        public Criteria andWebsitecssLike(String value) {
            addCriterion("websiteCss like", value, "websitecss");
            return (Criteria) this;
        }

        public Criteria andWebsitecssNotLike(String value) {
            addCriterion("websiteCss not like", value, "websitecss");
            return (Criteria) this;
        }

        public Criteria andWebsitecssIn(List<String> values) {
            addCriterion("websiteCss in", values, "websitecss");
            return (Criteria) this;
        }

        public Criteria andWebsitecssNotIn(List<String> values) {
            addCriterion("websiteCss not in", values, "websitecss");
            return (Criteria) this;
        }

        public Criteria andWebsitecssBetween(String value1, String value2) {
            addCriterion("websiteCss between", value1, value2, "websitecss");
            return (Criteria) this;
        }

        public Criteria andWebsitecssNotBetween(String value1, String value2) {
            addCriterion("websiteCss not between", value1, value2, "websitecss");
            return (Criteria) this;
        }

        public Criteria andCombinAmountIsNull() {
            addCriterion("combin_amount is null");
            return (Criteria) this;
        }

        public Criteria andCombinAmountIsNotNull() {
            addCriterion("combin_amount is not null");
            return (Criteria) this;
        }

        public Criteria andCombinAmountEqualTo(Integer value) {
            addCriterion("combin_amount =", value, "combinAmount");
            return (Criteria) this;
        }

        public Criteria andCombinAmountNotEqualTo(Integer value) {
            addCriterion("combin_amount <>", value, "combinAmount");
            return (Criteria) this;
        }

        public Criteria andCombinAmountGreaterThan(Integer value) {
            addCriterion("combin_amount >", value, "combinAmount");
            return (Criteria) this;
        }

        public Criteria andCombinAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("combin_amount >=", value, "combinAmount");
            return (Criteria) this;
        }

        public Criteria andCombinAmountLessThan(Integer value) {
            addCriterion("combin_amount <", value, "combinAmount");
            return (Criteria) this;
        }

        public Criteria andCombinAmountLessThanOrEqualTo(Integer value) {
            addCriterion("combin_amount <=", value, "combinAmount");
            return (Criteria) this;
        }

        public Criteria andCombinAmountIn(List<Integer> values) {
            addCriterion("combin_amount in", values, "combinAmount");
            return (Criteria) this;
        }

        public Criteria andCombinAmountNotIn(List<Integer> values) {
            addCriterion("combin_amount not in", values, "combinAmount");
            return (Criteria) this;
        }

        public Criteria andCombinAmountBetween(Integer value1, Integer value2) {
            addCriterion("combin_amount between", value1, value2, "combinAmount");
            return (Criteria) this;
        }

        public Criteria andCombinAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("combin_amount not between", value1, value2, "combinAmount");
            return (Criteria) this;
        }

        public Criteria andCombinCountIsNull() {
            addCriterion("combin_count is null");
            return (Criteria) this;
        }

        public Criteria andCombinCountIsNotNull() {
            addCriterion("combin_count is not null");
            return (Criteria) this;
        }

        public Criteria andCombinCountEqualTo(Integer value) {
            addCriterion("combin_count =", value, "combinCount");
            return (Criteria) this;
        }

        public Criteria andCombinCountNotEqualTo(Integer value) {
            addCriterion("combin_count <>", value, "combinCount");
            return (Criteria) this;
        }

        public Criteria andCombinCountGreaterThan(Integer value) {
            addCriterion("combin_count >", value, "combinCount");
            return (Criteria) this;
        }

        public Criteria andCombinCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("combin_count >=", value, "combinCount");
            return (Criteria) this;
        }

        public Criteria andCombinCountLessThan(Integer value) {
            addCriterion("combin_count <", value, "combinCount");
            return (Criteria) this;
        }

        public Criteria andCombinCountLessThanOrEqualTo(Integer value) {
            addCriterion("combin_count <=", value, "combinCount");
            return (Criteria) this;
        }

        public Criteria andCombinCountIn(List<Integer> values) {
            addCriterion("combin_count in", values, "combinCount");
            return (Criteria) this;
        }

        public Criteria andCombinCountNotIn(List<Integer> values) {
            addCriterion("combin_count not in", values, "combinCount");
            return (Criteria) this;
        }

        public Criteria andCombinCountBetween(Integer value1, Integer value2) {
            addCriterion("combin_count between", value1, value2, "combinCount");
            return (Criteria) this;
        }

        public Criteria andCombinCountNotBetween(Integer value1, Integer value2) {
            addCriterion("combin_count not between", value1, value2, "combinCount");
            return (Criteria) this;
        }

        public Criteria andZtcGoodsViewIsNull() {
            addCriterion("ztc_goods_view is null");
            return (Criteria) this;
        }

        public Criteria andZtcGoodsViewIsNotNull() {
            addCriterion("ztc_goods_view is not null");
            return (Criteria) this;
        }

        public Criteria andZtcGoodsViewEqualTo(Integer value) {
            addCriterion("ztc_goods_view =", value, "ztcGoodsView");
            return (Criteria) this;
        }

        public Criteria andZtcGoodsViewNotEqualTo(Integer value) {
            addCriterion("ztc_goods_view <>", value, "ztcGoodsView");
            return (Criteria) this;
        }

        public Criteria andZtcGoodsViewGreaterThan(Integer value) {
            addCriterion("ztc_goods_view >", value, "ztcGoodsView");
            return (Criteria) this;
        }

        public Criteria andZtcGoodsViewGreaterThanOrEqualTo(Integer value) {
            addCriterion("ztc_goods_view >=", value, "ztcGoodsView");
            return (Criteria) this;
        }

        public Criteria andZtcGoodsViewLessThan(Integer value) {
            addCriterion("ztc_goods_view <", value, "ztcGoodsView");
            return (Criteria) this;
        }

        public Criteria andZtcGoodsViewLessThanOrEqualTo(Integer value) {
            addCriterion("ztc_goods_view <=", value, "ztcGoodsView");
            return (Criteria) this;
        }

        public Criteria andZtcGoodsViewIn(List<Integer> values) {
            addCriterion("ztc_goods_view in", values, "ztcGoodsView");
            return (Criteria) this;
        }

        public Criteria andZtcGoodsViewNotIn(List<Integer> values) {
            addCriterion("ztc_goods_view not in", values, "ztcGoodsView");
            return (Criteria) this;
        }

        public Criteria andZtcGoodsViewBetween(Integer value1, Integer value2) {
            addCriterion("ztc_goods_view between", value1, value2, "ztcGoodsView");
            return (Criteria) this;
        }

        public Criteria andZtcGoodsViewNotBetween(Integer value1, Integer value2) {
            addCriterion("ztc_goods_view not between", value1, value2, "ztcGoodsView");
            return (Criteria) this;
        }

        public Criteria andAutoOrderEvaluateIsNull() {
            addCriterion("auto_order_evaluate is null");
            return (Criteria) this;
        }

        public Criteria andAutoOrderEvaluateIsNotNull() {
            addCriterion("auto_order_evaluate is not null");
            return (Criteria) this;
        }

        public Criteria andAutoOrderEvaluateEqualTo(Integer value) {
            addCriterion("auto_order_evaluate =", value, "autoOrderEvaluate");
            return (Criteria) this;
        }

        public Criteria andAutoOrderEvaluateNotEqualTo(Integer value) {
            addCriterion("auto_order_evaluate <>", value, "autoOrderEvaluate");
            return (Criteria) this;
        }

        public Criteria andAutoOrderEvaluateGreaterThan(Integer value) {
            addCriterion("auto_order_evaluate >", value, "autoOrderEvaluate");
            return (Criteria) this;
        }

        public Criteria andAutoOrderEvaluateGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_order_evaluate >=", value, "autoOrderEvaluate");
            return (Criteria) this;
        }

        public Criteria andAutoOrderEvaluateLessThan(Integer value) {
            addCriterion("auto_order_evaluate <", value, "autoOrderEvaluate");
            return (Criteria) this;
        }

        public Criteria andAutoOrderEvaluateLessThanOrEqualTo(Integer value) {
            addCriterion("auto_order_evaluate <=", value, "autoOrderEvaluate");
            return (Criteria) this;
        }

        public Criteria andAutoOrderEvaluateIn(List<Integer> values) {
            addCriterion("auto_order_evaluate in", values, "autoOrderEvaluate");
            return (Criteria) this;
        }

        public Criteria andAutoOrderEvaluateNotIn(List<Integer> values) {
            addCriterion("auto_order_evaluate not in", values, "autoOrderEvaluate");
            return (Criteria) this;
        }

        public Criteria andAutoOrderEvaluateBetween(Integer value1, Integer value2) {
            addCriterion("auto_order_evaluate between", value1, value2, "autoOrderEvaluate");
            return (Criteria) this;
        }

        public Criteria andAutoOrderEvaluateNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_order_evaluate not between", value1, value2, "autoOrderEvaluate");
            return (Criteria) this;
        }

        public Criteria andAutoOrderReturnIsNull() {
            addCriterion("auto_order_return is null");
            return (Criteria) this;
        }

        public Criteria andAutoOrderReturnIsNotNull() {
            addCriterion("auto_order_return is not null");
            return (Criteria) this;
        }

        public Criteria andAutoOrderReturnEqualTo(Integer value) {
            addCriterion("auto_order_return =", value, "autoOrderReturn");
            return (Criteria) this;
        }

        public Criteria andAutoOrderReturnNotEqualTo(Integer value) {
            addCriterion("auto_order_return <>", value, "autoOrderReturn");
            return (Criteria) this;
        }

        public Criteria andAutoOrderReturnGreaterThan(Integer value) {
            addCriterion("auto_order_return >", value, "autoOrderReturn");
            return (Criteria) this;
        }

        public Criteria andAutoOrderReturnGreaterThanOrEqualTo(Integer value) {
            addCriterion("auto_order_return >=", value, "autoOrderReturn");
            return (Criteria) this;
        }

        public Criteria andAutoOrderReturnLessThan(Integer value) {
            addCriterion("auto_order_return <", value, "autoOrderReturn");
            return (Criteria) this;
        }

        public Criteria andAutoOrderReturnLessThanOrEqualTo(Integer value) {
            addCriterion("auto_order_return <=", value, "autoOrderReturn");
            return (Criteria) this;
        }

        public Criteria andAutoOrderReturnIn(List<Integer> values) {
            addCriterion("auto_order_return in", values, "autoOrderReturn");
            return (Criteria) this;
        }

        public Criteria andAutoOrderReturnNotIn(List<Integer> values) {
            addCriterion("auto_order_return not in", values, "autoOrderReturn");
            return (Criteria) this;
        }

        public Criteria andAutoOrderReturnBetween(Integer value1, Integer value2) {
            addCriterion("auto_order_return between", value1, value2, "autoOrderReturn");
            return (Criteria) this;
        }

        public Criteria andAutoOrderReturnNotBetween(Integer value1, Integer value2) {
            addCriterion("auto_order_return not between", value1, value2, "autoOrderReturn");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreIsNull() {
            addCriterion("weixin_store is null");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreIsNotNull() {
            addCriterion("weixin_store is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreEqualTo(Boolean value) {
            addCriterion("weixin_store =", value, "weixinStore");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNotEqualTo(Boolean value) {
            addCriterion("weixin_store <>", value, "weixinStore");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreGreaterThan(Boolean value) {
            addCriterion("weixin_store >", value, "weixinStore");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreGreaterThanOrEqualTo(Boolean value) {
            addCriterion("weixin_store >=", value, "weixinStore");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreLessThan(Boolean value) {
            addCriterion("weixin_store <", value, "weixinStore");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreLessThanOrEqualTo(Boolean value) {
            addCriterion("weixin_store <=", value, "weixinStore");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreIn(List<Boolean> values) {
            addCriterion("weixin_store in", values, "weixinStore");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNotIn(List<Boolean> values) {
            addCriterion("weixin_store not in", values, "weixinStore");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreBetween(Boolean value1, Boolean value2) {
            addCriterion("weixin_store between", value1, value2, "weixinStore");
            return (Criteria) this;
        }

        public Criteria andWeixinStoreNotBetween(Boolean value1, Boolean value2) {
            addCriterion("weixin_store not between", value1, value2, "weixinStore");
            return (Criteria) this;
        }

        public Criteria andWeixinAmountIsNull() {
            addCriterion("weixin_amount is null");
            return (Criteria) this;
        }

        public Criteria andWeixinAmountIsNotNull() {
            addCriterion("weixin_amount is not null");
            return (Criteria) this;
        }

        public Criteria andWeixinAmountEqualTo(Integer value) {
            addCriterion("weixin_amount =", value, "weixinAmount");
            return (Criteria) this;
        }

        public Criteria andWeixinAmountNotEqualTo(Integer value) {
            addCriterion("weixin_amount <>", value, "weixinAmount");
            return (Criteria) this;
        }

        public Criteria andWeixinAmountGreaterThan(Integer value) {
            addCriterion("weixin_amount >", value, "weixinAmount");
            return (Criteria) this;
        }

        public Criteria andWeixinAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("weixin_amount >=", value, "weixinAmount");
            return (Criteria) this;
        }

        public Criteria andWeixinAmountLessThan(Integer value) {
            addCriterion("weixin_amount <", value, "weixinAmount");
            return (Criteria) this;
        }

        public Criteria andWeixinAmountLessThanOrEqualTo(Integer value) {
            addCriterion("weixin_amount <=", value, "weixinAmount");
            return (Criteria) this;
        }

        public Criteria andWeixinAmountIn(List<Integer> values) {
            addCriterion("weixin_amount in", values, "weixinAmount");
            return (Criteria) this;
        }

        public Criteria andWeixinAmountNotIn(List<Integer> values) {
            addCriterion("weixin_amount not in", values, "weixinAmount");
            return (Criteria) this;
        }

        public Criteria andWeixinAmountBetween(Integer value1, Integer value2) {
            addCriterion("weixin_amount between", value1, value2, "weixinAmount");
            return (Criteria) this;
        }

        public Criteria andWeixinAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("weixin_amount not between", value1, value2, "weixinAmount");
            return (Criteria) this;
        }

        public Criteria andConfigPaymentTypeIsNull() {
            addCriterion("config_payment_type is null");
            return (Criteria) this;
        }

        public Criteria andConfigPaymentTypeIsNotNull() {
            addCriterion("config_payment_type is not null");
            return (Criteria) this;
        }

        public Criteria andConfigPaymentTypeEqualTo(Integer value) {
            addCriterion("config_payment_type =", value, "configPaymentType");
            return (Criteria) this;
        }

        public Criteria andConfigPaymentTypeNotEqualTo(Integer value) {
            addCriterion("config_payment_type <>", value, "configPaymentType");
            return (Criteria) this;
        }

        public Criteria andConfigPaymentTypeGreaterThan(Integer value) {
            addCriterion("config_payment_type >", value, "configPaymentType");
            return (Criteria) this;
        }

        public Criteria andConfigPaymentTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("config_payment_type >=", value, "configPaymentType");
            return (Criteria) this;
        }

        public Criteria andConfigPaymentTypeLessThan(Integer value) {
            addCriterion("config_payment_type <", value, "configPaymentType");
            return (Criteria) this;
        }

        public Criteria andConfigPaymentTypeLessThanOrEqualTo(Integer value) {
            addCriterion("config_payment_type <=", value, "configPaymentType");
            return (Criteria) this;
        }

        public Criteria andConfigPaymentTypeIn(List<Integer> values) {
            addCriterion("config_payment_type in", values, "configPaymentType");
            return (Criteria) this;
        }

        public Criteria andConfigPaymentTypeNotIn(List<Integer> values) {
            addCriterion("config_payment_type not in", values, "configPaymentType");
            return (Criteria) this;
        }

        public Criteria andConfigPaymentTypeBetween(Integer value1, Integer value2) {
            addCriterion("config_payment_type between", value1, value2, "configPaymentType");
            return (Criteria) this;
        }

        public Criteria andConfigPaymentTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("config_payment_type not between", value1, value2, "configPaymentType");
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
        
        public Criteria andSmsAppIdIsNull() {
            addCriterion("sms_app_id is null");
            return (Criteria) this;
        }

        public Criteria andSmsAppIdIsNotNull() {
            addCriterion("sms_app_id is not null");
            return (Criteria) this;
        }

        public Criteria andSmsAppIdEqualTo(String value) {
            addCriterion("sms_app_id =", value, "smsAppId");
            return (Criteria) this;
        }

        public Criteria andSmsAppIdNotEqualTo(String value) {
            addCriterion("sms_app_id <>", value, "smsAppId");
            return (Criteria) this;
        }

        public Criteria andSmsAppIdGreaterThan(String value) {
            addCriterion("sms_app_id >", value, "smsAppId");
            return (Criteria) this;
        }

        public Criteria andSmsAppIdGreaterThanOrEqualTo(String value) {
            addCriterion("sms_app_id >=", value, "smsAppId");
            return (Criteria) this;
        }

        public Criteria andSmsAppIdLessThan(String value) {
            addCriterion("sms_app_id <", value, "smsAppId");
            return (Criteria) this;
        }

        public Criteria andSmsAppIdLessThanOrEqualTo(String value) {
            addCriterion("sms_app_id <=", value, "smsAppId");
            return (Criteria) this;
        }

        public Criteria andSmsAppIdLike(String value) {
            addCriterion("sms_app_id like", value, "smsAppId");
            return (Criteria) this;
        }

        public Criteria andSmsAppIdNotLike(String value) {
            addCriterion("sms_app_id not like", value, "smsAppId");
            return (Criteria) this;
        }

        public Criteria andSmsAppIdIn(List<String> values) {
            addCriterion("sms_app_id in", values, "smsAppId");
            return (Criteria) this;
        }

        public Criteria andSmsAppIdNotIn(List<String> values) {
            addCriterion("sms_app_id not in", values, "smsAppId");
            return (Criteria) this;
        }

        public Criteria andSmsAppIdBetween(String value1, String value2) {
            addCriterion("sms_app_id between", value1, value2, "smsAppId");
            return (Criteria) this;
        }

        public Criteria andSmsAppIdNotBetween(String value1, String value2) {
            addCriterion("sms_app_id not between", value1, value2, "smsAppId");
            return (Criteria) this;
        }
        
        public Criteria andSmsExceedTimeIsNull() {
            addCriterion("sms_exceed_time is null");
            return (Criteria) this;
        }

        public Criteria andSmsExceedTimeIsNotNull() {
            addCriterion("sms_exceed_time is not null");
            return (Criteria) this;
        }

        public Criteria andSmsExceedTimeEqualTo(String value) {
            addCriterion("sms_exceed_time =", value, "smsExceedTime");
            return (Criteria) this;
        }

        public Criteria andSmsExceedTimeNotEqualTo(String value) {
            addCriterion("sms_exceed_time <>", value, "smsExceedTime");
            return (Criteria) this;
        }

        public Criteria andSmsExceedTimeGreaterThan(String value) {
            addCriterion("sms_exceed_time >", value, "smsExceedTime");
            return (Criteria) this;
        }

        public Criteria andSmsExceedTimeGreaterThanOrEqualTo(String value) {
            addCriterion("sms_exceed_time >=", value, "smsExceedTime");
            return (Criteria) this;
        }

        public Criteria andSmsExceedTimeLessThan(String value) {
            addCriterion("sms_exceed_time <", value, "smsExceedTime");
            return (Criteria) this;
        }

        public Criteria andSmsExceedTimeLessThanOrEqualTo(String value) {
            addCriterion("sms_exceed_time <=", value, "smsExceedTime");
            return (Criteria) this;
        }

        public Criteria andSmsExceedTimeLike(String value) {
            addCriterion("sms_exceed_time like", value, "smsExceedTime");
            return (Criteria) this;
        }

        public Criteria andSmsExceedTimeNotLike(String value) {
            addCriterion("sms_exceed_time not like", value, "smsExceedTime");
            return (Criteria) this;
        }

        public Criteria andSmsExceedTimeIn(List<String> values) {
            addCriterion("sms_exceed_time in", values, "smsExceedTime");
            return (Criteria) this;
        }

        public Criteria andSmsExceedTimeNotIn(List<String> values) {
            addCriterion("sms_exceed_time not in", values, "smsExceedTime");
            return (Criteria) this;
        }

        public Criteria andSmsExceedTimeBetween(String value1, String value2) {
            addCriterion("sms_exceed_time between", value1, value2, "smsExceedTime");
            return (Criteria) this;
        }

        public Criteria andSmsExceedTimeNotBetween(String value1, String value2) {
            addCriterion("sms_exceed_time not between", value1, value2, "smsExceedTime");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthIsNull() {
            addCriterion("verification_code_length is null");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthIsNotNull() {
            addCriterion("verification_code_length is not null");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthEqualTo(String value) {
            addCriterion("verification_code_length =", value, "verificationCodeLength");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthNotEqualTo(String value) {
            addCriterion("verification_code_length <>", value, "verificationCodeLength");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthGreaterThan(String value) {
            addCriterion("verification_code_length >", value, "verificationCodeLength");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthGreaterThanOrEqualTo(String value) {
            addCriterion("verification_code_length >=", value, "verificationCodeLength");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthLessThan(String value) {
            addCriterion("verification_code_length <", value, "verificationCodeLength");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthLessThanOrEqualTo(String value) {
            addCriterion("verification_code_length <=", value, "verificationCodeLength");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthLike(String value) {
            addCriterion("verification_code_length like", value, "verificationCodeLength");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthNotLike(String value) {
            addCriterion("verification_code_length not like", value, "verificationCodeLength");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthIn(List<String> values) {
            addCriterion("verification_code_length in", values, "verificationCodeLength");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthNotIn(List<String> values) {
            addCriterion("verification_code_length not in", values, "verificationCodeLength");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthBetween(String value1, String value2) {
            addCriterion("verification_code_length between", value1, value2, "verificationCodeLength");
            return (Criteria) this;
        }

        public Criteria andVerificationCodeLengthNotBetween(String value1, String value2) {
            addCriterion("verification_code_length not between", value1, value2, "verificationCodeLength");
            return (Criteria) this;
        }
        
        public Criteria andMaxFrequencyWeekIsNull() {
            addCriterion("max_frequency_week is null");
            return (Criteria) this;
        }

        public Criteria andMaxFrequencyWeekIsNotNull() {
            addCriterion("max_frequency_week is not null");
            return (Criteria) this;
        }

        public Criteria andMaxFrequencyWeekEqualTo(Integer value) {
            addCriterion("max_frequency_week =", value, "maxFrequencyWeek");
            return (Criteria) this;
        }

        public Criteria andMaxFrequencyWeekNotEqualTo(Integer value) {
            addCriterion("max_frequency_week <>", value, "maxFrequencyWeek");
            return (Criteria) this;
        }

        public Criteria andMaxFrequencyWeekGreaterThan(Integer value) {
            addCriterion("max_frequency_week >", value, "maxFrequencyWeek");
            return (Criteria) this;
        }

        public Criteria andMaxFrequencyWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_frequency_week >=", value, "maxFrequencyWeek");
            return (Criteria) this;
        }

        public Criteria andMaxFrequencyWeekLessThan(Integer value) {
            addCriterion("max_frequency_week <", value, "maxFrequencyWeek");
            return (Criteria) this;
        }

        public Criteria andMaxFrequencyWeekLessThanOrEqualTo(Integer value) {
            addCriterion("max_frequency_week <=", value, "maxFrequencyWeek");
            return (Criteria) this;
        }

        public Criteria andMaxFrequencyWeekIn(List<Integer> values) {
            addCriterion("max_frequency_week in", values, "maxFrequencyWeek");
            return (Criteria) this;
        }

        public Criteria andMaxFrequencyWeekNotIn(List<Integer> values) {
            addCriterion("max_frequency_week not in", values, "maxFrequencyWeek");
            return (Criteria) this;
        }

        public Criteria andMaxFrequencyWeekBetween(Integer value1, Integer value2) {
            addCriterion("max_frequency_week between", value1, value2, "maxFrequencyWeek");
            return (Criteria) this;
        }

        public Criteria andMaxFrequencyWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("max_frequency_week not between", value1, value2, "maxFrequencyWeek");
            return (Criteria) this;
        }

        public Criteria andMaxNumberWeekIsNull() {
            addCriterion("max_number_week is null");
            return (Criteria) this;
        }

        public Criteria andMaxNumberWeekIsNotNull() {
            addCriterion("max_number_week is not null");
            return (Criteria) this;
        }

        public Criteria andMaxNumberWeekEqualTo(Integer value) {
            addCriterion("max_number_week =", value, "maxNumberWeek");
            return (Criteria) this;
        }

        public Criteria andMaxNumberWeekNotEqualTo(Integer value) {
            addCriterion("max_number_week <>", value, "maxNumberWeek");
            return (Criteria) this;
        }

        public Criteria andMaxNumberWeekGreaterThan(Integer value) {
            addCriterion("max_number_week >", value, "maxNumberWeek");
            return (Criteria) this;
        }

        public Criteria andMaxNumberWeekGreaterThanOrEqualTo(Integer value) {
            addCriterion("max_number_week >=", value, "maxNumberWeek");
            return (Criteria) this;
        }

        public Criteria andMaxNumberWeekLessThan(Integer value) {
            addCriterion("max_number_week <", value, "maxNumberWeek");
            return (Criteria) this;
        }

        public Criteria andMaxNumberWeekLessThanOrEqualTo(Integer value) {
            addCriterion("max_number_week <=", value, "maxNumberWeek");
            return (Criteria) this;
        }

        public Criteria andMaxNumberWeekIn(List<Integer> values) {
            addCriterion("max_number_week in", values, "maxNumberWeek");
            return (Criteria) this;
        }

        public Criteria andMaxNumberWeekNotIn(List<Integer> values) {
            addCriterion("max_number_week not in", values, "maxNumberWeek");
            return (Criteria) this;
        }

        public Criteria andMaxNumberWeekBetween(Integer value1, Integer value2) {
            addCriterion("max_number_week between", value1, value2, "maxNumberWeek");
            return (Criteria) this;
        }

        public Criteria andMaxNumberWeekNotBetween(Integer value1, Integer value2) {
            addCriterion("max_number_week not between", value1, value2, "maxNumberWeek");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIsNull() {
            addCriterion("max_price is null");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIsNotNull() {
            addCriterion("max_price is not null");
            return (Criteria) this;
        }

        public Criteria andMaxPriceEqualTo(BigDecimal value) {
            addCriterion("max_price =", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotEqualTo(BigDecimal value) {
            addCriterion("max_price <>", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceGreaterThan(BigDecimal value) {
            addCriterion("max_price >", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("max_price >=", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceLessThan(BigDecimal value) {
            addCriterion("max_price <", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("max_price <=", value, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceIn(List<BigDecimal> values) {
            addCriterion("max_price in", values, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotIn(List<BigDecimal> values) {
            addCriterion("max_price not in", values, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_price between", value1, value2, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMaxPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("max_price not between", value1, value2, "maxPrice");
            return (Criteria) this;
        }

        public Criteria andMinPricceIsNull() {
            addCriterion("min_pricce is null");
            return (Criteria) this;
        }

        public Criteria andMinPricceIsNotNull() {
            addCriterion("min_pricce is not null");
            return (Criteria) this;
        }

        public Criteria andMinPricceEqualTo(BigDecimal value) {
            addCriterion("min_pricce =", value, "minPricce");
            return (Criteria) this;
        }

        public Criteria andMinPricceNotEqualTo(BigDecimal value) {
            addCriterion("min_pricce <>", value, "minPricce");
            return (Criteria) this;
        }

        public Criteria andMinPricceGreaterThan(BigDecimal value) {
            addCriterion("min_pricce >", value, "minPricce");
            return (Criteria) this;
        }

        public Criteria andMinPricceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("min_pricce >=", value, "minPricce");
            return (Criteria) this;
        }

        public Criteria andMinPricceLessThan(BigDecimal value) {
            addCriterion("min_pricce <", value, "minPricce");
            return (Criteria) this;
        }

        public Criteria andMinPricceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("min_pricce <=", value, "minPricce");
            return (Criteria) this;
        }

        public Criteria andMinPricceIn(List<BigDecimal> values) {
            addCriterion("min_pricce in", values, "minPricce");
            return (Criteria) this;
        }

        public Criteria andMinPricceNotIn(List<BigDecimal> values) {
            addCriterion("min_pricce not in", values, "minPricce");
            return (Criteria) this;
        }

        public Criteria andMinPricceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_pricce between", value1, value2, "minPricce");
            return (Criteria) this;
        }

        public Criteria andMinPricceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("min_pricce not between", value1, value2, "minPricce");
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