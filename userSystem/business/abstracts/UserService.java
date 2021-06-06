package userSystem.business.abstracts;

import userSystem.entities.concretes.User;

public interface UserService {
	void add(User user);
	void logIn(String email, String password);
	
	
	
}
