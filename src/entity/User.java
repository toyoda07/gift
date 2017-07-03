package entity;


public class User {

	public int user_id;
	public String user_name;
	private String telephone;
	private String password;

	public User() {
	}

	public User(int user_id, String user_name, String telephone ,String password) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.telephone = telephone;
		this.password = password;
	}
	public User(int user_id, String user_name, String telephone) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.telephone = telephone;
	}

	public User(int user_id) {
		this.user_id = user_id;
	}

	public User(String user_name, String telephone,String password) {
		this.user_name = user_name;
		this.telephone = telephone;
		this.password = password;
	}

	public User(String user_name, String telephone,String password,int user_id) {
		this.user_name = user_name;
		this.telephone = telephone;
		this.password = password;
		this.user_id = user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public int getUserId() {
		return this.user_id;
	}

	public void setUserName(String user_name) {
		this.user_name = user_name;
	}

	public String getUserName() {
		return this.user_name;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return this.password;
	}
}
