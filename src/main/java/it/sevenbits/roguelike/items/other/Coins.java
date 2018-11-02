package it.sevenbits.roguelike.items.other;

import it.sevenbits.roguelike.items.Counted;
import it.sevenbits.roguelike.items.Item;

public class Coins extends Item implements Counted {

    private String name;
    private int count;

    public Coins(int count) {
        name = "Монета";
        this.count = count;
    }

    @Override
    public String getName() {
        return name + " " + count+"x";
    }

    @Override
    public int getCount() {
        return count;
    }

    @Override
    public void setCount(int count) {
        this.count = count;
    }
}
