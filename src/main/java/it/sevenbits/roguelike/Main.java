package it.sevenbits.roguelike;

import it.sevenbits.roguelike.creatures.mainhero.Hero;
import it.sevenbits.roguelike.creatures.monsters.Skeleton;
import it.sevenbits.roguelike.gameobjects.objects.Chest;
import it.sevenbits.roguelike.items.other.Coins;
import it.sevenbits.roguelike.items.weapons.SwordOfSun;

public class Main {

    public static void main(String[] args) {
        Skeleton skeleton = new Skeleton(3, 3, "SKELETON");
        Hero hero = new Hero(4, 4, "HERO");

        SwordOfSun swordOfSun = new SwordOfSun();
        Coins coins = new Coins(124);

        hero.attack(skeleton);
        Chest chest = new Chest(2, 2, "CHEST");
        chest.putItem(swordOfSun);
        chest.putItem(coins);

        chest.use(hero);
        chest.loot(hero);

        hero.getInventory().getItems().forEach(itm -> System.out.println(itm.getName()));
    }
}
