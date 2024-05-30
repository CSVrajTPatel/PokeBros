import java.util.ArrayList;

public class CardList {
    private static CardList masterList;
    private static ArrayList<Card> cardList;

     
    private CardList() {
        cardList = (DataLoader.loadCards());
    }
    
    public static ArrayList<Card> getCardList() {
        if (cardList == null) {
            masterList = new CardList();
        }
        return cardList;
    }

    public static Card searchByName(String name) {
        for (Card card : cardList) {
            if (card.getName().equalsIgnoreCase(name)) {
                return card;
            }
        }
        return null;
    }

    public static ArrayList<Card> searchByName(String name, ArrayList<Card> cards) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getName().equalsIgnoreCase(name)) {
                result.add(card);
            }
        }
        return result;
    }

    public static ArrayList<Card> searchByType(String type) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cardList) {
            if (card.getType().equalsIgnoreCase(type)) {
                result.add(card);
            }
        }
        return result;
    }

    public static ArrayList<Card> searchByType(String type, ArrayList<Card> cards) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getType().equalsIgnoreCase(type)) {
                result.add(card);
            }
        }
        return result;
    }

    public static ArrayList<Card> searchByRarity(String rarity) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cardList) {
            if (card.getRarity().equalsIgnoreCase(rarity)) {
                result.add(card);
            }
        }
        return result;
    }

    public static ArrayList<Card> searchByRarity(String type, ArrayList<Card> cards) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getRarity().equalsIgnoreCase(type)) {
                result.add(card);
            }
        }
        return result;
    }

    public static Card searchById(int id) {
        for (Card card : cardList) {
            if (card.getId() == id) {
                return card;
            }
        }
        return null;
    }

    public static Card searchById(int id, ArrayList<Card> cards) {
        for (Card card : cards) {
            if (card.getId() == id) {
                return card;
            }
        }
        return null; 
    }

    public static ArrayList<Card> searchByPack(int pack) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cardList) {
            if (card.getPack() == pack) {
                result.add(card);
            }
        }
        return result;
    }

    public static ArrayList<Card> searchByPack(int pack, ArrayList<Card> cards) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getPack() == pack) {
                result.add(card);
            }
        }
        return result;
    }
}
