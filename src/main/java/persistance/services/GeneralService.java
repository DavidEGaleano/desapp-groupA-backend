package persistance.services;

public class GeneralService {

	private ProfileService profileService;
	
	//private PersonService personService;

	public ProfileService getProfileService() {
		return profileService;
	}

	/*public PersonService getPersonService() {
		return personService;
	}*/

	public void setProfileService(final ProfileService profileService) {
		this.profileService = profileService;
	}

/*	public void setPersonService(final PersonService personService) {
		this.personService = personService;
	}*/

}
