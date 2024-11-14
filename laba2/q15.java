import java.util.Scanner;

public class q15 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите стоимость товара (рубли): ");
        int a = scanner.nextInt();
        System.out.print("Введите стоимость товара (копейки): ");
        int b = scanner.nextInt();

        System.out.print("Введите сумму, которой заплатили (рубли): ");
        int c = scanner.nextInt();
        System.out.print("Введите сумму, которой заплатили (копейки): ");
        int d = scanner.nextInt();

        int totalPaid = c * 100 + d; 
        int totalCost = a * 100 + b; 

        if (totalPaid < totalCost) {
            System.out.println("Недостаточно денег для покупки.");
        } else {
            int changeInKopecks = totalPaid - totalCost;
            int changeRubles = changeInKopecks / 100;
            int changeKopecks = changeInKopecks % 100;
            System.out.println(changeRubles + " " + changeKopecks);
        }
        scanner.close();
    }
}
