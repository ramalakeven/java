public class Store {
    private int numberOfRegisters;
    private Product[] products;
    private int numberOfSellers;

    // дефолтный конструктор
    public Store() {
        this.numberOfRegisters = 0;
        this.products = new Product[0];
        this.numberOfSellers = 0;
    }

    // КОнструктор с параметрами
    public Store(int numberOfRegisters, Product[] products, int numberOfSellers) {
        this.numberOfRegisters = numberOfRegisters;
        this.products = products;
        this.numberOfSellers = numberOfSellers;
    }

// Геттеры и сеттеры
    public int getNumberOfRegisters() {
        return numberOfRegisters;
    }

    public void setNumberOfRegisters(int numberOfRegisters) {
        this.numberOfRegisters = numberOfRegisters;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public int getNumberOfSellers() {
        return numberOfSellers;
    }

    public void setNumberOfSellers(int numberOfSellers) {
        this.numberOfSellers = numberOfSellers;
    }

    // Класс продуктов
    public static class Product {
        private String name;
        private double weight;
        private double price;

        // Дефолтный конструктор
        public Product() {
            this.name = "";
            this.weight = 0.0;
            this.price = 0.0;
        }

        // С параметрами
        public Product(String name, double weight, double price) {
            this.name = name;
            this.weight = weight;
            this.price = price;
        }

        // геттеры и сеттеры
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

    // Считаем вес
    public double calculateAverageProductWeight() {
        double totalWeight = 0.0;
        for (Product product : products) {
            totalWeight += product.getWeight();
        }
        return products.length > 0 ? totalWeight / products.length : 0.0;
    }

    // количество продавцов на количество касс
    public double calculateRegisterEfficiency() {
        return numberOfRegisters > 0 ? (double) numberOfSellers / numberOfRegisters : 0.0;
    }

    // Эффективность магазина
    public double calculateStoreEfficiency() {
        double avgWeight = calculateAverageProductWeight();
        double registerEfficiency = calculateRegisterEfficiency();
        return registerEfficiency > 0 ? Math.min(avgWeight / (registerEfficiency + 1), 1.0) : 0.0;
    }

    // Возвращаем данные строкой
    @Override
    public String toString() {
        return "Эффективность магазина: " + calculateStoreEfficiency();
    }
}