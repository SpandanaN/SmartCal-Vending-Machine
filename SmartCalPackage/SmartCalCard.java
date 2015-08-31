package SmartCalPackage;

import java.io.Serializable;

public abstract class SmartCalCard implements Serializable{
	int id;
	double value;
	
	public SmartCalCard(int id) {
		this.id = id;
	}
	
	public int getCardId(){
		return this.id;
	}
	
	abstract void setBalance(double amount);
	abstract double getBalance();
}
