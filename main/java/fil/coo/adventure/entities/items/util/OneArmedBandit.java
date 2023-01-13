package fil.coo.adventure.entities.items.util;

import fil.coo.adventure.entities.Player;
import fil.coo.adventure.entities.items.Item;

public class OneArmedBandit extends Item {

	
	public OneArmedBandit(){ 
		// Roue de la fortune utilisé dès qu'une salle est terminée
		super("Roue de la fortune");
	}
	@Override
	public void isUsedBy(Player player) {
		// Machine à gain/malus => 1 chance sur 5 de gagner un lot
		int min = 0; // Valeur min
		int max = 4; // Valeur max

		// Affiche les différents lots possibles dans la roue de la fortune
		System.out.println("Les différents lots :");
		System.out.println("- malus de vie");
		System.out.println("- potion de soin");
		System.out.println("- potion de force");
		System.out.println("- gain de 10 d'armure");
		System.out.println("- gain de 50 gold");
		// Genere un chiffre entre 0 et 4
		int random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);




		//Démarrage de la roulette
		if (random_int == 0) {
			//malus de 10 point de vie
			player.LooseLife(10);
			System.out.println("Vous avez perdu 10 point de vie");
		} else if (random_int == 1) {
			//Ajout d'une potion de soin
			player.addItemToInventory(new LifePotion());
			System.out.println("Vous avez gagné une potion de 20 point de vie !");
		} else if (random_int == 2) {
			//Ajout d'une potion de force
			player.addItemToInventory(new StrengthPotion());
			System.out.println("Vous avez gagné une potion de 10 point de force !");
		}else if (random_int == 3){
			//Ajout de 10 d'armure
			player.addArmor(10);
			System.out.println("vous avez gagné 10 d'armure !");
		}else if (random_int == 4){
			//Ajout de 50 gold
			player.addGold(50);
			System.out.println("vous avez gagné 50 gold !");
		}
		
	}

}
