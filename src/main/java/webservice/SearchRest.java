package webservice;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.Event;
import model.Searcher;
import utils.ResponseGenerator;

@Path("/search")
public class SearchRest extends ResponseGenerator{
	
	public Searcher searcher;


	public Searcher getSearcher() {
		return searcher;
	}


	public void setSearcher(Searcher searcher) {
		this.searcher = searcher;
	}


	@GET
	@Path("/economic/{id_user}")
	@Produces("application/json")
	public List<Event> searchEconomic(@PathParam("id_user") final Integer id_user) {
		
		List<Event> list = new ArrayList<Event>();
		
		try {
			list = this.searcher.economicTour(id_user);
			return list;
		} catch (Exception e) {
			return list;
		}
	}
	
	
	@GET
	@Path("/withLimitOfPersons/{id_user}/{limit}")
	@Produces("application/json")
	public List<Event> withLimitOfPersons(@PathParam("id_user") final Integer id_user,@PathParam("limit") final Integer limit) {
		
		List<Event> list = new ArrayList<Event>();
		
		try {
			list = this.searcher.forLimitOfPersons(id_user, limit);
			return list;
		} catch (Exception e) {
			return list;
		}
		
	}

}
