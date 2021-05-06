package ECommerceBackend;

import java.util.ArrayList;
import ECommerceBackend.business.abstracts.UserService;
import ECommerceBackend.business.concretes.UserManager;
import ECommerceBackend.core.GoogleAuthManagerAdapter;
import ECommerceBackend.dataAccess.concretes.HibernateUserDao;
import ECommerceBackend.entites.concretes.User;

public class Main {

	public static void main(String[] args) {
		ArrayList<User> userList = new ArrayList<User>();
		UserService userService = new UserManager(new HibernateUserDao(), new GoogleAuthManagerAdapter());
		
		User burak = new User("Burak","İmdat","burak@gmail.com","123456789");//OK
		User burak2 = new User("Burak","İmdat","burak#gmail.com","123456789");//Kontrol et
		User burak3 = new User("Burak","İmdat","burak@gmail.com","123456789");//Email kullanılmış
		User burak4 = new User("Burak","İmdat","burak4@gmail.com","123");//Kontrol et
		
		if(userService.add(burak, userList)) {
			userList.add(burak);
		}
		System.out.println();
		if(userService.add(burak2, userList)) {
			userList.add(burak2);
		}
		System.out.println();
		if(userService.add(burak3, userList)) {
			userList.add(burak3);
		}
		System.out.println();
		if(userService.add(burak4, userList)) {
			userList.add(burak4);
		}
	}

}
