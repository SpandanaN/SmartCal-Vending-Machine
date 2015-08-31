package SmartCalPackage;

public interface ItemFactory{
	public ItemsForSale createItem();
}

class SodaFactory implements ItemFactory{
	public ItemsForSale createItem(){
		return new Soda();
	}
}

class ChipsFactory implements ItemFactory{
	public ItemsForSale createItem(){
		return new Chips();
	}
}

class ChocolatesFactory implements ItemFactory{
	public ItemsForSale createItem(){
		return new Chocolates();
	}
}

class BiscuitsFactory implements ItemFactory{
	public ItemsForSale createItem(){
		return new Biscuits();
	}
}

class WaterFactory implements ItemFactory{
	public ItemsForSale createItem(){
		return new Water();
	}
}

class SandwichFactory implements ItemFactory{
	public ItemsForSale createItem(){
		return new Sandwich();
	}
}

