import java.util.*;


public class Trade {
    private User sender;
    private User receiver ;
    private ArrayList<Card> sendersCards;
    private Card recieverCard;
    private boolean isFairTrade;
    private boolean awaitingResponse;
    private boolean wasAccepted;
    private String comment;

    public Trade(User sender, User seller, ArrayList <Card> sendersCards, Card recieverCard, boolean isFairTrade, boolean awaitingResponse, boolean wasAccepted, String comment){
        this.sender = sender;
        this.receiver = seller;
        this.sendersCards = sendersCards;
        this.recieverCard = recieverCard;
        this.isFairTrade = isFairTrade;
        this.awaitingResponse = awaitingResponse;
        this.wasAccepted = wasAccepted;
        this.comment = comment;
    }
 
    public User getSender() {
        return sender;
    }
    
    public User getReceiver() {
        return receiver;
    }


    // THIS NEEDS TO BE REDONE
     
    public boolean isFairTrade() {
       /*  CardList masterCardList = new CardList();
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
        */
        return isFairTrade;
        
      }

    public boolean isAwaitingResponse() {
        return awaitingResponse;
    }
   
    public void setAwaitingResponse(boolean awaitingResponse) {
        this.awaitingResponse = awaitingResponse;
    }
   
    public void acceptTrade() {
        this.wasAccepted = true;
        sender.addCardToList(recieverCard);
        receiver.removeCardFromList(recieverCard);

        for(Card card : sendersCards){
            receiver.addCardToList(card);
            sender.removeCardFromList(card);
        }
    }

    public void rejectTrade(){
        this.wasAccepted = false;
    }

    public String getComment() {
        return comment;
    }

    public boolean wasAccepted() {
        return wasAccepted;
    }
   
    public String getRecieverUserName() {
        return receiver.getUserName();
    }

    public String getSenderUserName() {
        return sender.getUserName();
    }

    public ArrayList<Card> getCardsOffered() {
        return sendersCards;
    }
   
    public Card getRecieverCard() {
        return recieverCard;
    }
   
}
