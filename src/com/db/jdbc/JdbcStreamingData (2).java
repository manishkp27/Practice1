package com.db.jdbc;

import java.io.*;
import java.sql.*;
public class JdbcStreamingData {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://10.33.192.248:3306/progenie","root","Wns$1234");
			
			Statement stm = con.createStatement();
			try{
			stm.executeUpdate("Drop table XML_Data ");
			}catch(Exception e){
				System.out.println("drop table failed");
			}
			stm.executeUpdate("Create table XML_Data(id integer, data long)");
			
			File f = new File("D:/EclipseWorkSpace/Practice/src/com/db/jdbc/XML_Data.xml");
			System.out.println("file content length:"+(int)f.length());
			double fLength = (int)f.length();
			if(fLength<1)
				return;
			
			PreparedStatement pStmt = con.prepareStatement("insert into XML_Data values(?,?)");
			pStmt.setInt(1, 100);
			pStmt.setAsciiStream(2, new FileInputStream(f),(int)f.length());
			pStmt.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(SQLException ex) { ex.printStackTrace(); }
		catch(FileNotFoundException e){e.printStackTrace();	}
		finally{
			System.out.println("close");
			if(con!=null)
				con.close();
		}

	}
	

}
