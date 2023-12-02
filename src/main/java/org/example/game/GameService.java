package org.example.game;

import org.example.database.DataBase;
import org.example.game.Game;
import org.example.map.Map;
import org.example.map.MapLoader;
import org.example.objects.ObjectTypes;
import org.example.service.UserInput;

public class GameService {

    private Game game;
    private UserInput userInput;
    private GameLoader gameLoader;
    private DataBase dataBase;

    public GameService(Game game, UserInput userInput, DataBase dataBase) {
        this.game = game;
        this.userInput = userInput;
        this.dataBase = dataBase;
    }

    public void loadLevelForGame() {
        System.out.println("Írja be a pálya nevét:");
        gameLoader = new GameLoader();
        game.setMap(gameLoader.loadMap(userInput.getUserInputAsString()));
        game.gameController();
    }

    public void loadLevelFromDB() {
        dataBase.fetchMapNames();
        System.out.println("Írja be a pálya nevét: ");
        Map map = dataBase.loadMap(userInput.getUserInputAsString());
        map.getHero().setNumberOfArrows(map.counterOfObject(ObjectTypes.WUMPUS));
        map.setStartingHeroX(map.getHero().getX());
        map.setStartingHeroY(map.getHero().getY());
        game.setMap(map);
        game.gameController();
    }

}
