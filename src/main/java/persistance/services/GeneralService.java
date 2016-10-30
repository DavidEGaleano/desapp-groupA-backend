package persistance.services;

public class GeneralService {

	private ProfileService profileService;
	private UserService userService;
	private EventService eventService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(final UserService userService) {
		this.userService = userService;
	}

	public EventService getEventService() {
		return eventService;
	}

	public void setEventService(final EventService eventService) {
		this.eventService = eventService;
	}

	public ProfileService getProfileService() {
		return profileService;
	}

	public void setProfileService(final ProfileService profileService) {
		this.profileService = profileService;
	}
	
}
