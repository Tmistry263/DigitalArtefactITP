package lib;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

//abstract class to provide foundation for subclasses
abstract class Severity {

    ArrayList<String> bugName = new ArrayList<>();
    ArrayList<Integer> daysBugOpen = new ArrayList<>();
    String severityRanking;
    Scanner keyScanner = new Scanner(System.in);

    // initialise severity class and pass severityRanking in the method to adapt methods to severity level.
    public Severity(String severityRanking) {
        this.severityRanking = severityRanking;
    }

    // private method to collect bug info
    private void collectBugInfo() {
        System.out.println("Please enter all the " + severityRanking + " bugs you have found.\n" +
                "If you haven't found any, type 'none'. When you are finished, type 'Done'.");
        while (true) { //Loop to keep asking for bug input unless typing 'none' or 'done'
            System.out.println("Enter the bug name, none or done to finish:");
            String foundBugName = keyScanner.nextLine();
            foundBugName = foundBugName.toLowerCase();
            if (foundBugName.equals("done") || foundBugName.equals("none")) {
                break;
            }
            System.out.println("How many days has the bug been open?");
            int daysOpen = keyScanner.nextInt();
            keyScanner.nextLine(); 
            bugName.add(foundBugName); //add names to array
            daysBugOpen.add(daysOpen); //add days open to array 
        }
    }

    //public method to access collectBugInfo() method and keep logic private.
    public void callCollectBugInfo() {
        collectBugInfo();
    }

    //Public method calling print bug info methods that are currently private. 
    public void callBugPrintMethods() {
        printBugNameInfo();
        printLongestAndShortestOpenBug();
        printAverageDaysOpen();
        printBugSeverityMessage();
    }
    
    //publically available method for testing purposes 
    public ArrayList<String> getBugName() {
        return bugName;
    }

    // private method to print bug name info
    private void printBugNameInfo() {
        System.out.println("\nBugs found for " + severityRanking + ":");
        for (int i = 0; i < bugName.size(); i++) {
            System.out.println("Bug found: " + bugName.get(i));
            
        }
    }

    // private method to print average days open
    private void printAverageDaysOpen() {
        // if statement to avoid calculating average if no methods declared
        if (daysBugOpen.isEmpty()) {
            System.out.println("Cannot calculate an average as there were no Bugs found!");
            return;
        }
        // for each loop to add sum
        int totalDaysOpen = 0;
        for (int days : daysBugOpen) {
            totalDaysOpen += days;
        }
        System.out.println("Total number of days that the Bugs were open is: " + totalDaysOpen);
        double averageDaysBugsOpen = (double) totalDaysOpen / daysBugOpen.size();
        String averageDaysBugsOpenFinal = String.format("%.2f", averageDaysBugsOpen); // String format to print double to two decimal places
        System.out.println(severityRanking + " Average days a Bug was open is: " + averageDaysBugsOpenFinal + " days.");
    }

    // private method to print the bugs with longest and shortest days open
    private void printLongestAndShortestOpenBug() {
        if (daysBugOpen.isEmpty()) {
            System.out.println("There are no bugs with information to display.");
        } else {
            Collections.sort(daysBugOpen); // sort days bug open into numercial order
            int shortestOpenBug = daysBugOpen.get(0); // get first element in sorted ArrayList
            System.out.println(
                    "The Bug that was open for the shortest amount of time was open for: " + shortestOpenBug + " days");
            int longestOpenBug = daysBugOpen.get(daysBugOpen.size() - 1);// get last element in sorted ArrayList
            System.out.println(
                    "The Bug that was open for the longest amount of time was open for: " + longestOpenBug + " days");
        }
    }

    // Instantiate message to print bug serverity. Method implements in subclass. 
    public abstract void printBugSeverityMessage();
}

// Classes inherit functionality from abstract class and sets severity ranking
class SevOne extends Severity {
    public SevOne() {
        super("Severity One");
    }
    // Overides method to print a severity specific message
    @Override
    public void printBugSeverityMessage() {
        System.out.println( "Any Severity One bug is a showstopper, It is critical they are fixed before the code goes live!\n");
    }
}

// Overides method to print a severity specific message
class SevTwo extends Severity {
    public SevTwo() {
        super("Severity Two");
    }
    // Overides method to print a severity specific message
    @Override
    public void printBugSeverityMessage() {
        System.out.println("Any Severity Two bug will need to assess whether these have to be fixed before release or can be \n" +
                           "added to the backlog. Ideally this should be fixed.\n");
    }
}

// Overides method to print a severity specific message
class SevThree extends Severity {
    public SevThree() {
        super("Severity Three");
    }
    // Overides method to print a severity specific message 
    @Override
    public void printBugSeverityMessage() {
        System.out.println("If these Severity Three bugs aren't fixed before release they will be added to the backlog for \n" +
                           "a future fix.\n");
    }
}