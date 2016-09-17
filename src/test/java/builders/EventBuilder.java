package builders;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import kind.DayMoment;
import kind.Kind;
import model.Event;

public class EventBuilder {
	
	private ArrayList<Kind> types = new ArrayList<Kind>();
	private Date date = createDate();
	private DayMoment scheduler = DayMoment.NIGHT;
	private String address = "an address";
	private int amount = 1000;
	private int limitOfPersons = 3;
	private ArrayList<Event> suggestions = new ArrayList<Event>();
	
	public static EventBuilder anEvent(){
		return new EventBuilder();
	}
	
	
	private Date createDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016,8,12);
        Date date =  calendar.getTime();
        return date;
	}	
	
	public Event build(){
		Event event = new Event(types, date, scheduler, address, amount, limitOfPersons);
		event.setSuggestions(suggestions);
		return event;
	}
	
	public EventBuilder withTypes(ArrayList<Kind> pTypes){
		types = pTypes;
		return this;
	}
	
	public EventBuilder withDate(Date aDate){
		date = aDate;
		return this;
	}
	
	public EventBuilder withScheduler(DayMoment aDayMoment){
		scheduler = aDayMoment;
		return this;
	}
	
	public EventBuilder withAddress(String anAddress){
		address = anAddress;
		return this;
	}
	
	public EventBuilder withAmount(int anAmount){
		amount = anAmount;
		return this;
	}
	
	public EventBuilder withLimitOfPersons(int aLimit){
		limitOfPersons = aLimit;
		return this;
	}
	
	public EventBuilder withSuggestion(ArrayList<Event> anSuggestions){
		suggestions = anSuggestions;
		return this;
	}
	
	
}
