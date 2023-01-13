package fil.coo.adventure.entities.monsters;


//import java.util.Random;

import fil.coo.adventure.entities.GameCharacters;

public abstract class Monster extends GameCharacters{
	//classe abstraite => paramètres des monstres liées aux classes filles monsters.util.*
	public Monster(String name, int lP, int armor, int st, int gc) {
		super(name, lP, armor, st , gc);
	}
}
