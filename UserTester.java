import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTester {

    private UserList userList;

    @BeforeEach
    public void setUp() {
        userList = UserList.getInstance();
        userList.addUserToList("josh1515", "password123", "josh", "Doe", "john.doe@example.com");
        userList.addUserToList("logan142", "password321", "logan", "John", "johnM@gmail.com");
    }

    @Test
    void testUserValidUserName() {
        User hasJoshUser = userList.searchByUserName("josh1515");
        boolean hasJosh = (hasJoshUser != null);
        assertTrue(hasJosh);
    }
    
    @Test
    public void testValidLastUserUserName(){
        User hasLoganUser = userList.searchByUserName("logan142");
        boolean hasLogan = (hasLoganUser != null);
        assertTrue(hasLogan);
    }
    @Test 
    public void testHaveUserInValid() {
        assertFalse(userList.searchByUserName("jsmith") != null);
    }

    @Test
    public void testHaveUserEmpty() {
        User hasEmpty = userList.searchByUserName(" ");
        assertNull(hasEmpty);
    }

    @Test
    public void testHaveUserNull() {
        User hasNull = userList.searchByUserName(null);
        assertNull(hasNull);
    }

    @Test
    public void testUserValidPassword() {
        User joshUser = userList.searchByUserName("josh1515");
        boolean passwordMatches = joshUser.getPassword().equals("password123");
        assertTrue(passwordMatches);
    }

    @Test
    public void testUserValidFirstName(){
        User joshUser = userList.searchByUserName("josh1515");
        boolean validFirstName =  joshUser.getFirstName().equals("josh");
        assertTrue(validFirstName);
    }

    @Test 
    public void testUserForLastName(){
        User joshUser = userList.searchByUserName("josh1515");
        boolean validLastName =  joshUser.getLastName().equals("Doe");
        assertTrue(validLastName);
    }

    @Test
    public void testUserForEmail(){
        User joshUser = userList.searchByUserName("josh1515");
        boolean validEmail =  joshUser.getEmail().equals("john.doe@example.com");
        assertTrue(validEmail);
    }

   
}
