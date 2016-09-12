package model;

import java.util.HashMap;
import java.util.Map;

public class LogSistem {

	public Map<String,String> users;
	
	public LogSistem(){
		this.users = new HashMap<String, String>();
	}
	
	public void newUser(String userName, String password) throws Exception{
		this.validateNewUser(userName);
		this.validatePassword(password);
	}
		
	public boolean validateNewUser(String userName) throws Exception{
		return this.users.containsKey(userName);
	}
	
	public boolean validatePassword(String password) throws Exception{
		return (password.length() < 4 || password.length() > 12);
	}
	
	public void logIn(String userName, String password) throws Exception{
		this.validateLog(userName, password);
	}
	
	public boolean validateLog(String userName, String password){
		return !this.users.containsKey(userName);
	}
	
	public void changePassword(String userName, String oldPassword, String newPassword)throws Exception{
		this.validateLog(userName, oldPassword);
		this.validatePassword(newPassword);
		this.users.put(userName, newPassword); 
	}
}