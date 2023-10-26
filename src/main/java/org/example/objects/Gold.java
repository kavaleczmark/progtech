package org.example.objects;

public class Gold extends GameObject {

    @Override
    public String getName() {
        return "GOLD";
    }

    public ObjectTypes getType() {
        return ObjectTypes.GOLD;
    }
}
