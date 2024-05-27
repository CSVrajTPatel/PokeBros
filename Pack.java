import java.util.ArrayList;

public class Pack {
    
    private String name;
    private int price;
    private ArrayList<Card> cards;
    private int numberOfRares;
    
    public ArrayList<Integer> openPack(int pack) {
        return new ArrayList<Integer>();
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
