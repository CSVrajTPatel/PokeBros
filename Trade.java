import java.util.ArrayList;
import java.lang.Math;

public class Trade {
    private String buyerUserName;
    private String sellerUserName;
    private ArrayList<Integer> cardsOffered;
    private ArrayList<Integer> cardsRequested;
    private boolean isFairTrade;
    private boolean awaitingResponse;
    private boolean wasAccepted;
    private String comment;

    public Trade(String buyerUserName, String sellerUserName, ArrayList<Integer> cardsOffered, ArrayList<Integer> cardsRequested, boolean isFairTrade, boolean awaitingResponse, boolean wasAccepted, String comment) {
        // VP Constructor to initialize Trade object
        this.buyerUserName = buyerUserName;
        this.sellerUserName = sellerUserName;
        this.cardsOffered = cardsOffered;
        this.cardsRequested = cardsRequested;
        this.isFairTrade = isFairTrade;
        this.awaitingResponse = awaitingResponse;
        this.wasAccepted = wasAccepted;
        this.comment = comment;
    }

    // VP Getters and setters for Trade attributes
    public String getBuyerUserName() {
        return buyerUserName;
    }

    public void setBuyerUserName(String buyerUserName) {
        this.buyerUserName = buyerUserName;
    }

    public String getSellerUserName() {
        return sellerUserName;
    }

    public void setSellerUserName(String sellerUserName) {
        this.sellerUserName = sellerUserName;
    }

    public ArrayList<Integer> getCardsOffered() {
        return cardsOffered;
    }

    public void setCardsOffered(ArrayList<Integer> cardsOffered) {
        this.cardsOffered = cardsOffered;
    }

    public ArrayList<Integer> getCardsRequested() {
        return cardsRequested;
    }

    public void setCardsRequested(ArrayList<Integer> cardsRequested) {
        this.cardsRequested = cardsRequested;
    }

    public boolean isFairTrade() {
      CardList masterCardList = new CardList();
      double buyerCardValue = 0;
      double sellerCardValue = 0;
      for(int i = 0; i < cardsOffered.size(); i++){
        buyerCardValue += masterCardList.searchById(cardsOffered.get(i)).getValue();
      }
      for(int i = 0; i < cardsRequested.size(); i++){
        sellerCardValue += masterCardList.searchById(cardsRequested.get(i)).getValue();
      }
      // if the cumulative value of the cards is within 50, the trade is fair
      // otherwise the trade is false
      if ((Math.abs((sellerCardValue - buyerCardValue)) <=50 )){
        isFairTrade = true;
      }
      return isFairTrade;
      
    }

    public void setFairTrade(boolean fairTrade) {
        isFairTrade = fairTrade;
    }

    public boolean isAwaitingResponse() {
        return awaitingResponse;
    }

    public void setAwaitingResponse(boolean awaitingResponse) {
        this.awaitingResponse = awaitingResponse;
    }

    public boolean wasAccepted() {
        return wasAccepted;
    }

    public void setWasAccepted(boolean wasAccepted) {
        this.wasAccepted = wasAccepted;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
