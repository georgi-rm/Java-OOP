package person;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public void setFirstName(String firstName) {
        if (isNullOrEmpty(firstName)) {
            throw new IllegalArgumentException("The first name cannot be null or empty");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (isNullOrEmpty(lastName)) {
            throw new IllegalArgumentException("The last name cannot be null or empty");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age should be in the range [0 ... 120]");
        }
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }
}
