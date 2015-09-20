package com.solution2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InterThreadComm {
	public static void main(String[] args) throws SQLException, InterruptedException {
		new Thread( new MyThread1()).start();
		new Thread( new MyThread2()).start();
	}
}

class MyThread1 implements Runnable{
	int oldSal1 ;
	public void run(){
		oldSal1 = ConnectDB.getData();
		System.out.println("MyThread1.run() oldSal1="+oldSal1);	
		
		System.out.println("MyThread1.run() updatedSal="+ConnectDB.updateSalary(oldSal1));
		
	}
}
class MyThread2 implements Runnable{
	int oldSal2;
	public void run(){
		/*try {
			Thread.sleep(1000);
		} catch (InterruptedException e) { e.printStackTrace(); }
		*/
		oldSal2 = ConnectDB.getData();
		System.out.println("MyThread2.run() oldSal2="+oldSal2);
		System.out.println("MyThread2.run() updatedSal="+ConnectDB.updateSalary(oldSal2));
		
	}
}
class ConnectDB{
	static Connection con= ConnectDB.getConnection();
	public static int updateSalary(int oldSal){
		try {
			PreparedStatement st = con.prepareStatement("update employee set salary=? where id=1");
			st.setInt(1, oldSal+100);
			
			st.executeUpdate();
			return getData();
			
		} catch (SQLException e) { e.printStackTrace(); }
		return 0;
	}
	public static int getData(){
		try{
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select salary from employee where id=1");
			rs.next();
			return rs.getInt(1);
		} catch (SQLException e) { e.printStackTrace(); }
		return 0;
	}
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return  DriverManager.getConnection("jdbc:mysql://10.33.192.248:3306/progenie?user=root&password=Wns$1234");
		} catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
		return null;
	}	
}