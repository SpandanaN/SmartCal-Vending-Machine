package SmartCalPackage;

public class MonitoringSystem{
	
	private LoginStrategy strategy;
	
	public MonitoringSystem(LoginStrategy strategy){
		this.strategy = strategy;
	}
	
	public boolean authenticateLogin(String username, String password){
		return strategy.loginAuthentication(username, password);
	}
}
