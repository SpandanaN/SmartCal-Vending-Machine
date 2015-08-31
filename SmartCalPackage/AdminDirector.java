package SmartCalPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdminDirector{
	private MachineBuilder machine_builder;
	AdminDirector(MachineBuilder machine_builder){
		this.machine_builder=machine_builder;
	}
	Machine getMachine(){
		return this.machine_builder.getMachine();
	}
	void makeMachine(){
		this.machine_builder.buildA1Slot();
		this.machine_builder.buildA2Slot();
		this.machine_builder.buildA3Slot();
	}
}
class Machine extends Subject implements MachineComponents,Serializable{
	private int A1Count;
	private int A2Count;
	private int A3Count;
	private String A1itemName;
	private String A2itemName;
	private String A3itemName;
	public int id;
	private String location;
	public ArrayList<ItemsForSale> itemsAvailable=new ArrayList<ItemsForSale>();
	
	//changes for state
	MachineState noCash;
	MachineState noA1Item;
	MachineState noA2Item;
	MachineState noA3Item;
	MachineState hasCash;
	MachineState machineOutOfCash;
	
	MachineState machine_state;
	int cashInMachine=200;
	public Machine() throws ClassNotFoundException, IOException{
		observers=new ArrayList<Observer>();
		
	}
	
	public void CheckMachineState() throws ClassNotFoundException, IOException{
		noCash=new NoCash(this);
		noA1Item=new NoA1Item(this);
		noA2Item=new NoA2Item(this);
		noA3Item=new NoA3Item(this);
		hasCash=new HasCash(this);
		machineOutOfCash=new NoCash(this);
		
		machine_state=hasCash;
		cashInMachine=(int) Database.getBalanceOfMachine(1);
		
		if(cashInMachine<=0){
			machine_state=machineOutOfCash;
		}
		if(this.getA1Count()<=0){
			machine_state=noA1Item;
		}
		if(this.getA2Count()<=0){
			machine_state=noA2Item;
		}
		if(this.getA3Count()<=0){
			machine_state=noA3Item;
		}
	}
	void setMachineState(MachineState newMachineState){
		machine_state=newMachineState;
	}
	
	void setCashInMachine(int newCashInMachine){
		cashInMachine=newCashInMachine;
	}
	
	public MachineState getNoCashState(){
		return machineOutOfCash;
	}
	
	public String purchase(){
		return machine_state.purchase();
	}
	



	
	
	//changes for state end
	
	//changes for observer
	ArrayList<Observer> observers;
	
	
	/*Machine(){
		observers=new ArrayList<Observer>();
	}*/
	@Override
	public void register(Observer newObserver) {
		observers.add(newObserver);
	}

	@Override
	public void unregister(Observer deleteObserver) {
		int observerIndex=observers.indexOf(deleteObserver);
		observers.remove(observerIndex);
	}

	@Override
	public void notifyObserver() {
		for(Observer observer:observers)
			observer.update(A1Count, A2Count, A3Count);
	}
	
	
	//changes end
	
	public void addItems(ItemsForSale item){
		itemsAvailable.add(item);
	}
	
	public List<ItemsForSale> getItemsAvailable() throws IOException, ClassNotFoundException{
		//return itemsOnDisplay;
		FileInputStream fis = new FileInputStream("itemsAvailable.tmp");
		ObjectInputStream ois = new ObjectInputStream(fis);
		List<ItemsForSale> items = (List<ItemsForSale>) ois.readObject();
		ois.close();
		return items;
	}
	
	public void addItemsAvailable(ItemsForSale item) throws IOException, ClassNotFoundException{
		List<ItemsForSale> items = getItemsAvailable(); //(List<ItemsForSale>) ois.readObject();
		items.add(item);
		FileOutputStream fout= new FileOutputStream("itemsAvailable.tmp");
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(items);
		//ois.close();
		oos.close();
		/*} catch(EOFException e) {
			itemsAvailable.add(item);
			ois.writeObject(itemsAvailable);
		}*/
	}
	@Override
	public void setA1Count(int count) {
		A1Count=count;
		notifyObserver();
	}
	int getA1Count(){
		return A1Count;
	}

	public void setMachineId(int id){
		this.id = id;
	}
	
	public int getMachineId(){
		return id;
	}
	
	@Override
	public void setA2Count(int count) {
		A2Count=count;
		notifyObserver();
	}
	int getA2Count(){
		return A2Count;
	}

	@Override
	public void setA3Count(int count) {
		A3Count=count;
		notifyObserver();
	}
	int getA3Count(){
		return A3Count;
	}

	@Override
	public void setA1Item(String item) {
		A1itemName=item;
	}
	String getA1Item(){
		return A1itemName;
	}

	@Override
	public void setA2Item(String item) {
		A2itemName=item;
	}
	String getA2Item(){
		return A2itemName;
	}

	@Override
	public void setA3Item(String item) {
		A3itemName=item;
	}
	String getA3Item(){
		return A3itemName;
	}
	void setLocation(String location){
		this.location=location;
	}
	String getLocation(){
		return location;
	}
}
interface MachineComponents{
	void setA1Count(int count);
	void setA2Count(int count);
	void setA3Count(int count);
	void setA1Item(String item);
	void setA2Item(String item);
	void setA3Item(String item);
}

interface MachineBuilder{
	void buildA1Slot();
	void buildA2Slot();
	void buildA3Slot();
	Machine getMachine();
}
class SmartVendingMachineBuilder implements MachineBuilder,Serializable{
	private Machine machine;
	SmartVendingMachineBuilder() throws ClassNotFoundException, IOException{
		this.machine=new Machine();
	}
	@Override
	public void buildA1Slot() {
		machine.setA1Count(5);
		machine.setA1Item("Coke");
	}
	@Override
	public void buildA2Slot() {
		machine.setA2Count(5);
		machine.setA2Item("Chips");
	}
	@Override
	public void buildA3Slot() {
		machine.setA3Count(5);
		machine.setA3Item("Biscuits");
	}
	@Override
	public Machine getMachine() {
		return this.machine;
	}
}
