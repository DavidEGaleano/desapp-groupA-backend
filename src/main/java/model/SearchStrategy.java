package model;

import java.util.ArrayList;
import java.util.List;

import kind.Kind;
import persistance.services.EventService;
import persistance.services.UserService;

public abstract class SearchStrategy {
	
	protected User user;
	protected UserService userservice;
	protected EventService eventservice;
	protected ArrayList<Kind> types;
	//Temporal hasta que se tenga que trabajar
	//con la BD. (solo para testeo).
	protected ArrayList<Event> events;
	
	public SearchStrategy(User user, UserService puserservice, EventService peventservice){
		this.user = user;
		this.userservice = puserservice;
		this.eventservice = peventservice;
		this.types = new ArrayList<Kind>();
	}
	
	public abstract List<Event> search();
	
	private void setKindTypes(User pUser){
		types.add(pUser.getProfile().getTypeOfFood());
		types.add(pUser.getProfile().getTypeOfFilm());
		types.add(pUser.getProfile().getTypeOfMusic());
	}
	
	protected ArrayList<Event> userEventPreferences(User pUser, ArrayList<Event> pEvents){
		ArrayList<Event> events = new ArrayList<Event>();
		this.setKindTypes(pUser);
		for(int i=0;i < pEvents.size();i++){
			Event event = pEvents.get(i);
			if(this.matchAllTypes(event)&&this.matchAmount(pUser,event)){
				events.add(event);
			}
		}
		this.types = new ArrayList<Kind>();
		return events;
	}
	
	private boolean matchAmount(User friend, Event event){
		return friend.getProfile().getLimitAmount() >= event.amount;
	}
	
	private boolean matchAllTypes(Event event){
		List<Kind> eventTypes = event.getTypes();
		return containsAllUserKind(eventTypes);
	}
	
	private boolean containsAllUserKind(List<Kind> events){
		boolean value = true;
		for(int i=0; i < events.size();i++){
			if(value){
				value = types.contains(events.get(i));
			}else{
				return value;
			}
			i++;
		}
		
		return value;
	}
	
	public void setEvents (ArrayList<Event> events){
		this.events = events;
	}
	
}
