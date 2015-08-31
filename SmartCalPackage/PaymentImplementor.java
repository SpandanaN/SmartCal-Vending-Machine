package SmartCalPackage;

public abstract class PaymentImplementor {
	private Payment payment;
	protected double change;
	
	public abstract double getChange(double totalAmount, double amtInserted);
}
