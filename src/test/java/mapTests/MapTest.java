package mapTests;

import org.example.map.Map;
import org.example.objects.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class MapTest {

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
    @Test
    public void testGetGold() {
        Gold gold = new Gold(2,2);
        map.getMap()[2][2] = gold;

        Gold result = map.getGold();

        assertEquals(gold, result);
    }
    @Test
    public void testGetSize() {
        int expectedSize = 10;
        Map map = new Map(expectedSize);

        int result = map.getSize();

        assertEquals(expectedSize, result);
    }

    @Test
    public void testSetAndGetStartingHeroX() {
        int expectedStartingHeroX = 2;

        map.setStartingHeroX(expectedStartingHeroX);
        int result = map.getStartingHeroX();

        assertEquals(expectedStartingHeroX, result);
    }

    @Test
    public void testSetAndGetStartingHeroY() {
        int expectedStartingHeroY = 3;

        map.setStartingHeroY(expectedStartingHeroY);
        int result = map.getStartingHeroY();

        assertEquals(expectedStartingHeroY, result);
    }

    @Test
    public void testSetAndGetMap() {
        GameObject[][] expectedMap = new GameObject[][]{{new Wall(), new Wall()}, {new Gold(1,1), new GameObject()}};

        map.setMap(expectedMap);
        GameObject[][] result = map.getMap();

        assertArrayEquals(expectedMap, result);
    }


}
