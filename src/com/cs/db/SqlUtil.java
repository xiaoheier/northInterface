package com.cs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SqlUtil {
	
	public static ResultSet execut(String sql){
		Connection con = null;  
        PreparedStatement stmt= null;  
        ResultSet rs = null;  
        try{  
            con = ConnectionPool.getInstance().getConnection();  
            stmt = con.prepareStatement(sql);  
            rs = stmt.executeQuery();  
        }catch(Exception e){
        	e.printStackTrace();
        }
        return rs;
	}
	
	
	/* @param conn
	 *            连接
	 * @param pstm
	 *            PreparedStatement
	 * @return int 执行sql对应的影响行。
	 * @throws SQLException
	 * @author 宋立君
	 * @date 2014年07月03日
	 */
	public int execute(Connection conn, PreparedStatement pstm)
	        throws SQLException {
	    try {
	        return pstm.executeUpdate();
	    } finally {
	        //Close(conn);
	    }
	}
	
	/**
	 * 查询sql。
	 * 
	 * @param conn
	 *            连接
	 * @param pstm
	 *            PreparedStatement
	 * @return List<Map<String,Object>> 查询的结果集
	 * @throws SQLException
	 * @author 宋立君
	 * @date 2014年07月03日
	 */
	public List<Map<String, Object>> query(Connection conn,
	        PreparedStatement pstm) throws SQLException {
	    try {
	        return resultSetToList(pstm.executeQuery());
	    } finally {
	        //Close(conn);
	    }
	}
	
	/**
	 * 功能：ResultSet 转为List<Map<String,Object>>
	 * 
	 * 
	 * @param rs
	 *            ResultSet 原始数据集
	 * @return List<Map<String,Object>>
	 * @throws java.sql.SQLException
	 * @author 宋立君
	 * @date 2014年07月03日
	 */
	private List<Map<String, Object>> resultSetToList(ResultSet rs)
	        throws java.sql.SQLException {
	    if (rs == null)
	        return Collections.emptyList();

	    ResultSetMetaData md = rs.getMetaData(); // 得到结果集(rs)的结构信息，比如字段数、字段名等
	    int columnCount = md.getColumnCount(); // 返回此 ResultSet 对象中的列数
	    List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	    Map<String, Object> rowData = new HashMap<String, Object>();
	    while (rs.next()) {
	        rowData = new HashMap<String, Object>(columnCount);
	        for (int i = 1; i <= columnCount; i++) {
	            rowData.put(md.getColumnName(i), rs.getObject(i));
	        }
	        list.add(rowData);
	    }
	    return list;
	}
	
	
	/**
	 * 查询sql语句。
	 * 
	 * @param sql
	 *            被执行的sql语句
	 * @return List<Map<String,Object>>
	 * @throws SQLException
	 * @author 宋立君
	 * @date 2014年07月03日
	 */
	/*public List<Map<String, Object>> query(String sql) throws SQLException {
	    List<Map<String, Object>> results = null;
	    Connection conn = null;
	    try {
	        conn = getConnection();
	        QueryRunner qr = new QueryRunner();
	        results = qr.query(conn, sql, new MapListHandler());
	    } finally {
	        Close(conn);
	    }
	    return results;
	}*/
	
	/**
	 * 根据参数查询sql语句
	 * 
	 * @param sql
	 *            sql语句
	 * @param param
	 *            参数
	 * @return List<Map<String,Object>>
	 * @throws SQLException
	 * @author 宋立君
	 * @date 2014年07月03日
	 */
	/*public List<Map<String, Object>> query(String sql, Object param)
	        throws SQLException {
	    List<Map<String, Object>> results = null;
	    Connection conn = null;
	    try {
	        conn = getConnection();
	        QueryRunner qr = new QueryRunner();
	        results = (List<Map<String, Object>>) qr.query(conn, sql, param,
	                new MapListHandler());
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        Close(conn);
	    }
	    return results;
	}*/

	/**
	 * 执行sql语句
	 * 
	 * @param sql
	 *            被执行的sql语句
	 * @return 受影响的行
	 * @throws Exception
	 * @author 宋立君
	 * @date 2014年07月03日
	 */
	/*public int execute(String sql) throws Exception {
	    Connection conn = getConnection();
	    int rows = 0;
	    try {
	        QueryRunner qr = new QueryRunner();
	        rows = qr.update(conn, sql);
	    } finally {
	        Close(conn);
	    }
	    return rows;
	}*/

	/**
	 * 执行含参数的sql语句
	 * 
	 * @param sql
	 *            被执行的sql语句
	 * @param params
	 *            参数
	 * @return 返回受影响的行
	 * @throws Exception
	 * @author 宋立君
	 * @date 2014年07月03日
	 */
	/*public int execute(String sql, Object[] params) throws Exception {
	    Connection conn = getConnection();
	    int rows = 0;
	    try {
	        QueryRunner qr = new QueryRunner();
	        rows = qr.update(conn, sql, params);
	    } finally {
	        Close(conn);
	    }
	    return rows;
	}*/

	/**
	 * 关闭连接
	 * 
	 * @param conn
	 * @throws SQLException
	 * @author 宋立君
	 * @date 2014年07月03日
	 */
	/*public void Close(Connection conn) throws SQLException {
	    if (conn != null) {
	        conn.close();
	    }
	    DbUtils.closeQuietly(conn);
	}*/

	/**
	 * 启动连接池
	 * 
	 * @author 宋立君
	 * @date 2014年07月03日
	 */
	/*private void StartPool() {
	    try {
	        Class.forName(dri);
	    } catch (ClassNotFoundException e1) {
	        e1.printStackTrace();
	    }
	    if (connectionPool != null) {
	        ShutdownPool();
	    }
	    try {
	        connectionPool = new GenericObjectPool(null);
	        ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(
	                url, username, password);
	        PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(
	                connectionFactory, connectionPool, null, "SELECT 1", false,
	                true);
	        Class.forName("org.apache.commons.dbcp.PoolingDriver");
	        PoolingDriver driver = (PoolingDriver) DriverManager
	                .getDriver("jdbc:apache:commons:dbcp:");
	        driver.registerPool(poolName, poolableConnectionFactory.getPool());

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    // 开启查询程序
	    queryThread = new QueryThread(this);
	    queryThread.start();
	}*/

	/**
	 * 关闭连接池
	 * 
	 * @author 宋立君
	 * @date 2014年07月03日
	 */
	/*private void ShutdownPool() {
	    try {
	        PoolingDriver driver = (PoolingDriver) DriverManager
	                .getDriver("jdbc:apache:commons:dbcp:");
	        driver.closePool(poolName);
	        // 关闭定时查询
	        queryThread.setStartQuery(false);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}*/

	/**
	 * 得到一个连接
	 * 
	 * @return
	 * @author 宋立君
	 * @date 2014年07月03日
	 */
	public synchronized Connection getConnection() {
	    Connection conn = null;
	     conn = ConnectionPool.getInstance().getConnection();
	    return conn;
	}
}
