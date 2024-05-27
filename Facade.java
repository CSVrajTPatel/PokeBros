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