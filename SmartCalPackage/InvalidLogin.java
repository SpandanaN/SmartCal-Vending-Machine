package SmartCalPackage;

public class InvalidLogin implements LoginStrategy{

	@Override
	public boolean loginAuthentication(String username, String password) {
		//does nothing
		return false;
	}

}
