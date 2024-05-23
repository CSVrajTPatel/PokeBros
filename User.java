import java.util.*;

public class User {

    private String userName;

    private UUID uuid; 

    private String password;

    private String firstName;

    private String lastName;

    private String email;
    
    private ArrayList<Card> favoriteCards;

    private double currency;

    private ArrayList<Card> ownedCards;
    
    private int timeLastCurrency;


    public void createAccount(String firstName, String lastName, String email, String userName, String password) {
        // for time last currency intialization, use Package java.time
        // 
        return;
    }

    public UUID getUUID() {
        return uuid;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean editEmail(String newEmail) {
        if (newEmail != email) {
            email = newEmail;
            return true;
        }
        return false;
        
    }

    public boolean editFirstName(Strine newName) {
        if (newName != firstName) {
            firstName = newName;
            return true;
        }
        return false;
    }

    public boolean editLastName(String newName) {
        if (newName != lastName) {
            lastName = newName;
            return true;
        }
        return false;
    }

    public boolean editPassword(String newPass) {
        if (newPass != password) {
            newPass = password;
            return true;
        }
        return false;
    }

    public void addCard(Card card) {
        ownedCards.add(card);
        return;
    }

    public ArrayList<Card> getCollection() {
        return ownedCards;
    }

    public ArrayList<Card> getFavorites() {
        return favoriteCards;
    }

    public boolean addFavroiteCard(Card favCard) {
        for (Card card : favoriteCards){
            if (favCard == card)
                return false;
        }
        favoriteCards.add(favCard);
        return true;
    }

    public boolean removeFavoriteCard(Card badCard) {
        for (Card card : favoriteCards){
            if (badCard == card) {
                favoriteCards.remove(badCard);
                return true;
            }
        }
        return false;
    }

    public boolean tradeCards(Trade tradeDetails) {
        return true;
    }

    public boolean purchasePack() {
        return true;
    }

    public boolean claimDailyCurrency() {
        return true;
    }

    public ArrayList<Trade> viewTradeOffers() {
        return new ArrayList<Trade>();
    }

    public ArrayList<Trade> viewPendingTradeRequests() {
        return new ArrayList<Trade>();
    }

    public boolean initiateTrade(User user, Card card) {
        return true;
    }

    public ArrayList<Card> searchCards(String criteria) {
        return new ArrayList<Card>();
    }

    public boolean viewCardDetails(Card card) {
        return true;
    }

    public ArrayList<User> findUsersWithCard(Card card) {
        return new ArrayList<User>();
    }

    public void addCurrencyAmount(double amount) {
        return;
    }

    public void subCurrencyAmount(double amount) {
        return;
    }

    public double getCurrencyAmount() {
        return currency;
    }
    public int getTimeLastCurrency(){
        return 0;
    }
}