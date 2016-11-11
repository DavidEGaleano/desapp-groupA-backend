package model;

import java.util.List;

public class Searcher {
	
	//private System system;
	private SearchMode search;
	
	public SearchMode getSearch() {
		return search;
	}

	public void setSearch(SearchMode search) {
		this.search = search;
	}
	public Searcher(){}

	public Searcher(System system, SearchMode search){
		//this.system = system;
		this.search = search;
	}
	
	//todos retornan void ya que falta la parte de persistencia.
	public List<Event> economicTour(int idUser){
		search.economicMode(idUser);
		return search.doSearch();
	}
	
	public void tourWithFriends(int idUser){
		search.withFriendMode(idUser);
		search.doSearch();
	}
	
	public void saturdayNightFever(int idUser){
		search.saturdayNightFeverMode(idUser);
		search.doSearch();
	}
	
	public void betterHalf(int idUser){
		search.betterHalfMode(idUser);
		search.doSearch();
	}
	
	public void surpriseMe(int idUser){
		search.surpriseMeMode(idUser);
		search.doSearch();
	}
}
