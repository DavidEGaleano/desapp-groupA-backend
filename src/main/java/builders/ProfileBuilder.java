package builders;

import kind.Kind;
import model.Profile;

public class ProfileBuilder {
	
	public Kind typeOfFilm = Kind.ACTION;
	public Kind typeOfMusic= Kind.ROCK;
	public Kind typeOfFood = Kind.SUSHI;
	public int limitAmount = 1200;
	public int limitPeople = 10;
	
	public static ProfileBuilder anEvent(){
		return new ProfileBuilder();
	}
	
	public Profile build(){
		Profile profile = new Profile(typeOfFilm,typeOfMusic,typeOfFood,limitAmount,limitPeople);
		return profile;
	}
	
	public ProfileBuilder withTypeOfFilm(Kind pKind){
		typeOfFilm = pKind;
		return this;
	}
	
	public ProfileBuilder withTypeOfMusic(Kind pKind){
		typeOfMusic = pKind;
		return this;
	}
	
	public ProfileBuilder withTypeOfFood(Kind pKind){
		typeOfFood = pKind;
		return this;
	}
	
	public ProfileBuilder withLimitAmount(int amount){
		limitAmount = amount;
		return this;
	}
	
	public ProfileBuilder withLimitPeople(int amount){
		limitPeople = amount;
		return this;
	}
	
	
	
	
}
