package jdbctest;

import java.sql.Connection;
import java.sql.DriverManager;

public class testjdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcUrl="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String password="hbstudent";

		try {
			
		System.out.println("Connecting to database"+jdbcUrl);
		Connection myconn=DriverManager.getConnection(jdbcUrl,user,password);
		System.out.println("Connection Successful");
		}
		catch (Exception e){
			e.printStackTrace();
		}

	}

}
