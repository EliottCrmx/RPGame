package fil.coo.adventure;

import fil.coo.adventure.entities.*;
import fil.coo.adventure.places.*;
import fil.coo.adventure.entities.monsters.*;

public class AdventureGame {
	private Room currentRoom;
	private Player player;
	
	public AdventureGame(Room startingRoom) {
		this.currentRoom = startingRoom;
	}
	
	public Room currentRoom() {
		return this.currentRoom;
	}
	
	public Player getPlayer() {
		return this.player;
	}

	public void addMonster(Monster monster, Room room) {
		room.addMonster(monster);
	}
	
}
