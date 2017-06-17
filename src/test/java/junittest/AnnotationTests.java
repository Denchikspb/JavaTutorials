package junittest;

import org.junit.*;
/**
 * Created by Денис on 17.06.2017.
 */
public class AnnotationTests {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("This is init first...");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("this is init last...");
    }

    @Before
    public void before(){
        System.out.println("Before each test");
    }

    @After
    public void after(){
        System.out.println("After each test");
    }

    @Test
    public void simpleTest(){
        System.out.println("This is simple test");
    }

    @Ignore
    @Test
    public void ignoreTest(){
        System.out.println("This test will be ignored");
    }

}
