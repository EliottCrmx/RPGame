package fil.coo.adventure.places.salle;

import java.util.*;

import fil.coo.adventure.entities.items.Item;
import fil.coo.adventure.entities.items.util.GoldChest;
import fil.coo.adventure.entities.items.util.StrengthPotion;
import fil.coo.adventure.entities.monsters.Monster;
import fil.coo.adventure.entities.monsters.util.Ogre;
import fil.coo.adventure.entities.monsters.util.Orc;
import fil.coo.adventure.entities.monsters.util.ZombiesHord;
import fil.coo.adventure.places.Room;

public class Dungeon extends Room {
    //Salle Donjon => 3e salle
    public Dungeon() {

        super("Dungeon", 3, null, null, null);

        List<Item> roomDungeonItems = new ArrayList<>();
        roomDungeonItems.add(new StrengthPotion());
        roomDungeonItems.add(new GoldChest());
        setRoomItem(roomDungeonItems);

        List<Monster> roomDungeonMonsters = new ArrayList<>();
        roomDungeonMonsters.add(new Orc());
        roomDungeonMonsters.add(new Ogre());
        roomDungeonMonsters.add(new ZombiesHord());

        setRoomMonster(roomDungeonMonsters);

        List<Room> roomDungeonLinkedRooms = new ArrayList<>();
        roomDungeonLinkedRooms.add(new SalleDesCoffres());
        //roomDungeonLinkedRooms.add(new Forest());
        setRoomLinkedRooms(roomDungeonLinkedRooms);

    }
}

