package SmartCalPackage;

import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Chips extends ItemsForSale implements Serializable{
	String name="Chips";
	double cost=2.5;
	int calories=310;
	int sugarlevel=33;
	
	public void setItemName(String name){
		this.name=name;
	}
	
	public String getItemName(){
		return name;
	}
	
	public static void main(String [] args){
		ItemsForSale chips=new Chips();
		chips.setName("Chips");
		System.out.println(chips.getItemName());
	}

	@Override
	public Image getImage() {
		Image img = new ImageIcon(this.getClass().getResource("/chips.png")).getImage();
		return img;
	}
}