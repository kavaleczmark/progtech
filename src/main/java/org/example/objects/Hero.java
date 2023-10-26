package org.example.objects;

public class Hero extends GameObject {

    @Override
    public String getName() {
        return "HERO";
    }

    public ObjectTypes getType() {
        return ObjectTypes.HERO;
    }
}
