
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is responsible for keeping the track of teacher's name, id,
 * salary.
 */
public class Teacher extends Person implements Serializable {

    CSVWriter csvWriter = new CSVWriter("teacherData.csv");
    private int salary;
    private int salaryEarned;

    /**
     * Creates a new Teacher object.
     * 
     * @param id     id for the teacher.
     * @param name   name of the teacher.
     * @param salary salary of the teacher.
     */
    public Teacher(int id, String name, int salary) {
        super(id, name);
        this.salary = salary;
        this.salaryEarned = 0;
        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[] { String.valueOf(id), name,
                String.valueOf(salary) });
        csvWriter.writeData(dataLines);
    }

    /**
     *
     * @return the salary of the teacher.
     */
    public int getSalary() {
        return salary;
    }

    /**
     * set the salary.
     * 
     * @param salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
        String[] newData = new String[] { String.valueOf(super.id), super.name,
                String.valueOf(salary) };
        csvWriter.updateData(super.id - 1, newData); // Assuming id starts from
                                                     // 1 and corresponds to
                                                     // line number
    }

    /**
     * Adds to salaryEarned. Removes from the total money earned by the school.
     * 
     * @param salary
     */
    public void receiveSalary(int salary) {
        salaryEarned += salary;
        School.updateTotalMoneySpent(salary);
    }

    @Override
    public String toString() {
        return super.toString() + " | Total salary earned so far: $"
                + salaryEarned;
    }
}
