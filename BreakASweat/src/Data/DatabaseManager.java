package Data;

import java.util.ArrayList;
import logic.User;
import Data.TempUserRecord;

public class DatabaseManager {
	private TempUserRecord userrecord;
	private TempContributorRecord contributor;
	private TempMusicRecord music;
	private TempProgramRecord program;

	private ArrayList<TempMusicRecord> musicRegister = new ArrayList<TempMusicRecord>();
	public ArrayList<TempUserRecord> userRegister = new ArrayList<TempUserRecord>();
	private ArrayList<TempContributorRecord> contributorRegister = new ArrayList<TempContributorRecord>();
	private ArrayList<TempProgramRecord> programRegister = new ArrayList<TempProgramRecord>();

	public DatabaseManager() {

		TempUserRecord user1 = new TempUserRecord("ryan", "ting123");
		TempUserRecord user2 = new TempUserRecord("fred", "fred123");
		TempUserRecord user3 = new TempUserRecord("sheng", "sheng123");

		userRegister.add(user1);
		userRegister.add(user2);
		userRegister.add(user3);

		TempContributorRecord con1 = new TempContributorRecord("kimchi", "kimchi123", "Male", "Athelete", "0138359611");
		TempContributorRecord con2 = new TempContributorRecord("jiayih", "jiayih123", "Male", "FastRunner", "0123456789");
		TempContributorRecord con3 = new TempContributorRecord("lam", "lam123", "Male", "Footballer", "0198765432");
		
		contributorRegister.add(con1);
		contributorRegister.add(con2);
		contributorRegister.add(con3);

		TempProgramRecord prog1 = new TempProgramRecord("5x5 Program", "img/5x5.jpg", "Fred", "The five-by-five program is one that is quite popular among those who are looking to gain a high amount of strength and muscle mass.", "RM700", true);
		TempProgramRecord prog2 = new TempProgramRecord("German Volume Training", "img/GVT.jpg", "Ryan", "The design of this program is to focus on two main muscle groups per day, alternating between them over the course of three days a week.", "RM900", true);
		TempProgramRecord prog3 = new TempProgramRecord("FST-7 Training", "img/FST.jpg", "Kimchi", "It is primarily responsible for helping to maintain the structural integrity of the body, provide support and protection.", "RM500", true);
		TempProgramRecord prog4 = new TempProgramRecord("Upper/Lower Split", "img/split.jpg", "J Yon", "This set-up is typically performed on a two on, one off schedule and allows you to hit each muscle group twice per week.", "RM300", true);
		TempProgramRecord prog5 = new TempProgramRecord("Full Body Workout", "img/full.jpg", "J Yon", "Full-body programs will provide one direct exercise for each muscle group.", "RM100", true);
		
		programRegister.add(prog1);
		programRegister.add(prog2);
		programRegister.add(prog3);
		programRegister.add(prog4);
		programRegister.add(prog5);
	}

	public boolean verifyUser(String username, String pwd) {
		for (TempUserRecord user: userRegister) {
			if (user.getUsername().equals(username) && user.getPassword().equals(pwd)){
				System.out.println("true");
				return true;
			}
		}
		return false;
		
	}
	
	public boolean verifyContributor(String username, String password) {
		for (TempContributorRecord contributor: contributorRegister) {
			if (contributor.getUsername().equals(username) && contributor.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}

	public TempUserRecord getUser(String username, String password) {
		for (TempUserRecord user : userRegister) {
			if (userrecord.getUsername().equals(username) && userrecord.getPassword().equals(password))
				return user;
		}

		return null;
	}
	public ArrayList<TempUserRecord> getUserList(){
		return userRegister;
	}
	public ArrayList<TempContributorRecord> getContList(){
		return contributorRegister;
	}

	public TempContributorRecord getContributor(String username, String password) {
		for (TempContributorRecord contributor : contributorRegister) {
			if (contributor.getUsername().equals(username) && contributor.getPassword().equals(password))
				return contributor;
		}

		return null;
	}

	public ArrayList<TempUserRecord> getUserRegister() {
		return userRegister;
	}

	public ArrayList<TempContributorRecord> getContributorRegister() {
		return contributorRegister;
	}

	public ArrayList<TempMusicRecord> getMusic() {
		return musicRegister;
	}

	public ArrayList<TempProgramRecord> getProgram() {
		return programRegister;
	}
	
	public void insertUser(String username, String password) {
		TempUserRecord user = new TempUserRecord(username, password);
		userRegister.add(user);
	}
	public void insertContributor(String username, String password, String gender, String pro, String contact) {
		TempContributorRecord cont = new TempContributorRecord(username, password, gender, pro, contact);
		contributorRegister.add(cont);
	}
	
	public void viewAllUsers() {
		ArrayList<User> userlist = new ArrayList<User>();

		for (TempUserRecord tempuser : userRegister) {
			System.out.println(tempuser.getUsername());
			
		}
	}

}
