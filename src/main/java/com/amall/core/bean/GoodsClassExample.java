package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.amall.core.web.BaseQuery;

public class GoodsClassExample extends BaseQuery
{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List <Criteria> oredCriteria;

	public GoodsClassExample ( )
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

		public Criteria andClassnameIsNull ( )
			{
				addCriterion ("className is null");
				return (Criteria) this;
			}

		public Criteria andClassnameIsNotNull ( )
			{
				addCriterion ("className is not null");
				return (Criteria) this;
			}

		public Criteria andClassnameEqualTo (String value)
			{
				addCriterion ("className =" , value , "classname");
				return (Criteria) this;
			}

		public Criteria andClassnameNotEqualTo (String value)
			{
				addCriterion ("className <>" , value , "classname");
				return (Criteria) this;
			}

		public Criteria andClassnameGreaterThan (String value)
			{
				addCriterion ("className >" , value , "classname");
				return (Criteria) this;
			}

		public Criteria andClassnameGreaterThanOrEqualTo (String value)
			{
				addCriterion ("className >=" , value , "classname");
				return (Criteria) this;
			}

		public Criteria andClassnameLessThan (String value)
			{
				addCriterion ("className <" , value , "classname");
				return (Criteria) this;
			}

		public Criteria andClassnameLessThanOrEqualTo (String value)
			{
				addCriterion ("className <=" , value , "classname");
				return (Criteria) this;
			}

		public Criteria andClassnameLike (String value)
			{
				addCriterion ("className like" , value , "classname");
				return (Criteria) this;
			}

		public Criteria andClassnameNotLike (String value)
			{
				addCriterion ("className not like" , value , "classname");
				return (Criteria) this;
			}

		public Criteria andClassnameIn (List <String> values)
			{
				addCriterion ("className in" , values , "classname");
				return (Criteria) this;
			}

		public Criteria andClassnameNotIn (List <String> values)
			{
				addCriterion ("className not in" , values , "classname");
				return (Criteria) this;
			}

		public Criteria andClassnameBetween (String value1 , String value2)
			{
				addCriterion ("className between" , value1 , value2 , "classname");
				return (Criteria) this;
			}

		public Criteria andClassnameNotBetween (String value1 , String value2)
			{
				addCriterion ("className not between" , value1 , value2 , "classname");
				return (Criteria) this;
			}

		public Criteria andDisplayIsNull ( )
			{
				addCriterion ("display is null");
				return (Criteria) this;
			}

		public Criteria andDisplayIsNotNull ( )
			{
				addCriterion ("display is not null");
				return (Criteria) this;
			}

		public Criteria andDisplayEqualTo (Boolean value)
			{
				addCriterion ("display =" , value , "display");
				return (Criteria) this;
			}

		public Criteria andDisplayNotEqualTo (Boolean value)
			{
				addCriterion ("display <>" , value , "display");
				return (Criteria) this;
			}

		public Criteria andDisplayGreaterThan (Boolean value)
			{
				addCriterion ("display >" , value , "display");
				return (Criteria) this;
			}

		public Criteria andDisplayGreaterThanOrEqualTo (Boolean value)
			{
				addCriterion ("display >=" , value , "display");
				return (Criteria) this;
			}

		public Criteria andDisplayLessThan (Boolean value)
			{
				addCriterion ("display <" , value , "display");
				return (Criteria) this;
			}

		public Criteria andDisplayLessThanOrEqualTo (Boolean value)
			{
				addCriterion ("display <=" , value , "display");
				return (Criteria) this;
			}

		public Criteria andDisplayIn (List <Boolean> values)
			{
				addCriterion ("display in" , values , "display");
				return (Criteria) this;
			}

		public Criteria andDisplayNotIn (List <Boolean> values)
			{
				addCriterion ("display not in" , values , "display");
				return (Criteria) this;
			}

