package it.sevenbits.roguelike.creatures;

import it.sevenbits.roguelike.items.Inventory;
import it.sevenbits.roguelike.items.Counted;
import it.sevenbits.roguelike.items.Item;

public interface Inventored {
    Inventory getInventory();
    void putItem(Item item);
}
