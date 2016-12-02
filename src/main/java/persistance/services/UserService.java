package persistance.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import model.User;
import persistance.repositories.UserRepository;

public class UserService extends GenericService<User>{
	private static final long serialVersionUID = -2932116622242535844L;
	
	UserRepository userrepository;

	public UserRepository getUserrepository() {
		return userrepository;
	}

	public void setUserrepository(UserRepository userrepository) {
		this.userrepository = userrepository;
	}
	
	@Transactional
	public boolean hasUserWithEmail(String email){		
		List<User> users= this.userrepository.obtainUserWithEmail(email);
		return (users.size() > 0);
	}
	
	@Transactional
	public User getUserWithEmail(String email){		
		return this.userrepository.obtainUserWithEmail(email).get(0);
	}
	
	
	@Transactional
	public Boolean hasUserWithToken(String token){		
		return this.userrepository.obtainUserWithToken(token).size() > 0;
	}
	
	@Transactional
	public User getUserWithToken(String token){		
		return this.userrepository.obtainUserWithToken(token).get(0);
	}
}
