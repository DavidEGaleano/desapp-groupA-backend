package model;

import java.util.HashMap;
import java.util.Map;

public class LogSystem {

	public Map<String, String> users;
	public User userLogged;

	public LogSystem() {
		this.users = new HashMap<String, String>();
	}
	
	public void newUser(String userName, String password) {
		if (this.notExistUser(userName) && this.correctPaswordSize(password)) {
			users.put(userName, password);
		}
	}

	public boolean notExistUser(String userName) {
		return !this.users.containsKey(userName);
	}

	public boolean correctPaswordSize(String password) {
		return (password.length() > 4 && password.length() < 12);
	}

	/*public void logIn(String userName, String password) {
		if(this.autenticateUser(userName, password)){
			//userLogged = getUserByName(username);
		}
	}*/

	public boolean autenticateUser(String userName, String password) {
		return this.users.containsKey(userName) && users.get(userName).equals(password);
	}

	public void changePassword(String userName, String oldPassword, String newPassword){
		if (this.autenticateUser(userName, oldPassword) && this.correctPaswordSize(newPassword)) {
			this.users.put(userName, newPassword);
		}
	}
	
	public void logOut(){
		this.userLogged = null;
	}
	
	public Map<String, String> getUsers(){
		return this.users;
	}
}