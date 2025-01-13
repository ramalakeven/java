package studentstats;

import java.util.Comparator;

public class StudentComparator {

    public static class AverageGradeComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s2.getAverageGrade(), s1.getAverageGrade()); 
        }
    }

    public static class ScholarshipComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s2.getScholarship(), s1.getScholarship()); 
        }
    }

    public static class AgeComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return s2.getAge() - s1.getAge();
        }
    }

    public static class AttendanceComparator implements Comparator<Student> {
        @Override
        public int compare(Student s1, Student s2) {
            return Double.compare(s2.getAttendancePercentage(), s1.getAttendancePercentage());
        }
    }
    private static void updateAttendance() {
        // Обработка списка студентов
        String attendance = getStringInput("Введите отметку о посещении (был/не был): ");
        Student studentToUpdate = students.get(studentIndex);
        if (attendance.equals("был")) {
            studentToUpdate.setAttendedClasses(studentToUpdate.getAttendedClasses() + 1);
        } else if (attendance.equals("не был")) {
            studentToUpdate.setMissedClasses(studentToUpdate.getMissedClasses() + 1);
        }
        studentToUpdate.setAttendance(attendance);
    }
    
}