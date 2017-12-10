package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;

public class User implements Serializable, UserDetails
{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date addtime;

	private Boolean deletestatus;

	private String msn;// MSN

	private String qq;// QQ

	private String ww;// 旺旺

	private String address;

	private BigDecimal availablebalance;// 总余额/卖家的分成.账户金额.可用余额

	private Date birthday;

	private String email;// 电子邮箱

	private BigDecimal freezeblance;// 买家方的冻结余额

	private Integer gold;// 所拥有的礼品金数

	private Integer integral; // 用户信用值(现为代金券)

	private Integer creditlevel; // 用户信用等级

	private Date lastlogindate;  // 最后登录日期

	private String lastloginip;

	private Integer logincount;  // 登录次数

	private Date logindate;  // 登录时间

	private String loginip;

	private String mobile;// 手机号码

	private String password;// 密码

	private Integer report;// 举报商品

	private Integer sex;// 性别

	private Integer status;  // 状态

	private String telephone;	// 手机号

	private String truename;// 真实姓名

	private String nickname; // 昵称

	private Long directRefer; // 直接推荐人

	private String username;

	private String userrole;  // 角色

	private Integer userCredit;

	private Long photoId;

	private Long storeId;	// 店铺外键id

	private String qqOpenid;

	private String sinaOpenid;

	private Long parentId;

	private Integer years;

	private Long areaId;

	private String storeQuickMenu;		// 店铺快捷菜单设置

	private Long partnerId;   // 分享的会员ID

	private Long did;

	private boolean isShare = false;

	private Integer levelAngel;  // 会员等级

	private Long dreamPartnerId; // 梦想会员主键

	private Long verifyId;

	private String wxOpenid;  // 微信openid

	private BigDecimal historyFee; // 历史获取分利记录

	private BigDecimal currentFee; // 当前可用分利金额

	private String payPassword;	// 余额支付密码

	private Long cityId;	// 城市id

	private Long cityRole;	// 会员id

	private Integer dou;

	private BigDecimal canCarry;

	private BigDecimal manageMoney;

	private Boolean chgTruenameTimes;

	public Long getCityId ( )
		{
			return cityId;
		}

	public void setCityId (Long cityId)
		{
			this.cityId = cityId;
		}

	public Long getCityRole ( )
		{
			return cityRole;
		}

	public void setCityRole (Long cityRole)
		{
			this.cityRole = cityRole;
		}

	public String getPayPassword ( )
		{
			return payPassword;
		}

	public void setPayPassword (String payPassword)
		{
			this.payPassword = payPassword;
		}

	public Long getDid ( )
		{
			return did;
		}

	public void setDid (Long did)
		{
			this.did = did;
		}

	public boolean isShare ( )
		{
			return isShare;
		}

	public void setShare (boolean isShare)
		{
			this.isShare = isShare;
		}

	public Long getPartnerId ( )
		{
			return partnerId;
		}

	public Integer getLevelAngel ( )
		{
			return levelAngel;
		}

	public void setLevelAngel (Integer levelAngel)
		{
			this.levelAngel = levelAngel;
		}

	public void setPartnerId (Long partnerId)
		{
			this.partnerId = partnerId;
		}

	public Long getId ( )
		{
			return id;
		}

	public void setId (Long id)
		{
			this.id = id;
		}

	public Date getAddtime ( )
		{
			return addtime;
		}

	public void setAddtime (Date addtime)
		{
			this.addtime = addtime;
		}

	public Boolean getDeletestatus ( )
		{
			return deletestatus;
		}

	public void setDeletestatus (Boolean deletestatus)
		{
			this.deletestatus = deletestatus;
		}

	public String getMsn ( )
		{
			return msn;
		}

	public void setMsn (String msn)
		{
			this.msn = msn == null ? null : msn.trim ();
		}

	public String getQq ( )
		{
			return qq;
		}

	public void setQq (String qq)
		{
			this.qq = qq == null ? null : qq.trim ();
		}

	public String getWw ( )
		{
			return ww;
		}

