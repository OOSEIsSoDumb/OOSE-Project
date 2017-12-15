package logic;

public class MainSystem {
	private String name;
	
	public MainSystem(String name){
		this.name=name;
	}
	
	public boolean isValidUser(String username, String password){
		return db.verifyUser(username, password);
	}
	public void isValidContributor(boolean isContributor){
		return db.verifyContributor(isContributor);
	}
}
