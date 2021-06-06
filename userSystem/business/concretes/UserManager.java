package userSystem.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import userSystem.business.abstracts.UserService;
import userSystem.core.abstracts.AuthorizationService;
import userSystem.dataAccess.abstracts.UserDao;
import userSystem.entities.concretes.User;

public class UserManager implements UserService {

	private AuthorizationService authorizationService;
	private UserDao userDao;
	
	private List<String> emailList = new ArrayList<String>();
	private List<String> passwordList = new ArrayList<String>();
	
	public UserManager(AuthorizationService authorizationService, UserDao userDao) {
		super();
		this.authorizationService = authorizationService;
		this.userDao = userDao;
	}

	
	public static boolean emailValidate(String email) {
		String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
		
		} 
	
	public static boolean EmailValidation(String email) {
		return true;
	}
	
	@Override
	public void add(User user) {
		if(user.getFirstName().length()<=2 || user.getLastName().length()<=2) {
			System.out.println("Ýsim ve soyisim en az 2 karakterli girilmeli!");
			return;
		}
		
		if(user.getPassword().length()<6){
			System.out.println("Parola 6 karakterden az olamaz!");
			return;
		}
		if(user.getPassword() == null) {
			System.out.println("Bir parola giriniz.");
			return;}
				
		
		if (emailList.contains(user.getEmail())){
            System.out.println("E-posta adresi mevcut, baþka bir adres giriniz.");
            return;
        }
		
		if (emailValidate(user.getEmail())){
            emailList.add(user.getEmail());
            passwordList.add(user.getPassword());
            this.userDao.add(user);
            this.authorizationService.registerToSystem("kayýt olundu : " + user.getFirstName() + " " + user.getLastName());
		}
		else {System.out.println("Geçerli bir E-mail adresi giriniz!");}
	}


	@Override
	public void logIn(String email, String password) {
		if(emailList.contains(email) && passwordList.contains(password)) {
			System.out.println("Giriþ baþarýlý.");
		}
		else {
			System.out.println("E-mail veya parolanýzý yanlýþ girdiniz! ");
		}
	}


		
}
