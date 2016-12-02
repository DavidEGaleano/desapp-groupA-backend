package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import kind.DayMoment;
import kind.Kind;

public class Event {
	
	public int id;
	public List<Kind> types;
	public String name;
	public Date date;
	public DayMoment dayMoment;
	public String address;
	public int amount;
	public double lat;
	public double lng;
	public int limitOfPersons;
	public List<Event> suggestions;
	
	public Event(){
		
	}
	
	public Event(List<Kind> types, Date date, DayMoment dayMoment, String address, int amount, int limitOfPersons, double lat, double lng, String name){
		this.types = types;
		this.date = date;
		this.dayMoment = dayMoment;
		this.address = address;
		this.amount = amount;
		this.limitOfPersons = limitOfPersons;
		this.suggestions = new ArrayList<Event>();
		this.lat = lat;
		this.lng = lng;
		this.name = name;
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
	
	public DayMoment getDayMoment(){
		return this.dayMoment;
	}
	
	public List<Kind> getTypes(){
		return this.types;
	}

	public int getLimitOfPersons(){
		return this.limitOfPersons;
	}
	
	public void setSuggestions(List<Event> suggestions) {
		this.suggestions = suggestions;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setLimitOfPersons(int limitOfPersons) {
		this.limitOfPersons = limitOfPersons;
	}
	
	public void addType(Kind type){
		this.types.add(type);
	}
}