package org.example.objects;

public class Gold extends GameObject {

    public Gold(int x, int y) {
        super(x,y);
    }

    @Override
    public String getName() {
        return "GOLD";
    }

    public ObjectTypes getType() {
        return ObjectTypes.GOLD;
    }

    public String getSaveAbleName() {
        return getName();
    }
}
