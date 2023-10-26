package org.example.map;

import org.example.game.Game;
import org.example.menu.MainMenu;
import org.example.service.UserInput;
import org.example.objects.*;

public class MapEditor {
    private Map map;
    private UserInput userInput;
    private Game game;
    private MainMenu mainMenu;
    private int x, y;

    public MapEditor(Game game, UserInput userInput, MainMenu mainMenu) {
        this.userInput = userInput;
        this.game = game;
        this.mainMenu = mainMenu;
    }

    public void mapEditor() {
        System.out.println("-------PÁLYASZERKESZTŐ-------");
        System.out.println("1. PÁLYA LÉTREHOZÁSA");
        System.out.println("2. PÁLYA BETÖLTÉSE    #comingsoon");
        System.out.println("3. PÁLYA MENTÉSE    #comingsoon");
        System.out.println("4. VISSZA A FŐMENÜBE");
        handleMapEditorInput(userInput.getUserInputAsInt());
    }

    private void handleMapEditorInput(int input) {
        switch (input) {
            case 1 -> createMapMenu();
            case 4 -> mainMenu.startMainMenu();
            default -> {
                System.out.println("#cominsoon or #wrongcommand");
                mapEditor();
            }
        }
    }

    public void createMapMenu() {
        System.out.println("-------PÁLYA LÉTREHOZÁSA-------");
        createMap();
        System.out.println("1. POZICIÓ VÁLASZTÁSA");
        System.out.println("2. VISSZA");
        handleCreateMapMenuInput(userInput.getUserInputAsInt());
    }

    private void handleCreateMapMenuInput(int input) {
        switch (input) {
            case 1 -> choosePosition();
            case 2 -> mapEditor();
            default -> {
                System.out.println("#cominsoon or #wrongcommand");
                mapEditor();
            }
        }
    }

    private void createMap() {
        System.out.println("Írja be a pálya méretét (NxN):");
        map = new Map(userInput.getUserInputAsInt());
        map.printMap();
    }

    private void choosePosition() {
        int x, y;
        do {
            System.out.println("Válassz oszlopot (pl. 'a'): ");
            y = userInput.getUserInputAsChar() - 'a';
            System.out.println("Válassz sort (pl. 1): ");
            x = userInput.getUserInputAsInt() - 1;
        } while (x < 0 || x > map.getSize() - 1 || y < 0 || y > map.getSize() - 1);
        this.x = x;
        this.y = y;
        fillObjects();

    }

    private void continueGame() {
        System.out.println("1. FOLYTATÁS");
        System.out.println("2. MENTÉS/KILÉPÉS");
        switch (userInput.getUserInputAsInt()) {
            case 1 -> choosePosition();
            case 2 -> mapEditor();
        }

    }

    private void fillObjects() {
        System.out.println("-------VÁLASSZON EGY ELEMET!-------");
        System.out.println("1. GOLD \n" +
                "2. HERO \n" +
                "3. PIT  \n" +
                "4. WUMPUS \n" +
                "5. ELEM TÖRLÉSE \n" +
                "6. VISSZA");
        switch (userInput.getUserInputAsInt()) {
            case 1 -> {
                map.getMap()[x][y] = new Gold();
                map.printMap();
                continueGame();
            }
            case 2 -> {
                map.getMap()[x][y] = new Hero();
                map.printMap();
                continueGame();
            }
            case 3 -> {
                map.getMap()[x][y] = new Pit();
                map.printMap();
                continueGame();
            }
            case 4 -> {
                map.getMap()[x][y] = new Wumpus();
                map.printMap();
                continueGame();
            }
            case 5 -> {
                map.getMap()[x][y] = new GameObject();
                map.printMap();
                continueGame();

            }
            case 6 -> mapEditor();
        }
    }
}