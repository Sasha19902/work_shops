package it.sevenbits.roguelike.items;

import it.sevenbits.roguelike.creatures.Inventored;

public interface Lootable {
    void loot(Inventored hero);
}
