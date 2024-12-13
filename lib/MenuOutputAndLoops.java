package lib;

import java.util.Scanner;

public class MenuOutputAndLoops {
    
    UserInformation userInfo = new UserInformation();
    ProductBeingTested productTested = new ProductBeingTested();
    PercentageOfTestsCompleted percentageCalculations = new PercentageOfTestsCompleted();
    SevOne sevOne = new SevOne();
    SevTwo sevTwo = new SevTwo();
    SevThree sevThree = new SevThree();
    TellMeAJoke joke = new TellMeAJoke();

    Scanner keyScanner = new Scanner(System.in);
    private int usersOptions;

    // Construtor to pass data from main method class to this class
    public MenuOutputAndLoops(UserInformation userInfo, ProductBeingTested productTested,
            PercentageOfTestsCompleted percentageCalculations, SevOne sevOne, SevTwo sevTwo, SevThree sevThree) {
        this.userInfo = userInfo;
        this.productTested = productTested;
        this.percentageCalculations = percentageCalculations;
        this.sevOne = sevOne;
        this.sevTwo = sevTwo;
        this.sevThree = sevThree;
    }

    // private method for printing welcome message
    private void welcomeMessage() {
        System.out.println("Hello! Welcome to Test Management Summariser!\n" +
                           "Before we start, I'd like to take some information from you.");
    }

    // public method to display welcome message
    public void callWelcomeMessage() {
        welcomeMessage();
    }

    // private method to give a quick summary from data collected
    // not testing as covered in other classes
    private void quickSummary() {
        System.out.println("\nThanks for that information " + userInfo.getUserName() + "\n" +
                "You are currently testing " + productTested.getProductInTest() + "\n" +
                "You have " + percentageCalculations.getNumberOfTests() + " tests to run.\n" +
                "You have " + (percentageCalculations.getNumberOfTests() - percentageCalculations.getNumberOfTestsRun())
                + " tests left to run\n");
    }

    // Public method to display quick summary method
    public void callQuicksummary() {
        quickSummary();
    }

    // Private method to display menu
    private void displayMenu() {
        System.out.println("You have 5 options to chose from:\n" +
                "Option 1: See your name\n" +
                "Option 2: See the project you are working on\n" +
                "Option 3: What % of testing is complete?\n" +
                "Option 4: Be told a joke\n" +
                "Option 5: See information about the bugs you've found.");
    }

    //public method to callDisplayMenu() and keep logic private.
    public void callDisplayMenu() {
        displayMenu();
    }

    // private method to get users menu option
    private int getUserOption() { // Loop to keep asking unit valid option selected
        while (true) {
            try {
                System.out.println("Enter a valid option (1-5)");
                usersOptions = keyScanner.nextInt();
                keyScanner.nextLine();
                if (usersOptions < 1 || usersOptions > 5) { // if statement to check if option is less than 1 or greater
                                                            // than 5
                    System.out.println(usersOptions + " is an invalid choice");
                } else {
                    return usersOptions; // Breaks loop
                }
            } catch (Exception e) {
                System.out.println("invalid choice. Please choose an option between 1-5"); // Print out exception
                keyScanner.nextLine();// clear buffer
            }
        }
    }

    // Private method to handle user choice in a switch case.
    private void handleUserChoice(int option) {
        switch (option) {
            case 1:
                userInfo.callPrintUserName();
                break;
            case 2:
                productTested.callDisplayProductBeingTested();
                break;
            case 3:
                percentageCalculations.callDisplayPercentageOfTestsCompleted();
                break;
            case 4:
                joke.callTellUserAJoke();
                break;
            case 5:
                sevOne.callBugPrintMethods();
                sevTwo.callBugPrintMethods();
                sevThree.callBugPrintMethods();
                break;
        }
    }

    // Private method to ask if user wants to continue.
    private boolean userContinues() {
        System.out.println("Do you want to continue? (Yes/No):");
        String continueResponse = keyScanner.nextLine();
        continueResponse = continueResponse.toLowerCase();
        return !(continueResponse.equals("no") || continueResponse.equals("n")); // changes continueProgramme boolean to
                                                                                 // false if no selected
    }

    // Private method to loop menu which calls private displayMenu(),
    // getUserOption() and userContinues() methods.
    private void loopMenu() {
        boolean continueProgramme = true;
        while (continueProgramme) { // While user say yes to continue, method keeps looping
            callDisplayMenu();
            int userSelected = getUserOption();
            handleUserChoice(userSelected);
            continueProgramme = userContinues();
        }
        System.out.println("Thank you for using this programme!");
    }

    // public method to display menu loop
    public void callLoopMenu() {
        loopMenu();
    }
}
