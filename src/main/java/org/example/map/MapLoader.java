package org.example.map;

import org.example.objects.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class MapLoader {
    public Map loadMap(String mapName) {
        GameObject[][] gameObjects = null;
        int i=0, j=0;
        FileReader fR = null;
        BufferedReader bR = null;
        Map map = null;
        try {
            String currLine;
            fR = new FileReader(mapName+ ".txt");
            bR = new BufferedReader(fR);
            int size = Integer.parseInt(bR.readLine());
            gameObjects = new GameObject[size][size];
            while ((currLine = bR.readLine()) != null) {
                StringTokenizer sT = new StringTokenizer(currLine,",");
                while(sT.hasMoreTokens()) {
                    switch (sT.nextToken()) {
                        case "EMPTY" -> gameObjects[i][j] = new GameObject();
                        case "GOLD" -> gameObjects[i][j] = new Gold();
                        case "HERO" -> gameObjects[i][j] = new Hero();
                        case "PIT" -> gameObjects[i][j] = new Pit();
                        case "WALL" -> gameObjects[i][j] = new Wall();
                        case "WUMPUS" -> gameObjects[i][j] = new Wumpus();
                    }
                    if (j < size - 1) {
                        j++;
                    } else {
                        i++;
                        j = 0;
                    }
                }
            }
            map = new Map(size);
            map.setMap(gameObjects);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bR != null) bR.close();
                if (fR != null) fR.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }
}