	public void setWw (String ww)
		{
			this.ww = ww == null ? null : ww.trim ();
		}

	public String getAddress ( )
		{
			return address;
		}

	public void setAddress (String address)
		{
			this.address = address == null ? null : address.trim ();
		}

	public BigDecimal getAvailablebalance ( )
		{
			return availablebalance;
		}

	public void setAvailablebalance (BigDecimal availablebalance)
		{
			this.availablebalance = availablebalance;
		}

	public Date getBirthday ( )
		{
			return birthday;
		}

	public void setBirthday (Date birthday)
		{
			this.birthday = birthday;
		}

	public String getEmail ( )
		{
			return email;
		}

	public void setEmail (String email)
		{
			this.email = email == null ? null : email.trim ();
		}

	public BigDecimal getFreezeblance ( )
		{
			return freezeblance;
		}

	public void setFreezeblance (BigDecimal freezeblance)
		{
			this.freezeblance = freezeblance;
		}

	public Integer getGold ( )
		{
			return gold;
		}

	public void setGold (Integer gold)
		{
			this.gold = gold;
		}

	public Integer getIntegral ( )
		{
			return integral;
		}

	public void setIntegral (Integer integral)
		{
			this.integral = integral;
		}

	public Integer getCreditlevel ( )
		{
			return creditlevel;
		}

	public void setCreditlevel (Integer creditlevel)
		{
			this.creditlevel = creditlevel;
		}

	public Date getLastlogindate ( )
		{
			return lastlogindate;
		}

	public void setLastlogindate (Date lastlogindate)
		{
			this.lastlogindate = lastlogindate;
		}

	public String getLastloginip ( )
		{
			return lastloginip;
		}

	public void setLastloginip (String lastloginip)
		{
			this.lastloginip = lastloginip == null ? null : lastloginip.trim ();
		}

	public Integer getLogincount ( )
		{
			return logincount;
		}

	public void setLogincount (Integer logincount)
		{
			this.logincount = logincount;
		}

	public Date getLogindate ( )
		{
			return logindate;
		}

	public void setLogindate (Date logindate)
		{
			this.logindate = logindate;
		}

	public String getLoginip ( )
		{
			return loginip;
		}

	public void setLoginip (String loginip)
		{
			this.loginip = loginip == null ? null : loginip.trim ();
		}

	public String getMobile ( )
		{
			return mobile;
		}

	public void setMobile (String mobile)
		{
			this.mobile = mobile == null ? null : mobile.trim ();
		}

	public Long getDreamPartnerId ( )
		{
			return dreamPartnerId;
		}

	public void setDreamPartnerId (Long dreamPartnerId)
		{
			this.dreamPartnerId = dreamPartnerId;
		}

	public String getPassword ( )
		{
			return password;
		}

	public void setPassword (String password)
		{
			this.password = password == null ? null : password.trim ();
		}

	public String getWxOpenid ( )
		{
			return wxOpenid;
		}

	public void setWxOpenid (String wxOpenid)
		{
			this.wxOpenid = wxOpenid == null ? null : wxOpenid.trim ();
		}

	public Integer getReport ( )
		{
			return report;
		}

	public void setReport (Integer report)
		{
			this.report = report;
		}

	public Integer getSex ( )
		{
			return sex;
		}

	public void setSex (Integer sex)
		{
			this.sex = sex;
		}

	public Integer getStatus ( )
		{
			return status;
		}

	public void setStatus (Integer status)
		{
			this.status = status;
		}

	public String getTelephone ( )
		{
			return telephone;
		}

	public void setTelephone (String telephone)
		{
			this.telephone = telephone == null ? null : telephone.trim ();
		}

	public String getTruename ( )
		{
			return truename;
		}

	public void setTruename (String truename)
		{
			this.truename = truename == null ? null : truename.trim ();
		}

	public Long getDirectRefer ( )
		{
			return directRefer;
		}

	public void setDirectRefer (Long directRefer)
		{
			this.directRefer = directRefer;
		}

	public String getUsername ( )
		{
			return username;
		}

