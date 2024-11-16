
import java.io.*;
import java.util.*;

public class CSVWriter {
    private File csvOutputFile;

    public CSVWriter(String fileName) {
        this.csvOutputFile = new File(fileName);
    }

    public void writeData(List<String[]> dataLines) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(csvOutputFile, true))) {
            dataLines.stream().map(CSVWriter::convertToCSV)
                    .forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateData(int lineNumber, String[] newData) {
        List<String[]> dataLines = new ArrayList<>();

        // Read the existing file
        try (BufferedReader br = new BufferedReader(
                new FileReader(csvOutputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                dataLines.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Update the specific line
        if (lineNumber >= 0 && lineNumber < dataLines.size()) {
            dataLines.set(lineNumber, newData);
        } else {
            System.out.println("Invalid line number");
            return;
        }

        // Write the updated data back to the file
        try (PrintWriter pw = new PrintWriter(new FileWriter(csvOutputFile))) {
            for (String[] dataLine : dataLines) {
                pw.println(convertToCSV(dataLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        List<String[]> dataLines = new ArrayList<>();

        // Read the existing file
        try (BufferedReader br = new BufferedReader(
                new FileReader(csvOutputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                dataLines.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Find and remove the student with the given id
        boolean studentFound = false;
        Iterator<String[]> iterator = dataLines.iterator();
        while (iterator.hasNext()) {
            String[] dataLine = iterator.next();
            if (dataLine.length > 0 && Integer.parseInt(dataLine[0]) == id) {
                iterator.remove();
                studentFound = true;
                break;
            }
        }

        if (!studentFound) {
            System.out.println("Student with ID " + id + " not found.");
            return;
        }

        // Write the updated data back to the file
        try (PrintWriter pw = new PrintWriter(new FileWriter(csvOutputFile))) {
            for (String[] dataLine : dataLines) {
                pw.println(convertToCSV(dataLine));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String[]> getStudent() {
        List<String[]> students = new ArrayList<>();

        // Read the existing file
        try (BufferedReader br = new BufferedReader(
                new FileReader(csvOutputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                students.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    public List<String[]> getTeacher() {
        List<String[]> teachers = new ArrayList<>();

        // Read the existing file
        try (BufferedReader br = new BufferedReader(
                new FileReader(csvOutputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                teachers.add(line.split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return teachers;
    }

    private static String convertToCSV(String[] data) {
        return String.join(",", data);
    }
}
