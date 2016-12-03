package builders;

import java.util.ArrayList;

import kind.Kind;
import model.Event;
import model.LogSystem;
import model.Profile;
import model.System;
import model.Tour;
import model.User;

public class UserBuilder {
	
	private String userName = "aName";
	private String password = "aPassword";
	private String token = null;
	private String mail = "aMail";
	private System system = new System(new LogSystem()); 
	private Profile profile = new Profile(Kind.COMEDY,Kind.CLASSIC,Kind.SUSHI,1000,10);
	private ArrayList<Tour> tours = new ArrayList<Tour>();
	private ArrayList<Event> events = new ArrayList <Event>();
	private ArrayList<User> friends = new ArrayList<User>();
	private ArrayList<User> friendsRequests = new ArrayList<User>();
	private Boolean logged = false;
	
	public static UserBuilder anUser(){
		return new UserBuilder();
	}
	
	public User build(){
		User user = new User(system, userName, password, mail);
		user.setEvents(events);
		user.setTours(tours);
		user.setFriends(friends);
		user.setFriendsRequests(friendsRequests);
		user.setProfile(profile);
		user.setLogged(logged);
		user.setToken(token);
		return user;
	}
	
	public UserBuilder withToken(String ptoken){
		token = ptoken;
		return this;
	}
	
	public UserBuilder withLogged(Boolean aLogState){
		logged = aLogState;
		return this;
	}
	
	public UserBuilder withProfile(Profile aProfile){
		profile = aProfile;
		return this;
	}
	
	
	public UserBuilder withFriends(ArrayList<User> aFriends){
		friends = aFriends;
		return this;
	}
	
	public UserBuilder withFriendRequest(ArrayList<User> aFriendsReq){
		friendsRequests = aFriendsReq;
		return this;
	}
	
	public UserBuilder withTours(ArrayList<Tour> anTours){
		tours = anTours;
		return this;
	}
	
	public UserBuilder withEvents(ArrayList<Event> anEvents){
		events = anEvents;
		return this;
	}
	
	public UserBuilder withMail(String aMail){
		mail = aMail;
		return this;
	}
	
	public UserBuilder withPassword(String aPassword){
		password = aPassword;
		return this;
	}
	
	public UserBuilder withSystem(System aSystem){
		system = aSystem;
		return this;
	}
	
	public UserBuilder withUserName(String aName){
		userName = aName;
		return this;
	}
	
	
}