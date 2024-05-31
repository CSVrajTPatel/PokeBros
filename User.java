import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String userName;
    private UUID uniqueIdentifier;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<Card> favoriteCards;
    private double currency;
    private ArrayList<Card> ownedCards;
    private Instant lastClaimedCurrencyTime;
    private ArrayList<Trade> sendingTrades = new ArrayList<Trade>();
    private ArrayList<Trade> receivingTrades = new ArrayList<Trade>();

    public User(String userName, String password, String firstName, String lastName, String email, ArrayList<Card> favoriteCards, double currency, ArrayList<Card> ownedCards) {
        // VP Constructor to initialize User object
        this.userName = userName;
        this.uniqueIdentifier = UUID.randomUUID();
//        uniqueIdentifier = UUID.randomUUID(); 
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.favoriteCards = favoriteCards;
        this.currency = currency;
        this.ownedCards = ownedCards;
        this.lastClaimedCurrencyTime = Instant.now();
    }

    public User(String userName, String password, String firstName, String lastName, String email) {
        this(userName, password, firstName, lastName, email, new ArrayList<>(), 50, new ArrayList<>());
    }

    // VP Getters and setters for User attributes
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public UUID getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Card> getFavoriteCards() {
        return favoriteCards;
    }

    public void setFavoriteCards(ArrayList<Card> favoriteCards) {
        this.favoriteCards = favoriteCards;
    }

    public boolean addFavoriteCard(Card card) {
        for (Card favCard : favoriteCards) {
            if (card == favCard) {
                return false;
            }
        }
        favoriteCards.add(card);
        return true;
    }

    public double getCurrency() {
        return currency;
    }

    public void addCurrency(double currency) {
        this.currency += currency;
    }

    public ArrayList<Card> getOwnedCards() {
        return ownedCards;
    }

    public Instant getLastClaimedCurrencyTime(){
      return lastClaimedCurrencyTime;
    }

    public void setLastClaimedCurrencyTime(Instant lastClaimedCurrencyTime) {
        this.lastClaimedCurrencyTime = lastClaimedCurrencyTime;
    }

    public void addCardToList(Card card) {
        ownedCards.add(card);
    }

    public void removeCardFromList(Card card){
        ownedCards.remove(card);
    }

    public boolean openPack(int pack) {
        if (currency >= 10) {
            Pack newPack = new Pack(pack);
            ArrayList<Card> packList = newPack.openPack();
            for (Card card : packList) {
                ownedCards.add(card);
            }
            return true;
        }
        return false;
    }
    
    public ArrayList<Trade> getPendingTrades() {
        return new ArrayList<Trade>();
    }
    
    public ArrayList<Trade> getTradeHistory() {
        return new ArrayList<Trade>();
    }

    public boolean claimDailyCurrency() {
        Instant currentTime = Instant.now();
        Duration timeBetween = Duration.between(lastClaimedCurrencyTime, currentTime);
    
        if (timeBetween.toDays() >= 1) {
            addCurrency(25);
            setLastClaimedCurrencyTime(currentTime);
            UserList.getInstance().saveUsers(); // Save the updated user data
            return true;
        }
        return false;
    }

    public void addSendingTrade(Trade trade) {
        sendingTrades.add(trade);
    }

    public void addReceivingTrade(Trade trade) {
        sendingTrades.add(trade);
    }
}
