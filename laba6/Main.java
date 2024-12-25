public class Main {
    public static void main(String[] args) {
        Store.Product[] products = {
            new Store.Product("Яблоки", 1.2, 60),
            new Store.Product("Пельмени", 0.8, 160),
            new Store.Product("Арбузы", 2.5, 600),
            new Store.Product("Лимонад", 0.5, 90),
            new Store.Product("Барбариски", 1, 250)
        };

        Store store = new Store(10, products, 6);
        System.out.println(store.toString());

        Supermarket supermarket = new Supermarket(20, products, 10, 50, new String[]{"Фрукты", "Сладости", "Напитки", "Овощи"});
        System.out.println(supermarket.toString());
    }
}
