import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private final Map<String, Student> allStudents;

    public StudentSystem() {
        this.allStudents = new HashMap<>();
    }

    public String parseCommand(String[] commandParameters) {
        String commandName = commandParameters[0];

        switch (commandName) {
            case "Create":
                String nameOfStudent = commandParameters[1];
                int age = Integer.parseInt(commandParameters[2]);
                double grade = Double.parseDouble(commandParameters[3]);

                addNewStudent( nameOfStudent, age, grade);
                return null;
            case "Show":
                String name = commandParameters[1];
                return getInfoOfStudent(name);
            case "Exit":
                return commandName;
            default:
                return null;
        }
    }

    private void addNewStudent(String name, int age, double grade) {
        allStudents.putIfAbsent(name, new Student(name, age, grade));
    }

    private String getInfoOfStudent(String name) {
        if (allStudents.containsKey(name)) {
            Student student = allStudents.get(name);
            return FormatterOfStudentInfo.getStudentInfo(student);
        }
        return null;
    }
}
