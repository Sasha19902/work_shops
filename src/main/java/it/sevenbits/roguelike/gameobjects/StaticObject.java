package it.sevenbits.roguelike.gameobjects;

import it.sevenbits.roguelike.absracts.GameObject;

public abstract class StaticObject extends GameObject {

    public StaticObject(int xPosition, int yPosition, String name) {
        super(xPosition, yPosition, name);
    }

}
