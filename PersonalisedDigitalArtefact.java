import java.util.Scanner;
import java.util.Random;

public class PersonalisedDigitalArtefact {

    public static void main(String[] args) {

        // Declare new scanner with name keyScanner

        Scanner keyScanner = new Scanner(System.in);

        System.out.println("Hello! and welcome to the Test Management Summariser!.\n" +
                "Before we start, I need to collect some data about you");

        System.out.println("What is your name?");

        String programmeUsersName = keyScanner.nextLine();

        System.out.println("What are you testing at the moment?");

        String productBeingTested = keyScanner.nextLine();

        System.out.println("How many total tests do you have to run?");

        int numberOfTests = keyScanner.nextInt();
        keyScanner.nextLine();

        System.out.println("How many tests have been run?");

        int numberOfTestsRun = keyScanner.nextInt();
        keyScanner.nextLine();

        System.out.println("\nThanks, " + programmeUsersName + " for that information.\n" +
                "You are testing " + productBeingTested + " and you have " + numberOfTests + " tests to run\n" +
                "You have " + (numberOfTests - numberOfTestsRun) + " tests remaining.");

        // Boolean to control looping menu.
        boolean continueProgramme = true;

        while (continueProgramme) {

            System.out.println("You have 4 options to chose from:\n" +
                    "Option 1: See your name\n" +
                    "Option 2: See the project you are working on\n" +
                    "Option 3: What % of testing is complete?\n" +
                    "Option 4: Be told a joke\n" +
                    "Please select an option (1-4)");

            int usersOption = keyScanner.nextInt();
            keyScanner.nextLine();

            // while loop to validate users input
            while (usersOption < 1 || usersOption > 4) {

                System.out.println(usersOption + " is not a valid choice");
                System.out.println("Please select (1-4): ");
                usersOption = keyScanner.nextInt();
                keyScanner.nextLine();

            }

            System.out.println("Great Job you have selected option " + usersOption);

            // Switch statement to carry out users choice
            switch (usersOption) {

                case 1:
                    displayUserName(programmeUsersName);
                    break;

                case 2:
                    displayProductBeingTested(productBeingTested);
                    break;

                case 3:
                    displayPercentageOfTestsCompleted(numberOfTestsRun, numberOfTests, productBeingTested);
                    break;

                case 4:
                    // genarate random number to tell one of the jokes in the method
                    Random randomValue = new Random();
                    int jokeGeneratingNumber = randomValue.nextInt(4) + 1;// generate a random number between 1 - 4 to
                                                                          // tell the the joke in the switch statement
                                                                          // in the method.
                    tellUserAJoke(jokeGeneratingNumber);
                    break;

            }

        }

        // Does the user want to continue the application?
        System.out.println("Do you want to continue?(yes/no)");
        String usersContinueChoice = keyScanner.nextLine();

        // convert users choice to lower case for validation of choice.
        usersContinueChoice = usersContinueChoice.toLowerCase();

        // else if statement to continue the programme
        if (usersContinueChoice.equals("no")) {

            continueProgramme = false;
            System.out.println("The programme will now exit, Goodbye!");

        } else if (!usersContinueChoice.equals("yes")) {

            System.out.println("Invalid response, I assume you want to continue");

        }

        keyScanner.close();

    }

    // Method for Option 1: display user name
    private static void displayUserName(String usersName) {

        System.out.println("Your name is " + usersName);

    }

    // Method for Option 2: Display product being tested
    private static void displayProductBeingTested(String testedProduct) {

        System.out.println("You are testing " + testedProduct);

    }

    // Method for Option 3: display percentage of tests complete
    private static void displayPercentageOfTestsCompleted(int testsCurrentlyComplete, int totalOfTests,
            String testedProduct) {

        try {

            if (totalOfTests <= 0) {

                throw new IllegalArgumentException("The total number of tests must be more than zero");
            }

            if (testsCurrentlyComplete < 0) {
                throw new IllegalArgumentException("The number of tests run should not be a negative number");
            }

            if (testsCurrentlyComplete > totalOfTests) {

                throw new IllegalArgumentException(
                        "The number of completed tests cannot exceed the total number of tests");

            }

            if (testsCurrentlyComplete == 0) {

                System.out.println("You haven't completed any tests yet.");

            } else {

                double percentageTestingFinished = ((double) testsCurrentlyComplete / totalOfTests) * 100;
                String percentageTestsCompletedResult = String.format("%.2f", percentageTestingFinished);// format
                                                                                                         // double to
                                                                                                         // display only
                                                                                                         // 2 decimal
                                                                                                         // places.
                System.out.println("You have completed " + percentageTestsCompletedResult + " % of your testing on "
                        + testedProduct);

                if ((percentageTestingFinished > 50.00) && (percentageTestingFinished < 75.00)) {

                    System.out.println("You are over halfway there! Keep Going");

                } else if ((percentageTestingFinished >= 75.00) && (percentageTestingFinished < 100.00)) {

                    System.out.println("Not far to go! Keep going!");

                } else if (percentageTestingFinished == 100.00) {

                    System.out.println("You are finished! Well Done!");

                } else {

                    System.out.println("Keep up the good work!");

                }

            }
        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        }

    }

    // method fot Option 4: to tell a joke based on a random number.
    private static void tellUserAJoke(int jokeNumber) {

        switch (jokeNumber) {

            case 1:
                System.out.println("Why cant you trust an atom? Because they make up everything!");
                break;

            case 2:
                System.out.println("Why was six afraid of seven? Because seven eight nine!");
                break;

            case 3:
                System.out.println("Did you hear about the frog that illegally parked his car? He got toad away");
                break;

            case 4:
                System.out.println("What do you call a bear with no teeth? A gummy bear.");
                break;

        }

        System.out.println("I never guaranteed that these jokes would be funny.");
    }
}
