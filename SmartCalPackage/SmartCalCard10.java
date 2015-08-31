package SmartCalPackage;

import java.io.Serializable;

public class SmartCalCard10 extends SmartCalCard implements Serializable{
	public SmartCalCard10(int id){
		super(id);
		this.value = 10.00;
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
