package lib;
import java.util.Scanner;

public class ProductBeingTested {
    
    Scanner keyScanner = new Scanner(System.in);
    private String productInTest;

    //Private method to set product in test 
    private void setProductInTest() {
        boolean validProduct = false;
        while (!validProduct) {  //validate input to ensure it is not empty 
            try {
                System.out.println("What product are you curently testing?");
                productInTest = keyScanner.nextLine();
                if (productInTest.isEmpty()) {
                    throw new IllegalArgumentException("Please enter your product ");
                }
                validProduct = true;
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage()); //print error message 
            }
        }
    }

    //publically available method for setting product in test 
    public  void callSetProductInTest() {
        setProductInTest();
    }

    //Publically available method to get product in test
    public String getProductInTest() {
         return productInTest;
    }

    //Privately method to display product being tested 
    private void displayProductBeingTested() {
        System.out.println("You are testing " + getProductInTest());
    }

    //Privately method to display product being tested 
    public void callDisplayProductBeingTested() {
        displayProductBeingTested();
    }
}
