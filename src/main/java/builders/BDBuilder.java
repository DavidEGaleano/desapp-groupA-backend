package builders;

import javax.annotation.PostConstruct;

import kind.DayMoment;
import kind.Kind;
import model.Event;
import model.User;
import persistance.services.EventService;
import persistance.services.UserService;

public class BDBuilder {
	
	EventService eventservice;
	UserService userservive;
	
	public EventService getEventservice() {
		return eventservice;
	}

	public void setEventservice(EventService eventservice) {
		this.eventservice = eventservice;
	}

	public UserService getUserservive() {
		return userservive;
	}

	public void setUserservive(UserService userservive) {
		this.userservive = userservive;
	}

	@PostConstruct
	public void createEntities(){

		User user1 = new UserBuilder()
					.withUserName("UserTestOne")
					.withMail("UTO@test.com")
					.withPassword("UTOpass")
					.withProfile(new ProfileBuilder().withLimitAmount(500).build())
					.build();
		User user2 = new UserBuilder()
					.withUserName("UserTestTwo")
					.withMail("UTTw@test.com")
					.withPassword("UTTpass")
					.build();
		User user3 = new UserBuilder()
					.withUserName("UserTestThree")
					.withMail("UTTh@test.com")
					.withPassword("UTThpass")
					.withProfile(new ProfileBuilder().withLimitAmount(2000).build())
					.build();
		
		user2.addFriend(user1);
		
		Event event1 = new EventBuilder()
					  .withAddress("Address I test")
					  .withAmount(1000)
					  .withLimitOfPersons(80)
					  .withScheduler(DayMoment.AFTERNOON)
					  .build();
		
		event1.addType(Kind.ACTION);
		event1.addType(Kind.FAST_FOOD);
		Event event2 = new EventBuilder()
				      .withAddress("Address II test")
				      .withAmount(2000)
				      .withLimitOfPersons(40)
				      .withScheduler(DayMoment.NIGHT)
				      .build();
		event2.addType(Kind.ELECTRONIC);
		event2.addType(Kind.PIZZA);
		
		Event event3 = new EventBuilder()
				      .withAddress("Address III test")
				      .withAmount(3000)
				      .withLimitOfPersons(50)
				      .withScheduler(DayMoment.NIGHT)
				      .build();
		event3.addType(Kind.GRILL);
		event3.addType(Kind.PASTA);
		
		
		
		this.eventservice.save(event1);
		this.eventservice.save(event2);
		this.eventservice.save(event3);
		
		this.userservive.save(user1);
		this.userservive.save(user2);
		this.userservive.save(user3);
		
	}
}
