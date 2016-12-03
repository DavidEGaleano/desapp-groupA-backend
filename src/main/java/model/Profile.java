package model;

import kind.Kind;

public class Profile {
	
	public Kind typeOfFilm;
	public Kind typeOfMusic;
	public Kind typeOfFood;
	public int limitAmount;
	public int limitPeople;
	public int id;
	
	public Profile(){
		
	}
	
	public Profile(Kind typeOfFilm, Kind typeOfMusic, Kind typeOfFood, int limitAmount, int limitPeople){
		this.typeOfFilm = typeOfFilm;
		this.typeOfMusic = typeOfMusic;
		this.typeOfFood = typeOfFood;
		this.limitAmount = limitAmount;
		this.limitPeople = limitPeople;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Kind getTypeOfFilm() {
		return typeOfFilm;
	}

	public Kind getTypeOfMusic() {
		return typeOfMusic;
	}

	public Kind getTypeOfFood() {
		return typeOfFood;
	}
	
	public int getLimitAmount(){
		return limitAmount;
	}
	
	public void setLimitAmount(int limit){
		this.limitAmount = limit;
	}
}