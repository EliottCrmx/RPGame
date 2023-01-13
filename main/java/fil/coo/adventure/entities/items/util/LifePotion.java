package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class LifePotion extends Item {

	public LifePotion() {
		super("Potion de Soin");
	}

	@Override
	public void isUsedBy(Player player) {
		// ajout de 20 points de vie lorsque la potion est utilisée
		int lifePoint = player.getLifePoints();
		if(lifePoint + 20 > 100) {
			player.setLifePoint(100);
		} else {
			player.addLifePoint(20);
			System.out.println("Vous avez récupéré 20 points de vie !");
		}
	}

}
