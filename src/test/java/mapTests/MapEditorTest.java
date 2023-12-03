package mapTests;

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
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MapEditorTest {
    @Mock
    private Game game;
    @Mock
    private UserInput userInput;
    @Mock
    private MainMenu mainMenu;
    @Mock
    private DataBase dataBase;
    @Mock
    private MapValidator mapValidator;
    @Mock
    private MapEditor mapEditor;
    @Mock
    private Map map;
    @Mock
    private MapLoader mapLoader;

    @BeforeEach
    public void setUp() {
        mapEditor = new MapEditor(game, userInput, mainMenu, dataBase);
    }

    @Test
    public void testMapEditor() {
        Mockito.when(userInput.getUserInputAsInt())
                .thenReturn(1)
                .thenReturn(4);
        mapEditor.mapEditor();
        Mockito.verify(mainMenu).startMainMenu();
    }
    @Test
    public void testCreateMap() {
        int size = 5;
        when(userInput.getUserInputAsInt()).thenReturn(size);
        mapEditor.createMap();
        assertEquals(size, map.getSize());
    }
    @Test
    void choosePosition_ShouldChooseValidPosition() {
        // Mock adatok beállítása
        int x = 2;
        int y = 2;
        when(userInput.getUserInputAsInt()).thenReturn(x).thenReturn(y);

        // Teszt
        mapEditor.choosePosition();

        // Ellenőrzés
        verify(userInput, times(2)).getUserInputAsInt();
        assertEquals(x - 1, game.getMap().getHero().getX());
        assertEquals(y - 'a', game.getMap().getHero().getY());
    }


}
