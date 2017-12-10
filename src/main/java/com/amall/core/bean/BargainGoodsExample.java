package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.amall.core.web.BaseQuery;

public class BargainGoodsExample extends BaseQuery
{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List <Criteria> oredCriteria;

	public BargainGoodsExample ( )
	{
		oredCriteria = new ArrayList <Criteria> ();
	}

	public void setOrderByClause (String orderByClause)
		{
			this.orderByClause = orderByClause;
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

		protected void addCriterionForJDBCDate (String condition , Date value , String property)
			{
				if (value == null)
				{
					throw new RuntimeException ("Value for " + property + " cannot be null");
				}
				addCriterion (condition , new java.util.Date (value.getTime ()) , property);
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

		public Criteria andIdEqualTo (Long value)
			{
				addCriterion ("id =" , value , "id");
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

		public Criteria andBgPriceIsNull ( )
			{
				addCriterion ("bg_price is null");
				return (Criteria) this;
			}

		public Criteria andBgPriceIsNotNull ( )
			{
				addCriterion ("bg_price is not null");
				return (Criteria) this;
			}

		public Criteria andBgPriceEqualTo (BigDecimal value)
			{
				addCriterion ("bg_price =" , value , "bgPrice");
				return (Criteria) this;
			}

		public Criteria andBgPriceNotEqualTo (BigDecimal value)
			{
				addCriterion ("bg_price <>" , value , "bgPrice");
				return (Criteria) this;
			}

		public Criteria andBgPriceGreaterThan (BigDecimal value)
			{
				addCriterion ("bg_price >" , value , "bgPrice");
				return (Criteria) this;
			}

		public Criteria andBgPriceGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("bg_price >=" , value , "bgPrice");
				return (Criteria) this;
			}

		public Criteria andBgPriceLessThan (BigDecimal value)
			{
				addCriterion ("bg_price <" , value , "bgPrice");
				return (Criteria) this;
			}

		public Criteria andBgPriceLessThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("bg_price <=" , value , "bgPrice");
				return (Criteria) this;
			}

		public Criteria andBgPriceIn (List <BigDecimal> values)
			{
				addCriterion ("bg_price in" , values , "bgPrice");
				return (Criteria) this;
			}

		public Criteria andBgPriceNotIn (List <BigDecimal> values)
			{
				addCriterion ("bg_price not in" , values , "bgPrice");
				return (Criteria) this;
			}

		public Criteria andBgPriceBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("bg_price between" , value1 , value2 , "bgPrice");
				return (Criteria) this;
			}

