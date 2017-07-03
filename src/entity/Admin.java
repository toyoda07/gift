package entity;

public class Admin {
	private String adminId;
	private String adminName;
	private String Password;

	public Admin() {
	}

	public Admin(String admin_id, String admin_name,String password) {
		this.adminId = admin_id;
		this.adminName = admin_name;
		this.Password = password;
	}

	public void setAdminId(String admin_id) {
		this.adminId = admin_id;
	}

	public String getAdminId() {
		return this.adminId;
	}

	public void setAdminName(String admin_name) {
		this.adminName = admin_name;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setPassword(String password) {
		this.Password = password;
	}

	public String getPassword() {
		return this.Password;
	}

}
