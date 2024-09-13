package trieu.dev;

import java.sql.DriverManager;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String DB_URL = "jdbc:mysql://localhost:3306/shop";
		final String USER = "root";
		final String PASS = "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			DriverManager.getConnection(DB_URL, USER, PASS);
			System.out.println("ket noi thanh cong");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}

}
