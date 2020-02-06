import java.util.Arrays;

public class Office implements Cloneable {
    private Person[] persons;

    public Office(Person... persons) {
        this.persons = Arrays.copyOf(persons, persons.length);
    }

    @Override
    public Office clone() throws CloneNotSupportedException {
        Office office = (Office) super.clone();
        office.persons = persons.clone();
        return office;
    }

    @Override
    public String toString() {
        return String.format("%s{persons=%s}", getClass().getSimpleName(), Arrays.toString(persons));
    }

    public Person[] getPersons() {
        return persons;
    }
}