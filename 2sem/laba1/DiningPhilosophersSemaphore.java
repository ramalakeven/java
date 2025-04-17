import java.util.concurrent.Semaphore;

public class DiningPhilosophersSemaphore {

    static class Philosopher extends Thread {
        private final int id;
        private final Semaphore leftFork;
        private final Semaphore rightFork;
        private final Semaphore butler; // этот семафор ограничивает кол-во философов, пытающихся поесть, чтобы не было ситуации, когда все философы схавтили вилку с одной стороны и потеряли возможность есть в вечном ожидании второй
        private final int maxIterations; // Ограничение по итерациям было добавлено чтобы программа завершалась по истечении какого-то времени

        public Philosopher(int id, Semaphore leftFork, Semaphore rightFork, Semaphore butler, int maxIterations) {
            this.id = id;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
            this.butler = butler;
            this.maxIterations = maxIterations;
        }

        private void think() throws InterruptedException {
            System.out.println("Философ " + id + " размышляет...");
            Thread.sleep((long) (Math.random() * 1000));
        }

        private void eat() throws InterruptedException {
            System.out.println("Философ " + id + " ест!");
            Thread.sleep((long) (Math.random() * 1000));
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < maxIterations; i++) {
                    think();

                    // Запрашиваем разрешение у дворецкого
                    butler.acquire();

                    // Захватываем обе вилки
                    leftFork.acquire();
                    rightFork.acquire();

                    eat();

                    // Освобождаем вилки
                    leftFork.release();
                    rightFork.release();

                    // Сообщаем что философ поел
                    butler.release();
                }

                System.out.println("Философ " + id + " закончил есть.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        int numPhilosophers = 5;
        int iterations = 5;

        Philosopher[] philosophers = new Philosopher[numPhilosophers];
        Semaphore[] forks = new Semaphore[numPhilosophers];

        // Создаем вилки (каждая вилка — семафор с 1 разрешением)
        for (int i = 0; i < numPhilosophers; i++) {
            forks[i] = new Semaphore(1);
        }

        // Дворецкий — ограничивает количество философов, которые могут одновременно есть
        Semaphore butler = new Semaphore(numPhilosophers - 1);

        // Создаем философов и запускаем потоки
        for (int i = 0; i < numPhilosophers; i++) {
            Semaphore leftFork = forks[i];
            Semaphore rightFork = forks[(i + 1) % numPhilosophers];

            philosophers[i] = new Philosopher(i, leftFork, rightFork, butler, iterations);
            philosophers[i].start();
        }

        // Ждем завершения всех философов
        for (Philosopher philosopher : philosophers) {
            try {
                philosopher.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("Все философы закончили есть.");
    }
}
