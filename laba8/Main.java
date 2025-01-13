public class Main {
    public static void main(String[] args) {
        KitchenWorker kitchenWorker = new KitchenWorker("John", "Doe", "Male", true, "Cook", 2000.0, 5, "Kitchen", "Head Chef", "Italian Cuisine");
        OfficeWorker officeWorker = new OfficeWorker("Jane", "Smith", "Female", true, "Manager", 3000.0, 7, "Office", "Open Space", true);
        GuardWorker guardWorker = new GuardWorker("Alex", "Brown", "Male", true, "Security Guard", 1500.0, 10, "Security", "Night", true);

        kitchenWorker.work();
        officeWorker.work();
        guardWorker.work();

        officeWorker.attendMeeting();
        guardWorker.checkSecurity();
    }
}
