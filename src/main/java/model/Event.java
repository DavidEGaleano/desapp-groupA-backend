package model;

import java.util.ArrayList;
import java.util.Date;
import kind.Kind;
import kind.DayMoment;

public class Event {

	public ArrayList<Kind> types;
	public Date date;
	public DayMoment scheduler;
	public String address;
	public int amount;
	public int limitOfPersons;
	public ArrayList<Event> suggestions;
	
	public Event(ArrayList<Kind> types, Date date, DayMoment scheduler, String address, int amount, int limitOfPersons){
		this.types = types;
		this.date = date;
		this.scheduler = scheduler;
		this.address = address;
		this.amount = amount;
		this.limitOfPersons = limitOfPersons;
		this.suggestions = new ArrayList<Event>();
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Methods
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void newSuggestion(Event event){
		this.suggestions.add(event);
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public int getAmount(){
		return this.amount;
	}
	
	public Date getDate(){
		return this.date;
	}
	
	public DayMoment getScheduler(){
		return this.scheduler;
	}

	public int getLimitOfPersons(){
		return this.limitOfPersons;
	}
	
	public void setSuggestions(ArrayList<Event> suggestions) {
		this.suggestions = suggestions;
	}
}