		public Criteria andDisplayBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("display between" , value1 , value2 , "display");
				return (Criteria) this;
			}

		public Criteria andDisplayNotBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("display not between" , value1 , value2 , "display");
				return (Criteria) this;
			}

		public Criteria andLevelIsNull ( )
			{
				addCriterion ("level is null");
				return (Criteria) this;
			}

		public Criteria andLevelIsNotNull ( )
			{
				addCriterion ("level is not null");
				return (Criteria) this;
			}

		public Criteria andLevelEqualTo (Integer value)
			{
				addCriterion ("level =" , value , "level");
				return (Criteria) this;
			}

		public Criteria andLevelNotEqualTo (Integer value)
			{
				addCriterion ("level <>" , value , "level");
				return (Criteria) this;
			}

		public Criteria andLevelGreaterThan (Integer value)
			{
				addCriterion ("level >" , value , "level");
				return (Criteria) this;
			}

		public Criteria andLevelGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("level >=" , value , "level");
				return (Criteria) this;
			}

		public Criteria andLevelLessThan (Integer value)
			{
				addCriterion ("level <" , value , "level");
				return (Criteria) this;
			}

		public Criteria andLevelLessThanOrEqualTo (Integer value)
			{
				addCriterion ("level <=" , value , "level");
				return (Criteria) this;
			}

		public Criteria andLevelIn (List <Integer> values)
			{
				addCriterion ("level in" , values , "level");
				return (Criteria) this;
			}

		public Criteria andLevelNotIn (List <Integer> values)
			{
				addCriterion ("level not in" , values , "level");
				return (Criteria) this;
			}

		public Criteria andLevelBetween (Integer value1 , Integer value2)
			{
				addCriterion ("level between" , value1 , value2 , "level");
				return (Criteria) this;
			}

		public Criteria andLevelNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("level not between" , value1 , value2 , "level");
				return (Criteria) this;
			}

		public Criteria andRecommendIsNull ( )
			{
				addCriterion ("recommend is null");
				return (Criteria) this;
			}

		public Criteria andRecommendIsNotNull ( )
			{
				addCriterion ("recommend is not null");
				return (Criteria) this;
			}

		public Criteria andRecommendEqualTo (Boolean value)
			{
				addCriterion ("recommend =" , value , "recommend");
				return (Criteria) this;
			}

		public Criteria andRecommendNotEqualTo (Boolean value)
			{
				addCriterion ("recommend <>" , value , "recommend");
				return (Criteria) this;
			}

		public Criteria andRecommendGreaterThan (Boolean value)
			{
				addCriterion ("recommend >" , value , "recommend");
				return (Criteria) this;
			}

		public Criteria andRecommendGreaterThanOrEqualTo (Boolean value)
			{
				addCriterion ("recommend >=" , value , "recommend");
				return (Criteria) this;
			}

		public Criteria andRecommendLessThan (Boolean value)
			{
				addCriterion ("recommend <" , value , "recommend");
				return (Criteria) this;
			}

		public Criteria andRecommendLessThanOrEqualTo (Boolean value)
			{
				addCriterion ("recommend <=" , value , "recommend");
				return (Criteria) this;
			}

		public Criteria andRecommendIn (List <Boolean> values)
			{
				addCriterion ("recommend in" , values , "recommend");
				return (Criteria) this;
			}

		public Criteria andRecommendNotIn (List <Boolean> values)
			{
				addCriterion ("recommend not in" , values , "recommend");
				return (Criteria) this;
			}

		public Criteria andRecommendBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("recommend between" , value1 , value2 , "recommend");
				return (Criteria) this;
			}

		public Criteria andRecommendNotBetween (Boolean value1 , Boolean value2)
			{
				addCriterion ("recommend not between" , value1 , value2 , "recommend");
				return (Criteria) this;
			}

		public Criteria andSequenceIsNull ( )
			{
				addCriterion ("sequence is null");
				return (Criteria) this;
			}

		public Criteria andSequenceIsNotNull ( )
			{
				addCriterion ("sequence is not null");
				return (Criteria) this;
			}

		public Criteria andSequenceEqualTo (Integer value)
			{
				addCriterion ("sequence =" , value , "sequence");
				return (Criteria) this;
			}

		public Criteria andSequenceNotEqualTo (Integer value)
			{
				addCriterion ("sequence <>" , value , "sequence");
				return (Criteria) this;
			}

		public Criteria andSequenceGreaterThan (Integer value)
			{
				addCriterion ("sequence >" , value , "sequence");
				return (Criteria) this;
			}

		public Criteria andSequenceGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("sequence >=" , value , "sequence");
				return (Criteria) this;
			}

		public Criteria andSequenceLessThan (Integer value)
			{
				addCriterion ("sequence <" , value , "sequence");
				return (Criteria) this;
			}

		public Criteria andSequenceLessThanOrEqualTo (Integer value)
			{
				addCriterion ("sequence <=" , value , "sequence");
				return (Criteria) this;
			}

		public Criteria andSequenceIn (List <Integer> values)
			{
				addCriterion ("sequence in" , values , "sequence");
				return (Criteria) this;
			}

		public Criteria andSequenceNotIn (List <Integer> values)
			{
				addCriterion ("sequence not in" , values , "sequence");
				return (Criteria) this;
			}

		public Criteria andSequenceBetween (Integer value1 , Integer value2)
			{
				addCriterion ("sequence between" , value1 , value2 , "sequence");
				return (Criteria) this;
			}

		public Criteria andSequenceNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("sequence not between" , value1 , value2 , "sequence");
				return (Criteria) this;
			}

		public Criteria andGoodstypeIdIsNull ( )
			{
				addCriterion ("goodsType_id is null");
				return (Criteria) this;
			}

		public Criteria andGoodstypeIdIsNotNull ( )
			{
				addCriterion ("goodsType_id is not null");
				return (Criteria) this;
			}

		public Criteria andGoodstypeIdEqualTo (Long value)
			{
				addCriterion ("goodsType_id =" , value , "goodstypeId");
				return (Criteria) this;
			}

		public Criteria andGoodstypeIdNotEqualTo (Long value)
			{
				addCriterion ("goodsType_id <>" , value , "goodstypeId");
				return (Criteria) this;
			}

		public Criteria andGoodstypeIdGreaterThan (Long value)
			{
				addCriterion ("goodsType_id >" , value , "goodstypeId");
				return (Criteria) this;
			}

		public Criteria andGoodstypeIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("goodsType_id >=" , value , "goodstypeId");
				return (Criteria) this;
			}

		public Criteria andGoodstypeIdLessThan (Long value)
			{
				addCriterion ("goodsType_id <" , value , "goodstypeId");
				return (Criteria) this;
			}

		public Criteria andGoodstypeIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("goodsType_id <=" , value , "goodstypeId");
				return (Criteria) this;
			}

		public Criteria andGoodstypeIdIn (List <Long> values)
			{
				addCriterion ("goodsType_id in" , values , "goodstypeId");
				return (Criteria) this;
			}

		public Criteria andGoodstypeIdNotIn (List <Long> values)
			{
				addCriterion ("goodsType_id not in" , values , "goodstypeId");
				return (Criteria) this;
			}

		public Criteria andGoodstypeIdBetween (Long value1 , Long value2)
			{
				addCriterion ("goodsType_id between" , value1 , value2 , "goodstypeId");
				return (Criteria) this;
			}

		public Criteria andGoodstypeIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("goodsType_id not between" , value1 , value2 , "goodstypeId");
				return (Criteria) this;
			}

		public Criteria andParentIdIsNull ( )
			{
				addCriterion ("parent_id is null");
				return (Criteria) this;
			}

		public Criteria andParentIdIsNotNull ( )
			{
				addCriterion ("parent_id is not null");
				return (Criteria) this;
			}

		public Criteria andParentIdEqualTo (Long value)
			{
				addCriterion ("parent_id =" , value , "parentId");
				return (Criteria) this;
			}

		public Criteria andParentIdNotEqualTo (Long value)
			{
				addCriterion ("parent_id <>" , value , "parentId");
				return (Criteria) this;
			}

		public Criteria andParentIdGreaterThan (Long value)
			{
				addCriterion ("parent_id >" , value , "parentId");
				return (Criteria) this;
			}

		public Criteria andParentIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("parent_id >=" , value , "parentId");
				return (Criteria) this;
			}

		public Criteria andParentIdLessThan (Long value)
			{
				addCriterion ("parent_id <" , value , "parentId");
				return (Criteria) this;
			}

		public Criteria andParentIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("parent_id <=" , value , "parentId");
				return (Criteria) this;
			}

		public Criteria andParentIdIn (List <Long> values)
			{
				addCriterion ("parent_id in" , values , "parentId");
				return (Criteria) this;
			}

		public Criteria andParentIdNotIn (List <Long> values)
			{
				addCriterion ("parent_id not in" , values , "parentId");
				return (Criteria) this;
			}

		public Criteria andParentIdBetween (Long value1 , Long value2)
			{
				addCriterion ("parent_id between" , value1 , value2 , "parentId");
				return (Criteria) this;
			}

		public Criteria andParentIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("parent_id not between" , value1 , value2 , "parentId");
				return (Criteria) this;
			}

		public Criteria andIconSysIsNull ( )
			{
				addCriterion ("icon_sys is null");
				return (Criteria) this;
			}

		public Criteria andIconSysIsNotNull ( )
			{
				addCriterion ("icon_sys is not null");
				return (Criteria) this;
			}

		public Criteria andIconSysEqualTo (String value)
			{
				addCriterion ("icon_sys =" , value , "iconSys");
				return (Criteria) this;
			}

		public Criteria andIconSysNotEqualTo (String value)
			{
				addCriterion ("icon_sys <>" , value , "iconSys");
				return (Criteria) this;
			}

		public Criteria andIconSysGreaterThan (String value)
			{
				addCriterion ("icon_sys >" , value , "iconSys");
				return (Criteria) this;
			}

		public Criteria andIconSysGreaterThanOrEqualTo (String value)
			{
				addCriterion ("icon_sys >=" , value , "iconSys");
				return (Criteria) this;
			}

		public Criteria andIconSysLessThan (String value)
			{
				addCriterion ("icon_sys <" , value , "iconSys");
				return (Criteria) this;
			}

		public Criteria andIconSysLessThanOrEqualTo (String value)
			{
				addCriterion ("icon_sys <=" , value , "iconSys");
				return (Criteria) this;
			}

		public Criteria andIconSysLike (String value)
			{
				addCriterion ("icon_sys like" , value , "iconSys");
				return (Criteria) this;
			}

		public Criteria andIconSysNotLike (String value)
			{
				addCriterion ("icon_sys not like" , value , "iconSys");
				return (Criteria) this;
			}

		public Criteria andIconSysIn (List <String> values)
			{
				addCriterion ("icon_sys in" , values , "iconSys");
				return (Criteria) this;
			}

		public Criteria andIconSysNotIn (List <String> values)
			{
				addCriterion ("icon_sys not in" , values , "iconSys");
				return (Criteria) this;
			}

		public Criteria andIconSysBetween (String value1 , String value2)
			{
				addCriterion ("icon_sys between" , value1 , value2 , "iconSys");
				return (Criteria) this;
			}

		public Criteria andIconSysNotBetween (String value1 , String value2)
			{
				addCriterion ("icon_sys not between" , value1 , value2 , "iconSys");
				return (Criteria) this;
			}

		public Criteria andIconTypeIsNull ( )
			{
				addCriterion ("icon_type is null");
				return (Criteria) this;
			}

		public Criteria andIconTypeIsNotNull ( )
			{
				addCriterion ("icon_type is not null");
				return (Criteria) this;
			}

		public Criteria andIconTypeEqualTo (Integer value)
			{
				addCriterion ("icon_type =" , value , "iconType");
				return (Criteria) this;
			}

		public Criteria andIconTypeNotEqualTo (Integer value)
			{
				addCriterion ("icon_type <>" , value , "iconType");
				return (Criteria) this;
			}

		public Criteria andIconTypeGreaterThan (Integer value)
			{
				addCriterion ("icon_type >" , value , "iconType");
				return (Criteria) this;
			}

		public Criteria andIconTypeGreaterThanOrEqualTo (Integer value)
			{
				addCriterion ("icon_type >=" , value , "iconType");
				return (Criteria) this;
			}

		public Criteria andIconTypeLessThan (Integer value)
			{
				addCriterion ("icon_type <" , value , "iconType");
				return (Criteria) this;
			}

		public Criteria andIconTypeLessThanOrEqualTo (Integer value)
			{
				addCriterion ("icon_type <=" , value , "iconType");
				return (Criteria) this;
			}

		public Criteria andIconTypeIn (List <Integer> values)
			{
				addCriterion ("icon_type in" , values , "iconType");
				return (Criteria) this;
			}

		public Criteria andIconTypeNotIn (List <Integer> values)
			{
				addCriterion ("icon_type not in" , values , "iconType");
				return (Criteria) this;
			}

		public Criteria andIconTypeBetween (Integer value1 , Integer value2)
			{
				addCriterion ("icon_type between" , value1 , value2 , "iconType");
				return (Criteria) this;
			}

		public Criteria andIconTypeNotBetween (Integer value1 , Integer value2)
			{
				addCriterion ("icon_type not between" , value1 , value2 , "iconType");
				return (Criteria) this;
			}

		public Criteria andIconAccIdIsNull ( )
			{
				addCriterion ("icon_acc_id is null");
				return (Criteria) this;
			}

		public Criteria andIconAccIdIsNotNull ( )
			{
				addCriterion ("icon_acc_id is not null");
				return (Criteria) this;
			}

		public Criteria andIconAccIdEqualTo (Long value)
			{
				addCriterion ("icon_acc_id =" , value , "iconAccId");
				return (Criteria) this;
			}

		public Criteria andIconAccIdNotEqualTo (Long value)
			{
				addCriterion ("icon_acc_id <>" , value , "iconAccId");
				return (Criteria) this;
			}

		public Criteria andIconAccIdGreaterThan (Long value)
			{
				addCriterion ("icon_acc_id >" , value , "iconAccId");
				return (Criteria) this;
			}

		public Criteria andIconAccIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("icon_acc_id >=" , value , "iconAccId");
				return (Criteria) this;
			}

		public Criteria andIconAccIdLessThan (Long value)
			{
				addCriterion ("icon_acc_id <" , value , "iconAccId");
				return (Criteria) this;
			}

		public Criteria andIconAccIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("icon_acc_id <=" , value , "iconAccId");
				return (Criteria) this;
			}

		public Criteria andIconAccIdIn (List <Long> values)
			{
				addCriterion ("icon_acc_id in" , values , "iconAccId");
				return (Criteria) this;
			}

		public Criteria andIconAccIdNotIn (List <Long> values)
			{
				addCriterion ("icon_acc_id not in" , values , "iconAccId");
				return (Criteria) this;
			}

		public Criteria andIconAccIdBetween (Long value1 , Long value2)
			{
				addCriterion ("icon_acc_id between" , value1 , value2 , "iconAccId");
				return (Criteria) this;
			}

		public Criteria andIconAccIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("icon_acc_id not between" , value1 , value2 , "iconAccId");
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

		public Criteria andGroupIdEqualTo (Long value)
			{
				addCriterion ("group_id =" , value , "groupId");
				return (Criteria) this;
			}

		public Criteria andGroupIdNotEqualTo (Long value)
			{
				addCriterion ("group_id <>" , value , "groupId");
				return (Criteria) this;
			}

		public Criteria andGroupIdGreaterThan (Long value)
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

		public Criteria andGroupIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("group_id <=" , value , "groupId");
				return (Criteria) this;
			}

		public Criteria andGroupIdIn (List <Long> values)
			{
				addCriterion ("group_id in" , values , "groupId");
				return (Criteria) this;
			}

		public Criteria andGroupIdNotIn (List <Long> values)
			{
				addCriterion ("group_id not in" , values , "groupId");
				return (Criteria) this;
			}

		public Criteria andGroupIdBetween (Long value1 , Long value2)
			{
				addCriterion ("group_id between" , value1 , value2 , "groupId");
				return (Criteria) this;
			}

		public Criteria andGroupIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("group_id not between" , value1 , value2 , "groupId");
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

		public Criteria andDescriptionEvaluateEqualTo (BigDecimal value)
			{
				addCriterion ("description_evaluate =" , value , "descriptionEvaluate");
				return (Criteria) this;
			}

		public Criteria andDescriptionEvaluateNotEqualTo (BigDecimal value)
			{
				addCriterion ("description_evaluate <>" , value , "descriptionEvaluate");
				return (Criteria) this;
			}

		public Criteria andDescriptionEvaluateGreaterThan (BigDecimal value)
			{
				addCriterion ("description_evaluate >" , value , "descriptionEvaluate");
				return (Criteria) this;
			}

		public Criteria andDescriptionEvaluateGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("description_evaluate >=" , value , "descriptionEvaluate");
				return (Criteria) this;
			}

		public Criteria andDescriptionEvaluateLessThan (BigDecimal value)
			{
				addCriterion ("description_evaluate <" , value , "descriptionEvaluate");
				return (Criteria) this;
			}

		public Criteria andDescriptionEvaluateLessThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("description_evaluate <=" , value , "descriptionEvaluate");
				return (Criteria) this;
			}

		public Criteria andDescriptionEvaluateIn (List <BigDecimal> values)
			{
				addCriterion ("description_evaluate in" , values , "descriptionEvaluate");
				return (Criteria) this;
			}

		public Criteria andDescriptionEvaluateNotIn (List <BigDecimal> values)
			{
				addCriterion ("description_evaluate not in" , values , "descriptionEvaluate");
				return (Criteria) this;
			}

		public Criteria andDescriptionEvaluateBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("description_evaluate between" , value1 , value2 , "descriptionEvaluate");
				return (Criteria) this;
			}

		public Criteria andDescriptionEvaluateNotBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("description_evaluate not between" , value1 , value2 , "descriptionEvaluate");
				return (Criteria) this;
			}

		public Criteria andServiceEvaluateIsNull ( )
			{
				addCriterion ("service_evaluate is null");
				return (Criteria) this;
			}

		public Criteria andServiceEvaluateIsNotNull ( )
			{
				addCriterion ("service_evaluate is not null");
				return (Criteria) this;
			}

		public Criteria andServiceEvaluateEqualTo (BigDecimal value)
			{
				addCriterion ("service_evaluate =" , value , "serviceEvaluate");
				return (Criteria) this;
			}

		public Criteria andServiceEvaluateNotEqualTo (BigDecimal value)
			{
				addCriterion ("service_evaluate <>" , value , "serviceEvaluate");
				return (Criteria) this;
			}

		public Criteria andServiceEvaluateGreaterThan (BigDecimal value)
			{
				addCriterion ("service_evaluate >" , value , "serviceEvaluate");
				return (Criteria) this;
			}

		public Criteria andServiceEvaluateGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("service_evaluate >=" , value , "serviceEvaluate");
				return (Criteria) this;
			}

		public Criteria andServiceEvaluateLessThan (BigDecimal value)
			{
				addCriterion ("service_evaluate <" , value , "serviceEvaluate");
				return (Criteria) this;
			}

		public Criteria andServiceEvaluateLessThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("service_evaluate <=" , value , "serviceEvaluate");
				return (Criteria) this;
			}

		public Criteria andServiceEvaluateIn (List <BigDecimal> values)
			{
				addCriterion ("service_evaluate in" , values , "serviceEvaluate");
				return (Criteria) this;
			}

		public Criteria andServiceEvaluateNotIn (List <BigDecimal> values)
			{
				addCriterion ("service_evaluate not in" , values , "serviceEvaluate");
				return (Criteria) this;
			}

		public Criteria andServiceEvaluateBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("service_evaluate between" , value1 , value2 , "serviceEvaluate");
				return (Criteria) this;
			}

		public Criteria andServiceEvaluateNotBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("service_evaluate not between" , value1 , value2 , "serviceEvaluate");
				return (Criteria) this;
			}

		public Criteria andShipEvaluateIsNull ( )
			{
				addCriterion ("ship_evaluate is null");
				return (Criteria) this;
			}

		public Criteria andShipEvaluateIsNotNull ( )
			{
				addCriterion ("ship_evaluate is not null");
				return (Criteria) this;
			}

		public Criteria andShipEvaluateEqualTo (BigDecimal value)
			{
				addCriterion ("ship_evaluate =" , value , "shipEvaluate");
				return (Criteria) this;
			}

		public Criteria andShipEvaluateNotEqualTo (BigDecimal value)
			{
				addCriterion ("ship_evaluate <>" , value , "shipEvaluate");
				return (Criteria) this;
			}

		public Criteria andShipEvaluateGreaterThan (BigDecimal value)
			{
				addCriterion ("ship_evaluate >" , value , "shipEvaluate");
				return (Criteria) this;
			}

		public Criteria andShipEvaluateGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("ship_evaluate >=" , value , "shipEvaluate");
				return (Criteria) this;
			}

		public Criteria andShipEvaluateLessThan (BigDecimal value)
			{
				addCriterion ("ship_evaluate <" , value , "shipEvaluate");
				return (Criteria) this;
			}

		public Criteria andShipEvaluateLessThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("ship_evaluate <=" , value , "shipEvaluate");
				return (Criteria) this;
			}

		public Criteria andShipEvaluateIn (List <BigDecimal> values)
			{
				addCriterion ("ship_evaluate in" , values , "shipEvaluate");
				return (Criteria) this;
			}

		public Criteria andShipEvaluateNotIn (List <BigDecimal> values)
			{
				addCriterion ("ship_evaluate not in" , values , "shipEvaluate");
				return (Criteria) this;
			}

		public Criteria andShipEvaluateBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("ship_evaluate between" , value1 , value2 , "shipEvaluate");
				return (Criteria) this;
			}

		public Criteria andShipEvaluateNotBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("ship_evaluate not between" , value1 , value2 , "shipEvaluate");
				return (Criteria) this;
			}

		public Criteria andRateIsNull ( )
			{
				addCriterion ("rate is null");
				return (Criteria) this;
			}

		public Criteria andRateIsNotNull ( )
			{
				addCriterion ("rate is not null");
				return (Criteria) this;
			}

		public Criteria andRateEqualTo (BigDecimal value)
			{
				addCriterion ("rate =" , value , "rate");
				return (Criteria) this;
			}

		public Criteria andRateNotEqualTo (BigDecimal value)
			{
				addCriterion ("rate <>" , value , "rate");
				return (Criteria) this;
			}

		public Criteria andRateGreaterThan (BigDecimal value)
			{
				addCriterion ("rate >" , value , "rate");
				return (Criteria) this;
			}

		public Criteria andRateGreaterThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("rate >=" , value , "rate");
				return (Criteria) this;
			}

		public Criteria andRateLessThan (BigDecimal value)
			{
				addCriterion ("rate <" , value , "rate");
				return (Criteria) this;
			}

		public Criteria andRateLessThanOrEqualTo (BigDecimal value)
			{
				addCriterion ("rate <=" , value , "rate");
				return (Criteria) this;
			}

		public Criteria andRateIn (List <BigDecimal> values)
			{
				addCriterion ("rate in" , values , "rate");
				return (Criteria) this;
			}

		public Criteria andRateNotIn (List <BigDecimal> values)
			{
				addCriterion ("rate not in" , values , "rate");
				return (Criteria) this;
			}

		public Criteria andRateBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("rate between" , value1 , value2 , "rate");
				return (Criteria) this;
			}

		public Criteria andRateNotBetween (BigDecimal value1 , BigDecimal value2)
			{
				addCriterion ("rate not between" , value1 , value2 , "rate");
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

		public Criteria andModuleIdEqualTo (Long value)
			{
				addCriterion ("module_id =" , value , "moduleId");
				return (Criteria) this;
			}

		public Criteria andModuleIdNotEqualTo (Long value)
			{
				addCriterion ("module_id <>" , value , "moduleId");
				return (Criteria) this;
			}

		public Criteria andModuleIdGreaterThan (Long value)
			{
				addCriterion ("module_id >" , value , "moduleId");
				return (Criteria) this;
			}

		public Criteria andModuleIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("module_id >=" , value , "moduleId");
				return (Criteria) this;
			}

		public Criteria andModuleIdLessThan (Long value)
			{
				addCriterion ("module_id <" , value , "moduleId");
				return (Criteria) this;
			}

		public Criteria andModuleIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("module_id <=" , value , "moduleId");
				return (Criteria) this;
			}

		public Criteria andModuleIdIn (List <Long> values)
			{
				addCriterion ("module_id in" , values , "moduleId");
				return (Criteria) this;
			}

		public Criteria andModuleIdNotIn (List <Long> values)
			{
				addCriterion ("module_id not in" , values , "moduleId");
				return (Criteria) this;
			}

		public Criteria andModuleIdBetween (Long value1 , Long value2)
			{
				addCriterion ("module_id between" , value1 , value2 , "moduleId");
				return (Criteria) this;
			}

		public Criteria andModuleIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("module_id not between" , value1 , value2 , "moduleId");
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