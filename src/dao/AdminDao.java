package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Admin;

public class AdminDao {

	private static final String SQL_SELECT_ID_AND_PASS = "SELECT admin_id, admin_name, password FROM admin WHERE admin_id = ? AND password = ?";


	private Connection connection;

	public AdminDao(Connection connection) {
		this.connection = connection;
	}

	public Admin findByIdAndPass(String admin_id, String password) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID_AND_PASS)) {
			stmt.setString(1, admin_id);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new Admin(rs.getString("admin_id"), rs.getString("admin_name"), rs.getString("password"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
