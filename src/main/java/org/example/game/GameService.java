package org.example.game;

import org.example.game.Game;
import org.example.map.Map;
import org.example.map.MapLoader;
import org.example.objects.ObjectTypes;
import org.example.service.UserInput;

public class GameService {

    private Game game;
    private UserInput userInput;
    private GameLoader gameLoader;

    public GameService(Game game, UserInput userInput) {
        this.game = game;
        this.userInput = userInput;
    }

    public void loadLevelForGame() {
        System.out.println("Írja be a pálya nevét:");
        gameLoader = new GameLoader();
        game.setMap(gameLoader.loadMap(userInput.getUserInputAsString()));
        game.gameController();
    }

}
