package model;

import java.util.ArrayList;
import java.util.Date;

import kind.DayMoment;
import kind.KindOfTour;

public class Sistem {
	
	public ArrayList<User> users;
	public ArrayList<Event> allEvents;
	public LogSistem logSistem;
	
	public Sistem(LogSistem logSistem){
		this.users = new ArrayList<User>();
		this.allEvents = new ArrayList<Event>();
		this.logSistem = logSistem;
	}
	

	public User searchFriend(User user) throws Exception{
		this.existsUser(user);
		User usuario = null;
		for (User u  : users){
			if(users.contains(u))
				usuario = u;
		}
		return usuario;
	}

	public void addEvent(Event event){
		this.allEvents.add(event);
	}
	
	public boolean existsUser(User user){
		return !this.users.contains(user);
	}
	
	public Tour newTour(KindOfTour KindOfTour, Date date, DayMoment dayMoment, int limitAmount, ArrayList<User> friends){
		Tour tour = new Tour(KindOfTour, date, dayMoment, limitAmount, friends);
		this.generateEventOptions(tour);
		return tour;
	}

	public void generateEventOptions(Tour tour){
	//Deberia hacer una query que traiga los eventos para una fecha, horario, limite de personas y monto indicados
		ArrayList<Event> events = new ArrayList<Event>();
		for(Event event: this.allEvents){
			if(this.conditionA(event, tour) && this.conditionB(event, tour) && this.conditionC(event, tour) && this.conditionD(event, tour)){
				events.add(event);
			}
		}
		tour.setEventOptions1(events);
		tour.setEventOptions2(events);
	}  
	
	private Boolean conditionA(Event event, Tour tour){
		return event.getDate().equals(tour.getDate());
	}
	
	private Boolean conditionB(Event event, Tour tour){
		return event.getScheduler().equals(tour.getScheduler());
	}
	
	private Boolean conditionC(Event event, Tour tour){
		return event.getLimitOfPersons() <= tour.getFriends().size();
	}
	
	private Boolean conditionD(Event event, Tour tour){
		return event.getAmount() <= tour.getLimitAmount();
	}
	 
	public void selectEvent1ForATour(Event event, Tour tour){
		tour.addEvent1(1, event);
		tour.eventOptions2.remove(event);
		this.refreshEvents2(tour);
	}

	public void selectEvent2ForATour(Event event, Tour tour){
		tour.addEvent1(2, event);
	}
	
	private void refreshEvents2(Tour tour) {
		ArrayList<Event> result = new ArrayList<Event>();
		for(Event event: tour.getEventOptions2()){
			if(this.conditionE(event, tour)){
				result.add(event);
			}
		}
		tour.setEventOptions2(result);
	}
	
	private Boolean conditionE(Event event, Tour tour){
		return event.getAmount() <= (tour.getLimitAmount() - tour.getEvent1().getAmount());
	}
	
	public void registerNewUser(String userName, String password, String mail) throws Exception{
		this.logSistem.newUser(userName, password);
		User user = new User(this, userName, password, mail);
		this.users.add(user);
		this.logSistem.users.put(userName, password);
	}
	
	public void changePassword(String userName, String oldPassword, String newPassword)throws Exception{
		this.logSistem.changePassword(userName, oldPassword, newPassword);
		this.obtainUser(userName).setPassword(newPassword);
	}
	
	public User obtainUser(String userName){
		for(User user: this.users){
			if(user.getName() == userName){
				return user;
			}
		}
		return null;
	}
	
	public void logIn(String userName, String password) throws Exception{
		this.logSistem.logIn(userName, password);
		this.obtainUser(userName).setLogged(true);
	}

	public void logOut(String userName) throws Exception{
		this.obtainUser(userName).setLogged(false);
	}
}