package com.db.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMysql {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://10.33.192.248:3306/progenie","root","Wns$1234");
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from calldetails where callid>3120");
			
			//System.out.println("result size=");
			while(rs.next()){
				System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getInt(3)+", "+rs.getString(5));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException ex) {
			ex.printStackTrace();
		}
		finally{
			System.out.println("close");
			if(con!=null)
				con.close();
		}

	}

}
