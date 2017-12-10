package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.amall.core.web.BaseQuery;

public class SellerAccountExample extends BaseQuery
{

	private static final long serialVersionUID = -6872285390685441389L;

	protected String orderByClause;

	protected boolean distinct;

	protected List <Criteria> oredCriteria;

	public SellerAccountExample ( )
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

		public Criteria andResourceIsNull ( )
			{
				addCriterion ("resource is null");
				return (Criteria) this;
			}

		public Criteria andResourceIsNotNull ( )
			{
				addCriterion ("resource is not null");
				return (Criteria) this;
			}

		public Criteria andResourceEqualTo (String value)
			{
				addCriterion ("resource =" , value , "resource");
				return (Criteria) this;
			}

		public Criteria andResourceNotEqualTo (String value)
			{
				addCriterion ("resource <>" , value , "resource");
				return (Criteria) this;
			}

		public Criteria andResourceGreaterThan (String value)
			{
				addCriterion ("resource >" , value , "resource");
				return (Criteria) this;
			}

		public Criteria andResourceGreaterThanOrEqualTo (String value)
			{
				addCriterion ("resource >=" , value , "resource");
				return (Criteria) this;
			}

		public Criteria andResourceLessThan (String value)
			{
				addCriterion ("resource <" , value , "resource");
				return (Criteria) this;
			}

		public Criteria andResourceLessThanOrEqualTo (String value)
			{
				addCriterion ("resource <=" , value , "resource");
				return (Criteria) this;
			}

		public Criteria andResourceLike (String value)
			{
				addCriterion ("resource like" , value , "resource");
				return (Criteria) this;
			}

		public Criteria andResourceNotLike (String value)
			{
				addCriterion ("resource not like" , value , "resource");
				return (Criteria) this;
			}

		public Criteria andResourceIn (List <String> values)
			{
				addCriterion ("resource in" , values , "resource");
				return (Criteria) this;
			}

		public Criteria andResourceNotIn (List <String> values)
			{
				addCriterion ("resource not in" , values , "resource");
				return (Criteria) this;
			}

		public Criteria andResourceBetween (String value1 , String value2)
			{
				addCriterion ("resource between" , value1 , value2 , "resource");
				return (Criteria) this;
			}

		public Criteria andResourceNotBetween (String value1 , String value2)
			{
				addCriterion ("resource not between" , value1 , value2 , "resource");
				return (Criteria) this;
			}

		public Criteria andTypeIsNull ( )
			{
				addCriterion ("type is null");
				return (Criteria) this;
			}

		public Criteria andTypeIsNotNull ( )
			{
				addCriterion ("type is not null");
				return (Criteria) this;
			}

		public Criteria andTypeEqualTo (String value)
			{
				addCriterion ("type =" , value , "type");
				return (Criteria) this;
			}

		public Criteria andTypeNotEqualTo (String value)
			{
				addCriterion ("type <>" , value , "type");
				return (Criteria) this;
			}

		public Criteria andTypeGreaterThan (String value)
			{
				addCriterion ("type >" , value , "type");
				return (Criteria) this;
			}

		public Criteria andTypeGreaterThanOrEqualTo (String value)
			{
				addCriterion ("type >=" , value , "type");
				return (Criteria) this;
			}

		public Criteria andTypeLessThan (String value)
			{
				addCriterion ("type <" , value , "type");
				return (Criteria) this;
			}

		public Criteria andTypeLessThanOrEqualTo (String value)
			{
				addCriterion ("type <=" , value , "type");
				return (Criteria) this;
			}

		public Criteria andTypeLike (String value)
			{
				addCriterion ("type like" , value , "type");
				return (Criteria) this;
			}

		public Criteria andTypeNotLike (String value)
			{
				addCriterion ("type not like" , value , "type");
				return (Criteria) this;
			}

		public Criteria andTypeIn (List <String> values)
			{
				addCriterion ("type in" , values , "type");
				return (Criteria) this;
			}

