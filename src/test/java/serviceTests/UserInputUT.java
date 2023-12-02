package serviceTests;

import org.example.service.UserInput;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserInputUT {

    @Mock
    private UserInput userInput;

    @Test
    public void shouldGetInputFromUserAsString() {
        UserInput userInput1 = Mockito.mock(UserInput.class);
        when(userInput1.getUserInputAsString()).thenReturn("test"); //mikor fut add vissza a test-et
        String actual = userInput1.getUserInputAsString();
        assertEquals("test", actual);
    }

    @Test
    public void shouldGetInputFromUserAsInt() {
        when(userInput.getUserInputAsInt()).thenReturn(1); //mikor fut add vissza a test-et
        int actual = userInput.getUserInputAsInt();
        assertEquals(1, actual);
    }

    @Test
    public void shouldGetInputFromUserAsChar() {
        when(userInput.getUserInputAsChar()).thenReturn('a'); //mikor fut add vissza a test-et
        char actual = userInput.getUserInputAsChar();
        assertEquals('a', actual);
    }
}

