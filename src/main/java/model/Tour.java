package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kind.DayMoment;
import kind.KindOfTour;

public class Tour {
	
	public KindOfTour type;
	public Date date;
	public DayMoment scheduler;
	public int amount;
	public int limitAmount;
	public List<User> friends;
	public List<Event> eventOptions1;
	public List<Event> eventOptions2;
	public Event event1;
	public Event event2;
	
	public Tour(KindOfTour typeOfTour, Date date, DayMoment scheduler, int limitAmount, List<User> friends){
		this.type = typeOfTour;
		this.date = date;
		this.scheduler = scheduler;
		this.amount = 0;
		this.limitAmount = limitAmount;
		this.friends = friends;
		this.eventOptions1 = new ArrayList<Event>();
		this.eventOptions2 = new ArrayList<Event>();
		this.event1 = null;
		this.event2 = null;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void makeSuggestions(){
		this.event1.newSuggestion(this.event2);
		this.event2.newSuggestion(this.event1);
	}

	public void addEvent1(int eventNumber, Event event){
		if(eventNumber == 1){
			this.event1 = event;
		}else{
			this.event2 = event;
		}
		this.amount += event.getAmount();
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Event getEvent1(){
		return this.event1;
	}
	
	public int getLimitAmount(){
		return this.limitAmount;
	}	
	
	public List<User> getFriends() {
		return friends;
	}

	public Date getDate() {
		return date;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public DayMoment getScheduler() {
		return scheduler;
	}

	public List<Event> getEventOptions1() {
		return eventOptions1;
	}
	
	public List<Event> getEventOptions2(){
		return this.eventOptions2;
	}
	
	public void setEventOptions1(List<Event> events){
		this.eventOptions1 = events;
	}
	
	public void setEventOptions2(List<Event> events){
		this.eventOptions2 = events;
	}

	public void setEvent1(Event event1) {
		this.event1 = event1;
	}
	
	public void setEvent2(Event event2) {
		this.event2 = event2;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}