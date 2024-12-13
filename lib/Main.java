package lib;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyScanner = new Scanner(System.in);
        UserInformation userInfo = new UserInformation();
        ProductBeingTested productTested = new ProductBeingTested();
        PercentageOfTestsCompleted percentageCalculations = new PercentageOfTestsCompleted();
        SevOne sevOne = new SevOne();
        SevTwo sevTwo = new SevTwo();
        SevThree sevThree = new SevThree();
        MenuOutputAndLoops menuLoops = new MenuOutputAndLoops(userInfo, productTested, percentageCalculations, sevOne, sevTwo, sevThree);
        menuLoops.callWelcomeMessage();
        userInfo.callCollectUserName();
        productTested.callSetProductInTest();
        percentageCalculations.callCollectTestNumbersData();
        sevOne.callCollectBugInfo();
        sevTwo.callCollectBugInfo();
        sevThree.callCollectBugInfo();
        menuLoops.callQuicksummary();
        menuLoops.callLoopMenu();
        keyScanner.close();               
    }
}