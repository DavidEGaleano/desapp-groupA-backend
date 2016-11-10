package webservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import kind.Kind;
import model.Profile;
import persistance.services.ProfileService;


@Path("/profile")
public class WebServiceProfileRest {

	private ProfileService profileService;
	

	public ProfileService getProfileService() {
		return profileService;
	}
	
	public void setProfileService(final ProfileService profileService) {
		this.profileService = profileService;
	}

	
	@GET
	@Path("/profiletest")
	@Produces("application/json")
	public List<Profile> profileTest() {
		this.getProfileService().save(new Profile(Kind.ACTION, Kind.ELECTRONIC, Kind.FAST_FOOD, 1000));
		return this.profileService.retriveAll();
	}
	
	@GET
	@Path("/profiles")
	@Produces("application/json")
	public List<Profile> profile() {
		return this.getProfileService().retriveAll();

	}
	
	@DELETE
	@Path("/deleteprofile/{id}")
	@Produces("application/json")
	public String deleteProfile(@PathParam("id") final Integer id) {

		try {
			Profile toDelete = this.getProfileService().getById(id);
			this.getProfileService().delete(toDelete);
		} catch (Exception e) {
			return "Profile Id not found";
		}
		return "Profile Deleted";
	}
	
	@GET
	@Path("/getEvent/{id}")
	@Produces("application/json")
	public Profile getProfile(@PathParam("id") final Integer id) {
		return this.getProfileService().getById(id);
	}

}