package com.db.jdbc;
import java.sql.*;
public class JdbcMetadata {

	public static void main(String[] args) throws ClassNotFoundException {
		//String url = "jdbc:mysql://10.33.192.248:3306/progenie?user=root&password=Wns$1234";
		String url = "jdbc:jtds:sqlserver://10.33.192.130:1433/PGWnsCareers?user=CodeConn&password=CodeConn";
		
		Class<?> forName = Class.forName("net.sourceforge.jtds.jdbc.Driver");
		
		//try( Connection con = DriverManager.getConnection(url)){
		try(Connection con = DriverManager.getConnection("jdbc:jtds:sqlserver://10.33.192.130:1433/PGWnsCareers","CodeConn","CodeConn")){
			DatabaseMetaData dbmd = con.getMetaData();
			System.out.println(dbmd.getURL()+" \n"+dbmd.getDatabaseProductName() + " \n"+dbmd.getDriverName()+ " \n"+dbmd.getDriverVersion());
			
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from calldetails");
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getTableName(1) +" "+rsmd.getColumnCount()+" "+rsmd.getColumnName(1));
		}catch(SQLException e){
			e.printStackTrace();
		}

	}

}
