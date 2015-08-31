package SmartCalPackage;

public class CardImpl extends PaymentImplementor{
	int cardId;

	public void setCardId(int id){
		this.cardId = id;
	}
	
	@Override
	public double getChange(double totalAmount, double amtInserted) {
		//Fetch the card information while calling this method 
		//calculate the balance and return the card balance
		this.change = amtInserted - totalAmount;
		return this.change;
	}

}
