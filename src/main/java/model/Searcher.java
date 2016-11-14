package model;

import java.util.List;

public class Searcher {
	
	private SearchMode search;
	
	public SearchMode getSearch() {
		return search;
	}

	public void setSearch(SearchMode search) {
		this.search = search;
	}
	
	public Searcher(){}

	public Searcher(SearchMode search){
		this.search = search;
	}
	
	
	public List<Event> economicTour(int idUser){
		search.economicMode(idUser);
		return search.doSearch();
	}
	
	public List<Event> tourWithFriends(int idUser){
		search.withFriendMode(idUser);
		return search.doSearch();
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
