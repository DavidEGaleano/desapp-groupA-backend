package model;

public class SearchMode {

	protected SearchStrategy mode;
	
	public void economicMode(User user) {
		this.mode = new EconomicSearch(user);
	}

	public void withFriendMode(User user) {
		this.mode = new WithFriendSearch(user);	
	}

	public void saturdayNightFeverMode(User user) {
		this.mode = new SaturdayNightFeverSearch(user);		
	}

	public void betterHalfMode(User user) {
		this.mode = new BetterHalfSearch(user);
	}

	public void surpriseMeMode(User user) {
		this.mode = new SurpriseMeSearch(user);
	}
	
	public void doSearch(){
		mode.search();
	}

}
