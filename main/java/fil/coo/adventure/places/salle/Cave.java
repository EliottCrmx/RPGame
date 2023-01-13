package fil.coo.adventure.places.salle;

import java.util.*;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.items.util.StrengthPotion;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.util.Goblin;
import fil.coo.adventure.entities.monsters.util.Ogre;
import fil.coo.adventure.places.Room;

public class Cave extends Room {
    //Salle Grotte => 2e salle
    public Cave() {
        super("Cave", 2, null, null, null);

        List<Item> roomCaveItems = new ArrayList<>();
        roomCaveItems.add(new StrengthPotion());
        roomCaveItems.add(new GoldChest());
        setRoomItem(roomCaveItems);

        List<Monster> roomCaveMonsters = new ArrayList<>();
        roomCaveMonsters.add(new Goblin());
        roomCaveMonsters.add(new Ogre());
        setRoomMonster(roomCaveMonsters);

        List<Room> roomCaveLinkedRooms = new ArrayList<>();
        roomCaveLinkedRooms.add(new Crypt());
        roomCaveLinkedRooms.add(new Dungeon());
        setRoomLinkedRooms(roomCaveLinkedRooms);
    }
}
