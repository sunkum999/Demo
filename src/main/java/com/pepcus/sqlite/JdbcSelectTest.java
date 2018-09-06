package com.pepcus.sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcSelectTest { // Save as "JdbcSelectTest.java"
	public static void main(String[] args) throws Exception {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String url = "jdbc:sqlite:C://SQLiteDB/SQLite.sqlite";
			conn = DriverManager.getConnection(url);//"jdbc:mysql://localhost:3306");
			
			Statement stmt = conn.createStatement();
			String strInsertData = "INSERT INTO Product ( PRODUCT_NAME, CREATED_AT, PRODUCT_CODE, PRODUCT_BAR_CODE, PRODUCT_PRICE) ";
			String val = strInsertData + "VALUES ('OneLpus', 2, 'OPO5646', 'OP45O658OO', 10500)";
			// String strSelect = "select title, price, qty from books";
			// System.out.println("The SQL query is: " + strSelect); // Echo For debugging
			// System.out.println();

			int executeUpdate = stmt.executeUpdate(val);
			System.out.println("executeUpdate::" + executeUpdate);
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			
		}
	}
}
