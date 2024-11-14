import java.util.Scanner;

public class q9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите натуральное число: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Факториал не определен для отрицательных чисел.");
        } else if (n == 0) {
            System.out.println("Факториал 0 равен 1.");
        } else {
            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            System.out.println("Факториал " + n + " равен " + factorial);
        }
    }
}
