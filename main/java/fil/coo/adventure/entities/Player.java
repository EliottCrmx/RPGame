package fil.coo.adventure.entities;

import fil.coo.adventure.Inventory;
import fil.coo.adventure.entities.items.*;



public class Player extends GameCharacters {
	protected Inventory inventory;
	
	
	
	
	public Player(String name, int armor,int health, int strength, int gold, Inventory inventory) {
		super(name, health, armor, strength, gold);
		this.inventory = inventory;
	}


	//Récupérer un Item, l'ajouter à l'inventaire
	public void addItemToInventory(Item item) {
		inventory.addItem(item);

	}

	public Inventory getInventory() {
		return inventory;
	}


	public void useItem(Item item){
		inventory.removeItem(item);
		item.isUsedBy(this);

	}













	/* 
	public void removeItemFromInventory(Item item) {
		this.inventory.removeItem(item);
	}
	

	public void attack(Monster monster) {
		while (monster.getLifePoints() > 0 && this.getLifePoints() > 0) {
			monster.setLifePoint(monster.getLifePoints() - this.strength);
			System.out.println(name + " attacked " + monster.getName() + " and dealt " + this.strength + " damage!");
			if (monster.getLifePoints() <= 0) {
				System.out.println(monster.getName() + " died!");
				break;
			}
			this.LifePoints -= monster.getStrength();
			System.out.println(monster.getName() + " attacked " + name + " and dealt " + monster.getStrength() + " damage!");
			if (this.LifePoints <= 0) {
				System.out.println(name + " died!");
				break;
			}
		}
	}

	//public Move(String room){
		// RECAP à chaque début de salle
		//System.out.println("Vos point de vie sont égale à "+ this.getLifePoints());

	//}*/
}
