package it.sevenbits.roguelike.gameobjects.objects;

import it.sevenbits.roguelike.creatures.Inventored;
import it.sevenbits.roguelike.creatures.mainhero.Character;
import it.sevenbits.roguelike.items.Item;
import it.sevenbits.roguelike.items.Lootable;
import it.sevenbits.roguelike.items.Storage;
import it.sevenbits.roguelike.gameobjects.StaticObject;
import it.sevenbits.roguelike.gameobjects.Usable;
import it.sevenbits.roguelike.items.Counted;

import java.util.HashSet;
import java.util.Set;

public class Chest extends StaticObject implements Storage, Usable, Lootable {

    private Set<Item> itemStorage;

    public Chest(int xPosition, int yPosition, String name) {
        super(xPosition, yPosition, name);
        itemStorage = new HashSet<>();
    }

    public void use(Character character) {
        System.out.println(character.getName() + " Открывает сундук");
    }

    public void putItem(Item item) {
        itemStorage.add(item);
    }

    public Counted getItem(Counted item) {
        return null;
    }

    public void draw() {
        System.out.println("рисуем " + getName());
    }

    public void loot(Inventored hero) {
        itemStorage.forEach(hero::putItem);
        itemStorage.clear();
    }
}
