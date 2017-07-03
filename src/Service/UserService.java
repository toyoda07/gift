package Service;

import java.sql.Connection;
import java.util.Collections;
import java.util.List;

import dao.UserDao;
import entity.User;
import util.DbUtil;

public class UserService {

	public List<User> findAll() {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			return userDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public List<User> find(String userid,String user_name,String telephone,String sqljoin) {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			return userDao.find(userid,user_name,telephone,sqljoin);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public User findId(String userid) {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			return userDao.findId(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	//insert
	public int register(User user) {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			return userDao.insert(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public int maxid() {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			int maxid = userDao.selectmax();
			return maxid;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	//update
	public int Maxid() {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			return userDao.selectmax() ;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	public User findById(String userid) {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			return userDao.findById(userid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}


	public int update(User user) {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			return userDao.update(user) ;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	//delete
	public int delete(User user) {
		try (Connection conn = DbUtil.getConnection()) {
			UserDao userDao = new UserDao(conn);
			return userDao.delete(user) ;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

}