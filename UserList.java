import java.util.ArrayList;
import java.util.Arrays;
public class UserList {
    public ArrayList<User> userList;

    public UserList() {
        userList = new ArrayList<>();
    }

    public ArrayList<User> getUserList() {
        userList = DataLoader.loadUsers();
        return userList;
    }

    public boolean addUserToList(User user) {

        return false;
    }

    public boolean removeUserFromList(String username) {

        return false;
    }
    

}