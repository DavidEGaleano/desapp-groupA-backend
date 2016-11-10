package webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import builders.ProfileBuilder;
import model.Profile;
import persistance.services.ProfileService;



public class WebServiceProfileRest {

	private ProfileService profileService;
	

	public ProfileService getProfileService() {
		return profileService;
	}
	
	public void setProfileService(final ProfileService profileService) {
		this.profileService = profileService;
	}

	
	@GET
	@Path("/create")
	@Produces("application/json")
	public String profileTest() {
		Profile profile = new ProfileBuilder().build();
		try {
			this.getProfileService().save(profile);
		}catch(Exception e){
			return "{Error: Can't create a profile ,"
					+ "Status: FAIL}";
		}
		return "{Action:"+"Profile Created"+","
				+"ID:"+ profile.id+","
				+"Status"+": "+"OK"+"}";
	}
	
	@GET
	@Path("/profiles")
	@Produces("application/json")
	public List<Profile> profile() {
		return this.getProfileService().retriveAll();

	}
	
	@GET
	@Path("/delete/{id}")
	@Produces("application/json")
	public String deleteProfile(@PathParam("id") final Integer id) {

		try {
			Profile toDelete = this.getProfileService().getById(id);
			this.getProfileService().delete(toDelete);
		} catch (Exception e) {
			return "{Error: Can't delete profile or invalid ID,"
					+ "Status: FAIL}";
		}
		return "{Action:"+"Profile Deleted"+","
				+"ID:"+id+","
				+"Status"+": "+"OK"+"}";
	}
	
	@GET
	@Path("/getProfile/{id}")
	@Produces("application/json")
	public Profile getProfile(@PathParam("id") final Integer id) {
		return this.getProfileService().getById(id);
	}

}