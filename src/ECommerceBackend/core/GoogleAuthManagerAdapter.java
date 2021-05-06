package ECommerceBackend.core;

import ECommerceBackend.googleAuth.GoogleAuthManager;

public class GoogleAuthManagerAdapter implements AuthService{

	@Override
	public void addUserAuth(String message) {
		GoogleAuthManager googleAuthManager = new GoogleAuthManager();
		googleAuthManager.addUser(message);
		
	}

}
