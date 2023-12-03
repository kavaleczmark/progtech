package org.example.map;

import org.example.database.DataBase;
import org.example.game.Game;
import org.example.menu.MainMenu;
import org.example.service.UserInput;
import org.example.objects.*;

public class MapEditor {
    private Map map;
    private UserInput userInput;
    private Game game;
    private MainMenu mainMenu;
    private MapValidator mapValidator;

    private DataBase dataBase;
    private int x, y;

    public MapEditor(Game game, UserInput userInput, MainMenu mainMenu, DataBase dataBase) {
        this.userInput = userInput;
        this.game = game;
        this.mainMenu = mainMenu;
        this.mapValidator = new MapValidator();
        this.dataBase = dataBase;
    }

    public void mapEditor() {
        System.out.println("-------PÁLYASZERKESZTŐ-------");
        System.out.println("1. PÁLYA LÉTREHOZÁSA");
        System.out.println("2. PÁLYA BETÖLTÉSE");
        System.out.println("3. PÁLYA MENTÉSE");
        System.out.println("4. VISSZA A FŐMENÜBE");
        handleMapEditorInput(userInput.getUserInputAsInt());
    }

    public void handleMapEditorInput(int input) {
        switch (input) {
            case 1 -> createMapMenu();
            case 2 -> loadMapMenu();
            case 3 -> saveMapMenu();
            case 4 -> mainMenu.startMainMenu();
            default -> {
                System.out.println("#cominsoon or #wrongcommand");
                mapEditor();
            }
        }
    }

    public void loadMapMenu() {
        System.out.println("-------PÁLYA BETÖLTÉSE-------");
        System.out.println("1. PÁLYA BETÖLTÉSE FÁJLBÓL");
        System.out.println("2. PÁLYA BETÖLTÉSE ADATBÁZISBÓL");
        handleMapLoaderInput(userInput.getUserInputAsInt());
    }

    public void handleMapLoaderInput(int input) {
        switch (input) {
            case 1 -> loadMapFromFile();
            case 2 -> loadMapFromDB();
            default -> {
                System.out.println("#cominsoon or #wrongcommand");
                mapEditor();
            }
        }
    }

    public void loadMapFromDB() {
        dataBase.fetchMapNames();
        System.out.println("Add meg a betöltendő pálya nevét!");
        map = dataBase.loadMap(userInput.getUserInputAsString());
        map.printMap();
        choosePosition();
    }

    public void loadMapFromFile() {
        MapLoader mapLoader = new MapLoader();
        System.out.println("Add meg a betöltendő pálya nevét!");
        map = mapLoader.loadMap(userInput.getUserInputAsString());
        map.printMap();
        choosePosition();
    }

    public void saveMapMenu() {
        System.out.println("-------PÁLYA MENTÉSE-------");
        System.out.println("1. PÁLYA MENTÉSE FÁJLBA");
        System.out.println("2. PÁLYA MENTÉSE ADATBÁZISBA");
        handleMapSaverInput(userInput.getUserInputAsInt());
    }

    public void handleMapSaverInput(int input) {
        switch (input) {
            case 1 -> saveMapToFile();
            case 2 -> saveMapToDB();
            default -> {
                System.out.println("#cominsoon or #wrongcommand");
                mapEditor();
            }
        }
    }

    public void saveMapToDB() {
        System.out.println("Add meg a pálya nevét!");
        dataBase.saveMap(map, userInput.getUserInputAsString());
        mapEditor();
    }

    public void saveMapToFile() {
        MapSaver mapSaver = new MapSaver();
        System.out.println("Add meg a pálya nevét!");
        mapSaver.saveMap(map, userInput.getUserInputAsString());
        mapEditor();
    }

    public void createMapMenu() {
        System.out.println("-------PÁLYA LÉTREHOZÁSA-------");
        createMap();
        System.out.println("1. POZICIÓ VÁLASZTÁSA");
        System.out.println("2. VISSZA");
        handleCreateMapMenuInput(userInput.getUserInputAsInt());
    }

    public void handleCreateMapMenuInput(int input) {
        switch (input) {
            case 1 -> choosePosition();
            case 2 -> mapEditor();
            default -> {
                System.out.println("#cominsoon or #wrongcommand");
                mapEditor();
            }
        }
    }

    public void createMap() {
        System.out.println("Írja be a pálya méretét (NxN):");
        map = new Map(userInput.getUserInputAsInt());
        map.printMap();
    }

    public void choosePosition() {
        int x, y;
        do {
            System.out.println("A külső fal nem szerkeszthető!");
            System.out.println("Válassz oszlopot (pl. 'b'): ");
            y = userInput.getUserInputAsChar() - 'a';
            System.out.println("Válassz sort (pl. 2): ");
            x = userInput.getUserInputAsInt() - 1;
        } while (x < 1 || x > map.getSize() - 2 || y < 1 || y > map.getSize() - 2);
        this.x = x;
        this.y = y;
        fillObjects();

    }

    public void continueGame() {
        System.out.println("1. FOLYTATÁS");
        System.out.println("2. VISSZA A MENÜBE");
        switch (userInput.getUserInputAsInt()) {
            case 1 -> choosePosition();
            case 2 -> mapEditor();
        }
    }

    public void fillObjects() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
        System.out.println("-------VÁLASSZON EGY ELEMET!-------");
        System.out.println(
                "1. GOLD \n" +
                        "2. HERO \n" +
                        "3. PIT  \n" +
                        "4. WUMPUS \n" +
                        "5. WALL \n" +
                        "6. ELEM TÖRLÉSE \n" +
                        "7. VISSZA");
        switch (userInput.getUserInputAsInt()) {
            case 1 -> {
                if (mapValidator.isActionPossible(ObjectTypes.GOLD, map)) {
                    map.getMap()[x][y] = new Gold(x, y);
                    map.printMap();
                } else {
                    map.printMap();
                    System.out.println("Nem lehet 1-nél több GOLD a pályán!");
                }
                continueGame();
            }
            case 2 -> {
                if (mapValidator.isActionPossible(ObjectTypes.HERO, map)) {
                    map.getMap()[x][y] = new Hero(x, y, 'E');
                    map.printMap();
                } else {
                    map.printMap();
                    System.out.println("Nem lehet 1-nél több HERO a pályán!");
                }
                continueGame();
            }
            case 3 -> {
                map.getMap()[x][y] = new Pit();
                map.printMap();
                continueGame();
            }
            case 4 -> {
                if (mapValidator.isActionPossible(ObjectTypes.WUMPUS, map)) {
                    map.getMap()[x][y] = new Wumpus(x, y);
                    map.printMap();
                } else {
                    System.out.println("Nem lehetséges ez a parancs validálás miatt!");
                }
                continueGame();
            }
            case 5 -> {
                map.getMap()[x][y] = new Wall();
                map.printMap();
                continueGame();
            }
            case 6 -> {
                map.getMap()[x][y] = new GameObject();
                map.printMap();
                continueGame();

            }
            case 7 -> mapEditor();
        }
    }
}