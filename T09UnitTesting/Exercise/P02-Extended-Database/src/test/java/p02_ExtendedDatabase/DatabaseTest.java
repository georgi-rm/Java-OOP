package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private static final Integer[] NUMBERS_ARRAY = {0, 1, 2, 3, 4, 5};
    private static final int TOO_MANY_ELEMENTS = 17;
    private static final Person PERSON_TO_ADD = new Person(100, "Ani");
    private Person[] initialRegisteredPeople;
    private Database database;

    @Before
    public void setUpTests() throws OperationNotSupportedException {
        Person personOne = new Person(0, "Jhon");
        Person personTwo = new Person(1, "George");
        Person personThree = new Person(2, "Dimo");
        Person personFour = new Person(3, "Martin");
        this.initialRegisteredPeople = new Person[]{personOne, personTwo, personThree, personFour};
        this.database = new Database(this.initialRegisteredPeople);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWithZeroElements() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWithBiggerInputArray() throws OperationNotSupportedException {
        Database database = new Database(new Person[TOO_MANY_ELEMENTS]);
    }

    @Test
    public void testConstructorWithCorrectInput() {
        Person[] actualElements = this.database.getElements();
        assertEquals(this.initialRegisteredPeople.length, actualElements.length);
        assertArrayEquals(this.initialRegisteredPeople, actualElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddWithNullElement() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void testAddWithCorrectElement() throws OperationNotSupportedException {
        this.database.add(PERSON_TO_ADD);

        Person[] actualElements = this.database.getElements();
        assertEquals(this.initialRegisteredPeople.length + 1, actualElements.length);
        assertEquals(PERSON_TO_ADD, actualElements[actualElements.length - 1]);
    }

    @Test
    public void testRemoveElementWithElements() throws OperationNotSupportedException {
        this.database.remove();
        Person[] actualElements = this.database.getElements();
        assertEquals(this.initialRegisteredPeople.length - 1, actualElements.length);
        assertEquals(this.initialRegisteredPeople[this.initialRegisteredPeople.length - 2], actualElements[actualElements.length - 1]);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowExceptionWhenThereIsNoElements() throws OperationNotSupportedException {
        for (int i = 0; i < this.initialRegisteredPeople.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void testFindByUsernameWithExistingUsername() throws OperationNotSupportedException {
        String usernameToSearch = this.initialRegisteredPeople[1].getUsername();
        Person foundPerson = this.database.findByUsername(usernameToSearch);
        assertEquals(usernameToSearch, foundPerson.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithNonExistingUsername() throws OperationNotSupportedException {
        String usernameToSearch = "Not Existing Username";
        Person foundPerson = this.database.findByUsername(usernameToSearch);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWithNullUsername() throws OperationNotSupportedException {
        String usernameToSearch = null;
        Person foundPerson = this.database.findByUsername(usernameToSearch);
    }

    @Test
    public void testFindByIdWithExistingId() throws OperationNotSupportedException {
        int idToSearch = this.initialRegisteredPeople[1].getId();
        Person foundPerson = this.database.findById(idToSearch);
        assertEquals(idToSearch, foundPerson.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdWithNonExistingId() throws OperationNotSupportedException {
        Person foundPerson = this.database.findById(1234);
    }

}