package logic;

public class Contributor{
	private String username;
	private String password;
	private boolean isValid;


	public Contributor(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public boolean isValid() {
		return isValid;
	}

}
