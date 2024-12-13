package lib;


import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import org.junit.jupiter.api.Test;

public class MenuOutputAndLoopsTest {
    //instantiate classes 
    UserInformation userInfo = new UserInformation();
    ProductBeingTested product = new ProductBeingTested();
    PercentageOfTestsCompleted percentage = new PercentageOfTestsCompleted();
    SevOne sevOne = new SevOne();
    SevTwo sevTwo = new SevTwo();
    SevThree sevThree =  new SevThree();
    MenuOutputAndLoops menu = new MenuOutputAndLoops(userInfo, product, percentage, sevOne, sevTwo, sevThree);//Initalise menu object
    TellMeAJoke joke = new TellMeAJoke();

    @Test //Test display menu 
    void testCallDisplayMenu() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//capture output 
        System.setOut(new PrintStream(baos));
        menu.callDisplayMenu();
        String output = baos.toString(); 
        assertTrue(output.contains("Option 1"));//Assert options are display
        assertTrue(output.contains("Option 2"));
        assertTrue(output.contains("Option 3"));
        assertTrue(output.contains("Option 4"));
        assertTrue(output.contains("Option 5"));
        System.setOut(System.out);//restore original out
    }

    @Test//Test welcome message 
    void testCallWelcomeMessage() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//Capture output
        System.setOut(new PrintStream(baos));
        menu.callWelcomeMessage();
        String consoleOutput = baos.toString(); //convert output to String 
        assertTrue(consoleOutput.contains("Hello! Welcome to Test Management Summariser!"));//Assert message is displayed in output 
        System.setOut(System.out);
    }

    @Test//Test loop menu with valid input 
    public void testLoopMenuValid1() {
        String mockUserInput = "1\nno\n"; //mock user imput
        ByteArrayInputStream bais = new ByteArrayInputStream(mockUserInput.getBytes());//ByteArrayInputStream mocks input using a byte array 
        System.setIn(bais);//Set Scanner input as ByteArrayInputStream 
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//capture output
        System.setOut(new PrintStream(baos));
        MenuOutputAndLoops menu = new MenuOutputAndLoops(userInfo, product, percentage, sevOne, sevTwo, sevThree);
        menu.callLoopMenu();
        String output = baos.toString();//convert output to string
        assertTrue(output.contains("You have 5 options to chose from:"));//asert output contains
        assertTrue(output.contains("Option 1: See your name"));
        assertTrue(output.contains("Thank you for using this programme!"));
    }

    @Test//test loop with an valid input
    public void testLoopMenuValid5() {
        String simulatedUserInput = "5\nno\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        MenuOutputAndLoops menu = new MenuOutputAndLoops(userInfo, product, percentage, sevOne, sevTwo, sevThree);
        menu.callLoopMenu();
        String output = outputStream.toString();
        assertTrue(output.contains("You have 5 options to chose from:"));
        assertTrue(output.contains("Option 5: See information about the bugs you've found"));
        assertTrue(output.contains("Thank you for using this programme!"));
    }

    @Test//test with Invalid option passed
    public void testLoopMenuInvalid0() {
        String simulatedUserInput = "0\n5\nno\n";//invalid option passe 
        ByteArrayInputStream bais = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        MenuOutputAndLoops menu = new MenuOutputAndLoops(userInfo, product, percentage, sevOne, sevTwo, sevThree);
        menu.callLoopMenu();
        String output = outputStream.toString();
        assertTrue(output.contains("You have 5 options to chose from:"));
        assertTrue(output.contains("0 is an invalid choice"));
        assertTrue(output.contains("Option 5: See information about the bugs you've found"));
        assertTrue(output.contains("Thank you for using this programme!"));
    }

    @Test //test with invalid option passed  
    public void testLoopMenuInvalid6() {
        String simulatedUserInput = "6\n5\nno\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        MenuOutputAndLoops menu = new MenuOutputAndLoops(userInfo, product, percentage, sevOne, sevTwo, sevThree);
        menu.callLoopMenu();
        String output = outputStream.toString();
        assertTrue(output.contains("You have 5 options to chose from:"));
        assertTrue(output.contains("6 is an invalid choice"));
        assertTrue(output.contains("Option 5: See information about the bugs you've found"));
        assertTrue(output.contains("Thank you for using this programme!"));
    }


    @Test//test when user wanted to continue when asked. 
    public void testLoopMenuValidContinue() {
        String simulatedUserInput = "1\nYes\n1\nno\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        MenuOutputAndLoops menu = new MenuOutputAndLoops(userInfo, product, percentage, sevOne, sevTwo, sevThree);
        menu.callLoopMenu();
        String output = outputStream.toString();
        assertTrue(output.contains("You have 5 options to chose from:"));
        assertTrue(output.contains("Option 1: See your name"));
        assertTrue(output.contains("Thank you for using this programme!"));
        assertTrue(output.contains("Do you want to continue? (Yes/No):"));
    }
}




    


