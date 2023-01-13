package fil.coo.adventure.entities.items;

import fil.coo.adventure.Inventory;
import fil.coo.adventure.entities.Player;

public abstract class Item extends Inventory {
	protected String name;

	public Item(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public abstract void isUsedBy(Player player);
}
