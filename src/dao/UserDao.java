package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;

public class UserDao {

	private static String SQL_SELECT_ALL = "SELECT user_id , user_name , telephone FROM user_info";
	private static String SQL_SELECT_ID= "SELECT user_id , user_name , telephone , password FROM user_info WHERE user_id = ?";
	private static String SQL_INSERT = "INSERT INTO user_info (user_name , telephone , password) VALUES (? , ? , ?)";
	private static String SQL_SELECT_ID_MAX= "SELECT MAX(user_id) FROM user_info";
	private static String SQL_UPDATE = "UPDATE user_info SET user_name = ? , telephone = ? , password = ? WHERE user_id = ? ";
	private static String SQL_DELETE = "DELETE FROM user_info WHERE user_id= ?";



	private Connection connection;

	public UserDao(Connection connection) {
		this.connection = connection;
	}

	//select

	public List<User> findAll() {
		List<User> list = new ArrayList<User>();

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				User u = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"));
				list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return list;
	}

	public List<User> find(String userid, String user_name, String telephone, String join) {
		List<User> list = new ArrayList<User>();
		int id;
		SQL_SELECT_ALL += join;
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ALL)) {
			int i = 1;

			if (!"".equals(userid)) {
				id	 = Integer.parseInt(userid);
				stmt.setInt(i, id);
				i++;
			}

			if (!"".equals(user_name)) {
				stmt.setString(i, user_name);
				i++;
			}

			if (!"".equals(telephone)) {
				stmt.setString(i, telephone);
			}

			System.out.println(stmt);
			SQL_SELECT_ALL = "SELECT user_id , user_name , telephone FROM user_info";
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User u = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"));
				list.add(u);
			}
		} catch (SQLException e) {
			SQL_SELECT_ALL = "SELECT user_id , user_name , telephone FROM user_info";
			throw new RuntimeException(e);
		}
		SQL_SELECT_ALL = "SELECT user_id , user_name , telephone FROM user_info";
		return list;
	}



	public User findId(String userid) {
		List<User> list = new ArrayList<User>();
		int id;
		User u = null;

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID)) {
			ResultSet rs = stmt.executeQuery();

			if (!"".equals(userid)) {
				id	 = Integer.parseInt(userid);
				stmt.setInt(1, id);
			}
			while (rs.next()) {

			u = new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
			list.add(u);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return u;
	}

	//insert
	public int insert(User user) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_INSERT)) {
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getTelephone());
			stmt.setString(3, user.getPassword());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int selectmax() {
		int id = 0;

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID_MAX)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				id = rs.getInt("max");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return id;
	}

	//update

	public int SelectMax() {
		int id = 0;

		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID_MAX)) {
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				id = rs.getInt("user_id");
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return id;
	}

	public User findById(String userid) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID)) {
			int id = 0;
			if (!"".equals(userid)) {
				id	 = Integer.parseInt(userid);
				stmt.setInt(1, id);
			}
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				return new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int update(User user) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_UPDATE)) {
			stmt.setString(1, user.getUserName());
			stmt.setString(2, user.getTelephone());
			stmt.setString(3, user.getPassword());
			stmt.setInt(4, user.getUserId());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//delete
	public User FindById(String userid) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_SELECT_ID)) {
			int id = 0;
			if (!"".equals(userid)) {
				id	 = Integer.parseInt(userid);
				stmt.setInt(1, id);
			}
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("telephone"), rs.getString("password"));
			} else {
				return null;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public int delete(User user) {
		try (PreparedStatement stmt = connection.prepareStatement(SQL_DELETE)) {

				stmt.setInt(1, user.getUserId());

			return stmt.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
