package builders;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import kind.DayMoment;
import kind.Kind;
import model.Event;

public class EventBuilder {
	
	private List<Kind> types = new ArrayList<Kind>();
	private Date date = createDate();
	private DayMoment scheduler = DayMoment.NIGHT;
	private String address = "an address";
	private int amount = 1000;
	private int limitOfPersons = 3;
	private double lat = 0;
	private double lng = 0;
	private String name = "Ejemplo";
	private List<Event> suggestions = new ArrayList<Event>();
	
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
		Event event = new Event(types, date, scheduler, address, amount, limitOfPersons, lat,lng,name);
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
	
	public EventBuilder withSuggestion(List<Event> anSuggestions){
		suggestions = anSuggestions;
		return this;
	}
	
	public EventBuilder withLat(double plat){
		lat = plat;
		return this;
	}
	
	public EventBuilder withLng(double plng){
		lng = plng;
		return this;
	}
	
	public EventBuilder withName(String pname){
		name = pname;
		return this;
	}
	
	public ArrayList<Event> fromJson(String route) throws IOException, ParseException{
		JSONParser parser = new JSONParser();
		ArrayList<Event> events = new ArrayList<Event>();
		try {
			
            Object obj = parser.parse(new FileReader(route));
            JSONArray jsonObjects = (JSONArray) obj;
            Object[] jsons = jsonObjects.toArray();
            
            for(int i = 0; i<jsons.length; i++){            	
            	JSONObject jsonval = (JSONObject) jsons[i];
            	String longitud = (String) jsonval.get("X");
            	String latitud = (String) jsonval.get("Y");
            	String name = (String) jsonval.get("NOMBRE");
            	String address = (String) jsonval.get("DIRECCION");
            	long capacity = (long) jsonval.get("CAPACIDAD");
            	long amount = (long) jsonval.get("AMOUNT");
            	double lat = Double.parseDouble(longitud.replace(",","."));
            	double lng = Double.parseDouble(latitud.replace(",","."));            
                events.add(new EventBuilder().withAddress(address).withAmount((int) amount).withLat(lat).withLng(lng).withLimitOfPersons((int)capacity).withName(name).build());
            }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
		 return events;
	}
	
	
}
