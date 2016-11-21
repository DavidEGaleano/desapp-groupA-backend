package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kind.DayMoment;
import kind.KindOfTour;


public class User {
	
	public int id;
	public String userName;
	public String password;
	public String mail;
	public Profile profile;
	public List<Tour> tours;
	public List<Event> events;
	public List<User> friends;
	public System system; 
	public List<User> friendsRequests;
	public Boolean logged;
	
	public User(){}
	
	public User(System sistem, String userName, String password, String mail){
		this.userName = userName;
		this.password = password;
		this.mail = mail;
		this.profile = null;
		this.tours = new ArrayList<Tour>();
		this.events = new ArrayList<Event>();
		this.friends = new ArrayList<User>();
		this.system = sistem;
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

	public void newTour(KindOfTour kindOfTour, Date date, DayMoment scheduler, int limitAmount, List<User> friends){
		this.tours.add(this.system.newTour(kindOfTour, date, scheduler, limitAmount, friends));
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
	
	//Deberia tirar Exception en un futuro
	//¿Es necesario que usuario tenga buscar amigo, si lo delega a system?
	//si es "search friend" mejor que sea a si mismo, si tiene los amigos.
	public User searchFriend(User user){
		return this.system.searchFriend(user);
	}
	
	public void sendFriendRequest(User friend){
		this.friendsRequests.add(friend);
	}

	public void deleteFriend(User friend){
		this.friends.remove(friend);
		friend.getFriends().remove(this);
	}
	
	public void acceptFriend(User friend){
		this.friendsRequests.remove(friend);
		this.addFriend(friend);
		friend.addFriend(this);
	}
	
	public void cancelFriend(User friend){
		this.friendsRequests.remove(friend);
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Login Methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean isLogged(){
		return !this.logged;
	}
	
	public void changePassword(String userName, String oldPassword, String newPassword)throws Exception{
		this.system.changePassword(userName, oldPassword, newPassword);
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
	
	public List<Tour> getTours() {
		return tours;
	}
	
	public List<Event> getEvents() {
		return events;
	}

	public System getSistem() {
		return system;
	}
	
	public List<User> getFriends(){
		return this.friends;
	}

	public List<User> getFriendsRequests() {
		return friendsRequests;
	}
	
	public void setPassword(String password){
		this.password = password;
	}
	
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	public void setTours(List<Tour> tours) {
		this.tours = tours;
	}
	
	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public void setFriendsRequests(List<User> friendsRequests) {
		this.friendsRequests = friendsRequests;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	public void setLogged(Boolean logged){
		this.logged = logged;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}
	
	public int getLimitAmount(){
		return this.profile.getLimitAmount();
	}

}