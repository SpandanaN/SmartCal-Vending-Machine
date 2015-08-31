package SmartCalPackage;
import java.io.Serializable;
import java.util.ArrayList;

abstract class Subject implements Serializable{
	abstract void register(Observer newObserver);
	abstract void unregister(Observer newObserevr);
	abstract void notifyObserver();
}

abstract class Observer implements Serializable{
	abstract void update(int A1itemCount, int A2itemCount, int A3itemCount);
}
class CountObserver extends Observer implements Serializable{
	
	int A1itemCount;
	int A2itemCount;
	int A3itemCount;
	Subject machine1subject;
	
	CountObserver(Subject machine1subject){
		this.machine1subject=machine1subject;
		machine1subject.register(this);
	}
	@Override
	public void update(int A1itemCount, int A2itemCount, int A3itemCount) {
		this.A1itemCount=A1itemCount;
		this.A2itemCount=A2itemCount;
		this.A3itemCount=A3itemCount;
		printDetails();
	}
	
	void printDetails(){
		System.out.println("A1 count : "+A1itemCount+"\nA2 count : "+A2itemCount+"\nA3 count : "+A3itemCount);
	}
}
