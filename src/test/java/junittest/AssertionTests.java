package junittest;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Денис on 17.06.2017.
 */
public class AssertionTests {

    @Test
    public void shouldDemonstrateAssertionsTest() {
        Integer first = 1;
        Integer second = 2;
        Integer repeatFirst = 1;

        Integer[] expectedIntegersArray = {1, 2, 3, 4, 5};
        Integer[] resultIntegersArray = {1, 2, 3, 4, 5};

        assertEquals(first, repeatFirst);

        assertNotNull(second);

        assertSame(first, repeatFirst);

        assertArrayEquals(expectedIntegersArray, resultIntegersArray);
    }
}
