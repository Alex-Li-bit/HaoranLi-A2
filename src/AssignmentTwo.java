public class AssignmentTwo {

    public static void main(String[] args) {
        // ===== Step 1: Create Employee (Operator) =====
        Employee operator = new Employee(
                "Alice",       // name
                30,            // age
                "123456789",   // phone
                "Operator",    // position
                5000           // salary
        );

        Visitor visitor1 = new Visitor("Bob", 20, "987654321", "VIP", 160);
        Visitor visitor2 = new Visitor("Charlie", 25, "555666777", "Regular", 170);
        Visitor visitor3 = new Visitor("Diana", 18, "111222333", "VIP", 155);
        Visitor visitor4 = new Visitor("Ethan", 22, "444555666", "Regular", 165);
        Visitor visitor5 = new Visitor("Fiona", 19, "777888999", "VIP", 158);

        Ride rollerCoaster = new Ride("ThunderRide", operator, 5);

        System.out.println("=== Adding visitors to queue ===");
        rollerCoaster.addVisitorToQueue(visitor1);
        rollerCoaster.addVisitorToQueue(visitor2);
        rollerCoaster.addVisitorToQueue(visitor3);
        rollerCoaster.addVisitorToQueue(visitor4);
        rollerCoaster.addVisitorToQueue(visitor5);
        rollerCoaster.printQueue();

        System.out.println("\n=== Removing one visitor from queue ===");
        rollerCoaster.removeVisitorFromQueue();
        rollerCoaster.printQueue();

        System.out.println("\n=== Adding visitors to ride history ===");
        rollerCoaster.addVisitorToHistory(visitor1);
        rollerCoaster.addVisitorToHistory(visitor2);
        rollerCoaster.addVisitorToHistory(visitor3);
        rollerCoaster.addVisitorToHistory(visitor4);
        rollerCoaster.addVisitorToHistory(visitor5);

        System.out.println("\n=== Check if a visitor is in ride history ===");
        System.out.println(visitor3.getName() + " is in ride history? " +
                rollerCoaster.checkVisitorFromHistory(visitor3));

        System.out.println("\n=== Total number of visitors in history ===");
        System.out.println("Total visitors: " + rollerCoaster.numberOfVisitors());

        System.out.println("\n=== Print ride history ===");
        rollerCoaster.printRideHistory();

        System.out.println("\n=== Test runOneCycle() method ===");
        rollerCoaster.runOneCycle();
    }

}