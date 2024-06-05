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

	@Test
	public void testGetCardByHP() {
		assertEquals(100, masterList.get(8).getHp());
	}

	@Test
	public void testGetCardByValue() {
		assertEquals(45.00, masterList.get(9).getValue());
	}

	@Test
	public void testGetCardByEvoStage() {
		assertEquals(1, masterList.get(10).getEvoStage());
	}

	@Test
	public void testGetCardByFamily() {
		ArrayList<Integer> fam = new ArrayList<>();
		fam.add(10);
		fam.add(12);
		assertEquals(fam, masterList.get(11).getFamily());
	}

	@Test
	public void testGetCardByAttack() {
		ArrayList<String> atk = new ArrayList<>();
		atk.add("Whirlwind");
		atk.add("Bye-Bye Flight");
		assertEquals(atk, masterList.get(12).getAttacks());
	}

	@Test
	public void testSearchCardByID() {
		assertEquals("Bulbasaur", cardList.searchById(1, masterList).getName());
	}

	@Test
	public void testSearchCardByName() {
		assertEquals("Ivysaur", cardList.searchByName("Ivysaur").getName());
	}

	@Test
	public void testSearchCardsByName() {
		ArrayList<String> pkms = new ArrayList<>();
		ArrayList<String> searchedPkms = new ArrayList<>();
		pkms.add("Bulbasaur");
		pkms.add("Ivysaur");
		pkms.add("Venusaur");
		for (Card c : cardList.searchByName("saur", masterList))
			searchedPkms.add(c.getName());
		assertEquals(pkms, searchedPkms);
	}
}
