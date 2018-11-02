package it.sevenbits.roguelike.creatures.monsters;

import it.sevenbits.roguelike.creatures.*;
import it.sevenbits.roguelike.items.Inventory;
import it.sevenbits.roguelike.items.Item;

public class Skeleton extends Monster implements Healthed, Energed, Inventored, Attacker {

    private Inventory inventory;

    private int currentHealth;
    private int maxHealth;

    private int currentEnergy;
    private int maxCurrentEnergy;

    public Skeleton(int xPosition, int yPosition, String name) {
        super(xPosition, yPosition, name);
        inventory = new Inventory();
        currentHealth = 100;
        maxHealth = 100;
        currentEnergy = 100;
        maxCurrentEnergy = 100;
    }

    public int getEnergy() {
        return currentEnergy;
    }

    public int getMaxEnergy() {
        return maxCurrentEnergy;
    }

    public int getHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void putItem(Item item) {
        inventory.putItem(item);
    }

    public void draw() {
        System.out.println("риусем " + getName());
    }

    @Override
    public void attack(Creature creature) {
        System.out.println(getName() + " атакует " + creature.getName());
    }

    @Override
    public int getDamage() {
        return 0;
    }
}
