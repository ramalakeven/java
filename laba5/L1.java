package l5;
import java.util.Scanner;

import static l5.Point3d.comparisonxyz;

public class L1 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Координаты первой точки"); 
        Point3d p1 = createPoint(scanner);

        System.out.println("Координаты второй точки");
        Point3d p2 = createPoint(scanner);

        System.out.println("Координаты третьей точки");
        Point3d p3 = createPoint(scanner);

        if (comparisonxyz(p1, p2) || comparisonxyz(p2, p3) || comparisonxyz(p3, p1)) {
            System.out.println("Ошибка: Некоторые точки совпадают, невозможно вычислить площадь");
        } else {
            System.out.println("Площадь треугольника: ");
            System.out.printf("%.2f", computeArea(p1, p2, p3));
        }
    }

    public static Point3d createPoint(Scanner scanner) { 
        System.out.println("x: ");
        double x = scanner.nextDouble();

        System.out.println("y: ");
        double y = scanner.nextDouble();

        System.out.println("z: ");
        double z = scanner.nextDouble();

        return new Point3d(x, y, z);
    }

    public static double computeArea(Point3d p1, Point3d p2, Point3d p3) {

        double a = p1.distanceTo(p2);  // Сторона a
        double b = p2.distanceTo(p3);  // Сторона b
        double c = p3.distanceTo(p1);  // Сторона c

        double value=Math.sqrt(((a + b + c) / 2) * (((a + b + c) / 2) - a) * (((a + b + c) / 2) - b) * (((a + b + c) / 2) - c));  // Площадь

        return value;
    }


}
