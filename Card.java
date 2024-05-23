import java.util.ArrayList;

public class Card {
    // Class attributes
    private String name;
    private int evoStage;
    private PokeType type;
    private int id;
    private int hp;
    private double value;
    private int pack;
    private String rarity;
    private String Attacks;
    private ArrayList<Card> Family;

    public Card(String name, int evoStage, PokeType type, int id, int hp, double value, int pack, String rarity, String Attacks, ArrayList Family) {
        this.name = name;
        this.evoStage = evoStage;
        this.type = type;
        this.id = id;
        this.hp = hp;
        this.value = value;
        this.pack = pack;
        this.rarity = rarity;
    
    }


    public Card getCard() {
        return this;
    }

    public String getCardName() {
        return name;
    }

    public ArrayList<Card> getCardFamily() {
        return Family;
    }

    public String getCardType() {
        return type.toString();
    }

    public int getCardPokedexNumber() {
        return id;
    }

    public int getCardHealthPoints() {
        return hp;
    }

    public int getCardCoinValue() {
        return (int) value;
    }

    public String getCardRarity() {
        return rarity;
    }


    public void buyCard() {

    }

    public void sellCard() {

    }
}