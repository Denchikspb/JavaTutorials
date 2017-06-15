package junittest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Денис on 15.06.2017.
 */
public class ArrayHolderTest {
    ArrayHolder arrayHolder = new ArrayHolder();

    @Test
    public void shouldCreateDefaultArrayTest() {
         assertEquals(arrayHolder.toString(), "[1, 2, 3, 4, 5]");
    }
}