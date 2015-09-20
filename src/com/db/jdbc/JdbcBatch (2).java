package com.db.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcBatch {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://10.33.192.248:3306/progenie","root","Wns$1234");
			con.setAutoCommit(false);
			
			Statement stm = con.createStatement();
			stm.addBatch("insert into calldetails values(410,'341',15,1110,'callDroped',	'2014-02-20 08:33:55',	'2014-02-20 08:34:25')");
			stm.addBatch("insert into calldetails values(411,'341',18,1111,'callDroped',	'2014-02-20 08:33:55',	'2014-02-20 08:34:25')");
			stm.addBatch("insert into calldetails values(412,'341',18,1112,'callDroped',	'2014-02-20 08:33:55',	'2014-02-20 08:34:25')");
			int[] rows = stm.executeBatch();
			System.out.println(rows.length);
			
			con.commit();
			
			if(con!=null)
				con.rollback();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException ex) {
			System.out.println("roll back");
			if(con!=null)
				con.rollback();
			ex.printStackTrace();
		}
		finally{
			System.out.println("close");
			if(con!=null)
				con.close();
		}

	}

}
