import java.util.Scanner;

public class MenuSystem {

    public static void main(String[] args) {

        // Declare new scanner with name keyScanner

        Scanner keyScanner = new Scanner(System.in);

        // Print out welcome and first question

        System.out.println("Hello and welcome to the programme. Before we start, lets collect some data about you\n");

        System.out.println("What is your first name?\n");

        // Declare String variable and scanner input for first name and second question

        String inputFirstName = keyScanner.nextLine();

        System.out.println("What is your second name?\n");

        // Declare String variable and scanner input for second name and third question

        String inputSecondName = keyScanner.nextLine();

        System.out.println("Where do you work?\n");

        // Declare String variable and scanner input for Place of work and fifth
        // question

        String inputPlaceOfWork = keyScanner.nextLine();

        System.out.println("How many years have you worked for " + inputPlaceOfWork + "?\n");

        int inputLengthOfService = keyScanner.nextInt();

        // End of questions and summary of inputs

        System.out.println("Ok, all information has been gathered\n");

        System.out.println("Welcome to the programme " + inputFirstName + " " + inputSecondName + "."
                + " Congratulations on working\n" + "for " + inputPlaceOfWork + " for " + inputLengthOfService
                + " years. Now, let's begin…\n" + //
                "In this programme you have 4 choices:\n" + //
                "Option 1: See your full name\n" + //
                "Option 2: Remember where you work\n" + //
                "Option 3: See how many years you have left until retirement\n" + //
                "Option 4: Hear some personalised words of encouragement\n" + //
                "Please select (1-4)");

        int usersOption = keyScanner.nextInt();

        System.out.println("Great job " + inputFirstName + " you have selected option " + usersOption);

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

        System.out.println("This programme will now close. Bye!");

        keyScanner.close();

    }

}

    
    
