package com.amall.core.web.tools.database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amall.core.web.tools.UnicodeReader;

/**
 * 
 * <p>Title: PublicMethod</p>
 * <p>Description: 数据库的连接、关闭 sql执行、结果返回等一些操作</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午1:56:00
 * @version 1.0
 */
@Repository
public class PublicMethod {

	@Autowired
	private DbConnection dbConnectoin;
	private static Connection conn = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	/**
	 * 
	 * <p>Title: getConnection</p>
	 * <p>Description: 链接数据库</p>
	 * @return  Connection 对象
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {
		try {
			conn = this.dbConnectoin.getConnection();
		} catch (Exception e) {
			throw new Exception("数据链接错误,请检查用户输入的信息!");
		}
		return conn;
	}
	/**
	 * 
	 * <p>Title: closeConn</p>
	 * <p>Description: 关闭连接</p>
	 */
	public void closeConn() {
		this.dbConnectoin.closeAll();
	}
	/**
	 * 
	 * <p>Title: queryResult</p>
	 * <p>Description: 执行sql获得结果</p>
	 * @param sqlStr  查询sql语句
	 * @return  ResultSet对象
	 * @throws Exception
	 */
	public ResultSet queryResult(String sqlStr) throws Exception {
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sqlStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * 
	 * <p>Title: getAllTableName</p>
	 * <p>Description:  获得所有数据库表的名称</p>
	 * @param sqlStr  查询的sql语句
	 * @return  List<String>
	 * @throws Exception
	 */
	public List<String> getAllTableName(String sqlStr) throws Exception {
		List list = null;
		try {
			list = new ArrayList();
			rs = queryResult(sqlStr);
			while (rs.next())
				list.add(rs.getString(1));
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbConnectoin.closeAll();
		}
		return list;
	}

	public List<String> getAllColumns(String sqlStr) throws Exception {
		List list = null;
		try {
			list = new ArrayList();
			rs = queryResult(sqlStr);
			while (rs.next())
				list.add(rs.getString(2));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbConnectoin.closeAll();
		}
		return list;
	}
	/**
	 * 
	 * <p>Title: getDescribe</p>
	 * <p>Description:  根据传入的sql获得表中的所有列信息</p>
	 * @param sqlStr	sql语句
	 * @return  List<TableColumn>
	 * @throws Exception
	 */
	public List<TableColumn> getDescribe(String sqlStr) throws Exception {
		List list = null;
		try {
			list = new ArrayList();
			rs = queryResult(sqlStr);
			while (rs.next()) {
				TableColumn dbColumns = new TableColumn();
				dbColumns.setColumnsFiled(rs.getString(1));
				dbColumns.setColumnsType(rs.getString(2));
				dbColumns.setColumnsNull(rs.getString(3));
				dbColumns.setColumnsKey(rs.getString(4));
				dbColumns.setColumnsDefault(rs.getString(5));
				dbColumns.setColumnsExtra(rs.getString(6));
				list.add(dbColumns);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbConnectoin.closeAll();
		}
		return list;
	}

	public List<String> loadSqlScript(String filePath) throws Exception {
		List sqlList = null;
		UnicodeReader inReader = null;
		StringBuffer sqlStr = null;
		try {
			sqlList = new ArrayList();
			sqlStr = new StringBuffer();

			inReader = new UnicodeReader(new FileInputStream(filePath), "UTF-8");
			char[] buff = new char[1024];
			int byteRead = 0;
			while ((byteRead = inReader.read(buff)) != -1) {
				sqlStr.append(new String(buff, 0, byteRead));
			}

			String[] sqlStrArr = sqlStr.toString().split(
					"(;\\s*\\r\\n)|(;\\s*\\n)");
			for (String str : sqlStrArr) {
				String sql = str.replaceAll("--.*", "").trim();
				if (!sql.equals(""))
					sqlList.add(sql);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sqlList;
	}

	public String trim(String obj) throws Exception {
		Matcher matcher = null;
		Pattern pattern = null;
		try {
			pattern = Pattern.compile("\\s*\n");
			matcher = pattern.matcher(obj.toString());
		} catch (Exception e) {
			throw e;
		}
		return matcher.replaceAll("");
	}
	/**
	 * 
	 * <p>Title: genericQueryField</p>
	 * <p>Description: 根据指定表，查询得到该表中所有的字段名组成的字符串，字段与字段之间用"," 隔开</p>
	 * @param table 数据库表名
	 * @return  String
	 */
	public String genericQueryField(String table) {
		String query_sql = "";
		try {
			conn = getConnection();
			stmt = conn.createStatement();

			String sql = "select * from " + table;
			//获得查询结果中列的编号、类型和属性
			ResultSetMetaData rsmds = stmt.executeQuery(sql).getMetaData();
			for (int j = 1; j < rsmds.getColumnCount(); j++) {
				query_sql = query_sql + rsmds.getColumnName(j) + ",";
			}
			//表中所有的字段名，中间用"," 隔开
			query_sql = query_sql + rsmds.getColumnName(rsmds.getColumnCount());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.dbConnectoin.closeAll();
		}
		return query_sql;
	}
}
