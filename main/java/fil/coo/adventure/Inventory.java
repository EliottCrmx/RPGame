package fil.coo.adventure;
import fil.coo.adventure.entities.items.*;
import java.util.*;


public class Inventory { //Inventaire(classe) qui contient les items
    private ArrayList<Item> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }
}
