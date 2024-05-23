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

    public boolean editEmail() {
        return true;
    }

    public boolean editFirstName() {
        return true;
    }

    public boolean editLastName() {
        return true;
    }

    public boolean editPassword() {
        return true;
    }

    public boolean addCard(Card card) {
        return true;
    }

    public ArrayList<Card> getCollection() {
        return ownedCards;
    }

    public ArrayList<Card> getFavorites() {
        return favoriteCards;
    }

    public boolean addFavroiteCard() {
        return true;
    }

    public boolean removeFavoriteCard() {
        return true;
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