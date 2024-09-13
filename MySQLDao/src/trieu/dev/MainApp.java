package trieu.dev;
import java.sql.DriverManager;

import trieu.dev.data.dao.CategoryDao;
import trieu.dev.data.impl.CategoryImpl;
import trieu.dev.data.model.Category;

public class MainApp {
	public static void main1(String[] args) {
		// TODO Auto-generated method stub
		final String DB_URL ="jdbc:mysql://localhost:3306/shop";
		final String USER ="root";
		 final String PASS ="";

try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	DriverManager.getConnection(DB_URL,USER,PASS);
	System.out.println("ket noi thanh cong");
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CategoryDao categoryDao = new CategoryImpl();
		Category cat = new Category(1,"ADIDAS","http://ss");
		categoryDao.insert(cat);
		
//		Category find = categoryDao.find(3);
//		System.out.println(find.name);
//		find.name ="ao qua dai";
//		categoryDao.update(find);
//		categoryDao.delete(find.id);
		
	}
}
