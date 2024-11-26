import java.util.Scanner;

public class MenuSystemLoop {

    public static void main(String[] args) {

        // Declare new scanner with name keyScanner
        // Ask user questions and get answers. 

        Scanner keyScanner = new Scanner(System.in);

        System.out.println("Hello and welcome to the programme. Before we start, lets collect some data about you");

        System.out.println("What is your first name?");

        String inputFirstName = keyScanner.nextLine();

        System.out.println("What is your second name?");

        String inputSecondName = keyScanner.nextLine();

        System.out.println("Where do you work?");

        String inputPlaceOfWork = keyScanner.nextLine();

        System.out.println("How many years have you worked for " + inputPlaceOfWork + "?");

        int inputLengthOfService = keyScanner.nextInt();

        System.out.println("Ok, all information has been gathered");

        //Print out user inputs and ask menu options. 

        System.out.println("Welcome to the programme " + inputFirstName + " " + inputSecondName + "." + " Congratulations on working\n" 
                           + "for " + inputPlaceOfWork + " for " + inputLengthOfService+ " years. Now, let's begin…");
    
        //Boolean to control looping menu.
        boolean continueProgramme =  true;

        while (continueProgramme) {

            System.out.println("In this programme you have 4 choices:\n" + //
            "Option 1: See your full name\n" + //
            "Option 2: Remember where you work\n" + //
            "Option 3: See how many years you have left until retirement\n" + //
            "Option 4: Hear some personalised words of encouragement\n" + //
            "Please select (1-4)");
            
            int usersOption = keyScanner.nextInt();
            keyScanner.nextLine();

            //while loop to calidate users input
            while (usersOption < 1 || usersOption > 4) {

                System.out.println(usersOption + " is not a valid choice");
                System.out.println("Please select (1-4): ");
                usersOption = keyScanner.nextInt();
                keyScanner.nextLine();
                
            }
        
        System.out.println("Great Job " + inputFirstName + " you have selected option " + usersOption);    
            
        //Switch statement to carry out users choice
        switch (usersOption) {

            case 1:
                System.out.println("Your full name is " + " " + inputFirstName + " " + inputSecondName);
                break;

            case 2:
                System.out.println("You work at " + inputPlaceOfWork);
                break;

            case 3:
                System.out.println("Most people work for 35 years, you may have " + (35 - inputLengthOfService)
                        + " years of work left.");
                break;

            case 4:
                System.out.println("Keep on going " + inputFirstName + " you've got this!");
                break;  

        }

        //Does the user want to continue the application?
        System.out.println("Do you want to continue?");
        String usersContinueChoice = keyScanner.nextLine();

        //convert users choice to lower case for validation of choice.
        usersContinueChoice = usersContinueChoice.toLowerCase();

        //else if statement to continue the programme
        if (usersContinueChoice.equals("no")) {

            continueProgramme = false;
            System.out.println("The programme will now exit, Goodbye!");

        } else if(!usersContinueChoice.equals("yes")) {
            
            System.out.println("Invalid response, I assume you want to continue");

            }

        }

        keyScanner.close();
    }   
}   



    
    