	public void setUsername (String username)
		{
			this.username = username == null ? null : username.trim ();
		}

	public String getUserrole ( )
		{
			return userrole;
		}

	public BigDecimal getHistoryFee ( )
		{
			return historyFee;
		}

	public void setHistoryFee (BigDecimal historyFee)
		{
			this.historyFee = historyFee;
		}

	public BigDecimal getCurrentFee ( )
		{
			return currentFee;
		}

	public void setCurrentFee (BigDecimal currentFee)
		{
			this.currentFee = currentFee;
		}

	public void setUserrole (String userrole)
		{
			this.userrole = userrole == null ? null : userrole.trim ();
		}

	public Integer getUserCredit ( )
		{
			return userCredit;
		}

	public void setUserCredit (Integer userCredit)
		{
			this.userCredit = userCredit;
		}

	public Long getPhotoId ( )
		{
			return photoId;
		}

	public void setPhotoId (Long photoId)
		{
			this.photoId = photoId;
		}

	public Long getStoreId ( )
		{
			return storeId;
		}

	public void setStoreId (Long storeId)
		{
			this.storeId = storeId;
		}

	public String getQqOpenid ( )
		{
			return qqOpenid;
		}

	public void setQqOpenid (String qqOpenid)
		{
			this.qqOpenid = qqOpenid == null ? null : qqOpenid.trim ();
		}

	public String getSinaOpenid ( )
		{
			return sinaOpenid;
		}

	public void setSinaOpenid (String sinaOpenid)
		{
			this.sinaOpenid = sinaOpenid == null ? null : sinaOpenid.trim ();
		}

	public Long getParentId ( )
		{
			return parentId;
		}

	public void setParentId (Long parentId)
		{
			this.parentId = parentId;
		}

	public Integer getYears ( )
		{
			return years;
		}

	public void setYears (Integer years)
		{
			this.years = years;
		}

	public Long getAreaId ( )
		{
			return areaId;
		}

	public void setAreaId (Long areaId)
		{
			this.areaId = areaId;
		}

	public Long getVerifyId ( )
		{
			return verifyId;
		}

	public void setVerifyId (Long verifyId)
		{
			this.verifyId = verifyId;
		}

	public String getStoreQuickMenu ( )
		{
			return storeQuickMenu;
		}

	public void setStoreQuickMenu (String storeQuickMenu)
		{
			this.storeQuickMenu = storeQuickMenu == null ? null : storeQuickMenu.trim ();
		}

	private List <Role> roles = new ArrayList <Role> ();

	private GrantedAuthority [ ] authorities = new GrantedAuthority [0];

	public List <Role> getRoles ( )
		{
			return this.roles;
		}

	public void setRoles (List <Role> roles)
		{
			this.roles = roles;
		}

	public Integer getDou ( )
		{
			return dou;
		}

	public void setDou (Integer dou)
		{
			this.dou = dou;
		}

	public BigDecimal getCanCarry ( )
		{
			return canCarry;
		}

	public void setCanCarry (BigDecimal canCarry)
		{
			this.canCarry = canCarry;
		}

	public BigDecimal getManageMoney ( )
		{
			return manageMoney;
		}

	public void setManageMoney (BigDecimal manageMoney)
		{
			this.manageMoney = manageMoney;
		}

	public UserConfig getConfig ( )
		{
			return config;
		}

	public void setConfig (UserConfig config)
		{
			this.config = config;
		}

	public static long getSerialversionuid ( )
		{
			return serialVersionUID;
		}

	public GrantedAuthority [ ] get_all_Authorities ( )
		{
			/*
			 * Map map=new HashMap();
			 * map.put("id", this.getId());
			 * List<Role> rolelist=userService.findRoleByUserId(map);
			 * this.setRoles(rolelist);
			 */
			List <GrantedAuthorityImpl> grantedAuthorities = new ArrayList <GrantedAuthorityImpl> (this.roles.size ());
			for (Role role : this.roles)
			{
				grantedAuthorities.add (new GrantedAuthorityImpl (role.getRolecode ()));
			}
			return (GrantedAuthority [ ]) grantedAuthorities.toArray (new GrantedAuthority [this.roles.size ()]);
		}

