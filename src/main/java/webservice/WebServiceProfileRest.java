package webservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import builders.ProfileBuilder;
import model.Profile;
import persistance.services.ProfileService;
import utils.ResponseGenerator;


@Path("/profile")
public class WebServiceProfileRest extends ResponseGenerator{

	private ProfileService profileService;
	

	public ProfileService getProfileService() {
		return profileService;
	}
	
	public void setProfileService(final ProfileService profileService) {
		this.profileService = profileService;
	}
	
	@POST
	@Path("/create")
	@Produces("application/json")
	public Response profileTest() {
		Profile profile = new ProfileBuilder().build();
		try {
			this.profileService.save(profile);
		}catch(Exception e){
			return responseBadRequest("{Error: Can't create a profile ,"
					+ "Status: FAIL}");
		}
		return responseOK("{Action:"+"Profile Created"+","
				+"ID:"+ profile.id+","
				+"Status"+": "+"OK"+"}");
	}
	
	@GET
	@Path("/profiles")
	@Produces("application/json")
	public List<Profile> profile() {
		return this.profileService.retriveAll();

	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces("application/json")
	public Response deleteProfile(@PathParam("id") final Integer id) {

		try {
			Profile profile = this.getProfileService().getById(id);
			this.profileService.delete(profile);
		} catch (Exception e) {
			return responseBadRequest("{Error: Can't delete profile or invalid ID,"
					+ "Status: FAIL}");
		}
		return responseOK("{Action:"+"Profile Deleted"+","
				+"ID:"+id+","
				+"Status"+": "+"OK"+"}");
	}
	
	@POST
	@Path("/update/limitamount/{profile_id}/{amount}")
	@Produces("application/json")
	public Response updateUserEmail(@PathParam("profile_id") final Integer id, @PathParam("amount") final Integer amount){
		try{
			Profile profile = this.getProfileService().getById(id);
			profile.setLimitAmount(amount);
			this.profileService.update(profile);
		}catch (Exception e){
			return responseBadRequest("{Error: Can't update profile or invalid ID,"
					+ "Status: FAIL}");
		}
		return responseOK("{Action:"+"profile limitAmount changed"+","
		+"ID:"+id+","
		+"Status"+": "+"OK"+"}");
	}
	
	@GET
	@Path("/getProfile/{id}")
	@Produces("application/json")
	public Profile getProfile(@PathParam("id") final Integer id) {
		return this.profileService.getById(id);
	}

}