package org.example.objects;

import org.example.ObjectTypes;

public class Pit extends GameObject {

    @Override
    public String getName() {
        return "PIT";
    }

    public ObjectTypes getObJectTypes() {
        return ObjectTypes.PIT;
    }
}
