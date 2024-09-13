package trieu.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class Orderimpl {
	public Orderimpl(Connection conn) {
		super();
	}

	public static void select(Connection conn) {
        String sql = "SELECT * FROM `ORDER` WHERE ID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String code = rs.getString("code");
                String status = rs.getString("status");
                int userId = rs.getInt("user_id");
                rs.getTimestamp("created_at");
                System.out.printf("id: %d, code: %s, status: %s, user_id: %d%n", id, code, status, userId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insert(Connection conn) {
        String sql = "INSERT INTO `ORDER` (ID, CODE, STATUS, USER_ID) VALUES (NULL, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "ORD123");
            stmt.setString(2, "PENDING");
            stmt.setInt(3, 1);

            stmt.execute();
            System.out.println("Order inserted successfully.");
        } catch (Exception e) {
            System.err.println("Error while inserting order: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void Delete(Connection conn) {
        String sql = "DELETE FROM `ORDER` WHERE ID = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, 1);
            stmt.executeUpdate();
            System.out.println("DELETE successful!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void Update(Connection conn) {
        String sql = "UPDATE `ORDER` SET code = ?, status = ?, user_id = ?, created_at = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, "ORD123"); // code
            stmt.setString(2, "Shipped"); // status
            stmt.setInt(3, 1001); // user_id
            stmt.setTimestamp(4, new Timestamp(System.currentTimeMillis())); // created_at
            stmt.setInt(5, 1); // id
            stmt.execute();
            System.out.println("Update successful!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
