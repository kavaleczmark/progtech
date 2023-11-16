package org.example.game;

import org.example.map.Map;
import org.example.objects.*;

public class HeroAction {
    public boolean pickUpGold(Map map) {
        GameObject[][] objectsMap = map.getMap();
        Hero hero = map.getHero();
        int x = hero.getX();
        int y = hero.getY();
        switch (map.getHero().getDirection()) {
            case 'E' -> {
                if (objectsMap[x][y + 1] instanceof Gold) {
                    hero.setHasGold(true);
                    objectsMap[x][y + 1] = hero;
                    return hero.isHasGold();
                }
            }
            case 'W' -> {
                if (objectsMap[x][y - 1] instanceof Gold) {
                    hero.setHasGold(true);
                    objectsMap[x][y - 1] = hero;
                    return hero.isHasGold();
                }
            }
            case 'N' -> {
                if (objectsMap[x - 1][y] instanceof Gold) {
                    hero.setHasGold(true);
                    objectsMap[x - 1][y] = hero;
                    return hero.isHasGold();
                }
            }
            case 'S' -> {
                if (objectsMap[x + 1][y] instanceof Gold) {
                    hero.setHasGold(true);
                    objectsMap[x + 1][y] = hero;
                    return hero.isHasGold();
                }
            }
        }
        return hero.isHasGold();
    }

    public void killWumpusWithArrows(Map map) {
        GameObject[][] objectsMap = map.getMap();
        Hero hero = map.getHero();
        if(hero.getNumberOfArrows() == 0) {
            System.out.println("Nincs több nyilad!");
            return;
        }
        int x = hero.getX();
        int y = hero.getY();
        hero.setNumberOfArrows(hero.getNumberOfArrows()-1);
        while(!(objectsMap[x][y] instanceof Wall) || !(objectsMap[x][y] instanceof Wumpus) ) {
            if(objectsMap[x][y] instanceof Wall)
            {
                break;
            }
            if(objectsMap[x][y] instanceof Wumpus)
            {
                objectsMap[x][y] = new GameObject();
                break;
            }
            switch (map.getHero().getDirection()) {
                case 'E' -> y++;
                case 'W' -> y--;
                case 'S' -> x++;
                case 'N' -> x--;
            }
        }
    }

    public void turnRightHero(Map map) {
        switch (map.getHero().getDirection()) {
            case 'E' -> map.getHero().setDirection('S');
            case 'S' -> map.getHero().setDirection('W');
            case 'W' -> map.getHero().setDirection('N');
            case 'N' -> map.getHero().setDirection('E');
        }
    }

    public void turnLeftHero(Map map) {
        switch (map.getHero().getDirection()) {
            case 'E' -> map.getHero().setDirection('N');
            case 'N' -> map.getHero().setDirection('W');
            case 'W' -> map.getHero().setDirection('S');
            case 'S' -> map.getHero().setDirection('E');
        }
    }

    public void stepsOneHero(Map map) {
        GameObject[][] objectsMap = map.getMap();
        Hero oldHero = map.getHero();
        int x = oldHero.getX();
        int y = oldHero.getY();
        pickUpGold(map);
        switch (map.getHero().getDirection()) {
            case 'E' -> {
                objectsMap[x][y] = new GameObject();
                if (!(objectsMap[x][y + 1] instanceof Wall)) {
                    objectsMap[x][y + 1] = oldHero;
                    oldHero.setX(x);
                    oldHero.setY(y + 1);
                    map.setMap(objectsMap);
                } else {
                    objectsMap[x][y] = oldHero;
                    oldHero.setX(x);
                    oldHero.setY(y);
                    map.setMap(objectsMap);
                    System.out.println("Nem lehet a falra lépni!");
                }
            }
            case 'W' -> {
                objectsMap[x][y] = new GameObject();
                if (!(objectsMap[x][y - 1] instanceof Wall)) {
                    objectsMap[x][y - 1] = oldHero;
                    oldHero.setX(x);
                    oldHero.setY(y - 1);
                    map.setMap(objectsMap);
                } else {
                    objectsMap[x][y] = oldHero;
                    oldHero.setX(x);
                    oldHero.setY(y);
                    map.setMap(objectsMap);
                    System.out.println("Nem lehet a falra lépni!");
                }
            }
            case 'S' -> {
                objectsMap[x][y] = new GameObject();
                if (!(objectsMap[x + 1][y] instanceof Wall)) {
                    objectsMap[x + 1][y] = oldHero;
                    oldHero.setX(x + 1);
                    oldHero.setY(y);
                    map.setMap(objectsMap);
                } else {
                    objectsMap[x][y] = oldHero;
                    oldHero.setX(x);
                    oldHero.setY(y);
                    map.setMap(objectsMap);
                    System.out.println("Nem lehet a falra lépni!");
                }
            }
            case 'N' -> {
                objectsMap[x][y] = new GameObject();
                if (!(objectsMap[x - 1][y] instanceof Wall)) {
                    objectsMap[x - 1][y] = oldHero;
                    oldHero.setX(x - 1);
                    oldHero.setY(y);
                    map.setMap(objectsMap);
                } else {
                    objectsMap[x][y] = oldHero;
                    oldHero.setX(x);
                    oldHero.setY(y);
                    map.setMap(objectsMap);
                    System.out.println("Nem lehet a falra lépni!");
                }
            }
        }
    }
}
