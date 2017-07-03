package Service;
import java.sql.Connection;

import dao.AdminDao;
import entity.Admin;
import util.DbUtil;

public class AdminService {
	public Admin authentication(String admin_id, String password) {
		try (Connection conn = DbUtil.getConnection()) {
			AdminDao adminDao = new AdminDao(conn);
			Admin admin = adminDao.findByIdAndPass(admin_id, password);

			return admin;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
