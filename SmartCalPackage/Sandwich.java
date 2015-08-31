package SmartCalPackage;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Sandwich extends ItemsForSale implements Serializable{
	String name="Sandwich";
	double cost=4.5;
	int calories=350;
	int sugarlevel=22;

	public void setItemName(String name){
		this.name=name;
	}

	public String getItemName(){
		return name;
	}

	public static void main(String [] args){
		ItemsForSale sandwich=new Sandwich();
		sandwich.setName("Sandwich");
		System.out.println(sandwich.getItemName());
	}

	@Override
	public Image getImage() {
		Image img = new ImageIcon(this.getClass().getResource("/sandwich.jpg")).getImage();
		return img;
	}

}
