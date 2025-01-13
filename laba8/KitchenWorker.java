public class KitchenWorker extends Employee implements Worker {
    private String kitchenRole;
    private String specialty;

    // Конструктор
    public KitchenWorker(String name, String surname, String gender, boolean active, String position, double payment, int experience, String department, String kitchenRole, String specialty) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.kitchenRole = kitchenRole;
        this.specialty = specialty;
    }

    @Override
    public void work() {
        System.out.println("Kitchen worker is cooking.");
    }

    public void cleanKitchen() {
        System.out.println("Cleaning the kitchen.");
    }

    // Геттеры и сеттеры
    public String getKitchenRole() {
        return kitchenRole;
    }

    public void setKitchenRole(String kitchenRole) {
        this.kitchenRole = kitchenRole;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
