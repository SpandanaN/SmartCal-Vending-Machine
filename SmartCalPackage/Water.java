package SmartCalPackage;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Water extends ItemsForSale implements Serializable{
	String name="Water"; 
	double cost=1.50;
	int calories=20;
	int sugarlevel=2;

	public void setItemName(String name){
		this.name=name;
	}

	public String getItemName(){
		return name;
	}

	public static void main(String [] args){
		ItemsForSale water=new Water();
		water.setName("Water");
		System.out.println(water.getItemName());
	}

	@Override
	public Image getImage() {
		Image img = new ImageIcon(this.getClass().getResource("/water.jpg")).getImage();
		return img;
	}
}
