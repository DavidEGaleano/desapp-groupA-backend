package builders;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import kind.DayMoment;
import kind.KindOfTour;
import model.Event;
import model.Tour;
import model.User;

public class TourBuilder {
	
	private EventBuilder anEvent = new EventBuilder();
	public KindOfTour type = KindOfTour.CHEAPER;
	public Date date = createDate() ;
	public DayMoment scheduler = DayMoment.NIGHT;
	public int amount = 4;
	public int limitAmount = 1500;
	public ArrayList<User> friends = new ArrayList<User>();
	public ArrayList<Event> eventOptions1 = new ArrayList<Event>();
	public ArrayList<Event> eventOptions2 = new ArrayList<Event>();
	public Event event1 = anEvent.build();
	public Event event2 = anEvent.build();
	
	private Date createDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(2016,8,12);
        Date date =  calendar.getTime();
        return date;
	}
	
	public Tour Build(){
		Tour aTour = new Tour(type, date, scheduler, limitAmount, friends);
		aTour.setAmount(amount);
		aTour.setEvent1(event1);
		aTour.setEvent2(event2);
		aTour.setEventOptions1(eventOptions1);
		aTour.setEventOptions2(eventOptions2);
		return aTour;
	}
	
	public TourBuilder withEventOptions2(ArrayList<Event> aEventOpt2){
		eventOptions2 = aEventOpt2;
		return this;
	}
	
	public TourBuilder withEventOptions1(ArrayList<Event> aEventOpt){
		eventOptions1 = aEventOpt;
		return this;
	}
	
	public TourBuilder withEvent2(Event aEvent){
		event2 = aEvent;
		return this;
	}
	
	public TourBuilder withEvent1(Event aEvent){
		event1 = aEvent;
		return this;
	}
	
	public TourBuilder withAmount(int anAmountOfFriends){
		amount = anAmountOfFriends;
		return this;
	}
	
	public TourBuilder withFriends(ArrayList<User> aFriends){
		friends = aFriends;
		return this;
	}
	
	
	public TourBuilder withLimitAmount(int aLimitAmount){
		limitAmount = aLimitAmount;
		return this;
	}
	
	public TourBuilder withScheduler(DayMoment aDayMoment){
		scheduler = aDayMoment;
		return this;
	}
	
	public TourBuilder withDate(Date aDate){
		date = aDate;
		return this;
	}
	
	public TourBuilder withType(KindOfTour aType){
		type = aType;
		return this;
	}
}
