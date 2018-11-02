package it.sevenbits.roguelike.absracts;

public abstract class GameObject implements Coordinated, Visuality, Named {

    private int xPosition;
    private int yPosition;
    private String name;

    public GameObject(int xPosition, int yPosition, String name) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.name = name;
    }

    public int getXPosition() {
        return xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public String getName() {
        return name;
    }
}
