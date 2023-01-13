package fil.coo.adventure.places.salle;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.items.util.LifePotion;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.util.Goblin;
import fil.coo.adventure.entities.monsters.util.Slime;
import fil.coo.adventure.places.Room;

import java.util.ArrayList;
import java.util.*;

public class Forest extends Room {
    //Salle Foret => 1ere salle
    public Forest() {
        super("Forest", 1, null, null, null);

        List<Item> roomForestItems = new ArrayList<>();
        roomForestItems.add(new LifePotion());
        roomForestItems.add(new GoldChest());
        setRoomItem(roomForestItems);

        List<Monster> roomForestMonsters = new ArrayList<>();
        roomForestMonsters.add(new Goblin());
        roomForestMonsters.add(new Slime());
        setRoomMonster(roomForestMonsters);

        List<Room> roomForestLinkedRooms = new ArrayList<>();
        roomForestLinkedRooms.add(new Cave());
        //roomForestLinkedRooms.add(new Dungeon());
        setRoomLinkedRooms(roomForestLinkedRooms);
        
    }
}
