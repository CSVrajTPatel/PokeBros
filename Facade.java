import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;

public class Facade {

  private User user;

  public Facade() {
  }

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
    CardList master = CardList.getInstance();
    return master.getCardList();
  }

  public ArrayList<Integer> viewFamily(Card card) {
    return card.getFamily();
  }

  public int getCardId(Card card) {
    return card.getId();
  }


  public boolean initiateTrade(ArrayList<Card> senderCards, Card receiverCard, double senderCoins, String comment) {
    return user.initiateTrade(senderCards, receiverCard, senderCoins, comment);
  }

  public void rejectTrade(Trade trade) {
    trade.rejectTrade();

  }

  public void acceptTrade(int tradeIndex) {
    Trade.acceptTrade(user, tradeIndex);
}

  public boolean evaluateTrade(Trade trade) {
    return trade.isFairTrade();
  }

  public ArrayList<Trade> getSendingTrades() {
    return user.getSendingTrades();
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

    public void logOffUser(){
      UserList userList = UserList.getInstance();
      userList.logOffUser(user.getUserName());
    }

    public String getUserName() {
      return user.getUserName();
    }
    public static void printTrades(ArrayList<Trade> trades) {
      for (Trade trade : trades) {
          System.out.println("Sender: " + trade.getSender().getUserName());
          System.out.println("Receiver: " + trade.getReceiver().getUserName());
          System.out.println("Comment: " + trade.getComment());
          System.out.print("Cards Offered: ");
          for (Card card : trade.getCardsOffered()) {
              System.out.print("[" + card.getId() + " - " + card.getName() + "] ");
          }
          System.out.println();
          Card requestedCard = trade.getReceiverCard();
          System.out.println("Card Requested: [" + requestedCard.getId() + " - " + requestedCard.getName() + "]");
          System.out.println("Is Fair Trade: " + trade.isFairTrade());
          System.out.println("Awaiting Response: " + trade.isAwaitingResponse());
          System.out.println("Was Accepted: " + trade.wasAccepted());
          System.out.println("Sender Coin: " + trade.getSenderCoin());
          System.out.println("-------------------------");
      }
  }

  public static void main(String[] args) {
      Facade facade = new Facade("VrajTPatel", "VrajIsStupid");

      // Print receiving trades
      ArrayList<Trade> receivingTrades = facade.user.getReceivingTrades();
      printTrades(receivingTrades);
    
       // Prompt user to select a trade to accept
       Scanner scanner = new Scanner(System.in);
       System.out.println("Enter the number of the trade you want to accept:");
       int tradeNumber = scanner.nextInt();
       int tradeIndex = tradeNumber - 1;
          facade.acceptTrade(tradeIndex);
          System.out.println("Accepted Trade " + tradeNumber + ":");
    scanner.close();

    facade.logOffUser();
          
    }
  }


/* 

    Scanner scanner = new Scanner(System.in);
  
    System.out.print("Enter username: ");
    String userName = scanner.nextLine();
  
    System.out.print("Enter password: ");
    String password = scanner.nextLine();
  
    Facade facade = new Facade(userName, password);
  
    if (facade.user != null) {
      System.out.println("Logged in as: " + facade.getUserName());
  
      // Display original cards
      System.out.println("Original Cards Owned by " + facade.getUserName() + ":");
      for (Card card : facade.getOwnedCards()) {
        System.out.println(card.getName());
       }
    }
    else {
        System.out.println("Login failed. (User not found or incorrect password)");
        scanner.close();
        System.exit(0);
    }
  
    System.out.println("Enter the name of the pokemon you want to trade for");
    Card card = facade.searchByName(scanner.nextLine());

    System.out.println("Would you like to trade for this card?");
    String answer = scanner.nextLine();

    if (answer.equalsIgnoreCase("yes")) {
      System.out.println("Please enter your comment");
      String comment = scanner.nextLine();

      ArrayList<Card> tradeOffer = new ArrayList<Card>();

      while (answer.equalsIgnoreCase("yes")) {
        System.out.println("Please enter the name of 1 pokemon you would like to trade");
        String pokemon = scanner.nextLine();
      
        tradeOffer.add(facade.searchByName(pokemon));
      
        System.out.println("Would you like to add another pokemon?");
        answer = scanner.nextLine();
      }
      System.out.println("Would you like to add any currency to this trade?");
      double coin = scanner.nextDouble();

      
      if (!facade.initiateTrade(tradeOffer, card, coin, comment)) {
        System.out.println("Trade Failed");
        scanner.close();
        System.exit(0);
      }
    } 
    else {
      scanner.close();
      System.exit(0);
    }
    ArrayList<Trade> sendingTrades = facade.getSendingTrades();
    for (Trade trade : sendingTrades) { 
      System.out.println(trade.getSender().getUserName());
      System.out.println(trade.getReceiver().getUserName());
    }

    facade.logOffUser();
*/

  


      /* 
        String userName = "VrajTPatel";
        String password = "VrajIsStupid";

        Facade facade = new Facade(userName, password);

        if (facade.user != null) {
            System.out.println("User successfully logged in.");
            System.out.println("Current Currency: " + facade.getCurrency());

            // Claim daily currency
            if (facade.claimDailyCurrency()) {
                System.out.println("Daily currency claimed.");
                System.out.println("Updated Currency: " + facade.user.getCurrency());
            } else {
                System.out.println("Failed to claim daily currency.");
            }

            // Logging off the user
            facade.logOffUser(userName);
            System.out.println("User logged off.");
        } else {
            System.out.println("Login failed. (User not found or incorrect password)");
        }
    }
*/

