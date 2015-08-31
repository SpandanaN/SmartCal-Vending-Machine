package SmartCalPackage;

public class SuccessfulLogin implements LoginStrategy{

	@Override
	public boolean loginAuthentication(String username, String password) {
		if(username.equals(Database.getAdminUsername()) && password.equals(Database.getAdminPassword())){
			return true;
		}
		else{
			return false;
		}
	}

}
