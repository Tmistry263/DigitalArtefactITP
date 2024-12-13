package lib;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class SeverityTest {

    @Test //Test collecting Sev One bugs info
    void testCallCollectBugSevOne() {
        String mockBugData = "Test Bug A\n2\nTest Bug B\n7\ndone"; //Mock input 
        ByteArrayInputStream bais = new ByteArrayInputStream(mockBugData.getBytes()); //ByteArrayInputStream mocks input using a byte array 
        System.setIn(bais);//Set Scanner input as ByteArrayInputStream 
        SevOne sevOne = new SevOne(); //Object of SevOne class
        sevOne.callCollectBugInfo(); //call method
        assertEquals(2, sevOne.getBugName().size());//Assert ArrayList has 2 entries. 
    }

    @Test //Test to collect Sev Two bugs info
    void testCallCollectBugSevTwo() {
        String mockBugData = "Test Bug A\n2\ndone"; 
        ByteArrayInputStream bais = new ByteArrayInputStream(mockBugData.getBytes());
        System.setIn(bais);
        SevTwo sevTwo = new SevTwo();
        sevTwo.callCollectBugInfo();
        assertEquals(1, sevTwo.getBugName().size());//assert only one entry
    }

    @Test //Test to collect no Sev Three info 
    void testCallCollectBugSevThree() {
        String mockBugData = "none";
        ByteArrayInputStream bais = new ByteArrayInputStream(mockBugData.getBytes());
        System.setIn(bais);
        SevThree sevthree = new SevThree();
        sevthree.callCollectBugInfo();
        assertEquals(0, sevthree.getBugName().size());//assert no bugs entered 
    }

    @Test//Test to collect and print bug info for Sev One
    void testCallBugPrintMethodsSevOne() {
        String mockBugData = "Test Bug A\n2\nTest Bug B\n7\ndone";
        ByteArrayInputStream bais = new ByteArrayInputStream(mockBugData.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //Create a ByteArrayOutputStream to capture anything printed to console 
        PrintStream orgOut = System.out; //save original console output 
        System.setOut(new PrintStream(baos));//redirect console output 
        SevOne sevOne = new SevOne();
        sevOne.callCollectBugInfo();
        sevOne.callBugPrintMethods();//Call method being tested
        System.setOut(orgOut);//restore system out
        System.setIn(System.in);//restore system in 
        String consoleOutput = baos.toString();//convert output to a string
        assertTrue(consoleOutput.contains("found"));//assert String found is in the output.  
    }

    @Test//Test to collect and print bug info for Sev two
    void testCallBugPrintMethodsSevTwo() {
        String mockBugData = "Test Bug A\n2\nTest Bug B\n7\ndone";
        ByteArrayInputStream bais = new ByteArrayInputStream(mockBugData.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream orgOut = System.out;
        System.setOut(new PrintStream(baos));
        SevTwo sevTwo = new SevTwo();
        sevTwo.callCollectBugInfo();
        sevTwo.callBugPrintMethods();
        System.setOut(orgOut);
        System.setIn(System.in);
        String consoleOutput = baos.toString();
        assertTrue(consoleOutput.contains("Any Severity Two bug will need to assess whether these have to be fixed before release")); //assert Sev Two method is displayed in output      
    }

    @Test//Test to collect and print bug info for sev three 
    void testCallBugPrintMethodsSevThree() {
        String mockBugData = "none";
        ByteArrayInputStream bais = new ByteArrayInputStream(mockBugData.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream orgOut = System.out;
        System.setOut(new PrintStream(baos));
        SevThree sevThree = new SevThree();
        sevThree.callCollectBugInfo();
        sevThree.callBugPrintMethods();
        System.setOut(orgOut);
        System.setIn(System.in);
        String consoleOutput = baos.toString();
        assertTrue(consoleOutput.contains("no bugs"));//assert no bugs 
        assertTrue(consoleOutput.contains("Cannot calculate"));//assert can't calculate average 
        assertTrue(consoleOutput.contains("If these Severity Three bugs aren't fixed before release they will be added"));//assert sev three bug message displayed 
    }
}
