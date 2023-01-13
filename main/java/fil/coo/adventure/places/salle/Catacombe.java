package fil.coo.adventure.places.salle;

import java.util.*;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.util.LifePotion;
import fil.coo.adventure.entities.items.util.StrengthPotion;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.util.Kraken;
import fil.coo.adventure.entities.monsters.util.Ogre;
import fil.coo.adventure.places.Room;

public class Catacombe extends Room {
    public Catacombe() {
        super("Catacombe", 4, null, null, null);

        List<Item> roomCatacombeItems = new ArrayList<>();
        roomCatacombeItems.add(new StrengthPotion());
        roomCatacombeItems.add(new LifePotion());
        setRoomItem(roomCatacombeItems);

        List<Monster> roomCatacombeMonsters = new ArrayList<>();
        roomCatacombeMonsters.add(new Kraken());
        roomCatacombeMonsters.add(new Kraken());
        roomCatacombeMonsters.add(new Ogre());
        roomCatacombeMonsters.add(new Ogre());
        setRoomMonster(roomCatacombeMonsters);

        List<Room> roomCatacombeLinkedRooms = new ArrayList<>();
        //roomCaveLinkedRooms.add(new Forest());
        roomCatacombeLinkedRooms.add(new Arene());
        setRoomLinkedRooms(roomCatacombeLinkedRooms);
    }
}
