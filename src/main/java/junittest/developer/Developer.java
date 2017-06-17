package junittest.developer;

/**
 * Created by Денис on 17.06.2017.
 */
public class Developer {
    private String firstName;
    private String lastName;
    private String specialty;
    private int salary;

    public Developer(){

    }

    public Developer(String firstName, String lastName, String specialty, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Developer: " +
                "\nFirstName: " + firstName +
                "\nLastName: " + lastName +
                "\nSpecialty: " + specialty +
                "\nSalary: " + salary + ".";
    }
}
