package logic;

public class User {
	private String username;
	private String password;
	private String comfirmpassword;
	private String email;
	private String gender;
	
	public User(String user, String password, String confirmpassword, String email, String gender){
		this.username = user;
		this.password= password;
		this.comfirmpassword=comfirmpassword;
		this.email=email;
		this.gender=gender;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getComfirmpassword() {
		return comfirmpassword;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}
}
