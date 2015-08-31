package SmartCalPackage;

public class MoneyImpl extends PaymentImplementor{

	@Override
	public double getChange(double totalAmount, double amtInserted) {
		this.change = amtInserted - totalAmount;
		return this.change;
	}

}
