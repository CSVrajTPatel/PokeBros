import java.util.ArrayList;

public class CardList {
    public ArrayList<Card> cardList;

     
    public CardList() {
        cardList = (DataLoader.loadCards());
    }
    
    public ArrayList<Card> getCardList() {
        return cardList;
    }

    public ArrayList<Card> searchByName(String name) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cardList) {
            if (card.getName().equalsIgnoreCase(name)) {
                result.add(card);
            }
        }
        return result;
    }

    public ArrayList<Card> searchByName(String name, ArrayList<Card> cards) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getName().equalsIgnoreCase(name)) {
                result.add(card);
            }
        }
        return result;
    }

    public ArrayList<Card> searchByType(String type) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cardList) {
            if (card.getType().equalsIgnoreCase(type)) {
                result.add(card);
            }
        }
        return result;
    }

    public ArrayList<Card> searchByType(String type, ArrayList<Card> cards) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getType().equalsIgnoreCase(type)) {
                result.add(card);
            }
        }
        return result;
    }

    public ArrayList<Card> searchByRarity(String rarity) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cardList) {
            if (card.getRarity().equalsIgnoreCase(rarity)) {
                result.add(card);
            }
        }
        return result;
    }

    public Card searchById(int id) {
        for (Card card : cardList) {
            if (card.getId() == id) {
                return card;
            }
        }
        return null;
    }

    public Card searchById(int id, ArrayList<Card> cards) {
        for (Card card : cards) {
            if (card.getId() == id) {
                return card;
            }
        }
        return null; 
    }

    public ArrayList<Card> searchByPack(int pack) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cardList) {
            if (card.getPack() == pack) {
                result.add(card);
            }
        }
        return result;
    }

    public ArrayList<Card> searchByPack(int pack, ArrayList<Card> cards) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cards) {
            if (card.getPack() == pack) {
                result.add(card);
            }
        }
        return result;
    }
}
