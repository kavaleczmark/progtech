package org.example.map;

import org.example.objects.ObjectTypes;

public class MapValidator {

    private Map map;

    public MapValidator() {
    }

    public int getHeroCount() {
        return map.counterOfObject(ObjectTypes.HERO);
    }

    public int getGoldCount() {
        return map.counterOfObject(ObjectTypes.GOLD);
    }

    public int getWumpusCount() {
        return map.counterOfObject(ObjectTypes.WUMPUS);
    }

    public boolean isActionPossible(ObjectTypes type, Map map) {
        this.map = map;
        switch (type) {
            case HERO -> {
                return getHeroCount() != 1;
            }

            case GOLD -> {
                return getGoldCount() != 1;
            }

            case WUMPUS -> {
                return getWumpusCount() != getPossibleWumpusCount();
            }
        }
        return true;
    }

    public int getPossibleWumpusCount() {
        int size = map.getSize();
        if (size <= 8) {
            return 1;
        } else if (size <= 14) {
            return 2;
        } else {
            return 3;
        }
    }
}
