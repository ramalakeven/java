package laba9;
import java.util.*;

public class Group {
    private ArrayList<Student> students = new ArrayList<>();
    public static final int MAX_SIZE = 15;
    public static final int MIN_SIZE = 3;

    public void addStudent(int age, String gender, String firstName, String lastName, String patronymic, int course, double averageGrade) {
        try {
            if (students.size() >= MAX_SIZE) {
                System.out.println("Группа переполнена, максимальное количество студентов: " + MAX_SIZE);
                return;
            }
            Student student = new Student(age, gender, firstName, lastName, patronymic, course, averageGrade);
            students.add(student);
            System.out.println("Студент " + firstName + " " + lastName + " добавлен в группу.");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);

        if (students.size() >= MAX_SIZE) {
            System.out.println("Группа переполнена, не можем добавить студента.");
            return;
        }

        try {
            System.out.print("Введите возраст: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Введите пол: ");
            String gender = scanner.nextLine();
            System.out.print("Введите имя: ");
            String firstName = scanner.nextLine();
            System.out.print("Введите фамилию: ");
            String lastName = scanner.nextLine();
            System.out.print("Введите отчество: ");
            String patronymic = scanner.nextLine();
            System.out.print("Введите курс: ");
            int course = scanner.nextInt();
            System.out.print("Введите средний бал: ");
            double averageGrade = scanner.nextDouble();

            Student student = new Student(age, gender, firstName, lastName, patronymic, course, averageGrade);
            students.add(student);
            System.out.println("Студент добавлен: " + firstName + " " + lastName);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public void removeStudent(int index) {
        if (students.size() <= MIN_SIZE) {
            System.out.println("Невозможно удалить студента. В группе должно быть не менее " + MIN_SIZE + " студентов.");
            return;
        }
        if (index < 0 || index >= students.size()) {
            System.out.println("Неверный индекс студента.");
            return;
        }
        Student removed = students.remove(index);
        System.out.println("Студент " + removed.getFirstName() + " " + removed.getLastName() + " удален из группы.");
    }

    public Student getStudentByIndex(int index) {
        try {
            if (index < 0 || index >= students.size()) {
                throw new IndexOutOfBoundsException("Неверный индекс. Допустимый диапазон: от 0 до " + (students.size() - 1) + ".");
            }
            return students.get(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void printStudents() {
        if (students.isEmpty()) {
            System.out.println("Группа пуста.");
        }
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            System.out.println("Студент " + (i + 1) + ": " +
                    student.getFirstName() + " " + student.getLastName() + ", Возраст: " + student.getAge() +
                    ", Курс: " + student.getCourse() + ", Средний бал: " + student.getAverageGrade());
        }
    }

    public int getStudentsCount() {
        return students.size();
    }
}
