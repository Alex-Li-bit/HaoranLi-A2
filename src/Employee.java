public class Employee extends Person {
    private String position;
    private double salary;

    public Employee() {
        super(); // 调用 Person 的默认构造器
        this.position = "";
        this.salary = 0.0;
    }

    public Employee(String name, int age, String phoneNumber, String position, double salary) {
        super(name, age, phoneNumber); // 初始化父类字段
        this.position = position;
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee[" + super.toString() + ", position=" + position + ", salary=" + salary + "]";
    }
}