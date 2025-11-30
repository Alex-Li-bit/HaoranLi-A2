public abstract class Person {
    private String name;
    private int age;
    private String phoneNumber;

    public Person() {
        this.name = "";
        this.age = 0;
        this.phoneNumber = "";
    }

    public Person(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Person[name=" + name + ", age=" + age + ", phone=" + phoneNumber + "]";
    }
}