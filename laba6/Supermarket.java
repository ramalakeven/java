public class Supermarket extends Store {
    private double area;
    private String[] categories;

    // Конструктор базовый
    public Supermarket() {
        super();
        this.area = 0.0;
        this.categories = new String[0];
    }

    // Конструктор с параметрами
    public Supermarket(int numberOfRegisters, Product[] products, int numberOfSellers, double area, String[] categories) {
        super(numberOfRegisters, products, numberOfSellers);
        this.area = area;
        this.categories = categories;
    }

    // Геттеры и сеттеры
    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public String[] getCategories() {
        return categories;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }

    // Считаем эффективность
    @Override
    public double calculateStoreEfficiency() {
        double registerEfficiency = calculateRegisterEfficiency();
        return categories.length > 0 && registerEfficiency > 0 ? Math.min(( categories.length / area ) * registerEfficiency, 1.0) : 0.0;
    }

    // Возвращаем строкой
    @Override
    public String toString() {
        return "Эффективность супермаркета: " + calculateStoreEfficiency();
    }
}