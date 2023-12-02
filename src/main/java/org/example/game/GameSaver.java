package org.example.game;

import org.example.map.Map;

import java.io.FileWriter;
import java.io.IOException;

public class GameSaver {
    private Game game;

    public GameSaver(Game game) {
        this.game = game;
    }

    public void saveGame(Map map) {
        if (map == null) {
            System.out.println("Előbb hozz létre egy pályát");
            return;
        }
        int mapSize = map.getSize();
        try {
            FileWriter myWriter = new FileWriter(game.getName() + ".txt");
            myWriter.write(mapSize + "\n");
            myWriter.write(map.getHero().isHasGold() + "\n");
            myWriter.write(map.getHero().getNumberOfArrows() + "\n");
            myWriter.write(map.getStepCount() + "\n");
            myWriter.write(map.getStartingHeroX() + "\n");
            myWriter.write(map.getStartingHeroY() + "\n");
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    myWriter.write(map.getMap()[i][j].getSaveAbleName());
                    if (j != mapSize - 1) {
                        myWriter.write(",");
                    }
                }
                if (i != mapSize - 1) {
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Hiba mentés közben!");
        }
    }
}