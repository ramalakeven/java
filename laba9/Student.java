package studentslist;
import java.util.*;


public class Student {
    private int age;
    private String gender;
    private String firstName;
    private String lastName;
    private String patronymic;
    private int course;
    private double averageGrade;

    public Student(int age, String gender, String firstName, String lastName, String patronymic, int course, double averageGrade) throws NotCorrectAgeException {
        setAge(age);
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
        this.course = course;
        this.averageGrade = averageGrade;
    }

    public Student() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws NotCorrectAgeException {
        if (age < 16 || age > 60) {
            throw new NotCorrectAgeException("Возраст студента должен быть от 16 до 60 лет.");
        }
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }
}
