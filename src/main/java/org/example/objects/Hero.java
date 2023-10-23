package org.example.objects;

import org.example.ObjectTypes;

public class Hero extends GameObject {

    @Override
    public String getName() {
        return "HERO";
    }

    public ObjectTypes getObJectTypes() {
        return ObjectTypes.HERO;
    }
}
