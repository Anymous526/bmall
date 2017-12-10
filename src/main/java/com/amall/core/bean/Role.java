package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 角色信息
 * @author ljx
 *
 */
public class Role implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Boolean display;

    private String info;

    private String rolecode;

    private String rolename;  //角色名称

    private Integer sequence;	//序号

    private String type;		//类型

    private Long rgId;			

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Boolean getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Boolean deletestatus) {
        this.deletestatus = deletestatus;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info == null ? null : info.trim();
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getRgId() {
        return rgId;
    }

    public void setRgId(Long rgId) {
        this.rgId = rgId;
    }
    
    
    private List<Res> reses = new ArrayList<Res>();
    private RoleGroup rg;
    
    //用户 角色  多对多
    private List<User> users = new ArrayList<User>();
    
    
    
    
	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Res> getReses() {
		return reses;
	}

	public void setReses(List<Res> reses) {
		this.reses = reses;
	}

	public RoleGroup getRg() {
		return rg;
	}

	public void setRg(RoleGroup rg) {
		this.rg = rg;
		if(rg !=null)
			this.rgId = rg.getId();
	}
    
    
}