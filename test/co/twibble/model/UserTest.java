package co.twibble.model;

import org.junit.Before;
import org.junit.Test;

import static co.twibble.model.UserType.ADMINISTRATOR;
import static co.twibble.model.UserType.EDITOR;
import static org.junit.Assert.*;

/**
 * The UserTest class checks the getters and setters of the User class
 *
 * @author  Andy McCall
 * @version 0.2
 * @since   2017-02-16
 */

//** TODO: Document UserTest class with JavaDoc

public class UserTest {

    private User classUserUnderTest = new User();

    @Before
    public void setUp() {
        classUserUnderTest.setUserId(1);
        classUserUnderTest.setFirstName("FirstName1");
        classUserUnderTest.setLastName("LastName1");
        classUserUnderTest.setUserName("userName1");
        classUserUnderTest.setEmailAddress("firstname.lastname@domain.com");
        classUserUnderTest.setPassword("HjmajH7");
        classUserUnderTest.setUserType(ADMINISTRATOR);
    }


    @Test
    public void test_new_user_is_empty() throws Exception {
        User userUnderTest = new User();
        assertEquals(0,userUnderTest.getUserId());
        assertNull(userUnderTest.getFirstName());
        assertNull(userUnderTest.getLastName());
        assertNull(userUnderTest.getUserName());
        assertNull(userUnderTest.getEmailAddress());
        assertNull(userUnderTest.getPassword());
        assertNull(userUnderTest.getUserType());
    }

    @Test
    public void test_getId_Passes() throws Exception {
        assertEquals("getUserId has failed!",1,classUserUnderTest.getUserId());
    }

    @Test
    public void test_setId_Passes() throws Exception {
        User userUnderTest = new User();
        userUnderTest.setUserId(2);
        assertEquals("setUserId has failed!",2,userUnderTest.getUserId());
    }

    @Test
    public void test_getFirstName_Passes() throws Exception {
        assertEquals("getFirstName failed!","FirstName1",classUserUnderTest.getFirstName());
    }

    @Test
    public void test_setFirstName_Passes() throws Exception {
        User userUnderTest = new User();
        userUnderTest.setFirstName("FirstName2");
        assertEquals("setFirstName failed!","FirstName2",userUnderTest.getFirstName());
    }

    @Test
    public void test_getLastName_Passes() throws Exception {
        assertEquals("getLastName failed!","LastName1",classUserUnderTest.getLastName());
    }

    @Test
    public void test_setLastName_Passes() throws Exception {
        User userUnderTest = new User();
        userUnderTest.setLastName("LastName2");
        assertEquals("setLastName failed!","LastName2",userUnderTest.getLastName());
    }

    @Test
    public void test_getUserName_Passes() throws Exception {
        assertEquals("getUserName failed!","userName1",classUserUnderTest.getUserName());
    }

    @Test
    public void test_setUserName_Passes() throws Exception {
        User userUnderTest = new User();
        userUnderTest.setUserName("userName2");
        assertEquals("getUserName failed!","userName2",userUnderTest.getUserName());
    }

    @Test
    public void test_getEmailAddress_Passes() throws Exception {
        assertEquals("getEmailAddress failed!","firstname.lastname@domain.com",classUserUnderTest.getEmailAddress());
    }

    @Test
    public void test_setEmailAddress_Passes() throws Exception {
        User userUnderTest = new User();
        userUnderTest.setEmailAddress("firstname2.lastname2@domain2.com");
        assertEquals("setEmailAddress failed!","firstname2.lastname2@domain2.com",userUnderTest.getEmailAddress());
    }

    @Test
    public void test_getPassword_Passes() throws Exception {
        assertEquals("getPassword failed!","HjmajH7",classUserUnderTest.getPassword());
    }

    @Test
    public void test_setPassword_Passes() throws Exception {
        User userUnderTest = new User();
        userUnderTest.setPassword("Jkaj&jhG");
        assertEquals("setPassword failed!","Jkaj&jhG",userUnderTest.getPassword());
    }

    @Test
    public void test_getUserType_Passes() throws Exception {
        assertEquals("getUserType failed!",ADMINISTRATOR,classUserUnderTest.getUserType());
    }

    @Test
    public void test_setUserType_Passes() throws Exception {
        User userUnderTest = new User();
        userUnderTest.setUserType(EDITOR);
        assertEquals("setPassword failed!",EDITOR,userUnderTest.getUserType());
    }

    @Test
    public void test_toString_Passes() throws Exception {
        assertEquals("toString failed!","User{userId=1, firstName='FirstName1', lastName='LastName1', userName='userName1', displayName='null', emailAddress='firstname.lastname@domain.com', password='HjmajH7', userType=ADMINISTRATOR, userStatus=null}", classUserUnderTest.toString());
    }

}