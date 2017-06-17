package junittest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Денис on 17.06.2017.
 */
public class CalculatorAdvancedTests {
    private Calculator calculator = new Calculator();

    private int firstNumber;
    private int secondNumber;

    @Before
    public void setUp(){
        firstNumber = 100;
        secondNumber = 200;

        calculator.setFirstNumber(firstNumber);
        calculator.setSecondNumber(secondNumber);
    }

    @Test
    public void shouldCreateCalculatorWithSetupValues(){
        assertEquals(firstNumber , 100);
        assertEquals(secondNumber , 200);
    }

    @Test
    public void shouldReturnCorrectSum(){
        assertEquals(300, calculator.calculateSum());
    }
}
