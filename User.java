import java.util.List;
import java.util.UUID;

public class User {
    private String userName;
    private UUID uniqueIdentifier;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private List<Integer> favoriteCards;
    private double currency;
    private List<Integer> ownedCards;

    public User(String userName, String password, String firstName, String lastName, String email, List<Integer> favoriteCards, double currency, List<Integer> ownedCards) {
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

    public List<Integer> getFavoriteCards() {
        return favoriteCards;
    }

    public void setFavoriteCards(List<Integer> favoriteCards) {
        this.favoriteCards = favoriteCards;
    }

    public double getCurrency() {
        return currency;
    }

    public void setCurrency(double currency) {
        this.currency = currency;
    }

    public List<Integer> getOwnedCards() {
        return ownedCards;
    }

    public void setOwnedCards(List<Integer> ownedCards) {
        this.ownedCards = ownedCards;
    }
}
