import static org.junit.jupiter.api.Assertions.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CardListTesting {
    CardList cardList = CardList.getInstance();
    ArrayList<Card> masterList = cardList.getCardList();

	@BeforeClass
	public void oneTimeSetup() {
		
	}
	
	@AfterClass
	public void oneTimeTearDown() {
		
	}
	
	@BeforeEach
	public void setup() {
		
	}
	
	@AfterEach
	public void tearDown() {
		
	}

    @Test
    public void testGetCardByName() {
		assertEquals("Venusaur", masterList.get(3).getName());
    }

	@Test
	public void testGetCardByType() {
		assertEquals("Fire", masterList.get(4).getType());
	}

	@Test
	public void testGetCardByRarity() {
		assertEquals("Ultra Rare", masterList.get(6).getRarity());
	}

	@Test
	public void testGetCardByPack() {
		assertEquals(3, masterList.get(7).getPack());
	}

	
}
