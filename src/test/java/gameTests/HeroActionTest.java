package gameTests;
import org.example.game.Game;
import org.example.game.GameLoader;
import org.example.game.HeroAction;
import org.example.map.Map;
import org.example.map.MapLoader;
import org.example.game.GameService;
import org.example.menu.MainMenu;
import org.example.objects.*;
import org.example.service.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class HeroActionTest {
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
    @Mock
    private HeroAction heroAction;

    @BeforeEach
    public void init() {
        heroAction = new HeroAction();
    }

    @Test
    public void testIsWonHeroTrue() {
        Map map = new Map(6);
        Hero hero = new Hero(1,1,'E');
        hero.setHasGold(true);
        map.setStartingHeroX(1);
        map.setStartingHeroY(1);
        map.getMap()[1][1] = hero;
        assertTrue(heroAction.isWonHero(map));
    }

    @Test
    public void testIsWonHeroFalse() {
        Map map = new Map(6);
        Hero hero = new Hero(1,1,'E');
        map.setStartingHeroX(1);
        map.setStartingHeroY(1);
        map.getMap()[1][1] = hero;
        assertFalse(heroAction.isWonHero(map));
    }

    @Test
    public void testTurnRightHero() {
        Map map = new Map(6);
        Hero hero = new Hero(1,1,'E');
        map.setStartingHeroX(1);
        map.setStartingHeroY(1);
        map.getMap()[1][1] = hero;
        heroAction.turnRightHero(map);
        assertEquals('S', hero.getDirection());
    }

    @Test
    public void testTurnLeftHero() {
        Map map = new Map(6);
        Hero hero = new Hero(1,1,'E');
        map.setStartingHeroX(1);
        map.setStartingHeroY(1);
        map.getMap()[1][1] = hero;
        heroAction.turnLeftHero(map);
        assertEquals('N', hero.getDirection());
    }

    @Test
    public void testHeroHasArrow() {
        Map map = new Map(6);
        Hero hero = new Hero(1,1,'E');
        hero.setNumberOfArrows(1);
        map.setStartingHeroX(1);
        map.setStartingHeroY(1);
        map.getMap()[1][1] = hero;
        heroAction.stepsOneHero(map);
        assertEquals(1, hero.getNumberOfArrows());
    }

}