		public Criteria andBgPriceNotBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("bg_price not between" , value1 , value2 , "bgPrice");
				return (Criteria) this;
			}

		public Criteria andBgStatusIsNull ( )
			{
				addCriterion ("bg_status is null");
				return (Criteria) this;
			}

		public Criteria andBgStatusIsNotNull ( )
			{
				addCriterion ("bg_status is not null");
				return (Criteria) this;
			}

		public Criteria andBgStatusEqualTo (Integer value)
			{
				addCriterion ("bg_status =" , value , "bgStatus");
				return (Criteria) this;
			}

		public Criteria andBgStatusNotEqualTo (Integer value)
			{
				addCriterion ("bg_status <>" , value , "bgStatus");
				return (Criteria) this;
			}

		public Criteria andBgStatusGreaterThan (Integer value)
			{
				addCriterion ("bg_status >" , value , "bgStatus");
				return (Criteria) this;
			}

		public Criteria andBgStatusGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("bg_status >=" , value , "bgStatus");
				return (Criteria) this;
			}

		public Criteria andBgStatusLessThan (Integer value)
			{
				addCriterion ("bg_status <" , value , "bgStatus");
				return (Criteria) this;
			}

		public Criteria andBgStatusLessThanOrEqualTo (Integer value)
			{
				addCriterion ("bg_status <=" , value , "bgStatus");
				return (Criteria) this;
			}

		public Criteria andBgStatusIn (List <Integer> values)
			{
				addCriterion ("bg_status in" , values , "bgStatus");
				return (Criteria) this;
			}

		public Criteria andBgStatusNotIn (List <Integer> values)
			{
				addCriterion ("bg_status not in" , values , "bgStatus");
				return (Criteria) this;
			}

		public Criteria andBgStatusBetween (Integer value1 , Integer value2)
			{
				addCriterion ("bg_status between" , value1 , value2 , "bgStatus");
				return (Criteria) this;
			}

		public Criteria andBgStatusNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("bg_status not between" , value1 , value2 , "bgStatus");
				return (Criteria) this;
			}

		public Criteria andBgTimeIsNull ( )
			{
				addCriterion ("bg_time is null");
				return (Criteria) this;
			}

		public Criteria andBgTimeIsNotNull ( )
			{
				addCriterion ("bg_time is not null");
				return (Criteria) this;
			}

		public Criteria andBgTimeEqualTo (Date value)
			{
				addCriterionForJDBCDate ("bg_time =" , value , "bgTime");
				return (Criteria) this;
			}

		public Criteria andBgTimeNotEqualTo (Date value)
			{
				addCriterionForJDBCDate ("bg_time <>" , value , "bgTime");
				return (Criteria) this;
			}

		public Criteria andBgTimeGreaterThan (Date value)
			{
				addCriterionForJDBCDate ("bg_time >" , value , "bgTime");
				return (Criteria) this;
			}

		public Criteria andBgTimeGreaterThanOrEqualTo (Date value)
			{
				addCriterionForJDBCDate ("bg_time >=" , value , "bgTime");
				return (Criteria) this;
			}

		public Criteria andBgTimeLessThan (Date value)
			{
				addCriterionForJDBCDate ("bg_time <" , value , "bgTime");
				return (Criteria) this;
			}

		public Criteria andBgTimeLessThanOrEqualTo (Date value)
			{
				addCriterionForJDBCDate ("bg_time <=" , value , "bgTime");
				return (Criteria) this;
			}

		public Criteria andBgTimeIn (List <Date> values)
			{
				addCriterionForJDBCDate ("bg_time in" , values , "bgTime");
				return (Criteria) this;
			}

		public Criteria andBgTimeNotIn (List <Date> values)
			{
				addCriterionForJDBCDate ("bg_time not in" , values , "bgTime");
				return (Criteria) this;
			}

		public Criteria andBgTimeBetween (Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("bg_time between" , value1 , value2 , "bgTime");
				return (Criteria) this;
			}

		public Criteria andBgTimeNotBetween (Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("bg_time not between" , value1 , value2 , "bgTime");
				return (Criteria) this;
			}

		public Criteria andBgEndTimeIsNull ( )
			{
				addCriterion ("bg_end_time is null");
				return (Criteria) this;
			}

		public Criteria andBgEndTimeIsNotNull ( )
			{
				addCriterion ("bg_end_time is not null");
				return (Criteria) this;
			}

		public Criteria andBgEndTimeEqualTo (Date value)
			{
				addCriterionForJDBCDate ("bg_end_time =" , value , "bgEndTime");
				return (Criteria) this;
			}

		public Criteria andBgEndTimeNotEqualTo (Date value)
			{
				addCriterionForJDBCDate ("bg_end_time <>" , value , "bgEndTime");
				return (Criteria) this;
			}

		public Criteria andBgEndTimeGreaterThan (Date value)
			{
				addCriterionForJDBCDate ("bg_end_time >" , value , "bgEndTime");
				return (Criteria) this;
			}

		public Criteria andBgEndTimeGreaterThanOrEqualTo (Date value)
			{
				addCriterionForJDBCDate ("bg_end_time >=" , value , "bgEndTime");
				return (Criteria) this;
			}

		public Criteria andBgEndTimeLessThan (Date value)
			{
				addCriterionForJDBCDate ("bg_end_time <" , value , "bgEndTime");
				return (Criteria) this;
			}

		public Criteria andBgEndTimeLessThanOrEqualTo (Date value)
			{
				addCriterionForJDBCDate ("bg_end_time <=" , value , "bgEndTime");
				return (Criteria) this;
			}

		public Criteria andBgEndTimeIn (List <Date> values)
			{
				addCriterionForJDBCDate ("bg_end_time in" , values , "bgEndTime");
				return (Criteria) this;
			}

		public Criteria andBgEndTimeNotIn (List <Date> values)
			{
				addCriterionForJDBCDate ("bg_end_time not in" , values , "bgEndTime");
				return (Criteria) this;
			}

		public Criteria andBgEndTimeBetween (Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("bg_end_time between" , value1 , value2 , "bgEndTime");
				return (Criteria) this;
			}

		public Criteria andBgEndTimeNotBetween (Date value1 , Date value2)
			{
				addCriterionForJDBCDate ("bg_end_time not between" , value1 , value2 , "bgEndTime");
				return (Criteria) this;
			}

		public Criteria andBgAdminUserIdIsNull ( )
			{
				addCriterion ("bg_admin_user_id is null");
				return (Criteria) this;
			}

		public Criteria andBgAdminUserIdIsNotNull ( )
			{
				addCriterion ("bg_admin_user_id is not null");
				return (Criteria) this;
			}

		public Criteria andBgAdminUserIdEqualTo (Long value)
			{
				addCriterion ("bg_admin_user_id =" , value , "bgAdminUserId");
				return (Criteria) this;
			}

		public Criteria andBgAdminUserIdNotEqualTo (Long value)
			{
				addCriterion ("bg_admin_user_id <>" , value , "bgAdminUserId");
				return (Criteria) this;
			}

		public Criteria andBgAdminUserIdGreaterThan (Long value)
			{
				addCriterion ("bg_admin_user_id >" , value , "bgAdminUserId");
				return (Criteria) this;
			}

		public Criteria andBgAdminUserIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("bg_admin_user_id >=" , value , "bgAdminUserId");
				return (Criteria) this;
			}

		public Criteria andBgAdminUserIdLessThan (Long value)
			{
				addCriterion ("bg_admin_user_id <" , value , "bgAdminUserId");
				return (Criteria) this;
			}

		public Criteria andBgAdminUserIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("bg_admin_user_id <=" , value , "bgAdminUserId");
				return (Criteria) this;
			}

		public Criteria andBgAdminUserIdIn (List <Long> values)
			{
				addCriterion ("bg_admin_user_id in" , values , "bgAdminUserId");
				return (Criteria) this;
			}

		public Criteria andBgAdminUserIdNotIn (List <Long> values)
			{
				addCriterion ("bg_admin_user_id not in" , values , "bgAdminUserId");
				return (Criteria) this;
			}

		public Criteria andBgAdminUserIdBetween (Long value1 , Long value2)
			{
				addCriterion ("bg_admin_user_id between" , value1 , value2 , "bgAdminUserId");
				return (Criteria) this;
			}

		public Criteria andBgAdminUserIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("bg_admin_user_id not between" , value1 , value2 , "bgAdminUserId");
				return (Criteria) this;
			}

		public Criteria andBgGoodsIdIsNull ( )
			{
				addCriterion ("bg_goods_id is null");
				return (Criteria) this;
			}

		public Criteria andBgGoodsIdIsNotNull ( )
			{
				addCriterion ("bg_goods_id is not null");
				return (Criteria) this;
			}

		public Criteria andBgGoodsIdEqualTo (Long value)
			{
				addCriterion ("bg_goods_id =" , value , "bgGoodsId");
				return (Criteria) this;
			}

		public Criteria andBgGoodsIdNotEqualTo (Long value)
			{
				addCriterion ("bg_goods_id <>" , value , "bgGoodsId");
				return (Criteria) this;
			}

		public Criteria andBgGoodsIdGreaterThan (Long value)
			{
				addCriterion ("bg_goods_id >" , value , "bgGoodsId");
				return (Criteria) this;
			}

		public Criteria andBgGoodsIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("bg_goods_id >=" , value , "bgGoodsId");
				return (Criteria) this;
			}

		public Criteria andBgGoodsIdLessThan (Long value)
			{
				addCriterion ("bg_goods_id <" , value , "bgGoodsId");
				return (Criteria) this;
			}

		public Criteria andBgGoodsIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("bg_goods_id <=" , value , "bgGoodsId");
				return (Criteria) this;
			}

		public Criteria andBgGoodsIdIn (List <Long> values)
			{
				addCriterion ("bg_goods_id in" , values , "bgGoodsId");
				return (Criteria) this;
			}

		public Criteria andBgGoodsIdNotIn (List <Long> values)
			{
				addCriterion ("bg_goods_id not in" , values , "bgGoodsId");
				return (Criteria) this;
			}

		public Criteria andBgGoodsIdBetween (Long value1 , Long value2)
			{
				addCriterion ("bg_goods_id between" , value1 , value2 , "bgGoodsId");
				return (Criteria) this;
			}

		public Criteria andBgGoodsIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("bg_goods_id not between" , value1 , value2 , "bgGoodsId");
				return (Criteria) this;
			}

		public Criteria andBgCountIsNull ( )
			{
				addCriterion ("bg_count is null");
				return (Criteria) this;
			}

		public Criteria andBgCountIsNotNull ( )
			{
				addCriterion ("bg_count is not null");
				return (Criteria) this;
			}

		public Criteria andBgCountEqualTo (Integer value)
			{
				addCriterion ("bg_count =" , value , "bgCount");
				return (Criteria) this;
			}

		public Criteria andBgCountNotEqualTo (Integer value)
			{
				addCriterion ("bg_count <>" , value , "bgCount");
				return (Criteria) this;
			}

		public Criteria andBgCountGreaterThan (Integer value)
			{
				addCriterion ("bg_count >" , value , "bgCount");
				return (Criteria) this;
			}

		public Criteria andBgCountGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("bg_count >=" , value , "bgCount");
				return (Criteria) this;
			}

		public Criteria andBgCountLessThan (Integer value)
			{
				addCriterion ("bg_count <" , value , "bgCount");
				return (Criteria) this;
			}

		public Criteria andBgCountLessThanOrEqualTo (Integer value)
			{
				addCriterion ("bg_count <=" , value , "bgCount");
				return (Criteria) this;
			}

		public Criteria andBgCountIn (List <Integer> values)
			{
				addCriterion ("bg_count in" , values , "bgCount");
				return (Criteria) this;
			}

		public Criteria andBgCountNotIn (List <Integer> values)
			{
				addCriterion ("bg_count not in" , values , "bgCount");
				return (Criteria) this;
			}

		public Criteria andBgCountBetween (Integer value1 , Integer value2)
			{
				addCriterion ("bg_count between" , value1 , value2 , "bgCount");
				return (Criteria) this;
			}

		public Criteria andBgCountNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("bg_count not between" , value1 , value2 , "bgCount");
				return (Criteria) this;
			}

		public Criteria andBgRebateIsNull ( )
			{
				addCriterion ("bg_rebate is null");
				return (Criteria) this;
			}

		public Criteria andBgRebateIsNotNull ( )
			{
				addCriterion ("bg_rebate is not null");
				return (Criteria) this;
			}

		public Criteria andBgRebateEqualTo (BigDecimal value)
			{
				addCriterion ("bg_rebate =" , value , "bgRebate");
				return (Criteria) this;
			}

		public Criteria andBgRebateNotEqualTo (BigDecimal value)
			{
				addCriterion ("bg_rebate <>" , value , "bgRebate");
				return (Criteria) this;
			}

		public Criteria andBgRebateGreaterThan (BigDecimal value)
			{
				addCriterion ("bg_rebate >" , value , "bgRebate");
				return (Criteria) this;
			}

		public Criteria andBgRebateGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("bg_rebate >=" , value , "bgRebate");
				return (Criteria) this;
			}

		public Criteria andBgRebateLessThan (BigDecimal value)
			{
				addCriterion ("bg_rebate <" , value , "bgRebate");
				return (Criteria) this;
			}

		public Criteria andBgRebateLessThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("bg_rebate <=" , value , "bgRebate");
				return (Criteria) this;
			}

		public Criteria andBgRebateIn (List <BigDecimal> values)
			{
				addCriterion ("bg_rebate in" , values , "bgRebate");
				return (Criteria) this;
			}

		public Criteria andBgRebateNotIn (List <BigDecimal> values)
			{
				addCriterion ("bg_rebate not in" , values , "bgRebate");
				return (Criteria) this;
			}

		public Criteria andBgRebateBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("bg_rebate between" , value1 , value2 , "bgRebate");
				return (Criteria) this;
			}

		public Criteria andBgRebateNotBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("bg_rebate not between" , value1 , value2 , "bgRebate");
				return (Criteria) this;
			}

		public Criteria andAuditTimeIsNull ( )
			{
				addCriterion ("audit_time is null");
				return (Criteria) this;
			}

		public Criteria andAuditTimeIsNotNull ( )
			{
				addCriterion ("audit_time is not null");
				return (Criteria) this;
			}

		public Criteria andAuditTimeEqualTo (Date value)
			{
				addCriterion ("audit_time =" , value , "auditTime");
				return (Criteria) this;
			}

		public Criteria andAuditTimeNotEqualTo (Date value)
			{
				addCriterion ("audit_time <>" , value , "auditTime");
				return (Criteria) this;
			}

		public Criteria andAuditTimeGreaterThan (Date value)
			{
				addCriterion ("audit_time >" , value , "auditTime");
				return (Criteria) this;
			}

		public Criteria andAuditTimeGreaterThanOrEqualTo (Date value)
			{
				addCriterion ("audit_time >=" , value , "auditTime");
				return (Criteria) this;
			}

		public Criteria andAuditTimeLessThan (Date value)
			{
				addCriterion ("audit_time <" , value , "auditTime");
				return (Criteria) this;
			}

		public Criteria andAuditTimeLessThanOrEqualTo (Date value)
			{
				addCriterion ("audit_time <=" , value , "auditTime");
				return (Criteria) this;
			}

		public Criteria andAuditTimeIn (List <Date> values)
			{
				addCriterion ("audit_time in" , values , "auditTime");
				return (Criteria) this;
			}

		public Criteria andAuditTimeNotIn (List <Date> values)
			{
				addCriterion ("audit_time not in" , values , "auditTime");
				return (Criteria) this;
			}

		public Criteria andAuditTimeBetween (Date value1 , Date value2)
			{
				addCriterion ("audit_time between" , value1 , value2 , "auditTime");
				return (Criteria) this;
			}

		public Criteria andAuditTimeNotBetween (Date value1 , Date value2)
			{
				addCriterion ("audit_time not between" , value1 , value2 , "auditTime");
				return (Criteria) this;
			}

		public Criteria andMarkIsNull ( )
			{
				addCriterion ("mark is null");
				return (Criteria) this;
			}

		public Criteria andMarkIsNotNull ( )
			{
				addCriterion ("mark is not null");
				return (Criteria) this;
			}

		public Criteria andMarkEqualTo (Integer value)
			{
				addCriterion ("mark =" , value , "mark");
				return (Criteria) this;
			}

		public Criteria andMarkNotEqualTo (Integer value)
			{
				addCriterion ("mark <>" , value , "mark");
				return (Criteria) this;
			}

		public Criteria andMarkGreaterThan (Integer value)
			{
				addCriterion ("mark >" , value , "mark");
				return (Criteria) this;
			}

		public Criteria andMarkGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("mark >=" , value , "mark");
				return (Criteria) this;
			}

		public Criteria andMarkLessThan (Integer value)
			{
				addCriterion ("mark <" , value , "mark");
				return (Criteria) this;
			}

		public Criteria andMarkLessThanOrEqualTo (Integer value)
			{
				addCriterion ("mark <=" , value , "mark");
				return (Criteria) this;
			}

		public Criteria andMarkIn (List <Integer> values)
			{
				addCriterion ("mark in" , values , "mark");
				return (Criteria) this;
			}

		public Criteria andMarkNotIn (List <Integer> values)
			{
				addCriterion ("mark not in" , values , "mark");
				return (Criteria) this;
			}

		public Criteria andMarkBetween (Integer value1 , Integer value2)
			{
				addCriterion ("mark between" , value1 , value2 , "mark");
				return (Criteria) this;
			}

		public Criteria andMarkNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("mark not between" , value1 , value2 , "mark");
				return (Criteria) this;
			}

		public Criteria andBargainGoodsStatusIsNull ( )
			{
				addCriterion ("bargain_goods_status is null");
				return (Criteria) this;
			}

		public Criteria andBargainGoodsStatusIsNotNull ( )
			{
				addCriterion ("bargain_goods_status is not null");
				return (Criteria) this;
			}

		public Criteria andBargainGoodsStatusEqualTo (String value)
			{
				addCriterion ("bargain_goods_status =" , value , "bargainGoodsStatus");
				return (Criteria) this;
			}

		public Criteria andBargainGoodsStatusNotEqualTo (String value)
			{
				addCriterion ("bargain_goods_status <>" , value , "bargainGoodsStatus");
				return (Criteria) this;
			}

		public Criteria andBargainGoodsStatusGreaterThan (String value)
			{
				addCriterion ("bargain_goods_status >" , value , "bargainGoodsStatus");
				return (Criteria) this;
			}

		public Criteria andBargainGoodsStatusGreaterThanOrEqualTo (String value)
			{
				addCriterion ("bargain_goods_status >=" , value , "bargainGoodsStatus");
				return (Criteria) this;
			}

		public Criteria andBargainGoodsStatusLessThan (String value)
			{
				addCriterion ("bargain_goods_status <" , value , "bargainGoodsStatus");
				return (Criteria) this;
			}

		public Criteria andBargainGoodsStatusLessThanOrEqualTo (String value)
			{
				addCriterion ("bargain_goods_status <=" , value , "bargainGoodsStatus");
				return (Criteria) this;
			}

		public Criteria andBargainGoodsStatusIn (List <String> values)
			{
				addCriterion ("bargain_goods_status in" , values , "bargainGoodsStatus");
				return (Criteria) this;
			}

		public Criteria andBargainGoodsStatusNotIn (List <String> values)
			{
				addCriterion ("bargain_goods_status not in" , values , "bargainGoodsStatus");
				return (Criteria) this;
			}

		public Criteria andBargainGoodsStatusBetween (String value1 , String value2)
			{
				addCriterion ("bargain_goods_status between" , value1 , value2 , "bargainGoodsStatus");
				return (Criteria) this;
			}

		public Criteria andBargainGoodsStatusNotBetween (String value1 , String value2)
			{
				addCriterion ("bargain_goods_status not between" , value1 , value2 , "bargainGoodsStatus");
				return (Criteria) this;
			}

		public Criteria andCloseTimeIsNull ( )
			{
				addCriterion ("close_time is null");
				return (Criteria) this;
			}

		public Criteria andCloseTimeIsNotNull ( )
			{
				addCriterion ("close_time is not null");
				return (Criteria) this;
			}

		public Criteria andCloseTimeEqualTo (Date value)
			{
				addCriterion ("close_time =" , value , "closeTime");
				return (Criteria) this;
			}

		public Criteria andCloseTimeNotEqualTo (Date value)
			{
				addCriterion ("close_time <>" , value , "closeTime");
				return (Criteria) this;
			}

		public Criteria andCloseTimeGreaterThan (Date value)
			{
				addCriterion ("close_time >" , value , "closeTime");
				return (Criteria) this;
			}

		public Criteria andCloseTimeGreaterThanOrEqualTo (Date value)
			{
				addCriterion ("close_time >=" , value , "closeTime");
				return (Criteria) this;
			}

		public Criteria andCloseTimeLessThan (Date value)
			{
				addCriterion ("close_time <" , value , "closeTime");
				return (Criteria) this;
			}

		public Criteria andCloseTimeLessThanOrEqualTo (Date value)
			{
				addCriterion ("close_time <=" , value , "closeTime");
				return (Criteria) this;
			}

		public Criteria andCloseTimeIn (List <Date> values)
			{
				addCriterion ("close_time in" , values , "closeTime");
				return (Criteria) this;
			}

		public Criteria andCloseTimeNotIn (List <Date> values)
			{
				addCriterion ("close_time not in" , values , "closeTime");
				return (Criteria) this;
			}

		public Criteria andCloseTimeBetween (Date value1 , Date value2)
			{
				addCriterion ("close_time between" , value1 , value2 , "closeTime");
				return (Criteria) this;
			}

		public Criteria andCloseTimeNotBetween (Date value1 , Date value2)
			{
				addCriterion ("close_time not between" , value1 , value2 , "closeTime");
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