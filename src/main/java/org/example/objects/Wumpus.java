package org.example.objects;

public class Wumpus extends GameObject {

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
}
