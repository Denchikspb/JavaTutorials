package junittest;

import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.Test;

/**
 * Created by Денис on 17.06.2017.
 */
public class TestSuiteDemo {
    TestSuite testSuite = new TestSuite(CalculatorAdvancedTests.class, CalculatorTest.class);

    TestResult testResult = new TestResult();

    @Test
    public void testSuiteInAction() {
        testSuite.run(testResult);
        System.out.println("Amount of test cases: " + testSuite.countTestCases());

        testSuite.setName("SimpleTestSuite");
        System.out.println("Name of Test Suite: " + testSuite.getName());
    }
}
