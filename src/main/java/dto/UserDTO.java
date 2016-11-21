package dto;


import java.util.ArrayList;
import java.util.List;

import model.Event;
import model.Tour;
import model.User;

public class UserDTO {
	
	public int id;
	public String userName;
	public String password;
	public String mail;
	public int friends = 0;
	public int profileId;
	public List<Tour> tours;
	public List<Event> events;
	public Boolean logged;
	
	public UserDTO copyDataFromUser(User user){
		this.id = user.id;
		this.userName = user.userName;
		this.mail = user.mail;
		this.friends = user.friends.size();
		this.tours= user.tours;
		this.events = user.events;
		this.profileId = user.profile.id;
		this.logged = user.logged;
		return this;
	}
	
	public ArrayList<UserDTO> copyDataFromUsers(List<User>users){
		ArrayList<UserDTO> listDtos = new ArrayList<UserDTO>();
		
		for(int i=0; i<users.size();i++){
			listDtos.add(new UserDTO().copyDataFromUser(users.get(i)));
		}
		
		return listDtos;
	}
	
	
}
