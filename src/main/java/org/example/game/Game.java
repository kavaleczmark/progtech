package org.example.game;

import org.example.map.Map;
import org.example.service.UserInput;
import org.example.menu.MainMenu;

public class Game implements GameAction {

    private UserInput userInput;
    private String userName;
    private MainMenu mainMenu;
    private GameService gameService;
    private Map map;

    public Game() {
        this.userInput = new UserInput();
        this.mainMenu = new MainMenu(this, userInput, gameService);
        this.gameService = new GameService(this, userInput);
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void startGame() {
        getUserName();
        mainMenu.startMainMenu();
    }

    public String getName() {
        return userName;
    }

    public void getUserName() {
        System.out.println("Üdvözlünk a Wumpus játékban!\nÍrd be a felhasználóneved: ");
        userName = userInput.getUserInputAsString();
        System.out.println("Köszönjük! További jó szórakozást " + userName + "!");
    }

    public void game() {
        System.out.println("-------JÁTÉK-------");
        System.out.println("1. PÁLYA BETÖLTÉSE JÁTÉKBÓL");
        System.out.println("2. PÁLYA BETÖLTÉSE ADATBÁZISBÓL");
        System.out.println("3. VISSZA A FŐMENÜBE");
        handleGameInput(userInput.getUserInputAsInt());
    }

    private void handleGameInput(int input) {
        switch (input) {
            case 1 -> gameService.loadLevelForGame();
            case 3 -> mainMenu.startMainMenu();
            default -> {
                System.out.println("#comingsoon or #wrongcommand");
                game();
            }
        }
    }

    public void exitGame() {
        System.exit(0);
    }

    private void saveGame() {
        GameSaver gameSaver = new GameSaver(this);
        gameSaver.saveGame(map);
        System.out.println("Játékállás elmentve!");
        exitGame();
    }

    @Override
    public void giveUp() {
        System.out.println("A játéknak vége, feladtad!");
        System.out.println("Vissza a menübe!");
        mainMenu.startMainMenu();
    }

    @Override
    public void postPone() {
        saveGame();
    }
    public void pauseGame() {
        System.out.println("1. FELADÁS");
        System.out.println("2. HALASZTÁS");
        System.out.println("3. FOLYTATÁS");
        handlePauseGameInput(userInput.getUserInputAsInt());
    }

    private void handlePauseGameInput(int input) {
        switch (input) {
            case 1 -> giveUp();
            case 2 -> postPone();
            case 3 -> gameController();
            default -> {
                System.out.println("#comingsoon or #wrongcommand");
                game();
            }
        }
    }

    public void gameController() {
        map.printMap();
        System.out.println("-------Kontroller-------");
        System.out.println("MOZGATÁS: W/A/S/D");
        System.out.println("SZÜNET: X");
        handleGameControllerInput(userInput.getUserInputAsChar());
    }

    private void handleGameControllerInput(int input) {
        switch (input) {
            case 'X', 'x' -> pauseGame();
            default -> {
                System.out.println("#comingsoon or #wrongcommand");
                game();
            }
        }
    }

}