/*
 * TESTS FOR:
 *  USER LOGIN
 *  PACK OPENING( ADDING CARDS TO OWNED CARDS)
 *  USER LOG OFF
 * 
 *    UserList masterList = UserList.getInstance();
      Scanner scanner = new Scanner(System.in);

      System.out.print("Enter username: ");
      String username = scanner.nextLine();

      System.out.print("Enter password: ");
      String password = scanner.nextLine();

      User user1 = masterList.loginUser(username, password);

      if (user1 != null) {
          System.out.println("Logged in as: " + user1.getUserName());

          // Display original cards
          System.out.println("Original Cards Owned by " + user1.getUserName() + ":");
          for (Card card : user1.getOwnedCards()) {
              System.out.println(card.getName());
          }

          // Opening a pack
          System.out.println("Opening Pack 1:");
          if (user1.openPack(1)) {  // Make sure openPack updates the user's card list and returns true if successful
              System.out.println("Cards now owned by " + user1.getUserName() + " after opening the pack:");
              for (Card card : user1.getOwnedCards()) {
                  System.out.println(card.getName());
              }
          } else {
              System.out.println("Failed to open pack.");
          }

          // Display updated cards right before logging off
          System.out.println("Final check of cards owned by " + user1.getUserName() + " before logging off:");
          for (Card card : user1.getOwnedCards()) {
              System.out.println(card.getName());
          }

          // Log off the user
          masterList.logOffUser(user1.getUserName());
          System.out.println("User logged off.");
      } else {
          System.out.println("Login failed, user not found or incorrect password.");
      }

      scanner.close();
  }
}
 * 
 */

  
/*
 * TESTS FOR:
 *  Creating a new User
 *  Ensuring the basic new userformat is working correctly
 *  Logging off the user and recording to users.json
 * 

      // Hardcoded user details
      String userName = "newUser123";
      String password = "SecurePassword!123";
      String firstName = "John";
      String lastName = "Doe";
      String email = "john.doe@example.com";

    
      Facade facade = new Facade();

      // Attempt to create a new user and automatically log them in
      boolean userCreated = facade.createUser(userName, password, firstName, lastName, email);

      if (userCreated) {
          User user = facade.loginUser(userName, password);
          if (user != null) {
              facade.user = user;
              System.out.println("User successfully created and logged in.");
              // Display the user's details
              System.out.println("Username: " + facade.user.getUserName());
              System.out.println("First Name: " + facade.user.getFirstName());
              System.out.println("Last Name: " + facade.user.getLastName());
              System.out.println("Email: " + facade.user.getEmail());
              System.out.println("Currency: " + facade.user.getCurrency());
              System.out.println("Owned Cards: " + (facade.user.getOwnedCards().isEmpty() ? "No cards owned." : facade.user.getOwnedCards()));

              // Logging off the user
              facade.logOffUser(userName);
              System.out.println("User logged off.");
          } else {
              System.out.println("User creation failed. (User may already exist or email is invalid)");
          }
      } else {
          System.out.println("User creation failed. (User may already exist or email is invalid)");
      }
  }
 * 
 * 
 */
    
/*
 *    TESTS FOR :
 *    LOGGING IN
 *    CLAIM DAILY CURRENCY
 *   // Hardcoded user details for login
        String userName = "VrajTPatel";
        String password = "VrajIsStupid";
  
        Facade facade = new Facade(userName, password);
        User user = facade.loginUser(userName, password);
  
        if (user != null) {
            facade.user = user;
            System.out.println("User successfully logged in.");
            System.out.println("Current Currency: " + facade.user.getCurrency());
  
            // Claim daily currency
            if (facade.claimDailyCurrency()) {
                System.out.println("Daily currency claimed.");
                System.out.println("Updated Currency: " + facade.user.getCurrency());
            } else {
                System.out.println("Failed to claim daily currency.");
            }
  
            // Logging off the user
            facade.logOffUser(userName);
            System.out.println("User logged off.");
        } else {
            System.out.println("Login failed. (User not found or incorrect password)");
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

  

