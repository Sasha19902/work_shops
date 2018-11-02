package it.sevenbits.roguelike.creatures;

import it.sevenbits.roguelike.creatures.monsters.Creature;

public interface Attacker {
    void attack(Creature creature);
    int getDamage();
}
