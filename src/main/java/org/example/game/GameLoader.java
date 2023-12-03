package org.example.game;

import org.example.map.Map;
import org.example.objects.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class GameLoader {
    public Map loadMap(String mapName) {
        GameObject[][] gameObjects = null;
        int i = 0;
        int j = 0;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        Map map = null;
        try {
            fileReader = new FileReader(mapName + ".txt");
            bufferedReader = new BufferedReader(fileReader);
            int size = Integer.parseInt(bufferedReader.readLine());
            boolean hasGold = Boolean.parseBoolean(bufferedReader.readLine());
            int arrows = Integer.parseInt(bufferedReader.readLine());
            int steps = Integer.parseInt(bufferedReader.readLine());
            int heroX = Integer.parseInt(bufferedReader.readLine());
            int heroY = Integer.parseInt(bufferedReader.readLine());
            gameObjects = new GameObject[size][size];
            String currLine;
            while ((currLine = bufferedReader.readLine()) != null) {
                StringTokenizer stringTokenizer = new StringTokenizer(currLine, ",");
                while (stringTokenizer.hasMoreTokens()) {
                    switch (stringTokenizer.nextToken()) {
                        case "EMPTY" -> gameObjects[i][j] = new GameObject();
                        case "GOLD" -> gameObjects[i][j] = new Gold(i, j);
                        case "HERO|E" -> gameObjects[i][j] = new Hero(i, j, 'E');
                        case "HERO|S" -> gameObjects[i][j] = new Hero(i, j, 'S');
                        case "HERO|N" -> gameObjects[i][j] = new Hero(i, j, 'N');
                        case "HERO|W" -> gameObjects[i][j] = new Hero(i, j, 'W');
                        case "PIT" -> gameObjects[i][j] = new Pit();
                        case "WALL" -> gameObjects[i][j] = new Wall();
                        case "WUMPUS" -> gameObjects[i][j] = new Wumpus(i, j);
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
            map.getHero().setHasGold(hasGold);
            map.getHero().setNumberOfArrows(arrows);
            map.setStepCount(steps);
            map.setStartingHeroX(heroX);
            map.setStartingHeroY(heroY);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return map;
    }
}
