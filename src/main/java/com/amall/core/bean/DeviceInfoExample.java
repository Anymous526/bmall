package com.amall.core.bean;

import java.util.ArrayList;
import java.util.List;
import com.amall.core.web.BaseQuery;

public class DeviceInfoExample extends BaseQuery
{

	private static final long serialVersionUID = 1L;

	protected String orderByClause;

	protected boolean distinct;

	protected List <Criteria> oredCriteria;

	public DeviceInfoExample ( )
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

		public Criteria andAddTimeEqualTo (String value)
			{
				addCriterion ("add_time =" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeNotEqualTo (String value)
			{
				addCriterion ("add_time <>" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeGreaterThan (String value)
			{
				addCriterion ("add_time >" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeGreaterThanOrEqualTo (String value)
			{
				addCriterion ("add_time >=" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeLessThan (String value)
			{
				addCriterion ("add_time <" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeLessThanOrEqualTo (String value)
			{
				addCriterion ("add_time <=" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeLike (String value)
			{
				addCriterion ("add_time like" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeNotLike (String value)
			{
				addCriterion ("add_time not like" , value , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeIn (List <String> values)
			{
				addCriterion ("add_time in" , values , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeNotIn (List <String> values)
			{
				addCriterion ("add_time not in" , values , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeBetween (String value1 , String value2)
			{
				addCriterion ("add_time between" , value1 , value2 , "addTime");
				return (Criteria) this;
			}

		public Criteria andAddTimeNotBetween (String value1 , String value2)
			{
				addCriterion ("add_time not between" , value1 , value2 , "addTime");
				return (Criteria) this;
			}

		public Criteria andTokenIsNull ( )
			{
				addCriterion ("token is null");
				return (Criteria) this;
			}

		public Criteria andTokenIsNotNull ( )
			{
				addCriterion ("token is not null");
				return (Criteria) this;
			}

		public Criteria andTokenEqualTo (String value)
			{
				addCriterion ("token =" , value , "token");
				return (Criteria) this;
			}

		public Criteria andTokenNotEqualTo (String value)
			{
				addCriterion ("token <>" , value , "token");
				return (Criteria) this;
			}

		public Criteria andTokenGreaterThan (String value)
			{
				addCriterion ("token >" , value , "token");
				return (Criteria) this;
			}

		public Criteria andTokenGreaterThanOrEqualTo (String value)
			{
				addCriterion ("token >=" , value , "token");
				return (Criteria) this;
			}

		public Criteria andTokenLessThan (String value)
			{
				addCriterion ("token <" , value , "token");
				return (Criteria) this;
			}

		public Criteria andTokenLessThanOrEqualTo (String value)
			{
				addCriterion ("token <=" , value , "token");
				return (Criteria) this;
			}

		public Criteria andTokenLike (String value)
			{
				addCriterion ("token like" , value , "token");
				return (Criteria) this;
			}

		public Criteria andTokenNotLike (String value)
			{
				addCriterion ("token not like" , value , "token");
				return (Criteria) this;
			}

		public Criteria andTokenIn (List <String> values)
			{
				addCriterion ("token in" , values , "token");
				return (Criteria) this;
			}

		public Criteria andTokenNotIn (List <String> values)
			{
				addCriterion ("token not in" , values , "token");
				return (Criteria) this;
			}

		public Criteria andTokenBetween (String value1 , String value2)
			{
				addCriterion ("token between" , value1 , value2 , "token");
				return (Criteria) this;
			}

		public Criteria andTokenNotBetween (String value1 , String value2)
			{
				addCriterion ("token not between" , value1 , value2 , "token");
				return (Criteria) this;
			}

		public Criteria andSercretIsNull ( )
			{
				addCriterion ("sercret is null");
				return (Criteria) this;
			}

		public Criteria andSercretIsNotNull ( )
			{
				addCriterion ("sercret is not null");
				return (Criteria) this;
			}

		public Criteria andSercretEqualTo (String value)
			{
				addCriterion ("sercret =" , value , "sercret");
				return (Criteria) this;
			}

		public Criteria andSercretNotEqualTo (String value)
			{
				addCriterion ("sercret <>" , value , "sercret");
				return (Criteria) this;
			}

		public Criteria andSercretGreaterThan (String value)
			{
				addCriterion ("sercret >" , value , "sercret");
				return (Criteria) this;
			}

		public Criteria andSercretGreaterThanOrEqualTo (String value)
			{
				addCriterion ("sercret >=" , value , "sercret");
				return (Criteria) this;
			}

		public Criteria andSercretLessThan (String value)
			{
				addCriterion ("sercret <" , value , "sercret");
				return (Criteria) this;
			}

		public Criteria andSercretLessThanOrEqualTo (String value)
			{
				addCriterion ("sercret <=" , value , "sercret");
				return (Criteria) this;
			}

		public Criteria andSercretLike (String value)
			{
				addCriterion ("sercret like" , value , "sercret");
				return (Criteria) this;
			}

		public Criteria andSercretNotLike (String value)
			{
				addCriterion ("sercret not like" , value , "sercret");
				return (Criteria) this;
			}

		public Criteria andSercretIn (List <String> values)
			{
				addCriterion ("sercret in" , values , "sercret");
				return (Criteria) this;
			}

		public Criteria andSercretNotIn (List <String> values)
			{
				addCriterion ("sercret not in" , values , "sercret");
				return (Criteria) this;
			}

		public Criteria andSercretBetween (String value1 , String value2)
			{
				addCriterion ("sercret between" , value1 , value2 , "sercret");
				return (Criteria) this;
			}

		public Criteria andSercretNotBetween (String value1 , String value2)
			{
				addCriterion ("sercret not between" , value1 , value2 , "sercret");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoIsNull ( )
			{
				addCriterion ("device_info is null");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoIsNotNull ( )
			{
				addCriterion ("device_info is not null");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoEqualTo (String value)
			{
				addCriterion ("device_info =" , value , "deviceInfo");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoNotEqualTo (String value)
			{
				addCriterion ("device_info <>" , value , "deviceInfo");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoGreaterThan (String value)
			{
				addCriterion ("device_info >" , value , "deviceInfo");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoGreaterThanOrEqualTo (String value)
			{
				addCriterion ("device_info >=" , value , "deviceInfo");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoLessThan (String value)
			{
				addCriterion ("device_info <" , value , "deviceInfo");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoLessThanOrEqualTo (String value)
			{
				addCriterion ("device_info <=" , value , "deviceInfo");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoLike (String value)
			{
				addCriterion ("device_info like" , value , "deviceInfo");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoNotLike (String value)
			{
				addCriterion ("device_info not like" , value , "deviceInfo");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoIn (List <String> values)
			{
				addCriterion ("device_info in" , values , "deviceInfo");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoNotIn (List <String> values)
			{
				addCriterion ("device_info not in" , values , "deviceInfo");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoBetween (String value1 , String value2)
			{
				addCriterion ("device_info between" , value1 , value2 , "deviceInfo");
				return (Criteria) this;
			}

		public Criteria andDeviceInfoNotBetween (String value1 , String value2)
			{
				addCriterion ("device_info not between" , value1 , value2 , "deviceInfo");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeIsNull ( )
			{
				addCriterion ("device_type is null");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeIsNotNull ( )
			{
				addCriterion ("device_type is not null");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeEqualTo (String value)
			{
				addCriterion ("device_type =" , value , "deviceType");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeNotEqualTo (String value)
			{
				addCriterion ("device_type <>" , value , "deviceType");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeGreaterThan (String value)
			{
				addCriterion ("device_type >" , value , "deviceType");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeGreaterThanOrEqualTo (String value)
			{
				addCriterion ("device_type >=" , value , "deviceType");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeLessThan (String value)
			{
				addCriterion ("device_type <" , value , "deviceType");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeLessThanOrEqualTo (String value)
			{
				addCriterion ("device_type <=" , value , "deviceType");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeLike (String value)
			{
				addCriterion ("device_type like" , value , "deviceType");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeNotLike (String value)
			{
				addCriterion ("device_type not like" , value , "deviceType");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeIn (List <String> values)
			{
				addCriterion ("device_type in" , values , "deviceType");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeNotIn (List <String> values)
			{
				addCriterion ("device_type not in" , values , "deviceType");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeBetween (String value1 , String value2)
			{
				addCriterion ("device_type between" , value1 , value2 , "deviceType");
				return (Criteria) this;
			}

		public Criteria andDeviceTypeNotBetween (String value1 , String value2)
			{
				addCriterion ("device_type not between" , value1 , value2 , "deviceType");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionIsNull ( )
			{
				addCriterion ("device_system_version is null");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionIsNotNull ( )
			{
				addCriterion ("device_system_version is not null");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionEqualTo (String value)
			{
				addCriterion ("device_system_version =" , value , "deviceSystemVersion");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionNotEqualTo (String value)
			{
				addCriterion ("device_system_version <>" , value , "deviceSystemVersion");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionGreaterThan (String value)
			{
				addCriterion ("device_system_version >" , value , "deviceSystemVersion");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionGreaterThanOrEqualTo (String value)
			{
				addCriterion ("device_system_version >=" , value , "deviceSystemVersion");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionLessThan (String value)
			{
				addCriterion ("device_system_version <" , value , "deviceSystemVersion");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionLessThanOrEqualTo (String value)
			{
				addCriterion ("device_system_version <=" , value , "deviceSystemVersion");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionLike (String value)
			{
				addCriterion ("device_system_version like" , value , "deviceSystemVersion");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionNotLike (String value)
			{
				addCriterion ("device_system_version not like" , value , "deviceSystemVersion");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionIn (List <String> values)
			{
				addCriterion ("device_system_version in" , values , "deviceSystemVersion");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionNotIn (List <String> values)
			{
				addCriterion ("device_system_version not in" , values , "deviceSystemVersion");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionBetween (String value1 , String value2)
			{
				addCriterion ("device_system_version between" , value1 , value2 , "deviceSystemVersion");
				return (Criteria) this;
			}

		public Criteria andDeviceSystemVersionNotBetween (String value1 , String value2)
			{
				addCriterion ("device_system_version not between" , value1 , value2 , "deviceSystemVersion");
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

		public Criteria andAppVersionIsNull ( )
			{
				addCriterion ("app_version is null");
				return (Criteria) this;
			}

		public Criteria andAppVersionIsNotNull ( )
			{
				addCriterion ("app_version is not null");
				return (Criteria) this;
			}

		public Criteria andAppVersionEqualTo (String value)
			{
				addCriterion ("app_version =" , value , "appVersion");
				return (Criteria) this;
			}

		public Criteria andAppVersionNotEqualTo (String value)
			{
				addCriterion ("app_version <>" , value , "appVersion");
				return (Criteria) this;
			}

		public Criteria andAppVersionGreaterThan (String value)
			{
				addCriterion ("app_version >" , value , "appVersion");
				return (Criteria) this;
			}

		public Criteria andAppVersionGreaterThanOrEqualTo (String value)
			{
				addCriterion ("app_version >=" , value , "appVersion");
				return (Criteria) this;
			}

		public Criteria andAppVersionLessThan (String value)
			{
				addCriterion ("app_version <" , value , "appVersion");
				return (Criteria) this;
			}

		public Criteria andAppVersionLessThanOrEqualTo (String value)
			{
				addCriterion ("app_version <=" , value , "appVersion");
				return (Criteria) this;
			}

		public Criteria andAppVersionLike (String value)
			{
				addCriterion ("app_version like" , value , "appVersion");
				return (Criteria) this;
			}

		public Criteria andAppVersionNotLike (String value)
			{
				addCriterion ("app_version not like" , value , "appVersion");
				return (Criteria) this;
			}

		public Criteria andAppVersionIn (List <String> values)
			{
				addCriterion ("app_version in" , values , "appVersion");
				return (Criteria) this;
			}

		public Criteria andAppVersionNotIn (List <String> values)
			{
				addCriterion ("app_version not in" , values , "appVersion");
				return (Criteria) this;
			}

		public Criteria andAppVersionBetween (String value1 , String value2)
			{
				addCriterion ("app_version between" , value1 , value2 , "appVersion");
				return (Criteria) this;
			}

		public Criteria andAppVersionNotBetween (String value1 , String value2)
			{
				addCriterion ("app_version not between" , value1 , value2 , "appVersion");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidIsNull ( )
			{
				addCriterion ("device_uuid is null");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidIsNotNull ( )
			{
				addCriterion ("device_uuid is not null");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidEqualTo (String value)
			{
				addCriterion ("device_uuid =" , value , "deviceUuid");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidNotEqualTo (String value)
			{
				addCriterion ("device_uuid <>" , value , "deviceUuid");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidGreaterThan (String value)
			{
				addCriterion ("device_uuid >" , value , "deviceUuid");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidGreaterThanOrEqualTo (String value)
			{
				addCriterion ("device_uuid >=" , value , "deviceUuid");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidLessThan (String value)
			{
				addCriterion ("device_uuid <" , value , "deviceUuid");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidLessThanOrEqualTo (String value)
			{
				addCriterion ("device_uuid <=" , value , "deviceUuid");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidLike (String value)
			{
				addCriterion ("device_uuid like" , value , "deviceUuid");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidNotLike (String value)
			{
				addCriterion ("device_uuid not like" , value , "deviceUuid");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidIn (List <String> values)
			{
				addCriterion ("device_uuid in" , values , "deviceUuid");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidNotIn (List <String> values)
			{
				addCriterion ("device_uuid not in" , values , "deviceUuid");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidBetween (String value1 , String value2)
			{
				addCriterion ("device_uuid between" , value1 , value2 , "deviceUuid");
				return (Criteria) this;
			}

		public Criteria andDeviceUuidNotBetween (String value1 , String value2)
			{
				addCriterion ("device_uuid not between" , value1 , value2 , "deviceUuid");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandIsNull ( )
			{
				addCriterion ("device_brand is null");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandIsNotNull ( )
			{
				addCriterion ("device_brand is not null");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandEqualTo (String value)
			{
				addCriterion ("device_brand =" , value , "deviceBrand");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandNotEqualTo (String value)
			{
				addCriterion ("device_brand <>" , value , "deviceBrand");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandGreaterThan (String value)
			{
				addCriterion ("device_brand >" , value , "deviceBrand");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandGreaterThanOrEqualTo (String value)
			{
				addCriterion ("device_brand >=" , value , "deviceBrand");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandLessThan (String value)
			{
				addCriterion ("device_brand <" , value , "deviceBrand");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandLessThanOrEqualTo (String value)
			{
				addCriterion ("device_brand <=" , value , "deviceBrand");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandLike (String value)
			{
				addCriterion ("device_brand like" , value , "deviceBrand");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandNotLike (String value)
			{
				addCriterion ("device_brand not like" , value , "deviceBrand");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandIn (List <String> values)
			{
				addCriterion ("device_brand in" , values , "deviceBrand");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandNotIn (List <String> values)
			{
				addCriterion ("device_brand not in" , values , "deviceBrand");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandBetween (String value1 , String value2)
			{
				addCriterion ("device_brand between" , value1 , value2 , "deviceBrand");
				return (Criteria) this;
			}

		public Criteria andDeviceBrandNotBetween (String value1 , String value2)
			{
				addCriterion ("device_brand not between" , value1 , value2 , "deviceBrand");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdIsNull ( )
			{
				addCriterion ("registration_ID is null");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdIsNotNull ( )
			{
				addCriterion ("registration_ID is not null");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdEqualTo (String value)
			{
				addCriterion ("registration_ID =" , value , "registrationId");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdNotEqualTo (String value)
			{
				addCriterion ("registration_ID <>" , value , "registrationId");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdGreaterThan (String value)
			{
				addCriterion ("registration_ID >" , value , "registrationId");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdGreaterThanOrEqualTo (String value)
			{
				addCriterion ("registration_ID >=" , value , "registrationId");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdLessThan (String value)
			{
				addCriterion ("registration_ID <" , value , "registrationId");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdLessThanOrEqualTo (String value)
			{
				addCriterion ("registration_ID <=" , value , "registrationId");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdLike (String value)
			{
				addCriterion ("registration_ID like" , value , "registrationId");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdNotLike (String value)
			{
				addCriterion ("registration_ID not like" , value , "registrationId");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdIn (List <String> values)
			{
				addCriterion ("registration_ID in" , values , "registrationId");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdNotIn (List <String> values)
			{
				addCriterion ("registration_ID not in" , values , "registrationId");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdBetween (String value1 , String value2)
			{
				addCriterion ("registration_ID between" , value1 , value2 , "registrationId");
				return (Criteria) this;
			}

		public Criteria andRegistrationIdNotBetween (String value1 , String value2)
			{
				addCriterion ("registration_ID not between" , value1 , value2 , "registrationId");
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