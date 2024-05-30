import java.util.ArrayList;
import java.time.Instant;
import java.time.Duration;
import java.util.Scanner;

public class Facade {

  private User user;
  //masterCardList = new CardList();

  //public Facade() {
  //  user = new User();
  //}

  public Card searchByName(String name) {
    return CardList.searchByName(name);
  }

  public ArrayList<Card> searchByType(String filter) {
    return CardList.searchByType(filter);
  }

  public ArrayList<Card> searchByRarity(String filter) {
    return CardList.searchByRarity(filter);
  }

  public Card searchById(int filter) {
    return CardList.searchById(filter);
  }

  public Card getCard(Card card) {
    // confused why this method is needed
    return card;
  }

  public double getCurrency() {
    return user.getCurrency();
  }

  public ArrayList<Card> getCollection() {
     return user.getOwnedCards();
  }

  public ArrayList<Card> getCardList() {
    return CardList.getCardList();
  }

  public ArrayList<Card> viewFamily(Card card) {
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
/*
 * VP USER SECTION:
 */
    public boolean createUser(String userName, String password, String firstName, String lastName, String email) {
      return UserList.addUserToList(userName, password, firstName, lastName, email);
    }


    // USER LIST NEEDS TO BE A SINGLETON SO NO CONSTRUCTOR
    // EVERY USER LIST NEEDS TO BE THE SAME
    public User loginUser(String userName, String password) {
      return UserList.loginUser(userName, password);
    }


    // FACADE NEEDS TO BE SINGLETON AS WELL
    public static void main(String[] args) {
      int count;
      for (int i = 1; i < 4; i++) {
        count = 0;
        ArrayList<Card> pack1 = CardList.searchByPack(i);
        for (int j = 0; j < pack1.size(); j++) {
          count++;
        }
        System.out.println("Pack " + i);
        System.out.println(count);
      
      }
      // Facade facade = new Facade();
  /*
      // Test creating a user
      boolean userCreated = facade.createUser("testUser", "password123", "John", "Doe", "john.doe@example.com");
      if (userCreated) {
          System.out.println("User created successfully.");
      } else {
          System.out.println("User creation failed.");
      }
  */
      // Test logging in
      /* User loggedInUser = facade.loginUser("VrajTPatel", "VrajIsStupid");
      if (loggedInUser != null) {
          System.out.println("Login successful for user: " + loggedInUser.getUserName());
          System.out.println("User Information:");
          System.out.println("Username: " + loggedInUser.getUserName());
          System.out.println("First Name: " + loggedInUser.getFirstName());
          System.out.println("Last Name: " + loggedInUser.getLastName());
          System.out.println("Email: " + loggedInUser.getEmail());
          System.out.println("Currency: " + loggedInUser.getCurrency());
          System.out.println("Favorite Cards:");
          for (Card card : loggedInUser.getFavoriteCards()) {
              System.out.println(card.getName());
          }
// To ensure Functionality with Cards.
          System.out.println("Owned Cards:");
          for (Card card : loggedInUser.getOwnedCards()) {
            System.out.println(card.getName());
          }
      } else {
          System.out.println("Something is broken Fix it");
      }
  }
   */


    /* TEST FOR PACK OPENING
      Pack newPack = new Pack(1);
      ArrayList<Card> packList = newPack.openPack();
      for (Card card : packList) {
        System.out.println(card.getName());
      }
      Scanner scanner = new Scanner(System.in);
      scanner.nextLine();

      CardList masterList = new CardList();
      packList = masterList.searchByRarity("uncommon");
      for (Card card : packList) {
        System.out.println(card.getName());
    }
    */

  }
}
  

