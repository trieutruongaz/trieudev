package trieu.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderItemimpl {

	 public static void select(Connection conn, int orderId) {
	        String sql = "SELECT * FROM `ORDER_ITEMS` WHERE order_id = ?";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, orderId); 
	            ResultSet rs = stmt.executeQuery();
	            while (rs.next()) {
	                rs.getInt("id");
	                rs.getInt("quantity");
	                rs.getDouble("price");
	                rs.getInt("product_id");
	              
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void insert(Connection conn, int quantity, double price, int orderId, int productId) {
	        String sql = "INSERT INTO `ORDER_ITEMS` (quantity, price, order_id, product_id) VALUES (?, ?, ?, ?)";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, quantity);
	            stmt.setDouble(2, price);
	            stmt.setInt(3, orderId);
	            stmt.setInt(4, productId);
	            stmt.executeUpdate();
	            System.out.println("Order inserted successfully.");
	        } catch (Exception e) {
	            System.err.println("Error while inserting order: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }



	    public static void delete(Connection conn, int id) {
	        String sql = "DELETE FROM `ORDER_ITEMS` WHERE id = ?";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, id); 
	            stmt.executeUpdate();
	            System.out.println("Delete successful!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void update(Connection conn, int id, int quantity, double price) {
	        String sql = "UPDATE `ORDER_ITEMS` SET quantity = ?, price = ? WHERE id = ?";
	        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, quantity); 
	            stmt.setDouble(2, price); 
	            stmt.setInt(3, id); 
	            stmt.executeUpdate();
	            System.out.println("Update successful!");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}

