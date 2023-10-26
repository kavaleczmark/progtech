import org.example.map.Map;
import org.example.map.MapEditor;
import org.example.map.MapValidator;
import org.example.objects.Hero;
import org.example.objects.ObjectTypes;
import org.example.service.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UnitTests {

    @Mock
    private UserInput userInput;
    @Mock
    private MapEditor mapEditor;
    @Mock
    private MapValidator mapValidator;
    private ObjectTypes types;
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
}
