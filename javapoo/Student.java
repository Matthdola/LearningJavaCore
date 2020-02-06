/**
 * This program create a Student class
 * 
 * @version 1.0 2019-12-28
 * @author Matthias DOLA,
 * @book:From Core Java Volume 1 of Horstmann, Cay S & Cornell, Gary
 */

public class Student extends Person {
    private String major;

    /**
     * 
     * @param aName the student's name
     * @param aMajor the student's major
     */
    public Student(String aName, String aMajor){
        // pass n to superclass constructor
        super(aName);
        this.major = aMajor;
    }

    @Override
    public String getDescription() {
        return "a student majoring in " + this.major;
    }
}