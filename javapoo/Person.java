/**
 * This program create a Person class as Abstract
 * 
 * @version 1.0 2019-12-28
 * @author Matthias DOLA,
 * @book:From Core Java Volume 1 of Horstmann, Cay S & Cornell, Gary
 */
public abstract class Person {
    public abstract String getDescription();
    private String name;

    public Person(String aName) {
        this.name = aName;
    }

    public String getName() {
        return this.name;
    }
}