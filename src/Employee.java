public class Employee extends Person {

    private String position;
    private double salary;

    public Employee() {}

    public Employee(String name, int age, String phone, String position, double salary) {
        super(name, age, phone);
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
}