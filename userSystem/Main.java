package userSystem;

import java.util.List;

import userSystem.business.abstracts.UserService;
import userSystem.business.concretes.UserManager;
import userSystem.core.concretes.GoogleManagerAdapter;
import userSystem.dataAccess.concretes.HUserDao;
import userSystem.entities.concretes.User;



public class Main {

	public static void main(String[] args) {
		
		UserManager userManager = new UserManager(new GoogleManagerAdapter(),new HUserDao());

			
		User user1=new User(1,"Adý","Soyadý","adsoyad@gmail.com","1234567");
		User user2=new User(2,"Ýsim","Soyisim","isimsoyisim@gmail.com","1234567");			
		
		userManager.add(user1);
		userManager.add(user2);

	}

}
