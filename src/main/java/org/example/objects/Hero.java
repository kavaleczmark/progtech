package org.example.objects;

public class Hero extends GameObject {

    @Override
    public String getName() {
        return "HERO";
    }

    public ObjectTypes getObJectTypes() {
        return ObjectTypes.HERO;
    }
}
