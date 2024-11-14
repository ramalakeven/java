import java.util.Scanner;

public class q4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите начальный вклад: ");
        double principal = scanner.nextDouble();

        System.out.print("Введите число лет: ");
        int years = scanner.nextInt();

        System.out.print("Введите процентную ставку: ");
        double interestRate = scanner.nextDouble();

        double amount = principal;

        for (int i = 1; i <= years; i++) {
            amount += amount * (interestRate / 100);
        }

        System.out.printf("Через %d лет вы получите %.2f долларов.\n", years, amount);
    }
}
