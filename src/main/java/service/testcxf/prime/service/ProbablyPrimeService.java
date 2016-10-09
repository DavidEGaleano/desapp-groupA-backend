package service.testcxf.prime.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

import kind.Kind;
import model.LogSystem;
import model.Profile;
import model.User;

@Service("probablyPrimeService")
@Path("/prime")
public class ProbablyPrimeService {

	@GET
	@Path("/{number}")
	@Produces("text/plain")
	public boolean isPrime(@PathParam("number") int number){
		return true;
	}
	
	@GET
	@Path("/profile/{name}")
	@Produces("application/json")
	public Profile getProfile(@PathParam("name") String name){
		Profile profile = new Profile(Kind.ACTION,Kind.ROCK, Kind.FAST_FOOD, 1000);
		return profile;
	}
}
