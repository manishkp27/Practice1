package com.db.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTransaction {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://10.33.192.248:3306/progenie","root","Wns$1234");
			con.setAutoCommit(false);
			
			Statement stm = con.createStatement();
			int rows=stm.executeUpdate("insert into calldetails values(408,'341',15,15,'callDroped',	'2014-02-20 08:33:55',	'2014-02-20 08:34:25')");
			System.out.println(rows);
			rows=stm.executeUpdate("insert into calldetails values(409,'341',18,118,'callDroped',	'2014-02-20 08:33:55',	'2014-02-20 08:34:25')");
			System.out.println(rows);
			//if(true)
			//throw new SQLException();
			
			con.commit();
			
			if(con!=null)
				con.rollback();
			/*while(rs.next()){
				System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3)+", "+rs.getString(5));
			}*/
			
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