		public Criteria andTypeNotIn (List <String> values)
			{
				addCriterion ("type not in" , values , "type");
				return (Criteria) this;
			}

		public Criteria andTypeBetween (String value1 , String value2)
			{
				addCriterion ("type between" , value1 , value2 , "type");
				return (Criteria) this;
			}

		public Criteria andTypeNotBetween (String value1 , String value2)
			{
				addCriterion ("type not between" , value1 , value2 , "type");
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

		public Criteria andBelongUserIdIsNull ( )
			{
				addCriterion ("belong_user_id is null");
				return (Criteria) this;
			}

		public Criteria andBelongUserIdIsNotNull ( )
			{
				addCriterion ("belong_user_id is not null");
				return (Criteria) this;
			}

		public Criteria andBelongUserIdEqualTo (Long value)
			{
				addCriterion ("belong_user_id =" , value , "belongUserId");
				return (Criteria) this;
			}

		public Criteria andBelongUserIdNotEqualTo (Long value)
			{
				addCriterion ("belong_user_id <>" , value , "belongUserId");
				return (Criteria) this;
			}

		public Criteria andBelongUserIdGreaterThan (Long value)
			{
				addCriterion ("belong_user_id >" , value , "belongUserId");
				return (Criteria) this;
			}

		public Criteria andBelongUserIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("belong_user_id >=" , value , "belongUserId");
				return (Criteria) this;
			}

		public Criteria andBelongUserIdLessThan (Long value)
			{
				addCriterion ("belong_user_id <" , value , "belongUserId");
				return (Criteria) this;
			}

		public Criteria andBelongUserIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("belong_user_id <=" , value , "belongUserId");
				return (Criteria) this;
			}

		public Criteria andBelongUserIdIn (List <Long> values)
			{
				addCriterion ("belong_user_id in" , values , "belongUserId");
				return (Criteria) this;
			}

		public Criteria andBelongUserIdNotIn (List <Long> values)
			{
				addCriterion ("belong_user_id not in" , values , "belongUserId");
				return (Criteria) this;
			}

		public Criteria andBelongUserIdBetween (Long value1 , Long value2)
			{
				addCriterion ("belong_user_id between" , value1 , value2 , "belongUserId");
				return (Criteria) this;
			}

		public Criteria andBelongUserIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("belong_user_id not between" , value1 , value2 , "belongUserId");
				return (Criteria) this;
			}

		public Criteria andStatusIsNull ( )
			{
				addCriterion ("status is null");
				return (Criteria) this;
			}

		public Criteria andStatusIsNotNull ( )
			{
				addCriterion ("status is not null");
				return (Criteria) this;
			}

		public Criteria andStatusEqualTo (Integer value)
			{
				addCriterion ("status =" , value , "status");
				return (Criteria) this;
			}

		public Criteria andStatusNotEqualTo (Integer value)
			{
				addCriterion ("status <>" , value , "status");
				return (Criteria) this;
			}

		public Criteria andStatusGreaterThan (Integer value)
			{
				addCriterion ("status >" , value , "status");
				return (Criteria) this;
			}

		public Criteria andStatusGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("status >=" , value , "status");
				return (Criteria) this;
			}

		public Criteria andStatusLessThan (Integer value)
			{
				addCriterion ("status <" , value , "status");
				return (Criteria) this;
			}

		public Criteria andStatusLessThanOrEqualTo (Integer value)
			{
				addCriterion ("status <=" , value , "status");
				return (Criteria) this;
			}

		public Criteria andStatusIn (List <Integer> values)
			{
				addCriterion ("status in" , values , "status");
				return (Criteria) this;
			}

		public Criteria andStatusNotIn (List <Integer> values)
			{
				addCriterion ("status not in" , values , "status");
				return (Criteria) this;
			}

		public Criteria andStatusBetween (Integer value1 , Integer value2)
			{
				addCriterion ("status between" , value1 , value2 , "status");
				return (Criteria) this;
			}

		public Criteria andStatusNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("status not between" , value1 , value2 , "status");
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