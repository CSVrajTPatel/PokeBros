import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {
    private static final String CARDS_FILE_PATH = "json/cards.json";
    private static final String USERS_FILE_PATH = "json/users.json";
    private static final String TRADES_FILE_PATH = "json/trades.json";

    public static List<Card> loadCards() {
        List<Card> cards = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(CARDS_FILE_PATH)) {
            JSONArray cardsArray = (JSONArray) parser.parse(reader);
            for (Object obj : cardsArray) {
                JSONObject cardObject = (JSONObject) obj;
                cards.add(parseCard(cardObject));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return cards;
    }

    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(USERS_FILE_PATH)) {
            JSONArray usersArray = (JSONArray) parser.parse(reader);
            for (Object obj : usersArray) {
                JSONObject userObject = (JSONObject) obj;
                users.add(parseUser(userObject));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static List<Trade> loadTrades() {
        List<Trade> trades = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(TRADES_FILE_PATH)) {
            JSONArray tradesArray = (JSONArray) parser.parse(reader);
            for (Object obj : tradesArray) {
                JSONObject tradeObject = (JSONObject) obj;
                trades.add(parseTrade(tradeObject));
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return trades;
    }

    private static Card parseCard(JSONObject cardObject) {
        int id = ((Long) cardObject.get("id")).intValue();
        String name = (String) cardObject.get("name");
        String type = (String) cardObject.get("type");
        String rarity = (String) cardObject.get("rarity");
        int pack = ((Long) cardObject.get("pack")).intValue();
        int hp = ((Long) cardObject.get("hp")).intValue();
        double value = parseDouble(cardObject.get("value"));
        int evoStage = ((Long) cardObject.get("evoStage")).intValue();

        List<Integer> family = new ArrayList<>();
        if (cardObject.get("family") instanceof JSONArray) {
            JSONArray familyArray = (JSONArray) cardObject.get("family");
            for (Object familyId : familyArray) {
                family.add(((Long) familyId).intValue());
            }
        } else if (cardObject.get("family") instanceof Long) {
            family.add(((Long) cardObject.get("family")).intValue());
        }

        List<String> attacks = new ArrayList<>();
        if (cardObject.get("attacks") instanceof JSONArray) {
            JSONArray attacksArray = (JSONArray) cardObject.get("attacks");
            for (Object attack : attacksArray) {
                attacks.add((String) attack);
            }
        } else if (cardObject.get("attacks") instanceof String) {
            attacks.add((String) cardObject.get("attacks"));
        }

        return new Card(id, name, type, rarity, pack, hp, value, evoStage, family, attacks);
    }

    private static double parseDouble(Object value) {
        if (value instanceof Long) {
            return ((Long) value).doubleValue();
        } else if (value instanceof Double) {
            return (Double) value;
        } else {
            throw new IllegalArgumentException("Unexpected value type: " + value.getClass());
        }
    }

    private static User parseUser(JSONObject userObject) {
        String userName = (String) userObject.get("userName");
        String uniqueIdentifier = (String) userObject.get("uniqueIdentifier");
        String password = (String) userObject.get("password");
        String firstName = (String) userObject.get("firstName");
        String lastName = (String) userObject.get("lastName");
        String email = (String) userObject.get("email");
        double currency = parseDouble(userObject.get("currency"));

        List<Integer> favoriteCards = new ArrayList<>();
        JSONArray favoriteCardsArray = (JSONArray) userObject.get("favoriteCards");
        for (Object cardId : favoriteCardsArray) {
            favoriteCards.add(((Long) cardId).intValue());
        }

        List<Integer> ownedCards = new ArrayList<>();
        JSONArray ownedCardsArray = (JSONArray) userObject.get("ownedCards");
        for (Object cardId : ownedCardsArray) {
            ownedCards.add(((Long) cardId).intValue());
        }

        return new User(userName, uniqueIdentifier, password, firstName, lastName, email, favoriteCards, currency, ownedCards);
    }

    private static Trade parseTrade(JSONObject tradeObject) {
        String buyerUserName = (String) tradeObject.get("buyerUserName");
        String sellerUserName = (String) tradeObject.get("sellerUserName");

        List<Integer> cardsOffered = new ArrayList<>();
        JSONArray cardsOfferedArray = (JSONArray) tradeObject.get("cardsOffered");
        for (Object cardId : cardsOfferedArray) {
            cardsOffered.add(((Long) cardId).intValue());
        }

        List<Integer> cardsRequested = new ArrayList<>();
        JSONArray cardsRequestedArray = (JSONArray) tradeObject.get("cardsRequested");
        for (Object cardId : cardsRequestedArray) {
            cardsRequested.add(((Long) cardId).intValue());
        }

        boolean isFairTrade = (Boolean) tradeObject.get("isFairTrade");
        boolean awaitingResponse = (Boolean) tradeObject.get("awaitingResponse");
        boolean wasAccepted = (Boolean) tradeObject.get("wasAccepted");
        String comment = (String) tradeObject.get("comment");

        return new Trade(buyerUserName, sellerUserName, cardsOffered, cardsRequested, isFairTrade, awaitingResponse, wasAccepted, comment);
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader(CARDS_FILE_PATH))) {
            String line;
            int lineCount = 0;
            while ((line = reader.readLine()) != null && lineCount < 10) {
                System.out.println(line);
                lineCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
