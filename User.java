import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;

public class User {
    private String userName;
    private UUID uniqueIdentifier;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private ArrayList<Integer> favoriteCards;
    private double currency;
    private ArrayList<Integer> ownedCards;
    private Instant lastClaimedCurrencyTime;

    public User(String userName, String password, String firstName, String lastName, String email, ArrayList<Integer> favoriteCards, double currency, ArrayList<Integer> ownedCards) {
        // VP Constructor to initialize User object
        this.userName = userName;
        uniqueIdentifier = UUID.randomUUID(); 
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.favoriteCards = favoriteCards;
        this.currency = currency;
        this.ownedCards = ownedCards;
        this.lastClaimedCurrencyTime = Instant.now();
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

    public ArrayList<Integer> getFavoriteCards() {
        return favoriteCards;
    }

    public void setFavoriteCards(ArrayList<Integer> favoriteCards) {
        this.favoriteCards = favoriteCards;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency += currency;
    }

    public ArrayList<Integer> getOwnedCards() {
        return ownedCards;
    }

    public Instant getLastClaimedCurrencyTime(){
      return lastClaimedCurrencyTime;
    }

    public void setLastClaimedCurrencyTime(Instant inst){
      // need to write to the user file
      lastClaimedCurrencyTime = inst;
    }

    public void addCardToList(Card card) {
        ownedCards.add(card.getId());
    }
}
