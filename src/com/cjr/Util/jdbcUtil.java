package com.cjr.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *      数据库连接类
 * @author 大南海
 *
 */
public class jdbcUtil {
 
	private static final String dricerClass;
	private static final String url;
	private static final String username;
	private static final String password;
 
	static {
		dricerClass = "org.mariadb.jdbc.Driver";
		url = "jdbc:mariadb://localhost:3306/mywork";
		username = "root";
		password = "243528";
	}
 
	/*
	 * 加载数据库的方法
	 */
 
	public static void locadClass() throws ClassNotFoundException {
 
		Class.forName(dricerClass);
	}
 
	/*
	 * 获取数据库连接的方法
	 */
	public static Connection getConnection() throws Exception {
 
		Connection conn = DriverManager.getConnection(url, username, password);
 
		return conn;
	}
 
	/*
	 * 关闭连接并释放资源的方法
	 */
	public static void result(Connection conn, Statement stam) {
 
		if (conn != null) {
 
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
 
		if (stam != null) {
 
			try {
				stam.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stam = null;
		}
	}
 
	/*
	 * 关闭连接并释放资源的方法
	 */
	public static void result(Connection conn, Statement stam, ResultSet rs) {
 
		if (conn != null) {
 
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
 
		if (stam != null) {
 
			try {
				stam.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stam = null;
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
 
	}
	
	public static void result(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			conn =null;
		}
	}
 
}