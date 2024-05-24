import java.util.ArrayList;

public class CardList {
    public ArrayList<Card> cardList;

    /* 
    public CardList() {
        cardList = new ArrayList<Card>();
        for (int i = 0; i < 151; i++) {
            int id = ;
            String name = ;
            String type = ;
            String rarity = ;
            int pack = ;
            int hp = ;
            double value = ;
            int evoStage = ;
            ArrayList<Integer> family = new ArrayList<Integer>();
            ArrayList<String> attacks = new ArrayList<String>();
            cardList.set(1, new Card(id, name, type, rarity, pack, hp, value, evoStage, family, attacks));
        }
    }
    */

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
