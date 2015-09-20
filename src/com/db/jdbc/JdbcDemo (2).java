package com.db.jdbc;
import java.sql.*;
import java.util.*;

public class JdbcDemo {
	public static void main(String[] args) {
		ResultSet rs=null;
		Connection con=null;

		try{
			//Step1 Register jdbc driver
			//Class.forName("com.mysql.jdbc.Driver");
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			
		//Step2 open a connection
			//con = DriverManager.getConnection("jdbc:mysql://10.33.192.248:3306/progenie","root","Wns$1234");
			/*Properties prop = new Properties();
			prop.put("user", "root");
			prop.put("password", "Wns$1234");
			con = DriverManager.getConnection("jdbc:mysql://10.33.192.248:3306/progenie",prop);		*/	
			con=DriverManager.getConnection("jdbc:mysql://10.33.192.248:3306/progenie?user=root&password=Wns$1234");
			
		//Step3 execute query
			//****1 select, Statement=con.createStatement:executeQuery
			//stmt = con.createStatement();
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = stmt.executeQuery("select * from calldetails where calldetid<=50");// to get a result set, as you would with a SELECT statement. 
			//stmt.e
			printRs(rs);
			updateStatus(rs);
			
			//****2 update/insert, PreparedStatement=con.prepareStatement:pStmt.executeUpdate/executeQuery
			PreparedStatement pStmt = con.prepareStatement("update calldetails set CALLSTATUS=? where calldetid<=?");
			pStmt.setString(1, "callDroped3");
			pStmt.setString(2, "50");
			int rows = pStmt.executeUpdate();// to get a number of rows affected - for example, an INSERT, UPDATE, or DELETE statement.
			System.out.println("num of rows affected:"+rows);
			//rs = pStmt.executeQuery();
			
			
			//****3 StoreProcedure, CallableStatement=con.prepareCall:execute
			CallableStatement cStmt = con.prepareCall(" call getEmpName(?,?)");
			cStmt.setInt(1, 6);
			cStmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			Boolean res = cStmt.execute();//to execute SQL DDL statements or when you need to use truly dynamic SQL
			System.out.println("res:"+res+" "+cStmt.getString(2));
			

			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();
			if(pStmt!=null)
				pStmt.close();
			if(con!=null)
				con.close();
		}
		//catch(ClassNotFoundException e){ e.printStackTrace();}
		catch(SQLException e){e.printStackTrace();}
		catch(Exception e){e.printStackTrace();}
		finally
		{
			try {
				if(con!=null)
					con.close();
			} 
			catch (SQLException e) { e.printStackTrace(); }
		}
	}
	static void printRs(ResultSet rs) throws SQLException{
		rs.beforeFirst();
		int i=0;
		while(rs.next()){
			System.out.println(""+i+++": "+rs.getInt("calldetid")+", "+rs.getString("callid")+", "+rs.getString("callstatus"));
		}
	}
	static void updateStatus(ResultSet rs) throws SQLException{
		rs.beforeFirst();
		while(rs.next()){
			rs.updateString("callstatus", rs.getString(5)+'1');//rs.updateString(5, rs.getString(5)+'1');
			rs.updateRow();
		}
		printRs(rs);
	}
}
