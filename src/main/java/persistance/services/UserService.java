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
	public List<User> getUserWithEmail(String email){		
		return this.userrepository.obtainUserWithEmail(email);
	}
}
