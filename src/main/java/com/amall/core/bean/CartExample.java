package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.amall.core.web.BaseQuery;

public class CartExample extends BaseQuery
{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List <Criteria> oredCriteria;

	public CartExample ( )
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

		public Criteria andPaymentIsNull ( )
			{
				addCriterion ("payment is null");
				return (Criteria) this;
			}

		public Criteria andPaymentIsNotNull ( )
			{
				addCriterion ("payment is not null");
				return (Criteria) this;
			}

		public Criteria andPaymentEqualTo (BigDecimal value)
			{
				addCriterion ("payment =" , value , "payment");
				return (Criteria) this;
			}

		public Criteria andPaymentNotEqualTo (BigDecimal value)
			{
				addCriterion ("payment <>" , value , "payment");
				return (Criteria) this;
			}

		public Criteria andPaymentGreaterThan (BigDecimal value)
			{
				addCriterion ("payment >" , value , "payment");
				return (Criteria) this;
			}

		public Criteria andPaymentGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("payment >=" , value , "payment");
				return (Criteria) this;
			}

		public Criteria andPaymentLessThan (BigDecimal value)
			{
				addCriterion ("payment <" , value , "payment");
				return (Criteria) this;
			}

		public Criteria andPaymentLessThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("payment <=" , value , "payment");
				return (Criteria) this;
			}

		public Criteria andPaymentIn (List <BigDecimal> values)
			{
				addCriterion ("payment in" , values , "payment");
				return (Criteria) this;
			}

		public Criteria andPaymentNotIn (List <BigDecimal> values)
			{
				addCriterion ("payment not in" , values , "payment");
				return (Criteria) this;
			}

		public Criteria andPaymentBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("payment between" , value1 , value2 , "payment");
				return (Criteria) this;
			}

		public Criteria andPaymentNotBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("payment not between" , value1 , value2 , "payment");
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

		public Criteria andStatusEqualTo (Boolean value)
			{
				addCriterion ("status =" , value , "status");
				return (Criteria) this;
			}

		public Criteria andStatusNotEqualTo (Boolean value)
			{
				addCriterion ("status <>" , value , "status");
				return (Criteria) this;
			}

		public Criteria andStatusGreaterThan (Boolean value)
			{
				addCriterion ("status >" , value , "status");
				return (Criteria) this;
			}

		public Criteria andStatusGreaterThanOrEqualTo (Boolean value)
			{
				addCriterion ("status >=" , value , "status");
				return (Criteria) this;
			}

		public Criteria andStatusLessThan (Boolean value)
			{
				addCriterion ("status <" , value , "status");
				return (Criteria) this;
			}

		public Criteria andStatusLessThanOrEqualTo (Boolean value)
			{
				addCriterion ("status <=" , value , "status");
				return (Criteria) this;
			}

		public Criteria andStatusIn (List <Boolean> values)
			{
				addCriterion ("status in" , values , "status");
				return (Criteria) this;
			}

		public Criteria andStatusNotIn (List <Boolean> values)
			{
				addCriterion ("status not in" , values , "status");
				return (Criteria) this;
			}

		public Criteria andStatusBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("status between" , value1 , value2 , "status");
				return (Criteria) this;
			}

		public Criteria andStatusNotBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("status not between" , value1 , value2 , "status");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdIsNull ( )
			{
				addCriterion ("goods_cart_id is null");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdIsNotNull ( )
			{
				addCriterion ("goods_cart_id is not null");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdEqualTo (String value)
			{
				addCriterion ("goods_cart_id =" , value , "goodsCartId");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdNotEqualTo (String value)
			{
				addCriterion ("goods_cart_id <>" , value , "goodsCartId");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdGreaterThan (String value)
			{
				addCriterion ("goods_cart_id >" , value , "goodsCartId");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdGreaterThanOrEqualTo (String value)
			{
				addCriterion ("goods_cart_id >=" , value , "goodsCartId");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdLessThan (String value)
			{
				addCriterion ("goods_cart_id <" , value , "goodsCartId");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdLessThanOrEqualTo (String value)
			{
				addCriterion ("goods_cart_id <=" , value , "goodsCartId");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdLike (String value)
			{
				addCriterion ("goods_cart_id like" , value , "goodsCartId");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdNotLike (String value)
			{
				addCriterion ("goods_cart_id not like" , value , "goodsCartId");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdIn (List <String> values)
			{
				addCriterion ("goods_cart_id in" , values , "goodsCartId");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdNotIn (List <String> values)
			{
				addCriterion ("goods_cart_id not in" , values , "goodsCartId");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdBetween (String value1 , String value2)
			{
				addCriterion ("goods_cart_id between" , value1 , value2 , "goodsCartId");
				return (Criteria) this;
			}

		public Criteria andGoodsCartIdNotBetween (String value1 , String value2)
			{
				addCriterion ("goods_cart_id not between" , value1 , value2 , "goodsCartId");
				return (Criteria) this;
			}

		/**
		 * 
		 * <p>
		 * Title: andGoodsCartIdIsNull
		 * </p>
		 * <p>
		 * Description: 界限
		 * </p>
		 * 
		 * @return
		 */
		public Criteria andOfIdIsNull ( )
			{
				addCriterion ("of_id is null");
				return (Criteria) this;
			}

		public Criteria andOfIdIsNotNull ( )
			{
				addCriterion ("of_id is not null");
				return (Criteria) this;
			}

		public Criteria andOfIdEqualTo (String value)
			{
				addCriterion ("of_id =" , value , "ofId");
				return (Criteria) this;
			}

		public Criteria andOfIdNotEqualTo (String value)
			{
				addCriterion ("of_id <>" , value , "ofId");
				return (Criteria) this;
			}

		public Criteria andOfIdGreaterThan (String value)
			{
				addCriterion ("of_id >" , value , "ofId");
				return (Criteria) this;
			}

		public Criteria andOfIdGreaterThanOrEqualTo (String value)
			{
				addCriterion ("of_id >=" , value , "ofId");
				return (Criteria) this;
			}

		public Criteria andOfIdLessThan (String value)
			{
				addCriterion ("of_id <" , value , "ofId");
				return (Criteria) this;
			}

		public Criteria andOfIdLessThanOrEqualTo (String value)
			{
				addCriterion ("of_id <=" , value , "ofId");
				return (Criteria) this;
			}

		public Criteria andOfIdLike (String value)
			{
				addCriterion ("of_id like" , value , "ofId");
				return (Criteria) this;
			}

		public Criteria andOfIdNotLike (String value)
			{
				addCriterion ("of_id not like" , value , "ofId");
				return (Criteria) this;
			}

		public Criteria andOfIdIn (List <String> values)
			{
				addCriterion ("of_id in" , values , "ofId");
				return (Criteria) this;
			}

		public Criteria andOfIdNotIn (List <String> values)
			{
				addCriterion ("of_id not in" , values , "ofId");
				return (Criteria) this;
			}

		public Criteria andOfIdBetween (String value1 , String value2)
			{
				addCriterion ("of_id between" , value1 , value2 , "ofId");
				return (Criteria) this;
			}

		public Criteria andOfIdNotBetween (String value1 , String value2)
			{
				addCriterion ("of_id not between" , value1 , value2 , "ofId");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsIsNull ( )
			{
				addCriterion ("goodsIds is null");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsIsNotNull ( )
			{
				addCriterion ("goodsIds is not null");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsEqualTo (String value)
			{
				addCriterion ("goodsIds =" , value , "goodsIds");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsNotEqualTo (String value)
			{
				addCriterion ("goodsIds <>" , value , "goodsIds");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsGreaterThan (String value)
			{
				addCriterion ("goodsIds >" , value , "goodsIds");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsGreaterThanOrEqualTo (String value)
			{
				addCriterion ("goodsIds >=" , value , "goodsIds");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsLessThan (String value)
			{
				addCriterion ("goodsIds <" , value , "goodsIds");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsLessThanOrEqualTo (String value)
			{
				addCriterion ("goodsIds <=" , value , "goodsIds");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsLike (String value)
			{
				addCriterion ("goodsIds like" , value , "goodsIds");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsNotLike (String value)
			{
				addCriterion ("goodsIds not like" , value , "goodsIds");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsIn (List <String> values)
			{
				addCriterion ("goodsIds in" , values , "goodsIds");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsNotIn (List <String> values)
			{
				addCriterion ("goodsIds not in" , values , "goodsIds");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsBetween (String value1 , String value2)
			{
				addCriterion ("goodsIds between" , value1 , value2 , "goodsIds");
				return (Criteria) this;
			}

		public Criteria andGoodsIdsNotBetween (String value1 , String value2)
			{
				addCriterion ("goodsIds not between" , value1 , value2 , "goodsIds");
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