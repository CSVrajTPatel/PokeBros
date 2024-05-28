import java.util.ArrayList;
import java.time.Instant;
import java.time.Duration;

public class Facade {

  private User user;
  private CardList masterCardList;
  //masterCardList = new CardList();

  //public Facade() {
  //  user = new User();
  //}

  public ArrayList<Card> searchByName(String name) {
    return masterCardList.searchByName(name);
  }

  public ArrayList<Card> searchByType(String filter) {
    return masterCardList.searchByType(filter);
  }

  public ArrayList<Card> searchByRarity(String filter) {
    return masterCardList.searchByRarity(filter);
  }

  public Card searchById(int filter) {
    return masterCardList.searchById(filter);
  }

  public Card getCard(Card card) {
    // confused why this method is needed
    return card;
  }

  public double getCurrency() {
    return user.getCurrency();
  }

  public ArrayList<Integer> getCollection() {
     return user.getOwnedCards();
  }

  public ArrayList<Card> getCardList() {
    return masterCardList.getCardList();
  }

  public ArrayList<Integer> viewFamily(Card card) {
    return card.getFamily();
  }

  public Boolean initiateTrade(ArrayList<Card> userCards, ArrayList<Card> traderCards, User user, double userCoin, double traderCoin) {
    return true;
  }

  public void rejectTrade(Trade trade) {
  
  }

  public void acceptTrade(Trade trade) {
    /*
     * get the cards offered for, add them to collection of buyer
     * remove listed cards from collection of the seller
     * add the cards which were offered to the seller to the seller's collection
     * use trade.getBuyerUserName()
     * use trade.getCardsOffered()
     * use trade.getSellerUserName()
     * use trade.getCardsRequested()
     *
     * use a for loop to iterate over each array and do user.addCardToList()
     * also do  user.removeCardFromList()
     * update JSON file
     */

  }

  public boolean evaluateTrade(Trade trade) {
    return true;
  }

 /* public ArrayList<Trade> getPastTradeHistory() {
    return user.getTradeHistory();
  }

  public ArrayList<Trade> getPendingTrades() {
    return user.viewPendingTradeRequests();
  }

  public boolean setFavoriteCard(Card targetCard) {
    if(user.addFavoriteCard(targetCard)){
      return true;
    }
    return false;
  }
   */
  

  public boolean purchasePack(int num) {
    // should there be an array list of static pack objects?
    // singleton pack object of each type which returns a random
    // subset of the cards available in that pack if hte user can purchase it?
    
        // adding to user collection
        // should probably be done in pack class, but then the pack opening process
        // would get done in the methods of user class, which might be the best way forward?
        // could also potentially pass the user as a parameter to pack class?
      // return type might need to be different?
    return true;
  }

  public boolean ClaimDailyCurrency() {
    Instant currentTime = Instant.now();
    Duration timeBetween = Duration.between(user.getLastClaimedCurrencyTime(), currentTime);
    if(timeBetween.toDays() >= 1){
      user.setCurrency(25);
      user.setLastClaimedCurrencyTime(currentTime);
      return true;
    }
    // need to add reading and writing from JSON file
    return false;  
  }

  public static void main(String[] args) {
      Pack newPack = new Pack(3);
      ArrayList<Card> packList = newPack.openPack();
      for (Card card : packList) {
        System.out.println(card.getName());
      }
  }

}