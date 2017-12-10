package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class WapAdvertPositionExample extends BaseQuery{
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WapAdvertPositionExample() {
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

        public Criteria andApAccUrlIsNull() {
            addCriterion("ap_acc_url is null");
            return (Criteria) this;
        }

        public Criteria andApAccUrlIsNotNull() {
            addCriterion("ap_acc_url is not null");
            return (Criteria) this;
        }

        public Criteria andApAccUrlEqualTo(String value) {
            addCriterion("ap_acc_url =", value, "apAccUrl");
            return (Criteria) this;
        }

        public Criteria andApAccUrlNotEqualTo(String value) {
            addCriterion("ap_acc_url <>", value, "apAccUrl");
            return (Criteria) this;
        }

        public Criteria andApAccUrlGreaterThan(String value) {
            addCriterion("ap_acc_url >", value, "apAccUrl");
            return (Criteria) this;
        }

        public Criteria andApAccUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ap_acc_url >=", value, "apAccUrl");
            return (Criteria) this;
        }

        public Criteria andApAccUrlLessThan(String value) {
            addCriterion("ap_acc_url <", value, "apAccUrl");
            return (Criteria) this;
        }

        public Criteria andApAccUrlLessThanOrEqualTo(String value) {
            addCriterion("ap_acc_url <=", value, "apAccUrl");
            return (Criteria) this;
        }

        public Criteria andApAccUrlLike(String value) {
            addCriterion("ap_acc_url like", value, "apAccUrl");
            return (Criteria) this;
        }

        public Criteria andApAccUrlNotLike(String value) {
            addCriterion("ap_acc_url not like", value, "apAccUrl");
            return (Criteria) this;
        }

        public Criteria andApAccUrlIn(List<String> values) {
            addCriterion("ap_acc_url in", values, "apAccUrl");
            return (Criteria) this;
        }

        public Criteria andApAccUrlNotIn(List<String> values) {
            addCriterion("ap_acc_url not in", values, "apAccUrl");
            return (Criteria) this;
        }

        public Criteria andApAccUrlBetween(String value1, String value2) {
            addCriterion("ap_acc_url between", value1, value2, "apAccUrl");
            return (Criteria) this;
        }

        public Criteria andApAccUrlNotBetween(String value1, String value2) {
            addCriterion("ap_acc_url not between", value1, value2, "apAccUrl");
            return (Criteria) this;
        }

        public Criteria andApHeightIsNull() {
            addCriterion("ap_height is null");
            return (Criteria) this;
        }

        public Criteria andApHeightIsNotNull() {
            addCriterion("ap_height is not null");
            return (Criteria) this;
        }

        public Criteria andApHeightEqualTo(Integer value) {
            addCriterion("ap_height =", value, "apHeight");
            return (Criteria) this;
        }

        public Criteria andApHeightNotEqualTo(Integer value) {
            addCriterion("ap_height <>", value, "apHeight");
            return (Criteria) this;
        }

        public Criteria andApHeightGreaterThan(Integer value) {
            addCriterion("ap_height >", value, "apHeight");
            return (Criteria) this;
        }

        public Criteria andApHeightGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_height >=", value, "apHeight");
            return (Criteria) this;
        }

        public Criteria andApHeightLessThan(Integer value) {
            addCriterion("ap_height <", value, "apHeight");
            return (Criteria) this;
        }

        public Criteria andApHeightLessThanOrEqualTo(Integer value) {
            addCriterion("ap_height <=", value, "apHeight");
            return (Criteria) this;
        }

        public Criteria andApHeightIn(List<Integer> values) {
            addCriterion("ap_height in", values, "apHeight");
            return (Criteria) this;
        }

        public Criteria andApHeightNotIn(List<Integer> values) {
            addCriterion("ap_height not in", values, "apHeight");
            return (Criteria) this;
        }

        public Criteria andApHeightBetween(Integer value1, Integer value2) {
            addCriterion("ap_height between", value1, value2, "apHeight");
            return (Criteria) this;
        }

        public Criteria andApHeightNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_height not between", value1, value2, "apHeight");
            return (Criteria) this;
        }

        public Criteria andApPriceIsNull() {
            addCriterion("ap_price is null");
            return (Criteria) this;
        }

        public Criteria andApPriceIsNotNull() {
            addCriterion("ap_price is not null");
            return (Criteria) this;
        }

        public Criteria andApPriceEqualTo(Integer value) {
            addCriterion("ap_price =", value, "apPrice");
            return (Criteria) this;
        }

        public Criteria andApPriceNotEqualTo(Integer value) {
            addCriterion("ap_price <>", value, "apPrice");
            return (Criteria) this;
        }

        public Criteria andApPriceGreaterThan(Integer value) {
            addCriterion("ap_price >", value, "apPrice");
            return (Criteria) this;
        }

        public Criteria andApPriceGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_price >=", value, "apPrice");
            return (Criteria) this;
        }

        public Criteria andApPriceLessThan(Integer value) {
            addCriterion("ap_price <", value, "apPrice");
            return (Criteria) this;
        }

        public Criteria andApPriceLessThanOrEqualTo(Integer value) {
            addCriterion("ap_price <=", value, "apPrice");
            return (Criteria) this;
        }

        public Criteria andApPriceIn(List<Integer> values) {
            addCriterion("ap_price in", values, "apPrice");
            return (Criteria) this;
        }

        public Criteria andApPriceNotIn(List<Integer> values) {
            addCriterion("ap_price not in", values, "apPrice");
            return (Criteria) this;
        }

        public Criteria andApPriceBetween(Integer value1, Integer value2) {
            addCriterion("ap_price between", value1, value2, "apPrice");
            return (Criteria) this;
        }

        public Criteria andApPriceNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_price not between", value1, value2, "apPrice");
            return (Criteria) this;
        }

        public Criteria andApSaleTypeIsNull() {
            addCriterion("ap_sale_type is null");
            return (Criteria) this;
        }

        public Criteria andApSaleTypeIsNotNull() {
            addCriterion("ap_sale_type is not null");
            return (Criteria) this;
        }

        public Criteria andApSaleTypeEqualTo(Integer value) {
            addCriterion("ap_sale_type =", value, "apSaleType");
            return (Criteria) this;
        }

        public Criteria andApSaleTypeNotEqualTo(Integer value) {
            addCriterion("ap_sale_type <>", value, "apSaleType");
            return (Criteria) this;
        }

        public Criteria andApSaleTypeGreaterThan(Integer value) {
            addCriterion("ap_sale_type >", value, "apSaleType");
            return (Criteria) this;
        }

        public Criteria andApSaleTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_sale_type >=", value, "apSaleType");
            return (Criteria) this;
        }

        public Criteria andApSaleTypeLessThan(Integer value) {
            addCriterion("ap_sale_type <", value, "apSaleType");
            return (Criteria) this;
        }

        public Criteria andApSaleTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ap_sale_type <=", value, "apSaleType");
            return (Criteria) this;
        }

        public Criteria andApSaleTypeIn(List<Integer> values) {
            addCriterion("ap_sale_type in", values, "apSaleType");
            return (Criteria) this;
        }

        public Criteria andApSaleTypeNotIn(List<Integer> values) {
            addCriterion("ap_sale_type not in", values, "apSaleType");
            return (Criteria) this;
        }

        public Criteria andApSaleTypeBetween(Integer value1, Integer value2) {
            addCriterion("ap_sale_type between", value1, value2, "apSaleType");
            return (Criteria) this;
        }

        public Criteria andApSaleTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_sale_type not between", value1, value2, "apSaleType");
            return (Criteria) this;
        }

        public Criteria andApShowTypeIsNull() {
            addCriterion("ap_show_type is null");
            return (Criteria) this;
        }

        public Criteria andApShowTypeIsNotNull() {
            addCriterion("ap_show_type is not null");
            return (Criteria) this;
        }

        public Criteria andApShowTypeEqualTo(Integer value) {
            addCriterion("ap_show_type =", value, "apShowType");
            return (Criteria) this;
        }

        public Criteria andApShowTypeNotEqualTo(Integer value) {
            addCriterion("ap_show_type <>", value, "apShowType");
            return (Criteria) this;
        }

        public Criteria andApShowTypeGreaterThan(Integer value) {
            addCriterion("ap_show_type >", value, "apShowType");
            return (Criteria) this;
        }

        public Criteria andApShowTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_show_type >=", value, "apShowType");
            return (Criteria) this;
        }

        public Criteria andApShowTypeLessThan(Integer value) {
            addCriterion("ap_show_type <", value, "apShowType");
            return (Criteria) this;
        }

        public Criteria andApShowTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ap_show_type <=", value, "apShowType");
            return (Criteria) this;
        }

        public Criteria andApShowTypeIn(List<Integer> values) {
            addCriterion("ap_show_type in", values, "apShowType");
            return (Criteria) this;
        }

        public Criteria andApShowTypeNotIn(List<Integer> values) {
            addCriterion("ap_show_type not in", values, "apShowType");
            return (Criteria) this;
        }

        public Criteria andApShowTypeBetween(Integer value1, Integer value2) {
            addCriterion("ap_show_type between", value1, value2, "apShowType");
            return (Criteria) this;
        }

        public Criteria andApShowTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_show_type not between", value1, value2, "apShowType");
            return (Criteria) this;
        }

        public Criteria andApStatusIsNull() {
            addCriterion("ap_status is null");
            return (Criteria) this;
        }

        public Criteria andApStatusIsNotNull() {
            addCriterion("ap_status is not null");
            return (Criteria) this;
        }

        public Criteria andApStatusEqualTo(Integer value) {
            addCriterion("ap_status =", value, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusNotEqualTo(Integer value) {
            addCriterion("ap_status <>", value, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusGreaterThan(Integer value) {
            addCriterion("ap_status >", value, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_status >=", value, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusLessThan(Integer value) {
            addCriterion("ap_status <", value, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ap_status <=", value, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusIn(List<Integer> values) {
            addCriterion("ap_status in", values, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusNotIn(List<Integer> values) {
            addCriterion("ap_status not in", values, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusBetween(Integer value1, Integer value2) {
            addCriterion("ap_status between", value1, value2, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_status not between", value1, value2, "apStatus");
            return (Criteria) this;
        }

        public Criteria andApSysTypeIsNull() {
            addCriterion("ap_sys_type is null");
            return (Criteria) this;
        }

        public Criteria andApSysTypeIsNotNull() {
            addCriterion("ap_sys_type is not null");
            return (Criteria) this;
        }

        public Criteria andApSysTypeEqualTo(Integer value) {
            addCriterion("ap_sys_type =", value, "apSysType");
            return (Criteria) this;
        }

        public Criteria andApSysTypeNotEqualTo(Integer value) {
            addCriterion("ap_sys_type <>", value, "apSysType");
            return (Criteria) this;
        }

        public Criteria andApSysTypeGreaterThan(Integer value) {
            addCriterion("ap_sys_type >", value, "apSysType");
            return (Criteria) this;
        }

        public Criteria andApSysTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_sys_type >=", value, "apSysType");
            return (Criteria) this;
        }

        public Criteria andApSysTypeLessThan(Integer value) {
            addCriterion("ap_sys_type <", value, "apSysType");
            return (Criteria) this;
        }

        public Criteria andApSysTypeLessThanOrEqualTo(Integer value) {
            addCriterion("ap_sys_type <=", value, "apSysType");
            return (Criteria) this;
        }

        public Criteria andApSysTypeIn(List<Integer> values) {
            addCriterion("ap_sys_type in", values, "apSysType");
            return (Criteria) this;
        }

        public Criteria andApSysTypeNotIn(List<Integer> values) {
            addCriterion("ap_sys_type not in", values, "apSysType");
            return (Criteria) this;
        }

        public Criteria andApSysTypeBetween(Integer value1, Integer value2) {
            addCriterion("ap_sys_type between", value1, value2, "apSysType");
            return (Criteria) this;
        }

        public Criteria andApSysTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_sys_type not between", value1, value2, "apSysType");
            return (Criteria) this;
        }

        public Criteria andApTextIsNull() {
            addCriterion("ap_text is null");
            return (Criteria) this;
        }

        public Criteria andApTextIsNotNull() {
            addCriterion("ap_text is not null");
            return (Criteria) this;
        }

        public Criteria andApTextEqualTo(String value) {
            addCriterion("ap_text =", value, "apText");
            return (Criteria) this;
        }

        public Criteria andApTextNotEqualTo(String value) {
            addCriterion("ap_text <>", value, "apText");
            return (Criteria) this;
        }

        public Criteria andApTextGreaterThan(String value) {
            addCriterion("ap_text >", value, "apText");
            return (Criteria) this;
        }

        public Criteria andApTextGreaterThanOrEqualTo(String value) {
            addCriterion("ap_text >=", value, "apText");
            return (Criteria) this;
        }

        public Criteria andApTextLessThan(String value) {
            addCriterion("ap_text <", value, "apText");
            return (Criteria) this;
        }

        public Criteria andApTextLessThanOrEqualTo(String value) {
            addCriterion("ap_text <=", value, "apText");
            return (Criteria) this;
        }

        public Criteria andApTextLike(String value) {
            addCriterion("ap_text like", value, "apText");
            return (Criteria) this;
        }

        public Criteria andApTextNotLike(String value) {
            addCriterion("ap_text not like", value, "apText");
            return (Criteria) this;
        }

        public Criteria andApTextIn(List<String> values) {
            addCriterion("ap_text in", values, "apText");
            return (Criteria) this;
        }

        public Criteria andApTextNotIn(List<String> values) {
            addCriterion("ap_text not in", values, "apText");
            return (Criteria) this;
        }

        public Criteria andApTextBetween(String value1, String value2) {
            addCriterion("ap_text between", value1, value2, "apText");
            return (Criteria) this;
        }

        public Criteria andApTextNotBetween(String value1, String value2) {
            addCriterion("ap_text not between", value1, value2, "apText");
            return (Criteria) this;
        }

        public Criteria andApTitleIsNull() {
            addCriterion("ap_title is null");
            return (Criteria) this;
        }

        public Criteria andApTitleIsNotNull() {
            addCriterion("ap_title is not null");
            return (Criteria) this;
        }

        public Criteria andApTitleEqualTo(String value) {
            addCriterion("ap_title =", value, "apTitle");
            return (Criteria) this;
        }

        public Criteria andApTitleNotEqualTo(String value) {
            addCriterion("ap_title <>", value, "apTitle");
            return (Criteria) this;
        }

        public Criteria andApTitleGreaterThan(String value) {
            addCriterion("ap_title >", value, "apTitle");
            return (Criteria) this;
        }

        public Criteria andApTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ap_title >=", value, "apTitle");
            return (Criteria) this;
        }

        public Criteria andApTitleLessThan(String value) {
            addCriterion("ap_title <", value, "apTitle");
            return (Criteria) this;
        }

        public Criteria andApTitleLessThanOrEqualTo(String value) {
            addCriterion("ap_title <=", value, "apTitle");
            return (Criteria) this;
        }

        public Criteria andApTitleLike(String value) {
            addCriterion("ap_title like", value, "apTitle");
            return (Criteria) this;
        }

        public Criteria andApTitleNotLike(String value) {
            addCriterion("ap_title not like", value, "apTitle");
            return (Criteria) this;
        }

        public Criteria andApTitleIn(List<String> values) {
            addCriterion("ap_title in", values, "apTitle");
            return (Criteria) this;
        }

        public Criteria andApTitleNotIn(List<String> values) {
            addCriterion("ap_title not in", values, "apTitle");
            return (Criteria) this;
        }

        public Criteria andApTitleBetween(String value1, String value2) {
            addCriterion("ap_title between", value1, value2, "apTitle");
            return (Criteria) this;
        }

        public Criteria andApTitleNotBetween(String value1, String value2) {
            addCriterion("ap_title not between", value1, value2, "apTitle");
            return (Criteria) this;
        }

        public Criteria andApTypeIsNull() {
            addCriterion("ap_type is null");
            return (Criteria) this;
        }

        public Criteria andApTypeIsNotNull() {
            addCriterion("ap_type is not null");
            return (Criteria) this;
        }

        public Criteria andApTypeEqualTo(String value) {
            addCriterion("ap_type =", value, "apType");
            return (Criteria) this;
        }

        public Criteria andApTypeNotEqualTo(String value) {
            addCriterion("ap_type <>", value, "apType");
            return (Criteria) this;
        }

        public Criteria andApTypeGreaterThan(String value) {
            addCriterion("ap_type >", value, "apType");
            return (Criteria) this;
        }

        public Criteria andApTypeGreaterThanOrEqualTo(String value) {
            addCriterion("ap_type >=", value, "apType");
            return (Criteria) this;
        }

        public Criteria andApTypeLessThan(String value) {
            addCriterion("ap_type <", value, "apType");
            return (Criteria) this;
        }

        public Criteria andApTypeLessThanOrEqualTo(String value) {
            addCriterion("ap_type <=", value, "apType");
            return (Criteria) this;
        }

        public Criteria andApTypeLike(String value) {
            addCriterion("ap_type like", value, "apType");
            return (Criteria) this;
        }

        public Criteria andApTypeNotLike(String value) {
            addCriterion("ap_type not like", value, "apType");
            return (Criteria) this;
        }

        public Criteria andApTypeIn(List<String> values) {
            addCriterion("ap_type in", values, "apType");
            return (Criteria) this;
        }

        public Criteria andApTypeNotIn(List<String> values) {
            addCriterion("ap_type not in", values, "apType");
            return (Criteria) this;
        }

        public Criteria andApTypeBetween(String value1, String value2) {
            addCriterion("ap_type between", value1, value2, "apType");
            return (Criteria) this;
        }

        public Criteria andApTypeNotBetween(String value1, String value2) {
            addCriterion("ap_type not between", value1, value2, "apType");
            return (Criteria) this;
        }

        public Criteria andApUseStatusIsNull() {
            addCriterion("ap_use_status is null");
            return (Criteria) this;
        }

        public Criteria andApUseStatusIsNotNull() {
            addCriterion("ap_use_status is not null");
            return (Criteria) this;
        }

        public Criteria andApUseStatusEqualTo(Integer value) {
            addCriterion("ap_use_status =", value, "apUseStatus");
            return (Criteria) this;
        }

        public Criteria andApUseStatusNotEqualTo(Integer value) {
            addCriterion("ap_use_status <>", value, "apUseStatus");
            return (Criteria) this;
        }

        public Criteria andApUseStatusGreaterThan(Integer value) {
            addCriterion("ap_use_status >", value, "apUseStatus");
            return (Criteria) this;
        }

        public Criteria andApUseStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_use_status >=", value, "apUseStatus");
            return (Criteria) this;
        }

        public Criteria andApUseStatusLessThan(Integer value) {
            addCriterion("ap_use_status <", value, "apUseStatus");
            return (Criteria) this;
        }

        public Criteria andApUseStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ap_use_status <=", value, "apUseStatus");
            return (Criteria) this;
        }

        public Criteria andApUseStatusIn(List<Integer> values) {
            addCriterion("ap_use_status in", values, "apUseStatus");
            return (Criteria) this;
        }

        public Criteria andApUseStatusNotIn(List<Integer> values) {
            addCriterion("ap_use_status not in", values, "apUseStatus");
            return (Criteria) this;
        }

        public Criteria andApUseStatusBetween(Integer value1, Integer value2) {
            addCriterion("ap_use_status between", value1, value2, "apUseStatus");
            return (Criteria) this;
        }

        public Criteria andApUseStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_use_status not between", value1, value2, "apUseStatus");
            return (Criteria) this;
        }

        public Criteria andApWidthIsNull() {
            addCriterion("ap_width is null");
            return (Criteria) this;
        }

        public Criteria andApWidthIsNotNull() {
            addCriterion("ap_width is not null");
            return (Criteria) this;
        }

        public Criteria andApWidthEqualTo(Integer value) {
            addCriterion("ap_width =", value, "apWidth");
            return (Criteria) this;
        }

        public Criteria andApWidthNotEqualTo(Integer value) {
            addCriterion("ap_width <>", value, "apWidth");
            return (Criteria) this;
        }

        public Criteria andApWidthGreaterThan(Integer value) {
            addCriterion("ap_width >", value, "apWidth");
            return (Criteria) this;
        }

        public Criteria andApWidthGreaterThanOrEqualTo(Integer value) {
            addCriterion("ap_width >=", value, "apWidth");
            return (Criteria) this;
        }

        public Criteria andApWidthLessThan(Integer value) {
            addCriterion("ap_width <", value, "apWidth");
            return (Criteria) this;
        }

        public Criteria andApWidthLessThanOrEqualTo(Integer value) {
            addCriterion("ap_width <=", value, "apWidth");
            return (Criteria) this;
        }

        public Criteria andApWidthIn(List<Integer> values) {
            addCriterion("ap_width in", values, "apWidth");
            return (Criteria) this;
        }

        public Criteria andApWidthNotIn(List<Integer> values) {
            addCriterion("ap_width not in", values, "apWidth");
            return (Criteria) this;
        }

        public Criteria andApWidthBetween(Integer value1, Integer value2) {
            addCriterion("ap_width between", value1, value2, "apWidth");
            return (Criteria) this;
        }

        public Criteria andApWidthNotBetween(Integer value1, Integer value2) {
            addCriterion("ap_width not between", value1, value2, "apWidth");
            return (Criteria) this;
        }

        public Criteria andApAccIdIsNull() {
            addCriterion("ap_acc_id is null");
            return (Criteria) this;
        }

        public Criteria andApAccIdIsNotNull() {
            addCriterion("ap_acc_id is not null");
            return (Criteria) this;
        }

        public Criteria andApAccIdEqualTo(Long value) {
            addCriterion("ap_acc_id =", value, "apAccId");
            return (Criteria) this;
        }

        public Criteria andApAccIdNotEqualTo(Long value) {
            addCriterion("ap_acc_id <>", value, "apAccId");
            return (Criteria) this;
        }

        public Criteria andApAccIdGreaterThan(Long value) {
            addCriterion("ap_acc_id >", value, "apAccId");
            return (Criteria) this;
        }

        public Criteria andApAccIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ap_acc_id >=", value, "apAccId");
            return (Criteria) this;
        }

        public Criteria andApAccIdLessThan(Long value) {
            addCriterion("ap_acc_id <", value, "apAccId");
            return (Criteria) this;
        }

        public Criteria andApAccIdLessThanOrEqualTo(Long value) {
            addCriterion("ap_acc_id <=", value, "apAccId");
            return (Criteria) this;
        }

        public Criteria andApAccIdIn(List<Long> values) {
            addCriterion("ap_acc_id in", values, "apAccId");
            return (Criteria) this;
        }

        public Criteria andApAccIdNotIn(List<Long> values) {
            addCriterion("ap_acc_id not in", values, "apAccId");
            return (Criteria) this;
        }

        public Criteria andApAccIdBetween(Long value1, Long value2) {
            addCriterion("ap_acc_id between", value1, value2, "apAccId");
            return (Criteria) this;
        }

        public Criteria andApAccIdNotBetween(Long value1, Long value2) {
            addCriterion("ap_acc_id not between", value1, value2, "apAccId");
            return (Criteria) this;
        }

        public Criteria andApMarkIsNull() {
            addCriterion("ap_mark is null");
            return (Criteria) this;
        }

        public Criteria andApMarkIsNotNull() {
            addCriterion("ap_mark is not null");
            return (Criteria) this;
        }

        public Criteria andApMarkEqualTo(String value) {
            addCriterion("ap_mark =", value, "apMark");
            return (Criteria) this;
        }

        public Criteria andApMarkNotEqualTo(String value) {
            addCriterion("ap_mark <>", value, "apMark");
            return (Criteria) this;
        }

        public Criteria andApMarkGreaterThan(String value) {
            addCriterion("ap_mark >", value, "apMark");
            return (Criteria) this;
        }

        public Criteria andApMarkGreaterThanOrEqualTo(String value) {
            addCriterion("ap_mark >=", value, "apMark");
            return (Criteria) this;
        }

        public Criteria andApMarkLessThan(String value) {
            addCriterion("ap_mark <", value, "apMark");
            return (Criteria) this;
        }

        public Criteria andApMarkLessThanOrEqualTo(String value) {
            addCriterion("ap_mark <=", value, "apMark");
            return (Criteria) this;
        }

        public Criteria andApMarkLike(String value) {
            addCriterion("ap_mark like", value, "apMark");
            return (Criteria) this;
        }

        public Criteria andApMarkNotLike(String value) {
            addCriterion("ap_mark not like", value, "apMark");
            return (Criteria) this;
        }

        public Criteria andApMarkIn(List<String> values) {
            addCriterion("ap_mark in", values, "apMark");
            return (Criteria) this;
        }

        public Criteria andApMarkNotIn(List<String> values) {
            addCriterion("ap_mark not in", values, "apMark");
            return (Criteria) this;
        }

        public Criteria andApMarkBetween(String value1, String value2) {
            addCriterion("ap_mark between", value1, value2, "apMark");
            return (Criteria) this;
        }

        public Criteria andApMarkNotBetween(String value1, String value2) {
            addCriterion("ap_mark not between", value1, value2, "apMark");
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