package SmartCalPackage;

import java.io.Serializable;

import javax.swing.JOptionPane;

public interface MachineState{
	String purchase();
}

class NoCash implements MachineState,Serializable{
	
	Machine vendingMachine;
	
	public NoCash(Machine newVendingMachine){
		vendingMachine=newVendingMachine;
	}

	@Override
	public String purchase() {
		System.out.println("Sorry! The machine doesn't have enough money to complete the transaction.");
		return "Sorry! The machine doesn't have enough money to complete the transaction.";
	}
	
}

class NoA1Item implements MachineState,Serializable{
	
	Machine vendingMachine;
	
	public NoA1Item(Machine newVendingMachine){
		vendingMachine=newVendingMachine;
	}

	@Override
	public String purchase() {
		System.out.println("Sorry! Item A1 is out of stock.");
		return "Item A1 is out of stock..";
	}
	
}
class NoA2Item implements MachineState,Serializable{
	
	Machine vendingMachine;
	
	public NoA2Item(Machine newVendingMachine){
		vendingMachine=newVendingMachine;
	}

	@Override
	public String purchase() {
		System.out.println("Sorry! Item A2 is out of stock.");
		return "Item A2 is out of stock.";
	}
	
}
class NoA3Item implements MachineState,Serializable{
	
	Machine vendingMachine;
	
	public NoA3Item(Machine newVendingMachine){
		vendingMachine=newVendingMachine;
	}

	@Override
	public String purchase() {
		System.out.println("Sorry! Item A3 is out of stock.");
		return "Item A3 is out of stock.";
		
	}
	
}

class HasCash implements MachineState,Serializable{
	
	Machine vendingMachine;
	
	public HasCash(Machine newVendingMachine){
		vendingMachine=newVendingMachine;
	}

	@Override
	public String purchase() {
		System.out.println("Do you want to continue?");
		return "Do you want to continue?";
	}
	
}
