package mapTests;

import org.example.map.Map;
import org.example.map.MapValidator;
import org.example.objects.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MapValidatorUT {

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
    public void testIsActionPossible_Wumpus() {
        Map map = new Map(9);
        MapValidator mapValidator = new MapValidator();
        map.getMap()[0][1] = new Wumpus(0, 1);
        map.getMap()[0][2] = new Wumpus(1, 2);
        map.getMap()[0][3] = new Wumpus(4, 3);

        mapValidator.isActionPossible(ObjectTypes.WUMPUS, map);

        assertTrue(mapValidator.isActionPossible(ObjectTypes.WUMPUS, map));
    }

    @Test
    public void testIsActionPossible_Gold() {
        Map map = new Map(13);
        MapValidator mapValidator = new MapValidator();
        map.getMap()[0][1] = new Gold(0, 1);
        map.getMap()[1][2] = new Gold(1, 2);
        map.getMap()[4][3] = new Gold(4, 3);

        mapValidator.isActionPossible(ObjectTypes.GOLD, map);

        assertTrue(mapValidator.isActionPossible(ObjectTypes.GOLD, map));
    }

    @Test
    public void testIsActionPossible_Hero() {
        Map map = new Map(6);
        MapValidator mapValidator = new MapValidator();
        map.getMap()[2][1] = new Hero(0, 1, 'E');
        map.getMap()[1][4] = new Hero(1, 2, 'E');
        map.getMap()[3][3] = new Hero(4, 3, 'E');

        mapValidator.isActionPossible(ObjectTypes.HERO, map);

        assertTrue(mapValidator.isActionPossible(ObjectTypes.HERO, map));
    }

}

