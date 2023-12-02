package gameTests;

import org.example.game.Game;
import org.example.game.GameLoader;
import org.example.game.GameService;
import org.example.map.Map;
import org.example.map.MapLoader;
import org.example.menu.MainMenu;
import org.example.service.UserInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameTest {
    @Mock
    private UserInput userInput;
    @Mock
    private MainMenu mainMenu;
    @Mock
    private Game game;
    @Mock
    private MapLoader mapLoader;
    @Mock
    private Map map;
    @Mock
    private GameLoader gameLoader;
    @Mock
    private GameService gameService;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @Test
    public void testGameCreation() {
        assertNotNull(game);
        assertNotNull(userInput);
        assertNotNull(mainMenu);
    }

    @Test
    public void testGetUserName() {
        when(userInput.getUserInputAsString()).thenReturn("John");
        game.startGame();
        game.getUserName();
        userInput.getUserInputAsString();
        verify(userInput).getUserInputAsString();
    }

    @Test
    void testCallGame() {
        game.game();
        verify(game, times(1)).game();
    }





}
