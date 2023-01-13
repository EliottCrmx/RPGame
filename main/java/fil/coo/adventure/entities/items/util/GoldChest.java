package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.Player;

public class GoldChest extends Item {
	public GoldChest() {
		super("Coffre d'or");
	}
	
	@Override
	public void isUsedBy(Player player) {
		// ajout de gold lorsque le coffre est utilisé
		player.addGold(10);
		System.out.println("Vous avez gagné 10 pièces d'or !");
		
	}

}
