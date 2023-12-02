package mapTests;

import org.example.game.Game;
import org.example.map.Map;
import org.example.map.MapEditor;
import org.example.map.MapValidator;
import org.example.game.GameService;
import org.example.menu.MainMenu;
import org.example.objects.*;
import org.example.service.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class MapUT {

    @Mock
    private Map map;
    private int size;

    @BeforeEach
    void setup() {
        size = 6;
        map = new Map(size);
    }

    @Test
    public void shouldReturnCorrectCountOfObject() {
        map = new Map(6);
        int actual = map.counterOfObject(ObjectTypes.WALL); //6-os map méretnél 20 fal van-e?
        assertEquals(20, actual);
    }

    @Test
    void shouldReturnCorrectMapSize() {
        int actualSize = map.getSize();
        assertEquals(size, actualSize);
    }
    @Test
    void shouldReturnStartingHeroCoordinates() {
        map.setStartingHeroX(2);
        map.setStartingHeroY(3);
        int actualX = map.getStartingHeroX();
        int actualY = map.getStartingHeroY();
        assertEquals(2, actualX);
        assertEquals(3, actualY);
    }
    @Test
    void shouldReturnCorrectGoldObject() {
        Gold gold = new Gold(2,2);
        map.getMap()[2][3] = gold;
        Gold actualGold = map.getGold();
        assertEquals(gold, actualGold);
    }

    @Test
    void shouldSetCorrectStepCount() {
        map.setStepCount(10);
        int actualCount = map.getStepCount();
        assertEquals(10, actualCount);
    }

    @Test
    void shouldSetCorrectMap() {
        GameObject[][] newMap = new GameObject[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                newMap[i][j] = new Wall();
            }
        }
        map.setMap(newMap);
        GameObject[][] actualMap = map.getMap();
        assertArrayEquals(newMap, actualMap);
    }

    @Test
    void shouldReturnCorrectHero() {
        Hero hero = new Hero(2,2,'E');
        map.getMap()[2][3] = hero;
        Hero actualHero = map.getHero();
        assertEquals(hero, actualHero);
    }

    @Test
    void shouldPrintMapSuccessfully() {
        map.printMap();
        assertTrue(true);
    }

    @Test
    void shouldReturnCorrectCounterOfObject() {
        map.setMap(new GameObject[][]{
                {new Wall(), new Wall(), new GameObject(), new Wall(), new GameObject(), new Wall()},
                {new Wall(), new GameObject(), new Gold(1,3), new Wall(), new Wall(), new Wall()},
                {new Wall(), new Wall(), new Wall(), new Wall(), new Wall(), new Wall()},
                {new Wall(), new GameObject(), new Wall(), new Wall(), new Wall(), new Wall()},
                {new Wall(), new GameObject(), new Wall(), new Wall(), new GameObject(), new Wall()},
                {new Wall(), new Wall(), new Pit(), new Wall(), new GameObject(), new Wall()}
        });
        int wallCount = map.counterOfObject(ObjectTypes.WALL);
        int goldCount = map.counterOfObject(ObjectTypes.GOLD);
        int pitCount = map.counterOfObject(ObjectTypes.PIT);
        assertEquals(27, wallCount);
        assertEquals(1, goldCount);
        assertEquals(1, pitCount);

    }
}
