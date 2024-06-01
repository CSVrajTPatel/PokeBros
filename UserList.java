import java.util.ArrayList;

public class UserList {
    private static UserList masterList;
    private static ArrayList<User> userList;

    private UserList() {
        userList = DataLoader.loadUsers();
    }

    public static UserList getInstance() {
        if (masterList == null) {
            masterList = new UserList();
        }
        return masterList;
    }

    //public ArrayList<User> 
    
    // Adding a User
    public boolean addUserToList(String userName, String password, String firstName, String lastName, String email) {

        // ERROR CHECK LIKE DUPES OR VALID EMAIL HERE
        for (User user : userList) {
            if (user.getUserName() == userName) {
                return false;
            }
            if (!email.contains("@")) {
                return false;
            }
        }
        User newUser = new User(userName, password, firstName, lastName, email);
        userList.add(newUser);

        // If we are writing all the time it will be expensive on memory
        
        // DataWriter.updateUsers(userList);

        return true;

    }

    public User loginUser(String userName, String password) {
    
        for (User user : userList) {
            if (user.getUserName().equalsIgnoreCase(userName) && user.getPassword().equals(password)) {
                DataLoader.loadTrades();
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

    public ArrayList<User> searchByCards(Card card){
        ArrayList<User> returnList = new ArrayList<User>();
        for (User user : userList){

            ArrayList<Card> userCards = user.getOwnedCards();
            for (Card userCard : userCards) {

                if (userCard == card) {

                    returnList.add(user);
                    break;
                }
            }
        }
        return returnList;
    }

    public void logOffUser(String username){
    
        User user = searchByUserName(username);
        if (user != null) {
            DataWriter.updateUsers(userList);
            DataWriter.removeNonPendingTrades();
        }
    }

    public void saveUsers(){
        DataWriter.updateUsers(userList);
    }
    
    public void main(String[] args) {

        CardList masterList = CardList.getInstance();
        // Test searchByUserName method
        String testUsername = "VrajTPatel";
        User foundUser = searchByUserName(testUsername);

        if (foundUser != null) {
            System.out.println("User found: " + foundUser.getUserName());
            System.out.println("Email: " + foundUser.getEmail());
        } else {
            System.out.println("User not found.");
        }
    }
}