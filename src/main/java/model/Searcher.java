package model;

public class Searcher {
	
	private System system;
	private SearchMode search;
	
	public Searcher(System system, SearchMode search){
		this.system = system;
		this.search = search;
	}
	
	//todos retornan void ya que falta la parte de persistencia.
	public void economicTour(String userName){
		search.economicMode(this.system.obtainUser(userName));
		search.doSearch();
	}
	
	public void tourWithFriends(String userName){
		search.withFriendMode(this.system.obtainUser(userName));
		search.doSearch();
	}
	
	public void saturdayNightFever(String userName){
		search.saturdayNightFeverMode(this.system.obtainUser(userName));
		search.doSearch();
	}
	
	public void betterHalf(String userName){
		search.betterHalfMode(this.system.obtainUser(userName));
		search.doSearch();
	}
	
	public void surpriseMe(String userName){
		search.surpriseMeMode(this.system.obtainUser(userName));
		search.doSearch();
	}
}
