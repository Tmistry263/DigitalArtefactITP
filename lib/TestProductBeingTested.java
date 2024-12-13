package lib;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestProductBeingTested {

    @Test//test valid product passed 
    public void testProductBeingTestValid() {
        InputStream orgIn = System.in; //Back up original System.in
        String mockProduct =  "Product X"; //mock product name 
        ByteArrayInputStream bais = new ByteArrayInputStream(mockProduct.getBytes());//ByteArrayInputStream mocks input using a byte array 
        System.setIn(bais);//Set Scanner input as ByteArrayInputStream 
        ProductBeingTested product = new ProductBeingTested();//instantiate new class 
        product.callSetProductInTest();//Set product in test 
        String actualProduct = product.getProductInTest();//get value stored when calling previous method 
        assertEquals("Product X", actualProduct);//Assert String actualProduct is "Product X"
        System.setIn(orgIn);//Set system in back to origina 

        }
    

    @Test//test invalid input and then valid input passed 
    public void testProductBeingTestInvalid() {
        InputStream orgIn = System.in;
        String input= "\nProduct X"; // mock empty input followed by actual input 
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais); //
        ProductBeingTested product = new ProductBeingTested();
        product.callSetProductInTest(); // Calls the private method indirectly
        String actualProduct = product.getProductInTest();
        assertEquals("Product X", actualProduct);
        System.setIn(orgIn);
    }

    @Test //Test valid input passed and displayed
    public void testDisplayProductBeingTested() {
        String input =  "Product X";
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        System.setIn(bais);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//Capture outputs
        PrintStream orgOut = System.out; 
        System.setOut(new PrintStream(baos));
        ProductBeingTested product = new ProductBeingTested();
        product.callSetProductInTest();
        product.callDisplayProductBeingTested(); 
        System.setOut(orgOut);
        System.setIn(System.in);//set original out 
        String consoleOutput = baos.toString();//convert console output to string
        assertTrue(consoleOutput.contains("You are testing Product X"));
    }
}

