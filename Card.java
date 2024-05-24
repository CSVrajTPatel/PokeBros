import java.util.ArrayList;

public class Card {
    private int id;
    private String name;
    private String type;
    private String rarity;
    private int pack;
    private int hp;
    private double value;
    private int evoStage;
    private ArrayList<Integer> family;
    private ArrayList<String> attacks;

    public Card() { 
        id = 0;
        name = "wow";
        type = "dang";
        rarity = "super";
        pack = 3;
        hp = 100;
        value = 10.4;
        evoStage = 1;
        family = new ArrayList<Integer>();
        attacks = new ArrayList<String>();
    }

    public Card(int id, String name, String type, String rarity, int pack, int hp, double value, int evoStage, ArrayList<Integer> family, ArrayList<String> attacks) {
        //VP initialize Card objects 
        this.id = id;
        this.name = name;
        this.type = type;
        this.rarity = rarity;
        this.pack = pack;
        this.hp = hp;
        this.value = value;
        this.evoStage = evoStage;
        this.family = family;
        this.attacks = attacks;
    }

    //VP getters and setters for Card attributes
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getPack() {
        return pack;
    }

    public void setPack(int pack) {
        this.pack = pack;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getEvoStage() {
        return evoStage;
    }

    public void setEvoStage(int evoStage) {
        this.evoStage = evoStage;
    }

    public ArrayList<Integer> getFamily() {
        return family;
    }

    public void setFamily(ArrayList<Integer> family) {
        this.family = family;
    }

    public ArrayList<String> getAttacks() {
        return attacks;
    }

    public void setAttacks(ArrayList<String> attacks) {
        this.attacks = attacks;
    }
}
