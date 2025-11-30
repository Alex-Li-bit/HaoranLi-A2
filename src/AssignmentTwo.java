public class AssignmentTwo {

    public static void main(String[] args) {
        AssignmentTwo at = new AssignmentTwo();

        Employee e = new Employee("Alice Operator", 30, "0415123456", "Ride Operator", 60000.0);
        Visitor v = new Visitor("Bob Visitor", 25, "0416987654", "Adult", 1.75);
        Ride r = new Ride("Thunder Coaster", 120, e);

        System.out.println(e);
        System.out.println(v);
        System.out.println(r);

    }

    public void partThree() {}
    public void partFourA() {}
    public void partFourB() {}
    public void partFive() {}
    public void partSix() {}
    public void partSeven() {}
}