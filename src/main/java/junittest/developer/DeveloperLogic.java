package junittest.developer;

/**
 * Created by Денис on 17.06.2017.
 */
public class DeveloperLogic {
    public int calculateHourRate(Developer developer) {
        return developer.getSalary() / 20 / 8;
    }

    public int calculateAnnualSalary(Developer developer) {
        return developer.getSalary() * 12;
    }
}
