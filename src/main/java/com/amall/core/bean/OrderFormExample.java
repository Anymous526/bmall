package com.amall.core.bean;

import com.amall.core.web.BaseQuery;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderFormExample extends BaseQuery
{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	protected String orderByType;

	protected String orderByClause;

	protected boolean distinct;

	protected List <Criteria> oredCriteria;

	public OrderFormExample ( )
	{
		oredCriteria = new ArrayList <Criteria> ();
	}

	public void setOrderByClause (String orderByClause)
		{
			this.orderByClause = orderByClause;
		}

	public String getOrderByType ( )
		{
			return orderByType;
		}

	public void setOrderByType (String orderByType)
		{
			this.orderByType = orderByType;
		}

	public String getOrderByClause ( )
		{
			return orderByClause;
		}

	public void setDistinct (boolean distinct)
		{
			this.distinct = distinct;
		}

	public boolean isDistinct ( )
		{
			return distinct;
		}

	public List <Criteria> getOredCriteria ( )
		{
			return oredCriteria;
		}

	public void or (Criteria criteria)
		{
			oredCriteria.add (criteria);
		}

	public Criteria or ( )
		{
			Criteria criteria = createCriteriaInternal ();
			oredCriteria.add (criteria);
			return criteria;
		}

	public Criteria createCriteria ( )
		{
			Criteria criteria = createCriteriaInternal ();
			if (oredCriteria.size () == 0)
			{
				oredCriteria.add (criteria);
			}
			return criteria;
		}

	protected Criteria createCriteriaInternal ( )
		{
			Criteria criteria = new Criteria ();
			return criteria;
		}

	public void clear ( )
		{
			oredCriteria.clear ();
			orderByClause = null;
			distinct = false;
		}

	protected abstract static class GeneratedCriteria
	{

		protected List <Criterion> criteria;

		protected GeneratedCriteria ( )
		{
			super ();
			criteria = new ArrayList <Criterion> ();
		}

		public boolean isValid ( )
			{
				return criteria.size () > 0;
			}

		public List <Criterion> getAllCriteria ( )
			{
				return criteria;
			}

		public List <Criterion> getCriteria ( )
			{
				return criteria;
			}

		protected void addCriterion (String condition)
			{
				if (condition == null)
				{
					throw new RuntimeException ("Value for condition cannot be null");
				}
				criteria.add (new Criterion (condition));
			}

		protected void addCriterion (String condition , Object value , String property)
			{
				if (value == null)
				{
					throw new RuntimeException ("Value for " + property + " cannot be null");
				}
				criteria.add (new Criterion (condition , value));
			}

		protected void addCriterion (String condition , Object value1 , Object value2 , String property)
			{
				if (value1 == null || value2 == null)
				{
					throw new RuntimeException ("Between values for " + property + " cannot be null");
				}
				criteria.add (new Criterion (condition , value1 , value2));
			}

		public Criteria andIdIsNull ( )
			{
				addCriterion ("id is null");
				return (Criteria) this;
			}

		public Criteria andIdIsNotNull ( )
			{
				addCriterion ("id is not null");
				return (Criteria) this;
			}

		public Criteria andIdEqualTo (Long value)
			{
				addCriterion ("id =" , value , "id");
				return (Criteria) this;
			}

		public Criteria andGroupIdEqualTo (Long value)
			{
				addCriterion ("group_id =" , value , "groupId");
				return (Criteria) this;
			}

		public Criteria andGroupIdIsNull ( )
			{
				addCriterion ("group_id is null");
				return (Criteria) this;
			}

		public Criteria andGroupIdIsNotNull ( )
			{
				addCriterion ("group_id is not null");
				return (Criteria) this;
			}

		public Criteria andIdNotEqualTo (Long value)
			{
				addCriterion ("id <>" , value , "id");
				return (Criteria) this;
			}

		public Criteria andIdGreaterThan (Long value)
			{
				addCriterion ("id >" , value , "id");
				return (Criteria) this;
			}

		public Criteria andIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("id >=" , value , "id");
				return (Criteria) this;
			}

		public Criteria andIdLessThan (Long value)
			{
				addCriterion ("id <" , value , "id");
				return (Criteria) this;
			}

		public Criteria andIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("id <=" , value , "id");
				return (Criteria) this;
			}

		public Criteria andIdIn (List <Long> values)
			{
				addCriterion ("id in" , values , "id");
				return (Criteria) this;
			}

		public Criteria andIdNotIn (List <Long> values)
			{
				addCriterion ("id not in" , values , "id");
				return (Criteria) this;
			}

		public Criteria andIdBetween (Long value1 , Long value2)
			{
				addCriterion ("id between" , value1 , value2 , "id");
				return (Criteria) this;
			}

		public Criteria andIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("id not between" , value1 , value2 , "id");
				return (Criteria) this;
			}

		public Criteria andAddtimeIsNull ( )
			{
				addCriterion ("addTime is null");
				return (Criteria) this;
			}

		public Criteria andAddtimeIsNotNull ( )
			{
				addCriterion ("addTime is not null");
				return (Criteria) this;
			}

		public Criteria andAddtimeEqualTo (Date value)
			{
				addCriterion ("addTime =" , value , "addtime");
				return (Criteria) this;
			}

		public Criteria andAddtimeNotEqualTo (Date value)
			{
				addCriterion ("addTime <>" , value , "addtime");
				return (Criteria) this;
			}

		public Criteria andAddtimeGreaterThan (Date value)
			{
				addCriterion ("addTime >" , value , "addtime");
				return (Criteria) this;
			}

		public Criteria andAddtimeGreaterThanOrEqualTo (Date value)
			{
				addCriterion ("addTime >=" , value , "addtime");
				return (Criteria) this;
			}

		public Criteria andAddtimeLessThan (Date value)
			{
				addCriterion ("addTime <" , value , "addtime");
				return (Criteria) this;
			}

		public Criteria andAddtimeLessThanOrEqualTo (Date value)
			{
				addCriterion ("addTime <=" , value , "addtime");
				return (Criteria) this;
			}

		public Criteria andAddtimeIn (List <Date> values)
			{
				addCriterion ("addTime in" , values , "addtime");
				return (Criteria) this;
			}

		public Criteria andAddtimeNotIn (List <Date> values)
			{
				addCriterion ("addTime not in" , values , "addtime");
				return (Criteria) this;
			}

		public Criteria andAddtimeBetween (Date value1 , Date value2)
			{
				addCriterion ("addTime between" , value1 , value2 , "addtime");
				return (Criteria) this;
			}

		public Criteria andAddtimeNotBetween (Date value1 , Date value2)
			{
				addCriterion ("addTime not between" , value1 , value2 , "addtime");
				return (Criteria) this;
			}

		public Criteria andDeletestatusIsNull ( )
			{
				addCriterion ("deleteStatus is null");
				return (Criteria) this;
			}

		public Criteria andDeletestatusIsNotNull ( )
			{
				addCriterion ("deleteStatus is not null");
				return (Criteria) this;
			}

		public Criteria andDeletestatusEqualTo (Boolean value)
			{
				addCriterion ("deleteStatus =" , value , "deletestatus");
				return (Criteria) this;
			}

		public Criteria andDeletestatusNotEqualTo (Boolean value)
			{
				addCriterion ("deleteStatus <>" , value , "deletestatus");
				return (Criteria) this;
			}

		public Criteria andDeletestatusGreaterThan (Boolean value)
			{
				addCriterion ("deleteStatus >" , value , "deletestatus");
				return (Criteria) this;
			}

		public Criteria andDeletestatusGreaterThanOrEqualTo (Boolean value)
			{
				addCriterion ("deleteStatus >=" , value , "deletestatus");
				return (Criteria) this;
			}

		public Criteria andDeletestatusLessThan (Boolean value)
			{
				addCriterion ("deleteStatus <" , value , "deletestatus");
				return (Criteria) this;
			}

		public Criteria andDeletestatusLessThanOrEqualTo (Boolean value)
			{
				addCriterion ("deleteStatus <=" , value , "deletestatus");
				return (Criteria) this;
			}

		public Criteria andDeletestatusIn (List <Boolean> values)
			{
				addCriterion ("deleteStatus in" , values , "deletestatus");
				return (Criteria) this;
			}

		public Criteria andDeletestatusNotIn (List <Boolean> values)
			{
				addCriterion ("deleteStatus not in" , values , "deletestatus");
				return (Criteria) this;
			}

		public Criteria andDeletestatusBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("deleteStatus between" , value1 , value2 , "deletestatus");
				return (Criteria) this;
			}

		public Criteria andDeletestatusNotBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("deleteStatus not between" , value1 , value2 , "deletestatus");
				return (Criteria) this;
			}

		public Criteria andFinishtimeIsNull ( )
			{
				addCriterion ("finishTime is null");
				return (Criteria) this;
			}

		public Criteria andFinishtimeIsNotNull ( )
			{
				addCriterion ("finishTime is not null");
				return (Criteria) this;
			}

		public Criteria andFinishtimeEqualTo (Date value)
			{
				addCriterion ("finishTime =" , value , "finishtime");
				return (Criteria) this;
			}

		public Criteria andFinishtimeNotEqualTo (Date value)
			{
				addCriterion ("finishTime <>" , value , "finishtime");
				return (Criteria) this;
			}

		public Criteria andFinishtimeGreaterThan (Date value)
			{
				addCriterion ("finishTime >" , value , "finishtime");
				return (Criteria) this;
			}

		public Criteria andFinishtimeGreaterThanOrEqualTo (Date value)
			{
				addCriterion ("finishTime >=" , value , "finishtime");
				return (Criteria) this;
			}

		public Criteria andFinishtimeLessThan (Date value)
			{
				addCriterion ("finishTime <" , value , "finishtime");
				return (Criteria) this;
			}

		public Criteria andFinishtimeLessThanOrEqualTo (Date value)
			{
				addCriterion ("finishTime <=" , value , "finishtime");
				return (Criteria) this;
			}

		public Criteria andFinishtimeIn (List <Date> values)
			{
				addCriterion ("finishTime in" , values , "finishtime");
				return (Criteria) this;
			}

		public Criteria andFinishtimeNotIn (List <Date> values)
			{
				addCriterion ("finishTime not in" , values , "finishtime");
				return (Criteria) this;
			}

		public Criteria andFinishtimeBetween (Date value1 , Date value2)
			{
				addCriterion ("finishTime between" , value1 , value2 , "finishtime");
				return (Criteria) this;
			}

		public Criteria andFinishtimeNotBetween (Date value1 , Date value2)
			{
				addCriterion ("finishTime not between" , value1 , value2 , "finishtime");
				return (Criteria) this;
			}

		public Criteria andGoodsAmountIsNull ( )
			{
				addCriterion ("goods_amount is null");
				return (Criteria) this;
			}

		public Criteria andGoodsAmountIsNotNull ( )
			{
				addCriterion ("goods_amount is not null");
				return (Criteria) this;
			}

		public Criteria andGoodsAmountEqualTo (BigDecimal value)
			{
				addCriterion ("goods_amount =" , value , "goodsAmount");
				return (Criteria) this;
			}

		public Criteria andGoodsAmountNotEqualTo (BigDecimal value)
			{
				addCriterion ("goods_amount <>" , value , "goodsAmount");
				return (Criteria) this;
			}

		public Criteria andGoodsAmountGreaterThan (BigDecimal value)
			{
				addCriterion ("goods_amount >" , value , "goodsAmount");
				return (Criteria) this;
			}

		public Criteria andGoodsAmountGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("goods_amount >=" , value , "goodsAmount");
				return (Criteria) this;
			}

		public Criteria andGoodsAmountLessThan (BigDecimal value)
			{
				addCriterion ("goods_amount <" , value , "goodsAmount");
				return (Criteria) this;
			}

		public Criteria andGoodsAmountLessThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("goods_amount <=" , value , "goodsAmount");
				return (Criteria) this;
			}

		public Criteria andGoodsAmountIn (List <BigDecimal> values)
			{
				addCriterion ("goods_amount in" , values , "goodsAmount");
				return (Criteria) this;
			}

		public Criteria andGoodsAmountNotIn (List <BigDecimal> values)
			{
				addCriterion ("goods_amount not in" , values , "goodsAmount");
				return (Criteria) this;
			}

		public Criteria andGoodsAmountBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("goods_amount between" , value1 , value2 , "goodsAmount");
				return (Criteria) this;
			}

		public Criteria andGoodsAmountNotBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("goods_amount not between" , value1 , value2 , "goodsAmount");
				return (Criteria) this;
			}

		public Criteria andInvoiceIsNull ( )
			{
				addCriterion ("invoice is null");
				return (Criteria) this;
			}

		public Criteria andInvoiceIsNotNull ( )
			{
				addCriterion ("invoice is not null");
				return (Criteria) this;
			}

		public Criteria andInvoiceEqualTo (String value)
			{
				addCriterion ("invoice =" , value , "invoice");
				return (Criteria) this;
			}

		public Criteria andInvoiceNotEqualTo (String value)
			{
				addCriterion ("invoice <>" , value , "invoice");
				return (Criteria) this;
			}

		public Criteria andInvoiceGreaterThan (String value)
			{
				addCriterion ("invoice >" , value , "invoice");
				return (Criteria) this;
			}

		public Criteria andInvoiceGreaterThanOrEqualTo (String value)
			{
				addCriterion ("invoice >=" , value , "invoice");
				return (Criteria) this;
			}

		public Criteria andInvoiceLessThan (String value)
			{
				addCriterion ("invoice <" , value , "invoice");
				return (Criteria) this;
			}

		public Criteria andInvoiceLessThanOrEqualTo (String value)
			{
				addCriterion ("invoice <=" , value , "invoice");
				return (Criteria) this;
			}

		public Criteria andInvoiceLike (String value)
			{
				addCriterion ("invoice like" , value , "invoice");
				return (Criteria) this;
			}

		public Criteria andInvoiceNotLike (String value)
			{
				addCriterion ("invoice not like" , value , "invoice");
				return (Criteria) this;
			}

		public Criteria andInvoiceIn (List <String> values)
			{
				addCriterion ("invoice in" , values , "invoice");
				return (Criteria) this;
			}

		public Criteria andInvoiceNotIn (List <String> values)
			{
				addCriterion ("invoice not in" , values , "invoice");
				return (Criteria) this;
			}

		public Criteria andInvoiceBetween (String value1 , String value2)
			{
				addCriterion ("invoice between" , value1 , value2 , "invoice");
				return (Criteria) this;
			}

		public Criteria andInvoiceNotBetween (String value1 , String value2)
			{
				addCriterion ("invoice not between" , value1 , value2 , "invoice");
				return (Criteria) this;
			}

		public Criteria andInvoicetypeIsNull ( )
			{
				addCriterion ("invoiceType is null");
				return (Criteria) this;
			}

		public Criteria andInvoicetypeIsNotNull ( )
			{
				addCriterion ("invoiceType is not null");
				return (Criteria) this;
			}

		public Criteria andInvoicetypeEqualTo (Integer value)
			{
				addCriterion ("invoiceType =" , value , "invoicetype");
				return (Criteria) this;
			}

		public Criteria andInvoicetypeNotEqualTo (Integer value)
			{
				addCriterion ("invoiceType <>" , value , "invoicetype");
				return (Criteria) this;
			}

		public Criteria andInvoicetypeGreaterThan (Integer value)
			{
				addCriterion ("invoiceType >" , value , "invoicetype");
				return (Criteria) this;
			}

		public Criteria andInvoicetypeGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("invoiceType >=" , value , "invoicetype");
				return (Criteria) this;
			}

		public Criteria andInvoicetypeLessThan (Integer value)
			{
				addCriterion ("invoiceType <" , value , "invoicetype");
				return (Criteria) this;
			}

		public Criteria andInvoicetypeLessThanOrEqualTo (Integer value)
			{
				addCriterion ("invoiceType <=" , value , "invoicetype");
				return (Criteria) this;
			}

		public Criteria andInvoicetypeIn (List <Integer> values)
			{
				addCriterion ("invoiceType in" , values , "invoicetype");
				return (Criteria) this;
			}

		public Criteria andInvoicetypeNotIn (List <Integer> values)
			{
				addCriterion ("invoiceType not in" , values , "invoicetype");
				return (Criteria) this;
			}

		public Criteria andInvoicetypeBetween (Integer value1 , Integer value2)
			{
				addCriterion ("invoiceType between" , value1 , value2 , "invoicetype");
				return (Criteria) this;
			}

		public Criteria andInvoicetypeNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("invoiceType not between" , value1 , value2 , "invoicetype");
				return (Criteria) this;
			}

		public Criteria andOrderIdIsNull ( )
			{
				addCriterion ("order_id is null");
				return (Criteria) this;
			}

		public Criteria andOrderIdIsNotNull ( )
			{
				addCriterion ("order_id is not null");
				return (Criteria) this;
			}

		public Criteria andOrderIdEqualTo (String value)
			{
				addCriterion ("order_id =" , value , "orderId");
				return (Criteria) this;
			}

		public Criteria andOrderIdNotEqualTo (String value)
			{
				addCriterion ("order_id <>" , value , "orderId");
				return (Criteria) this;
			}

		public Criteria andOrderIdGreaterThan (String value)
			{
				addCriterion ("order_id >" , value , "orderId");
				return (Criteria) this;
			}

		public Criteria andOrderIdGreaterThanOrEqualTo (String value)
			{
				addCriterion ("order_id >=" , value , "orderId");
				return (Criteria) this;
			}

		public Criteria andOrderIdLessThan (String value)
			{
				addCriterion ("order_id <" , value , "orderId");
				return (Criteria) this;
			}

		public Criteria andOrderIdLessThanOrEqualTo (String value)
			{
				addCriterion ("order_id <=" , value , "orderId");
				return (Criteria) this;
			}

		public Criteria andOrderIdLike (String value)
			{
				addCriterion ("order_id like" , value , "orderId");
				return (Criteria) this;
			}

		public Criteria andOrderIdNotLike (String value)
			{
				addCriterion ("order_id not like" , value , "orderId");
				return (Criteria) this;
			}

		public Criteria andOrderIdIn (List <String> values)
			{
				addCriterion ("order_id in" , values , "orderId");
				return (Criteria) this;
			}

		public Criteria andOrderIdNotIn (List <String> values)
			{
				addCriterion ("order_id not in" , values , "orderId");
				return (Criteria) this;
			}

		public Criteria andOrderIdBetween (String value1 , String value2)
			{
				addCriterion ("order_id between" , value1 , value2 , "orderId");
				return (Criteria) this;
			}

		public Criteria andOrderIdNotBetween (String value1 , String value2)
			{
				addCriterion ("order_id not between" , value1 , value2 , "orderId");
				return (Criteria) this;
			}

		public Criteria andOrderStatusIsNull ( )
			{
				addCriterion ("order_status is null");
				return (Criteria) this;
			}

		public Criteria andOrderStatusIsNotNull ( )
			{
				addCriterion ("order_status is not null");
				return (Criteria) this;
			}

		public Criteria andOrderStatusEqualTo (Integer value)
			{
				addCriterion ("order_status =" , value , "orderStatus");
				return (Criteria) this;
			}

		public Criteria andOrderStatusNotEqualTo (Integer value)
			{
				addCriterion ("order_status <>" , value , "orderStatus");
				return (Criteria) this;
			}

		public Criteria andOrderStatusGreaterThan (Integer value)
			{
				addCriterion ("order_status >" , value , "orderStatus");
				return (Criteria) this;
			}

		public Criteria andOrderStatusGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("order_status >=" , value , "orderStatus");
				return (Criteria) this;
			}

		public Criteria andOrderStatusLessThan (Integer value)
			{
				addCriterion ("order_status <" , value , "orderStatus");
				return (Criteria) this;
			}

		public Criteria andOrderStatusLessThanOrEqualTo (Integer value)
			{
				addCriterion ("order_status <=" , value , "orderStatus");
				return (Criteria) this;
			}

		public Criteria andOrderStatusIn (List <Integer> values)
			{
				addCriterion ("order_status in" , values , "orderStatus");
				return (Criteria) this;
			}

		public Criteria andOrderStatusNotIn (List <Integer> values)
			{
				addCriterion ("order_status not in" , values , "orderStatus");
				return (Criteria) this;
			}

		public Criteria andOrderStatusBetween (Integer value1 , Integer value2)
			{
				addCriterion ("order_status between" , value1 , value2 , "orderStatus");
				return (Criteria) this;
			}

		public Criteria andOrderStatusNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("order_status not between" , value1 , value2 , "orderStatus");
				return (Criteria) this;
			}

		public Criteria andPaytimeIsNull ( )
			{
				addCriterion ("payTime is null");
				return (Criteria) this;
			}

		public Criteria andPaytimeIsNotNull ( )
			{
				addCriterion ("payTime is not null");
				return (Criteria) this;
			}

		public Criteria andPaytimeEqualTo (Date value)
			{
				addCriterion ("payTime =" , value , "paytime");
				return (Criteria) this;
			}

		public Criteria andPaytimeNotEqualTo (Date value)
			{
				addCriterion ("payTime <>" , value , "paytime");
				return (Criteria) this;
			}

		public Criteria andPaytimeGreaterThan (Date value)
			{
				addCriterion ("payTime >" , value , "paytime");
				return (Criteria) this;
			}

		public Criteria andPaytimeGreaterThanOrEqualTo (Date value)
			{
				addCriterion ("payTime >=" , value , "paytime");
				return (Criteria) this;
			}

		public Criteria andPaytimeLessThan (Date value)
			{
				addCriterion ("payTime <" , value , "paytime");
				return (Criteria) this;
			}

		public Criteria andPaytimeLessThanOrEqualTo (Date value)
			{
				addCriterion ("payTime <=" , value , "paytime");
				return (Criteria) this;
			}

		public Criteria andPaytimeIn (List <Date> values)
			{
				addCriterion ("payTime in" , values , "paytime");
				return (Criteria) this;
			}

		public Criteria andPaytimeNotIn (List <Date> values)
			{
				addCriterion ("payTime not in" , values , "paytime");
				return (Criteria) this;
			}

		public Criteria andPaytimeBetween (Date value1 , Date value2)
			{
				addCriterion ("payTime between" , value1 , value2 , "paytime");
				return (Criteria) this;
			}

		public Criteria andPaytimeNotBetween (Date value1 , Date value2)
			{
				addCriterion ("payTime not between" , value1 , value2 , "paytime");
				return (Criteria) this;
			}

		public Criteria andRefundIsNull ( )
			{
				addCriterion ("refund is null");
				return (Criteria) this;
			}

		public Criteria andRefundIsNotNull ( )
			{
				addCriterion ("refund is not null");
				return (Criteria) this;
			}

		public Criteria andRefundEqualTo (BigDecimal value)
			{
				addCriterion ("refund =" , value , "refund");
				return (Criteria) this;
			}

		public Criteria andRefundNotEqualTo (BigDecimal value)
			{
				addCriterion ("refund <>" , value , "refund");
				return (Criteria) this;
			}

		public Criteria andRefundGreaterThan (BigDecimal value)
			{
				addCriterion ("refund >" , value , "refund");
				return (Criteria) this;
			}

		public Criteria andRefundGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("refund >=" , value , "refund");
				return (Criteria) this;
			}

		public Criteria andRefundLessThan (BigDecimal value)
			{
				addCriterion ("refund <" , value , "refund");
				return (Criteria) this;
			}

		public Criteria andRefundLessThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("refund <=" , value , "refund");
				return (Criteria) this;
			}

		public Criteria andRefundIn (List <BigDecimal> values)
			{
				addCriterion ("refund in" , values , "refund");
				return (Criteria) this;
			}

		public Criteria andRefundNotIn (List <BigDecimal> values)
			{
				addCriterion ("refund not in" , values , "refund");
				return (Criteria) this;
			}

		public Criteria andRefundBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("refund between" , value1 , value2 , "refund");
				return (Criteria) this;
			}

		public Criteria andRefundNotBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("refund not between" , value1 , value2 , "refund");
				return (Criteria) this;
			}

		public Criteria andRefundTypeIsNull ( )
			{
				addCriterion ("refund_type is null");
				return (Criteria) this;
			}

		public Criteria andRefundTypeIsNotNull ( )
			{
				addCriterion ("refund_type is not null");
				return (Criteria) this;
			}

		public Criteria andRefundTypeEqualTo (String value)
			{
				addCriterion ("refund_type =" , value , "refundType");
				return (Criteria) this;
			}

		public Criteria andRefundTypeNotEqualTo (String value)
			{
				addCriterion ("refund_type <>" , value , "refundType");
				return (Criteria) this;
			}

		public Criteria andRefundTypeGreaterThan (String value)
			{
				addCriterion ("refund_type >" , value , "refundType");
				return (Criteria) this;
			}

		public Criteria andRefundTypeGreaterThanOrEqualTo (String value)
			{
				addCriterion ("refund_type >=" , value , "refundType");
				return (Criteria) this;
			}

		public Criteria andRefundTypeLessThan (String value)
			{
				addCriterion ("refund_type <" , value , "refundType");
				return (Criteria) this;
			}

		public Criteria andRefundTypeLessThanOrEqualTo (String value)
			{
				addCriterion ("refund_type <=" , value , "refundType");
				return (Criteria) this;
			}

		public Criteria andRefundTypeLike (String value)
			{
				addCriterion ("refund_type like" , value , "refundType");
				return (Criteria) this;
			}

		public Criteria andRefundTypeNotLike (String value)
			{
				addCriterion ("refund_type not like" , value , "refundType");
				return (Criteria) this;
			}

		public Criteria andRefundTypeIn (List <String> values)
			{
				addCriterion ("refund_type in" , values , "refundType");
				return (Criteria) this;
			}

		public Criteria andRefundTypeNotIn (List <String> values)
			{
				addCriterion ("refund_type not in" , values , "refundType");
				return (Criteria) this;
			}

		public Criteria andRefundTypeBetween (String value1 , String value2)
			{
				addCriterion ("refund_type between" , value1 , value2 , "refundType");
				return (Criteria) this;
			}

		public Criteria andRefundTypeNotBetween (String value1 , String value2)
			{
				addCriterion ("refund_type not between" , value1 , value2 , "refundType");
				return (Criteria) this;
			}

		public Criteria andShipcodeIsNull ( )
			{
				addCriterion ("shipCode is null");
				return (Criteria) this;
			}

		public Criteria andShipcodeIsNotNull ( )
			{
				addCriterion ("shipCode is not null");
				return (Criteria) this;
			}

		public Criteria andShipcodeEqualTo (String value)
			{
				addCriterion ("shipCode =" , value , "shipcode");
				return (Criteria) this;
			}

		public Criteria andShipcodeNotEqualTo (String value)
			{
				addCriterion ("shipCode <>" , value , "shipcode");
				return (Criteria) this;
			}

		public Criteria andShipcodeGreaterThan (String value)
			{
				addCriterion ("shipCode >" , value , "shipcode");
				return (Criteria) this;
			}

		public Criteria andShipcodeGreaterThanOrEqualTo (String value)
			{
				addCriterion ("shipCode >=" , value , "shipcode");
				return (Criteria) this;
			}

		public Criteria andShipcodeLessThan (String value)
			{
				addCriterion ("shipCode <" , value , "shipcode");
				return (Criteria) this;
			}

		public Criteria andShipcodeLessThanOrEqualTo (String value)
			{
				addCriterion ("shipCode <=" , value , "shipcode");
				return (Criteria) this;
			}

		public Criteria andShipcodeLike (String value)
			{
				addCriterion ("shipCode like" , value , "shipcode");
				return (Criteria) this;
			}

		public Criteria andShipcodeNotLike (String value)
			{
				addCriterion ("shipCode not like" , value , "shipcode");
				return (Criteria) this;
			}

		public Criteria andShipcodeIn (List <String> values)
			{
				addCriterion ("shipCode in" , values , "shipcode");
				return (Criteria) this;
			}

		public Criteria andShipcodeNotIn (List <String> values)
			{
				addCriterion ("shipCode not in" , values , "shipcode");
				return (Criteria) this;
			}

		public Criteria andShipcodeBetween (String value1 , String value2)
			{
				addCriterion ("shipCode between" , value1 , value2 , "shipcode");
				return (Criteria) this;
			}

		public Criteria andShipcodeNotBetween (String value1 , String value2)
			{
				addCriterion ("shipCode not between" , value1 , value2 , "shipcode");
				return (Criteria) this;
			}

		public Criteria andShiptimeIsNull ( )
			{
				addCriterion ("shipTime is null");
				return (Criteria) this;
			}

		public Criteria andShiptimeIsNotNull ( )
			{
				addCriterion ("shipTime is not null");
				return (Criteria) this;
			}

		public Criteria andShiptimeEqualTo (Date value)
			{
				addCriterion ("shipTime =" , value , "shiptime");
				return (Criteria) this;
			}

		public Criteria andShiptimeNotEqualTo (Date value)
			{
				addCriterion ("shipTime <>" , value , "shiptime");
				return (Criteria) this;
			}

		public Criteria andShiptimeGreaterThan (Date value)
			{
				addCriterion ("shipTime >" , value , "shiptime");
				return (Criteria) this;
			}

		public Criteria andShiptimeGreaterThanOrEqualTo (Date value)
			{
				addCriterion ("shipTime >=" , value , "shiptime");
				return (Criteria) this;
			}

		public Criteria andShiptimeLessThan (Date value)
			{
				addCriterion ("shipTime <" , value , "shiptime");
				return (Criteria) this;
			}

		public Criteria andShiptimeLessThanOrEqualTo (Date value)
			{
				addCriterion ("shipTime <=" , value , "shiptime");
				return (Criteria) this;
			}

		public Criteria andShiptimeIn (List <Date> values)
			{
				addCriterion ("shipTime in" , values , "shiptime");
				return (Criteria) this;
			}

		public Criteria andShiptimeNotIn (List <Date> values)
			{
				addCriterion ("shipTime not in" , values , "shiptime");
				return (Criteria) this;
			}

		public Criteria andShiptimeBetween (Date value1 , Date value2)
			{
				addCriterion ("shipTime between" , value1 , value2 , "shiptime");
				return (Criteria) this;
			}

		public Criteria andShiptimeNotBetween (Date value1 , Date value2)
			{
				addCriterion ("shipTime not between" , value1 , value2 , "shiptime");
				return (Criteria) this;
			}

		public Criteria andShipPriceIsNull ( )
			{
				addCriterion ("ship_price is null");
				return (Criteria) this;
			}

		public Criteria andShipPriceIsNotNull ( )
			{
				addCriterion ("ship_price is not null");
				return (Criteria) this;
			}

		public Criteria andShipPriceEqualTo (BigDecimal value)
			{
				addCriterion ("ship_price =" , value , "shipPrice");
				return (Criteria) this;
			}

		public Criteria andShipPriceNotEqualTo (BigDecimal value)
			{
				addCriterion ("ship_price <>" , value , "shipPrice");
				return (Criteria) this;
			}

		public Criteria andShipPriceGreaterThan (BigDecimal value)
			{
				addCriterion ("ship_price >" , value , "shipPrice");
				return (Criteria) this;
			}

		public Criteria andShipPriceGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("ship_price >=" , value , "shipPrice");
				return (Criteria) this;
			}

		public Criteria andShipPriceLessThan (BigDecimal value)
			{
				addCriterion ("ship_price <" , value , "shipPrice");
				return (Criteria) this;
			}

		public Criteria andShipPriceLessThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("ship_price <=" , value , "shipPrice");
				return (Criteria) this;
			}

		public Criteria andShipPriceIn (List <BigDecimal> values)
			{
				addCriterion ("ship_price in" , values , "shipPrice");
				return (Criteria) this;
			}

		public Criteria andShipPriceNotIn (List <BigDecimal> values)
			{
				addCriterion ("ship_price not in" , values , "shipPrice");
				return (Criteria) this;
			}

		public Criteria andShipPriceBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("ship_price between" , value1 , value2 , "shipPrice");
				return (Criteria) this;
			}

		public Criteria andShipPriceNotBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("ship_price not between" , value1 , value2 , "shipPrice");
				return (Criteria) this;
			}

		public Criteria andTotalpriceIsNull ( )
			{
				addCriterion ("totalPrice is null");
				return (Criteria) this;
			}

		public Criteria andTotalpriceIsNotNull ( )
			{
				addCriterion ("totalPrice is not null");
				return (Criteria) this;
			}

		public Criteria andTotalpriceEqualTo (BigDecimal value)
			{
				addCriterion ("totalPrice =" , value , "totalprice");
				return (Criteria) this;
			}

		public Criteria andTotalpriceNotEqualTo (BigDecimal value)
			{
				addCriterion ("totalPrice <>" , value , "totalprice");
				return (Criteria) this;
			}

		public Criteria andTotalpriceGreaterThan (BigDecimal value)
			{
				addCriterion ("totalPrice >" , value , "totalprice");
				return (Criteria) this;
			}

		public Criteria andTotalpriceGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("totalPrice >=" , value , "totalprice");
				return (Criteria) this;
			}

		public Criteria andTotalpriceLessThan (BigDecimal value)
			{
				addCriterion ("totalPrice <" , value , "totalprice");
				return (Criteria) this;
			}

		public Criteria andTotalpriceLessThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("totalPrice <=" , value , "totalprice");
				return (Criteria) this;
			}

		public Criteria andTotalpriceIn (List <BigDecimal> values)
			{
				addCriterion ("totalPrice in" , values , "totalprice");
				return (Criteria) this;
			}

		public Criteria andTotalpriceNotIn (List <BigDecimal> values)
			{
				addCriterion ("totalPrice not in" , values , "totalprice");
				return (Criteria) this;
			}

		public Criteria andTotalpriceBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("totalPrice between" , value1 , value2 , "totalprice");
				return (Criteria) this;
			}

		public Criteria andTotalpriceNotBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("totalPrice not between" , value1 , value2 , "totalprice");
				return (Criteria) this;
			}

		public Criteria andAddrIdIsNull ( )
			{
				addCriterion ("addr_id is null");
				return (Criteria) this;
			}

		public Criteria andAddrIdIsNotNull ( )
			{
				addCriterion ("addr_id is not null");
				return (Criteria) this;
			}

		public Criteria andAddrIdEqualTo (Long value)
			{
				addCriterion ("addr_id =" , value , "addrId");
				return (Criteria) this;
			}

		public Criteria andAddrIdNotEqualTo (Long value)
			{
				addCriterion ("addr_id <>" , value , "addrId");
				return (Criteria) this;
			}

		public Criteria andAddrIdGreaterThan (Long value)
			{
				addCriterion ("addr_id >" , value , "addrId");
				return (Criteria) this;
			}

		public Criteria andAddrIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("addr_id >=" , value , "addrId");
				return (Criteria) this;
			}

		public Criteria andAddrIdLessThan (Long value)
			{
				addCriterion ("addr_id <" , value , "addrId");
				return (Criteria) this;
			}

		public Criteria andAddrIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("addr_id <=" , value , "addrId");
				return (Criteria) this;
			}

		public Criteria andAddrIdIn (List <Long> values)
			{
				addCriterion ("addr_id in" , values , "addrId");
				return (Criteria) this;
			}

		public Criteria andAddrIdNotIn (List <Long> values)
			{
				addCriterion ("addr_id not in" , values , "addrId");
				return (Criteria) this;
			}

		public Criteria andAddrIdBetween (Long value1 , Long value2)
			{
				addCriterion ("addr_id between" , value1 , value2 , "addrId");
				return (Criteria) this;
			}

		public Criteria andAddrIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("addr_id not between" , value1 , value2 , "addrId");
				return (Criteria) this;
			}

		public Criteria andPaymentIdIsNull ( )
			{
				addCriterion ("payment_id is null");
				return (Criteria) this;
			}

		public Criteria andPaymentIdIsNotNull ( )
			{
				addCriterion ("payment_id is not null");
				return (Criteria) this;
			}

		public Criteria andPaymentIdEqualTo (Long value)
			{
				addCriterion ("payment_id =" , value , "paymentId");
				return (Criteria) this;
			}

		public Criteria andPaymentIdNotEqualTo (Long value)
			{
				addCriterion ("payment_id <>" , value , "paymentId");
				return (Criteria) this;
			}

		public Criteria andPaymentIdGreaterThan (Long value)
			{
				addCriterion ("payment_id >" , value , "paymentId");
				return (Criteria) this;
			}

		public Criteria andPaymentIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("payment_id >=" , value , "paymentId");
				return (Criteria) this;
			}

		public Criteria andPaymentIdLessThan (Long value)
			{
				addCriterion ("payment_id <" , value , "paymentId");
				return (Criteria) this;
			}

		public Criteria andPaymentIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("payment_id <=" , value , "paymentId");
				return (Criteria) this;
			}

		public Criteria andPaymentIdIn (List <Long> values)
			{
				addCriterion ("payment_id in" , values , "paymentId");
				return (Criteria) this;
			}

		public Criteria andPaymentIdNotIn (List <Long> values)
			{
				addCriterion ("payment_id not in" , values , "paymentId");
				return (Criteria) this;
			}

		public Criteria andPaymentIdBetween (Long value1 , Long value2)
			{
				addCriterion ("payment_id between" , value1 , value2 , "paymentId");
				return (Criteria) this;
			}

		public Criteria andPaymentIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("payment_id not between" , value1 , value2 , "paymentId");
				return (Criteria) this;
			}

		public Criteria andStoreIdIsNull ( )
			{
				addCriterion ("store_id is null");
				return (Criteria) this;
			}

		public Criteria andStoreIdIsNotNull ( )
			{
				addCriterion ("store_id is not null");
				return (Criteria) this;
			}

		public Criteria andStoreIdEqualTo (Long value)
			{
				addCriterion ("store_id =" , value , "storeId");
				return (Criteria) this;
			}

		public Criteria andStoreIdNotEqualTo (Long value)
			{
				addCriterion ("store_id <>" , value , "storeId");
				return (Criteria) this;
			}

		public Criteria andStoreIdGreaterThan (Long value)
			{
				addCriterion ("store_id >" , value , "storeId");
				return (Criteria) this;
			}

		public Criteria andStoreIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("store_id >=" , value , "storeId");
				return (Criteria) this;
			}

		public Criteria andStoreIdLessThan (Long value)
			{
				addCriterion ("store_id <" , value , "storeId");
				return (Criteria) this;
			}

		public Criteria andStoreIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("store_id <=" , value , "storeId");
				return (Criteria) this;
			}

		public Criteria andStoreIdIn (List <Long> values)
			{
				addCriterion ("store_id in" , values , "storeId");
				return (Criteria) this;
			}

		public Criteria andStoreIdNotIn (List <Long> values)
			{
				addCriterion ("store_id not in" , values , "storeId");
				return (Criteria) this;
			}

		public Criteria andStoreIdBetween (Long value1 , Long value2)
			{
				addCriterion ("store_id between" , value1 , value2 , "storeId");
				return (Criteria) this;
			}

		public Criteria andStoreIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("store_id not between" , value1 , value2 , "storeId");
				return (Criteria) this;
			}

		public Criteria andUserIdIsNull ( )
			{
				addCriterion ("user_id is null");
				return (Criteria) this;
			}

		public Criteria andUserIdIsNotNull ( )
			{
				addCriterion ("user_id is not null");
				return (Criteria) this;
			}

		public Criteria andUserIdEqualTo (Long value)
			{
				addCriterion ("user_id =" , value , "userId");
				return (Criteria) this;
			}

		public Criteria andUserIdNotEqualTo (Long value)
			{
				addCriterion ("user_id <>" , value , "userId");
				return (Criteria) this;
			}

		public Criteria andUserIdGreaterThan (Long value)
			{
				addCriterion ("user_id >" , value , "userId");
				return (Criteria) this;
			}

		public Criteria andUserIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("user_id >=" , value , "userId");
				return (Criteria) this;
			}

		public Criteria andUserIdLessThan (Long value)
			{
				addCriterion ("user_id <" , value , "userId");
				return (Criteria) this;
			}

		public Criteria andUserIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("user_id <=" , value , "userId");
				return (Criteria) this;
			}

		public Criteria andUserIdIn (List <Long> values)
			{
				addCriterion ("user_id in" , values , "userId");
				return (Criteria) this;
			}

		public Criteria andUserIdNotIn (List <Long> values)
			{
				addCriterion ("user_id not in" , values , "userId");
				return (Criteria) this;
			}

		public Criteria andUserIdBetween (Long value1 , Long value2)
			{
				addCriterion ("user_id between" , value1 , value2 , "userId");
				return (Criteria) this;
			}

		public Criteria andUserIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("user_id not between" , value1 , value2 , "userId");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmEmailIsNull ( )
			{
				addCriterion ("auto_confirm_email is null");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmEmailIsNotNull ( )
			{
				addCriterion ("auto_confirm_email is not null");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmEmailEqualTo (Boolean value)
			{
				addCriterion ("auto_confirm_email =" , value , "autoConfirmEmail");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmEmailNotEqualTo (Boolean value)
			{
				addCriterion ("auto_confirm_email <>" , value , "autoConfirmEmail");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmEmailGreaterThan (Boolean value)
			{
				addCriterion ("auto_confirm_email >" , value , "autoConfirmEmail");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmEmailGreaterThanOrEqualTo (Boolean value)
			{
				addCriterion ("auto_confirm_email >=" , value , "autoConfirmEmail");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmEmailLessThan (Boolean value)
			{
				addCriterion ("auto_confirm_email <" , value , "autoConfirmEmail");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmEmailLessThanOrEqualTo (Boolean value)
			{
				addCriterion ("auto_confirm_email <=" , value , "autoConfirmEmail");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmEmailIn (List <Boolean> values)
			{
				addCriterion ("auto_confirm_email in" , values , "autoConfirmEmail");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmEmailNotIn (List <Boolean> values)
			{
				addCriterion ("auto_confirm_email not in" , values , "autoConfirmEmail");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmEmailBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("auto_confirm_email between" , value1 , value2 , "autoConfirmEmail");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmEmailNotBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("auto_confirm_email not between" , value1 , value2 , "autoConfirmEmail");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmSmsIsNull ( )
			{
				addCriterion ("auto_confirm_sms is null");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmSmsIsNotNull ( )
			{
				addCriterion ("auto_confirm_sms is not null");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmSmsEqualTo (Boolean value)
			{
				addCriterion ("auto_confirm_sms =" , value , "autoConfirmSms");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmSmsNotEqualTo (Boolean value)
			{
				addCriterion ("auto_confirm_sms <>" , value , "autoConfirmSms");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmSmsGreaterThan (Boolean value)
			{
				addCriterion ("auto_confirm_sms >" , value , "autoConfirmSms");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmSmsGreaterThanOrEqualTo (Boolean value)
			{
				addCriterion ("auto_confirm_sms >=" , value , "autoConfirmSms");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmSmsLessThan (Boolean value)
			{
				addCriterion ("auto_confirm_sms <" , value , "autoConfirmSms");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmSmsLessThanOrEqualTo (Boolean value)
			{
				addCriterion ("auto_confirm_sms <=" , value , "autoConfirmSms");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmSmsIn (List <Boolean> values)
			{
				addCriterion ("auto_confirm_sms in" , values , "autoConfirmSms");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmSmsNotIn (List <Boolean> values)
			{
				addCriterion ("auto_confirm_sms not in" , values , "autoConfirmSms");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmSmsBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("auto_confirm_sms between" , value1 , value2 , "autoConfirmSms");
				return (Criteria) this;
			}

		public Criteria andAutoConfirmSmsNotBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("auto_confirm_sms not between" , value1 , value2 , "autoConfirmSms");
				return (Criteria) this;
			}

		public Criteria andTransportIsNull ( )
			{
				addCriterion ("transport is null");
				return (Criteria) this;
			}

		public Criteria andTransportIsNotNull ( )
			{
				addCriterion ("transport is not null");
				return (Criteria) this;
			}

		public Criteria andTransportEqualTo (String value)
			{
				addCriterion ("transport =" , value , "transport");
				return (Criteria) this;
			}

		public Criteria andTransportNotEqualTo (String value)
			{
				addCriterion ("transport <>" , value , "transport");
				return (Criteria) this;
			}

		public Criteria andTransportGreaterThan (String value)
			{
				addCriterion ("transport >" , value , "transport");
				return (Criteria) this;
			}

		public Criteria andTransportGreaterThanOrEqualTo (String value)
			{
				addCriterion ("transport >=" , value , "transport");
				return (Criteria) this;
			}

		public Criteria andTransportLessThan (String value)
			{
				addCriterion ("transport <" , value , "transport");
				return (Criteria) this;
			}

		public Criteria andTransportLessThanOrEqualTo (String value)
			{
				addCriterion ("transport <=" , value , "transport");
				return (Criteria) this;
			}

		public Criteria andTransportLike (String value)
			{
				addCriterion ("transport like" , value , "transport");
				return (Criteria) this;
			}

		public Criteria andTransportNotLike (String value)
			{
				addCriterion ("transport not like" , value , "transport");
				return (Criteria) this;
			}

		public Criteria andTransportIn (List <String> values)
			{
				addCriterion ("transport in" , values , "transport");
				return (Criteria) this;
			}

		public Criteria andTransportNotIn (List <String> values)
			{
				addCriterion ("transport not in" , values , "transport");
				return (Criteria) this;
			}

		public Criteria andTransportBetween (String value1 , String value2)
			{
				addCriterion ("transport between" , value1 , value2 , "transport");
				return (Criteria) this;
			}

		public Criteria andTransportNotBetween (String value1 , String value2)
			{
				addCriterion ("transport not between" , value1 , value2 , "transport");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdIsNull ( )
			{
				addCriterion ("out_order_id is null");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdIsNotNull ( )
			{
				addCriterion ("out_order_id is not null");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdEqualTo (String value)
			{
				addCriterion ("out_order_id =" , value , "outOrderId");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdNotEqualTo (String value)
			{
				addCriterion ("out_order_id <>" , value , "outOrderId");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdGreaterThan (String value)
			{
				addCriterion ("out_order_id >" , value , "outOrderId");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdGreaterThanOrEqualTo (String value)
			{
				addCriterion ("out_order_id >=" , value , "outOrderId");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdLessThan (String value)
			{
				addCriterion ("out_order_id <" , value , "outOrderId");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdLessThanOrEqualTo (String value)
			{
				addCriterion ("out_order_id <=" , value , "outOrderId");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdLike (String value)
			{
				addCriterion ("out_order_id like" , value , "outOrderId");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdNotLike (String value)
			{
				addCriterion ("out_order_id not like" , value , "outOrderId");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdIn (List <String> values)
			{
				addCriterion ("out_order_id in" , values , "outOrderId");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdNotIn (List <String> values)
			{
				addCriterion ("out_order_id not in" , values , "outOrderId");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdBetween (String value1 , String value2)
			{
				addCriterion ("out_order_id between" , value1 , value2 , "outOrderId");
				return (Criteria) this;
			}

		public Criteria andOutOrderIdNotBetween (String value1 , String value2)
			{
				addCriterion ("out_order_id not between" , value1 , value2 , "outOrderId");
				return (Criteria) this;
			}

		public Criteria andEcIdIsNull ( )
			{
				addCriterion ("ec_id is null");
				return (Criteria) this;
			}

		public Criteria andEcIdIsNotNull ( )
			{
				addCriterion ("ec_id is not null");
				return (Criteria) this;
			}

		public Criteria andEcIdEqualTo (Long value)
			{
				addCriterion ("ec_id =" , value , "ecId");
				return (Criteria) this;
			}

		public Criteria andEcIdNotEqualTo (Long value)
			{
				addCriterion ("ec_id <>" , value , "ecId");
				return (Criteria) this;
			}

		public Criteria andEcIdGreaterThan (Long value)
			{
				addCriterion ("ec_id >" , value , "ecId");
				return (Criteria) this;
			}

		public Criteria andEcIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("ec_id >=" , value , "ecId");
				return (Criteria) this;
			}

		public Criteria andEcIdLessThan (Long value)
			{
				addCriterion ("ec_id <" , value , "ecId");
				return (Criteria) this;
			}

		public Criteria andEcIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("ec_id <=" , value , "ecId");
				return (Criteria) this;
			}

		public Criteria andEcIdIn (List <Long> values)
			{
				addCriterion ("ec_id in" , values , "ecId");
				return (Criteria) this;
			}

		public Criteria andEcIdNotIn (List <Long> values)
			{
				addCriterion ("ec_id not in" , values , "ecId");
				return (Criteria) this;
			}

		public Criteria andEcIdBetween (Long value1 , Long value2)
			{
				addCriterion ("ec_id between" , value1 , value2 , "ecId");
				return (Criteria) this;
			}

		public Criteria andEcIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("ec_id not between" , value1 , value2 , "ecId");
				return (Criteria) this;
			}

		public Criteria andCiIdIsNull ( )
			{
				addCriterion ("ci_id is null");
				return (Criteria) this;
			}

		public Criteria andCiIdIsNotNull ( )
			{
				addCriterion ("ci_id is not null");
				return (Criteria) this;
			}

		public Criteria andCiIdEqualTo (Long value)
			{
				addCriterion ("ci_id =" , value , "ciId");
				return (Criteria) this;
			}

		public Criteria andCiIdNotEqualTo (Long value)
			{
				addCriterion ("ci_id <>" , value , "ciId");
				return (Criteria) this;
			}

		public Criteria andCiIdGreaterThan (Long value)
			{
				addCriterion ("ci_id >" , value , "ciId");
				return (Criteria) this;
			}

		public Criteria andCiIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("ci_id >=" , value , "ciId");
				return (Criteria) this;
			}

		public Criteria andCiIdLessThan (Long value)
			{
				addCriterion ("ci_id <" , value , "ciId");
				return (Criteria) this;
			}

		public Criteria andCiIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("ci_id <=" , value , "ciId");
				return (Criteria) this;
			}

		public Criteria andCiIdIn (List <Long> values)
			{
				addCriterion ("ci_id in" , values , "ciId");
				return (Criteria) this;
			}

		public Criteria andCiIdNotIn (List <Long> values)
			{
				addCriterion ("ci_id not in" , values , "ciId");
				return (Criteria) this;
			}

		public Criteria andCiIdBetween (Long value1 , Long value2)
			{
				addCriterion ("ci_id between" , value1 , value2 , "ciId");
				return (Criteria) this;
			}

		public Criteria andCiIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("ci_id not between" , value1 , value2 , "ciId");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeIsNull ( )
			{
				addCriterion ("return_shipCode is null");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeIsNotNull ( )
			{
				addCriterion ("return_shipCode is not null");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeEqualTo (String value)
			{
				addCriterion ("return_shipCode =" , value , "returnShipcode");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeNotEqualTo (String value)
			{
				addCriterion ("return_shipCode <>" , value , "returnShipcode");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeGreaterThan (String value)
			{
				addCriterion ("return_shipCode >" , value , "returnShipcode");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeGreaterThanOrEqualTo (String value)
			{
				addCriterion ("return_shipCode >=" , value , "returnShipcode");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeLessThan (String value)
			{
				addCriterion ("return_shipCode <" , value , "returnShipcode");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeLessThanOrEqualTo (String value)
			{
				addCriterion ("return_shipCode <=" , value , "returnShipcode");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeLike (String value)
			{
				addCriterion ("return_shipCode like" , value , "returnShipcode");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeNotLike (String value)
			{
				addCriterion ("return_shipCode not like" , value , "returnShipcode");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeIn (List <String> values)
			{
				addCriterion ("return_shipCode in" , values , "returnShipcode");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeNotIn (List <String> values)
			{
				addCriterion ("return_shipCode not in" , values , "returnShipcode");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeBetween (String value1 , String value2)
			{
				addCriterion ("return_shipCode between" , value1 , value2 , "returnShipcode");
				return (Criteria) this;
			}

		public Criteria andReturnShipcodeNotBetween (String value1 , String value2)
			{
				addCriterion ("return_shipCode not between" , value1 , value2 , "returnShipcode");
				return (Criteria) this;
			}

		public Criteria andReturnEcIdIsNull ( )
			{
				addCriterion ("return_ec_id is null");
				return (Criteria) this;
			}

		public Criteria andReturnEcIdIsNotNull ( )
			{
				addCriterion ("return_ec_id is not null");
				return (Criteria) this;
			}

		public Criteria andReturnEcIdEqualTo (Long value)
			{
				addCriterion ("return_ec_id =" , value , "returnEcId");
				return (Criteria) this;
			}

		public Criteria andReturnEcIdNotEqualTo (Long value)
			{
				addCriterion ("return_ec_id <>" , value , "returnEcId");
				return (Criteria) this;
			}

		public Criteria andReturnEcIdGreaterThan (Long value)
			{
				addCriterion ("return_ec_id >" , value , "returnEcId");
				return (Criteria) this;
			}

		public Criteria andReturnEcIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("return_ec_id >=" , value , "returnEcId");
				return (Criteria) this;
			}

		public Criteria andReturnEcIdLessThan (Long value)
			{
				addCriterion ("return_ec_id <" , value , "returnEcId");
				return (Criteria) this;
			}

		public Criteria andReturnEcIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("return_ec_id <=" , value , "returnEcId");
				return (Criteria) this;
			}

		public Criteria andReturnEcIdIn (List <Long> values)
			{
				addCriterion ("return_ec_id in" , values , "returnEcId");
				return (Criteria) this;
			}

		public Criteria andReturnEcIdNotIn (List <Long> values)
			{
				addCriterion ("return_ec_id not in" , values , "returnEcId");
				return (Criteria) this;
			}

		public Criteria andReturnEcIdBetween (Long value1 , Long value2)
			{
				addCriterion ("return_ec_id between" , value1 , value2 , "returnEcId");
				return (Criteria) this;
			}

		public Criteria andReturnEcIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("return_ec_id not between" , value1 , value2 , "returnEcId");
				return (Criteria) this;
			}

		public Criteria andReturnShiptimeIsNull ( )
			{
				addCriterion ("return_shipTime is null");
				return (Criteria) this;
			}

		public Criteria andReturnShiptimeIsNotNull ( )
			{
				addCriterion ("return_shipTime is not null");
				return (Criteria) this;
			}

		public Criteria andReturnShiptimeEqualTo (Date value)
			{
				addCriterion ("return_shipTime =" , value , "returnShiptime");
				return (Criteria) this;
			}

		public Criteria andReturnShiptimeNotEqualTo (Date value)
			{
				addCriterion ("return_shipTime <>" , value , "returnShiptime");
				return (Criteria) this;
			}

		public Criteria andReturnShiptimeGreaterThan (Date value)
			{
				addCriterion ("return_shipTime >" , value , "returnShiptime");
				return (Criteria) this;
			}

		public Criteria andReturnShiptimeGreaterThanOrEqualTo (Date value)
			{
				addCriterion ("return_shipTime >=" , value , "returnShiptime");
				return (Criteria) this;
			}

		public Criteria andReturnShiptimeLessThan (Date value)
			{
				addCriterion ("return_shipTime <" , value , "returnShiptime");
				return (Criteria) this;
			}

		public Criteria andReturnShiptimeLessThanOrEqualTo (Date value)
			{
				addCriterion ("return_shipTime <=" , value , "returnShiptime");
				return (Criteria) this;
			}

		public Criteria andReturnShiptimeIn (List <Date> values)
			{
				addCriterion ("return_shipTime in" , values , "returnShiptime");
				return (Criteria) this;
			}

		public Criteria andReturnShiptimeNotIn (List <Date> values)
			{
				addCriterion ("return_shipTime not in" , values , "returnShiptime");
				return (Criteria) this;
			}

		public Criteria andReturnShiptimeBetween (Date value1 , Date value2)
			{
				addCriterion ("return_shipTime between" , value1 , value2 , "returnShiptime");
				return (Criteria) this;
			}

		public Criteria andReturnShiptimeNotBetween (Date value1 , Date value2)
			{
				addCriterion ("return_shipTime not between" , value1 , value2 , "returnShiptime");
				return (Criteria) this;
			}

		public Criteria andOrderTypeIsNull ( )
			{
				addCriterion ("order_type is null");
				return (Criteria) this;
			}

		public Criteria andOrderTypeIsNotNull ( )
			{
				addCriterion ("order_type is not null");
				return (Criteria) this;
			}

		public Criteria andOrderTypeEqualTo (String value)
			{
				addCriterion ("order_type =" , value , "orderType");
				return (Criteria) this;
			}

		public Criteria andOrderTypeNotEqualTo (String value)
			{
				addCriterion ("order_type <>" , value , "orderType");
				return (Criteria) this;
			}

		public Criteria andOrderTypeGreaterThan (String value)
			{
				addCriterion ("order_type >" , value , "orderType");
				return (Criteria) this;
			}

		public Criteria andOrderTypeGreaterThanOrEqualTo (String value)
			{
				addCriterion ("order_type >=" , value , "orderType");
				return (Criteria) this;
			}

		public Criteria andOrderTypeLessThan (String value)
			{
				addCriterion ("order_type <" , value , "orderType");
				return (Criteria) this;
			}

		public Criteria andOrderTypeLessThanOrEqualTo (String value)
			{
				addCriterion ("order_type <=" , value , "orderType");
				return (Criteria) this;
			}

		public Criteria andOrderTypeLike (String value)
			{
				addCriterion ("order_type like" , value , "orderType");
				return (Criteria) this;
			}

		public Criteria andOrderTypeNotLike (String value)
			{
				addCriterion ("order_type not like" , value , "orderType");
				return (Criteria) this;
			}

		public Criteria andOrderTypeIn (List <String> values)
			{
				addCriterion ("order_type in" , values , "orderType");
				return (Criteria) this;
			}

		public Criteria andOrderTypeNotIn (List <String> values)
			{
				addCriterion ("order_type not in" , values , "orderType");
				return (Criteria) this;
			}

		public Criteria andOrderTypeBetween (String value1 , String value2)
			{
				addCriterion ("order_type between" , value1 , value2 , "orderType");
				return (Criteria) this;
			}

		public Criteria andOrderTypeNotBetween (String value1 , String value2)
			{
				addCriterion ("order_type not between" , value1 , value2 , "orderType");
				return (Criteria) this;
			}

		public Criteria andAlipayorderIdIsNull ( )
			{
				addCriterion ("alipayorder_id is null");
				return (Criteria) this;
			}

		public Criteria andAlipayorderIdIsNotNull ( )
			{
				addCriterion ("alipayorder_id is not null");
				return (Criteria) this;
			}

		public Criteria andAlipayorderIdEqualTo (Long value)
			{
				addCriterion ("alipayorder_id =" , value , "alipayorderId");
				return (Criteria) this;
			}

		public Criteria andAlipayorderIdNotEqualTo (Long value)
			{
				addCriterion ("alipayorder_id <>" , value , "alipayorderId");
				return (Criteria) this;
			}

		public Criteria andAlipayorderIdGreaterThan (Long value)
			{
				addCriterion ("alipayorder_id >" , value , "alipayorderId");
				return (Criteria) this;
			}

		public Criteria andAlipayorderIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("alipayorder_id >=" , value , "alipayorderId");
				return (Criteria) this;
			}

		public Criteria andAlipayorderIdLessThan (Long value)
			{
				addCriterion ("alipayorder_id <" , value , "alipayorderId");
				return (Criteria) this;
			}

		public Criteria andAlipayorderIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("alipayorder_id <=" , value , "alipayorderId");
				return (Criteria) this;
			}

		public Criteria andAlipayorderIdIn (List <Long> values)
			{
				addCriterion ("alipayorder_id in" , values , "alipayorderId");
				return (Criteria) this;
			}

		public Criteria andAlipayorderIdNotIn (List <Long> values)
			{
				addCriterion ("alipayorder_id not in" , values , "alipayorderId");
				return (Criteria) this;
			}

		public Criteria andAlipayorderIdBetween (Long value1 , Long value2)
			{
				addCriterion ("alipayorder_id between" , value1 , value2 , "alipayorderId");
				return (Criteria) this;
			}

		public Criteria andAlipayorderIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("alipayorder_id not between" , value1 , value2 , "alipayorderId");
				return (Criteria) this;
			}

		public Criteria andRefundIDIsNull ( )
			{
				addCriterion ("refund_id is null");
				return (Criteria) this;
			}

		public Criteria andRefundIDIsNotNull ( )
			{
				addCriterion ("refund_id is not null");
				return (Criteria) this;
			}

		public Criteria andRefundIDEqualTo (Long value)
			{
				addCriterion ("refund_id =" , value , "refund_id");
				return (Criteria) this;
			}
		
        public Criteria andBeanNumIsNull() {
            addCriterion("bean_num is null");
            return (Criteria) this;
        }

        public Criteria andBeanNumIsNotNull() {
            addCriterion("bean_num is not null");
            return (Criteria) this;
        }

        public Criteria andBeanNumEqualTo(BigDecimal value) {
            addCriterion("bean_num =", value, "beanNum");
            return (Criteria) this;
        }

        public Criteria andBeanNumNotEqualTo(BigDecimal value) {
            addCriterion("bean_num <>", value, "beanNum");
            return (Criteria) this;
        }

        public Criteria andBeanNumGreaterThan(BigDecimal value) {
            addCriterion("bean_num >", value, "beanNum");
            return (Criteria) this;
        }

        public Criteria andBeanNumGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bean_num >=", value, "beanNum");
            return (Criteria) this;
        }

        public Criteria andBeanNumLessThan(BigDecimal value) {
            addCriterion("bean_num <", value, "beanNum");
            return (Criteria) this;
        }

        public Criteria andBeanNumLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bean_num <=", value, "beanNum");
            return (Criteria) this;
        }

        public Criteria andBeanNumIn(List<BigDecimal> values) {
            addCriterion("bean_num in", values, "beanNum");
            return (Criteria) this;
        }

        public Criteria andBeanNumNotIn(List<BigDecimal> values) {
            addCriterion("bean_num not in", values, "beanNum");
            return (Criteria) this;
        }

        public Criteria andBeanNumBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bean_num between", value1, value2, "beanNum");
            return (Criteria) this;
        }

        public Criteria andBeanNumNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bean_num not between", value1, value2, "beanNum");
            return (Criteria) this;
        }

        public Criteria andBeanAmountIsNull() {
            addCriterion("bean_amount is null");
            return (Criteria) this;
        }

        public Criteria andBeanAmountIsNotNull() {
            addCriterion("bean_amount is not null");
            return (Criteria) this;
        }

        public Criteria andBeanAmountEqualTo(BigDecimal value) {
            addCriterion("bean_amount =", value, "beanAmount");
            return (Criteria) this;
        }

        public Criteria andBeanAmountNotEqualTo(BigDecimal value) {
            addCriterion("bean_amount <>", value, "beanAmount");
            return (Criteria) this;
        }

        public Criteria andBeanAmountGreaterThan(BigDecimal value) {
            addCriterion("bean_amount >", value, "beanAmount");
            return (Criteria) this;
        }

        public Criteria andBeanAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("bean_amount >=", value, "beanAmount");
            return (Criteria) this;
        }

        public Criteria andBeanAmountLessThan(BigDecimal value) {
            addCriterion("bean_amount <", value, "beanAmount");
            return (Criteria) this;
        }

        public Criteria andBeanAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("bean_amount <=", value, "beanAmount");
            return (Criteria) this;
        }

        public Criteria andBeanAmountIn(List<BigDecimal> values) {
            addCriterion("bean_amount in", values, "beanAmount");
            return (Criteria) this;
        }

        public Criteria andBeanAmountNotIn(List<BigDecimal> values) {
            addCriterion("bean_amount not in", values, "beanAmount");
            return (Criteria) this;
        }

        public Criteria andBeanAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bean_amount between", value1, value2, "beanAmount");
            return (Criteria) this;
        }

        public Criteria andBeanAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("bean_amount not between", value1, value2, "beanAmount");
            return (Criteria) this;
        }
	}

	public static class Criteria extends GeneratedCriteria
	{

		protected Criteria ( )
		{
			super ();
		}
	}

	public static class Criterion
	{

		private String condition;

		private Object value;

		private Object secondValue;

		private boolean noValue;

		private boolean singleValue;

		private boolean betweenValue;

		private boolean listValue;

		private String typeHandler;

		public String getCondition ( )
			{
				return condition;
			}

		public Object getValue ( )
			{
				return value;
			}

		public Object getSecondValue ( )
			{
				return secondValue;
			}

		public boolean isNoValue ( )
			{
				return noValue;
			}

		public boolean isSingleValue ( )
			{
				return singleValue;
			}

		public boolean isBetweenValue ( )
			{
				return betweenValue;
			}

		public boolean isListValue ( )
			{
				return listValue;
			}

		public String getTypeHandler ( )
			{
				return typeHandler;
			}

		protected Criterion (String condition)
		{
			super ();
			this.condition = condition;
			this.typeHandler = null;
			this.noValue = true;
		}

		protected Criterion (String condition , Object value , String typeHandler)
		{
			super ();
			this.condition = condition;
			this.value = value;
			this.typeHandler = typeHandler;
			if (value instanceof List <?>)
			{
				this.listValue = true;
			}
			else
			{
				this.singleValue = true;
			}
		}

		protected Criterion (String condition , Object value)
		{
			this (condition , value , null);
		}

		protected Criterion (String condition , Object value , Object secondValue , String typeHandler)
		{
			super ();
			this.condition = condition;
			this.value = value;
			this.secondValue = secondValue;
			this.typeHandler = typeHandler;
			this.betweenValue = true;
		}

		protected Criterion (String condition , Object value , Object secondValue)
		{
			this (condition , value , secondValue , null);
		}
	}
}