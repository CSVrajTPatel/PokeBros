import java.util.ArrayList;

public class UserList {
    private static UserList masterList;
    private static ArrayList<User> userList;

    private UserList() {
        userList = DataLoader.loadUsers();
    }

    public static ArrayList<User> getUserList() {
        if (userList == null) {
            masterList = new UserList();
        }
        return userList;
    }

    // Adding a User
    public static boolean addUserToList(String userName, String password, String firstName, String lastName, String email) {
        userList = getUserList();
        // MOVE TO USER CONSTRUCTOR
        // ArrayList<Card> emptyFavoriteCards = new ArrayList<Card>();
        // ArrayList<Card> emptyOwnedCards = new ArrayList<Card>();
        // double initialCurrency = 1000.0;

        // ERROR CHECK LIKE DUPES OR VALID EMAIL HERE
        // User newUser = new User(userName, password, firstName, lastName, email, emptyFavoriteCards, initialCurrency, emptyOwnedCards);
        // userList.add(newUser);

        // If we are writing all the time it will be expensive on memory
        // 
        // DataWriter.updateUsers(userList);

        return true;

    }

    public static User loginUser(String userName, String password) {
        userList = getUserList();
        for (User user : userList) {
            if (user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equals(password)) {
                return user;  // Login successful
            }
        }
        return null;  // Login failed
    }

    public static boolean removeUserFromList(String username) {
        userList = getUserList();
        for (User user : userList) {
            if (user.getUserName().equals(username)) {
                userList.remove(user);
                DataWriter.updateUsers(userList);
                return true;
            }
        }
        return false;  // User not found
    }

    public static User searchByUserName(String username){
        userList = getUserList();
        for (User user : userList){
            if(user.getUserName().equalsIgnoreCase(username)){
                return user;
            }
        }
        return null;
    }

    public static void logOffUser(String username){
        userList = getUserList();
        User user = searchByUserName(username);
        if (user != null) {
            
            DataWriter.updateUsers(userList);

        }
    }
    
    public static void main(String[] args) {
        

        // Test searchByUserName method
        String testUsername = "VrajTPatel";
        User foundUser = UserList.searchByUserName(testUsername);

        if (foundUser != null) {
            System.out.println("User found: " + foundUser.getUserName());
            System.out.println("Email: " + foundUser.getEmail());
        } else {
            System.out.println("User not found.");
        }
    }
}