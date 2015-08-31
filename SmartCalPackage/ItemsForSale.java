package SmartCalPackage;

import java.awt.Image;
import java.io.Serializable;

public abstract class ItemsForSale implements Serializable{
	
	String name;
	 double cost;
	//String nutritionalInfo;
	int calories;
	int sugarlevel;
	public void setCost(double cost) {
		this.cost=cost;
	}

	public  void setCalories(int calories){
		this.calories=calories;
	}
	public  void setSugar(int sugarlevel){
		this.sugarlevel=sugarlevel;
	}
	
	/**public void setNutritionalInfo(String info) {
	nutritionalInfo=info;
	}*/
	public  void setName(String name) {
		this.name=name;
	}
	public  double getCost() {
		return this.cost;
	}
	public  String getItemName() {
		return this.name;
	}
	/**public String getInfo() {
		return this.nutritionalInfo;
	}**/
	public  int getCalories(){
		return this.calories;
	}
	public  int getSugarLevels(){
		return this.sugarlevel;
	}
	public void displayDetails() {
		System.out.println("The selected item is "+name.toUpperCase());
		System.out.println("Cost of "+name+" is "+cost);
		//System.out.println("Nutitional info: "+nutritionalInfo);
	}
	
	public abstract Image getImage();

}
