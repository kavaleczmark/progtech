package org.example.objects;

public class Wall extends GameObject {

    @Override
    public String getName() {
        return "WALL";
    }

    public ObjectTypes getType() {
        return ObjectTypes.WALL;
    }

    public String getSaveAbleName() {
        return getName();
    }
}
