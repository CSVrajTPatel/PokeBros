import java.util.Scanner;

import java.util.*;
public class Trade {
    
    private User seller;
    private User buyer;
    private ArrayList <Card> cardsRequested;
    private boolean isFairTrade;
    private boolean awaitingResponse;
    private boolean wasAccepted;
    private String comments;


    public Trade(){
        this.tradee = seller;
        this.trader = buyer;
        this.isFairTrade = isFairTrade;
        this.awaitingRespones = awaitingResponse;
        this.wasAccepted = wasAccepted;
        this.comments = comment;
    }

    public Trade(User buyer, User seller, Card Wanted){
    
    }

    public void getisFairTrade(){

    }

    public boolean getisAwaitingResponse(){
       return this.isAwaitingResponse;
    }

    public boolean getWasAccepted(){
        return wasAccepted;
    }

    public User getTrader(){
        this.user = seller;
    }
    public User getTradee(){
        this.user = buyer;
     
    }

    public boolean acceptTrade(){
        this.awatingingResponse = false;
        this.wasAccepted = true;
    }

    public boolean rejectTrade(){
        this.awatingRespone = false;
        this.wasAccepted = false;
    }

    public boolean makeOffer(){

        return true;
    }

    public String getComment(){
        Scanner scanner = new Scanner(System.in);
        String comment = scanner.nextLine();
        return comment;
    }

    public String setComment(String comment){
        this.comment = comment;
    }

    public boolean proposeTrade(){

        return true;
    }

    public boolean addCardToTrade(){
        return true;
    }

    public boolean removeCardFromeTrade(){

        return true;
    }
    public boolean setBuyer(User target){

        return true;
    }

    public boolean setSeller(User){

        return true;
    }
    public boolean removeTradee(){
        this.seller = null;
        return true;
    }
}
