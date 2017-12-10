package com.amall.core.web.ucapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.bean.SysConfig;
import com.amall.core.service.system.ISysConfigService;

@Component
public class UCTools {

	@Autowired
	private ISysConfigService sysConfigService;
	public static final ThreadLocal<Connection> thread = new ThreadLocal<Connection>();

	public boolean active_user(String userName, String pws, String email) {
		boolean ret = true;
		Connection conn = getConnection();
		try {
			Statement stmt = conn.createStatement();
			String sql = "insert into "
					+ this.sysConfigService.getSysConfig().getUcTablePreffix()
					+ "common_member (`email`,`username`,`password`,`regdate`,`groupid`) value ('"
					+ email + "','" + userName + "','" + pws + "','"
					+ System.currentTimeMillis() / 1000L + "','10')";
			ret = stmt.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll();
		}
		return ret;
	}

	public Connection getConnection() {
		Connection conn = (Connection) thread.get();
		if (conn == null) {
			SysConfig config = this.sysConfigService.getSysConfig();
			String UC_DATABASE = config.getUcDatabase();
			String UC_TABLE_PREFFIX = config.getUcTablePreffix();
			String UC_DATABASE_URL = config.getUcDatabaseUrl();
			String UC_DATABASE_PORT = config.getUcDatabasePort();
			String UC_DATABASE_USERNAME = config.getUcDatabaseUsername();
			String UC_DATABASE_PWS = config.getUcDatabasePws();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://"
						+ UC_DATABASE_URL + ":" + UC_DATABASE_PORT + "/"
						+ UC_DATABASE, UC_DATABASE_USERNAME, UC_DATABASE_PWS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			thread.set(conn);
		}
		return conn;
	}

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

	public static void main(String[] args) {
		UCTools tools = new UCTools();
		tools.active_user("test", "122", "333@test.com");
	}
}
