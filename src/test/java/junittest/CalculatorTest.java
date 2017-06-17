package junittest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Денис on 17.06.2017.
 */
public class CalculatorTest {
    Calculator calculator = new Calculator(5, 10);

    @Test
    public void shouldCreateCalculatorInstance(){
        assertNotNull(calculator);
    }

    @Test
    public void shouldReturnCorrectSum(){
        assertEquals(15, calculator.calculateSum());
    }

}