package fil.coo.adventure.places;

import java.util.*;

import fil.coo.adventure.entities.monsters.*;
import fil.coo.adventure.entities.items.*;

public class Room {
	protected String name;

	protected List<Monster> monsters; //liste de monstre
	protected int difficulty; //difficulté du jeu
	protected List<Item> items; //liste equipement consommable
	private List<Room> linkedRooms; //salle liée
	

	// Constructeur de la classe Room
	public Room(String name, int difficulty, List<Item> items, List<Monster> monsters, List<Room> linkedRooms) {
		this.name = name;
		this.difficulty = difficulty;
		this.items = items;
		this.monsters = monsters; 
		this.linkedRooms = linkedRooms;
	}


	// Fonction début de la salle
	public void start(){
		//nom de la salle, difficulté, salles liées

		System.out.println("Vous êtes dans la salle : " + name);
        System.out.println("Difficulté: " + difficulty);
        
		if (linkedRooms.size() != 0){
			System.out.print("Salle Suivante : ");
			for (Room linkedRoom : linkedRooms) {
				if (linkedRoom.getName() == linkedRooms.get(linkedRooms.size() -1).getName()) {
					System.out.println(linkedRoom.getName());
				} else { 
					System.out.print(linkedRoom.getName() + ", ");
				}
			}
		} else {
			System.out.println("Pas de salle suivante");
		}
		/*
		System.out.print("\nLinked rooms: ");


        for (Room room : linkedRooms) {
            System.out.print(room.getName() + " , ");
        } */
	}

	public String getName() {
		return name;
	}
	
	public void setRoomLinkedRooms(List<Room> linkedRooms){
        this.linkedRooms = linkedRooms;
    }

	public List<Room> getLinkedRooms() {
        return linkedRooms;
    }

	public void setRoomItem(List<Item> items){
        this.items = items;
    }

	public void setRoomMonster(List<Monster> monsters){
        this.monsters = monsters;
    }

	//Fonction relative aux monstres
	public void addMonster(Monster monster) {
		this.monsters.add(monster);
	}
	
	public void removeMonsters(Monster monster) {
		monsters.remove(monster);
	}
	
	public List<Monster> getMonsters() {
		return this.monsters;
	}

	// Fonction Item
	public void removeItem(Item item) {
		this.items.remove(item);
	}

	
	public List<Item> getItems() {
		return items;
	}
/*
	public void addItem(Item item) {
		this.items.add(item);
	}
	
*/

/*
	public boolean isExit() {
		return false;
	}
	
	private void addNeighbour(Direction d, Room r) {
		this.neighbour.put(d, r);
	}
	

	public Set<Direction> getPossibleDirections() {
		return this.neighbour.keySet();
	}
*/
	public boolean allMonstersKilled() {
		boolean res = true;
		for (Monster monster : monsters) {
			if (!monster.isDead()) {
				res = false;
			}
		}
		return res;
	}
	/*
	public String toString() {
		return new String();
	}
	*/
}
