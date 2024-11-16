
/**
 * 
 * This class is responsible for keeping the
 * track of individuals in the school, including
 * students and teachers.
 *
 */
public abstract class Person {

    protected int id;
    protected String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Name: " + name;
    }
}