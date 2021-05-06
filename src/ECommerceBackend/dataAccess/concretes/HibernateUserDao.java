package ECommerceBackend.dataAccess.concretes;

import ECommerceBackend.dataAccess.abstracts.UserDao;
import ECommerceBackend.entites.concretes.User;

public class HibernateUserDao implements UserDao{

	@Override
	public void add(User user) {
		System.out.println("User eklendi : " + user.getFirstName());
		System.out.println(user.geteMail() + " doğrulama epostası gönderildi");
		System.out.println("Üyelik tamamlandı...");
	}

}
