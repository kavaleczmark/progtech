package gameTests;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.example.database.DataBase;
import org.example.game.Game;
import org.example.map.*;
import org.example.game.GameService;
import org.example.menu.MainMenu;
import org.example.objects.*;
import org.example.service.UserInput;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class GameServiceTest {
    private GameService gameService;
    private Game game;
    private UserInput userInput;
    private DataBase dataBase;

    @BeforeEach
    void setUp() {
        game = mock(Game.class);
        userInput = mock(UserInput.class);
        dataBase = mock(DataBase.class);

        gameService = new GameService(game, userInput, dataBase);
    }

    @Test
    void loadLevelForGame_ShouldLoadMapForGame() {
        when(userInput.getUserInputAsString()).thenReturn("test");

        gameService.loadLevelForGame();

        verify(userInput).getUserInputAsString();
        verify(game).setMap(any(Map.class));
        verify(game).gameController();
    }

    @Test
    void loadLevelFromDB_ShouldLoadMapFromDB() {
        when(userInput.getUserInputAsString()).thenReturn("level1");
        Map map = mock(Map.class);
        when(dataBase.loadMap(anyString())).thenReturn(map);

        Hero hero = mock(Hero.class);
        when(map.getHero()).thenReturn(hero);

        gameService.loadLevelFromDB();

        verify(dataBase).fetchMapNames();
        verify(userInput).getUserInputAsString();
        verify(dataBase).loadMap("level1");
        verify(game).setMap(map);
        verify(game).gameController();
    }
}
