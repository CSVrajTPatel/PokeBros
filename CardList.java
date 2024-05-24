import java.util.ArrayList;

public class CardList {
    public ArrayList<Card> cardList;

    public CardList() {
        this.cardList = new ArrayList<>();
    }

    public ArrayList<Card> getCardList() {
        return cardList;
    }

    public boolean addCardToList(Card card) {
        return cardList.add(card);
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

    public ArrayList<Card> searchByType(String type) {
        ArrayList<Card> result = new ArrayList<>();
        for (Card card : cardList) {
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
}
