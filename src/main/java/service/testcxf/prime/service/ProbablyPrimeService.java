package service.testcxf.prime.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Service;

@Service("probablyPrimeService")
@Path("/prime")
public class ProbablyPrimeService {
	
	@GET
	@Path("/{number}")
	@Produces("text/plain")
	public boolean isPrime(@PathParam("number") int number){
		return true;
	}
}
