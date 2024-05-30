import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;

public class Facade {

  private User user;

  public Facade(String userName, String password) {
    user = loginUser(userName, password);
  }
  
  public User loginUser(String userName, String password) {
    UserList userList = UserList.getInstance();
    return userList.loginUser(userName, password);
  }
  
  public Card searchByName(String name) {
    CardList master = CardList.getInstance();
    return master.searchByName(name);
  }

  public ArrayList<Card> searchByType(String filter) {
    CardList master = CardList.getInstance();
    return master.searchByType(filter);
  }

  public ArrayList<Card> searchByRarity(String filter) {
    CardList master = CardList.getInstance();
    return master.searchByRarity(filter);
  }

  public Card searchById(int filter) {
    CardList master = CardList.getInstance();
    return master.searchById(filter);
  }

  public double getCurrency() {
    return user.getCurrency();
  }

  public ArrayList<Card> getOwnedCards() {
     return user.getOwnedCards();
  }

  public ArrayList<Card> getCardList() {
    CardList masterList = CardList.getInstance();
    return masterList.getCardList();
  }

  public ArrayList<Integer> viewFamily(Card card) {
    return card.getFamily();
  }

  public Boolean initiateTrade(ArrayList<Card> senderCards, Card receiverCard, User receiver, double senderCoins) {
    Trade trade = new Trade(user, receiver, senderCards, receiverCard,senderCoins);
    user.addSendingTrade(trade);
    receiver.addReceivingTrade(trade);
    return true;
  }

  public void rejectTrade(Trade trade) {

  trade.rejectTrade();

  }

  public void acceptTrade(Trade trade) {

    trade.acceptTrade();

  }

  public boolean evaluateTrade(Trade trade) {
    return trade.isFairTrade();
  }

  public ArrayList<Trade> getTradeHistory() {
    return user.getTradeHistory();
  }

  public ArrayList<Trade> getPendingTrades() {
    return user.getPendingTrades();
  }

  public boolean addFavoriteCard(Card card) {
    return user.addFavoriteCard(card);
  }
  
  public ArrayList<Card> getFavoriteCards() {
    return user.getFavoriteCards();
  }

  public boolean openPack(int pack) {
    return user.openPack(pack);
    
  }

  public boolean claimDailyCurrency() {
    return user.claimDailyCurrency(); 
  }

    public boolean createUser(String userName, String password, String firstName, String lastName, String email) {
      UserList userList = UserList.getInstance();
      return userList.addUserToList(userName, password, firstName, lastName, email);
    }

    public void logOffUser(String userName){
      UserList userList = UserList.getInstance();
      userList.logOffUser(userName);
    }

    public String getUserName() {
      return user.getUserName();
    }

    public static void main(String[] args) {
      // Initialize the facade, which logs in the user as part of the constructor
      Facade facade = new Facade("VrajTPatel", "VrajIsStupid");  // Adjust these credentials as needed
  
      if (facade.user != null) {
          System.out.println("Logged in as: " + facade.user.getUserName());
  
          // Display original cards
          System.out.println("Original Cards Owned by " + facade.user.getUserName() + ":");
          for (Card card : facade.getOwnedCards()) {
              System.out.println(card.getName());
          }
  
          // Test the openPack method which should update the user's owned cards
          System.out.println("Opening Pack 1:");
          if (facade.openPack(1)) {  // Assumes openPack method returns true if successful
              System.out.println("Cards now owned by " + facade.user.getUserName() + " after opening the pack:");
              for (Card card : facade.getOwnedCards()) {  // This will include the newly added cards
                  System.out.println(card.getName());
              }
          } else {
              System.out.println("Failed to open pack.");
          }
  
          // Display updated cards right before logging off to confirm they are updated
          System.out.println("Final check of cards owned by " + facade.user.getUserName() + " before logging off:");
          for (Card card : facade.getOwnedCards()) {
              System.out.println(card.getName());
          }
  
          // Log off the user
          facade.logOffUser(facade.user.getUserName());
          System.out.println("User logged off.");
      } else {
          System.out.println("Login failed, user not found.");
      }
  }
}
      

  

  


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

  

