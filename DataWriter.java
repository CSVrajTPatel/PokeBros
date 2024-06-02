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


public class DataWriter {
    private static final String USERS_FILE_PATH = "./json/users.json";
    private static final String TRADES_FILE_PATH = "./json/trades.json";

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void updateUsers(ArrayList<User> users) {
        // Clear the existing users
        JSONArray usersArray = new JSONArray();

        for (User user : users) {
            JSONObject userJson = userToJson(user);
            usersArray.add(userJson);
        }

        // Write the JSONArray to the file, OVERWRITING existing content
        try (FileWriter file = new FileWriter(USERS_FILE_PATH)) {
            file.write(gson.toJson(usersArray));
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
        for (Card card : user.getFavoriteCards()) {
            favoriteCardsArray.add(card.getId());
        }
        userObject.put("favoriteCards", favoriteCardsArray);

        JSONArray ownedCardsArray = new JSONArray();
        for (Card card : user.getOwnedCards()) {
            ownedCardsArray.add(card.getId());
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
        tradeObject.put("receiverUserName", trade.getReceiver().getUserName());
        tradeObject.put("senderUserName", trade.getSender().getUserName());

        JSONArray cardsOfferedArray = new JSONArray();
        for (Card card : trade.getCardsOffered()) {
            cardsOfferedArray.add(card.getId());
        }
        tradeObject.put("cardsOffered", cardsOfferedArray);

        tradeObject.put("cardsRequested", trade.getReceiverCard().getId());

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
    
// Updates accepted trade
public static void updateAcceptedTrade(Trade acceptedTrade) {
    JSONArray tradesArray = readJsonArrayFromFile(TRADES_FILE_PATH);
    if (tradesArray == null) {
        tradesArray = new JSONArray();
    }

    for (int i = 0; i < tradesArray.size(); i++) {
        JSONObject tradeJson = (JSONObject) tradesArray.get(i);
        String senderUserName = (String) tradeJson.get("senderUserName");
        String receiverUserName = (String) tradeJson.get("receiverUserName");

        if (senderUserName.equals(acceptedTrade.getSender().getUserName()) && 
            receiverUserName.equals(acceptedTrade.getReceiver().getUserName())) {
            
            // Update the fields directly
            tradeJson.put("awaitingResponse", false);
            tradeJson.put("wasAccepted", true);
            tradesArray.set(i, tradeJson);
            break;
        }
    }

    // Write the updated trades array back to the file
    try (FileWriter file = new FileWriter(TRADES_FILE_PATH)) {
        file.write(gson.toJson(tradesArray));
        file.flush();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

//Removes NonPendingTrades
    public static void removeNonPendingTrades() {
        JSONArray tradesArray = readJsonArrayFromFile(TRADES_FILE_PATH);
        if (tradesArray == null) {
            return;
        }

        Iterator<JSONObject> iterator = tradesArray.iterator();
        while (iterator.hasNext()) {
            JSONObject tradeJson = iterator.next();
            Boolean awaitingResponse = (Boolean) tradeJson.get("awaitingResponse");
            if (awaitingResponse != null && !awaitingResponse) {
                iterator.remove();
            }
        }

        try (FileWriter file = new FileWriter(TRADES_FILE_PATH)) {
            file.write(gson.toJson(tradesArray));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}