	public GrantedAuthority [ ] get_common_Authorities ( )
		{
			/*
			 * Map map=new HashMap();
			 * map.put("id", this.getId());
			 * List<Role> rolelist=userService.findRoleByUserId(map);
			 * this.setRoles(rolelist);
			 */
			List <GrantedAuthorityImpl> grantedAuthorities = new ArrayList <GrantedAuthorityImpl> (this.roles.size ());
			for (Role role : this.roles)
			{
				if (!role.getType ().equals ("ADMIN"))
					grantedAuthorities.add (new GrantedAuthorityImpl (role.getRolecode ()));
			}
			return (GrantedAuthority [ ]) grantedAuthorities.toArray (new GrantedAuthority [grantedAuthorities.size ()]);
		}

	public String getAuthoritiesString ( )
		{
			List <String> authorities = new ArrayList <String> ();
			for (GrantedAuthority authority : getAuthorities ())
			{
				authorities.add (authority.getAuthority ());
			}
			return StringUtils.join (authorities.toArray () , ",");
		}

	public GrantedAuthority [ ] getAuthorities ( )
		{
			return this.authorities;
		}

	public void setAuthorities (GrantedAuthority [ ] authorities)
		{
			this.authorities = authorities;
		}

	private Accessory parent;

	private StoreWithBLOBs store;

	private List <Accessory> files = new ArrayList <Accessory> ();

	private List <User> childs = new ArrayList <User> ();

	private Accessory photo;

	private UserConfig config;

	private List <ChattingLog> chattingLogs = new ArrayList <ChattingLog> ();

	private List <ChattingFriend> chattingFriends = new ArrayList <ChattingFriend> ();

	private List <Chatting> chattings = new ArrayList <Chatting> ();

	public List <Chatting> getChattings ( )
		{
			return chattings;
		}

	public void setChattings (List <Chatting> chattings)
		{
			this.chattings = chattings;
		}

	public List <ChattingFriend> getChattingFriends ( )
		{
			return chattingFriends;
		}

	public void setChattingFriends (List <ChattingFriend> chattingFriends)
		{
			this.chattingFriends = chattingFriends;
		}

	public List <ChattingLog> getChattingLogs ( )
		{
			return chattingLogs;
		}

	public void setChattingLogs (List <ChattingLog> chattingLogs)
		{
			this.chattingLogs = chattingLogs;
		}

	public Accessory getPhoto ( )
		{
			return photo;
		}

	public void setPhoto (Accessory photo)
		{
			this.photo = photo;
		}

	public List <Accessory> getFiles ( )
		{
			return files;
		}

	public void setFiles (List <Accessory> files)
		{
			this.files = files;
		}

	public List <User> getChilds ( )
		{
			return childs;
		}

	public void setChilds (List <User> childs)
		{
			this.childs = childs;
		}
	
	public void setParent (Accessory parent)
		{
			this.parent = parent;
			this.parentId = parent.getId ();
		}

	public void setStore (StoreWithBLOBs store)
		{
			this.store = store;
			if (store != null)
			{
				this.storeId = store.getId ();
			}
		}

	public StoreWithBLOBs getStore ( )
		{
		
			return this.store;
		}

	public Accessory getParent ( )
		{
			return this.parent;
		}

	public boolean isAccountNonExpired ( )
		{
			return true;
		}

	public boolean isAccountNonLocked ( )
		{
			return true;
		}

	public boolean isCredentialsNonExpired ( )
		{
			return true;
		}

	public boolean isEnabled ( )
		{
			return true;
		}

	public String getNickname ( )
		{
			return nickname;
		}

	public void setNickname (String nickname)
		{
			this.nickname = nickname;
		}

	public Boolean getChgTruenameTimes ( )
		{
			return chgTruenameTimes;
		}

	public void setChgTruenameTimes (Boolean chgTruenameTimes)
		{
			this.chgTruenameTimes = chgTruenameTimes;
		}
}