package lib;
import java.util.Scanner;

public class PercentageOfTestsCompleted {
    
    Scanner keyScanner = new Scanner(System.in);
    //Private variables declared
    
    private int numberOfTests = 0;
    private int numberOfTestsRun = 0;
    
    //Getter for total number of tests
    public int getNumberOfTests() {
        return numberOfTests;
    }
    
    //Setter for total number of tests 
    public void setNumberOfTests(int numberOfTests) {
        this.numberOfTests = numberOfTests;
    }
    
    //Getter for number of tests run
    public int getNumberOfTestsRun() {
        return numberOfTestsRun;
    }
    
    //Setter for number of tests run
    public void setNumberOfTestsRun(int numberOfTestsRun) {
        this.numberOfTestsRun = numberOfTestsRun;
    }
    
    //Method for collecting test numbers
    private void collectTestNumbersData() {
        boolean validInput = false;
        //While loop to ensure there is a valid input and loops until a valid input is achieved
        while (!validInput) { 
            try {
                System.out.println("How many tests do you have to run in total?");
                this.numberOfTests = keyScanner.nextInt();
                if (numberOfTests <= 0) {
                    throw new IllegalArgumentException("The total number of tests must be more than zero!");//Exception to ensure numberOfTests is more than zero
                }
                System.out.println("How many tests have you run so far?");
                this.numberOfTestsRun = keyScanner.nextInt();
                
                    if (numberOfTestsRun > numberOfTests) {
                        throw new IllegalArgumentException("The number of tests run must not be more than the total number of tests");//Exception to ensure numberofTestsRun is not more than numberOfTests
                    }
                    if (numberOfTestsRun < 0) {
                        throw new IllegalArgumentException("The number of tests run cannot be less than zero!");//Exception to ensure the numberOfTestsRun 
                    }
                    validInput = true;                 
            } catch (IllegalArgumentException e) {  //Print error messages
                System.out.println("Error: " + e.getMessage());
                System.out.println("Please try again");
            } 
        } 
    }

    //Publically available method to call collectTestNumbersData method. 
    public void callCollectTestNumbersData() {
        collectTestNumbersData();
    }

    //Calculate percentage of tests run.
    private void displayPercentageOfTestsCompleted() {
        if (numberOfTestsRun == 0) { //To avoid mathematical error of dividing by zero. 
            System.out.println("You haven't started testing yet.");
        } else {
            double percentageTestingFinished = ((double) numberOfTestsRun / numberOfTests) * 100;
            String percentageTestsCompletedResult = String.format("%.2f", percentageTestingFinished);// format double to display only 2 decimal places.
            System.out.println("You have completed " + percentageTestsCompletedResult + " % of your testing.");
            if ((percentageTestingFinished > 50.00) && (percentageTestingFinished < 75.00)) {
                System.out.println("You are over halfway there! Keep Going");//print a message depending on percentage of tests run. 
            } else if ((percentageTestingFinished >= 75.00) && (percentageTestingFinished < 100.00)) {
                System.out.println("Not far to go! Keep going!");
            } else if (percentageTestingFinished == 100.00) {
                System.out.println("You are finished! Well Done!");
            } else {
                System.out.println("Keep up the good work!");
            }
        }
    }

    //Publically available method to call display percentages of tests complete.
    public void callDisplayPercentageOfTestsCompleted() {
        displayPercentageOfTestsCompleted();
    }
    
    }
