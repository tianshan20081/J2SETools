package com.aoeng.base.database.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author zhangshaocheng <sczhang0131@163.com>
 * 
 * @Nov 16, 2012 4:17:13 PM
 */
public class SqliteUtils {

	/**
	 * @return
	 */
	public static Connection getConn(String dataUrlString) {
		// TODO Auto-generated method stub
		// jdbc:sqlite://home/paynet/address.db
		Connection connection = null;
		try {
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection(dataUrlString);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @param conn
	 */
	public static void closeConn(Connection conn) {
		// TODO Auto-generated method stub
		if (null != conn) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param preparedStatement
	 */
	public static void closeState(Statement statement) {
		// TODO Auto-generated method stub
		if (null != statement) {
			try {
				statement.close();
				statement = null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
