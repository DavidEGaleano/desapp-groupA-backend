package webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import builders.ProfileBuilder;
import kind.Kind;
import model.Profile;
import persistance.services.ProfileService;
import utils.ResponseGenerator;


@Path("/profile")
public class ProfileRest extends ResponseGenerator{

	private ProfileService profileService;
	

	public ProfileService getProfileService() {
		return profileService;
	}
	
	public void setProfileService(final ProfileService profileService) {
		this.profileService = profileService;
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
	@Path("/update/{profile_id}/{amount}/{music}/{food}/{film}/{limitpeople}")
	@Produces("application/json")
	public Response updateprofile(@PathParam("profile_id") final Integer id, @PathParam("amount") final Integer amount,@PathParam("music") final Kind music,
			@PathParam("food") final Kind food, @PathParam("film") final Kind film, @PathParam("limitpeople") final int limitpeople){
		try{
			Profile profile = this.profileService.getById(id);
			profile.setLimitAmount(amount);
			profile.typeOfFilm = film;
			profile.typeOfFood = food;
			profile.typeOfMusic = music;
			profile.limitPeople = limitpeople;
			this.profileService.update(profile);
		}catch (Exception e){
			return responseBadRequest("{ \"Error\":\"Can't update Profile or invalid ID\","
					+"\"Status\":\"FAIL\"}");
		}
		return responseOK("{ \"Action\":\"Profile updated\","
				+"\"ID\": "+ id +","
				+"\"Status\":\"ok\"}");
	}
	
	@POST
	@Path("/update/{profile_id}/{json}")
	@Consumes("application/json")
	public Response updateprofilejson(@PathParam("json") final Profile profile){
		try{
			this.profileService.update(profile);
		}catch (Exception e){
			return responseBadRequest("{ \"Error\":\"Can't update Profile or invalid ID\","
					+"\"Status\":\"FAIL\"}");
		}
		return responseOK("{ \"Action\":\"Profile updated\","
				+"\"ID\": "+ profile.id +","
				+"\"Status\":\"ok\"}");
	}
	
	@GET
	@Path("/getProfile/{id}")
	@Produces("application/json")
	public Profile getProfile(@PathParam("id") final Integer id) {
		return this.profileService.getById(id);
	}

}