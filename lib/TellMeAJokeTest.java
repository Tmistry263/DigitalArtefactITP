package lib;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TellMeAJokeTest {

    @Test//Test switch statement displays a joke.  
    void testGeneratedNumberAndOutput() {
        TellMeAJoke joke = new TellMeAJoke();//instantiate class
        ByteArrayOutputStream baos = new ByteArrayOutputStream(); //Capture output
        PrintStream orgOut = System.out;
        System.setOut(new PrintStream(baos));//redirect console output
        joke.callTellUserAJoke();
        String consoleOutput = baos.toString();//convert output to stream 
        assertTrue(consoleOutput.contains("Why cant you trust an atom?") ||
                   consoleOutput.contains("Why was six afraid of seven?") ||
                   consoleOutput.contains("Did you hear about the frog that illegally parked his car?") ||
                   consoleOutput.contains("What do you call a bear with no teeth?")); //assert one of the jokes is printed 
        System.setOut(orgOut);//set System out back to original 
    }
}
