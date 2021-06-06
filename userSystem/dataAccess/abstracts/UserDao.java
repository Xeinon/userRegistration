package userSystem.dataAccess.abstracts;

import java.util.List;

import userSystem.entities.concretes.User;



public interface UserDao {
	void add(User user);
	void delete(User user);
	void update(User user);
	User get(int id);
	User getByEmail(String email);
	List<User> getAll();
}
