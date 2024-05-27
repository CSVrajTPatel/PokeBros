import java.util.ArrayList;
import java.util.Random; 

public class Pack {
    
    private String name;
    private int price;
    private ArrayList<Card> cards;
    private int numberOfRares;
    private int packNumber;

    public Pack(String name, int price, int numberOfRares, int packNum){
      this.name = name;
      this.price = price;
      this.numberOfRares = numberOfRares;
      this.packNumber = packNum;
    }
    
    public ArrayList<Card> openPack(int pack) {
      // somehow these need to be added to user collection json file
      // unsure if pack type should be specified as parameter or gotten from somwhere else
    int numCardsInPack = 5 - numberOfRares;
    Random rand = new Random();  // needed to randomly select carcardseds
    CardList masterCardList = new CardList();
      while(numCardsInPack < 5-numberOfRares){
        cards.add(masterCardList.searchByPack(pack).get(rand.nextInt(masterCardList.searchByPack(packType).size())));
        //  generate enough cards of the given pack type needed 
        //  to fill the pack and adds to the pack card list
    }
        return cards;
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
    public int getPackPrice(){
        return price;
    }
}
