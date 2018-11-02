package it.sevenbits.roguelike.items;

import java.util.HashSet;
import java.util.Set;

public class Inventory implements Storage {

    private Set<Item> items;

    public Inventory() {
        items = new HashSet<>();
    }

    public void putItem(Item item) {
        items.add(item);
    }

    public Set<Item> getItems() {
        return items;
    }
}
