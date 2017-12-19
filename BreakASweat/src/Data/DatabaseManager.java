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
	private ArrayList<TempWorkoutRecord> workoutRegister = new ArrayList<TempWorkoutRecord>();


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

		TempProgramRecord prog1 = new TempProgramRecord("5x5 Program", "img/5x5.jpg", "Fred", "The five-by-five program is one that is quite popular among those who are looking to gain a high amount of strength and muscle mass.", "RM700");
		TempProgramRecord prog2 = new TempProgramRecord("German Volume Training", "img/GVT.jpg", "Ryan", "The design of this program is to focus on two main muscle groups per day, alternating between them over the course of three days a week.", "RM900");
		TempProgramRecord prog3 = new TempProgramRecord("FST-7 Training", "img/FST.jpg", "Kimchi", "It is primarily responsible for helping to maintain the structural integrity of the body, provide support and protection.", "RM500");
		TempProgramRecord prog4 = new TempProgramRecord("Upper/Lower Split", "img/split.jpg", "J Yon", "This set-up is typically performed on a two on, one off schedule and allows you to hit each muscle group twice per week.", "RM300");
		TempProgramRecord prog5 = new TempProgramRecord("Full Body Workout", "img/full.jpg", "J Yon", "Full-body programs will provide one direct exercise for each muscle group.", "RM100");
		
		programRegister.add(prog1);
		programRegister.add(prog2);
		programRegister.add(prog3);
		programRegister.add(prog4);
		programRegister.add(prog5);

		TempWorkoutRecord w1 = new TempWorkoutRecord("PUSH UPS", "Workouts/pushups.png");
		TempWorkoutRecord w2 = new TempWorkoutRecord("BACK PRESS", "Workouts/backpress.jpg");
		TempWorkoutRecord w3 = new TempWorkoutRecord("PULL UPS", "Workouts/pullups.jpg");
		TempWorkoutRecord w4 = new TempWorkoutRecord("BENCHED PRESS", "Workouts/benchedpress.jpg");
		TempWorkoutRecord w5 = new TempWorkoutRecord("CABLE FLY", "Workouts/cablefly.png");
		TempWorkoutRecord w6 = new TempWorkoutRecord("DEAD LIFT", "Workouts/deadlift.jpg");
		TempWorkoutRecord w7 = new TempWorkoutRecord("DUMBBELL FLYS", "Workouts/download.jpg");
		TempWorkoutRecord w8 = new TempWorkoutRecord("PARALLEL BAR DIPS", "Workouts/bardips.jpg");
		TempWorkoutRecord w9 = new TempWorkoutRecord("BARBELL CURLS", "Workouts/barbellcurl.jpg");
		TempWorkoutRecord w10 = new TempWorkoutRecord("HAMMER CURLS", "Workouts/Hammer_Curls.png");
		TempWorkoutRecord w11 = new TempWorkoutRecord("CARDIO", "Workouts/cardio.jpg");
		TempWorkoutRecord w12 = new TempWorkoutRecord("UPRIGHT ROWS", "Workouts/uprightrow.jpg");
		
		workoutRegister.add(w1);
		workoutRegister.add(w2);
		workoutRegister.add(w3);
		workoutRegister.add(w4);
		workoutRegister.add(w5);
		workoutRegister.add(w6);
		workoutRegister.add(w7);
		workoutRegister.add(w8);
		workoutRegister.add(w9);
		workoutRegister.add(w10);
		workoutRegister.add(w11);
		workoutRegister.add(w12);	
	}

	public boolean verifyUser(String username, String pwd) {
		for (TempUserRecord user: userRegister) {
			if (user.getUsername().equals(username) && user.getPassword().equals(pwd)){
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
	public ArrayList<TempWorkoutRecord> getWorkoutRegister() {
		return workoutRegister;
	}
	public void insertUser(String username, String password) {
		TempUserRecord user = new TempUserRecord(username, password);
		userRegister.add(user);
	}
	public void insertContributor(String username, String password, String gender, String pro, String contact) {
		TempContributorRecord cont = new TempContributorRecord(username, password, gender, pro, contact);
		contributorRegister.add(cont);
	}
	public void insertProgram(String title, String pictures, String authors, String details, String price){
		TempProgramRecord program = new TempProgramRecord(title, pictures, authors, details, price);
		programRegister.add(program);
	}
	
	public void viewAllUsers() {
		ArrayList<User> userlist = new ArrayList<User>();

		for (TempUserRecord tempuser : userRegister) {
			System.out.println(tempuser.getUsername());
			
		}
	}

}
