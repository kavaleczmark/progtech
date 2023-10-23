package org.example.objects;

import org.example.ObjectTypes;

public class Wumpus extends GameObject {

    @Override
    public String getName() {
        return "WUMPUS";
    }

    public ObjectTypes getObJectTypes() {
        return ObjectTypes.WUMPUS;
    }
}
