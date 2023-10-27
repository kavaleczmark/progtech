import org.example.game.Game;
import org.example.map.Map;
import org.example.map.MapEditor;
import org.example.map.MapValidator;
import org.example.menu.MainMenu;
import org.example.objects.*;
import org.example.service.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UnitTests {

    @Mock
    private UserInput userInput;
    @Mock
    private MapEditor mapEditor;
    @Mock
    private MainMenu mainMenu;
    @Mock
    private Game game;
    private Map map;

    @Test
    public void shouldGetInputFromUserAsString() {
        when(userInput.getUserInputAsString()).thenReturn("test"); //mikor fut add vissza a test-et
        String actual = userInput.getUserInputAsString();
        assertEquals("test",actual);
    }
    @Test
    public void shouldGetInputFromUserAsInt() {
        when(userInput.getUserInputAsInt()).thenReturn(1); //mikor fut add vissza a test-et
        int actual = userInput.getUserInputAsInt();
        assertEquals(1,actual);
    }
    @Test
    public void shouldGetInputFromUserAsChar() {
        when(userInput.getUserInputAsChar()).thenReturn('a'); //mikor fut add vissza a test-et
        char actual = userInput.getUserInputAsChar();
        assertEquals('a',actual);
    }

    @Test
    public void shouldReturnCorrectCountOfObject() {
        map = new Map(6);
        int actual = map.counterOfObject(ObjectTypes.WALL); //6-os map méretnél 20 fal van-e?
        assertEquals(20,actual);
    }

    @Test
    public void test() {
        mapEditor.mapEditor();
        verify(mapEditor,times(1)).mapEditor();
    }

    @Test
    public void test2() {
        mapEditor.createMapMenu();
        verify(mapEditor,times(1)).createMapMenu();
    }

    @Test
    public void shouldGetCorrectNumberOfHeroes() {
        MapValidator mapValidator = mock(MapValidator.class);
        when(mapValidator.getHeroCount()).thenReturn(0);
        int expected = 0;
        int actual = mapValidator.getHeroCount();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCorrectNumberOfGold() {
        MapValidator mapValidator = mock(MapValidator.class);
        when(mapValidator.getGoldCount()).thenReturn(0);
        int expected = 0;
        int actual = mapValidator.getGoldCount();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldGetCorrectNumberOfWumpus() {
        MapValidator mapValidator = mock(MapValidator.class);
        when(mapValidator.getWumpusCount()).thenReturn(2);
        int expected = 2;
        int actual = mapValidator.getWumpusCount();
        assertEquals(expected, actual);
    }

    @Test
    public void testGameCreation() {
        assertNotNull(game);
        assertNotNull(userInput);
        assertNotNull(mainMenu);
    }

    @Test
    public void testIsActionPossible_Wumpus() {
        Map map = new Map(9);
        MapValidator mapValidator = new MapValidator();
        map.getMap()[0][1] = new Wumpus();
        map.getMap()[0][2] = new Wumpus();
        map.getMap()[0][3] = new Wumpus();

        mapValidator.isActionPossible(ObjectTypes.WUMPUS, map);

        assertTrue(mapValidator.isActionPossible(ObjectTypes.WUMPUS, map));
    }
    @Test
    public void testIsActionPossible_Gold() {
        Map map = new Map(13);
        MapValidator mapValidator = new MapValidator();
        map.getMap()[0][1] = new Gold();
        map.getMap()[1][2] = new Gold();
        map.getMap()[4][3] = new Gold();

        mapValidator.isActionPossible(ObjectTypes.GOLD, map);

        assertTrue(mapValidator.isActionPossible(ObjectTypes.GOLD, map));
    }

    public void testIsActionPossible_Hero() {
        Map map = new Map(6);
        MapValidator mapValidator = new MapValidator();
        map.getMap()[2][1] = new Hero();
        map.getMap()[1][4] = new Hero();
        map.getMap()[3][3] = new Hero();

        mapValidator.isActionPossible(ObjectTypes.HERO, map);

        assertFalse(mapValidator.isActionPossible(ObjectTypes.HERO, map));
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

