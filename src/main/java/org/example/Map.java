package org.example;

import org.example.objects.GameObject;

public class Map {

    private GameObject[][] map;
    private int size;

    public Map(int size) {
        this.size = size;
        this.map = new GameObject[size][size];
    }

}
