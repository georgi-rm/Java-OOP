public class FormatterOfStudentInfo {
    public static String getStudentInfo(Student student) {
        return String.format("%s is %s years old.%s", student.getName(), student.getAge(), getGradeCommentary(student.getGrade()));
    }

    public static String getGradeCommentary(double grade) {
        if (grade >= 5.00) {
            return  " Excellent student.";
        } else if (grade < 5.00 && grade >= 3.50) {
            return  " Average student.";
        } else {
            return  " Very nice person.";
        }
    }
}
