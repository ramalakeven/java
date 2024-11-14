import java.util.Scanner;

public class q12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1: ");
        int a = scanner.nextInt();
        System.out.print("2: ");
        int b = scanner.nextInt();

        if ( a > b ) {
            System.out.println("Наибольшее: "+ a );
        }
        else if ( a < b ) {
            System.out.println("Наибольшее: "+ b );
        }
        if ( a == b) {
            System.out.println("Числа равны");
        }
}
}