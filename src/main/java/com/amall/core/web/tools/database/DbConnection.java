package com.amall.core.web.tools.database;

import java.sql.Connection;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 
 * <p>Title: DbConnection</p>
 * <p>Description: 数据库工具类，提供连接和关闭连接的方法</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29上午11:56:13
 * @version 1.0
 */
@Repository
public class DbConnection {

	@Autowired
	private DataSource dataSource;
	public static final ThreadLocal<Connection> thread = new ThreadLocal();
	
	/**
	 * 
	 * <p>Title: getConnection</p>
	 * <p>Description: 获得Connection</p>
	 * @return
	 */
	public Connection getConnection() {
		Connection conn = (Connection) thread.get();
		if (conn == null) {
			try {
				conn = this.dataSource.getConnection();
				thread.set(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
	/**
	 * 
	 * <p>Title: closeAll</p>
	 * <p>Description: 关闭连接</p>
	 */
	public void closeAll() {
		try {
			Connection conn = (Connection) thread.get();
			if (conn != null) {
				conn.close();
				thread.set(null);
			}
		} catch (Exception e) {
			try {
				throw e;
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
