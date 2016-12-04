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

import builders.UserBuilder;
import dto.UserDTO;
import model.User;
import persistance.services.UserService;
import utils.ResponseGenerator;


@Path("/user")
public class UserRest extends ResponseGenerator{
	
	private UserService userService;
	

	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(final UserService profileService) {
		this.userService = profileService;
	}

	
	@POST
	@Path("setUser/{name}/{email}")
	@Produces("application/json")
	public Response addorupdateuser(@PathParam("name") final String name,@PathParam("email") final String email) {
		try {
		User user;
		List<User> list = userService.getUserWithEmail(email);
		if(list.size()==0){
			 user = new UserBuilder().withUserName(name).withMail(email).build();
			this.userService.save(user);
		}else{
			 user = list.get(0);
			 this.userService.update(user);

		}
		return responseOK("{ \"Action\":\"User added\","
				+"\"ID\": "+ user.id +","
				+"\"Status\":\"ok\"}");
			
		}catch(Exception e){
			return responseBadRequest("{ \"Error\":\"Can't update event or invalid ID\","
					+"\"Status\":\"FAIL\"}");
		}
		

		
	}
	
	@GET
	@Path("/getUserWithEmail/{email}")
	@Produces("application/json")
	public User getUser(@PathParam("email") final String email) {
		try{
			return  this.userService.getUserWithEmail(email).get(0);
		}catch (Exception e) {
			return null;
		}
	}
	
	@GET
	@Path("/users")
	@Produces("application/json")
	public List<User> users() {
		return this.userService.retriveAll();

	}
	
	@DELETE
	@Path("/delete/{id}")
	@Produces("application/json")
	public Response deleteProfile(@PathParam("id") final Integer id) {		
		try {
			User user = this.userService.getById(id);
			this.userService.delete(user);
		} catch (Exception e) {
			return responseBadRequest("{Error: Can't delete user or invalid ID,"
					    		+ "Status: FAIL}");
		}
		
		return responseOK("{Action:"+"User Deleted"+","
							+"ID:"+id+","
							+"Status"+": "+"OK"+"}");
	}
	
	@POST
	@Path("/updateUser/{user_id}/{username}")
	@Produces("application/json")
	public Response updateUser(@PathParam("user_id") final Integer id, @PathParam("username") final String name,@PathParam("email") final String mail){
		try{
			User user = this.userService.getById(id);
			user.setUserName(name);
			this.userService.update(user);
		}catch (Exception e){
			return responseBadRequest("{ \"Error\":\"Can't update event or invalid ID\","
					+"\"Status\":\"FAIL\"}");
		}
		return responseOK("{ \"Action\":\"User updated\","
				+"\"ID\": "+ id +","
				+"\"Status\":\"ok\"}");
	}	
	
	@GET
	@Path("/getFriends/{id}")
	@Produces("application/json")
	public List<UserDTO> userFriends(@PathParam("id") final Integer id) {
		return new UserDTO().copyDataFromUsers((this.userService.getById(id).friends));		
	}
	
	
	@GET
	@Path("/getUser/{id}")
	@Produces("application/json")
	public UserDTO getProfile(@PathParam("id") final Integer id) {
		return new UserDTO().copyDataFromUser(this.userService.getById(id));
	}
	
	
}
