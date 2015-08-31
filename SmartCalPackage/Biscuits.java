package SmartCalPackage;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Biscuits extends ItemsForSale implements Serializable{
	String name="Biscuits"; 
	double cost=2.00;
	int calories=160;
	int sugarlevel=20;

	public void setItemName(String name){
		this.name=name;
	}

	public String getItemName(){
		return name;
	}

	public static void main(String [] args){
		ItemsForSale biscuits=new Biscuits();
		biscuits.setName("Biscuits");
		System.out.println(biscuits.getItemName());
	}

	@Override
	public Image getImage() {
		Image img = new ImageIcon(this.getClass().getResource("/biscuits.jpg")).getImage();
		return img;
	}
}
