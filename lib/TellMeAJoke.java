package lib;
import java.util.Random;

public class TellMeAJoke {
    Random randomNumber = new Random(); //create Random number object
    //Method to generate a joke. 
    private void tellUserAJoke() {
        int jokeGeneratingNumber = randomNumber.nextInt(4) + 1; //generate a number between 1-4
        //Switch statement to print joke depending on number generated
        switch (jokeGeneratingNumber) {
            case 1:
                System.out.println("Why cant you trust an atom? Because they make up everything!");
                break;
            case 2:
                System.out.println("Why was six afraid of seven? Because seven eight nine!");
                break;
            case 3:
                System.out.println("Did you hear about the frog that illegally parked his car? He got toad away!");
                break;
            case 4:
                System.out.println("What do you call a bear with no teeth? A gummy bear!");
                break;
        }
        System.out.println("I never guaranteed that these jokes would be funny!");
    }
    
    //Publically available method to tellUserAJoke method. 
    public void callTellUserAJoke() {
        tellUserAJoke();
    }
}
