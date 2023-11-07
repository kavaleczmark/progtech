package org.example.objects;

public class Pit extends GameObject {

    @Override
    public String getName() {
        return "PIT";
    }

    public ObjectTypes getType() {
        return ObjectTypes.PIT;
    }

    public String getSaveAbleName() {
        return getName();
    }
}
