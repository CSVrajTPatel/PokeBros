import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;

public class Facade {

  private static User user;
  private static Facade facade;

  public static Facade getInstance(String username, String password) {
    facade = new Facade(username, password);
    return facade;
  }

  private Facade(String username, String password) {
    user = loginUser(username, password);
  }
  
  private User loginUser(String userName, String password) {
    UserList userList = UserList.getInstance();
    return userList.loginUser(userName, password);
  }

  public User getUser() {
    return user;
  }
  
  public ArrayList<Card> searchByName(String name) {
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


  public boolean initiateTrade(ArrayList<Card> senderCards, Card receiverCard, String comment) {
    return user.initiateTrade(senderCards, receiverCard, comment);
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
/*
 * TESTS FOR:
 *  Creating a new User
 *  Ensuring the basic new userformat is working correctly
 *  Logging off the user and recording to users.json
 * 

      // Hardcoded user details

      Scanner scanner = new Scanner(System.in);
      System.out.println("CREATINT A NEW USER /n");
      System.out.print("User Name: ");
      String userName = scanner.nextLine();
      System.out.print("Password: ");
      String password = scanner.nextLine();
      System.out.print("First Name: ");
      String firstName = scanner.nextLine();
      System.out.print("User Name: ");
      String lastName = scanner.nextLine();
      System.out.print("Email: ");
      String email = scanner.nextLine();

      Facade facade = Facade.getInstance(userName, password);
      

      // Attempt to create a new user and automatically log them in

      boolean userCreated = facade.createUser(userName, password, firstName, lastName, email);

      if (userCreated) {
        facade = Facade.getInstance(userName, password);
        if (facade.getUser() != null) {
          System.out.println("User successfully created and logged in.");
          // Display the user's details
          System.out.println("Username: " + facade.getUser().getUserName());
          System.out.println("First Name: " + facade.getUser().getFirstName());
          System.out.println("Last Name: " +facade.getUser().getLastName());
          System.out.println("Email: " + facade.getUser().getEmail());
          System.out.println("Currency: " + facade.getUser().getCurrency());
          System.out.print("Owned Cards: " );
          if (facade.getOwnedCards().size() > 0) {
            for (Card card : facade.getOwnedCards()) {
              System.out.println(card.getName());
            }
          }
          else {
            System.out.println("No cards Owned");
            System.out.println(" ");
          }
                
          // + (facade.user.getOwnedCards().isEmpty() ? "No cards owned." : facade.user.getOwnedCards()));

          // Opening a pack
          System.out.println("Would you like to open a pack?");
          String decision = scanner.nextLine();
          int fail = 1;
          if (decision.equalsIgnoreCase("yes")) {
            fail = 0;
            while (fail == 0) {
              System.out.println("Which Pack would you like to open?");
              int choice = scanner.nextInt();
              decision = scanner.nextLine();
              int count = facade.getOwnedCards().size();

              if (facade.openPack(choice)) {  // Make sure openPack updates the user's card list and returns true if successful
                System.out.println("Opening Pack " + choice);
                System.out.println("Cards Opened by " + facade.getUserName() + " from the pack:");

                for (int i = count; i < facade.getOwnedCards().size(); i++) {
                  System.out.println(facade.getOwnedCards().get(i).getName());
                }
                System.out.println("Would you like to open another?");
                decision = scanner.nextLine();

                if (!decision.equalsIgnoreCase("yes")) {
                  fail = 1;
                }
                    
              } 
              else {
                System.out.println("Failed to open pack, not enough currency");
                break;
              }
            }
  
          }
          
            // Display updated cards right before logging off
          System.out.println("Final check of cards owned by " + facade.getUserName() + " before logging off:");
          for (Card card : facade.getOwnedCards()) {
            System.out.println(card.getName());
          }

          System.out.println("Enter the name of the pokemon you want to search for");
          ArrayList<Card> searchMons = new ArrayList<>();
          searchMons = facade.searchByName(scanner.nextLine());

          if (searchMons.size() != 1) {
            System.out.println("Invalid Name");
            scanner.close();
            System.exit(0);
          }
          System.out.println("Would you like to trade for this card?");
          String answer = scanner.nextLine();
          
          if (answer.equalsIgnoreCase("yes")) {
            System.out.println("Please enter your comment");
            String comment = scanner.nextLine();

            ArrayList<Card> tradeOffer = new ArrayList<Card>();

      while (answer.equalsIgnoreCase("yes")) {
        System.out.println("Please enter the name of 1 pokemon you would like to offer");
        String pokemon = scanner.nextLine();
      
        tradeOffer.add(facade.searchByName(pokemon));
      
        System.out.println("Would you like to add another pokemon?");
        answer = scanner.nextLine();
      }

      
      if (!facade.initiateTrade(tradeOffer, cards.get(0), comment)) {
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

          // Log off the user
          facade.logOffUser();
          System.out.println("User logged off.");
              
        } 
          else {
            System.out.println("User creation failed. (User may already exist or email is invalid)");
          }
      } 
      else {
          System.out.println("User creation failed. (User may already exist or email is invalid)");
      }



/* 

TEST 2
DO THIS AFTER 


      Facade facade2 = new Facade("VrajTPatel", "VrajIsStupid");

      // Print receiving trades
      ArrayList<Trade> receivingTrades = facade2.user.getReceivingTrades();
      printTrades(receivingTrades);

      System.out.println("Enter the number of the trade you want to accept:");
      int tradeNumber = scanner.nextInt();
      int tradeIndex = tradeNumber - 1;
          facade.acceptTrade(tradeIndex);
          System.out.println("Accepted Trade " + tradeNumber + ":");

          if (facade.claimDailyCurrency()) {
            System.out.println("Daily currency claimed.");
            System.out.println("Updated Currency: " + facade.getCurrency());
        } else {
            System.out.println("Failed to claim daily currency.");
        }

      scanner.close();


    facade2.logOffUser();
  }
}

*/


    /* 
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

  */

  }
}



 

