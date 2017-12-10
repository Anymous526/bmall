package com.amall.core.web.virtual;

/**
 * 
 * <p>Title: SysMap</p>
 * <p>Description: 作用与Map一样，此类为了更方便设置map的key和value</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-27下午6:27:36
 * @version 1.0
 */
public class SysMap {
	private Object key;
	private Object value;

	public SysMap() {
	}

	public SysMap(Object key, Object value) {
		this.key = key;
		this.value = value;
	}

	public Object getKey() {
		return this.key;
	}

	public void setKey(Object key) {
		this.key = key;
	}

	public Object getValue() {
		return this.value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}
