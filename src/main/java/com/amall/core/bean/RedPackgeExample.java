package com.amall.core.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.amall.core.web.BaseQuery;

public class RedPackgeExample extends BaseQuery
{

	private static final long serialVersionUID = -1243477228850794521L;

	protected String orderByClause;

	protected boolean distinct;

	protected List <Criteria> oredCriteria;

	public RedPackgeExample ( )
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

		public Criteria andAddTimeIsNull ( )
			{
				addCriterion ("add_time is null");
				return (Criteria) this;
			}

		public Criteria andAddTimeIsNotNull ( )
			{
				addCriterion ("add_time is not null");
				return (Criteria) this;
			}

		public Criteria andAddTimeEqualTo (Date value)
			{
				addCriterion ("add_time =" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeNotEqualTo (Date value)
			{
				addCriterion ("add_time <>" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeGreaterThan (Date value)
			{
				addCriterion ("add_time >" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeGreaterThanOrEqualTo (Date value)
			{
				addCriterion ("add_time >=" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeLessThan (Date value)
			{
				addCriterion ("add_time <" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeLessThanOrEqualTo (Date value)
			{
				addCriterion ("add_time <=" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeIn (List <Date> values)
			{
				addCriterion ("add_time in" , values , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeNotIn (List <Date> values)
			{
				addCriterion ("add_time not in" , values , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeBetween (Date value1 , Date value2)
			{
				addCriterion ("add_time between" , value1 , value2 , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeNotBetween (Date value1 , Date value2)
			{
				addCriterion ("add_time not between" , value1 , value2 , "addTime");
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

		public Criteria andRedNumberIsNull ( )
			{
				addCriterion ("red_number is null");
				return (Criteria) this;
			}

		public Criteria andRedNumberIsNotNull ( )
			{
				addCriterion ("red_number is not null");
				return (Criteria) this;
			}

		public Criteria andRedNumberEqualTo (Integer value)
			{
				addCriterion ("red_number =" , value , "redNumber");
				return (Criteria) this;
			}

		public Criteria andRedNumberNotEqualTo (Integer value)
			{
				addCriterion ("red_number <>" , value , "redNumber");
				return (Criteria) this;
			}

		public Criteria andRedNumberGreaterThan (Integer value)
			{
				addCriterion ("red_number >" , value , "redNumber");
				return (Criteria) this;
			}

		public Criteria andRedNumberGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("red_number >=" , value , "redNumber");
				return (Criteria) this;
			}

		public Criteria andRedNumberLessThan (Integer value)
			{
				addCriterion ("red_number <" , value , "redNumber");
				return (Criteria) this;
			}

		public Criteria andRedNumberLessThanOrEqualTo (Integer value)
			{
				addCriterion ("red_number <=" , value , "redNumber");
				return (Criteria) this;
			}

		public Criteria andRedNumberIn (List <Integer> values)
			{
				addCriterion ("red_number in" , values , "redNumber");
				return (Criteria) this;
			}

		public Criteria andRedNumberNotIn (List <Integer> values)
			{
				addCriterion ("red_number not in" , values , "redNumber");
				return (Criteria) this;
			}

		public Criteria andRedNumberBetween (Integer value1 , Integer value2)
			{
				addCriterion ("red_number between" , value1 , value2 , "redNumber");
				return (Criteria) this;
			}

		public Criteria andRedNumberNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("red_number not between" , value1 , value2 , "redNumber");
				return (Criteria) this;
			}

		public Criteria andTotalGoldIsNull ( )
			{
				addCriterion ("total_gold is null");
				return (Criteria) this;
			}

		public Criteria andTotalGoldIsNotNull ( )
			{
				addCriterion ("total_gold is not null");
				return (Criteria) this;
			}

		public Criteria andTotalGoldEqualTo (Integer value)
			{
				addCriterion ("total_gold =" , value , "totalGold");
				return (Criteria) this;
			}

		public Criteria andTotalGoldNotEqualTo (Integer value)
			{
				addCriterion ("total_gold <>" , value , "totalGold");
				return (Criteria) this;
			}

		public Criteria andTotalGoldGreaterThan (Integer value)
			{
				addCriterion ("total_gold >" , value , "totalGold");
				return (Criteria) this;
			}

		public Criteria andTotalGoldGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("total_gold >=" , value , "totalGold");
				return (Criteria) this;
			}

		public Criteria andTotalGoldLessThan (Integer value)
			{
				addCriterion ("total_gold <" , value , "totalGold");
				return (Criteria) this;
			}

		public Criteria andTotalGoldLessThanOrEqualTo (Integer value)
			{
				addCriterion ("total_gold <=" , value , "totalGold");
				return (Criteria) this;
			}

		public Criteria andTotalGoldIn (List <Integer> values)
			{
				addCriterion ("total_gold in" , values , "totalGold");
				return (Criteria) this;
			}

		public Criteria andTotalGoldNotIn (List <Integer> values)
			{
				addCriterion ("total_gold not in" , values , "totalGold");
				return (Criteria) this;
			}

		public Criteria andTotalGoldBetween (Integer value1 , Integer value2)
			{
				addCriterion ("total_gold between" , value1 , value2 , "totalGold");
				return (Criteria) this;
			}

		public Criteria andTotalGoldNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("total_gold not between" , value1 , value2 , "totalGold");
				return (Criteria) this;
			}

		public Criteria andSendTypeIsNull ( )
			{
				addCriterion ("send_type is null");
				return (Criteria) this;
			}

		public Criteria andSendTypeIsNotNull ( )
			{
				addCriterion ("send_type is not null");
				return (Criteria) this;
			}

		public Criteria andSendTypeEqualTo (Integer value)
			{
				addCriterion ("send_type =" , value , "sendType");
				return (Criteria) this;
			}

		public Criteria andSendTypeNotEqualTo (Integer value)
			{
				addCriterion ("send_type <>" , value , "sendType");
				return (Criteria) this;
			}

		public Criteria andSendTypeGreaterThan (Integer value)
			{
				addCriterion ("send_type >" , value , "sendType");
				return (Criteria) this;
			}

		public Criteria andSendTypeGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("send_type >=" , value , "sendType");
				return (Criteria) this;
			}

		public Criteria andSendTypeLessThan (Integer value)
			{
				addCriterion ("send_type <" , value , "sendType");
				return (Criteria) this;
			}

		public Criteria andSendTypeLessThanOrEqualTo (Integer value)
			{
				addCriterion ("send_type <=" , value , "sendType");
				return (Criteria) this;
			}

		public Criteria andSendTypeIn (List <Integer> values)
			{
				addCriterion ("send_type in" , values , "sendType");
				return (Criteria) this;
			}

		public Criteria andSendTypeNotIn (List <Integer> values)
			{
				addCriterion ("send_type not in" , values , "sendType");
				return (Criteria) this;
			}

		public Criteria andSendTypeBetween (Integer value1 , Integer value2)
			{
				addCriterion ("send_type between" , value1 , value2 , "sendType");
				return (Criteria) this;
			}

		public Criteria andSendTypeNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("send_type not between" , value1 , value2 , "sendType");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeIsNull ( )
			{
				addCriterion ("red_packge_type is null");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeIsNotNull ( )
			{
				addCriterion ("red_packge_type is not null");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeEqualTo (String value)
			{
				addCriterion ("red_packge_type =" , value , "redPackgeType");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeNotEqualTo (String value)
			{
				addCriterion ("red_packge_type <>" , value , "redPackgeType");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeGreaterThan (String value)
			{
				addCriterion ("red_packge_type >" , value , "redPackgeType");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeGreaterThanOrEqualTo (String value)
			{
				addCriterion ("red_packge_type >=" , value , "redPackgeType");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeLessThan (String value)
			{
				addCriterion ("red_packge_type <" , value , "redPackgeType");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeLessThanOrEqualTo (String value)
			{
				addCriterion ("red_packge_type <=" , value , "redPackgeType");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeLike (String value)
			{
				addCriterion ("red_packge_type like" , value , "redPackgeType");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeNotLike (String value)
			{
				addCriterion ("red_packge_type not like" , value , "redPackgeType");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeIn (List <String> values)
			{
				addCriterion ("red_packge_type in" , values , "redPackgeType");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeNotIn (List <String> values)
			{
				addCriterion ("red_packge_type not in" , values , "redPackgeType");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeBetween (String value1 , String value2)
			{
				addCriterion ("red_packge_type between" , value1 , value2 , "redPackgeType");
				return (Criteria) this;
			}

		public Criteria andRedPackgeTypeNotBetween (String value1 , String value2)
			{
				addCriterion ("red_packge_type not between" , value1 , value2 , "redPackgeType");
				return (Criteria) this;
			}

		public Criteria andRedPackgeRemainIsNull ( )
			{
				addCriterion ("red_packge_remain is null");
				return (Criteria) this;
			}

		public Criteria andRedPackgeRemainIsNotNull ( )
			{
				addCriterion ("red_packge_remain is not null");
				return (Criteria) this;
			}

		public Criteria andRedPackgeRemainEqualTo (Integer value)
			{
				addCriterion ("red_packge_remain =" , value , "redPackgeRemain");
				return (Criteria) this;
			}

		public Criteria andRedPackgeRemainNotEqualTo (Integer value)
			{
				addCriterion ("red_packge_remain <>" , value , "redPackgeRemain");
				return (Criteria) this;
			}

		public Criteria andRedPackgeRemainGreaterThan (Integer value)
			{
				addCriterion ("red_packge_remain >" , value , "redPackgeRemain");
				return (Criteria) this;
			}

		public Criteria andRedPackgeRemainGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("red_packge_remain >=" , value , "redPackgeRemain");
				return (Criteria) this;
			}

		public Criteria andRedPackgeRemainLessThan (Integer value)
			{
				addCriterion ("red_packge_remain <" , value , "redPackgeRemain");
				return (Criteria) this;
			}

		public Criteria andRedPackgeRemainLessThanOrEqualTo (Integer value)
			{
				addCriterion ("red_packge_remain <=" , value , "redPackgeRemain");
				return (Criteria) this;
			}

		public Criteria andRedPackgeRemainIn (List <Integer> values)
			{
				addCriterion ("red_packge_remain in" , values , "redPackgeRemain");
				return (Criteria) this;
			}

		public Criteria andRedPackgeRemainNotIn (List <Integer> values)
			{
				addCriterion ("red_packge_remain not in" , values , "redPackgeRemain");
				return (Criteria) this;
			}

		public Criteria andRedPackgeRemainBetween (Integer value1 , Integer value2)
			{
				addCriterion ("red_packge_remain between" , value1 , value2 , "redPackgeRemain");
				return (Criteria) this;
			}

		public Criteria andRedPackgeRemainNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("red_packge_remain not between" , value1 , value2 , "redPackgeRemain");
				return (Criteria) this;
			}

		public Criteria andUpgradeLevelIsNull ( )
			{
				addCriterion ("upgrade_level is null");
				return (Criteria) this;
			}

		public Criteria andUpgradeLevelIsNotNull ( )
			{
				addCriterion ("upgrade_level is not null");
				return (Criteria) this;
			}

		public Criteria andUpgradeLevelEqualTo (Integer value)
			{
				addCriterion ("upgrade_level =" , value , "upgradeLevel");
				return (Criteria) this;
			}

		public Criteria andUpgradeLevelNotEqualTo (Integer value)
			{
				addCriterion ("upgrade_level <>" , value , "upgradeLevel");
				return (Criteria) this;
			}

		public Criteria andUpgradeLevelGreaterThan (Integer value)
			{
				addCriterion ("upgrade_level >" , value , "upgradeLevel");
				return (Criteria) this;
			}

		public Criteria andUpgradeLevelGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("upgrade_level >=" , value , "upgradeLevel");
				return (Criteria) this;
			}

		public Criteria andUpgradeLevelLessThan (Integer value)
			{
				addCriterion ("upgrade_level <" , value , "upgradeLevel");
				return (Criteria) this;
			}

		public Criteria andUpgradeLevelLessThanOrEqualTo (Integer value)
			{
				addCriterion ("upgrade_level <=" , value , "upgradeLevel");
				return (Criteria) this;
			}

		public Criteria andUpgradeLevelIn (List <Integer> values)
			{
				addCriterion ("upgrade_level in" , values , "upgradeLevel");
				return (Criteria) this;
			}

		public Criteria andUpgradeLevelNotIn (List <Integer> values)
			{
				addCriterion ("upgrade_level not in" , values , "upgradeLevel");
				return (Criteria) this;
			}

		public Criteria andUpgradeLevelBetween (Integer value1 , Integer value2)
			{
				addCriterion ("upgrade_level between" , value1 , value2 , "upgradeLevel");
				return (Criteria) this;
			}

		public Criteria andUpgradeLevelNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("upgrade_level not between" , value1 , value2 , "upgradeLevel");
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