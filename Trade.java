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

    public Trade(User sender, User seller, ArrayList <Card> sendersCards, Card receiverCard, boolean isFairTrade, boolean awaitingResponse, boolean wasAccepted, String comment){
        this.sender = sender;
        this.receiver = seller;
        this.sendersCards = sendersCards;
        this.receiverCard = receiverCard;
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
       
        double senderCardValue = 0;
        for(int i = 0; i < sendersCards.size(); i++){
            senderCardValue += sendersCards.get(i).getValue();
        }
        // if the cumulative value of the cards is within `0%
        // otherwise the trade is false
        if (receiverCard.getValue() / senderCardValue >= 0.9 && receiverCard.getValue() / senderCardValue <= 1.1){
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
   
    public void acceptTrade() {
        this.wasAccepted = true;
        sender.addCardToList(receiverCard);
        receiver.removeCardFromList(receiverCard);

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
   
}
