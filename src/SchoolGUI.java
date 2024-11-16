
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This class represents the graphical user interface (GUI) for the school
 * management system.
 */
public class SchoolGUI extends JFrame {
    private School school; // The School object containing teachers and students
    private JTextArea displayArea; // Text area to display information

    /**
     * Constructor for the SchoolGUI class.
     *
     * @param school The School object to be managed by the GUI.
     */
    public SchoolGUI(School school) {
        this.school = school;
        setTitle("School Management System"); // Sets the title of the window
        setSize(400, 300); // Sets the size of the window
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Sets the default close
                                                 // operation
        setLayout(new BorderLayout()); // Sets the layout manager for the window

        // Creates a text area to display information and adds it to the center
        // of the window
        displayArea = new JTextArea();
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        // Creates a panel for buttons and adds it to the south of the window
        JPanel panel = new JPanel();
        JButton viewStudents = new JButton("View Students");
        JButton viewTeachers = new JButton("View Teachers");
        JButton payFees = new JButton("Pay Fees");
        panel.add(viewStudents);
        panel.add(viewTeachers);
        panel.add(payFees);
        add(panel, BorderLayout.SOUTH);

        // Adds action listeners to the buttons
        viewStudents.addActionListener(e -> displayStudents());
        viewTeachers.addActionListener(e -> displayTeachers());
        payFees.addActionListener(e -> payFees());

        setVisible(true); // Makes the window visible
    }

    /**
     * Displays the information of all students in the school.
     */
    private void displayStudents() {
        displayArea.setText(""); // Clears the text area
        for (String[] s : school.getStudents()) {
            String ret = "";
            for (String st : s) {
                ret += st + " | ";
            }
            displayArea.append(ret.toString() + "\n"); // Appends each student's
                                                       // information to the
                                                       // text
                                                       // area
        }
    }

    /**
     * Displays the information of all teachers in the school.
     */
    private void displayTeachers() {
        displayArea.setText(""); // Clears the text area
        for (String[] s : school.getTeachers()) {
            String ret = "";
            for (String st : s) {
                ret += st + " | ";
            }
            displayArea.append(ret.toString() + "\n"); // Appends each student's
                                                       // information to the
                                                       // text
                                                       // area
        }
    }

    /**
     * Allows the user to pay fees for a student.
     */
    private void payFees() {
        String idStr = JOptionPane.showInputDialog("Enter Student ID:"); // Prompts
                                                                         // the
                                                                         // user
                                                                         // for
                                                                         // the
                                                                         // student
                                                                         // ID
        String amountStr = JOptionPane.showInputDialog("Enter Amount:"); // Prompts
                                                                         // the
                                                                         // user
                                                                         // for
                                                                         // the
                                                                         // amount
                                                                         // to
                                                                         // pay

        // Parse the ID and amount to integers
        try {
            int id = Integer.parseInt(idStr);
            int amount = Integer.parseInt(amountStr);
            // Iterates through the list of students to find the student with
            // the matching ID
            for (String[] s : school.getStudents()) {
                if (Integer.parseInt(s[0]) == id) { // Compare IDs as strings
                    new Student(Integer.parseInt(s[0]), s[1],
                            Integer.parseInt(s[2])).payFees(id, amount); // Calls
                                                                         // the
                                                                         // payFees
                                                                         // method
                                                                         // of
                                                                         // the
                    // Student object
                    JOptionPane.showMessageDialog(this,
                            "Fees paid successfully!"); // Displays a message
                                                        // indicating success
                    repaint();
                    return; // Exits the method
                }
            }
            JOptionPane.showMessageDialog(this, "Student not found!"); // Displays
                                                                       // a
                                                                       // message
                                                                       // indicating
                                                                       // that
                                                                       // the
                                                                       // student
                                                                       // was
                                                                       // not
                                                                       // found

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid input! Please enter numeric values.");
        }
    }

    /**
     * Main method to create and run the GUI.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // Creates a list of teachers and adds two teachers to it
        ArrayList<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(1, "Lizzy", 500));
        teachers.add(new Teacher(2, "Mellisa", 700));
        teachers.get(0).setSalary(800);

        // Creates a list of students and adds two students to it
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Tamasha", 4));
        students.add(new Student(2, "Rakshith", 12));

        // Creates a School object with the lists of teachers and students
        School school = new School(teachers, students);
        school.deleteStudent(1);

        // Creates a new SchoolGUI object, passing the School object as an
        // argument
        new SchoolGUI(school);
    }
}