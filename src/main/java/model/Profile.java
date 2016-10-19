package model;

import kind.Kind;

public class Profile {
	
	public Kind typeOfFilm;
	public Kind typeOfMusic;
	public Kind typeOfFood;
	public int limitAmount;
	public int id;
	
	public Profile(){
		
	}
	
	public Profile(Kind typeOfFilm, Kind typeOfMusic, Kind typeOfFood, int limitAmount){
		this.typeOfFilm = typeOfFilm;
		this.typeOfMusic = typeOfMusic;
		this.typeOfFood = typeOfFood;
		this.limitAmount = limitAmount;
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
}