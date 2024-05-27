import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataWriter {
    // Paths to the JSON files for users and trades
    private static final String USERS_FILE_PATH = "json/users.json";
    private static final String TRADES_FILE_PATH = "json/trades.json";

    // Method to update the users in the JSON file
    public static void updateUsers(ArrayList<User> users) {
        try {
            // Read existing users from the JSON file
            JSONParser parser = new JSONParser();
            JSONArray usersArray;

            try (FileReader reader = new FileReader(USERS_FILE_PATH)) {
                usersArray = (JSONArray) parser.parse(reader);
            } catch (IOException | ParseException e) {
                usersArray = new JSONArray();
            }

            // Add new users to the JSON array
            for (User user : users) {
                JSONObject userJson = userToJson(user);
                usersArray.add(userJson);
            }

            // Write the updated JSON array to the file
            try (FileWriter file = new FileWriter(USERS_FILE_PATH)) {
                file.write(usersArray.toJSONString());
                file.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to update the trades in the JSON file
    public static void updateTrades(ArrayList<Trade> trades) {
        try {
            // Read existing trades from the JSON file
            JSONParser parser = new JSONParser();
            JSONArray tradesArray;

            try (FileReader reader = new FileReader(TRADES_FILE_PATH)) {
                tradesArray = (JSONArray) parser.parse(reader);
            } catch (IOException | ParseException e) {
                tradesArray = new JSONArray();
            }

            // Add new trades to the JSON array
            for (Trade trade : trades) {
                JSONObject tradeJson = tradeToJson(trade);
                tradesArray.add(tradeJson);
            }

            // Write the updated JSON array to the file
            try (FileWriter file = new FileWriter(TRADES_FILE_PATH)) {
                file.write(tradesArray.toJSONString());
                file.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert a User object to a JSONObject
    private static JSONObject userToJson(User user) {
        JSONObject userObject = new JSONObject();
        userObject.put("userName", user.getUserName());
        userObject.put("uniqueIdentifier", user.getUniqueIdentifier().toString());
        userObject.put("password", user.getPassword());
        userObject.put("firstName", user.getFirstName());
        userObject.put("lastName", user.getLastName());
        userObject.put("email", user.getEmail());
        userObject.put("currency", user.getCurrency());

        // Convert favorite cards list to a JSON array
        JSONArray favoriteCardsArray = new JSONArray();
        for (Integer cardId : user.getFavoriteCards()) {
            favoriteCardsArray.add(cardId);
        }
        userObject.put("favoriteCards", favoriteCardsArray);

        // Convert owned cards list to a JSON array
        JSONArray ownedCardsArray = new JSONArray();
        for (Integer cardId : user.getOwnedCards()) {
            ownedCardsArray.add(cardId);
        }
        userObject.put("ownedCards", ownedCardsArray);

        return userObject;
    }

    // Helper method to convert a Trade object to a JSONObject
    private static JSONObject tradeToJson(Trade trade) {
        JSONObject tradeObject = new JSONObject();
        tradeObject.put("buyerUserName", trade.getBuyerUserName());
        tradeObject.put("sellerUserName", trade.getSellerUserName());

        // Convert cards offered list to a JSON array
        JSONArray cardsOfferedArray = new JSONArray();
        for (Integer cardId : trade.getCardsOffered()) {
            cardsOfferedArray.add(cardId);
        }
        tradeObject.put("cardsOffered", cardsOfferedArray);

        // Convert cards requested list to a JSON array
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
        //Hardcoded addition of a new user
        //User newUser = new User("Brock", "password", "Brock", "Harrison", "brock@example.com", Arrays.asList(1, 4, 7), 300.0, Arrays.asList(7, 8, 9));
        //updateUsers(Arrays.asList(newUser));
        // Example usage of updating users
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("exampleUserName", "examplePassword", "Vraj", "Patel", "john.doe@example.com", new ArrayList<>(Arrays.asList(1, 4, 7)), 1000.0, new ArrayList<>(Arrays.asList(1, 2, 3))));
        updateUsers(users);

        // Hardcoded addition of a new trade
        //Trade newTrade = new Trade("Brock", "Misty", Arrays.asList(7, 8, 9), Arrays.asList(8,9,10), true, false, true, "Smooth trade!");
      //  updateTrades(Arrays.asList(newTrade));

        System.out.println("Data written to files.");
    }
}

