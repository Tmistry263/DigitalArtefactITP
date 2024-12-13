package lib;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class PercentageOfTestsCompletedTest {
    @Test
    void testCallCollectTestNumbersData_Valid() {
        String mockedInput = "5\n3\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(mockedInput.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream orgOut = System.out;
        System.setOut(new PrintStream(baos));

        PercentageOfTestsCompleted percentage = new PercentageOfTestsCompleted();
        percentage.callCollectTestNumbersData();

        assertEquals(5, percentage.getNumberOfTests());
        assertEquals(3, percentage.getNumberOfTestsRun());

        System.setOut(orgOut);
        System.setIn(System.in);

    }

    @Test
    void testCallCollectTestNumbersDataInvalid() {
        String mockedInput = "-2\n 5\n 7\n 5\n 3\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(mockedInput.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream orgOut = System.out;
        System.setOut(new PrintStream(baos));

        PercentageOfTestsCompleted percentage = new PercentageOfTestsCompleted();
        percentage.callCollectTestNumbersData();

        assertEquals(5, percentage.getNumberOfTests());
        assertEquals(3, percentage.getNumberOfTestsRun());

        System.setOut(orgOut);
        System.setIn(System.in);

        String consoleOutput = baos.toString();
        assertTrue(consoleOutput.contains("The total number of tests must be more than zero!"));
        assertTrue(consoleOutput.contains("The number of tests run must not be more than the"));

    }

    @Test
    void testCallDisplayPercentageOfTestsCompleted() {
        String mockedInput = "10\n5\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(mockedInput.getBytes());
        System.setIn(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream orgOut = System.out;
        System.setOut(new PrintStream(baos));

        PercentageOfTestsCompleted percentage = new PercentageOfTestsCompleted();
        percentage.callCollectTestNumbersData();
        percentage.callDisplayPercentageOfTestsCompleted();

        System.setOut(orgOut);
        System.setIn(System.in);

        String consoleOutput = baos.toString();
        assertTrue(consoleOutput.contains("50.00"));

    }
}

