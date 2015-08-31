package SmartCalPackage;

import java.io.Serializable;

public class SmartCalCard50 extends SmartCalCard implements Serializable{
	public SmartCalCard50(int id){
		super(id);
		this.value = 50.00;
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
