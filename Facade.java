import java.util.ArrayList;
public class Facade{

  private User user;

  public ArrayList<Card> searchByName(String name){
    return null;
  }

  public ArrayList<Card> searchByType(String filter){
    return null;
 }

  public ArrayList<Card> searchByRarity(String filter){
  return null;
 }  

 public Card searchById(int filter){
  return null;
 }  

 public Card getCard(Card card){
  return card;
 } 

 public double getCurrency(){
  return 0.0;
 } 

 public ArrayList<Card> getCollection(){
  return null;
 }

 public ArrayList<Card> getCardList(){
  return null;
 } 

public ArrayList<Card> viewFamily(Card card){
  return null;
} 

public Boolean initiateTrade(ArrayList<Card> userCards, ArrayList<Card> traderCards, User user, double userCoin, double traderCoin){
  return true;
} 

public void rejectTrade(Trade trade){
} 
public void acceptTrade(Trade trade){

}

public boolean evaluateTrade(Trade trade){
  return true;
}
public ArrayList<Trade> getPastTradeHistory(){
  return null;
}
public ArrayList<Trade> getPendingTrades(){
  return null;
}
public boolean setFavoriiteCard(Card targetCard){
  return true;
} 
public boolean purchasePack(int num){
  return true;
} 
public boolean ClaimDailyCurrency(){
  return true;
}  

}