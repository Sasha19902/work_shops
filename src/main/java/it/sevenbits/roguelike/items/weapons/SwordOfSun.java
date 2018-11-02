package it.sevenbits.roguelike.items.weapons;

public class SwordOfSun extends Sword {

    private int damage;
    private String name;

    public SwordOfSun() {
        damage = 10;
        name = "SWORD OF SUN";
    }

    public int getDamage() {
        return damage;
    }

    public void draw() {
        System.out.println("рисуем " + getName());
    }

    @Override
    public String getName() {
        return name;
    }
}
