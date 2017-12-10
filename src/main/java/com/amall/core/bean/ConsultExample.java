package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.amall.core.web.BaseQuery;

public class ConsultExample extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ConsultExample() {
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

        public Criteria andConsultEmailIsNull() {
            addCriterion("consult_email is null");
            return (Criteria) this;
        }

        public Criteria andConsultEmailIsNotNull() {
            addCriterion("consult_email is not null");
            return (Criteria) this;
        }

        public Criteria andConsultEmailEqualTo(String value) {
            addCriterion("consult_email =", value, "consultEmail");
            return (Criteria) this;
        }

        public Criteria andConsultEmailNotEqualTo(String value) {
            addCriterion("consult_email <>", value, "consultEmail");
            return (Criteria) this;
        }

        public Criteria andConsultEmailGreaterThan(String value) {
            addCriterion("consult_email >", value, "consultEmail");
            return (Criteria) this;
        }

        public Criteria andConsultEmailGreaterThanOrEqualTo(String value) {
            addCriterion("consult_email >=", value, "consultEmail");
            return (Criteria) this;
        }

        public Criteria andConsultEmailLessThan(String value) {
            addCriterion("consult_email <", value, "consultEmail");
            return (Criteria) this;
        }

        public Criteria andConsultEmailLessThanOrEqualTo(String value) {
            addCriterion("consult_email <=", value, "consultEmail");
            return (Criteria) this;
        }

        public Criteria andConsultEmailLike(String value) {
            addCriterion("consult_email like", value, "consultEmail");
            return (Criteria) this;
        }

        public Criteria andConsultEmailNotLike(String value) {
            addCriterion("consult_email not like", value, "consultEmail");
            return (Criteria) this;
        }

        public Criteria andConsultEmailIn(List<String> values) {
            addCriterion("consult_email in", values, "consultEmail");
            return (Criteria) this;
        }

        public Criteria andConsultEmailNotIn(List<String> values) {
            addCriterion("consult_email not in", values, "consultEmail");
            return (Criteria) this;
        }

        public Criteria andConsultEmailBetween(String value1, String value2) {
            addCriterion("consult_email between", value1, value2, "consultEmail");
            return (Criteria) this;
        }

        public Criteria andConsultEmailNotBetween(String value1, String value2) {
            addCriterion("consult_email not between", value1, value2, "consultEmail");
            return (Criteria) this;
        }

        public Criteria andReplyIsNull() {
            addCriterion("reply is null");
            return (Criteria) this;
        }

        public Criteria andReplyIsNotNull() {
            addCriterion("reply is not null");
            return (Criteria) this;
        }

