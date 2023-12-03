package org.example.menu;

import org.example.database.DataBase;
import org.example.game.Game;
import org.example.game.GameService;
import org.example.service.UserInput;
import org.example.map.MapEditor;

public class MainMenu {

    private Game game;
    private MapEditor mapEditor;
    private UserInput userInput;
    private GameService gameMenu;
    private DataBase dataBase;

    public MainMenu(Game game, UserInput userInput, GameService gameMenu,DataBase dataBase) {
        this.game = game;
        this.userInput = userInput;
        this.gameMenu = gameMenu;
        this.dataBase = dataBase;
        this.mapEditor = new MapEditor(game, userInput, this, dataBase);
    }

    public void startMainMenu() {
        System.out.println("-------FŐMENÜ-------");
        System.out.println("1. JÁTÉK");
        System.out.println("2. PÁLYASZERKESZTÉS");
        System.out.println("3. RANGLISTA");
        System.out.println("4. KILÉPÉS");
        handleMainMenuInput(userInput.getUserInputAsInt());
    }
    public void highScore() {
        System.out.println("-----HIGH SCORE-----");
        dataBase.fetchPlayers();
        System.out.println("VISSZA - X");
        char input = userInput.getUserInputAsChar();
        if(input=='X' || input=='x') {
            startMainMenu();
        }
        else {
            System.out.println("HELYTELEN PARANCS!");
            highScore();
        }

    }

    private void handleMainMenuInput(int input) {
        switch (input) {
            case 1 -> game.game();
            case 2 -> mapEditor.mapEditor();
            case 3 -> highScore();
            case 4 -> game.exitGame();
            default -> {
                System.out.println("NEM LÉTEZIK ILYEN PARANCS");
                startMainMenu();
            }
        }
    }
}
