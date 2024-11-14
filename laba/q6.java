import java.util.Scanner;

public class q6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println("ДА");
        } else {
            System.out.println("НЕТ");
        }
    }
}
