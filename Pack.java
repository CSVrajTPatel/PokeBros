import java.util.ArrayList;
import java.util.Random; 

public class Pack {
    
    private String name;
    private ArrayList<Card> cards;
    private int packNumber;

    public Pack(int num){
    packNumber = num;
    CardList masterCardList = CardList.getInstance();
      if (num == 1) {
        name = "Bulbasaur Pack";
        cards = masterCardList.searchByPack(packNumber);
    }
      else if (num == 2) {
        // CardList masterCardList = new CardList();
        name = "Charmander Pack";
        cards = masterCardList.searchByPack(packNumber);
    }
      else if (num == 3) {
        // CardList masterCardList = new CardList();
        cards = masterCardList.searchByPack(packNumber);
        name = "Squirtle Pack";
    }

    }

    // FAIR WARNING TO ANYONE WHO TRIES TO UNDERSTAND THIS
    // I'm sorry in advance I know its disgusting
    // But based off the current order of the list in Rarity.java it will work
    // if you change that order it will probably still work, just not exactly as intended
    // im done for now tho
    public ArrayList<Card> openPack() {

      ArrayList<Card> newPack = new ArrayList<Card>(); // pack to be returned
     
      int listNum = 7; // num cards in the pack

      Random rand = new Random();
      int numRares = rand.nextInt(10); //rand number 0-9

      // if else to decide how many rares in the pack
      // 0-8 = 1 rare, 9 = 2 rares. so a 10% to get two
      if (numRares == 9) {
        numRares = 2;
      }

      else  {
        numRares = 1;
      }

      int num; // temp variable for random card index

      // Loops through the Rarities in Rarity.java
      // This loop really depends on the order in which they are processed, with the rares first then commons
      for (Rarity rarity : Rarity.values()) {

        num = rand.nextInt(cards.size());

        // First check is to check if 0 rares were selected, so it's a failsafe
        // I did it first to make sure rares are selected before commons if that happens
        // This should only go through if like 0 or 1 rare was selected because rares are iterated through first
        if (rarity.toString().equalsIgnoreCase("common") && numRares != 0) {

          // I did while instead of for to make sure if a rare wasn't selected i could rerandomize and check again until rares are selected
          while (numRares != 0) {

            //if its common or uncommen then re-randomize and go thru again until numRares = 0
            if (cards.get(num).getRarity().equalsIgnoreCase("common") || 
            cards.get(num).getRarity().equalsIgnoreCase("uncommon")) {

              num = rand.nextInt(cards.size());
            }

            // if it got past first check then it is a rare, so add and numRares-- and listNum-- 
            else {
              newPack.add(cards.get(num));
              numRares--;
              listNum--;
              num = rand.nextInt(cards.size());
            }
          }
        }

        // check if common or uncommon, im doing both when it iterates to common to have this only run once and finish here
        if (rarity.toString().equalsIgnoreCase("common")) {

          // at this point listNum will have exactly how many common or uncommons there should be so
          // same reason for while loop as above
          while (listNum > 0) {

            // if common or uncommon add and listNum--
            if (cards.get(num).getRarity().equalsIgnoreCase("common") ||
            cards.get(num).getRarity().equalsIgnoreCase("uncommon")) {
              newPack.add(cards.get(num));
              listNum--;
              num = rand.nextInt(cards.size());
            }

            // if not re-randomize and try again
            else {
              num = rand.nextInt(cards.size());
            }
          }
        }

        // Actually the first thing that should run, but it made sense to put it here to get the checks right (please believe me)
        // Checks if there are rares still to be added and adds the random card if its rare
        if (numRares != 0 && 
          cards.get(num).getRarity().equalsIgnoreCase(rarity.toString())) {

            newPack.add(cards.get(num));
            listNum --;
            numRares --;
      }
    }
    return newPack;
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