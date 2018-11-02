package it.sevenbits.roguelike.creatures.monsters;

import it.sevenbits.roguelike.absracts.Unit;

public abstract class Creature extends Unit {

    public Creature(int xPosition, int yPosition, String name) {
        super(xPosition, yPosition, name);
    }
}
