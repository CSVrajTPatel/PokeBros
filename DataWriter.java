import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class DataWriter {
    private static final String USERS_FILE_PATH = "json/users.json";
    private static final String TRADES_FILE_PATH = "json/trades.json";

    public static void updateUsers(List<User> users) {
        try {
            // Read existing users
            JSONParser parser = new JSONParser();
            JSONArray usersArray;

            try (FileReader reader = new FileReader(USERS_FILE_PATH)) {
                usersArray = (JSONArray) parser.parse(reader);
            } catch (IOException | ParseException e) {
                usersArray = new JSONArray();
            }

            // Add new users
            for (User user : users) {
                JSONObject userJson = userToJson(user);
                usersArray.add(userJson);
            }

            // Write updated users to file
            try (FileWriter file = new FileWriter(USERS_FILE_PATH)) {
                file.write(usersArray.toJSONString());
                file.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateTrades(List<Trade> trades) {
        try {
            // Read existing trades
            JSONParser parser = new JSONParser();
            JSONArray tradesArray;

            try (FileReader reader = new FileReader(TRADES_FILE_PATH)) {
                tradesArray = (JSONArray) parser.parse(reader);
            } catch (IOException | ParseException e) {
                tradesArray = new JSONArray();
            }

            // Add new trades
            for (Trade trade : trades) {
                JSONObject tradeJson = tradeToJson(trade);
                tradesArray.add(tradeJson);
            }

            // Write updated trades to file
            try (FileWriter file = new FileWriter(TRADES_FILE_PATH)) {
                file.write(tradesArray.toJSONString());
                file.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject userToJson(User user) {
        JSONObject userObject = new JSONObject();
        userObject.put("userName", user.getUserName());
        userObject.put("uniqueIdentifier", user.getUniqueIdentifier());
        userObject.put("password", user.getPassword());
        userObject.put("firstName", user.getFirstName());
        userObject.put("lastName", user.getLastName());
        userObject.put("email", user.getEmail());
        userObject.put("currency", user.getCurrency());

        JSONArray favoriteCardsArray = new JSONArray();
        for (Integer cardId : user.getFavoriteCards()) {
            favoriteCardsArray.add(cardId);
        }
        userObject.put("favoriteCards", favoriteCardsArray);

        JSONArray ownedCardsArray = new JSONArray();
        for (Integer cardId : user.getOwnedCards()) {
            ownedCardsArray.add(cardId);
        }
        userObject.put("ownedCards", ownedCardsArray);

        return userObject;
    }

    private static JSONObject tradeToJson(Trade trade) {
        JSONObject tradeObject = new JSONObject();
        tradeObject.put("buyerUserName", trade.getBuyerUserName());
        tradeObject.put("sellerUserName", trade.getSellerUserName());

        JSONArray cardsOfferedArray = new JSONArray();
        for (Integer cardId : trade.getCardsOffered()) {
            cardsOfferedArray.add(cardId);
        }
        tradeObject.put("cardsOffered", cardsOfferedArray);

        JSONArray cardsRequestedArray = new JSONArray();
        for (Integer cardId : trade.getCardsRequested()) {
            cardsRequestedArray.add(cardId);
        }
        tradeObject.put("cardsRequested", cardsRequestedArray);

        tradeObject.put("isFairTrade", trade.isFairTrade());
        tradeObject.put("awaitingResponse", trade.isAwaitingResponse());
        tradeObject.put("wasAccepted", trade.wasAccepted());
        tradeObject.put("comment", trade.getComment());

        return tradeObject;
    }

    public static void main(String[] args) {
        // Hardcoded addition of a new user
        User newUser = new User("Brock", "password", "Brock", "Harrison", "brock@example.com", Arrays.asList(1, 4, 7), 300.0, Arrays.asList(7, 8, 9));
        updateUsers(Arrays.asList(newUser));

        // Hardcoded addition of a new trade
        Trade newTrade = new Trade("Brock", "Misty", Arrays.asList(7, 8, 9), Arrays.asList(10, 11, 12), true, false, true, "Smooth trade!");
        updateTrades(Arrays.asList(newTrade));

        System.out.println("Data written to files.");
    }
}
