package it.sevenbits.roguelike.creatures.mainhero;

import it.sevenbits.roguelike.creatures.*;
import it.sevenbits.roguelike.creatures.monsters.Creature;
import it.sevenbits.roguelike.items.Inventory;
import it.sevenbits.roguelike.items.Item;
import it.sevenbits.roguelike.items.weapons.Sword;

public class Hero extends Character implements Healthed, Energed, Attacker, Inventored {

    private int currentHealth;
    private int maxHealth;

    private int currentEnergy;
    private int maxCurrentEnergy;

    private Sword sword;

    private Inventory inventory;

    public Hero(int xPosition, int yPosition, String name) {
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

    public int getHealth() {
        return currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getMaxEnergy() {
        return maxCurrentEnergy;
    }

    public void attack(Creature creature) {
        System.out.println(this.getName() + " Атакует " + creature.getName());
    }

    @Override
    public int getDamage() {
        return 0;
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public void putItem(Item item) {
        inventory.putItem(item);
    }

    public void draw() {
        System.out.println("рисуем " + getName());
    }
}
