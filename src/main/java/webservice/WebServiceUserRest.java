package webservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import builders.UserBuilder;
import model.User;
import persistance.services.UserService;


@Path("/user")
public class WebServiceUserRest {
	
	private UserService userService;
	

	public UserService getUserService() {
		return userService;
	}
	
	public void setUserService(final UserService profileService) {
		this.userService = profileService;
	}

	
	@GET
	@Path("/create")
	@Produces("application/json")
	public String profileTest() {
		User user = new UserBuilder().build();
		try {
			this.getUserService().save(user);
		}catch(Exception e){
			return "{Error: Can't create a user ,"
					+ "Status: FAIL}";
		}
		return "{Action:"+"User Created"+","
				+"ID:"+ user.id+","
				+"Status"+": "+"OK"+"}";
	}
	
	@GET
	@Path("/users")
	@Produces("application/json")
	public List<User> users() {
		return this.getUserService().retriveAll();

	}
	
	@GET
	@Path("/delete/{id}")
	@Produces("application/json")
	public String deleteProfile(@PathParam("id") final Integer id) {

		try {
			User toDelete = this.getUserService().getById(id);
			this.getUserService().delete(toDelete);
		} catch (Exception e) {
			return "{Error: Can't delete user or invalid ID,"
					+ "Status: FAIL}";
		}
		return "{Action:"+"User Deleted"+","
				+"ID:"+id+","
				+"Status"+": "+"OK"+"}";
	}
	
	@GET
	@Path("/getUser/{id}")
	@Produces("application/json")
	public User getProfile(@PathParam("id") final Integer id) {
		return this.getUserService().getById(id);
	}
}
