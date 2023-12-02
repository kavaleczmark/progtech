package org.example.game;

import org.example.map.Map;
import org.example.objects.*;

public class HeroAction {

    public boolean isWonHero(Map map) {
        Hero hero = map.getHero();
        int x = hero.getX();
        int y = hero.getY();
        if (map.getStartingHeroX() == x && map.getStartingHeroY() == y && hero.isHasGold()) {
            hero.setWon(true);
            return true;
        }
        hero.setWon(false);
        return false;
    }

    public void moveOnWumpus(Map map) {
        GameObject[][] objectsMap = map.getMap();
        Hero hero = map.getHero();
        int x = hero.getX();
        int y = hero.getY();
        switch (map.getHero().getDirection()) {
            case 'E' -> {
                if (objectsMap[x][y + 1] instanceof Wumpus) {
                    objectsMap[x][y + 1] = hero;
                    objectsMap[x][y] = new GameObject();
                    hero.setDead();
                    map.printMap();
                    System.out.println("\uD83D\uDEAB Játéknak vége, megölt a Wumpus! \uD83D\uDEAB");
                    System.exit(0);
                }
            }
            case 'W' -> {
                if (objectsMap[x][y - 1] instanceof Wumpus) {
                    objectsMap[x][y - 1] = hero;
                    objectsMap[x][y] = new GameObject();
                    hero.setDead();
                    map.printMap();
                    System.out.println("\uD83D\uDEAB Játéknak vége, megölt a Wumpus! \uD83D\uDEAB");
                    System.exit(0);
                }
            }
            case 'N' -> {
                if (objectsMap[x - 1][y] instanceof Wumpus) {
                    objectsMap[x - 1][y] = hero;
                    objectsMap[x][y] = new GameObject();
                    hero.setDead();
                    map.printMap();
                    System.out.println("\uD83D\uDEAB Játéknak vége, megölt a Wumpus! \uD83D\uDEAB");
                    System.exit(0);
                }
            }
            case 'S' -> {
                if (objectsMap[x + 1][y] instanceof Wumpus) {
                    objectsMap[x + 1][y] = hero;
                    objectsMap[x][y] = new GameObject();
                    hero.setDead();
                    map.printMap();
                    System.out.println("\uD83D\uDEAB Játéknak vége, megölt a Wumpus! \uD83D\uDEAB");
                    System.exit(0);
                }
            }
        }
    }

    public void moveOnPit(Map map) {
        GameObject[][] objectsMap = map.getMap();
        Hero hero = map.getHero();
        int x = hero.getX();
        int y = hero.getY();
        if (hero.getNumberOfArrows() == 0) {
            return;
        }
        switch (map.getHero().getDirection()) {
            case 'E' -> {
                if (objectsMap[x][y + 1] instanceof Pit) {
                    hero.setNumberOfArrows(hero.getNumberOfArrows() - 1);
                }
            }
            case 'W' -> {
                if (objectsMap[x][y - 1] instanceof Pit) {
                    hero.setNumberOfArrows(hero.getNumberOfArrows() - 1);
                }
            }
            case 'N' -> {
                if (objectsMap[x - 1][y] instanceof Pit) {
                    hero.setNumberOfArrows(hero.getNumberOfArrows() - 1);
                }
            }
            case 'S' -> {
                if (objectsMap[x + 1][y] instanceof Pit) {
                    hero.setNumberOfArrows(hero.getNumberOfArrows() - 1);
                }
            }
        }
    }

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
        if (hero.getNumberOfArrows() == 0) {
            System.out.println("Nincs több nyilad!");
            return;
        }
        int x = hero.getX();
        int y = hero.getY();
        hero.setNumberOfArrows(hero.getNumberOfArrows() - 1);
        while (!(objectsMap[x][y] instanceof Wall) || !(objectsMap[x][y] instanceof Wumpus)) {
            if (objectsMap[x][y] instanceof Wall) {
                break;
            }
            if (objectsMap[x][y] instanceof Wumpus) {
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
        map.setStepCount(map.getStepCount() + 1);
        pickUpGold(map);
        moveOnPit(map);
        moveOnWumpus(map);
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
        isWonHero(map);
    }
}
