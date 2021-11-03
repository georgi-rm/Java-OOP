public class Person {
    private final String firstName;
    private final String lastName;
    private final int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        String salary = "" + this.salary;
        return String.format("%s %s gets %s leva", this.firstName, this.lastName, salary);
    }

    public void increaseSalary(double bonus) {
        if (this.age < 30) {
            bonus *= 0.5;
        }
        this.salary = this.salary + ( this.salary * bonus / 100 );
    }
}
