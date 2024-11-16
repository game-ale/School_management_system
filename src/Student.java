
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for keeping the track of students fees, name ,grade
 * & fees paid.
 *
 */
public class Student extends Person implements Serializable {

    CSVWriter csvWriter = new CSVWriter("studentData.csv");
    private int grade;
    private int feesPaid;
    private int feesTotal;

    /**
     * To create a new student by initializing. Fees for every student is
     * $30,000. Fees paid initially is 0.
     * 
     * @param id    id for the student: unique.
     * @param name  name of the student.
     * @param grade grade of the student.
     */
    public Student(int id, String name, int grade) {
        super(id, name);
        this.feesPaid = 0;
        this.feesTotal = 30000;
        this.grade = grade;
        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(
                new String[] { String.valueOf(id), name, String.valueOf(grade),
                        String.valueOf(feesPaid), String.valueOf(feesTotal) });
        csvWriter.writeData(dataLines);

    }

    // Not going to alter student's name, student's id.

    /**
     * Used to update the student's grade.
     * 
     * @param grade new grade of the student.
     */
    public void setGrade(int grade) {
        this.grade = grade;
        String[] newData = new String[] { String.valueOf(super.id), super.name,
                String.valueOf(grade), String.valueOf(feesPaid),
                String.valueOf(feesTotal) };
        csvWriter.updateData(super.id - 1, newData);
    }

    public int getid() {
        return id;
    }

    /**
     * Keep adding the fees to feesPaid Field. Add the fees to the fees paid.
     * The school is going receive the funds.
     *
     * @param fees the fees that the student pays.
     */
    public void payFees(int id, int fees) {
        feesPaid += fees;
        School.updateTotalMoneyEarned(feesPaid);
        String[] newData = new String[] { String.valueOf(id), super.name,
                String.valueOf(grade), String.valueOf(feesPaid),
                String.valueOf(feesTotal) };
        csvWriter.updateData(id, newData);
    }

    /**
     *
     * @return the grade of the student.
     */
    public int getGrade() {
        return grade;
    }

    /**
     *
     * @return fees paid by the student.
     */
    public int getFeesPaid() {
        return feesPaid;
    }

    /**
     *
     * @return the total fees of the student.
     */
    public int getFeesTotal() {
        return feesTotal;
    }

    /**
     *
     * @return the remaining fees.
     */
    public int getRemainingFees() {
        return feesTotal - feesPaid;
    }

    @Override
    public String toString() {
        return super.toString() + " | Grade: " + grade
                + " | Total fees paid so far: $" + feesPaid;
    }
}
