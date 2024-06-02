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

        // WRITES TO LOADER HERE
    }
 
    public User getSender() {
        return sender;
    }
    
    public User getReceiver() {
        return receiver;
    }

     
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

    public static boolean acceptTrade(User receiver, int tradeIndex) {
        ArrayList<Trade> receivingTrades = receiver.getReceivingTrades();
        if (tradeIndex < 0 || tradeIndex >= receivingTrades.size()) {
            return false;
        }
        Trade tradeToAccept = receivingTrades.get(tradeIndex);
        if (!tradeToAccept.awaitingResponse) {
            return false;
        }
        tradeToAccept.wasAccepted = true;
        tradeToAccept.awaitingResponse = false;
        
        tradeToAccept.sender.addCardToList(tradeToAccept.receiverCard);
        tradeToAccept.receiver.removeCardFromList(tradeToAccept.receiverCard);

        for (Card card : tradeToAccept.sendersCards) {
            tradeToAccept.receiver.addCardToList(card);
            tradeToAccept.sender.removeCardFromList(card);
        }
        
        DataWriter.updateAcceptedTrade(tradeToAccept);
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

    public boolean wasAccepted() {
        return wasAccepted;
    }

    public ArrayList<Card> getCardsOffered() {
        return sendersCards;
    }
   
    public Card getReceiverCard() {
        return receiverCard;
    }
   
    public double getSenderCoin() {
        return senderCoin;
    }
}
