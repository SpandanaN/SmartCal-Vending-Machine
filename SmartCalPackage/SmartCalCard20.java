package SmartCalPackage;

import java.io.Serializable;

public class SmartCalCard20 extends SmartCalCard implements Serializable{
	public SmartCalCard20(int id){
		super(id);
		this.value = 20.00;
	}

	@Override
	void setBalance(double amount) {
		this.value = this.value - amount;
	}

	@Override
	double getBalance() {
		return this.value;
	}
}
