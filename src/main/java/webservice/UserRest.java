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

	
	@GET
	@Path("setUser/{name}/{email}/{token}")
	@Produces("application/json")
	public Response addorupdateuser(@PathParam("name") final String name,@PathParam("email") final String email,@PathParam("token") final String token) {
		try {
		User user;
		if(!userService.hasUserWithEmail(email)){
			 user = new UserBuilder().withUserName(name).withMail(email).build();
			this.userService.save(user);
		}else{
			 user = userService.getUserWithEmail(email);
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
	@Path("/update/{jsonuser}")
	@Consumes("application/json")
	public Response updateUser(@PathParam("jsonuser") UserDTO user){
		try {
			User bduser = this.userService.getById(user.id);
			bduser.userName = user.userName;
			bduser.mail = user.mail;
			this.userService.update(bduser);
		} catch (Exception e) {
			return responseBadRequest("{ \"Error\":\"Can't update event or invalid ID\","
					+"\"Status\":\"FAIL\"}");

		}
		return responseOK("{ \"Action\":\"User updated\","
				+"\"ID\": "+ user.id +","
				+"\"Status\":\"ok\"}");
	}
	
	@GET
	@Path("/getUserWithEmail/{email}")
	@Produces("application/json")
	public User getUser(@PathParam("email") final String email) {
		
		return this.userService.getUserWithEmail(email);

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
	@Path("/updateUser/{user_id}/{username}/{email}")
	@Produces("application/json")
	public Response updateUserPassword(@PathParam("user_id") final Integer id, @PathParam("username") final String name,@PathParam("email") final String mail){
		try{
			User user = this.userService.getById(id);
			user.setUserName(name);
			user.setMail(mail);
			this.userService.update(user);
		}catch (Exception e){
			return responseBadRequest("{ \"Error\":\"Can't update event or invalid ID\","
					+"\"Status\":\"FAIL\"}");
		}
		return responseOK("{ \"Action\":\"User updated\","
				+"\"ID\": "+ id +","
				+"\"Status\":\"ok\"}");
	}
	
	
	@POST
	@Path("/update/email/{user_id}/{email}")
	@Produces("application/json")
	public Response updateUserEmail(@PathParam("user_id") final Integer id, @PathParam("email") final String email){
		try{
			User user = this.getUserService().getById(id);
			user.setMail(email);
			this.userService.update(user);
		}catch (Exception e){
			return responseBadRequest("{Error: Can't update user email or invalid ID,"
									  + "Status: FAIL}");
		}
		return responseOK("{Action:"+"User email updated"+","
							+"ID:"+id+","
							+"Status"+": "+"OK"+"}");
	}
	
	
	@PUT
	@Path("/update/username/{user_id}/{name}")
	@Produces("application/json")
	public Response updateUsername(@PathParam("user_id") final Integer id, @PathParam("name") final String name){
		try{
			User user = this.getUserService().getById(id);
			user.setMail(name);
			this.userService.update(user);
		}catch (Exception e){
			return responseBadRequest("{Error: Can't update user email or invalid ID,"
									  + "Status: FAIL}");
		}
		return responseOK("{Action:"+"User email updated"+","
							+"ID:"+id+","
							+"Status"+": "+"OK"+"}");
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
