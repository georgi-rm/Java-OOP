package person;

import exceptions.InvalidPersonNameException;

public class Main {
    public static void main(String[] args) {
        try {
            Student peter = new Student("Franco", "franco@abv.bg");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

        try {
            Student noName = new Student("  ", "franco@abv.bg");
        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

        try {
            Student noLastName = new Student("Franco", null);

        } catch (IllegalArgumentException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

        try {
            Student invalidName = new Student("4havdar", "chavdar@abv.bg");

        } catch (InvalidPersonNameException ex) {
            System.out.println("Exception thrown: " + ex.getMessage());
        }

    }
}
