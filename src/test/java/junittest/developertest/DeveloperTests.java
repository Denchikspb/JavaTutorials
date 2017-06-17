package junittest.developertest;

import junittest.developer.Developer;
import junittest.developer.DeveloperLogic;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Денис on 17.06.2017.
 */
public class DeveloperTests {
    Developer developer = new Developer();
    DeveloperLogic logic = new DeveloperLogic();

    @Before
    public void setUp(){
        developer.setFirstName("Simple");
        developer.setLastName("Developer");
        developer.setSpecialty("Java");
        developer.setSalary(2000);
    }

    @Test
    public void shouldCreateDeveloperInstanceTest(){
        assertEquals("Simple", developer.getFirstName());
        assertEquals("Developer", developer.getLastName());
        assertEquals("Java", developer.getSpecialty());
        assertEquals(2000, developer.getSalary());
    }

    @Test
    public void shouldCalculateAnnualSalaryTest(){
        assertEquals(24000, logic.calculateAnnualSalary(developer));
    }

    @Test
    public void shouldCalculateHourRateTest(){
        assertEquals(12, logic.calculateHourRate(developer));
    }

}
