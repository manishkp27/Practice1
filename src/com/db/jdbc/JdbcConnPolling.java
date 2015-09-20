package com.db.jdbc;

import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

public class JdbcConnPolling {
	static Connection con=null;
	public static void main(String[] args) throws NamingException, SQLException {
			con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from calldetails where calldetid<=50");
			while(rs.next()){
				System.out.println(rs.getInt("calldetid")+", "+rs.getString("callid")+", "+rs.getString("callstatus"));
			}
			con.close();
	}
	static Connection getConnection() throws NamingException, SQLException{
		System.out.println("getConnect()");
		//InitialContext initCtx = createContext();
		//ConnectionPoolDataSource cPDSource= (ConnectionPoolDataSource )initCtx.lookup("HrDS");
		//Connection con =cPDSource.getPooledConnection().getConnection();
		
		InitialContext initCtx = new InitialContext();
		DataSource DSource= (DataSource )initCtx.lookup("java:comp/env/jdbc/CareersMSSQL");//("java:comp/env/jdbc/progenie");
		Connection con =DSource.getConnection();
				
		if(con==null)
			con = connect();
		return con;
	}
	static InitialContext createContext() throws NamingException{
		Properties propEnv = new Properties();
		propEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.rmi.registry.RegistryContextFactory");
		//propEnv.put(Context.PROVIDER_URL,"rmi:10.33.192.248:3306/progenie?user=root&password=Wns$1234");
		propEnv.put(Context.PROVIDER_URL,"jdbc:mysql://10.33.192.248:3306/progenie?user=root&password=Wns$1234");
		
		return new InitialContext(propEnv);
	}
	
	public static Connection connect() throws SQLException {
		System.out.println("connect()");
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://10.33.192.248:3306/progenie","root","Wns$1234");
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
