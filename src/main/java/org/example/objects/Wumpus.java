package org.example.objects;

public class Wumpus extends GameObject {

    @Override
    public String getName() {
        return "WUMPUS";
    }

    public ObjectTypes getObJectTypes() {
        return ObjectTypes.WUMPUS;
    }
}
