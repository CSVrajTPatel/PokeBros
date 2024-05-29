import java.util.ArrayList;

public class UserList {
    public ArrayList<User> userList;

    public UserList() {
        userList = DataLoader.loadUsers();
    }

    public ArrayList<User> getUserList() {
        userList = DataLoader.loadUsers();
        return userList;
    }

    // Adding a User
    public boolean addUserToList(String userName, String password, String firstName, String lastName, String email) {
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

    public User loginUser(String userName, String password) {
        for (User user : userList) {
            if (user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equals(password)) {
                return user;  // Login successful
            }
        }
        return null;  // Login failed
    }

    public boolean removeUserFromList(String username) {
        for (User user : userList) {
            if (user.getUserName().equals(username)) {
                userList.remove(user);
                DataWriter.updateUsers(userList);
                return true;
            }
        }
        return false;  // User not found
    }

    public User searchByUserName(String username){
        for (User user : userList){
            if(user.getUserName().equalsIgnoreCase(username)){
                return user;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        UserList userList = new UserList();

        // Test searchByUserName method
        String testUsername = "VrajTPatel";
        User foundUser = userList.searchByUserName(testUsername);

        if (foundUser != null) {
            System.out.println("User found: " + foundUser.getUserName());
            System.out.println("Email: " + foundUser.getEmail());
        } else {
            System.out.println("User not found.");
        }
    }
}