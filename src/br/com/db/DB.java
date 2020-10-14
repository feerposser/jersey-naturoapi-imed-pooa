package br.com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public final class DB {
	
	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String url = "jdbc:mysql://127.0.0.1:3306/naruto"; //?useSSL=false
	private static String username = "root";
	private static String password = "admin";
	
	private static Connection conn = null;
	
	public static Connection getConnection() {
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("ata");
		}
		
		if (conn == null) {
			try {
				conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/naruto?"+
						"user=root&password=admin&serverTimezone=UTC");
				
//				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DbException(e.getMessage());
			}
		}
		
		return conn;
	}
	
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void fecharStmt(Statement stmt) {
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void fecharConn(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
