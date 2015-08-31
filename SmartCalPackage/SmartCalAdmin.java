package SmartCalPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* This class maintains the admin part. Functionalities include:
 * - Creation of new items and initializing them.
 * - Creation of new machines
 * - Editing items or machines
 * 
 */
public class SmartCalAdmin implements Serializable{
	
	public static void createNewItems() throws IOException, ClassNotFoundException{
		//Creating new items
		ItemsForSale chips=new Chips();
		ItemsForSale soda=new Soda();
		ItemsForSale choco=new Chocolates();
		ItemsForSale biscuits = new Biscuits();
		ItemsForSale sandwich = new Sandwich();
		ItemsForSale water = new Water();
		//Setting the items with their properties.
		chips.setName("Chips");
		chips.setCost(2.00);
		chips.setCalories(100);
		chips.setSugar(10);
		soda.setName("Soda");
		soda.setCost(3.00);
		soda.setCalories(300);
		soda.setSugar(33);
		choco.setName("Chocolates");
		choco.setCost(2.15);
		choco.setCalories(350);
		choco.setSugar(50);
		biscuits.setName("Biscuits");
		biscuits.setCost(2.15);
		biscuits.setCalories(100);
		biscuits.setSugar(20);
		sandwich.setName("Sandwich");
		sandwich.setCost(2.15);
		chips.setCalories(150);
		chips.setSugar(25);
		water.setName("Water");
		water.setCost(2.15);
		chips.setCalories(0);
		chips.setSugar(0);
		//Adding them to the arraylist
		Database.addItemToList(chips);
		Database.addItemToList(soda);
		Database.addItemToList(choco);
		Database.addItemToList(sandwich);
		Database.addItemToList(water);
		Database.addItemToList(biscuits);
	}
	
	public static void createNewCards(){
		SmartCalCard card1 = new SmartCalCard10(1000);
		SmartCalCard card2 = new SmartCalCard20(2000);
		SmartCalCard card3 = new SmartCalCard50(5000);
		//Database.addToSet(card1);
		//Database.addToSet(card2);
		//Database.addToSet(card3);
	}
	
	public static void main(String args[]) throws IOException, ClassNotFoundException {
		
		Database.setupFiles();
		createNewItems();
		//System.out.println(Database.getCountOfItem("Biscuits"));
		/*List<ItemsForSale> itemList = Database.getItemsFromList();
		for(ItemsForSale item : itemList){
			System.out.println(item.getItemName());
			System.out.println(item.getCost());
		}
		System.out.println();*/
		
		
	}
}
