package lib;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInformationTest {

    @Test//Test to collect username 
    void testCallCollectUserName() {
        // Backup the original System.in
            InputStream orgIn = System.in;
            String mockName = "Test User"; //mock user name
            ByteArrayInputStream input = new ByteArrayInputStream(mockName.getBytes());
            System.setIn(input); // Redredirect console input
            UserInformation userInfo = new UserInformation();
            userInfo.callCollectUserName(); // Method that reads user input
            String actualName = userInfo.getUserName();//get stored value for comparison 
            assertEquals(mockName, actualName);//assert mock name is the same as stored value 
            System.setIn(orgIn);//originsl system in
        }
    

    @Test//test to print user name 
    void testCallPrintUserName() {//test to print user name 
        InputStream orgIn = System.in;
        String mockName = "Test User"; // 
        ByteArrayInputStream input = new ByteArrayInputStream(mockName.getBytes());
        System.setIn(input); // Redirect System.in to simulated input
        UserInformation userInfo = new UserInformation();
        userInfo.callCollectUserName(); // Method that reads user input
        userInfo.callPrintUserName();//call print name 
        assertEquals(userInfo.getUserName(), mockName);//assert mock name is the same as stored value 
        System.setIn(orgIn);
    }
}
