package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class StrengthPotion extends Item {

protected String name;

	public StrengthPotion() {
		super("Potion de Force");
	}
	
		@Override
	public void isUsedBy(Player player) {
		// ajout de 10 points de force lorsque la potion est utilisée
		player.addStrenghtPoint(5);
		System.out.println("Vous avez gagné 5 points de force !");
	}

}
