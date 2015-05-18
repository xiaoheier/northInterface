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
	 *            ����
	 * @param pstm
	 *            PreparedStatement
	 * @return int ִ��sql��Ӧ��Ӱ���С�
	 * @throws SQLException
	 * @author ������
	 * @date 2014��07��03��
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
	 * ��ѯsql��
	 * 
	 * @param conn
	 *            ����
	 * @param pstm
	 *            PreparedStatement
	 * @return List<Map<String,Object>> ��ѯ�Ľ����
	 * @throws SQLException
	 * @author ������
	 * @date 2014��07��03��
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
	 * ���ܣ�ResultSet תΪList<Map<String,Object>>
	 * 
	 * 
	 * @param rs
	 *            ResultSet ԭʼ���ݼ�
	 * @return List<Map<String,Object>>
	 * @throws java.sql.SQLException
	 * @author ������
	 * @date 2014��07��03��
	 */
	private List<Map<String, Object>> resultSetToList(ResultSet rs)
	        throws java.sql.SQLException {
	    if (rs == null)
	        return Collections.emptyList();

	    ResultSetMetaData md = rs.getMetaData(); // �õ������(rs)�Ľṹ��Ϣ�������ֶ������ֶ�����
	    int columnCount = md.getColumnCount(); // ���ش� ResultSet �����е�����
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
	 * ��ѯsql��䡣
	 * 
	 * @param sql
	 *            ��ִ�е�sql���
	 * @return List<Map<String,Object>>
	 * @throws SQLException
	 * @author ������
	 * @date 2014��07��03��
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
	 * ���ݲ�����ѯsql���
	 * 
	 * @param sql
	 *            sql���
	 * @param param
	 *            ����
	 * @return List<Map<String,Object>>
	 * @throws SQLException
	 * @author ������
	 * @date 2014��07��03��
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
	 * ִ��sql���
	 * 
	 * @param sql
	 *            ��ִ�е�sql���
	 * @return ��Ӱ�����
	 * @throws Exception
	 * @author ������
	 * @date 2014��07��03��
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
	 * ִ�к�������sql���
	 * 
	 * @param sql
	 *            ��ִ�е�sql���
	 * @param params
	 *            ����
	 * @return ������Ӱ�����
	 * @throws Exception
	 * @author ������
	 * @date 2014��07��03��
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
	 * �ر�����
	 * 
	 * @param conn
	 * @throws SQLException
	 * @author ������
	 * @date 2014��07��03��
	 */
	/*public void Close(Connection conn) throws SQLException {
	    if (conn != null) {
	        conn.close();
	    }
	    DbUtils.closeQuietly(conn);
	}*/

	/**
	 * �������ӳ�
	 * 
	 * @author ������
	 * @date 2014��07��03��
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
	    // ������ѯ����
	    queryThread = new QueryThread(this);
	    queryThread.start();
	}*/

	/**
	 * �ر����ӳ�
	 * 
	 * @author ������
	 * @date 2014��07��03��
	 */
	/*private void ShutdownPool() {
	    try {
	        PoolingDriver driver = (PoolingDriver) DriverManager
	                .getDriver("jdbc:apache:commons:dbcp:");
	        driver.closePool(poolName);
	        // �رն�ʱ��ѯ
	        queryThread.setStartQuery(false);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}*/

	/**
	 * �õ�һ������
	 * 
	 * @return
	 * @author ������
	 * @date 2014��07��03��
	 */
	public synchronized Connection getConnection() {
	    Connection conn = null;
	     conn = ConnectionPool.getInstance().getConnection();
	    return conn;
	}
}
