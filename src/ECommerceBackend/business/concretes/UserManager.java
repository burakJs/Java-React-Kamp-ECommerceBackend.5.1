package ECommerceBackend.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ECommerceBackend.business.abstracts.UserService;
import ECommerceBackend.core.AuthService;
import ECommerceBackend.dataAccess.abstracts.UserDao;
import ECommerceBackend.entites.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private AuthService authService;
	
	public UserManager(UserDao userDao, AuthService authService) {
		super();
		this.userDao = userDao;
		this.authService = authService;
	}

	@Override
	public boolean add(User user,List<User> userList) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern  = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.geteMail());
		
		if(user.getPassword().length() >= 6 && matcher.matches() && 
				user.getFirstName().length() >= 2 && user.getLastName().length()>=2) {
			for (User tempUser : userList) {
				if(user.geteMail() == tempUser.geteMail()) {
					System.out.println("Böyle bir email önceden kullanılmış...");
					return false;
				}
			}
			userDao.add(user);
			authService.addUserAuth(user.geteMail());
			return true;
		}
		else {
			System.out.println("Girdiğiniz bilgileri kontrol ediniz...");
			return false;
		}
	}

}

//Yaz. Müh. demeseydik ne olurdun