package com.db.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcMssql {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:jtds:sqlserver://10.33.192.130:1433/PGWnsCareers","CodeConn","CodeConn");
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from calldetails where callid>3120");
			while(rs.next()){
				System.out.println(rs.getInt(1)+", "+rs.getString(2)+", "+rs.getString(3));
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally{
			System.out.println("close");
			if(con!=null)
				con.close();
		}
	}

}
