
import java.util.List;
import java.util.Optional;

/**
 * Many teachers, many students. Implements teachers and student using an
 * ArrayList.
 * 
 */
public class School {

    private List<Teacher> teachers;
    private List<Student> students;
    private static int totalMoneyEarned;
    private static int totalMoneySpent;

    /**
     * new school object is created.
     * 
     * @param teachers list of teachers in the school.
     * @param students list of students int the school.
     */
    public School(List<Teacher> teachers, List<Student> students) {
        this.teachers = teachers;
        this.students = students;
        totalMoneyEarned = 0;
        totalMoneySpent = 0;
    }

    /**
     *
     * @return the list of teachers int the school.
     */
    private List<String[]> teacher = new CSVWriter("teacherData.csv")
            .getTeacher();

    public List<String[]> getTeachers() {
        return teacher;
    }

    /**
     * Adds a teacher to the school.
     * 
     * @param teacher the teacher to be added.
     */
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    /**
     *
     * @return the list of students in the school.
     */
    private List<String[]> student = new CSVWriter("studentData.csv")
            .getStudent();

    public List<String[]> getStudents() {
        return student;
    }

    /**
     * Adds a student to the school
     * 
     * @param student the student to be added.
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     *
     * @return the total money earned by the school.
     */
    public int getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    /**
     * Adds the total money earned by the school.
     * 
     * @param MoneyEarned money that is supposed to be added.
     */
    public static void updateTotalMoneyEarned(int MoneyEarned) {
        totalMoneyEarned += MoneyEarned;
    }

    /**
     *
     * @return the total money spent by the school.
     */
    public int getTotalMoneySpent() {
        return totalMoneySpent;
    }

    /**
     * update the money that is spent by the school which is the salary given by
     * the school to its teachers.
     * 
     * @param moneySpent the money spent by school.
     */
    public static void updateTotalMoneySpent(int moneySpent) {
        totalMoneyEarned -= moneySpent;
    }

    // CRUD Operations
    public void updateTeacher(int index, Teacher newTeacher) {
        if (index >= 0 && index < teachers.size()) {
            teachers.set(index, newTeacher);
        } else {
            System.out.println("Invalid teacher index.");
        }
    }

    public void deleteStudent(int index) {
        new CSVWriter("studentData.csv").deleteStudent(index);
    }

    public Optional<Student> getStudent(int index) {
        if (index >= 0 && index < students.size()) {
            return Optional.of(students.get(index));
        } else {
            return Optional.empty();
        }
    }

    // Save and Load Data (Placeholder methods)
    public void saveData() {
        // Implementation for saving data to a file or database
        System.out.println("Data saved successfully.");
    }

    public void loadData() {
        // Implementation for loading data from a file or database
        System.out.println("Data loaded successfully.");
    }

}
