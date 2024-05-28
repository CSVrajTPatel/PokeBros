import java.util.ArrayList;
import java.util.Random; 

public class Pack {
    
    private String name;
    private ArrayList<Card> cards;
    private int packNumber;

    public Pack(int num){
      packNumber = num;
      if (num == 1) {
        CardList masterCardList = new CardList();
        name = "Bulbasaur Pack";
        cards = masterCardList.searchByPack(packNumber);
    }
      else if (num == 2) {
        CardList masterCardList = new CardList();
        name = "Charmander Pack";
        cards = masterCardList.searchByPack(packNumber);
    }
      else if (num == 3) {
        CardList masterCardList = new CardList();
        cards = masterCardList.searchByPack(packNumber);
        name = "Squirtle Pack";
    }

    }

    
    public ArrayList<Card> openPack() {
      ArrayList<Card> newPack = new ArrayList<Card>();
      CardList masterCardList = new CardList();
      Random rand = new Random();
      int numRares = rand.nextInt(10);
      int listNum = 7;
      if (numRares == 9) {
        numRares = 2;
      }

      else  {
        numRares = 1;
      }

      int num;
      int num2;

      for (Rarity rarity : Rarity.values()) {

        num = rand.nextInt(cards.size());

        if (rarity.toString().equalsIgnoreCase("common") || 
            rarity.toString().equalsIgnoreCase("uncommon" )) {

              num2 = rand.nextInt(1, listNum);
               // for (int i = 0; )
              

          }
        else if (numRares != 0 && 
          cards.get(num).getRarity().equalsIgnoreCase(rarity.toString())) {

            newPack.add(cards.get(num));
            listNum -= 1;

      }
    }
  }

    

    public ArrayList<Card> getCardList() {
      // i think this method is redundant but leaving for now
        return cards;
    }

    public boolean buyPack(int packType) {
      // this method seems to be useless unless it can be called as user.buyPack()
      // which cannot be done if pack is its own object as it is right now
        return true;

    }
}