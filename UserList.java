import java.util.ArrayList;
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
        if (user != null && !userList.contains(user)) {
            userList.add(user);
            DataWriter.updateUsers(userList);
            return true;
        }
        return false;
    }

    public boolean removeUserFromList(String username) {
        for (User user : userList) {
            if (user.getUserName().equals(username)) {
                userList.remove(user);
                DataWriter.updateUsers(userList);
                return true;
            }
        }
        return false;
    }
}   