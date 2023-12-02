package gameTests;
import org.example.game.Game;
import org.example.game.GameLoader;
import org.example.game.HeroAction;
import org.example.map.Map;
import org.example.map.MapEditor;
import org.example.map.MapLoader;
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
public class HeroActionUT {
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
        Hero hero = new Hero(0,1,'E');
        hero.setHasGold(true);
        hero.setX(1);
        hero.setY(1);
        map.setStartingHeroX(0);
        map.setStartingHeroY(1);
        map.setHero(hero);
        assertTrue(heroAction.isWonHero(map));
    }

    @Test
    public void testIsWonHeroFalse() {
        Map map = new Map(6);
        Hero hero = new Hero(0,1,'E');
        hero.setX(1);
        hero.setY(1);
        map.setStartingHeroX(0);
        map.setStartingHeroY(1);
        map.setHero(hero);
        assertFalse(heroAction.isWonHero(map));
    }

    @Test
    public void testTurnRightHero() {
        Map map = new Map(6);
        Hero hero = new Hero(0,1,'E');
        hero.setX(1);
        hero.setY(1);
        map.setStartingHeroX(0);
        map.setStartingHeroY(1);
        map.setHero(hero);
        heroAction.turnRightHero(map);
        assertEquals('S', hero.getDirection());
    }

    @Test
    public void testTurnLeftHero() {
        Map map = new Map(6);
        Hero hero = new Hero(0,1,'E');
        hero.setX(1);
        hero.setY(1);
        map.setStartingHeroX(0);
        map.setStartingHeroY(1);
        map.setHero(hero);
        heroAction.turnLeftHero(map);
        assertEquals('N', hero.getDirection());
    }

    @Test
    public void testStepsOneHero() {
        Map map = new Map(6);
        Hero hero = new Hero(0,1,'E');
        hero.setX(1);
        hero.setY(1);
        hero.setNumberOfArrows(1);
        map.setStartingHeroX(0);
        map.setStartingHeroY(1);
        map.setHero(hero);
        heroAction.stepsOneHero(map);
        assertEquals(1, hero.getNumberOfArrows());
    }

}
