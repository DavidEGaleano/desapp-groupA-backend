package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kind.DayMoment;
import kind.KindOfTour;

public class System {
	
	public List<User> users;
	public List<Event> allEvents;
	public LogSystem logSystem;
	
	public System(LogSystem logSistem){
		this.users = new ArrayList<User>();
		this.allEvents = new ArrayList<Event>();
		this.logSystem = logSistem;
	}
	

	public User searchFriend(User user){
		User ret = null;
		for (User u  : users){
			if(users.contains(u))
				ret = u;
		}
		return ret;
	}

	public void addEvent(Event event){
		this.allEvents.add(event);
	}
	
	public Tour newTour(KindOfTour KindOfTour, Date date, DayMoment dayMoment, int limitAmount, List<User> friends){
		Tour tour = new Tour(KindOfTour, date, dayMoment, limitAmount, friends);
		this.generateEventOptions(tour);
		return tour;
	}

	public void generateEventOptions(Tour tour){
		List<Event> events = new ArrayList<Event>();
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
		return event.getDayMoment().equals(tour.getScheduler());
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
		List<Event> result = new ArrayList<Event>();
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
	
	public void registerNewUser(String userName, String password, String mail){
		this.logSystem.newUser(userName, password);
		User user = new User(this, userName, password, mail);
		this.users.add(user);
		this.logSystem.users.put(userName, password);
	}
	
	public void changePassword(String userName, String oldPassword, String newPassword){
		this.logSystem.changePassword(userName, oldPassword, newPassword);
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
}