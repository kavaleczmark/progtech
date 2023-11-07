package org.example.map;

import org.example.service.UserInput;

import java.io.FileWriter;
import java.io.IOException;

public class MapSaver {

    public MapSaver() {
    }

    public void saveMap(Map map, String mapName) {
        if(map == null) {
            System.out.println("Előbb hozz létre egy pályát");
            return;
        }
        int mapSize = map.getSize();
        try {
            FileWriter myWriter = new FileWriter(mapName+".txt");
            myWriter.write(mapSize+"\n");
            for (int i = 0; i < mapSize; i++) {
                for (int j = 0; j < mapSize; j++) {
                    myWriter.write(map.getMap()[i][j].getSaveAbleName());
                    if(j!=mapSize-1){
                        myWriter.write(",");
                    }
                }
                if(i!=mapSize-1) {
                    myWriter.write("\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Hiba mentés közben!");
        }
    }

}
