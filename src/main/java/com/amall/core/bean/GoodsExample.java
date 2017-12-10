package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.amall.core.web.BaseQuery;

public class GoodsExample extends BaseQuery
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List <Criteria> oredCriteria;


	public GoodsExample ( )
	{
		oredCriteria = new ArrayList <Criteria> ();
	}


	public void setOrderByClause (	String orderByClause)
		{
			this.orderByClause = orderByClause;
		}


	public String getOrderByClause ( )
		{
			return orderByClause;
		}


	public void setDistinct (	boolean distinct)
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


		protected void addCriterion (	String condition)
			{
				if (condition == null)
				{
					throw new RuntimeException ("Value for condition cannot be null");
				}
				criteria.add (new Criterion (condition));
			}


		protected void addCriterion (	String condition , Object value , String property)
			{
				if (value == null)
				{
					throw new RuntimeException ("Value for " + property + " cannot be null");
				}
				criteria.add (new Criterion (condition , value));
			}


		protected void addCriterion (	String condition , Object value1 , Object value2 , String property)
			{
				if (value1 == null || value2 == null)
				{
					throw new RuntimeException ("Between values for " + property + " cannot be null");
				}
				criteria.add (new Criterion (condition , value1 , value2));
			}


		protected void addCriterionForJDBCDate (String condition , Date value , String property)
			{
				if (value == null)
				{
					throw new RuntimeException ("Value for " + property + " cannot be null");
				}
				addCriterion (condition , new java.sql.Date (value.getTime ()) , property);
			}


		protected void addCriterionForJDBCDate (String condition , List <Date> values , String property)
			{
				if (values == null || values.size () == 0)
				{
					throw new RuntimeException ("Value list for " + property + " cannot be null or empty");
				}
				List <java.sql.Date> dateList = new ArrayList <java.sql.Date> ();
				Iterator <Date> iter = values.iterator ();
				while (iter.hasNext ())
				{
					dateList.add (new java.sql.Date (iter.next ().getTime ()));
				}
				addCriterion (condition , dateList , property);
			}


		protected void addCriterionForJDBCDate (String condition , Date value1 , Date value2 , String property)
			{
				if (value1 == null || value2 == null)
				{
					throw new RuntimeException ("Between values for " + property + " cannot be null");
				}
				addCriterion (condition , new java.sql.Date (value1.getTime ()) , new java.sql.Date (value2.getTime ()) , property);
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


		public Criteria andIdEqualTo (	Long value)
			{
				addCriterion ("id =" , value , "id");
				return (Criteria) this;
			}


		public Criteria andIdNotEqualTo (	Long value)
			{
				addCriterion ("id <>" , value , "id");
				return (Criteria) this;
			}


		public Criteria andIdGreaterThan (	Long value)
			{
				addCriterion ("id >" , value , "id");
				return (Criteria) this;
			}


		public Criteria andIdGreaterThanOrEqualTo (	Long value)
			{
				addCriterion ("id >=" , value , "id");
				return (Criteria) this;
			}


		public Criteria andIdLessThan (	Long value)
			{
				addCriterion ("id <" , value , "id");
				return (Criteria) this;
			}


		public Criteria andIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("id <=" , value , "id");
				return (Criteria) this;
			}


		public Criteria andIdIn (	List <Long> values)
			{
				addCriterion ("id in" , values , "id");
				return (Criteria) this;
			}


		public Criteria andIdNotIn (List <Long> values)
			{
				addCriterion ("id not in" , values , "id");
				return (Criteria) this;
			}


		public Criteria andIdBetween (	Long value1 , Long value2)
			{
				addCriterion ("id between" , value1 , value2 , "id");
				return (Criteria) this;
			}


		public Criteria andIdNotBetween (	Long value1 , Long value2)
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


		public Criteria andAddtimeEqualTo (	Date value)
			{
				addCriterion ("addTime =" , value , "addtime");
				return (Criteria) this;
			}


		public Criteria andAddtimeNotEqualTo (	Date value)
			{
				addCriterion ("addTime <>" , value , "addtime");
				return (Criteria) this;
			}


		public Criteria andAddtimeGreaterThan (	Date value)
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


		public Criteria andAddtimeLessThanOrEqualTo (	Date value)
			{
				addCriterion ("addTime <=" , value , "addtime");
				return (Criteria) this;
			}


		public Criteria andAddtimeIn (	List <Date> values)
			{
				addCriterion ("addTime in" , values , "addtime");
				return (Criteria) this;
			}


		public Criteria andAddtimeNotIn (	List <Date> values)
			{
				addCriterion ("addTime not in" , values , "addtime");
				return (Criteria) this;
			}


		public Criteria andAddtimeBetween (	Date value1 , Date value2)
			{
				addCriterion ("addTime between" , value1 , value2 , "addtime");
				return (Criteria) this;
			}


		public Criteria andAddtimeNotBetween (	Date value1 , Date value2)
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


		public Criteria andDeletestatusNotEqualTo (	Boolean value)
			{
				addCriterion ("deleteStatus <>" , value , "deletestatus");
				return (Criteria) this;
			}


		public Criteria andDeletestatusGreaterThan (Boolean value)
			{
				addCriterion ("deleteStatus >" , value , "deletestatus");
				return (Criteria) this;
			}


		public Criteria andDeletestatusGreaterThanOrEqualTo (	Boolean value)
			{
				addCriterion ("deleteStatus >=" , value , "deletestatus");
				return (Criteria) this;
			}


		public Criteria andDeletestatusLessThan (	Boolean value)
			{
				addCriterion ("deleteStatus <" , value , "deletestatus");
				return (Criteria) this;
			}


		public Criteria andDeletestatusLessThanOrEqualTo (	Boolean value)
			{
				addCriterion ("deleteStatus <=" , value , "deletestatus");
				return (Criteria) this;
			}


		public Criteria andDeletestatusIn (	List <Boolean> values)
			{
				addCriterion ("deleteStatus in" , values , "deletestatus");
				return (Criteria) this;
			}


		public Criteria andDeletestatusNotIn (	List <Boolean> values)
			{
				addCriterion ("deleteStatus not in" , values , "deletestatus");
				return (Criteria) this;
			}


		public Criteria andDeletestatusBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("deleteStatus between" , value1 , value2 , "deletestatus");
				return (Criteria) this;
			}


		public Criteria andDeletestatusNotBetween (	Boolean value1 , Boolean value2)
			{
				addCriterion ("deleteStatus not between" , value1 , value2 , "deletestatus");
				return (Criteria) this;
			}


		public Criteria andActivityStatusIsNull ( )
			{
				addCriterion ("activity_status is null");
				return (Criteria) this;
			}


		public Criteria andActivityStatusIsNotNull ( )
			{
				addCriterion ("activity_status is not null");
				return (Criteria) this;
			}


		public Criteria andActivityStatusEqualTo (	Integer value)
			{
				addCriterion ("activity_status =" , value , "activityStatus");
				return (Criteria) this;
			}


		public Criteria andActivityStatusNotEqualTo (	Integer value)
			{
				addCriterion ("activity_status <>" , value , "activityStatus");
				return (Criteria) this;
			}


		public Criteria andActivityStatusGreaterThan (	Integer value)
			{
				addCriterion ("activity_status >" , value , "activityStatus");
				return (Criteria) this;
			}


		public Criteria andActivityStatusGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("activity_status >=" , value , "activityStatus");
				return (Criteria) this;
			}


		public Criteria andActivityStatusLessThan (	Integer value)
			{
				addCriterion ("activity_status <" , value , "activityStatus");
				return (Criteria) this;
			}


		public Criteria andActivityStatusLessThanOrEqualTo (Integer value)
			{
				addCriterion ("activity_status <=" , value , "activityStatus");
				return (Criteria) this;
			}


		public Criteria andActivityStatusIn (	List <Integer> values)
			{
				addCriterion ("activity_status in" , values , "activityStatus");
				return (Criteria) this;
			}


		public Criteria andActivityStatusNotIn (List <Integer> values)
			{
				addCriterion ("activity_status not in" , values , "activityStatus");
				return (Criteria) this;
			}


		public Criteria andActivityStatusBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("activity_status between" , value1 , value2 , "activityStatus");
				return (Criteria) this;
			}


		public Criteria andActivityStatusNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("activity_status not between" , value1 , value2 , "activityStatus");
				return (Criteria) this;
			}


		public Criteria andBargainStatusIsNull ( )
			{
				addCriterion ("bargain_status is null");
				return (Criteria) this;
			}


		public Criteria andBargainStatusIsNotNull ( )
			{
				addCriterion ("bargain_status is not null");
				return (Criteria) this;
			}


		public Criteria andBargainStatusEqualTo (	Integer value)
			{
				addCriterion ("bargain_status =" , value , "bargainStatus");
				return (Criteria) this;
			}


		public Criteria andBargainStatusNotEqualTo (Integer value)
			{
				addCriterion ("bargain_status <>" , value , "bargainStatus");
				return (Criteria) this;
			}


		public Criteria andBargainStatusGreaterThan (	Integer value)
			{
				addCriterion ("bargain_status >" , value , "bargainStatus");
				return (Criteria) this;
			}


		public Criteria andBargainStatusGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("bargain_status >=" , value , "bargainStatus");
				return (Criteria) this;
			}


		public Criteria andBargainStatusLessThan (	Integer value)
			{
				addCriterion ("bargain_status <" , value , "bargainStatus");
				return (Criteria) this;
			}


		public Criteria andBargainStatusLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("bargain_status <=" , value , "bargainStatus");
				return (Criteria) this;
			}


		public Criteria andBargainStatusIn (List <Integer> values)
			{
				addCriterion ("bargain_status in" , values , "bargainStatus");
				return (Criteria) this;
			}


		public Criteria andBargainStatusNotIn (	List <Integer> values)
			{
				addCriterion ("bargain_status not in" , values , "bargainStatus");
				return (Criteria) this;
			}


		public Criteria andBargainStatusBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("bargain_status between" , value1 , value2 , "bargainStatus");
				return (Criteria) this;
			}


		public Criteria andBargainStatusNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("bargain_status not between" , value1 , value2 , "bargainStatus");
				return (Criteria) this;
			}


		public Criteria andCombinBeginTimeIsNull ( )
			{
				addCriterion ("combin_begin_time is null");
				return (Criteria) this;
			}


		public Criteria andCombinBeginTimeIsNotNull ( )
			{
				addCriterion ("combin_begin_time is not null");
				return (Criteria) this;
			}


		public Criteria andCombinBeginTimeEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("combin_begin_time =" , value , "combinBeginTime");
				return (Criteria) this;
			}


		public Criteria andCombinBeginTimeNotEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("combin_begin_time <>" , value , "combinBeginTime");
				return (Criteria) this;
			}


		public Criteria andCombinBeginTimeGreaterThan (	Date value)
			{
				addCriterionForJDBCDate ("combin_begin_time >" , value , "combinBeginTime");
				return (Criteria) this;
			}


		public Criteria andCombinBeginTimeGreaterThanOrEqualTo (Date value)
			{
				addCriterionForJDBCDate ("combin_begin_time >=" , value , "combinBeginTime");
				return (Criteria) this;
			}


		public Criteria andCombinBeginTimeLessThan (Date value)
			{
				addCriterionForJDBCDate ("combin_begin_time <" , value , "combinBeginTime");
				return (Criteria) this;
			}


		public Criteria andCombinBeginTimeLessThanOrEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("combin_begin_time <=" , value , "combinBeginTime");
				return (Criteria) this;
			}


		public Criteria andCombinBeginTimeIn (	List <Date> values)
			{
				addCriterionForJDBCDate ("combin_begin_time in" , values , "combinBeginTime");
				return (Criteria) this;
			}


		public Criteria andCombinBeginTimeNotIn (	List <Date> values)
			{
				addCriterionForJDBCDate ("combin_begin_time not in" , values , "combinBeginTime");
				return (Criteria) this;
			}


		public Criteria andCombinBeginTimeBetween (	Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("combin_begin_time between" , value1 , value2 , "combinBeginTime");
				return (Criteria) this;
			}


		public Criteria andCombinBeginTimeNotBetween (	Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("combin_begin_time not between" , value1 , value2 , "combinBeginTime");
				return (Criteria) this;
			}


		public Criteria andCombinEndTimeIsNull ( )
			{
				addCriterion ("combin_end_time is null");
				return (Criteria) this;
			}


		public Criteria andCombinEndTimeIsNotNull ( )
			{
				addCriterion ("combin_end_time is not null");
				return (Criteria) this;
			}


		public Criteria andCombinEndTimeEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("combin_end_time =" , value , "combinEndTime");
				return (Criteria) this;
			}


		public Criteria andCombinEndTimeNotEqualTo (Date value)
			{
				addCriterionForJDBCDate ("combin_end_time <>" , value , "combinEndTime");
				return (Criteria) this;
			}


		public Criteria andCombinEndTimeGreaterThan (	Date value)
			{
				addCriterionForJDBCDate ("combin_end_time >" , value , "combinEndTime");
				return (Criteria) this;
			}


		public Criteria andCombinEndTimeGreaterThanOrEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("combin_end_time >=" , value , "combinEndTime");
				return (Criteria) this;
			}


		public Criteria andCombinEndTimeLessThan (	Date value)
			{
				addCriterionForJDBCDate ("combin_end_time <" , value , "combinEndTime");
				return (Criteria) this;
			}


		public Criteria andCombinEndTimeLessThanOrEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("combin_end_time <=" , value , "combinEndTime");
				return (Criteria) this;
			}


		public Criteria andCombinEndTimeIn (List <Date> values)
			{
				addCriterionForJDBCDate ("combin_end_time in" , values , "combinEndTime");
				return (Criteria) this;
			}


		public Criteria andCombinEndTimeNotIn (	List <Date> values)
			{
				addCriterionForJDBCDate ("combin_end_time not in" , values , "combinEndTime");
				return (Criteria) this;
			}


		public Criteria andCombinEndTimeBetween (	Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("combin_end_time between" , value1 , value2 , "combinEndTime");
				return (Criteria) this;
			}


		public Criteria andCombinEndTimeNotBetween (Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("combin_end_time not between" , value1 , value2 , "combinEndTime");
				return (Criteria) this;
			}


		public Criteria andCombinPriceIsNull ( )
			{
				addCriterion ("combin_price is null");
				return (Criteria) this;
			}


		public Criteria andCombinPriceIsNotNull ( )
			{
				addCriterion ("combin_price is not null");
				return (Criteria) this;
			}


		public Criteria andCombinPriceEqualTo (	BigDecimal value)
			{
				addCriterion ("combin_price =" , value , "combinPrice");
				return (Criteria) this;
			}


		public Criteria andCombinPriceNotEqualTo (	BigDecimal value)
			{
				addCriterion ("combin_price <>" , value , "combinPrice");
				return (Criteria) this;
			}


		public Criteria andCombinPriceGreaterThan (	BigDecimal value)
			{
				addCriterion ("combin_price >" , value , "combinPrice");
				return (Criteria) this;
			}


		public Criteria andCombinPriceGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("combin_price >=" , value , "combinPrice");
				return (Criteria) this;
			}


		public Criteria andCombinPriceLessThan (BigDecimal value)
			{
				addCriterion ("combin_price <" , value , "combinPrice");
				return (Criteria) this;
			}


		public Criteria andCombinPriceLessThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("combin_price <=" , value , "combinPrice");
				return (Criteria) this;
			}


		public Criteria andCombinPriceIn (	List <BigDecimal> values)
			{
				addCriterion ("combin_price in" , values , "combinPrice");
				return (Criteria) this;
			}


		public Criteria andCombinPriceNotIn (	List <BigDecimal> values)
			{
				addCriterion ("combin_price not in" , values , "combinPrice");
				return (Criteria) this;
			}


		public Criteria andCombinPriceBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("combin_price between" , value1 , value2 , "combinPrice");
				return (Criteria) this;
			}


		public Criteria andCombinPriceNotBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("combin_price not between" , value1 , value2 , "combinPrice");
				return (Criteria) this;
			}


		public Criteria andCombinStatusIsNull ( )
			{
				addCriterion ("combin_status is null");
				return (Criteria) this;
			}


		public Criteria andCombinStatusIsNotNull ( )
			{
				addCriterion ("combin_status is not null");
				return (Criteria) this;
			}


		public Criteria andCombinStatusEqualTo (Integer value)
			{
				addCriterion ("combin_status =" , value , "combinStatus");
				return (Criteria) this;
			}


		public Criteria andCombinStatusNotEqualTo (	Integer value)
			{
				addCriterion ("combin_status <>" , value , "combinStatus");
				return (Criteria) this;
			}


		public Criteria andCombinStatusGreaterThan (Integer value)
			{
				addCriterion ("combin_status >" , value , "combinStatus");
				return (Criteria) this;
			}


		public Criteria andCombinStatusGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("combin_status >=" , value , "combinStatus");
				return (Criteria) this;
			}


		public Criteria andCombinStatusLessThan (	Integer value)
			{
				addCriterion ("combin_status <" , value , "combinStatus");
				return (Criteria) this;
			}


		public Criteria andCombinStatusLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("combin_status <=" , value , "combinStatus");
				return (Criteria) this;
			}


		public Criteria andCombinStatusIn (	List <Integer> values)
			{
				addCriterion ("combin_status in" , values , "combinStatus");
				return (Criteria) this;
			}


		public Criteria andCombinStatusNotIn (	List <Integer> values)
			{
				addCriterion ("combin_status not in" , values , "combinStatus");
				return (Criteria) this;
			}


		public Criteria andCombinStatusBetween (Integer value1 , Integer value2)
			{
				addCriterion ("combin_status between" , value1 , value2 , "combinStatus");
				return (Criteria) this;
			}


		public Criteria andCombinStatusNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("combin_status not between" , value1 , value2 , "combinStatus");
				return (Criteria) this;
			}


		public Criteria andDeliveryStatusIsNull ( )
			{
				addCriterion ("delivery_status is null");
				return (Criteria) this;
			}


		public Criteria andDeliveryStatusIsNotNull ( )
			{
				addCriterion ("delivery_status is not null");
				return (Criteria) this;
			}


		public Criteria andDeliveryStatusEqualTo (	Integer value)
			{
				addCriterion ("delivery_status =" , value , "deliveryStatus");
				return (Criteria) this;
			}


		public Criteria andDeliveryStatusNotEqualTo (	Integer value)
			{
				addCriterion ("delivery_status <>" , value , "deliveryStatus");
				return (Criteria) this;
			}


		public Criteria andDeliveryStatusGreaterThan (	Integer value)
			{
				addCriterion ("delivery_status >" , value , "deliveryStatus");
				return (Criteria) this;
			}


		public Criteria andDeliveryStatusGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("delivery_status >=" , value , "deliveryStatus");
				return (Criteria) this;
			}


		public Criteria andDeliveryStatusLessThan (	Integer value)
			{
				addCriterion ("delivery_status <" , value , "deliveryStatus");
				return (Criteria) this;
			}


		public Criteria andDeliveryStatusLessThanOrEqualTo (Integer value)
			{
				addCriterion ("delivery_status <=" , value , "deliveryStatus");
				return (Criteria) this;
			}


		public Criteria andDeliveryStatusIn (	List <Integer> values)
			{
				addCriterion ("delivery_status in" , values , "deliveryStatus");
				return (Criteria) this;
			}


		public Criteria andDeliveryStatusNotIn (List <Integer> values)
			{
				addCriterion ("delivery_status not in" , values , "deliveryStatus");
				return (Criteria) this;
			}


		public Criteria andDeliveryStatusBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("delivery_status between" , value1 , value2 , "deliveryStatus");
				return (Criteria) this;
			}


		public Criteria andDeliveryStatusNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("delivery_status not between" , value1 , value2 , "deliveryStatus");
				return (Criteria) this;
			}


		public Criteria andDescriptionEvaluateIsNull ( )
			{
				addCriterion ("description_evaluate is null");
				return (Criteria) this;
			}


		public Criteria andDescriptionEvaluateIsNotNull ( )
			{
				addCriterion ("description_evaluate is not null");
				return (Criteria) this;
			}


		public Criteria andDescriptionEvaluateEqualTo (	Long value)
			{
				addCriterion ("description_evaluate =" , value , "descriptionEvaluate");
				return (Criteria) this;
			}


		public Criteria andDescriptionEvaluateNotEqualTo (	Long value)
			{
				addCriterion ("description_evaluate <>" , value , "descriptionEvaluate");
				return (Criteria) this;
			}


		public Criteria andDescriptionEvaluateGreaterThan (	Long value)
			{
				addCriterion ("description_evaluate >" , value , "descriptionEvaluate");
				return (Criteria) this;
			}


		public Criteria andDescriptionEvaluateGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("description_evaluate >=" , value , "descriptionEvaluate");
				return (Criteria) this;
			}


		public Criteria andDescriptionEvaluateLessThan (Long value)
			{
				addCriterion ("description_evaluate <" , value , "descriptionEvaluate");
				return (Criteria) this;
			}


		public Criteria andDescriptionEvaluateLessThanOrEqualTo (	Long value)
			{
				addCriterion ("description_evaluate <=" , value , "descriptionEvaluate");
				return (Criteria) this;
			}


		public Criteria andDescriptionEvaluateIn (	List <Long> values)
			{
				addCriterion ("description_evaluate in" , values , "descriptionEvaluate");
				return (Criteria) this;
			}


		public Criteria andDescriptionEvaluateNotIn (	List <Long> values)
			{
				addCriterion ("description_evaluate not in" , values , "descriptionEvaluate");
				return (Criteria) this;
			}


		public Criteria andDescriptionEvaluateBetween (	Long value1 , Long value2)
			{
				addCriterion ("description_evaluate between" , value1 , value2 , "descriptionEvaluate");
				return (Criteria) this;
			}


		public Criteria andDescriptionEvaluateNotBetween (	Long value1 , Long value2)
			{
				addCriterion ("description_evaluate not between" , value1 , value2 , "descriptionEvaluate");
				return (Criteria) this;
			}


		public Criteria andEmsTransFeeIsNull ( )
			{
				addCriterion ("ems_trans_fee is null");
				return (Criteria) this;
			}


		public Criteria andEmsTransFeeIsNotNull ( )
			{
				addCriterion ("ems_trans_fee is not null");
				return (Criteria) this;
			}


		public Criteria andEmsTransFeeEqualTo (	BigDecimal value)
			{
				addCriterion ("ems_trans_fee =" , value , "emsTransFee");
				return (Criteria) this;
			}


		public Criteria andEmsTransFeeNotEqualTo (	BigDecimal value)
			{
				addCriterion ("ems_trans_fee <>" , value , "emsTransFee");
				return (Criteria) this;
			}


		public Criteria andEmsTransFeeGreaterThan (	BigDecimal value)
			{
				addCriterion ("ems_trans_fee >" , value , "emsTransFee");
				return (Criteria) this;
			}


		public Criteria andEmsTransFeeGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("ems_trans_fee >=" , value , "emsTransFee");
				return (Criteria) this;
			}


		public Criteria andEmsTransFeeLessThan (BigDecimal value)
			{
				addCriterion ("ems_trans_fee <" , value , "emsTransFee");
				return (Criteria) this;
			}


		public Criteria andEmsTransFeeLessThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("ems_trans_fee <=" , value , "emsTransFee");
				return (Criteria) this;
			}


		public Criteria andEmsTransFeeIn (	List <BigDecimal> values)
			{
				addCriterion ("ems_trans_fee in" , values , "emsTransFee");
				return (Criteria) this;
			}


		public Criteria andEmsTransFeeNotIn (	List <BigDecimal> values)
			{
				addCriterion ("ems_trans_fee not in" , values , "emsTransFee");
				return (Criteria) this;
			}


		public Criteria andEmsTransFeeBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("ems_trans_fee between" , value1 , value2 , "emsTransFee");
				return (Criteria) this;
			}


		public Criteria andEmsTransFeeNotBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("ems_trans_fee not between" , value1 , value2 , "emsTransFee");
				return (Criteria) this;
			}


		public Criteria andExpressTransFeeIsNull ( )
			{
				addCriterion ("express_trans_fee is null");
				return (Criteria) this;
			}


		public Criteria andExpressTransFeeIsNotNull ( )
			{
				addCriterion ("express_trans_fee is not null");
				return (Criteria) this;
			}


		public Criteria andExpressTransFeeEqualTo (	BigDecimal value)
			{
				addCriterion ("express_trans_fee =" , value , "expressTransFee");
				return (Criteria) this;
			}


		public Criteria andExpressTransFeeNotEqualTo (	BigDecimal value)
			{
				addCriterion ("express_trans_fee <>" , value , "expressTransFee");
				return (Criteria) this;
			}


		public Criteria andExpressTransFeeGreaterThan (	BigDecimal value)
			{
				addCriterion ("express_trans_fee >" , value , "expressTransFee");
				return (Criteria) this;
			}


		public Criteria andExpressTransFeeGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("express_trans_fee >=" , value , "expressTransFee");
				return (Criteria) this;
			}


		public Criteria andExpressTransFeeLessThan (BigDecimal value)
			{
				addCriterion ("express_trans_fee <" , value , "expressTransFee");
				return (Criteria) this;
			}


		public Criteria andExpressTransFeeLessThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("express_trans_fee <=" , value , "expressTransFee");
				return (Criteria) this;
			}


		public Criteria andExpressTransFeeIn (	List <BigDecimal> values)
			{
				addCriterion ("express_trans_fee in" , values , "expressTransFee");
				return (Criteria) this;
			}


		public Criteria andExpressTransFeeNotIn (	List <BigDecimal> values)
			{
				addCriterion ("express_trans_fee not in" , values , "expressTransFee");
				return (Criteria) this;
			}


		public Criteria andExpressTransFeeBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("express_trans_fee between" , value1 , value2 , "expressTransFee");
				return (Criteria) this;
			}


		public Criteria andExpressTransFeeNotBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("express_trans_fee not between" , value1 , value2 , "expressTransFee");
				return (Criteria) this;
			}


		public Criteria andGoodsChoiceTypeIsNull ( )
			{
				addCriterion ("goods_choice_type is null");
				return (Criteria) this;
			}


		public Criteria andGoodsChoiceTypeIsNotNull ( )
			{
				addCriterion ("goods_choice_type is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsChoiceTypeEqualTo (	Integer value)
			{
				addCriterion ("goods_choice_type =" , value , "goodsChoiceType");
				return (Criteria) this;
			}


		public Criteria andGoodsChoiceTypeNotEqualTo (	Integer value)
			{
				addCriterion ("goods_choice_type <>" , value , "goodsChoiceType");
				return (Criteria) this;
			}


		public Criteria andGoodsChoiceTypeGreaterThan (	Integer value)
			{
				addCriterion ("goods_choice_type >" , value , "goodsChoiceType");
				return (Criteria) this;
			}


		public Criteria andGoodsChoiceTypeGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("goods_choice_type >=" , value , "goodsChoiceType");
				return (Criteria) this;
			}


		public Criteria andGoodsChoiceTypeLessThan (Integer value)
			{
				addCriterion ("goods_choice_type <" , value , "goodsChoiceType");
				return (Criteria) this;
			}


		public Criteria andGoodsChoiceTypeLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("goods_choice_type <=" , value , "goodsChoiceType");
				return (Criteria) this;
			}


		public Criteria andGoodsChoiceTypeIn (	List <Integer> values)
			{
				addCriterion ("goods_choice_type in" , values , "goodsChoiceType");
				return (Criteria) this;
			}


		public Criteria andGoodsChoiceTypeNotIn (	List <Integer> values)
			{
				addCriterion ("goods_choice_type not in" , values , "goodsChoiceType");
				return (Criteria) this;
			}


		public Criteria andGoodsChoiceTypeBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("goods_choice_type between" , value1 , value2 , "goodsChoiceType");
				return (Criteria) this;
			}


		public Criteria andGoodsChoiceTypeNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("goods_choice_type not between" , value1 , value2 , "goodsChoiceType");
				return (Criteria) this;
			}


		public Criteria andGoodsClickIsNull ( )
			{
				addCriterion ("goods_click is null");
				return (Criteria) this;
			}


		public Criteria andGoodsClickIsNotNull ( )
			{
				addCriterion ("goods_click is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsClickEqualTo (	Integer value)
			{
				addCriterion ("goods_click =" , value , "goodsClick");
				return (Criteria) this;
			}


		public Criteria andGoodsClickNotEqualTo (	Integer value)
			{
				addCriterion ("goods_click <>" , value , "goodsClick");
				return (Criteria) this;
			}


		public Criteria andGoodsClickGreaterThan (	Integer value)
			{
				addCriterion ("goods_click >" , value , "goodsClick");
				return (Criteria) this;
			}


		public Criteria andGoodsClickGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("goods_click >=" , value , "goodsClick");
				return (Criteria) this;
			}


		public Criteria andGoodsClickLessThan (	Integer value)
			{
				addCriterion ("goods_click <" , value , "goodsClick");
				return (Criteria) this;
			}


		public Criteria andGoodsClickLessThanOrEqualTo (Integer value)
			{
				addCriterion ("goods_click <=" , value , "goodsClick");
				return (Criteria) this;
			}


		public Criteria andGoodsClickIn (	List <Integer> values)
			{
				addCriterion ("goods_click in" , values , "goodsClick");
				return (Criteria) this;
			}


		public Criteria andGoodsClickNotIn (List <Integer> values)
			{
				addCriterion ("goods_click not in" , values , "goodsClick");
				return (Criteria) this;
			}


		public Criteria andGoodsClickBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("goods_click between" , value1 , value2 , "goodsClick");
				return (Criteria) this;
			}


		public Criteria andGoodsClickNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("goods_click not between" , value1 , value2 , "goodsClick");
				return (Criteria) this;
			}


		public Criteria andGoodsCollectIsNull ( )
			{
				addCriterion ("goods_collect is null");
				return (Criteria) this;
			}


		public Criteria andGoodsCollectIsNotNull ( )
			{
				addCriterion ("goods_collect is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsCollectEqualTo (Integer value)
			{
				addCriterion ("goods_collect =" , value , "goodsCollect");
				return (Criteria) this;
			}


		public Criteria andGoodsCollectNotEqualTo (	Integer value)
			{
				addCriterion ("goods_collect <>" , value , "goodsCollect");
				return (Criteria) this;
			}


		public Criteria andGoodsCollectGreaterThan (Integer value)
			{
				addCriterion ("goods_collect >" , value , "goodsCollect");
				return (Criteria) this;
			}


		public Criteria andGoodsCollectGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("goods_collect >=" , value , "goodsCollect");
				return (Criteria) this;
			}


		public Criteria andGoodsCollectLessThan (	Integer value)
			{
				addCriterion ("goods_collect <" , value , "goodsCollect");
				return (Criteria) this;
			}


		public Criteria andGoodsCollectLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("goods_collect <=" , value , "goodsCollect");
				return (Criteria) this;
			}


		public Criteria andGoodsCollectIn (	List <Integer> values)
			{
				addCriterion ("goods_collect in" , values , "goodsCollect");
				return (Criteria) this;
			}


		public Criteria andGoodsCollectNotIn (	List <Integer> values)
			{
				addCriterion ("goods_collect not in" , values , "goodsCollect");
				return (Criteria) this;
			}


		public Criteria andGoodsCollectBetween (Integer value1 , Integer value2)
			{
				addCriterion ("goods_collect between" , value1 , value2 , "goodsCollect");
				return (Criteria) this;
			}


		public Criteria andGoodsCollectNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("goods_collect not between" , value1 , value2 , "goodsCollect");
				return (Criteria) this;
			}


		public Criteria andGoodsCurrentPriceIsNull ( )
			{
				addCriterion ("goods_current_price is null");
				return (Criteria) this;
			}


		public Criteria andGoodsCurrentPriceIsNotNull ( )
			{
				addCriterion ("goods_current_price is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsCurrentPriceEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_current_price =" , value , "goodsCurrentPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsCurrentPriceNotEqualTo (BigDecimal value)
			{
				addCriterion ("goods_current_price <>" , value , "goodsCurrentPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsCurrentPriceGreaterThan (	BigDecimal value)
			{
				addCriterion ("goods_current_price >" , value , "goodsCurrentPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsCurrentPriceGreaterThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_current_price >=" , value , "goodsCurrentPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsCurrentPriceLessThan (	BigDecimal value)
			{
				addCriterion ("goods_current_price <" , value , "goodsCurrentPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsCurrentPriceLessThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_current_price <=" , value , "goodsCurrentPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsCurrentPriceIn (List <BigDecimal> values)
			{
				addCriterion ("goods_current_price in" , values , "goodsCurrentPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsCurrentPriceNotIn (	List <BigDecimal> values)
			{
				addCriterion ("goods_current_price not in" , values , "goodsCurrentPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsCurrentPriceBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("goods_current_price between" , value1 , value2 , "goodsCurrentPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsCurrentPriceNotBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("goods_current_price not between" , value1 , value2 , "goodsCurrentPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeIsNull ( )
			{
				addCriterion ("goods_fee is null");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeIsNotNull ( )
			{
				addCriterion ("goods_fee is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeEqualTo (String value)
			{
				addCriterion ("goods_fee =" , value , "goodsFee");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeNotEqualTo (	String value)
			{
				addCriterion ("goods_fee <>" , value , "goodsFee");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeGreaterThan (String value)
			{
				addCriterion ("goods_fee >" , value , "goodsFee");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeGreaterThanOrEqualTo (	String value)
			{
				addCriterion ("goods_fee >=" , value , "goodsFee");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeLessThan (	String value)
			{
				addCriterion ("goods_fee <" , value , "goodsFee");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeLessThanOrEqualTo (	String value)
			{
				addCriterion ("goods_fee <=" , value , "goodsFee");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeLike (	String value)
			{
				addCriterion ("goods_fee like" , value , "goodsFee");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeNotLike (String value)
			{
				addCriterion ("goods_fee not like" , value , "goodsFee");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeIn (	List <String> values)
			{
				addCriterion ("goods_fee in" , values , "goodsFee");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeNotIn (	List <String> values)
			{
				addCriterion ("goods_fee not in" , values , "goodsFee");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeBetween (String value1 , String value2)
			{
				addCriterion ("goods_fee between" , value1 , value2 , "goodsFee");
				return (Criteria) this;
			}


		public Criteria andGoodsFeeNotBetween (	String value1 , String value2)
			{
				addCriterion ("goods_fee not between" , value1 , value2 , "goodsFee");
				return (Criteria) this;
			}


		public Criteria andGoodsInventoryIsNull ( )
			{
				addCriterion ("goods_inventory is null");
				return (Criteria) this;
			}


		public Criteria andGoodsInventoryIsNotNull ( )
			{
				addCriterion ("goods_inventory is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsInventoryEqualTo (	Integer value)
			{
				addCriterion ("goods_inventory =" , value , "goodsInventory");
				return (Criteria) this;
			}


		public Criteria andGoodsInventoryNotEqualTo (	Integer value)
			{
				addCriterion ("goods_inventory <>" , value , "goodsInventory");
				return (Criteria) this;
			}


		public Criteria andGoodsInventoryGreaterThan (	Integer value)
			{
				addCriterion ("goods_inventory >" , value , "goodsInventory");
				return (Criteria) this;
			}


		public Criteria andGoodsInventoryGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("goods_inventory >=" , value , "goodsInventory");
				return (Criteria) this;
			}


		public Criteria andGoodsInventoryLessThan (	Integer value)
			{
				addCriterion ("goods_inventory <" , value , "goodsInventory");
				return (Criteria) this;
			}


		public Criteria andGoodsInventoryLessThanOrEqualTo (Integer value)
			{
				addCriterion ("goods_inventory <=" , value , "goodsInventory");
				return (Criteria) this;
			}


		public Criteria andGoodsInventoryIn (	List <Integer> values)
			{
				addCriterion ("goods_inventory in" , values , "goodsInventory");
				return (Criteria) this;
			}


		public Criteria andGoodsInventoryNotIn (List <Integer> values)
			{
				addCriterion ("goods_inventory not in" , values , "goodsInventory");
				return (Criteria) this;
			}


		public Criteria andGoodsInventoryBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("goods_inventory between" , value1 , value2 , "goodsInventory");
				return (Criteria) this;
			}


		public Criteria andGoodsInventoryNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("goods_inventory not between" , value1 , value2 , "goodsInventory");
				return (Criteria) this;
			}


		public Criteria andGoodsNameIsNull ( )
			{
				addCriterion ("goods_name is null");
				return (Criteria) this;
			}


		public Criteria andGoodsNameIsNotNull ( )
			{
				addCriterion ("goods_name is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsNameEqualTo (	String value)
			{
				addCriterion ("goods_name =" , value , "goodsName");
				return (Criteria) this;
			}


		public Criteria andGoodsNameNotEqualTo (String value)
			{
				addCriterion ("goods_name <>" , value , "goodsName");
				return (Criteria) this;
			}


		public Criteria andGoodsNameGreaterThan (	String value)
			{
				addCriterion ("goods_name >" , value , "goodsName");
				return (Criteria) this;
			}


		public Criteria andGoodsNameGreaterThanOrEqualTo (	String value)
			{
				addCriterion ("goods_name >=" , value , "goodsName");
				return (Criteria) this;
			}


		public Criteria andGoodsNameLessThan (	String value)
			{
				addCriterion ("goods_name <" , value , "goodsName");
				return (Criteria) this;
			}


		public Criteria andGoodsNameLessThanOrEqualTo (	String value)
			{
				addCriterion ("goods_name <=" , value , "goodsName");
				return (Criteria) this;
			}


		public Criteria andGoodsNameLike (	String value)
			{
				addCriterion ("goods_name like" , value , "goodsName");
				return (Criteria) this;
			}


		public Criteria andGoodsNameNotLike (	String value)
			{
				addCriterion ("goods_name not like" , value , "goodsName");
				return (Criteria) this;
			}


		public Criteria andGoodsNameIn (List <String> values)
			{
				addCriterion ("goods_name in" , values , "goodsName");
				return (Criteria) this;
			}


		public Criteria andGoodsNameNotIn (	List <String> values)
			{
				addCriterion ("goods_name not in" , values , "goodsName");
				return (Criteria) this;
			}


		public Criteria andGoodsNameBetween (	String value1 , String value2)
			{
				addCriterion ("goods_name between" , value1 , value2 , "goodsName");
				return (Criteria) this;
			}


		public Criteria andGoodsNameNotBetween (String value1 , String value2)
			{
				addCriterion ("goods_name not between" , value1 , value2 , "goodsName");
				return (Criteria) this;
			}


		public Criteria andGoodsPriceIsNull ( )
			{
				addCriterion ("goods_price is null");
				return (Criteria) this;
			}


		public Criteria andGoodsPriceIsNotNull ( )
			{
				addCriterion ("goods_price is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsPriceEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_price =" , value , "goodsPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsPriceNotEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_price <>" , value , "goodsPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsPriceGreaterThan (	BigDecimal value)
			{
				addCriterion ("goods_price >" , value , "goodsPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsPriceGreaterThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_price >=" , value , "goodsPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsPriceLessThan (	BigDecimal value)
			{
				addCriterion ("goods_price <" , value , "goodsPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsPriceLessThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("goods_price <=" , value , "goodsPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsPriceIn (	List <BigDecimal> values)
			{
				addCriterion ("goods_price in" , values , "goodsPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsPriceNotIn (List <BigDecimal> values)
			{
				addCriterion ("goods_price not in" , values , "goodsPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsPriceBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("goods_price between" , value1 , value2 , "goodsPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsPriceNotBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("goods_price not between" , value1 , value2 , "goodsPrice");
				return (Criteria) this;
			}


		public Criteria andGoodsRecommendIsNull ( )
			{
				addCriterion ("goods_recommend is null");
				return (Criteria) this;
			}


		public Criteria andGoodsRecommendIsNotNull ( )
			{
				addCriterion ("goods_recommend is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsRecommendEqualTo (	Boolean value)
			{
				addCriterion ("goods_recommend =" , value , "goodsRecommend");
				return (Criteria) this;
			}


		public Criteria andGoodsRecommendNotEqualTo (	Boolean value)
			{
				addCriterion ("goods_recommend <>" , value , "goodsRecommend");
				return (Criteria) this;
			}


		public Criteria andGoodsRecommendGreaterThan (	Boolean value)
			{
				addCriterion ("goods_recommend >" , value , "goodsRecommend");
				return (Criteria) this;
			}


		public Criteria andGoodsRecommendGreaterThanOrEqualTo (	Boolean value)
			{
				addCriterion ("goods_recommend >=" , value , "goodsRecommend");
				return (Criteria) this;
			}


		public Criteria andGoodsRecommendLessThan (	Boolean value)
			{
				addCriterion ("goods_recommend <" , value , "goodsRecommend");
				return (Criteria) this;
			}


		public Criteria andGoodsRecommendLessThanOrEqualTo (Boolean value)
			{
				addCriterion ("goods_recommend <=" , value , "goodsRecommend");
				return (Criteria) this;
			}


		public Criteria andGoodsRecommendIn (	List <Boolean> values)
			{
				addCriterion ("goods_recommend in" , values , "goodsRecommend");
				return (Criteria) this;
			}


		public Criteria andGoodsRecommendNotIn (List <Boolean> values)
			{
				addCriterion ("goods_recommend not in" , values , "goodsRecommend");
				return (Criteria) this;
			}


		public Criteria andGoodsRecommendBetween (	Boolean value1 , Boolean value2)
			{
				addCriterion ("goods_recommend between" , value1 , value2 , "goodsRecommend");
				return (Criteria) this;
			}


		public Criteria andGoodsRecommendNotBetween (	Boolean value1 , Boolean value2)
			{
				addCriterion ("goods_recommend not between" , value1 , value2 , "goodsRecommend");
				return (Criteria) this;
			}


		public Criteria andGoodsSalenumIsNull ( )
			{
				addCriterion ("goods_salenum is null");
				return (Criteria) this;
			}


		public Criteria andGoodsSalenumIsNotNull ( )
			{
				addCriterion ("goods_salenum is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsSalenumEqualTo (Integer value)
			{
				addCriterion ("goods_salenum =" , value , "goodsSalenum");
				return (Criteria) this;
			}


		public Criteria andGoodsSalenumNotEqualTo (	Integer value)
			{
				addCriterion ("goods_salenum <>" , value , "goodsSalenum");
				return (Criteria) this;
			}


		public Criteria andGoodsSalenumGreaterThan (Integer value)
			{
				addCriterion ("goods_salenum >" , value , "goodsSalenum");
				return (Criteria) this;
			}


		public Criteria andGoodsSalenumGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("goods_salenum >=" , value , "goodsSalenum");
				return (Criteria) this;
			}


		public Criteria andGoodsSalenumLessThan (	Integer value)
			{
				addCriterion ("goods_salenum <" , value , "goodsSalenum");
				return (Criteria) this;
			}


		public Criteria andGoodsSalenumLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("goods_salenum <=" , value , "goodsSalenum");
				return (Criteria) this;
			}


		public Criteria andGoodsSalenumIn (	List <Integer> values)
			{
				addCriterion ("goods_salenum in" , values , "goodsSalenum");
				return (Criteria) this;
			}


		public Criteria andGoodsSalenumNotIn (	List <Integer> values)
			{
				addCriterion ("goods_salenum not in" , values , "goodsSalenum");
				return (Criteria) this;
			}


		public Criteria andGoodsSalenumBetween (Integer value1 , Integer value2)
			{
				addCriterion ("goods_salenum between" , value1 , value2 , "goodsSalenum");
				return (Criteria) this;
			}


		public Criteria andGoodsSalenumNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("goods_salenum not between" , value1 , value2 , "goodsSalenum");
				return (Criteria) this;
			}


		public Criteria andGoodsSellerTimeIsNull ( )
			{
				addCriterion ("goods_seller_time is null");
				return (Criteria) this;
			}


		public Criteria andGoodsSellerTimeIsNotNull ( )
			{
				addCriterion ("goods_seller_time is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsSellerTimeEqualTo (	Date value)
			{
				addCriterion ("goods_seller_time =" , value , "goodsSellerTime");
				return (Criteria) this;
			}


		public Criteria andGoodsSellerTimeNotEqualTo (	Date value)
			{
				addCriterion ("goods_seller_time <>" , value , "goodsSellerTime");
				return (Criteria) this;
			}


		public Criteria andGoodsSellerTimeGreaterThan (	Date value)
			{
				addCriterion ("goods_seller_time >" , value , "goodsSellerTime");
				return (Criteria) this;
			}


		public Criteria andGoodsSellerTimeGreaterThanOrEqualTo (Date value)
			{
				addCriterion ("goods_seller_time >=" , value , "goodsSellerTime");
				return (Criteria) this;
			}


		public Criteria andGoodsSellerTimeLessThan (Date value)
			{
				addCriterion ("goods_seller_time <" , value , "goodsSellerTime");
				return (Criteria) this;
			}


		public Criteria andGoodsSellerTimeLessThanOrEqualTo (	Date value)
			{
				addCriterion ("goods_seller_time <=" , value , "goodsSellerTime");
				return (Criteria) this;
			}


		public Criteria andGoodsSellerTimeIn (	List <Date> values)
			{
				addCriterion ("goods_seller_time in" , values , "goodsSellerTime");
				return (Criteria) this;
			}


		public Criteria andGoodsSellerTimeNotIn (	List <Date> values)
			{
				addCriterion ("goods_seller_time not in" , values , "goodsSellerTime");
				return (Criteria) this;
			}


		public Criteria andGoodsSellerTimeBetween (	Date value1 , Date value2)
			{
				addCriterion ("goods_seller_time between" , value1 , value2 , "goodsSellerTime");
				return (Criteria) this;
			}


		public Criteria andGoodsSellerTimeNotBetween (	Date value1 , Date value2)
			{
				addCriterion ("goods_seller_time not between" , value1 , value2 , "goodsSellerTime");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialIsNull ( )
			{
				addCriterion ("goods_serial is null");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialIsNotNull ( )
			{
				addCriterion ("goods_serial is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialEqualTo (	String value)
			{
				addCriterion ("goods_serial =" , value , "goodsSerial");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialNotEqualTo (	String value)
			{
				addCriterion ("goods_serial <>" , value , "goodsSerial");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialGreaterThan (	String value)
			{
				addCriterion ("goods_serial >" , value , "goodsSerial");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialGreaterThanOrEqualTo (String value)
			{
				addCriterion ("goods_serial >=" , value , "goodsSerial");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialLessThan (String value)
			{
				addCriterion ("goods_serial <" , value , "goodsSerial");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialLessThanOrEqualTo (	String value)
			{
				addCriterion ("goods_serial <=" , value , "goodsSerial");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialLike (String value)
			{
				addCriterion ("goods_serial like" , value , "goodsSerial");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialNotLike (	String value)
			{
				addCriterion ("goods_serial not like" , value , "goodsSerial");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialIn (	List <String> values)
			{
				addCriterion ("goods_serial in" , values , "goodsSerial");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialNotIn (	List <String> values)
			{
				addCriterion ("goods_serial not in" , values , "goodsSerial");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialBetween (	String value1 , String value2)
			{
				addCriterion ("goods_serial between" , value1 , value2 , "goodsSerial");
				return (Criteria) this;
			}


		public Criteria andGoodsSerialNotBetween (	String value1 , String value2)
			{
				addCriterion ("goods_serial not between" , value1 , value2 , "goodsSerial");
				return (Criteria) this;
			}


		public Criteria andGoodsStatusIsNull ( )
			{
				addCriterion ("goods_status is null");
				return (Criteria) this;
			}


		public Criteria andGoodsStatusIsNotNull ( )
			{
				addCriterion ("goods_status is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsStatusEqualTo (	Integer value)
			{
				addCriterion ("goods_status =" , value , "goodsStatus");
				return (Criteria) this;
			}


		public Criteria andGoodsStatusNotEqualTo (	Integer value)
			{
				addCriterion ("goods_status <>" , value , "goodsStatus");
				return (Criteria) this;
			}


		public Criteria andGoodsStatusGreaterThan (	Integer value)
			{
				addCriterion ("goods_status >" , value , "goodsStatus");
				return (Criteria) this;
			}


		public Criteria andGoodsStatusGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("goods_status >=" , value , "goodsStatus");
				return (Criteria) this;
			}


		public Criteria andGoodsStatusLessThan (Integer value)
			{
				addCriterion ("goods_status <" , value , "goodsStatus");
				return (Criteria) this;
			}


		public Criteria andGoodsStatusLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("goods_status <=" , value , "goodsStatus");
				return (Criteria) this;
			}


		public Criteria andGoodsStatusIn (	List <Integer> values)
			{
				addCriterion ("goods_status in" , values , "goodsStatus");
				return (Criteria) this;
			}


		public Criteria andGoodsStatusNotIn (	List <Integer> values)
			{
				addCriterion ("goods_status not in" , values , "goodsStatus");
				return (Criteria) this;
			}


		public Criteria andGoodsStatusBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("goods_status between" , value1 , value2 , "goodsStatus");
				return (Criteria) this;
			}


		public Criteria andGoodsStatusNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("goods_status not between" , value1 , value2 , "goodsStatus");
				return (Criteria) this;
			}


		public Criteria andGoodsTransfeeIsNull ( )
			{
				addCriterion ("goods_transfee is null");
				return (Criteria) this;
			}


		public Criteria andGoodsTransfeeIsNotNull ( )
			{
				addCriterion ("goods_transfee is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsTransfeeEqualTo (	Integer value)
			{
				addCriterion ("goods_transfee =" , value , "goodsTransfee");
				return (Criteria) this;
			}


		public Criteria andGoodsTransfeeNotEqualTo (Integer value)
			{
				addCriterion ("goods_transfee <>" , value , "goodsTransfee");
				return (Criteria) this;
			}


		public Criteria andGoodsTransfeeGreaterThan (	Integer value)
			{
				addCriterion ("goods_transfee >" , value , "goodsTransfee");
				return (Criteria) this;
			}


		public Criteria andGoodsTransfeeGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("goods_transfee >=" , value , "goodsTransfee");
				return (Criteria) this;
			}


		public Criteria andGoodsTransfeeLessThan (	Integer value)
			{
				addCriterion ("goods_transfee <" , value , "goodsTransfee");
				return (Criteria) this;
			}


		public Criteria andGoodsTransfeeLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("goods_transfee <=" , value , "goodsTransfee");
				return (Criteria) this;
			}


		public Criteria andGoodsTransfeeIn (List <Integer> values)
			{
				addCriterion ("goods_transfee in" , values , "goodsTransfee");
				return (Criteria) this;
			}


		public Criteria andGoodsTransfeeNotIn (	List <Integer> values)
			{
				addCriterion ("goods_transfee not in" , values , "goodsTransfee");
				return (Criteria) this;
			}


		public Criteria andGoodsTransfeeBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("goods_transfee between" , value1 , value2 , "goodsTransfee");
				return (Criteria) this;
			}


		public Criteria andGoodsTransfeeNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("goods_transfee not between" , value1 , value2 , "goodsTransfee");
				return (Criteria) this;
			}


		public Criteria andGoodsVolumeIsNull ( )
			{
				addCriterion ("goods_volume is null");
				return (Criteria) this;
			}


		public Criteria andGoodsVolumeIsNotNull ( )
			{
				addCriterion ("goods_volume is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsVolumeEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_volume =" , value , "goodsVolume");
				return (Criteria) this;
			}


		public Criteria andGoodsVolumeNotEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_volume <>" , value , "goodsVolume");
				return (Criteria) this;
			}


		public Criteria andGoodsVolumeGreaterThan (	BigDecimal value)
			{
				addCriterion ("goods_volume >" , value , "goodsVolume");
				return (Criteria) this;
			}


		public Criteria andGoodsVolumeGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("goods_volume >=" , value , "goodsVolume");
				return (Criteria) this;
			}


		public Criteria andGoodsVolumeLessThan (BigDecimal value)
			{
				addCriterion ("goods_volume <" , value , "goodsVolume");
				return (Criteria) this;
			}


		public Criteria andGoodsVolumeLessThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_volume <=" , value , "goodsVolume");
				return (Criteria) this;
			}


		public Criteria andGoodsVolumeIn (	List <BigDecimal> values)
			{
				addCriterion ("goods_volume in" , values , "goodsVolume");
				return (Criteria) this;
			}


		public Criteria andGoodsVolumeNotIn (	List <BigDecimal> values)
			{
				addCriterion ("goods_volume not in" , values , "goodsVolume");
				return (Criteria) this;
			}


		public Criteria andGoodsVolumeBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("goods_volume between" , value1 , value2 , "goodsVolume");
				return (Criteria) this;
			}


		public Criteria andGoodsVolumeNotBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("goods_volume not between" , value1 , value2 , "goodsVolume");
				return (Criteria) this;
			}


		public Criteria andGoodsWeightIsNull ( )
			{
				addCriterion ("goods_weight is null");
				return (Criteria) this;
			}


		public Criteria andGoodsWeightIsNotNull ( )
			{
				addCriterion ("goods_weight is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsWeightEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_weight =" , value , "goodsWeight");
				return (Criteria) this;
			}


		public Criteria andGoodsWeightNotEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_weight <>" , value , "goodsWeight");
				return (Criteria) this;
			}


		public Criteria andGoodsWeightGreaterThan (	BigDecimal value)
			{
				addCriterion ("goods_weight >" , value , "goodsWeight");
				return (Criteria) this;
			}


		public Criteria andGoodsWeightGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("goods_weight >=" , value , "goodsWeight");
				return (Criteria) this;
			}


		public Criteria andGoodsWeightLessThan (BigDecimal value)
			{
				addCriterion ("goods_weight <" , value , "goodsWeight");
				return (Criteria) this;
			}


		public Criteria andGoodsWeightLessThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_weight <=" , value , "goodsWeight");
				return (Criteria) this;
			}


		public Criteria andGoodsWeightIn (	List <BigDecimal> values)
			{
				addCriterion ("goods_weight in" , values , "goodsWeight");
				return (Criteria) this;
			}


		public Criteria andGoodsWeightNotIn (	List <BigDecimal> values)
			{
				addCriterion ("goods_weight not in" , values , "goodsWeight");
				return (Criteria) this;
			}


		public Criteria andGoodsWeightBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("goods_weight between" , value1 , value2 , "goodsWeight");
				return (Criteria) this;
			}


		public Criteria andGoodsWeightNotBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("goods_weight not between" , value1 , value2 , "goodsWeight");
				return (Criteria) this;
			}


		public Criteria andGoodsAverageIsNull ( )
			{
				addCriterion ("goods_average is null");
				return (Criteria) this;
			}


		public Criteria andGoodsAverageIsNotNull ( )
			{
				addCriterion ("goods_average is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsAverageEqualTo (Integer value)
			{
				addCriterion ("goods_average =" , value , "goodsAverage");
				return (Criteria) this;
			}


		public Criteria andGoodsAverageNotEqualTo (	Integer value)
			{
				addCriterion ("goods_average <>" , value , "goodsAverage");
				return (Criteria) this;
			}


		public Criteria andGoodsAverageGreaterThan (Integer value)
			{
				addCriterion ("goods_average >" , value , "goodsAverage");
				return (Criteria) this;
			}


		public Criteria andGoodsAverageGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("goods_average >=" , value , "goodsAverage");
				return (Criteria) this;
			}


		public Criteria andGoodsAverageLessThan (	Integer value)
			{
				addCriterion ("goods_average <" , value , "goodsAverage");
				return (Criteria) this;
			}


		public Criteria andGoodsAverageLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("goods_average <=" , value , "goodsAverage");
				return (Criteria) this;
			}


		public Criteria andGoodsAverageIn (	List <Integer> values)
			{
				addCriterion ("goods_average in" , values , "goodsAverage");
				return (Criteria) this;
			}


		public Criteria andGoodsAverageNotIn (	List <Integer> values)
			{
				addCriterion ("goods_average not in" , values , "goodsAverage");
				return (Criteria) this;
			}


		public Criteria andGoodsAverageBetween (Integer value1 , Integer value2)
			{
				addCriterion ("goods_average between" , value1 , value2 , "goodsAverage");
				return (Criteria) this;
			}


		public Criteria andGoodsAverageNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("goods_average not between" , value1 , value2 , "goodsAverage");
				return (Criteria) this;
			}


		public Criteria andGroupBuyIsNull ( )
			{
				addCriterion ("group_buy is null");
				return (Criteria) this;
			}


		public Criteria andGroupBuyIsNotNull ( )
			{
				addCriterion ("group_buy is not null");
				return (Criteria) this;
			}


		public Criteria andGroupBuyEqualTo (Integer value)
			{
				addCriterion ("group_buy =" , value , "groupBuy");
				return (Criteria) this;
			}


		public Criteria andGroupBuyNotEqualTo (	Integer value)
			{
				addCriterion ("group_buy <>" , value , "groupBuy");
				return (Criteria) this;
			}


		public Criteria andGroupBuyGreaterThan (Integer value)
			{
				addCriterion ("group_buy >" , value , "groupBuy");
				return (Criteria) this;
			}


		public Criteria andGroupBuyGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("group_buy >=" , value , "groupBuy");
				return (Criteria) this;
			}


		public Criteria andGroupBuyLessThan (	Integer value)
			{
				addCriterion ("group_buy <" , value , "groupBuy");
				return (Criteria) this;
			}


		public Criteria andGroupBuyLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("group_buy <=" , value , "groupBuy");
				return (Criteria) this;
			}


		public Criteria andGroupBuyIn (	List <Integer> values)
			{
				addCriterion ("group_buy in" , values , "groupBuy");
				return (Criteria) this;
			}


		public Criteria andGroupBuyNotIn (	List <Integer> values)
			{
				addCriterion ("group_buy not in" , values , "groupBuy");
				return (Criteria) this;
			}


		public Criteria andGroupBuyBetween (Integer value1 , Integer value2)
			{
				addCriterion ("group_buy between" , value1 , value2 , "groupBuy");
				return (Criteria) this;
			}


		public Criteria andGroupBuyNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("group_buy not between" , value1 , value2 , "groupBuy");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeIsNull ( )
			{
				addCriterion ("inventory_type is null");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeIsNotNull ( )
			{
				addCriterion ("inventory_type is not null");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeEqualTo (	String value)
			{
				addCriterion ("inventory_type =" , value , "inventoryType");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeNotEqualTo (String value)
			{
				addCriterion ("inventory_type <>" , value , "inventoryType");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeGreaterThan (	String value)
			{
				addCriterion ("inventory_type >" , value , "inventoryType");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeGreaterThanOrEqualTo (	String value)
			{
				addCriterion ("inventory_type >=" , value , "inventoryType");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeLessThan (	String value)
			{
				addCriterion ("inventory_type <" , value , "inventoryType");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeLessThanOrEqualTo (	String value)
			{
				addCriterion ("inventory_type <=" , value , "inventoryType");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeLike (	String value)
			{
				addCriterion ("inventory_type like" , value , "inventoryType");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeNotLike (	String value)
			{
				addCriterion ("inventory_type not like" , value , "inventoryType");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeIn (List <String> values)
			{
				addCriterion ("inventory_type in" , values , "inventoryType");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeNotIn (	List <String> values)
			{
				addCriterion ("inventory_type not in" , values , "inventoryType");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeBetween (	String value1 , String value2)
			{
				addCriterion ("inventory_type between" , value1 , value2 , "inventoryType");
				return (Criteria) this;
			}


		public Criteria andInventoryTypeNotBetween (String value1 , String value2)
			{
				addCriterion ("inventory_type not between" , value1 , value2 , "inventoryType");
				return (Criteria) this;
			}


		public Criteria andMailTransFeeIsNull ( )
			{
				addCriterion ("mail_trans_fee is null");
				return (Criteria) this;
			}


		public Criteria andMailTransFeeIsNotNull ( )
			{
				addCriterion ("mail_trans_fee is not null");
				return (Criteria) this;
			}


		public Criteria andMailTransFeeEqualTo (BigDecimal value)
			{
				addCriterion ("mail_trans_fee =" , value , "mailTransFee");
				return (Criteria) this;
			}


		public Criteria andMailTransFeeNotEqualTo (	BigDecimal value)
			{
				addCriterion ("mail_trans_fee <>" , value , "mailTransFee");
				return (Criteria) this;
			}


		public Criteria andMailTransFeeGreaterThan (BigDecimal value)
			{
				addCriterion ("mail_trans_fee >" , value , "mailTransFee");
				return (Criteria) this;
			}


		public Criteria andMailTransFeeGreaterThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("mail_trans_fee >=" , value , "mailTransFee");
				return (Criteria) this;
			}


		public Criteria andMailTransFeeLessThan (	BigDecimal value)
			{
				addCriterion ("mail_trans_fee <" , value , "mailTransFee");
				return (Criteria) this;
			}


		public Criteria andMailTransFeeLessThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("mail_trans_fee <=" , value , "mailTransFee");
				return (Criteria) this;
			}


		public Criteria andMailTransFeeIn (	List <BigDecimal> values)
			{
				addCriterion ("mail_trans_fee in" , values , "mailTransFee");
				return (Criteria) this;
			}


		public Criteria andMailTransFeeNotIn (	List <BigDecimal> values)
			{
				addCriterion ("mail_trans_fee not in" , values , "mailTransFee");
				return (Criteria) this;
			}


		public Criteria andMailTransFeeBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("mail_trans_fee between" , value1 , value2 , "mailTransFee");
				return (Criteria) this;
			}


		public Criteria andMailTransFeeNotBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("mail_trans_fee not between" , value1 , value2 , "mailTransFee");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsIsNull ( )
			{
				addCriterion ("seo_keywords is null");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsIsNotNull ( )
			{
				addCriterion ("seo_keywords is not null");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsEqualTo (	String value)
			{
				addCriterion ("seo_keywords =" , value , "seoKeywords");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsNotEqualTo (	String value)
			{
				addCriterion ("seo_keywords <>" , value , "seoKeywords");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsGreaterThan (	String value)
			{
				addCriterion ("seo_keywords >" , value , "seoKeywords");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsGreaterThanOrEqualTo (String value)
			{
				addCriterion ("seo_keywords >=" , value , "seoKeywords");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsLessThan (String value)
			{
				addCriterion ("seo_keywords <" , value , "seoKeywords");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsLessThanOrEqualTo (	String value)
			{
				addCriterion ("seo_keywords <=" , value , "seoKeywords");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsLike (String value)
			{
				addCriterion ("seo_keywords like" , value , "seoKeywords");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsNotLike (	String value)
			{
				addCriterion ("seo_keywords not like" , value , "seoKeywords");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsIn (	List <String> values)
			{
				addCriterion ("seo_keywords in" , values , "seoKeywords");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsNotIn (	List <String> values)
			{
				addCriterion ("seo_keywords not in" , values , "seoKeywords");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsBetween (	String value1 , String value2)
			{
				addCriterion ("seo_keywords between" , value1 , value2 , "seoKeywords");
				return (Criteria) this;
			}


		public Criteria andSeoKeywordsNotBetween (	String value1 , String value2)
			{
				addCriterion ("seo_keywords not between" , value1 , value2 , "seoKeywords");
				return (Criteria) this;
			}


		public Criteria andStorePriceIsNull ( )
			{
				addCriterion ("store_price is null");
				return (Criteria) this;
			}


		public Criteria andStorePriceIsNotNull ( )
			{
				addCriterion ("store_price is not null");
				return (Criteria) this;
			}


		public Criteria andStorePriceEqualTo (	BigDecimal value)
			{
				addCriterion ("store_price =" , value , "storePrice");
				return (Criteria) this;
			}


		public Criteria andStorePriceNotEqualTo (	BigDecimal value)
			{
				addCriterion ("store_price <>" , value , "storePrice");
				return (Criteria) this;
			}


		public Criteria andStorePriceGreaterThan (	BigDecimal value)
			{
				addCriterion ("store_price >" , value , "storePrice");
				return (Criteria) this;
			}


		public Criteria andStorePriceGreaterThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("store_price >=" , value , "storePrice");
				return (Criteria) this;
			}


		public Criteria andStorePriceLessThan (	BigDecimal value)
			{
				addCriterion ("store_price <" , value , "storePrice");
				return (Criteria) this;
			}


		public Criteria andStorePriceLessThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("store_price <=" , value , "storePrice");
				return (Criteria) this;
			}


		public Criteria andStorePriceIn (	List <BigDecimal> values)
			{
				addCriterion ("store_price in" , values , "storePrice");
				return (Criteria) this;
			}


		public Criteria andStorePriceNotIn (List <BigDecimal> values)
			{
				addCriterion ("store_price not in" , values , "storePrice");
				return (Criteria) this;
			}


		public Criteria andStorePriceBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("store_price between" , value1 , value2 , "storePrice");
				return (Criteria) this;
			}


		public Criteria andStorePriceNotBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("store_price not between" , value1 , value2 , "storePrice");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendIsNull ( )
			{
				addCriterion ("store_recommend is null");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendIsNotNull ( )
			{
				addCriterion ("store_recommend is not null");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendEqualTo (	Boolean value)
			{
				addCriterion ("store_recommend =" , value , "storeRecommend");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendNotEqualTo (	Boolean value)
			{
				addCriterion ("store_recommend <>" , value , "storeRecommend");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendGreaterThan (	Boolean value)
			{
				addCriterion ("store_recommend >" , value , "storeRecommend");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendGreaterThanOrEqualTo (	Boolean value)
			{
				addCriterion ("store_recommend >=" , value , "storeRecommend");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendLessThan (	Boolean value)
			{
				addCriterion ("store_recommend <" , value , "storeRecommend");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendLessThanOrEqualTo (Boolean value)
			{
				addCriterion ("store_recommend <=" , value , "storeRecommend");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendIn (	List <Boolean> values)
			{
				addCriterion ("store_recommend in" , values , "storeRecommend");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendNotIn (List <Boolean> values)
			{
				addCriterion ("store_recommend not in" , values , "storeRecommend");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendBetween (	Boolean value1 , Boolean value2)
			{
				addCriterion ("store_recommend between" , value1 , value2 , "storeRecommend");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendNotBetween (	Boolean value1 , Boolean value2)
			{
				addCriterion ("store_recommend not between" , value1 , value2 , "storeRecommend");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendTimeIsNull ( )
			{
				addCriterion ("store_recommend_time is null");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendTimeIsNotNull ( )
			{
				addCriterion ("store_recommend_time is not null");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendTimeEqualTo (	Date value)
			{
				addCriterion ("store_recommend_time =" , value , "storeRecommendTime");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendTimeNotEqualTo (	Date value)
			{
				addCriterion ("store_recommend_time <>" , value , "storeRecommendTime");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendTimeGreaterThan (	Date value)
			{
				addCriterion ("store_recommend_time >" , value , "storeRecommendTime");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendTimeGreaterThanOrEqualTo (	Date value)
			{
				addCriterion ("store_recommend_time >=" , value , "storeRecommendTime");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendTimeLessThan (	Date value)
			{
				addCriterion ("store_recommend_time <" , value , "storeRecommendTime");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendTimeLessThanOrEqualTo (Date value)
			{
				addCriterion ("store_recommend_time <=" , value , "storeRecommendTime");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendTimeIn (	List <Date> values)
			{
				addCriterion ("store_recommend_time in" , values , "storeRecommendTime");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendTimeNotIn (List <Date> values)
			{
				addCriterion ("store_recommend_time not in" , values , "storeRecommendTime");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendTimeBetween (	Date value1 , Date value2)
			{
				addCriterion ("store_recommend_time between" , value1 , value2 , "storeRecommendTime");
				return (Criteria) this;
			}


		public Criteria andStoreRecommendTimeNotBetween (	Date value1 , Date value2)
			{
				addCriterion ("store_recommend_time not between" , value1 , value2 , "storeRecommendTime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHotIsNull ( )
			{
				addCriterion ("weixin_shop_hot is null");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHotIsNotNull ( )
			{
				addCriterion ("weixin_shop_hot is not null");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHotEqualTo (	Boolean value)
			{
				addCriterion ("weixin_shop_hot =" , value , "weixinShopHot");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHotNotEqualTo (Boolean value)
			{
				addCriterion ("weixin_shop_hot <>" , value , "weixinShopHot");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHotGreaterThan (	Boolean value)
			{
				addCriterion ("weixin_shop_hot >" , value , "weixinShopHot");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHotGreaterThanOrEqualTo (	Boolean value)
			{
				addCriterion ("weixin_shop_hot >=" , value , "weixinShopHot");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHotLessThan (	Boolean value)
			{
				addCriterion ("weixin_shop_hot <" , value , "weixinShopHot");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHotLessThanOrEqualTo (	Boolean value)
			{
				addCriterion ("weixin_shop_hot <=" , value , "weixinShopHot");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHotIn (List <Boolean> values)
			{
				addCriterion ("weixin_shop_hot in" , values , "weixinShopHot");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHotNotIn (	List <Boolean> values)
			{
				addCriterion ("weixin_shop_hot not in" , values , "weixinShopHot");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHotBetween (	Boolean value1 , Boolean value2)
			{
				addCriterion ("weixin_shop_hot between" , value1 , value2 , "weixinShopHot");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHotNotBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("weixin_shop_hot not between" , value1 , value2 , "weixinShopHot");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHottimeIsNull ( )
			{
				addCriterion ("weixin_shop_hotTime is null");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHottimeIsNotNull ( )
			{
				addCriterion ("weixin_shop_hotTime is not null");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHottimeEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("weixin_shop_hotTime =" , value , "weixinShopHottime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHottimeNotEqualTo (Date value)
			{
				addCriterionForJDBCDate ("weixin_shop_hotTime <>" , value , "weixinShopHottime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHottimeGreaterThan (	Date value)
			{
				addCriterionForJDBCDate ("weixin_shop_hotTime >" , value , "weixinShopHottime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHottimeGreaterThanOrEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("weixin_shop_hotTime >=" , value , "weixinShopHottime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHottimeLessThan (	Date value)
			{
				addCriterionForJDBCDate ("weixin_shop_hotTime <" , value , "weixinShopHottime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHottimeLessThanOrEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("weixin_shop_hotTime <=" , value , "weixinShopHottime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHottimeIn (List <Date> values)
			{
				addCriterionForJDBCDate ("weixin_shop_hotTime in" , values , "weixinShopHottime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHottimeNotIn (	List <Date> values)
			{
				addCriterionForJDBCDate ("weixin_shop_hotTime not in" , values , "weixinShopHottime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHottimeBetween (	Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("weixin_shop_hotTime between" , value1 , value2 , "weixinShopHottime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopHottimeNotBetween (Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("weixin_shop_hotTime not between" , value1 , value2 , "weixinShopHottime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendIsNull ( )
			{
				addCriterion ("weixin_shop_recommend is null");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendIsNotNull ( )
			{
				addCriterion ("weixin_shop_recommend is not null");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendEqualTo (	Boolean value)
			{
				addCriterion ("weixin_shop_recommend =" , value , "weixinShopRecommend");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendNotEqualTo (	Boolean value)
			{
				addCriterion ("weixin_shop_recommend <>" , value , "weixinShopRecommend");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendGreaterThan (	Boolean value)
			{
				addCriterion ("weixin_shop_recommend >" , value , "weixinShopRecommend");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendGreaterThanOrEqualTo (Boolean value)
			{
				addCriterion ("weixin_shop_recommend >=" , value , "weixinShopRecommend");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendLessThan (Boolean value)
			{
				addCriterion ("weixin_shop_recommend <" , value , "weixinShopRecommend");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendLessThanOrEqualTo (	Boolean value)
			{
				addCriterion ("weixin_shop_recommend <=" , value , "weixinShopRecommend");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendIn (	List <Boolean> values)
			{
				addCriterion ("weixin_shop_recommend in" , values , "weixinShopRecommend");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendNotIn (	List <Boolean> values)
			{
				addCriterion ("weixin_shop_recommend not in" , values , "weixinShopRecommend");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendBetween (	Boolean value1 , Boolean value2)
			{
				addCriterion ("weixin_shop_recommend between" , value1 , value2 , "weixinShopRecommend");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendNotBetween (	Boolean value1 , Boolean value2)
			{
				addCriterion ("weixin_shop_recommend not between" , value1 , value2 , "weixinShopRecommend");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendtimeIsNull ( )
			{
				addCriterion ("weixin_shop_recommendTime is null");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendtimeIsNotNull ( )
			{
				addCriterion ("weixin_shop_recommendTime is not null");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendtimeEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("weixin_shop_recommendTime =" , value , "weixinShopRecommendtime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendtimeNotEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("weixin_shop_recommendTime <>" , value , "weixinShopRecommendtime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendtimeGreaterThan (	Date value)
			{
				addCriterionForJDBCDate ("weixin_shop_recommendTime >" , value , "weixinShopRecommendtime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendtimeGreaterThanOrEqualTo (Date value)
			{
				addCriterionForJDBCDate ("weixin_shop_recommendTime >=" , value , "weixinShopRecommendtime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendtimeLessThan (Date value)
			{
				addCriterionForJDBCDate ("weixin_shop_recommendTime <" , value , "weixinShopRecommendtime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendtimeLessThanOrEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("weixin_shop_recommendTime <=" , value , "weixinShopRecommendtime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendtimeIn (	List <Date> values)
			{
				addCriterionForJDBCDate ("weixin_shop_recommendTime in" , values , "weixinShopRecommendtime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendtimeNotIn (	List <Date> values)
			{
				addCriterionForJDBCDate ("weixin_shop_recommendTime not in" , values , "weixinShopRecommendtime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendtimeBetween (	Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("weixin_shop_recommendTime between" , value1 , value2 , "weixinShopRecommendtime");
				return (Criteria) this;
			}


		public Criteria andWeixinShopRecommendtimeNotBetween (	Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("weixin_shop_recommendTime not between" , value1 , value2 , "weixinShopRecommendtime");
				return (Criteria) this;
			}


		public Criteria andZtcApplyTimeIsNull ( )
			{
				addCriterion ("ztc_apply_time is null");
				return (Criteria) this;
			}


		public Criteria andZtcApplyTimeIsNotNull ( )
			{
				addCriterion ("ztc_apply_time is not null");
				return (Criteria) this;
			}


		public Criteria andZtcApplyTimeEqualTo (Date value)
			{
				addCriterion ("ztc_apply_time =" , value , "ztcApplyTime");
				return (Criteria) this;
			}


		public Criteria andZtcApplyTimeNotEqualTo (	Date value)
			{
				addCriterion ("ztc_apply_time <>" , value , "ztcApplyTime");
				return (Criteria) this;
			}


		public Criteria andZtcApplyTimeGreaterThan (Date value)
			{
				addCriterion ("ztc_apply_time >" , value , "ztcApplyTime");
				return (Criteria) this;
			}


		public Criteria andZtcApplyTimeGreaterThanOrEqualTo (	Date value)
			{
				addCriterion ("ztc_apply_time >=" , value , "ztcApplyTime");
				return (Criteria) this;
			}


		public Criteria andZtcApplyTimeLessThan (	Date value)
			{
				addCriterion ("ztc_apply_time <" , value , "ztcApplyTime");
				return (Criteria) this;
			}


		public Criteria andZtcApplyTimeLessThanOrEqualTo (	Date value)
			{
				addCriterion ("ztc_apply_time <=" , value , "ztcApplyTime");
				return (Criteria) this;
			}


		public Criteria andZtcApplyTimeIn (	List <Date> values)
			{
				addCriterion ("ztc_apply_time in" , values , "ztcApplyTime");
				return (Criteria) this;
			}


		public Criteria andZtcApplyTimeNotIn (	List <Date> values)
			{
				addCriterion ("ztc_apply_time not in" , values , "ztcApplyTime");
				return (Criteria) this;
			}


		public Criteria andZtcApplyTimeBetween (Date value1 , Date value2)
			{
				addCriterion ("ztc_apply_time between" , value1 , value2 , "ztcApplyTime");
				return (Criteria) this;
			}


		public Criteria andZtcApplyTimeNotBetween (	Date value1 , Date value2)
			{
				addCriterion ("ztc_apply_time not between" , value1 , value2 , "ztcApplyTime");
				return (Criteria) this;
			}


		public Criteria andZtcBeginTimeIsNull ( )
			{
				addCriterion ("ztc_begin_time is null");
				return (Criteria) this;
			}


		public Criteria andZtcBeginTimeIsNotNull ( )
			{
				addCriterion ("ztc_begin_time is not null");
				return (Criteria) this;
			}


		public Criteria andZtcBeginTimeEqualTo (Date value)
			{
				addCriterionForJDBCDate ("ztc_begin_time =" , value , "ztcBeginTime");
				return (Criteria) this;
			}


		public Criteria andZtcBeginTimeNotEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("ztc_begin_time <>" , value , "ztcBeginTime");
				return (Criteria) this;
			}


		public Criteria andZtcBeginTimeGreaterThan (Date value)
			{
				addCriterionForJDBCDate ("ztc_begin_time >" , value , "ztcBeginTime");
				return (Criteria) this;
			}


		public Criteria andZtcBeginTimeGreaterThanOrEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("ztc_begin_time >=" , value , "ztcBeginTime");
				return (Criteria) this;
			}


		public Criteria andZtcBeginTimeLessThan (	Date value)
			{
				addCriterionForJDBCDate ("ztc_begin_time <" , value , "ztcBeginTime");
				return (Criteria) this;
			}


		public Criteria andZtcBeginTimeLessThanOrEqualTo (	Date value)
			{
				addCriterionForJDBCDate ("ztc_begin_time <=" , value , "ztcBeginTime");
				return (Criteria) this;
			}


		public Criteria andZtcBeginTimeIn (	List <Date> values)
			{
				addCriterionForJDBCDate ("ztc_begin_time in" , values , "ztcBeginTime");
				return (Criteria) this;
			}


		public Criteria andZtcBeginTimeNotIn (	List <Date> values)
			{
				addCriterionForJDBCDate ("ztc_begin_time not in" , values , "ztcBeginTime");
				return (Criteria) this;
			}


		public Criteria andZtcBeginTimeBetween (Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("ztc_begin_time between" , value1 , value2 , "ztcBeginTime");
				return (Criteria) this;
			}


		public Criteria andZtcBeginTimeNotBetween (	Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("ztc_begin_time not between" , value1 , value2 , "ztcBeginTime");
				return (Criteria) this;
			}


		public Criteria andZtcClickNumIsNull ( )
			{
				addCriterion ("ztc_click_num is null");
				return (Criteria) this;
			}


		public Criteria andZtcClickNumIsNotNull ( )
			{
				addCriterion ("ztc_click_num is not null");
				return (Criteria) this;
			}


		public Criteria andZtcClickNumEqualTo (	Integer value)
			{
				addCriterion ("ztc_click_num =" , value , "ztcClickNum");
				return (Criteria) this;
			}


		public Criteria andZtcClickNumNotEqualTo (	Integer value)
			{
				addCriterion ("ztc_click_num <>" , value , "ztcClickNum");
				return (Criteria) this;
			}


		public Criteria andZtcClickNumGreaterThan (	Integer value)
			{
				addCriterion ("ztc_click_num >" , value , "ztcClickNum");
				return (Criteria) this;
			}


		public Criteria andZtcClickNumGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("ztc_click_num >=" , value , "ztcClickNum");
				return (Criteria) this;
			}


		public Criteria andZtcClickNumLessThan (Integer value)
			{
				addCriterion ("ztc_click_num <" , value , "ztcClickNum");
				return (Criteria) this;
			}


		public Criteria andZtcClickNumLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("ztc_click_num <=" , value , "ztcClickNum");
				return (Criteria) this;
			}


		public Criteria andZtcClickNumIn (	List <Integer> values)
			{
				addCriterion ("ztc_click_num in" , values , "ztcClickNum");
				return (Criteria) this;
			}


		public Criteria andZtcClickNumNotIn (	List <Integer> values)
			{
				addCriterion ("ztc_click_num not in" , values , "ztcClickNum");
				return (Criteria) this;
			}


		public Criteria andZtcClickNumBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("ztc_click_num between" , value1 , value2 , "ztcClickNum");
				return (Criteria) this;
			}


		public Criteria andZtcClickNumNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("ztc_click_num not between" , value1 , value2 , "ztcClickNum");
				return (Criteria) this;
			}


		public Criteria andZtcDredgePriceIsNull ( )
			{
				addCriterion ("ztc_dredge_price is null");
				return (Criteria) this;
			}


		public Criteria andZtcDredgePriceIsNotNull ( )
			{
				addCriterion ("ztc_dredge_price is not null");
				return (Criteria) this;
			}


		public Criteria andZtcDredgePriceEqualTo (	Integer value)
			{
				addCriterion ("ztc_dredge_price =" , value , "ztcDredgePrice");
				return (Criteria) this;
			}


		public Criteria andZtcDredgePriceNotEqualTo (	Integer value)
			{
				addCriterion ("ztc_dredge_price <>" , value , "ztcDredgePrice");
				return (Criteria) this;
			}


		public Criteria andZtcDredgePriceGreaterThan (	Integer value)
			{
				addCriterion ("ztc_dredge_price >" , value , "ztcDredgePrice");
				return (Criteria) this;
			}


		public Criteria andZtcDredgePriceGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("ztc_dredge_price >=" , value , "ztcDredgePrice");
				return (Criteria) this;
			}


		public Criteria andZtcDredgePriceLessThan (	Integer value)
			{
				addCriterion ("ztc_dredge_price <" , value , "ztcDredgePrice");
				return (Criteria) this;
			}


		public Criteria andZtcDredgePriceLessThanOrEqualTo (Integer value)
			{
				addCriterion ("ztc_dredge_price <=" , value , "ztcDredgePrice");
				return (Criteria) this;
			}


		public Criteria andZtcDredgePriceIn (	List <Integer> values)
			{
				addCriterion ("ztc_dredge_price in" , values , "ztcDredgePrice");
				return (Criteria) this;
			}


		public Criteria andZtcDredgePriceNotIn (List <Integer> values)
			{
				addCriterion ("ztc_dredge_price not in" , values , "ztcDredgePrice");
				return (Criteria) this;
			}


		public Criteria andZtcDredgePriceBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("ztc_dredge_price between" , value1 , value2 , "ztcDredgePrice");
				return (Criteria) this;
			}


		public Criteria andZtcDredgePriceNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("ztc_dredge_price not between" , value1 , value2 , "ztcDredgePrice");
				return (Criteria) this;
			}


		public Criteria andZtcGoldIsNull ( )
			{
				addCriterion ("ztc_gold is null");
				return (Criteria) this;
			}


		public Criteria andZtcGoldIsNotNull ( )
			{
				addCriterion ("ztc_gold is not null");
				return (Criteria) this;
			}


		public Criteria andZtcGoldEqualTo (	Integer value)
			{
				addCriterion ("ztc_gold =" , value , "ztcGold");
				return (Criteria) this;
			}


		public Criteria andZtcGoldNotEqualTo (	Integer value)
			{
				addCriterion ("ztc_gold <>" , value , "ztcGold");
				return (Criteria) this;
			}


		public Criteria andZtcGoldGreaterThan (	Integer value)
			{
				addCriterion ("ztc_gold >" , value , "ztcGold");
				return (Criteria) this;
			}


		public Criteria andZtcGoldGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("ztc_gold >=" , value , "ztcGold");
				return (Criteria) this;
			}


		public Criteria andZtcGoldLessThan (Integer value)
			{
				addCriterion ("ztc_gold <" , value , "ztcGold");
				return (Criteria) this;
			}


		public Criteria andZtcGoldLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("ztc_gold <=" , value , "ztcGold");
				return (Criteria) this;
			}


		public Criteria andZtcGoldIn (	List <Integer> values)
			{
				addCriterion ("ztc_gold in" , values , "ztcGold");
				return (Criteria) this;
			}


		public Criteria andZtcGoldNotIn (	List <Integer> values)
			{
				addCriterion ("ztc_gold not in" , values , "ztcGold");
				return (Criteria) this;
			}


		public Criteria andZtcGoldBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("ztc_gold between" , value1 , value2 , "ztcGold");
				return (Criteria) this;
			}


		public Criteria andZtcGoldNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("ztc_gold not between" , value1 , value2 , "ztcGold");
				return (Criteria) this;
			}


		public Criteria andZtcPayStatusIsNull ( )
			{
				addCriterion ("ztc_pay_status is null");
				return (Criteria) this;
			}


		public Criteria andZtcPayStatusIsNotNull ( )
			{
				addCriterion ("ztc_pay_status is not null");
				return (Criteria) this;
			}


		public Criteria andZtcPayStatusEqualTo (Integer value)
			{
				addCriterion ("ztc_pay_status =" , value , "ztcPayStatus");
				return (Criteria) this;
			}


		public Criteria andZtcPayStatusNotEqualTo (	Integer value)
			{
				addCriterion ("ztc_pay_status <>" , value , "ztcPayStatus");
				return (Criteria) this;
			}


		public Criteria andZtcPayStatusGreaterThan (Integer value)
			{
				addCriterion ("ztc_pay_status >" , value , "ztcPayStatus");
				return (Criteria) this;
			}


		public Criteria andZtcPayStatusGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("ztc_pay_status >=" , value , "ztcPayStatus");
				return (Criteria) this;
			}


		public Criteria andZtcPayStatusLessThan (	Integer value)
			{
				addCriterion ("ztc_pay_status <" , value , "ztcPayStatus");
				return (Criteria) this;
			}


		public Criteria andZtcPayStatusLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("ztc_pay_status <=" , value , "ztcPayStatus");
				return (Criteria) this;
			}


		public Criteria andZtcPayStatusIn (	List <Integer> values)
			{
				addCriterion ("ztc_pay_status in" , values , "ztcPayStatus");
				return (Criteria) this;
			}


		public Criteria andZtcPayStatusNotIn (	List <Integer> values)
			{
				addCriterion ("ztc_pay_status not in" , values , "ztcPayStatus");
				return (Criteria) this;
			}


		public Criteria andZtcPayStatusBetween (Integer value1 , Integer value2)
			{
				addCriterion ("ztc_pay_status between" , value1 , value2 , "ztcPayStatus");
				return (Criteria) this;
			}


		public Criteria andZtcPayStatusNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("ztc_pay_status not between" , value1 , value2 , "ztcPayStatus");
				return (Criteria) this;
			}


		public Criteria andZtcPriceIsNull ( )
			{
				addCriterion ("ztc_price is null");
				return (Criteria) this;
			}


		public Criteria andZtcPriceIsNotNull ( )
			{
				addCriterion ("ztc_price is not null");
				return (Criteria) this;
			}


		public Criteria andZtcPriceEqualTo (Integer value)
			{
				addCriterion ("ztc_price =" , value , "ztcPrice");
				return (Criteria) this;
			}


		public Criteria andZtcPriceNotEqualTo (	Integer value)
			{
				addCriterion ("ztc_price <>" , value , "ztcPrice");
				return (Criteria) this;
			}


		public Criteria andZtcPriceGreaterThan (Integer value)
			{
				addCriterion ("ztc_price >" , value , "ztcPrice");
				return (Criteria) this;
			}


		public Criteria andZtcPriceGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("ztc_price >=" , value , "ztcPrice");
				return (Criteria) this;
			}


		public Criteria andZtcPriceLessThan (	Integer value)
			{
				addCriterion ("ztc_price <" , value , "ztcPrice");
				return (Criteria) this;
			}


		public Criteria andZtcPriceLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("ztc_price <=" , value , "ztcPrice");
				return (Criteria) this;
			}


		public Criteria andZtcPriceIn (	List <Integer> values)
			{
				addCriterion ("ztc_price in" , values , "ztcPrice");
				return (Criteria) this;
			}


		public Criteria andZtcPriceNotIn (	List <Integer> values)
			{
				addCriterion ("ztc_price not in" , values , "ztcPrice");
				return (Criteria) this;
			}


		public Criteria andZtcPriceBetween (Integer value1 , Integer value2)
			{
				addCriterion ("ztc_price between" , value1 , value2 , "ztcPrice");
				return (Criteria) this;
			}


		public Criteria andZtcPriceNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("ztc_price not between" , value1 , value2 , "ztcPrice");
				return (Criteria) this;
			}


		public Criteria andZtcStatusIsNull ( )
			{
				addCriterion ("ztc_status is null");
				return (Criteria) this;
			}


		public Criteria andZtcStatusIsNotNull ( )
			{
				addCriterion ("ztc_status is not null");
				return (Criteria) this;
			}


		public Criteria andZtcStatusEqualTo (	Integer value)
			{
				addCriterion ("ztc_status =" , value , "ztcStatus");
				return (Criteria) this;
			}


		public Criteria andZtcStatusNotEqualTo (Integer value)
			{
				addCriterion ("ztc_status <>" , value , "ztcStatus");
				return (Criteria) this;
			}


		public Criteria andZtcStatusGreaterThan (	Integer value)
			{
				addCriterion ("ztc_status >" , value , "ztcStatus");
				return (Criteria) this;
			}


		public Criteria andZtcStatusGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("ztc_status >=" , value , "ztcStatus");
				return (Criteria) this;
			}


		public Criteria andZtcStatusLessThan (	Integer value)
			{
				addCriterion ("ztc_status <" , value , "ztcStatus");
				return (Criteria) this;
			}


		public Criteria andZtcStatusLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("ztc_status <=" , value , "ztcStatus");
				return (Criteria) this;
			}


		public Criteria andZtcStatusIn (List <Integer> values)
			{
				addCriterion ("ztc_status in" , values , "ztcStatus");
				return (Criteria) this;
			}


		public Criteria andZtcStatusNotIn (	List <Integer> values)
			{
				addCriterion ("ztc_status not in" , values , "ztcStatus");
				return (Criteria) this;
			}


		public Criteria andZtcStatusBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("ztc_status between" , value1 , value2 , "ztcStatus");
				return (Criteria) this;
			}


		public Criteria andZtcStatusNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("ztc_status not between" , value1 , value2 , "ztcStatus");
				return (Criteria) this;
			}


		public Criteria andGcIdIsNull ( )
			{
				addCriterion ("gc_id is null");
				return (Criteria) this;
			}


		public Criteria andGcIdIsNotNull ( )
			{
				addCriterion ("gc_id is not null");
				return (Criteria) this;
			}


		public Criteria andGcIdEqualTo (Long value)
			{
				addCriterion ("gc_id =" , value , "gcId");
				return (Criteria) this;
			}


		public Criteria andGcIdNotEqualTo (	Long value)
			{
				addCriterion ("gc_id <>" , value , "gcId");
				return (Criteria) this;
			}


		public Criteria andGcIdGreaterThan (Long value)
			{
				addCriterion ("gc_id >" , value , "gcId");
				return (Criteria) this;
			}


		public Criteria andGcIdGreaterThanOrEqualTo (	Long value)
			{
				addCriterion ("gc_id >=" , value , "gcId");
				return (Criteria) this;
			}


		public Criteria andGcIdLessThan (	Long value)
			{
				addCriterion ("gc_id <" , value , "gcId");
				return (Criteria) this;
			}


		public Criteria andGcIdLessThanOrEqualTo (	Long value)
			{
				addCriterion ("gc_id <=" , value , "gcId");
				return (Criteria) this;
			}


		public Criteria andGcIdIn (	List <Long> values)
			{
				addCriterion ("gc_id in" , values , "gcId");
				return (Criteria) this;
			}


		public Criteria andGcIdNotIn (	List <Long> values)
			{
				addCriterion ("gc_id not in" , values , "gcId");
				return (Criteria) this;
			}


		public Criteria andGcIdBetween (Long value1 , Long value2)
			{
				addCriterion ("gc_id between" , value1 , value2 , "gcId");
				return (Criteria) this;
			}


		public Criteria andGcIdNotBetween (	Long value1 , Long value2)
			{
				addCriterion ("gc_id not between" , value1 , value2 , "gcId");
				return (Criteria) this;
			}


		public Criteria andGoodsBrandIdIsNull ( )
			{
				addCriterion ("goods_brand_id is null");
				return (Criteria) this;
			}


		public Criteria andGoodsBrandIdIsNotNull ( )
			{
				addCriterion ("goods_brand_id is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsBrandIdEqualTo (Long value)
			{
				addCriterion ("goods_brand_id =" , value , "goodsBrandId");
				return (Criteria) this;
			}


		public Criteria andGoodsBrandIdNotEqualTo (	Long value)
			{
				addCriterion ("goods_brand_id <>" , value , "goodsBrandId");
				return (Criteria) this;
			}


		public Criteria andGoodsBrandIdGreaterThan (Long value)
			{
				addCriterion ("goods_brand_id >" , value , "goodsBrandId");
				return (Criteria) this;
			}


		public Criteria andGoodsBrandIdGreaterThanOrEqualTo (	Long value)
			{
				addCriterion ("goods_brand_id >=" , value , "goodsBrandId");
				return (Criteria) this;
			}


		public Criteria andGoodsBrandIdLessThan (	Long value)
			{
				addCriterion ("goods_brand_id <" , value , "goodsBrandId");
				return (Criteria) this;
			}


		public Criteria andGoodsBrandIdLessThanOrEqualTo (	Long value)
			{
				addCriterion ("goods_brand_id <=" , value , "goodsBrandId");
				return (Criteria) this;
			}


		public Criteria andGoodsBrandIdIn (	List <Long> values)
			{
				addCriterion ("goods_brand_id in" , values , "goodsBrandId");
				return (Criteria) this;
			}


		public Criteria andGoodsBrandIdNotIn (	List <Long> values)
			{
				addCriterion ("goods_brand_id not in" , values , "goodsBrandId");
				return (Criteria) this;
			}


		public Criteria andGoodsBrandIdBetween (Long value1 , Long value2)
			{
				addCriterion ("goods_brand_id between" , value1 , value2 , "goodsBrandId");
				return (Criteria) this;
			}


		public Criteria andGoodsBrandIdNotBetween (	Long value1 , Long value2)
			{
				addCriterion ("goods_brand_id not between" , value1 , value2 , "goodsBrandId");
				return (Criteria) this;
			}


		public Criteria andGoodsMainPhotoIdIsNull ( )
			{
				addCriterion ("goods_main_photo_id is null");
				return (Criteria) this;
			}


		public Criteria andGoodsMainPhotoIdIsNotNull ( )
			{
				addCriterion ("goods_main_photo_id is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsMainPhotoIdEqualTo (Long value)
			{
				addCriterion ("goods_main_photo_id =" , value , "goodsMainPhotoId");
				return (Criteria) this;
			}


		public Criteria andGoodsMainPhotoIdNotEqualTo (	Long value)
			{
				addCriterion ("goods_main_photo_id <>" , value , "goodsMainPhotoId");
				return (Criteria) this;
			}


		public Criteria andGoodsMainPhotoIdGreaterThan (Long value)
			{
				addCriterion ("goods_main_photo_id >" , value , "goodsMainPhotoId");
				return (Criteria) this;
			}


		public Criteria andGoodsMainPhotoIdGreaterThanOrEqualTo (	Long value)
			{
				addCriterion ("goods_main_photo_id >=" , value , "goodsMainPhotoId");
				return (Criteria) this;
			}


		public Criteria andGoodsMainPhotoIdLessThan (	Long value)
			{
				addCriterion ("goods_main_photo_id <" , value , "goodsMainPhotoId");
				return (Criteria) this;
			}


		public Criteria andGoodsMainPhotoIdLessThanOrEqualTo (	Long value)
			{
				addCriterion ("goods_main_photo_id <=" , value , "goodsMainPhotoId");
				return (Criteria) this;
			}


		public Criteria andGoodsMainPhotoIdIn (	List <Long> values)
			{
				addCriterion ("goods_main_photo_id in" , values , "goodsMainPhotoId");
				return (Criteria) this;
			}


		public Criteria andGoodsMainPhotoIdNotIn (	List <Long> values)
			{
				addCriterion ("goods_main_photo_id not in" , values , "goodsMainPhotoId");
				return (Criteria) this;
			}


		public Criteria andGoodsMainPhotoIdBetween (Long value1 , Long value2)
			{
				addCriterion ("goods_main_photo_id between" , value1 , value2 , "goodsMainPhotoId");
				return (Criteria) this;
			}


		public Criteria andGoodsMainPhotoIdNotBetween (	Long value1 , Long value2)
			{
				addCriterion ("goods_main_photo_id not between" , value1 , value2 , "goodsMainPhotoId");
				return (Criteria) this;
			}


		public Criteria andGoodsStoreIdIsNull ( )
			{
				addCriterion ("goods_store_id is null");
				return (Criteria) this;
			}


		public Criteria andGoodsStoreIdIsNotNull ( )
			{
				addCriterion ("goods_store_id is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsStoreIdEqualTo (Long value)
			{
				addCriterion ("goods_store_id =" , value , "goodsStoreId");
				return (Criteria) this;
			}


		public Criteria andGoodsStoreIdNotEqualTo (	Long value)
			{
				addCriterion ("goods_store_id <>" , value , "goodsStoreId");
				return (Criteria) this;
			}


		public Criteria andGoodsStoreIdGreaterThan (Long value)
			{
				addCriterion ("goods_store_id >" , value , "goodsStoreId");
				return (Criteria) this;
			}


		public Criteria andGoodsStoreIdGreaterThanOrEqualTo (	Long value)
			{
				addCriterion ("goods_store_id >=" , value , "goodsStoreId");
				return (Criteria) this;
			}


		public Criteria andGoodsStoreIdLessThan (	Long value)
			{
				addCriterion ("goods_store_id <" , value , "goodsStoreId");
				return (Criteria) this;
			}


		public Criteria andGoodsStoreIdLessThanOrEqualTo (	Long value)
			{
				addCriterion ("goods_store_id <=" , value , "goodsStoreId");
				return (Criteria) this;
			}


		public Criteria andGoodsStoreIdIn (	List <Long> values)
			{
				addCriterion ("goods_store_id in" , values , "goodsStoreId");
				return (Criteria) this;
			}


		public Criteria andGoodsStoreIdNotIn (	List <Long> values)
			{
				addCriterion ("goods_store_id not in" , values , "goodsStoreId");
				return (Criteria) this;
			}


		public Criteria andGoodsStoreIdBetween (Long value1 , Long value2)
			{
				addCriterion ("goods_store_id between" , value1 , value2 , "goodsStoreId");
				return (Criteria) this;
			}


		public Criteria andGoodsStoreIdNotBetween (	Long value1 , Long value2)
			{
				addCriterion ("goods_store_id not between" , value1 , value2 , "goodsStoreId");
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


		public Criteria andGroupIdEqualTo (	Long value)
			{
				addCriterion ("group_id =" , value , "groupId");
				return (Criteria) this;
			}


		public Criteria andGroupIdNotEqualTo (	Long value)
			{
				addCriterion ("group_id <>" , value , "groupId");
				return (Criteria) this;
			}


		public Criteria andGroupIdGreaterThan (	Long value)
			{
				addCriterion ("group_id >" , value , "groupId");
				return (Criteria) this;
			}


		public Criteria andGroupIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("group_id >=" , value , "groupId");
				return (Criteria) this;
			}


		public Criteria andGroupIdLessThan (Long value)
			{
				addCriterion ("group_id <" , value , "groupId");
				return (Criteria) this;
			}


		public Criteria andGroupIdLessThanOrEqualTo (	Long value)
			{
				addCriterion ("group_id <=" , value , "groupId");
				return (Criteria) this;
			}


		public Criteria andGroupIdIn (	List <Long> values)
			{
				addCriterion ("group_id in" , values , "groupId");
				return (Criteria) this;
			}


		public Criteria andGroupIdNotIn (	List <Long> values)
			{
				addCriterion ("group_id not in" , values , "groupId");
				return (Criteria) this;
			}


		public Criteria andGroupIdBetween (	Long value1 , Long value2)
			{
				addCriterion ("group_id between" , value1 , value2 , "groupId");
				return (Criteria) this;
			}


		public Criteria andGroupIdNotBetween (	Long value1 , Long value2)
			{
				addCriterion ("group_id not between" , value1 , value2 , "groupId");
				return (Criteria) this;
			}


		public Criteria andTransportIdIsNull ( )
			{
				addCriterion ("transport_id is null");
				return (Criteria) this;
			}


		public Criteria andTransportIdIsNotNull ( )
			{
				addCriterion ("transport_id is not null");
				return (Criteria) this;
			}


		public Criteria andTransportIdEqualTo (	Long value)
			{
				addCriterion ("transport_id =" , value , "transportId");
				return (Criteria) this;
			}


		public Criteria andTransportIdNotEqualTo (	Long value)
			{
				addCriterion ("transport_id <>" , value , "transportId");
				return (Criteria) this;
			}


		public Criteria andTransportIdGreaterThan (	Long value)
			{
				addCriterion ("transport_id >" , value , "transportId");
				return (Criteria) this;
			}


		public Criteria andTransportIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("transport_id >=" , value , "transportId");
				return (Criteria) this;
			}


		public Criteria andTransportIdLessThan (Long value)
			{
				addCriterion ("transport_id <" , value , "transportId");
				return (Criteria) this;
			}


		public Criteria andTransportIdLessThanOrEqualTo (	Long value)
			{
				addCriterion ("transport_id <=" , value , "transportId");
				return (Criteria) this;
			}


		public Criteria andTransportIdIn (	List <Long> values)
			{
				addCriterion ("transport_id in" , values , "transportId");
				return (Criteria) this;
			}


		public Criteria andTransportIdNotIn (	List <Long> values)
			{
				addCriterion ("transport_id not in" , values , "transportId");
				return (Criteria) this;
			}


		public Criteria andTransportIdBetween (	Long value1 , Long value2)
			{
				addCriterion ("transport_id between" , value1 , value2 , "transportId");
				return (Criteria) this;
			}


		public Criteria andTransportIdNotBetween (	Long value1 , Long value2)
			{
				addCriterion ("transport_id not between" , value1 , value2 , "transportId");
				return (Criteria) this;
			}


		public Criteria andZtcAdminIdIsNull ( )
			{
				addCriterion ("ztc_admin_id is null");
				return (Criteria) this;
			}


		public Criteria andZtcAdminIdIsNotNull ( )
			{
				addCriterion ("ztc_admin_id is not null");
				return (Criteria) this;
			}


		public Criteria andZtcAdminIdEqualTo (	Long value)
			{
				addCriterion ("ztc_admin_id =" , value , "ztcAdminId");
				return (Criteria) this;
			}


		public Criteria andZtcAdminIdNotEqualTo (	Long value)
			{
				addCriterion ("ztc_admin_id <>" , value , "ztcAdminId");
				return (Criteria) this;
			}


		public Criteria andZtcAdminIdGreaterThan (	Long value)
			{
				addCriterion ("ztc_admin_id >" , value , "ztcAdminId");
				return (Criteria) this;
			}


		public Criteria andZtcAdminIdGreaterThanOrEqualTo (	Long value)
			{
				addCriterion ("ztc_admin_id >=" , value , "ztcAdminId");
				return (Criteria) this;
			}


		public Criteria andZtcAdminIdLessThan (	Long value)
			{
				addCriterion ("ztc_admin_id <" , value , "ztcAdminId");
				return (Criteria) this;
			}


		public Criteria andZtcAdminIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("ztc_admin_id <=" , value , "ztcAdminId");
				return (Criteria) this;
			}


		public Criteria andZtcAdminIdIn (	List <Long> values)
			{
				addCriterion ("ztc_admin_id in" , values , "ztcAdminId");
				return (Criteria) this;
			}


		public Criteria andZtcAdminIdNotIn (List <Long> values)
			{
				addCriterion ("ztc_admin_id not in" , values , "ztcAdminId");
				return (Criteria) this;
			}


		public Criteria andZtcAdminIdBetween (	Long value1 , Long value2)
			{
				addCriterion ("ztc_admin_id between" , value1 , value2 , "ztcAdminId");
				return (Criteria) this;
			}


		public Criteria andZtcAdminIdNotBetween (	Long value1 , Long value2)
			{
				addCriterion ("ztc_admin_id not between" , value1 , value2 , "ztcAdminId");
				return (Criteria) this;
			}


		public Criteria andSalespromotionIsNull ( )
			{
				addCriterion ("salesPromotion is null");
				return (Criteria) this;
			}


		public Criteria andSalespromotionIsNotNull ( )
			{
				addCriterion ("salesPromotion is not null");
				return (Criteria) this;
			}


		public Criteria andSalespromotionEqualTo (	String value)
			{
				addCriterion ("salesPromotion =" , value , "salespromotion");
				return (Criteria) this;
			}


		public Criteria andSalespromotionNotEqualTo (	String value)
			{
				addCriterion ("salesPromotion <>" , value , "salespromotion");
				return (Criteria) this;
			}


		public Criteria andSalespromotionGreaterThan (	String value)
			{
				addCriterion ("salesPromotion >" , value , "salespromotion");
				return (Criteria) this;
			}


		public Criteria andSalespromotionGreaterThanOrEqualTo (	String value)
			{
				addCriterion ("salesPromotion >=" , value , "salespromotion");
				return (Criteria) this;
			}


		public Criteria andSalespromotionLessThan (	String value)
			{
				addCriterion ("salesPromotion <" , value , "salespromotion");
				return (Criteria) this;
			}


		public Criteria andSalespromotionLessThanOrEqualTo (String value)
			{
				addCriterion ("salesPromotion <=" , value , "salespromotion");
				return (Criteria) this;
			}


		public Criteria andSalespromotionLike (	String value)
			{
				addCriterion ("salesPromotion like" , value , "salespromotion");
				return (Criteria) this;
			}


		public Criteria andSalespromotionNotLike (	String value)
			{
				addCriterion ("salesPromotion not like" , value , "salespromotion");
				return (Criteria) this;
			}


		public Criteria andSalespromotionIn (	List <String> values)
			{
				addCriterion ("salesPromotion in" , values , "salespromotion");
				return (Criteria) this;
			}


		public Criteria andSalespromotionNotIn (List <String> values)
			{
				addCriterion ("salesPromotion not in" , values , "salespromotion");
				return (Criteria) this;
			}


		public Criteria andSalespromotionBetween (	String value1 , String value2)
			{
				addCriterion ("salesPromotion between" , value1 , value2 , "salespromotion");
				return (Criteria) this;
			}


		public Criteria andSalespromotionNotBetween (	String value1 , String value2)
			{
				addCriterion ("salesPromotion not between" , value1 , value2 , "salespromotion");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoIsNull ( )
			{
				addCriterion ("goodsInfo is null");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoIsNotNull ( )
			{
				addCriterion ("goodsInfo is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoEqualTo (	String value)
			{
				addCriterion ("goodsInfo =" , value , "goodsinfo");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoNotEqualTo (String value)
			{
				addCriterion ("goodsInfo <>" , value , "goodsinfo");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoGreaterThan (	String value)
			{
				addCriterion ("goodsInfo >" , value , "goodsinfo");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoGreaterThanOrEqualTo (	String value)
			{
				addCriterion ("goodsInfo >=" , value , "goodsinfo");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoLessThan (	String value)
			{
				addCriterion ("goodsInfo <" , value , "goodsinfo");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoLessThanOrEqualTo (	String value)
			{
				addCriterion ("goodsInfo <=" , value , "goodsinfo");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoLike (	String value)
			{
				addCriterion ("goodsInfo like" , value , "goodsinfo");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoNotLike (	String value)
			{
				addCriterion ("goodsInfo not like" , value , "goodsinfo");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoIn (List <String> values)
			{
				addCriterion ("goodsInfo in" , values , "goodsinfo");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoNotIn (	List <String> values)
			{
				addCriterion ("goodsInfo not in" , values , "goodsinfo");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoBetween (	String value1 , String value2)
			{
				addCriterion ("goodsInfo between" , value1 , value2 , "goodsinfo");
				return (Criteria) this;
			}


		public Criteria andGoodsinfoNotBetween (String value1 , String value2)
			{
				addCriterion ("goodsInfo not between" , value1 , value2 , "goodsinfo");
				return (Criteria) this;
			}


		public Criteria andStoreNavIdIsNull ( )
			{
				addCriterion ("store_nav_id is null");
				return (Criteria) this;
			}


		public Criteria andStoreNavIdIsNotNull ( )
			{
				addCriterion ("store_nav_id is not null");
				return (Criteria) this;
			}


		public Criteria andStoreNavIdEqualTo (	Long value)
			{
				addCriterion ("store_nav_id =" , value , "storeNavId");
				return (Criteria) this;
			}


		public Criteria andStoreNavIdNotEqualTo (	Long value)
			{
				addCriterion ("store_nav_id <>" , value , "storeNavId");
				return (Criteria) this;
			}


		public Criteria andStoreNavIdGreaterThan (	Long value)
			{
				addCriterion ("store_nav_id >" , value , "storeNavId");
				return (Criteria) this;
			}


		public Criteria andStoreNavIdGreaterThanOrEqualTo (	Long value)
			{
				addCriterion ("store_nav_id >=" , value , "storeNavId");
				return (Criteria) this;
			}


		public Criteria andStoreNavIdLessThan (	Long value)
			{
				addCriterion ("store_nav_id <" , value , "storeNavId");
				return (Criteria) this;
			}


		public Criteria andStoreNavIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("store_nav_id <=" , value , "storeNavId");
				return (Criteria) this;
			}


		public Criteria andStoreNavIdIn (	List <Long> values)
			{
				addCriterion ("store_nav_id in" , values , "storeNavId");
				return (Criteria) this;
			}


		public Criteria andStoreNavIdNotIn (List <Long> values)
			{
				addCriterion ("store_nav_id not in" , values , "storeNavId");
				return (Criteria) this;
			}


		public Criteria andStoreNavIdBetween (	Long value1 , Long value2)
			{
				addCriterion ("store_nav_id between" , value1 , value2 , "storeNavId");
				return (Criteria) this;
			}


		public Criteria andStoreNavIdNotBetween (	Long value1 , Long value2)
			{
				addCriterion ("store_nav_id not between" , value1 , value2 , "storeNavId");
				return (Criteria) this;
			}


		public Criteria andPointIdIsNull ( )
			{
				addCriterion ("point_id is null");
				return (Criteria) this;
			}


		public Criteria andPointIdIsNotNull ( )
			{
				addCriterion ("point_id is not null");
				return (Criteria) this;
			}


		public Criteria andPointIdEqualTo (	Long value)
			{
				addCriterion ("point_id =" , value , "pointId");
				return (Criteria) this;
			}


		public Criteria andPointIdNotEqualTo (	Long value)
			{
				addCriterion ("point_id <>" , value , "pointId");
				return (Criteria) this;
			}


		public Criteria andPointIdGreaterThan (	Long value)
			{
				addCriterion ("point_id >" , value , "pointId");
				return (Criteria) this;
			}


		public Criteria andPointIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("point_id >=" , value , "pointId");
				return (Criteria) this;
			}


		public Criteria andPointIdLessThan (Long value)
			{
				addCriterion ("point_id <" , value , "pointId");
				return (Criteria) this;
			}


		public Criteria andPointIdLessThanOrEqualTo (	Long value)
			{
				addCriterion ("point_id <=" , value , "pointId");
				return (Criteria) this;
			}


		public Criteria andPointIdIn (	List <Long> values)
			{
				addCriterion ("point_id in" , values , "pointId");
				return (Criteria) this;
			}


		public Criteria andPointIdNotIn (	List <Long> values)
			{
				addCriterion ("point_id not in" , values , "pointId");
				return (Criteria) this;
			}


		public Criteria andPointIdBetween (	Long value1 , Long value2)
			{
				addCriterion ("point_id between" , value1 , value2 , "pointId");
				return (Criteria) this;
			}


		public Criteria andPointIdNotBetween (	Long value1 , Long value2)
			{
				addCriterion ("point_id not between" , value1 , value2 , "pointId");
				return (Criteria) this;
			}


		public Criteria andRefundServerTimeIsNull ( )
			{
				addCriterion ("refund_server_time is null");
				return (Criteria) this;
			}


		public Criteria andRefundServerTimeIsNotNull ( )
			{
				addCriterion ("refund_server_time is not null");
				return (Criteria) this;
			}


		public Criteria andRefundServerTimeEqualTo (Integer value)
			{
				addCriterion ("refund_server_time =" , value , "refundServerTime");
				return (Criteria) this;
			}


		public Criteria andRefundServerTimeNotEqualTo (	Integer value)
			{
				addCriterion ("refund_server_time <>" , value , "refundServerTime");
				return (Criteria) this;
			}


		public Criteria andRefundServerTimeGreaterThan (Integer value)
			{
				addCriterion ("refund_server_time >" , value , "refundServerTime");
				return (Criteria) this;
			}


		public Criteria andRefundServerTimeGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("refund_server_time >=" , value , "refundServerTime");
				return (Criteria) this;
			}


		public Criteria andRefundServerTimeLessThan (	Integer value)
			{
				addCriterion ("refund_server_time <" , value , "refundServerTime");
				return (Criteria) this;
			}


		public Criteria andRefundServerTimeLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("refund_server_time <=" , value , "refundServerTime");
				return (Criteria) this;
			}


		public Criteria andRefundServerTimeIn (	List <Integer> values)
			{
				addCriterion ("refund_server_time in" , values , "refundServerTime");
				return (Criteria) this;
			}


		public Criteria andRefundServerTimeNotIn (	List <Integer> values)
			{
				addCriterion ("refund_server_time not in" , values , "refundServerTime");
				return (Criteria) this;
			}


		public Criteria andRefundServerTimeBetween (Integer value1 , Integer value2)
			{
				addCriterion ("refund_server_time between" , value1 , value2 , "refundServerTime");
				return (Criteria) this;
			}


		public Criteria andRefundServerTimeNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("refund_server_time not between" , value1 , value2 , "refundServerTime");
				return (Criteria) this;
			}


		public Criteria andModuleIdIsNull ( )
			{
				addCriterion ("module_id is null");
				return (Criteria) this;
			}


		public Criteria andModuleIdIsNotNull ( )
			{
				addCriterion ("module_id is not null");
				return (Criteria) this;
			}


		public Criteria andModuleIdEqualTo (Integer value)
			{
				addCriterion ("module_id =" , value , "moduleId");
				return (Criteria) this;
			}


		public Criteria andModuleIdNotEqualTo (	Integer value)
			{
				addCriterion ("module_id <>" , value , "moduleId");
				return (Criteria) this;
			}


		public Criteria andModuleIdGreaterThan (Integer value)
			{
				addCriterion ("module_id >" , value , "moduleId");
				return (Criteria) this;
			}


		public Criteria andModuleIdGreaterThanOrEqualTo (	Integer value)
			{
				addCriterion ("module_id >=" , value , "moduleId");
				return (Criteria) this;
			}


		public Criteria andModuleIdLessThan (	Integer value)
			{
				addCriterion ("module_id <" , value , "moduleId");
				return (Criteria) this;
			}


		public Criteria andModuleIdLessThanOrEqualTo (	Integer value)
			{
				addCriterion ("module_id <=" , value , "moduleId");
				return (Criteria) this;
			}


		public Criteria andModuleIdIn (	List <Integer> values)
			{
				addCriterion ("module_id in" , values , "moduleId");
				return (Criteria) this;
			}


		public Criteria andModuleIdNotIn (	List <Integer> values)
			{
				addCriterion ("module_id not in" , values , "moduleId");
				return (Criteria) this;
			}


		public Criteria andModuleIdBetween (Integer value1 , Integer value2)
			{
				addCriterion ("module_id between" , value1 , value2 , "moduleId");
				return (Criteria) this;
			}


		public Criteria andModuleIdNotBetween (	Integer value1 , Integer value2)
			{
				addCriterion ("module_id not between" , value1 , value2 , "moduleId");
				return (Criteria) this;
			}


		public Criteria andGoodsRateIsNull ( )
			{
				addCriterion ("goods_rate is null");
				return (Criteria) this;
			}


		public Criteria andGoodsRateIsNotNull ( )
			{
				addCriterion ("goods_rate is not null");
				return (Criteria) this;
			}


		public Criteria andGoodsRateEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_rate =" , value , "goodsRate");
				return (Criteria) this;
			}


		public Criteria andGoodsRateNotEqualTo (BigDecimal value)
			{
				addCriterion ("goods_rate <>" , value , "goodsRate");
				return (Criteria) this;
			}


		public Criteria andGoodsRateGreaterThan (	BigDecimal value)
			{
				addCriterion ("goods_rate >" , value , "goodsRate");
				return (Criteria) this;
			}


		public Criteria andGoodsRateGreaterThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_rate >=" , value , "goodsRate");
				return (Criteria) this;
			}


		public Criteria andGoodsRateLessThan (	BigDecimal value)
			{
				addCriterion ("goods_rate <" , value , "goodsRate");
				return (Criteria) this;
			}


		public Criteria andGoodsRateLessThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("goods_rate <=" , value , "goodsRate");
				return (Criteria) this;
			}


		public Criteria andGoodsRateIn (List <BigDecimal> values)
			{
				addCriterion ("goods_rate in" , values , "goodsRate");
				return (Criteria) this;
			}


		public Criteria andGoodsRateNotIn (	List <BigDecimal> values)
			{
				addCriterion ("goods_rate not in" , values , "goodsRate");
				return (Criteria) this;
			}


		public Criteria andGoodsRateBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("goods_rate between" , value1 , value2 , "goodsRate");
				return (Criteria) this;
			}


		public Criteria andGoodsRateNotBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("goods_rate not between" , value1 , value2 , "goodsRate");
				return (Criteria) this;
			}


		public Criteria andAcceptBeanIsNull ( )
			{
				addCriterion ("accept_bean is null");
				return (Criteria) this;
			}


		public Criteria andAcceptBeanIsNotNull ( )
			{
				addCriterion ("accept_bean is not null");
				return (Criteria) this;
			}


		public Criteria andAcceptBeanEqualTo (	Boolean value)
			{
				addCriterion ("accept_bean =" , value , "acceptBean");
				return (Criteria) this;
			}


		public Criteria andAcceptBeanNotEqualTo (	Boolean value)
			{
				addCriterion ("accept_bean <>" , value , "acceptBean");
				return (Criteria) this;
			}


		public Criteria andAcceptBeanGreaterThan (	Boolean value)
			{
				addCriterion ("accept_bean >" , value , "acceptBean");
				return (Criteria) this;
			}


		public Criteria andAcceptBeanGreaterThanOrEqualTo (	Boolean value)
			{
				addCriterion ("accept_bean >=" , value , "acceptBean");
				return (Criteria) this;
			}


		public Criteria andAcceptBeanLessThan (	Boolean value)
			{
				addCriterion ("accept_bean <" , value , "acceptBean");
				return (Criteria) this;
			}


		public Criteria andAcceptBeanLessThanOrEqualTo (Boolean value)
			{
				addCriterion ("accept_bean <=" , value , "acceptBean");
				return (Criteria) this;
			}


		public Criteria andAcceptBeanIn (	List <Boolean> values)
			{
				addCriterion ("accept_bean in" , values , "acceptBean");
				return (Criteria) this;
			}


		public Criteria andAcceptBeanNotIn (List <Boolean> values)
			{
				addCriterion ("accept_bean not in" , values , "acceptBean");
				return (Criteria) this;
			}


		public Criteria andAcceptBeanBetween (	Boolean value1 , Boolean value2)
			{
				addCriterion ("accept_bean between" , value1 , value2 , "acceptBean");
				return (Criteria) this;
			}


		public Criteria andAcceptBeanNotBetween (	Boolean value1 , Boolean value2)
			{
				addCriterion ("accept_bean not between" , value1 , value2 , "acceptBean");
				return (Criteria) this;
			}


		public Criteria andBeanRateIsNull ( )
			{
				addCriterion ("bean_rate is null");
				return (Criteria) this;
			}


		public Criteria andBeanRateIsNotNull ( )
			{
				addCriterion ("bean_rate is not null");
				return (Criteria) this;
			}


		public Criteria andBeanRateEqualTo (BigDecimal value)
			{
				addCriterion ("bean_rate =" , value , "beanRate");
				return (Criteria) this;
			}


		public Criteria andBeanRateNotEqualTo (	BigDecimal value)
			{
				addCriterion ("bean_rate <>" , value , "beanRate");
				return (Criteria) this;
			}


		public Criteria andBeanRateGreaterThan (BigDecimal value)
			{
				addCriterion ("bean_rate >" , value , "beanRate");
				return (Criteria) this;
			}


		public Criteria andBeanRateGreaterThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("bean_rate >=" , value , "beanRate");
				return (Criteria) this;
			}


		public Criteria andBeanRateLessThan (	BigDecimal value)
			{
				addCriterion ("bean_rate <" , value , "beanRate");
				return (Criteria) this;
			}


		public Criteria andBeanRateLessThanOrEqualTo (	BigDecimal value)
			{
				addCriterion ("bean_rate <=" , value , "beanRate");
				return (Criteria) this;
			}


		public Criteria andBeanRateIn (	List <BigDecimal> values)
			{
				addCriterion ("bean_rate in" , values , "beanRate");
				return (Criteria) this;
			}


		public Criteria andBeanRateNotIn (	List <BigDecimal> values)
			{
				addCriterion ("bean_rate not in" , values , "beanRate");
				return (Criteria) this;
			}


		public Criteria andBeanRateBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("bean_rate between" , value1 , value2 , "beanRate");
				return (Criteria) this;
			}


		public Criteria andBeanRateNotBetween (	BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("bean_rate not between" , value1 , value2 , "beanRate");
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