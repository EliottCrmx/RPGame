package fil.coo.adventure.places.salle;

import java.util.*;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.util.LifePotion;
import fil.coo.adventure.entities.items.util.StrengthPotion;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.util.Kraken;
import fil.coo.adventure.entities.monsters.util.Ogre;
import fil.coo.adventure.places.Room;

public class Crypt extends Room {
    //Salle Crypte => 4e salle
    public Crypt() {
        super("Crypte", 4, null, null, null);

        List<Item> roomCryptItems = new ArrayList<>();
        roomCryptItems.add(new LifePotion());
        roomCryptItems.add(new StrengthPotion());
        setRoomItem(roomCryptItems);

        List<Monster> roomCryptMonsters = new ArrayList<>();
        roomCryptMonsters.add(new Ogre());
        roomCryptMonsters.add(new Ogre());
        roomCryptMonsters.add(new Kraken());
        setRoomMonster(roomCryptMonsters);

        List<Room> roomCryptRoom = new ArrayList<>();
        roomCryptRoom.add(new Catacombe());
        //roomCryptRoom.add(new Dungeon());
        setRoomLinkedRooms(roomCryptRoom);
    }
}