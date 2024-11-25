import java.util.Scanner;

public class GreetingPage {
    public static void main(String[] args) {
    
    //Declare new scanner with name keyScanner    
    Scanner keyScanner = new Scanner(System.in);

    System.out.println("Hello and welcome to the programme. Before we start, lets collect some data about you\n");
    
    System.out.println("What is your first name?");
    
    //scanner input for first question
    String inputFirstName = keyScanner.nextLine();

    System.out.println("What is your second name?");

    //scanner input for second question
    String inputSecondName = keyScanner.nextLine();

    System.out.println("Where do you work?");

    //scanner input for third question
    String inputPlaceOfWork = keyScanner.nextLine();

    System.out.println("How many years have you worked for "+inputPlaceOfWork+"?");

    //scanner input for forth question
    int inputLengthOfService = keyScanner.nextInt();
    keyScanner.nextLine();

    System.out.println("Ok, all information has been gathered\n");

    //print inputs in a sentence 
    System.out.println("Welcome to the programme "+inputFirstName+" "+inputSecondName+"."+" Congratulations on working\n" + //
                       "for "+inputPlaceOfWork+" for "+inputLengthOfService+" years.\n" + //
                       "Now, let’s begin…");

    //Close scanner.                    
    keyScanner.close();

    }

}    


    
    
