package model;

import java.util.ArrayList;
import java.util.List;

import persistance.services.EventService;
import persistance.services.UserService;

public class SearchMode {

	protected SearchStrategy mode;
	public UserService userservice;
	public EventService eventservice;
	
	public UserService getUserservice() {
		return userservice;
	}

	public void setUserservice(UserService userservice) {
		this.userservice = userservice;
	}

	public EventService getEventservice() {
		return eventservice;
	}

	public void setEventservice(EventService eventservice) {
		this.eventservice = eventservice;
	}

	public void economicMode(int idUser) {
		this.mode = new EconomicSearch(userservice.getById(idUser),userservice,eventservice);
	}

	public void withFriendMode(int idUser) {
		this.mode = new WithFriendSearch(userservice.getById(idUser),userservice,eventservice);	
	}

	public void saturdayNightFeverMode(int idUser) {
		this.mode = new SaturdayNightFeverSearch(userservice.getById(idUser),userservice,eventservice);		
	}

	public void betterHalfMode(int idUser) {
		this.mode = new BetterHalfSearch(userservice.getById(idUser),userservice,eventservice);
	}

	public void surpriseMeMode(int idUser) {
		this.mode = new SurpriseMeSearch(userservice.getById(idUser),userservice,eventservice);
	}
	
	public void setEvents(ArrayList<Event> event){
		mode.setEvents(event);
	}
	
	public List<Event> doSearch(){
		return mode.search();
	}

}
