import java.util.Scanner;

public class q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество долларов: ");
        double dollars = scanner.nextDouble();

 
        double poundsPerDollar = 1 / 1.487;
        double marksPerDollar = 1 / 0.584;
        double yenPerDollar = 1 / 0.00955;

        double pounds = dollars * poundsPerDollar;
        double marks = dollars * marksPerDollar;
        double yen = dollars * yenPerDollar;

        System.out.println("Вы получите:");
        System.out.printf("%.3f фунтов\n", pounds);
        System.out.printf("%.3f немецких марок\n", marks);
        System.out.printf("%.3f йен\n", yen);
    }
}