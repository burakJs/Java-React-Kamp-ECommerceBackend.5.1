package ECommerceBackend.business.abstracts;

import java.util.List;

import ECommerceBackend.entites.concretes.User;

public interface UserService {
	boolean add(User user,List<User> userList);
}
