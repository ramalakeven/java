package studentslist;

import java.io.InputStreamReader;
import java.util.*;


// Исключение для проверки возраста
class NotCorrectAgeException extends Exception {
    public NotCorrectAgeException(String message) {
        super(message);
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in, java.nio.charset.StandardCharsets.UTF_8));
        Group group = new Group();

        while (true) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить студента");
            System.out.println("2. Удалить студента");
            System.out.println("3. Вывести список студентов");
            System.out.println("4. Поиск студента по индексу");
            System.out.println("0. Выход");

            try {
                int choice = Integer.parseInt(scanner.nextLine()); // Обработка ввода числа

                switch (choice) {
                    case 1:
                        group.addStudent();
                        break;
                    case 2:
                        System.out.print("Введите индекс студента для удаления: ");
                        int removeIndex = Integer.parseInt(scanner.nextLine()) - 1; // Преобразование 1-based в 0-based
                        group.removeStudent(removeIndex);
                        break;
                    case 3:
                        group.printStudents();
                        break;
                    case 4:
                        System.out.print("Введите индекс студента для поиска: ");
                        int searchIndex = Integer.parseInt(scanner.nextLine()) - 1; // Преобразование 1-based в 0-based
                        Student student = group.getStudentByIndex(searchIndex);
                        if (student != null) {
                            System.out.println("Найден студент: " + student.getFirstName() + " " + student.getLastName());
                        }
                        break;
                    case 0:
                        System.out.println("Выход из программы.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Неверный выбор. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите числовое значение.");
            }
        }
    }
}
