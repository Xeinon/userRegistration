package userSystem.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import userSystem.dataAccess.abstracts.UserDao;
import userSystem.entities.concretes.User;

public class HUserDao implements UserDao{

	List<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Kullanýcý eklendi :" + user.getFirstName() +" "+ user.getLastName());
		
	}

	@Override
	public void delete(User user) {
		User userDelete = null;
		for(User s : users) 
		{
			if(user.getId() == s.getId()) 
			{
				userDelete = s;
			}
		}
		users.remove(userDelete);
		
	}

	@Override
	public void update(User user) {
		System.out.println("Kullanýcý güncellendi : " + user.getFirstName() + " " + user.getEmail());
		
	}

	@Override
	public User get(int id) {
		for(User user : users) {
			if(user.getId() == id ) {
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public User getByEmail(String email) {
		for(User user : users) {
			if(user.getEmail() == email)
				return user;
		}
		return null;
	}

}
