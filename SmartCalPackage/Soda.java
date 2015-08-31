package SmartCalPackage;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Soda extends ItemsForSale implements Serializable{
	String name="Soda";
	double cost=1.50;
	int calories=250;
	int sugarlevel=23;
	
	public void setItemName(String name){
		this.name=name;
	}
	
	public String getItemName(){
		return name;
	}
	
	public static void main(String [] args){
		ItemsForSale soda=new Soda();
		soda.setName("Soda");
		System.out.println(soda.getItemName());
	}
	
	public Image getImage(){
		Image img = new ImageIcon(this.getClass().getResource("/soda.png")).getImage();
		return img;
	}
}