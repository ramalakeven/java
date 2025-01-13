public class OfficeWorker extends Employee implements Worker {
    private String officeType;
    private boolean hasMeetingToday;

    // Конструктор
    public OfficeWorker(String name, String surname, String gender, boolean active, String position, double payment, int experience, String department, String officeType, boolean hasMeetingToday) {
        super(name, surname, gender, active, position, payment, experience, department);
        this.officeType = officeType;
        this.hasMeetingToday = hasMeetingToday;
    }

    @Override
    public void work() {
        System.out.println("Office worker is working on the computer.");
    }

    public void attendMeeting() {
        if (hasMeetingToday) {
            System.out.println("Attending the meeting.");
        } else {
            System.out.println("No meetings today.");
        }
    }

    // Геттеры и сеттеры
    public String getOfficeType() {
        return officeType;
    }

    public void setOfficeType(String officeType) {
        this.officeType = officeType;
    }

    public boolean isHasMeetingToday() {
        return hasMeetingToday;
    }

    public void setHasMeetingToday(boolean hasMeetingToday) {
        this.hasMeetingToday = hasMeetingToday;
    }
}
