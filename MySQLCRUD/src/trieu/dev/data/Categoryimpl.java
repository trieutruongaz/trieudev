package trieu.dev.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Categoryimpl {
private Connection conn;
	
	public Categoryimpl(Connection conn) {
		super();
		this.conn = conn;
	}

	public void find() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CATEGORIES WHERE ID = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String thumbnail = rs.getString("thumbnail");
				System.out.format("id:%d - name:%s - thumbnail:%s", id, name, thumbnail).println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void findAll() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM CATEGORIES";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String thumbnail = rs.getString("thumbnail");
				System.out.format("%id:%s:%s", id, name, thumbnail).println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

	public void delete() {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM CATEGORIES WHERE ID=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, 13);
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update() {
		// TODO Auto-generated method stub
		String sql = "UPDATE CATEGORIES SET NAME=?, THUMBNAIL=? WHERE ID=?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "Ao Nu");
			stmt.setString(2, "https://image.com/2.jpg");
			stmt.setInt(3, 8);
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insert() {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO CATEGORIES(NAME, THUMBNAIL) VALUES (?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, "Ao Nam");
			stmt.setString(2, "https://image.com/1.jpg");
			
			stmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
