package store;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        // генерация случайных продуктов
        List<Product> products = generateRandomProducts(25);
        System.out.println("Генерация случайных продуктов:");
        products.forEach(System.out::println);
        System.out.println();

        // создание корзины и добавление продуктов (с проверкой дубликатов поимени)
        List<Product> cart = new ArrayList<>();
        addProductsToCart(cart, products.subList(0, 10)); // 10 продуктов
        System.out.println("Продукты в корзине");
        cart.forEach(System.out::println);
        System.out.println();

        // удаление продуктов с весом > 5 кг или стоимостью > 10000
        removeExpensiveOrHeavyProducts(cart);
        System.out.println("Продукты в корзине после удаления дорогих и тяжелых:");
        cart.forEach(System.out::println);
        System.out.println();

        // перемещение любимого продукта в начало списка
        String favoriteProductName = ProductName.Бананы.toString(); // выберем бананы как любимый продукт
        moveFavoriteProductToFirst(cart, favoriteProductName);
        System.out.println("Продукты с любимым типом в начале");
        cart.forEach(System.out::println);
        System.out.println();

        // вывод продуктов стоимостью < 10 и весом > 2
        System.out.println("Продукты со стоимостью < 10 и весом > 2:");
        filterAndPrintProducts(products);
    }

    private static List<Product> generateRandomProducts(int count) {
        List<Product> products = new ArrayList<>();
        Random random = new Random();
        ProductName[] names = ProductName.values();

        for (int i = 0; i < count; i++) {
            String name = names[random.nextInt(names.length)].toString();
            double price;
            double weight;
                price = random.nextDouble() * 15 + 1;
                weight = random.nextDouble() *7 + 0.5;
            products.add(new Product(name, price, weight));
        }
        return products;
    }
    private static void addProductsToCart(List<Product> cart, List<Product> productsToAdd) {
        for (Product product : productsToAdd) {
            if (!cart.contains(product)) {
                cart.add(product);
            }
        }
    }

    private static void removeExpensiveOrHeavyProducts(List<Product> cart) {
        cart.removeIf(product -> product.getWeight() > 5 || product.getPrice() > 10000);
    }

    private static void moveFavoriteProductToFirst(List<Product> cart, String favoriteProductName) {
        Product favoriteProduct = null;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getName().equals(favoriteProductName)) {
                favoriteProduct = cart.remove(i);
                break;
            }
        }
        if (favoriteProduct != null) {
            cart.add(0, favoriteProduct); // Добавить в начало
        }
    }

  private static void filterAndPrintProducts(List<Product> products) {
        products.stream()
          .filter(product -> product.getPrice() < 10 && product.getWeight() > 2)
          .forEach(System.out::println);
      }
}