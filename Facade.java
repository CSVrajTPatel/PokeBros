import java.util.ArrayList;

public class Facade {

  private User user;

  //public Facade() {
  //  user = new User();
  //}

  public ArrayList<Card> searchByName(String name) {
    return null;
  }

  public ArrayList<Card> searchByType(String filter) {
    return null;
  }

  public ArrayList<Card> searchByRarity(String filter) {
    return null;
  }

  public Card searchById(int filter) {
    return null;
  }

  public Card getCard(Card card) {
    return card;
  }

  public double getCurrency() {
    return 0.0;
  }

  public ArrayList<Card> getCollection() {
    return null;
  }

  public ArrayList<Card> getCardList() {
    return null;
  }

  public ArrayList<Card> viewFamily(Card card) {
    return null;
  }

  public Boolean initiateTrade(ArrayList<Card> userCards, ArrayList<Card> traderCards, User user, double userCoin, double traderCoin) {
    return true;
  }

  public void rejectTrade(Trade trade) {
  
  }

  public void acceptTrade(Trade trade) {

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
    Pack testPack = new Pack("Pack #1", 20, 1, num);
    if(user.getCurrency() < testPack.getPackPrice()){
      return false;
    }
    user.setCurrency(-1*testPack.getPackPrice());  // subtract currency if user can afford the pack
    // add cards from pack to user collection  
    for(int i = 0; i < testPack.getCardList().size(); i++){
        user.addCardToList(testPack.getCardList().get(i));
        // adding to user collection
        // should probably be done in pack class, but then the pack opening process
        // would get done in the methods of user class, which might be the best way forward?
        // could also potentially pass the user as a parameter to pack class?
      }
      // return type might need to be different?
    return true;
  }

  public boolean ClaimDailyCurrency() {
    return true;
  }

  public static void main(String[] args) {
      CardList list = new CardList();
      ArrayList<Card> cards = list.searchByRarity("common");
      ArrayList<Card> newCards = list.searchByPack(1, cards);
      for (int i = 0; i < newCards.size(); i++)
        System.out.println(newCards.get(i).getName());
  }

}