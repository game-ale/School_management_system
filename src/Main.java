
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Teacher lizzy = new Teacher(1, "Lizzy", 500);
            Teacher mellisa = new Teacher(2, "Mellisa", 700);
            Teacher vanderhorn = new Teacher(3, "Vanderhorn", 600);

            List<Teacher> teacherList = new ArrayList<>();
            teacherList.add(lizzy);
            teacherList.add(mellisa);
            teacherList.add(vanderhorn);

            Student tamasha = new Student(1, "Tamasha", 4);
            Student rakshith = new Student(2, "Rakshith Vasudev", 12);
            Student rabbi = new Student(3, "Rabbi", 5);
            List<Student> studentList = new ArrayList<>();

            studentList.add(tamasha);
            studentList.add(rabbi);
            studentList.add(rakshith);

            School ghs = new School(teacherList, studentList);

            Teacher megan = new Teacher(6, "Megan", 900);
            ghs.addTeacher(megan);

            tamasha.payFees(tamasha.getId(), 5000);
            rakshith.payFees(tamasha.getId(), 6000);

            lizzy.receiveSalary(lizzy.getSalary());

            vanderhorn.receiveSalary(vanderhorn.getSalary());

            mellisa.receiveSalary(mellisa.getSalary());

            // CRUD Operations
            ghs.updateTeacher(2, new Teacher(2, "Melissa Smith", 750));
            ghs.deleteStudent(3);
            ghs.getStudent(1).ifPresent(System.out::println);

            // Save and Load Data
            ghs.saveData();
            ghs.loadData();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
