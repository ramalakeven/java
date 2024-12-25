package l5;

import java.math.RoundingMode;

public class Point3d {  // Класс для трехмерной точки

    private double xC;  // x
    private double yC;  // y
    private double zC;  // z

    public Point3d ( double x, double y, double z){  // Конструктор инициализации
        xC = x;
        yC = y;
        zC = z;
    }
    public  Point3d () {  // Конструктор по умолчанию
        this(0, 0, 0);
    }
    public double getX () {  // Возвращение координаты x 
        return xC;
    }
    public double getY () {  // Возвращение координаты y
        return yC;
    }
    public double getZ () {  // Возвращение координаты z
        return zC;
    }

    public void setX (double val) {  // Установка значения x
        xC = val;
    }
    public void setY (double val) {  // Установка значения y
        yC = val;
    }
    public void setZ (double val) {  // Установка значения z
        zC = val;
    }

    static boolean comparisonxyz(Point3d myP1, Point3d myP2) {  // Сравнение трех координат значений двух объектов
        return myP1.getX() == myP2.getX() && myP1.getY() == myP2.getY() && myP1.getZ() == myP2.getZ() ? true: false;
    }

    public double distanceTo(Point3d other) {  // Расстояние между точками
        double dx = this.xC - other.xC;
        double dy = this.yC - other.yC;
        double dz = this.zC - other.zC;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }
}
