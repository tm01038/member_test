package com.member.lib.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521/orcl";
	private static final String ID = "test";
	private static final String PW = "1234";

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static Connection open() {

		Connection conn = null;

		if (conn == null) {
			try {
				conn = DriverManager.getConnection(URL, ID, PW);
				
				return conn;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				conn =null;
			}
		}

		return null;
	}

}
