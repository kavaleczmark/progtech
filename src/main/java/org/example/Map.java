package org.example;

import org.example.objects.*;

public class Map {

    private GameObject[][] map;
    private int size;

    public Map(int size) {
        if (size < 6) {
            this.size = 6;
        } else if (size > 20) {
            this.size = 20;
        } else {
            this.size = size;
        }
        this.map = new GameObject[this.size][this.size];
        initMap();
    }

    private void initMap() {
        fillEmpty();
        loadWall();
    }

    private void fillEmpty() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = new GameObject();
            }
        }
    }

    public void printMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j].getName() + " \t");
            }
            System.out.println();
            System.out.println();
        }
    }

    private void loadWall() {
        for (int i = 0; i < size; i++) {
            map[0][i] = new Wall();
            map[size - 1][i] = new Wall();
            map[i][0] = new Wall();
            map[i][size - 1] = new Wall();
        }
    }
    public int counterOfObject(ObjectTypes type) {
        int counter=0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(map[i][j].getObJectTypes()==type){
                    counter++;
                }
            }
        }
        return counter;
    }
}
