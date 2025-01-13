package studentstats;

import java.util.*;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static TreeSet<Student> studentsByScholarship = new TreeSet<>(new StudentComparator.ScholarshipComparator());
    private static TreeSet<Student> studentsByAverageGrade = new TreeSet<>(new StudentComparator.AverageGradeComparator());
    private static TreeSet<Student> studentsByAge = new TreeSet<>(new StudentComparator.AgeComparator());
    private static List<Student> students = new ArrayList<>();

    private static int getMenuChoice(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
            }
        }
    }

    private static int getIntegerInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
            }
        }
    }

    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод. Пожалуйста, введите число.");
            }
        }
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            try {
                int choice = getMenuChoice("Выберите пункт меню: ");
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        removeStudent();
                        break;
                    case 3:
                        changeGrade();
                        break;
                    case 4:
                        changeScholarship();
                        break;
                    case 5:
                        updateAttendance();
                        break;
                    case 6:
                        showSortedList();
                        break;
                    case 7:
                        running = false;
                        break;
                    default:
                        System.out.println("Неверный выбор.");
                }
            } catch (InvalidStudentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Произошла ошибка: " + e.getMessage());
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавить студента");
        System.out.println("2. Удалить студента");
        System.out.println("3. Изменить оценку студента");
        System.out.println("4. Изменить стипендию студента");
        System.out.println("5. Добавить отметку о посещении/непосещении");
        System.out.println("6. Отобразить отсортированный список студентов");
        System.out.println("7. Выход");
    }

    private static void addStudent() throws InvalidStudentException {
        try {
            int age = getIntegerInput("Введите возраст студента: ");
            double averageGrade = getDoubleInput("Введите среднюю оценку студента: ");
            String firstName = getStringInput("Введите имя студента: ");
            String lastName = getStringInput("Введите фамилию студента: ");
            String middleName = getStringInput("Введите отчество студента: ");

            // Проверка Белоусова Алексея Юрьевича 
            if (firstName.equals("Алексей") && lastName.equals("Белоусов") && middleName.equals("Юрьевич")) {
                throw new InvalidStudentException("Алексей Белоусов Юрьевич не может быть студентом.");
            }

            double scholarship = getDoubleInput("Введите размер стипендии студента: ");
            String gender = getStringInput("Введите пол студента (м/ж): ");

            Student student = new Student(firstName, lastName, middleName, age, gender, averageGrade, scholarship);

            // Проверка на дубликат
            for (Student existing : students) {
                if (existing.getFirstName().equals(firstName) &&
                    existing.getLastName().equals(lastName) &&
                    existing.getMiddleName().equals(middleName)) {
                    throw new InvalidStudentException("Студент " + firstName + " " + lastName + " уже существует.");
                }
            }

            students.add(student);
            studentsByAge.add(student);
            studentsByAverageGrade.add(student);
            studentsByScholarship.add(student);

            System.out.println("Студент " + firstName + " " + lastName + " успешно добавлен!");
        } catch (InvalidStudentException e) {
            throw e;
        } catch (Exception e) {
            System.err.println("Ошибка при добавлении студента: " + e.getMessage());
        }
    }

    private static void removeStudent() {
        try {
            if (students.isEmpty()) {
                throw new NoSuchElementException("Список студентов пуст. Нечего удалять.");
            }

            System.out.println("Список студентов:");
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i).getLastName() + " " + students.get(i).getFirstName());
            }

            int studentIndex = getIntegerInput("Введите номер студента для удаления: ") - 1;

            Student studentToRemove = students.get(studentIndex);
            students.remove(studentIndex);
            studentsByAge.remove(studentToRemove);
            studentsByAverageGrade.remove(studentToRemove);
            studentsByScholarship.remove(studentToRemove);

            System.out.println("Студент " + studentToRemove.getFirstName() + " " + studentToRemove.getLastName() + " успешно удален.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Неверный номер студента.");
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void changeGrade() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст. Нечего изменять.");
            return;
        }

        System.out.println("Список студентов:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getLastName() + " " + students.get(i).getFirstName());
        }

        int studentIndex = getIntegerInput("Введите номер студента для изменения оценки: ") - 1;

        if (studentIndex >= 0 && studentIndex < students.size()) {
            double newGrade = getDoubleInput("Введите новую среднюю оценку студента: ");
            Student studentToUpdate = students.get(studentIndex);
            studentsByAverageGrade.remove(studentToUpdate);
            studentToUpdate.setAverageGrade(newGrade);
            studentsByAverageGrade.add(studentToUpdate);
            System.out.println("Оценка студента " + studentToUpdate.getFirstName() + " " + studentToUpdate.getLastName() + " успешно изменена.");
        } else {
            System.out.println("Неверный номер студента.");
        }
    }
    private static void changeScholarship() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст. Нечего изменять.");
            return;
        }

        System.out.println("Список студентов:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getLastName() + " " + students.get(i).getFirstName());
        }

        int studentIndex = getIntegerInput("Введите номер студента для изменения стипендии: ") - 1;

        if (studentIndex >= 0 && studentIndex < students.size()) {
            double newScholarship = getDoubleInput("Введите новый размер стипендии студента: ");
            Student studentToUpdate = students.get(studentIndex);
            studentsByScholarship.remove(studentToUpdate);
            studentToUpdate.setScholarship(newScholarship);
            studentsByScholarship.add(studentToUpdate);

            System.out.println("Стипендия студента " + studentToUpdate.getFirstName() + " " + studentToUpdate.getLastName() + " успешно изменена.");
        } else {
            System.out.println("Неверный номер студента.");
        }
    }
    private static void updateAttendance() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст. Нечего отмечать.");
            return;
        }

        System.out.println("Список студентов:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println((i + 1) + ". " + students.get(i).getLastName() + " " + students.get(i).getFirstName());
        }

        int studentIndex = getIntegerInput("Введите номер студента для отметки посещения: ") - 1;

        if (studentIndex >= 0 && studentIndex < students.size()) {
           String attendance = getStringInput("Введите отметку о посещении (был/не был): ");
            Student studentToUpdate = students.get(studentIndex);
            studentToUpdate.setAttendance(attendance);
            System.out.println("Отметка о посещении студента " + studentToUpdate.getFirstName() + " " + studentToUpdate.getLastName() + " успешно обновлена.");
        } else {
            System.out.println("Неверный номер студента.");
        }
    }
    private static void showSortedList() {
        if (students.isEmpty()) {
            System.out.println("Список студентов пуст.");
            return;
        }

        System.out.println("Выберите вариант сортировки:");
        System.out.println("1. По возрасту");
        System.out.println("2. По среднему баллу");
        System.out.println("3. По размеру стипендии");

        int sortChoice = getIntegerInput("Выберите пункт меню: ");

        switch (sortChoice) {
            case 1:
                System.out.println("Список студентов, отсортированный по возрасту:");
                studentsByAge.forEach(System.out::println);
                break;
            case 2:
                System.out.println("Список студентов, отсортированный по среднему баллу:");
                studentsByAverageGrade.forEach(System.out::println);
                break;
            case 3:
                System.out.println("Список студентов, отсортированный по размеру стипендии:");
                studentsByScholarship.forEach(System.out::println);
                break;
            default:
                System.out.println("Неверный вариант сортировки.");
        }
    }
}