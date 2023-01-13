package fil.coo.adventure.entities;


public abstract class GameCharacters {
	protected String name;
	protected int LifePoints;
	protected int armor;
	protected int strength;
	protected int gold;

	//Super Constructeur réutilisé dans Player et Monster
	public GameCharacters(String name, int lP, int armor, int st, int gc) {
		this.name = name;
		this.LifePoints = lP;
		this.armor = armor;
		this.strength = st;
		this.gold=gc;
	}


//Armure
public int getArmor() {
	return armor;
}

public void setArmor(int armor) {
	this.armor = armor;
}

public void addArmor(int armor) {
	this.armor += armor;
}

public void removeArmor(int armor) {
	this.armor -= armor;
}



	public int getLifePoints() {
		return LifePoints;
	}

	public String getName() {
        return name;
    }

	public int getStrength() {
		return strength;
	}

	public void addStrenghtPoint(int str){
		this.strength += str;
	}

	public void addLifePoint(int lp){
		this.LifePoints += lp;
	}

	public void removeGold(int gc){
		this.gold -= gc;
	}
	
	
	public void LooseLife(int st) {
		this.LifePoints -= st;
	}

	public void setLifePoint(Integer lP){
		this.LifePoints = lP;
	}
	public boolean isDead(){
		return this.getLifePoints() <= 0;
	}

	public int getGold() {
		return gold;
	}

	public void addGold(int g) {
		gold = gold + g;
	}


}
