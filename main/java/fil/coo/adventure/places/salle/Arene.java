package fil.coo.adventure.places.salle;

import java.util.*;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.util.LifePotion;
import fil.coo.adventure.entities.items.util.StrengthPotion;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.util.Balrog;
import fil.coo.adventure.entities.monsters.util.Dragon;
import fil.coo.adventure.entities.monsters.util.Kraken;
import fil.coo.adventure.places.Room;

public class Arene extends Room {
    public Arene() {
        super("L'Arène", 6, null, null, null);

        List<Item> roomAreneItems = new ArrayList<>();
        roomAreneItems.add(new StrengthPotion());
        roomAreneItems.add(new LifePotion());
        setRoomItem(roomAreneItems);

        List<Monster> roomAreneMonsters = new ArrayList<>();
        roomAreneMonsters.add(new Dragon());
        roomAreneMonsters.add(new Kraken());
        roomAreneMonsters.add(new Balrog());
        setRoomMonster(roomAreneMonsters);

        List<Room> roomAreneLinkedRooms = new ArrayList<>();
        //roomAreneLinkedRooms.add(new Forest());
        //roomAreneLinkedRooms.add(new Dungeon());
        setRoomLinkedRooms(roomAreneLinkedRooms);
    }
}
