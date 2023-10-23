package org.example.objects;

import org.example.ObjectTypes;

public class Wall extends GameObject {

    @Override
    public String getName() {
        return "WALL";
    }

    public ObjectTypes getObJectTypes() {
        return ObjectTypes.WALL;
    }
}
