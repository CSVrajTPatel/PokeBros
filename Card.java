import java.util.ArrayList;
/*
 * Represents a Card.
 */
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
/*
 * Default constructor for the card class.
 */
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
    /**
     * Constructs a Card with specified attributes.
     * @param id The ID of the card pokeDex number.
     * @param name The name of the pokemon card.
     * @param type The pokemon type.
     * @param rarity The rarity of the card.
     * @param pack The pack number associated with the card.
     * @param hp The health points of the card.
     * @param value The value of the card.
     * @param evoStage The evo stage of the card.
     * @param family The family of the card.
     * @param attacks The attacks of the card.
     * 
     */
    public Card(int id, String name, String type, String rarity, int pack, int hp, double value, int evoStage, ArrayList<Integer> family, ArrayList<String> attacks) {
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
    /**
     * Gets the ID of the card.
     * 
     * @return The ID of the card.
     * issue #79
     * 
     */
    public int getId() {
        return id;
    }
    
    /**
     * Sets the ID of the card.
     * 
     * @param id The new ID of the card.
     * issue #79
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the card.
     * 
     * @return The name of the card.
     * issue #73
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the card.
     * 
     * @param name The new name of the card.
     * issue #73
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the type of the card.
     * 
     * @return The type of the card.
     * issue #83
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the card.
     * 
     * @param type The new type of the card.
     * issue #83
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the rarity of the card.
     * 
     * @return The rarity of the card.
     * issue #84
     */
    public String getRarity() {
        return rarity;
    }

    /**
     * Sets the rarity of the card.
     * 
     * @param rarity The new rarity of the card.
     * issue #84
     */
    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    /**
     * Gets the pack number of the card.
     * 
     * @return The pack number of the card.
     * issue #69
     */
    public int getPack() {
        return pack;
    }

    /**
     * Sets the pack number of the card.
     * 
     * @param pack The new pack number of the card.
     * issue #69
     */
    public void setPack(int pack) {
        this.pack = pack;
    }

    /**
     * Gets the health points of the card.
     * 
     * @return The health points of the card.
     * issue #80
     */
    public int getHp() {
        return hp;
    }

    /**
     * Sets the health points of the card.
     * 
     * @param hp The new health points of the card.
     * issue #80
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * Gets the value of the card.
     * 
     * @return The value of the card.
     * issue #81
     */
    public double getValue() {
        return value;
    }

    /**
     * Sets the value of the card.
     * 
     * @param value The new value of the card.
     * issue #81
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * Gets the evolution stage of the card.
     * 
     * @return The evolution stage of the card.
     * issue #86
     */
    public int getEvoStage() {
        return evoStage;
    }

    /**
     * Sets the evolution stage of the card.
     * 
     * @param evoStage The new evolution stage of the card.
     * issue #86
     */
    public void setEvoStage(int evoStage) {
        this.evoStage = evoStage;
    }

    /**
     * Gets the family of the card.
     * 
     * @return The family of the card.
     */
    public ArrayList<Integer> getFamily() {
        return family;
    }

    /**
     * Sets the family of the card.
     * 
     * @param family The new family of the card.
     */
    public void setFamily(ArrayList<Integer> family) {
        this.family = family;
    }

    /**
     * Gets the attacks of the card.
     * 
     * @return The attacks of the card.
     */
    public ArrayList<String> getAttacks() {
        return attacks;
    }

    /**
     * Sets the attacks of the card.
     * 
     * @param attacks The new attacks of the card.
     */
    public void setAttacks(ArrayList<String> attacks) {
        this.attacks = attacks;
    }
}
