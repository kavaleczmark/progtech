package org.example.game;

import org.example.game.Game;
import org.example.map.MapEditor;
import org.example.map.MapLoader;
import org.example.service.UserInput;

public class GameService {

    private Game game;
    private UserInput userInput;
    private MapLoader mapLoader;

    public GameService(Game game, UserInput userInput) {
        this.game = game;
        this.userInput = userInput;
    }

    public void loadLevelForGame() {
        System.out.println("Írja be a pálya nevét:");
        mapLoader = new MapLoader();
        game.setMap(mapLoader.loadMap(userInput.getUserInputAsString()));
        game.gameController();
    }

}
