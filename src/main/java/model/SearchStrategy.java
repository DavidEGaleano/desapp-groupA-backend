package model;

import java.util.ArrayList;

import kind.Kind;

public abstract class SearchStrategy {
	
	protected User user;
	protected Kind typeMusic;
	protected Kind typeFilm;
	protected Kind typeFood;
	
	public SearchStrategy(User user){
		this.user = user;
	}
	
	public abstract ArrayList<Event> search();
	
	protected void setKindTypes(User user){
		this.typeMusic = user.getProfile().getTypeOfMusic();
		this.typeFilm = user.getProfile().getTypeOfFilm();
		this.typeFood = user.getProfile().getTypeOfFood();
	}
	
}
