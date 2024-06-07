import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTester {

    /*
     * We need to add a way to input the favorite cards and the currency and owned cards
     * 
     */
    private UserList userList;

    @BeforeEach
    public void setUp() {
        userList = UserList.getInstance();
        userList.addUserToList("josh1515", "password123", "josh", "Doe", "john.doe@example.com");
        userList.addUserToList("logan142", "password321", "logan", "John", "johnM@gmail.com");
    }

    // test for the first user 
    @Test
    void testUserValidUserName() {
        User hasJoshUser = userList.searchByUserName("josh1515");
        assertNotNull(hasJoshUser);
    }

    @Test
    public void testUserValidFirstName(){
        User joshUser = userList.searchByUserName("josh1515");
        assertEquals(joshUser.getFirstName(), "josh");
    }

      // checking if the password is valid 
      @Test
      public void testUserValidPassword() {
          User joshUser = userList.searchByUserName("josh1515");
          boolean passwordMatches = joshUser.getPassword().equals("password123");
          assertTrue(passwordMatches);
      }

    // 
    // test for the second user
        @Test
    public void testValidLastUserUserName(){
        User hasLoganUser = userList.searchByUserName("logan142");
        boolean hasLogan = (hasLoganUser != null);
        assertTrue(hasLogan);
    }

    // testing for if a user is not valid within the list of users 
    @Test 
    public void testHaveUserInValid() {
        assertFalse(userList.searchByUserName("jsmith") != null);
    }

    // test for checking if the username is empty 
    @Test
    public void testHaveUserEmpty() {
        User hasEmpty = userList.searchByUserName(" ");
        assertNull(hasEmpty);
    }
    // test for checking if the username is null 
    @Test
    public void testHaveUserNull() {
        User hasNull = userList.searchByUserName(null);
        assertNull(hasNull);
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

    public void testUserForOwnedCards(){
        User joshUser = userList.searchByUserName("josh1515");
        ArrayList<Card> ownedCards =  joshUser.getOwnedCards();
        assertNotNull(ownedCards);
    }

    @Test
    public void testUserForFavoriteCards(){
        User joshUser = userList.searchByUserName("josh1515");
        ArrayList<Card> favCards =  joshUser.getFavoriteCards();
        assertNotNull(favCards);
    }

    @Test
    public void testUserForCurrency(){
        User joshUser = userList.searchByUserName("josh1515");
        double currency =  joshUser.getCurrency();
        assertNotNull(currency);
    }


}
