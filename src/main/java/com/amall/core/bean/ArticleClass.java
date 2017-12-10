package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 
 * <p>Title: ArticleClass</p>
 * <p>Description: 文章分类信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月9日下午2:47:47
 * @version 1.0
 */

public class ArticleClass implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String classname;	//分类名称

    private Integer level;		//等级

    private String mark;

    private Integer sequence;

    private Boolean sysclass;

    private Long parentId;		//上级分类外间id

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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Boolean getSysclass() {
        return sysclass;
    }

    public void setSysclass(Boolean sysclass) {
        this.sysclass = sysclass;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    
    
    
    
    private List<Article> articles = new ArrayList<Article>();
    private List<ArticleClass> childs = new ArrayList<ArticleClass>();
    private ArticleClass parent;

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<ArticleClass> getChilds() {
		return childs;
	}

	public void setChilds(List<ArticleClass> childs) {
		this.childs = childs;
	}

	public ArticleClass getParent() {
		return parent;
	}

	public void setParent(ArticleClass parent) {
		this.parent = parent;
		if (parent != null)
			this.parentId = parent.getId();
	}
    
    
}