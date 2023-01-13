package fil.coo.adventure.places.salle;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.items.util.LifePotion;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.util.Balrog;
import fil.coo.adventure.entities.monsters.util.Kraken;
import fil.coo.adventure.entities.monsters.util.ZombiesHord;
import fil.coo.adventure.places.Room;

import java.util.ArrayList;
import java.util.*;

public class SalleDesCoffres extends Room {
    public SalleDesCoffres() {
        super("Salle Des Coffres", 5, null, null, null);

        List<Item> roomSalleDesCoffresItems = new ArrayList<>();
        roomSalleDesCoffresItems.add(new LifePotion());
        roomSalleDesCoffresItems.add(new GoldChest());
        setRoomItem(roomSalleDesCoffresItems);

        List<Monster> roomSalleDesCoffresMonsters = new ArrayList<>();
        roomSalleDesCoffresMonsters.add(new Balrog());
        roomSalleDesCoffresMonsters.add(new Kraken());
        roomSalleDesCoffresMonsters.add(new ZombiesHord());
        setRoomMonster(roomSalleDesCoffresMonsters);

        List<Room> roomSalleDesCoffresLinkedRooms = new ArrayList<>();
        roomSalleDesCoffresLinkedRooms.add(new Arene());
        //roomSalleDesCoffresLinkedRooms.add(new Dungeon());
        setRoomLinkedRooms(roomSalleDesCoffresLinkedRooms);
        
    }
}
