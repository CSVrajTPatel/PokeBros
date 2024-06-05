import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CardTesting {
    CardList cardList = CardList.getInstance();
    ArrayList<Card> masterList = cardList.getCardList();
    ArrayList<Integer> fam = new ArrayList<>();
    ArrayList<String> atk = new ArrayList<>();
    Card pikachu = new Card();

    @BeforeClass
	public void oneTimeSetup() {
        
	}
	
	@AfterClass
	public void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public void setup() {
		fam.add(26);
        atk.add("Charge");
        atk.add("Pika Punch");
        pikachu = new Card(25, "Pikachu", "Lightning", "Illustration Rare",
         1, 60, 17.65, 1, fam, atk);
	}
	
	@AfterEach
	public void tearDown() {
		
	}

    @Test
    public void testGetCardName() {
        assertEquals(pikachu.getName(), masterList.get(25).getName());
    }

    @Test
    public void testGetCardType() {
        assertEquals(pikachu.getType(), masterList.get(25).getType());
    }

    @Test
    public void testGetCardRarity() {
        assertEquals(pikachu.getRarity(), masterList.get(25).getRarity());
    }

    @Test
    public void testGetCardPack() {
        assertEquals(pikachu.getPack(), masterList.get(25).getPack());
    }

    @Test
    public void testGetCardHP() {
        assertEquals(pikachu.getHp(), masterList.get(25).getHp());
    }

    @Test
    public void testGetCardValue() {
        assertEquals(pikachu.getValue(), masterList.get(25).getValue());
    }

    @Test
    public void testGetCardEvoStage() {
        assertEquals(pikachu.getEvoStage(), masterList.get(25).getEvoStage());
    }

    @Test
    public void testGetCardFamily() {
        assertEquals(pikachu.getFamily(), masterList.get(25).getFamily());
    }

    @Test
    public void testGetCardAttacks() {
        assertEquals(pikachu.getAttacks(), masterList.get(25).getAttacks());
    }
}
