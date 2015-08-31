package SmartCalPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class Database implements Serializable{

	private static List<ItemsForSale> allItems = new ArrayList<ItemsForSale>();
	private static Set<Machine> machines = new HashSet<Machine>();
	private static Set<SmartCalCard> allCards = new HashSet<SmartCalCard>();
	private static HashMap<Integer, Double> totalCost = new HashMap<Integer, Double>();
	private static HashMap<Integer, Double> balanceCash = new HashMap<Integer, Double>();
	private static HashMap<String, Integer> popularItems = new HashMap<String, Integer>();

	public static void setupFiles() throws IOException {
		FileOutputStream fos = new FileOutputStream("cards.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(allCards);
		oos.close();
		fos = new FileOutputStream("cardId.ser");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(1);
		oos.close();
		fos = new FileOutputStream("items.ser");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(allItems);
		oos.close();
		fos = new FileOutputStream("machines.ser");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(machines);
		oos.close();
		fos = new FileOutputStream("machineId.ser");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(1);
		oos.close();
		fos = new FileOutputStream("earnings.ser");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(totalCost);
		oos.close();
		fos = new FileOutputStream("cashInMachine.ser");
		oos = new ObjectOutputStream(fos);
		balanceCash.put(1, 20.00);
		oos.writeObject(balanceCash);
		oos.close();
		fos = new FileOutputStream("itemCount.ser");
		oos = new ObjectOutputStream(fos);
		oos.writeObject(popularItems);
		oos.close();
	}

	public static void addItemToList(ItemsForSale item) throws IOException, ClassNotFoundException {
		allItems = getItemsFromList();
		allItems.add(item);
		FileOutputStream fos = new FileOutputStream("items.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(allItems);
		oos.close();
		fos.close();
	}

	public static List<ItemsForSale> getItemsFromList() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("items.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<ItemsForSale> items = (List<ItemsForSale>) ois.readObject();
		ois.close();
		fis.close();
		return items;
	}
	
	public static void updateItemInfo(String item_name,ItemsForSale new_item) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("items.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<ItemsForSale> item = (List<ItemsForSale>) ois.readObject();
		ois.close();
		ItemsForSale itemToDel = null;
		
		for(ItemsForSale i : item){
			if(i.getItemName().equals(item_name)){
				itemToDel =i;
			} 
		}
		
		item.remove(itemToDel);
		item.add(new_item);
		FileOutputStream fos = new FileOutputStream("items.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(item);
		oos.close();
	}

	public static ItemsForSale getItem(int index) throws IOException, ClassNotFoundException{
		allItems = getItemsFromList();
		return allItems.get(index);
	}

	public static void addMachine(Machine machine) throws IOException, ClassNotFoundException{
		machines = getAllMachines();
		machines.add(machine);
		FileOutputStream fos = new FileOutputStream("machines.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(machines);
		oos.close();
	}

	public static Set<Machine> getAllMachines() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("machines.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Set<Machine> machine = (Set<Machine>) ois.readObject();
		ois.close();
		fis.close();
		return machine;
	}

	public static Machine retrieveMachine(int id) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("machines.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Set<Machine> machine = (Set<Machine>) ois.readObject();
		ois.close();
		Iterator<Machine> machinesIterator=null;
		machinesIterator = machine.iterator();
		while(machinesIterator.hasNext()) { 
			Machine mac = machinesIterator.next();
			if(mac.id == id){
				return mac;
			}
		}
		return null;
	}
	
	public static void updateMachineInfo(int id, Machine newMachine) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("machines.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Set<Machine> machine = (Set<Machine>) ois.readObject();
		ois.close();
		Machine macToDel = null;
		
		for(Machine mac : machine){
			if(mac.id == id){
				macToDel = mac;
			} 
		}
		
		machine.remove(macToDel);
		machine.add(newMachine);
		FileOutputStream fos = new FileOutputStream("machines.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(machine);
		oos.close();
	}

	public static int getMachineId() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("machineId.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		int id = (Integer) ois.readObject();
		ois.close();
		return id;
	}

	public static void setMachineId() throws IOException, ClassNotFoundException{
		int id = getMachineId();
		id++;
		FileOutputStream fos = new FileOutputStream("machineId.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject((int) id);
		oos.close();
	}

	public static String getAdminUsername(){
		return "myAdmin2015";
	}

	public static String getAdminPassword(){
		return "123456";
	}
	
	//Updating the total earnings of the machine
	public static void updateCostOfMachine(int id, double amount) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("earnings.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		totalCost = (HashMap<Integer, Double>) ois.readObject();
		ois.close();
		if(totalCost.containsKey(id)){
			double total = totalCost.get(id);
			total += amount;
			totalCost.put(id, total);
		} else {
			totalCost.put(id, amount);
		}
		FileOutputStream fos = new FileOutputStream("earnings.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(totalCost);
		oos.close();
	}
	
	//Fetching the earnings of the machine
	public static double getEarningsOfMachine(int id) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("earnings.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		totalCost = (HashMap<Integer, Double>) ois.readObject();
		ois.close();
		return totalCost.get(id);
	}
	
	//This function retrieves all the cards in the database
	public static Set<SmartCalCard> getAllCards() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("cards.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Set<SmartCalCard> cards = (Set<SmartCalCard>) ois.readObject();
		ois.close();
		fis.close();
		return cards;
	}
	
	//Adding the new cards to the database.
	//Using a set to prevent adding cards with same id.
	public static void addCard(SmartCalCard card) throws IOException, ClassNotFoundException{
		allCards = getAllCards();
		allCards.add(card);
		FileOutputStream fos = new FileOutputStream("cards.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(allCards);
		oos.close();
	}

	//This function is used to fetch the card from the database based on the card id.
	public static SmartCalCard fetchCard(int id) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("cards.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Set<SmartCalCard> cards = (Set<SmartCalCard>) ois.readObject();
		ois.close();
		for(SmartCalCard card : cards){
			if(card.id == id){
				return card;
			} 
		}
		return null;
	}
	
	public static void updateCardInfo(int id, SmartCalCard card) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("cards.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Set<SmartCalCard> cards = (Set<SmartCalCard>) ois.readObject();
		ois.close();
		SmartCalCard cardToDel = null;
		
		for(SmartCalCard c : cards){
			if(c.id == id){
				cardToDel = c;
			} 
		}
		
		cards.remove(cardToDel);
		cards.add(card);
		FileOutputStream fos = new FileOutputStream("cards.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(cards);
		oos.close();
	}
	
	public static int getCardId() throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("cardId.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		int id = (Integer) ois.readObject();
		ois.close();
		return id;
	}

	public static void setCardId() throws IOException, ClassNotFoundException{
		int id = getCardId();
		id++;
		FileOutputStream fos = new FileOutputStream("cardId.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject((int) id);
		oos.close();
	}
	
	public static void updateCashInMachine(int id, double amount) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("cashInMachine.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		balanceCash = (HashMap<Integer, Double>) ois.readObject();
		ois.close();
		if(balanceCash.containsKey(id)){
			double total = balanceCash.get(id);
			total -= amount;
			balanceCash.put(id, total);
		} else {
			balanceCash.put(id, amount);
		}
		FileOutputStream fos = new FileOutputStream("cashInMachine.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(balanceCash);
		oos.close();
	}
	
	//Fetching the balance of the machine
	public static double getBalanceOfMachine(int id) throws IOException, ClassNotFoundException{
		FileInputStream fis = new FileInputStream("cashInMachine.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		balanceCash = (HashMap<Integer, Double>) ois.readObject();
		ois.close();
		return balanceCash.get(id);
	}
	
	//Updating count of the items purchased
	public static void updateCountOfItems(String item) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("itemCount.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		popularItems = (HashMap<String, Integer>) ois.readObject();
		if(popularItems.containsKey(item)){
			popularItems.put(item, popularItems.get(item) + 1);
		} else {
			popularItems.put(item, 1);
		}
		FileOutputStream fos = new FileOutputStream("itemCount.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(popularItems);
		oos.close();
	}
	
	//Getting the count of items sold
	public static int getCountOfItem(String item) throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream("itemCount.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		popularItems = (HashMap<String, Integer>) ois.readObject();
		ois.close();
		return popularItems.get(item);
	}

}
