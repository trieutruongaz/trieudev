package trieu.dev;

import java.sql.Connection;
import java.sql.DriverManager;
import trieu.dev.data.Categoryimpl;
import trieu.dev.data.OrderItemimpl;
import trieu.dev.data.Orderimpl;
import trieu.dev.data.Productimpl;
import trieu.dev.data.Userimpl;




public class MainApp {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = getConnection();
		new Categoryimpl(conn);
		new Userimpl(conn); 
		new Productimpl(conn);
		new Orderimpl(conn);
		new OrderItemimpl();
		
//		categoryImpl.insert();
//		categoryImpl.update();
//		categoryImpl.delete();
//		categoryImpl.select();
//		categoryImpl.find();
//		categoryImpl.findAll();
		
//		UserImpl userImpl = new UserImpl(conn);
//		userImpl.insert();
//		userImpl.update();
//		userImpl.delete(4);
//		userImpl.find(3);
//		userImpl.findAll();
//		userImpl.find("vinh@gmail.com", "123456");
		
		
//		ProductImpl productImpl = new ProductImpl(conn);
//		productImpl.insert();
//		productImpl.update();
//		productImpl.delete(6);
//		productImpl.find(3);
//		productImpl.findAll();
//		productImpl.hot(14);
//		productImpl.findByCategory(3);
		
//		OrderImpl orderImpl = new OrderImpl(conn);
//		orderImpl.insert(conn);
//		orderImpl.Delete(conn);
		
//		OrderItemImpl orderItemImpl = new OrderItemImpl();
//		orderItemImpl.insert(conn, 1, 2, 3, 4);
//		orderItemImpl.delete(conn, 3);
	}

	private static Connection getConnection() {
		// TODO Auto-generated method stub
		final String DB_URL ="jdbc:mysql://localhost:3306/shop";
		final String USER ="root";
		final String PASS ="";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
