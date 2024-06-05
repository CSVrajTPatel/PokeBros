import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;

public class PackTester {
    private Pack pack;
    private CardList masterCardList;

    @Before
    public void setUp() {
        masterCardList = CardList.getInstance();
        pack = new Pack(1);
   }
  
    @Test
    public void testOpenPack() {
        ArrayList<Card> openedPack = pack.openPack();
        assertEquals(7, openedPack.size()); 
        for (Card card : openedPack) {
            assertNotNull(card); 
        }
    }

    @Test
    public void testGetCardList() {
        ArrayList<Card> cardList = pack.getCardList();
        assertNotNull(cardList); 
        assertEquals(masterCardList.searchByPack(1), cardList); 
    }

}