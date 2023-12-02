package org.example.objects;

public class Wumpus extends GameObject {

    public Wumpus(int x, int y) {
        super(x, y);
    }

    @Override
    public String getName() {
        return "WUMPUS";
    }

    public ObjectTypes getType() {
        return ObjectTypes.WUMPUS;
    }

    public String getSaveAbleName() {
        return getName();
    }

    public String getKilledWumpus() {
        return "DEATH";
    }
}
