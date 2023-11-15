package org.example.game;
import org.example.map.Map;
import org.example.objects.GameObject;
import org.example.objects.Hero;
import org.example.objects.ObjectTypes;
import org.example.objects.Wall;

public class HeroAction {

    public int numberOfArrows(Map map) {
        return map.counterOfObject(ObjectTypes.WUMPUS);
    }
    public void turnRightHero(Map map) {

        switch (map.getHero().getDirection()){
            case 'E' -> map.getHero().setDirection('S');
            case 'S' -> map.getHero().setDirection('W');
            case 'W' -> map.getHero().setDirection('N');
            case 'N' -> map.getHero().setDirection('E');
        }
    }

    public void turnLeftHero(Map map) {
        switch (map.getHero().getDirection()){
            case 'E' -> map.getHero().setDirection('N');
            case 'N' -> map.getHero().setDirection('W');
            case 'W' -> map.getHero().setDirection('S');
            case 'S' -> map.getHero().setDirection('E');
        }
    }
     public void stepsOneHero(Map map) {
        GameObject[][] objectsMap= map.getMap();
        Hero oldHero;
        int x,y;
        switch(map.getHero().getDirection()){
            case 'E' -> {
                oldHero = map.getHero();
                x = oldHero.getX();
                y = oldHero.getY();
                objectsMap[x][y] = new GameObject();
                if(!(objectsMap[x][y + 1] instanceof Wall)) {
                    objectsMap[x][y+1] = oldHero;
                    oldHero.setX(x);
                    oldHero.setY(y+1);
                    map.setMap(objectsMap);
                }
                else{
                    objectsMap[x][y] = oldHero;
                    oldHero.setX(x);
                    oldHero.setY(y);
                    map.setMap(objectsMap);
                    System.out.println("Nem lehet a falra lépni!");
                }
            }
            case 'W' -> {
                oldHero = map.getHero();
                x = oldHero.getX();
                y = oldHero.getY();
                objectsMap[x][y] = new GameObject();
                if(!(objectsMap[x][y-1] instanceof Wall)) {
                    objectsMap[x][y-1] = oldHero;
                    oldHero.setX(x);
                    oldHero.setY(y-1);
                    map.setMap(objectsMap);
                }
                else{
                    objectsMap[x][y] = oldHero;
                    oldHero.setX(x);
                    oldHero.setY(y);
                    map.setMap(objectsMap);
                    System.out.println("Nem lehet a falra lépni!");
                }
            }
            case 'S' -> {
                oldHero = map.getHero();
                x = oldHero.getX();
                y = oldHero.getY();
                objectsMap[x][y] = new GameObject();
                if(!(objectsMap[x+1][y] instanceof Wall)) {
                    objectsMap[x+1][y] = oldHero;
                    oldHero.setX(x+1);
                    oldHero.setY(y);
                    map.setMap(objectsMap);
                }
                else{
                    objectsMap[x][y] = oldHero;
                    oldHero.setX(x);
                    oldHero.setY(y);
                    map.setMap(objectsMap);
                    System.out.println("Nem lehet a falra lépni!");
                }
            }
            case 'N' -> {
                oldHero = map.getHero();
                x = oldHero.getX();
                y = oldHero.getY();
                objectsMap[x][y] = new GameObject();
                if(!(objectsMap[x-1][y] instanceof Wall)) {
                    objectsMap[x-1][y] = oldHero;
                    oldHero.setX(x-1);
                    oldHero.setY(y);
                    map.setMap(objectsMap);
                }
                else{
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
