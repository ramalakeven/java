import java.util.Scanner;

public class q11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("1:");
        int a = scanner.nextInt();
        System.out.print("2:");
        int b = scanner.nextInt();
        if (b>=a){
            for (int i = a; i <= b; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
    else {
        for (int i = b; i <= a; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
        }

        
}