package com.amall.core.web.tools.database;

/**
 * 
 * <p>Title: TableColumn</p>
 * <p>Description: 数据库表中的列信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午12:03:37
 * @version 1.0
 */
public class TableColumn {
	//列字段
	private String columnsFiled;
	//列sql类型
	private String columnsType;
	
	private String columnsNull;
	
	private String columnsKey;
	//默认
	private String columnsDefault;
	//其他
	private String columnsExtra;

	public String getColumnsFiled() {
		return this.columnsFiled;
	}

	public void setColumnsFiled(String columnsFiled) {
		this.columnsFiled = columnsFiled;
	}

	public String getColumnsType() {
		return this.columnsType;
	}

	public void setColumnsType(String columnsType) {
		this.columnsType = columnsType;
	}

	public String getColumnsNull() {
		return this.columnsNull;
	}

	public void setColumnsNull(String columnsNull) {
		this.columnsNull = columnsNull;
	}

	public String getColumnsKey() {
		return this.columnsKey;
	}

	public void setColumnsKey(String columnsKey) {
		this.columnsKey = columnsKey;
	}

	public String getColumnsDefault() {
		return this.columnsDefault;
	}

	public void setColumnsDefault(String columnsDefault) {
		this.columnsDefault = columnsDefault;
	}

	public String getColumnsExtra() {
		return this.columnsExtra;
	}

	public void setColumnsExtra(String columnsExtra) {
		this.columnsExtra = columnsExtra;
	}
}
