package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class WapAdvertExample extends BaseQuery{
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WapAdvertExample() {
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

        public Criteria andAdBeginTimeIsNull() {
            addCriterion("ad_begin_time is null");
            return (Criteria) this;
        }

        public Criteria andAdBeginTimeIsNotNull() {
            addCriterion("ad_begin_time is not null");
            return (Criteria) this;
        }

        public Criteria andAdBeginTimeEqualTo(Date value) {
            addCriterion("ad_begin_time =", value, "adBeginTime");
            return (Criteria) this;
        }

        public Criteria andAdBeginTimeNotEqualTo(Date value) {
            addCriterion("ad_begin_time <>", value, "adBeginTime");
            return (Criteria) this;
        }

        public Criteria andAdBeginTimeGreaterThan(Date value) {
            addCriterion("ad_begin_time >", value, "adBeginTime");
            return (Criteria) this;
        }

        public Criteria andAdBeginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ad_begin_time >=", value, "adBeginTime");
            return (Criteria) this;
        }

        public Criteria andAdBeginTimeLessThan(Date value) {
            addCriterion("ad_begin_time <", value, "adBeginTime");
            return (Criteria) this;
        }

        public Criteria andAdBeginTimeLessThanOrEqualTo(Date value) {
            addCriterion("ad_begin_time <=", value, "adBeginTime");
            return (Criteria) this;
        }

        public Criteria andAdBeginTimeIn(List<Date> values) {
            addCriterion("ad_begin_time in", values, "adBeginTime");
            return (Criteria) this;
        }

        public Criteria andAdBeginTimeNotIn(List<Date> values) {
            addCriterion("ad_begin_time not in", values, "adBeginTime");
            return (Criteria) this;
        }

        public Criteria andAdBeginTimeBetween(Date value1, Date value2) {
            addCriterion("ad_begin_time between", value1, value2, "adBeginTime");
            return (Criteria) this;
        }

        public Criteria andAdBeginTimeNotBetween(Date value1, Date value2) {
            addCriterion("ad_begin_time not between", value1, value2, "adBeginTime");
            return (Criteria) this;
        }

        public Criteria andAdClickNumIsNull() {
            addCriterion("ad_click_num is null");
            return (Criteria) this;
        }

        public Criteria andAdClickNumIsNotNull() {
            addCriterion("ad_click_num is not null");
            return (Criteria) this;
        }

        public Criteria andAdClickNumEqualTo(Integer value) {
            addCriterion("ad_click_num =", value, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumNotEqualTo(Integer value) {
            addCriterion("ad_click_num <>", value, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumGreaterThan(Integer value) {
            addCriterion("ad_click_num >", value, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_click_num >=", value, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumLessThan(Integer value) {
            addCriterion("ad_click_num <", value, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumLessThanOrEqualTo(Integer value) {
            addCriterion("ad_click_num <=", value, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumIn(List<Integer> values) {
            addCriterion("ad_click_num in", values, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumNotIn(List<Integer> values) {
            addCriterion("ad_click_num not in", values, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumBetween(Integer value1, Integer value2) {
            addCriterion("ad_click_num between", value1, value2, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdClickNumNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_click_num not between", value1, value2, "adClickNum");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeIsNull() {
            addCriterion("ad_end_time is null");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeIsNotNull() {
            addCriterion("ad_end_time is not null");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeEqualTo(Date value) {
            addCriterion("ad_end_time =", value, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeNotEqualTo(Date value) {
            addCriterion("ad_end_time <>", value, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeGreaterThan(Date value) {
            addCriterion("ad_end_time >", value, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ad_end_time >=", value, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeLessThan(Date value) {
            addCriterion("ad_end_time <", value, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeLessThanOrEqualTo(Date value) {
            addCriterion("ad_end_time <=", value, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeIn(List<Date> values) {
            addCriterion("ad_end_time in", values, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeNotIn(List<Date> values) {
            addCriterion("ad_end_time not in", values, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeBetween(Date value1, Date value2) {
            addCriterion("ad_end_time between", value1, value2, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdEndTimeNotBetween(Date value1, Date value2) {
            addCriterion("ad_end_time not between", value1, value2, "adEndTime");
            return (Criteria) this;
        }

        public Criteria andAdGoldIsNull() {
            addCriterion("ad_gold is null");
            return (Criteria) this;
        }

        public Criteria andAdGoldIsNotNull() {
            addCriterion("ad_gold is not null");
            return (Criteria) this;
        }

        public Criteria andAdGoldEqualTo(Integer value) {
            addCriterion("ad_gold =", value, "adGold");
            return (Criteria) this;
        }

        public Criteria andAdGoldNotEqualTo(Integer value) {
            addCriterion("ad_gold <>", value, "adGold");
            return (Criteria) this;
        }

        public Criteria andAdGoldGreaterThan(Integer value) {
            addCriterion("ad_gold >", value, "adGold");
            return (Criteria) this;
        }

        public Criteria andAdGoldGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_gold >=", value, "adGold");
            return (Criteria) this;
        }

        public Criteria andAdGoldLessThan(Integer value) {
            addCriterion("ad_gold <", value, "adGold");
            return (Criteria) this;
        }

        public Criteria andAdGoldLessThanOrEqualTo(Integer value) {
            addCriterion("ad_gold <=", value, "adGold");
            return (Criteria) this;
        }

        public Criteria andAdGoldIn(List<Integer> values) {
            addCriterion("ad_gold in", values, "adGold");
            return (Criteria) this;
        }

        public Criteria andAdGoldNotIn(List<Integer> values) {
            addCriterion("ad_gold not in", values, "adGold");
            return (Criteria) this;
        }

        public Criteria andAdGoldBetween(Integer value1, Integer value2) {
            addCriterion("ad_gold between", value1, value2, "adGold");
            return (Criteria) this;
        }

        public Criteria andAdGoldNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_gold not between", value1, value2, "adGold");
            return (Criteria) this;
        }

        public Criteria andAdSlideSequenceIsNull() {
            addCriterion("ad_slide_sequence is null");
            return (Criteria) this;
        }

        public Criteria andAdSlideSequenceIsNotNull() {
            addCriterion("ad_slide_sequence is not null");
            return (Criteria) this;
        }

        public Criteria andAdSlideSequenceEqualTo(Integer value) {
            addCriterion("ad_slide_sequence =", value, "adSlideSequence");
            return (Criteria) this;
        }

        public Criteria andAdSlideSequenceNotEqualTo(Integer value) {
            addCriterion("ad_slide_sequence <>", value, "adSlideSequence");
            return (Criteria) this;
        }

        public Criteria andAdSlideSequenceGreaterThan(Integer value) {
            addCriterion("ad_slide_sequence >", value, "adSlideSequence");
            return (Criteria) this;
        }

        public Criteria andAdSlideSequenceGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_slide_sequence >=", value, "adSlideSequence");
            return (Criteria) this;
        }

        public Criteria andAdSlideSequenceLessThan(Integer value) {
            addCriterion("ad_slide_sequence <", value, "adSlideSequence");
            return (Criteria) this;
        }

        public Criteria andAdSlideSequenceLessThanOrEqualTo(Integer value) {
            addCriterion("ad_slide_sequence <=", value, "adSlideSequence");
            return (Criteria) this;
        }

        public Criteria andAdSlideSequenceIn(List<Integer> values) {
            addCriterion("ad_slide_sequence in", values, "adSlideSequence");
            return (Criteria) this;
        }

        public Criteria andAdSlideSequenceNotIn(List<Integer> values) {
            addCriterion("ad_slide_sequence not in", values, "adSlideSequence");
            return (Criteria) this;
        }

        public Criteria andAdSlideSequenceBetween(Integer value1, Integer value2) {
            addCriterion("ad_slide_sequence between", value1, value2, "adSlideSequence");
            return (Criteria) this;
        }

        public Criteria andAdSlideSequenceNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_slide_sequence not between", value1, value2, "adSlideSequence");
            return (Criteria) this;
        }

        public Criteria andAdStatusIsNull() {
            addCriterion("ad_status is null");
            return (Criteria) this;
        }

        public Criteria andAdStatusIsNotNull() {
            addCriterion("ad_status is not null");
            return (Criteria) this;
        }

        public Criteria andAdStatusEqualTo(Integer value) {
            addCriterion("ad_status =", value, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusNotEqualTo(Integer value) {
            addCriterion("ad_status <>", value, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusGreaterThan(Integer value) {
            addCriterion("ad_status >", value, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("ad_status >=", value, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusLessThan(Integer value) {
            addCriterion("ad_status <", value, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusLessThanOrEqualTo(Integer value) {
            addCriterion("ad_status <=", value, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusIn(List<Integer> values) {
            addCriterion("ad_status in", values, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusNotIn(List<Integer> values) {
            addCriterion("ad_status not in", values, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusBetween(Integer value1, Integer value2) {
            addCriterion("ad_status between", value1, value2, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("ad_status not between", value1, value2, "adStatus");
            return (Criteria) this;
        }

        public Criteria andAdTextIsNull() {
            addCriterion("ad_text is null");
            return (Criteria) this;
        }

        public Criteria andAdTextIsNotNull() {
            addCriterion("ad_text is not null");
            return (Criteria) this;
        }

        public Criteria andAdTextEqualTo(String value) {
            addCriterion("ad_text =", value, "adText");
            return (Criteria) this;
        }

        public Criteria andAdTextNotEqualTo(String value) {
            addCriterion("ad_text <>", value, "adText");
            return (Criteria) this;
        }

        public Criteria andAdTextGreaterThan(String value) {
            addCriterion("ad_text >", value, "adText");
            return (Criteria) this;
        }

        public Criteria andAdTextGreaterThanOrEqualTo(String value) {
            addCriterion("ad_text >=", value, "adText");
            return (Criteria) this;
        }

        public Criteria andAdTextLessThan(String value) {
            addCriterion("ad_text <", value, "adText");
            return (Criteria) this;
        }

        public Criteria andAdTextLessThanOrEqualTo(String value) {
            addCriterion("ad_text <=", value, "adText");
            return (Criteria) this;
        }

        public Criteria andAdTextLike(String value) {
            addCriterion("ad_text like", value, "adText");
            return (Criteria) this;
        }

        public Criteria andAdTextNotLike(String value) {
            addCriterion("ad_text not like", value, "adText");
            return (Criteria) this;
        }

        public Criteria andAdTextIn(List<String> values) {
            addCriterion("ad_text in", values, "adText");
            return (Criteria) this;
        }

        public Criteria andAdTextNotIn(List<String> values) {
            addCriterion("ad_text not in", values, "adText");
            return (Criteria) this;
        }

        public Criteria andAdTextBetween(String value1, String value2) {
            addCriterion("ad_text between", value1, value2, "adText");
            return (Criteria) this;
        }

        public Criteria andAdTextNotBetween(String value1, String value2) {
            addCriterion("ad_text not between", value1, value2, "adText");
            return (Criteria) this;
        }

        public Criteria andAdTitleIsNull() {
            addCriterion("ad_title is null");
            return (Criteria) this;
        }

        public Criteria andAdTitleIsNotNull() {
            addCriterion("ad_title is not null");
            return (Criteria) this;
        }

        public Criteria andAdTitleEqualTo(String value) {
            addCriterion("ad_title =", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleNotEqualTo(String value) {
            addCriterion("ad_title <>", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleGreaterThan(String value) {
            addCriterion("ad_title >", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleGreaterThanOrEqualTo(String value) {
            addCriterion("ad_title >=", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleLessThan(String value) {
            addCriterion("ad_title <", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleLessThanOrEqualTo(String value) {
            addCriterion("ad_title <=", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleLike(String value) {
            addCriterion("ad_title like", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleNotLike(String value) {
            addCriterion("ad_title not like", value, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleIn(List<String> values) {
            addCriterion("ad_title in", values, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleNotIn(List<String> values) {
            addCriterion("ad_title not in", values, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleBetween(String value1, String value2) {
            addCriterion("ad_title between", value1, value2, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdTitleNotBetween(String value1, String value2) {
            addCriterion("ad_title not between", value1, value2, "adTitle");
            return (Criteria) this;
        }

        public Criteria andAdUrlIsNull() {
            addCriterion("ad_url is null");
            return (Criteria) this;
        }

        public Criteria andAdUrlIsNotNull() {
            addCriterion("ad_url is not null");
            return (Criteria) this;
        }

        public Criteria andAdUrlEqualTo(String value) {
            addCriterion("ad_url =", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlNotEqualTo(String value) {
            addCriterion("ad_url <>", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlGreaterThan(String value) {
            addCriterion("ad_url >", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ad_url >=", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlLessThan(String value) {
            addCriterion("ad_url <", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlLessThanOrEqualTo(String value) {
            addCriterion("ad_url <=", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlLike(String value) {
            addCriterion("ad_url like", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlNotLike(String value) {
            addCriterion("ad_url not like", value, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlIn(List<String> values) {
            addCriterion("ad_url in", values, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlNotIn(List<String> values) {
            addCriterion("ad_url not in", values, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlBetween(String value1, String value2) {
            addCriterion("ad_url between", value1, value2, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdUrlNotBetween(String value1, String value2) {
            addCriterion("ad_url not between", value1, value2, "adUrl");
            return (Criteria) this;
        }

        public Criteria andAdAccIdIsNull() {
            addCriterion("ad_acc_id is null");
            return (Criteria) this;
        }

        public Criteria andAdAccIdIsNotNull() {
            addCriterion("ad_acc_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdAccIdEqualTo(Long value) {
            addCriterion("ad_acc_id =", value, "adAccId");
            return (Criteria) this;
        }

        public Criteria andAdAccIdNotEqualTo(Long value) {
            addCriterion("ad_acc_id <>", value, "adAccId");
            return (Criteria) this;
        }

        public Criteria andAdAccIdGreaterThan(Long value) {
            addCriterion("ad_acc_id >", value, "adAccId");
            return (Criteria) this;
        }

        public Criteria andAdAccIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ad_acc_id >=", value, "adAccId");
            return (Criteria) this;
        }

        public Criteria andAdAccIdLessThan(Long value) {
            addCriterion("ad_acc_id <", value, "adAccId");
            return (Criteria) this;
        }

        public Criteria andAdAccIdLessThanOrEqualTo(Long value) {
            addCriterion("ad_acc_id <=", value, "adAccId");
            return (Criteria) this;
        }

        public Criteria andAdAccIdIn(List<Long> values) {
            addCriterion("ad_acc_id in", values, "adAccId");
            return (Criteria) this;
        }

        public Criteria andAdAccIdNotIn(List<Long> values) {
            addCriterion("ad_acc_id not in", values, "adAccId");
            return (Criteria) this;
        }

        public Criteria andAdAccIdBetween(Long value1, Long value2) {
            addCriterion("ad_acc_id between", value1, value2, "adAccId");
            return (Criteria) this;
        }

        public Criteria andAdAccIdNotBetween(Long value1, Long value2) {
            addCriterion("ad_acc_id not between", value1, value2, "adAccId");
            return (Criteria) this;
        }

        public Criteria andAdApIdIsNull() {
            addCriterion("ad_ap_id is null");
            return (Criteria) this;
        }

        public Criteria andAdApIdIsNotNull() {
            addCriterion("ad_ap_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdApIdEqualTo(Long value) {
            addCriterion("ad_ap_id =", value, "adApId");
            return (Criteria) this;
        }

        public Criteria andAdApIdNotEqualTo(Long value) {
            addCriterion("ad_ap_id <>", value, "adApId");
            return (Criteria) this;
        }

        public Criteria andAdApIdGreaterThan(Long value) {
            addCriterion("ad_ap_id >", value, "adApId");
            return (Criteria) this;
        }

        public Criteria andAdApIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ad_ap_id >=", value, "adApId");
            return (Criteria) this;
        }

        public Criteria andAdApIdLessThan(Long value) {
            addCriterion("ad_ap_id <", value, "adApId");
            return (Criteria) this;
        }

        public Criteria andAdApIdLessThanOrEqualTo(Long value) {
            addCriterion("ad_ap_id <=", value, "adApId");
            return (Criteria) this;
        }

        public Criteria andAdApIdIn(List<Long> values) {
            addCriterion("ad_ap_id in", values, "adApId");
            return (Criteria) this;
        }

        public Criteria andAdApIdNotIn(List<Long> values) {
            addCriterion("ad_ap_id not in", values, "adApId");
            return (Criteria) this;
        }

        public Criteria andAdApIdBetween(Long value1, Long value2) {
            addCriterion("ad_ap_id between", value1, value2, "adApId");
            return (Criteria) this;
        }

        public Criteria andAdApIdNotBetween(Long value1, Long value2) {
            addCriterion("ad_ap_id not between", value1, value2, "adApId");
            return (Criteria) this;
        }

        public Criteria andAdUserIdIsNull() {
            addCriterion("ad_user_id is null");
            return (Criteria) this;
        }

        public Criteria andAdUserIdIsNotNull() {
            addCriterion("ad_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdUserIdEqualTo(Long value) {
            addCriterion("ad_user_id =", value, "adUserId");
            return (Criteria) this;
        }

        public Criteria andAdUserIdNotEqualTo(Long value) {
            addCriterion("ad_user_id <>", value, "adUserId");
            return (Criteria) this;
        }

        public Criteria andAdUserIdGreaterThan(Long value) {
            addCriterion("ad_user_id >", value, "adUserId");
            return (Criteria) this;
        }

        public Criteria andAdUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ad_user_id >=", value, "adUserId");
            return (Criteria) this;
        }

        public Criteria andAdUserIdLessThan(Long value) {
            addCriterion("ad_user_id <", value, "adUserId");
            return (Criteria) this;
        }

        public Criteria andAdUserIdLessThanOrEqualTo(Long value) {
            addCriterion("ad_user_id <=", value, "adUserId");
            return (Criteria) this;
        }

        public Criteria andAdUserIdIn(List<Long> values) {
            addCriterion("ad_user_id in", values, "adUserId");
            return (Criteria) this;
        }

        public Criteria andAdUserIdNotIn(List<Long> values) {
            addCriterion("ad_user_id not in", values, "adUserId");
            return (Criteria) this;
        }

        public Criteria andAdUserIdBetween(Long value1, Long value2) {
            addCriterion("ad_user_id between", value1, value2, "adUserId");
            return (Criteria) this;
        }

        public Criteria andAdUserIdNotBetween(Long value1, Long value2) {
            addCriterion("ad_user_id not between", value1, value2, "adUserId");
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