        public Criteria andReplyEqualTo(Boolean value) {
            addCriterion("reply =", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotEqualTo(Boolean value) {
            addCriterion("reply <>", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyGreaterThan(Boolean value) {
            addCriterion("reply >", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("reply >=", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyLessThan(Boolean value) {
            addCriterion("reply <", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyLessThanOrEqualTo(Boolean value) {
            addCriterion("reply <=", value, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyIn(List<Boolean> values) {
            addCriterion("reply in", values, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotIn(List<Boolean> values) {
            addCriterion("reply not in", values, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyBetween(Boolean value1, Boolean value2) {
            addCriterion("reply between", value1, value2, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("reply not between", value1, value2, "reply");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNull() {
            addCriterion("reply_time is null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIsNotNull() {
            addCriterion("reply_time is not null");
            return (Criteria) this;
        }

        public Criteria andReplyTimeEqualTo(Date value) {
            addCriterion("reply_time =", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotEqualTo(Date value) {
            addCriterion("reply_time <>", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThan(Date value) {
            addCriterion("reply_time >", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("reply_time >=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThan(Date value) {
            addCriterion("reply_time <", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeLessThanOrEqualTo(Date value) {
            addCriterion("reply_time <=", value, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeIn(List<Date> values) {
            addCriterion("reply_time in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotIn(List<Date> values) {
            addCriterion("reply_time not in", values, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeBetween(Date value1, Date value2) {
            addCriterion("reply_time between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andReplyTimeNotBetween(Date value1, Date value2) {
            addCriterion("reply_time not between", value1, value2, "replyTime");
            return (Criteria) this;
        }

        public Criteria andConsultUserIdIsNull() {
            addCriterion("consult_user_id is null");
            return (Criteria) this;
        }

        public Criteria andConsultUserIdIsNotNull() {
            addCriterion("consult_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andConsultUserIdEqualTo(Long value) {
            addCriterion("consult_user_id =", value, "consultUserId");
            return (Criteria) this;
        }

        public Criteria andConsultUserIdNotEqualTo(Long value) {
            addCriterion("consult_user_id <>", value, "consultUserId");
            return (Criteria) this;
        }

        public Criteria andConsultUserIdGreaterThan(Long value) {
            addCriterion("consult_user_id >", value, "consultUserId");
            return (Criteria) this;
        }

        public Criteria andConsultUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("consult_user_id >=", value, "consultUserId");
            return (Criteria) this;
        }

        public Criteria andConsultUserIdLessThan(Long value) {
            addCriterion("consult_user_id <", value, "consultUserId");
            return (Criteria) this;
        }

        public Criteria andConsultUserIdLessThanOrEqualTo(Long value) {
            addCriterion("consult_user_id <=", value, "consultUserId");
            return (Criteria) this;
        }

        public Criteria andConsultUserIdIn(List<Long> values) {
            addCriterion("consult_user_id in", values, "consultUserId");
            return (Criteria) this;
        }

        public Criteria andConsultUserIdNotIn(List<Long> values) {
            addCriterion("consult_user_id not in", values, "consultUserId");
            return (Criteria) this;
        }

        public Criteria andConsultUserIdBetween(Long value1, Long value2) {
            addCriterion("consult_user_id between", value1, value2, "consultUserId");
            return (Criteria) this;
        }

        public Criteria andConsultUserIdNotBetween(Long value1, Long value2) {
            addCriterion("consult_user_id not between", value1, value2, "consultUserId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNull() {
            addCriterion("goods_id is null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIsNotNull() {
            addCriterion("goods_id is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsIdEqualTo(Long value) {
            addCriterion("goods_id =", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotEqualTo(Long value) {
            addCriterion("goods_id <>", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThan(Long value) {
            addCriterion("goods_id >", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdGreaterThanOrEqualTo(Long value) {
            addCriterion("goods_id >=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThan(Long value) {
            addCriterion("goods_id <", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdLessThanOrEqualTo(Long value) {
            addCriterion("goods_id <=", value, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdIn(List<Long> values) {
            addCriterion("goods_id in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotIn(List<Long> values) {
            addCriterion("goods_id not in", values, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdBetween(Long value1, Long value2) {
            addCriterion("goods_id between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andGoodsIdNotBetween(Long value1, Long value2) {
            addCriterion("goods_id not between", value1, value2, "goodsId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdIsNull() {
            addCriterion("reply_user_id is null");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdIsNotNull() {
            addCriterion("reply_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdEqualTo(Long value) {
            addCriterion("reply_user_id =", value, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdNotEqualTo(Long value) {
            addCriterion("reply_user_id <>", value, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdGreaterThan(Long value) {
            addCriterion("reply_user_id >", value, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("reply_user_id >=", value, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdLessThan(Long value) {
            addCriterion("reply_user_id <", value, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdLessThanOrEqualTo(Long value) {
            addCriterion("reply_user_id <=", value, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdIn(List<Long> values) {
            addCriterion("reply_user_id in", values, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdNotIn(List<Long> values) {
            addCriterion("reply_user_id not in", values, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdBetween(Long value1, Long value2) {
            addCriterion("reply_user_id between", value1, value2, "replyUserId");
            return (Criteria) this;
        }

        public Criteria andReplyUserIdNotBetween(Long value1, Long value2) {
            addCriterion("reply_user_id not between", value1, value2, "replyUserId");
            return (Criteria) this;
        }
        
        public Criteria andConsultContentIsNull() {
            addCriterion("consult_content is null");
            return (Criteria) this;
        }

        public Criteria andConsultContentIsNotNull() {
            addCriterion("consult_content is not null");
            return (Criteria) this;
        }

        public Criteria andConsultContentEqualTo(String value) {
            addCriterion("consult_content =", value, "consultContent");
            return (Criteria) this;
        }

        public Criteria andConsultContentNotEqualTo(String value) {
            addCriterion("consult_content <>", value, "consultContent");
            return (Criteria) this;
        }

        public Criteria andConsultContentGreaterThan(String value) {
            addCriterion("consult_content >", value, "consultContent");
            return (Criteria) this;
        }

        public Criteria andConsultContentGreaterThanOrEqualTo(String value) {
            addCriterion("consult_content >=", value, "consultContent");
            return (Criteria) this;
        }

        public Criteria andConsultContentLessThan(String value) {
            addCriterion("consult_content <", value, "consultContent");
            return (Criteria) this;
        }

        public Criteria andConsultContentLessThanOrEqualTo(String value) {
            addCriterion("consult_content <=", value, "consultContent");
            return (Criteria) this;
        }

        public Criteria andConsultContentLike(String value) {
            addCriterion("consult_content like", value, "consultContent");
            return (Criteria) this;
        }

        public Criteria andConsultContentNotLike(String value) {
            addCriterion("consult_content not like", value, "consultContent");
            return (Criteria) this;
        }

        public Criteria andConsultContentIn(List<String> values) {
            addCriterion("consult_content in", values, "consultContent");
            return (Criteria) this;
        }

        public Criteria andConsultContentNotIn(List<String> values) {
            addCriterion("consult_content not in", values, "consultContent");
            return (Criteria) this;
        }

        public Criteria andConsultContentBetween(String value1, String value2) {
            addCriterion("consult_content between", value1, value2, "consultContent");
            return (Criteria) this;
        }

        public Criteria andConsultContentNotBetween(String value1, String value2) {
            addCriterion("consult_content not between", value1, value2, "consultContent");
            return (Criteria) this;
        }
        
        public Criteria andConsultReplyIsNull() {
            addCriterion("consult_reply is null");
            return (Criteria) this;
        }

        public Criteria andConsultReplyIsNotNull() {
            addCriterion("consult_reply is not null");
            return (Criteria) this;
        }

        public Criteria andConsultReplyEqualTo(String value) {
            addCriterion("consult_reply =", value, "consultReply");
            return (Criteria) this;
        }

        public Criteria andConsultReplyNotEqualTo(String value) {
            addCriterion("consult_reply <>", value, "consultReply");
            return (Criteria) this;
        }

        public Criteria andConsultReplyGreaterThan(String value) {
            addCriterion("consult_reply >", value, "consultReply");
            return (Criteria) this;
        }

        public Criteria andConsultReplyGreaterThanOrEqualTo(String value) {
            addCriterion("consult_reply >=", value, "consultReply");
            return (Criteria) this;
        }

        public Criteria andConsultReplyLessThan(String value) {
            addCriterion("consult_reply <", value, "consultReply");
            return (Criteria) this;
        }

        public Criteria andConsultReplyLessThanOrEqualTo(String value) {
            addCriterion("consult_reply <=", value, "consultReply");
            return (Criteria) this;
        }

        public Criteria andConsultReplyLike(String value) {
            addCriterion("consult_reply like", value, "consultReply");
            return (Criteria) this;
        }

        public Criteria andConsultReplyNotLike(String value) {
            addCriterion("consult_reply not like", value, "consultReply");
            return (Criteria) this;
        }

        public Criteria andConsultReplyIn(List<String> values) {
            addCriterion("consult_reply in", values, "consultReply");
            return (Criteria) this;
        }

        public Criteria andConsultReplyNotIn(List<String> values) {
            addCriterion("consult_reply not in", values, "consultReply");
            return (Criteria) this;
        }

        public Criteria andConsultReplyBetween(String value1, String value2) {
            addCriterion("consult_reply between", value1, value2, "consultReply");
            return (Criteria) this;
        }

        public Criteria andConsultReplyNotBetween(String value1, String value2) {
            addCriterion("consult_reply not between", value1, value2, "consultReply");
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