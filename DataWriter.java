import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Iterator;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class DataWriter {
    private static final String USERS_FILE_PATH = "./json/users.json";
    private static final String TRADES_FILE_PATH = "./json/trades.json";

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void updateUsers(ArrayList<User> users) {
        JSONArray existingUsersArray = readJsonArrayFromFile(USERS_FILE_PATH);
        if (existingUsersArray == null) {
            existingUsersArray = new JSONArray();
        }

        for (User user : users) {
            JSONObject userJson = userToJson(user);
            existingUsersArray.add(userJson);
        }

        try (FileWriter file = new FileWriter(USERS_FILE_PATH)) {
            file.write(gson.toJson(existingUsersArray));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateTrades(ArrayList<Trade> trades) {
        JSONArray existingTradesArray = readJsonArrayFromFile(TRADES_FILE_PATH);
        if (existingTradesArray == null) {
            existingTradesArray = new JSONArray();
        }

        for (Trade trade : trades) {
            JSONObject tradeJson = tradeToJson(trade);
            existingTradesArray.add(tradeJson);
        }

        try (FileWriter file = new FileWriter(TRADES_FILE_PATH)) {
            file.write(gson.toJson(existingTradesArray));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static JSONObject userToJson(User user) {
        JSONObject userObject = new JSONObject();
        userObject.put("userName", user.getUserName());
        userObject.put("uniqueIdentifier", user.getUniqueIdentifier().toString());
        userObject.put("password", user.getPassword());
        userObject.put("firstName", user.getFirstName());
        userObject.put("lastName", user.getLastName());
        userObject.put("email", user.getEmail());
        userObject.put("currency", user.getCurrency());
        userObject.put("lastClaimedCurrencyTime", user.getLastClaimedCurrencyTime().toString());

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

    private static String getStringValue(JSONObject jsonObject, String key) {
      Object value = jsonObject.get(key);
      return value != null ? value.toString() : "";
  }
    
    private static void removeUser(String targetUserName) {
      JSONArray existingUsersArray = readJsonArrayFromFile(USERS_FILE_PATH);
      Iterator<JSONObject> iterator = existingUsersArray.iterator();
      while (iterator.hasNext()) {
          JSONObject userJson = iterator.next();
          if (getStringValue(userJson, "userName").equals(targetUserName)) {
            System.out.println("found the target and removed it \n");
              iterator.remove();
  
          }
  }
    try (FileWriter file = new FileWriter(USERS_FILE_PATH)) {
      file.write(gson.toJson(existingUsersArray));
      file.flush();
    } catch (IOException e) {
        e.printStackTrace();
      }
    }

    /**
     * Convert a Trade object to a JSONObject.
     * @param trade Trade object to convert.
     * @return JSONObject representation of the trade.
     */
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

    private static JSONArray readJsonArrayFromFile(String filePath) {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            Object obj = jsonParser.parse(reader);
            return (JSONArray) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Tofu", "PSSS", "Vraj", "Patel", "john.LOLOLOLOL@example.com", new ArrayList<>(Arrays.asList(1, 4, 7)), 1000.0, new ArrayList<>(Arrays.asList(1, 2, 3))));
        User testforDeletion = new User("Tofu2", "PSSS", "Vraj", "Patel", "john.LOLOLOLOL@example.com", new ArrayList<>(Arrays.asList(1, 4, 7)), 1000.0, new ArrayList<>(Arrays.asList(1, 2, 3)));
        users.add(testforDeletion);
        updateUsers(users);
       //updateUsers(users);
        removeUser("Tofu2");
       

        ArrayList<Trade> trades = new ArrayList<>();
        trades.add(new Trade("Vraj", "Ash", new ArrayList<>(Arrays.asList(1, 2)), new ArrayList<>(Arrays.asList(3, 4)), true, false, true, "Scammer Gets Scammed"));
        updateTrades(trades);

        System.out.println("Data written to files.");
    }
}
