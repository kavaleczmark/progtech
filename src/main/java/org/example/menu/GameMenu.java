package org.example.menu;

import org.example.game.Game;
import org.example.map.MapEditor;
import org.example.service.UserInput;

public class GameMenu {

    private Game game;
    private UserInput userInput;

    public GameMenu(Game game, UserInput userInput) {
        this.game = game;
        this.userInput = userInput;
    }

    public void loadLevelForGame() {
        MapEditor mapEditor = new MapEditor(game,userInput,new MainMenu(game,userInput));
        mapEditor.loadMap();
    }
}
