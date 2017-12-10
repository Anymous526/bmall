package com.amall.core.bean;

import java.util.List;



/**
 * 
 * <p>Title: StoreClassWithBLOBs</p>
 * <p>Description: </p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  李越
 * @date	2015年6月4日下午1:56:32
 * @version 1.0
 */
public class StoreClassWithBLOBs extends StoreClass {

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	private List<StoreClass> childs;

	public List<StoreClass> getChilds() {
		return childs;
	}

	public void setChilds(List<StoreClass> childs) {
		this.childs = childs;
	}
	
	
	
	
	
	
	
	
	
	
	
}
