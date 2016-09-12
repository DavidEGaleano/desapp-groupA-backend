package model;

import java.util.ArrayList;
import java.util.Date;

import kind.DayMoment;
import kind.KindOfTour;

public class User {
	
	public String userName;
	public String password;
	public String mail;
	public Profile profile;
	public ArrayList<Tour> tours;
	public ArrayList<Event> events;
	public ArrayList<User> friends;
	public Sistem sistem; 
	public ArrayList<User> friendsRequests;
	public Boolean logged;
	
	public User(Sistem sistem, String userName, String password, String mail){
		this.userName = userName;
		this.password = password;
		this.mail = mail;
		this.profile = null;
		this.tours = new ArrayList<Tour>();
		this.events = new ArrayList<Event>();
		this.friends = new ArrayList<User>();
		this.sistem = sistem;
		this.friendsRequests = new ArrayList<User>();
		this.logged = false;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void loadProfile(Profile profile){
		this.profile = profile;
	}
	
	public void addEvent(Event event){
		this.events.add(event);
	}

	public void newTour(KindOfTour kindOfTour, Date date, DayMoment scheduler, int limitAmount, ArrayList<User> friends){
		this.tours.add(this.sistem.newTour(kindOfTour, date, scheduler, limitAmount, friends));
	}

	public void acceptTour(Tour tour){
		this.tours.add(tour);
		tour.makeSuggestions();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Friendship Methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addFriend(User friend){
		this.friends.add(friend);
	}
	
	public User searchFriend(User user) throws Exception{
		return this.sistem.searchFriend(user);
	}
	
	public void sendFriendRequest(User friend){
		this.friendsRequests.add(friend);
	}
	
	public void deleteFriend(User friend){
		this.friends.remove(friend);
		friend.getFriends().remove(this);
	}
	
	public void acceptFriend(User friend){
		this.friends.add(friend);
		friend.getFriends().add(this);
	}
	
	public void cancelFriend(User friend){
		this.friendsRequests.remove(friend);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Login Methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void logIn(String userName, String password) throws Exception{
		this.sistem.logIn(userName, password);
	}

	public void logOut(String userName) throws Exception{
		this.sistem.logOut(userName);
	}
	
	public boolean isLogged(){
		return !this.logged;
	}
	
	public void changePassword(String userName, String oldPassword, String newPassword)throws Exception{
		this.sistem.changePassword(userName, oldPassword, newPassword);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Profile getProfile() {
		return profile;
	}

	public String getName(){
		return this.userName;
	}
	
	public ArrayList<Tour> getTours() {
		return tours;
	}
	
	public ArrayList<Event> getEvents() {
		return events;
	}

	public Sistem getSistem() {
		return sistem;
	}
	
	public ArrayList<User> getFriends(){
		return this.friends;
	}

	public ArrayList<User> getFriendsRequests() {
		return friendsRequests;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	public void setTours(ArrayList<Tour> tours) {
		this.tours = tours;
	}
	
	public void setEvents(ArrayList<Event> events) {
		this.events = events;
	}

	public void setFriendsRequests(ArrayList<User> friendsRequests) {
		this.friendsRequests = friendsRequests;
	}

	public void setFriends(ArrayList<User> friends) {
		this.friends = friends;
	}
	
	public void setLogged(Boolean logged){
		this.logged = logged;
	}
}