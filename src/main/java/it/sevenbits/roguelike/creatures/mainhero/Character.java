package it.sevenbits.roguelike.creatures.mainhero;

import it.sevenbits.roguelike.absracts.Unit;

public abstract class Character extends Unit {

    public Character(int xPosition, int yPosition, String name) {
        super(xPosition, yPosition, name);
    }
}
