package SmartCalPackage;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Chocolates extends ItemsForSale implements Serializable{
	String name="Chocolates"; 
	double cost=1.00;
	int calories=210;
	int sugarlevel=20;

	public void setItemName(String name){
		this.name=name;
	}

	public String getItemName(){
		return name;
	}

	public static void main(String [] args){
		ItemsForSale chocolates=new Chocolates();
		chocolates.setName("Chocolates");
		System.out.println(chocolates.getItemName());
	}

	@Override
	public Image getImage() {
		Image img = new ImageIcon(this.getClass().getResource("/chocolate.png")).getImage();
		return img;
	}
}
