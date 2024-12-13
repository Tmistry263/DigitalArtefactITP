package lib;

import java.util.Scanner;

public class UserInformation {

    Scanner keyScanner = new Scanner(System.in);

    private String userName;
    // Getter for user name

    public String getUserName() {
        return userName;
    }

    // Setter for username
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // Private method for printing username
    private void printUserName() {
        System.out.println("Your name is " + getUserName());
    }

    // Publically availble method for printUserName that keeps method inaccessible.
    public void callPrintUserName() {
        printUserName();
    }

    // private method for asking for and storing user name in Setter.
    private void collectUserName() {
        System.out.println("Please enter your name.");
        String usersNameInput = keyScanner.nextLine();
        setUserName(usersNameInput);
    }
    
    // Publically available method for collectUserName() that keeps method inaccessible
    public void callCollectUserName() {
        collectUserName();
    }
}
