import java.util.*;

public class User extends UserList{

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


    public User(String firstName, String lastName, String email, String userName, String password) {
        // for time last currency intialization, use Package java.time
        // 

        uuid = UUID.randomUUID(); 
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        currency = 0;
        timeLastCurrency = 0;
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

    public boolean editFirstName(String newName) {
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

    public boolean tradeCards(Trade tradeDetails){ // need json access
        return true;
    }

    public boolean purchasePack() { // doing soon
        return true;
    }

    public boolean claimDailyCurrency() { 
        if (timeLastCurrency != 0)
            return false;
        currency += 20;
        return true;
    }

    public ArrayList<Trade> viewTradeOffers() { // need json access
        return new ArrayList<Trade>();
    }

    public ArrayList<Trade> viewPendingTradeRequests() { // need json access
        return new ArrayList<Trade>();
    }

    public boolean initiateTrade(User tradee, ArrayList<Card> offers, Card want) {

        return true;
    }

    public ArrayList<Card> searchCards(String criteria) { // I don't think we need this either
        return new ArrayList<Card>();
    }

    public void getCardDetails(Card card) { // I don't think we need this
        
        return;
    }

    public ArrayList<User> findUsersWithCard(Card card) { // need json access
        return new ArrayList<User>();
    }

    public void addCurrencyAmount(double amount) {
        currency = currency + amount;
        return;
    }

    public void subCurrencyAmount(double amount) {
        currency = currency - amount;
        return;
    }

    public double getCurrencyAmount() {
        return currency;
    }

    public int getTimeLastCurrency(){
        return 0;
    }
}