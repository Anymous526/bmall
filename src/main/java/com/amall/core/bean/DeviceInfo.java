package com.amall.core.bean;

import java.io.Serializable;

public class DeviceInfo implements Serializable
{

	private static final long serialVersionUID = 1L;

	private Long id;

	private String addTime;

	private String token;

	private String sercret;

	private String deviceInfo;

	private String deviceType;

	private String deviceSystemVersion;

	private Long userId;

	private String appVersion;

	private String deviceUuid;

	private String deviceBrand;

	private String registrationId;

	public Long getId ( )
		{
			return id;
		}

	public void setId (Long id)
		{
			this.id = id;
		}

	public String getAddTime ( )
		{
			return addTime;
		}

	public void setAddTime (String addTime)
		{
			this.addTime = addTime == null ? null : addTime.trim ();
		}

	public String getToken ( )
		{
			return token;
		}

	public void setToken (String token)
		{
			this.token = token == null ? null : token.trim ();
		}

	public String getSercret ( )
		{
			return sercret;
		}

	public void setSercret (String sercret)
		{
			this.sercret = sercret == null ? null : sercret.trim ();
		}

	public String getDeviceInfo ( )
		{
			return deviceInfo;
		}

	public void setDeviceInfo (String deviceInfo)
		{
			this.deviceInfo = deviceInfo == null ? null : deviceInfo.trim ();
		}

	public String getDeviceType ( )
		{
			return deviceType;
		}

	public void setDeviceType (String deviceType)
		{
			this.deviceType = deviceType == null ? null : deviceType.trim ();
		}

	public String getDeviceSystemVersion ( )
		{
			return deviceSystemVersion;
		}

	public void setDeviceSystemVersion (String deviceSystemVersion)
		{
			this.deviceSystemVersion = deviceSystemVersion == null ? null : deviceSystemVersion.trim ();
		}

	public Long getUserId ( )
		{
			return userId;
		}

	public void setUserId (Long userId)
		{
			this.userId = userId;
		}

	public String getAppVersion ( )
		{
			return appVersion;
		}

	public void setAppVersion (String appVersion)
		{
			this.appVersion = appVersion == null ? null : appVersion.trim ();
		}

	public String getDeviceUuid ( )
		{
			return deviceUuid;
		}

	public void setDeviceUuid (String deviceUuid)
		{
			this.deviceUuid = deviceUuid == null ? null : deviceUuid.trim ();
		}

	public String getDeviceBrand ( )
		{
			return deviceBrand;
		}

	public void setDeviceBrand (String deviceBrand)
		{
			this.deviceBrand = deviceBrand == null ? null : deviceBrand.trim ();
		}

	public String getRegistrationId ( )
		{
			return registrationId;
		}

	public void setRegistrationId (String registrationId)
		{
			this.registrationId = registrationId;
		}
}