package dto;


import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDTO {
	
	public int id;
	

	public String userName;
	public String mail;
	public int friends = 0;
	public int profileId;
	
	public UserDTO(){
		
	}
	
	public UserDTO copyDataFromUser(User user){
		this.id = user.id;
		this.userName = user.userName;
		this.mail = user.mail;
		this.friends = user.friends.size();
		this.profileId = user.profile.id;
		return this;
	}
	
	public ArrayList<UserDTO> copyDataFromUsers(List<User>users){
		ArrayList<UserDTO> listDtos = new ArrayList<UserDTO>();
		
		for(int i=0; i<users.size();i++){
			listDtos.add(new UserDTO().copyDataFromUser(users.get(i)));
		}
		
		return listDtos;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getFriends() {
		return friends;
	}

	public void setFriends(int friends) {
		this.friends = friends;
	}

	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	
	
}
