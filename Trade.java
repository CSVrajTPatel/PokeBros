import java.util.*;


public class Trade {
    private User sender;
    private User receiver ;
    private ArrayList<Card> sendersCards;
    private Card receiverCard;
    private boolean isFairTrade;
    private boolean awaitingResponse;
    private boolean wasAccepted;
    private String comment;
    private double senderCoin;

    public Trade(User sender, User receiver, ArrayList <Card> sendersCards, Card receiverCard, boolean isFairTrade, boolean awaitingResponse, boolean wasAccepted, String comment, double senderCoin){
        this.sender = sender;
        this.receiver = receiver;
        this.sendersCards = sendersCards;
        this.receiverCard = receiverCard;
        this.isFairTrade = isFairTrade;
        this.awaitingResponse = awaitingResponse;
        this.wasAccepted = wasAccepted;
        this.comment = comment;
        this.senderCoin = senderCoin;
    }

    public Trade(User sender, User receiver, ArrayList<Card> sendersCards, Card receiverCard, double senderCoin, String comment) {
        this.sender = sender;
        this.receiver = receiver;
        this.sendersCards = sendersCards;
        this.receiverCard = receiverCard;
        this.senderCoin = senderCoin;
        this.comment = comment;
        isFairTrade = isFairTrade();
        awaitingResponse = true;

    }
 
    public User getSender() {
        return sender;
    }
    
    public User getReceiver() {
        return receiver;
    }


    // THIS NEEDS TO BE REDONE
     
    public boolean isFairTrade() {
       
        double senderCardValue = senderCoin;
        for(int i = 0; i < sendersCards.size(); i++){
            senderCardValue += sendersCards.get(i).getValue();
        }
        // if the cumulative value of the cards is within `0%
        // otherwise the trade is false
        if (receiverCard.getValue() / senderCardValue >= 0.9 && receiverCard.getValue() / senderCardValue <= 1.1) {
            isFairTrade = true;
            return isFairTrade;
        }
        isFairTrade = false;
        return isFairTrade;
            
        
        
      }

    public boolean isAwaitingResponse() {
        return awaitingResponse;
    }
   
    public void setAwaitingResponse(boolean awaitingResponse) {
        this.awaitingResponse = awaitingResponse;
    }
   
    public boolean acceptTrade() {
        if (awaitingResponse = false) {
            return false;
        }
        this.wasAccepted = true;
        sender.addCardToList(receiverCard);
        receiver.removeCardFromList(receiverCard);

        for(Card card : sendersCards){
            receiver.addCardToList(card);
            sender.removeCardFromList(card);
            //  DataWriter.updateUsers(UserList.getUserList());
        }
        awaitingResponse = false;
        return true;
    }

    public boolean rejectTrade(){
        if (awaitingResponse = true) {
            awaitingResponse = false;
            return true;
        }
        return false;
    }

    public String getComment() {
        return comment;
    }

    // Not Needed I think
    public boolean wasAccepted() {
        return wasAccepted;
    }

    public ArrayList<Card> getCardsOffered() {
        return sendersCards;
    }
   
    public Card getreceiverCard() {
        return receiverCard;
    }
   
    public double getSenderCoin() {
        return senderCoin;
    }
}
