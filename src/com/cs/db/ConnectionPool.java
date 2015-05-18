package com.cs.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ConnectionPool {
	private DataSource ds;
	private static ConnectionPool pool;

	private ConnectionPool() {
		ds = new ComboPooledDataSource();
	}

	public static final ConnectionPool getInstance() {
		if (pool == null) {
			try {
				pool = new ConnectionPool();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return pool;
	}

	public synchronized final Connection getConnection() {
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[]) {
		 Connection con = null;  
	        PreparedStatement stmt= null;  
	        ResultSet rs = null;  
	        try{  
	            con = ConnectionPool.getInstance().getConnection();  
	            stmt = con.prepareStatement("select * from sys_role");  
	            rs = stmt.executeQuery();  
	            while(rs.next()){  
	                System.out.println(Thread.currentThread().getId()+"---------------¿ªÊ¼"+rs.getString("name"));  
	            }  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }finally{  
	            try {  
	                rs.close();  
	                stmt.close();  
	                con.close();  
	            } catch (SQLException e) {  
	                e.printStackTrace();  
	            }  
	        }  
	        System.out.println(Thread.currentThread().getId()+"--------½áÊø");  
	}
}
