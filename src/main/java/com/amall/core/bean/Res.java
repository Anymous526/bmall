package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Transient;
import org.apache.commons.lang.StringUtils;

public class Res implements Serializable
{

	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date addtime;

	private Boolean deletestatus;

	private String info;

	private String resname;

	private Integer sequence;

	private String type;

	private String value;

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

	public String getInfo ( )
		{
			return info;
		}

	public void setInfo (String info)
		{
			this.info = info == null ? null : info.trim ();
		}

	public String getResname ( )
		{
			return resname;
		}

	public void setResname (String resname)
		{
			this.resname = resname == null ? null : resname.trim ();
		}

	public Integer getSequence ( )
		{
			return sequence;
		}

	public void setSequence (Integer sequence)
		{
			this.sequence = sequence;
		}

	public String getType ( )
		{
			return type;
		}

	public void setType (String type)
		{
			this.type = type == null ? null : type.trim ();
		}

	public String getValue ( )
		{
			return value;
		}

	public void setValue (String value)
		{
			this.value = value == null ? null : value.trim ();
		}

	/**
	 * 
	 * <p>
	 * Title: getRoleAuthorities
	 * </p>
	 * <p>
	 * Description: 获得所有角色，每个权限之间用'，'隔开
	 * </p>
	 * 
	 * @return
	 */
	@Transient
	public String getRoleAuthorities ( )
		{
			List <String> roleAuthorities = new ArrayList <String> ();
			for (Role role : this.roles)
			{
				roleAuthorities.add (role.getRolecode ());      // 将所有角色添加到集合中
			}
			return StringUtils.join (roleAuthorities.toArray () , ",");   // 将集合转换为Spring，其元素用 ',' 隔开
		}

	// ManyToMany
	private List <Role> roles = new ArrayList <Role> ();

	public List <Role> getRoles ( )
		{
			return roles;
		}

	public void setRoles (List <Role> roles)
		{
			this.roles = roles;
		}
}