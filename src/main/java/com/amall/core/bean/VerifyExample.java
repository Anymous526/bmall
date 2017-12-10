package com.amall.core.bean;

import java.util.ArrayList;
import java.util.List;
import com.amall.core.web.BaseQuery;

public class VerifyExample extends BaseQuery
{

	private static final long serialVersionUID = 1082497230498547558L;

	protected String orderByClause;

	protected boolean distinct;

	protected List <Criteria> oredCriteria;

	public VerifyExample ( )
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

		public Criteria andPhotoIdIsNull ( )
			{
				addCriterion ("photo_id is null");
				return (Criteria) this;
			}

		public Criteria andPhotoIdIsNotNull ( )
			{
				addCriterion ("photo_id is not null");
				return (Criteria) this;
			}

		public Criteria andPhotoIdEqualTo (Long value)
			{
				addCriterion ("photo_id =" , value , "photoId");
				return (Criteria) this;
			}

		public Criteria andPhotoIdNotEqualTo (Long value)
			{
				addCriterion ("photo_id <>" , value , "photoId");
				return (Criteria) this;
			}

		public Criteria andPhotoIdGreaterThan (Long value)
			{
				addCriterion ("photo_id >" , value , "photoId");
				return (Criteria) this;
			}

		public Criteria andPhotoIdGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("photo_id >=" , value , "photoId");
				return (Criteria) this;
			}

		public Criteria andPhotoIdLessThan (Long value)
			{
				addCriterion ("photo_id <" , value , "photoId");
				return (Criteria) this;
			}

		public Criteria andPhotoIdLessThanOrEqualTo (Long value)
			{
				addCriterion ("photo_id <=" , value , "photoId");
				return (Criteria) this;
			}

		public Criteria andPhotoIdIn (List <Long> values)
			{
				addCriterion ("photo_id in" , values , "photoId");
				return (Criteria) this;
			}

		public Criteria andPhotoIdNotIn (List <Long> values)
			{
				addCriterion ("photo_id not in" , values , "photoId");
				return (Criteria) this;
			}

		public Criteria andPhotoIdBetween (Long value1 , Long value2)
			{
				addCriterion ("photo_id between" , value1 , value2 , "photoId");
				return (Criteria) this;
			}

		public Criteria andPhotoIdNotBetween (Long value1 , Long value2)
			{
				addCriterion ("photo_id not between" , value1 , value2 , "photoId");
				return (Criteria) this;
			}

		public Criteria andVerifyNameIsNull ( )
			{
				addCriterion ("verify_name is null");
				return (Criteria) this;
			}

		public Criteria andVerifyNameIsNotNull ( )
			{
				addCriterion ("verify_name is not null");
				return (Criteria) this;
			}

		public Criteria andVerifyNameEqualTo (String value)
			{
				addCriterion ("verify_name =" , value , "verifyName");
				return (Criteria) this;
			}

		public Criteria andVerifyNameNotEqualTo (String value)
			{
				addCriterion ("verify_name <>" , value , "verifyName");
				return (Criteria) this;
			}

		public Criteria andVerifyNameGreaterThan (String value)
			{
				addCriterion ("verify_name >" , value , "verifyName");
				return (Criteria) this;
			}

		public Criteria andVerifyNameGreaterThanOrEqualTo (String value)
			{
				addCriterion ("verify_name >=" , value , "verifyName");
				return (Criteria) this;
			}

		public Criteria andVerifyNameLessThan (String value)
			{
				addCriterion ("verify_name <" , value , "verifyName");
				return (Criteria) this;
			}

		public Criteria andVerifyNameLessThanOrEqualTo (String value)
			{
				addCriterion ("verify_name <=" , value , "verifyName");
				return (Criteria) this;
			}

		public Criteria andVerifyNameLike (String value)
			{
				addCriterion ("verify_name like" , value , "verifyName");
				return (Criteria) this;
			}

		public Criteria andVerifyNameNotLike (String value)
			{
				addCriterion ("verify_name not like" , value , "verifyName");
				return (Criteria) this;
			}

		public Criteria andVerifyNameIn (List <String> values)
			{
				addCriterion ("verify_name in" , values , "verifyName");
				return (Criteria) this;
			}

		public Criteria andVerifyNameNotIn (List <String> values)
			{
				addCriterion ("verify_name not in" , values , "verifyName");
				return (Criteria) this;
			}

		public Criteria andVerifyNameBetween (String value1 , String value2)
			{
				addCriterion ("verify_name between" , value1 , value2 , "verifyName");
				return (Criteria) this;
			}

		public Criteria andVerifyNameNotBetween (String value1 , String value2)
			{
				addCriterion ("verify_name not between" , value1 , value2 , "verifyName");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeIsNull ( )
			{
				addCriterion ("verify_code is null");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeIsNotNull ( )
			{
				addCriterion ("verify_code is not null");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeEqualTo (String value)
			{
				addCriterion ("verify_code =" , value , "verifyCode");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeNotEqualTo (String value)
			{
				addCriterion ("verify_code <>" , value , "verifyCode");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeGreaterThan (String value)
			{
				addCriterion ("verify_code >" , value , "verifyCode");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeGreaterThanOrEqualTo (String value)
			{
				addCriterion ("verify_code >=" , value , "verifyCode");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeLessThan (String value)
			{
				addCriterion ("verify_code <" , value , "verifyCode");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeLessThanOrEqualTo (String value)
			{
				addCriterion ("verify_code <=" , value , "verifyCode");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeLike (String value)
			{
				addCriterion ("verify_code like" , value , "verifyCode");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeNotLike (String value)
			{
				addCriterion ("verify_code not like" , value , "verifyCode");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeIn (List <String> values)
			{
				addCriterion ("verify_code in" , values , "verifyCode");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeNotIn (List <String> values)
			{
				addCriterion ("verify_code not in" , values , "verifyCode");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeBetween (String value1 , String value2)
			{
				addCriterion ("verify_code between" , value1 , value2 , "verifyCode");
				return (Criteria) this;
			}

		public Criteria andVerifyCodeNotBetween (String value1 , String value2)
			{
				addCriterion ("verify_code not between" , value1 , value2 , "verifyCode");
				return (Criteria) this;
			}

		public Criteria andVerifyStatusIsNull ( )
			{
				addCriterion ("verify_status is null");
				return (Criteria) this;
			}

		public Criteria andVerifyStatusIsNotNull ( )
			{
				addCriterion ("verify_status is not null");
				return (Criteria) this;
			}

		public Criteria andVerifyStatusEqualTo (Long value)
			{
				addCriterion ("verify_status =" , value , "verifyStatus");
				return (Criteria) this;
			}

		public Criteria andVerifyStatusNotEqualTo (Long value)
			{
				addCriterion ("verify_status <>" , value , "verifyStatus");
				return (Criteria) this;
			}

		public Criteria andVerifyStatusGreaterThan (Long value)
			{
				addCriterion ("verify_status >" , value , "verifyStatus");
				return (Criteria) this;
			}

		public Criteria andVerifyStatusGreaterThanOrEqualTo (Long value)
			{
				addCriterion ("verify_status >=" , value , "verifyStatus");
				return (Criteria) this;
			}

		public Criteria andVerifyStatusLessThan (Long value)
			{
				addCriterion ("verify_status <" , value , "verifyStatus");
				return (Criteria) this;
			}

		public Criteria andVerifyStatusLessThanOrEqualTo (Long value)
			{
				addCriterion ("verify_status <=" , value , "verifyStatus");
				return (Criteria) this;
			}

		public Criteria andVerifyStatusIn (List <Long> values)
			{
				addCriterion ("verify_status in" , values , "verifyStatus");
				return (Criteria) this;
			}

		public Criteria andVerifyStatusNotIn (List <Long> values)
			{
				addCriterion ("verify_status not in" , values , "verifyStatus");
				return (Criteria) this;
			}

		public Criteria andVerifyStatusBetween (Long value1 , Long value2)
			{
				addCriterion ("verify_status between" , value1 , value2 , "verifyStatus");
				return (Criteria) this;
			}

		public Criteria andVerifyStatusNotBetween (Long value1 , Long value2)
			{
				addCriterion ("verify_status not between" , value1 , value2 , "verifyStatus");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkIsNull ( )
			{
				addCriterion ("verify_remark is null");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkIsNotNull ( )
			{
				addCriterion ("verify_remark is not null");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkEqualTo (String value)
			{
				addCriterion ("verify_remark =" , value , "verifyRemark");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkNotEqualTo (String value)
			{
				addCriterion ("verify_remark <>" , value , "verifyRemark");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkGreaterThan (String value)
			{
				addCriterion ("verify_remark >" , value , "verifyRemark");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkGreaterThanOrEqualTo (String value)
			{
				addCriterion ("verify_remark >=" , value , "verifyRemark");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkLessThan (String value)
			{
				addCriterion ("verify_remark <" , value , "verifyRemark");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkLessThanOrEqualTo (String value)
			{
				addCriterion ("verify_remark <=" , value , "verifyRemark");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkLike (String value)
			{
				addCriterion ("verify_remark like" , value , "verifyRemark");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkNotLike (String value)
			{
				addCriterion ("verify_remark not like" , value , "verifyRemark");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkIn (List <String> values)
			{
				addCriterion ("verify_remark in" , values , "verifyRemark");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkNotIn (List <String> values)
			{
				addCriterion ("verify_remark not in" , values , "verifyRemark");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkBetween (String value1 , String value2)
			{
				addCriterion ("verify_remark between" , value1 , value2 , "verifyRemark");
				return (Criteria) this;
			}

		public Criteria andVerifyRemarkNotBetween (String value1 , String value2)
			{
				addCriterion ("verify_remark not between" , value1 , value2 , "verifyRemark");
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