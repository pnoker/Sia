package com.Sia.util.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Pnoker
 * @mail peter-no@foxmail.com
 * @date 2016年10月18日
 * @description
 */

public class MySql {
	public Connection connection = null;
	public Statement statement = null;
	private ResultSet result = null;

	public MySql() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/sia?useUnicode=true&characterEncoding=utf-8";
			connection = DriverManager.getConnection(url, "root", "123456");
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}

	public ResultSet executeQuery(String sql) throws SQLException {
		try {
			result = statement.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return result;
	}

	public int executeUpdate(String sql) throws SQLException {
		int updatenum = 0;
		try {
			updatenum = statement.executeUpdate(sql);
			return updatenum;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return updatenum;
	}

	public void free() throws SQLException {
		try {
			if (result != null)
				result.close();
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}
