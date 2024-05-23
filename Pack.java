import java.util.ArrayList;

public class Pack {
    
    private String name;
    private int price;
    private ArrayList<Card> cards;
    private int numberOfRares;
    
    public ArrayList<String> openPack(String cards) {
        return new ArrayList<String>();
    }

    public ArrayList<Card> getCardList() {
        return cards;
    }

    public boolean buyPack(int packType) {
        return true;

    }
    public double getPackPrice(){
        return price;
    }
}
