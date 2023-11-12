package org.example.menu;

import org.example.game.Game;
import org.example.game.GameService;
import org.example.service.UserInput;
import org.example.map.MapEditor;

public class MainMenu {

    private Game game;
    private MapEditor mapEditor;
    private UserInput userInput;
    private GameService gameMenu;

    public MainMenu(Game game, UserInput userInput, GameService gameMenu) {
        this.game = game;
        this.userInput = userInput;
        this.gameMenu = gameMenu;
        this.mapEditor = new MapEditor(game, userInput, this);
    }

    public void startMainMenu() {
        System.out.println("-------FŐMENÜ-------");
        System.out.println("1. JÁTÉK");
        System.out.println("2. PÁLYASZERKESZTÉS");
        System.out.println("3. KILÉPÉS");
        handleMainMenuInput(userInput.getUserInputAsInt());
    }

    private void handleMainMenuInput(int input) {
        switch (input) {
            case 1 -> game.game();
            case 2 -> mapEditor.mapEditor();
            case 3 -> game.exitGame();
            default -> {
                System.out.println("NEM LÉTEZIK ILYEN PARANCS");
                startMainMenu();
            }
        }
    }
}
